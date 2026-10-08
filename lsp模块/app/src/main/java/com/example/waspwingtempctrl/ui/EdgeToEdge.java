package com.example.waspwingtempctrl.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.waspwingtempctrl.R;

import java.lang.reflect.Field;

/**
 * 下侧沉浸式：让窗口铺满整屏（含系统手势条/导航栏那一条带子），系统栏的让位由本类算。
 *
 * <p>为什么需要它、谁吃哪段内边距、为什么要顶掉底栏自带的 inset 监听、与键盘的关系——见
 * {@code app/逻辑说明.md} §9.2。
 *
 * <p>键盘：窗口 softInputMode 全局设成 {@code ADJUST_NOTHING}，<b>窗口本身不缩、不平移</b>（系统栏
 * 让位仍只按 systemBars 算）。键盘弹起时让位只落在<b>内容区</b>、<b>底栏留在屏幕底不动</b>；另加三件事，
 * 全部复用 root 上那唯一一个 inset 监听（另装监听会顶掉让位监听）：
 * <ul>
 *   <li>被键盘挡住的输入框由 {@link ImeReveal} 滚进可视区；</li>
 *   <li>内容区（配置页 {@code page_pager} / 设置页 {@code settings_container}，见 {@link #CONTENT_HOST_IDS}）
 *       多吃一段<b>封顶的底部避让</b>（{@code min(键盘高, 屏高/3)}），底栏<b>不随之移动、几何逐值不变</b>；</li>
 *   <li>键盘收起（由在变不在）时由 {@link KeyboardState} 主动清掉当前输入框焦点（防抖）。</li>
 * </ul>
 * 另在焦点变化/键盘弹起时给输入框关掉框架文本放大镜（{@link #disableMagnifier}，反射，失败静默）。
 */
public final class EdgeToEdge {

    private EdgeToEdge() {
    }

