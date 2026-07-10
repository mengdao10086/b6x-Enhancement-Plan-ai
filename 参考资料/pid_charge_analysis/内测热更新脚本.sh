MODDIR=${0%/*}
BETA_FILE="/storage/emulated/0/Android/data/com.tencent.mobileqq/Tencent/QQfile_recv/PID_MODv*"
echo $BETA_FILE
if [ -f $BETA_FILE ]; then
    echo "内测文件存在…请等待热更新完成…!"
    rm -f $MODDIR/PID_MOD*
    mv -f $BETA_FILE $MODDIR/
    chmod +x $MODDIR/service.sh
    $MODDIR/service.sh
else
    echo "内测文件不存在"
fi
