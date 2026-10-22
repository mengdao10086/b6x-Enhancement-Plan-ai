package com.example.waspwingtempctrl.ui;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
            }
        });
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

    private static void copy(@NonNull Context context, @NonNull CharSequence text) {
        ClipboardManager manager =
                (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (manager != null) {
            manager.setPrimaryClip(ClipData.newPlainText("text", text));
        }
    }
}
