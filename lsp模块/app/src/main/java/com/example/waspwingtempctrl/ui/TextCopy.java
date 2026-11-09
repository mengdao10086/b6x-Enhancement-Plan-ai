package com.example.waspwingtempctrl.ui;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.RootShell;
import com.google.android.material.color.MaterialColors;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本复制与路径操作：长按整段复制、对话框正文可选、路径短按弹「复制 / 跳转」小卡，
 * 以及「这个控件是否正被选中」的判据。
 *
 * <p>两种复制方式互斥：开了 {@code textIsSelectable} 的控件由系统提供选择与复制，<b>不再</b>挂长按复制
 * （View 的长按监听会先吃掉手势，系统选择根本进不去）；反过来，长按复制的控件<b>不开</b>
 * {@code textIsSelectable} —— 后者会顺带把控件设为可聚焦/可点击（AOSP 实现），在配置页会干扰输入框焦点。
 *
 * <p>长按复制不额外提示：Android 13+ 系统自带剪贴板预览，再弹一条提示是重复反馈。
 * 路径小卡里的「复制」例外：卡片本身就是一次明确的选择动作，按用户要求给一条 Toast。
 */
final class TextCopy {

    /**
     * 调试日志标签：跳转失败/候选情况只写 logcat，不把异常原文塞进 Toast。
     * 用 W 级而非 D：真机 MIUI 会过滤掉 D 级日志，{@code logcat -s TextCopy:D} 抓不到。
     */
    private static final String TAG = "TextCopy";

    private TextCopy() {
    }

    /** 长按把控件当前文本整段写入剪贴板（带一次长按震动）；文本在长按发生时取，动态内容也能复制到最新值。 */
    static void copyOnLongPress(@NonNull TextView view) {
        copyOnLongPress(view, view::getText);
    }

    /**
     * 长按复制「由调用方指定的文本」：给可点击的容器（如展开/收起的卡头）挂长按时，复制它内部标题的文字。
     *
     * <p>短按与长按挂在同一个 View 上由框架按时长分流（长按触发后抬起不再触发点击），所以不需要自己计时，
     * 也不要把监听挂到内部的子 TextView 上——子控件会消费触摸，父容器的点击就收不到了。
     */
    static void copyOnLongPress(@NonNull View view, @NonNull Supplier<CharSequence> text) {
        view.setOnLongClickListener(v -> {
            copy(v.getContext(), text.get());
            v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
            return true;
        });
    }

    /**
     * 让对话框正文可选中复制。必须在 {@code show()} 之后才能取到 message 控件，故用 {@code onShow} 延迟到那时。
     * 对话框的标题/正文是框架建的 {@code TextView}，除选择能力外不改它的任何行为。
     */
    static void makeMessageSelectable(@NonNull Dialog dialog) {
        dialog.setOnShowListener(shown -> {
            TextView message = dialog.findViewById(android.R.id.message);
            if (message != null) {
                message.setTextIsSelectable(true);
                installPathSelection(message);
            }
        });
    }

    /** 「路径整条复制」开关键（定义在 {@code params.def.json} 的 webui 组，仅界面读取）。 */
    private static final String KEY_UI_PATH_COPY = "UI_PATH_COPY";

    /**
     * 两段式扩选的第二段时长：系统长按先按词选中一段，<b>继续按住</b>满这么久才扩成整条。
     * 抬手、超出手指移动阈值（改成拖选）或 ActionMode 结束都会取消这一次计时。
     */
    private static final long DEFAULT_HOLD_TO_EXPAND_MS = 300L;
    /** 扩选延迟在 {@code UI_PATH_COPY} 里的字段下标（0=开关，1=延迟毫秒）与取值范围。 */
    private static final int PATH_COPY_HOLD_FIELD = 1;
    private static final int HOLD_TO_EXPAND_MIN_MS = 100;
    private static final int HOLD_TO_EXPAND_MAX_MS = 2000;

    /**
     * 绝对路径识别：以 {@code /} 开头的连续路径字符段。前面紧邻 ASCII 单词字符或 {@code /} 时不算，
     * 避免把 {@code //} 与 URL 尾巴当成路径；字符集与 {@link #isPathChar} 的路径部分保持一致
     * （不含 {@code :}，避免把「路径:/data/x」的冒号吃进路径）。
     */
    private static final Pattern ABSOLUTE_PATH = Pattern.compile(
            "(?<![A-Za-z0-9._+%~@/-])/[A-Za-z0-9._+%~@-]+(?:/[A-Za-z0-9._+%~@-]+)*/?");
    /** 空路径表：没有命中时直接共用，避免每次点按新建数组。 */
    private static final int[][] NO_PATH_SPANS = new int[0][];

    /** 本进程里装过选区回调的控件：点背景时按它找"当前有选区的控件"。只增不减（弱引用随控件回收）。 */
    private static final Map<TextView, PathSelectionCallback> CALLBACKS = new WeakHashMap<>();

