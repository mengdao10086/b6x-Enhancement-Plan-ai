#!/system/bin/sh
# 飞智 B6X 增强计划 — 温控守护进程开机拉起（service.d 脚本）
#
# 本文件由 APK 逐字节复制到 service.d（内容哈希即部署完成判定 I4）。
# 为什么必须 service.d 拉起（三条硬阻断）、幂等由谁兜底、"不再先杀"、以及自动更新概述，
# 见 逻辑说明.md「部署与 Root 调用」与「看门狗反向保活」。开关值来自 profile.conf（UI_AUTO_UPDATE，缺省=开）。

BIN=/data/local/tmp/tempctrl
SVC_LOG=/data/local/tmp/tempctrl_service.log
WAIT_LOOPS=30           # 等旧进程退出：30 × 1s（C 端最长 sleep 5s 一轮）
RESTART_INTERVAL=300    # 看门狗周期（秒）

# 宿主 APK 包名与数据目录。判据用【父目录】而非 files/：app「清除数据」只清 files/ 内容，
# 父目录由系统保留 → 可抗"清除数据"误判（代价见 app/逻辑说明.md §2.4）。
HOST_PKG=com.example.waspwingtempctrl
HOST_DIR=/data/data/$HOST_PKG
HOST_FILES=$HOST_DIR/files
PM_BIN=/system/bin/pm
SCRIPT_NAME=b6x-tempctrl.sh

# ==================== 自动更新（开机自校验 / 自重部署）====================
# 判据顺序固定【先比时间戳、有变化再验哈希】；三份中间状态放 app 私有目录（为什么不落
# /data/local/tmp、各文件语义见 README「部署自校验文件协议」，清理清单三份同步见 app/逻辑说明.md §2.5）。
AU_KEY=UI_AUTO_UPDATE
AU_CONF=$HOST_FILES/profile.conf
AU_STAMP=$HOST_FILES/tempctrl_deploy_stamp
AU_MANIFEST=$HOST_FILES/tempctrl_sync_manifest
AU_TRIES=0              # 本次开机已尝试次数（pm / 解压工具可能晚一步就绪，失败不每 5 分钟刷一次）
AU_MAX_TRIES=3
# md5sum 对空输入的结果：用来判「解压没取到东西」。不能只看命令退出码——
# 三个候选工具里任何一个不存在/无该 applet 时，管道仍会跑完并给空输入算出这个值。
MD5_EMPTY=d41d8cd98f00b204e9800998ecf8427e

# 本脚本自身路径，用于看门狗自尽自检（见第 3 节）。
# 取不到含 '/' 的 $0 时置空 → 只保留二进制自检，避免误判成"脚本已被删"而自杀。
SELF=$0
case "$SELF" in
    */*) : ;;
    *) SELF="" ;;
esac

log() {
    echo "$(date '+%Y-%m-%d %H:%M:%S')：$1" >> "$SVC_LOG"
}

# 屏幕状态：Awake 才算亮屏（FBE 解锁完成的标志）
# 与 C 端 is_screen_awake() 同口径，但这里是第三套写法（C 端已改为 fork 一个 dumpsys、不再走 sh|awk 管线）：
# 只按 "mWakefulness=" 取值、不额外排除 Override 行 —— `mWakefulness=` 这个子串不会出现在
# `mWakefulnessOverride=` 里，故与 C 端（额外排除 Override）等价。改一侧时想一遍另一侧。
screen_on() {
    state=$(dumpsys power 2>/dev/null | grep 'mWakefulness=' | head -1 | cut -d= -f2)
    case "$state" in
        Awake) return 0 ;;
        Asleep|Dozing) return 1 ;;
        *) return 0 ;;   # 探测失败按"可拉起"兜底，避免读不到就死锁
    esac
}

# daemon 实例的 pid 列表：/proc/<pid>/exe 末端锚定 $BIN（判据唯一处；两侧对 "(deleted)" 同口径、
# 不用 pkill -f 的理由见 逻辑说明.md「进程检测机制」）。
bin_pids() {
    ls -l /proc/[0-9]*/exe 2>/dev/null \
        | grep -E -- "-> $BIN( [(]deleted[)])?$" \
        | sed -n "s#.* /proc/\([0-9]*\)/exe ->.*#\1#p"
}

