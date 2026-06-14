package com.omarea.vtools.activities;

import a.ac1;
import a.b62;
import a.c52;
import a.d61;
import a.d70;
import a.d72;
import a.dc1;
import a.e50;
import a.ec1;
import a.ec2;
import a.f92;
import a.fb0;
import a.fg2;
import a.fz0;
import a.g91;
import a.gc1;
import a.h42;
import a.hc1;
import a.hf2;
import a.hz0;
import a.ic1;
import a.k82;
import a.kh0;
import a.m42;
import a.n92;
import a.ob1;
import a.oc2;
import a.ot0;
import a.p80;
import a.pb1;
import a.qc2;
import a.qe2;
import a.r62;
import a.ru0;
import a.s60;
import a.sb1;
import a.t61;
import a.t62;
import a.tb1;
import a.tw0;
import a.u61;
import a.u90;
import a.ub1;
import a.wb1;
import a.wd2;
import a.x62;
import a.xd2;
import a.yb;
import a.yb1;
import a.z42;
import a.zz0;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.model.AppInfo;
import com.omarea.model.SceneConfigInfo;
import com.omarea.ui.BlurViewRecyclerView;
import com.omarea.ui.UMExpandLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityFreezeApps extends g91 {
    public HashMap _$_findViewCache;
    public u90 processBarDialog;
    public SharedPreferences shortConfig;
    public ArrayList<String> freezeApps = new ArrayList<>();
    public final String sortDataKey = "sorted_packages";
    public final i editingState = new i();

    public static final class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f8689a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final PackageManager f5290a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Runnable f5291a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<String> f5292a;
        public final boolean b;

        public a(Context context, List<String> list, Runnable runnable, boolean z) {
            f92.d(context, "context");
            f92.d(list, "selectedItems");
            f92.d(runnable, "onCompleted");
            this.f8689a = context;
            this.f5292a = list;
            this.f5291a = runnable;
            this.b = z;
            PackageManager packageManager = context.getPackageManager();
            f92.c(packageManager, "context.packageManager");
            this.f5290a = packageManager;
        }

        public final void a(String str) {
            if (this.b) {
                tw0.f3070a.e(str);
            } else {
                tw0.f3070a.a(str);
            }
        }

        public final Drawable b(String str) {
            try {
                return this.f5290a.getApplicationIcon(str);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            fz0 fz0Var = new fz0(this.f8689a);
            ru0 ru0Var = new ru0(this.f8689a, false, 0, 6, null);
            for (String str : this.f5292a) {
                SceneConfigInfo sceneConfigInfoB = fz0Var.b(str);
                sceneConfigInfoB.freeze = true;
                if (fz0Var.g(sceneConfigInfoB)) {
                    Drawable drawableB = b(str);
                    if (drawableB != null) {
                        ru0Var.k(drawableB, str);
                    }
                    a(str);
                }
            }
            fz0Var.close();
            this.f5291a.run();
        }
    }

    public static final class a0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8690a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AppInfo f5293a;

        public a0(p80.b bVar, AppInfo appInfo) {
            this.f8690a = bVar;
            this.f5293a = appInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8690a.c();
            ActivityFreezeApps.this.removeConfig(this.f5293a);
            ActivityFreezeApps.this.loadData();
        }
    }

    public static final class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f8691a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Runnable f5295a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ArrayList<String> f5296a;

        public b(Context context, ArrayList<String> arrayList, Runnable runnable) {
            f92.d(context, "context");
            f92.d(arrayList, "freezeApps");
            f92.d(runnable, "onCompleted");
            this.f8691a = context;
            this.f5296a = arrayList;
            this.f5295a = runnable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            ot0 ot0Var = new ot0();
            for (String str : this.f5296a) {
                s60.f7366a.a("pm unhide " + str + "\npm enable " + str);
                Thread.sleep(3000L);
                ot0Var.a(this.f8691a, str);
            }
            this.f5295a.run();
        }
    }

    public static final class b0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8692a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AppInfo f5297a;

        public b0(p80.b bVar, AppInfo appInfo) {
            this.f8692a = bVar;
            this.f5297a = appInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8692a.c();
            p80.a aVar = p80.f2403a;
            ActivityFreezeApps activityFreezeApps = ActivityFreezeApps.this;
            String string = activityFreezeApps.getString(u61.freezer_uninstall_dialog);
            f92.c(string, "getString(R.string.freezer_uninstall_dialog)");
            aVar.i(activityFreezeApps, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : this.f5297a.getAppName(), (16 & 8) != 0 ? null : new hc1(this), (16 & 16) != 0 ? null : null);
        }
    }

    public static final class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f8693a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Runnable f5299a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ArrayList<AppInfo> f5300a;

        public c(ArrayList<AppInfo> arrayList, Context context, Runnable runnable) {
            f92.d(arrayList, "apps");
            f92.d(context, "context");
            f92.d(runnable, "onCompleted");
            this.f5300a = arrayList;
            this.f8693a = context;
            this.f5299a = runnable;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.InterruptedException {
            /*
                r4 = this;
                java.util.ArrayList<com.omarea.model.AppInfo> r0 = r4.f5300a
                java.util.Iterator r0 = r0.iterator()
            L6:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L44
                java.lang.Object r1 = r0.next()
                com.omarea.model.AppInfo r1 = (com.omarea.model.AppInfo) r1
                java.lang.Boolean r2 = r1.enabled
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L27
                java.lang.Boolean r2 = r1.suspended
                java.lang.String r3 = "appInfo.suspended"
                a.f92.c(r2, r3)
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L30
            L27:
                a.tw0$a r2 = a.tw0.f3070a
                java.lang.String r3 = r1.getPackageName()
                r2.f(r3)
            L30:
                r2 = 3000(0xbb8, double:1.482E-320)
                java.lang.Thread.sleep(r2)
                a.ot0 r2 = new a.ot0
                r2.<init>()
                android.content.Context r3 = r4.f8693a
                java.lang.String r1 = r1.getPackageName()
                r2.a(r3, r1)
                goto L6
            L44:
                java.lang.Runnable r0 = r4.f5299a
                r0.run()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityFreezeApps.c.run():void");
        }
    }

    public static final class c0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8694a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AppInfo f5301a;

        public c0(p80.b bVar, AppInfo appInfo) {
            this.f8694a = bVar;
            this.f5301a = appInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8694a.c();
            ActivityFreezeApps.this.toggleEnable(this.f5301a);
            ActivityFreezeApps.this.loadData();
        }
    }

    public static final class d extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f8695a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Runnable f5303a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ArrayList<String> f5304a;

        public d(Context context, ArrayList<String> arrayList, Runnable runnable) {
            f92.d(context, "context");
            f92.d(arrayList, "freezeApps");
            f92.d(runnable, "onCompleted");
            this.f8695a = context;
            this.f5304a = arrayList;
            this.f5303a = runnable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            fz0 fz0Var = new fz0(this.f8695a);
            ot0 ot0Var = new ot0();
            for (String str : this.f5304a) {
                tw0.a aVar = tw0.f3070a;
                f92.c(str, "it");
                aVar.f(str);
                SceneConfigInfo sceneConfigInfoB = fz0Var.b(str);
                sceneConfigInfoB.freeze = false;
                fz0Var.g(sceneConfigInfoB);
                ot0Var.g(this.f8695a, str);
                tw0 tw0VarB = tw0.f3070a.b();
                if (tw0VarB != null) {
                    tw0VarB.B(str);
                }
            }
            fz0Var.close();
            this.f5303a.run();
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityFreezeApps$switchSuspendMode$1", f = "ActivityFreezeApps.kt", l = {}, m = "invokeSuspend")
    public static final class d0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8696a;
        public int b;

        public d0(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            d0 d0Var = ActivityFreezeApps.this.new d0(b62Var);
            d0Var.f8696a = (wd2) obj;
            return d0Var;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((d0) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            for (String str : ActivityFreezeApps.this.freezeApps) {
                ActivityFreezeApps activityFreezeApps = ActivityFreezeApps.this;
                f92.c(str, "it");
                activityFreezeApps.enableApp(str);
                ActivityFreezeApps.this.disableApp(str);
            }
            Scene.f4798a.i(new ic1(this));
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityFreezeApps$addFreezeAppDialog$1", f = "ActivityFreezeApps.kt", l = {470}, m = "invokeSuspend")
    public static final class e extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8697a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5307a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5308b;
        public Object c;
        public Object d;

        public e(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            e eVar = ActivityFreezeApps.this.new e(b62Var);
            eVar.f8697a = (wd2) obj;
            return eVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((e) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.util.ArrayList] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8697a;
                ArrayList<AppInfo> arrayListH = new kh0(ActivityFreezeApps.this.getContext(), false, 2, null).h(null, true);
                ArrayList<AppInfo> arrayList = new ArrayList();
                for (Object obj2 : arrayListH) {
                    if (t62.a(!ActivityFreezeApps.this.freezeApps.contains(((AppInfo) obj2).getPackageName())).booleanValue()) {
                        arrayList.add(obj2);
                    }
                }
                n92 n92Var = new n92();
                ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
                for (AppInfo appInfo : arrayList) {
                    d70.a aVar = new d70.a();
                    aVar.setAppName("" + appInfo.getAppName());
                    aVar.setPackageName("" + appInfo.getPackageName());
                    aVar.setSelected(false);
                    arrayList2.add(aVar);
                }
                n92Var.f6891a = new ArrayList(arrayList2);
                fg2 fg2VarC = qe2.c();
                ob1 ob1Var = new ob1(this, n92Var, null);
                this.f5307a = wd2Var;
                this.f5308b = arrayListH;
                this.c = arrayList;
                this.d = n92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, ob1Var, this) == objC) {
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

    public static final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Scene.f4798a.i(new pb1(this));
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityFreezeApps$autoAddList$1", f = "ActivityFreezeApps.kt", l = {}, m = "invokeSuspend")
    public static final class g extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8699a;
        public int b;

        public g(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            g gVar = ActivityFreezeApps.this.new g(b62Var);
            gVar.f8699a = (wd2) obj;
            return gVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((g) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
        @Override // a.s62
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object j(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 428
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityFreezeApps.g.j(java.lang.Object):java.lang.Object");
        }
    }

    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u90 u90VarAccess$getProcessBarDialog$p = ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this);
            String string = ActivityFreezeApps.this.getString(u61.please_wait);
            f92.c(string, "getString(R.string.please_wait)");
            u90VarAccess$getProcessBarDialog$p.d(string);
            new b(ActivityFreezeApps.this.getContext(), ActivityFreezeApps.this.freezeApps, new sb1(this)).start();
        }
    }

    public static final class i implements d61 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8701a;

        @Override // a.d61
        public boolean a() {
            return false;
        }

        @Override // a.d61
        public boolean b() {
            return this.f8701a;
        }

        public final boolean c() {
            return this.f8701a;
        }

        public final void d(boolean z) {
            this.f8701a = z;
        }
    }

    public static final class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UMExpandLayout f8702a;

        public j(UMExpandLayout uMExpandLayout) {
            this.f8702a = uMExpandLayout;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8702a.k();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            ImageView imageView = (ImageView) view;
            Context context = ActivityFreezeApps.this.getContext();
            UMExpandLayout uMExpandLayout = this.f8702a;
            f92.c(uMExpandLayout, "freezeOptions");
            imageView.setImageDrawable(yb.d(context, uMExpandLayout.h() ? 2131230844 : 2131230843));
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UMExpandLayout f8703a;

        public k(UMExpandLayout uMExpandLayout) {
            this.f8703a = uMExpandLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f8703a.f(false);
        }
    }

    public static final class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8704a;

        public l(p80.b bVar) {
            this.f8704a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8704a.c();
            u90.e(ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this), null, 1, null);
            qc2.d(hf2.f6309a, qe2.b(), null, new wb1(this, null), 2, null);
        }
    }

    public static final class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f8705a = new m();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Scene.c cVar = Scene.f4798a;
            String strM = hz0.f1282a.M();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            cVar.k(strM, ((CompoundButton) view).isChecked());
        }
    }

    public static final class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentName f8706a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ PackageManager f5312a;

        public n(PackageManager packageManager, ComponentName componentName) {
            this.f5312a = packageManager;
            this.f8706a = componentName;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            if (((CompoundButton) view).isChecked()) {
                this.f5312a.setComponentEnabledSetting(this.f8706a, 1, 1);
            } else {
                this.f5312a.setComponentEnabledSetting(this.f8706a, 2, 1);
            }
            Toast.makeText(ActivityFreezeApps.this.getContext(), ActivityFreezeApps.this.getString(u61.freeze_entrance_changed), 0).show();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            ((CompoundButton) view).setChecked(this.f5312a.getComponentEnabledSetting(this.f8706a) == 1);
        }
    }

    public static final class o implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8707a;

        public o(p80.b bVar) {
            this.f8707a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8707a.c();
            u90.e(ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this), null, 1, null);
            qc2.d(xd2.a(qe2.b()), null, null, new yb1(this, null), 3, null);
        }
    }

    public static final class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8708a;

        public p(p80.b bVar) {
            this.f8708a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8708a.c();
            u90.e(ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this), null, 1, null);
            new d(ActivityFreezeApps.this.getContext(), ActivityFreezeApps.this.freezeApps, new ac1(this)).start();
        }
    }

    public static final class q implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8709a;

        public q(p80.b bVar) {
            this.f8709a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8709a.c();
            ActivityFreezeApps.this.createShortcutAll();
        }
    }

    public static final class r implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8710a;

        public r(p80.b bVar) {
            this.f8710a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8710a.c();
            ActivityFreezeApps.this.autoAddList();
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityFreezeApps$loadData$1", f = "ActivityFreezeApps.kt", l = {176}, m = "invokeSuspend")
    public static final class s extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8711a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5319a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5320b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f5321b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public Object f5322c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;

        public s(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            s sVar = ActivityFreezeApps.this.new s(b62Var);
            sVar.f8711a = (wd2) obj;
            return sVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((s) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v15, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v16, types: [T, java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r1v19, types: [T, java.util.ArrayList] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.c;
            try {
                if (i == 0) {
                    h42.b(obj);
                    wd2 wd2Var = this.f8711a;
                    fz0 fz0Var = new fz0(ActivityFreezeApps.this.getContext());
                    String string = ActivityFreezeApps.access$getShortConfig$p(ActivityFreezeApps.this).getString(ActivityFreezeApps.this.sortDataKey, "");
                    f92.b(string);
                    f92.c(string, "shortConfig.getString(sortDataKey, \"\")!!");
                    List listD0 = ec2.d0(string, new String[]{","}, false, 0, 6, null);
                    ActivityFreezeApps activityFreezeApps = ActivityFreezeApps.this;
                    ArrayList<String> arrayListC = fz0Var.c();
                    f92.c(arrayListC, "store.freezeAppList");
                    activityFreezeApps.freezeApps = arrayListC;
                    int size = ActivityFreezeApps.this.freezeApps.size();
                    ArrayList arrayList = ActivityFreezeApps.this.freezeApps;
                    if (arrayList.size() > 1) {
                        c52.n(arrayList, new ec1(listD0, size));
                    }
                    boolean zB = Scene.f4798a.b(hz0.f1282a.M(), false);
                    ArrayList<String> arrayListE = zB ? new ot0().e(ActivityFreezeApps.this.getContext()) : new ArrayList<>();
                    n92 n92Var = new n92();
                    n92Var.f6891a = new ArrayList();
                    n92 n92Var2 = new n92();
                    n92Var2.f6891a = new StringBuilder();
                    kh0 kh0Var = new kh0(ActivityFreezeApps.this.getContext(), false, 2, null);
                    n92 n92Var3 = new n92();
                    n92Var3.f6891a = new ArrayList();
                    for (String str : ActivityFreezeApps.this.freezeApps) {
                        f92.c(str, "it");
                        AppInfo appInfoD = kh0Var.d(str);
                        if (appInfoD != null) {
                            ((ArrayList) n92Var3.f6891a).add(appInfoD);
                            if (zB && !arrayListE.contains(str)) {
                                ((ArrayList) n92Var.f6891a).add(appInfoD);
                                StringBuilder sb = (StringBuilder) n92Var2.f6891a;
                                sb.append(appInfoD.getAppName());
                                sb.append("\n");
                            }
                        }
                    }
                    fz0Var.close();
                    fg2 fg2VarC = qe2.c();
                    dc1 dc1Var = new dc1(this, n92Var3, n92Var, n92Var2, null);
                    this.f5319a = wd2Var;
                    this.f5320b = fz0Var;
                    this.f5322c = listD0;
                    this.b = size;
                    this.f5321b = zB;
                    this.d = arrayListE;
                    this.e = n92Var;
                    this.f = n92Var2;
                    this.g = kh0Var;
                    this.h = n92Var3;
                    this.c = 1;
                    if (oc2.g(fg2VarC, dc1Var, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
            return m42.f6769a;
        }
    }

    public static final class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ImageButton imageButton = (ImageButton) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_sort_confirm);
            f92.c(imageButton, "freeze_sort_confirm");
            imageButton.setVisibility(0);
            f92.c(view, "it");
            view.setVisibility(8);
            ImageButton imageButton2 = (ImageButton) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_menu);
            f92.c(imageButton2, "freeze_menu");
            imageButton2.setVisibility(8);
            EditText editText = (EditText) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_apps_search);
            f92.c(editText, "freeze_apps_search");
            editText.setEnabled(false);
            ActivityFreezeApps.this.editingState.d(true);
            BlurViewRecyclerView blurViewRecyclerView = (BlurViewRecyclerView) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_apps);
            f92.c(blurViewRecyclerView, "freeze_apps");
            zz0 zz0Var = (zz0) blurViewRecyclerView.getAdapter();
            if (zz0Var != null) {
                zz0Var.H(ActivityFreezeApps.this.editingState.c());
            }
            Toast.makeText(ActivityFreezeApps.this.getContext(), ActivityFreezeApps.this.getString(u61.freezer_editing), 0).show();
        }
    }

    public static final class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityFreezeApps.this.editingState.d(false);
            BlurViewRecyclerView blurViewRecyclerView = (BlurViewRecyclerView) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_apps);
            f92.c(blurViewRecyclerView, "freeze_apps");
            zz0 zz0Var = (zz0) blurViewRecyclerView.getAdapter();
            if (zz0Var != null) {
                StringBuilder sb = new StringBuilder();
                for (AppInfo appInfo : zz0Var.D()) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(appInfo.getPackageName());
                }
                ActivityFreezeApps.access$getShortConfig$p(ActivityFreezeApps.this).edit().clear().putString(ActivityFreezeApps.this.sortDataKey, sb.toString()).apply();
                zz0Var.H(ActivityFreezeApps.this.editingState.c());
                EditText editText = (EditText) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_apps_search);
                f92.c(editText, "freeze_apps_search");
                Editable text = editText.getText();
                zz0Var.getFilter().filter(text == null ? "" : text.toString());
            }
            ImageButton imageButton = (ImageButton) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_sort);
            f92.c(imageButton, "freeze_sort");
            imageButton.setVisibility(0);
            ImageButton imageButton2 = (ImageButton) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_menu);
            f92.c(imageButton2, "freeze_menu");
            imageButton2.setVisibility(0);
            f92.c(view, "it");
            view.setVisibility(8);
            EditText editText2 = (EditText) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_apps_search);
            f92.c(editText2, "freeze_apps_search");
            editText2.setEnabled(true);
            Toast.makeText(ActivityFreezeApps.this.getContext(), ActivityFreezeApps.this.getString(u61.freezer_edit_saved), 0).show();
        }
    }

    public static final class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (f92.a(e50.f677a.y0(), "basic")) {
                Toast.makeText(ActivityFreezeApps.this.getContext(), u61.only_adb_or_root_mode, 0).show();
            } else {
                ActivityFreezeApps.this.freezeOptionsDialog();
            }
        }
    }

    public static final class w implements TextWatcher {
        public w() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Filter filter;
            String string;
            BlurViewRecyclerView blurViewRecyclerView = (BlurViewRecyclerView) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_apps);
            f92.c(blurViewRecyclerView, "freeze_apps");
            Filterable filterable = (Filterable) blurViewRecyclerView.getAdapter();
            if (filterable == null || (filter = filterable.getFilter()) == null) {
                return;
            }
            if (charSequence == null || (string = charSequence.toString()) == null) {
                string = "";
            }
            filter.filter(string);
        }
    }

    public static final class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5323a;

        public x(ArrayList arrayList) {
            this.f5323a = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u90 u90VarAccess$getProcessBarDialog$p = ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this);
            String string = ActivityFreezeApps.this.getString(u61.please_wait);
            f92.c(string, "getString(R.string.please_wait)");
            u90VarAccess$getProcessBarDialog$p.d(string);
            new c(this.f5323a, ActivityFreezeApps.this.getContext(), new gc1(this)).start();
        }
    }

    public static final class y implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8717a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AppInfo f5324a;

        public y(p80.b bVar, AppInfo appInfo) {
            this.f8717a = bVar;
            this.f5324a = appInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8717a.c();
            ActivityFreezeApps.this.startApp(this.f5324a);
        }
    }

    public static final class z implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p80.b f8718a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AppInfo f5326a;

        public z(p80.b bVar, AppInfo appInfo) {
            this.f8718a = bVar;
            this.f5326a = appInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8718a.c();
            ActivityFreezeApps.this.createShortcut(this.f5326a);
        }
    }

    public static final /* synthetic */ u90 access$getProcessBarDialog$p(ActivityFreezeApps activityFreezeApps) {
        u90 u90Var = activityFreezeApps.processBarDialog;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("processBarDialog");
        throw null;
    }

    public static final /* synthetic */ SharedPreferences access$getShortConfig$p(ActivityFreezeApps activityFreezeApps) {
        SharedPreferences sharedPreferences = activityFreezeApps.shortConfig;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        f92.m("shortConfig");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFreezeAppDialog() {
        u90 u90Var = this.processBarDialog;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        qc2.d(xd2.a(qe2.b()), null, null, new e(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFreezeApps(List<String> list) {
        u90 u90Var = this.processBarDialog;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        String string = getString(u61.please_wait);
        f92.c(string, "getString(R.string.please_wait)");
        u90Var.d(string);
        new a(getContext(), list, new f(), getUseSuspendMode()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoAddList() {
        u90 u90Var = this.processBarDialog;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        String string = getString(u61.please_wait);
        f92.c(string, "getString(R.string.please_wait)");
        u90Var.d(string);
        qc2.d(hf2.f6309a, qe2.b(), null, new g(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void createShortcut(com.omarea.model.AppInfo r3) {
        /*
            r2 = this;
            java.lang.Boolean r0 = r3.enabled
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L15
            java.lang.Boolean r0 = r3.suspended
            java.lang.String r1 = "appInfo.suspended"
            a.f92.c(r0, r1)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L18
        L15:
            r2.enableApp(r3)
        L18:
            a.ot0 r0 = new a.ot0
            r0.<init>()
            android.content.Context r1 = r2.getContext()
            java.lang.String r3 = r3.getPackageName()
            boolean r3 = r0.a(r1, r3)
            r0 = 0
            if (r3 == 0) goto L34
            android.content.Context r3 = r2.getContext()
            r1 = 2131886735(0x7f12028f, float:1.9408057E38)
            goto L3b
        L34:
            android.content.Context r3 = r2.getContext()
            r1 = 2131886734(0x7f12028e, float:1.9408055E38)
        L3b:
            java.lang.String r1 = r2.getString(r1)
            android.widget.Toast r3 = android.widget.Toast.makeText(r3, r1, r0)
            r3.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityFreezeApps.createShortcut(com.omarea.model.AppInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createShortcutAll() {
        p80.a aVar = p80.f2403a;
        String string = getString(u61.freeze_batch_add);
        f92.c(string, "getString(R.string.freeze_batch_add)");
        String string2 = getString(u61.freeze_batch_add_wran);
        f92.c(string2, "getString(R.string.freeze_batch_add_wran)");
        aVar.i(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new h(), (16 & 16) != 0 ? null : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableApp(AppInfo appInfo) {
        disableApp(appInfo.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableApp(String str) {
        if (getUseSuspendMode()) {
            tw0.f3070a.e(str);
        } else {
            tw0.f3070a.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableApp(AppInfo appInfo) {
        enableApp(appInfo.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableApp(String str) {
        tw0.f3070a.f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void freezeOptionsDialog() {
        View viewInflate = getLayoutInflater().inflate(2131558522, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        viewInflate.findViewById(t61.menu_freeze).setOnClickListener(new l(bVarT));
        if (Build.VERSION.SDK_INT >= 28) {
            CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.freeze_suspend_mode);
            compoundButton.setEnabled(Build.VERSION.SDK_INT >= 28);
            compoundButton.setChecked(getUseSuspendMode());
            compoundButton.setOnClickListener(new tb1(this));
        } else {
            View viewFindViewById = viewInflate.findViewById(t61.freeze_suspend);
            f92.c(viewFindViewById, "view.findViewById<View>(R.id.freeze_suspend)");
            viewFindViewById.setVisibility(8);
        }
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.freeze_shortcut_suggest);
        f92.c(compoundButton2, "freeze_shortcut_suggest");
        compoundButton2.setChecked(Scene.f4798a.b(hz0.f1282a.M(), false));
        compoundButton2.setOnClickListener(m.f8705a);
        SeekBar seekBar = (SeekBar) viewInflate.findViewById(t61.freeze_time_limit);
        TextView textView = (TextView) viewInflate.findViewById(t61.freeze_time_limit_text);
        seekBar.setProgress(Scene.f4798a.g().getInt(hz0.f1282a.N(), 2));
        f92.c(textView, "freeze_time_limit_text");
        textView.setText(String.valueOf(seekBar.getProgress()));
        seekBar.setOnSeekBarChangeListener(new ub1(textView));
        CompoundButton compoundButton3 = (CompoundButton) viewInflate.findViewById(t61.freeze_quick_entry);
        PackageManager packageManager = getPackageManager();
        ComponentName componentName = new ComponentName(getApplicationContext(), (Class<?>) ActivityFreezeApps.class);
        boolean z2 = packageManager.getComponentEnabledSetting(componentName) == 1;
        f92.c(compoundButton3, "freeze_quick_entry");
        compoundButton3.setChecked(z2);
        compoundButton3.setOnClickListener(new n(packageManager, componentName));
        viewInflate.findViewById(t61.menu_unfreeze).setOnClickListener(new o(bVarT));
        viewInflate.findViewById(t61.menu_remove).setOnClickListener(new p(bVarT));
        viewInflate.findViewById(t61.menu_shortcut).setOnClickListener(new q(bVarT));
        viewInflate.findViewById(t61.menu_auto_add).setOnClickListener(new r(bVarT));
        UMExpandLayout uMExpandLayout = (UMExpandLayout) viewInflate.findViewById(t61.freeze_options);
        viewInflate.findViewById(t61.freeze_options_switch).setOnClickListener(new j(uMExpandLayout));
        Scene.f4798a.j(new k(uMExpandLayout), 15L);
    }

    private final boolean getUseSuspendMode() {
        return Scene.f4798a.b(hz0.O, Build.VERSION.SDK_INT >= 28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        qc2.d(xd2.a(qe2.b()), null, null, new s(null), 3, null);
        ((ImageButton) _$_findCachedViewById(t61.freeze_sort)).setOnClickListener(new t());
        ((ImageButton) _$_findCachedViewById(t61.freeze_sort_confirm)).setOnClickListener(new u());
    }

    private final void onViewCreated() {
        SharedPreferences sharedPreferences = getSharedPreferences("freeze_apps_sort", 0);
        f92.c(sharedPreferences, "this.getSharedPreference…t\", Context.MODE_PRIVATE)");
        this.shortConfig = sharedPreferences;
        u90 u90Var = new u90(this, null, 2, null);
        this.processBarDialog = u90Var;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        ((ImageButton) _$_findCachedViewById(t61.freeze_menu)).setOnClickListener(new v());
        loadData();
        ((EditText) _$_findCachedViewById(t61.freeze_apps_search)).addTextChangedListener(new w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeAndUninstall(AppInfo appInfo) {
        removeConfig(appInfo);
        s60.f7366a.a("pm uninstall --user " + new fb0(getContext()).b() + " " + appInfo.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void removeConfig(com.omarea.model.AppInfo r4) {
        /*
            r3 = this;
            java.lang.Boolean r0 = r4.enabled
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L15
            java.lang.Boolean r0 = r4.suspended
            java.lang.String r1 = "appInfo.suspended"
            a.f92.c(r0, r1)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L18
        L15:
            r3.enableApp(r4)
        L18:
            java.lang.String r4 = r4.getPackageName()
            a.fz0 r0 = new a.fz0
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            com.omarea.model.SceneConfigInfo r1 = r0.b(r4)
            r2 = 0
            r1.freeze = r2
            r0.g(r1)
            r0.close()
            a.tw0$a r0 = a.tw0.f3070a
            a.tw0 r0 = r0.b()
            if (r0 == 0) goto L3d
            r0.B(r4)
        L3d:
            a.ot0 r0 = new a.ot0
            r0.<init>()
            android.content.Context r1 = r3.getContext()
            r0.g(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityFreezeApps.removeConfig(com.omarea.model.AppInfo):void");
    }

    private final Bitmap rsBlur(Bitmap bitmap, int i2) {
        RenderScript renderScriptCreate = RenderScript.create(this);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
        Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(i2);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(bitmap);
        renderScriptCreate.destroy();
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shortcutsLostDialog(String str, ArrayList<AppInfo> arrayList) {
        if (Scene.f4798a.b(hz0.f1282a.M(), false)) {
            p80.a aVar = p80.f2403a;
            String string = getString(u61.freeze_shortcut_lost);
            f92.c(string, "getString(R.string.freeze_shortcut_lost)");
            aVar.i(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : getString(u61.freeze_shortcut_lost_desc) + "\n\n" + str, (16 & 8) != 0 ? null : new x(arrayList), (16 & 16) != 0 ? null : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showOptions(AppInfo appInfo) {
        View viewInflate = getLayoutInflater().inflate(2131558521, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        viewInflate.findViewById(t61.app_options_open).setOnClickListener(new y(bVarT, appInfo));
        viewInflate.findViewById(t61.app_options_shortcut).setOnClickListener(new z(bVarT, appInfo));
        viewInflate.findViewById(t61.app_options_remove).setOnClickListener(new a0(bVarT, appInfo));
        viewInflate.findViewById(t61.app_options_uninstall).setOnClickListener(new b0(bVarT, appInfo));
        viewInflate.findViewById(t61.app_options_freeze).setOnClickListener(new c0(bVarT, appInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void startApp(com.omarea.model.AppInfo r3) {
        /*
            r2 = this;
            r2.enableApp(r3)
            java.lang.Boolean r0 = r3.enabled
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L18
            java.lang.Boolean r0 = r3.suspended
            java.lang.String r1 = "appInfo.suspended"
            a.f92.c(r0, r1)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L3f
        L18:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r3.enabled = r0
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r3.suspended = r0
            int r0 = a.t61.freeze_apps
            android.view.View r0 = r2._$_findCachedViewById(r0)
            com.omarea.ui.BlurViewRecyclerView r0 = (com.omarea.ui.BlurViewRecyclerView) r0
            if (r0 == 0) goto L2f
            androidx.recyclerview.widget.RecyclerView$g r0 = r0.getAdapter()
            goto L30
        L2f:
            r0 = 0
        L30:
            a.zz0 r0 = (a.zz0) r0
            if (r0 == 0) goto L3f
            java.util.ArrayList r1 = r0.D()
            int r1 = r1.indexOf(r3)
            r0.j(r1)
        L3f:
            a.tw0$a r0 = a.tw0.f3070a
            a.tw0 r0 = r0.b()
            if (r0 == 0) goto L4e
            java.lang.String r1 = r3.getPackageName()
            r0.F(r1)
        L4e:
            a.x50 r0 = new a.x50
            r0.<init>(r2)
            java.lang.String r3 = r3.getPackageName()
            r0.b(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityFreezeApps.startApp(com.omarea.model.AppInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchSuspendMode() {
        u90 u90Var = this.processBarDialog;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        qc2.d(hf2.f6309a, qe2.b(), null, new d0(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void toggleEnable(com.omarea.model.AppInfo r4) {
        /*
            r3 = this;
            java.lang.Boolean r0 = r4.enabled
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L33
            java.lang.Boolean r0 = r4.suspended
            java.lang.String r2 = "appInfo.suspended"
            a.f92.c(r0, r2)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L17
            goto L33
        L17:
            r3.disableApp(r4)
            android.content.Context r0 = r3.getContext()
            r2 = 2131886731(0x7f12028b, float:1.940805E38)
            java.lang.String r2 = r3.getString(r2)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r1)
            r0.show()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.enabled = r0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L4e
        L33:
            r3.enableApp(r4)
            android.content.Context r0 = r3.getContext()
            r2 = 2131886732(0x7f12028c, float:1.9408051E38)
            java.lang.String r2 = r3.getString(r2)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r1)
            r0.show()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r4.enabled = r0
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L4e:
            r4.suspended = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityFreezeApps.toggleEnable(com.omarea.model.AppInfo):void");
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // android.app.Activity
    public void finish() {
        u90 u90Var;
        try {
            u90Var = this.processBarDialog;
        } catch (Exception unused) {
        }
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90Var.c();
        super.finish();
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558451);
        setBackArrow();
        onViewCreated();
    }
}
