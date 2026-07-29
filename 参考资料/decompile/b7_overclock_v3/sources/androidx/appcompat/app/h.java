package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.g1;
import g.d0;
import g.d1;
import g.i0;
import g.n0;
import g.p0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import l.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f1636a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1637b = "AppCompatDelegate";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f1638c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f1639d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f1640e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1641f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1642g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1643h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f1644i = -100;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f1645j = -100;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final androidx.collection.c<WeakReference<h>> f1646k = new androidx.collection.c<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f1647l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f1648m = 108;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f1649n = 109;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f1650o = 10;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface a {
    }

    public static void G(@n0 h hVar) {
        synchronized (f1647l) {
            H(hVar);
        }
    }

    public static void H(@n0 h hVar) {
        synchronized (f1647l) {
            Iterator<WeakReference<h>> it2 = f1646k.iterator();
            while (it2.hasNext()) {
                h hVar2 = it2.next().get();
                if (hVar2 == hVar || hVar2 == null) {
                    it2.remove();
                }
            }
        }
    }

    public static void J(boolean z10) {
        g1.c(z10);
    }

    public static void N(int i10) {
        if ((i10 == -1 || i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3) && f1645j != i10) {
            f1645j = i10;
            f();
        }
    }

    public static void c(@n0 h hVar) {
        synchronized (f1647l) {
            H(hVar);
            f1646k.add(new WeakReference<>(hVar));
        }
    }

    public static void f() {
        synchronized (f1647l) {
            Iterator<WeakReference<h>> it2 = f1646k.iterator();
            while (it2.hasNext()) {
                h hVar = it2.next().get();
                if (hVar != null) {
                    hVar.e();
                }
            }
        }
    }

    @n0
    public static h i(@n0 Activity activity, @p0 g gVar) {
        return new AppCompatDelegateImpl(activity, gVar);
    }

    @n0
    public static h j(@n0 Dialog dialog, @p0 g gVar) {
        return new AppCompatDelegateImpl(dialog, gVar);
    }

    @n0
    public static h k(@n0 Context context, @n0 Activity activity, @p0 g gVar) {
        return new AppCompatDelegateImpl(context, activity, gVar);
    }

    @n0
    public static h l(@n0 Context context, @n0 Window window, @p0 g gVar) {
        return new AppCompatDelegateImpl(context, window, gVar);
    }

    public static int o() {
        return f1645j;
    }

    public static boolean w() {
        return g1.b();
    }

    public abstract void A();

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D(Bundle bundle);

    public abstract void E();

    public abstract void F();

    public abstract boolean I(int i10);

    public abstract void K(@i0 int i10);

    public abstract void L(View view);

    public abstract void M(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void O(boolean z10);

    @v0(17)
    public abstract void P(int i10);

    public abstract void Q(@p0 Toolbar toolbar);

    public void R(@d1 int i10) {
    }

    public abstract void S(@p0 CharSequence charSequence);

    @p0
    public abstract l.b T(@n0 b.a aVar);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean e();

    @Deprecated
    public void g(Context context) {
    }

    @g.i
    @n0
    public Context h(@n0 Context context) {
        g(context);
        return context;
    }

    public abstract View m(@p0 View view, String str, @n0 Context context, @n0 AttributeSet attributeSet);

    @p0
    public abstract <T extends View> T n(@d0 int i10);

    @p0
    public abstract c.b p();

    public int q() {
        return -100;
    }

    public abstract MenuInflater r();

    @p0
    public abstract androidx.appcompat.app.a s();

    public abstract boolean t(int i10);

    public abstract void u();

    public abstract void v();

    public abstract boolean x();

    public abstract void y(Configuration configuration);

    public abstract void z(Bundle bundle);
}
