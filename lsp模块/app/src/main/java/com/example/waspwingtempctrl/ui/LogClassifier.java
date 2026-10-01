package com.example.waspwingtempctrl.ui;

import androidx.annotation.NonNull;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 日志分级判定（四类）。全部依据 C 端真实产出格式，不自行发明规则——规则与判据见
 * {@code app/逻辑说明.md} §8.2；关键词口径见 {@code app/逻辑说明.md} §8.3。
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
