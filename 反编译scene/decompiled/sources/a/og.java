package a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class og implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewTreeObserver f2241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f2242a;

    public og(View view, Runnable runnable) {
        this.f7018a = view;
        this.f2241a = view.getViewTreeObserver();
        this.f2242a = runnable;
    }

    public static og a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        og ogVar = new og(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(ogVar);
        view.addOnAttachStateChangeListener(ogVar);
        return ogVar;
    }

    public void b() {
        (this.f2241a.isAlive() ? this.f2241a : this.f7018a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f7018a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f2242a.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f2241a = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
