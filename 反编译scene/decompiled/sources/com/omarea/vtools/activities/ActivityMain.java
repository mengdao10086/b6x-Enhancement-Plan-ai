package com.omarea.vtools.activities;

import a.b62;
import a.bx1;
import a.d72;
import a.e50;
import a.e60;
import a.et1;
import a.f92;
import a.g91;
import a.h42;
import a.hn1;
import a.ho0;
import a.hz0;
import a.jl;
import a.k82;
import a.ke2;
import a.kv1;
import a.m42;
import a.qc2;
import a.qe2;
import a.qo1;
import a.r62;
import a.t61;
import a.u42;
import a.u61;
import a.w20;
import a.wd2;
import a.wu0;
import a.x31;
import a.x62;
import a.xd2;
import a.yb;
import a.zo0;
import a.zs1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.omarea.Scene;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityMain extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8732a;

    @x62(c = "com.omarea.vtools.activities.ActivityMain$onCreate$1", f = "ActivityMain.kt", l = {99}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8733a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5334a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = ActivityMain.this.new a(b62Var);
            aVar.f8733a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            String strQ;
            int iHashCode;
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8733a;
                if (e50.f677a.r0() && f92.a(e50.f677a.y0(), "root")) {
                    e50 e50Var = e50.f677a;
                    this.f5334a = wd2Var;
                    this.b = 1;
                    obj = e50Var.L0(this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                return m42.f6769a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            if (!((Boolean) obj).booleanValue()) {
                e50.f677a.R();
            }
            wu0.f3480a.q().e();
            String strA = hz0.f1282a.a();
            if (strA != null) {
                if ((strA.length() > 0) && ((iHashCode = (strQ = e50.f677a.Q(strA)).hashCode()) == -1309235419 ? strQ.equals("expired") : !(iHashCode == 1959784951 ? !strQ.equals("invalid") : iHashCode != 2127581733 || !strQ.equals("not-you")))) {
                    Scene.c.p(Scene.f4798a, ActivityMain.this.getString(u61.license_expired) + " [" + strQ + ']', 0, 2, null);
                    hz0.f1282a.D0(null);
                    hz0.f1282a.E0(null);
                }
            }
            if (e60.f698a.n() && e60.m()) {
                e60.f698a.r(Scene.f4798a.c());
            }
            return m42.f6769a;
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityMain.this.k();
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new qo1(ActivityMain.this).b();
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityMain.this.startActivity(new Intent(ActivityMain.this.getApplicationContext(), (Class<?>) ActivityOtherSettings.class));
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityMain$onResume$1", f = "ActivityMain.kt", l = {184}, m = "invokeSuspend")
    public static final class e extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8737a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5336a;
        public int b;

        public e(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            e eVar = ActivityMain.this.new e(b62Var);
            eVar.f8737a = (wd2) obj;
            return eVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((e) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            try {
                if (i == 0) {
                    h42.b(obj);
                    this.f5336a = this.f8737a;
                    this.b = 1;
                    if (ke2.a(3000L, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                }
                new ho0(ActivityMain.this.getContext()).J();
            } catch (Exception unused) {
            }
            return m42.f6769a;
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f8732a == null) {
            this.f8732a = new HashMap();
        }
        View view = (View) this.f8732a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f8732a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void k() {
        if (!u42.k(new String[]{"adb", "root"}, e50.f677a.y0())) {
            Toast.makeText(this, getString(u61.only_adb_or_root_mode), 0).show();
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)) {
            hn1 hn1Var = new hn1(this);
            hn1Var.a();
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        Toast.makeText(getApplicationContext(), getString(u61.permission_float), 1).show();
    }

    @Override // a.g91, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            jl supportFragmentManager = getSupportFragmentManager();
            f92.c(supportFragmentManager, "supportFragmentManager");
            if (supportFragmentManager.d() > 0) {
                getSupportFragmentManager().g();
            } else {
                excludeFromRecent();
                super.onBackPressed();
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ActivityStartSplash.f8870a.a() || (f92.a(e50.f677a.y0(), "adb") && !e50.f677a.r0())) {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) ActivityStartSplash.class);
            intent.addFlags(65536);
            intent.addFlags(1073741824);
            startActivity(intent);
            finish();
            return;
        }
        setContentView(2131558454);
        setSupportActionBar((Toolbar) findViewById(t61.toolbar));
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(t61.tab_list);
        f92.c(tabLayout, "tab_list");
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(t61.tab_content);
        f92.c(viewPager, "tab_content");
        jl supportFragmentManager = getSupportFragmentManager();
        f92.c(supportFragmentManager, "supportFragmentManager");
        x31 x31Var = new x31(tabLayout, viewPager, this, supportFragmentManager, 2131558638);
        String string = getString(u61.app_nav);
        f92.c(string, "getString(R.string.app_nav)");
        Drawable drawableD = yb.d(getContext(), 2131230820);
        f92.b(drawableD);
        f92.c(drawableD, "ContextCompat.getDrawabl…t, R.drawable.app_menu)!!");
        x31Var.g(string, drawableD, et1.f6040a.a(getThemeMode()));
        String string2 = getString(u61.app_home);
        f92.c(string2, "getString(R.string.app_home)");
        Drawable drawableD2 = yb.d(getContext(), 2131230818);
        f92.b(drawableD2);
        f92.c(drawableD2, "ContextCompat.getDrawabl…t, R.drawable.app_home)!!");
        x31Var.g(string2, drawableD2, new zs1());
        if (f92.a(e50.f677a.y0(), "root")) {
            String string3 = getString(u61.app_tuner);
            f92.c(string3, "getString(R.string.app_tuner)");
            Drawable drawableD3 = yb.d(getContext(), 2131230840);
            f92.b(drawableD3);
            f92.c(drawableD3, "ContextCompat.getDrawabl….drawable.app_settings)!!");
            x31Var.g(string3, drawableD3, new kv1());
            if (new w20(this).c()) {
                String string4 = getString(u61.app_user);
                f92.c(string4, "getString(R.string.app_user)");
                Drawable drawableD4 = yb.d(getContext(), 2131230841);
                f92.b(drawableD4);
                f92.c(drawableD4, "ContextCompat.getDrawabl…t, R.drawable.app_user)!!");
                x31Var.g(string4, drawableD4, new bx1());
            }
        }
        if (f92.a(e50.f677a.y0(), "basic")) {
            ImageButton imageButton = (ImageButton) _$_findCachedViewById(t61.action_graph);
            f92.c(imageButton, "action_graph");
            imageButton.setVisibility(8);
            ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(t61.action_power);
            f92.c(imageButton2, "action_power");
            imageButton2.setVisibility(8);
        }
        ViewPager viewPager2 = (ViewPager) _$_findCachedViewById(t61.tab_content);
        f92.c(viewPager2, "tab_content");
        viewPager2.setOffscreenPageLimit(4);
        ViewPager viewPager3 = (ViewPager) _$_findCachedViewById(t61.tab_content);
        f92.c(viewPager3, "tab_content");
        viewPager3.setAdapter(x31Var.f());
        TabLayout.g gVarU = ((TabLayout) _$_findCachedViewById(t61.tab_list)).u(1);
        if (gVarU != null) {
            gVarU.k();
        }
        try {
            qc2.d(xd2.a(qe2.b()), null, null, new a(null), 3, null);
        } catch (Exception unused) {
        }
        ((ImageButton) _$_findCachedViewById(t61.action_graph)).setOnClickListener(new b());
        ((ImageButton) _$_findCachedViewById(t61.action_power)).setOnClickListener(new c());
        ((ImageButton) _$_findCachedViewById(t61.action_settings)).setOnClickListener(new d());
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        jl supportFragmentManager = getSupportFragmentManager();
        f92.c(supportFragmentManager, "supportFragmentManager");
        supportFragmentManager.f().clear();
        super.onDestroy();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // a.cl, android.app.Activity, a.va.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        f92.d(strArr, "permissions");
        f92.d(iArr, "grantResults");
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Scene.f4798a.g().getLong(hz0.f1282a.S(), 0L) + ((long) 43200000) < System.currentTimeMillis()) {
            if (Scene.f4798a.g().getBoolean("get_next_release", false)) {
                new zo0().c(this, 8);
            } else {
                zo0.d(new zo0(), this, 0, 2, null);
            }
            Scene.f4798a.g().edit().putLong(hz0.f1282a.S(), System.currentTimeMillis()).apply();
        }
        if (e50.f677a.r0() && f92.a(e50.f677a.y0(), "root") && Scene.f4798a.g().getLong(hz0.f1282a.P(), 0L) + ((long) 259200000) < System.currentTimeMillis()) {
            qc2.d(xd2.a(qe2.b()), null, null, new e(null), 3, null);
            Scene.f4798a.g().edit().putLong(hz0.f1282a.P(), System.currentTimeMillis()).apply();
        }
    }
}
