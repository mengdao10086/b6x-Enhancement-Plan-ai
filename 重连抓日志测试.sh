#!/system/bin/sh
# 飞智温控增强 — 重连抓日志测试脚本 v2（P0 观测修复）
#
# 目的：一次运行抓「未连 → 打开 App 触发连接 → 已连」两个状态，覆盖 v1 最大的盲区
#       （症状发生在「用户手动打开 App 那一刻」，v1 只在设备不在场时抓，窗口结束才让用户拿回设备）。
#
# 相对 v1 的修复（依据 .claude/subagent方案存放区/重连卡死-分析B.md）：
#   ① 死模式：v1 [6] 的成功判据 `[底层] BLE 已连接` 的发射点已被 v3.0 删除（dee5adca 里有、HEAD 里没有）
#      → 本版不再依赖它，改用客观事实判成功：status 文件 BLE=1 / dumpsys STATE_CONNECTED / SDK 的 FlyBle 日志。
#   ② 假阴性：v1 [6] 在末尾又跑了一次 `logcat -d`，与 [2] 是两次独立 dump，中间夹两次 dumpsys 刷屏
#      → [6] 空不代表事件没发生。本版：dump 一次落盘到文件，[2]/[6] 共读同一份文件。
#   ③ 新增抓取：
#      · 宿主 SDK 日志 tag `FlyBle`——App 以 debug=true 初始化 SDK（App.smali:61-63 → Logger.inDebugMode=true），
#        故 SDK 的 Logger 会进 logcat；门禁被挡时打 "gatt has been connected with other device"（这是根因实证钥匙）。
#      · 完整 dumpsys bluetooth_manager（含 GATT Client 段；v1 被 head -200 砍掉）。
#      · 模块的「后台重连尝试 / 重连循环心跳 / 设备锁死」行（v1 漏抓）。
#      · dump 前后行数，自证有没有被环形缓冲轮转。
#
# 用法（设备端，需 root）：
#   su -c 'sh <脚本绝对路径> [未连秒数] [提示等待秒数] [已连秒数] [包名]'
#   默认：未连 90s、提示等待 20s、已连 90s、包名 com.flydigi.waspwing.experimental
#   落点：手机端 /storage/emulated/0/一键另存/测试/ ，或 adb push 到 /data/local/tmp/
#   输出：与脚本同目录的
#         「重连抓日志结果.log」（人看的报告）
#         「重连抓日志原始-未连.log」「重连抓日志原始-已连.log」（原始 dump，供 [2]/[6] 共读）

DIR=$(dirname "$0")
OUT="$DIR/重连抓日志结果.log"
RAW_OFF="$DIR/重连抓日志原始-未连.log"
RAW_ON="$DIR/重连抓日志原始-已连.log"
SEC_OFF="${1:-90}"
WAIT_ON="${2:-20}"
SEC_ON="${3:-90}"
PKG="${4:-com.flydigi.waspwing.experimental}"
TAG_MOD="LSPosedFramework"
TAG_SDK="FlyBle"

log() { echo "$1" | tee -a "$OUT"; }
count_lines() { wc -l < "$1" 2>/dev/null | tr -d ' '; }

# 每次运行重开头（覆盖上一份结果）
: > "$OUT" 2>/dev/null || { echo "无法写入 $OUT（检查脚本所在目录权限）" >&2; exit 1; }
: > "$RAW_OFF" 2>/dev/null || { echo "无法写入 $RAW_OFF（检查脚本所在目录权限）" >&2; exit 1; }
: > "$RAW_ON" 2>/dev/null || { echo "无法写入 $RAW_ON（检查脚本所在目录权限）" >&2; exit 1; }

log "==================== 重连抓日志 v2 $(date) ===================="
log "未连=${SEC_OFF}s　提示等待=${WAIT_ON}s　已连=${SEC_ON}s　包名=${PKG}　脚本目录=${DIR}"
log ""
log "---- [0] 流程 ----"
log "   1) 先让散热器断联（关机/走远）并保持后台/灭屏 ≥3min（设备不在场、连不上）"
log "   2) 运行本脚本：先采一段「未连」"
log "   3) 脚本会停下来提示，此时【打开 App 触发一次连接】"
log "   4) 脚本再采一段「已连」（覆盖你手动打开 App 那一刻）"
log ""

