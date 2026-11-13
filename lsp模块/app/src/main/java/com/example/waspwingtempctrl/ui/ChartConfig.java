package com.example.waspwingtempctrl.ui;

import android.content.Context;

import com.example.waspwingtempctrl.ConfigStore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 曲线页用到的全部口径参数。<b>只能在后台线程构造</b>（{@link #load} 内有同步 File IO）。
 *
 * <p>两类来源（口径见 app/逻辑说明.md §7.1）：
 * <ol>
 *   <li>{@code UI_GAP_SEC} / {@code UI_CHART_VIEW} / {@code UI_CURVE_FILTER}，
 *       以及右轴上限口径所需的 {@code COLD_RPM_MAP} /
 *       {@code PID_COLD_RANGE} / {@code PERF_ENABLED} —— 一律经 {@link ConfigStore} 读。
 *       字段缺项（如只写 {@code UI_CURVE_FILTER=15}）回落该字段在
 *       {@code assets/params.json} 里声明的默认值。</li>
 *   <li>{@code params.json} 的 {@code chart} 块（窗口档位/默认档位/滚动行数）——直接复用
 *       {@link ConfigStore} 构造时已解析的根对象（{@link ConfigStore#paramsRoot()}），
 *       <b>不再第二次 open + 解析整份资产</b>。读失败回落常量并把事实写进 {@link #notes}，不静默。</li>
 * </ol>
 *
 * <p><b>进程级缓存</b>：{@link #load} 的结果按 {@link ConfigStore#configFingerprint()} 缓存，失效判据
 * 只此一处、降级结果也一并留档。返回的对象<b>可能被多处共用</b>：只读，谁都不许改它的字段。
 * 见 app/逻辑说明.md §7.1。
 */
final class ChartConfig {

    /** {@code chart} 块读不到时的回落档位（与 {@code assets/params.json} 的 {@code chart} 块同值）。 */
    static final int[] FALLBACK_WINDOW_OPTIONS = {120, 180, 240, 360, 480, 720};
    static final int FALLBACK_WINDOW_DEFAULT = 360;
    static final int FALLBACK_ROLLING_MAX_LINES = 720;

    /** 断联判定阈值（秒）——{@code UI_GAP_SEC} 第 1 值。 */
    int gapDetectSec = 3;
    /** 空白封顶（秒）——{@code UI_GAP_SEC} 第 2 值。 */
    int gapMaxSec = 15;
    /** 左轴转速下限（RPM）——{@code UI_CHART_VIEW} 第 1 槽；0 = 关闭。 */
    int rpmAxisMin = 3000;
    /** 双向 EMA 每遍权重 α = {@code UI_CURVE_FILTER} 第 2 值/100；总开关关时为 0。 */
    float alpha = 0.15f;
    /** 最小步长 = {@code UI_CURVE_FILTER} 第 3 值/100；总开关关时为 0。 */
    float quantStep = 0.05f;
    /** 右轴上限浮动区间下沿 = {@code COLD_RPM_MAP} 第 1 值（映射起始强度）。 */
    int coldMapStart = 40;
    /** 右轴上限浮动区间上沿 = {@code PID_COLD_RANGE} 第 2 值（B6X 制冷上限）。 */
    int coldMax = 190;
    /** 曲线上的 PID 重算标记（{@code UI_CHART_VIEW} 第 2 槽）：在重算位置画竖虚线，默认开。 */
    boolean markDash = true;
    /** 制冷对的目标/实际强调方交换（{@code UI_CHART_SWAP} 第 1 值）：false = 强调实际（默认）。 */
    boolean swapCool;
    /** 风扇对的目标/实际强调方交换（{@code UI_CHART_SWAP} 第 2 值）：false = 强调实际（默认）。 */
    boolean swapRpm;

    int[] windowOptions = FALLBACK_WINDOW_OPTIONS.clone();
    int windowDefaultSec = FALLBACK_WINDOW_DEFAULT;
    int rollingMaxLines = FALLBACK_ROLLING_MAX_LINES;

    /** 回落/异常说明（信息条要如实上屏，不静默）。 */
    final List<String> notes = new ArrayList<>();

    private ChartConfig() {
    }

    /** {@link #load} 的进程级缓存条目：一份口径 + 它对应的配置指纹（不可变，故 volatile 一次读写即一致）。 */
    private static final class Cached {
        final String fingerprint;
        final ChartConfig config;

        Cached(String fingerprint, ChartConfig config) {
            this.fingerprint = fingerprint;
            this.config = config;
        }
    }

    private static volatile Cached cached;

    /**
     * 取一份曲线口径（带进程级缓存，见类注释）。<b>只能在后台线程调用</b>：缓存未命中时这里有
     * 同步 File IO 与 47KB JSON 解析。
     */
    static ChartConfig load(Context context) {
        ConfigStore store = ConfigStore.get(context);
        String fingerprint = store.configFingerprint();
        Cached hit = cached;
        if (hit != null && fingerprint.equals(hit.fingerprint)) {
            return hit.config;
        }
        ChartConfig c = new ChartConfig();
        c.readKeys(store);
        c.readChartBlock(store);
        cached = new Cached(fingerprint, c);
        return c;
    }

    // ==================== 配置键 ====================

    private void readKeys(ConfigStore store) {
        ConfigStore.Snapshot snap;
        try {
            snap = store.read();
        } catch (Throwable t) {
            notes.add("读取 profile.conf 失败（" + t.getClass().getSimpleName() + "），曲线参数全部使用默认值");
            return;
        }
        // 断联：两个字段都要求 > 0，否则各自回落 3 / 15（口径见 app/逻辑说明.md §7.2〈断联空白〉）
        int detect = field(store, snap, "UI_GAP_SEC", 0, 3);
        int maxSec = field(store, snap, "UI_GAP_SEC", 1, 15);
        gapDetectSec = detect > 0 ? detect : 3;
        gapMaxSec = maxSec > 0 ? maxSec : 15;
        // 曲线图（两槽）：第 1 槽纵轴下限、第 2 槽重算标记。新键未写或槽数不足时按槽回退旧键
        // （UI_RPM_AXIS_MIN / UI_PID_MARK），再回退默认；旧键值取自快照保留的原始值（定义里已删除）。
        ConfigStore.Value view = snap == null ? null : snap.get("UI_CHART_VIEW");
        boolean viewPresent = snap != null && snap.present("UI_CHART_VIEW");
        // 转速下限：负值一律归 0 = 关闭（口径见 app/逻辑说明.md §7.3〈双纵轴〉）
        rpmAxisMin = Math.max(0, chartViewSlot(snap, view, viewPresent, 0, 3000));
        // 重算标记：缺槽回退旧键，再回退默认（开）
        markDash = chartViewSlot(snap, view, viewPresent, 1, 1) != 0;
        // 目标/实际强调方交换（两槽）：第 1 槽管制冷对、第 2 槽管风扇对；缺键按 schema 默认（均 0 = 强调实际）。
        // 兼容旧单值配置：值只有 1 段时两对同时取该值，不回写配置文件。
        ConfigStore.Value sv = snap == null ? null : snap.get("UI_CHART_SWAP");
        int swapCoolRaw = field(store, snap, "UI_CHART_SWAP", 0, 0);
        int swapRpmRaw = field(store, snap, "UI_CHART_SWAP", 1, 0);
        if (sv != null && sv.size() == 1) {
            swapRpmRaw = swapCoolRaw;
        }
        swapCool = swapCoolRaw != 0;
        swapRpm = swapRpmRaw != 0;
        // 滤波（三值）：第一值 = 总开关，后两值 = 每遍权重 / 最小步长（口径见 app/逻辑说明.md §7.2）。
        // 兼容旧两值配置（权重 步长）：只有两段时视为开关开启，前两值即系数；不回写配置文件。
        ConfigStore.Value fv = snap == null ? null : snap.get("UI_CURVE_FILTER");
        boolean filterOn = true;
        int a;
        int s;
        if (fv != null && fv.size() >= 3) {
            filterOn = fv.intAt(0) != 0;
            a = fv.intAt(1);
            s = fv.intAt(2);
        } else if (fv != null && fv.size() > 0) {
            a = fv.intAt(0);
            s = fv.size() > 1 ? fv.intAt(1) : 5;
        } else {
            a = 15;
            s = 5;
        }
        // 两个子值 0 都合法（= 关闭该级），负值回落默认；总开关关时两者都按 0 走「不滤波」路径
        alpha = !filterOn ? 0f : (a >= 0 ? a / 100f : 0.15f);
        quantStep = !filterOn ? 0f : (s >= 0 ? s / 100f : 0.05f);
        // 右轴口径：总开关未开启时两端都回落代码默认（口径见 app/逻辑说明.md §7.3〈双纵轴〉）
        boolean perfOn = isOn(snap, "PERF_ENABLED");
        coldMapStart = perfOn ? clamp(single(store, snap, "COLD_RPM_MAP", 0, 40), 0, 194) : 40;
        int coldHigh = perfOn ? single(store, snap, "PID_COLD_RANGE", 1, 190) : 190;
        coldMax = coldHigh > 0 ? coldHigh : 190;
    }

    /**
     * 曲线图第 {@code i} 槽的值：新键写了该槽就取新键；否则按槽回退旧键
     * （第 1 槽 UI_RPM_AXIS_MIN、第 2 槽 UI_PID_MARK）的原始值，再回退 {@code fallback}。
     */
    private static int chartViewSlot(ConfigStore.Snapshot snap, ConfigStore.Value view,
                                     boolean viewPresent, int i, int fallback) {
        if (viewPresent && view != null && view.size() > i) {
            return view.intAt(i);
        }
        String legacyKey = i == 0 ? "UI_RPM_AXIS_MIN" : "UI_PID_MARK";
        Integer legacy = snap == null ? null : snap.rawInt(legacyKey);
        return legacy != null ? legacy : fallback;
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

    private void readChartBlock(ConfigStore store) {
        try {
            JSONObject root = store.paramsRoot();
            if (root == null) {
                String err = store.paramsLoadError();
                throw new IOException(err.isEmpty() ? "params.json 缺少 chart 块" : err);
            }
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
}
