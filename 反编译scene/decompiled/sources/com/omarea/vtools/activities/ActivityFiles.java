package com.omarea.vtools.activities;

import a.c60;
import a.ec2;
import a.f92;
import a.g91;
import a.i52;
import a.l21;
import a.n50;
import a.n92;
import a.na1;
import a.p80;
import a.qc2;
import a.qe2;
import a.t61;
import a.u42;
import a.u61;
import a.u90;
import a.xd2;
import a.y60;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityFiles extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l21 f8649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5250a;

    public static final class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r3v8, types: [T, a.p80$b] */
        @Override // java.lang.Runnable
        public final void run() {
            ActivityFiles activityFiles;
            String strB;
            String str;
            l21 l21Var = ActivityFiles.this.f8649a;
            f92.b(l21Var);
            n50 n50VarF = l21Var.f();
            if (n50VarF != null) {
                String str2 = (String) i52.K(ec2.d0(n50VarF.d(), new String[]{"."}, false, 0, 6, null));
                if (u42.k(new String[]{"txt", "conf", "sql", "xml", "prop", "md", "csv", "log", "ini", "json", "html", "htm", "js", "ts", "go", "java", "c", "cpp", "rs", "kt"}, str2)) {
                    Intent intent = new Intent(ActivityFiles.this, (Class<?>) ActivityEditor.class);
                    intent.putExtra("file", n50VarF.b());
                    intent.putExtra("rootMode", true);
                    ActivityFiles.this.startActivity(intent);
                    return;
                }
                if (f92.a(str2, "apk.1") || f92.a(str2, "apk")) {
                    n92 n92Var = new n92();
                    n92Var.f6891a = p80.a.G(p80.f2403a, ActivityFiles.this, null, 2, null);
                    qc2.d(xd2.a(qe2.b()), null, null, new na1(n50VarF, n92Var, null), 3, null);
                    return;
                }
                if (u42.k(new String[]{"jpg", "png", "gif", "jpeg", "webp", "heif", "heic", "bmp"}, str2)) {
                    activityFiles = ActivityFiles.this;
                    strB = n50VarF.b();
                    str = "image/*";
                } else {
                    if (!u42.k(new String[]{"mp4", "avi", "3gp", "rmvb", "rm", "mkv", "avi", "mov", "mpeg"}, str2)) {
                        return;
                    }
                    activityFiles = ActivityFiles.this;
                    strB = n50VarF.b();
                    str = "video/*";
                }
                activityFiles.l(strB, str);
            }
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l21 l21Var = ActivityFiles.this.f8649a;
            f92.b(l21Var);
            n50 n50VarF = l21Var.f();
            if (n50VarF != null) {
                y60.f7952a.b(n50VarF.b());
                l21 l21Var2 = ActivityFiles.this.f8649a;
                f92.b(l21Var2);
                l21Var2.k();
            }
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5250a == null) {
            this.f5250a = new HashMap();
        }
        View view = (View) this.f5250a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5250a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void l(String str, String str2) {
        try {
            Uri uriE = FileProvider.e(this, getPackageName() + ".fileprovider", new File(str));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriE, str2);
            intent.addFlags(268435456);
            intent.addFlags(1);
            startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(this, "没有可用的应用打开此文件", 0).show();
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558453);
        setBackArrow();
        onViewCreated();
    }

    @Override // a.v0, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        l21 l21Var;
        if (i == 4 && (l21Var = this.f8649a) != null && l21Var.g()) {
            return true;
        }
        setResult(0, new Intent());
        return super.onKeyDown(i, keyEvent);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_files));
    }

    public final void onViewCreated() {
        this.f8649a = new l21(n50.f6876a.a(c60.f5764a.e()), new a(), new u90(this, null, 2, null), null, true, true, new b(), false);
        ListView listView = (ListView) _$_findCachedViewById(t61.magisk_files);
        f92.c(listView, "magisk_files");
        listView.setAdapter((ListAdapter) this.f8649a);
    }
}
