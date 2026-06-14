package com.omarea.vtools.activities;

import a.f92;
import a.g91;
import a.h71;
import a.i71;
import a.j71;
import a.k71;
import a.l71;
import a.m71;
import a.n71;
import a.t61;
import a.u61;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAddin extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdapterView.OnItemClickListener f8476a = a.f8477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5102a;

    public static final class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8477a = new a();

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            f92.c(adapterView, "parent");
            Object item = adapterView.getAdapter().getItem(i);
            if (item == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<*, *> /* = java.util.HashMap<*, *> */");
            }
            Object obj = ((HashMap) item).get("Action");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable");
            }
            ((Runnable) obj).run();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5102a == null) {
            this.f5102a = new HashMap();
        }
        View view = (View) this.f5102a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5102a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final HashMap<String, Object> j(String str, String str2, Runnable runnable) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Title", str);
        map.put("Desc", str2);
        if (runnable != null) {
            map.put("Action", runnable);
        }
        return map;
    }

    public final void k(View view) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT <= 29) {
            String string = getString(u61.addin_fullscreen_on);
            f92.c(string, "getString(R.string.addin_fullscreen_on)");
            String string2 = getString(u61.addin_fullscreen_on_desc);
            f92.c(string2, "getString(R.string.addin_fullscreen_on_desc)");
            arrayList.add(j(string, string2, new h71(this, this, this)));
        }
        String string3 = getString(u61.addin_wifi);
        f92.c(string3, "getString(R.string.addin_wifi)");
        String string4 = getString(u61.addin_wifi_desc);
        f92.c(string4, "getString(R.string.addin_wifi_desc)");
        arrayList.add(j(string3, string4, new i71(this, this, this)));
        String string5 = getString(u61.addin_dpi);
        f92.c(string5, "getString(R.string.addin_dpi)");
        String string6 = getString(u61.addin_dpi_desc);
        f92.c(string6, "getString(R.string.addin_dpi_desc)");
        arrayList.add(j(string5, string6, new j71(this, this, this)));
        String string7 = getString(u61.addin_deviceinfo);
        f92.c(string7, "getString(R.string.addin_deviceinfo)");
        String string8 = getString(u61.addin_deviceinfo_desc);
        f92.c(string8, "getString(\n             …ng.addin_deviceinfo_desc)");
        arrayList.add(j(string7, string8, new k71(this, this, this)));
        String string9 = getString(u61.addin_mac);
        f92.c(string9, "getString(R.string.addin_mac)");
        String string10 = getString(u61.addin_mac_desc);
        f92.c(string10, "getString(R.string.addin_mac_desc)");
        arrayList.add(j(string9, string10, new l71(this, this, this)));
        String string11 = getString(u61.addin_mac_2);
        f92.c(string11, "getString(R.string.addin_mac_2)");
        String string12 = getString(u61.addin_mac_desc_2);
        f92.c(string12, "getString(R.string.addin_mac_desc_2)");
        arrayList.add(j(string11, string12, new m71(this, this, this)));
        if (Build.VERSION.SDK_INT > 23) {
            String string13 = getString(u61.addin_force_dex_compile);
            f92.c(string13, "getString(R.string.addin_force_dex_compile)");
            String string14 = getString(u61.addin_force_dex_compile_desc);
            f92.c(string14, "getString(R.string.addin_force_dex_compile_desc)");
            arrayList.add(j(string13, string14, new n71(this, this, this)));
        }
        ListView listView = (ListView) _$_findCachedViewById(t61.addin_system_listview);
        f92.c(listView, "addin_system_listview");
        listView.setAdapter((ListAdapter) new SimpleAdapter(view.getContext(), arrayList, 2131558619, new String[]{"Title", "Desc"}, new int[]{t61.Title, t61.Desc}));
        ListView listView2 = (ListView) _$_findCachedViewById(t61.addin_system_listview);
        f92.c(listView2, "addin_system_listview");
        listView2.setOnItemClickListener(this.f8476a);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558430);
        setBackArrow();
        ListView listView = (ListView) _$_findCachedViewById(t61.addin_system_listview);
        f92.c(listView, "this.addin_system_listview");
        k(listView);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_sundry));
    }
}
