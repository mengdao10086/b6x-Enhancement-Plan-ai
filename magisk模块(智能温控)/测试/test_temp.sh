#!/system/bin/sh
# 飞智散热器 — 温度控制测试脚本
# 推送到手机后用 su 执行
# adb push test_temp.sh /sdcard/
# adb shell su -c "sh /sdcard/test_temp.sh"

echo "=== 飞智散热器 温度控制测试 ==="

# 测试 1：智能温控模式，目标 28°C
echo ""
echo "[测试 1] 设置智能温控 28°C..."
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 0 --ei temperature 28 \
    --ei extra 0 2>&1
sleep 2

echo ""
echo "[测试 2] 设置智能温控 22°C..."
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 0 --ei temperature 22 \
    --ei extra 0 2>&1
sleep 2

echo ""
echo "[测试 3] 设置智能温控 30°C..."
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 0 --ei temperature 30 \
    --ei extra 0 2>&1

echo ""
echo "=== 完成 ==="
echo "请在手机上确认散热器 App 温度已变化"
echo "如未生效，请执行: logcat | grep WaspWingTempCtrl"
