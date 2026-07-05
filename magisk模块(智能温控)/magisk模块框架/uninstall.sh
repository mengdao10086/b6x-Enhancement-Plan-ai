#!/system/bin/sh
# 飞智 B6X 增强计划 — Magisk 模块卸载清理
# 删除 tempctrl 运行时产生的临时/持久文件
# service.sh 将二进制复制至此目录，一并清理

# 日志文件（默认路径 /cache/tempctrl.log）
rm -f /cache/tempctrl.log

# status 文件（LSPosed 模块通信 + BLE 状态）
rm -f /data/local/tmp/tempctrl.status

# 制冷强度存档（下次启动继承）
rm -f /data/local/tmp/tempctrl.gear

# 复制的二进制
rm -f /data/local/tmp/tempctrl