# ---- 加大环形缓冲（best-effort；避免 LSPosedFramework 行被 SDK 的 FlyBle debug 日志挤出）----
logcat -G 16M 2>/dev/null || log "(logcat -G 16M 失败，继续；若下方出现行数骤降即为缓冲轮转)"

# ================= 阶段 1：未连 =================
log ""
log "========== [1] 未连阶段（采 ${SEC_OFF}s，保持设备不在场/连不上）=========="
logcat -c 2>/dev/null || log "(logcat -c 失败，继续)"
i=0
while [ "$i" -lt "$SEC_OFF" ]; do
    sleep 5
    i=$((i + 5))
    log "  …未连剩余 $((SEC_OFF - i))s"
done
PID_OFF=$(pidof "$PKG" 2>/dev/null || ps -A 2>/dev/null | grep -w "$PKG" | awk '{print $2}' | head -1)
log "宿主 pid（未连）=${PID_OFF:-（空=已退出/未找到）}"
logcat -d -v time > "$RAW_OFF" 2>/dev/null
log "原始 dump 已落盘：$RAW_OFF（行数=$(count_lines "$RAW_OFF")）"
log "status（未连）："
cat /data/local/tmp/tempctrl_b6x.status 2>/dev/null | tee -a "$OUT"
log ""

# ================= 阶段 2：提示用户开 App =================
log "################################################################"
log "#                                                              #"
log "#   现在请【打开 App（$PKG）】触发一次连接                      #"
log "#                                                              #"
log "################################################################"
log "  （倒计时 ${WAIT_ON}s：请在这一段内打开 App；开完不用关，脚本会继续采「已连」）"
i=0
while [ "$i" -lt "$WAIT_ON" ]; do
    sleep 5
    i=$((i + 5))
    log "  …开 App 倒计时 $((WAIT_ON - i))s"
done

# ================= 阶段 3：已连 =================
log ""
log "========== [3] 已连阶段（采 ${SEC_ON}s，覆盖你打开 App 那一刻）=========="
i=0
while [ "$i" -lt "$SEC_ON" ]; do
    sleep 5
    i=$((i + 5))
    log "  …已连剩余 $((SEC_ON - i))s"
done
PID_ON=$(pidof "$PKG" 2>/dev/null || ps -A 2>/dev/null | grep -w "$PKG" | awk '{print $2}' | head -1)
log "宿主 pid（已连）=${PID_ON:-（空=已退出/未找到）}"
log "（pid 与未连阶段不同 = 期间 App 进程重启过；相同 = 未重启）"
logcat -d -v time > "$RAW_ON" 2>/dev/null
log "原始 dump 已落盘：$RAW_ON（行数=$(count_lines "$RAW_ON")）"
log "status（已连）："
cat /data/local/tmp/tempctrl_b6x.status 2>/dev/null | tee -a "$OUT"

# ================= 分析段：全部对「原始 dump 文件」grep（不再二次 dump，消除假阴性）=================
log ""
log "========== [4] 模块 logcat（tag=$TAG_MOD，读原始文件）=========="
log "--- 未连阶段 ---"
grep -F "$TAG_MOD" "$RAW_OFF" 2>/dev/null | tail -40 | tee -a "$OUT"
log "--- 已连阶段 ---"
grep -F "$TAG_MOD" "$RAW_ON" 2>/dev/null | tail -40 | tee -a "$OUT"

log ""
log "========== [5] 宿主 SDK logcat（tag=$TAG_SDK；门禁被挡时的钥匙）=========="
log "--- 未连阶段 ---"
grep -F "$TAG_SDK" "$RAW_OFF" 2>/dev/null | tail -40 | tee -a "$OUT"
log "--- 已连阶段 ---"
grep -F "$TAG_SDK" "$RAW_ON" 2>/dev/null | tail -40 | tee -a "$OUT"

