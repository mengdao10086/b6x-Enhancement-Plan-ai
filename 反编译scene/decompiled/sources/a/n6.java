package a;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n6 implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o6 f6879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f2025a;

    public n6(o6 o6Var, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f6879a = o6Var;
        this.f2025a = onGlobalLayoutListener;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f6879a.f6986a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2025a);
        }
    }
}
