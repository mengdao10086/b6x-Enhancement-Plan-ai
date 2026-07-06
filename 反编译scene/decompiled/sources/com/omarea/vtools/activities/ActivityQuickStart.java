package com.omarea.vtools.activities;

import a.b62;
import a.d72;
import a.e50;
import a.f92;
import a.h42;
import a.k82;
import a.m42;
import a.nf1;
import a.of1;
import a.pf1;
import a.qc2;
import a.qe2;
import a.r62;
import a.s60;
import a.t61;
import a.tw0;
import a.u61;
import a.wd2;
import a.wp0;
import a.x62;
import a.xd2;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityQuickStart extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5473a;
    public String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5474b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8865a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WeakReference<ActivityQuickStart> f5475a;

        public a(ActivityQuickStart activityQuickStart, String str) {
            f92.d(activityQuickStart, "context");
            f92.d(str, "pkg");
            this.f8865a = str;
            this.f5475a = new WeakReference<>(activityQuickStart);
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityQuickStart activityQuickStart = this.f5475a.get();
            if (activityQuickStart != null) {
                activityQuickStart.f5474b = true;
                Scene.f4798a.i(new nf1(activityQuickStart));
            }
            tw0.f3070a.f(this.f8865a);
            Scene.f4798a.i(new of1(this));
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityQuickStart$startApp$1", f = "ActivityQuickStart.kt", l = {}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8866a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Intent f5476a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Intent intent, b62 b62Var) {
            super(2, b62Var);
            this.f5476a = intent;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = ActivityQuickStart.this.new b(this.f5476a, b62Var);
            bVar.f8866a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            this.f5476a.setFlags(268500992);
            ActivityQuickStart.this.startActivity(this.f5476a);
            tw0 tw0VarB = tw0.f3070a.b();
            if (tw0VarB != null) {
                tw0VarB.G(ActivityQuickStart.this.f());
            }
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityQuickStart$startApp$2", f = "ActivityQuickStart.kt", l = {}, m = "invokeSuspend")
    public static final class c extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8867a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Intent f5478a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Intent intent, b62 b62Var) {
            super(2, b62Var);
            this.f5478a = intent;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            c cVar = ActivityQuickStart.this.new c(this.f5478a, b62Var);
            cVar.f8867a = (wd2) obj;
            return cVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((c) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            s60 s60Var;
            StringBuilder sb;
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            try {
                ActivityQuickStart.this.startActivity(this.f5478a);
            } catch (SecurityException unused) {
                if (f92.a(e50.f677a.y0(), "basic")) {
                    Toast.makeText(ActivityQuickStart.this.getApplicationContext(), ActivityQuickStart.this.getString(u61.fps_adb_root_require), 1).show();
                } else {
                    s60Var = s60.f7366a;
                    sb = new StringBuilder();
                    sb.append("am start -n '");
                    sb.append(ActivityQuickStart.this.f());
                    sb.append('/');
                    sb.append(ActivityQuickStart.this.b);
                    sb.append('\'');
                    s60Var.a(sb.toString());
                }
            } catch (Exception unused2) {
                s60Var = s60.f7366a;
                sb = new StringBuilder();
                sb.append("am start -n '");
                sb.append(ActivityQuickStart.this.f());
                sb.append('/');
                sb.append(ActivityQuickStart.this.b);
                sb.append('\'');
                s60Var.a(sb.toString());
            }
            return m42.f6769a;
        }
    }

    public View a(int i) {
        if (this.f5473a == null) {
            this.f5473a = new HashMap();
        }
        View view = (View) this.f5473a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5473a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void e(Runnable runnable) {
        qc2.d(xd2.a(qe2.b()), null, null, new pf1(new wp0(this, runnable, null, 4, null), null), 3, null);
    }

    public final String f() {
        String str = this.f8864a;
        if (str != null) {
            return str;
        }
        f92.m("appPackageName");
        throw null;
    }

    public final void g() {
        String str;
        PackageManager packageManager = getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
        } catch (Exception unused) {
            TextView textView = (TextView) a(t61.start_state_text);
            f92.c(textView, "start_state_text");
            textView.setText(getString(u61.freezer_qs_start_fail));
        }
        if (this.b != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            String str2 = this.f8864a;
            if (str2 == null) {
                f92.m("appPackageName");
                throw null;
            }
            String str3 = this.b;
            f92.b(str3);
            intent.setComponent(new ComponentName(str2, str3));
            intent.setFlags(268500992);
            qc2.d(xd2.a(qe2.a()), null, null, new c(intent, null), 3, null);
            return;
        }
        String str4 = this.f8864a;
        if (str4 == null) {
            f92.m("appPackageName");
            throw null;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str4);
        if (launchIntentForPackage != null) {
            qc2.d(xd2.a(qe2.a()), null, null, new b(launchIntentForPackage, null), 3, null);
            return;
        }
        try {
            str = this.f8864a;
        } catch (Exception unused2) {
        }
        if (str == null) {
            f92.m("appPackageName");
            throw null;
        }
        applicationInfo = packageManager.getApplicationInfo(str, 0);
        TextView textView2 = (TextView) a(t61.start_state_text);
        f92.c(textView2, "start_state_text");
        textView2.setText(applicationInfo == null ? getString(u61.freezer_qs_uninstalled) : getString(u61.freezer_qs_start_fail));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        ApplicationInfo applicationInfo;
        String str;
        super.onCreate(bundle);
        setContentView(2131558463);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Window window = getWindow();
        f92.c(window, "window");
        View decorView = window.getDecorView();
        f92.c(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1280);
        Window window2 = getWindow();
        f92.c(window2, "window");
        window2.setStatusBarColor(0);
        Intent intent = getIntent();
        f92.c(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("packageName")) {
            TextView textView = (TextView) a(t61.start_state_text);
            f92.c(textView, "start_state_text");
            textView.setText(getString(u61.freezer_qs_invalid));
            return;
        }
        String string = extras.getString("packageName");
        f92.b(string);
        this.f8864a = string;
        if (extras.containsKey("className")) {
            String string2 = extras.getString("className");
            f92.b(string2);
            this.b = string2;
        }
        PackageManager packageManager = getPackageManager();
        try {
            str = this.f8864a;
        } catch (Exception unused) {
            applicationInfo = null;
        }
        if (str == null) {
            f92.m("appPackageName");
            throw null;
        }
        applicationInfo = packageManager.getApplicationInfo(str, 0);
        if (applicationInfo != null && applicationInfo.enabled && (applicationInfo.flags & 1073741824) == 0) {
            g();
            return;
        }
        String str2 = this.f8864a;
        if (str2 != null) {
            e(new a(this, str2));
        } else {
            f92.m("appPackageName");
            throw null;
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        finish();
    }
}
