package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.savedstate.b;
import com.bumptech.glide.load.engine.GlideException;
import f0.b;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class g extends ComponentActivity implements b.j, b.l {
    public static final String B = "android:support:lifecycle";
    public boolean A;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j f5933w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final androidx.lifecycle.a0 f5934x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f5935y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5936z;

    public class a extends l<g> implements h0.e0, h0.f0, f0.b0, f0.d0, d1, androidx.activity.q, androidx.activity.result.i, androidx.savedstate.d, z, androidx.core.view.t {
        public a() {
            super(g.this);
        }

        @Override // f0.b0
        public void C0(@g.n0 androidx.core.util.d<f0.q> dVar) {
            g.this.C0(dVar);
        }

        @Override // androidx.core.view.t
        public void F(@g.n0 androidx.core.view.a0 a0Var) {
            g.this.F(a0Var);
        }

        @Override // f0.b0
        public void L2(@g.n0 androidx.core.util.d<f0.q> dVar) {
            g.this.L2(dVar);
        }

        @Override // h0.e0
        public void N(@g.n0 androidx.core.util.d<Configuration> dVar) {
            g.this.N(dVar);
        }

        @Override // androidx.lifecycle.d1
        @g.n0
        public c1 O0() {
            return g.this.O0();
        }

        @Override // h0.f0
        public void X1(@g.n0 androidx.core.util.d<Integer> dVar) {
            g.this.X1(dVar);
        }

        @Override // androidx.fragment.app.z
        public void a(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
            g.this.w3(fragment);
        }

        @Override // f0.d0
        public void a0(@g.n0 androidx.core.util.d<f0.g0> dVar) {
            g.this.a0(dVar);
        }

        @Override // h0.f0
        public void b0(@g.n0 androidx.core.util.d<Integer> dVar) {
            g.this.b0(dVar);
        }

        @Override // androidx.fragment.app.l, androidx.fragment.app.i
        @p0
        public View c(int i10) {
            return g.this.findViewById(i10);
        }

        @Override // androidx.fragment.app.l, androidx.fragment.app.i
        public boolean d() {
            Window window = g.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.lifecycle.y
        @g.n0
        public Lifecycle e() {
            return g.this.f5934x;
        }

        @Override // androidx.core.view.t
        public void f2(@g.n0 androidx.core.view.a0 a0Var, @g.n0 androidx.lifecycle.y yVar, @g.n0 Lifecycle.State state) {
            g.this.f2(a0Var, yVar, state);
        }

        @Override // h0.e0
        public void g1(@g.n0 androidx.core.util.d<Configuration> dVar) {
            g.this.g1(dVar);
        }

        @Override // androidx.fragment.app.l
        public void i(@g.n0 String str, @p0 FileDescriptor fileDescriptor, @g.n0 PrintWriter printWriter, @p0 String[] strArr) {
            g.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.l
        @g.n0
        public LayoutInflater k() {
            return g.this.getLayoutInflater().cloneInContext(g.this);
        }

        @Override // androidx.fragment.app.l
        public int l() {
            Window window = g.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.savedstate.d
        @g.n0
        public androidx.savedstate.b l1() {
            return g.this.l1();
        }

        @Override // androidx.fragment.app.l
        public boolean m() {
            return g.this.getWindow() != null;
        }

        @Override // f0.d0
        public void m0(@g.n0 androidx.core.util.d<f0.g0> dVar) {
            g.this.m0(dVar);
        }

        @Override // androidx.core.view.t
        public void n2(@g.n0 androidx.core.view.a0 a0Var) {
            g.this.n2(a0Var);
        }

        @Override // androidx.core.view.t
        public void o(@g.n0 androidx.core.view.a0 a0Var, @g.n0 androidx.lifecycle.y yVar) {
            g.this.o(a0Var, yVar);
        }

        @Override // androidx.fragment.app.l
        public boolean p(@g.n0 Fragment fragment) {
            return !g.this.isFinishing();
        }

        @Override // androidx.fragment.app.l
        public boolean q(@g.n0 String str) {
            return f0.b.P(g.this, str);
        }

        @Override // androidx.activity.q
        @g.n0
        public OnBackPressedDispatcher t() {
            return g.this.t();
        }

        @Override // androidx.fragment.app.l
        public void v() {
            v2();
        }

        @Override // androidx.activity.result.i
        @g.n0
        public ActivityResultRegistry v0() {
            return g.this.v0();
        }

        @Override // androidx.core.view.t
        public void v2() {
            g.this.v2();
        }

        @Override // androidx.fragment.app.l
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public g j() {
            return g.this;
        }
    }

    public g() {
        this.f5933w = j.b(new a());
        this.f5934x = new androidx.lifecycle.a0(this);
        this.A = true;
        p3();
    }

    private void p3() {
        l1().j(B, new b.c() { // from class: androidx.fragment.app.e
            @Override // androidx.savedstate.b.c
            public final Bundle a() {
                return this.f5915a.q3();
            }
        });
        N(new androidx.core.util.d() { // from class: androidx.fragment.app.d
            @Override // androidx.core.util.d
            public final void accept(Object obj) {
                this.f5900a.r3((Configuration) obj);
            }
        });
        d2(new androidx.core.util.d() { // from class: androidx.fragment.app.c
            @Override // androidx.core.util.d
            public final void accept(Object obj) {
                this.f5899a.s3((Intent) obj);
            }
        });
        r0(new e.c() { // from class: androidx.fragment.app.f
            @Override // e.c
            public final void a(Context context) {
                this.f5927a.t3(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle q3() {
        u3();
        this.f5934x.l(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r3(Configuration configuration) {
        this.f5933w.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s3(Intent intent) {
        this.f5933w.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t3(Context context) {
        this.f5933w.a(null);
    }

    public static boolean v3(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean zV3 = false;
        for (Fragment fragment : fragmentManager.I0()) {
            if (fragment != null) {
                if (fragment.u2() != null) {
                    zV3 |= v3(fragment.U1(), state);
                }
                l0 l0Var = fragment.K7;
                if (l0Var != null && l0Var.e().b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.K7.g(state);
                    zV3 = true;
                }
                if (fragment.J7.b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.J7.s(state);
                    zV3 = true;
                }
            }
        }
        return zV3;
    }

    public void A3(@g.n0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        B3(fragment, intent, i10, null);
    }

    public void B3(@g.n0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, @p0 Bundle bundle) {
        if (i10 == -1) {
            f0.b.Q(this, intent, -1, bundle);
        } else {
            fragment.A5(intent, i10, bundle);
        }
    }

    @Deprecated
    public void C3(@g.n0 Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, @p0 Intent intent, int i11, int i12, int i13, @p0 Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 == -1) {
            f0.b.R(this, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            fragment.B5(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    public void D3() {
        f0.b.A(this);
    }

    @Deprecated
    public void E3() {
        v2();
    }

    public void F3() {
        f0.b.G(this);
    }

    public void G3() {
        f0.b.S(this);
    }

    @Override // android.app.Activity
    public void dump(@g.n0 String str, @p0 FileDescriptor fileDescriptor, @g.n0 PrintWriter printWriter, @p0 String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (U2(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + GlideException.a.f12263d;
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f5935y);
            printWriter.print(" mResumed=");
            printWriter.print(this.f5936z);
            printWriter.print(" mStopped=");
            printWriter.print(this.A);
            if (getApplication() != null) {
                q1.a.d(this).b(str2, fileDescriptor, printWriter, strArr);
            }
            this.f5933w.D().e0(str, fileDescriptor, printWriter, strArr);
        }
    }

    @p0
    public final View m3(@p0 View view, @g.n0 String str, @g.n0 Context context, @g.n0 AttributeSet attributeSet) {
        return this.f5933w.G(view, str, context, attributeSet);
    }

    @g.n0
    public FragmentManager n3() {
        return this.f5933w.D();
    }

    @g.n0
    @Deprecated
    public q1.a o3() {
        return q1.a.d(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @g.i
    public void onActivityResult(int i10, int i11, @p0 Intent intent) {
        this.f5933w.F();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        this.f5934x.l(Lifecycle.Event.ON_CREATE);
        this.f5933w.f();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @p0
    public View onCreateView(@p0 View view, @g.n0 String str, @g.n0 Context context, @g.n0 AttributeSet attributeSet) {
        View viewM3 = m3(view, str, context, attributeSet);
        return viewM3 == null ? super.onCreateView(view, str, context, attributeSet) : viewM3;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f5933w.h();
        this.f5934x.l(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, @g.n0 MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.f5933w.e(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f5936z = false;
        this.f5933w.n();
        this.f5934x.l(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        x3();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @g.i
    public void onRequestPermissionsResult(int i10, @g.n0 String[] strArr, @g.n0 int[] iArr) {
        this.f5933w.F();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f5933w.F();
        super.onResume();
        this.f5936z = true;
        this.f5933w.z();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.f5933w.F();
        super.onStart();
        this.A = false;
        if (!this.f5935y) {
            this.f5935y = true;
            this.f5933w.c();
        }
        this.f5933w.z();
        this.f5934x.l(Lifecycle.Event.ON_START);
        this.f5933w.s();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f5933w.F();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.A = true;
        u3();
        this.f5933w.t();
        this.f5934x.l(Lifecycle.Event.ON_STOP);
    }

    @Override // f0.b.l
    @Deprecated
    public final void q(int i10) {
    }

    public void u3() {
        while (v3(n3(), Lifecycle.State.CREATED)) {
        }
    }

    @g.k0
    @Deprecated
    public void w3(@g.n0 Fragment fragment) {
    }

    public void x3() {
        this.f5934x.l(Lifecycle.Event.ON_RESUME);
        this.f5933w.r();
    }

    public void y3(@p0 f0.k0 k0Var) {
        f0.b.L(this, k0Var);
    }

    public void z3(@p0 f0.k0 k0Var) {
        f0.b.M(this, k0Var);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @p0
    public View onCreateView(@g.n0 String str, @g.n0 Context context, @g.n0 AttributeSet attributeSet) {
        View viewM3 = m3(null, str, context, attributeSet);
        return viewM3 == null ? super.onCreateView(str, context, attributeSet) : viewM3;
    }

    @g.o
    public g(@g.i0 int i10) {
        super(i10);
        this.f5933w = j.b(new a());
        this.f5934x = new androidx.lifecycle.a0(this);
        this.A = true;
        p3();
    }
}
