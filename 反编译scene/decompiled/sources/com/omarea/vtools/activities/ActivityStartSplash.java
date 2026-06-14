package com.omarea.vtools.activities;

import a.a42;
import a.a70;
import a.ac;
import a.ac2;
import a.ag1;
import a.aq0;
import a.b62;
import a.b92;
import a.bb2;
import a.bg1;
import a.c60;
import a.cg1;
import a.d72;
import a.e50;
import a.eg1;
import a.f92;
import a.fg1;
import a.g92;
import a.gg1;
import a.gh1;
import a.h42;
import a.hf2;
import a.hz0;
import a.ig1;
import a.k82;
import a.ke2;
import a.l92;
import a.lj0;
import a.m42;
import a.m61;
import a.nl0;
import a.nm1;
import a.oc2;
import a.om1;
import a.p80;
import a.pc2;
import a.qc2;
import a.qe2;
import a.qf1;
import a.r62;
import a.sn0;
import a.t61;
import a.tf1;
import a.u61;
import a.u90;
import a.v0;
import a.v72;
import a.va;
import a.vf1;
import a.w20;
import a.wd2;
import a.wf1;
import a.wp0;
import a.x62;
import a.xd2;
import a.xk0;
import a.xp0;
import a.z32;
import a.zf1;
import a.zg0;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.vtools.services.KeepAliveService;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityStartSplash extends v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8870a = new b(null);
    public static boolean b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f5481a = a42.a(new z());

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final z32 f5484b = a42.a(new m());
    public final z32 c = a42.a(new u());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f5480a = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5482a = "";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f5485b = "/storage/emulated/0/Android/data/com.omarea.vtools/up.sh";

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActivityStartSplash f8871a;

        public a(ActivityStartSplash activityStartSplash) {
            f92.d(activityStartSplash, "context");
            this.f8871a = activityStartSplash;
        }

        @Override // java.lang.Runnable
        public void run() {
            Scene.f4798a.i(new qf1(this));
            this.f8871a.A(new tf1(this));
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(b92 b92Var) {
            this();
        }

        public final boolean a() {
            return ActivityStartSplash.b;
        }

        public final void b(boolean z) {
            ActivityStartSplash.b = z;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5486a;

        public c(String str) {
            this.f5486a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = this.f5486a;
            if (str == null) {
                return;
            }
            int iHashCode = str.hashCode();
            if (iHashCode == 96415) {
                if (str.equals("adb")) {
                    ActivityStartSplash.this.C();
                }
            } else if (iHashCode == 3506402) {
                if (str.equals("root")) {
                    ActivityStartSplash.this.E();
                }
            } else if (iHashCode == 93508654 && str.equals("basic")) {
                ActivityStartSplash.this.D();
            }
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityStartSplash$checkFileWrite$1", f = "ActivityStartSplash.kt", l = {}, m = "invokeSuspend")
    public static final class d extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8873a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Runnable f5488a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ ActivityStartSplash f5489b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ActivityStartSplash activityStartSplash, Runnable runnable, b62 b62Var) {
            super(2, b62Var);
            this.f5489b = activityStartSplash;
            this.f5488a = runnable;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            d dVar = ActivityStartSplash.this.new d(this.f5489b, this.f5488a, b62Var);
            dVar.f8873a = (wd2) obj;
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
            if (f92.a(e50.f677a.y0(), "root")) {
                new xk0(this.f5489b).b();
            }
            if (!ActivityStartSplash.this.B("android.permission.READ_EXTERNAL_STORAGE") || !ActivityStartSplash.this.B("android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (Build.VERSION.SDK_INT >= 23) {
                    va.m(this.f5489b, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", "android.permission.WAKE_LOCK"}, 17);
                } else {
                    va.m(this.f5489b, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.WAKE_LOCK"}, 17);
                }
            }
            xp0 xp0Var = new xp0();
            Context applicationContext = ActivityStartSplash.this.getApplicationContext();
            f92.c(applicationContext, "applicationContext");
            if (!xp0Var.a(applicationContext) && f92.a(e50.f677a.y0(), "root")) {
                Context applicationContext2 = ActivityStartSplash.this.getApplicationContext();
                f92.c(applicationContext2, "applicationContext");
                xp0Var.c(applicationContext2);
            }
            this.f5488a.run();
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityStartSplash$checkPermissionsADB$1", f = "ActivityStartSplash.kt", l = {340, 347, 350}, m = "invokeSuspend")
    public static final class e extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8874a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5491a;
        public int b;

        public e(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            e eVar = ActivityStartSplash.this.new e(b62Var);
            eVar.f8874a = (wd2) obj;
            return eVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((e) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
        @Override // a.s62
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object j(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = a.r62.c()
                int r1 = r7.b
                r2 = 3
                r3 = 2
                r4 = 1
                java.lang.String r5 = "adb"
                if (r1 == 0) goto L34
                if (r1 == r4) goto L2c
                if (r1 == r3) goto L24
                if (r1 != r2) goto L1c
                java.lang.Object r0 = r7.f5491a
                a.wd2 r0 = (a.wd2) r0
                a.h42.b(r8)
                goto La7
            L1c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L24:
                java.lang.Object r1 = r7.f5491a
                a.wd2 r1 = (a.wd2) r1
                a.h42.b(r8)
                goto L82
            L2c:
                java.lang.Object r1 = r7.f5491a
                a.wd2 r1 = (a.wd2) r1
                a.h42.b(r8)
                goto L5d
            L34:
                a.h42.b(r8)
                a.wd2 r8 = r7.f8874a
                a.e50 r1 = a.e50.f677a
                java.lang.String r1 = r1.y0()
                boolean r1 = a.f92.a(r1, r5)
                if (r1 == 0) goto L4d
                a.e50 r1 = a.e50.f677a
                boolean r1 = r1.r0()
                if (r1 != 0) goto L65
            L4d:
                a.e50 r1 = a.e50.f677a
                r7.f5491a = r8
                r7.b = r4
                java.lang.Object r1 = r1.d1(r5, r7)
                if (r1 != r0) goto L5a
                return r0
            L5a:
                r6 = r1
                r1 = r8
                r8 = r6
            L5d:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L70
            L65:
                com.omarea.vtools.activities.ActivityStartSplash$a r8 = new com.omarea.vtools.activities.ActivityStartSplash$a
                com.omarea.vtools.activities.ActivityStartSplash r0 = com.omarea.vtools.activities.ActivityStartSplash.this
                r8.<init>(r0)
            L6c:
                r8.run()
                goto La7
            L70:
                com.omarea.vtools.activities.ActivityStartSplash r8 = com.omarea.vtools.activities.ActivityStartSplash.this
                com.omarea.vtools.activities.ActivityStartSplash.w(r8)
                a.e50 r8 = a.e50.f677a
                r7.f5491a = r1
                r7.b = r3
                java.lang.Object r8 = r8.d1(r5, r7)
                if (r8 != r0) goto L82
                return r0
            L82:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L92
                com.omarea.vtools.activities.ActivityStartSplash$a r8 = new com.omarea.vtools.activities.ActivityStartSplash$a
                com.omarea.vtools.activities.ActivityStartSplash r0 = com.omarea.vtools.activities.ActivityStartSplash.this
                r8.<init>(r0)
                goto L6c
            L92:
                a.fg2 r8 = a.qe2.c()
                a.uf1 r3 = new a.uf1
                r4 = 0
                r3.<init>(r7, r4)
                r7.f5491a = r1
                r7.b = r2
                java.lang.Object r8 = a.oc2.g(r8, r3, r7)
                if (r8 != r0) goto La7
                return r0
            La7:
                a.m42 r8 = a.m42.f6769a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityStartSplash.e.j(java.lang.Object):java.lang.Object");
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityStartSplash$checkPermissionsBasic$1", f = "ActivityStartSplash.kt", l = {309}, m = "invokeSuspend")
    public static final class f extends d72 implements k82<wd2, b62<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8875a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5492a;
        public int b;

        public f(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            f fVar = new f(b62Var);
            fVar.f8875a = (wd2) obj;
            return fVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super Boolean> b62Var) {
            return ((f) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8875a;
                e50 e50Var = e50.f677a;
                this.f5492a = wd2Var;
                this.b = 1;
                obj = e50Var.d1("basic", this);
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

    @x62(c = "com.omarea.vtools.activities.ActivityStartSplash$checkPermissionsROOT$1", f = "ActivityStartSplash.kt", l = {447}, m = "invokeSuspend")
    public static final class g extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8876a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5494a;
        public int b;

        public g(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            g gVar = ActivityStartSplash.this.new g(b62Var);
            gVar.f8876a = (wd2) obj;
            return gVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((g) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8876a;
                ActivityStartSplash activityStartSplash = ActivityStartSplash.this;
                this.f5494a = wd2Var;
                this.b = 1;
                if (activityStartSplash.F(this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            wd2 wd2VarA;
            k82 zf1Var;
            Scene.f4798a.i(new vf1(this));
            Context applicationContext = ActivityStartSplash.this.getApplicationContext();
            f92.c(applicationContext, "applicationContext");
            sn0 sn0Var = new sn0(applicationContext);
            if (sn0Var.d().getActivated()) {
                wd2VarA = xd2.a(qe2.b());
                zf1Var = new wf1(this, sn0Var, null);
            } else {
                wd2VarA = xd2.a(qe2.b());
                zf1Var = new zf1(this, sn0Var, null);
            }
            qc2.d(wd2VarA, null, null, zf1Var, 3, null);
        }
    }

    public static final class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityStartSplash.this.G();
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityStartSplash.this.L(new ag1(this));
        }
    }

    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityStartSplash.this.L(new bg1(this));
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityStartSplash.this.L(new cg1(this));
        }
    }

    public static final class m extends g92 implements v72<nm1> {
        public m() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final nm1 i() {
            return new nm1(ActivityStartSplash.this, new eg1(this), ActivityStartSplash.this.J());
        }
    }

    public static final class n extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l92 f8883a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Button f5495a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Timer f5497a;

        public n(l92 l92Var, Button button, Timer timer) {
            this.f8883a = l92Var;
            this.f5495a = button;
            this.f5497a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Scene.f4798a.i(new fg1(this));
        }
    }

    public static final class o implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Timer f8884a;

        public o(Timer timer) {
            this.f8884a = timer;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.f8884a.cancel();
        }
    }

    public static final class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8885a;

        public p(p80.b bVar) {
            this.f8885a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8885a.c();
            ActivityStartSplash.this.G();
        }
    }

    public static final class q implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l92 f8886a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ p80.b f5499a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CompoundButton f5500a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5502a;
        public final /* synthetic */ l92 b;

        public q(CompoundButton compoundButton, l92 l92Var, l92 l92Var2, p80.b bVar, String str) {
            this.f5500a = compoundButton;
            this.f8886a = l92Var;
            this.b = l92Var2;
            this.f5499a = bVar;
            this.f5502a = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            l92 l92Var;
            int i;
            CompoundButton compoundButton = this.f5500a;
            f92.c(compoundButton, "agreement");
            if (compoundButton.isChecked()) {
                if (this.f8886a.f6687a > 0 && (i = (l92Var = this.b).f6687a) < 10) {
                    l92Var.f6687a = i + 1;
                    return;
                }
                this.f5499a.c();
                Scene.f4798a.m(hz0.f1282a.K(), this.f5502a);
                String str = this.f5502a;
                int iHashCode = str.hashCode();
                if (iHashCode != 96415) {
                    if (iHashCode == 3506402 && str.equals("root")) {
                        qc2.d(hf2.f6309a, qe2.b(), null, new gg1(this, null), 2, null);
                        return;
                    }
                } else if (str.equals("adb")) {
                    ActivityStartSplash.this.C();
                    return;
                }
                ActivityStartSplash.this.P();
            }
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityStartSplash$initShizukuRish$1", f = "ActivityStartSplash.kt", l = {}, m = "invokeSuspend")
    public static final class r extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8887a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ FutureTask f5503a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(FutureTask futureTask, b62 b62Var) {
            super(2, b62Var);
            this.f5503a = futureTask;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            r rVar = new r(this.f5503a, b62Var);
            rVar.f8887a = (wd2) obj;
            return rVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((r) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            this.f5503a.run();
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityStartSplash$initShizukuRish$2", f = "ActivityStartSplash.kt", l = {}, m = "invokeSuspend")
    public static final class s extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8888a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ FutureTask f5504a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(FutureTask futureTask, b62 b62Var) {
            super(2, b62Var);
            this.f5504a = futureTask;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            s sVar = new s(this.f5504a, b62Var);
            sVar.f8888a = (wd2) obj;
            return sVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((s) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            for (int i = 0; i < 6 && !e50.f677a.r0(); i++) {
                e50.f677a.A1(300L);
            }
            if (e50.f677a.r0()) {
                this.f5504a.cancel(true);
            }
            return m42.f6769a;
        }
    }

    public static final class t<V> implements Callable<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l92 f8889a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Process f5506a;

        public t(l92 l92Var, Process process) {
            this.f8889a = l92Var;
            this.f5506a = process;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call() throws IOException {
            String strD = c60.f5764a.d(ActivityStartSplash.this, "rish.sh");
            String str = "export port=" + w20.f3357a.a().b();
            String str2 = "sh " + strD + " -c '" + str + ";sh " + ActivityStartSplash.this.f5482a + '\'';
            String str3 = "sh /storage/emulated/0/Android/data/com.omarea.vtools/rish.sh -c '" + str + ";sh " + ActivityStartSplash.this.f5485b + '\'';
            String str4 = "sh " + strD + " -c '" + str + ";sh " + ActivityStartSplash.this.f5485b + '\'';
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 30) {
                str2 = this.f8889a.f6687a > 1086 ? str4 : str3;
            }
            sb.append(str2);
            sb.append("\nexit 0");
            String string = sb.toString();
            Process process = this.f5506a;
            f92.c(process, "shell");
            OutputStream outputStream = process.getOutputStream();
            Charset charset = bb2.f5692a;
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = string.getBytes(charset);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
            return Integer.valueOf(this.f5506a.waitFor());
        }
    }

    public static final class u extends g92 implements v72<ig1> {
        public u() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ig1 i() {
            return new ig1(this);
        }
    }

    public static final class v extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return true;
        }
    }

    public static final class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityStartSplash.this.finishAfterTransition();
        }
    }

    public static final class x implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8892a;

        public x(p80.b bVar) {
            this.f8892a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8892a.c();
            Scene.f4798a.g().edit().putBoolean("agreement_v6", true).apply();
            ActivityStartSplash.this.z();
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityStartSplash$onProActivated$2", f = "ActivityStartSplash.kt", l = {582}, m = "invokeSuspend")
    public static final class y extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8893a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5509a;
        public int b;

        public y(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            y yVar = ActivityStartSplash.this.new y(b62Var);
            yVar.f8893a = (wd2) obj;
            return yVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((y) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8893a;
                LinearLayout linearLayout = (LinearLayout) ActivityStartSplash.this._$_findCachedViewById(t61.working_mode);
                f92.c(linearLayout, "working_mode");
                linearLayout.setVisibility(8);
                TextView textView = (TextView) ActivityStartSplash.this._$_findCachedViewById(t61.start_state_text);
                f92.c(textView, "start_state_text");
                textView.setText(ActivityStartSplash.this.getString(u61.scene_permissions_checking));
                this.f5509a = wd2Var;
                this.b = 1;
                if (ke2.a(16L, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            new a(ActivityStartSplash.this).run();
            return m42.f6769a;
        }
    }

    public static final class z extends g92 implements v72<u90> {
        public z() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u90 i() {
            return new u90(ActivityStartSplash.this, null, 2, null);
        }
    }

    public final void A(Runnable runnable) {
        qc2.d(hf2.f6309a, qe2.c(), null, new d(this, runnable, null), 2, null);
    }

    public final boolean B(String str) {
        return ac.b(getApplicationContext(), str) == 0;
    }

    public final void C() {
        Q();
        TextView textView = (TextView) _$_findCachedViewById(t61.start_state_text);
        f92.c(textView, "start_state_text");
        textView.setText(getString(u61.scene_permissions));
        if (f92.a(Scene.f4798a.h(hz0.f1282a.K(), ""), "adb")) {
            qc2.d(hf2.f6309a, qe2.b(), null, new e(null), 2, null);
        } else {
            K("adb");
        }
    }

    public final void D() {
        Q();
        if (!f92.a(e50.f677a.y0(), "basic")) {
            pc2.b(null, new f(null), 1, null);
        }
        P();
    }

    public final void E() {
        TextView textView = (TextView) _$_findCachedViewById(t61.start_state_text);
        f92.c(textView, "start_state_text");
        textView.setText(getString(u61.scene_permissions));
        if (f92.a(Scene.f4798a.h(hz0.f1282a.K(), ""), "root")) {
            qc2.d(hf2.f6309a, qe2.b(), null, new g(null), 2, null);
        } else {
            K("root");
        }
    }

    public final /* synthetic */ Object F(b62<? super m42> b62Var) {
        Object objD = new wp0(this, new h(), new i()).d(b62Var);
        return objD == r62.c() ? objD : m42.f6769a;
    }

    public final void G() {
        if (new w20(this).b()) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.mode_root);
            f92.c(linearLayout, "mode_root");
            linearLayout.setVisibility(8);
        }
        TextView textView = (TextView) _$_findCachedViewById(t61.start_state_text);
        f92.c(textView, "start_state_text");
        textView.setText(getString(u61.scene_working_mode));
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(t61.working_mode);
        f92.c(linearLayout2, "working_mode");
        linearLayout2.setVisibility(0);
        ((LinearLayout) _$_findCachedViewById(t61.mode_basic)).setOnClickListener(new j());
        ((LinearLayout) _$_findCachedViewById(t61.mode_adb)).setOnClickListener(new k());
        ((LinearLayout) _$_findCachedViewById(t61.mode_root)).setOnClickListener(new l());
    }

    public final nm1 H() {
        return (nm1) this.f5484b.getValue();
    }

    public final om1 I() {
        return (om1) this.c.getValue();
    }

    public final u90 J() {
        return (u90) this.f5481a.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityStartSplash.K(java.lang.String):void");
    }

    public final void L(Runnable runnable) {
        String strD = c60.f5764a.d(this, "busybox");
        if (!new File(strD).exists()) {
            c60 c60Var = c60.f5764a;
            AssetManager assets = getAssets();
            f92.c(assets, "assets");
            if (!f92.a(c60Var.j(assets, "toolkit/busybox", "busybox", this), strD)) {
                return;
            }
        }
        String strA = new nl0(this).a();
        if (strA != null) {
            this.f5482a = strA;
            e50.f677a.V0(strA, w20.f3357a.a());
            runnable.run();
            if (strA != null) {
                return;
            }
        }
        Scene.c.p(Scene.f4798a, "Unable to extract file!", 0, 2, null);
        m42 m42Var = m42.f6769a;
    }

    public final void M() {
        l92 l92Var = new l92();
        boolean z2 = false;
        l92Var.f6687a = 0;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo("moe.shizuku.privileged.api", 0);
            l92Var.f6687a = packageInfo.versionCode;
            if (packageInfo != null) {
                z2 = true;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            Process processE = a70.e();
            FutureTask futureTask = new FutureTask(new t(l92Var, processE));
            qc2.d(xd2.a(qe2.b()), null, null, new r(futureTask, null), 3, null);
            qc2.d(xd2.a(qe2.b()), null, null, new s(futureTask, null), 3, null);
            try {
                futureTask.get(7L, TimeUnit.SECONDS);
            } catch (Exception unused2) {
            } catch (Throwable th) {
                processE.destroy();
                throw th;
            }
            processE.destroy();
        }
    }

    public final void N() {
        if (Scene.f4798a.b(hz0.f1282a.D(), hz0.f1282a.E())) {
            lj0 lj0Var = new lj0();
            Context applicationContext = getApplicationContext();
            f92.c(applicationContext, "applicationContext");
            if (lj0Var.a(applicationContext, new ComponentName(Scene.f4798a.c(), (Class<?>) KeepAliveService.class))) {
                return;
            }
            zg0 zg0Var = new zg0();
            Context applicationContext2 = getApplicationContext();
            f92.c(applicationContext2, "applicationContext");
            if (zg0Var.a(applicationContext2)) {
                return;
            }
            Intent intent = new Intent(getApplicationContext(), (Class<?>) KeepAliveService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
        }
    }

    public final /* synthetic */ Object O(b62<? super m42> b62Var) {
        Scene.f4798a.m(hz0.f1282a.C0(), "root");
        Object objG = oc2.g(qe2.c(), new y(null), b62Var);
        return objG == r62.c() ? objG : m42.f6769a;
    }

    public final void P() {
        TextView textView = (TextView) _$_findCachedViewById(t61.start_state_text);
        f92.c(textView, "start_state_text");
        textView.setText("Completed!");
        startActivity(new Intent(getApplicationContext(), (Class<?>) ActivityMain.class));
        b = true;
        finish();
    }

    public final void Q() {
        aq0.f101a.f();
        new zg0().b(this);
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5483a == null) {
            this.f5483a = new HashMap();
        }
        View view = (View) this.f5483a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5483a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gh1.f1013a.k(this);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("port")) {
            String stringExtra = getIntent().getStringExtra("port");
            if (stringExtra == null) {
                stringExtra = "";
            }
            f92.c(stringExtra, "intent.getStringExtra(\"port\")?: \"\"");
            Integer numJ = ac2.j(stringExtra);
            if (numJ != null) {
                int iIntValue = numJ.intValue();
                w20.f3357a.a().d(iIntValue);
                e50.f677a.X0(iIntValue);
            }
        }
        setContentView(2131558465);
        m61.i(new m61(Scene.f4798a.c()), false, 1, null);
        if (Scene.f4798a.g().contains("agreement_v6")) {
            z();
        } else {
            View viewInflate = getLayoutInflater().inflate(2131558547, (ViewGroup) null);
            p80.a aVar = p80.f2403a;
            f92.c(viewInflate, "view");
            p80.b bVarR = aVar.r(this, viewInflate, false);
            WebView webView = (WebView) viewInflate.findViewById(t61.agreement_content);
            f92.c(webView, "webView");
            webView.setWebViewClient(new v());
            webView.loadUrl("http://vtools.omarea.com/scene-policy.html");
            ((Button) viewInflate.findViewById(2131362069)).setOnClickListener(new w());
            ((Button) viewInflate.findViewById(2131362070)).setOnClickListener(new x(bVarR));
        }
        N();
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d("Scene", ">>>>启动耗时" + (System.currentTimeMillis() - this.f5480a));
    }

    @Override // a.cl, android.app.Activity
    public void onPause() {
        J().c();
        super.onPause();
    }

    public final void z() {
        String strH = Scene.f4798a.h(hz0.f1282a.C0(), "");
        String strH2 = Scene.f4798a.h(hz0.f1282a.K(), "");
        if ((strH == null || strH.length() == 0) || (!f92.a(strH, strH2))) {
            G();
        } else {
            L(new c(strH));
        }
    }
}
