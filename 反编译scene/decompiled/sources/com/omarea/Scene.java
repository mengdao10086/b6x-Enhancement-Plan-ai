package com.omarea;

import a.a42;
import a.a70;
import a.aa0;
import a.aq0;
import a.b62;
import a.b92;
import a.c60;
import a.d72;
import a.e50;
import a.f92;
import a.fa0;
import a.g82;
import a.g92;
import a.h42;
import a.hz0;
import a.k82;
import a.ke2;
import a.l50;
import a.m42;
import a.ma0;
import a.mp0;
import a.n92;
import a.nb;
import a.nb2;
import a.nl0;
import a.no0;
import a.pa0;
import a.pc2;
import a.pp0;
import a.qc2;
import a.qe2;
import a.r62;
import a.s20;
import a.sa0;
import a.t20;
import a.u20;
import a.u61;
import a.ua0;
import a.v72;
import a.va0;
import a.w20;
import a.wd2;
import a.wu0;
import a.x62;
import a.xd2;
import a.ya0;
import a.z32;
import a.z90;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.omarea.data.customer.BatteryReceiver;
import com.omarea.model.ActivationCodeResponse;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class Scene extends Application {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @SuppressLint({"StaticFieldLeak"})
    public static Activity f4795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Application f4796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f4799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final c f4798a = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Handler f4797a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z32 f8348a = a42.a(b.f8350a);
    public static final z32 b = a42.a(a.f8349a);

    public static final class a extends g92 implements v72<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8349a = new a();

        public a() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String i() {
            String str = Build.MODEL;
            f92.c(str, "Build.MODEL");
            String strG = new nb2(" +").g(str, "");
            Locale locale = Locale.ENGLISH;
            f92.c(locale, "Locale.ENGLISH");
            if (strG == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strG.toLowerCase(locale);
            f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
    }

    public static final class b extends g92 implements v72<SharedPreferences> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8350a = new b();

        public b() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences i() {
            return Scene.f4798a.c().getSharedPreferences(hz0.f1282a.H(), 0);
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(b92 b92Var) {
            this();
        }

        public static /* synthetic */ void p(c cVar, String str, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            cVar.o(str, i);
        }

        public final <R> void a(g82<? super b62<? super R>, ? extends Object> g82Var) {
            f92.d(g82Var, "runnable");
            qc2.d(xd2.a(qe2.b()), null, null, new s20(g82Var, null), 3, null);
        }

        public final boolean b(String str, boolean z) {
            f92.d(str, "key");
            return g().getBoolean(str, z);
        }

        public final Application c() {
            Application application = Scene.f4796a;
            if (application != null) {
                return application;
            }
            f92.m("context");
            throw null;
        }

        public final Activity d() {
            return Scene.f4795a;
        }

        public final String e() {
            z32 z32Var = Scene.b;
            c cVar = Scene.f4798a;
            return (String) z32Var.getValue();
        }

        public final String f() {
            String str = Scene.f4799a;
            if (str != null) {
                return str;
            }
            f92.m("self");
            throw null;
        }

        public final SharedPreferences g() {
            z32 z32Var = Scene.f8348a;
            c cVar = Scene.f4798a;
            return (SharedPreferences) z32Var.getValue();
        }

        public final String h(String str, String str2) {
            f92.d(str, "key");
            return g().getString(str, str2);
        }

        public final void i(Runnable runnable) {
            f92.d(runnable, "runnable");
            Scene.f4797a.post(runnable);
        }

        public final void j(Runnable runnable, long j) {
            f92.d(runnable, "runnable");
            Scene.f4797a.postDelayed(runnable, j);
        }

        public final void k(String str, boolean z) {
            f92.d(str, "key");
            g().edit().putBoolean(str, z).apply();
        }

        public final void l(Activity activity) {
            Scene.f4795a = activity;
        }

        public final void m(String str, String str2) {
            f92.d(str, "key");
            (str2 == null ? g().edit().remove(str) : g().edit().putString(str, str2)).apply();
        }

        public final void n(int i, int i2) {
            Scene.f4797a.post(new u20(i, i2));
        }

        public final void o(String str, int i) {
            f92.d(str, "message");
            Scene.f4797a.post(new t20(str, i));
        }
    }

    @x62(c = "com.omarea.Scene$attachBaseContext$1", f = "Scene.kt", l = {}, m = "invokeSuspend")
    public static final class d extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8351a;
        public int b;

        public d(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            d dVar = new d(b62Var);
            dVar.f8351a = (wd2) obj;
            return dVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((d) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            Scene.f4798a.g().edit().putString(hz0.f1282a.n0(), a70.f(true)).apply();
            return m42.f6769a;
        }
    }

    public static final class e implements l50 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NotificationManager f8352a;

        public e() {
            Object systemService = Scene.f4798a.c().getSystemService("notification");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            }
            this.f8352a = (NotificationManager) systemService;
        }

        @Override // a.l50
        public void a(String str, String str2) {
            f92.d(str, "taskId");
            f92.d(str2, "result");
            String string = Scene.f4798a.c().getString(u61.notice_channel_task);
            f92.c(string, "context.getString(R.string.notice_channel_task)");
            b(string, "#TASK " + str + '\n' + str2);
        }

        @Override // a.l50
        public void b(String str, String str2) {
            nb nbVar;
            f92.d(str, "title");
            f92.d(str2, "message");
            if (Build.VERSION.SDK_INT >= 26) {
                if (this.f8352a.getNotificationChannel("vtools-task") == null) {
                    this.f8352a.createNotificationChannel(new NotificationChannel("vtools-task", Scene.f4798a.c().getString(u61.notice_channel_task), 2));
                }
                nbVar = new nb(Scene.f4798a.c(), "vtools-task");
            } else {
                nbVar = new nb(Scene.f4798a.c());
            }
            nbVar.n(2131230926);
            nbVar.p(System.currentTimeMillis());
            nbVar.g(str);
            nbVar.f(str2);
            this.f8352a.notify(920, nbVar.a());
        }

        @Override // a.l50
        public void c(String str) {
            f92.d(str, "message");
            Scene.f4798a.o(str, 1);
        }

        @Override // a.l50
        public void d(String str, String str2) {
            f92.d(str, "scene");
            f92.d(str2, "mode");
            fa0.r(fa0.f867a, str, null, 2, null);
            wu0.f3480a.q().d(str);
            wu0.f3480a.q().c(str2);
            z90.b(z90.f8048a, aa0.SCENE_MODE_ACTION, null, 2, null);
        }
    }

    @x62(c = "com.omarea.Scene$attachBaseContext$5", f = "Scene.kt", l = {}, m = "invokeSuspend")
    public static final class f extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8353a;
        public int b;

        public f(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            f fVar = new f(b62Var);
            fVar.f8353a = (wd2) obj;
            return fVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((f) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            try {
                ActivationCodeResponse activationCodeResponseE = new mp0(Scene.f4798a.c()).E();
                String str = null;
                if (activationCodeResponseE == null) {
                    return null;
                }
                if (activationCodeResponseE.getPass()) {
                    hz0.f1282a.D0(activationCodeResponseE.getCodeStr());
                    hz0.f1282a.E0(activationCodeResponseE.getType());
                    hz0 hz0Var = hz0.f1282a;
                    String account = activationCodeResponseE.getAccount();
                    if (!(account.length() == 0)) {
                        str = account;
                    }
                    hz0Var.M0(str);
                    e50.f677a.W0(activationCodeResponseE.getCodeStr());
                }
                return m42.f6769a;
            } catch (Exception unused) {
                return m42.f6769a;
            }
        }
    }

    @x62(c = "com.omarea.Scene$attachBaseContext$6", f = "Scene.kt", l = {271}, m = "invokeSuspend")
    public static final class g extends d72 implements k82<wd2, b62<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8354a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f4800a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4801a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(n92 n92Var, b62 b62Var) {
            super(2, b62Var);
            this.f8354a = n92Var;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            g gVar = new g(this.f8354a, b62Var);
            gVar.f4800a = (wd2) obj;
            return gVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super Boolean> b62Var) {
            return ((g) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f4800a;
                e50 e50Var = e50.f677a;
                String str = (String) this.f8354a.f6891a;
                this.f4801a = wd2Var;
                this.b = 1;
                obj = e50Var.d1(str, this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return obj;
        }
    }

    @x62(c = "com.omarea.Scene$attachBaseContext$7", f = "Scene.kt", l = {298}, m = "invokeSuspend")
    public static final class h extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8355a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4802a;
        public int b;

        public h(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            h hVar = new h(b62Var);
            hVar.f8355a = (wd2) obj;
            return hVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((h) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                this.f4802a = this.f8355a;
                this.b = 1;
                if (ke2.a(1000L, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            z90.f8048a.c(aq0.f101a);
            return m42.f6769a;
        }
    }

    public static final class i implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            f92.d(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            f92.d(activity, "activity");
            if (f92.a(Scene.f4798a.d(), activity)) {
                Scene.f4798a.l(null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            f92.d(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            f92.d(activity, "activity");
            Scene.f4798a.l(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            f92.d(activity, "activity");
            f92.d(bundle, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            f92.d(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            f92.d(activity, "activity");
            if (f92.a(Scene.f4798a.d(), activity)) {
                Scene.f4798a.l(null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        f4796a = this;
        String packageName = getPackageName();
        f92.c(packageName, "this.packageName");
        f4799a = packageName;
        String string = f4798a.g().getString(hz0.f1282a.n0(), "");
        boolean z = false;
        b92 b92Var = null;
        if (!(string == null || string.length() == 0)) {
            if (Build.VERSION.SDK_INT >= 30 && f92.a(string, "su")) {
                qc2.d(xd2.a(qe2.b()), null, null, new d(null), 3, null);
            }
            a70.j(string);
        }
        e50.f677a.z0(this);
        String strA = new nl0(this).a();
        if (strA != null) {
            e50.f677a.V0(strA, w20.f3357a.a());
        }
        no0.B(new no0(), false, 1, null);
        e50.f677a.U0(Boolean.valueOf(f4798a.b(hz0.f1282a.A(), false)));
        e50.f677a.c1(this, new e());
        c60 c60Var = c60.f5764a;
        String string2 = getString(u61.config_toolkit_install_path);
        f92.c(string2, "getString(R.string.config_toolkit_install_path)");
        a70.i(c60Var.d(this, string2));
        pp0.f7137a.a();
        String strA2 = hz0.f1282a.a();
        if (strA2 == null) {
            strA2 = "";
        }
        if (strA2.length() == 0) {
            pc2.b(null, new f(null), 1, null);
        } else {
            n92 n92Var = new n92();
            n92Var.f6891a = f4798a.h(hz0.f1282a.C0(), "");
            if ((strA2.length() > 0) && f92.a((String) n92Var.f6891a, "root")) {
                pc2.b(null, new g(n92Var, null), 1, null);
            }
            e50.f677a.W0(strA2);
        }
        new ya0(this).c();
        new va0(this).a();
        z90.f8048a.c(new BatteryReceiver(this, z, 2, b92Var));
        z90.f8048a.c(new ma0(this));
        z90.f8048a.c(new sa0(this));
        z90.f8048a.c(new pa0(true));
        qc2.d(xd2.a(qe2.b()), null, null, new h(null), 3, null);
        z90 z90Var = z90.f8048a;
        Application application = f4796a;
        if (application != null) {
            z90Var.c(new ua0(application));
        } else {
            f92.m("context");
            throw null;
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        f92.d(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new i());
    }
}
