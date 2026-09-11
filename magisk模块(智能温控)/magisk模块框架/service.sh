#!/system/bin/sh
# KernelSU 模块目录通常挂载了 noexec，不能直接运行二进制，
# 所以将 tempctrl 复制到 /data/local/tmp/ 再执行。
# tempctrl 通过 /proc/self/exe 自动定位 profile.conf（同目录/父目录）

MODDIR=${0%/*}
LOG_FILE="/cache/tempctrl.log"
BIN_SRC="$MODDIR/tempctrl"
BIN_DST="/data/local/tmp/tempctrl"
CONFIG_FILE="$MODDIR/profile.conf"

# 统一日志函数
log_msg() {
    echo "$(date '+%Y-%m-%d %H:%M:%S')：$1" >> "$LOG_FILE"
}

# 获取屏幕状态
get_screen_state() {
    state=$(dumpsys power 2>/dev/null | grep 'mWakefulness=' | head -1 | cut -d= -f2)
    case "$state" in
        Awake) echo "on" ;;
        Asleep|Dozing) echo "off" ;;
        *) echo "on" ;;
    esac
}

# 复制二进制并启动
copy_and_start() {
    pkill -f "$BIN_DST" 2>/dev/null
    sleep 1
    cp "$BIN_SRC" "$BIN_DST"
    chmod 0755 "$BIN_DST"
    nohup "$BIN_DST" --config "$CONFIG_FILE" >> "$LOG_FILE" 2>&1 &
}

# 1. 等待屏幕点亮（视为系统启动完成）
while [ "$(get_screen_state)" != "on" ]; do
    sleep 5
done

# 2. 清空上次日志并首次启动
> "$LOG_FILE"
copy_and_start

# 3. 每隔 5 分钟检查一次进程状态
while true; do
    sleep 300
    if ! pgrep -f "$BIN_DST" > /dev/null 2>&1; then
        # 非 on 状态则先等待 15 秒
        if [ "$(get_screen_state)" != "on" ]; then
            sleep 15
        fi
        # 先复制文件再启动
        copy_and_start
        log_msg "已重启 tempctrl"
    fi
done