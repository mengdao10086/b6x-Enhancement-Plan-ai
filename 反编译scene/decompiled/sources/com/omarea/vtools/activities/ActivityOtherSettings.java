package com.omarea.vtools.activities;

import a.ac;
import a.c60;
import a.d41;
import a.e50;
import a.f92;
import a.g91;
import a.g92;
import a.gh1;
import a.hz0;
import a.i60;
import a.jd1;
import a.kd1;
import a.kk0;
import a.l90;
import a.ld1;
import a.m42;
import a.md1;
import a.n30;
import a.nd1;
import a.od1;
import a.p80;
import a.pd1;
import a.qd1;
import a.rd1;
import a.s90;
import a.sd1;
import a.sk0;
import a.t61;
import a.td1;
import a.tj0;
import a.u61;
import a.ud1;
import a.v72;
import a.vd1;
import a.wd1;
import a.y42;
import a.z50;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.ui.BlurViewLinearLayout;
import com.omarea.vtools.services.KeepAliveService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityOtherSettings extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8783a;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityOtherSettings.this.finishAffinity();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                ActivityOtherSettings.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://vtools.omarea.com/scene-policy.html")));
            } catch (Exception unused) {
                Toast.makeText(ActivityOtherSettings.this.getContext(), u61.home_browser_error, 0).show();
            }
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p80.a aVar = p80.f2403a;
            ActivityOtherSettings activityOtherSettings = ActivityOtherSettings.this;
            String string = activityOtherSettings.getString(u61.settings_upload);
            f92.c(string, "getString(R.string.settings_upload)");
            String string2 = ActivityOtherSettings.this.getString(u61.settings_upload_desc);
            f92.c(string2, "getString(R.string.settings_upload_desc)");
            aVar.i(activityOtherSettings, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new od1(this), (16 & 16) != 0 ? null : null);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p80.a aVar = p80.f2403a;
            ActivityOtherSettings activityOtherSettings = ActivityOtherSettings.this;
            String string = activityOtherSettings.getString(u61.settings_download);
            f92.c(string, "getString(R.string.settings_download)");
            String string2 = ActivityOtherSettings.this.getString(u61.settings_download_desc);
            f92.c(string2, "getString(R.string.settings_download_desc)");
            aVar.i(activityOtherSettings, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new pd1(this), (16 & 16) != 0 ? null : null);
        }
    }

    public static final class e extends g92 implements v72<m42> {
        public e() {
            super(0);
        }

        public final void a() {
            String str = c60.f5764a.e() + "/scene_" + ActivityOtherSettings.this.getPackageManager().getPackageInfo(Scene.f4798a.c().getPackageName(), 0).versionName + "_strings_%s.xml";
            n30 n30Var = new n30();
            Locale locale = Locale.SIMPLIFIED_CHINESE;
            f92.c(locale, "Locale.SIMPLIFIED_CHINESE");
            n30Var.i(locale.getDisplayName());
            String str2 = String.format(str, Arrays.copyOf(new Object[]{"zh"}, 1));
            f92.c(str2, "java.lang.String.format(this, *args)");
            n30Var.j(str2);
            n30Var.f(n30Var.e());
            m42 m42Var = m42.f6769a;
            n30 n30Var2 = new n30();
            Locale locale2 = Locale.ENGLISH;
            n30Var2.i(locale2.getDisplayName(locale2));
            String str3 = String.format(str, Arrays.copyOf(new Object[]{"en"}, 1));
            f92.c(str3, "java.lang.String.format(this, *args)");
            n30Var2.j(str3);
            n30Var2.f(n30Var2.e());
            m42 m42Var2 = m42.f6769a;
            ArrayList<n30> arrayListC = y42.c(n30Var, n30Var2);
            if (sk0.f7408a.a().c()) {
                n30 n30Var3 = new n30();
                n30Var3.i(ActivityOtherSettings.this.getString(u61.settings_language_package));
                String str4 = String.format(str, Arrays.copyOf(new Object[]{"override"}, 1));
                f92.c(str4, "java.lang.String.format(this, *args)");
                n30Var3.j(str4);
                n30Var3.f(n30Var3.e());
                m42 m42Var3 = m42.f6769a;
                arrayListC.add(n30Var3);
            }
            l90 l90VarA = l90.f6685a.a(ActivityOtherSettings.this, arrayListC, 0, new wd1(this, arrayListC));
            String string = ActivityOtherSettings.this.getString(u61.settings_language_package_export);
            f92.c(string, "getString(R.string.setti…_language_package_export)");
            l90VarA.m(string);
            l90VarA.o();
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ m42 i() {
            a();
            return m42.f6769a;
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f8783a == null) {
            this.f8783a = new HashMap();
        }
        View view = (View) this.f8783a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f8783a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final boolean k(Context context, String str) {
        return ac.b(context, str) == 0;
    }

    public final String l() {
        return c60.f5764a.d(getContext(), "windowBg.jpg");
    }

    public final boolean m() {
        Context applicationContext = getApplicationContext();
        f92.c(applicationContext, "this.applicationContext");
        if (k(applicationContext, "android.permission.READ_EXTERNAL_STORAGE")) {
            Context applicationContext2 = getApplicationContext();
            f92.c(applicationContext2, "this.applicationContext");
            if (k(applicationContext2, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
        }
        return false;
    }

    public final void n() {
        if (Scene.f4798a.b(hz0.f1282a.D(), hz0.f1282a.E())) {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) KeepAliveService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
        }
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws XmlPullParserException, IOException {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 9999) {
                f92.b(intent);
                String stringExtra = intent.getStringExtra("file");
                f92.b(stringExtra);
                f92.c(stringExtra, "data!!.getStringExtra(\"file\")!!");
                String strH = sk0.f7408a.a().h(new File(stringExtra));
                if (strH != null) {
                    p80.f2403a.y(this, "模板占位符错误", "翻译时，应检查和保留 %s %d %.?f 等字符串占位符，并且不改变出现顺序。\nWhen translating a string, string placeholders such as %s %d %.?f should be checked and preserved without changing the order of occurrence.\n\n" + strH, new a());
                    return;
                }
                return;
            }
            if (i == 222) {
                Bitmap bitmapA = i60.a(getContext(), intent != null ? intent.getData() : null);
                if (bitmapA != null) {
                    Window window = getWindow();
                    f92.c(window, "window");
                    View decorView = window.getDecorView();
                    f92.c(decorView, "window.decorView");
                    int height = decorView.getHeight();
                    if (bitmapA.getHeight() > height) {
                        bitmapA = new z50().a(bitmapA, height);
                        f92.c(bitmapA, "BitmapUtil().bitmapZoomByHeight(file, h.toFloat())");
                    }
                    new z50().e(s90.c(bitmapA, Float.valueOf(1 / gh1.f1013a.c())), l(), Boolean.FALSE);
                    Scene.f4798a.g().edit().putInt(hz0.f1282a.g0(), 10).apply();
                    gh1.f1013a.j(null);
                    d41.f480a.a();
                    Intent intent2 = new Intent(this, (Class<?>) ActivityOtherSettings.class);
                    intent2.setFlags(268468224);
                    startActivity(intent2);
                    finish();
                }
            }
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558458);
        setBackArrow();
        Switch r7 = (Switch) _$_findCachedViewById(t61.settings_debug_layer);
        r7.setChecked(Scene.f4798a.b(hz0.f1282a.d0(), false));
        r7.setOnClickListener(ld1.f6695a);
        Switch r72 = (Switch) _$_findCachedViewById(t61.settings_ft_monitor);
        if (Build.VERSION.SDK_INT <= 30 || !f92.a(e50.f677a.y0(), "root")) {
            r72.setEnabled(false);
        } else {
            r72.setChecked(Scene.f4798a.b(hz0.f1282a.O(), false));
            r72.setOnClickListener(qd1.f7201a);
        }
        Switch r73 = (Switch) _$_findCachedViewById(t61.settings_next_release);
        r73.setChecked(Scene.f4798a.b("get_next_release", false));
        r73.setOnClickListener(rd1.f7290a);
        Switch r74 = (Switch) _$_findCachedViewById(t61.settings_layer_keep);
        r74.setChecked(Scene.f4798a.b(hz0.f1282a.T(), false));
        r74.setOnClickListener(sd1.f7386a);
        Switch r75 = (Switch) _$_findCachedViewById(t61.settings_precision_monitor);
        r75.setChecked(Scene.f4798a.b(hz0.f1282a.Y(), false));
        r75.setOnClickListener(td1.f7490a);
        Switch r76 = (Switch) _$_findCachedViewById(t61.settings_kernel_mem);
        r76.setChecked(hz0.f1282a.R());
        r76.setOnClickListener(ud1.f7587a);
        Switch r77 = (Switch) _$_findCachedViewById(t61.settings_simple_notification);
        r77.setChecked(Scene.f4798a.b(hz0.f1282a.G(), tj0.f7508a.a() || tj0.f7508a.b()));
        r77.setOnClickListener(vd1.f7683a);
        Switch r78 = (Switch) _$_findCachedViewById(t61.settings_language_package);
        r78.setChecked(sk0.f7408a.a().c());
        r78.setOnClickListener(new jd1(r78, this));
        TextView textView = (TextView) _$_findCachedViewById(t61.settings_language_package_export);
        f92.c(textView, "settings_language_package_export");
        String string = getString(u61.settings_language_package_export);
        f92.c(string, "getString(R.string.setti…_language_package_export)");
        kk0.a(textView, string, new e());
        Switch r79 = (Switch) _$_findCachedViewById(t61.settings_keep_alive);
        r79.setChecked(Scene.f4798a.b(hz0.f1282a.D(), hz0.f1282a.E()));
        r79.setOnClickListener(new kd1(this));
        Switch r710 = (Switch) _$_findCachedViewById(t61.settings_daemon_alive);
        if (!f92.a(e50.f677a.y0(), "root")) {
            r710.setChecked(false);
            r710.setEnabled(false);
        } else {
            r710.setChecked(Scene.f4798a.b(hz0.f1282a.A(), false));
        }
        r710.setOnClickListener(md1.f6796a);
        Switch r711 = (Switch) _$_findCachedViewById(t61.settings_daemon_auto);
        if (Build.VERSION.SDK_INT < 29 || f92.a(e50.f677a.y0(), "basic")) {
            r711.setChecked(false);
            r711.setEnabled(false);
            if (Build.VERSION.SDK_INT < 29 && hz0.f1282a.B()) {
                hz0.f1282a.H0(false);
            }
        } else {
            r711.setChecked(hz0.f1282a.B());
        }
        r711.setOnClickListener(nd1.f6903a);
        ((TextView) _$_findCachedViewById(t61.privacy_policy)).setOnClickListener(new b());
        BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.sync_menu);
        f92.c(blurViewLinearLayout, "sync_menu");
        blurViewLinearLayout.setVisibility(f92.a(e50.f677a.y0(), "root") ? 0 : 8);
        ((Button) _$_findCachedViewById(t61.sync_upload)).setOnClickListener(new c());
        ((Button) _$_findCachedViewById(t61.sync_download)).setOnClickListener(new d());
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().w();
    }

    public final void onThemeClick(View view) {
        f92.d(view, "view");
        int i = Integer.parseInt(view.getTag().toString());
        new File(l()).delete();
        if (i == 999) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            startActivityForResult(intent, 222);
            return;
        }
        d41.f480a.j(null);
        if (i != 10 || m()) {
            d41.f480a.a();
            Scene.f4798a.g().edit().putInt(hz0.f1282a.g0(), i).apply();
            recreate();
        } else {
            p80.a aVar = p80.f2403a;
            Context context = view.getContext();
            f92.c(context, "view.context");
            String string = getString(u61.wallpaper_rw_permission);
            f92.c(string, "getString(R.string.wallpaper_rw_permission)");
            p80.a.C(aVar, context, string, null, 4, null);
        }
    }
}
