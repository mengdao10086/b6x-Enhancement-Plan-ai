#!/system/bin/sh
# 阶段二真机采样：C-4 / C-5 / C-6 / R38 / R41
# 用法：sh 阶段二采样测试.sh（交互）
#       AUTO=1 sh 阶段二采样测试.sh（固定等待 15s）
# 输出：同目录 阶段二采样结果.log
# 每项独立：失败只跳过该项，不中断整体

DIR=$(cd "$(dirname "$0")" && pwd)
PATH="$PATH:/system/bin:/system/xbin:/sbin"
export PATH
OUT="$DIR/阶段二采样结果.log"
TMP="$DIR/.阶段二采样.tmp.$$"
TMP2="$DIR/.阶段二采样.tmp2.$$"
AUTO="${AUTO:-0}"
APP_PKG="${APP_PKG:-com.example.waspwingtempctrl}"
HOST_PKG="${HOST_PKG:-com.flydigi.waspwing}"
SUMMARY=""

: > "$OUT" 2>/dev/null || { printf '无法写 %s\n' "$OUT" >&2; exit 1; }
trap 'rm -f "$TMP" "$TMP2"' 0 2 15

log() { printf '%s\n' "$1" | tee -a "$OUT"; }
add_result() { SUMMARY="${SUMMARY}
$1 | $2 | $3"; }
skip_item() {
    log "[原始数据] 未采样（$2）"
    log "[判读] 跳过：$2"
    log "[期望] $3"
    add_result "$1" "$2" "跳过"
}
have() { command -v "$1" >/dev/null 2>&1; }

# ---------- 自检 ----------
log "==================== 阶段二采样 $(date '+%Y-%m-%d %H:%M:%S') ===================="
log "脚本目录：$DIR"
if [ "$AUTO" = "1" ]; then
    log "交互：AUTO=1（每项固定等待 15 秒）"
else
    log "交互：按回车开始；非交互终端自动等 15 秒"
fi
log ""

SU_OK=0
if have su; then
    if su -c id 2>/dev/null | grep -q 'uid=0'; then
        SU_OK=1
        log "[自检] su：可用（root）"
    else
        log "[自检] 跳过：su 不可用（未授权 root）"
    fi
else
    log "[自检] 跳过：缺 su"
fi

STRACE=$(command -v strace 2>/dev/null)
[ -n "$STRACE" ] || STRACE=$(su -c 'command -v strace' 2>/dev/null)
if [ -n "$STRACE" ]; then
    log "[自检] strace：$STRACE"
else
    log "[自检] 跳过：缺 strace（各项会提示 perfetto 降级）"
fi

HAVE_PIDOF=0
if have pidof; then
    HAVE_PIDOF=1
    log "[自检] pidof：可用"
else
    log "[自检] 跳过：缺 pidof（改用 ps 兜底）"
fi

HAVE_TIMEOUT=0
if have timeout; then
    HAVE_TIMEOUT=1
    log "[自检] timeout：可用"
else
    log "[自检] 跳过：缺 timeout（strace 项改用后台 kill）"
fi

if have dumpsys; then
    log "[自检] dumpsys：可用（本脚本不使用）"
else
    log "[自检] 跳过：缺 dumpsys（本脚本不使用）"
fi
log ""

perfetto_hint() {
    log "改用 perfetto（C2 §E 末尾）："
    log "  su -c 'perfetto -o /data/misc/perfetto-traces/p.pftrace -t 60s sched syscalls'"
    log "  拉回后按 comm 聚合同名事件；窗口时长按本项要求调整"
}

get_pid() {
    _pkg=$1
    _p=""
    if [ "$HAVE_PIDOF" = "1" ]; then
        _p=$(pidof "$_pkg" 2>/dev/null | awk '{print $1}')
    fi
    if [ -z "$_p" ] && [ "$SU_OK" = "1" ]; then
        _p=$(su -c "pidof $_pkg" 2>/dev/null | awk '{print $1}')
    fi
    if [ -z "$_p" ]; then
        _p=$(ps -A 2>/dev/null | grep -w "$_pkg" | awk '{print $2}' | head -n 1)
    fi
    printf '%s' "$_p"
}

run_strace() {
    _sec=$1
    _what=$2
    _pid=$3
    _out=$4
    : > "$_out"
    if [ "$HAVE_TIMEOUT" = "1" ]; then
        su -c "timeout $_sec $STRACE -f -ttt -e trace=$_what -p $_pid" > "$_out" 2>&1
    else
        su -c "$STRACE -f -ttt -e trace=$_what -p $_pid" > "$_out" 2>&1 &
        _bg=$!
        sleep "$_sec"
        kill "$_bg" 2>/dev/null
        sleep 1
    fi
}

strace_bad() {
    grep -qE 'Operation not permitted|Permission denied|No such process|Unable to attach|Could not attach|error creating process|ptrace\(' "$1" 2>/dev/null
}

count_pattern() {
    grep -cE "$1" "$2" 2>/dev/null | tr -d ' '
}

zone_seconds() {
    awk '/thermal_zone[0-9]*\/temp"/ {
        for (i = 1; i <= NF; i++) {
            if ($i ~ /^[0-9]+\.[0-9]+$/) { split($i, a, "."); print a[1]; break }
        }
    }' "$1" | sort -u | wc -l | tr -d ' '
}

