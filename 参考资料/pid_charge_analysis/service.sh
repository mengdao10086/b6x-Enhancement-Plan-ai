#!/system/bin/sh
MODDIR=${0%/*}
echo "请等待"
while [ -z `getprop sys.boot_completed` ]; do sleep 1; done
#防止傻屌反复运行
PID_process=`pgrep -f "PID_MOD"`
if [[ ! "$PID_process" == "" ]]; then
    echo 'Kill PID_MOD >>'
    kill -9 $PID_process 2>/dev/null
fi
#运行
nohup $MODDIR/PID_MOD* >/dev/null 2>&1 &
if [[ $(pgrep PID_MOD) != "" ]]; then
    echo 'PID_MOD Success! '
    sed -i "/^description=/c description=[ 运行成功！模块配置文件在/data/adb/modules/PID_CHG_MOD//配置，日志文件在同级目录PID_log ]" $MODDIR/module.prop
    sleep 1
#机型获取
    device=$(getprop ro.product.marketname)
    echo $device
    model=$(echo $device | tr -d ' ')
    sed -i "/^机型=/c 机型=$model" $MODDIR/配置
    sed -i "/^版本=/c 版本=`sed '/^version=/!d;s/.*=//' /$MODDIR/module.prop`" $MODDIR/配置
else
    echo 'PID_MOD Fail! '
    sed -i "/^description=/c description=[ 未运行，请联系作者反馈！模块配置文件在/data/adb/modules/PID_CHG_MOD/配置，日志文件在同级目录PID_log ]" $MODDIR/module.prop
fi
#setprop ctl.stop mi_thermald