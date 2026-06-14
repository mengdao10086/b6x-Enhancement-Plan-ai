package com.omarea.vtools.activities;

import a.d0;
import a.e42;
import a.e50;
import a.f92;
import a.g42;
import a.g91;
import a.h42;
import a.m42;
import a.oj0;
import a.s60;
import a.t61;
import a.u61;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAppActivity extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5107a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8488a = "";
    public String b = "";

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityInfo f8489a;

        public a(ActivityInfo activityInfo) {
            this.f8489a = activityInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityInfo activityInfo = this.f8489a;
            if (!activityInfo.enabled) {
                ActivityAppActivity activityAppActivity = ActivityAppActivity.this;
                Toast.makeText(activityAppActivity, activityAppActivity.getString(u61.am_activity_disabled), 1).show();
                return;
            }
            if (activityInfo.exported || f92.a(activityInfo.packageName, ActivityAppActivity.this.getContext().getPackageName())) {
                try {
                    ActivityAppActivity.this.startActivity(ActivityAppActivity.this.l());
                    return;
                } catch (ActivityNotFoundException | SecurityException unused) {
                    this.f8489a.exported = false;
                } catch (Exception e) {
                    Toast.makeText(ActivityAppActivity.this, "Exception " + e.getMessage(), 1).show();
                    return;
                }
            }
            ActivityAppActivity.this.m();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityInfo f8490a;

        public b(ActivityInfo activityInfo) {
            this.f8490a = activityInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppActivity activityAppActivity;
            String string;
            if (!this.f8490a.enabled) {
                ActivityAppActivity activityAppActivity2 = ActivityAppActivity.this;
                Toast.makeText(activityAppActivity2, activityAppActivity2.getString(u61.am_activity_disabled), 1).show();
                return;
            }
            oj0 oj0Var = new oj0(ActivityAppActivity.this, !r5.exported);
            Intent intentL = ActivityAppActivity.this.l();
            EditText editText = (EditText) ActivityAppActivity.this._$_findCachedViewById(t61.edit_title);
            f92.c(editText, "edit_title");
            String string2 = editText.getText().toString();
            ImageView imageView = (ImageView) ActivityAppActivity.this._$_findCachedViewById(t61.edit_icon);
            f92.c(imageView, "edit_icon");
            Drawable drawable = imageView.getDrawable();
            f92.c(drawable, "edit_icon.drawable");
            if (oj0Var.a(intentL, string2, drawable)) {
                activityAppActivity = ActivityAppActivity.this;
                string = "OK";
            } else {
                activityAppActivity = ActivityAppActivity.this;
                string = activityAppActivity.getString(u61.am_shortcut_fail);
            }
            Toast.makeText(activityAppActivity, string, 0).show();
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAppActivity.this.finishAfterTransition();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5107a == null) {
            this.f5107a = new HashMap();
        }
        View view = (View) this.f5107a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5107a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final Intent l() {
        Intent intent = new Intent("android.intent.action.VIEW");
        EditText editText = (EditText) _$_findCachedViewById(t61.edit_pkg);
        f92.c(editText, "edit_pkg");
        String string = editText.getText().toString();
        EditText editText2 = (EditText) _$_findCachedViewById(t61.edit_activity);
        f92.c(editText2, "edit_activity");
        intent.setComponent(new ComponentName(string, editText2.getText().toString()));
        intent.addFlags(268435456);
        return intent;
    }

    public final void loadData() throws PackageManager.NameNotFoundException {
        int i;
        int i2;
        PackageManager packageManager = getPackageManager();
        ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f8488a, this.b), 0);
        f92.c(activityInfo, "pm.getActivityInfo(Compo…me(pkgName, activity), 0)");
        String string = activityInfo.loadLabel(packageManager).toString();
        ((EditText) _$_findCachedViewById(t61.edit_title)).setText(string);
        setTitle(string);
        ((EditText) _$_findCachedViewById(t61.edit_activity)).setText(activityInfo.name);
        ((EditText) _$_findCachedViewById(t61.edit_pkg)).setText(activityInfo.packageName);
        ((ImageView) _$_findCachedViewById(t61.edit_icon)).setImageDrawable(activityInfo.loadIcon(packageManager));
        TextView textView = (TextView) _$_findCachedViewById(t61.state_exported);
        if (activityInfo.exported) {
            textView.setTextColor(-16711936);
            i = u61.am_exported;
        } else {
            textView.setTextColor(-65536);
            i = u61.am_no_exported;
        }
        textView.setText(getString(i));
        TextView textView2 = (TextView) _$_findCachedViewById(t61.state_enable);
        if (activityInfo.enabled) {
            textView2.setTextColor(-16711936);
            i2 = u61.enabled;
        } else {
            textView2.setTextColor(-65536);
            i2 = u61.not_enabled;
        }
        textView2.setText(getString(i2));
        ((Button) _$_findCachedViewById(t61.action_start)).setOnClickListener(new a(activityInfo));
        ((Button) _$_findCachedViewById(t61.action_save)).setOnClickListener(new b(activityInfo));
    }

    public final void m() {
        if (!(!f92.a(e50.f677a.y0(), "basic"))) {
            Toast.makeText(this, getString(u61.am_activity_permission), 1).show();
            return;
        }
        EditText editText = (EditText) _$_findCachedViewById(t61.edit_pkg);
        f92.c(editText, "edit_pkg");
        String string = editText.getText().toString();
        EditText editText2 = (EditText) _$_findCachedViewById(t61.edit_activity);
        f92.c(editText2, "edit_activity");
        String string2 = editText2.getText().toString();
        s60.f7366a.a("am start -n '" + string + '/' + string2 + '\'');
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(2131558433);
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
        toolbar.setNavigationOnClickListener(new c());
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("activity") || !extras.containsKey("packageName")) {
            return;
        }
        this.f8488a = String.valueOf(extras.getString("packageName"));
        this.b = String.valueOf(extras.getString("activity"));
        try {
            e42 e42Var = g42.f6169a;
            loadData();
            g42.a(m42.f6769a);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            g42.a(h42.a(th));
        }
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
