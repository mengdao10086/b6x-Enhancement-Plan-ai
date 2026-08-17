#!/system/bin/sh
# 飞智 B6X 增强计划 — 散热器无反应诊断脚本
#
# 用途：定位「守护进程卡在等待设备 / BLE 状态一直是 0」的根因。
#       输出 进程状态、刷入版本、状态文件内容与时间、上次设备 MAC、LSP 模块日志。
#
# 用法（设备端，需 root）：
#   adb push diagnose_status.sh /data/local/tmp/
#   adb shell su -c 'sh /data/local/tmp/diagnose_status.sh'
#   或在设备的终端模拟器（如 Termux）里 su 后执行。

echo "========== [1] tempctrl 进程与刷入版本 =========="

echo "--- tempctrl 进程（空 = 守护进程已退出/崩溃）---"
ps -A 2>/dev/null | grep -i tempctrl || ps 2>/dev/null | grep -i tempctrl || echo "(未找到 tempctrl 进程，或 ps 不可用)"
echo "--- 散热器 app 进程（flydigi/extool，空 = app 没起来）---"
ps -A 2>/dev/null | grep -iE "flydigi|extool|waspwing" || ps 2>/dev/null | grep -iE "flydigi|extool|waspwing" || echo "(未找到散热器 app 进程——app 被拉起后未存活)"

echo "--- 模块版本 ---"
if [ -d /data/adb/modules ]; then
    for f in /data/adb/modules/*/module.prop; do
        [ -f "$f" ] || continue
        echo "[$f]"
        grep -E "^(name|version|versionCode)=" "$f"
    done
else
    echo "(无 /data/adb/modules，Magisk/KSU 模块目录不存在)"
fi

echo ""
echo "========== [2] 状态文件内容与最后写入时间（关键：BLE= 是否为 0） =========="
for f in /data/local/tmp/tempctrl_b6x.status /data/local/tmp/tempctrl_b7x.status; do
    echo "--- $f ---"
    if [ -f "$f" ]; then
        # mtime：距现在 >10s 说明 LSP 模块最近 10 秒内没有写入
        stat -c "  mtime=%y  (距今约 $(( $(date +%s) - $(stat -c %Y "$f") ))s)" "$f" 2>/dev/null || ls -l "$f"
        echo "  内容："
        cat "$f" 2>/dev/null
    else
        echo "  (文件不存在!)"
    fi
    echo ""
done

echo "========== [3] 上次连接设备 MAC 记录（冷启动自动连接依据） =========="
cat /data/local/tmp/tempctrl_last_dev 2>/dev/null || echo "(无 /data/local/tmp/tempctrl_last_dev)"

echo ""
echo "========== [4] 蓝牙开关状态 =========="
dumpsys bluetooth_manager 2>/dev/null | grep -iE "enabled|mEnable|state:" | head -5 || echo "(dumpsys bluetooth_manager 无输出或无权限)"

echo ""
echo "========== [5] LSP 模块日志（waspwing：连接/回传/反射失败） =========="
echo "--- logcat（grep WaspWing/extool）---"
logcat -d 2>/dev/null | grep -iE "waspwing|extool|MainHook" | tail -60 || echo "(logcat 无输出或无权限)"
echo "--- LSPosed verbose log（模块加载/写入异常权威来源，tag 含 WaspWing）---"
latest=$(ls -t /data/adb/lspd/log/verbose_*.log 2>/dev/null | head -1)
if [ -n "$latest" ]; then
    echo "[$latest]"
    grep -iE "waspwing|extool|MainHook|写入状态文件失败|反射失败|参数回传缺失" "$latest" | tail -60
else
    echo "(无 verbose log)"
fi

echo ""
echo "========== 诊断完成 =========="
echo "判断要点："
echo "  1. tempctrl 进程在 → 守护进程活着，问题在 BLE 链路；不在 → 进程崩溃/未启动"
echo "  2. BLE=0 → LSP 模块未把连接写入状态文件（查第 5 节 waspwing 日志有无 markConnected / 反射失败）"
echo "  3. BLE 非 0 但守护进程仍死等 → 贴出状态文件 mtime 与完整内容，可能是文件写入方路径/权限不一致"
echo "  4. 无 tempctrl_last_dev → app 从未成功连接过，或 MAC 未持久化"
