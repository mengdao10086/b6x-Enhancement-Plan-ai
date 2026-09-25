package com.example.waspwingtempctrl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

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
 * 界面参数（原「[4] 界面」组）在 {@link SettingsActivity}。
 *
 * <p><b>为什么在 onCreate 里 setTheme</b>：{@code AndroidManifest.xml} 无 {@code android:theme}，
 * 而 {@link AppCompatActivity} 要求 AppCompat/Material 主题。故在 {@code super.onCreate()}
 * 之前手动应用 {@code R.style.Theme_B6XTempCtrl}。代价：onCreate 之前的一瞬仍是系统默认窗口背景（无碍）。
 *
 * <p><b>预热</b>：{@code onCreate} 首行就把"落页判定"与"曲线首帧"的重活交给后台线程（{@link #preload}），
 * 主线程不再为"落哪一页"读 {@code params.json} 与 {@code profile.conf}、算资产 MD5、首读
 * {@code SharedPreferences}。落页判定另有 {@link #LANDING_WAIT_MS} 的有界等待：拿到判定就直接落定
 * 最终那一页（无纠正动作，也就不会闪），拿不到才先用占位页、由 {@link #applyLanding} 事后纠正。
 * <b>两件事各在自己那根线程上同时起跑</b>（判定在 {@link #PRELOAD}、曲线预热在 {@link #WARMUP}）：
 * 放行主线程的那次 {@code countDown} 只可能由判定任务发出，判定那根线程上除判定外也别无他活 ——
 * 这是"判定仍最先唤醒主线程"的结构性保证（不靠调度让路）。预热线程降为后台优先级，但它碰<b>共享</b>的
 * 配置单例（那一段带锁）时仍在默认优先级（见 {@link #preload}）；剩下的只有纯粹的 CPU 争抢 ——
 * 设备有空闲核时不成立，单核或核被占满时判定可能被拉长（真机未测）。
 *
 * <p><b>骨架占位层</b>：真页面的内容（尤其配置页那份几十行表单）要几百毫秒才建出来，这段空窗里页面区是白的。
 * 故上一轮启动时把三页各自「已建好、还没绑具体数据」的样子截下来存盘（{@link SkeletonStore}），本次启动
 * 先把落定那一页的截图盖在页面区上（{@link #showSkeleton}），等<b>当前这页就绪</b>再撤
 * （{@link #applySkeleton}）。覆盖层 {@code setClickable(false)}，翻页与滚动手势照旧落到下面的真页面。
 *
 * <p><b>「就绪」的口径</b>（截图与撤层共用同一个判据，见 {@link #pageReady}）：<b>可见结构</b>已建好、
 * 还没有具体数据的那个状态。状态页与日志页的结构就是 inflate 出来的，视图一有即就绪；配置页的表单是异步
 * 建出来的，要等它把"看得见的那部分"建完（各组卡头与它们的值，见
 * {@link ConfigFormFragment#isStructureReady()}）——配置页默认全部折叠，折叠体里那几十行随后才建，
 * 但那不影响本页的判断：盖在页面上的骨架图与撤层后露出的界面都是折叠态，两者对齐。
 * 此外<b>任何翻页动作都立刻撤掉占位层</b>：它盖的是落定那一页的骨架，翻到别页就不再成立。
 *
 * <p><b>页签数量与顺序必须与 {@link #MENU_IDS} 一一对应</b>（同为 3 个、同序），菜单顺序声明在
 * {@code res/menu/menu_bottom.xml}。
 *
 * <p><b>切页 = ViewPager2</b>：手指跟随滑动、松手 fling 吸附到最近页，都由它给（页面容器是
 * {@code androidx.viewpager2.widget.ViewPager2}）。三页由 {@link FragmentStateAdapter} 持有，
 * {@code offscreenPageLimit = 2} 让三页都留在 FragmentManager 里（页面状态与滚动位置保住）。
 *
 * <p>代价：<b>页面生命周期不再随切页变化</b>（非当前页被压到 STARTED，不派发 onPause，
 * 也没有 hide/show 的 onHiddenChanged）。需要在"离开本页"时停定时器/归还软键盘设置的页面，
 * 实现 {@link PageAware}，由本类在切页后广播可见性。页序号经 {@link #ARG_PAGE} 写进 Fragment
 * 的 arguments：进程恢复后重建的实例也照样能算出自己是第几页。
 */
public class SetupActivity extends AppCompatActivity {

    private static final String KEY_TAB = "ww_selected_tab";

    /** 起始页设定（界面参数键，type=enum）：文本值 {@code status|config|log}，出厂 {@code config}。 */
    private static final String KEY_UI_START_PAGE = "UI_START_PAGE";
    /** 「需要重新部署时先落状态页」开关（界面参数键，type=switch）：出厂 1（开）。 */
    private static final String KEY_UI_DEPLOY_ENTRY = "UI_DEPLOY_ENTRY";

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
    /**
     * 曲线预热线程：进程级一个，与判定<b>同时</b>起跑（见 {@link #preload}）。
     *
     * <p>单独一根而不与 {@link #PRELOAD} 共用：判定是"主线程在等它"，预热只是纯优化，两者的优先级
     * 完全不同；共用一根就是串行，共用一个池则将来有人再塞任务进来就可能把"判定不能等"的保证破坏。
     */
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

    /**
     * 落页判定的等待上界（毫秒）：见 {@link #settleInitialPage}。
     *
     * <p>取 50ms 是因为两头的余量都够：判定这一步只有建 {@link ConfigStore} 单例、读一次配置、
     * 一次资产哈希（都在 {@code assets} 与私有小文件上），正常设备是十几到几十毫秒量级；而主线程
     * 在 {@code onCreate} 里已经先做掉 {@code setContentView} / adapter / 监听器那一串，给了预热线程
     * 一段真实的前置时间。等到了就与"当场判定"等价 —— 没有纠正动作，也就不会闪。等不到也<b>不是
     * 无界等</b>：满 50ms 一定返回，超时后由占位页先顶上、判定回来再 {@link #applyLanding} 纠正，
     * 故不会把主线程卡在首帧上。
     */
    private static final long LANDING_WAIT_MS = 50L;

    /**
     * 骨架占位层最长存在时间（毫秒）——硬上界：解码没回来、绘制回调不派发、当前页迟迟不就绪，都必须撤，
     * 不能一直盖着。
     *
     * <p>取 5 秒而不是 1.5 秒：本层正常路径的寿命由"当前页就绪"决定，配置页在慢机上建表可能超过 1.5 秒，
     * 上界若卡在那之前就会抢在真内容前面把白页露出来——那正是这一层要挡的东西。上界只用于兜底。
     */
    private static final long OVERLAY_MAX_MS = 5000L;

    private BottomNavigationView nav;
    private ViewPager2 pager;

    /** 骨架占位层（只盖 pager 那一片的覆盖层）；{@code null} = 当前没有。 */
    private ImageView overlay;

    /** 占位层画的是第几页；{@code -1} = 没有层。翻页判定要用它比页号（见 {@link #hideSkeleton} 的调用点）。 */
    private int overlayPage = -1;

    /** 底栏与 pager 互相驱动时的防重入标记（两者任一变化都会回调对方）。 */
    private boolean syncing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 启动耗时记账的原点：越早越准（本行之前只剩系统框架的时间，我方无更早的钩子）
        StartupTiming.begin();
        // 必须在 super.onCreate() 之前：AppCompatActivity 会在自己的 onCreate 里校验主题。
        setTheme(R.style.Theme_B6XTempCtrl);
        // 首行预热：越早提交，后台越能吃到下面这些主线程工作的空档。只用到 Application Context
        // 与静态执行器，故放在 super.onCreate() 之前是安全的（见 preload）。
        // 同步点也在这里建好交给预热线程：落页判定算完即唤醒（见 settleInitialPage 的有界等待）
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
                // 翻了页：占位层盖的是落定那一页的骨架，换页即失效，立刻撤（不必等"就绪"）。
                // 只比页号、不看"回调来了没"：初始那次 setCurrentItem 也会回一次 onPageSelected
                // （同一个页号），按"任何回调都撤"写会把刚要上屏的那层误杀
                if (position != overlayPage) {
                    hideSkeleton();
                }
                // 底栏跟随滑动结果；此处改底栏会回调上面的监听器，故加防重入标记
                syncing = true;
                nav.setSelectedItemId(MENU_IDS[position]);
                syncing = false;
                broadcastVisibility();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 手指一压（DRAGGING）就撤：拖动期间新旧两页同时在屏上，一张盖满 pager 区的静态图
                // 必然穿帮，不能等到 onPageSelected。只认 DRAGGING（用户的动作）：程序性跳页走
                // IDLE→SETTLING，那条路交给上面的页号判定，免得初始落页的杂音把这一层误杀
                if (state == ViewPager2.SCROLL_STATE_DRAGGING) {
                    hideSkeleton();
                }
            }
        });

        // 界面参数（原「[4] 界面」组）的入口：标题栏右侧设置按钮
        findViewById(R.id.action_settings).setOnClickListener(v ->
                startActivity(new Intent(this, SettingsActivity.class)));

        settleInitialPage(savedInstanceState, landingDone);
        // 首帧之后再广播一次：此刻页面视图才建好（ViewPager2 在布局中创建页面）
        pager.post(this::broadcastVisibility);
        // 骨架占位层（口径见类注释）：图与当前外观配套就先挂上（解图在后台），不配套则等三页都就绪后重截
        showSkeleton(pager.getCurrentItem());
        armSkeletonCapture();
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
     * 提交"控件预制造"（{@link ConfigPreInflater}）：与落页判定、曲线预热并列的第三件后台活，
     * 趁主线程忙首帧的时候把配置页要 inflate 的键行控件先造出来放着（主线程取不到就现场造，
     * 故它失败或没赶上都没有副作用）。
     *
     * <p><b>为什么提交点在这里，而不在 {@link #preload} 里</b>：预制造要用的 inflater 必须带上
     * AppCompat/Material 装好的视图工厂（否则 {@code <TextView>} 造出来的是基类而不是
     * {@code MaterialTextView}，预制造件就与现场造的不是同一种控件、也不是同一套样式），
     * 而那个工厂是 {@code AppCompatActivity.onCreate} 里装的——{@code preload} 在
     * {@code super.onCreate()} 之前跑，那时还没有工厂。故提交点放在 {@code super.onCreate()} 之后
     * （约第 25ms），到建表起点仍有三百多毫秒的余量。
     *
     * <p>本方法只交"这是谁的件"（{@code this}）：克隆 inflater、归属比对、关门都在
     * {@link ConfigPreInflater} 里做。克隆的来源是 Activity 自己那一份（与页面的
     * {@code getLayoutInflater()} 同源、同一个 Context 与主题），故造出来的控件与现场造的逐像素一致；
     * 那份 inflater 只许后台那一根线程用（LayoutInflater 不能跨线程共用）。与主线程共用 AppCompat
     * 视图工厂这一层的边界与警告，写在 {@link ConfigPreInflater} 的类注释里。
     */
    private void preInflate() {
        ConfigPreInflater.start(getApplicationContext(), this);
    }

    /**
     * 进程级预热：<b>两件事各在自己那根线程上同时起跑</b>，互不阻塞。
     *
     * <ol>
     *   <li><b>落页判定</b>（{@link #landingPageIndex}，{@link #PRELOAD}）：要建 {@link ConfigStore}
     *       单例（读并解析 {@code assets/params.json}）、整份读 {@code profile.conf}、算资产 MD5，
     *       还要首读 {@code SharedPreferences}。这四件原先全在 {@code onCreate} 的主线程链上，只为定
     *       "落哪一页"；</li>
     *   <li><b>曲线首帧</b>（{@link ChartLoader#warmUp}，{@link #WARMUP}）：曲线口径与数据文件的第一次
     *       读取 + 解析。原先它与判定串在同一根线程上、排在判定之后，被白白推迟一个判定的时长。</li>
     * </ol>
     * 判定算完就 {@code countDown} 放行等它的主线程（{@link #settleInitialPage} 的有界等待），再回主线程
     * {@link #applyLanding} 兜底纠正。判定那根线程上<b>除判定外再无别的活</b>，且预热线程在预热的其余部分
     * 都是后台优先级 —— 剩下的只有纯粹的 CPU 争抢（口径见类注释的〈预热〉一段）。
     *
     * <p>预热<b>失败无副作用</b>：{@link ChartLoader#warmUp} 自己吞掉一切异常且什么都留不下，曲线页随后
     * 照旧自己读一次、失败时照旧把诊断原文铺在曲线区（既有路径逐字不变）。
     *
     * @param landingDone 本次冷启动等落页判定的同步点；判定算完即 {@code countDown}。<b>只覆盖判定
     *                    这一步</b>（曲线预热在另一根线程上，主线程不必也不该等它）。进程重建（saved
     *                    state 非空）不需要判定 —— 落页取回上次那一页即可，传 {@code null}（判定任务
     *                    整个不提交，免得白等满上界）
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
                // 先在默认优先级下把配置单例碰出来：它内部有一段 synchronized 构造（读并解析 45KB
                // params.json），而判定那根线程要的第一件东西就是它（landingPageIndex 先取起始页开关）。
                // 若降到后台优先级之后才触发构造，就可能出现"nice=10 的预热线程持锁解析、nice=0 的判定
                // 线程在监视器上等它"——后台线程被限流时，等的就是被拉长的整段解析，与"让判定先跑"
                // 正好相反。这一步不比原有路径多做任何事：ChartConfig.load 下面本来也要碰它。
                try {
                    ConfigStore.get(app);
                } catch (Throwable ignored) {
                    // 建不起来也无所谓：下面 warmUp 自己还会再试一次，失败照旧无副作用
                }
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

    // ==================== 骨架占位层 ====================

    /**
     * 装上骨架占位层（主线程，{@code onCreate} 里调；图的存取见 {@link SkeletonStore}）。
     *
     * <p><b>只盖 pager 那一片</b>：给 pager 现包一个 FrameLayout，覆盖层与它同格。外壳布局与资源都不动
     * ——包出来的 FrameLayout 直接顶替 pager 在 {@code setup_root} 里的位置与 {@code weight}，
     * 几何与原来完全一致。撤覆盖层时不拆它（拆回去只多一次布局，位置本来就没变）。
     *
     * <p><b>解图在后台</b>（{@link #loadSkeleton}）：解码是 IO + 像素活，放主线程就是给首帧添堵。
     * 代价是覆盖层会先以「还没图的 ImageView」形态存在一小会儿（不可见、不吃触摸）——这段空窗是
     * 本方案的固有延迟：主线程要先忙完首帧，后台解完的图才轮得到上屏。
     *
     * <p>撤层时机见 {@link #applySkeleton}（当前页就绪）。翻页、落页纠正则在别处直接撤。
     *
     * @param page 本次落定的页序号（取落页判定的结论，不是第 0 页）
     */
    private void showSkeleton(int page) {
        Context app = getApplicationContext();
        if (!SkeletonStore.isCurrent(app)) {
            // 尺寸、夜间、字体、版本与截图那轮不同：本次不挡屏，由 armSkeletonCapture 等三页就绪后重截
            return;
        }
        ViewParent rawParent = pager.getParent();
        if (!(rawParent instanceof ViewGroup)) {
            // 布局层级被改过：宁可不显示覆盖层，也不要动一条没验证过的层级
            return;
        }
        ViewGroup parent = (ViewGroup) rawParent;
        int at = parent.indexOfChild(pager);
        ViewGroup.LayoutParams pagerParams = pager.getLayoutParams();
        parent.removeViewAt(at);
        FrameLayout holder = new FrameLayout(this);
        holder.setLayoutParams(pagerParams);
        pager.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        holder.addView(pager);

        ImageView cover = new ImageView(this);
        // 半分辨率图按 FIT_XY 拉满页面区（宽高比与截图时一致，故不会变形）
        cover.setScaleType(ImageView.ScaleType.FIT_XY);
        cover.setClickable(false);   // 不吃触摸：翻页与滚动手势照旧传给下面的真页面
        holder.addView(cover, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        parent.addView(holder, at);   // 与 pager 同格，画在它之上
        overlay = cover;
        overlayPage = page;

        // 硬上界（同时也是"post 兜底"）：解码没回来、或窗口不可见导致 pre-draw 不派发，都得撤
        pager.postDelayed(this::hideSkeleton, OVERLAY_MAX_MS);
        loadSkeleton(page);
    }

    /**
     * 后台解图（{@link SkeletonStore#load} 有 File IO 与解码）：解完回主线程换上。
     */
    private void loadSkeleton(int page) {
        Context app = getApplicationContext();
        Thread thread = new Thread(() -> {
            Bitmap bitmap = SkeletonStore.load(app, page);
            MAIN.post(() -> applySkeleton(bitmap));
        }, "ww-skeleton-load");
        thread.setDaemon(true);   // 只是个占位图：进程要退时不必等它
        thread.start();
    }

    /**
     * 占位图到手（主线程）：换上，并在「当前页就绪」时撤下（另加"至少上屏一帧"与硬上界两条边界）。
     *
     * <p>撤的时机有两个坑，各用一句话说明为什么这么写：
     * <ul>
     *   <li>pre-draw 在绘制<b>之前</b>派发，换完图顺手就撤等于同一帧里又撤掉、这张图从没上过屏；
     *       故放过第一次 pre-draw（那一帧正是把占位图画出来的）之后再谈撤。</li>
     *   <li>撤的判据是<b>当前这页就绪</b>（见类注释的口径），不是"画过一帧"——配置页落页时它要一直
     *       盖到表单建出来那一刻，那正是用户看到白页的那段空窗。就绪由
     *       {@link #pageReady} 判，逐帧看一眼（这段时间通常几百毫秒）。</li>
     * </ul>
     *
     * <p>硬上界已在 {@link #showSkeleton} 挂上，负责兜住"解码没回来"、"pre-draw 不派发"与
     * "当前页迟迟不就绪"三种情况；上界撤层后本监听在下一帧发现自己盖的那层没了，自行退场。
     */
    private void applySkeleton(Bitmap bitmap) {
        if (overlay == null || isDestroyed()) {
            return;   // 已撤下（硬上界 / 翻页 / 落页纠正先到）：这张图没人要了
        }
        if (bitmap == null || currentPageReady()) {
            // 没图可盖；或者真页面已经就绪（图来得太晚）——两种都没得可挡，立刻撤干净
            hideSkeleton();
            return;
        }
        overlay.setImageBitmap(bitmap);
        // 记账（旁路）：占位图真上屏那一刻（量"首帧 334 那一帧画的到底是骨架还是白页"）
        StartupTiming.mark(StartupTiming.MARK_SKELETON_UP);
        final ViewTreeObserver observer = pager.getViewTreeObserver();
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /** 第一次 pre-draw = 这一帧才要把占位图画出来，此时撤等于没画。 */
            private boolean painted;

            @Override
            public boolean onPreDraw() {
                if (overlay == null) {
                    detach(observer, this);   // 已被别处撤掉：监听退场
                    return true;
                }
                if (!painted) {
                    painted = true;
                    return true;
                }
                if (!currentPageReady()) {
                    return true;   // 真页面还没就绪：继续盖着
                }
                detach(observer, this);
                hideSkeleton();
                return true;
            }
        });
    }

    /** 撤下覆盖层（幂等）：没挂就什么都不做。包装用的 FrameLayout 不动（见 {@link #showSkeleton}）。 */
    private void hideSkeleton() {
        ImageView cover = overlay;
        if (cover == null) {
            return;
        }
        overlay = null;
        overlayPage = -1;
        ViewParent parent = cover.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(cover);
        }
        // 记账（旁路）：真撤掉了一层才记；本次启动压根没挂层时这行不会执行，展示成"—"
        StartupTiming.mark(StartupTiming.MARK_SKELETON_OFF);
    }

    /**
     * 三页都「就绪」之后取一次骨架截图（见 {@link SkeletonStore} 与类注释的口径）。
     *
     * <p>挂钩子之前先判一次键：图与当前外观配套就没什么可截的，那就不挂——省掉一个要等到视图树销毁
     * 才退场的每帧回调。键不配套才逐帧判"三页齐备且都就绪"，齐了就在这一帧截。
     *
     * <p><b>为什么不能挂在"就绪"那一刻同步截</b>：配置页的表单是刚 inflate 出来的一批子视图，
     * 要过完本帧的 measure+layout 才有尺寸，在 {@link ConfigFormFragment#isStructureReady()} 变真的
     * 那一刻直接 {@code view.draw(canvas)} 画出来是空表单（容器那时才刚置为可见）。pre-draw 在布局之后、
     * 绘制之前派发，正好卡在"建好且已布局"这一点上。
     *
     * <p>缺一页（或某页永不就绪，例如预热一直没回来）则整批不截、不写键（见
     * {@link SkeletonStore#captureIfNeeded}）：本监听就继续留着，每帧只做几次字段读与一次三元素列表
     * 遍历，不另设超时兜底——截不成这一轮就不截，下次启动重来。
     */
    private void armSkeletonCapture() {
        final Context app = getApplicationContext();
        if (SkeletonStore.isCurrent(app)) {
            return;
        }
        final ViewTreeObserver observer = pager.getViewTreeObserver();
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (!allPagesReady()) {
                    return true;   // 还有页没就绪：留着，下一帧再判
                }
                detach(observer, this);
                SkeletonStore.captureIfNeeded(app, pageRoots());
                return true;
            }
        });
    }

    /** 三页是否都已「就绪」：根视图都在（非配置页的结构就是 inflate 出来的，视图在即就绪）+ 配置页表单已建。 */
    private boolean allPagesReady() {
        View[] roots = pageRoots();
        for (int i = 0; i < roots.length; i++) {
            if (roots[i] == null || !pageReady(i)) {
                return false;
            }
        }
        return true;
    }

    /** 本次显示占位层的那一页（pager 当前页）是否已「就绪」（见 {@link #pageReady}）。 */
    private boolean currentPageReady() {
        return pager != null && pageReady(pager.getCurrentItem());
    }

    /**
     * 第 {@code page} 页是否已「就绪」——结构已建好、还没有具体数据的那个状态（见类注释的口径）。
     *
     * <p>状态页与日志页的结构就是 inflate 出来的，视图一有即就绪；配置页的表单是读完定义后
     * 异步建出来的，要它自己说建成（{@link ConfigFormFragment#isStructureReady()}）。
     * 按类而不是按页序号判：将来页序变动不会静默错位。
     */
    private boolean pageReady(int page) {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            Bundle args = fragment.getArguments();
            if (args == null || args.getInt(ARG_PAGE, -1) != page) {
                continue;
            }
            return !(fragment instanceof ConfigFormFragment)
                    || ((ConfigFormFragment) fragment).isStructureReady();
        }
        return false;   // 还没有实例：谈不上就绪
    }

    /**
     * 三页的根视图，<b>下标即页序号</b>；某页还没有实例或视图时该位为 {@code null}（由调用方判断）。
     *
     * <p>按 arguments 里的页序号归位（与 {@link #broadcastVisibility} 同一口径），不去扒 pager 内部
     * 那个 RecyclerView 的子项顺序：那是 ViewPager2 / FragmentStateAdapter 的内部约定，比 arguments 脆。
     */
    private View[] pageRoots() {
        View[] roots = new View[MENU_IDS.length];
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            Bundle args = fragment.getArguments();
            int page = args == null ? -1 : args.getInt(ARG_PAGE, -1);
            if (page >= 0 && page < roots.length) {
                roots[page] = fragment.getView();
            }
        }
        return roots;
    }

    /** 摘掉一次性绘制回调（视图树观察者已死时什么都不做，它自己会随视图树一起消失）。 */
    private static void detach(ViewTreeObserver observer, ViewTreeObserver.OnPreDrawListener listener) {
        if (observer.isAlive()) {
            observer.removeOnPreDrawListener(listener);
        }
    }

    /**
     * 记账（旁路）：量第一页 / 第三页的视图各自何时建好（{@link StartupTiming#MARK_PAGE_VIEW_1} /
     * {@link StartupTiming#MARK_PAGE_VIEW_ALL}），用来切分 `[onCreate 结束, 首帧]` 那一段：外壳布局
     * 与类加载占多少、三页的构造又占多少。
     *
     * <p>{@code recursive=false}：只收本页三个页签，不把配置页的子 Fragment（曲线区）算进来。
     * 回调体里只有一次计数与最多两次静态 mark，无 IO、无锁、不建线程；不改变任何 Fragment 生命周期
     * ——只是多挂一个观察者。
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
     * 记账（旁路）：量"页面区第一次绘制之前"这个时间点（{@link StartupTiming#MARK_FIRST_DRAW}）。
     * 一次性回调，记完即摘（{@link #detach}），故只吃一帧。
     *
     * <p>挂在 pager 的视图树上而不是别处：它是页面区的根，它要画了就意味着这一屏内容要上屏了。
     * pre-draw 在绘制<b>之前</b>派发，故本时刻是"即将画出第一帧"，与用户看到第一帧几乎同一瞬间。
     * 回调体内只有两个不会抛的静态调用与一次摘除，故不可能影响绘制。
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
     * 落页（{@code onCreate} 调一次）：把页序号落到页容器与底栏上。判据见 {@link #landingPageIndex}，
     * 只有两条路：
     * <ol>
     *   <li>进程重建（{@code savedInstanceState} 非空）→ 回到上次那一页（纯内存，当场落定）；</li>
     *   <li>冷启动 → 判定由预热线程算（见 {@link #preload}）：<b>有界等</b>它一手，等到了就按判定
     *       当场落页 —— 落的就是最终那一页，没有后续纠正动作，也就不会闪；等不到则用
     *       {@link #awaitLanding} 手头已有的那个占着（{@link #LANDING_INDEX} 是进程级的：本进程早先
     *       算过就落在<b>上次算出的那页</b>上，一次都没算过才是 {@link #DEFAULT_START_TAB}），
     *       判定到达后 {@link #applyLanding} 纠正。</li>
     * </ol>
     * <b>不播放入场动画</b>：冷启动直接落在那一页，不从第 0 页滑过去。
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
     * 取落页判定：本进程早先已算过（{@link #LANDING_INDEX} 有值）就直接用，一秒不等；否则
     * 有界等预热线程一手（{@link #LANDING_WAIT_MS} 是硬上界：超时、被中断、判定抛异常都照样返回）。
     * 返回 {@code -1} = 没等到，调用方用占位页顶上，判定到达后再纠正。
     *
     * <p>{@code landingDone} 只由"算完判定"那一步放行，后面的曲线预热不在它的覆盖范围内 ——
     * 曲线再慢也不会拖住落页。
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
        // 纠正落页：占位层盖的是另一页的骨架，换图不如撤掉（本次启动就让它退回现状）
        hideSkeleton();
        syncing = true;
        pager.setCurrentItem(index, false);
        nav.setSelectedItemId(MENU_IDS[index]);
        syncing = false;
    }

    /**
     * 落页判定的判据（<b>只在后台线程调</b>，见 {@link #preload}）：三级优先里去掉"进程重建取回上次
     * 那一页"那一级（它不需要 IO，留在 {@link #settleInitialPage} 里判），剩两级：
     * <ol>
     *   <li>部署入口开关为开、且 {@link Deployer#needsRedeploy} 为真 → 落状态页
     *       （首次部署与 root 授权的入口都在那里）；</li>
     *   <li>{@link #KEY_UI_START_PAGE} 设定的起始页（读不到或值非法即出厂 {@code config}）。</li>
     * </ol>
     * <b>不跑 su 真探测、不自动跳页</b>：第 1 级只看缓存比对。
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

    /** {@link #KEY_UI_DEPLOY_ENTRY} 是否开：switch 型在定义里是 0/1 数值（见 params.json）。读不到 → 出厂 1。 */
    private static boolean isDeployEntryEnabled(Context context) {
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
     * 广播页面可见性：只有当前页收 true。
     *
     * <p>遍历 FragmentManager 里的实例，而不是按页序号反查——FragmentStateAdapter 用内部 tag
     * （{@code "f" + itemId}）持有页面，依赖那条约定太脆；页序号由本类写进 arguments，故凡是
     * {@link PageAware} 的页面都能自己算出第几页（进程恢复后重建的实例也一样）。
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
