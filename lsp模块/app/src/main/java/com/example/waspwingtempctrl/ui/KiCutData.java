package com.example.waspwingtempctrl.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.KeyMeta;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.ConfigStore.Value;

/**
 * KI 分段倍率曲线图的取数：<b>横轴上限</b>（当前设备的制冷上限）与<b>此刻目标冷值</b>（红虚线位置）。
 *
 * <p>两条都是<b>只读、可失败、失败有降级</b>的旁路数据，绝不影响编辑与落盘：
 * <ul>
 *   <li>制冷上限优先取守护进程写在私有目录的 {@code tempctrl_coldmax}（一行 {@code COLD_MAX=<int>}，
 *       由 daemon 按当前设备刷新，B6X/B7X 自动切换）；读不到时回落配置 {@code PID_COLD_RANGE} 的
 *       B6X 值，总开关未开或仍取不到则回落 190。</li>
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

    private KiCutData() {
    }

    /** 横轴上限（制冷档位）；总开关未开、取不到时回落 190。 */
    static int coldMax(@NonNull Context context) {
        try {
            ConfigStore store = ConfigStore.get(context);
            Snapshot snap = store.read();
            if (!isOn(snap, "PERF_ENABLED")) {
                return 190;
            }
            int fromDaemon = readColdMaxHint(context);
            if (fromDaemon > 0) {
                return fromDaemon;
            }
            int b6 = fieldValue(store, snap, "PID_COLD_RANGE", 1, 190);
            return b6 > 0 ? b6 : 190;
        } catch (Throwable t) {
            return 190;
        }
    }

    /** 此刻目标冷值（曲线数据文件最后一行的目标制冷）；取不到或为哨兵值时返回 -1。 */
    static int targetCold(@NonNull Context context) {
        try {
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
