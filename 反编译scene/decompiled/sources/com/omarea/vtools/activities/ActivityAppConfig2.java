package com.omarea.vtools.activities;

import a.a42;
import a.aa0;
import a.b62;
import a.b81;
import a.c52;
import a.ck1;
import a.d72;
import a.f92;
import a.fz0;
import a.g91;
import a.g92;
import a.hz0;
import a.k82;
import a.kh0;
import a.m42;
import a.p21;
import a.p80;
import a.qc2;
import a.qe2;
import a.rj1;
import a.t61;
import a.u61;
import a.u90;
import a.v72;
import a.wd2;
import a.wu0;
import a.x62;
import a.xd2;
import a.yu0;
import a.z32;
import a.z90;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.model.AppInfo;
import com.omarea.model.SceneConfigInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAppConfig2 extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kh0 f5113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u90 f5114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f5116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<AppInfo> f5117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5118a;
    public ArrayList<AppInfo> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5119b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f5115a = a42.a(k.f8508a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fz0 f5112a = new fz0(Scene.f4798a.c());

    @x62(c = "com.omarea.vtools.activities.ActivityAppConfig2$loadList$1", f = "ActivityAppConfig2.kt", l = {}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8498a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ boolean f5121b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, b62 b62Var) {
            super(2, b62Var);
            this.f5121b = z;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = ActivityAppConfig2.this.new a(this.f5121b, b62Var);
            aVar.f8498a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01a7  */
        @Override // a.s62
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object j(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 486
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppConfig2.a.j(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityAppConfig2.this.f5112a.f();
            ActivityAppConfig2.this.A().edit().clear().apply();
            new yu0().a();
            ActivityAppConfig2.this.recreate();
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
                Intent intent = new Intent(ActivityAppConfig2.this.getContext(), (Class<?>) ActivityAppDetails.class);
                intent.putExtra("app", ((AppInfo) item).getPackageName());
                ActivityAppConfig2.this.startActivityForResult(intent, ActivityAppConfig2.this.f8497a);
                ActivityAppConfig2.this.f5116a = view;
            } catch (Exception unused) {
            }
        }
    }

    public static final class d implements AdapterView.OnItemLongClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            f92.c(adapterView, "parent");
            Object item = adapterView.getAdapter().getItem(i);
            if (item == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.model.AppInfo");
            }
            AppInfo appInfo = (AppInfo) item;
            String packageName = appInfo.getPackageName();
            ActivityAppConfig2 activityAppConfig2 = ActivityAppConfig2.this;
            ck1.d(new ck1(activityAppConfig2, activityAppConfig2.z(packageName), new b81(this, packageName, appInfo, adapterView, i, view)), false, false, 3, null);
            return true;
        }
    }

    public static final class e implements AdapterView.OnItemLongClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            p80.a aVar = p80.f2403a;
            ActivityAppConfig2 activityAppConfig2 = ActivityAppConfig2.this;
            String string = activityAppConfig2.getString(u61.detail_dynamic_required);
            f92.c(string, "getString(R.string.detail_dynamic_required)");
            p80.a.C(aVar, activityAppConfig2, string, null, 4, null);
            return true;
        }
    }

    public static final class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3 && i != 6) {
                return false;
            }
            ActivityAppConfig2.C(ActivityAppConfig2.this, false, 1, null);
            return true;
        }
    }

    public static final class g implements AdapterView.OnItemSelectedListener {
        public g() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ActivityAppConfig2.C(ActivityAppConfig2.this, false, 1, null);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static final class h implements AdapterView.OnItemSelectedListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ActivityAppConfig2.C(ActivityAppConfig2.this, false, 1, null);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f8506a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5123a;

        public i(ListView listView, ArrayList arrayList) {
            this.f8506a = listView;
            this.f5123a = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ListView listView = this.f8506a;
            ActivityAppConfig2 activityAppConfig2 = ActivityAppConfig2.this;
            ArrayList arrayList = this.f5123a;
            f92.b(arrayList);
            String string = ActivityAppConfig2.this.A().getString("*", wu0.f3480a.c());
            f92.b(string);
            f92.c(string, "spfPowerCfg.getString(\"*\", ModeSwitcher.BALANCE)!!");
            listView.setAdapter((ListAdapter) new p21(activityAppConfig2, arrayList, string));
            ActivityAppConfig2.n(ActivityAppConfig2.this).c();
        }
    }

    public static final class j<T> implements Comparator<AppInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f8507a = new j();

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

    public static final class k extends g92 implements v72<SharedPreferences> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f8508a = new k();

        public k() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences i() {
            return Scene.f4798a.c().getSharedPreferences(hz0.f1282a.l0(), 0);
        }
    }

    public static /* synthetic */ void C(ActivityAppConfig2 activityAppConfig2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        activityAppConfig2.B(z);
    }

    public static final /* synthetic */ kh0 j(ActivityAppConfig2 activityAppConfig2) {
        kh0 kh0Var = activityAppConfig2.f5113a;
        if (kh0Var != null) {
            return kh0Var;
        }
        f92.m("appListHelper");
        throw null;
    }

    public static final /* synthetic */ u90 n(ActivityAppConfig2 activityAppConfig2) {
        u90 u90Var = activityAppConfig2.f5114a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("processBarDialog");
        throw null;
    }

    public static final /* synthetic */ ArrayList y(ActivityAppConfig2 activityAppConfig2, ArrayList arrayList) {
        activityAppConfig2.G(arrayList);
        return arrayList;
    }

    public final SharedPreferences A() {
        return (SharedPreferences) this.f5115a.getValue();
    }

    @SuppressLint({"ApplySharedPref"})
    public final void B(boolean z) {
        if (this.f5119b) {
            return;
        }
        u90 u90Var = this.f5114a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        qc2.d(xd2.a(qe2.b()), null, null, new a(z, null), 3, null);
    }

    public final void D(String str, String str2) {
        z90 z90Var = z90.f8048a;
        aa0 aa0Var = aa0.SCENE_APP_CONFIG;
        HashMap<String, Object> map = new HashMap<>();
        map.put("app", str);
        map.put("mode", str2);
        m42 m42Var = m42.f6769a;
        z90Var.a(aa0Var, map);
    }

    public final void E(AppInfo appInfo) {
        appInfo.setSelected(false);
        String packageName = appInfo.getPackageName();
        appInfo.stateTags = z(packageName);
        SceneConfigInfo sceneConfigInfoB = this.f5112a.b(packageName);
        StringBuilder sb = new StringBuilder();
        if (sceneConfigInfoB.aloneLight) {
            sb.append(getString(u61.detail_manual_brightness));
        }
        if (sceneConfigInfoB.disNotice) {
            sb.append(getString(u61.detail_disable_notification));
        }
        if (sceneConfigInfoB.disButton) {
            sb.append(getString(u61.detail_disable_keys));
        }
        if (sceneConfigInfoB.gpsOn) {
            sb.append(getString(u61.detail_open_gps));
        }
        if (sceneConfigInfoB.screenOrientation != -1) {
            String strA = new rj1(this).a(Integer.valueOf(sceneConfigInfoB.screenOrientation));
            if (strA.length() > 0) {
                sb.append(strA);
                sb.append("  ");
            }
        }
        appInfo.desc = sb.toString();
    }

    public final void F(ArrayList<AppInfo> arrayList, ListView listView) {
        Scene.f4798a.i(new i(listView, arrayList));
    }

    public final ArrayList<AppInfo> G(ArrayList<AppInfo> arrayList) {
        c52.n(arrayList, j.f8507a);
        return arrayList;
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5118a == null) {
            this.f5118a = new HashMap();
        }
        View view = (View) this.f5118a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5118a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != this.f8497a || intent == null || this.b == null) {
            return;
        }
        int i4 = -1;
        if (i3 == -1) {
            try {
                ListView listView = (ListView) _$_findCachedViewById(t61.scene_app_list);
                f92.c(listView, "scene_app_list");
                ListAdapter adapter = listView.getAdapter();
                if (adapter == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterSceneMode");
                }
                p21 p21Var = (p21) adapter;
                Bundle extras = intent.getExtras();
                f92.b(extras);
                String string = extras.getString("app");
                ArrayList<AppInfo> arrayList = this.b;
                f92.b(arrayList);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ArrayList<AppInfo> arrayList2 = this.b;
                    f92.b(arrayList2);
                    if (f92.a(arrayList2.get(i5).getPackageName(), string)) {
                        i4 = i5;
                    }
                }
                if (i4 < 0) {
                    return;
                }
                E(p21Var.getItem(i4));
                ListView listView2 = (ListView) _$_findCachedViewById(t61.scene_app_list);
                f92.c(listView2, "scene_app_list");
                p21 p21Var2 = (p21) listView2.getAdapter();
                if (p21Var2 != null) {
                    View view = this.f5116a;
                    f92.b(view);
                    p21Var2.g(i4, view);
                }
            } catch (Exception e2) {
                Log.e("update-list", "" + e2.getMessage());
            }
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558434);
        setBackArrow();
        onViewCreated();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        f92.d(menu, "menu");
        getMenuInflater().inflate(2131623945, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        u90 u90Var = this.f5114a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90Var.c();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f92.d(menuItem, "item");
        if (menuItem.getItemId() != 2131361928) {
            return true;
        }
        p80.a aVar = p80.f2403a;
        String string = getString(u61.detail_reset_title);
        f92.c(string, "getString(R.string.detail_reset_title)");
        String string2 = getString(u61.detail_reset_desc);
        f92.c(string2, "getString(R.string.detail_reset_desc)");
        aVar.i(this, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new b(), (16 & 16) != 0 ? null : null);
        return true;
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_app_scene));
    }

    public final void onViewCreated() {
        ListView listView;
        AdapterView.OnItemLongClickListener eVar;
        this.f5114a = new u90(this, null, 2, null);
        this.f5113a = new kh0(this, false);
        if (A().getAll().isEmpty()) {
            new yu0().a();
        }
        ((ListView) _$_findCachedViewById(t61.scene_app_list)).setOnItemClickListener(new c());
        if (hz0.f1282a.b0()) {
            listView = (ListView) _$_findCachedViewById(t61.scene_app_list);
            eVar = new d();
        } else {
            listView = (ListView) _$_findCachedViewById(t61.scene_app_list);
            eVar = new e();
        }
        listView.setOnItemLongClickListener(eVar);
        ((EditText) _$_findCachedViewById(t61.config_search_box)).setOnEditorActionListener(new f());
        Spinner spinner = (Spinner) _$_findCachedViewById(t61.configlist_modes);
        f92.c(spinner, "configlist_modes");
        spinner.setOnItemSelectedListener(new g());
        Spinner spinner2 = (Spinner) _$_findCachedViewById(t61.configlist_type);
        f92.c(spinner2, "configlist_type");
        spinner2.setOnItemSelectedListener(new h());
        C(this, false, 1, null);
    }

    public final String z(String str) {
        String string = A().getString(str, "");
        f92.b(string);
        return string;
    }
}
