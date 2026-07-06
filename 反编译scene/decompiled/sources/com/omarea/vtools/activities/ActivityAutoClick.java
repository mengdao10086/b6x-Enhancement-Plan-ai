package com.omarea.vtools.activities;

import a.aa0;
import a.c91;
import a.e91;
import a.f91;
import a.f92;
import a.g91;
import a.hz0;
import a.i52;
import a.kh0;
import a.lk0;
import a.t61;
import a.u61;
import a.u90;
import a.un0;
import a.z42;
import a.z90;
import a.zg0;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import com.omarea.Scene;
import com.omarea.model.AppInfo;
import com.omarea.ui.BlurViewLinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAutoClick extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u90 f8568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5187a;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SharedPreferences sharedPreferences = ActivityAutoClick.this.getContext().getSharedPreferences(hz0.f1282a.c(), 0);
            List<AppInfo> listS = i52.S(new kh0(ActivityAutoClick.this.getContext(), false).h(null, true), new c91());
            ArrayList arrayList = new ArrayList(z42.m(listS, 10));
            for (AppInfo appInfo : listS) {
                appInfo.setSelected(sharedPreferences.getBoolean(appInfo.getPackageName(), false));
                arrayList.add(appInfo);
            }
            Scene.f4798a.i(new e91(this, arrayList, sharedPreferences));
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f8570a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5188a;

        public b(SharedPreferences sharedPreferences, String str) {
            this.f8570a = sharedPreferences;
            this.f5188a = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SharedPreferences.Editor editorEdit = this.f8570a.edit();
            String str = this.f5188a;
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
            }
            editorEdit.putBoolean(str, ((CompoundButton) view).isChecked()).apply();
            z90.b(z90.f8048a, aa0.SERVICE_UPDATE, null, 2, null);
        }
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z && Scene.f4798a.g().getBoolean(hz0.f1282a.f0(), false)) {
                new un0().a(ActivityAutoClick.this.getContext(), true);
            }
        }
    }

    public static final class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                new un0().a(ActivityAutoClick.this.getContext(), true);
            }
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityAutoClick.this.m();
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new zg0().c(ActivityAutoClick.this, new f91(this));
        }
    }

    public static final /* synthetic */ u90 k(ActivityAutoClick activityAutoClick) {
        u90 u90Var = activityAutoClick.f8568a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("processBarDialog");
        throw null;
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5187a == null) {
            this.f5187a = new HashMap();
        }
        View view = (View) this.f5187a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5187a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void m() {
        u90 u90Var = this.f8568a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        new Thread(new a()).start();
    }

    public final void n(CompoundButton compoundButton, SharedPreferences sharedPreferences, String str, boolean z) {
        compoundButton.setChecked(sharedPreferences.getBoolean(str, z));
        compoundButton.setOnClickListener(new b(sharedPreferences, str));
    }

    public final void o() {
        boolean zA = new zg0().a(getContext());
        View view_$_findCachedViewById = _$_findCachedViewById(t61.nav_scene_service_not_active);
        f92.c(view_$_findCachedViewById, "nav_scene_service_not_active");
        view_$_findCachedViewById.setVisibility(zA ? 8 : 0);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558441);
        setBackArrow();
        this.f8568a = new u90(this, null, 2, null);
        Switch r4 = (Switch) _$_findCachedViewById(t61.settings_auto_install);
        f92.c(r4, "settings_auto_install");
        n(r4, Scene.f4798a.g(), hz0.f1282a.J(), false);
        Switch r42 = (Switch) _$_findCachedViewById(t61.settings_auto_allow);
        f92.c(r42, "settings_auto_allow");
        n(r42, Scene.f4798a.g(), hz0.f1282a.I(), false);
        Switch r43 = (Switch) _$_findCachedViewById(t61.settings_skip_ad);
        f92.c(r43, "settings_skip_ad");
        n(r43, Scene.f4798a.g(), hz0.f1282a.e0(), false);
        Switch r44 = (Switch) _$_findCachedViewById(t61.settings_skip_ad_precise);
        f92.c(r44, "settings_skip_ad_precise");
        n(r44, Scene.f4798a.g(), hz0.f1282a.f0(), false);
        Switch r45 = (Switch) _$_findCachedViewById(t61.settings_quickly_grant);
        f92.c(r45, "settings_quickly_grant");
        n(r45, Scene.f4798a.g(), hz0.f1282a.F(), false);
        ((Switch) _$_findCachedViewById(t61.settings_skip_ad)).setOnCheckedChangeListener(new c());
        ((Switch) _$_findCachedViewById(t61.settings_skip_ad_precise)).setOnCheckedChangeListener(new d());
        ((LinearLayout) _$_findCachedViewById(t61.ad_skip_blacklist)).setOnClickListener(new e());
        BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.settings_skip_ad_panel);
        f92.c(blurViewLinearLayout, "settings_skip_ad_panel");
        blurViewLinearLayout.setVisibility(new lk0(Scene.f4798a.c()).c() ? 0 : 8);
        _$_findCachedViewById(t61.nav_scene_service_not_active).setOnClickListener(new f());
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_auto_click));
        o();
    }
}