log ""
log "========== [6] dumpsys bluetooth_manager（连接/GATT Client/扫描）=========="
if command -v dumpsys >/dev/null 2>&1; then
    DUMP="$DIR/.bt_dumpsys.tmp"
    dumpsys bluetooth_manager > "$DUMP" 2>/dev/null
    log "--- 连接态（STATE_/ConnectionState）---"
    grep -iE "ConnectionState|STATE_CONNECTED|STATE_DISCONNECTED|STATE_CONNECTING" "$DUMP" 2>/dev/null | head -40 | tee -a "$OUT"
    log "--- GATT Client 段（v1 被 head 砍掉的关键证据）---"
    grep -inE "gatt client|client map|Client:|CONNECTING" "$DUMP" 2>/dev/null | head -60 | tee -a "$OUT"
    log "--- 扫描（自扫签名 = LOW_LATENCY + DeviceAddress）---"
    grep -inE "LOW_LATENCY|DeviceAddress=|Filter .* results|ScanMode=" "$DUMP" 2>/dev/null | tail -30 | tee -a "$OUT"
    rm -f "$DUMP" 2>/dev/null
else
    log "(dumpsys 不可用)"
fi

log ""
log "========== [7] 宿主 app 运行时权限（$PKG）=========="
if command -v dumpsys >/dev/null 2>&1; then
    dumpsys package "$PKG" 2>/dev/null | grep -iE "BLUETOOTH_CONNECT|BLUETOOTH_SCAN" | tee -a "$OUT"
fi

# ================= [8] 关键判定行摘录：全部 grep 同一份原始文件 =================
log ""
log "========== [8] 关键判定行摘录（对原始文件 grep，非二次 dump）=========="
log "--- 【钥匙】SDK 门禁被挡：gatt has been connected with other device ---"
grep -F "gatt has been connected with other device" "$RAW_ON" 2>/dev/null | tee -a "$OUT"
log "--- 模块 心跳 / 重连尝试（判断「循环在跑 vs 停了」）---"
grep -E "重连循环心跳|后台重连尝试" "$RAW_ON" 2>/dev/null | tee -a "$OUT"
log "--- 模块 设备锁死 ---"
grep -F "设备锁死" "$RAW_ON" 2>/dev/null | tee -a "$OUT"
log "--- 模块 自扫（R1/R2/R4 判别）---"
grep -E "自扫结束|自扫命中|硬自愈|地址不符|回调异常|取地址异常" "$RAW_ON" 2>/dev/null | tee -a "$OUT"
log "--- 模块 connect() 进入 / 退出 ---"
grep -E "connect\(\) 进入|connect\(\) 退出" "$RAW_ON" 2>/dev/null | tee -a "$OUT"
log "--- 模块 断连 ---"
grep -E "BLE 断联|BLE 已连接" "$RAW_ON" 2>/dev/null | tee -a "$OUT"
log "--- 模块 预探测 / R2 命中 / GATE-A / 异常留痕 / 状态自愈 ---"
grep -E "预探测|R2 命中|GATE-A|异常留痕|状态自愈" "$RAW_ON" 2>/dev/null | tee -a "$OUT"

log ""
log "判定指引："
log "  · 若【钥匙】行（gatt has been connected with other device）在你打开 App 那段反复出现"
log "    → 根因「共享控制器 mDataConnectState 门禁被占/卡死」得到实证。"
log "  · 若 status 出现 BLE=1 / dumpsys 出现 STATE_CONNECTED，但【钥匙】行也大量出现"
log "    → 门禁在「被挡」与「放行」间抖动（占用），对应「要等一段比较长的时间」。"
log "  · 若全程无【钥匙】行且 status 始终 BLE=0 → 门禁不是主因，转查 GATT Client 段 / 句柄 / 冻结。"
log "  · 若模块「重连循环心跳」缺失而自扫仍在跑 → 区分「循环停了」与「没尝试」（心跳 5min 限频，窗口需够长）。"
log ""

# 自证：原始文件是否有被环形缓冲轮转（未连与已连 dump 的行数对比）
log "自证：原始 dump 行数　未连=$(count_lines "$RAW_OFF")　已连=$(count_lines "$RAW_ON")"
log "（若「已连」行数明显小于「未连」且时间跨度更短，警惕缓冲轮转；必要时加大 logcat -G 后重抓）"

log ""
log "==================== 抓取完成 ===================="
log "结果：$OUT"
log "原始：$RAW_OFF　$RAW_ON"
