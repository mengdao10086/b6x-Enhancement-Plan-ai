package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.Deployer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 部署状态的进程内缓存：启动时后台预取并<b>预渲染</b>，状态页建页/预取完成时直接上屏。
 *
 * <p><b>三件成对更新的东西</b>：原始文本、它的预渲染结果（路径已按「展示完整路径」开关裁剪、
 * span 已建好）、产生时刻 {@code atMs}。预渲染在后台线程完成，主线程只做 {@code setText}。
 *
 * <p><b>失效判据</b>：预渲染结果只依赖开关 {@code UI_FULL_PATH}（字号/主题只影响排版，不改
 * {@code CharSequence}，排版由平台在布局期自己算）。故缓存里记下渲染时的开关值，读取时与当前值
 * 比对：不一致即判定失效、返回 null（调用方回退到预填充骨架/现场探测），并在后台按新开关重渲一份
 * 供下次命中。原始文本换了也一样——两个字段总是一起写，不会出现「新文本 + 旧渲染」。
 *
 * <p><b>陈旧与失败</b>：超过 {@link #STALE_MS} 只标记陈旧，值照常先显示，后台刷新随后交叉淡入覆盖；
 * 探测失败不写缓存，旧值原样保留，提示仍由状态页既有分支负责。
 *
 * <p>线程约定：{@link #prefetch} / {@link #rendered} / {@link #isStale} / {@link #atMs} 在主线程调
 * （不碰 IO 与格式化，只读内存）；{@link #store} 在探测线程调（格式化在那里做完）；
 * 预取完成回调 {@link Listener} 一律回主线程。
 */
final class DeployStatusCache {

    /** 陈旧阈值：与状态页静默刷新的 30 秒节流同口径（见 StatusFragment.PROBE_MIN_INTERVAL_MS）。 */
    static final long STALE_MS = 30_000L;

    /** 预取完成回调（主线程）：页面已建好时立刻拿预渲染结果上屏，切页前布局就已完成。 */
    interface Listener {
        void onDeployStatusReady();
    }

    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** 预取与后台重渲共用：进程级一根、守护线程，失败无副作用。 */
    private static final ExecutorService EXEC = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ww-deploy-prefetch");
        thread.setDaemon(true);
        return thread;
    });

    /** 进程级只预取一次：视图重建（旋转、返回本页）不重复打 su。 */
    private static final AtomicBoolean PREFETCHED = new AtomicBoolean();

    private static final Object LOCK = new Object();

    /** 最近一次成功探测的原始文本；null = 进程内还没有过成功结果。 */
    @Nullable
    private static String text;
    /** {@link #text} 的预渲染结果（含路径 span）；与 {@link #text} 成对更新。 */
    @Nullable
    private static CharSequence rendered;
    /** 生成 {@link #rendered} 时的「展示完整路径」开关值：开关变了渲染结果即失效。 */
    private static boolean renderedShowFull;
    /** {@link #text} 的产生时刻（ms）；0 = 从未成功。 */
    private static long atMs;

    @Nullable
    private static Listener listener;

    private DeployStatusCache() {
    }

    /**
     * 启动预取：后台探一次部署状态、就地预渲染后放进缓存（进程级只提交一次，失败静默）。
     *
     * <p>root 尚未取得时直接返回：启动阶段不主动打 su，首次授权仍由状态页首探发起
     * （判据复用 {@link Deployer#rootNotYetGranted}，只读缓存、不跑 su）。
     */
    static void prefetch(Context context) {
        if (!PREFETCHED.compareAndSet(false, true)) {
            return;
        }
        final Context app = context.getApplicationContext();
        EXEC.execute(() -> {
            try {
                if (Deployer.rootNotYetGranted(app)) {
                    return;
                }
                final Deployer.Status status = Deployer.get(app).probe();
                synchronized (LOCK) {
                    if (text != null) {
                        // 状态页可能已经探完并回写过（落页恰为状态页时会并行）：不拿更早的快照覆盖
                        return;
                    }
                }
                store(app, status.describe());
                notifyListener();
            } catch (Throwable ignored) {
                // 预取失败不写缓存：状态页自己的探测会走既有失败分支提示
            }
        });
    }

    /**
     * 记录一次成功的探测结果：就地预渲染（后台线程）后与文本成对写入缓存。
     * 状态页每次探测成功都回写，供下次建页直接上屏。
     */
    static void store(Context context, String value) {
        if (value == null || value.isEmpty()) {
            return;
        }
        final boolean showFull = PathDisplay.showFull(context);
        final CharSequence preRendered = PathDisplay.format(value, showFull);
        synchronized (LOCK) {
            text = value;
            rendered = preRendered;
            renderedShowFull = showFull;
            atMs = System.currentTimeMillis();
        }
    }

    /** 注册预取完成回调（主线程）；同一时刻只有一个页面在听。 */
    static void setListener(@Nullable Listener value) {
        listener = value;
    }

    static void clearListener() {
        listener = null;
    }

    /**
     * 可直接上屏的预渲染结果；无缓存或开关已变返回 null。
     *
     * <p>开关变了就作废旧结果，并在后台按新开关重渲一份（下次进页即命中）——绝不拿旧渲染糊上去。
     */
    @Nullable
    static CharSequence rendered(Context context) {
        final boolean showFull = PathDisplay.showFull(context);
        synchronized (LOCK) {
            if (rendered != null && renderedShowFull == showFull) {
                return rendered;
            }
        }
        reRenderAsync(context);
        return null;
    }

    /** 最近一次成功的时间戳（ms）；从未成功返回 0。 */
    static long atMs() {
        synchronized (LOCK) {
            return atMs;
        }
    }

    /** 是否陈旧（从未成功也按陈旧处理：调用方照常走现场探测，不等预取）。 */
    static boolean isStale() {
        synchronized (LOCK) {
            return text == null || System.currentTimeMillis() - atMs > STALE_MS;
        }
    }

    /** 按当前开关重渲缓存文本（后台线程；没有缓存就什么都不做）。 */
    private static void reRenderAsync(Context context) {
        final Context app = context.getApplicationContext();
        EXEC.execute(() -> {
            final String cached;
            synchronized (LOCK) {
                cached = text;
            }
            if (cached != null) {
                store(app, cached);
            }
        });
    }

    /** 预取完成通知：一律回主线程，且只在监听者仍是刚才那个时才回调。 */
    private static void notifyListener() {
        final Listener current = listener;
        if (current == null) {
            return;
        }
        MAIN.post(() -> {
            final Listener target = listener;
            if (target == current) {
                target.onDeployStatusReady();
            }
        });
    }
}
