package com.omarea.vtools.activities;

import a.e60;
import a.f92;
import a.g91;
import a.l21;
import a.n50;
import a.p80;
import a.t61;
import a.u61;
import a.u90;
import a.y60;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityMagisk extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l21 f8728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5332a;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!e60.f698a.k(ActivityMagisk.this.getContext())) {
                Toast.makeText(ActivityMagisk.this.getContext(), ">_<", 0).show();
            } else {
                Toast.makeText(ActivityMagisk.this.getContext(), "OK!", 1).show();
                ActivityMagisk.this.recreate();
            }
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l21 l21Var = ActivityMagisk.this.f8728a;
            f92.b(l21Var);
            n50 n50VarF = l21Var.f();
            if (n50VarF != null) {
                Intent intent = new Intent(ActivityMagisk.this, (Class<?>) ActivityEditor.class);
                intent.putExtra("file", n50VarF.b());
                intent.putExtra("rootMode", true);
                ActivityMagisk.this.startActivity(intent);
            }
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l21 l21Var = ActivityMagisk.this.f8728a;
            f92.b(l21Var);
            n50 n50VarF = l21Var.f();
            if (n50VarF != null) {
                y60.f7952a.b(n50VarF.b());
                l21 l21Var2 = ActivityMagisk.this.f8728a;
                f92.b(l21Var2);
                l21Var2.k();
            }
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5332a == null) {
            this.f5332a = new HashMap();
        }
        View view = (View) this.f5332a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5332a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558453);
        setBackArrow();
        onViewCreated();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_app_magisk));
    }

    public final void onViewCreated() {
        if (!e60.f698a.n()) {
            Toast.makeText(getContext(), getString(u61.magisk_uninstalled), 1).show();
            return;
        }
        if (!e60.m()) {
            p80.a aVar = p80.f2403a;
            String string = getString(u61.magisk_install_title);
            f92.c(string, "getString(R.string.magisk_install_title)");
            String string2 = getString(u61.magisk_install_desc);
            f92.c(string2, "getString(R.string.magisk_install_desc)");
            aVar.i(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new a(), (16 & 16) != 0 ? null : null);
        }
        this.f8728a = new l21(n50.f6876a.a(e60.f698a.g()), new b(), new u90(this, null, 2, null), null, true, true, new c(), false);
        ListView listView = (ListView) _$_findCachedViewById(t61.magisk_files);
        f92.c(listView, "magisk_files");
        listView.setAdapter((ListAdapter) this.f8728a);
    }
}
