package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.p0;
import g.i1;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 implements y {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f6219j = 700;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6222b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public Handler f6225e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final b f6218i = new b(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public static final o0 f6220k = new o0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6223c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6224d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final a0 f6226f = new a0(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final Runnable f6227g = new Runnable() { // from class: androidx.lifecycle.n0
        @Override // java.lang.Runnable
        public final void run() {
            o0.j(this.f6217a);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final p0.a f6228h = new d();

    @g.v0(29)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f6229a = new a();

        @g.u
        @hk.m
        public static final void a(@yt.k Activity activity, @yt.k Application.ActivityLifecycleCallbacks callback) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            kotlin.jvm.internal.f0.p(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @i1
        public static /* synthetic */ void b() {
        }

        @hk.m
        @yt.k
        public final y a() {
            return o0.f6220k;
        }

        @hk.m
        public final void c(@yt.k Context context) {
            kotlin.jvm.internal.f0.p(context, "context");
            o0.f6220k.i(context);
        }
    }

    public static final class c extends m {

        public static final class a extends m {
            public final /* synthetic */ o0 this$0;

            public a(o0 o0Var) {
                this.this$0 = o0Var;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(@yt.k Activity activity) {
                kotlin.jvm.internal.f0.p(activity, "activity");
                this.this$0.f();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(@yt.k Activity activity) {
                kotlin.jvm.internal.f0.p(activity, "activity");
                this.this$0.g();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.m, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@yt.k Activity activity, @yt.l Bundle bundle) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                p0.f6231b.b(activity).h(o0.this.f6228h);
            }
        }

        @Override // androidx.lifecycle.m, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            o0.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @g.v0(29)
        public void onActivityPreCreated(@yt.k Activity activity, @yt.l Bundle bundle) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            a.a(activity, new a(o0.this));
        }

        @Override // androidx.lifecycle.m, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            o0.this.h();
        }
    }

    public static final class d implements p0.a {
        public d() {
        }

        @Override // androidx.lifecycle.p0.a
        public void b() {
            o0.this.g();
        }

        @Override // androidx.lifecycle.p0.a
        public void c() {
        }

        @Override // androidx.lifecycle.p0.a
        public void d() {
            o0.this.f();
        }
    }

    public static final void j(o0 this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.k();
        this$0.l();
    }

    @hk.m
    @yt.k
    public static final y m() {
        return f6218i.a();
    }

    @hk.m
    public static final void n(@yt.k Context context) {
        f6218i.c(context);
    }

    public final void d() {
        int i10 = this.f6222b - 1;
        this.f6222b = i10;
        if (i10 == 0) {
            Handler handler = this.f6225e;
            kotlin.jvm.internal.f0.m(handler);
            handler.postDelayed(this.f6227g, 700L);
        }
    }

    @Override // androidx.lifecycle.y
    @yt.k
    public Lifecycle e() {
        return this.f6226f;
    }

    public final void f() {
        int i10 = this.f6222b + 1;
        this.f6222b = i10;
        if (i10 == 1) {
            if (this.f6223c) {
                this.f6226f.l(Lifecycle.Event.ON_RESUME);
                this.f6223c = false;
            } else {
                Handler handler = this.f6225e;
                kotlin.jvm.internal.f0.m(handler);
                handler.removeCallbacks(this.f6227g);
            }
        }
    }

    public final void g() {
        int i10 = this.f6221a + 1;
        this.f6221a = i10;
        if (i10 == 1 && this.f6224d) {
            this.f6226f.l(Lifecycle.Event.ON_START);
            this.f6224d = false;
        }
    }

    public final void h() {
        this.f6221a--;
        l();
    }

    public final void i(@yt.k Context context) {
        kotlin.jvm.internal.f0.p(context, "context");
        this.f6225e = new Handler();
        this.f6226f.l(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.f0.n(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void k() {
        if (this.f6222b == 0) {
            this.f6223c = true;
            this.f6226f.l(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void l() {
        if (this.f6221a == 0 && this.f6223c) {
            this.f6226f.l(Lifecycle.Event.ON_STOP);
            this.f6224d = true;
        }
    }
}
