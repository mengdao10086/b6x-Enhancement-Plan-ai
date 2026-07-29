package com.blankj.utilcode.util;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f11709k = -2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f11710l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f11711m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f11712n = -16777217;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f11713o = -13912576;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f11714p = -16128;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f11715q = -65536;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f11716r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static WeakReference<Snackbar> f11717s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f11718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f11719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f11724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View.OnClickListener f11726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11727j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public c1(View view) {
        k();
        this.f11718a = view;
    }

    public static void a(@g.i0 int i10, @g.n0 ViewGroup.LayoutParams layoutParams) {
        Objects.requireNonNull(layoutParams, "Argument 'params' of type ViewGroup.LayoutParams (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View viewE = e();
        if (viewE != null) {
            viewE.setPadding(0, 0, 0, 0);
            ((Snackbar.SnackbarLayout) viewE).addView(LayoutInflater.from(viewE.getContext()).inflate(i10, (ViewGroup) null), -1, layoutParams);
        }
    }

    public static void b(@g.n0 View view, @g.n0 ViewGroup.LayoutParams layoutParams) {
        Objects.requireNonNull(view, "Argument 'child' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(layoutParams, "Argument 'params' of type ViewGroup.LayoutParams (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View viewE = e();
        if (viewE != null) {
            viewE.setPadding(0, 0, 0, 0);
            ((Snackbar.SnackbarLayout) viewE).addView(view, layoutParams);
        }
    }

    public static void c() {
        WeakReference<Snackbar> weakReference = f11717s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        f11717s.get().x();
        f11717s = null;
    }

    public static ViewGroup d(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    public static View e() {
        Snackbar snackbar = f11717s.get();
        if (snackbar == null) {
            return null;
        }
        return snackbar.K();
    }

    public static c1 w(@g.n0 View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return new c1(view);
    }

    public c1 f(@g.n0 CharSequence charSequence, @g.l int i10, @g.n0 View.OnClickListener onClickListener) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(onClickListener, "Argument 'listener' of type View.OnClickListener (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11724g = charSequence;
        this.f11725h = i10;
        this.f11726i = onClickListener;
        return this;
    }

    public c1 g(@g.n0 CharSequence charSequence, @g.n0 View.OnClickListener onClickListener) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(onClickListener, "Argument 'listener' of type View.OnClickListener (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return f(charSequence, -16777217, onClickListener);
    }

    public c1 h(@g.l int i10) {
        this.f11721d = i10;
        return this;
    }

    public c1 i(@g.v int i10) {
        this.f11722e = i10;
        return this;
    }

    public c1 j(@g.f0(from = 1) int i10) {
        this.f11727j = i10;
        return this;
    }

    public final void k() {
        this.f11719b = "";
        this.f11720c = -16777217;
        this.f11721d = -16777217;
        this.f11722e = -1;
        this.f11723f = -1;
        this.f11724g = "";
        this.f11725h = -16777217;
        this.f11727j = 0;
    }

    public c1 l(int i10) {
        this.f11723f = i10;
        return this;
    }

    public c1 m(@g.n0 CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "Argument 'msg' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11719b = charSequence;
        return this;
    }

    public c1 n(@g.l int i10) {
        this.f11720c = i10;
        return this;
    }

    public Snackbar o() {
        return p(false);
    }

    public Snackbar p(boolean z10) {
        View view = this.f11718a;
        if (view == null) {
            return null;
        }
        View view2 = view;
        if (z10) {
            ViewGroup viewGroupD = d(view);
            View viewFindViewWithTag = viewGroupD.findViewWithTag("topSnackBarCoordinatorLayout");
            View view3 = viewFindViewWithTag;
            if (viewFindViewWithTag == null) {
                CoordinatorLayout coordinatorLayout = new CoordinatorLayout(view.getContext());
                coordinatorLayout.setTag("topSnackBarCoordinatorLayout");
                coordinatorLayout.setRotation(180.0f);
                coordinatorLayout.setElevation(100.0f);
                viewGroupD.addView(coordinatorLayout, -1, -1);
                view3 = coordinatorLayout;
            }
            view2 = view3;
        }
        if (this.f11720c != -16777217) {
            SpannableString spannableString = new SpannableString(this.f11719b);
            spannableString.setSpan(new ForegroundColorSpan(this.f11720c), 0, spannableString.length(), 33);
            f11717s = new WeakReference<>(Snackbar.C0(view2, spannableString, this.f11723f));
        } else {
            f11717s = new WeakReference<>(Snackbar.C0(view2, this.f11719b, this.f11723f));
        }
        Snackbar snackbar = f11717s.get();
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.K();
        if (z10) {
            for (int i10 = 0; i10 < snackbarLayout.getChildCount(); i10++) {
                snackbarLayout.getChildAt(i10).setRotation(180.0f);
            }
        }
        int i11 = this.f11722e;
        if (i11 != -1) {
            snackbarLayout.setBackgroundResource(i11);
        } else {
            int i12 = this.f11721d;
            if (i12 != -16777217) {
                snackbarLayout.setBackgroundColor(i12);
            }
        }
        if (this.f11727j != 0) {
            ((ViewGroup.MarginLayoutParams) snackbarLayout.getLayoutParams()).bottomMargin = this.f11727j;
        }
        if (this.f11724g.length() > 0 && this.f11726i != null) {
            int i13 = this.f11725h;
            if (i13 != -16777217) {
                snackbar.G0(i13);
            }
            snackbar.F0(this.f11724g, this.f11726i);
        }
        snackbar.k0();
        return snackbar;
    }

    public void q() {
        r(false);
    }

    public void r(boolean z10) {
        this.f11721d = -65536;
        this.f11720c = -1;
        this.f11725h = -1;
        p(z10);
    }

    public void s() {
        t(false);
    }

    public void t(boolean z10) {
        this.f11721d = f11713o;
        this.f11720c = -1;
        this.f11725h = -1;
        p(z10);
    }

    public void u() {
        v(false);
    }

    public void v(boolean z10) {
        this.f11721d = f11714p;
        this.f11720c = -1;
        this.f11725h = -1;
        p(z10);
    }
}