guide() {
    log ""
    log "------------------------------------------------------------"
    log "[$1] 操作：$2"
    log "采样窗口：$3 秒"
    if [ "$AUTO" = "1" ]; then
        log "AUTO=1：固定等待 15 秒后开始采样"
        sleep 15
    elif [ -t 0 ]; then
        log "准备好后按回车开始（回车后等 3 秒采样）"
        read -r _
        sleep 3
    else
        log "非交互终端：等待 15 秒后开始采样"
        sleep 15
    fi
}

# ============================================================
# 1/5 C-4 / R02 状态页探针频率
# 验证：状态页 root 探针频率（60s 内 su execve 次数）
# 期望：≈2/60s（30s 闸门）或 4–6/60s（10–15s TTL）
# 判读：8–20 次/60s → 5s 一趟（R02 未生效）
# ============================================================
log ""
log "########## 1/5 C-4 / R02 状态页探针频率 ##########"
guide "1/5 C-4/R02 状态页探针" "请切到 app 的『状态』页并停留" 60
PID=$(get_pid "$APP_PKG")
EXP="≈2/60s（30s 闸门）或 4–6/60s（10–15s TTL）"
if [ -z "$PID" ]; then
    skip_item "C-4/R02 状态页探针" "app 未运行（$APP_PKG）" "$EXP"
elif [ "$SU_OK" != "1" ]; then
    skip_item "C-4/R02 状态页探针" "缺 su/root" "$EXP"
elif [ -z "$STRACE" ]; then
    perfetto_hint
    skip_item "C-4/R02 状态页探针" "缺 strace" "$EXP"
