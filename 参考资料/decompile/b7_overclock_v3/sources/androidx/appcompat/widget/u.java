package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.e;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2711a = "ReceiveContent";

    @g.v0(24)
    public static final class a {
        @g.u
        public static boolean a(@g.n0 DragEvent dragEvent, @g.n0 TextView textView, @g.n0 Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                androidx.core.view.u0.m1(textView, new e.b(dragEvent.getClipData(), 3).a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th2) {
                textView.endBatchEdit();
                throw th2;
            }
        }

        @g.u
        public static boolean b(@g.n0 DragEvent dragEvent, @g.n0 View view, @g.n0 Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            androidx.core.view.u0.m1(view, new e.b(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    public static boolean a(@g.n0 View view, @g.n0 DragEvent dragEvent) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 31 && i10 >= 24 && dragEvent.getLocalState() == null && androidx.core.view.u0.h0(view) != null) {
            Activity activityC = c(view);
            if (activityC == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't handle drop: no activity: view=");
                sb2.append(view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (dragEvent.getAction() == 3) {
                return view instanceof TextView ? a.a(dragEvent, (TextView) view, activityC) : a.b(dragEvent, view, activityC);
            }
        }
        return false;
    }

    public static boolean b(@g.n0 TextView textView, int i10) {
        if (Build.VERSION.SDK_INT >= 31 || androidx.core.view.u0.h0(textView) == null || !(i10 == 16908322 || i10 == 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            androidx.core.view.u0.m1(textView, new e.b(primaryClip, 1).d(i10 != 16908322 ? 1 : 0).a());
        }
        return true;
    }

    @g.p0
    public static Activity c(@g.n0 View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
