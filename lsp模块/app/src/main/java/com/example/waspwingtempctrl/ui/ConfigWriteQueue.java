package com.example.waspwingtempctrl.ui;

import android.os.Handler;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.ConfigStore.WriteResult;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * 「改即存」的防抖写入队列：连续改动合并成一次 {@link ConfigStore#setAll}，只触发一次临时文件
 * + rename。防抖<b>每键独立计时</b>（见 {@link #dueAt}）：定时器只排在当前最早的那个截止时刻上，
 * 到点把当时全部待写键整批一次写出，故新改一个键不会把别的键的落盘往后推。本类只在<b>主线程</b>
 * 调用（Handler 定时 + {@code pending} 表），落盘跑在外部传入的单线程 executor 上、结果回主线程
 * 回调。防抖窗口与线程模型详见 app/逻辑说明.md §3.2。
 */
final class ConfigWriteQueue {

    /** 防抖窗口。必须 &gt; 1000ms：st_mtime 是秒级精度，低于 1 秒 C 端可能不重载。 */
    static final long DEBOUNCE_MS = 1200L;

    interface Callback {
        /** 一次落盘的结果（主线程）。{@code written} 是本次提交的键值对。 */
        void onWriteResult(@NonNull WriteResult result, @NonNull Map<String, Value> written);
    }

    private final ConfigStore store;
    private final ExecutorService io;
    private final Handler main;
    private final Callback callback;

    /** 键 → 待写值。仅主线程访问。<b>保留到写结果返回为止</b>（见 {@link #finish}），不能在提交时清空，
     *  否则写盘期间界面会回退到磁盘旧值。 */
    private final LinkedHashMap<String, Value> pending = new LinkedHashMap<>();

    /** 键 → 该键自己的落盘截止时刻（{@link SystemClock#uptimeMillis()}，= 改动时刻 + {@link #DEBOUNCE_MS}）。
     *  仅主线程访问。某个键的批次交接给 io 时撤掉它的项（见 {@link #flushNow}）；写盘期间被重新编辑的键
     *  由 {@link #schedule} 重新登记。 */
    private final HashMap<String, Long> dueAt = new HashMap<>();

    private final Runnable flushTask = new Runnable() {
        @Override
        public void run() {
            flushNow();
        }
    };

    ConfigWriteQueue(@NonNull ConfigStore store, @NonNull ExecutorService io, @NonNull Handler main,
                     @NonNull Callback callback) {
        this.store = store;
        this.io = io;
        this.main = main;
        this.callback = callback;
    }

    /**
     * 排入一个待写项，并只刷新<b>该键自己</b>的防抖窗口（每键独立计时）。
     *
     * <p>定时器排在「当前待写键里<b>最早</b>的那个截止时刻」上：新排入的键的截止恒为
     * {@code now + DEBOUNCE_MS}、不早于既有任何键，故本调用只会让定时器<b>保持不变</b>，
     * 不会把别的键的落盘往后推。见 app 逻辑说明.md §3.2。
     */
    void schedule(@NonNull String key, @NonNull Value value) {
        pending.put(key, value);
        dueAt.put(key, SystemClock.uptimeMillis() + DEBOUNCE_MS);
        arm();
    }

    /** 把定时器重排到「{@code dueAt} 里最早的截止时刻」。{@code dueAt} 为空（无待写、或待写的都已在
     *  io 里）时不排任何定时器。仅主线程调用。 */
    private void arm() {
        main.removeCallbacks(flushTask);
        long earliest = Long.MAX_VALUE;
        for (Long due : dueAt.values()) {
            if (due != null && due < earliest) {
                earliest = due;
            }
        }
        if (earliest == Long.MAX_VALUE) {
            return;
        }
        main.postDelayed(flushTask, Math.max(0L, earliest - SystemClock.uptimeMillis()));
    }

    /** 撤销某键的待写项（用户把值改回了磁盘上的原值）。 */
    void cancel(@NonNull String key) {
        pending.remove(key);
        dueAt.remove(key);
        arm();
    }

    /** 当前待写值；无则 null（用于"有效值"= 待写值优先于磁盘值）。 */
    @Nullable
    Value pendingValue(@NonNull String key) {
        return pending.get(key);
    }

    /**
     * 立即冲刷待写项。<b>onPause / onDestroyView / 页面隐藏时必须调</b>
     * （被隐藏的 Fragment 生命周期仍是 RESUMED，不主动冲刷就会把改动留在内存里）。
     * 详见 app/逻辑说明.md §3.2。
     */
    void flushNow() {
        main.removeCallbacks(flushTask);
        if (pending.isEmpty() || io.isShutdown()) {
            return;
        }
        final LinkedHashMap<String, Value> batch = new LinkedHashMap<>(pending);
        // 本批已交接给 io：撤掉它们的截止时刻（连同其可能已排的定时器——首行的 removeCallbacks 已摘）。
        // 任何"还有定时器在排队"的键此刻必在 pending 里、也就必在本批内，故这次 removeCallbacks 不会撇下
        // 任何一个待写键；而写盘期间被重新编辑的键会由 schedule 重新登记 dueAt 并重排定时器。
        // pending 仍保留到 finish 返回，故界面在写盘期间不会回退到旧值。
        for (String key : batch.keySet()) {
            dueAt.remove(key);
        }
        io.execute(new Runnable() {
            @Override
            public void run() {
                final WriteResult result = store.setAll(batch);
                main.post(new Runnable() {
                    @Override
                    public void run() {
                        finish(result, batch);
                    }
                });
            }
        });
    }

    /** 丢弃定时器（页面销毁时调；不碰 executor，executor 由页面自己关）。 */
    void detach() {
        main.removeCallbacks(flushTask);
    }

    private void finish(@NonNull WriteResult result, @NonNull Map<String, Value> written) {
        // 只摘掉「提交时的那一份」：写盘期间被改成新值的键继续留在待写表里，等下一轮冲刷
        boolean dueAtChanged = false;
        for (Map.Entry<String, Value> entry : written.entrySet()) {
            Value current = pending.get(entry.getKey());
            if (current != null && current.equals(entry.getValue())) {
                pending.remove(entry.getKey());
                // 摘 pending 时必须同步摘该键的截止时刻：写盘期间"以相同值重排"过一次的键，其 dueAt
                // 已被 schedule 重新登记过，不同步摘掉就留下「dueAt 有、pending 无」的孤儿；那个过期
                // 截止时刻会让 arm() 此后恒取到它、delay=0，于是每次 schedule 都立刻落盘、多键不再合并
                // （破坏 >=1200ms 间隔）。这里维持不变式：dueAt 的键集恒 ⊆ pending 的键集。
                if (dueAt.remove(entry.getKey()) != null) {
                    dueAtChanged = true;
                }
            }
        }
        if (dueAtChanged) {
            // 摘掉过截止时刻 → 定时器可能正指向已被摘的那个时刻，重排到剩下最早的一个
            arm();
        }
        callback.onWriteResult(result, written);
    }
}
