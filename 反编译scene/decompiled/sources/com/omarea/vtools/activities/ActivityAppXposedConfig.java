package com.omarea.vtools.activities;

import a.c52;
import a.f92;
import a.g91;
import a.hz0;
import a.iz0;
import a.kh0;
import a.t61;
import a.u61;
import a.u90;
import a.z31;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.common.ui.OverScrollListView;
import com.omarea.model.AppInfo;
import com.omarea.model.SceneConfigInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAppXposedConfig extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public iz0 f5158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kh0 f5159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u90 f5160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f5161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<AppInfo> f5162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5163a;
    public ArrayList<AppInfo> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5164b;

    public static final class a implements Runnable {
        public final /* synthetic */ boolean b;

        public a(boolean z) {
            this.b = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 360
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppXposedConfig.a.run():void");
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityAppXposedConfig.w(ActivityAppXposedConfig.this, false, 1, null);
        }
    }

    public static final class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            try {
                f92.c(adapterView, "parent");
                Object item = adapterView.getAdapter().getItem(i);
                if (item == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.omarea.model.AppInfo");
                }
                Intent intent = new Intent(ActivityAppXposedConfig.this.getContext(), (Class<?>) ActivityAppXposedDetails.class);
                intent.putExtra("app", ((AppInfo) item).getPackageName());
                ActivityAppXposedConfig.this.startActivityForResult(intent, ActivityAppXposedConfig.this.f8543a);
                ActivityAppXposedConfig.this.f5161a = view;
            } catch (Exception unused) {
            }
        }
    }

    public static final class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3 && i != 6) {
                return false;
            }
            ActivityAppXposedConfig.w(ActivityAppXposedConfig.this, false, 1, null);
            return true;
        }
    }

    public static final class e implements AdapterView.OnItemSelectedListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ActivityAppXposedConfig.w(ActivityAppXposedConfig.this, false, 1, null);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OverScrollListView f8549a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5166a;

        public f(OverScrollListView overScrollListView, ArrayList arrayList) {
            this.f8549a = overScrollListView;
            this.f5166a = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OverScrollListView overScrollListView = this.f8549a;
            ActivityAppXposedConfig activityAppXposedConfig = ActivityAppXposedConfig.this;
            ArrayList arrayList = this.f5166a;
            f92.b(arrayList);
            overScrollListView.setAdapter((ListAdapter) new z31(activityAppXposedConfig, arrayList));
            ActivityAppXposedConfig.m(ActivityAppXposedConfig.this).c();
        }
    }

    public static final class g<T> implements Comparator<AppInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f8550a = new g();

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(AppInfo appInfo, AppInfo appInfo2) {
            try {
                String string = appInfo.stateTags.toString();
                String string2 = appInfo2.stateTags.toString();
                if (string.compareTo(string2) >= 0) {
                    if (string.compareTo(string2) <= 0) {
                        String packageName = appInfo.getPackageName();
                        String packageName2 = appInfo2.getPackageName();
                        if (packageName.compareTo(packageName2) >= 0) {
                            if (packageName.compareTo(packageName2) <= 0) {
                                return 0;
                            }
                        }
                    }
                    return 1;
                }
                return -1;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public static final /* synthetic */ kh0 j(ActivityAppXposedConfig activityAppXposedConfig) {
        kh0 kh0Var = activityAppXposedConfig.f5159a;
        if (kh0Var != null) {
            return kh0Var;
        }
        f92.m("applistHelper");
        throw null;
    }

    public static final /* synthetic */ u90 m(ActivityAppXposedConfig activityAppXposedConfig) {
        u90 u90Var = activityAppXposedConfig.f5160a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("processBarDialog");
        throw null;
    }

    public static final /* synthetic */ ArrayList u(ActivityAppXposedConfig activityAppXposedConfig, ArrayList arrayList) {
        activityAppXposedConfig.z(arrayList);
        return arrayList;
    }

    public static /* synthetic */ void w(ActivityAppXposedConfig activityAppXposedConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        activityAppXposedConfig.v(z);
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5163a == null) {
            this.f5163a = new HashMap();
        }
        View view = (View) this.f5163a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5163a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != this.f8543a || intent == null || this.b == null) {
            return;
        }
        int i3 = -1;
        if (i2 == -1) {
            try {
                OverScrollListView overScrollListView = (OverScrollListView) _$_findCachedViewById(t61.scene_app_list);
                f92.c(overScrollListView, "scene_app_list");
                ListAdapter adapter = overScrollListView.getAdapter();
                if (adapter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.XposedAppsAdapter");
                }
                z31 z31Var = (z31) adapter;
                Bundle extras = intent.getExtras();
                f92.b(extras);
                String string = extras.getString("app");
                ArrayList<AppInfo> arrayList = this.b;
                f92.b(arrayList);
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ArrayList<AppInfo> arrayList2 = this.b;
                    f92.b(arrayList2);
                    if (f92.a(arrayList2.get(i4).getPackageName(), string)) {
                        i3 = i4;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                x(z31Var.getItem(i3));
                OverScrollListView overScrollListView2 = (OverScrollListView) _$_findCachedViewById(t61.scene_app_list);
                f92.c(overScrollListView2, "scene_app_list");
                z31 z31Var2 = (z31) overScrollListView2.getAdapter();
                if (z31Var2 != null) {
                    View view = this.f5161a;
                    f92.b(view);
                    z31Var2.e(i3, view);
                }
            } catch (Exception e2) {
                Log.e("update-list", "" + e2.getMessage());
            }
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558438);
        setBackArrow();
        f92.c(getContext().getSharedPreferences(hz0.f1282a.H(), 0), "context.getSharedPrefere…PF, Context.MODE_PRIVATE)");
        this.f5158a = new iz0(this);
        onViewCreated();
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        iz0 iz0Var = this.f5158a;
        if (iz0Var == null) {
            f92.m("xposedExtension");
            throw null;
        }
        iz0Var.h();
        u90 u90Var = this.f5160a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90Var.c();
        super.onDestroy();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        iz0 iz0Var = this.f5158a;
        if (iz0Var == null) {
            f92.m("xposedExtension");
            throw null;
        }
        iz0Var.b(new b());
        setTitle(getString(u61.menu_xposed_app));
    }

    public final void onViewCreated() {
        this.f5160a = new u90(this, null, 2, null);
        boolean z = false;
        this.f5159a = new kh0(this, z, 2, null);
        f92.c(getSharedPreferences(hz0.f1282a.H(), 0), "getSharedPreferences(Spf…PF, Context.MODE_PRIVATE)");
        ((OverScrollListView) _$_findCachedViewById(t61.scene_app_list)).setOnItemClickListener(new c());
        ((EditText) _$_findCachedViewById(t61.config_search_box)).setOnEditorActionListener(new d());
        Spinner spinner = (Spinner) _$_findCachedViewById(t61.configlist_type);
        f92.c(spinner, "configlist_type");
        spinner.setOnItemSelectedListener(new e());
    }

    @SuppressLint({"ApplySharedPref"})
    public final void v(boolean z) {
        if (this.f5164b) {
            return;
        }
        u90 u90Var = this.f5160a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        new Thread(new a(z)).start();
    }

    public final void x(AppInfo appInfo) {
        appInfo.setSelected(false);
        String packageName = appInfo.getPackageName();
        new SceneConfigInfo().packageName = packageName;
        iz0 iz0Var = this.f5158a;
        if (iz0Var == null) {
            f92.m("xposedExtension");
            throw null;
        }
        if (iz0Var.e() != null) {
            iz0 iz0Var2 = this.f5158a;
            if (iz0Var2 == null) {
                f92.m("xposedExtension");
                throw null;
            }
            iz0.a aVarD = iz0Var2.d(packageName);
            if (aVarD != null) {
                StringBuilder sb = new StringBuilder();
                if (aVarD.a() > 0) {
                    sb.append("DPI:" + aVarD.a() + "  ");
                }
                if (aVarD.b()) {
                    sb.append(getString(u61.xp_hide_recent) + "  ");
                }
                if (aVarD.d()) {
                    sb.append(getString(u61.xp_slow_scroll) + "  ");
                }
                if (aVarD.e()) {
                    sb.append(getString(u61.xp_web_debug) + "  ");
                }
                appInfo.desc = sb.toString();
            }
        }
    }

    public final void y(ArrayList<AppInfo> arrayList, OverScrollListView overScrollListView) {
        Scene.f4798a.i(new f(overScrollListView, arrayList));
    }

    public final ArrayList<AppInfo> z(ArrayList<AppInfo> arrayList) {
        c52.n(arrayList, g.f8550a);
        return arrayList;
    }
}
