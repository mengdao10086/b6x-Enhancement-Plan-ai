package androidx.fragment.app;

import a.Cif;
import a.al;
import a.bl;
import a.cl;
import a.dg;
import a.fl;
import a.gl;
import a.hn;
import a.in;
import a.jl;
import a.kn;
import a.nn;
import a.oq;
import a.pq;
import a.qn;
import a.wb;
import a.xk;
import a.xm;
import a.xn;
import a.yk;
import a.yl;
import a.ym;
import a.yn;
import a.zk;
import a.zn;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
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
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, kn, yn, pq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f8200a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f4250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gl f4252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nn f4254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public oq f4255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xm f4257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yl f4258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zk f4259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bundle f4260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray<Parcelable> f4261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayoutInflater f4262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f4264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Fragment f4265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f4266a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Bundle f4269b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f4270b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Fragment f4271b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4274b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f4275c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4276c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4277d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4278e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean n;
    public boolean o;
    public boolean q;
    public boolean r;
    public boolean s;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4251a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f4267a = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f4273b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Boolean f4272b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public yl f4268b = new yl();
    public boolean m = true;
    public boolean p = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hn.b f4253a = hn.b.RESUMED;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qn<kn> f4256a = new qn<>();

    public Fragment() {
        N();
    }

    @Deprecated
    public static Fragment P(Context context, String str, Bundle bundle) {
        try {
            Fragment fragmentNewInstance = fl.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.k1(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e) {
            throw new al("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new al("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new al("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new al("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    public int A() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return 0;
        }
        return zkVar.d;
    }

    public void A0(Bundle bundle) {
    }

    public final Fragment B() {
        return this.f4271b;
    }

    public void B0() {
        this.n = true;
    }

    public Object C() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        Object obj = zkVar.f3865d;
        return obj == f8200a ? s() : obj;
    }

    public void C0() {
        this.n = true;
    }

    public final Resources D() {
        return d1().getResources();
    }

    public void D0(View view, Bundle bundle) {
    }

    public final boolean E() {
        return this.j;
    }

    public void E0(Bundle bundle) {
        this.n = true;
    }

    public Object F() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        Object obj = zkVar.f3862b;
        return obj == f8200a ? q() : obj;
    }

    public void F0(Bundle bundle) {
        this.f4268b.T0();
        this.f4251a = 2;
        this.n = false;
        Y(bundle);
        if (this.n) {
            this.f4268b.z();
            return;
        }
        throw new ym("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public Object G() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        return zkVar.e;
    }

    public void G0() {
        this.f4268b.q(this.f4252a, new yk(this), this);
        this.n = false;
        b0(this.f4252a.e());
        if (this.n) {
            return;
        }
        throw new ym("Fragment " + this + " did not call through to super.onAttach()");
    }

    public Object H() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        Object obj = zkVar.f;
        return obj == f8200a ? G() : obj;
    }

    public void H0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.f4268b.A(configuration);
    }

    public int I() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return 0;
        }
        return zkVar.f8077a;
    }

    public boolean I0(MenuItem menuItem) {
        if (this.h) {
            return false;
        }
        return d0(menuItem) || this.f4268b.B(menuItem);
    }

    public final String J(int i) {
        return D().getString(i);
    }

    public void J0(Bundle bundle) {
        this.f4268b.T0();
        this.f4251a = 1;
        this.n = false;
        this.f4255a.c(bundle);
        e0(bundle);
        this.s = true;
        if (this.n) {
            this.f4254a.i(hn.a.ON_CREATE);
            return;
        }
        throw new ym("Fragment " + this + " did not call through to super.onCreate()");
    }

    public final Fragment K() {
        String str;
        Fragment fragment = this.f4265a;
        if (fragment != null) {
            return fragment;
        }
        yl ylVar = this.f4258a;
        if (ylVar == null || (str = this.f4273b) == null) {
            return null;
        }
        return ylVar.f3732a.get(str);
    }

    public boolean K0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.h) {
            return false;
        }
        if (this.l && this.m) {
            z = true;
            h0(menu, menuInflater);
        }
        return z | this.f4268b.D(menu, menuInflater);
    }

    public final CharSequence L(int i) {
        return D().getText(i);
    }

    public void L0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4268b.T0();
        this.g = true;
        this.f4257a = new xm();
        View viewI0 = i0(layoutInflater, viewGroup, bundle);
        this.f4263a = viewI0;
        if (viewI0 != null) {
            this.f4257a.b();
            this.f4256a.g(this.f4257a);
        } else {
            if (this.f4257a.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f4257a = null;
        }
    }

    public View M() {
        return this.f4263a;
    }

    public void M0() {
        this.f4268b.E();
        this.f4254a.i(hn.a.ON_DESTROY);
        this.f4251a = 0;
        this.n = false;
        this.s = false;
        j0();
        if (this.n) {
            return;
        }
        throw new ym("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public final void N() {
        this.f4254a = new nn(this);
        this.f4255a = oq.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4254a.a(new in() { // from class: androidx.fragment.app.Fragment.2
                @Override // a.in
                public void a(kn knVar, hn.a aVar) {
                    View view;
                    if (aVar != hn.a.ON_STOP || (view = Fragment.this.f4263a) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
    }

    public void N0() {
        this.f4268b.F();
        if (this.f4263a != null) {
            this.f4257a.a(hn.a.ON_DESTROY);
        }
        this.f4251a = 1;
        this.n = false;
        l0();
        if (this.n) {
            zn.b(this).c();
            this.g = false;
        } else {
            throw new ym("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void O() {
        N();
        this.f4267a = UUID.randomUUID().toString();
        this.f4274b = false;
        this.f4276c = false;
        this.f4277d = false;
        this.f4278e = false;
        this.f = false;
        this.c = 0;
        this.f4258a = null;
        this.f4268b = new yl();
        this.f4252a = null;
        this.d = 0;
        this.e = 0;
        this.f4275c = null;
        this.h = false;
        this.i = false;
    }

    public void O0() {
        this.n = false;
        m0();
        this.f4262a = null;
        if (this.n) {
            if (this.f4268b.E0()) {
                return;
            }
            this.f4268b.E();
            this.f4268b = new yl();
            return;
        }
        throw new ym("Fragment " + this + " did not call through to super.onDetach()");
    }

    public LayoutInflater P0(Bundle bundle) {
        LayoutInflater layoutInflaterN0 = n0(bundle);
        this.f4262a = layoutInflaterN0;
        return layoutInflaterN0;
    }

    public final boolean Q() {
        return this.f4252a != null && this.f4274b;
    }

    public void Q0() {
        onLowMemory();
        this.f4268b.G();
    }

    public final boolean R() {
        return this.i;
    }

    public void R0(boolean z) {
        r0(z);
        this.f4268b.H(z);
    }

    public final boolean S() {
        return this.h;
    }

    public boolean S0(MenuItem menuItem) {
        if (this.h) {
            return false;
        }
        return (this.l && this.m && s0(menuItem)) || this.f4268b.W(menuItem);
    }

    public boolean T() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return false;
        }
        return zkVar.f3863b;
    }

    public void T0(Menu menu) {
        if (this.h) {
            return;
        }
        if (this.l && this.m) {
            t0(menu);
        }
        this.f4268b.X(menu);
    }

    public final boolean U() {
        return this.c > 0;
    }

    public void U0() {
        this.f4268b.Z();
        if (this.f4263a != null) {
            this.f4257a.a(hn.a.ON_PAUSE);
        }
        this.f4254a.i(hn.a.ON_PAUSE);
        this.f4251a = 3;
        this.n = false;
        u0();
        if (this.n) {
            return;
        }
        throw new ym("Fragment " + this + " did not call through to super.onPause()");
    }

    public boolean V() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return false;
        }
        return zkVar.f3859a;
    }

    public void V0(boolean z) {
        v0(z);
        this.f4268b.a0(z);
    }

    public final boolean W() {
        yl ylVar = this.f4258a;
        if (ylVar == null) {
            return false;
        }
        return ylVar.I0();
    }

    public boolean W0(Menu menu) {
        boolean z = false;
        if (this.h) {
            return false;
        }
        if (this.l && this.m) {
            z = true;
            w0(menu);
        }
        return z | this.f4268b.b0(menu);
    }

    public void X() {
        this.f4268b.T0();
    }

    public void X0() {
        boolean zG0 = this.f4258a.G0(this);
        Boolean bool = this.f4272b;
        if (bool == null || bool.booleanValue() != zG0) {
            this.f4272b = Boolean.valueOf(zG0);
            x0(zG0);
            this.f4268b.c0();
        }
    }

    public void Y(Bundle bundle) {
        this.n = true;
    }

    public void Y0() {
        this.f4268b.T0();
        this.f4268b.m0();
        this.f4251a = 4;
        this.n = false;
        z0();
        if (!this.n) {
            throw new ym("Fragment " + this + " did not call through to super.onResume()");
        }
        this.f4254a.i(hn.a.ON_RESUME);
        if (this.f4263a != null) {
            this.f4257a.a(hn.a.ON_RESUME);
        }
        this.f4268b.d0();
        this.f4268b.m0();
    }

    public void Z(int i, int i2, Intent intent) {
    }

    public void Z0(Bundle bundle) {
        A0(bundle);
        this.f4255a.d(bundle);
        Parcelable parcelableF1 = this.f4268b.f1();
        if (parcelableF1 != null) {
            bundle.putParcelable(cl.FRAGMENTS_TAG, parcelableF1);
        }
    }

    @Deprecated
    public void a0(Activity activity) {
        this.n = true;
    }

    public void a1() {
        this.f4268b.T0();
        this.f4268b.m0();
        this.f4251a = 3;
        this.n = false;
        B0();
        if (this.n) {
            this.f4254a.i(hn.a.ON_START);
            if (this.f4263a != null) {
                this.f4257a.a(hn.a.ON_START);
            }
            this.f4268b.e0();
            return;
        }
        throw new ym("Fragment " + this + " did not call through to super.onStart()");
    }

    public void b0(Context context) {
        this.n = true;
        gl glVar = this.f4252a;
        Activity activityD = glVar == null ? null : glVar.d();
        if (activityD != null) {
            this.n = false;
            a0(activityD);
        }
    }

    public void b1() {
        this.f4268b.g0();
        if (this.f4263a != null) {
            this.f4257a.a(hn.a.ON_STOP);
        }
        this.f4254a.i(hn.a.ON_STOP);
        this.f4251a = 2;
        this.n = false;
        C0();
        if (this.n) {
            return;
        }
        throw new ym("Fragment " + this + " did not call through to super.onStop()");
    }

    public void c0(Fragment fragment) {
    }

    public final cl c1() {
        cl clVarJ = j();
        if (clVarJ != null) {
            return clVarJ;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public boolean d0(MenuItem menuItem) {
        return false;
    }

    public final Context d1() {
        Context contextP = p();
        if (contextP != null) {
            return contextP;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void e0(Bundle bundle) {
        this.n = true;
        g1(bundle);
        if (this.f4268b.H0(1)) {
            return;
        }
        this.f4268b.C();
    }

    public final jl e1() {
        jl jlVarU = u();
        if (jlVarU != null) {
            return jlVarU;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f() {
        zk zkVar = this.f4259a;
        bl blVar = null;
        if (zkVar != null) {
            zkVar.f3859a = false;
            bl blVar2 = zkVar.f3853a;
            zkVar.f3853a = null;
            blVar = blVar2;
        }
        if (blVar != null) {
            blVar.b();
        }
    }

    public Animation f0(int i, boolean z, int i2) {
        return null;
    }

    public final View f1() {
        View viewM = M();
        if (viewM != null) {
            return viewM;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.d));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.e));
        printWriter.print(" mTag=");
        printWriter.println(this.f4275c);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f4251a);
        printWriter.print(" mWho=");
        printWriter.print(this.f4267a);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.c);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f4274b);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f4276c);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f4277d);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f4278e);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.h);
        printWriter.print(" mDetached=");
        printWriter.print(this.i);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.m);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.l);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.j);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.p);
        if (this.f4258a != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f4258a);
        }
        if (this.f4252a != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f4252a);
        }
        if (this.f4271b != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f4271b);
        }
        if (this.f4269b != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f4269b);
        }
        if (this.f4260a != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f4260a);
        }
        if (this.f4261a != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f4261a);
        }
        Fragment fragmentK = K();
        if (fragmentK != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentK);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.b);
        }
        if (y() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(y());
        }
        if (this.f4264a != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f4264a);
        }
        if (this.f4263a != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f4263a);
        }
        if (this.f4270b != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f4263a);
        }
        if (m() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(m());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(I());
        }
        if (p() != null) {
            zn.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f4268b + ":");
        this.f4268b.b(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public Animator g0(int i, boolean z, int i2) {
        return null;
    }

    public void g1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable(cl.FRAGMENTS_TAG)) == null) {
            return;
        }
        this.f4268b.d1(parcelable);
        this.f4268b.C();
    }

    @Override // a.kn
    public hn getLifecycle() {
        return this.f4254a;
    }

    @Override // a.pq
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.f4255a.b();
    }

    @Override // a.yn
    public xn getViewModelStore() {
        yl ylVar = this.f4258a;
        if (ylVar != null) {
            return ylVar.B0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final zk h() {
        if (this.f4259a == null) {
            this.f4259a = new zk();
        }
        return this.f4259a;
    }

    public void h0(Menu menu, MenuInflater menuInflater) {
    }

    public final void h1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f4261a;
        if (sparseArray != null) {
            this.f4270b.restoreHierarchyState(sparseArray);
            this.f4261a = null;
        }
        this.n = false;
        E0(bundle);
        if (this.n) {
            if (this.f4263a != null) {
                this.f4257a.a(hn.a.ON_CREATE);
            }
        } else {
            throw new ym("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public Fragment i(String str) {
        return str.equals(this.f4267a) ? this : this.f4268b.s0(str);
    }

    public abstract View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void i1(View view) {
        h().f3856a = view;
    }

    public final cl j() {
        gl glVar = this.f4252a;
        if (glVar == null) {
            return null;
        }
        return (cl) glVar.d();
    }

    public void j0() {
        this.n = true;
    }

    public void j1(Animator animator) {
        h().f3855a = animator;
    }

    public boolean k() {
        Boolean bool;
        zk zkVar = this.f4259a;
        if (zkVar == null || (bool = zkVar.f3861b) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void k0() {
    }

    public void k1(Bundle bundle) {
        if (this.f4258a != null && W()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f4269b = bundle;
    }

    public boolean l() {
        Boolean bool;
        zk zkVar = this.f4259a;
        if (zkVar == null || (bool = zkVar.f3857a) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void l0() {
        this.n = true;
    }

    public void l1(boolean z) {
        h().f3863b = z;
    }

    public View m() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        return zkVar.f3856a;
    }

    public void m0() {
        this.n = true;
    }

    public void m1(boolean z) {
        if (this.m != z) {
            this.m = z;
            if (this.l && Q() && !S()) {
                this.f4252a.o();
            }
        }
    }

    public Animator n() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        return zkVar.f3855a;
    }

    public LayoutInflater n0(Bundle bundle) {
        return x(bundle);
    }

    public void n1(int i) {
        if (this.f4259a == null && i == 0) {
            return;
        }
        h().b = i;
    }

    public final jl o() {
        if (this.f4252a != null) {
            return this.f4268b;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void o0(boolean z) {
    }

    public void o1(int i, int i2) {
        if (this.f4259a == null && i == 0 && i2 == 0) {
            return;
        }
        h();
        zk zkVar = this.f4259a;
        zkVar.c = i;
        zkVar.d = i2;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.n = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        c1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.n = true;
    }

    public Context p() {
        gl glVar = this.f4252a;
        if (glVar == null) {
            return null;
        }
        return glVar.e();
    }

    @Deprecated
    public void p0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.n = true;
    }

    public void p1(bl blVar) {
        h();
        bl blVar2 = this.f4259a.f3853a;
        if (blVar == blVar2) {
            return;
        }
        if (blVar != null && blVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        zk zkVar = this.f4259a;
        if (zkVar.f3859a) {
            zkVar.f3853a = blVar;
        }
        if (blVar != null) {
            blVar.a();
        }
    }

    public Object q() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        return zkVar.f3858a;
    }

    public void q0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.n = true;
        gl glVar = this.f4252a;
        Activity activityD = glVar == null ? null : glVar.d();
        if (activityD != null) {
            this.n = false;
            p0(activityD, attributeSet, bundle);
        }
    }

    public void q1(int i) {
        h().f8077a = i;
    }

    public wb r() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        return zkVar.f3854a;
    }

    public void r0(boolean z) {
    }

    @Deprecated
    public void r1(boolean z) {
        if (!this.p && z && this.f4251a < 3 && this.f4258a != null && Q() && this.s) {
            this.f4258a.U0(this);
        }
        this.p = z;
        this.o = this.f4251a < 3 && !z;
        if (this.f4260a != null) {
            this.f4266a = Boolean.valueOf(z);
        }
    }

    public Object s() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        return zkVar.f3864c;
    }

    public boolean s0(MenuItem menuItem) {
        return false;
    }

    public void s1(@SuppressLint({"UnknownNullness"}) Intent intent) {
        t1(intent, null);
    }

    public wb t() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return null;
        }
        return zkVar.f3860b;
    }

    public void t0(Menu menu) {
    }

    public void t1(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        gl glVar = this.f4252a;
        if (glVar != null) {
            glVar.n(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        Cif.a(this, sb);
        sb.append(" (");
        sb.append(this.f4267a);
        sb.append(")");
        if (this.d != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.d));
        }
        if (this.f4275c != null) {
            sb.append(" ");
            sb.append(this.f4275c);
        }
        sb.append('}');
        return sb.toString();
    }

    public final jl u() {
        return this.f4258a;
    }

    public void u0() {
        this.n = true;
    }

    public void u1() {
        yl ylVar = this.f4258a;
        if (ylVar == null || ylVar.f3724a == null) {
            h().f3859a = false;
        } else if (Looper.myLooper() != this.f4258a.f3724a.f().getLooper()) {
            this.f4258a.f3724a.f().postAtFrontOfQueue(new xk(this));
        } else {
            f();
        }
    }

    public final Object v() {
        gl glVar = this.f4252a;
        if (glVar == null) {
            return null;
        }
        return glVar.i();
    }

    public void v0(boolean z) {
    }

    public final LayoutInflater w() {
        LayoutInflater layoutInflater = this.f4262a;
        return layoutInflater == null ? P0(null) : layoutInflater;
    }

    public void w0(Menu menu) {
    }

    @Deprecated
    public LayoutInflater x(Bundle bundle) {
        gl glVar = this.f4252a;
        if (glVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterJ = glVar.j();
        yl ylVar = this.f4268b;
        ylVar.z0();
        dg.b(layoutInflaterJ, ylVar);
        return layoutInflaterJ;
    }

    public void x0(boolean z) {
    }

    public int y() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return 0;
        }
        return zkVar.b;
    }

    public void y0(int i, String[] strArr, int[] iArr) {
    }

    public int z() {
        zk zkVar = this.f4259a;
        if (zkVar == null) {
            return 0;
        }
        return zkVar.c;
    }

    public void z0() {
        this.n = true;
    }
}
