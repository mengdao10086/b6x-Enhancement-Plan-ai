package com.omarea.vtools.activities;

import a.a42;
import a.aa0;
import a.az0;
import a.ck1;
import a.d0;
import a.ec2;
import a.ez0;
import a.f92;
import a.fj0;
import a.fz0;
import a.g50;
import a.g82;
import a.g91;
import a.g92;
import a.gz0;
import a.h81;
import a.hz0;
import a.i52;
import a.i81;
import a.j81;
import a.k81;
import a.l81;
import a.m42;
import a.m81;
import a.m90;
import a.n30;
import a.p80;
import a.pt0;
import a.ri0;
import a.s61;
import a.so1;
import a.t61;
import a.u61;
import a.uj1;
import a.v72;
import a.wr0;
import a.xp0;
import a.yk0;
import a.z32;
import a.z42;
import a.z90;
import a.zg0;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.omarea.Scene;
import com.omarea.model.SceneConfigInfo;
import com.omarea.ui.BlurViewLinearLayout;
import com.omarea.ui.SeekBar;
import com.omarea.ui.Tags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAppDetails extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pt0 f5140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SharedPreferences f5144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SceneConfigInfo f5145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<g50> f5148a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5146a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ez0 f5139a = new ez0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ri0 f5141a = new ri0(Scene.f4798a.c());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wr0 f5142a = new wr0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f5143a = a42.a(new a());

    public static final class a extends g92 implements v72<Boolean> {
        public a() {
            super(0);
        }

        public final boolean a() {
            return new zg0().a(ActivityAppDetails.this);
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Boolean i() {
            return Boolean.valueOf(a());
        }
    }

    public static final class b implements m90 {
        public b() {
        }

        @Override // a.m90
        public void a(List<n30> list, boolean[] zArr) {
            f92.d(list, "selected");
            f92.d(zArr, "status");
            ArraySet arraySet = new ArraySet();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arraySet.add(((n30) it.next()).e());
            }
            gz0 gz0Var = new gz0(ActivityAppDetails.this.getContext());
            String str = ActivityAppDetails.this.C().packageName;
            f92.c(str, "sceneConfigInfo.packageName");
            gz0Var.c(str, arraySet);
            ArrayList arrayList = new ArrayList(z42.m(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(((n30) it2.next()).d());
            }
            String strH = i52.H(arrayList, "\n\n", null, null, 0, null, null, 62, null);
            if (strH == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String string = ec2.r0(strH).toString();
            TextView textView = (TextView) ActivityAppDetails.this._$_findCachedViewById(t61.task_custom_actions);
            f92.c(textView, "task_custom_actions");
            textView.setText(string);
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!new xp0().a(ActivityAppDetails.this)) {
                new xp0().b(ActivityAppDetails.this);
                Toast.makeText(ActivityAppDetails.this.getApplicationContext(), ActivityAppDetails.this.getString(u61.scene_need_write_sys_settings), 0).show();
                if (view == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
                }
                ((Switch) view).setChecked(!r5.isChecked());
                return;
            }
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            boolean zIsChecked = ((Switch) view).isChecked();
            if (zIsChecked) {
                Switch r0 = (Switch) ActivityAppDetails.this._$_findCachedViewById(t61.app_details_hidestatus);
                f92.c(r0, "app_details_hidestatus");
                if (r0.isChecked()) {
                    ActivityAppDetails.this.z().a(ActivityAppDetails.this.y());
                    return;
                }
            }
            if (zIsChecked) {
                ActivityAppDetails.this.z().b(ActivityAppDetails.this.y());
            } else {
                ActivityAppDetails.this.z().j(ActivityAppDetails.this.y());
            }
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!new xp0().a(ActivityAppDetails.this)) {
                new xp0().b(ActivityAppDetails.this);
                Toast.makeText(ActivityAppDetails.this.getApplicationContext(), ActivityAppDetails.this.getString(u61.scene_need_write_sys_settings), 0).show();
                if (view == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
                }
                ((Switch) view).setChecked(!r5.isChecked());
                return;
            }
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            boolean zIsChecked = ((Switch) view).isChecked();
            if (zIsChecked) {
                Switch r0 = (Switch) ActivityAppDetails.this._$_findCachedViewById(t61.app_details_hidenav);
                f92.c(r0, "app_details_hidenav");
                if (r0.isChecked()) {
                    ActivityAppDetails.this.z().a(ActivityAppDetails.this.y());
                    return;
                }
            }
            if (zIsChecked) {
                ActivityAppDetails.this.z().c(ActivityAppDetails.this.y());
            } else {
                ActivityAppDetails.this.z().k(ActivityAppDetails.this.y());
            }
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                ActivityAppDetails.this.F();
                ActivityAppDetails.this.startActivity(ActivityAppDetails.this.getPackageManager().getLaunchIntentForPackage(ActivityAppDetails.this.y()));
            } catch (Exception unused) {
                Toast.makeText(ActivityAppDetails.this.getApplicationContext(), ActivityAppDetails.this.getString(u61.start_app_fail), 0).show();
            }
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (new yk0().a(ActivityAppDetails.this)) {
                SceneConfigInfo sceneConfigInfoC = ActivityAppDetails.this.C();
                if (view == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
                }
                sceneConfigInfoC.disNotice = ((Switch) view).isChecked();
                return;
            }
            new yk0().b(ActivityAppDetails.this);
            Toast.makeText(ActivityAppDetails.this.getApplicationContext(), ActivityAppDetails.this.getString(u61.scene_need_notic_listing), 0).show();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            ((Switch) view).setChecked(!r5.isChecked());
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppDetails activityAppDetails = ActivityAppDetails.this;
            new uj1(activityAppDetails, Integer.valueOf(activityAppDetails.C().screenOrientation), new h81(this, view)).c();
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (new xp0().a(ActivityAppDetails.this)) {
                SceneConfigInfo sceneConfigInfoC = ActivityAppDetails.this.C();
                if (view == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
                }
                sceneConfigInfoC.aloneLight = ((Switch) view).isChecked();
                return;
            }
            new xp0().b(ActivityAppDetails.this);
            Toast.makeText(ActivityAppDetails.this.getApplicationContext(), ActivityAppDetails.this.getString(u61.scene_need_write_sys_settings), 0).show();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            ((Switch) view).setChecked(false);
        }
    }

    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SceneConfigInfo sceneConfigInfoC = ActivityAppDetails.this.C();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            sceneConfigInfoC.gpsOn = ((Switch) view).isChecked();
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SceneConfigInfo sceneConfigInfoC = ActivityAppDetails.this.C();
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
            }
            sceneConfigInfoC.showMonitor = ((Switch) view).isChecked();
        }
    }

    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppDetails.this.w();
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppDetails.this.startActivity(new Intent(ActivityAppDetails.this, (Class<?>) ActivityCommandList.class));
        }
    }

    public static final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppDetails.this.G();
        }
    }

    public static final class n implements View.OnClickListener {
        public n() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == 0) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Checkable");
            }
            boolean zIsChecked = ((Checkable) view).isChecked();
            LinearLayout linearLayout = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.scene_mode_config);
            f92.c(linearLayout, "scene_mode_config");
            linearLayout.setVisibility(zIsChecked ? 0 : 8);
            (zIsChecked ? ActivityAppDetails.o(ActivityAppDetails.this).edit().remove(ActivityAppDetails.this.y()) : ActivityAppDetails.o(ActivityAppDetails.this).edit().putBoolean(ActivityAppDetails.this.y(), true)).apply();
        }
    }

    public static final class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ActivityAppDetails.this.b) {
                SharedPreferences sharedPreferences = ActivityAppDetails.this.getSharedPreferences(hz0.f1282a.l0(), 0);
                ActivityAppDetails activityAppDetails = ActivityAppDetails.this;
                ck1.d(new ck1(activityAppDetails, sharedPreferences.getString(activityAppDetails.y(), ""), new i81(this, sharedPreferences, view)), false, false, 3, null);
            } else {
                p80.a aVar = p80.f2403a;
                ActivityAppDetails activityAppDetails2 = ActivityAppDetails.this;
                String string = activityAppDetails2.getString(u61.detail_dynamic_required);
                f92.c(string, "getString(R.string.detail_dynamic_required)");
                p80.a.C(aVar, activityAppDetails2, string, null, 4, null);
            }
        }
    }

    public static final class p extends g92 implements g82<fj0, m42> {
        public p() {
            super(1);
        }

        public final void a(fj0 fj0Var) {
            f92.d(fj0Var, "it");
            ActivityAppDetails.this.c = fj0Var.g() == 1;
            Switch r7 = (Switch) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_enable);
            f92.c(r7, "app_fas_enable");
            r7.setEnabled(ActivityAppDetails.this.c);
            ActivityAppDetails.this.f5141a.f(ActivityAppDetails.this.y(), ActivityAppDetails.this.c);
            if (ActivityAppDetails.this.c) {
                LinearLayout linearLayout = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_refresh_rate_min);
                f92.c(linearLayout, "app_refresh_rate_min");
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_adjust);
                f92.c(linearLayout2, "app_fas_adjust");
                Switch r2 = (Switch) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_enable);
                f92.c(r2, "app_fas_enable");
                linearLayout2.setVisibility(r2.isChecked() ? 0 : 8);
            } else {
                LinearLayout linearLayout3 = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_refresh_rate_min);
                f92.c(linearLayout3, "app_refresh_rate_min");
                LinearLayout linearLayout4 = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_refresh_rate_max);
                f92.c(linearLayout4, "app_refresh_rate_max");
                linearLayout3.setVisibility(linearLayout4.getVisibility());
                LinearLayout linearLayout5 = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_adjust);
                f92.c(linearLayout5, "app_fas_adjust");
                linearLayout5.setVisibility(8);
            }
            if (ActivityAppDetails.this.B()) {
                LinearLayout linearLayout6 = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_offset);
                f92.c(linearLayout6, "app_fas_offset");
                LinearLayout linearLayout7 = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_adjust);
                f92.c(linearLayout7, "app_fas_adjust");
                linearLayout6.setVisibility(linearLayout7.getVisibility());
            }
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(fj0 fj0Var) {
            a(fj0Var);
            return m42.f6769a;
        }
    }

    public static final class q implements CompoundButton.OnCheckedChangeListener {
        public q() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            LinearLayout linearLayout = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_adjust);
            f92.c(linearLayout, "app_fas_adjust");
            linearLayout.setVisibility(z ? 0 : 8);
            if (ActivityAppDetails.this.B()) {
                LinearLayout linearLayout2 = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_offset);
                f92.c(linearLayout2, "app_fas_offset");
                LinearLayout linearLayout3 = (LinearLayout) ActivityAppDetails.this._$_findCachedViewById(t61.app_fas_adjust);
                f92.c(linearLayout3, "app_fas_adjust");
                linearLayout2.setVisibility(linearLayout3.getVisibility());
            }
        }
    }

    public static final class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppDetails activityAppDetails = ActivityAppDetails.this;
            so1 so1Var = new so1(activityAppDetails, activityAppDetails.f5139a.e());
            az0 az0VarD = ActivityAppDetails.this.f5139a.d(ActivityAppDetails.this.y());
            so1Var.a(az0VarD != null ? Integer.valueOf(az0VarD.b()) : null, new l81(this));
        }
    }

    public static final class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppDetails activityAppDetails = ActivityAppDetails.this;
            so1 so1Var = new so1(activityAppDetails, activityAppDetails.f5139a.e());
            az0 az0VarD = ActivityAppDetails.this.f5139a.d(ActivityAppDetails.this.y());
            so1Var.a(az0VarD != null ? Integer.valueOf(az0VarD.a()) : null, new m81(this));
        }
    }

    public static final /* synthetic */ SharedPreferences o(ActivityAppDetails activityAppDetails) {
        SharedPreferences sharedPreferences = activityAppDetails.f5144a;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        f92.m("sceneBlackList");
        throw null;
    }

    public final boolean A() {
        wr0 wr0Var = this.f5142a;
        SceneConfigInfo sceneConfigInfo = this.f5145a;
        if (sceneConfigInfo == null) {
            f92.m("sceneConfigInfo");
            throw null;
        }
        String str = sceneConfigInfo.packageName;
        f92.c(str, "sceneConfigInfo.packageName");
        return wr0Var.k(str);
    }

    public final boolean B() {
        return this.f5142a.h();
    }

    public final SceneConfigInfo C() {
        SceneConfigInfo sceneConfigInfo = this.f5145a;
        if (sceneConfigInfo != null) {
            return sceneConfigInfo;
        }
        f92.m("sceneConfigInfo");
        throw null;
    }

    public final void D() {
        az0 az0VarD = this.f5139a.d(this.f5146a);
        if (az0VarD == null) {
            TextView textView = (TextView) _$_findCachedViewById(t61.app_refresh_rate_min_btn);
            f92.c(textView, "app_refresh_rate_min_btn");
            textView.setText(getString(u61._default));
            TextView textView2 = (TextView) _$_findCachedViewById(t61.app_refresh_rate_max_btn);
            f92.c(textView2, "app_refresh_rate_max_btn");
            textView2.setText(getString(u61._default));
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(t61.app_refresh_rate_min_btn);
        f92.c(textView3, "app_refresh_rate_min_btn");
        textView3.setText(az0VarD.b() + "Hz");
        TextView textView4 = (TextView) _$_findCachedViewById(t61.app_refresh_rate_max_btn);
        f92.c(textView4, "app_refresh_rate_max_btn");
        textView4.setText(az0VarD.a() + "Hz");
    }

    public final void E(String str, String str2) {
        if (x()) {
            z90 z90Var = z90.f8048a;
            aa0 aa0Var = aa0.SCENE_APP_CONFIG;
            HashMap<String, Object> map = new HashMap<>();
            map.put("app", str);
            if (str2 != null) {
                map.put("mode", str2);
            }
            m42 m42Var = m42.f6769a;
            z90Var.a(aa0Var, map);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppDetails.F():void");
    }

    public final void G() {
        F();
        finish();
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5147a == null) {
            this.f5147a = new HashMap();
        }
        View view = (View) this.f5147a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5147a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558436);
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
        toolbar.setNavigationOnClickListener(new m());
        if (getIntent() == null) {
            setResult(this.f8518a, getIntent());
            finish();
            return;
        }
        Intent intent = getIntent();
        f92.c(intent, "this.intent");
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("app")) {
            setResult(this.f8518a, getIntent());
            finish();
            return;
        }
        String string = extras.getString("app");
        f92.b(string);
        this.f5146a = string;
        if (f92.a(string, "android") || f92.a(this.f5146a, "com.android.systemui") || f92.a(this.f5146a, "com.android.webview") || f92.a(this.f5146a, "mokee.platform") || f92.a(this.f5146a, "com.miui.rom")) {
            BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.app_details_perf);
            f92.c(blurViewLinearLayout, "app_details_perf");
            blurViewLinearLayout.setVisibility(8);
            BlurViewLinearLayout blurViewLinearLayout2 = (BlurViewLinearLayout) _$_findCachedViewById(t61.app_details_auto);
            f92.c(blurViewLinearLayout2, "app_details_auto");
            blurViewLinearLayout2.setVisibility(8);
            BlurViewLinearLayout blurViewLinearLayout3 = (BlurViewLinearLayout) _$_findCachedViewById(t61.app_details_assist);
            f92.c(blurViewLinearLayout3, "app_details_assist");
            blurViewLinearLayout3.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.scene_mode_config);
            f92.c(linearLayout, "scene_mode_config");
            linearLayout.setVisibility(8);
            Switch r4 = (Switch) _$_findCachedViewById(t61.scene_mode_allow);
            f92.c(r4, "scene_mode_allow");
            r4.setVisibility(8);
        } else if (Build.VERSION.SDK_INT >= 29) {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(t61.app_details_immerse);
            f92.c(linearLayout2, "app_details_immerse");
            linearLayout2.setVisibility(8);
        }
        SharedPreferences sharedPreferences = getSharedPreferences(hz0.f1282a.m0(), 0);
        f92.c(sharedPreferences, "getSharedPreferences(Spf…ST, Context.MODE_PRIVATE)");
        this.f5144a = sharedPreferences;
        ((Switch) _$_findCachedViewById(t61.scene_mode_allow)).setOnClickListener(new n());
        ContentResolver contentResolver = getContentResolver();
        f92.c(contentResolver, "contentResolver");
        this.f5140a = new pt0(contentResolver);
        this.b = hz0.f1282a.b0();
        ((TextView) _$_findCachedViewById(t61.app_details_dynamic)).setOnClickListener(new o());
        this.c = f92.a(this.f5141a.d(this.f5146a), Boolean.TRUE);
        Switch r42 = (Switch) _$_findCachedViewById(t61.app_fas_enable);
        f92.c(r42, "app_fas_enable");
        r42.setEnabled(this.c);
        ((Tags) _$_findCachedViewById(t61.app_category)).b(getContext().getResources().getStringArray(s61.detail_categories), this.c ? 1 : 0).j(new p());
        ((Switch) _$_findCachedViewById(t61.app_fas_enable)).setOnCheckedChangeListener(new q());
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(t61.app_fas_adjust_fps);
        int iF = this.f5142a.f(this.f5146a);
        seekBar.setTag(Integer.valueOf(iF));
        seekBar.setFormatter(j81.f6486a);
        seekBar.setProgress(iF);
        SeekBar seekBar2 = (SeekBar) _$_findCachedViewById(t61.app_fas_adjust_offset);
        seekBar2.setFormatter(k81.f6584a);
        int iIntValue = this.f5142a.g(this.f5146a) != null ? r1.intValue() - 50 : 0;
        seekBar2.setTag(Integer.valueOf(iIntValue));
        seekBar2.setProgress(iIntValue);
        ((TextView) _$_findCachedViewById(t61.app_refresh_rate_min_btn)).setOnClickListener(new r());
        ((TextView) _$_findCachedViewById(t61.app_refresh_rate_max_btn)).setOnClickListener(new s());
        ((Switch) _$_findCachedViewById(t61.app_details_hidenav)).setOnClickListener(new c());
        ((Switch) _$_findCachedViewById(t61.app_details_hidestatus)).setOnClickListener(new d());
        ((ImageView) _$_findCachedViewById(t61.app_details_icon)).setOnClickListener(new e());
        SceneConfigInfo sceneConfigInfoB = new fz0(this).b(this.f5146a);
        f92.c(sceneConfigInfoB, "SceneConfigStore(this).getAppConfig(app)");
        this.f5145a = sceneConfigInfoB;
        if (Build.VERSION.SDK_INT <= 21) {
            Switch r43 = (Switch) _$_findCachedViewById(t61.app_details_hidenotice);
            f92.c(r43, "app_details_hidenotice");
            r43.setEnabled(false);
        } else {
            ((Switch) _$_findCachedViewById(t61.app_details_hidenotice)).setOnClickListener(new f());
        }
        ((TextView) _$_findCachedViewById(t61.scene_orientation)).setOnClickListener(new g());
        ((Switch) _$_findCachedViewById(t61.app_details_aloowlight)).setOnClickListener(new h());
        ((Switch) _$_findCachedViewById(t61.app_details_gps)).setOnClickListener(new i());
        ((Switch) _$_findCachedViewById(t61.app_monitor)).setOnClickListener(new j());
        ((ImageButton) _$_findCachedViewById(t61.custom_actions_add)).setOnClickListener(new k());
        ((ImageButton) _$_findCachedViewById(t61.custom_actions_list)).setOnClickListener(new l());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        f92.d(menu, "menu");
        return true;
    }

    @Override // a.v0, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        G();
        return false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f92.d(menuItem, "item");
        if (menuItem.getItemId() == 2131361930) {
            G();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0277  */
    @Override // a.g91, a.cl, android.app.Activity
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            Method dump skipped, instruction units count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppDetails.onResume():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w() {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppDetails.w():void");
    }

    public final boolean x() {
        return ((Boolean) this.f5143a.getValue()).booleanValue();
    }

    public final String y() {
        return this.f5146a;
    }

    public final pt0 z() {
        pt0 pt0Var = this.f5140a;
        if (pt0Var != null) {
            return pt0Var;
        }
        f92.m("immersivePolicyControl");
        throw null;
    }
}
