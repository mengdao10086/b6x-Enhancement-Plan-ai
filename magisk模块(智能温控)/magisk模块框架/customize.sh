#!/system/bin/sh
# ============================================================
# 飞智 B6X 增强计划 — 模块安装脚本
# ============================================================
# 刷入时 Magisk/KSU 自动执行：设置文件权限 + 询问自动拉起开关
# ============================================================

# 设置模块文件权限（可执行文件 0755，配置文件 0644）
set_perm "$MODPATH/tempctrl" 0 0 0755
set_perm "$MODPATH/service.sh" 0 0 0755
set_perm "$MODPATH/uninstall.sh" 0 0 0755
set_perm "$MODPATH/profile.conf" 0 0 0644

# ============================================================
# 自动拉起散热器 app 开关（v2.8）
#   - 音量+ = 开启（拉起后自动后台化，几乎无感）
#   - 音量- = 关闭（保持静默，需手动打开 app）
#   - 无操作 30 秒 或 读不到按键（如 KSU 环境）→ 默认关闭
# 之后可在 WebUI 的 APP_LAUNCH_ENABLED 随时修改
# ============================================================
ui_print ""
ui_print "=============================="
ui_print "  自动拉起散热器 app 功能"
ui_print "  无散热器 app 存活时自动拉起上次使用的 app"
ui_print "  拉起时会闪烁一下散热器的ui界面"
ui_print "  请自行根据自己的使用习惯选择是否开启"
ui_print "=============================="
ui_print "  音量+ = 开启   音量- = 关闭"
ui_print "  不操作 30 秒 → 默认关闭"

LAUNCH_ENABLED=0
KEY_PRESSED=0
for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30; do
    KEY=$(timeout 1 getevent -c 1 -lq 2>/dev/null | grep -o 'KEY_VOLUME[A-Z]*' | head -1)
    case "$KEY" in
        KEY_VOLUMEUP)   LAUNCH_ENABLED=1 ;;
        KEY_VOLUMEDOWN) LAUNCH_ENABLED=0 ;;
        *) continue ;;  # 读到其它键事件忽略，继续等音量键
    esac
    KEY_PRESSED=1
    break
done

if [ "$KEY_PRESSED" = 1 ]; then
    if [ "$LAUNCH_ENABLED" = 1 ]; then
        ui_print "已选择：开启自动拉起"
    else
        ui_print "已选择：关闭自动拉起"
    fi
else
    ui_print "未检测到按键，默认关闭自动拉起"
fi

# 写入 profile.conf（已有行替换，无则追加）
if [ -f "$MODPATH/profile.conf" ]; then
    if grep -q '^APP_LAUNCH_ENABLED=' "$MODPATH/profile.conf"; then
        sed -i "s/^APP_LAUNCH_ENABLED=.*/APP_LAUNCH_ENABLED=$LAUNCH_ENABLED/" "$MODPATH/profile.conf"
    else
        echo "APP_LAUNCH_ENABLED=$LAUNCH_ENABLED" >> "$MODPATH/profile.conf"
    fi
    ui_print "APP_LAUNCH_ENABLED=$LAUNCH_ENABLED（可后续在 WebUI 修改）"
fi
