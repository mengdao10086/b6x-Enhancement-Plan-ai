package com.example.waspwingtempctrl.ui;

import androidx.annotation.NonNull;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 日志分级判定（四类）。全部依据 C 端真实产出格式，不自行发明规则。
 *
 * <p><b>C 端行格式</b>（{@code lsp模块/daemon/tempctrl.c}）：
 * <pre>
 *   [DD HH:MM:SS] &lt;正文&gt;
 * </pre>
 * 由 {@code write_log()} 拼出：{@code snprintf(ts, ...)} 生成时间戳、
 * {@code fprintf} 用 {@code "[%s] "} 在前后加方括号并跟一个空格、末尾再补一个换行。
 * 因此<b>每一行都以 {@code [DD HH:MM:SS] } 开头</b>，正文只可能是下面几种：
 *
 * <ol>
 *   <li>{@code [DEBUG] ...} —— {@code debug_log} 宏加的固定前缀 {@code "[DEBUG] "}；
 *       宏自身要求 {@code debug_mode=1} 且对应分区开关=1（{@code debug_mode} 为文件级总开关，
 *       另有 7 个分区开关，如 {@code debug_pid}）。</li>
 *   <li>{@code [PID] ...} —— {@code pid_log} 宏加的固定前缀 {@code "[PID] "}，
 *       要求 {@code debug_mode=1 && debug_pid=1}。</li>
 *   <li>其余为常规输出，例如 {@code main()} 启动段的「脚本启动成功」、
 *       {@code reconnect_align()} 恢复对齐分支的「重连 PID 状态已重置，进入待对齐」。</li>
 * </ol>
 *
 * <p><b>四类判定规则（按此优先级短路）</b>：
 * <ol>
 *   <li><b>ERROR</b>：正文含 {@code 失败|错误|无法|异常|error|fail}（不区分大小写）。
 *       关键词口径见 {@code lsp模块/daemon/逻辑说明.md} 的「日志页」一节。
 *       C 端实例：{@code send_am_broadcast()} 的 fork 失败分支、
 *       {@code create_status_files()} 的状态文件创建失败分支、
 *       {@code load_config()} 的配置打开失败分支。</li>
 *   <li><b>WARN</b>：正文含 {@code 未生效|超时|未就绪|断联|断开|丢失|停滞|强制}
 *       —— 均为 C 端「降级/异常但继续运行」的措辞。
 *       C 端实例：{@code send_am_broadcast()} 的 am broadcast 超时、
 *       {@code try_align_actual()} 的回传超时用保守值起步分支、
 *       {@code reconnect_align()} 的两条断联分支（回传冷/RPM 汇总行、短断联保留 PID 状态行）、
 *       {@code watchdog_check()} 的锁死自动重启（实际制冷停滞）分支、
 *       {@code force_kill_and_relaunch()} 的锁死自动重启（强制停止并重新拉起）分支。</li>
 *   <li><b>DEBUG</b>：正文含 {@code [DEBUG]} 或 {@code [PID]}（{@code debug_log} / {@code pid_log}
 *       两条宏的固定前缀）。两类同归一档：它们同受 {@code debug_mode} 总开关约束，属分区调试追踪；
 *       且颜色标尺只提供了一档调试色（{@code @color/log_level_debug}）。</li>
 *   <li><b>INFO</b>：以 {@code [DD HH:MM:SS] } 开头的正常行（即 {@code write_log()} 的时间戳格式）。</li>
 *   <li><b>PLAIN</b>：都不满足（如尾部半行、空行）→ 界面用普通前景色渲染。</li>
 * </ol>
 *
 * <p><b>为什么严重级别先于 [DEBUG]/[PID] 前缀判定</b>：两者确有交集，例如
 * {@code rescan_cpu_zones()} 的
 * {@code debug_log(debug_sensor, "thermal_zone 扫描 无可读 zone（路径 %s），CPU 紧急无法触发", ...)}
 * 与 {@code rate_limited_execute()} 的
 * {@code debug_log(debug_exec, "实际值未就绪（冷%d rpm%d），跳过下发", ...)}。
 * 这类行本身就是异常信号，按严重级别着色比按前缀涂成调试灰更有用。
 */
final class LogClassifier {

    /** 错误关键词。 */
    private static final String[] ERROR_WORDS = {
            "失败", "错误", "无法", "异常", "error", "fail"
    };

    /** 警告关键词（C 端「降级但继续」措辞）。 */
    private static final String[] WARN_WORDS = {
            "未生效", "超时", "未就绪", "断联", "断开", "丢失", "停滞", "强制"
    };

    /** C 端调试分区前缀（tempctrl.c 中 debug_log / pid_log 两条宏写入的固定前缀）。 */
    private static final String DEBUG_PREFIX = "[DEBUG]";
    private static final String PID_PREFIX = "[PID]";

    /**
     * 上面两个前缀的小写形：{@link #classify} 拿的是整行小写后的串来比对，故这里只留小写形。
     * 类初始化时算一次即可 —— 写成字段而不是在方法里调 {@code toLowerCase}，是为了不让每行都
     * 现造两个 String（{@code String.toLowerCase} 不是编译期常量表达式，JIT 也不会替你折叠）。
     */
    private static final String DEBUG_PREFIX_LOWER = DEBUG_PREFIX.toLowerCase(Locale.ROOT);
    private static final String PID_PREFIX_LOWER = PID_PREFIX.toLowerCase(Locale.ROOT);

    /** C 端时间戳行首格式（tempctrl.c 的 write_log() 所拼）：{@code [DD HH:MM:SS] }。 */
    private static final Pattern TIMESTAMP = Pattern.compile("^\\[\\d\\d \\d\\d:\\d\\d:\\d\\d\\] ");

    private LogClassifier() {
    }

    @NonNull
    static LogLine.Level classify(@NonNull String line) {
        String lower = line.toLowerCase(Locale.ROOT);
        if (containsAny(lower, ERROR_WORDS)) {
            return LogLine.Level.ERROR;
        }
        if (containsAny(lower, WARN_WORDS)) {
            return LogLine.Level.WARN;
        }
        if (lower.contains(DEBUG_PREFIX_LOWER) || lower.contains(PID_PREFIX_LOWER)) {
            return LogLine.Level.DEBUG;
        }
        if (TIMESTAMP.matcher(line).find()) {
            return LogLine.Level.INFO;
        }
        return LogLine.Level.PLAIN;
    }

    private static boolean containsAny(String lowerLine, String[] words) {
        for (String w : words) {
            if (lowerLine.contains(w)) {
                return true;
            }
        }
        return false;
    }
}
