package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import g.c1;
import g.d1;
import g.p0;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g0 {
    public static final int A = 7;
    public static final int B = 8;
    public static final int C = 9;
    public static final int D = 10;
    public static final int E = 4096;
    public static final int F = 8192;
    public static final int G = -1;
    public static final int H = 0;
    public static final int I = 4097;
    public static final int J = 8194;
    public static final int K = 4099;
    public static final int L = 4100;
    public static final int M = 8197;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f5938t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5939u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5940v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5941w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5942x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f5943y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f5944z = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f5945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassLoader f5946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<a> f5947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public String f5955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f5957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f5959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<String> f5960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<String> f5961q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f5962r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<Runnable> f5963s;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f5965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5967d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5968e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5969f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5970g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Lifecycle.State f5971h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Lifecycle.State f5972i;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f5964a = i10;
            this.f5965b = fragment;
            this.f5966c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f5971h = state;
            this.f5972i = state;
        }

        public a(int i10, Fragment fragment, boolean z10) {
            this.f5964a = i10;
            this.f5965b = fragment;
            this.f5966c = z10;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f5971h = state;
            this.f5972i = state;
        }

        public a(int i10, @g.n0 Fragment fragment, Lifecycle.State state) {
            this.f5964a = i10;
            this.f5965b = fragment;
            this.f5966c = false;
            this.f5971h = fragment.I7;
            this.f5972i = state;
        }

        public a(a aVar) {
            this.f5964a = aVar.f5964a;
            this.f5965b = aVar.f5965b;
            this.f5966c = aVar.f5966c;
            this.f5967d = aVar.f5967d;
            this.f5968e = aVar.f5968e;
            this.f5969f = aVar.f5969f;
            this.f5970g = aVar.f5970g;
            this.f5971h = aVar.f5971h;
            this.f5972i = aVar.f5972i;
        }
    }

    @Deprecated
    public g0() {
        this.f5947c = new ArrayList<>();
        this.f5954j = true;
        this.f5962r = false;
        this.f5945a = null;
        this.f5946b = null;
    }

    public boolean A() {
        return this.f5947c.isEmpty();
    }

    @g.n0
    public g0 B(@g.n0 Fragment fragment) {
        m(new a(3, fragment));
        return this;
    }

    @g.n0
    public g0 C(@g.d0 int i10, @g.n0 Fragment fragment) {
        return D(i10, fragment, null);
    }

    @g.n0
    public g0 D(@g.d0 int i10, @g.n0 Fragment fragment, @p0 String str) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        x(i10, fragment, str, 2);
        return this;
    }

    @g.n0
    public final g0 E(@g.d0 int i10, @g.n0 Class<? extends Fragment> cls, @p0 Bundle bundle) {
        return F(i10, cls, bundle, null);
    }

    @g.n0
    public final g0 F(@g.d0 int i10, @g.n0 Class<? extends Fragment> cls, @p0 Bundle bundle, @p0 String str) {
        return D(i10, u(cls, bundle), str);
    }

    @g.n0
    public g0 G(@g.n0 Runnable runnable) {
        w();
        if (this.f5963s == null) {
            this.f5963s = new ArrayList<>();
        }
        this.f5963s.add(runnable);
        return this;
    }

    @g.n0
    @Deprecated
    public g0 H(boolean z10) {
        return Q(z10);
    }

    @g.n0
    @Deprecated
    public g0 I(@c1 int i10) {
        this.f5958n = i10;
        this.f5959o = null;
        return this;
    }

    @g.n0
    @Deprecated
    public g0 J(@p0 CharSequence charSequence) {
        this.f5958n = 0;
        this.f5959o = charSequence;
        return this;
    }

    @g.n0
    @Deprecated
    public g0 K(@c1 int i10) {
        this.f5956l = i10;
        this.f5957m = null;
        return this;
    }

    @g.n0
    @Deprecated
    public g0 L(@p0 CharSequence charSequence) {
        this.f5956l = 0;
        this.f5957m = charSequence;
        return this;
    }

    @g.n0
    public g0 M(@g.a @g.b int i10, @g.a @g.b int i11) {
        return N(i10, i11, 0, 0);
    }

    @g.n0
    public g0 N(@g.a @g.b int i10, @g.a @g.b int i11, @g.a @g.b int i12, @g.a @g.b int i13) {
        this.f5948d = i10;
        this.f5949e = i11;
        this.f5950f = i12;
        this.f5951g = i13;
        return this;
    }

    @g.n0
    public g0 O(@g.n0 Fragment fragment, @g.n0 Lifecycle.State state) {
        m(new a(10, fragment, state));
        return this;
    }

    @g.n0
    public g0 P(@p0 Fragment fragment) {
        m(new a(8, fragment));
        return this;
    }

    @g.n0
    public g0 Q(boolean z10) {
        this.f5962r = z10;
        return this;
    }

    @g.n0
    public g0 R(int i10) {
        this.f5952h = i10;
        return this;
    }

    @g.n0
    @Deprecated
    public g0 S(@d1 int i10) {
        return this;
    }

    @g.n0
    public g0 T(@g.n0 Fragment fragment) {
        m(new a(5, fragment));
        return this;
    }

    @g.n0
    public g0 f(@g.d0 int i10, @g.n0 Fragment fragment) {
        x(i10, fragment, null, 1);
        return this;
    }

    @g.n0
    public g0 g(@g.d0 int i10, @g.n0 Fragment fragment, @p0 String str) {
        x(i10, fragment, str, 1);
        return this;
    }

    @g.n0
    public final g0 h(@g.d0 int i10, @g.n0 Class<? extends Fragment> cls, @p0 Bundle bundle) {
        return f(i10, u(cls, bundle));
    }

    @g.n0
    public final g0 i(@g.d0 int i10, @g.n0 Class<? extends Fragment> cls, @p0 Bundle bundle, @p0 String str) {
        return g(i10, u(cls, bundle), str);
    }

    public g0 j(@g.n0 ViewGroup viewGroup, @g.n0 Fragment fragment, @p0 String str) {
        fragment.f5665v1 = viewGroup;
        return g(viewGroup.getId(), fragment, str);
    }

    @g.n0
    public g0 k(@g.n0 Fragment fragment, @p0 String str) {
        x(0, fragment, str, 1);
        return this;
    }

    @g.n0
    public final g0 l(@g.n0 Class<? extends Fragment> cls, @p0 Bundle bundle, @p0 String str) {
        return k(u(cls, bundle), str);
    }

    public void m(a aVar) {
        this.f5947c.add(aVar);
        aVar.f5967d = this.f5948d;
        aVar.f5968e = this.f5949e;
        aVar.f5969f = this.f5950f;
        aVar.f5970g = this.f5951g;
    }

    @g.n0
    public g0 n(@g.n0 View view, @g.n0 String str) {
        if (i0.f()) {
            String strX0 = u0.x0(view);
            if (strX0 == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.f5960p == null) {
                this.f5960p = new ArrayList<>();
                this.f5961q = new ArrayList<>();
            } else {
                if (this.f5961q.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                if (this.f5960p.contains(strX0)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + strX0 + "' has already been added to the transaction.");
                }
            }
            this.f5960p.add(strX0);
            this.f5961q.add(str);
        }
        return this;
    }

    @g.n0
    public g0 o(@p0 String str) {
        if (!this.f5954j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f5953i = true;
        this.f5955k = str;
        return this;
    }

    @g.n0
    public g0 p(@g.n0 Fragment fragment) {
        m(new a(7, fragment));
        return this;
    }

    public abstract int q();

    public abstract int r();

    public abstract void s();

    public abstract void t();

    @g.n0
    public final Fragment u(@g.n0 Class<? extends Fragment> cls, @p0 Bundle bundle) {
        k kVar = this.f5945a;
        if (kVar == null) {
            throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        ClassLoader classLoader = this.f5946b;
        if (classLoader == null) {
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        Fragment fragmentA = kVar.a(classLoader, cls.getName());
        if (bundle != null) {
            fragmentA.c5(bundle);
        }
        return fragmentA;
    }

    @g.n0
    public g0 v(@g.n0 Fragment fragment) {
        m(new a(6, fragment));
        return this;
    }

    @g.n0
    public g0 w() {
        if (this.f5953i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f5954j = false;
        return this;
    }

    public void x(int i10, Fragment fragment, @p0 String str, int i11) {
        String str2 = fragment.H7;
        if (str2 != null) {
            FragmentStrictMode.i(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.f5670z;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f5670z + " now " + str);
            }
            fragment.f5670z = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i12 = fragment.f5668x;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f5668x + " now " + i10);
            }
            fragment.f5668x = i10;
            fragment.f5669y = i10;
        }
        m(new a(i11, fragment));
    }

    @g.n0
    public g0 y(@g.n0 Fragment fragment) {
        m(new a(4, fragment));
        return this;
    }

    public boolean z() {
        return this.f5954j;
    }

    public g0(@g.n0 k kVar, @p0 ClassLoader classLoader) {
        this.f5947c = new ArrayList<>();
        this.f5954j = true;
        this.f5962r = false;
        this.f5945a = kVar;
        this.f5946b = classLoader;
    }

    public g0(@g.n0 k kVar, @p0 ClassLoader classLoader, @g.n0 g0 g0Var) {
        this(kVar, classLoader);
        Iterator<a> it2 = g0Var.f5947c.iterator();
        while (it2.hasNext()) {
            this.f5947c.add(new a(it2.next()));
        }
        this.f5948d = g0Var.f5948d;
        this.f5949e = g0Var.f5949e;
        this.f5950f = g0Var.f5950f;
        this.f5951g = g0Var.f5951g;
        this.f5952h = g0Var.f5952h;
        this.f5953i = g0Var.f5953i;
        this.f5954j = g0Var.f5954j;
        this.f5955k = g0Var.f5955k;
        this.f5958n = g0Var.f5958n;
        this.f5959o = g0Var.f5959o;
        this.f5956l = g0Var.f5956l;
        this.f5957m = g0Var.f5957m;
        if (g0Var.f5960p != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.f5960p = arrayList;
            arrayList.addAll(g0Var.f5960p);
        }
        if (g0Var.f5961q != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.f5961q = arrayList2;
            arrayList2.addAll(g0Var.f5961q);
        }
        this.f5962r = g0Var.f5962r;
    }
}
