#!/system/bin/sh

SOURCE_PATH="/sdcard/Documents/flydigi/server"
OLD_SOURCE_PATH="/sdcard/Android/data/com.android.motionelf/server"
EXECUTE_PATH="/data/local/tmp"
STARTER_PATH="$EXECUTE_PATH/motionelf_server"
echo "info: starter.sh begin"

recreate_tmp() {
  echo "info: $EXECUTE_PATH is possible broken, recreating..."
  rm -rf $EXECUTE_PATH
  mkdir -p $EXECUTE_PATH
}

broken_tmp() {
  echo "fatal: $EXECUTE_PATH is broken, please try reboot the device or manually recreate it..."
  exit 1
}

if [ -d "$SOURCE_PATH" ]; then
  echo "info: attempt to copy driver from $SOURCE_PATH to $EXECUTE_PATH"

  cp -R "$SOURCE_PATH/motionelf_server" "$EXECUTE_PATH/motionelf_server"
  cp -R "$SOURCE_PATH/libmotionelf_server.so" "$EXECUTE_PATH/libmotionelf_server.so"
  cp -R "$SOURCE_PATH/FZToolHelperAndroid" "$EXECUTE_PATH/FZToolHelperAndroid"

  cp -R "$SOURCE_PATH/motionelf_server" "$OLD_SOURCE_PATH/motionelf_server"
  cp -R "$SOURCE_PATH/libmotionelf_server.so" "$OLD_SOURCE_PATH/libmotionelf_server.so"
  cp -R "$SOURCE_PATH/FZToolHelperAndroid" "$OLD_SOURCE_PATH/FZToolHelperAndroid"

  chmod 777 $STARTER_PATH
  chown 2000 $STARTER_PATH
  chgrp 2000 $STARTER_PATH
fi

if [ -f $STARTER_PATH ]; then
  echo "info: exec $STARTER_PATH &"
  pkill -f app_process32
  wait
  $STARTER_PATH "useDaemon" "&"
  result=$?
  wait
  if [ ${result} -ne 0 ]; then
    echo "info: motionelf_server exit with non-zero value $result"
  else
    echo "info: motionelf_server exit with 0"
  fi
  wait
  echo "info: try start app $1 with active_driver action"
  am startservice -n "$1"/com.android.motionelf.FloatingWindow -a remote_action_driver_active_request
elif [ -f "$EXECUTE_PATH/FZToolHelperAndroid" ]; then
  echo "info: kill old process"
  pkill -f app_process32
  wait
  setprop service.adb.tcp.port 5555
  wait
  chmod 777 $EXECUTE_PATH/FZToolHelperAndroid
  wait
  echo "info: run $EXECUTE_PATH/FZToolHelperAndroid"
  wait
  export CLASSPATH=$EXECUTE_PATH/FZToolHelperAndroid && app_process32 $EXECUTE_PATH com.flydigi.tool.FZToolMain &
  result=$?
  if [ ${result} -ne 0 ]; then
    echo "info: FZToolMain exit with non-zero value $result"
  else
    echo "info: FZToolMain exit with 0"
  fi
  wait
  echo "info: try start app $1 with active_driver action"
  am start -n "$1"/com.game.motionelf.activity.ActivityStart -e action active_driver
else
  echo "Starter file not exist, please open Flydigi game center and try again."
fi
