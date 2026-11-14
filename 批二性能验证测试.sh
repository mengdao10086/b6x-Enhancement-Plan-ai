#!/system/bin/sh
# 批二真机性能验证：R44 曲线页帧时间 / R43 KI 行轮询基线
# 用法：sh 批二性能验证测试.sh（交互）
#       AUTO=1 sh 批二性能验证测试.sh（固定等待 15s）
# 输出：同目录 批二性能验证结果.log
# 每项独立：失败只跳过该项，不中断整体

DIR=$(cd "$(dirname "$0")" && pwd)
PATH="$PATH:/system/bin:/system/xbin:/sbin"
export PATH
OUT="$DIR/批二性能验证结果.log"
TMP="$DIR/.批二性能验证.tmp.$$"
TMP2="$DIR/.批二性能验证.tmp2.$$"
AUTO="${AUTO:-0}"
APP_PKG="${APP_PKG:-com.example.waspwingtempctrl}"
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
log "==================== 批二性能验证 $(date '+%Y-%m-%d %H:%M:%S') ===================="
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
    log "[自检] 跳过：缺 strace（R43 会提示 perfetto 降级）"
fi

HAVE_PIDOF=0
if have pidof; then
    HAVE_PIDOF=1
    log "[自检] pidof：可用"
else
    log "[自检] 跳过：缺 pidof（改用 ps 兜底）"
fi

if have dumpsys; then
    HAVE_DUMPSYS=1
    log "[自检] dumpsys：可用"
else
    HAVE_DUMPSYS=0
    log "[自检] 跳过：缺 dumpsys（R44 跳过）"
fi

HAVE_TIMEOUT=0
if have timeout; then
    HAVE_TIMEOUT=1
    log "[自检] timeout：可用"
else
    log "[自检] 跳过：缺 timeout（strace 项改用后台 kill）"
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

pct() {
    awk -v p="$1" '{a[NR]=$1} END {
        n=NR
        if (n==0) { print ""; exit }
        i=int(n*p/100+0.999)
        if (i<1) i=1
        if (i>n) i=n
        printf "%.2f", a[i]
    }' "$TMP2"
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
# 1/2 R44 曲线页帧时间
# 验证：曲线页停留 60s 的帧时间分布与 janky 比例
# 期望：P90 ≤16.7ms、janky ≤5%（参考阈值，非硬指标）
# 判读：帧行数为 0 视为页面未打开或无法解析
# ============================================================
log ""
log "########## 1/2 R44 曲线页帧时间 ##########"
guide "1/2 R44 曲线页帧时间" "请进入 app 的『曲线』页并停留 60 秒" 60
PID=$(get_pid "$APP_PKG")
EXP="P90 ≤16.7ms、janky ≤5%（参考阈值，非硬指标）"
if [ -z "$PID" ]; then
    skip_item "R44 曲线页帧时间" "app 未运行（$APP_PKG）" "$EXP"
elif [ "$HAVE_DUMPSYS" != "1" ]; then
    skip_item "R44 曲线页帧时间" "缺 dumpsys" "$EXP"
