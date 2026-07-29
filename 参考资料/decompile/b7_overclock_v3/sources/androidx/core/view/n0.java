package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f5052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f5053c;

    public n0(View view, Runnable runnable) {
        this.f5051a = view;
        this.f5052b = view.getViewTreeObserver();
        this.f5053c = runnable;
    }

    @g.n0
    public static n0 a(@g.n0 View view, @g.n0 Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        n0 n0Var = new n0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(n0Var);
        view.addOnAttachStateChangeListener(n0Var);
        return n0Var;
    }

    public void b() {
        if (this.f5052b.isAlive()) {
            this.f5052b.removeOnPreDrawListener(this);
        } else {
            this.f5051a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f5051a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f5053c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@g.n0 View view) {
        this.f5052b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@g.n0 View view) {
        b();
    }
}
