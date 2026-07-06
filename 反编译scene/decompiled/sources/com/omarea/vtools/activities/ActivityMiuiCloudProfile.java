package com.omarea.vtools.activities;

import a.ay0;
import a.b62;
import a.d72;
import a.e60;
import a.ec2;
import a.f92;
import a.g30;
import a.g91;
import a.h42;
import a.k82;
import a.m42;
import a.p80;
import a.q92;
import a.qc2;
import a.qe2;
import a.r62;
import a.s60;
import a.t61;
import a.u61;
import a.wd2;
import a.x62;
import a.xd2;
import a.y60;
import a.zx0;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityMiuiCloudProfile extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zx0 f8738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Menu f5337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5339a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5340b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5338a = "/sdcard/Android/scene-config.json";
    public final String b = "/data/data/com.xiaomi.joyose/databases";
    public final String c = "booster_config";
    public final String d = "common_config";
    public String e = "booster_config";

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5341a;

        public a(String str) {
            this.f5341a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((EditText) ActivityMiuiCloudProfile.this._$_findCachedViewById(t61.cloud_config)).setText(this.f5341a);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g30 f8740a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5342a;

        public b(String str, g30 g30Var) {
            this.f5342a = str;
            this.f8740a = g30Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y60 y60Var = y60.f7952a;
            String str = this.f5342a;
            String strA = this.f8740a.A(2);
            f92.c(strA, "json.toString(2)");
            if (y60Var.l(str, strA)) {
                Scene.c.p(Scene.f4798a, "OK", 0, 2, null);
            }
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g30 f8741a;

        public c(g30 g30Var) {
            this.f8741a = g30Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((EditText) ActivityMiuiCloudProfile.this._$_findCachedViewById(t61.cloud_config)).setText(this.f8741a.A(2));
        }
    }

    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityMiuiCloudProfile.this.p();
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityMiuiCloudProfile$onDestroy$1", f = "ActivityMiuiCloudProfile.kt", l = {}, m = "invokeSuspend")
    public static final class e extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8743a;
        public int b;

        public e(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            e eVar = ActivityMiuiCloudProfile.this.new e(b62Var);
            eVar.f8743a = (wd2) obj;
            return eVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((e) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            y60.f7952a.b(ActivityMiuiCloudProfile.this.f5338a);
            return m42.f6769a;
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityMiuiCloudProfile activityMiuiCloudProfile = ActivityMiuiCloudProfile.this;
            activityMiuiCloudProfile.u("SmartP.db", activityMiuiCloudProfile.c);
        }
    }

    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityMiuiCloudProfile activityMiuiCloudProfile = ActivityMiuiCloudProfile.this;
            activityMiuiCloudProfile.u("teg_config.db", activityMiuiCloudProfile.c);
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityMiuiCloudProfile activityMiuiCloudProfile = ActivityMiuiCloudProfile.this;
            activityMiuiCloudProfile.u("SmartP.db", activityMiuiCloudProfile.d);
        }
    }

    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityMiuiCloudProfile activityMiuiCloudProfile = ActivityMiuiCloudProfile.this;
            activityMiuiCloudProfile.u("teg_config.db", activityMiuiCloudProfile.d);
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (new File(ay0.f5653a).exists()) {
                if (!e60.m()) {
                    Toast.makeText(ActivityMiuiCloudProfile.this.getContext(), ActivityMiuiCloudProfile.this.getString(u61.magisk_uninstalled), 1).show();
                    return;
                } else {
                    ActivityMiuiCloudProfile activityMiuiCloudProfile = ActivityMiuiCloudProfile.this;
                    activityMiuiCloudProfile.u("default_cloud.db", activityMiuiCloudProfile.c);
                    return;
                }
            }
            Scene.c.p(Scene.f4798a, ay0.f5653a + " Not Found!", 0, 2, null);
        }
    }

    public static final class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            zx0.f8105a.b();
            ActivityMiuiCloudProfile.this.p();
            Scene.c.p(Scene.f4798a, "OK", 0, 2, null);
        }
    }

    public final void A() {
        String str = this.f5338a;
        y60 y60Var = y60.f7952a;
        EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
        f92.c(editText, "cloud_config");
        y60Var.l(str, editText.getText().toString());
        try {
            x();
            ComponentName componentName = new ComponentName("bin.mt.plus", "bin.mt.plus.OpenFileActivity");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setComponent(componentName);
            intent.addFlags(16384);
            intent.addFlags(8388608);
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/json");
            startActivityForResult(intent, 99);
        } catch (Exception unused) {
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5339a == null) {
            this.f5339a = new HashMap();
        }
        View view = (View) this.f5339a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5339a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    public final void o() {
        Scene.c cVar;
        String string;
        String str;
        try {
            EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
            f92.c(editText, "cloud_config");
            g30 g30Var = new g30(editText.getText().toString());
            zx0 zx0Var = this.f8738a;
            g30 g30VarD = zx0Var != null ? zx0.d(zx0Var, g30Var, false, 2, null) : null;
            if (g30VarD != null) {
                EditText editText2 = (EditText) _$_findCachedViewById(t61.cloud_config);
                f92.c(editText2, "cloud_config");
                String string2 = editText2.getText().toString();
                String strA = g30VarD.A(2);
                if (!f92.a(string2, strA)) {
                    p80.a aVar = p80.f2403a;
                    String string3 = getString(u61.miui_override);
                    f92.c(string3, "getString(R.string.miui_override)");
                    String string4 = getString(u61.miui_override_confirm);
                    f92.c(string4, "getString(R.string.miui_override_confirm)");
                    aVar.i(this, (16 & 2) != 0 ? "" : string3, (16 & 4) != 0 ? "" : string4, (16 & 8) != 0 ? null : new a(strA), (16 & 16) != 0 ? null : null);
                    return;
                }
                cVar = Scene.f4798a;
                string = getString(u61.miui_no_rule_matched);
                str = "getString(R.string.miui_no_rule_matched)";
            } else {
                cVar = Scene.f4798a;
                string = getString(u61.miui_rule_matched);
                str = "getString(R.string.miui_rule_matched)";
            }
            f92.c(string, str);
            Scene.c.p(cVar, string, 0, 2, null);
        } catch (Exception unused) {
            Scene.c cVar2 = Scene.f4798a;
            String string5 = getString(u61.miui_format_error3);
            f92.c(string5, "getString(R.string.miui_format_error3)");
            Scene.c.p(cVar2, string5, 0, 2, null);
        }
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 99) {
            w();
            return;
        }
        if (i3 != -1 || intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("file")) {
            Toast.makeText(this, getString(u61.img_file_not_found), 0).show();
            return;
        }
        Bundle extras2 = intent.getExtras();
        f92.b(extras2);
        String string = extras2.getString("file");
        f92.b(string);
        f92.c(string, "data.extras!!.getString(\"file\")!!");
        t(string);
    }

    @Override // a.g91, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
        f92.c(editText, "cloud_config");
        if (editText.getVisibility() != 0) {
            super.onBackPressed();
            return;
        }
        if (!s()) {
            p();
            return;
        }
        p80.a aVar = p80.f2403a;
        String string = getString(u61.miui_back);
        f92.c(string, "getString(R.string.miui_back)");
        String string2 = getString(u61.miui_back_confirm);
        f92.c(string2, "getString(R.string.miui_back_confirm)");
        aVar.i(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new d(), (16 & 16) != 0 ? null : null);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558455);
        setBackArrow();
        onViewCreated();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        f92.d(menu, "menu");
        getMenuInflater().inflate(2131623940, menu);
        this.f5337a = menu;
        return true;
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        qc2.d(xd2.a(qe2.b()), null, null, new e(null), 3, null);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f92.d(menuItem, "item");
        if (this.f8738a != null || menuItem.getItemId() == 2131361928) {
            switch (menuItem.getItemId()) {
                case t61.action_auto /* 2131361896 */:
                    o();
                    break;
                case t61.action_export /* 2131361910 */:
                    q();
                    break;
                case t61.action_import /* 2131361915 */:
                    v();
                    break;
                case t61.action_mt /* 2131361922 */:
                    A();
                    break;
                case t61.action_open /* 2131361923 */:
                    p();
                    break;
                case t61.action_reset /* 2131361928 */:
                    y();
                    break;
                case 2131361930:
                    z();
                    break;
            }
        } else {
            Scene.c.p(Scene.f4798a, "请先选择一个配置库进入编辑！", 0, 2, null);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle("特定场景优化");
    }

    @Override // a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        f92.d(bundle, "instanceState");
        super.onSaveInstanceState(bundle);
        bundle.clear();
    }

    public final void onViewCreated() {
        ((TextView) _$_findCachedViewById(t61.db_smartp_boost)).setOnClickListener(new f());
        ((TextView) _$_findCachedViewById(t61.db_teg_boost)).setOnClickListener(new g());
        ((TextView) _$_findCachedViewById(t61.db_smartp_common)).setOnClickListener(new h());
        ((TextView) _$_findCachedViewById(t61.db_teg_common)).setOnClickListener(new i());
        ((TextView) _$_findCachedViewById(t61.db_default_cloud_boost)).setOnClickListener(new j());
        try {
            getContext().getPackageManager().getPackageInfo("bin.mt.plus", 0);
            this.f5340b = true;
        } catch (Exception unused) {
        }
    }

    public final void p() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.actions);
        f92.c(linearLayout, "actions");
        linearLayout.setVisibility(0);
        EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
        f92.c(editText, "cloud_config");
        editText.setVisibility(8);
        this.f8738a = null;
        Integer[] numArr = {2131361930, Integer.valueOf(t61.action_auto), Integer.valueOf(t61.action_import), Integer.valueOf(t61.action_export), Integer.valueOf(t61.action_mt)};
        for (int i2 = 0; i2 < 5; i2++) {
            int iIntValue = numArr[i2].intValue();
            Menu menu = this.f5337a;
            if (menu == null) {
                f92.m("menu");
                throw null;
            }
            MenuItem menuItemFindItem = menu.findItem(iIntValue);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(false);
            }
        }
        Menu menu2 = this.f5337a;
        if (menu2 == null) {
            f92.m("menu");
            throw null;
        }
        MenuItem menuItemFindItem2 = menu2.findItem(t61.action_reset);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(true);
        }
    }

    public final void q() {
        EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
        f92.c(editText, "cloud_config");
        try {
            g30 g30Var = new g30(editText.getText().toString());
            String strR = r();
            p80.a aVar = p80.f2403a;
            Context context = getContext();
            String string = getString(u61.miui_export);
            f92.c(string, "getString(R.string.miui_export)");
            q92 q92Var = q92.f7191a;
            String string2 = getString(u61.miui_reset_confirm);
            f92.c(string2, "getString(R.string.miui_reset_confirm)");
            String str = String.format(string2, Arrays.copyOf(new Object[]{strR}, 1));
            f92.c(str, "java.lang.String.format(format, *args)");
            aVar.i(context, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : str, (16 & 8) != 0 ? null : new b(strR, g30Var), (16 & 16) != 0 ? null : null);
        } catch (Exception unused) {
            Scene.c cVar = Scene.f4798a;
            String string3 = getString(u61.miui_format_error);
            f92.c(string3, "getString(R.string.miui_format_error)");
            Scene.c.p(cVar, string3, 0, 2, null);
        }
    }

    public final String r() {
        String strJ;
        zx0 zx0Var = this.f8738a;
        if (zx0Var == null || (strJ = zx0Var.j()) == null) {
            strJ = "";
        }
        return "/sdcard/[" + strJ + "][" + this.e + "].json";
    }

    public final boolean s() {
        String strG = null;
        if (f92.a(this.e, this.c)) {
            zx0 zx0Var = this.f8738a;
            if (zx0Var != null) {
                strG = zx0Var.f();
            }
        } else {
            zx0 zx0Var2 = this.f8738a;
            if (zx0Var2 != null) {
                strG = zx0Var2.g();
            }
        }
        if (strG == null || strG.length() == 0) {
            EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
            f92.c(editText, "cloud_config");
            String string = editText.getText().toString();
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            if (ec2.r0(string).toString().length() == 0) {
                return false;
            }
        } else {
            try {
                EditText editText2 = (EditText) _$_findCachedViewById(t61.cloud_config);
                f92.c(editText2, "cloud_config");
                if (f92.a(strG, new g30(editText2.getText().toString()).toString())) {
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public final void t(String str) {
        String strJ;
        p80.a aVar;
        String str2;
        p80.a aVar2;
        String string;
        zx0 zx0Var = this.f8738a;
        if (zx0Var == null || (strJ = zx0Var.j()) == null) {
            strJ = "";
        }
        if ((ec2.C(str, "SmartP", false, 2, null) && ec2.C(strJ, "teg_config", false, 2, null)) || (ec2.C(str, "teg_config", false, 2, null) && ec2.C(strJ, "SmartP", false, 2, null))) {
            aVar2 = p80.f2403a;
            string = getString(u61.miui_target_error);
            f92.c(string, "getString(R.string.miui_target_error)");
        } else {
            if ((!ec2.C(str, this.d, false, 2, null) || !ec2.C(this.e, this.c, false, 2, null)) && (!ec2.C(str, this.c, false, 2, null) || !ec2.C(this.e, this.d, false, 2, null))) {
                if (y60.f7952a.d(str)) {
                    try {
                        g30 g30Var = new g30(y60.f7952a.i(str));
                        p80.a aVar3 = p80.f2403a;
                        String string2 = getString(u61.miui_import);
                        f92.c(string2, "getString(R.string.miui_import)");
                        q92 q92Var = q92.f7191a;
                        String string3 = getString(u61.miui_import_confirm);
                        f92.c(string3, "getString(R.string.miui_import_confirm)");
                        String str3 = String.format(string3, Arrays.copyOf(new Object[]{str}, 1));
                        f92.c(str3, "java.lang.String.format(format, *args)");
                        aVar3.i(this, (16 & 2) != 0 ? "" : string2, (16 & 4) != 0 ? "" : str3, (16 & 8) != 0 ? null : new c(g30Var), (16 & 16) != 0 ? null : null);
                        return;
                    } catch (Exception unused) {
                        aVar = p80.f2403a;
                        q92 q92Var2 = q92.f7191a;
                        String string4 = getString(u61.miui_format_error2);
                        f92.c(string4, "getString(R.string.miui_format_error2)");
                        str2 = String.format(string4, Arrays.copyOf(new Object[]{str}, 1));
                    }
                } else {
                    aVar = p80.f2403a;
                    q92 q92Var3 = q92.f7191a;
                    String string5 = getString(u61.miui_import_not_found);
                    f92.c(string5, "getString(R.string.miui_import_not_found)");
                    str2 = String.format(string5, Arrays.copyOf(new Object[]{str}, 1));
                }
                f92.c(str2, "java.lang.String.format(format, *args)");
                p80.a.C(aVar, this, str2, null, 4, null);
                return;
            }
            aVar2 = p80.f2403a;
            q92 q92Var4 = q92.f7191a;
            String string6 = getString(u61.miui_target_error2);
            f92.c(string6, "getString(R.string.miui_target_error2)");
            string = String.format(string6, Arrays.copyOf(new Object[]{this.c, this.d}, 2));
            f92.c(string, "java.lang.String.format(format, *args)");
        }
        p80.a.C(aVar2, this, string, null, 4, null);
    }

    public final void u(String str, String str2) {
        Menu menu;
        String str3 = this.b + '/' + str;
        if (!f92.a(str, "default_cloud.db") && !y60.f7952a.g(str3)) {
            Scene.c cVar = Scene.f4798a;
            q92 q92Var = q92.f7191a;
            String string = getString(u61.miui_not_found);
            f92.c(string, "getString(R.string.miui_not_found)");
            String str4 = String.format(string, Arrays.copyOf(new Object[]{str3}, 1));
            f92.c(str4, "java.lang.String.format(format, *args)");
            Scene.c.p(cVar, str4, 0, 2, null);
            return;
        }
        zx0 zx0VarA = zx0.f8105a.a(getContext(), str);
        String strF = f92.a(str2, zx0VarA.k()) ? zx0VarA.f() : zx0VarA.g();
        try {
            ((EditText) _$_findCachedViewById(t61.cloud_config)).setText(new g30(strF).A(2));
            this.e = str2;
            Integer[] numArr = {2131361930, Integer.valueOf(t61.action_import), Integer.valueOf(t61.action_export)};
            for (int i2 = 0; i2 < 3; i2++) {
                int iIntValue = numArr[i2].intValue();
                Menu menu2 = this.f5337a;
                if (menu2 == null) {
                    f92.m("menu");
                    throw null;
                }
                MenuItem menuItemFindItem = menu2.findItem(iIntValue);
                if (menuItemFindItem != null) {
                    menuItemFindItem.setVisible(true);
                }
            }
            if (f92.a(this.e, zx0VarA.k())) {
                Menu menu3 = this.f5337a;
                if (menu3 == null) {
                    f92.m("menu");
                    throw null;
                }
                MenuItem menuItemFindItem2 = menu3.findItem(t61.action_auto);
                if (menuItemFindItem2 != null) {
                    menuItemFindItem2.setVisible(true);
                }
            }
            menu = this.f5337a;
        } catch (Exception unused) {
            Scene.c cVar2 = Scene.f4798a;
            String string2 = getString(u61.miui_format_error3);
            f92.c(string2, "getString(R.string.miui_format_error3)");
            Scene.c.p(cVar2, string2, 0, 2, null);
            ((EditText) _$_findCachedViewById(t61.cloud_config)).setText(strF);
        }
        if (menu == null) {
            f92.m("menu");
            throw null;
        }
        MenuItem menuItemFindItem3 = menu.findItem(t61.action_reset);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setVisible(false);
        }
        Menu menu4 = this.f5337a;
        if (menu4 == null) {
            f92.m("menu");
            throw null;
        }
        MenuItem menuItemFindItem4 = menu4.findItem(t61.action_mt);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setVisible(this.f5340b);
        }
        EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
        f92.c(editText, "cloud_config");
        editText.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.actions);
        f92.c(linearLayout, "actions");
        linearLayout.setVisibility(8);
        m42 m42Var = m42.f6769a;
        this.f8738a = zx0VarA;
    }

    public final void v() {
        Intent intent = new Intent(this, (Class<?>) ActivityFileSelector.class);
        intent.putExtra("extension", ".json");
        startActivityForResult(intent, 1);
    }

    public final void w() {
        String strI = y60.f7952a.i(this.f5338a);
        if (strI == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string = ec2.r0(strI).toString();
        EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
        f92.c(editText, "cloud_config");
        if (editText.getText().toString() == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (!(!f92.a(string, ec2.r0(r2).toString()))) {
            p();
            Scene.c cVar = Scene.f4798a;
            String string2 = getString(u61.muui_no_change);
            f92.c(string2, "getString(R.string.muui_no_change)");
            Scene.c.p(cVar, string2, 0, 2, null);
            return;
        }
        try {
            ((EditText) _$_findCachedViewById(t61.cloud_config)).setText(new g30(string).toString());
            z();
        } catch (Exception unused) {
            ((EditText) _$_findCachedViewById(t61.cloud_config)).setText(string);
            Scene.c cVar2 = Scene.f4798a;
            String string3 = getString(u61.miui_format_error);
            f92.c(string3, "getString(R.string.miui_format_error)");
            cVar2.o(string3, 1);
        }
    }

    public final void x() {
        s60.f7366a.c("am stack list | grep bin.mt.plus | cut -f1 -d ':' | cut -f2 -d '=' | xargs am stack remove");
    }

    public final void y() {
        p80.a aVar = p80.f2403a;
        String string = getString(u61.miui_reset);
        f92.c(string, "getString(R.string.miui_reset)");
        String string2 = getString(u61.miui_export_desc);
        f92.c(string2, "getString(R.string.miui_export_desc)");
        aVar.i(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new k(), (16 & 16) != 0 ? null : null);
    }

    public final void z() {
        zx0 zx0Var;
        zx0 zx0Var2;
        if (this.f8738a != null) {
            try {
                EditText editText = (EditText) _$_findCachedViewById(t61.cloud_config);
                f92.c(editText, "cloud_config");
                g30 g30Var = new g30(editText.getText().toString());
                boolean z = true;
                if (!f92.a(this.e, this.c) ? (zx0Var = this.f8738a) == null || !zx0Var.n(g30Var) : (zx0Var2 = this.f8738a) == null || !zx0Var2.m(g30Var)) {
                    z = false;
                }
                Scene.c cVar = Scene.f4798a;
                if (!z) {
                    Scene.c.p(cVar, ">_<!", 0, 2, null);
                    return;
                }
                String string = getString(u61.miui_ok_need_reboot);
                f92.c(string, "getString(R.string.miui_ok_need_reboot)");
                Scene.c.p(cVar, string, 0, 2, null);
                p();
            } catch (Exception unused) {
                Scene.c cVar2 = Scene.f4798a;
                String string2 = getString(u61.miui_format_error);
                f92.c(string2, "getString(R.string.miui_format_error)");
                Scene.c.p(cVar2, string2, 0, 2, null);
            }
        }
    }
}