# 守护进程是否在跑（判据必须紧；假阳/假阴代价见 逻辑说明.md「进程检测机制」）。
running() {
    [ -n "$(bin_pids)" ]
}

# 停旧实例：kill 后必须轮询等它真正退出（只 sleep 1 会因单实例锁以退出码 2 退出）。
stop_old() {
    for p in $(bin_pids); do kill "$p" 2>/dev/null; done
    i=0
    while [ $i -lt $WAIT_LOOPS ]; do
        running || return 0
        for p in $(bin_pids); do kill "$p" 2>/dev/null; done
        sleep 1
        i=$((i + 1))
    done
    log "旧实例 $WAIT_LOOPS 秒未退出，升级 SIGKILL"
    for p in $(bin_pids); do kill -9 "$p" 2>/dev/null; done
    i=0
    while [ $i -lt 5 ]; do
        running || return 0
        sleep 1
        i=$((i + 1))
    done
    log "旧实例仍存活，跳过本次启动（避免与在跑实例抢锁）"
    return 1
}

start() {
    if ! [ -x "$BIN" ]; then
        log "二进制缺失或不可执行：$BIN（需在 app 里重新部署）"
        return 1
    fi
    # 先查后拉：已有实例就不重复拉起（也不动它）。这条日志是真机核对的判据之一——
    # 看到它就说明"拉起"这条路上没有重启守护进程。
    if running; then
        log "守护进程已在运行，跳过拉起（存在即不重复拉起）"
        return 0
    fi
    # 不传 --config：C 端按私有目录自行定位 profile.conf（--config 仅用于覆盖该默认）
    nohup "$BIN" >> "$SVC_LOG" 2>&1 < /dev/null &
    sleep 2
    if running; then
        # PID 取自与 running() 同一个判据（bin_pids），不再用 pgrep -f "$BIN"：
        # 那个子串匹配可能先命中"命令行里出现过该路径"的别的进程，导致 renice 打到别人身上、
        # 日志里的 pid 也不是守护进程的。
        pid=$(bin_pids | head -1)
        renice -n -20 -p "$pid" > /dev/null 2>&1
        log "已启动 tempctrl（pid=$pid）"
        return 0
    fi
    log "tempctrl 启动后未存活（退出码 2 = 已有实例在跑）"
    return 1
}

# ==================== 自动更新：小工具 ====================

# 读 KEY=VALUE 文件里的一个键（取第一个 '=' 之后、到行内注释或空白为止）
kv() {
    [ -f "$1" ] || return 1
    grep -m1 "^$2=" "$1" 2>/dev/null | cut -d= -f2- | sed 's/[[:space:]#].*//'
}

# 「自动更新」开关：读不到 / 空 / 非 0 一律当开（与 UI_AUTO_UPDATE 的默认值一致）
auto_update_on() {
    v=$(kv "$AU_CONF" "$AU_KEY")
    case "$v" in
        0) return 1 ;;
        *) return 0 ;;
    esac
}

# API 路径。开机早期 pm 可能还没就绪，故重试 3 次、每次隔 5s。
apk_path() {
    i=0
    while [ $i -lt 3 ]; do
        p=$("$PM_BIN" path "$HOST_PKG" 2>/dev/null | head -1)
        case "$p" in
            package:*) p=${p#package:} ;;
            *) p="" ;;
        esac
        if [ -n "$p" ] && [ -f "$p" ]; then
            echo "$p"
            return 0
        fi
        sleep 5
        i=$((i + 1))
    done
    return 1
}

# APK 文件自身 mtime（秒）。toybox/busybox 的 stat 都支持 -c；兜底用 date -r。
apk_mtime() {
    stat -c %Y "$APK" 2>/dev/null || date -r "$APK" +%s 2>/dev/null
}

