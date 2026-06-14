package a;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lh {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<View> f1801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f1800a = null;
    public Runnable b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6706a = -1;

    public lh(View view) {
        this.f1801a = new WeakReference<>(view);
    }

    public lh a(float f) {
        View view = this.f1801a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        View view = this.f1801a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.f1801a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public lh d(long j) {
        View view = this.f1801a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public lh e(Interpolator interpolator) {
        View view = this.f1801a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public lh f(mh mhVar) {
        View view = this.f1801a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, mhVar);
                mhVar = new kh(this);
            }
            g(view, mhVar);
        }
        return this;
    }

    public final void g(View view, mh mhVar) {
        if (mhVar != null) {
            view.animate().setListener(new ih(this, mhVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public lh h(long j) {
        View view = this.f1801a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public lh i(oh ohVar) {
        View view = this.f1801a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(ohVar != null ? new jh(this, ohVar, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.f1801a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public lh k(float f) {
        View view = this.f1801a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
