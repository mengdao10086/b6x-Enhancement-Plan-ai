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
# 幂等由 C 端单实例锁兜底（锁文件在私有目录 tempctrl.lock）：第二个实例打印 stderr 后
# 以退出码 2 退出，其它启动失败路径返回 0。因此启动前必须先确保旧进程【真的退出】。

BIN=/data/local/tmp/tempctrl
SVC_LOG=/data/local/tmp/tempctrl_service.log
WAIT_LOOPS=30           # 等旧进程退出：30 × 1s（C 端最长 sleep 5s 一轮）
RESTART_INTERVAL=300    # 看门狗周期（秒）

# 宿主 APK 包名与数据目录。判据用【父目录】而非 files/：app「清除数据」只清 files/ 内容，
# 父目录由系统保留 → 可抗"清除数据"误判（代价记在 lsp模块/daemon/逻辑说明.md 的「参数落点」注记处）。
HOST_PKG=com.example.waspwingtempctrl
HOST_DIR=/data/data/$HOST_PKG
PM_BIN=/system/bin/pm

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

running() {
    pgrep -f "$BIN" > /dev/null 2>&1
}

# 停旧实例：pkill 之后必须轮询 pgrep 等它真正退出。
# 只 sleep 1 就启动，新实例会因单实例锁立刻以 2 退出（旧 service.sh 就踩过这个坑）。
stop_old() {
    pkill -f "$BIN" 2>/dev/null
    i=0
    while [ $i -lt $WAIT_LOOPS ]; do
        running || return 0
        sleep 1
        i=$((i + 1))
    done
    log "旧实例 $WAIT_LOOPS 秒未退出，升级 SIGKILL"
    pkill -9 -f "$BIN" 2>/dev/null
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
    running && return 0
    # 不传 --config：C 端按私有目录自行定位 profile.conf（--config 仅用于覆盖该默认）
    nohup "$BIN" >> "$SVC_LOG" 2>&1 < /dev/null &
    sleep 2
    if running; then
        pid=$(pgrep -f "$BIN" | head -1)
        renice -n -20 -p "$pid" > /dev/null 2>&1
        log "已启动 tempctrl（pid=$pid）"
        return 0
    fi
    log "tempctrl 启动后未存活（退出码 2 = 已有实例在跑）"
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

# 1. 等亮屏（FBE 解锁后私有目录与 sysfs 才可靠可读）
while ! screen_on; do
    sleep 5
done

# 2. 停掉可能残留的旧实例，再启动
if stop_old; then
    start
fi

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
    if ! running; then
        screen_on || sleep 15
        start
    fi
done
