package com.example.waspwingtempctrl.ui;

import androidx.annotation.NonNull;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 日志分级判定（四类）。全部依据 C 端真实产出格式，不自行发明规则。
 *
 * <p><b>C 端行格式</b>（{@code magisk模块(智能温控)/tempctrl.c}）：
 * <pre>
 *   [DD HH:MM:SS] &lt;正文&gt;
 * </pre>
 * 时间戳由 {@code write_log()} 的 {@code snprintf(ts, ...)} 打印（第 926 行），
 * 前后加方括号并跟一个空格（第 927 行），正文后补换行（第 934 行）。
 * 因此<b>每一行都以 {@code [DD HH:MM:SS] } 开头</b>，正文只可能是下面几种：
 *
 * <ol>
 *   <li>{@code [DEBUG] ...} —— {@code debug_log} 宏加的固定前缀（第 406 行），
 *       且要求 {@code debug_mode=1} 与对应分区开关=1（第 404~410 行；开关定义见第 178 行）。</li>
 *   <li>{@code [PID] ...} —— {@code pid_log} 宏加的固定前缀（第 407~410 行），
 *       要求 {@code debug_mode=1 && debug_pid=1}。</li>
 *   <li>其余为常规输出，例如「脚本启动成功」（第 2759 行）、
 *       「重连 PID 状态已重置，进入待对齐」（第 2470 行）。</li>
 * </ol>
 *
 * <p><b>四类判定规则（按此优先级短路）</b>：
 * <ol>
 *   <li><b>ERROR</b>：正文含 {@code 失败|错误|无法|异常|error|fail}（不区分大小写）。
 *       关键词口径见 {@code 逻辑说明.md} 的「日志页」一节。
 *       C 端实例：{@code write_log("fork 失败，跳过下发")}（第 1398 行）、
 *       {@code write_log("状态文件 创建失败 %s")}（第 998 行）、
 *       {@code write_log("配置 无法打开 %s")}（第 721 行）。</li>
 *   <li><b>WARN</b>：正文含 {@code 拒绝|未生效|打折|超时|未就绪|断联|断开|丢失|停滞|强制}
 *       —— 均为 C 端「降级/异常但继续运行」的措辞。
 *       C 端实例：{@code write_log("配置 PID_KI_DYN_T 拒绝（%s）：... 未生效")}（第 619、639、656 行）、
 *       {@code write_log("配置 PID_KI_DYN_T M=%d > T2=%d，方向机制效果打折（不拦）")}（第 626 行）、
 *       {@code write_log("am broadcast 超时")}（第 1432 行）、
 *       {@code write_log("回传超时（>%ds）未就绪，用保守值起步 ...")}（第 2426 行）、
 *       {@code write_log("重连 断联%d秒 ...")}（第 2453 行）、
 *       {@code write_log("锁死自动重启 实际制冷 %d 停滞 ...")}（第 1839 行）、
 *       {@code write_log("锁死自动重启 强制停止 %s 并重新拉起")}（第 1776 行）。</li>
 *   <li><b>DEBUG</b>：正文含 {@code [DEBUG]} 或 {@code [PID]}（第 406、407 行两个宏的固定前缀）。
 *       两类同归一档：它们同受 {@code debug_mode} 总开关约束，属分区调试追踪；
 *       且颜色标尺只提供了一档调试色（{@code @color/log_level_debug}）。</li>
 *   <li><b>INFO</b>：以 {@code [DD HH:MM:SS] } 开头的正常行（第 926~927 行的格式）。</li>
 *   <li><b>PLAIN</b>：都不满足（如尾部半行、空行）→ 界面用普通前景色渲染。</li>
 * </ol>
 *
 * <p><b>为什么严重级别先于 [DEBUG]/[PID] 前缀判定</b>：两者确有交集，
 * 例如 {@code debug_log(debug_sensor, "thermal_zone 扫描 无可读 zone（路径 %s），CPU 紧急无法触发", ...)}
 * （第 1270 行）与 {@code debug_log(debug_exec, "实际值未就绪（冷%d rpm%d），跳过下发", ...)}（第 2483 行）。
 * 这类行本身就是异常信号，按严重级别着色比按前缀涂成调试灰更有用。
 */
final class LogClassifier {

    /** 错误关键词。 */
    private static final String[] ERROR_WORDS = {
            "失败", "错误", "无法", "异常", "error", "fail"
    };

    /** 警告关键词（C 端「降级但继续」措辞）。 */
    private static final String[] WARN_WORDS = {
            "拒绝", "未生效", "打折", "超时", "未就绪", "断联", "断开", "丢失", "停滞", "强制"
    };

    /** C 端调试分区前缀（tempctrl.c:406 / 407）。 */
    private static final String DEBUG_PREFIX = "[DEBUG]";
    private static final String PID_PREFIX = "[PID]";

    /** C 端时间戳行首格式（tempctrl.c:926~927）：{@code [DD HH:MM:SS] }。 */
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
        if (lower.contains(DEBUG_PREFIX.toLowerCase(Locale.ROOT))
                || lower.contains(PID_PREFIX.toLowerCase(Locale.ROOT))) {
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
