#!/system/bin/sh
# 飞智 B6X 增强计划 — 温控守护进程开机拉起（service.d 脚本）
#
# 本文件由 APK 部署时【逐字节】复制到 service.d 目录（不做任何占位符替换），
# 所以它的内容哈希可以直接与 APK 内 assets/deploy/b6x-tempctrl.sh 比对，
# 用于部署完成判定（I4）。
#
# 为什么必须由 service.d 拉起，而不是 APK 自己：
#   1) 全新安装 / 被强停过的 app 收不到 BOOT_COMPLETED（FLAG_EXCLUDE_STOPPED_PACKAGES）
#   2) 从 app 里 su 起的进程仍留在该 app 的 cgroup 内，app 一死就被连带杀
#   3) LSPosed 钩子以 untrusted_app 域与 uid 运行，读不了 thermal sysfs、用不了 am/dumpsys
#
# 幂等由 C 端单实例锁兜底（私有目录 tempctrl.lock，另加一把 /data/local/tmp 的兜底锁）：第二个实例打印 stderr 后
# 以退出码 2 退出，其它启动失败路径返回 0。启动前**不再**先杀旧实例（新规则：先查后拉、
# 存在即不重复拉起，见 running() 与第 2 节）——需要换掉在跑的实例时由调用方负责停稳
# （app 的停止序列，以及本脚本重部署路径里自带的 stop_old）。
#
# 除拉起与看门狗之外，本脚本还负责【自动更新】：开机时比对一次，之后看门狗每轮还会再试，
# 总量由 AU_MAX_TRIES 封顶（不是"每轮都无限试"）；比对
# 设备上的二进制/脚本与 APK 内的是否一致，不一致就重新装一遍。开关与中间状态都放 app 私有目录，
# 详见下面「自动更新」那一节；开关值来自 app 写的 profile.conf（键 UI_AUTO_UPDATE，缺省=开）。

BIN=/data/local/tmp/tempctrl
SVC_LOG=/data/local/tmp/tempctrl_service.log
WAIT_LOOPS=30           # 等旧进程退出：30 × 1s（C 端最长 sleep 5s 一轮）
RESTART_INTERVAL=300    # 看门狗周期（秒）

# 宿主 APK 包名与数据目录。判据用【父目录】而非 files/：app「清除数据」只清 files/ 内容，
# 父目录由系统保留 → 可抗"清除数据"误判（代价记在 lsp模块/daemon/逻辑说明.md 的「参数落点」注记处）。
HOST_PKG=com.example.waspwingtempctrl
HOST_DIR=/data/data/$HOST_PKG
HOST_FILES=$HOST_DIR/files
PM_BIN=/system/bin/pm
SCRIPT_NAME=b6x-tempctrl.sh

# ==================== 自动更新（开机自校验 / 自重部署）====================
# 这套东西是"发现设备上与 APK 内不一致就自动重新部署"，判据顺序固定为【先比时间戳、有变化再验哈希】：
#   时间戳 = APK 自身文件 mtime（秒），记在 AU_STAMP 里；没变就整段短路（一次 stat 的花费）。
#
# 三份中间状态（都放 app 私有目录，不落 /data/local/tmp）：
#   为什么不落 /data/local/tmp：卸载自清的清理清单有三份实现（C 端 cleanup_artifacts_on_uninstall()、
#   本脚本的 cleanup_all()、Deployer.uninstallScript()），新增文件必然要求三份同步，本文件不擅自扩清单。
#   私有目录则随系统卸载连目录一起删，不需要任何清单改动。
#   AU_CONF     = app 写的配置（profile.conf）：读「自动更新」开关（AU_KEY，缺省=开）
#   AU_STAMP    = 上次核对通过时 APK 的 mtime（内容 "<mtime> ok"）；时间戳没变即短路
#   AU_MANIFEST = app 写的期望状态清单：设备端三个解压命令都不可用时，退而按它比对与就位
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