# 依次尝试三个解压命令把 APK 内某个 asset 解到 stdout（为何三选一：设备端到底有哪个未验证，
# 逐个真跑、按"真取到内容"判定，不依赖 --help 探测）。
asset_pipe() {
    for tool in /data/adb/magisk/busybox busybox toybox; do
        command -v "$tool" > /dev/null 2>&1 || continue
        "$tool" unzip -p "$APK" "assets/$1" 2>/dev/null && return 0
    done
    if command -v unzip > /dev/null 2>&1; then
        unzip -p "$APK" "assets/$1" 2>/dev/null && return 0
    fi
    return 1
}

# APK 内某个 asset 的 md5；取不到打空串。
asset_md5() {
    m=$(asset_pipe "$1" | md5sum 2>/dev/null | cut -d' ' -f1)
    case "$m" in
        ""|"$MD5_EMPTY") echo "" ; return 1 ;;
        *) echo "$m" ; return 0 ;;
    esac
}

# 把 APK 内某个 asset 解到指定文件；内容为空即算失败并清掉半个文件。
asset_to_file() {
    asset_pipe "$1" > "$2" 2>/dev/null
    if [ -s "$2" ]; then
        return 0
    fi
    rm -f "$2"
    return 1
}

# 本脚本自己的路径（自更新要替换的就是它）。取不到就返回非 0 —— 此时只更新二进制、不动脚本。
script_path() {
    if [ -n "$SELF" ]; then
        echo "$SELF"
        return 0
    fi
    for d in /data/adb/ksu/service.d /data/adb/service.d; do
        if [ -f "$d/$SCRIPT_NAME" ]; then
            echo "$d/$SCRIPT_NAME"
            return 0
        fi
    done
    return 1
}

# 记下"已按这个 APK 时间戳核对通过"。只在私有目录已存在时写：
# 该目录若由 root 抢先建出来，标签未必是 app 能用的，故宁可少写一次也不替 app 建目录。
write_stamp() {
    [ -d "$HOST_FILES" ] || return 0
    echo "$1 $2" > "$AU_STAMP" 2>/dev/null
}

# ==================== 自动更新：主流程 ====================

# 解析"设备上应该是什么"：优先自己从 APK 解包（不依赖 app 是否跑过）；解不了再退到 app 写的清单。
# 清单只在它记的 APK 时间戳与当前 APK 一致时才可用——否则它描述的是旧 APK，按它装就是装旧内容。
resolve_expected() {
    E_SRC=""
    E_BIN_MD5=""
    E_SCRIPT_MD5=""
    E_BIN_FILE=""
    E_SCRIPT_FILE=""
    if command -v md5sum > /dev/null 2>&1; then
        b=$(asset_md5 tempctrl-arm64)
        s=$(asset_md5 "deploy/$SCRIPT_NAME")
        if [ -n "$b" ] && [ -n "$s" ]; then
            E_SRC=apk
            E_BIN_MD5=$b
            E_SCRIPT_MD5=$s
            return 0
        fi
    fi
    if [ "$(kv "$AU_MANIFEST" APK_MTIME)" = "$M_APK" ]; then
        b=$(kv "$AU_MANIFEST" BIN_MD5)
        s=$(kv "$AU_MANIFEST" SCRIPT_MD5)
        bf=$(kv "$AU_MANIFEST" BIN_SRC)
        sf=$(kv "$AU_MANIFEST" SCRIPT_SRC)
        if [ -n "$b" ] && [ -n "$s" ] && [ -f "$bf" ] && [ -f "$sf" ]; then
            E_SRC=manifest
            E_BIN_MD5=$b
            E_SCRIPT_MD5=$s
            E_BIN_FILE=$bf
            E_SCRIPT_FILE=$sf
            return 0
        fi
    fi
    return 1
}

# 设备侧现状：D_BIN / D_SCRIPT / SP（SP 为空表示取不到本脚本路径，此时只比二进制）
device_md5s() {
    D_BIN=$(md5sum "$BIN" 2>/dev/null | cut -d' ' -f1)
    D_SCRIPT=""
    SP=$(script_path) || SP=""
    if [ -n "$SP" ]; then
        D_SCRIPT=$(md5sum "$SP" 2>/dev/null | cut -d' ' -f1)
    fi
}

