package com.omarea.vtools.activities;

import a.d0;
import a.f92;
import a.g31;
import a.g91;
import a.hz0;
import a.iz0;
import a.n92;
import a.p61;
import a.p80;
import a.q61;
import a.q80;
import a.t61;
import a.t81;
import a.u61;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.omarea.xposed.XposedCheck;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAppXposedDetails extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public iz0.a f5167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q61 f5168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5171a;
    public iz0.a b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5172b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5170a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f5169a = new b();

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppXposedDetails.this.u();
        }
    }

    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ActivityAppXposedDetails.this.f5168a = p61.f(iBinder);
            ActivityAppXposedDetails.this.y();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ActivityAppXposedDetails.this.f5168a = null;
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ActivityAppXposedDetails.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://vtools.omarea.com/")));
            } catch (Exception unused) {
                Toast.makeText(ActivityAppXposedDetails.this.getContext(), "启动在线页面失败！", 0).show();
            }
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppXposedDetails.this.w();
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                ActivityAppXposedDetails.this.v();
                ActivityAppXposedDetails.this.startActivity(ActivityAppXposedDetails.this.getPackageManager().getLaunchIntentForPackage(ActivityAppXposedDetails.this.s()));
            } catch (Exception unused) {
                Toast.makeText(ActivityAppXposedDetails.this.getApplicationContext(), ActivityAppXposedDetails.this.getString(u61.start_app_fail), 0).show();
            }
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            iz0.a aVarT = ActivityAppXposedDetails.this.t();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            aVarT.g(((Switch) view).isChecked());
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            iz0.a aVarT = ActivityAppXposedDetails.this.t();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            aVarT.h(((Switch) view).isChecked());
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            iz0.a aVarT = ActivityAppXposedDetails.this.t();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            aVarT.i(((Switch) view).isChecked());
        }
    }

    public static final class i implements View.OnClickListener {
        public i() {
        }

        /* JADX WARN: Type inference failed for: r2v6, types: [T, a.p80$b] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n92 n92Var = new n92();
            n92Var.f6891a = null;
            View viewInflate = ActivityAppXposedDetails.this.getLayoutInflater().inflate(2131558515, (ViewGroup) null);
            EditText editText = (EditText) viewInflate.findViewById(t61.input_dpi);
            editText.setFilters(new g31[]{new g31(0, 1, null)});
            if (ActivityAppXposedDetails.this.t().a() >= 96) {
                editText.setText(String.valueOf(ActivityAppXposedDetails.this.t().a()));
            }
            p80.a aVar = p80.f2403a;
            ActivityAppXposedDetails activityAppXposedDetails = ActivityAppXposedDetails.this;
            String string = activityAppXposedDetails.getString(u61.xp_dpi_input);
            f92.c(string, "getString(R.string.xp_dpi_input)");
            String string2 = ActivityAppXposedDetails.this.getString(2131886519);
            f92.c(string2, "getString(R.string.btn_confirm)");
            q80 q80Var = new q80(string2, new t81(this, editText, n92Var), false);
            String string3 = ActivityAppXposedDetails.this.getString(2131886518);
            f92.c(string3, "getString(R.string.btn_cancel)");
            n92Var.f6891a = aVar.f(activityAppXposedDetails, string, "", viewInflate, q80Var, new q80(string3, null, false, 6, null));
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5171a == null) {
            this.f5171a = new HashMap();
        }
        View view = (View) this.f5171a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5171a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        x();
    }

    public final void o() {
        x();
        try {
            Intent intent = new Intent();
            intent.setAction("com.omarea.vaddin.ConfigUpdateService");
            intent.setComponent(new ComponentName("com.omarea.vaddin", "com.omarea.vaddin.ConfigUpdateService"));
            if (bindService(intent, this.f5169a, 1)) {
            } else {
                throw new Exception("");
            }
        } catch (Exception unused) {
            Toast.makeText(getApplicationContext(), getString(u61.xp_self_start_fail), 1).show();
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        TextView textView;
        String string;
        super.onCreate(bundle);
        setContentView(2131558439);
        View viewFindViewById = findViewById(t61.toolbar);
        if (viewFindViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        }
        Toolbar toolbar = (Toolbar) viewFindViewById;
        setSupportActionBar(toolbar);
        d0 supportActionBar = getSupportActionBar();
        f92.b(supportActionBar);
        supportActionBar.t(true);
        d0 supportActionBar2 = getSupportActionBar();
        f92.b(supportActionBar2);
        supportActionBar2.s(true);
        toolbar.setNavigationOnClickListener(new d());
        f92.c(getSharedPreferences(hz0.f1282a.H(), 0), "getSharedPreferences(Spf…PF, Context.MODE_PRIVATE)");
        if (getIntent() != null) {
            Intent intent = getIntent();
            f92.c(intent, "this.intent");
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("app")) {
                String string2 = extras.getString("app");
                f92.b(string2);
                this.f5170a = string2;
                hz0.f1282a.b0();
                ((ImageView) _$_findCachedViewById(t61.app_details_icon)).setOnClickListener(new e());
                this.f5167a = new iz0.a(this.f5170a);
                this.b = new iz0.a(this.f5170a);
                iz0.a aVar = this.f5167a;
                if (aVar == null) {
                    f92.m("sceneConfigInfo");
                    throw null;
                }
                if (aVar.a() >= 96) {
                    TextView textView2 = (TextView) _$_findCachedViewById(t61.app_details_dpi);
                    f92.c(textView2, "app_details_dpi");
                    iz0.a aVar2 = this.f5167a;
                    if (aVar2 == null) {
                        f92.m("sceneConfigInfo");
                        throw null;
                    }
                    textView2.setText(String.valueOf(aVar2.a()));
                }
                ((Switch) _$_findCachedViewById(t61.app_details_excludetask)).setOnClickListener(new f());
                ((Switch) _$_findCachedViewById(t61.app_details_scrollopt)).setOnClickListener(new g());
                ((Switch) _$_findCachedViewById(t61.app_details_web_debug)).setOnClickListener(new h());
                if (XposedCheck.xposedIsRunning()) {
                    iz0.a aVar3 = this.f5167a;
                    if (aVar3 == null) {
                        f92.m("sceneConfigInfo");
                        throw null;
                    }
                    if (aVar3.a() >= 96) {
                        textView = (TextView) _$_findCachedViewById(t61.app_details_dpi);
                        f92.c(textView, "app_details_dpi");
                        iz0.a aVar4 = this.f5167a;
                        if (aVar4 == null) {
                            f92.m("sceneConfigInfo");
                            throw null;
                        }
                        string = String.valueOf(aVar4.a());
                    } else {
                        textView = (TextView) _$_findCachedViewById(t61.app_details_dpi);
                        f92.c(textView, "app_details_dpi");
                        string = getString(u61._default);
                    }
                    textView.setText(string);
                    ((TextView) _$_findCachedViewById(t61.app_details_dpi)).setOnClickListener(new i());
                    return;
                }
                return;
            }
        }
        setResult(this.f8551a, getIntent());
        finish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        f92.d(menu, "menu");
        getMenuInflater().inflate(2131623944, menu);
        return true;
    }

    @Override // a.v0, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        w();
        return false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f92.d(menuItem, "item");
        if (menuItem.getItemId() == 2131361930) {
            w();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // a.g91, a.cl, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onResume() {
        PackageInfo packageInfo;
        super.onResume();
        p();
        try {
            packageInfo = getPackageManager().getPackageInfo(this.f5170a, 0);
        } catch (Exception unused) {
            Toast.makeText(getApplicationContext(), getString(u61.xp_app_uninstalled), 0).show();
            packageInfo = null;
        }
        if (packageInfo == null) {
            finish();
            return;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        TextView textView = (TextView) _$_findCachedViewById(t61.app_details_name);
        f92.c(textView, "app_details_name");
        textView.setText(applicationInfo.loadLabel(getPackageManager()));
        TextView textView2 = (TextView) _$_findCachedViewById(t61.app_details_packagename);
        f92.c(textView2, "app_details_packagename");
        textView2.setText(packageInfo.packageName);
        ((ImageView) _$_findCachedViewById(t61.app_details_icon)).setImageDrawable(applicationInfo.loadIcon(getPackageManager()));
    }

    public final void p() {
        boolean zXposedIsRunning = XposedCheck.xposedIsRunning();
        TextView textView = (TextView) _$_findCachedViewById(t61.app_details_vaddins_notactive);
        f92.c(textView, "app_details_vaddins_notactive");
        textView.setVisibility(zXposedIsRunning ? 8 : 0);
        try {
            boolean z = getPackageManager().getPackageInfo("com.omarea.vaddin", 0) != null;
            this.f5172b = z;
            zXposedIsRunning = zXposedIsRunning && z;
        } catch (Exception unused) {
            this.f5172b = false;
        }
        ((TextView) _$_findCachedViewById(t61.app_details_vaddins_notinstall)).setOnClickListener(new a());
        if (this.f5172b && r() < q()) {
            u();
        } else if (this.f5172b) {
            TextView textView2 = (TextView) _$_findCachedViewById(t61.app_details_vaddins_notinstall);
            f92.c(textView2, "app_details_vaddins_notinstall");
            textView2.setVisibility(8);
            if (this.f5168a == null) {
                o();
            } else {
                y();
            }
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(t61.app_details_vaddins_notinstall);
            f92.c(textView3, "app_details_vaddins_notinstall");
            textView3.setVisibility(0);
        }
        TextView textView4 = (TextView) _$_findCachedViewById(t61.app_details_vaddins_notactive);
        f92.c(textView4, "app_details_vaddins_notactive");
        textView4.setVisibility(XposedCheck.xposedIsRunning() ? 8 : 0);
        TextView textView5 = (TextView) _$_findCachedViewById(t61.app_details_dpi);
        f92.c(textView5, "app_details_dpi");
        textView5.setEnabled(zXposedIsRunning);
        Switch r1 = (Switch) _$_findCachedViewById(t61.app_details_excludetask);
        f92.c(r1, "app_details_excludetask");
        r1.setEnabled(zXposedIsRunning);
        Switch r12 = (Switch) _$_findCachedViewById(t61.app_details_scrollopt);
        f92.c(r12, "app_details_scrollopt");
        r12.setEnabled(zXposedIsRunning);
        Switch r13 = (Switch) _$_findCachedViewById(t61.app_details_web_debug);
        f92.c(r13, "app_details_web_debug");
        r13.setEnabled(zXposedIsRunning);
    }

    public final int q() {
        return getResources().getInteger(2131427330);
    }

    public final int r() {
        try {
            return getPackageManager().getPackageInfo("com.omarea.vaddin", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final String s() {
        return this.f5170a;
    }

    public final iz0.a t() {
        iz0.a aVar = this.f5167a;
        if (aVar != null) {
            return aVar;
        }
        f92.m("sceneConfigInfo");
        throw null;
    }

    public final void u() {
        p80.a aVar = p80.f2403a;
        Context context = getContext();
        String string = getString(u61.scene_addin_miss);
        f92.c(string, "getString(R.string.scene_addin_miss)");
        String string2 = getString(u61.scene_addin_miss_desc);
        f92.c(string2, "getString(R.string.scene_addin_miss_desc)");
        aVar.M(context, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new c(), (16 & 16) != 0 ? null : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v() {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppXposedDetails.v():void");
    }

    public final void w() {
        v();
        finish();
    }

    public final void x() {
        try {
            if (this.f5168a != null) {
                unbindService(this.f5169a);
                this.f5168a = null;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x003a, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y() {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppXposedDetails.y():void");
    }
}
