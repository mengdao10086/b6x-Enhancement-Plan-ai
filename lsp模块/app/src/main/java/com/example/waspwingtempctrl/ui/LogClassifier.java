package com.example.waspwingtempctrl.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日志分级判定（四类 + 兜底）。全部依据真实日志措辞，不自行发明规则——判据口径
 * 见 {@code app/逻辑说明.md} §8.2。
 *
 * <p>判定顺序（先命中先返回，保证同一行结果确定）：
 * <ol>
 *   <li>先剔除良性短语（{@code 未见异常} / {@code 读取失败默认值} 等），并把
 *       {@code 无法判定} 记为「降级」后从文本中移除，避免被更强的 {@code 无法} 误判为错误；</li>
 *   <li>ERROR：中文硬错误词 + 英文整词（{@code failover} / {@code error_count} 不命中）；</li>
 *   <li>WARN：降级但继续（超时 / 跳过 / 重试 / 重连 / 断开等）；</li>
 *   <li>DEBUG：{@code [DEBUG]} / {@code [PID]} 前缀，以及「已钩住」这类正向钩子追踪行；</li>
 *   <li>其余交给调用方按行格式判 INFO / PLAIN。</li>
 * </ol>
 *
 * <p>{@link #merge} 供 LSPosed 来源使用：header 的级别字母先落一档，再用同一套关键词
 * 提升（只升不降），两个来源因此共用同一份语义。
 */
final class LogClassifier {

    /** 中文硬错误词。 */
    private static final String[] ERROR_WORDS_ZH = {
            "失败", "错误", "异常", "崩溃", "致命", "无法"
    };

    /**
     * 英文硬错误词：按「字母边界」匹配——中文紧贴英文（{@code 失败error}）也能命中，
     * 而 {@code failover} / {@code error_count} 这类子串不命中（下划线按字母处理）。
     */
    private static final Pattern ERROR_WORDS_EN = Pattern.compile(
            "(?<![A-Za-z_])(?:errors?|fail(?:ed|ing|ure|ures)?|fatal|panic(?:ked)?|abort(?:ed)?"
                    + "|exceptions?|crashed?|denied|refused|missing)(?![A-Za-z_])");

    /** 「无法判定」是降级但继续，先剔除再匹配，避免被 ERROR 词的「无法」升级。 */
    private static final String[] DEGRADED_PHRASES = {"无法判定", "无法判断", "无法确定"};

    /** 中文降级词（C 端与 LSPosed 模块共用的真实措辞）。 */
    private static final String[] WARN_WORDS_ZH = {
            "未生效", "超时", "未就绪", "断联", "断开", "丢失", "停滞",
            "强制停止", "跳过", "重试", "退化", "降级", "回落", "放弃",
            "重连", "待对齐", "不可用", "未起来", "未安装",
            "未钩住", "未 hook", "钩子未生效", "钩子异常"
    };

    /** 英文降级词；{@code timeout=} 这类配置键不算（负向前瞻排除紧跟 = / : 的写法）。 */
    private static final Pattern WARN_WORDS_EN = Pattern.compile(
            "(?<![A-Za-z_])(?:timeout|timed\\s+out|retry|retrying|retries|skip|skipped|skipping"
                    + "|fallback|degraded|reconnect(?:ed|ing)?|disconnect(?:ed)?|lost|stalled"
                    + "|unavailable|not\\s+ready)(?![A-Za-z_])(?!\\s*[=:])");

    /** 正向钩子追踪行：与 {@code [DEBUG]} / {@code [PID]} 同归调试档，不误染成告警。 */
    private static final String[] HOOK_TRACE_WORDS = {
            "已钩住", "已 hook", "hook 成功", "钩子已生效", "注入成功"
    };

    /** 良性否定 / 说明性短语：先剔除，避免「未见异常」「读取失败默认值」误染。 */
    private static final String[] BENIGN_PHRASES = {
            "未见异常", "无异常", "无明显异常", "未出现异常", "未发现异常", "未发现错误",
            "没有异常", "无错误", "没有错误",
            "读取失败默认值", "读取失败固定", "跳过启动首下"
    };

    /** 英文良性写法：{@code no error} / {@code error=0} / {@code failures=0}。 */
    private static final Pattern BENIGN_EN = Pattern.compile(
            "(?<![A-Za-z_])(?:no|not|without)\\s+(?:errors?|failures?)(?![A-Za-z_])"
                    + "|(?<![A-Za-z_])errors?\\s*[=:]\\s*0(?![A-Za-z_])"
                    + "|(?<![A-Za-z_])fail(?:ed|ures?)?\\s*[=:]\\s*0(?![A-Za-z_])");

    /** C 端调试分区前缀（tempctrl.c 中 debug_log / pid_log 两条宏写入的固定前缀）。 */
    private static final String DEBUG_PREFIX = "[DEBUG]";
    private static final String PID_PREFIX = "[PID]";

    /**
     * 上面两个前缀的小写形：{@link #specialLevel} 拿的是整行小写后的串来比对，故这里只留小写形。
     * 类初始化时算一次即可 —— 写成字段而不是在方法里调 {@code toLowerCase}，是为了不让每行都
     * 现造两个 String。
     */
    private static final String DEBUG_PREFIX_LOWER = DEBUG_PREFIX.toLowerCase(Locale.ROOT);
    private static final String PID_PREFIX_LOWER = PID_PREFIX.toLowerCase(Locale.ROOT);

    /** C 端时间戳行首格式（tempctrl.c 的 write_log() 所拼）：{@code [DD HH:MM:SS] }。 */
    private static final Pattern TIMESTAMP = Pattern.compile("^\\[\\d\\d \\d\\d:\\d\\d:\\d\\d\\] ");

    private LogClassifier() {
    }

    /** daemon 来源的整行分级：特殊语义 → 异常栈 → 带时间戳的普通行 → 兜底。 */
    @NonNull
    static LogLine.Level classify(@NonNull String line) {
        LogLine.Level special = specialLevel(line);
        if (special != null) {
            return special;
        }
        // 异常栈帧：C 端不产出，但日志里可能混入 am/dumpsys 的原样输出；裸 at 行不应留白
        if (isStackFrame(line)) {
            return LogLine.Level.ERROR;
        }
        if (TIMESTAMP.matcher(line).find()) {
            return LogLine.Level.INFO;
        }
        return LogLine.Level.PLAIN;
    }

    /**
     * 只做「特殊语义」判定，不判断时间戳 / 兜底格式，取不到返回 null。
     * LSPosed 来源的显示行没有 daemon 那种行首时间戳，靠本方法把关键词族叠加上去。
     */
    @Nullable
    static LogLine.Level specialLevel(@NonNull String line) {
        String trimmed = line.trim();
        // 续行里的异常栈根节点：本身没有中文/英文关键词，但语义是错误
        if (trimmed.startsWith("Caused by:") || trimmed.startsWith("Suppressed:")
                || (trimmed.startsWith("... ") && trimmed.endsWith(" more"))) {
            return LogLine.Level.ERROR;
        }
        String text = sanitize(line.toLowerCase(Locale.ROOT));

        boolean degraded = containsAny(text, DEGRADED_PHRASES);
        if (degraded) {
            text = removeAll(text, DEGRADED_PHRASES);
        }
        if (containsAny(text, ERROR_WORDS_ZH) || ERROR_WORDS_EN.matcher(text).find()) {
            return LogLine.Level.ERROR;
        }
        if (degraded || containsAny(text, WARN_WORDS_ZH) || WARN_WORDS_EN.matcher(text).find()) {
            return LogLine.Level.WARN;
        }
        if (text.contains(DEBUG_PREFIX_LOWER) || text.contains(PID_PREFIX_LOWER)
                || containsAny(text, HOOK_TRACE_WORDS)) {
            return LogLine.Level.DEBUG;
        }
        return null;
    }

    /**
     * 把「header 级别字母给出的档位」和「正文关键词给出的档位」合并：只升不降。
     *
     * @param header header 的级别字母（E/F→ERROR、W→WARN、D/V→DEBUG、I→INFO）
     * @param text   要匹配关键词的文本（header 用去前缀后的正文，续行用整行）
     */
    @NonNull
    static LogLine.Level merge(@NonNull LogLine.Level header, @NonNull String text) {
        LogLine.Level body = specialLevel(text);
        if (body == null) {
            return header;
        }
        if (body == LogLine.Level.ERROR || header == LogLine.Level.ERROR) {
            return LogLine.Level.ERROR;
        }
        if (body == LogLine.Level.WARN) {
            return LogLine.Level.WARN;
        }
        // 正文只是调试档（[DEBUG]/[PID]/钩子追踪）：header 已是告警就保留告警，否则落调试灰
        return header == LogLine.Level.WARN ? header : LogLine.Level.DEBUG;
    }

    /** 剔除良性短语与英文「无错误」写法；只对确实命中的行做替换，避免每行都造新串。 */
    private static String sanitize(String lowerLine) {
        String text = lowerLine;
        for (String phrase : BENIGN_PHRASES) {
            if (text.contains(phrase)) {
                text = text.replace(phrase, " ");
            }
        }
        Matcher matcher = BENIGN_EN.matcher(text);
        if (matcher.find()) {
            text = matcher.replaceAll(" ");
        }
        return text;
    }

    private static String removeAll(String text, String[] phrases) {
        for (String phrase : phrases) {
            if (text.contains(phrase)) {
                text = text.replace(phrase, " ");
            }
        }
        return text;
    }

    private static boolean containsAny(String lowerLine, String[] words) {
        for (String w : words) {
            if (lowerLine.contains(w)) {
                return true;
            }
        }
        return false;
    }

    /** 异常栈帧：{@code at foo(...)} / {@code Caused by:} / {@code Suppressed:} / {@code ... 3 more}。 */
    private static boolean isStackFrame(String line) {
        String text = line.trim();
        return text.startsWith("at ")
                || text.startsWith("Caused by:")
                || text.startsWith("Suppressed:")
                || (text.startsWith("... ") && text.endsWith(" more"));
    }
}
