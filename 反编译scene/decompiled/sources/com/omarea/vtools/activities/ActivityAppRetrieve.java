package com.omarea.vtools.activities;

import a.b62;
import a.d72;
import a.e50;
import a.f92;
import a.fb0;
import a.fg2;
import a.g91;
import a.h42;
import a.hf2;
import a.k82;
import a.m42;
import a.n92;
import a.o81;
import a.oc2;
import a.p01;
import a.p80;
import a.p81;
import a.pj0;
import a.q81;
import a.qc2;
import a.qe2;
import a.r62;
import a.s60;
import a.t61;
import a.u61;
import a.u90;
import a.wd2;
import a.x62;
import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.omarea.common.ui.OverScrollListView;
import com.omarea.model.AppInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAppRetrieve extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u90 f8538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PackageManager f5149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f5150a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<p01> f5151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5152a;

    @x62(c = "com.omarea.vtools.activities.ActivityAppRetrieve$loadData$1", f = "ActivityAppRetrieve.kt", l = {95}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8539a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5154a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5155b;
        public Object c;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = ActivityAppRetrieve.this.new a(b62Var);
            aVar.f8539a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [T, java.util.ArrayList] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8539a;
                ArrayList<ApplicationInfo> arrayListA = new pj0().a(ActivityAppRetrieve.this.getContext());
                n92 n92Var = new n92();
                n92Var.f6891a = new ArrayList();
                f92.c(arrayListA, "uninstalledApp");
                for (ApplicationInfo applicationInfo : arrayListA) {
                    ArrayList arrayList = (ArrayList) n92Var.f6891a;
                    ActivityAppRetrieve activityAppRetrieve = ActivityAppRetrieve.this;
                    f92.c(applicationInfo, "it");
                    arrayList.add(activityAppRetrieve.r(applicationInfo));
                }
                fg2 fg2VarC = qe2.c();
                o81 o81Var = new o81(this, n92Var, null);
                this.f5154a = wd2Var;
                this.f5155b = arrayListA;
                this.c = n92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, o81Var, this) == objC) {
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

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ StringBuilder f5156a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5157a;

        public b(StringBuilder sb, ArrayList arrayList) {
            this.f5156a = sb;
            this.f5157a = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            s60 s60Var = s60.f7366a;
            String string = this.f5156a.toString();
            f92.c(string, "cmds.toString()");
            s60Var.a(string);
            ActivityAppRetrieve.this.t(this.f5157a);
            ArrayList<ApplicationInfo> arrayListA = new pj0().a(ActivityAppRetrieve.this);
            ArrayList arrayList = new ArrayList();
            for (ApplicationInfo applicationInfo : arrayListA) {
                ArrayList arrayList2 = this.f5157a;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (f92.a(((AppInfo) obj).getPackageName(), applicationInfo.packageName)) {
                        arrayList3.add(obj);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    ActivityAppRetrieve activityAppRetrieve = ActivityAppRetrieve.this;
                    f92.c(applicationInfo, "app");
                    arrayList.add(activityAppRetrieve.r(applicationInfo));
                }
            }
            ActivityAppRetrieve.this.f5150a.post(new p81(this, arrayList, arrayListA));
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppRetrieve.this.s();
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p80.a aVar = p80.f2403a;
            ActivityAppRetrieve activityAppRetrieve = ActivityAppRetrieve.this;
            String string = activityAppRetrieve.getString(u61.apps_retrieve_confirm);
            f92.c(string, "getString(R.string.apps_retrieve_confirm)");
            aVar.i(activityAppRetrieve, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : "", (16 & 8) != 0 ? null : new q81(this), (16 & 16) != 0 ? null : null);
        }
    }

    public static final /* synthetic */ u90 m(ActivityAppRetrieve activityAppRetrieve) {
        u90 u90Var = activityAppRetrieve.f8538a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("progressBarDialog");
        throw null;
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5152a == null) {
            this.f5152a = new HashMap();
        }
        View view = (View) this.f5152a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5152a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void loadData() {
        u90 u90Var = this.f8538a;
        if (u90Var == null) {
            f92.m("progressBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        qc2.d(hf2.f6309a, qe2.b(), null, new a(null), 2, null);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    @SuppressLint({"ApplySharedPref"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558437);
        setBackArrow();
        PackageManager packageManager = getPackageManager();
        f92.c(packageManager, "packageManager");
        this.f5149a = packageManager;
        this.f8538a = new u90(this, null, 2, null);
        ((OverScrollListView) _$_findCachedViewById(t61.hidden_app)).addHeaderView(getLayoutInflater().inflate(2131558618, (ViewGroup) null));
        ((FloatingActionButton) _$_findCachedViewById(t61.fab_confirm)).setOnClickListener(new c());
        if (f92.a(e50.f677a.y0(), "root")) {
            ((ImageView) _$_findCachedViewById(t61.apps_force_reset)).setOnClickListener(new d());
            return;
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(t61.apps_force_reset);
        f92.c(imageView, "apps_force_reset");
        imageView.setVisibility(8);
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().w();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        loadData();
    }

    public final AppInfo r(ApplicationInfo applicationInfo) {
        AppInfo appInfo = new AppInfo();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        PackageManager packageManager = this.f5149a;
        if (packageManager == null) {
            f92.m("pm");
            throw null;
        }
        sb.append(applicationInfo.loadLabel(packageManager));
        appInfo.setAppName(sb.toString());
        String str = applicationInfo.packageName;
        f92.c(str, "it.packageName");
        appInfo.setPackageName(str);
        appInfo.enabled = Boolean.valueOf(applicationInfo.enabled);
        appInfo.path = applicationInfo.sourceDir;
        return appInfo;
    }

    public final void s() {
        WeakReference<p01> weakReference = this.f5151a;
        p01 p01Var = weakReference != null ? weakReference.get() : null;
        f92.b(p01Var);
        ArrayList<AppInfo> arrayListE = p01Var.e();
        if (arrayListE.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (AppInfo appInfo : arrayListE) {
                sb.append("pm unhide " + appInfo.getPackageName() + '\n');
                sb.append("pm enable " + appInfo.getPackageName() + '\n');
                if (Build.VERSION.SDK_INT >= 28) {
                    sb.append("pm unsuspend " + appInfo.getPackageName() + "\nsu 1000 -c 'pm unsuspend " + appInfo.getPackageName() + "' 2>/dev/null\n");
                }
            }
            if (f92.a(e50.f677a.y0(), "basic")) {
                p80.a aVar = p80.f2403a;
                String string = getString(u61.apps_retrieve_adb_require);
                f92.c(string, "getString(R.string.apps_retrieve_adb_require)");
                p80.a.B(aVar, this, string, getString(u61.apps_retrieve_adb_require_desc) + "\n\n" + ((Object) sb), null, 8, null);
                return;
            }
            u90 u90Var = this.f8538a;
            if (u90Var == null) {
                f92.m("progressBarDialog");
                throw null;
            }
            String string2 = getString(u61.please_wait);
            f92.c(string2, "getString(R.string.please_wait)");
            u90Var.d(string2);
            new Thread(new b(sb, arrayListE)).start();
        }
    }

    public final void t(ArrayList<AppInfo> arrayList) {
        int iB = new fb0(this).b();
        Iterator<AppInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            String str = "pm install-existing --user " + iB + ' ' + it.next().getPackageName();
            Log.d("Scene", str);
            s60.f7366a.a(str);
        }
    }
}
