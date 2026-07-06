package a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a4 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e4 f5567a;

    public a4(e4 e4Var) {
        this.f5567a = e4Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f5567a.f659a;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f5567a.f659a = view.getViewTreeObserver();
            }
            e4 e4Var = this.f5567a;
            e4Var.f659a.removeGlobalOnLayoutListener(e4Var.f658a);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