else
    log "app pid=$PID，开始 60 s 采样（execve）"
    run_strace 60 execve "$PID" "$TMP"
    if strace_bad "$TMP"; then
        perfetto_hint
        skip_item "C-4/R02 状态页探针" "strace attach 失败" "$EXP"
    elif [ ! -s "$TMP" ]; then
        perfetto_hint
        skip_item "C-4/R02 状态页探针" "strace 无输出" "$EXP"
    else
        N=$(count_pattern 'execve\(.*su' "$TMP")
        STRICT=$(count_pattern 'execve\("[^"]*/su"' "$TMP")
        ALL=$(count_pattern 'execve\(' "$TMP")
        log "[原始数据] 60 s 窗口：execve 总数=$ALL，含 su 的 execve=$N 次（路径直指 su=$STRICT）"
        grep -E 'execve\(.*su' "$TMP" | head -n 3 | sed 's/^/  样本：/' | tee -a "$OUT"
        if [ "$ALL" -eq 0 ]; then
            J="跳过：无 execve（状态页未打开或探针已停）"
        elif [ "$N" -ge 8 ] && [ "$N" -le 20 ]; then
            J="FAIL：≈5 s/趟，R02 未生效"
        elif [ "$N" -ge 3 ] && [ "$N" -le 7 ]; then
            J="PASS：10–15 s TTL 生效"
        elif [ "$N" -le 2 ]; then
            J="PASS：30 s 闸门生效（0 次需确认状态页已打开）"
        else
            J="FAIL：高于 5 s 频率（$N/60s）"
        fi
        log "[判读] $J"
        log "[期望] ≈2/60s（30s 闸门）或 4–6/60s（10–15s TTL）；≈12/60s 为 5s 未优化"
        add_result "C-4/R02 状态页探针" "${N}次/60s" "${J%%：*}"
    fi
fi

# ============================================================
# 2/5 C-5 / R03 lite 后台轮询
# 验证：切后台后 app 是否仍读曲线数据文件
# 期望：≈0/120s（已暂停或被节流）
# 判读：>60 次/120s → 仍在轮询
# ============================================================
log ""
log "########## 2/5 C-5 / R03 lite 后台轮询 ##########"
guide "2/5 C-5/R03 lite 后台轮询" "请把 app 切到后台（回到桌面），保持 120 秒" 120
PID=$(get_pid "$APP_PKG")
EXP="≈0/120s（切后台后暂停）；>60/120s 为仍在轮询"
if [ -z "$PID" ]; then
    skip_item "C-5/R03 后台轮询" "app 未运行（$APP_PKG）" "$EXP"
elif [ "$SU_OK" != "1" ]; then
    skip_item "C-5/R03 后台轮询" "缺 su/root" "$EXP"
elif [ -z "$STRACE" ]; then
    perfetto_hint
    skip_item "C-5/R03 后台轮询" "缺 strace" "$EXP"
else
    log "app pid=$PID，开始 120 s 采样（openat）"
    run_strace 120 openat "$PID" "$TMP"
    if strace_bad "$TMP"; then
        perfetto_hint
        skip_item "C-5/R03 后台轮询" "strace attach 失败" "$EXP"
    elif [ ! -s "$TMP" ]; then
        perfetto_hint
        skip_item "C-5/R03 后台轮询" "strace 无输出" "$EXP"
    else
        N=$(count_pattern 'tempctrl_webui\.data' "$TMP")
        log "[原始数据] 120 s 窗口：openat tempctrl_webui.data=$N 次"
        grep 'tempctrl_webui\.data' "$TMP" | head -n 3 | sed 's/^/  样本：/' | tee -a "$OUT"
        if [ "$N" -le 10 ]; then
            J="PASS：≈0，后台轮询已暂停/被节流"
        elif [ "$N" -gt 60 ]; then
            J="FAIL：>60/120s，仍在轮询"
        else
            J="FAIL：$N/120s，未达到 ≈0"
        fi
        log "[判读] $J"
        log "[期望] ≈0/120s（切后台后暂停）；>60/120s 为仍在轮询"
        add_result "C-5/R03 后台轮询" "${N}次/120s" "${J%%：*}"
    fi
fi

# ============================================================
# 3/5 C-6 / R05 模块空闲唤醒
# 验证：宿主 app 60s 内 voluntary_ctxt_switches 差分
# 期望：基线 ≈1200/60s（20 Hz）；R05 目标 ≈600–750/60s
# 判读：≥1000 → 20 Hz 空转（R05 未生效）
# ============================================================
log ""
log "########## 3/5 C-6 / R05 模块空闲唤醒 ##########"
guide "3/5 C-6/R05 模块空闲唤醒" "请保持宿主 app 在后台空闲，不要操作" 60
PID=$(get_pid "$HOST_PKG")
EXP="基线 ≈1200/60s（20 Hz）；R05 目标 ≈600–750/60s（80–100 ms）"
if [ -z "$PID" ]; then
    skip_item "C-6/R05 空闲唤醒" "宿主 app 未运行（$HOST_PKG）" "$EXP"
