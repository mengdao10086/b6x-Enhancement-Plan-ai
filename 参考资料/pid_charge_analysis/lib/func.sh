#!/system/bin/sh
MODDIR=${0%/*}
a=1
modthermal="$MODDIR/提取文件"
config="/data/vendor/thermal/config"
export LD_LIBRARY_PATH=$MODDIR:$LD_LIBRARY_PATH
draw(){
    mkdir $modthermal
    cp -f /odm/etc/thermal-*.conf $modthermal >/dev/null 2>&1
    cp -f /vendor/etc/thermal-*.conf $modthermal >/dev/null 2>&1
    cp -f /system/etc/thermal-*.conf $modthermal >/dev/null 2>&1
    echo "温控文件提取完成!!!"
    sleep 1
}
modify() {
    mkdir $MODDIR/config
    $MODDIR/mithermal_change -a $modthermal $MODDIR/config 
    sleep 1
}
replace(){
    cp -r $MODDIR/config /data/vendor/thermal
}
delete(){
    echo "备用方案"
}
key_click(){
local key
    while true;do
        key=$(getevent -qlc 1 | awk '{ print $3,$4 }')
        if [[ $key == 'KEY_VOLUMEDOWN UP' ]];then
            return 1
        elif [[ $key == 'KEY_VOLUMEUP UP' ]];then
            return 0
        fi
        
    done
}
funcrun(){
    if [ $a -eq 1 ]; then
        if [ -z "$(ls $MODDIR/config)" ]; then
            draw
            modify
            replace
            echo "日用场景充电温控猎杀完成"
            echo
        else
            echo "日用场景充电温控已猎杀完成"
            echo
            echo "如果异常请清空"$MODDIR/config
        fi
        if [ -z "$(ls $config)" ]; then
            replace
            echo "日用场景温控替换完成！"
        else
            echo 
            echo
            echo "⚠️当前云控目录存在温控文件，音量上选择替换！⚠️"
            echo
            echo "⚠️音量下退出！⚠️"
            key_click
            if [ $? == 0 ]; then  
                echo
                replace
                echo "替换完成"
                echo
                echo "如果异常请清空云控目录"$config
                echo
            fi
        fi
    elif [ $a -eq 2 ]; then
        echo "系统温控暂时关闭，打游戏和充电时请注意温度做好散热😘"
        echo
        echo "你可以再次电击执行按钮选择功能3恢复，或者重启手机😘"
        echo
        setprop ctl.stop mi_thermald
        echo > /sys/class/thermal/thermal_message/board_sensor_temp
    elif [ $a -eq 3 ]; then
        echo "系统温控已经恢复😘"
        echo
        setprop ctl.restart mi_thermald
    fi
}
funcshow(){
    if [ $a -eq 1  ]; then
        echo "功能$a: 扬充电温控  请按压音量键上确认选择"
        echo "继续选择请按音量键下"
        echo
    elif [ $a -eq 2 ]; then
        echo "功能$a: 暂时关闭温控 此时cpu充电等都不受限制"
        echo "请按压音量键上确认选择 继续选择请按音量键下"
        echo
    elif [ $a -eq 3 ]; then
        echo "功能$a: 恢复关闭的温控 请按压音量键上确认选择" 
        echo "继续选择请按音量键下"
        echo
    elif [ $a -eq 4 ]; then
        echo "功能$a: 同步共享在线温控配置(辅助模块写好了，还未有针对机型的配置)" 
        echo "看介绍可以学习使用，尝试自己写一下温控同步(有点脱裤子放屁的感觉)"
        echo "继续选择请按音量键下"
        echo
    elif [ $a -ge 5 ];then
        a=1
        echo "功能$a: 扬充电温控  请按压音量键上确认选择"
        echo "继续选择请按音量键下"
        echo
    fi
}
while true; do
    funcshow
    key_click
    key=$?
    if [ $key -eq 0 ]; then
        echo "您确认了运行了功能$a"
        echo
        funcrun
        echo "请再次点击音量键上或下结束或退出😘"
        key_click
        break
    else
        ((a++))
    fi
done