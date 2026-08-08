#!/system/bin/sh
# 飞智 B6X 增强计划 — Magisk 模块卸载清理
# 删除 tempctrl 运行时产生的文件

# 日志文件（默认路径；tempctrl.log，检测到用户修改 LOG_FILE 时会在此文件追加对应 rm 行）
rm -f /cache/tempctrl.log

# status 文件
rm -f /data/local/tmp/tempctrl.status  # 旧
rm -f /data/local/tmp/tempctrl_b6x.status
rm -f /data/local/tmp/tempctrl_b7x.status

# 制冷强度存档
rm -f /data/local/tmp/tempctrl.gear  # 旧

# 复制的二进制
rm -f /data/local/tmp/tempctrl