    /**
     * 方案 B：保留系统选择态，只在选区 ActionMode 创建时把选区扩到「当前词所在的整条路径」；
     * 同时让路径支持短按弹「复制 / 跳转」小卡（见 {@link PathSelectionCallback#onTap}），
     * 并把路径染成与 TextButton 同源的强调色（pre-draw 一次性变化检测补色，见 {@link #syncPathStyles}）。
     * 递归处理 root 下所有 {@code textIsSelectable} 的 {@link TextView}（跳过 {@link EditText}）。
     *
     * <p>同一控件可能被父子两级页面各装一次（配置页根 + 曲线子页）：重复安装会互相覆盖
     * 触摸监听并重复索引，保留第一份即可——回调按当前文本惰性重建索引。
     *
     * <p>开关关闭时回调不扩选、不弹卡、不改系统菜单，行为等同未安装（系统按词选择）。
     * <b>已知风险</b>：MIUI/HyperOS 可能不走这套系统回调，届时本功能不生效（用户已知情并接受）。
     */
    static void installPathSelection(@NonNull View root) {
        if (root instanceof TextView && !(root instanceof EditText)) {
            TextView text = (TextView) root;
            if (text.isTextSelectable() && !CALLBACKS.containsKey(text)) {
                PathSelectionCallback callback = new PathSelectionCallback(text);
                CALLBACKS.put(text, callback);
                text.setCustomSelectionActionModeCallback(callback);
                // 只观察按住/抬手/拖动：返回 false，系统选择与手柄拖动原样走（两段式计时与短按判定都用它）
                text.setOnTouchListener(new HoldWatcher(callback));
                // 文本由各页面 setText 刷新、不会重新 install：用 pre-draw 做一次性的文本变化检测补色。
                // 监听器只在「已附着」时挂到当前窗口的 ViewTreeObserver；换窗口后由附着监听重新挂。
                text.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                    @Override
                    public void onViewAttachedToWindow(View v) {
                        callback.attachPreDraw();
                    }

                    @Override
                    public void onViewDetachedFromWindow(View v) {
                        callback.detachPreDraw();
                    }
                });
                callback.attachPreDraw();
            }
        }
        if (root instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) root;
            for (int i = 0; i < group.getChildCount(); i++) {
                installPathSelection(group.getChildAt(i));
            }
        }
    }

    /**
     * 单个控件的路径交互：<b>两段式扩选</b>——系统长按先按词选中一段，继续按住满 {@link #HOLD_TO_EXPAND_MS}
     * 才扩成整条路径；抬手或改成拖选即保持系统那一段。每次 ActionMode 至多扩一次。
     * <b>短按</b>则由 {@link #onTap} 弹「复制 / 跳转」小卡，两者共用同一套触摸观察。
     */
    private static final class PathSelectionCallback implements ActionMode.Callback {

        private final TextView view;
        /** 本次 ActionMode 是否已扩过（防止重复计时再次强设选区）。 */
        private boolean expanded;
        /** 当前 ActionMode（点背景清除时用它结束浮条）；未创建时为 null。 */
        @Nullable
        private ActionMode mode;
        /** 手指是否仍按在控件上：抬手或拖动都会清掉这次"继续按住"的计时。 */
        private boolean holding;
        /** 本次按压是否已经按满 {@link #HOLD_TO_EXPAND_MS}（不依赖 ActionMode 何时创建）。 */
        private boolean holdElapsed;
        /** 按下点在控件内的坐标：系统尚未建立选区时，用它自己算出整条路径。 */
        private float pressX;
        private float pressY;
        private final Runnable expandAfterHold = this::expandIfStillHolding;
        /** 路径区间缓存的文本对象与长度：{@code setText} 会换掉整个 CharSequence，据此惰性重建。 */
        @Nullable
        private CharSequence indexedText;
        private int indexedLength = -1;
        /** 上次索引时开关是否开启：关闭时保留空表，重新开启后由点按补索引。 */
        private boolean indexedEnabled;
        private int[][] pathSpans = NO_PATH_SPANS;
        /** 当前挂着 pre-draw 的观察者：换窗口/重新附着时用它去重。 */
        @Nullable
        private ViewTreeObserver styledObserver;
        /** 固定实例，挂/摘 pre-draw 用同一个对象（方法引用每次求值不保证同一实例）。 */
        private final ViewTreeObserver.OnPreDrawListener preDrawListener = this::onPreDraw;

        PathSelectionCallback(TextView view) {
            this.view = view;
            syncPathStyles();   // 安装时先索引并着色一次
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            expanded = false;
            this.mode = mode;
            // 开关实时读取（与其它 webui 组界面键同一套），创建当帧即生效
            if (isPathCopyEnabled(view.getContext())) {
                // 部分系统把 ActionMode 推迟到抬手之后才建：按压期已过但确实按够了，
                // 此时系统刚落定那一段选区，再扩一次（按住期间已主动扩过则重复一次无副作用）
                if (holdElapsed || expanded) {
                    view.post(this::applyWholePath);
                }
            }
            return true;   // 不 menu.clear()：保留系统复制/全选/分享
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;  // 系统菜单无需重建（手柄拖动只走这里，不重新扩选）
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;  // 交给系统默认项处理
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            this.mode = null;
            holding = false;
            view.removeCallbacks(expandAfterHold);
        }

        /**
         * 按下起点：从这一刻起算「系统长按时长 + {@link #HOLD_TO_EXPAND_MS}」。
         * 不从 ActionMode 创建回调起算——部分系统把它推迟到抬手之后，那样就永远等不到"按住期间"。
         */
        void onPressStart(float x, float y) {
            pressX = x;
            pressY = y;
            holdElapsed = false;
            holding = true;
            view.removeCallbacks(expandAfterHold);
            long delay = ViewConfiguration.getLongPressTimeout() + holdToExpandMs(view.getContext());
            view.postDelayed(expandAfterHold, delay);
        }

        /** 按住状态由 {@link HoldWatcher} 维护：抬手/拖动即取消这一次扩选。 */
        void setHolding(boolean value) {
            holding = value;
            if (!value) {
                view.removeCallbacks(expandAfterHold);
            }
        }

        /**
         * 短按落在路径上：弹「复制 / 跳转」小卡。由 {@link HoldWatcher} 在抬手时判定，
         * <b>不消费触摸</b>，因此系统选择、滚动与点击行为都不受影响。
         * 开关关闭或已有选区时什么都不做（与安装前完全一致）。
         */
        void onTap(float x, float y) {
            if (!isPathCopyEnabled(view.getContext()) || view.hasSelection()) {
                return;
            }
            PathHit hit = pathHitAt(x, y);
            if (hit == null) {
                return;
            }
            // 等本次触摸分发结束再弹窗：避免在 dispatchTouchEvent 里同步换窗口焦点
            view.post(() -> {
                if (view.isAttachedToWindow() && !view.hasSelection()) {
                    PathActionCard.show(view, hit);
                }
            });
        }

        /** 触点命中的路径；落在行间空白、行尾留白或路径外时返回 null。 */
        @Nullable
        private PathHit pathHitAt(float x, float y) {
            Layout layout = view.getLayout();
            CharSequence text = view.getText();
            if (layout == null || text == null || text.length() == 0) {
                return null;
            }
            // 与 TextView 的点击判定同一坐标口径：先扣掉内边距并加上滚动偏移
            float localX = x - view.getTotalPaddingLeft() + view.getScrollX();
            float localY = y - view.getTotalPaddingTop() + view.getScrollY();
            int line = layout.getLineForVertical((int) localY);
            if (localY < layout.getLineTop(line) || localY >= layout.getLineBottom(line)
                    || localX < layout.getLineLeft(line) || localX > layout.getLineRight(line)) {
                return null;   // 点在行间/行尾的空白，不是文字
            }
            int offset = layout.getOffsetForHorizontal(line, localX);
            if (offset < 0 || offset >= text.length()) {
                return null;
            }
            for (int[] span : ensurePathIndex()) {
                if (offset >= span[0] && offset < span[1]) {
                    return hitFor(layout, line, span);
                }
            }
            return null;
        }

        /**
         * 以「被点路径在当前行上的那段」为锚：水平中心 x 与行盒上下沿（屏幕坐标）。
         * 路径可能跨行，这里只取被点那一行，保证小卡贴着手指附近。
         */
        @Nullable
        private PathHit hitFor(@NonNull Layout layout, int line, @NonNull int[] span) {
            int lineStart = layout.getLineStart(line);
            int lineEnd = layout.getLineEnd(line);
            int segStart = Math.max(span[0], lineStart);
            int segEnd = Math.min(span[1], lineEnd);
            if (segStart >= segEnd) {
                return null;
            }
            float left = layout.getPrimaryHorizontal(segStart);
            // segEnd == 行尾时 getPrimaryHorizontal 可能落到下一行行首；改用行右沿
            float right = segEnd < lineEnd
                    ? layout.getPrimaryHorizontal(segEnd)
                    : layout.getLineRight(line);
            if (left > right) {
                float swap = left;
                left = right;
                right = swap;
            }
            int[] location = new int[2];
            view.getLocationOnScreen(location);
            float originX = location[0] + view.getTotalPaddingLeft() - view.getScrollX();
            float originY = location[1] + view.getTotalPaddingTop() - view.getScrollY();
            CharSequence text = view.getText();
            return new PathHit(
                    text.subSequence(span[0], span[1]).toString(),
                    Math.round(originX + (left + right) / 2f),
                    Math.round(originY + layout.getLineTop(line)),
                    Math.round(originY + layout.getLineBottom(line)));
        }

        /** pre-draw：只在文本对象/长度变化时重建区间与着色；未变化时每帧只做一次身份比较。 */
        boolean onPreDraw() {
            syncPathStyles();
            return true;   // 不取消绘制
        }

        /** 挂到当前窗口的观察者；同一观察者只挂一次。 */
        void attachPreDraw() {
            if (!view.isAttachedToWindow()) {
                return;
            }
            ViewTreeObserver observer = view.getViewTreeObserver();
            if (observer == styledObserver) {
                return;
            }
            styledObserver = observer;
            try {
                observer.addOnPreDrawListener(preDrawListener);
            } catch (IllegalStateException ignored) {
                styledObserver = null;   // 观察者已失效：等下次附着再挂
            }
        }

        /** 离开窗口时摘掉监听并清引用，重新附着时再挂到新的观察者。 */
        void detachPreDraw() {
            ViewTreeObserver observer = styledObserver;
            styledObserver = null;
            if (observer != null) {
                try {
                    observer.removeOnPreDrawListener(preDrawListener);
                } catch (IllegalStateException ignored) {
                    // 观察者已随窗口销毁：无需再摘
                }
            }
        }

        /**
         * 文本变化检测：{@code setText} 会换掉整个 CharSequence（各页面刷新时都重设文本且不会重装），
         * 以对象身份 + 长度判定；只有变化时才跑正则并补色。开关关闭时连正则都不跑。
         */
        private void syncPathStyles() {
            CharSequence text = view.getText();
            int length = text == null ? 0 : text.length();
            if (text == indexedText && length == indexedLength) {
                return;
            }
            indexedText = text;
            indexedLength = length;
            if (!isPathCopyEnabled(view.getContext())) {
                indexedEnabled = false;
                pathSpans = NO_PATH_SPANS;
                return;
            }
            indexedEnabled = true;
            pathSpans = findPathSpans(text);
            applyPathColors(text);
        }

        /** 点按时兜底：开关刚打开、文本没变时补一次索引与着色。 */
        private int[][] ensurePathIndex() {
            syncPathStyles();
            if (!indexedEnabled && isPathCopyEnabled(view.getContext())) {
                indexedEnabled = true;
                CharSequence text = view.getText();
                pathSpans = findPathSpans(text);
                applyPathColors(text);
            }
            return pathSpans;
        }

        /** 给当前 Spannable 里的每条路径套上「按钮强调色」；只清本功能自己的标记 span。 */
        private void applyPathColors(@Nullable CharSequence text) {
            if (!(text instanceof Spannable)) {
                return;
            }
            Spannable spannable = (Spannable) text;
            for (PathColorSpan old : spannable.getSpans(0, spannable.length(), PathColorSpan.class)) {
                spannable.removeSpan(old);
            }
            if (!indexedEnabled || pathSpans.length == 0) {
                return;
            }
            final int color;
            try {
                // 与 TextButton 的 enabled 文字色同源：?attr/colorPrimary（本项目即 @color/brand_primary）
                color = MaterialColors.getColor(view, androidx.appcompat.R.attr.colorPrimary);
            } catch (RuntimeException e) {
                return;   // 主题异常时不着色，不影响文本其余功能
            }
            for (int[] span : pathSpans) {
                spannable.setSpan(new PathColorSpan(color), span[0], span[1],
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        /** 当前是否正有选中（点背景清除的判据）。 */
        boolean isSelecting() {
            return view.hasSelection();
        }

        /** 结束选区与浮条：点背景时调用。先清选区再结束 ActionMode，系统回调里不会再触发扩选。 */
        void clearSelection() {
            if (!view.hasSelection()) {
                return;
            }
            holding = false;
            expanded = false;
            view.removeCallbacks(expandAfterHold);
            CharSequence text = view.getText();
            if (text instanceof Spannable) {
                Selection.removeSelection((Spannable) text);
            }
            ActionMode current = mode;
            mode = null;
            if (current != null) {
                current.finish();
            }
        }

        private void expandIfStillHolding() {
            holdElapsed = true;
            if (!holding || expanded) {
                return;   // 已抬手/已拖动：保留系统选中的那一段
            }
            if (view.hasSelection()) {
                applyWholePath();   // 系统已按词选好：扩到整条
            } else {
                applyWholePathFromPress();   // 系统还没落选区：用按下点自己算，别等抬手
            }
        }

        /** 非按住入口（键盘/无障碍）的兜底：系统已有选区时一步扩到整条。 */
        private void expandOnce() {
            if (expanded || !view.isAttachedToWindow() || !view.hasSelection()) {
                return;
            }
            applyWholePath();
        }

        /** 把当前选区两端扩到整条路径；选区不在同一条路径上时保持不动。 */
        private void applyWholePath() {
            if (!view.isAttachedToWindow() || !view.hasSelection()) {
                return;
            }
            CharSequence text = view.getText();
            if (!(text instanceof Spannable)) {
                return;
            }
            int[] bounds = wholePathBounds(
                    text, view.getSelectionStart(), view.getSelectionEnd());
            if (bounds == null) {
                return;
            }
            expanded = true;
            // textIsSelectable 的控件文本是 SPANNABLE（见 setTextIsSelectable），可直接设选区
            Selection.setSelection((Spannable) text, bounds[0], bounds[1]);
        }

        /** 按住期满而系统尚未建立选区：按按下点的字符偏移自己算出整条路径并选中。 */
        private void applyWholePathFromPress() {
            CharSequence text = view.getText();
            Layout layout = view.getLayout();
            if (!(text instanceof Spannable) || layout == null || text.length() == 0) {
                return;
            }
            int line = layout.getLineForVertical((int) pressY);
            int offset = layout.getOffsetForHorizontal(line, pressX);
            if (offset < 0 || offset >= text.length()) {
                return;
            }
            int[] bounds = wholePathBounds(text, offset, offset);
            if (bounds == null) {
                return;
            }
            expanded = true;
            view.requestFocus();   // 选区要有焦点才画得出来（此时手指仍按着）
            Selection.setSelection((Spannable) text, bounds[0], bounds[1]);
        }
    }

    /** 只用于标记本功能加的路径颜色，清理时不会误删文本上其它 ForegroundColorSpan。 */
    private static final class PathColorSpan extends ForegroundColorSpan {
        PathColorSpan(int color) {
            super(color);
        }
    }

    /**
     * 触摸观察者：只记录按下/移动/抬起/多指，<b>不消费事件</b>（返回 false，系统选择与手柄拖动原样走）。
     *
     * <p>两种手势都从这里分流，<b>只有这一套触摸判定</b>：
     * <ul>
     *   <li>按住：交给 {@link PathSelectionCallback} 做两段式扩选计时；</li>
     *   <li>短按：位移未超触摸阈值且时长短于系统长按阈值，抬手时把按下点交给回调判定是不是路径。</li>
     * </ul>
     * 移动超出阈值即视为拖选/滚动，取消自动扩选，也不再当短按。
     */
    private static final class HoldWatcher implements View.OnTouchListener {

        private final PathSelectionCallback callback;
        private float downX;
        private float downY;
        private boolean moved;
        private boolean multiTouch;

        HoldWatcher(PathSelectionCallback callback) {
            this.callback = callback;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    downX = event.getX();
                    downY = event.getY();
                    moved = false;
                    multiTouch = false;
                    callback.onPressStart(downX, downY);
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    multiTouch = true;   // 多指不是短按；同时取消这次自动扩选
                    callback.setHolding(false);
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (!moved) {
                        float dx = event.getX() - downX;
                        float dy = event.getY() - downY;
                        int slop = ViewConfiguration.get(v.getContext()).getScaledTouchSlop();
                        if (dx * dx + dy * dy > (float) slop * slop) {
                            moved = true;
                            callback.setHolding(false);
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (isTap(event)) {
                        callback.onTap(downX, downY);
                    }
                    callback.setHolding(false);
                    break;
                case MotionEvent.ACTION_CANCEL:
                    callback.setHolding(false);
                    break;
                default:
                    break;
            }
            return false;
        }

        /** 短按 = 位移未超阈值、非多指、且从按下到抬起的时长低于系统长按阈值。 */
        private boolean isTap(MotionEvent event) {
            if (moved || multiTouch) {
                return false;
            }
            long held = event.getEventTime() - event.getDownTime();
            return held < ViewConfiguration.getLongPressTimeout();
        }
    }

    /** 一次路径命中的结果：文本本身 + 小卡的锚点几何（屏幕坐标）。 */
    private static final class PathHit {
        final String path;
        /** 被点路径该行片段的水平中心（屏幕 x）。 */
        final int centerX;
        /** 该行行盒的上下沿（屏幕 y）。 */
        final int lineTopY;
        final int lineBottomY;

        PathHit(String path, int centerX, int lineTopY, int lineBottomY) {
            this.path = path;
            this.centerX = centerX;
            this.lineTopY = lineTopY;
            this.lineBottomY = lineBottomY;
        }
    }

    /**
     * 路径操作小卡：只有「复制 / 跳转」两个按钮，紧贴被点路径那一行的上方弹出；
     * 上方放不下就翻到下方。用 {@link PopupWindow} 承载（不压暗背景），点外部或返回键即收起。
     */
    private static final class PathActionCard {

        /** 卡片与行盒之间的间隙、距窗口可见边缘的最小留白（dp）。 */
        private static final float GAP_DP = 4f;
        private static final float MARGIN_DP = 8f;

        @Nullable
        private static WeakReference<PopupWindow> current;

        private PathActionCard() {
        }

        static void show(@NonNull View anchor, @NonNull PathHit hit) {
            Context context = anchor.getContext();
            View card = LayoutInflater.from(context)
                    .inflate(R.layout.view_path_action_card, null, false);
            PopupWindow popup = new PopupWindow(card,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    true);
            popup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            popup.setOutsideTouchable(true);
            card.findViewById(R.id.path_card_copy).setOnClickListener(v -> {
                copy(context, hit.path);
                Toast.makeText(context.getApplicationContext(),
                        R.string.path_action_copied, Toast.LENGTH_SHORT).show();
                popup.dismiss();
            });
            card.findViewById(R.id.path_card_open).setOnClickListener(v -> {
                popup.dismiss();
                PathOpener.open(context, hit.path);
            });
            popup.setOnDismissListener(() -> {
                WeakReference<PopupWindow> ref = current;
                if (ref != null && ref.get() == popup) {
                    current = null;
                }
            });

            // 先量出卡片实宽实高，再决定「贴上方还是翻到下方」以及水平居中位置
            card.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            int width = card.getMeasuredWidth();
            int height = card.getMeasuredHeight();
            float density = context.getResources().getDisplayMetrics().density;
            int gap = Math.round(GAP_DP * density);
            int margin = Math.round(MARGIN_DP * density);
            Rect frame = new Rect();
            anchor.getWindowVisibleDisplayFrame(frame);

            int x = hit.centerX - width / 2;
            x = Math.max(frame.left + margin, Math.min(x, frame.right - width - margin));
            int y = hit.lineTopY - height - gap;   // 优先贴上方
            if (y < frame.top + margin) {
                y = hit.lineBottomY + gap;         // 上方放不下：翻到下方
            }
            y = Math.max(frame.top + margin,
                    Math.min(y, frame.bottom - height - margin));

            dismissCurrent();
            try {
                popup.showAtLocation(anchor, Gravity.NO_GRAVITY, x, y);
            } catch (RuntimeException e) {
                return;   // 宿主窗口已失效（退出/切页）：不弹卡，也不留下失效引用
            }
            current = new WeakReference<>(popup);
        }

        private static void dismissCurrent() {
            PopupWindow previous = current == null ? null : current.get();
            current = null;
            if (previous != null && previous.isShowing()) {
                previous.dismiss();
            }
        }
    }

    /**
     * 路径跳转：用 root 身份执行 {@code am start -a VIEW -d file://…}，把路径交给文件管理器。
     *
     * <p><b>为什么不自己 startActivity：</b>{@code content://} 方案会被 system_server 的 URI 授权检查
     * 拦下（{@code UriGrantsManagerService#checkGrantUriPermissionUnlocked} 要求调用方持有 provider 的
     * {@code MANAGE_DOCUMENTS} 或既存 URI 授权，普通应用都拿不到），连选择器都弹不出来；
     * {@code file://} 又会被本应用 {@code targetSdk=34} 的 StrictMode
     * 判 {@code FileUriExposedException}。改由 su 拉起的 {@code am} 进程（uid 0）发送 file URI，
     * 既绕开 targetSdk 的暴露检查，也不需要 URI 授权——隐式 Intent 命中多个应用时由系统自己弹选择器。
     */
    private static final class PathOpener {

        /** 主存储的规范路径：/sdcard、/storage/self/primary 等写法统一归一到它。 */
        private static final String PRIMARY_ROOT = "/storage/emulated/0";
        /** am 只提交启动请求，正常几百毫秒即返回；超过这个时间按失败处理。 */
        private static final long AM_TIMEOUT_MS = 5_000L;
        /** 结果提示统一回主线程弹出（root 调用会阻塞 I/O，必须离开主线程）。 */
        private static final Handler MAIN = new Handler(Looper.getMainLooper());

        private PathOpener() {
        }

        /** 跳转到路径所在目录（路径本身是文件时取父目录），由 root 的 am 发起。 */
        static void open(@NonNull Context context, @NonNull String path) {
            String directory = directoryOf(path);
            String shared = toSharedPath(directory);
            boolean rootOnly = shared == null;
            String target = rootOnly ? directory : shared;
            Uri uri = Uri.fromFile(new File(target));
            String command = "am start -a android.intent.action.VIEW -d "
                    + shellQuote(uri.toString());
            Log.w(TAG, "open: su cmd=" + command + " rootOnly=" + rootOnly);
            Context app = context.getApplicationContext();
            // RootShell 会阻塞 I/O 且内部串行取锁：一次性后台线程，结果再回主线程提示
            Thread worker = new Thread(() -> launch(app, command, path, rootOnly), "ww-path-open");
            worker.setDaemon(true);
            worker.start();
        }

        /** 路径若指向文件则取父目录；无法确定类型时按「最后一段带扩展名」判断。 */
        @NonNull
        private static String directoryOf(@NonNull String path) {
            if (!looksLikeFile(path)) {
                return path;
            }
            int slash = path.lastIndexOf('/');
            return slash > 0 ? path.substring(0, slash) : "/";
        }

        /** 最后一段带扩展名（且不是隐藏文件）就当作文件。 */
        private static boolean looksLikeFile(@NonNull String path) {
            String name = path.substring(path.lastIndexOf('/') + 1);
            int dot = name.lastIndexOf('.');
            return dot > 0 && dot < name.length() - 1;
        }

        /** 常见共享存储写法统一到 {@code /storage/…}；不是共享存储则返回 null。 */
        @Nullable
        private static String toSharedPath(@NonNull String path) {
            if (path.equals("/sdcard") || path.startsWith("/sdcard/")) {
                return PRIMARY_ROOT + path.substring("/sdcard".length());
            }
            if (path.equals("/mnt/sdcard") || path.startsWith("/mnt/sdcard/")) {
                return PRIMARY_ROOT + path.substring("/mnt/sdcard".length());
            }
            if (path.equals("/storage/self/primary") || path.startsWith("/storage/self/primary/")) {
                return PRIMARY_ROOT + path.substring("/storage/self/primary".length());
            }
            if (path.equals("/data/media/0") || path.startsWith("/data/media/0/")) {
                return PRIMARY_ROOT + path.substring("/data/media/0".length());
            }
            if (path.equals("/storage") || path.startsWith("/storage/")) {
                return path;
            }
            return null;
        }

        /** 后台：su 执行 am；超时、通道失败、输出没有 Starting 或带 Error 都算失败。 */
        private static void launch(@NonNull Context app, @NonNull String command,
                                   @NonNull String path, boolean rootOnly) {
            RootShell.Result result;
            try {
                result = RootShell.get(app).exec(command, AM_TIMEOUT_MS);
            } catch (RuntimeException e) {
                Log.w(TAG, "open: su failed " + e.getClass().getName() + ": " + e.getMessage());
                fail(app, path, rootOnly);
                return;
            }
            String output = (result.stdout + '\n' + result.stderr).trim();
            // am 对「解析不到应用」也先打印 Starting 再把 Error 写到 stderr，故必须两者一起判
            boolean started = output.contains("Starting: Intent")
                    && !output.contains("Error:") && !output.contains("Exception");
            Log.w(TAG, "open: su done started=" + started + " exit=" + result.exitCode
                    + " timedOut=" + result.timedOut + " output=" + output);
            if (!result.isOk() || !started) {
                fail(app, path, rootOnly);
            }
        }

        /** 失败：普通路径只提示没有应用；root 路径先把路径写进剪贴板，便于换有 root 的文件管理器粘贴定位。 */
        private static void fail(@NonNull Context app, @NonNull String path, boolean rootOnly) {
            if (rootOnly) {
                copy(app, path);
                show(app, R.string.path_action_open_root_failed);
            } else {
                show(app, R.string.path_action_open_no_app);
            }
        }

        /** 单引号包裹并转义其中的单引号：空格、中文、$ 等都原样交给 shell。 */
        @NonNull
        private static String shellQuote(@NonNull String value) {
            return "'" + value.replace("'", "'\\''") + "'";
        }

        /** 后台线程只投递消息，Toast 在主线程弹。 */
        private static void show(@NonNull Context app, int textRes) {
            MAIN.post(() -> Toast.makeText(app, textRes, Toast.LENGTH_LONG).show());
        }
    }

    /**
     * 点背景清除选区：Activity 在 {@code dispatchTouchEvent} 的 ACTION_DOWN 上调用。
     * 触点落在任一"有选区且可见"的控件内就什么都不做（用户还在操作那一段）；否则清掉所有选区并结束浮条。
     */
    static void dismissSelectionsOutside(float rawX, float rawY) {
        // 先复制一份：WeakHashMap 在迭代期间可能因 GC 清理条目而变结构
        List<Map.Entry<TextView, PathSelectionCallback>> entries =
                new ArrayList<>(CALLBACKS.entrySet());
        List<PathSelectionCallback> selecting = new ArrayList<>();
        for (Map.Entry<TextView, PathSelectionCallback> entry : entries) {
            TextView text = entry.getKey();
            PathSelectionCallback callback = entry.getValue();
            if (text == null || callback == null || !callback.isSelecting() || !text.isShown()) {
                continue;
            }
            if (hits(text, rawX, rawY)) {
                return;   // 点在选区内：这一段还在操作，不动
            }
            selecting.add(callback);
        }
        for (PathSelectionCallback callback : selecting) {
            callback.clearSelection();
        }
    }

    /** 触点（屏幕坐标）是否落在控件矩形内。 */
    private static boolean hits(@NonNull TextView view, float rawX, float rawY) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return rawX >= location[0] && rawX < location[0] + view.getWidth()
                && rawY >= location[1] && rawY < location[1] + view.getHeight();
    }

    /** 第二段时长实时读取（{@code UI_PATH_COPY} 的第二个字段）；越界钳制，读取失败或旧版单值配置走默认 300ms。 */
    private static long holdToExpandMs(@NonNull Context context) {
        try {
            ConfigStore.Value value = ConfigStore.get(context).get(KEY_UI_PATH_COPY);
            if (value == null || value.size() <= PATH_COPY_HOLD_FIELD) {
                return DEFAULT_HOLD_TO_EXPAND_MS;   // 旧配置只有 0/1 一位：延迟取默认
            }
            int ms = value.intAt(PATH_COPY_HOLD_FIELD);
            return Math.max(HOLD_TO_EXPAND_MIN_MS, Math.min(HOLD_TO_EXPAND_MAX_MS, ms));
        } catch (RuntimeException e) {
            return DEFAULT_HOLD_TO_EXPAND_MS;
        }
    }

    /** 开关默认开启；读取失败也按开启处理（不因配置通道异常丢掉路径复制）。 */
    private static boolean isPathCopyEnabled(Context context) {
        try {
            ConfigStore.Value value = ConfigStore.get(context).get(KEY_UI_PATH_COPY);
            return value == null || value.intAt(0) != 0;
        } catch (RuntimeException e) {
            return true;
        }
    }

    /**
     * 选区所在的「整条路径」边界；不是路径（起点/终点不在同一路径内，或不以 {@code /} 开头）时返回 null。
     * 路径字符 = ASCII 字母数字与 {@code ._-+%~@/:}，遇空白/换行/全角标点等其它字符即止。
     */
    @Nullable
    private static int[] wholePathBounds(CharSequence text, int selStart, int selEnd) {
        if (text == null) {
            return null;
        }
        int length = text.length();
        int start = Math.min(selStart, selEnd);
        int end = Math.max(selStart, selEnd);
        if (start < 0 || start >= length || !isPathChar(text.charAt(start))) {
            return null;   // 选区起点不在路径字符上
        }
        int left = start;
        while (left > 0 && isPathChar(text.charAt(left - 1))) {
            left--;
        }
        int right = start;
        while (right < length && isPathChar(text.charAt(right))) {
            right++;
        }
        if (text.charAt(left) != '/') {
            return null;   // 只认以 / 开头的路径
        }
        if (end > right) {
            return null;   // 终点越出该路径：起终点不在同一条路径内
        }
        if (left == start && right == end) {
            return null;   // 已经是整条路径
        }
        return new int[]{left, right};
    }

    private static boolean isPathChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                || (c >= '0' && c <= '9') || "._-+%~@/:".indexOf(c) >= 0;
    }

    /** 一次扫描出文本里所有绝对路径的 {@code [start, end)} 区间；结果由调用方缓存。 */
    private static int[][] findPathSpans(@Nullable CharSequence text) {
        if (text == null || text.length() == 0) {
            return NO_PATH_SPANS;
        }
        String plain = text.toString();
        List<int[]> spans = new ArrayList<>();
        Matcher matcher = ABSOLUTE_PATH.matcher(plain);
        while (matcher.find()) {
            spans.add(new int[]{matcher.start(), matcher.end()});
        }
        return spans.toArray(new int[0][]);
    }

    /** 控件是否正处在选择态（含未拖动的选中）。刷新路径用它决定本次是否跳过 UI 更新。 */
    static boolean isSelecting(@Nullable TextView view) {
        return view != null && view.hasSelection();
    }

    /** 每个控件至多一条轮询链：后到的 action 覆盖先到的（补最新内容），链本身不重复起。 */
    private static final Map<TextView, Runnable> PENDING = new WeakHashMap<>();
    private static final Map<TextView, Boolean> POLLING = new WeakHashMap<>();
    /** 轮询间隔：只在该控件被选中且有待补内容时才跑，一次检查只是读一个布尔值。 */
    private static final long SELECTION_POLL_MS = 200L;

    /**
     * 选择结束后执行一次 {@code action}（用于把暂停期间攒下的最新内容补上）。
     *
     * <p>不用 {@code setCustomSelectionActionModeCallback}：那会替换系统默认的「复制/全选」菜单。
     * 这里按固定间隔查 {@link TextView#hasSelection()}，控件脱离窗口即停止。
     */
    static void runWhenSelectionEnds(@NonNull TextView view, @NonNull Runnable action) {
        if (!view.hasSelection()) {
            action.run();
            return;
        }
        PENDING.put(view, action);
        if (POLLING.put(view, Boolean.TRUE) != null) {
            return;   // 已有轮询链，action 已被最新一次覆盖
        }
        pollSelectionEnd(view);
    }

    private static void pollSelectionEnd(@NonNull TextView view) {
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!view.isAttachedToWindow()) {
                    PENDING.remove(view);
                    POLLING.remove(view);
                    return;
                }
                if (view.hasSelection()) {
                    view.postDelayed(this, SELECTION_POLL_MS);
                    return;
                }
                Runnable action = PENDING.remove(view);
                POLLING.remove(view);
                if (action != null) {
                    action.run();
                }
            }
        }, SELECTION_POLL_MS);
    }

    /** 直接写剪贴板；包内可见，供日志页的整行跨选复制复用。 */
    static void copy(@NonNull Context context, @NonNull CharSequence text) {
        ClipboardManager manager =
                (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (manager != null) {
            manager.setPrimaryClip(ClipData.newPlainText("text", text));
        }
    }
}
