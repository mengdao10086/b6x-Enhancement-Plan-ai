set_perm_recursive "$MODPATH" 0 0 0755 0755
# 获取设备型号
device_model=$(getprop ro.product.manufacturer)
# 定义允许安装的设备型号
allowed_model="Xiaomi"
# 检查设备型号是否符合要求
if [ "$device_model" != "$allowed_model" ]; then
    ui_print "此模块只支持米系手机与平板设备！停止安装!"
    exit 1
fi
echo "厂商设备为米系！检测正常！"
ui_print "本充电模块只支持米系手机与平板设备使用，伪机型可能会判断错误！"

ui_print "默认配置在/data/adb/modules/PID_CHG_MOD/配置"
ui_print "游戏/旁路配置在/data/adb/modules/PID_CHG_MOD/GAME_list"

ui_print "配置实时生效无需重启"

ui_print "亮屏充电温度设定值为43℃可能会有±0.4℃的偏差"
ui_print "息屏充电温度设定为45.5可能会有±0.4℃的偏差"
ui_print "添加夜间模式超过9点充电会自动进入夜间模式充电温度只有39℃"

ui_print "注意！配置默认功率是120W，请根据手机或平板充电规格更改功率功率！"

ui_print "模块与各种定温定流充电模块有冲突请不要同时安装"
ui_print "更不要只是单纯的停相关冲突的模块，请先卸载后使用"

ui_print "!!!有强迫症的人谨慎安装!!! "
ui_print "!!!有强迫症的人谨慎安装!!! "
ui_print "!!!有强迫症的人谨慎安装!!! "
ui_print " 版本为重构版本，有问题请加群反馈将log发到群里面，详细描述问题 "
version_check() {
    if [[ $KSU_VER_CODE != "" ]] && [[ $KSU_VER_CODE -lt 11874 || $KSU_KERNEL_VER_CODE -lt 11874 ]]; then
        abort "不支持的KSU版本 (需versionCode >= 11874)"
    elif [[ $KSU_VER_CODE == "" && $MAGISK_VER_CODE != "" && $MAGISK_VER_CODE -lt 26000 ]]; then
		abort "不支持的Magisk版本(需versionCode >= 26000)"
    elif [[ $API -lt 30 ]]; then
        abort "不支持的安卓版本 (需apiVersion >= 30)"
    fi
}
version_check

