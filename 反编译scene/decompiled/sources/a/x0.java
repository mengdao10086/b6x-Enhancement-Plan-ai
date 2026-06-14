package a;

import a.k3;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7839a = -100;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final da<WeakReference<x0>> f3503a = new da<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f3504a = new Object();

    public static void A(x0 x0Var) {
        synchronized (f3504a) {
            B(x0Var);
        }
    }

    public static void B(x0 x0Var) {
        synchronized (f3504a) {
            Iterator<WeakReference<x0>> it = f3503a.iterator();
            while (it.hasNext()) {
                x0 x0Var2 = it.next().get();
                if (x0Var2 == x0Var || x0Var2 == null) {
                    it.remove();
                }
            }
        }
    }

    public static void G(int i) {
        if (i != -1 && i != 0 && i != 1 && i != 2 && i != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        } else if (f7839a != i) {
            f7839a = i;
            f();
        }
    }

    public static void c(x0 x0Var) {
        synchronized (f3504a) {
            B(x0Var);
            f3503a.add(new WeakReference<>(x0Var));
        }
    }

    public static void f() {
        synchronized (f3504a) {
            Iterator<WeakReference<x0>> it = f3503a.iterator();
            while (it.hasNext()) {
                x0 x0Var = it.next().get();
                if (x0Var != null) {
                    x0Var.e();
                }
            }
        }
    }

    public static x0 i(Activity activity, w0 w0Var) {
        return new w1(activity, w0Var);
    }

    public static x0 j(Dialog dialog, w0 w0Var) {
        return new w1(dialog, w0Var);
    }

    public static int l() {
        return f7839a;
    }

    public abstract boolean C(int i);

    public abstract void D(int i);

    public abstract void E(View view);

    public abstract void F(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void H(int i);

    public abstract void I(Toolbar toolbar);

    public abstract void J(int i);

    public abstract void K(CharSequence charSequence);

    public abstract k3 L(k3.a aVar);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean e();

    @Deprecated
    public void g(Context context) {
    }

    public Context h(Context context) {
        g(context);
        return context;
    }

    public abstract <T extends View> T k(int i);

    public abstract f0 m();

    public abstract int n();

    public abstract MenuInflater o();

    public abstract d0 p();

    public abstract void q();

    public abstract void r();

    public abstract void s(Configuration configuration);

    public abstract void t(Bundle bundle);

    public abstract void u();

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z();
}
