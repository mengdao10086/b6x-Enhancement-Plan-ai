package com.omarea.vtools.activities;

import a.a42;
import a.b92;
import a.bc2;
import a.d0;
import a.e50;
import a.f92;
import a.g91;
import a.g92;
import a.l11;
import a.l21;
import a.n50;
import a.t61;
import a.u61;
import a.v72;
import a.z32;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityFileSelector extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8644a = new a(null);
    public static final int b = 0;
    public static final int c = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l11 f5244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l21 f5245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5247a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f5243a = b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f5249b = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f5246a = a42.a(e.f8648a);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(b92 b92Var) {
            this();
        }

        public static /* synthetic */ Intent b(a aVar, Context context, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return aVar.a(context, str, str2);
        }

        public final Intent a(Context context, String str, String str2) {
            f92.d(context, "context");
            Intent intent = new Intent(context, (Class<?>) ActivityFileSelector.class);
            if (str != null) {
                intent.putExtra("extension", bc2.t(str, ".", "", false, 4, null));
            }
            if (str2 != null) {
                intent.putExtra("start", str2);
            }
            return intent;
        }

        public final int c() {
            return ActivityFileSelector.b;
        }

        public final int d() {
            return ActivityFileSelector.c;
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityFileSelector.this.finish();
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l21 l21Var = ActivityFileSelector.this.f5245a;
            f92.b(l21Var);
            n50 n50VarF = l21Var.f();
            if (n50VarF != null) {
                ActivityFileSelector.this.setResult(-1, new Intent().putExtra("file", n50VarF.b()));
                ActivityFileSelector.this.finish();
            }
        }
    }

    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l11 l11Var = ActivityFileSelector.this.f5244a;
            f92.b(l11Var);
            File fileM = l11Var.m();
            if (fileM != null) {
                ActivityFileSelector.this.setResult(-1, new Intent().putExtra("file", fileM.getAbsolutePath()));
                ActivityFileSelector.this.finish();
            }
        }
    }

    public static final class e extends g92 implements v72<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f8648a = new e();

        public e() {
            super(0);
        }

        public final boolean a() {
            return f92.a(e50.f677a.y0(), "root");
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Boolean i() {
            return Boolean.valueOf(a());
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5248a == null) {
            this.f5248a = new HashMap();
        }
        View view = (View) this.f5248a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5248a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final boolean n() {
        return ((Boolean) this.f5246a.getValue()).booleanValue();
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558448);
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
        toolbar.setNavigationOnClickListener(new b());
        Intent intent = getIntent();
        f92.c(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("extension")) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                Intent intent2 = getIntent();
                f92.c(intent2, "intent");
                Bundle extras2 = intent2.getExtras();
                f92.b(extras2);
                sb.append(extras2.getString("extension"));
                String string = sb.toString();
                this.f5247a = string;
                if (!bc2.x(string, ".", false, 2, null)) {
                    this.f5247a = '.' + this.f5247a;
                }
                if (this.f5247a.length() > 0) {
                    setTitle(getTitle().toString() + '(' + this.f5247a + ')');
                }
            }
            if (extras.containsKey("mode")) {
                int i = extras.getInt("mode");
                this.f5243a = i;
                if (i == c) {
                    setTitle(getString(u61.title_activity_folder_selector));
                }
            }
            if (extras.containsKey("start")) {
                String string2 = extras.getString("start");
                f92.b(string2);
                this.f5249b = string2;
            }
        }
    }

    @Override // a.v0, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        l11 l11Var;
        l21 l21Var;
        if (i == 4 && (((l11Var = this.f5244a) != null && l11Var.n()) || ((l21Var = this.f5245a) != null && l21Var.g()))) {
            return true;
        }
        setResult(0, new Intent());
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // a.g91, a.cl, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityFileSelector.onResume():void");
    }
}
