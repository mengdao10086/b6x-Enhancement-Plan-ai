package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.t0;
import androidx.lifecycle.z0;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.bumptech.glide.load.engine.GlideException;
import g.h1;
import g.p0;
import g.v0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.y, d1, androidx.lifecycle.r, androidx.savedstate.d, androidx.activity.result.b {
    public static final Object S7 = new Object();
    public static final int T7 = -1;
    public static final int U7 = 0;
    public static final int V7 = 1;
    public static final int W7 = 2;
    public static final int X7 = 3;
    public static final int Y7 = 4;
    public static final int Z7 = 5;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final int f5639a8 = 6;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final int f5640b8 = 7;
    public boolean A;
    public boolean B;
    public boolean C;
    public View C1;
    public j C2;
    public boolean D;
    public boolean E7;
    public LayoutInflater F7;
    public boolean G7;

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String H7;
    public Lifecycle.State I7;
    public androidx.lifecycle.a0 J7;
    public boolean K0;
    public boolean K1;
    public Runnable K2;

    @p0
    public l0 K7;
    public androidx.lifecycle.j0<androidx.lifecycle.y> L7;
    public z0.b M7;
    public androidx.savedstate.c N7;

    @g.i0
    public int O7;
    public final AtomicInteger P7;
    public final ArrayList<l> Q7;
    public final l R7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f5642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SparseArray<Parcelable> f5643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bundle f5644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public Boolean f5645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public String f5646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f5647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Fragment f5648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f5651k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f5652k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f5653k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f5660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5661s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FragmentManager f5662t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.fragment.app.l<?> f5663u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @g.n0
    public FragmentManager f5664v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public ViewGroup f5665v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f5666v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Fragment f5667w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f5668x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f5669y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f5670z;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@g.n0 String str, @p0 Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class a<I> extends androidx.activity.result.g<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f5673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f.a f5674b;

        public a(AtomicReference atomicReference, f.a aVar) {
            this.f5673a = atomicReference;
            this.f5674b = aVar;
        }

        @Override // androidx.activity.result.g
        @g.n0
        public f.a<I, ?> a() {
            return this.f5674b;
        }

        @Override // androidx.activity.result.g
        public void c(I i10, @p0 f0.e eVar) {
            androidx.activity.result.g gVar = (androidx.activity.result.g) this.f5673a.get();
            if (gVar == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            gVar.c(i10, eVar);
        }

        @Override // androidx.activity.result.g
        public void d() {
            androidx.activity.result.g gVar = (androidx.activity.result.g) this.f5673a.getAndSet(null);
            if (gVar != null) {
                gVar.d();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.C5();
        }
    }

    public class c extends l {
        public c() {
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.l
        public void a() {
            Fragment.this.N7.c();
            SavedStateHandleSupport.c(Fragment.this);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.g1(false);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController f5679a;

        public e(SpecialEffectsController specialEffectsController) {
            this.f5679a = specialEffectsController;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5679a.g();
        }
    }

    public class f extends androidx.fragment.app.i {
        public f() {
        }

        @Override // androidx.fragment.app.i
        @p0
        public View c(int i10) {
            View view = Fragment.this.C1;
            if (view != null) {
                return view.findViewById(i10);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.i
        public boolean d() {
            return Fragment.this.C1 != null;
        }
    }

    public class g implements p.a<Void, ActivityResultRegistry> {
        public g() {
        }

        @Override // p.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r32) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.f5663u;
            return obj instanceof androidx.activity.result.i ? ((androidx.activity.result.i) obj).v0() : fragment.P4().v0();
        }
    }

    public class h implements p.a<Void, ActivityResultRegistry> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityResultRegistry f5683a;

        public h(ActivityResultRegistry activityResultRegistry) {
            this.f5683a = activityResultRegistry;
        }

        @Override // p.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r12) {
            return this.f5683a;
        }
    }

    public class i extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p.a f5685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f5686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f.a f5687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.activity.result.a f5688d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(p.a aVar, AtomicReference atomicReference, f.a aVar2, androidx.activity.result.a aVar3) {
            super(null);
            this.f5685a = aVar;
            this.f5686b = atomicReference;
            this.f5687c = aVar2;
            this.f5688d = aVar3;
        }

        @Override // androidx.fragment.app.Fragment.l
        public void a() {
            String strU1 = Fragment.this.u1();
            this.f5686b.set(((ActivityResultRegistry) this.f5685a.apply(null)).i(strU1, Fragment.this, this.f5687c, this.f5688d));
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f5690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.a
        public int f5692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.a
        public int f5693d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.a
        public int f5694e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @g.a
        public int f5695f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5696g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList<String> f5697h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ArrayList<String> f5698i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f5699j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f5700k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f5701l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f5702m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f5703n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f5704o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f5705p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f5706q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public f0.k0 f5707r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public f0.k0 f5708s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f5709t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public View f5710u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f5711v;

        public j() {
            Object obj = Fragment.S7;
            this.f5700k = obj;
            this.f5701l = null;
            this.f5702m = obj;
            this.f5703n = null;
            this.f5704o = obj;
            this.f5707r = null;
            this.f5708s = null;
            this.f5709t = 1.0f;
            this.f5710u = null;
        }
    }

    @v0(19)
    public static class k {
        public static void a(@g.n0 View view) {
            view.cancelPendingInputEvents();
        }
    }

    public static abstract class l {
        public l() {
        }

        public abstract void a();

        public /* synthetic */ l(b bVar) {
            this();
        }
    }

    public Fragment() {
        this.f5641a = -1;
        this.f5646f = UUID.randomUUID().toString();
        this.f5649i = null;
        this.f5651k = null;
        this.f5664v = new v();
        this.K0 = true;
        this.f5666v2 = true;
        this.K2 = new b();
        this.I7 = Lifecycle.State.RESUMED;
        this.L7 = new androidx.lifecycle.j0<>();
        this.P7 = new AtomicInteger();
        this.Q7 = new ArrayList<>();
        this.R7 = new c();
        o3();
    }

    @g.n0
    @Deprecated
    public static Fragment q3(@g.n0 Context context, @g.n0 String str) {
        return r3(context, str, null);
    }

    @g.n0
    @Deprecated
    public static Fragment r3(@g.n0 Context context, @g.n0 String str, @p0 Bundle bundle) {
        try {
            Fragment fragmentNewInstance = androidx.fragment.app.k.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.c5(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e10) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        } catch (java.lang.InstantiationException e11) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e11);
        } catch (NoSuchMethodException e12) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e12);
        } catch (InvocationTargetException e13) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e13);
        }
    }

    @g.n0
    @Deprecated
    public q1.a A2() {
        return q1.a.d(this);
    }

    public final boolean A3() {
        return this.f5641a >= 7;
    }

    public void A4() {
        this.f5664v.U();
        if (this.C1 != null) {
            this.K7.a(Lifecycle.Event.ON_PAUSE);
        }
        this.J7.l(Lifecycle.Event.ON_PAUSE);
        this.f5641a = 6;
        this.f5653k1 = false;
        a4();
        if (this.f5653k1) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    @Deprecated
    public void A5(@SuppressLint({"UnknownNullness"}) Intent intent, int i10, @p0 Bundle bundle) {
        if (this.f5663u != null) {
            L2().k1(this, intent, i10, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final boolean B3() {
        FragmentManager fragmentManager = this.f5662t;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.d1();
    }

    public void B4(boolean z10) {
        b4(z10);
    }

    @Deprecated
    public void B5(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, @p0 Intent intent, int i11, int i12, int i13, @p0 Bundle bundle) throws IntentSender.SendIntentException {
        if (this.f5663u == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Fragment ");
            sb2.append(this);
            sb2.append(" received the following in startIntentSenderForResult() requestCode: ");
            sb2.append(i10);
            sb2.append(" IntentSender: ");
            sb2.append(intentSender);
            sb2.append(" fillInIntent: ");
            sb2.append(intent);
            sb2.append(" options: ");
            sb2.append(bundle);
        }
        L2().l1(this, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public final int C2() {
        Lifecycle.State state = this.I7;
        return (state == Lifecycle.State.INITIALIZED || this.f5667w == null) ? state.ordinal() : Math.min(state.ordinal(), this.f5667w.C2());
    }

    public final boolean C3() {
        View view;
        return (!s3() || u3() || (view = this.C1) == null || view.getWindowToken() == null || this.C1.getVisibility() != 0) ? false : true;
    }

    public boolean C4(@g.n0 Menu menu) {
        boolean z10 = false;
        if (this.A) {
            return false;
        }
        if (this.f5652k0 && this.K0) {
            z10 = true;
            c4(menu);
        }
        return z10 | this.f5664v.W(menu);
    }

    public void C5() {
        if (this.C2 == null || !p1().f5711v) {
            return;
        }
        if (this.f5663u == null) {
            p1().f5711v = false;
        } else if (Looper.myLooper() != this.f5663u.h().getLooper()) {
            this.f5663u.h().postAtFrontOfQueue(new d());
        } else {
            g1(true);
        }
    }

    public void D3() {
        this.f5664v.n1();
    }

    public void D4() {
        boolean zB1 = this.f5662t.b1(this);
        Boolean bool = this.f5651k;
        if (bool == null || bool.booleanValue() != zB1) {
            this.f5651k = Boolean.valueOf(zB1);
            d4(zB1);
            this.f5664v.X();
        }
    }

    public void D5(@g.n0 View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @g.i
    @g.k0
    @Deprecated
    public void E3(@p0 Bundle bundle) {
        this.f5653k1 = true;
    }

    public void E4() {
        this.f5664v.n1();
        this.f5664v.j0(true);
        this.f5641a = 7;
        this.f5653k1 = false;
        f4();
        if (!this.f5653k1) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.a0 a0Var = this.J7;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        a0Var.l(event);
        if (this.C1 != null) {
            this.K7.a(event);
        }
        this.f5664v.Y();
    }

    public int F2() {
        j jVar = this.C2;
        if (jVar == null) {
            return 0;
        }
        return jVar.f5696g;
    }

    @Deprecated
    public void F3(int i10, int i11, @p0 Intent intent) {
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Fragment ");
            sb2.append(this);
            sb2.append(" received the following in onActivityResult(): requestCode: ");
            sb2.append(i10);
            sb2.append(" resultCode: ");
            sb2.append(i11);
            sb2.append(" data: ");
            sb2.append(intent);
        }
    }

    public void F4(Bundle bundle) {
        g4(bundle);
        this.N7.e(bundle);
        Bundle bundleE1 = this.f5664v.e1();
        if (bundleE1 != null) {
            bundle.putParcelable(FragmentManager.S, bundleE1);
        }
    }

    @Override // androidx.activity.result.b
    @g.k0
    @g.n0
    public final <I, O> androidx.activity.result.g<I> G(@g.n0 f.a<I, O> aVar, @g.n0 ActivityResultRegistry activityResultRegistry, @g.n0 androidx.activity.result.a<O> aVar2) {
        return L4(aVar, new h(activityResultRegistry), aVar2);
    }

    @g.i
    @g.k0
    @Deprecated
    public void G3(@g.n0 Activity activity) {
        this.f5653k1 = true;
    }

    public void G4() {
        this.f5664v.n1();
        this.f5664v.j0(true);
        this.f5641a = 5;
        this.f5653k1 = false;
        h4();
        if (!this.f5653k1) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.a0 a0Var = this.J7;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        a0Var.l(event);
        if (this.C1 != null) {
            this.K7.a(event);
        }
        this.f5664v.Z();
    }

    @g.i
    @g.k0
    public void H3(@g.n0 Context context) {
        this.f5653k1 = true;
        androidx.fragment.app.l<?> lVar = this.f5663u;
        Activity activityF = lVar == null ? null : lVar.f();
        if (activityF != null) {
            this.f5653k1 = false;
            G3(activityF);
        }
    }

    public void H4() {
        this.f5664v.b0();
        if (this.C1 != null) {
            this.K7.a(Lifecycle.Event.ON_STOP);
        }
        this.J7.l(Lifecycle.Event.ON_STOP);
        this.f5641a = 4;
        this.f5653k1 = false;
        i4();
        if (this.f5653k1) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public boolean I1() {
        Boolean bool;
        j jVar = this.C2;
        if (jVar == null || (bool = jVar.f5705p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @g.k0
    @Deprecated
    public void I3(@g.n0 Fragment fragment) {
    }

    public void I4() {
        j4(this.C1, this.f5642b);
        this.f5664v.c0();
    }

    @p0
    public final Fragment J2() {
        return this.f5667w;
    }

    @g.k0
    public boolean J3(@g.n0 MenuItem menuItem) {
        return false;
    }

    public void J4() {
        p1().f5711v = true;
    }

    @g.i
    @g.k0
    public void K3(@p0 Bundle bundle) {
        this.f5653k1 = true;
        W4(bundle);
        if (this.f5664v.c1(1)) {
            return;
        }
        this.f5664v.J();
    }

    public final void K4(long j10, @g.n0 TimeUnit timeUnit) {
        p1().f5711v = true;
        FragmentManager fragmentManager = this.f5662t;
        Handler handlerH = fragmentManager != null ? fragmentManager.J0().h() : new Handler(Looper.getMainLooper());
        handlerH.removeCallbacks(this.K2);
        handlerH.postDelayed(this.K2, timeUnit.toMillis(j10));
    }

    @g.n0
    public final FragmentManager L2() {
        FragmentManager fragmentManager = this.f5662t;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @g.k0
    @p0
    public Animation L3(int i10, boolean z10, int i11) {
        return null;
    }

    @g.n0
    public final <I, O> androidx.activity.result.g<I> L4(@g.n0 f.a<I, O> aVar, @g.n0 p.a<Void, ActivityResultRegistry> aVar2, @g.n0 androidx.activity.result.a<O> aVar3) {
        if (this.f5641a <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            N4(new i(aVar2, atomicReference, aVar, aVar3));
            return new a(atomicReference, aVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    @g.k0
    @p0
    public Animator M3(int i10, boolean z10, int i11) {
        return null;
    }

    public void M4(@g.n0 View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @g.k0
    @Deprecated
    public void N3(@g.n0 Menu menu, @g.n0 MenuInflater menuInflater) {
    }

    public final void N4(@g.n0 l lVar) {
        if (this.f5641a >= 0) {
            lVar.a();
        } else {
            this.Q7.add(lVar);
        }
    }

    @Override // androidx.lifecycle.d1
    @g.n0
    public c1 O0() {
        if (this.f5662t == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (C2() != Lifecycle.State.INITIALIZED.ordinal()) {
            return this.f5662t.R0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public View O1() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        return jVar.f5690a;
    }

    @g.k0
    @p0
    public View O3(@g.n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        int i10 = this.O7;
        if (i10 != 0) {
            return layoutInflater.inflate(i10, viewGroup, false);
        }
        return null;
    }

    @Deprecated
    public final void O4(@g.n0 String[] strArr, int i10) {
        if (this.f5663u != null) {
            L2().j1(this, strArr, i10);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Override // androidx.activity.result.b
    @g.k0
    @g.n0
    public final <I, O> androidx.activity.result.g<I> P1(@g.n0 f.a<I, O> aVar, @g.n0 androidx.activity.result.a<O> aVar2) {
        return L4(aVar, new g(), aVar2);
    }

    public boolean P2() {
        j jVar = this.C2;
        if (jVar == null) {
            return false;
        }
        return jVar.f5691b;
    }

    @g.i
    @g.k0
    public void P3() {
        this.f5653k1 = true;
    }

    @g.n0
    public final androidx.fragment.app.g P4() {
        androidx.fragment.app.g gVarW1 = w1();
        if (gVarW1 != null) {
            return gVarW1;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @g.a
    public int Q2() {
        j jVar = this.C2;
        if (jVar == null) {
            return 0;
        }
        return jVar.f5694e;
    }

    @g.k0
    @Deprecated
    public void Q3() {
    }

    @g.n0
    public final Bundle Q4() {
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            return bundleT1;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @g.i
    @g.k0
    public void R3() {
        this.f5653k1 = true;
    }

    @g.n0
    public final Context R4() {
        Context contextX1 = X1();
        if (contextX1 != null) {
            return contextX1;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @g.a
    public int S2() {
        j jVar = this.C2;
        if (jVar == null) {
            return 0;
        }
        return jVar.f5695f;
    }

    @g.i
    @g.k0
    public void S3() {
        this.f5653k1 = true;
    }

    @g.n0
    @Deprecated
    public final FragmentManager S4() {
        return L2();
    }

    @p0
    public final Bundle T1() {
        return this.f5647g;
    }

    public float T2() {
        j jVar = this.C2;
        if (jVar == null) {
            return 1.0f;
        }
        return jVar.f5709t;
    }

    @g.n0
    public LayoutInflater T3(@p0 Bundle bundle) {
        return z2(bundle);
    }

    @g.n0
    public final Object T4() {
        Object objU2 = u2();
        if (objU2 != null) {
            return objU2;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @g.n0
    public final FragmentManager U1() {
        if (this.f5663u != null) {
            return this.f5664v;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @p0
    public Object U2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.f5702m;
        return obj == S7 ? j2() : obj;
    }

    @g.k0
    public void U3(boolean z10) {
    }

    @g.n0
    public final Fragment U4() {
        Fragment fragmentJ2 = J2();
        if (fragmentJ2 != null) {
            return fragmentJ2;
        }
        if (X1() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + X1());
    }

    @g.n0
    public final Resources V2() {
        return R4().getResources();
    }

    @h1
    @g.i
    @Deprecated
    public void V3(@g.n0 Activity activity, @g.n0 AttributeSet attributeSet, @p0 Bundle bundle) {
        this.f5653k1 = true;
    }

    @g.n0
    public final View V4() {
        View viewK3 = k3();
        if (viewK3 != null) {
            return viewK3;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Deprecated
    public final boolean W2() {
        FragmentStrictMode.k(this);
        return this.C;
    }

    @h1
    @g.i
    public void W3(@g.n0 Context context, @g.n0 AttributeSet attributeSet, @p0 Bundle bundle) {
        this.f5653k1 = true;
        androidx.fragment.app.l<?> lVar = this.f5663u;
        Activity activityF = lVar == null ? null : lVar.f();
        if (activityF != null) {
            this.f5653k1 = false;
            V3(activityF, attributeSet, bundle);
        }
    }

    public void W4(@p0 Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable(FragmentManager.S)) == null) {
            return;
        }
        this.f5664v.M1(parcelable);
        this.f5664v.J();
    }

    @p0
    public Context X1() {
        androidx.fragment.app.l<?> lVar = this.f5663u;
        if (lVar == null) {
            return null;
        }
        return lVar.g();
    }

    @p0
    public Object X2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.f5700k;
        return obj == S7 ? c2() : obj;
    }

    public void X3(boolean z10) {
    }

    public final void X4() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto RESTORE_VIEW_STATE: ");
            sb2.append(this);
        }
        if (this.C1 != null) {
            Y4(this.f5642b);
        }
        this.f5642b = null;
    }

    @p0
    public Object Y2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        return jVar.f5703n;
    }

    @g.k0
    @Deprecated
    public boolean Y3(@g.n0 MenuItem menuItem) {
        return false;
    }

    public final void Y4(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f5643c;
        if (sparseArray != null) {
            this.C1.restoreHierarchyState(sparseArray);
            this.f5643c = null;
        }
        if (this.C1 != null) {
            this.K7.d(this.f5644d);
            this.f5644d = null;
        }
        this.f5653k1 = false;
        k4(bundle);
        if (this.f5653k1) {
            if (this.C1 != null) {
                this.K7.a(Lifecycle.Event.ON_CREATE);
            }
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    @p0
    public Object Z2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.f5704o;
        return obj == S7 ? Y2() : obj;
    }

    @g.k0
    @Deprecated
    public void Z3(@g.n0 Menu menu) {
    }

    public void Z4(boolean z10) {
        p1().f5706q = Boolean.valueOf(z10);
    }

    @g.n0
    public ArrayList<String> a3() {
        ArrayList<String> arrayList;
        j jVar = this.C2;
        return (jVar == null || (arrayList = jVar.f5697h) == null) ? new ArrayList<>() : arrayList;
    }

    @g.i
    @g.k0
    public void a4() {
        this.f5653k1 = true;
    }

    public void a5(boolean z10) {
        p1().f5705p = Boolean.valueOf(z10);
    }

    @g.a
    public int b2() {
        j jVar = this.C2;
        if (jVar == null) {
            return 0;
        }
        return jVar.f5692c;
    }

    @g.n0
    public ArrayList<String> b3() {
        ArrayList<String> arrayList;
        j jVar = this.C2;
        return (jVar == null || (arrayList = jVar.f5698i) == null) ? new ArrayList<>() : arrayList;
    }

    public void b4(boolean z10) {
    }

    public void b5(@g.a int i10, @g.a int i11, @g.a int i12, @g.a int i13) {
        if (this.C2 == null && i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return;
        }
        p1().f5692c = i10;
        p1().f5693d = i11;
        p1().f5694e = i12;
        p1().f5695f = i13;
    }

    @p0
    public Object c2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        return jVar.f5699j;
    }

    @g.n0
    public final String c3(@g.c1 int i10) {
        return V2().getString(i10);
    }

    @g.k0
    @Deprecated
    public void c4(@g.n0 Menu menu) {
    }

    public void c5(@p0 Bundle bundle) {
        if (this.f5662t != null && B3()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f5647g = bundle;
    }

    public f0.k0 d2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        return jVar.f5707r;
    }

    @g.n0
    public final String d3(@g.c1 int i10, @p0 Object... objArr) {
        return V2().getString(i10, objArr);
    }

    @g.k0
    public void d4(boolean z10) {
    }

    public void d5(@p0 f0.k0 k0Var) {
        p1().f5707r = k0Var;
    }

    @Override // androidx.lifecycle.y
    @g.n0
    public Lifecycle e() {
        return this.J7;
    }

    @p0
    public final String e3() {
        return this.f5670z;
    }

    @Deprecated
    public void e4(int i10, @g.n0 String[] strArr, @g.n0 int[] iArr) {
    }

    public void e5(@p0 Object obj) {
        p1().f5699j = obj;
    }

    public final boolean equals(@p0 Object obj) {
        return super.equals(obj);
    }

    @g.a
    public int f2() {
        j jVar = this.C2;
        if (jVar == null) {
            return 0;
        }
        return jVar.f5693d;
    }

    @p0
    @Deprecated
    public final Fragment f3() {
        return g3(true);
    }

    @g.i
    @g.k0
    public void f4() {
        this.f5653k1 = true;
    }

    public void f5(@p0 f0.k0 k0Var) {
        p1().f5708s = k0Var;
    }

    public void g1(boolean z10) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        j jVar = this.C2;
        if (jVar != null) {
            jVar.f5711v = false;
        }
        if (this.C1 == null || (viewGroup = this.f5665v1) == null || (fragmentManager = this.f5662t) == null) {
            return;
        }
        SpecialEffectsController specialEffectsControllerN = SpecialEffectsController.n(viewGroup, fragmentManager);
        specialEffectsControllerN.p();
        if (z10) {
            this.f5663u.h().post(new e(specialEffectsControllerN));
        } else {
            specialEffectsControllerN.g();
        }
    }

    @p0
    public final Fragment g3(boolean z10) {
        String str;
        if (z10) {
            FragmentStrictMode.m(this);
        }
        Fragment fragment = this.f5648h;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.f5662t;
        if (fragmentManager == null || (str = this.f5649i) == null) {
            return null;
        }
        return fragmentManager.o0(str);
    }

    @g.k0
    public void g4(@g.n0 Bundle bundle) {
    }

    public void g5(@p0 Object obj) {
        p1().f5701l = obj;
    }

    @Override // androidx.lifecycle.r
    @g.n0
    public z0.b h0() {
        if (this.f5662t == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.M7 == null) {
            Application application = null;
            Context applicationContext = R4().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && FragmentManager.W0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not find Application instance from Context ");
                sb2.append(R4().getApplicationContext());
                sb2.append(", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.M7 = new t0(application, this, T1());
        }
        return this.M7;
    }

    @Deprecated
    public final int h3() {
        FragmentStrictMode.l(this);
        return this.f5650j;
    }

    @g.i
    @g.k0
    public void h4() {
        this.f5653k1 = true;
    }

    public void h5(View view) {
        p1().f5710u = view;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @g.n0
    public final CharSequence i3(@g.c1 int i10) {
        return V2().getText(i10);
    }

    @g.i
    @g.k0
    public void i4() {
        this.f5653k1 = true;
    }

    @Deprecated
    public void i5(boolean z10) {
        if (this.f5652k0 != z10) {
            this.f5652k0 = z10;
            if (!s3() || u3()) {
                return;
            }
            this.f5663u.v();
        }
    }

    @Override // androidx.lifecycle.r
    @g.i
    @g.n0
    public p1.a j0() {
        Application application;
        Context applicationContext = R4().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find Application instance from Context ");
            sb2.append(R4().getApplicationContext());
            sb2.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        p1.e eVar = new p1.e();
        if (application != null) {
            eVar.c(z0.a.f6278i, application);
        }
        eVar.c(SavedStateHandleSupport.f6123c, this);
        eVar.c(SavedStateHandleSupport.f6124d, this);
        if (T1() != null) {
            eVar.c(SavedStateHandleSupport.f6125e, T1());
        }
        return eVar;
    }

    @g.n0
    public androidx.fragment.app.i j1() {
        return new f();
    }

    @p0
    public Object j2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        return jVar.f5701l;
    }

    @Deprecated
    public boolean j3() {
        return this.f5666v2;
    }

    @g.k0
    public void j4(@g.n0 View view, @p0 Bundle bundle) {
    }

    public void j5(@p0 SavedState savedState) {
        Bundle bundle;
        if (this.f5662t != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.f5672a) == null) {
            bundle = null;
        }
        this.f5642b = bundle;
    }

    public f0.k0 k2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        return jVar.f5708s;
    }

    @p0
    public View k3() {
        return this.C1;
    }

    @g.i
    @g.k0
    public void k4(@p0 Bundle bundle) {
        this.f5653k1 = true;
    }

    public void k5(boolean z10) {
        if (this.K0 != z10) {
            this.K0 = z10;
            if (this.f5652k0 && s3() && !u3()) {
                this.f5663u.v();
            }
        }
    }

    @Override // androidx.savedstate.d
    @g.n0
    public final androidx.savedstate.b l1() {
        return this.N7.b();
    }

    @g.k0
    @g.n0
    public androidx.lifecycle.y l3() {
        l0 l0Var = this.K7;
        if (l0Var != null) {
            return l0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public void l4(Bundle bundle) {
        this.f5664v.n1();
        this.f5641a = 3;
        this.f5653k1 = false;
        E3(bundle);
        if (this.f5653k1) {
            X4();
            this.f5664v.F();
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public void l5(int i10) {
        if (this.C2 == null && i10 == 0) {
            return;
        }
        p1();
        this.C2.f5696g = i10;
    }

    @g.n0
    public LiveData<androidx.lifecycle.y> m3() {
        return this.L7;
    }

    public void m4() {
        Iterator<l> it2 = this.Q7.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.Q7.clear();
        this.f5664v.s(this.f5663u, j1(), this);
        this.f5641a = 0;
        this.f5653k1 = false;
        H3(this.f5663u.g());
        if (this.f5653k1) {
            this.f5662t.P(this);
            this.f5664v.G();
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public void m5(boolean z10) {
        if (this.C2 == null) {
            return;
        }
        p1().f5691b = z10;
    }

    public void n1(@g.n0 String str, @p0 FileDescriptor fileDescriptor, @g.n0 PrintWriter printWriter, @p0 String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f5668x));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f5669y));
        printWriter.print(" mTag=");
        printWriter.println(this.f5670z);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f5641a);
        printWriter.print(" mWho=");
        printWriter.print(this.f5646f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f5661s);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f5654l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f5655m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f5657o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f5658p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.A);
        printWriter.print(" mDetached=");
        printWriter.print(this.B);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.K0);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f5652k0);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f5666v2);
        if (this.f5662t != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f5662t);
        }
        if (this.f5663u != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f5663u);
        }
        if (this.f5667w != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f5667w);
        }
        if (this.f5647g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f5647g);
        }
        if (this.f5642b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f5642b);
        }
        if (this.f5643c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f5643c);
        }
        if (this.f5644d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f5644d);
        }
        Fragment fragmentG3 = g3(false);
        if (fragmentG3 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentG3);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f5650j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(P2());
        if (b2() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(b2());
        }
        if (f2() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(f2());
        }
        if (Q2() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(Q2());
        }
        if (S2() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(S2());
        }
        if (this.f5665v1 != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f5665v1);
        }
        if (this.C1 != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.C1);
        }
        if (O1() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(O1());
        }
        if (X1() != null) {
            q1.a.d(this).b(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f5664v + ":");
        this.f5664v.e0(str + GlideException.a.f12263d, fileDescriptor, printWriter, strArr);
    }

    public View n2() {
        j jVar = this.C2;
        if (jVar == null) {
            return null;
        }
        return jVar.f5710u;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean n3() {
        return this.f5652k0;
    }

    public void n4(@g.n0 Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public void n5(float f10) {
        p1().f5709t = f10;
    }

    public final void o3() {
        this.J7 = new androidx.lifecycle.a0(this);
        this.N7 = androidx.savedstate.c.a(this);
        this.M7 = null;
        if (this.Q7.contains(this.R7)) {
            return;
        }
        N4(this.R7);
    }

    public boolean o4(@g.n0 MenuItem menuItem) {
        if (this.A) {
            return false;
        }
        if (J3(menuItem)) {
            return true;
        }
        return this.f5664v.I(menuItem);
    }

    public void o5(@p0 Object obj) {
        p1().f5702m = obj;
    }

    @Override // android.content.ComponentCallbacks
    @g.i
    public void onConfigurationChanged(@g.n0 Configuration configuration) {
        this.f5653k1 = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @g.k0
    public void onCreateContextMenu(@g.n0 ContextMenu contextMenu, @g.n0 View view, @p0 ContextMenu.ContextMenuInfo contextMenuInfo) {
        P4().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    @g.i
    @g.k0
    public void onLowMemory() {
        this.f5653k1 = true;
    }

    public final j p1() {
        if (this.C2 == null) {
            this.C2 = new j();
        }
        return this.C2;
    }

    public void p3() {
        o3();
        this.H7 = this.f5646f;
        this.f5646f = UUID.randomUUID().toString();
        this.f5654l = false;
        this.f5655m = false;
        this.f5657o = false;
        this.f5658p = false;
        this.f5659q = false;
        this.f5661s = 0;
        this.f5662t = null;
        this.f5664v = new v();
        this.f5663u = null;
        this.f5668x = 0;
        this.f5669y = 0;
        this.f5670z = null;
        this.A = false;
        this.B = false;
    }

    public void p4(Bundle bundle) {
        this.f5664v.n1();
        this.f5641a = 1;
        this.f5653k1 = false;
        this.J7.a(new androidx.lifecycle.v() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.v
            public void c(@g.n0 androidx.lifecycle.y yVar, @g.n0 Lifecycle.Event event) {
                View view;
                if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.C1) == null) {
                    return;
                }
                k.a(view);
            }
        });
        this.N7.d(bundle);
        K3(bundle);
        this.G7 = true;
        if (this.f5653k1) {
            this.J7.l(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    @Deprecated
    public void p5(boolean z10) {
        FragmentStrictMode.o(this);
        this.C = z10;
        FragmentManager fragmentManager = this.f5662t;
        if (fragmentManager == null) {
            this.D = true;
        } else if (z10) {
            fragmentManager.q(this);
        } else {
            fragmentManager.G1(this);
        }
    }

    public boolean q4(@g.n0 Menu menu, @g.n0 MenuInflater menuInflater) {
        boolean z10 = false;
        if (this.A) {
            return false;
        }
        if (this.f5652k0 && this.K0) {
            z10 = true;
            N3(menu, menuInflater);
        }
        return z10 | this.f5664v.K(menu, menuInflater);
    }

    public void q5(@p0 Object obj) {
        p1().f5700k = obj;
    }

    public void r4(@g.n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        this.f5664v.n1();
        this.f5660r = true;
        this.K7 = new l0(this, O0());
        View viewO3 = O3(layoutInflater, viewGroup, bundle);
        this.C1 = viewO3;
        if (viewO3 == null) {
            if (this.K7.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.K7 = null;
        } else {
            this.K7.b();
            ViewTreeLifecycleOwner.b(this.C1, this.K7);
            ViewTreeViewModelStoreOwner.b(this.C1, this.K7);
            ViewTreeSavedStateRegistryOwner.b(this.C1, this.K7);
            this.L7.r(this.K7);
        }
    }

    public void r5(@p0 Object obj) {
        p1().f5703n = obj;
    }

    public final boolean s3() {
        return this.f5663u != null && this.f5654l;
    }

    public void s4() {
        this.f5664v.L();
        this.J7.l(Lifecycle.Event.ON_DESTROY);
        this.f5641a = 0;
        this.f5653k1 = false;
        this.G7 = false;
        P3();
        if (this.f5653k1) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void s5(@p0 ArrayList<String> arrayList, @p0 ArrayList<String> arrayList2) {
        p1();
        j jVar = this.C2;
        jVar.f5697h = arrayList;
        jVar.f5698i = arrayList2;
    }

    @p0
    public Fragment t1(@g.n0 String str) {
        return str.equals(this.f5646f) ? this : this.f5664v.t0(str);
    }

    @p0
    @Deprecated
    public final FragmentManager t2() {
        return this.f5662t;
    }

    public final boolean t3() {
        return this.B;
    }

    public void t4() {
        this.f5664v.M();
        if (this.C1 != null && this.K7.e().b().isAtLeast(Lifecycle.State.CREATED)) {
            this.K7.a(Lifecycle.Event.ON_DESTROY);
        }
        this.f5641a = 1;
        this.f5653k1 = false;
        R3();
        if (this.f5653k1) {
            q1.a.d(this).h();
            this.f5660r = false;
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void t5(@p0 Object obj) {
        p1().f5704o = obj;
    }

    @g.n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append(zc.a.f58316d);
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(zc.a.f58317e);
        sb2.append(" (");
        sb2.append(this.f5646f);
        if (this.f5668x != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f5668x));
        }
        if (this.f5670z != null) {
            sb2.append(" tag=");
            sb2.append(this.f5670z);
        }
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    @g.n0
    public String u1() {
        return FragmentManager.W + this.f5646f + "_rq#" + this.P7.getAndIncrement();
    }

    @p0
    public final Object u2() {
        androidx.fragment.app.l<?> lVar = this.f5663u;
        if (lVar == null) {
            return null;
        }
        return lVar.j();
    }

    public final boolean u3() {
        FragmentManager fragmentManager;
        return this.A || ((fragmentManager = this.f5662t) != null && fragmentManager.Z0(this.f5667w));
    }

    public void u4() {
        this.f5641a = -1;
        this.f5653k1 = false;
        S3();
        this.F7 = null;
        if (this.f5653k1) {
            if (this.f5664v.V0()) {
                return;
            }
            this.f5664v.L();
            this.f5664v = new v();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    @Deprecated
    public void u5(@p0 Fragment fragment, int i10) {
        if (fragment != null) {
            FragmentStrictMode.p(this, fragment, i10);
        }
        FragmentManager fragmentManager = this.f5662t;
        FragmentManager fragmentManager2 = fragment != null ? fragment.f5662t : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragmentG3 = fragment; fragmentG3 != null; fragmentG3 = fragmentG3.g3(false)) {
            if (fragmentG3.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.f5649i = null;
            this.f5648h = null;
        } else if (this.f5662t == null || fragment.f5662t == null) {
            this.f5649i = null;
            this.f5648h = fragment;
        } else {
            this.f5649i = fragment.f5646f;
            this.f5648h = null;
        }
        this.f5650j = i10;
    }

    public final int v2() {
        return this.f5668x;
    }

    public final boolean v3() {
        return this.f5661s > 0;
    }

    @g.n0
    public LayoutInflater v4(@p0 Bundle bundle) {
        LayoutInflater layoutInflaterT3 = T3(bundle);
        this.F7 = layoutInflaterT3;
        return layoutInflaterT3;
    }

    @Deprecated
    public void v5(boolean z10) {
        FragmentStrictMode.q(this, z10);
        if (!this.f5666v2 && z10 && this.f5641a < 5 && this.f5662t != null && s3() && this.G7) {
            FragmentManager fragmentManager = this.f5662t;
            fragmentManager.q1(fragmentManager.D(this));
        }
        this.f5666v2 = z10;
        this.K1 = this.f5641a < 5 && !z10;
        if (this.f5642b != null) {
            this.f5645e = Boolean.valueOf(z10);
        }
    }

    @p0
    public final androidx.fragment.app.g w1() {
        androidx.fragment.app.l<?> lVar = this.f5663u;
        if (lVar == null) {
            return null;
        }
        return (androidx.fragment.app.g) lVar.f();
    }

    @g.n0
    public final LayoutInflater w2() {
        LayoutInflater layoutInflater = this.F7;
        return layoutInflater == null ? v4(null) : layoutInflater;
    }

    public final boolean w3() {
        return this.f5658p;
    }

    public void w4() {
        onLowMemory();
    }

    public boolean w5(@g.n0 String str) {
        androidx.fragment.app.l<?> lVar = this.f5663u;
        if (lVar != null) {
            return lVar.q(str);
        }
        return false;
    }

    public boolean x1() {
        Boolean bool;
        j jVar = this.C2;
        if (jVar == null || (bool = jVar.f5706q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean x3() {
        FragmentManager fragmentManager;
        return this.K0 && ((fragmentManager = this.f5662t) == null || fragmentManager.a1(this.f5667w));
    }

    public void x4(boolean z10) {
        X3(z10);
    }

    public void x5(@SuppressLint({"UnknownNullness"}) Intent intent) {
        y5(intent, null);
    }

    public boolean y3() {
        j jVar = this.C2;
        if (jVar == null) {
            return false;
        }
        return jVar.f5711v;
    }

    public boolean y4(@g.n0 MenuItem menuItem) {
        if (this.A) {
            return false;
        }
        if (this.f5652k0 && this.K0 && Y3(menuItem)) {
            return true;
        }
        return this.f5664v.R(menuItem);
    }

    public void y5(@SuppressLint({"UnknownNullness"}) Intent intent, @p0 Bundle bundle) {
        androidx.fragment.app.l<?> lVar = this.f5663u;
        if (lVar != null) {
            lVar.s(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @g.n0
    @Deprecated
    public LayoutInflater z2(@p0 Bundle bundle) {
        androidx.fragment.app.l<?> lVar = this.f5663u;
        if (lVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterK = lVar.k();
        androidx.core.view.p.d(layoutInflaterK, this.f5664v.K0());
        return layoutInflaterK;
    }

    public final boolean z3() {
        return this.f5655m;
    }

    public void z4(@g.n0 Menu menu) {
        if (this.A) {
            return;
        }
        if (this.f5652k0 && this.K0) {
            Z3(menu);
        }
        this.f5664v.S(menu);
    }

    @Deprecated
    public void z5(@SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        A5(intent, i10, null);
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {

        @g.n0
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f5672a;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Bundle bundle) {
            this.f5672a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@g.n0 Parcel parcel, int i10) {
            parcel.writeBundle(this.f5672a);
        }

        public SavedState(@g.n0 Parcel parcel, @p0 ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f5672a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }

    @g.o
    public Fragment(@g.i0 int i10) {
        this();
        this.O7 = i10;
    }
}
