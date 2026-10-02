package com.example.waspwingtempctrl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.waspwingtempctrl.ui.ChartLoader;
import com.example.waspwingtempctrl.ui.ConfigFormFragment;
import com.example.waspwingtempctrl.ui.ConfigPreInflater;
import com.example.waspwingtempctrl.ui.EdgeToEdge;
import com.example.waspwingtempctrl.ui.LogFragment;
import com.example.waspwingtempctrl.ui.Motion;
import com.example.waspwingtempctrl.ui.StatusFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 应用外壳：标题栏（标题 + 右侧设置按钮）+ 页面容器 + 底部页签栏（状态 / 配置 · 曲线 / 日志）。
 *
 * <p>本类<b>不含任何业务</b>：部署动作在 {@link StatusFragment}（I5 边界在那里），配置与曲线
 * 在 {@code ConfigFormFragment}（曲线是它的子 Fragment），日志在 {@code LogFragment}，
 * 界面参数（「[4] 界面」组）在 {@link SettingsActivity}。
 *
 * <p>启动时序（落页判定 / 预热的并行结构与有界等待、参数区露面闸门）与界面外壳（三页结构、
 * {@link PageAware} 广播口径）见 {@code app/逻辑说明.md} §5.1 / §5.2 / §9.1。
 *
 * <p><b>页签数量与顺序必须与 {@link #MENU_IDS} 一一对应</b>（同为 3 个、同序），菜单顺序声明在
 * {@code res/menu/menu_bottom.xml}。
 *
 * <p>配置页参数区露出前的那段空窗不出现"半成品"；曾用于遮盖它的"骨架占位层"已整套删除
 * （2026-09-26，见 {@code app/逻辑说明.md} §5.2）。
 */
public class SetupActivity extends AppCompatActivity {

    private static final String KEY_TAB = "ww_selected_tab";

    /** 起始页设定（界面参数键，type=enum）：文本值 {@code status|config|log}，出厂 {@code config}。 */
    private static final String KEY_UI_START_PAGE = "UI_START_PAGE";
    /** 「需要重新部署时先落状态页」开关（界面参数键，type=switch）：出厂 1（开）。 */
    private static final String KEY_UI_DEPLOY_ENTRY = "UI_DEPLOY_ENTRY";
    /** 动画速度倍率（界面参数键，type=int×100，0.5×–2×）：出厂 100（=1.0×）。 */
    private static final String KEY_UI_ANIM_SPEED = "UI_ANIM_SPEED";

    /** 页序号参数名（写进各页 Fragment 的 arguments，可见性广播时反查用）。 */
    static final String ARG_PAGE = "ww_page";

    /** 底栏菜单项 id，顺序即页序，必须与 {@code res/menu/menu_bottom.xml} 一致。 */
    private static final int[] MENU_IDS = {R.id.tab_status, R.id.tab_config, R.id.tab_log};

    /** 读不到配置时的出厂起始页（与 {@code params.json} 的 {@code UI_START_PAGE} factory 一致）。 */
    private static final int DEFAULT_START_TAB = R.id.tab_config;

    /** 落页判定线程：进程级一个。 */
    private static final ExecutorService PRELOAD = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ww-preload");
        thread.setDaemon(true);
        return thread;
    });
    /** 曲线预热线程：进程级一个，与判定同时起跑、单独一根（理由见 {@code app/逻辑说明.md} §5.1）。 */
    private static final ExecutorService WARMUP = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ww-chart-warmup");
        thread.setDaemon(true);
        return thread;
    });
    /** 曲线预热是否已提交（见 {@link #preload}：进程级只跑一次）。判定不在此列，每次 onCreate 都要跑。 */
    private static final AtomicBoolean WARMED = new AtomicBoolean();
    /** 预热算出的落页页序号；{@code -1} = 还没算出来。static、不随 Activity 重建清零。 */
    private static final AtomicInteger LANDING_INDEX = new AtomicInteger(-1);
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** 落页判定的等待上界（毫秒）：超时即由占位页顶上、判定回来再纠正（取值理由见 {@code app/逻辑说明.md} §5.1）。 */
    private static final long LANDING_WAIT_MS = 50L;

    private BottomNavigationView nav;
    private ViewPager2 pager;

    /** 底栏与 pager 互相驱动时的防重入标记（两者任一变化都会回调对方）。 */
    private boolean syncing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 启动耗时记账的原点：越早越准（本行之前只剩系统框架的时间，我方无更早的钩子）
        StartupTiming.begin();
        // 必须在 super.onCreate() 之前：AppCompatActivity 会在自己的 onCreate 里校验主题。
        setTheme(R.style.Theme_B6XTempCtrl);
        // 首行预热（只用 Application Context 与静态执行器，故 super.onCreate() 之前安全）；同步点在此建好交给预热线程，见 app/逻辑说明.md §5.1
        CountDownLatch landingDone = savedInstanceState == null ? new CountDownLatch(1) : null;
        preload(this, landingDone);
        super.onCreate(savedInstanceState);
        preInflate();
        setContentView(R.layout.activity_setup);

        pager = findViewById(R.id.page_pager);
        nav = findViewById(R.id.bottom_nav);
        // 下侧沉浸式：底栏背景铺到屏幕底，条目留在系统手势条之上（见 ui/EdgeToEdge）
        EdgeToEdge.apply(this, findViewById(R.id.setup_root), nav);
        pager.setAdapter(new PagesAdapter());
        pager.setOffscreenPageLimit(MENU_IDS.length - 1);
        armPageViewMarks();

        nav.setOnItemSelectedListener(item -> {
            setPage(indexOf(item.getItemId()));
            return true;
        });

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // 记账（旁路）：首轮 onPageSelected 落在哪一刻（首次写入胜出，后续翻页不会改写）
                StartupTiming.mark(StartupTiming.MARK_PAGE_SELECTED);
                // 底栏跟随滑动结果；此处改底栏会回调上面的监听器，故加防重入标记
                syncing = true;
                nav.setSelectedItemId(MENU_IDS[position]);
                syncing = false;
                broadcastVisibility();
            }
        });

        // 界面参数（「[4] 界面」组）的入口：标题栏右侧设置按钮
        findViewById(R.id.action_settings).setOnClickListener(v ->
                startActivity(new Intent(this, SettingsActivity.class)));

        settleInitialPage(savedInstanceState, landingDone);
        // 首帧之后再广播一次：此刻页面视图才建好（ViewPager2 在布局中创建页面）
        pager.post(this::broadcastVisibility);
        // 记账（旁路）：主线程这段壳工作到此为止；再挂一个一次性回调量"页面区第一次绘制前"
        StartupTiming.mark(StartupTiming.MARK_ONCREATE_END);
        markFirstDraw();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 回前台或页面被系统重建后重发一次：页面自己记的可见性状态可能已经丢了
        broadcastVisibility();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (pager != null) {
            outState.putInt(KEY_TAB, pager.getCurrentItem());
        }
    }

    // ==================== 预热 ====================

    /**
     * 提交"控件预制造"（与落页判定、曲线预热并列的第三件后台活，失败或没赶上均无副作用）：
     * 提交点须在 {@code super.onCreate()} 之后（那时才有 AppCompat 视图工厂），理由见
     * {@code app/逻辑说明.md} §5.1；本方法只交 {@code this}，克隆与关门在 {@link ConfigPreInflater}。
     */
    private void preInflate() {
        ConfigPreInflater.start(getApplicationContext(), this);
    }

    /**
     * 进程级预热：落页判定与曲线预热各在自己那根线程上同时起跑、互不阻塞；"判定最先唤醒主线程"
     * 的结构性保证、优先级处理与失败无副作用，见 {@code app/逻辑说明.md} §5.1。
     *
     * @param landingDone 本次冷启动等落页判定的同步点；判定算完即 {@code countDown}。<b>只覆盖判定
     *                    这一步</b>（曲线预热在另一根线程上，主线程不必也不该等它）。进程重建（saved
     *                    state 非空）不需要判定 —— 落页取回上次那一页即可，传 {@code null}
     */
    private static void preload(SetupActivity activity, CountDownLatch landingDone) {
        Context app = activity.getApplicationContext();
        // 判定先提交：先提交的先被创建并启动，让判定早一步待跑（这只是顺序偏好，不是调度保证 ——
        // "判定最先唤醒主线程"靠的是 countDown 只可能由判定任务发出，与谁先跑无关）
        if (landingDone != null) {
            PRELOAD.execute(() -> {
                long startedAt = StartupTiming.now();
                int landing;
                try {
                    landing = landingPageIndex(app);
                } catch (Throwable t) {
                    landing = indexOf(DEFAULT_START_TAB);   // 兜底：判定挂了也不能让落页悬着
                }
                StartupTiming.span(StartupTiming.LANDING, startedAt);
                LANDING_INDEX.set(landing);
                StartupTiming.mark(StartupTiming.MARK_LANDING_WAKE);
                landingDone.countDown();   // 判定一到手就放行主线程
                // 拷一份给 lambda 捕获：上面的 try/catch 有两处赋值，landing 本身不是 effectively final
                final int landingForMain = landing;
                MAIN.post(() -> activity.applyLanding(landingForMain));
            });
        }
        // 曲线预热：进程级只跑一次（判定不在此列，每次 onCreate 都要跑）
        if (WARMED.compareAndSet(false, true)) {
            WARMUP.execute(() -> {
                // 先在默认优先级下碰一次配置单例（它内部有 synchronized 构造；降优先级后再构造会让低优先级线程持锁挡住判定，见 app/逻辑说明.md §5.1）
                try {
                    ConfigStore.get(app);
                } catch (Throwable ignored) {
                    // 建不起来也无所谓：下面 warmUp 自己还会再试一次，失败照旧无副作用
                }
                // 界面动效速度倍率：进程一次、后台线程读界面参数后喂给 Motion（读不到退回 1.0）
                applyMotionSpeed(app);
                try {
                    // 降为后台优先级：主线程那次有界等待（≤50ms）优先于"把曲线缓存备好"。
                    // 设备有空闲核时两者并不冲突；争抢时让判定先跑，预热晚一点完成（最坏即退回现状）。
                    Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                } catch (Throwable ignored) {
                    // 降不下去也不影响：最坏就是与判定等权争抢
                }
                ChartLoader.warmUp(app);
            });
        }
    }

    /** 摘掉一次性绘制回调（视图树观察者已死时什么都不做，它自己会随视图树一起消失）。 */
    private static void detach(ViewTreeObserver observer, ViewTreeObserver.OnPreDrawListener listener) {
        if (observer.isAlive()) {
            observer.removeOnPreDrawListener(listener);
        }
    }

    /**
     * 记账（旁路）：量第一页 / 第三页视图建好的时刻（{@code recursive=false}，只收三个页签、不算子
     * Fragment）；含义见 {@code app/逻辑说明.md} §5.3。
     */
    private void armPageViewMarks() {
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(
                new FragmentManager.FragmentLifecycleCallbacks() {
                    private int created;

                    @Override
                    public void onFragmentViewCreated(@NonNull FragmentManager fm, @NonNull Fragment f,
                                                      @NonNull View v, @Nullable Bundle savedInstanceState) {
                        created++;
                        if (created == 1) {
                            StartupTiming.mark(StartupTiming.MARK_PAGE_VIEW_1);
                        } else if (created == MENU_IDS.length) {
                            StartupTiming.mark(StartupTiming.MARK_PAGE_VIEW_ALL);
                        }
                    }
                }, false);
    }

    /**
     * 记账（旁路）：量"页面区第一次绘制之前"（一次性回调，记完即摘）；含义见 {@code app/逻辑说明.md} §5.3。
     */
    private void markFirstDraw() {
        final ViewTreeObserver observer = pager.getViewTreeObserver();
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                StartupTiming.mark(StartupTiming.MARK_FIRST_DRAW);
                detach(observer, this);
                return true;
            }
        });
    }

    // ==================== 启动落页 ====================

    /**
     * 落页（{@code onCreate} 调一次）：进程重建取回上次那一页；冷启动有界等判定一手，等不到先用
     * 占位页、判定到达后 {@link #applyLanding} 纠正。不播放入场动画。见 {@code app/逻辑说明.md} §5.1。
     *
     * @param landingDone 预热线程的落页判定同步点；{@code null} = 本次不需要判定（进程重建）
     */
    private void settleInitialPage(Bundle savedInstanceState, CountDownLatch landingDone) {
        int initial;
        if (savedInstanceState != null) {
            initial = savedInstanceState.getInt(KEY_TAB, 0);
        } else {
            int decided = awaitLanding(landingDone);
            initial = decided >= 0 ? decided : indexOf(DEFAULT_START_TAB);
        }
        if (initial < 0 || initial >= MENU_IDS.length) {
            initial = 0;
        }
        syncing = true;
        pager.setCurrentItem(initial, false);
        nav.setSelectedItemId(MENU_IDS[initial]);
        syncing = false;
    }

    /**
     * 取落页判定：本进程早先已算过就直接用、一秒不等；否则有界等预热线程一手（{@link #LANDING_WAIT_MS}
     * 是硬上界）。返回 {@code -1} = 没等到，调用方用占位页顶上。见 {@code app/逻辑说明.md} §5.1。
     */
    private static int awaitLanding(CountDownLatch landingDone) {
        // 记账（旁路）：主线程进有界等待那一刻（与"判定放行"相减 = onCreate 里白等的那段）
        StartupTiming.mark(StartupTiming.MARK_LANDING_AWAIT);
        int decided = LANDING_INDEX.get();
        if (decided >= 0 || landingDone == null) {
            return decided;
        }
        try {
            landingDone.await(LANDING_WAIT_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();   // 中断不吞：按"没等到"立刻返回，不再续等
        }
        return LANDING_INDEX.get();
    }

    /** 预热线程算出的落页判定到达（主线程）：纠正占位页；与当前页相同时什么都不做（不闪）。 */
    private void applyLanding(int index) {
        // 越界就不纠正，停在占位页：判定的两个来源都是 indexOf（见 landingPageIndex），
        // menu_bottom.xml 与 MENU_IDS 一旦漂移就会返回 -1，取下标前必须与 settleInitialPage 同口径地拦一道
        if (pager == null || isDestroyed() || index < 0 || index >= MENU_IDS.length) {
            return;
        }
        if (index == pager.getCurrentItem()) {
            return;
        }
        syncing = true;
        pager.setCurrentItem(index, false);
        nav.setSelectedItemId(MENU_IDS[index]);
        syncing = false;
    }

    /**
     * 落页判定的判据（<b>只在后台线程调</b>）：部署入口开关为开且 {@link Deployer#needsRedeploy} 为真
     * → 落状态页；否则 {@link #KEY_UI_START_PAGE} 的起始页。不跑 su 真探测、不自动跳页。
     * 见 {@code app/逻辑说明.md} §5.1。
     */
    private static int landingPageIndex(Context context) {
        if (isDeployEntryEnabled(context) && Deployer.needsRedeploy(context)) {
            return indexOf(R.id.tab_status);
        }
        return indexOf(startPageTabId(context));
    }

    /**
     * {@link #KEY_UI_START_PAGE} 的文本值 → 页签 id。<b>显式映射</b>而非复用页序下标：
     * {@link #MENU_IDS} 的顺序将来若有变动，这里不会静默错位。未读到或不认识的值 → 出厂
     * {@link #DEFAULT_START_TAB}。
     */
    private static int startPageTabId(Context context) {
        ConfigStore.Value value = ConfigStore.get(context).get(KEY_UI_START_PAGE);
        String text = value == null ? "" : value.text().trim();
        switch (text) {
            case "status":
                return R.id.tab_status;
            case "log":
                return R.id.tab_log;
            default:
                return DEFAULT_START_TAB;
        }
    }

    /**
     * 读 {@link #KEY_UI_ANIM_SPEED}（int×100）并喂给 {@link Motion} 的速度倍率；键缺失/未定义（返回
     * {@code null}）、读盘异常、非法值一律退回 1.0。倍率在进程内只于启动时读一次（改设置需重启生效）。
     */
    private static void applyMotionSpeed(Context context) {
        try {
            ConfigStore.Value value = ConfigStore.get(context).get(KEY_UI_ANIM_SPEED);
            Motion.setSpeedMultiplier(value == null ? 1f : value.intAt(0) / 100f);
        } catch (Throwable t) {
            Motion.setSpeedMultiplier(1f);
        }
    }

    /**
     * {@link #KEY_UI_DEPLOY_ENTRY} 是否开：switch 型在定义里是 0/1 数值（见 params.json）。读不到 → 出厂 1。
     *
     * <p><b>自动更新开着时本项按"关"处理（压制，不写回配置文件）</b>——静默重部署本就由状态页在
     * 后台探测里完成（三页启动即建，见 {@code app/逻辑说明.md} §5.1 / §8.1），不必再导用户去状态页。
     * <b>唯 root 尚未取得时例外</b>：那一次仍按存值生效，好让用户落到状态页去拿 root 授权与首次部署；
     * root 取得后不再例外，root 丢失（探测到 su 不通）后自动恢复为例外。
     * 见 {@code app/逻辑说明.md} §5.1 与 §9.3。
     */
    private static boolean isDeployEntryEnabled(Context context) {
        if (Deployer.isAutoUpdateEnabled(context) && !Deployer.rootNotYetGranted(context)) {
            return false;
        }
        ConfigStore.Value value = ConfigStore.get(context).get(KEY_UI_DEPLOY_ENTRY);
        return value == null || value.intAt(0) != 0;
    }

    // ==================== 页签与翻页 ====================

    /** 菜单项 id → 页序号；不属于本菜单时返回 -1。 */
    private static int indexOf(int itemId) {
        for (int i = 0; i < MENU_IDS.length; i++) {
            if (MENU_IDS[i] == itemId) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 切到第 {@code index} 页（底栏点击用）。翻页动画即 ViewPager2 的平滑滚动，不再手写转场。
     * 防重入：底栏由 onPageSelected 反向同步时不回推，避免两者互相触发。
     */
    private void setPage(int index) {
        if (syncing || index < 0 || index >= MENU_IDS.length) {
            return;
        }
        if (pager.getCurrentItem() != index) {
            pager.setCurrentItem(index, true);
        }
    }

    /**
     * 广播页面可见性：只有当前页收 true；遍历 FragmentManager 实例、按 {@link #ARG_PAGE} 反查页序号
     * （不依赖 FragmentStateAdapter 内部 tag）。见 {@code app/逻辑说明.md} §9.1。
     */
    private void broadcastVisibility() {
        int current = pager == null ? 0 : pager.getCurrentItem();
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (!(fragment instanceof PageAware)) {
                continue;
            }
            Bundle args = fragment.getArguments();
            int page = args == null ? -1 : args.getInt(ARG_PAGE, -1);
            ((PageAware) fragment).onPageVisible(page == current);
        }
    }

    /** 三页一份：页序号 → Fragment。页序号顺手写进 arguments 供可见性广播反查。 */
    private final class PagesAdapter extends FragmentStateAdapter {

        PagesAdapter() {
            super(SetupActivity.this);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment = create(position);
            Bundle args = new Bundle();
            args.putInt(ARG_PAGE, position);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getItemCount() {
            return MENU_IDS.length;
        }
    }

    private static Fragment create(int index) {
        switch (index) {
            case 0:
                return new StatusFragment();
            case 1:
                return new ConfigFormFragment();
            default:
                return new LogFragment();
        }
    }
}
