package a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a5 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b5 f5570a;

    public a5(b5 b5Var) {
        this.f5570a = b5Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f5570a.f223a;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f5570a.f223a = view.getViewTreeObserver();
            }
            b5 b5Var = this.f5570a;
            b5Var.f223a.removeGlobalOnLayoutListener(b5Var.f222a);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