# 开机自校验 / 自重部署。返回 0 表示"刚重部署过"（进程已停，由调用方随后拉起）。
# 判据顺序固定：先时间戳（没变就整段短路）→ 有变化再验哈希 → 真不一致才重部署。
auto_update_check() {
    auto_update_on || return 1
    APK=$(apk_path) || { log "自动更新：暂时拿不到 APK 路径（pm 未就绪？），跳过"; return 1; }
    M_APK=$(apk_mtime)
    if [ -z "$M_APK" ]; then
        log "自动更新：拿不到 APK 时间戳，跳过"
        return 1
    fi
    # 从没部署过（二进制不在、也没有核对记录）：不自动装，等用户在 app 里一键部署
    if [ ! -x "$BIN" ] && [ ! -f "$AU_STAMP" ]; then
        log "自动更新：本机从未部署过，跳过（请在 app 内一键部署）"
        return 1
    fi
    # 时间戳没变 → 短路（"先比时间戳"这一步的全部收益都在这）。
    # 前提是二进制还在且可执行：少了这一条，一个被清掉的二进制会让短路一直成立、
    # 永远不走后面的比对（"被删"不是"内容变了"，但存在性这一眼是免费的）。
    if [ -x "$BIN" ] && [ "$(cut -d' ' -f1 "$AU_STAMP" 2>/dev/null)" = "$M_APK" ]; then
        return 1
    fi
    if ! resolve_expected; then
        log "自动更新：无法确定 APK 内应有的内容（解压工具不可用且清单不可用），跳过"
        return 1
    fi
    device_md5s
    if [ "$D_BIN" = "$E_BIN_MD5" ] && { [ -z "$SP" ] || [ "$D_SCRIPT" = "$E_SCRIPT_MD5" ]; }; then
        write_stamp "$M_APK" ok
        log "自动更新：设备上的内容与 APK 内一致，无需重部署"
        return 1
    fi

    # 真不一致 → 重部署。先停旧实例：覆写正在运行的二进制会 ETXTBSY；
    # 脚本自身则"先写 .new 再 mv"（它正被 sh 解释执行，就地截断会踩边走边读）。
    if ! stop_old; then
        log "自动更新：旧实例未退出，本次跳过重部署"
        return 1
    fi
    if [ "$E_SRC" = apk ]; then
        asset_to_file tempctrl-arm64 "$BIN.new" || { log "自动更新：二进制解包失败，跳过"; return 1; }
    else
        cp -f "$E_BIN_FILE" "$BIN.new" || { log "自动更新：二进制副本不可用，跳过"; return 1; }
    fi
    chmod 0755 "$BIN.new" 2>/dev/null
    rm -f "$BIN"
    if ! mv -f "$BIN.new" "$BIN"; then
        log "自动更新：二进制就位失败"
        return 1
    fi
    device_md5s
    if [ "$D_BIN" = "$E_BIN_MD5" ]; then
        log "自动更新：已更新二进制 $BIN（内容与 APK 内一致）"
    else
        log "自动更新：二进制就位后复核不一致（APK=$E_BIN_MD5 设备=$D_BIN）"
        return 1
    fi

    if [ -n "$SP" ]; then
        if [ "$E_SRC" = apk ]; then
            asset_to_file "deploy/$SCRIPT_NAME" "$SP.new" || log "自动更新：脚本解包失败（本次只更新二进制）"
        else
            cp -f "$E_SCRIPT_FILE" "$SP.new" 2>/dev/null || log "自动更新：脚本副本不可用（本次只更新二进制）"
        fi
        if [ -s "$SP.new" ]; then
            chmod 0755 "$SP.new" 2>/dev/null
            if mv -f "$SP.new" "$SP"; then
                log "自动更新：已更新 service.d 脚本 $SP（新脚本下次开机生效）"
            fi
        fi
        rm -f "$SP.new" 2>/dev/null
    else
        log "自动更新：取不到本脚本路径，本次只更新二进制"
    fi

    device_md5s
    if [ "$D_BIN" = "$E_BIN_MD5" ] && { [ -z "$SP" ] || [ "$D_SCRIPT" = "$E_SCRIPT_MD5" ]; }; then
        write_stamp "$M_APK" ok
        log "自动更新：重部署完成（旧实例已停；新实例由随后的启动序列拉起）"
        return 0
    fi
    log "自动更新：重部署后复核未通过（不记时间戳，下次开机重试）"
    return 1
}

