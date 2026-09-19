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
    # --- 自尽自检（纵深防御，比被卸载方 pkill 更可靠）---
    # 不同 root 方案下本 shell 的 cmdline 形态不一样，卸载方的匹配可能漏掉，故这里自愈：
    # 脚本文件或二进制任一不在 → 说明已被卸载/清掉，立即静默退出。
    # 必须"静默"：此分支一旦 log() 写盘，就会把卸载时刚删掉的日志文件重建出来。
    # 也必须排在任何 start() 之前，否则守护进程会在 5 分钟内自己回来。
    if [ -n "$SELF" ] && [ ! -f "$SELF" ]; then
        exit 0
    fi
    if ! [ -x "$BIN" ]; then
        log "二进制已不存在（$BIN），看门狗退出"
        exit 0
    fi
    if ! running; then
        screen_on || sleep 15
        start
    fi
done
