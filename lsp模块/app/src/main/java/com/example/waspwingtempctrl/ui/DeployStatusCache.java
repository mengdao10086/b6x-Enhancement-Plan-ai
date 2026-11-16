package com.example.waspwingtempctrl.ui;

import android.content.Context;

import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.Deployer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 部署状态的进程内缓存：启动时后台预取一次，状态页建好视图就先拿它上屏，再由原有探测刷新覆盖。
 *
 * <p><b>只存「探测成功」的文本</b>（与状态区同源的 {@link Deployer.Status#describe()} 一份），
 * 失败不写缓存、旧值原样保留；失败提示仍由状态页既有的两条分支负责（静默探测限频记一条，
 * 手动/首探失败弹对话框）。
 *
 * <p><b>陈旧不等于作废</b>：超过 {@link #STALE_MS} 只标记「陈旧」，文本照样先显示，
 * 后台刷新随后交叉淡入替换——不退回空白骨架。时间戳同时给状态页做「刚探过」的节流依据。
 *
 * <p>调用线程：{@link #prefetch} 可在主线程调（只提交任务，不碰 IO/root）；
 * {@link #store} 在探测线程调；其余读取方法主线程调，内部只保护一对字段。
 */
final class DeployStatusCache {

    /** 陈旧阈值：与状态页静默刷新的 30 秒节流同口径（见 StatusFragment.PROBE_MIN_INTERVAL_MS）。 */
    static final long STALE_MS = 30_000L;

    /** 预取线程：进程级一根、守护线程；预取失败无副作用，不进状态页的忙态。 */
    private static final ExecutorService EXEC = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ww-deploy-prefetch");
        thread.setDaemon(true);
        return thread;
    });

    /** 进程级只预取一次：视图重建（旋转、返回本页）不重复打 su。 */
    private static final AtomicBoolean PREFETCHED = new AtomicBoolean();

    private static final Object LOCK = new Object();

    /** 最近一次成功探测的文本；null = 进程内还没有过成功结果。 */
    @Nullable
    private static String text;
    /** {@link #text} 的产生时刻（ms）；0 = 从未成功。 */
    private static long atMs;

    private DeployStatusCache() {
    }

    /**
     * 启动预取：后台探一次部署状态放进缓存（进程级只提交一次，失败静默）。
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
                // 状态页可能已经探完并回写过（落页恰为状态页时会并行）：不拿更早的快照覆盖
                if (text() == null) {
                    store(status.describe());
                }
            } catch (Throwable ignored) {
                // 预取失败不写缓存：状态页自己的探测会走既有失败分支提示
            }
        });
    }

    /** 记录一次成功的探测结果（状态页每次探测成功都回写，供下次进页先上屏）。 */
    static void store(String value) {
        if (value == null || value.isEmpty()) {
            return;
        }
        synchronized (LOCK) {
            text = value;
            atMs = System.currentTimeMillis();
        }
    }

    /** 最近一次成功的文本；从未成功返回 null（调用方回退到预填充骨架）。 */
    @Nullable
    static String text() {
        synchronized (LOCK) {
            return text;
        }
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
}
