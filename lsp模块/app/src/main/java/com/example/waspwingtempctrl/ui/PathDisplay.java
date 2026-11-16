package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;

import java.util.regex.Matcher;

/**
 * 文件路径的全局显示口径（参数 {@code UI_FULL_PATH}）：
 * <ul>
 *   <li>开：原样显示完整路径（与改造前一致）；</li>
 *   <li>关（默认）：每个绝对路径只显示最后一段文件名，但用 {@link TextCopy.PathTargetSpan}
 *       记住原路径——路径小卡的复制/跳转仍拿得到完整路径，不会退化成「打开文件名」。</li>
 * </ul>
 *
 * <p>所有会把文件路径写到 {@code textIsSelectable} 控件的地方都经这里过一遍；读取在每次上屏时现取，
 * 故设置页改完开关后，各页下一次刷新即生效，不依赖进程重启。
 */
final class PathDisplay {

    /** 「展示完整路径」开关键（{@code params.def.json} 的 webui 组）。 */
    static final String KEY_UI_FULL_PATH = "UI_FULL_PATH";

    private PathDisplay() {
    }

    /** 开关当前是否要求完整路径；读取失败按关闭处理（默认即关闭）。 */
    static boolean showFull(@NonNull Context context) {
        try {
            ConfigStore.Value value = ConfigStore.get(context).get(KEY_UI_FULL_PATH);
            return value != null && value.intAt(0) != 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /**
     * 按开关生成要上屏的文本：完整路径原样返回；否则把每个绝对路径替换成文件名。
     * 没有路径时不新建对象，直接返回原文本。
     */
    @NonNull
    static CharSequence format(@NonNull Context context, @Nullable CharSequence text) {
        return format(text, showFull(context));
    }

    /**
     * 同上，开关值由调用方给定：后台预渲染时与缓存键取同一份值，避免两次读开关得到不同结果。
     */
    @NonNull
    static CharSequence format(@Nullable CharSequence text, boolean showFull) {
        if (text == null) {
            return "";
        }
        if (showFull) {
            return text;
        }
        String plain = text.toString();
        Matcher matcher = TextCopy.ABSOLUTE_PATH.matcher(plain);
        if (!matcher.find()) {
            return text;
        }
        SpannableStringBuilder out = new SpannableStringBuilder();
        int last = 0;
        do {
            out.append(plain, last, matcher.start());
            String path = matcher.group();
            // 「文件:行号」里的行号不属于路径：只把路径部分换名，行号原样留在后面
            int cut = TextCopy.trimLineSuffix(path, 0, path.length());
            String target = path.substring(0, cut);
            int start = out.length();
            out.append(nameOf(target));
            out.setSpan(new TextCopy.PathTargetSpan(target), start, out.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            out.append(path, cut, path.length());
            last = matcher.end();
        } while (matcher.find());
        out.append(plain, last, plain.length());
        return out;
    }

    /**
     * 已知整条文本就是一条路径时用：无论开关都返回一个覆盖整段文本的显式路径区间。
     * 这样 glob（{@code modules_*.log}）或含空格的日志文件名也能整条可点，不靠正则猜边界。
     */
    @NonNull
    static CharSequence forSinglePath(@NonNull Context context, @NonNull String path) {
        String shown = showFull(context) ? path : nameOf(path);
        SpannableStringBuilder out = new SpannableStringBuilder(shown);
        out.setSpan(new TextCopy.PathTargetSpan(path), 0, out.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return out;
    }

    /** 路径的最后一段；以 {@code /} 结尾时先去掉尾斜杠。 */
    @NonNull
    static String nameOf(@NonNull String path) {
        String trimmed = path;
        while (trimmed.length() > 1 && trimmed.endsWith("/")) {
            trimmed = trimmed.substring(0, trimmed.length() - 1);
        }
        int slash = trimmed.lastIndexOf('/');
        String name = slash >= 0 ? trimmed.substring(slash + 1) : trimmed;
        return name.isEmpty() ? path : name;
    }
}
