package com.example.waspwingtempctrl.ui;

import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.Value;
import com.example.waspwingtempctrl.ConfigStore.WriteResult;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * 「改即存」的防抖写入队列。
 *
 * <h3>为什么必须防抖</h3>
 * C 端每 5 秒 {@code stat()} + {@code st_mtime} 轮询热重载，而 {@code st_mtime} 只有<b>秒级</b>精度：
 * 两次写入间隔 &lt; 1 秒时 C 端可能不重载。故连续改动合并成一次落盘，窗口 {@link #DEBOUNCE_MS}
 * 取 1200ms（&gt; 1000ms，留出写盘与时钟粒度余量）。
 *
 * <h3>为什么批量</h3>
 * 多个键的改动合并为一次 {@link ConfigStore#setAll}，只触发一次临时文件 + rename，只碰一次 mtime。
 *
 * <h3>线程</h3>
 * 本类只在<b>主线程</b>调用（Handler 定时 + {@code pending} 表）；落盘跑在外部传入的单线程
 * executor 上，结果回主线程回调。{@code pending} 保留到写结果返回为止，避免写盘期间界面回退到旧值。
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

    /** 键 → 待写值。仅主线程访问。 */
    private final LinkedHashMap<String, Value> pending = new LinkedHashMap<>();

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

    /** 排入一个待写项并重置防抖窗口。 */
    void schedule(@NonNull String key, @NonNull Value value) {
        pending.put(key, value);
        main.removeCallbacks(flushTask);
        main.postDelayed(flushTask, DEBOUNCE_MS);
    }

    /** 撤销某键的待写项（用户把值改回了磁盘上的原值）。 */
    void cancel(@NonNull String key) {
        pending.remove(key);
        if (pending.isEmpty()) {
            main.removeCallbacks(flushTask);
        }
    }

    /** 当前待写值；无则 null（用于"有效值"= 待写值优先于磁盘值）。 */
    @Nullable
    Value pendingValue(@NonNull String key) {
        return pending.get(key);
    }

    /**
     * 立即冲刷待写项。<b>onPause / onDestroyView / 页面隐藏时必须调</b>：
     * 被隐藏的 Fragment 生命周期仍是 RESUMED，onPause 不会来，不主动冲刷就会把改动留在内存里。
     */
    void flushNow() {
        main.removeCallbacks(flushTask);
        if (pending.isEmpty() || io.isShutdown()) {
            return;
        }
        final LinkedHashMap<String, Value> batch = new LinkedHashMap<>(pending);
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
        for (Map.Entry<String, Value> entry : written.entrySet()) {
            Value current = pending.get(entry.getKey());
            if (current != null && current.equals(entry.getValue())) {
                pending.remove(entry.getKey());
            }
        }
        callback.onWriteResult(result, written);
    }
}