# daemon 实例的 pid 列表：/proc/<pid>/exe 恰好指向 $BIN（末端锚定，故不会命中
# tempctrl_service.log / tempctrl_uiprefs / tempctrl_*.status 那些兄弟文件）。
# 判据只有这一处：running()、stop_old()、start() 都从它取，故"判有没有在跑"与"停哪些 / 给谁
# 改优先级"不可能给出不同结论（与 app 侧 Deployer 的 bin_pids 同为 exe 末端锚定，但对 "(deleted)" 的口径故意不同：app 侧接受、本处不接受）。
# **不用 pkill -f "$BIN"**：那是 cmdline 子串匹配，凡命令行里出现过该路径的临时进程
# （诊断脚本里的 ls -l /data/local/tmp/tempctrl、grep tempctrl 等）都会被误杀 —— 2026-09-28 修。
# 二进制在运行中被替换（rm+mv）时 exe 会显示 "(deleted)"，此处按"不在"处理：拉起会因单实例锁
# 立刻退出，代价只是一条日志。
bin_pids() {
    ls -l /proc/[0-9]*/exe 2>/dev/null \
        | grep -E -- "-> $BIN$" \
        | sed -n "s#.* /proc/\([0-9]*\)/exe ->.*#\1#p"
}

# 守护进程是否在跑。**本判据必须紧**：它现在同时决定"要不要保留在跑的那个实例"与
# "要不要拉起一个"（先查后拉），假阳（把别的进程认成 daemon）会让真正的 daemon 永远起不来；
# 假阴最多多起一个（C 端单实例锁会让它立刻以退出码 2 退出；且第 2 节已不再先杀，故不会误杀）。
running() {
    [ -n "$(bin_pids)" ]
}

# 停旧实例：kill 之后必须轮询等它真正退出。
# 只 sleep 1 就启动，新实例会因单实例锁立刻以 2 退出（旧 service.sh 就踩过这个坑）。
# 目标 pid 每轮重新取一次：等待期内新冒出来的同类进程也一并停掉（保留旧 pkill 的语义）。
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

# 依次尝试三个解压命令把 APK 内某个 asset 解到 stdout。
# 为什么要三选一：设备端到底有哪个未验证（Magisk 自带 busybox 有 unzip 未确证、
# Android toybox 自哪个版本起有 unzip 也未确证），故逐个真跑一次，谁成功算谁。
# 只按"真取到内容"判定成功（见 asset_md5 的 MD5_EMPTY 判据），不依赖 --help 之类的探测。
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

# 卸载兜底清理：清单与 C 端 cleanup_artifacts_on_uninstall() 严格一致，改一处必须同步另一处。
# 覆盖 C 端做不到的三类：①daemon 已死但脚本还在 ②daemon 启动后 30s 延迟窗口内被卸载
# ③C 端被 SELinux 拒删 /data/adb（本脚本自身就跑在该域内，能删自己）。
# 私有目录产物交给系统卸载，不显式删（与 C 端一致，也不显式删 profile.conf）。
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

# 1. 等「亮屏 且 私有目录就绪」（FBE 解锁后私有目录与 sysfs 才可靠可读）
#    为什么要多等这一条：旧写法只等 mWakefulness=Awake，**而亮屏不等于已解锁** —— 锁屏界面
#    本身就是 Awake，于是守护进程会在 CE 存储尚未解锁时被拉起，那一轮它读不到 profile.conf
#    （detect_config_path 只跑一次），只能全程跑代码默认值、界面改配置也不生效。
#    判据取「私有目录可列」而不是某个 getprop/cmd：它就是守护进程真正要用的那个目录，
#    同源、零额外 fork；探测失败按"未就绪"处理（与 screen_on 的兜底方向相反 ——
#    这里的两个方向代价不对称：多等一会儿只推迟控温，而放过一次就要等这个实例重启才恢复）。
#    超时兜底：万一判据在该机型/root 方案下不成立，也不能永远不拉起（那比跑默认值更糟）——
#    超时后照常拉起并记一条日志，配置由 C 端的周期重试自行补齐（见 tempctrl.c 的 config_loaded）。
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

