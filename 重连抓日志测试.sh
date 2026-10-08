#!/system/bin/sh
# 飞智温控增强 — 重连抓日志测试脚本
#
# 用途：真机复现「长时间断联后后台无法重连」时，一次性抓齐判定所需信息：
#   ① 宿主进程存活（pid；同一 pid 贯穿 = 进程未重启）
#   ② 模块 logcat（LSPosedFramework 标签）——含 connect() 进入/退出、预探测、自扫结束、断连、后台重连尝试
#   ③ 蓝牙栈连接/GATT/扫描状态（dumpsys bluetooth_manager）
#   ④ 宿主 app 的运行时权限（BLUETOOTH_CONNECT / BLUETOOTH_SCAN 是否 granted）
#   ⑤ status 文件（/data/local/tmp/tempctrl_*.status）
#   ⑥ 自扫诊断汇总行（判定 R1/R2/R4 的关键）
#
# 用法（设备端，需 root）：
#   推荐步骤：先让散热器断联（关机/走远）并保持后台或灭屏 ≥3min，
#             再 su -c 'sh <脚本绝对路径> [抓取秒数] [包名]'
#   抓取秒数默认 180；包名默认 B6X 宿主 com.flydigi.waspwing.experimental。
#   （脚本会先落一份「运行前缓冲」——即上面那段 ≥3min 断联日志——再清缓冲进入抓取窗口。）
#
# 落点：手机端放 /storage/emulated/0/一键另存/测试/，或 adb push 到 /data/local/tmp/。
# 输出：与脚本同目录的「重连抓日志结果.log」（前缀一致）。

DIR=$(dirname "$0")
OUT="$DIR/重连抓日志结果.log"
SEC="${1:-180}"
PKG="${2:-com.flydigi.waspwing.experimental}"
TAG="LSPosedFramework"

log() { echo "$1" | tee -a "$OUT"; }

# 每次运行重开头（覆盖上一份结果）
: > "$OUT" 2>/dev/null || { echo "无法写入 $OUT（检查脚本所在目录权限）" >&2; exit 1; }

log "==================== 重连抓日志 $(date) ===================="
log "抓取时长=${SEC}s　包名=${PKG}　脚本目录=${DIR}"

# ---- [0] 先落一份「运行前缓冲」再清空，进入抓取窗口 ----
log ""
log "---- [0] 复现步骤 ----"
log "   1) 先让散热器断联（关机/走远），并保持后台/灭屏 ≥3min"
log "   2) 运行本脚本：先落一份运行前缓冲，再在下面窗口内继续保持断联（默认 ${SEC}s）"
log ""
log "--- 运行前缓冲（logcat -d，清空前）---"
logcat -d -v time -s "$TAG" 2>/dev/null | tee -a "$OUT"
log "(清空缓冲，进入抓取窗口)"
logcat -c 2>/dev/null || log "(logcat -c 失败，继续)"
i=0
while [ "$i" -lt "$SEC" ]; do
    sleep 5
    i=$((i + 5))
    log "  …剩余 $((SEC - i))s"
done

# ---- [1] 宿主进程存活 ----
log ""
log "========== [1] 宿主进程存活 =========="
PID=$(pidof "$PKG" 2>/dev/null || ps -A 2>/dev/null | grep -w "$PKG" | awk '{print $2}' | head -1)
log "宿主进程 pid=${PID:-（空=已退出/未找到）}"
log "（同一 pid 贯穿全程 = 进程未重启 → 「陈旧挂起对象」路线的先决条件成立）"

# ---- [2] 模块 logcat ----
log ""
log "========== [2] 模块 logcat（tag=$TAG）=========="
logcat -d -v time -s "$TAG" 2>/dev/null | tee -a "$OUT"
log "(若此处为空：模块日志 tag 可能不同，尝试：logcat -d | grep -iE 'waspwingtempctrl|LSPosed')"

# ---- [3] 蓝牙栈状态 ----
log ""
log "========== [3] dumpsys bluetooth_manager（连接/GATT/扫描）=========="
if command -v dumpsys >/dev/null 2>&1; then
    dumpsys bluetooth_manager 2>/dev/null | grep -iE "gatt|connect|scan|Device|address" | head -200 | tee -a "$OUT"
else
    log "(dumpsys 不可用)"
fi

# ---- [4] 宿主 app 运行时权限 ----
log ""
log "========== [4] 宿主 app 运行时权限（$PKG）=========="
if command -v dumpsys >/dev/null 2>&1; then
    dumpsys package "$PKG" 2>/dev/null | grep -iE "BLUETOOTH_CONNECT|BLUETOOTH_SCAN" | tee -a "$OUT"
    log "--- 权限授予一览（granted= 行）---"
    dumpsys package "$PKG" 2>/dev/null | grep -iE "granted=" | head -40 | tee -a "$OUT"
else
    log "(dumpsys 不可用)"
fi

# ---- [5] status 文件 ----
log ""
log "========== [5] status 文件 =========="
for f in /data/local/tmp/tempctrl_b6x.status /data/local/tmp/tempctrl_b7x.status; do
    log "--- $f ---"
    cat "$f" 2>/dev/null | tee -a "$OUT"
    [ -s "$f" ] || log "(不存在或为空)"
done

# ---- [6] 关键判定行摘录 ----
log ""
log "========== [6] 关键判定行摘录 =========="
LOG_DUMP=$(logcat -d -s "$TAG" 2>/dev/null)
log "--- connect() 退出（是否有 gatt / throwable）---"
echo "$LOG_DUMP" | grep "connect() 退出" | tee -a "$OUT"
log "--- 预探测 / R2 命中 / GATE-A ---"
echo "$LOG_DUMP" | grep -E "预探测|R2 命中|GATE-A|异常留痕" | tee -a "$OUT"
log "--- 自扫（R1/R2/R4 判别）---"
echo "$LOG_DUMP" | grep -E "自扫结束|硬自愈|地址不符|回调异常|取地址异常" | tee -a "$OUT"
log "--- 断连 ---"
echo "$LOG_DUMP" | grep "BLE 断联" | tee -a "$OUT"
log "--- 成功连接（修好判据）---"
echo "$LOG_DUMP" | grep "\[底层\] BLE 已连接" | tee -a "$OUT"
log ""
log "判定指引："
log "  · 自扫结束 回调=0                       → 设备不在场 R1（环境，非代码）"
log "  · connect() 退出 throwable=SecurityException 或 预探测/回调异常(取地址) → R2 命中（陈旧对象/权限门禁）"
log "  · 自扫结束 回调>0 地址不符>0            → R4（比较/脱敏）"
log "  · [底层] BLE 已连接 且未手动开 App      → 修复生效"

log ""
log "==================== 抓取完成，结果见：$OUT ===================="
