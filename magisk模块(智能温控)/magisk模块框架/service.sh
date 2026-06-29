#!/system/bin/sh
# KernelSU 的模块目录通常挂载了 noexec，不能直接运行二进制，
# 所以将 tempctrl 复制到 /data/local/tmp/ 再执行。
# tempctrl 通过 /proc/self/exe 自动定位 profile.conf（同目录/父目录）

MODDIR=${0%/*}

# 启动函数
start_tempctrl() {
    nohup /data/local/tmp/tempctrl --config "$MODDIR/profile.conf" >> /cache/tempctrl_init.log 2>&1 &
}

# 1. 等待系统启动完成（仅首次执行）
for i in $(seq 1 12); do
    if [ "$(getprop sys.boot_completed)" = "1" ]; then
        break
    fi
    sleep 5
done

# 2. 复制二进制到可执行分区（仅首次执行）
cp "$MODDIR/tempctrl" /data/local/tmp/tempctrl
chmod 755 /data/local/tmp/tempctrl

# 3. 首次启用
start_tempctrl

# 4. 每隔5分钟检查一次进程状态
while true; do
    sleep 300
    if ! pgrep -f "/data/local/tmp/tempctrl" > /dev/null 2>&1; then
        # 进程不存在，重新启动
        start_tempctrl
        echo "
$(date '+%Y-%m-%d %H:%M:%S')：已重启tempctrl
" >> /cache/tempctrl_init.log
    fi
done