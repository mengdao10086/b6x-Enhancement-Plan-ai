#!/system/bin/sh
# 飞智 B6X 增强计划 — 模块安装脚本
# 刷入时 Magisk/KSU 自动执行：设置文件权限 + 询问自动拉起开关

# 设置模块文件权限（可执行文件 0755，配置文件 0644）
set_perm "$MODPATH/tempctrl" 0 0 0755
set_perm "$MODPATH/service.sh" 0 0 0755
set_perm "$MODPATH/uninstall.sh" 0 0 0755
set_perm "$MODPATH/profile.conf" 0 0 0644

# 输出ui_print提示信息，询问用户是否开启自动拉起散热器 app 功能
ui_print ""
ui_print "=============================="
ui_print "  自动拉起散热器 app 功能"
ui_print "  无散热器 app 存活时自动拉起上次使用的 app"
ui_print "  拉起时会闪烁一下散热器的ui界面"
ui_print "  请自行根据自己的使用习惯选择是否开启"
ui_print "  本功能也是锁死自动重启功能的前置条件"
ui_print "=============================="
ui_print "  音量+ = 开启   音量- = 关闭"
ui_print "  不操作 30 秒 → 默认关闭"
ui_print "=============================="
ui_print ""

LAUNCH_ENABLED=0
KEY_PRESSED=0
for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30; do
    command -v getevent >/dev/null 2>&1 || break   # 无 getevent 的环境（部分 ksu 恢复模式）直接跳过，避免空等 30s×2
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
ui_print ""

sleep 1

# 锁死自动重启（watchdog）选择：仅自动拉起开启时询问，默认关闭
# （自动拉起为前置条件：C 端检测到自动拉起关闭时，无论配置如何都会强制关闭 watchdog）
WATCHDOG_VALUE=0
if [ "$LAUNCH_ENABLED" = "1" ]; then
    ui_print ""
    ui_print "=============================="
    ui_print "  散热器锁死自动重启功能"
    ui_print "  检测到散热器锁死（实际制冷持续多周期无响应）时"
    ui_print "  自动强制重启散热器 app 以恢复控制"
    ui_print "  默认关闭（不操作保持关闭）"
    ui_print "=============================="
    ui_print "  音量+ = 开启（6 周期）   音量- = 关闭"
    ui_print "  不操作 30 秒 → 默认关闭"
    ui_print "=============================="
    ui_print ""
    KEY_PRESSED=0
    WATCHDOG_ENABLED=0
    for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30; do
        command -v getevent >/dev/null 2>&1 || break   # 无 getevent 直接跳过按键等待
        KEY=$(timeout 1 getevent -c 1 -lq 2>/dev/null | grep -o 'KEY_VOLUME[A-Z]*' | head -1)
        case "$KEY" in
            KEY_VOLUMEUP)   WATCHDOG_ENABLED=1; WATCHDOG_VALUE=6 ;;
            KEY_VOLUMEDOWN) WATCHDOG_ENABLED=0; WATCHDOG_VALUE=0 ;;
            *) continue ;;
        esac
        KEY_PRESSED=1
        break
    done

    if [ "$KEY_PRESSED" = 1 ]; then
        if [ "$WATCHDOG_ENABLED" = 1 ]; then
            ui_print "已选择：开启锁死自动重启"
        else
            ui_print "已选择：关闭锁死自动重启"
        fi
    else
        ui_print "未检测到按键，默认关闭锁死自动重启"
    fi
    ui_print ""
else
    ui_print "自动拉起未开启，锁死自动重启默认关闭（自动拉起为其前置条件）"
fi

# 写入 profile.conf（已有行替换，无则追加）
if [ -f "$MODPATH/profile.conf" ]; then
    if grep -q '^APP_LAUNCH_ENABLED=' "$MODPATH/profile.conf"; then
        sed -i "s/^APP_LAUNCH_ENABLED=.*/APP_LAUNCH_ENABLED=$LAUNCH_ENABLED/" "$MODPATH/profile.conf"
    else
        echo "APP_LAUNCH_ENABLED=$LAUNCH_ENABLED" >> "$MODPATH/profile.conf"
    fi
    ui_print "APP_LAUNCH_ENABLED=$LAUNCH_ENABLED（可后续在 WebUI/配置文件 修改）"
    # 锁死自动重启周期数（0=关闭；6=实际制冷停滞 6 周期(30s)且≠目标则 kill app 重新拉起）
    if grep -q '^APP_WATCHDOG=' "$MODPATH/profile.conf"; then
        sed -i "s/^APP_WATCHDOG=.*/APP_WATCHDOG=$WATCHDOG_VALUE/" "$MODPATH/profile.conf"
    else
        echo "APP_WATCHDOG=$WATCHDOG_VALUE" >> "$MODPATH/profile.conf"
    fi
    ui_print "APP_WATCHDOG=$WATCHDOG_VALUE（可后续在 WebUI/配置文件 修改）"
fi
