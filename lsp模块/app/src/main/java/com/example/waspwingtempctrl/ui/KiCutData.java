package com.example.waspwingtempctrl.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.AppFiles;
import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.FieldMeta;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.ConfigStore.Value;

/**
 * KI 分段倍率曲线图的取数：<b>横轴上限</b>（当前设备的制冷上限）与<b>当前冷值</b>（红虚线位置）。
 *
 * <p>两条都是<b>只读、可失败、失败有降级</b>的旁路数据，绝不影响编辑与落盘：
 * <ul>
 *   <li>制冷上限优先取守护进程写在私有目录的 {@code tempctrl_coldmax}（一行 {@code COLD_MAX=<int>}，
 *       由 daemon 按当前设备刷新，B6X/B7X 自动切换）；读不到时回落配置 {@code PID_COLD_RANGE} 的
 *       B6X 值，总开关未开、仍取不到或超出定义范围则回落 190。</li>
 *   <li>目标冷值取曲线数据文件 {@code tempctrl_webui.data} 最后一行的第 8 列（目标制冷）；
 *       取不到返回 -1，由调用方决定不画红线。</li>
 * </ul>
 *
 * @see KiCutTable
 */
final class KiCutData {

    /** 曲线数据文件里「目标制冷」的列下标（行格式权威见 daemon/逻辑说明.md〈状态页数据源〉）。 */
    private static final int COL_TARGET_COLD = 7;
    /** 制冷上限提示文件里 {@code COLD_MAX=} 的字段名前缀（格式权威见 app/逻辑说明.md §6.6）。 */
    private static final String COLDMAX_FIELD = "COLD_MAX=";
    /** 上限提示文件只有一行，读这点字节足够。 */
    private static final int COLDMAX_PROBE_BYTES = 64;
    /** 横轴上限的降级值（B6X 出厂上限；定义 PID_COLD_RANGE 第 2 字段 factory=190）。 */
    private static final int FALLBACK_COLD_MAX = 190;

    private KiCutData() {
    }

    /** 横轴上限（制冷档位）；总开关未开、取不到或超出定义范围时回落 {@link #FALLBACK_COLD_MAX}。 */
    static int coldMax(@NonNull Context context) {
        try {
            ConfigStore store = ConfigStore.get(context);
            Snapshot snap = store.read();
            if (!isOn(snap, "PERF_ENABLED")) {
                return FALLBACK_COLD_MAX;
            }
            int candidate = readColdMaxHint(context);
            if (candidate <= 0) {
                candidate = fieldValue(store, snap, "PID_COLD_RANGE", 1, FALLBACK_COLD_MAX);
            }
            if (candidate <= 0) {
                candidate = FALLBACK_COLD_MAX;
            }
            // 越界值（外部手改配置 / 损坏的 tempctrl_coldmax）走既有降级值，不静默钳到边界
            return withinDefinedColdRange(store, candidate) ? candidate : FALLBACK_COLD_MAX;
        } catch (Throwable t) {
            return FALLBACK_COLD_MAX;
        }
    }

    /**
     * 横轴上限是否落在 {@code PID_COLD_RANGE} 的定义范围内。上限对应两个设备字段：
     * {@code fields[1]}「制冷B6X」（{@code min=0, max=194}）与 {@code fields[2]}「制冷B7X」
     * （{@code min=1, max=255}），取二者并集 0~255（调用方已保证 {@code candidate > 0}，故实际为 1~255）。
     * 定义缺失或字段无范围时没有可信上界，仅接受不超过降级值的正数（不按任意大值分配数组）。
     */
    private static boolean withinDefinedColdRange(@NonNull ConfigStore store, int candidate) {
        KeyMeta meta = store.key("PID_COLD_RANGE");
        if (meta == null || meta.fields == null || meta.fields.size() < 3) {
            return candidate > 0 && candidate <= FALLBACK_COLD_MAX;
        }
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        for (int i = 1; i <= 2; i++) {
            FieldMeta field = meta.fields.get(i);
            if (field.min != null) {
                lo = Math.min(lo, field.min);
            }
            if (field.max != null) {
                hi = Math.max(hi, field.max);
            }
        }
        if (lo == Integer.MAX_VALUE || hi == Integer.MIN_VALUE) {
            return candidate > 0 && candidate <= FALLBACK_COLD_MAX;
        }
        return candidate >= lo && candidate <= hi;
    }

    /** 当前冷值（曲线数据文件最后一行的目标制冷）；取不到、为哨兵值或临时停止生效时返回 -1。 */
    static int targetCold(@NonNull Context context) {
        try {
            // 临时停止期间不画「当前冷值」指示线（此时 daemon 不下发，红线没有意义）
            if (isOn(ConfigStore.get(context).read(), "UI_TEMP_STOP")) {
                return -1;
            }
            String text = AppFiles.readTailText(AppFiles.dataFile(context), 4096);
            String line = lastLine(text);
            if (line == null) {
                return -1;
            }
            String[] cols = line.split(",", -1);
            if (cols.length <= COL_TARGET_COLD) {
                return -1;
            }
            int v = Integer.parseInt(cols[COL_TARGET_COLD].trim());
            return v >= 0 ? v : -1;
        } catch (Throwable t) {
            return -1;
        }
    }

    /** 末尾第一个非空行；没有则 null。 */
    @Nullable
    private static String lastLine(@NonNull String text) {
        int end = text.length();
        while (end > 0) {
            int nl = text.lastIndexOf('\n', end - 1);
            String line = text.substring(nl + 1, end).trim();
            if (!line.isEmpty()) {
                return line;
            }
            if (nl < 0) {
                return null;
            }
            end = nl;
        }
        return null;
    }

    // ==================== 生效制冷上限（守护进程写入） ====================

    /**
     * 守护进程写的当前生效制冷上限（{@code COLD_MAX=<int>}）；读不到 / 解析不出返回 -1。
     * 文件由 daemon 按 active_device 刷新（B6X=配置上限、B7X=b7 上限），daemon 未运行时缺失。
     */
    private static int readColdMaxHint(@NonNull Context context) {
        try {
            String text = AppFiles.readTailText(AppFiles.coldMaxFile(context), COLDMAX_PROBE_BYTES);
            for (String raw : text.split("\n")) {
                String line = raw.trim();
                if (line.startsWith(COLDMAX_FIELD)) {
                    return Integer.parseInt(line.substring(COLDMAX_FIELD.length()).trim());
                }
            }
        } catch (Throwable t) {
            // 文件不存在 / 不可读 / 解析失败：交给调用方回落（不吞异常也不上屏）
        }
        return -1;
    }

    // ==================== 配置键读取（与曲线页同源口径） ====================

    private static boolean isOn(@Nullable Snapshot snap, @NonNull String key) {
        Value v = snap == null ? null : snap.get(key);
        return v != null && v.intAt(0) != 0;
    }

    /** 多值键第 {@code idx} 个字段的值；字段/键缺失时回落该字段的 schema 默认值。 */
    private static int fieldValue(@NonNull ConfigStore store, @Nullable Snapshot snap,
                                  @NonNull String key, int idx, int fallback) {
        int def = fallback;
        KeyMeta meta = store.key(key);
        if (meta != null && meta.fields != null && idx < meta.fields.size()) {
            def = meta.fields.get(idx).defaultValue;
        }
        Value v = snap == null ? null : snap.get(key);
        if (v == null) {
            return def;
        }
        return idx < v.size() ? v.intAt(idx) : def;
    }
}