elif [ "$SU_OK" != "1" ]; then
    skip_item "C-6/R05 空闲唤醒" "缺 su/root" "$EXP"
else
    A=$(su -c "grep '^voluntary_ctxt_switches' /proc/$PID/status" 2>/dev/null | awk '{print $2}')
    case "$A" in
        ''|*[!0-9]*)
            A=""
            ;;
    esac
    if [ -z "$A" ]; then
        skip_item "C-6/R05 空闲唤醒" "读取 voluntary_ctxt_switches 失败" "$EXP"
    else
        log "宿主 pid=$PID；60 s 窗口前 voluntary_ctxt_switches=$A"
        log "采样中（60 s），请勿操作设备…"
        i=0
        while [ "$i" -lt 60 ]; do
            sleep 15
            i=$((i + 15))
            log "  …剩余 $((60 - i))s"
        done
        B=$(su -c "grep '^voluntary_ctxt_switches' /proc/$PID/status" 2>/dev/null | awk '{print $2}')
        case "$B" in
            ''|*[!0-9]*)
                skip_item "C-6/R05 空闲唤醒" "采样结束时进程退出或读取失败" "$EXP"
                B=""
                ;;
        esac
        if [ -n "$B" ]; then
            DIFF=$((B - A))
            log "[原始数据] 60 s 窗口差分=$DIFF（前 $A → 后 $B）"
            if [ "$DIFF" -lt 0 ]; then
                J="跳过：计数器回退（进程重启）"
            elif [ "$DIFF" -ge 1000 ]; then
                J="FAIL：≈20 Hz 空转（R05 未生效）"
            elif [ "$DIFF" -ge 450 ]; then
                J="PASS：80–100 ms 档（R05 生效）"
            else
                J="PASS：低于 80–100 ms 档（需确认 app 是否活跃）"
            fi
            log "[判读] $J"
            log "[期望] 基线 ≈1200/60s（20 Hz）；R05 目标 ≈600–750/60s（80–100 ms）"
            add_result "C-6/R05 空闲唤醒" "${DIFF}次/60s" "${J%%：*}"
        fi
    fi
fi

# ============================================================
# 4/5 R41 zone 常驻 fd
# 验证：60s 内 tempctrl 打开 thermal_zone*/temp 次数
# 期望：稳态 ≈0；仅首次扫描或名单变化有 ≤12 次短突发
# 判读：跨多秒逐次 open → 常驻 fd 未生效
# ============================================================
log ""
log "########## 4/5 R41 zone 常驻 fd ##########"
guide "4/5 R41 zone 常驻 fd" "请保持设备空闲、亮屏，确认 tempctrl 守护进程运行" 60
PID=$(get_pid tempctrl)
EXP="稳态 ≈0/60s；仅首次扫描或名单变化有短突发（≤12 次）"
if [ -z "$PID" ]; then
    skip_item "R41 zone 常驻 fd" "tempctrl 未运行" "$EXP"
elif [ "$SU_OK" != "1" ]; then
    skip_item "R41 zone 常驻 fd" "缺 su/root" "$EXP"
elif [ -z "$STRACE" ]; then
    perfetto_hint
    skip_item "R41 zone 常驻 fd" "缺 strace" "$EXP"