# 卸载兜底清理：清单与 C 端 cleanup_artifacts_on_uninstall()、Deployer.uninstallScript() 三份须同步；
# 覆盖 C 端做不到的三类见 app/逻辑说明.md §2.5。私有目录产物交给系统卸载，不显式删。
cleanup_all() {
    stop_old
    rm -f /data/local/tmp/tempctrl \
          /data/local/tmp/tempctrl_b6x.status \
          /data/local/tmp/tempctrl_b7x.status \
          /data/local/tmp/tempctrl_uiprefs \
          /data/local/tmp/tempctrl_service.log \
          /data/local/tmp/tempctrl.lock \
          /data/local/tmp/tempctrl_last_dev \
          /data/adb/service.d/b6x-tempctrl.sh \
          /data/adb/ksu/service.d/b6x-tempctrl.sh \
          /cache/tempctrl.log
    if [ -n "$SELF" ]; then
        rm -f "$SELF"
    fi
}

# 1. 等「亮屏 且 私有目录就绪」（亮屏不等于已解锁；判据取私有目录可列、超时兜底见 逻辑说明.md「配置路径自动检测」）
CE_WAIT_MAX=600         # 等解锁的上限（秒）；每轮 sleep 5，另有探测开销，实际 ≥ 此值
CE_WAIT_TRIES=$((CE_WAIT_MAX / 5))

ce_ready() {
    [ -d "$HOST_FILES" ]
}

i=0
while :; do
    if screen_on && ce_ready; then
        break
    fi
    i=$((i + 1))
    if [ $i -ge $CE_WAIT_TRIES ]; then
        log "等待亮屏/解锁超过 $CE_WAIT_MAX 秒，先拉起（配置由守护进程的周期重试补齐）"
        break
    fi
    sleep 5
done

# 1.5 自动更新：APK 换了就把设备上的二进制与脚本重新装好（开关关掉则整段不做）
#     只落盘、不启动：紧接着的第 2 节会把新二进制起起来（重部署路径内部已停过旧实例，
#     故第 2 节的 start 走到"先查后拉"时看到的是"没有实例"，照旧拉起）。
AU_TRIES=$((AU_TRIES + 1))
auto_update_check

# 2. 拉起守护进程（**不再先杀**——"存在即不重复拉起"的另一半；成环理由与代价见 逻辑说明.md「看门狗反向保活」）
start

# 3. 看门狗：每 5 分钟确认进程存活（C 端自身有看门狗，这里兜住进程级死亡）
while true; do
    sleep $RESTART_INTERVAL
    # --- 宿主 APK 卸载自清理（兜底）---
    # 判据与 C 端 host_app_uninstalled() 同构（父目录 + pm path 二次确认），隔 5s 复核一次；
    # 必须排在最前、排在任何 start() 之前、全程静默——理由见 app/逻辑说明.md §2.4。
    if [ ! -d "$HOST_DIR" ] && ! "$PM_BIN" path "$HOST_PKG" > /dev/null 2>&1; then
        sleep 5
        if [ ! -d "$HOST_DIR" ] && ! "$PM_BIN" path "$HOST_PKG" > /dev/null 2>&1; then
            cleanup_all
            exit 0
        fi
    fi
    # --- 自尽自检（纵深防御）：脚本文件或二进制任一不在 → 立即静默退出（必须静默、排在任何 start() 之前）---
    if [ -n "$SELF" ] && [ ! -f "$SELF" ]; then
        exit 0
    fi
    if ! [ -x "$BIN" ]; then
        # 静默（同上）：此处写盘会把卸载时刚删掉的日志文件重建出来
        exit 0
    fi
    # --- 自动更新（周期性自校验）：须排在上面三处 exit 0 之后 ---
    if [ "$AU_TRIES" -lt "$AU_MAX_TRIES" ]; then
        AU_TRIES=$((AU_TRIES + 1))
        auto_update_check
    fi
    if ! running; then
        screen_on || sleep 15
        start
    fi
done