# 2. 拉起守护进程（**不再先杀**——"存在即不重复拉起"的另一半）
#    旧行为是"无条件 stop_old 再 start"，那正是"守护进程拉起看门狗 → 看门狗杀掉守护进程"成环的
#    源头（见 tempctrl.c 的「看门狗反向保活」小节）。取消之后：
#      · 这里只调 start，它内部先查（running）再拉，已有实例就什么都不做；
#      · "换掉在跑的实例"改由调用方负责——app 的停止序列（killAndWaitSnippet）在拉起本脚本之前
#        就已经把旧 daemon 停稳；本脚本的重部署路径（auto_update_check 内部）也自带 stop_old。
#    代价（如实记录）：开机时若已有实例在跑（例如用户开机后抢先点了「拉起daemon」，那个实例活在
#    app 的 cgroup 内），不再把它替换成 service.d 拉起的规范实例；它会随 app 一起被杀，随后由
#    本脚本的看门狗循环在 ≤RESTART_INTERVAL 秒内重建。
start

# 3. 看门狗：每 5 分钟确认进程存活（C 端自身有看门狗，这里兜住进程级死亡）
while true; do
    sleep $RESTART_INTERVAL
    # --- 宿主 APK 卸载自清理（兜底）---
    # 判据与 C 端 host_app_uninstalled() 同构：父目录 + pm path 二次确认。
    # 必须排在最前：置前的 SELF 自检只退出不清理，会漏掉仍留在 /data/local/tmp 的二进制。
    # 必须排在任何 start() 之前，否则守护进程会在 5 分钟内自己回来。
    # 全程静默（包括 cleanup_all 内部的 stop_old 可能写的日志）——那点写入随后被 rm 删掉，
    # 不能落在这里的任何一处 echo，否则日志文件会在卸载后被重新建出来。
    # 隔 5s 复核一次才动手（对齐 C 端「连续 2 次命中才判真」）：本循环 300s 才跑一轮，
    # 单次采样若撞上 /data/data 挂载抖动或 pm 未就绪就会误判，而误判的代价是自毁部署。
    if [ ! -d "$HOST_DIR" ] && ! "$PM_BIN" path "$HOST_PKG" > /dev/null 2>&1; then
        sleep 5
        if [ ! -d "$HOST_DIR" ] && ! "$PM_BIN" path "$HOST_PKG" > /dev/null 2>&1; then
            cleanup_all
            exit 0
        fi
    fi
    # --- 自尽自检（纵深防御，比被卸载方 pkill 更可靠）---
    # 不同 root 方案下本 shell 的 cmdline 形态不一样，卸载方的匹配可能漏掉，故这里自愈：
    # 脚本文件或二进制任一不在 → 说明已被卸载/清掉，立即静默退出。
    # 必须"静默"：此分支一旦 log() 写盘，就会把卸载时刚删掉的日志文件重建出来。
    # 也必须排在任何 start() 之前，否则守护进程会在 5 分钟内自己回来。
    if [ -n "$SELF" ] && [ ! -f "$SELF" ]; then
        exit 0
    fi
    if ! [ -x "$BIN" ]; then
        # 静默（与上一分支同理，见其上注释）：此处写盘会把卸载时刚删掉的日志文件重建出来
        exit 0
    fi
    # --- 自动更新（周期性自校验）---
    # 必须排在上面三处 exit 0 之后：卸载自清/自尽那条路上任何一次写盘，都会把刚删掉的日志重建出来。
    # 需重部署时 auto_update_check 内部已停旧实例，下面这个分支负责把新二进制起起来。
    if [ "$AU_TRIES" -lt "$AU_MAX_TRIES" ]; then
        AU_TRIES=$((AU_TRIES + 1))
        auto_update_check
    fi
    if ! running; then
        screen_on || sleep 15
        start
    fi
done
