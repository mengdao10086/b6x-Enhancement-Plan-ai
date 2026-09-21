package com.example.waspwingtempctrl.ui;

import android.content.Context;

import com.example.waspwingtempctrl.ConfigStore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 曲线页用到的全部口径参数。<b>只能在后台线程构造</b>（{@link #load} 内有同步 File IO）。
 *
 * <p>两类来源：
 * <ol>
 *   <li>{@code UI_GAP_SEC} / {@code UI_LABEL_MERGE_PX} / {@code UI_RPM_AXIS_MIN} /
 *       {@code UI_CURVE_FILTER}，以及右轴上限口径所需的 {@code COLD_RPM_MAP} /
 *       {@code PID_COLD_RANGE} / {@code PERF_ENABLED} —— 一律经 {@link ConfigStore} 读
 *       （口径清单 §13）。字段缺项（如只写 {@code UI_CURVE_FILTER=15}）回落该字段在
 *       {@code assets/params.json} 里声明的默认值。</li>
 *   <li>{@code params.json} 的 {@code chart} 块（窗口档位/默认档位/滚动行数目标——
 *       文案作「目标」与 {@link #notes} 上屏的说法同源；代码里它仍是环形保留的硬上限）——
 *       {@link ConfigStore} 只暴露 {@code groups()/keys()/key()}，{@code chart} 不是键，
 *       故本类直接读该 asset（<b>本页唯一允许碰 assets 的地方，只读</b>）。
 *       读失败时回落已确认的常量，并把回落事实写进 {@link #notes}，不静默。</li>
 * </ol>
 */
final class ChartConfig {

    /** {@code chart} 块读不到时的回落档位（与 {@code assets/params.json} 的 {@code chart} 块同值）。 */
    static final int[] FALLBACK_WINDOW_OPTIONS = {120, 180, 240, 360, 480, 720};
    static final int FALLBACK_WINDOW_DEFAULT = 360;
    static final int FALLBACK_ROLLING_MAX_LINES = 720;

    /** 断联判定阈值（秒）——{@code UI_GAP_SEC} 第 1 值。 */
    int gapDetectSec = 5;
    /** 空白封顶（秒）——{@code UI_GAP_SEC} 第 2 值。 */
    int gapMaxSec = 15;
    /** 标注合并阈值（配置 px，使用时按 density 换算）——{@code UI_LABEL_MERGE_PX}。 */
    int labelMergePx = 9;
    /** 左轴转速下限（RPM）——{@code UI_RPM_AXIS_MIN}；0 = 关闭。 */
    int rpmAxisMin = 3000;
    /** 双向 EMA 每遍权重 α = 第 1 值/100。 */
    float alpha = 0.15f;
    /** 最小步长 = 第 2 值/100。 */
    float quantStep = 0.05f;
    /** 右轴上限浮动区间下沿 = {@code COLD_RPM_MAP} 第 1 值（映射起始强度）。 */
    int coldMapStart = 40;
    /** 右轴上限浮动区间上沿 = {@code PID_COLD_RANGE} 第 2 值（B6X 制冷上限）。 */
    int coldMax = 190;

    int[] windowOptions = FALLBACK_WINDOW_OPTIONS.clone();
    int windowDefaultSec = FALLBACK_WINDOW_DEFAULT;
    int rollingMaxLines = FALLBACK_ROLLING_MAX_LINES;

    /** 回落/异常说明（信息条要如实上屏，不静默）。 */
    final List<String> notes = new ArrayList<>();

    private ChartConfig() {
    }

    static ChartConfig load(Context context) {
        ChartConfig c = new ChartConfig();
        c.readKeys(context);
        c.readChartBlock(context);
        return c;
    }

    // ==================== 配置键 ====================

    private void readKeys(Context context) {
        ConfigStore store = ConfigStore.get(context);
        ConfigStore.Snapshot snap;
        try {
            snap = store.read();
        } catch (Throwable t) {
            notes.add("读取 profile.conf 失败（" + t.getClass().getSimpleName() + "），曲线参数全部使用默认值");
            return;
        }
        // 断联：两个字段都要求 > 0，否则各自回落 5 / 15（口径见 逻辑说明.md 的「曲线」一节〈断联空白〉）
        int detect = field(store, snap, "UI_GAP_SEC", 0, 5);
        int maxSec = field(store, snap, "UI_GAP_SEC", 1, 15);
        gapDetectSec = detect > 0 ? detect : 5;
        gapMaxSec = maxSec > 0 ? maxSec : 15;
        // 合并阈值：≥ 0 合法（0 = 不合并以外全合并），负值回落 9（口径见 逻辑说明.md 的「可配置参数一览」UI_LABEL_MERGE_PX）
        int merge = field(store, snap, "UI_LABEL_MERGE_PX", 0, 9);
        labelMergePx = merge >= 0 ? merge : 9;
        // 转速下限：负值一律归 0 = 关闭（口径见 逻辑说明.md 的「曲线」一节〈双纵轴〉）
        rpmAxisMin = Math.max(0, field(store, snap, "UI_RPM_AXIS_MIN", 0, 3000));
        // 滤波：两个子值 0 都合法（= 关闭该级），负值回落默认（口径见 逻辑说明.md 的「曲线」一节〈滤波关闭语义〉）
        int a = field(store, snap, "UI_CURVE_FILTER", 0, 15);
        int s = field(store, snap, "UI_CURVE_FILTER", 1, 5);
        alpha = a >= 0 ? a / 100f : 0.15f;
        quantStep = s >= 0 ? s / 100f : 0.05f;
        // 右轴口径：总开关未开启时两端都回落代码默认（口径见 逻辑说明.md 的「曲线」一节〈双纵轴〉）
        boolean perfOn = isOn(snap, "PERF_ENABLED");
        coldMapStart = perfOn ? clamp(single(store, snap, "COLD_RPM_MAP", 0, 40), 0, 194) : 40;
        int coldHigh = perfOn ? single(store, snap, "PID_COLD_RANGE", 1, 190) : 190;
        coldMax = coldHigh > 0 ? coldHigh : 190;
    }

    private static boolean isOn(ConfigStore.Snapshot snap, String key) {
        ConfigStore.Value v = snap == null ? null : snap.get(key);
        return v != null && v.intAt(0) != 0;
    }

    /** 多值键第 i 个字段；字段缺项回落该字段的 schema 默认值（口径见 逻辑说明.md 的「可配置参数一览」）。 */
    private static int field(ConfigStore store, ConfigStore.Snapshot snap, String key, int idx, int fallback) {
        ConfigStore.KeyMeta meta = store.key(key);
        int def = fallback;
        if (meta != null && meta.fields != null && idx < meta.fields.size()) {
            def = meta.fields.get(idx).defaultValue;
        }
        ConfigStore.Value v = snap == null ? null : snap.get(key);
        if (v == null) {
            return def;
        }
        return idx < v.size() ? v.intAt(idx) : def;
    }

    private static int single(ConfigStore store, ConfigStore.Snapshot snap, String key, int idx, int fallback) {
        return field(store, snap, key, idx, fallback);
    }

    private static int clamp(int v, int lo, int hi) {
        return v < lo ? lo : (v > hi ? hi : v);
    }

    // ==================== params.json 的 chart 块 ====================

    private void readChartBlock(Context context) {
        try (InputStream in = context.getAssets().open(ConfigStore.PARAMS_ASSET)) {
            JSONObject root = new JSONObject(readAll(in));
            JSONObject chart = root.optJSONObject("chart");
            if (chart == null) {
                throw new IOException("params.json 缺少 chart 块");
            }
            JSONArray opts = chart.optJSONArray("windowOptionsSec");
            int[] tmp = new int[opts == null ? 0 : opts.length()];
            int n = 0;
            for (int i = 0; i < tmp.length; i++) {
                int v = opts.optInt(i, 0);
                if (v > 0) {
                    tmp[n++] = v;
                }
            }
            if (n == 0) {
                throw new IOException("params.json chart.windowOptionsSec 为空");
            }
            windowOptions = Arrays.copyOf(tmp, n);
            windowDefaultSec = chart.optInt("windowDefaultSec", FALLBACK_WINDOW_DEFAULT);
            int lines = chart.optInt("rollingMaxLines", FALLBACK_ROLLING_MAX_LINES);
            rollingMaxLines = lines > 0 ? lines : FALLBACK_ROLLING_MAX_LINES;
            if (!contains(windowOptions, windowDefaultSec)) {
                notes.add("chart.windowDefaultSec=" + windowDefaultSec + " 不在档位集合内，已回落 360");
                windowDefaultSec = contains(windowOptions, FALLBACK_WINDOW_DEFAULT)
                        ? FALLBACK_WINDOW_DEFAULT : windowOptions[0];
            }
        } catch (Throwable t) {
            windowOptions = FALLBACK_WINDOW_OPTIONS.clone();
            windowDefaultSec = FALLBACK_WINDOW_DEFAULT;
            rollingMaxLines = FALLBACK_ROLLING_MAX_LINES;
            notes.add("params.json 的 chart 块读取失败（" + t.getClass().getSimpleName() + ": "
                    + t.getMessage() + "），已回落常量：档位 " + Arrays.toString(windowOptions)
                    + "、默认 " + windowDefaultSec + "s、行数目标 " + rollingMaxLines);
        }
    }

    private static boolean contains(int[] arr, int v) {
        for (int a : arr) {
            if (a == v) {
                return true;
            }
        }
        return false;
    }

    private static String readAll(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int n;
        while ((n = in.read(buf)) > 0) {
            out.write(buf, 0, n);
        }
        return new String(out.toByteArray(), StandardCharsets.UTF_8);
    }
}