else
    log "tempctrl pid=$PID，开始 60 s 采样（openat）"
    run_strace 60 openat "$PID" "$TMP"
    if strace_bad "$TMP"; then
        perfetto_hint
        skip_item "R41 zone 常驻 fd" "strace attach 失败" "$EXP"
    elif [ ! -s "$TMP" ]; then
        perfetto_hint
        skip_item "R41 zone 常驻 fd" "strace 无输出" "$EXP"
    else
        N=$(count_pattern 'thermal_zone[0-9]*/temp"' "$TMP")
        SEC=$(zone_seconds "$TMP")
        log "[原始数据] 60 s 窗口：zone temp openat=$N 次，分布在 $SEC 个秒"
        grep 'thermal_zone[0-9]*/temp"' "$TMP" | head -n 3 | sed 's/^/  样本：/' | tee -a "$OUT"
        if [ "$N" -eq 0 ]; then
            J="PASS：常驻 fd 生效（60s 0 open）"
        elif [ "$N" -le 12 ] && [ "$SEC" -le 2 ]; then
            J="PASS：仅名单重开突发（$N 次/$SEC 秒），常驻 fd 生效"
        else
            J="FAIL：仍在逐次 open（$N 次/$SEC 秒）"
        fi
        log "[判读] $J"
        log "[期望] 稳态 ≈0/60s；仅首次扫描或名单变化有短突发（≤12 次）"
        add_result "R41 zone 常驻 fd" "${N}次/60s（${SEC}秒）" "${J%%：*}"
    fi
fi

# ============================================================
# 5/5 R38 BT_REQ 5s 门
# 验证：60s 内 tempctrl 打开 bt_req 文件次数
# 期望：≤15/60s（5s 门 ≈12）
# 判读：≈60/60s → 5s 门未生效
# ============================================================
log ""
log "########## 5/5 R38 BT_REQ 5s 门 ##########"
guide "5/5 R38 BT_REQ 5s 门" "请保持设备空闲，确认 tempctrl 守护进程运行" 60
PID=$(get_pid tempctrl)
EXP="≤15/60s（5 s 门 ≈12）；≈60/60s 为未生效"
if [ -z "$PID" ]; then
    skip_item "R38 BT_REQ 5s 门" "tempctrl 未运行" "$EXP"
elif [ "$SU_OK" != "1" ]; then
    skip_item "R38 BT_REQ 5s 门" "缺 su/root" "$EXP"
elif [ -z "$STRACE" ]; then
    perfetto_hint
    skip_item "R38 BT_REQ 5s 门" "缺 strace" "$EXP"
else
    log "tempctrl pid=$PID，开始 60 s 采样（openat）"
    run_strace 60 openat "$PID" "$TMP"
    if strace_bad "$TMP"; then
        perfetto_hint
        skip_item "R38 BT_REQ 5s 门" "strace attach 失败" "$EXP"
    elif [ ! -s "$TMP" ]; then
        perfetto_hint
        skip_item "R38 BT_REQ 5s 门" "strace 无输出" "$EXP"
    else
        N=$(count_pattern 'tempctrl_bt_req' "$TMP")
        log "[原始数据] 60 s 窗口：bt_req openat=$N 次"
        grep 'tempctrl_bt_req' "$TMP" | head -n 3 | sed 's/^/  样本：/' | tee -a "$OUT"
        if [ "$N" -eq 0 ]; then
            J="跳过：0 次（未观测到 BT_REQ 轮询）"
        elif [ "$N" -le 15 ]; then
            J="PASS：5 s 门生效（≈12/60s）"
        elif [ "$N" -ge 45 ]; then
            J="FAIL：≈60/60s，5 s 门未生效"
        else
            J="FAIL：高于 5 s 门（$N/60s）"
        fi
        log "[判读] $J"
        log "[期望] ≤15/60s（5 s 门 ≈12）；≈60/60s 为未生效"
        add_result "R38 BT_REQ 5s 门" "${N}次/60s" "${J%%：*}"
    fi
fi

# ---------- 汇总 ----------
log ""
log "==================== 汇总 ===================="
log "项名 | 实测 | 结论"
printf '%s\n' "$SUMMARY" | tee -a "$OUT"
log ""
log "结果文件：$OUT"
exit 0
