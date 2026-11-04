package com.example.waspwingtempctrl.ui;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Selection;
import android.text.Spannable;
import android.view.ActionMode;
import android.view.HapticFeedbackConstants;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Supplier;

/**
 * 文本复制：长按整段复制、对话框正文可选、以及「这个控件是否正被选中」的判据。
 *
 * <p>两种复制方式互斥：开了 {@code textIsSelectable} 的控件由系统提供选择与复制，<b>不再</b>挂长按复制
 * （View 的长按监听会先吃掉手势，系统选择根本进不去）；反过来，长按复制的控件<b>不开</b>
 * {@code textIsSelectable} —— 后者会顺带把控件设为可聚焦/可点击（AOSP 实现），在配置页会干扰输入框焦点。
 *
 * <p>复制成功不额外提示：Android 13+ 系统自带剪贴板预览，再弹一条提示是重复反馈。
 */
final class TextCopy {

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
    private static final long HOLD_TO_EXPAND_MS = 850L;

    /** 本进程里装过选区回调的控件：点背景时按它找"当前有选区的控件"。只增不减（弱引用随控件回收）。 */
    private static final Map<TextView, PathSelectionCallback> CALLBACKS = new WeakHashMap<>();

    /**
     * 方案 B：保留系统选择态，只在选区 ActionMode 创建时把选区扩到「当前词所在的整条路径」。
     * 递归处理 root 下所有 {@code textIsSelectable} 的 {@link TextView}（跳过 {@link EditText}）。
     *
     * <p>开关关闭时回调不扩选、不改系统菜单，行为等同未安装（系统按词选择）。
     * <b>已知风险</b>：MIUI/HyperOS 可能不走这套系统回调，届时本功能不生效（用户已知情并接受）。
     */
    static void installPathSelection(@NonNull View root) {
        if (root instanceof TextView && !(root instanceof EditText)) {
            TextView text = (TextView) root;
            if (text.isTextSelectable()) {
                PathSelectionCallback callback = new PathSelectionCallback(text);
                CALLBACKS.put(text, callback);
                text.setCustomSelectionActionModeCallback(callback);
                // 只观察按住/抬手与拖动：返回 false，系统选择与手柄拖动原样走（两段式的计时用它）
                text.setOnTouchListener(new HoldWatcher(callback));
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
     * 单个控件的选区回调：<b>两段式</b>——系统长按先按词选中一段，继续按住满 {@link #HOLD_TO_EXPAND_MS}
     * 才扩成整条路径；抬手或改成拖选即保持系统那一段。每次 ActionMode 至多扩一次。
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
        private final Runnable expandAfterHold = this::expandIfStillHolding;

        PathSelectionCallback(TextView view) {
            this.view = view;
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            expanded = false;
            this.mode = mode;
            // 开关实时读取（与其它 webui 组界面键同一套），创建当帧即生效
            if (isPathCopyEnabled(view.getContext())) {
                // 系统在创建回调之后才落定选区，延一帧再起计时：先让用户看到选中的那一段
                view.post(() -> {
                    if (expanded) {
                        return;
                    }
                    if (holding) {
                        view.postDelayed(expandAfterHold, HOLD_TO_EXPAND_MS);
                    } else {
                        // 非按住触发（键盘/无障碍等）：退回一步到位，保证整条复制在这些入口仍可用
                        expandOnce();
                    }
                });
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

        /** 按住状态由 {@link HoldWatcher} 维护：抬手/拖动即取消这一次扩选。 */
        void setHolding(boolean value) {
            holding = value;
            if (!value) {
                view.removeCallbacks(expandAfterHold);
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
            if (!holding || expanded) {
                return;   // 已抬手/已拖动：保留系统选中的那一段
            }
            expandOnce();
        }

        private void expandOnce() {
            if (expanded) {
                return;
            }
            expanded = true;
            if (!view.isAttachedToWindow() || !view.hasSelection()) {
                return;
            }
            CharSequence text = view.getText();
            int[] bounds = wholePathBounds(
                    text, view.getSelectionStart(), view.getSelectionEnd());
            // textIsSelectable 的控件文本是 SPANNABLE（见 setTextIsSelectable），可直接设选区
            if (bounds != null && text instanceof Spannable) {
                Selection.setSelection((Spannable) text, bounds[0], bounds[1]);
            }
        }
    }

    /**
     * 按住观察者：只记录按下/移动/抬起，<b>不消费事件</b>（返回 false，系统选择与手柄拖动原样走）。
     * 移动超出触摸阈值即视为用户改成拖选，取消这次自动扩选。
     */
    private static final class HoldWatcher implements View.OnTouchListener {

        private final PathSelectionCallback callback;
        private float downX;
        private float downY;
        private boolean moved;

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
                    callback.setHolding(true);
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
                case MotionEvent.ACTION_CANCEL:
                    callback.setHolding(false);
                    break;
                default:
                    break;
            }
            return false;
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
