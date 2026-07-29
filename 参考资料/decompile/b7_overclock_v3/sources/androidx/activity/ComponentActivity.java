package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.os.a;
import androidx.core.view.w;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.a0;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.r;
import androidx.lifecycle.t0;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import androidx.lifecycle.z0;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.savedstate.b;
import f.a;
import f.b;
import f0.b0;
import f0.c0;
import f0.d0;
import f0.g0;
import g.i0;
import g.k0;
import g.n0;
import g.p0;
import g.r0;
import g.u;
import g.v0;
import h0.e0;
import h0.f0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public class ComponentActivity extends f0.l implements e.a, y, d1, r, androidx.savedstate.d, q, androidx.activity.result.i, androidx.activity.result.b, e0, f0, c0, b0, d0, androidx.core.view.t, m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f1289v = "android:support:activity-result";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e.b f1290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f1291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f1292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.savedstate.c f1293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c1 f1294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z0.b f1295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OnBackPressedDispatcher f1296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f1297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final l f1298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @i0
    public int f1299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f1300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ActivityResultRegistry f1301n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList<androidx.core.util.d<Configuration>> f1302o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CopyOnWriteArrayList<androidx.core.util.d<Integer>> f1303p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList<androidx.core.util.d<Intent>> f1304q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList<androidx.core.util.d<f0.q>> f1305r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList<androidx.core.util.d<g0>> f1306s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1307t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1308u;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            }
        }
    }

    public class b extends ActivityResultRegistry {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f1314a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.C0315a f1315b;

            public a(int i10, a.C0315a c0315a) {
                this.f1314a = i10;
                this.f1315b = c0315a;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c(this.f1314a, this.f1315b.a());
            }
        }

        /* JADX INFO: renamed from: androidx.activity.ComponentActivity$b$b, reason: collision with other inner class name */
        public class RunnableC0026b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f1317a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f1318b;

            public RunnableC0026b(int i10, IntentSender.SendIntentException sendIntentException) {
                this.f1317a = i10;
                this.f1318b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(this.f1317a, 0, new Intent().setAction(b.n.f27358b).putExtra(b.n.f27360d, this.f1318b));
            }
        }

        public b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void f(int i10, @n0 f.a<I, O> aVar, I i11, @p0 f0.e eVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0315a<O> c0315aB = aVar.b(componentActivity, i11);
            if (c0315aB != null) {
                new Handler(Looper.getMainLooper()).post(new a(i10, c0315aB));
                return;
            }
            Intent intentA = aVar.a(componentActivity, i11);
            Bundle bundleL = null;
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (intentA.hasExtra(b.m.f27356b)) {
                bundleL = intentA.getBundleExtra(b.m.f27356b);
                intentA.removeExtra(b.m.f27356b);
            } else if (eVar != null) {
                bundleL = eVar.l();
            }
            Bundle bundle = bundleL;
            if (b.k.f27352b.equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra(b.k.f27353c);
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                f0.b.J(componentActivity, stringArrayExtra, i10);
                return;
            }
            if (!b.n.f27358b.equals(intentA.getAction())) {
                f0.b.Q(componentActivity, intentA, i10, bundle);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra(b.n.f27359c);
            try {
                f0.b.R(componentActivity, intentSenderRequest.g(), i10, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.e(), 0, bundle);
            } catch (IntentSender.SendIntentException e10) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0026b(i10, e10));
            }
        }
    }

    @v0(19)
    public static class c {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    @v0(33)
    public static class d {
        @u
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c1 f1321b;
    }

    public interface f extends Executor {
        void k1(@n0 View view);
    }

    @v0(16)
    public class g implements f, ViewTreeObserver.OnDrawListener, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f1323b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f1322a = SystemClock.uptimeMillis() + 10000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1324c = false;

        public g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Runnable runnable = this.f1323b;
            if (runnable != null) {
                runnable.run();
                this.f1323b = null;
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f1323b = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f1324c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1365a.b();
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // androidx.activity.ComponentActivity.f
        public void k1(@n0 View view) {
            if (this.f1324c) {
                return;
            }
            this.f1324c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f1323b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f1322a) {
                    this.f1324c = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f1323b = null;
            if (ComponentActivity.this.f1298k.e()) {
                this.f1324c = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public static class h implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f1326a = a();

        @n0
        public final Handler a() {
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = Looper.getMainLooper();
            }
            return new Handler(looperMyLooper);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f1326a.postAtFrontOfQueue(runnable);
        }

        @Override // androidx.activity.ComponentActivity.f
        public void k1(@n0 View view) {
        }
    }

    public ComponentActivity() {
        this.f1290c = new e.b();
        this.f1291d = new w(new Runnable() { // from class: androidx.activity.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f1364a.v2();
            }
        });
        this.f1292e = new a0(this);
        androidx.savedstate.c cVarA = androidx.savedstate.c.a(this);
        this.f1293f = cVarA;
        this.f1296i = new OnBackPressedDispatcher(new a());
        f fVarA3 = a3();
        this.f1297j = fVarA3;
        this.f1298k = new l(fVarA3, new ik.a() { // from class: androidx.activity.f
            @Override // ik.a
            public final Object o() {
                return this.f1363a.e3();
            }
        });
        this.f1300m = new AtomicInteger();
        this.f1301n = new b();
        this.f1302o = new CopyOnWriteArrayList<>();
        this.f1303p = new CopyOnWriteArrayList<>();
        this.f1304q = new CopyOnWriteArrayList<>();
        this.f1305r = new CopyOnWriteArrayList<>();
        this.f1306s = new CopyOnWriteArrayList<>();
        this.f1307t = false;
        this.f1308u = false;
        if (e() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i10 = Build.VERSION.SDK_INT;
        e().a(new v() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.v
            public void c(@n0 y yVar, @n0 Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        c.a(viewPeekDecorView);
                    }
                }
            }
        });
        e().a(new v() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.v
            public void c(@n0 y yVar, @n0 Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ComponentActivity.this.f1290c.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.O0().a();
                }
            }
        });
        e().a(new v() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.v
            public void c(@n0 y yVar, @n0 Lifecycle.Event event) {
                ComponentActivity.this.b3();
                ComponentActivity.this.e().d(this);
            }
        });
        cVarA.c();
        SavedStateHandleSupport.c(this);
        if (i10 <= 23) {
            e().a(new ImmLeaksCleaner(this));
        }
        l1().j(f1289v, new b.c() { // from class: androidx.activity.d
            @Override // androidx.savedstate.b.c
            public final Bundle a() {
                return this.f1361a.f3();
            }
        });
        r0(new e.c() { // from class: androidx.activity.e
            @Override // e.c
            public final void a(Context context) {
                this.f1362a.g3(context);
            }
        });
    }

    private void d3() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.b(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.b(getWindow().getDecorView(), this);
        ViewTreeFullyDrawnReporterOwner.b(getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ z1 e3() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle f3() {
        Bundle bundle = new Bundle();
        this.f1301n.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g3(Context context) {
        Bundle bundleB = l1().b(f1289v);
        if (bundleB != null) {
            this.f1301n.g(bundleB);
        }
    }

    @Override // f0.b0
    public final void C0(@n0 androidx.core.util.d<f0.q> dVar) {
        this.f1305r.add(dVar);
    }

    @Override // androidx.core.view.t
    public void F(@n0 androidx.core.view.a0 a0Var) {
        this.f1291d.l(a0Var);
    }

    @Override // androidx.activity.result.b
    @n0
    public final <I, O> androidx.activity.result.g<I> G(@n0 f.a<I, O> aVar, @n0 ActivityResultRegistry activityResultRegistry, @n0 androidx.activity.result.a<O> aVar2) {
        return activityResultRegistry.i("activity_rq#" + this.f1300m.getAndIncrement(), this, aVar, aVar2);
    }

    @Override // androidx.activity.m
    @n0
    public l J() {
        return this.f1298k;
    }

    @Override // f0.b0
    public final void L2(@n0 androidx.core.util.d<f0.q> dVar) {
        this.f1305r.remove(dVar);
    }

    @Override // h0.e0
    public final void N(@n0 androidx.core.util.d<Configuration> dVar) {
        this.f1302o.add(dVar);
    }

    @Override // androidx.lifecycle.d1
    @n0
    public c1 O0() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        b3();
        return this.f1294g;
    }

    @Override // androidx.activity.result.b
    @n0
    public final <I, O> androidx.activity.result.g<I> P1(@n0 f.a<I, O> aVar, @n0 androidx.activity.result.a<O> aVar2) {
        return G(aVar, this.f1301n, aVar2);
    }

    @Override // e.a
    public final void T1(@n0 e.c cVar) {
        this.f1290c.e(cVar);
    }

    @Override // f0.c0
    public final void U0(@n0 androidx.core.util.d<Intent> dVar) {
        this.f1304q.remove(dVar);
    }

    @Override // h0.f0
    public final void X1(@n0 androidx.core.util.d<Integer> dVar) {
        this.f1303p.add(dVar);
    }

    @Override // f0.d0
    public final void a0(@n0 androidx.core.util.d<g0> dVar) {
        this.f1306s.remove(dVar);
    }

    public final f a3() {
        return new g();
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        d3();
        this.f1297j.k1(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // h0.f0
    public final void b0(@n0 androidx.core.util.d<Integer> dVar) {
        this.f1303p.remove(dVar);
    }

    public void b3() {
        if (this.f1294g == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.f1294g = eVar.f1321b;
            }
            if (this.f1294g == null) {
                this.f1294g = new c1();
            }
        }
    }

    @p0
    @Deprecated
    public Object c3() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.f1320a;
        }
        return null;
    }

    @Override // f0.c0
    public final void d2(@n0 androidx.core.util.d<Intent> dVar) {
        this.f1304q.add(dVar);
    }

    @Override // f0.l, androidx.lifecycle.y
    @n0
    public Lifecycle e() {
        return this.f1292e;
    }

    @Override // androidx.core.view.t
    @SuppressLint({"LambdaLast"})
    public void f2(@n0 androidx.core.view.a0 a0Var, @n0 y yVar, @n0 Lifecycle.State state) {
        this.f1291d.e(a0Var, yVar, state);
    }

    @Override // h0.e0
    public final void g1(@n0 androidx.core.util.d<Configuration> dVar) {
        this.f1302o.remove(dVar);
    }

    @Override // androidx.lifecycle.r
    @n0
    public z0.b h0() {
        if (this.f1295h == null) {
            this.f1295h = new t0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.f1295h;
    }

    @p0
    @Deprecated
    public Object h3() {
        return null;
    }

    @Override // androidx.lifecycle.r
    @g.i
    @n0
    public p1.a j0() {
        p1.e eVar = new p1.e();
        if (getApplication() != null) {
            eVar.c(z0.a.f6278i, getApplication());
        }
        eVar.c(SavedStateHandleSupport.f6123c, this);
        eVar.c(SavedStateHandleSupport.f6124d, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            eVar.c(SavedStateHandleSupport.f6125e, getIntent().getExtras());
        }
        return eVar;
    }

    @Override // e.a
    @p0
    public Context l0() {
        return this.f1290c.d();
    }

    @Override // androidx.savedstate.d
    @n0
    public final androidx.savedstate.b l1() {
        return this.f1293f.b();
    }

    @Override // f0.d0
    public final void m0(@n0 androidx.core.util.d<g0> dVar) {
        this.f1306s.add(dVar);
    }

    @Override // androidx.core.view.t
    public void n2(@n0 androidx.core.view.a0 a0Var) {
        this.f1291d.c(a0Var);
    }

    @Override // androidx.core.view.t
    public void o(@n0 androidx.core.view.a0 a0Var, @n0 y yVar) {
        this.f1291d.d(a0Var, yVar);
    }

    @Override // android.app.Activity
    @g.i
    @Deprecated
    public void onActivityResult(int i10, int i11, @p0 Intent intent) {
        if (this.f1301n.b(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    @k0
    public void onBackPressed() {
        this.f1296i.f();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    @g.i
    public void onConfigurationChanged(@n0 Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<androidx.core.util.d<Configuration>> it2 = this.f1302o.iterator();
        while (it2.hasNext()) {
            it2.next().accept(configuration);
        }
    }

    @Override // f0.l, android.app.Activity
    @r0(markerClass = {a.b.class})
    public void onCreate(@p0 Bundle bundle) {
        this.f1293f.d(bundle);
        this.f1290c.c(this);
        super.onCreate(bundle);
        androidx.lifecycle.p0.g(this);
        if (androidx.core.os.a.k()) {
            this.f1296i.g(d.a(this));
        }
        int i10 = this.f1299l;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, @n0 Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.f1291d.h(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, @n0 MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.f1291d.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    @g.i
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.f1307t) {
            return;
        }
        Iterator<androidx.core.util.d<f0.q>> it2 = this.f1305r.iterator();
        while (it2.hasNext()) {
            it2.next().accept(new f0.q(z10));
        }
    }

    @Override // android.app.Activity
    @g.i
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<androidx.core.util.d<Intent>> it2 = this.f1304q.iterator();
        while (it2.hasNext()) {
            it2.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, @n0 Menu menu) {
        this.f1291d.i(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    @g.i
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.f1308u) {
            return;
        }
        Iterator<androidx.core.util.d<g0>> it2 = this.f1306s.iterator();
        while (it2.hasNext()) {
            it2.next().accept(new g0(z10));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, @p0 View view, @n0 Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.f1291d.k(menu);
        return true;
    }

    @Override // android.app.Activity
    @g.i
    @Deprecated
    public void onRequestPermissionsResult(int i10, @n0 String[] strArr, @n0 int[] iArr) {
        if (this.f1301n.b(i10, -1, new Intent().putExtra(b.k.f27353c, strArr).putExtra(b.k.f27354d, iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    @p0
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object objH3 = h3();
        c1 c1Var = this.f1294g;
        if (c1Var == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            c1Var = eVar.f1321b;
        }
        if (c1Var == null && objH3 == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.f1320a = objH3;
        eVar2.f1321b = c1Var;
        return eVar2;
    }

    @Override // f0.l, android.app.Activity
    @g.i
    public void onSaveInstanceState(@n0 Bundle bundle) {
        Lifecycle lifecycleE = e();
        if (lifecycleE instanceof a0) {
            ((a0) lifecycleE).s(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f1293f.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @g.i
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<androidx.core.util.d<Integer>> it2 = this.f1303p.iterator();
        while (it2.hasNext()) {
            it2.next().accept(Integer.valueOf(i10));
        }
    }

    @Override // e.a
    public final void r0(@n0 e.c cVar) {
        this.f1290c.a(cVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (f2.a.h()) {
                f2.a.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.f1298k.d();
        } finally {
            f2.a.f();
        }
    }

    @Override // android.app.Activity
    public void setContentView(@i0 int i10) {
        d3();
        this.f1297j.k1(getWindow().getDecorView());
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@n0 Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@n0 IntentSender intentSender, int i10, @p0 Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    @Override // androidx.activity.q
    @n0
    public final OnBackPressedDispatcher t() {
        return this.f1296i;
    }

    @Override // androidx.activity.result.i
    @n0
    public final ActivityResultRegistry v0() {
        return this.f1301n;
    }

    @Override // androidx.core.view.t
    public void v2() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@n0 Intent intent, int i10, @p0 Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@n0 IntentSender intentSender, int i10, @p0 Intent intent, int i11, int i12, int i13, @p0 Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @Override // android.app.Activity
    @g.i
    @v0(api = 26)
    public void onMultiWindowModeChanged(boolean z10, @n0 Configuration configuration) {
        this.f1307t = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.f1307t = false;
            Iterator<androidx.core.util.d<f0.q>> it2 = this.f1305r.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new f0.q(z10, configuration));
            }
        } catch (Throwable th2) {
            this.f1307t = false;
            throw th2;
        }
    }

    @Override // android.app.Activity
    @g.i
    @v0(api = 26)
    public void onPictureInPictureModeChanged(boolean z10, @n0 Configuration configuration) {
        this.f1308u = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.f1308u = false;
            Iterator<androidx.core.util.d<g0>> it2 = this.f1306s.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new g0(z10, configuration));
            }
        } catch (Throwable th2) {
            this.f1308u = false;
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        d3();
        this.f1297j.k1(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        d3();
        this.f1297j.k1(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @g.o
    public ComponentActivity(@i0 int i10) {
        this();
        this.f1299l = i10;
    }
}