else
    log "app pid=$PID，先 reset 帧统计"
    dumpsys gfxinfo "$APP_PKG" reset > "$TMP" 2>&1
    log "开始 60 s 采样（保持曲线页前台）"
    i=0
    while [ "$i" -lt 60 ]; do
        sleep 15
        i=$((i + 15))
        log "  …剩余 $((60 - i))s"
    done
    dumpsys gfxinfo "$APP_PKG" framestats > "$TMP" 2>&1

    TOTAL=$(grep -m1 'Total frames rendered:' "$TMP" | sed 's/.*: *//')
    JANKLINE=$(grep -m1 'Janky frames:' "$TMP" | sed 's/^ *//')
    [ -n "$TOTAL" ] || TOTAL="（未解析到）"
    [ -n "$JANKLINE" ] || JANKLINE="（未解析到）"

    # 帧时长取 FrameCompleted - IntendedVsync（ms），过滤异常值
    awk -F, '
        /Flags,/ {
            iv=0; fc=0
            for (i=1; i<=NF; i++) {
                gsub(/ /, "", $i)
                if ($i == "IntendedVsync") iv=i
                if ($i == "FrameCompleted") fc=i
            }
            next
        }
        iv && fc && $1 ~ /^[0-9]+$/ && NF >= fc {
            d=($fc-$iv)/1000000.0
            if (d > 0 && d < 1000) print d
        }
    ' "$TMP" | sort -n > "$TMP2"
    ROWS=$(wc -l < "$TMP2" 2>/dev/null | tr -d ' ')

    if [ -z "$ROWS" ] || [ "$ROWS" -eq 0 ]; then
        log "[原始数据] Total frames rendered=${TOTAL}，Janky=${JANKLINE}"
        log "[原始数据] 60 s 窗口：可解析帧行=0"
        log "[判读] 跳过：无帧行（页面未打开/画面静止或 framestats 无 FrameCompleted 列）"
        log "[期望] 60 s 曲线页持续刷新；P90 ≤16.7ms、janky ≤5%（参考）"
        add_result "R44 曲线页帧时间" "无帧行" "跳过"
    else
        P90=$(pct 90)
        P95=$(pct 95)
        P99=$(pct 99)
        JC=$(awk '$1>16.67 {n++} END {print n+0}' "$TMP2")
        JPCT=$(awk -v n="$JC" -v t="$ROWS" 'BEGIN {if (t>0) printf "%.1f", n*100/t; else print "0"}')

        log "[原始数据] 60 s 窗口：帧行=$ROWS，Total frames rendered=${TOTAL}"
        log "[原始数据] dumpsys Janky=${JANKLINE}；按 >16.67ms 计 janky=${JC}（${JPCT}%）"
        log "[原始数据] 帧时长分位：P90=${P90}ms P95=${P95}ms P99=${P99}ms"

        if awk -v p="$P90" -v j="$JPCT" 'BEGIN {exit !(p <= 16.7 && j <= 5)}'; then
            J="PASS：P90≤16.7ms 且 janky≤5%"
        else
            J="FAIL：帧时间或 janky 超参考阈值"
        fi
        log "[判读] $J"
        log "[期望] P90 ≤16.7ms、janky ≤5%（参考阈值，非硬指标）"
        add_result "R44 曲线页帧时间" "${ROWS}帧/jank${JC}（${JPCT}%）/P90 ${P90}ms" "${J%%：*}"
    fi
fi

# ============================================================
# 2/2 R43 KI 行轮询基线
# 验证：KI 表可见时 app 60s 内读数据文件次数
# 期望：≈60/60s（1 Hz，R43 决策基线）
# 判读：0 次 = 行未激活/不可见，按跳过处理
# ============================================================
log ""
log "########## 2/2 R43 KI 行轮询基线 ##########"
guide "2/2 R43 KI 行轮询基线" "请进入含 KI 表的参数页，让表型键所在行可见并停留 60 秒" 60
PID=$(get_pid "$APP_PKG")
EXP="≈60/60s（1 Hz）；该值为 R43 决策基线"
if [ -z "$PID" ]; then
    skip_item "R43 KI 行轮询" "app 未运行（$APP_PKG）" "$EXP"
elif [ "$SU_OK" != "1" ]; then
    skip_item "R43 KI 行轮询" "缺 su/root" "$EXP"
elif [ -z "$STRACE" ]; then
    perfetto_hint
    skip_item "R43 KI 行轮询" "缺 strace" "$EXP"
else
    log "app pid=$PID，开始 60 s 采样（openat）"
    run_strace 60 openat "$PID" "$TMP"
    if strace_bad "$TMP"; then
        perfetto_hint
        skip_item "R43 KI 行轮询" "strace attach 失败" "$EXP"
    elif [ ! -s "$TMP" ]; then
        perfetto_hint
        skip_item "R43 KI 行轮询" "strace 无输出" "$EXP"
    else
        N=$(count_pattern 'tempctrl_webui\.data' "$TMP")
        log "[原始数据] 60 s 窗口：openat tempctrl_webui.data=$N 次"
        grep 'tempctrl_webui\.data' "$TMP" | head -n 3 | sed 's/^/  样本：/' | tee -a "$OUT"
        if [ "$N" -eq 0 ]; then
            J="跳过：0 次（KI 行未激活/不可见，或 UI_TEMP_STOP 未开）"
        elif [ "$N" -ge 40 ] && [ "$N" -le 80 ]; then
            J="PASS：1 Hz 基线成立"
        elif [ "$N" -lt 40 ]; then
            J="FAIL：低于 1 Hz（$N/60s）"
        else
            J="FAIL：高于 1 Hz（$N/60s）"
        fi
        log "[判读] $J"
        log "[期望] ≈60/60s（1 Hz）；该值为 R43 决策基线"
        add_result "R43 KI 行轮询" "${N}次/60s" "${J%%：*}"
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