    /**
     * @param root      页面根（顶/左/右内边距归它）
     * @param bottomBar 要铺到屏幕底的那个栏（底栏），可为 null（没有这种栏时底部内边距归 root）。
     *                  它必须是定高（wrap_content/match_parent 时本类不动它）；XML 里声明的那个高度
     *                  被当作基准内容高，只在首次调用时量一次，之后不再反推（见 {@link BottomBarLayout}）。
     *                  键盘弹起时它<b>不动</b>——避让落在内容区（{@link #findContentHost}），不在本栏。
     */
    public static void apply(@NonNull Activity activity, @NonNull View root,
                             @Nullable View bottomBar) {
        WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), false);
        // 键盘只覆盖、窗口不缩不平移。decorFits=false 下 adjust 值不影响 insets 派发（见 app/逻辑说明.md
        // §9.2），这里锁死"不缩窗、不平移"这条旧通路；底部避让落在内容区，见下方 root 监听。
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
        final BottomBarLayout bottomBarLayout = new BottomBarLayout();
        final ContentHostAvoid contentHostAvoid = new ContentHostAvoid();
        final ImeReveal imeReveal = new ImeReveal();
        final KeyboardState keyboardState = new KeyboardState(root);
        // 避让落点 = 除底栏以外的那块内容区；取不到即 null，整条避让安全退化（不加、不崩）。
        final View contentHost = findContentHost(root, bottomBar);
        if (bottomBar != null) {
            // 顶掉 material 自带的那个会改写 paddingBottom 的监听（见类注释）
            ViewCompat.setOnApplyWindowInsetsListener(bottomBar, (view, windowInsets) -> windowInsets);
        }
        ViewCompat.setOnApplyWindowInsetsListener(root, (view, windowInsets) -> {
            Insets bars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets ime = windowInsets.getInsets(WindowInsetsCompat.Type.ime());
            // 键盘高（px，相对窗口底）；0 表示键盘不在。与 ImeReveal 同口径，单点计算、多处复用。
            int imeBottom = ime.bottom > bars.bottom ? ime.bottom : 0;
            // 根：只吃顶/左/右 + 底（无底栏吃 systemBars，有底栏归底栏）。避让**不落在这里**，
            // 落在根会连底栏一起顶起——实测被用户否掉，改为落到内容区（见下）。
            int rootBottom = bottomBar == null ? bars.bottom : 0;
            if (view.getPaddingLeft() != bars.left || view.getPaddingTop() != bars.top
                    || view.getPaddingRight() != bars.right || view.getPaddingBottom() != rootBottom) {
                view.setPadding(bars.left, bars.top, bars.right, rootBottom);
            }
            if (bottomBar != null) {
                bottomBarLayout.apply(bottomBar, bars.bottom);
            }
            // 键盘在时内容区底部让出 min(键盘高, 屏高/3)：内容缩到避让带之上，底栏留在屏幕底不动。
            contentHostAvoid.apply(contentHost, bottomAvoidPx(view, imeBottom));
            // 复用这唯一一个 inset 监听驱动"聚焦滚进可视区"（另装监听会顶掉本让位监听）
            imeReveal.onInsets(view, imeBottom);
            // 键盘由不在变在：给当前输入框关掉框架放大镜（反射，失败静默）
            if (keyboardState.onInsets(imeBottom)) {
                disableMagnifier(view.findFocus());
            }
            return windowInsets;
        });
        ViewCompat.requestApplyInsets(root);
        // 键盘已弹起时焦点在输入框之间跳动，也要重新滚一次；顺手给新焦点关掉放大镜
        root.getViewTreeObserver().addOnGlobalFocusChangeListener((oldFocus, newFocus) -> {
            if (newFocus != null) {
                disableMagnifier(newFocus);
                imeReveal.onFocusChanged(root);
            }
        });
    }

    /**
     * 内容宿主的候选 id（配置页 ViewPager2 / 设置页内容容器），按序取第一个命中的。
     * 硬编码两个外壳布局的 id 是刻意的取舍：避让必须落在"除底栏以外的那块内容区"，而外壳以外的
     * 通用判据（"根的第一个非底栏子 View"）会连标题栏一起算进来，更脆。
     */
    private static final int[] CONTENT_HOST_IDS = {R.id.page_pager, R.id.settings_container};

    /**
     * 取"除底栏以外的那块内容区"作为避让落点：按 {@link #CONTENT_HOST_IDS} 在 root 内找。
     * 取不到（布局改了名、或换了外壳）返回 {@code null} ⇒ 调用方安全退化，不加避让。
     */
    @Nullable
    private static View findContentHost(@NonNull View root, @Nullable View bottomBar) {
        for (int id : CONTENT_HOST_IDS) {
            View candidate = root.findViewById(id);
            if (candidate != null && candidate != bottomBar) {
                return candidate;
            }
        }
        return null;
    }

    /**
     * 键盘在时内容区要补的底部避让高度（px）：{@code min(键盘高, 屏高/3)}——键盘再高也只顶掉内容区
     * 下面 1/3，避免内容被顶得太狠。键盘不在返回 0。屏高优先取根的实测高（与这次布局同口径），
     * 未量到退回显示指标。
     */
    private static int bottomAvoidPx(@NonNull View root, int imeBottom) {
        if (imeBottom <= 0) {
            return 0;
        }
        int screenHeight = root.getHeight();
        if (screenHeight <= 0) {
            screenHeight = root.getResources().getDisplayMetrics().heightPixels;
        }
        return Math.min(imeBottom, screenHeight / 3);
    }

    /** 放大镜 animator 在 {@code Editor} 上的候选字段名（新名 → 旧名）。 */
    private static final String[] MAGNIFIER_FIELD_NAMES = {"mMagnifierAnimator", "mMagnifier"};

    /**
     * 关掉框架的文本放大镜：反射取 {@code TextView.mEditor}，再把 {@code Editor} 里那个放大镜
     * animator 置空。框架的 {@code updateMagnifier} 对空 animator 直接 return，故置空即"删掉放大镜"
     * 而**保留拖动手柄**。
     *
     * <p>只对 {@link EditText}（含 {@code TextInputEditText}）动手。整段包在 {@code try/catch(Throwable)}
     * 里：隐藏字段被改名 / 不可写（新版多为 {@code private final}）/ 被 hidden-api 拦下，都只静默放弃，
     * **绝不抛到主线程、也绝不影响其它功能**（见 {@code app/逻辑说明.md} §10 未验证项）。
     */
    private static void disableMagnifier(@Nullable View view) {
        if (!(view instanceof EditText)) {
            return;
        }
        try {
            Field editorField = TextView.class.getDeclaredField("mEditor");
            editorField.setAccessible(true);
            Object editor = editorField.get(view);
            if (editor == null) {
                return;
            }
            for (String name : MAGNIFIER_FIELD_NAMES) {
                try {
                    Field field = editor.getClass().getDeclaredField(name);
                    field.setAccessible(true);
                    if (field.get(editor) != null) {
                        field.set(editor, null);
                    }
                    return;     // 命中即止（找到名字就算成功，值本来就是空也不必再找）
                } catch (NoSuchFieldException ignored) {
                    // 换下一个候选字段名
                }
            }
        } catch (Throwable ignored) {
            // 反射失败：静默放弃，保留系统默认放大镜
        }
    }

    /**
     * 内容宿主的底部避让：{@code host.paddingBottom = 基准底内边距 + 避让}。基准仅在首次调用时量一次
     * （同 {@link BottomBarLayout} 的口径），免得把上次写进去的避让当成基准而逐次累加。宿主为 null 时
     * 什么都不做（安全退化）。
     */
    private static final class ContentHostAvoid {

        /** 基准底内边距；负值表示还没量过。 */
        private int basePaddingBottom = -1;

        void apply(@Nullable View host, int avoid) {
            if (host == null) {
                return;
            }
            if (basePaddingBottom < 0) {
                basePaddingBottom = host.getPaddingBottom();
            }
            int bottom = basePaddingBottom + avoid;
            if (host.getPaddingBottom() != bottom) {
                host.setPadding(host.getPaddingLeft(), host.getPaddingTop(),
                        host.getPaddingRight(), bottom);
            }
        }
    }

    /**
     * 底栏几何的持有者：{@code height = 基准内容高 + inset}、{@code paddingBottom = inset}，两者都是
     * 绝对赋值、不是叠加；基准内容高<b>只在首次调用时量一次</b>、之后恒用该值。旧写法为什么错见
     * {@code app/逻辑说明.md} §9.2。
     */
    private static final class BottomBarLayout {

        /** 基准内容高；负值表示还没量过。 */
        private int baseContentHeight = -1;

        void apply(@NonNull View bottomBar, int inset) {
            ViewGroup.LayoutParams params = bottomBar.getLayoutParams();
            if (params == null || params.height <= 0) {
                // 高度不是定值（wrap_content/match_parent）：留空，免得把比例算坏
                return;
            }
            if (baseContentHeight < 0) {
                baseContentHeight = params.height - bottomBar.getPaddingBottom();
            }
            int height = baseContentHeight + inset;
            if (params.height == height && bottomBar.getPaddingBottom() == inset) {
                // 与现状一致：不写回，也不触发多余的布局
                return;
            }
            bottomBar.setPadding(bottomBar.getPaddingLeft(), bottomBar.getPaddingTop(),
                    bottomBar.getPaddingRight(), inset);
            params.height = height;
            bottomBar.setLayoutParams(params);
        }
    }

    /**
     * 键盘"在 / 不在"的状态机：只在"由在变不在"时，延后一小段**复核**并清掉输入框焦点。
     *
     * <p>为什么要它：失焦即提交挂在键行自己的焦点监听上，而按返回键收起键盘时框架**不清焦点**，
     * 输入框会停在编辑态——既不提交也不复位。
     *
     * <p>为什么要延后复核：IME 收起是动画，inset 会经过若干中间值、甚至瞬时归零；等一小段再看，
     * 键盘还在就取消、真没了才清，避免动画中间态误清焦点。
     *
     * <p>"哪些控件算输入框"：只认 {@link EditText}（含 {@code TextInputEditText}）——任意可聚焦
     * View（按钮、开关、可聚焦容器等）不算，免得误伤非文本控件。
     */
    private static final class KeyboardState {

        /** 收起后等多久复核（毫秒）：覆盖 IME 收起动画的中间态。 */
        private static final long RELEASE_DELAY_MS = 120L;

        private final View root;
        private final Handler handler = new Handler(Looper.getMainLooper());
        private boolean imePresent;
        private boolean releasePending;

        KeyboardState(@NonNull View root) {
            this.root = root;
        }

        /** @return 本次是否"键盘由不在变在"（调用方据此给当前输入框关放大镜）。 */
        boolean onInsets(int imeBottom) {
            boolean present = imeBottom > 0;
            boolean becamePresent = present && !imePresent;
            boolean becameAbsent = !present && imePresent;
            imePresent = present;
            if (becamePresent) {
                cancelRelease();
            } else if (becameAbsent) {
                scheduleRelease();
            }
            return becamePresent;
        }

        private void scheduleRelease() {
            releasePending = true;
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(() -> {
                releasePending = false;
                if (imePresent) {
                    return;     // 复核时键盘又回来了：不动焦点
                }
                View focused = root.findFocus();
                if (focused instanceof EditText && focused.isFocused()) {
                    focused.clearFocus();
                }
            }, RELEASE_DELAY_MS);
        }

        private void cancelRelease() {
            if (releasePending) {
                handler.removeCallbacksAndMessages(null);
                releasePending = false;
            }
        }
    }

    /**
     * "聚焦滚进可视区"兜底：键盘弹起时，若当前焦点所在的输入框被键盘挡住，就把<b>它所在的那个
     * 滚动区</b>往上滚一点让它露出来。只改滚动偏移、零 padding，因此无状态、无残留、无"必须成对"。
     *
     * <p>纯增量：读不到键盘高度（{@code imeBottom <= 0}）就什么都不做，绝不退化回重排。
     */
    private static final class ImeReveal {

        /**
         * 输入框与键盘之间要留的余量。取 48dp 而非 16dp：插入手柄挂在光标下方、向下伸约 25dp
         * （AOSP {@code INSERTION_HANDLE_DELTA_HEIGHT} 默认 25），余量太小则手柄落进键盘那条带子里
         * （见 app/逻辑说明.md §9.2 与未验证项）。**该值需真机微调**。
         */
        private static final int MARGIN_DP = 48;

        /** 最近一次键盘高度（px，相对窗口底）；0 表示键盘不在。每个实例只服务一个 Activity 窗口，不跨页共享。 */
        private int lastImeBottom;

        /** inset 变化时调用：记下键盘高度，键盘在就滚一次。 */
        void onInsets(@NonNull View root, int imeBottom) {
            lastImeBottom = imeBottom;
            if (lastImeBottom > 0) {
                scheduleReveal(root);
            }
        }

        /** 焦点变化时调用：键盘在就按新焦点重滚一次。 */
        void onFocusChanged(@NonNull View root) {
            if (lastImeBottom > 0) {
                scheduleReveal(root);
            }
        }

        /** 延后一帧再算：滚动落点依赖布局完成时机。 */
        private void scheduleReveal(@NonNull View root) {
            root.post(() -> reveal(root));
        }

        private void reveal(@NonNull View root) {
            if (!root.isAttachedToWindow()) {
                return;
            }
            View focused = root.findFocus();
            if (focused == null) {
                return;
            }
            // 沿父链找滚动容器；找不到就 no-op（日志页搜索框在顶部、祖先链上没有滚动容器）
            ScrollView scroll = findScrollAncestor(focused);
            if (scroll == null) {
                return;
            }
            int[] rootLoc = new int[2];
            int[] focusLoc = new int[2];
            root.getLocationInWindow(rootLoc);
            focused.getLocationInWindow(focusLoc);
            int marginPx = Math.round(MARGIN_DP * root.getResources().getDisplayMetrics().density);
            // limit = 键盘上沿再往上留一个边距，即焦点底允许停留的最低位置；limit 内已含该边距
            int limit = rootLoc[1] + root.getHeight() - lastImeBottom - marginPx;
            int focusedBottom = focusLoc[1] + focused.getHeight();
            // 只补"超出 limit 的那一段"：滚完后焦点底落在 limit，即键盘上沿上方恰好一个边距
            int delta = focusedBottom - limit;
            if (delta > 0) {
                scroll.smoothScrollBy(0, delta);
            }
        }

        @Nullable
        private static ScrollView findScrollAncestor(@NonNull View view) {
            ViewParent parent = view.getParent();
            while (parent != null) {
                if (parent instanceof ScrollView) {
                    return (ScrollView) parent;
                }
                parent = parent.getParent();
            }
            return null;
        }
    }
}
