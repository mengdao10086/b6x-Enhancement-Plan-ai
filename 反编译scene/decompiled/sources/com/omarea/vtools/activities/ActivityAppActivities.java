package com.omarea.vtools.activities;

import a.dh0;
import a.f92;
import a.g91;
import a.m42;
import a.m92;
import a.p41;
import a.t31;
import a.t61;
import a.u61;
import a.v71;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAppActivities extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8483a;

    public static final class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && i != 5 && i != 3) {
                return true;
            }
            ActivityAppActivities activityAppActivities = ActivityAppActivities.this;
            EditText editText = (EditText) activityAppActivities._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            Editable text = editText.getText();
            f92.c(text, "apps_search_box.text");
            activityAppActivities.k(text);
            return true;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m92 f8485a;

        public b(m92 m92Var) {
            this.f8485a = m92Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f8485a.f6785a = jCurrentTimeMillis;
            Scene.f4798a.j(new v71(this, jCurrentTimeMillis), 500L);
        }
    }

    public static final class c implements AdapterView.OnItemLongClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            f92.c(adapterView, "parent");
            Adapter adapter = adapterView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.contents.AdapterActivities");
            }
            ActivityInfo item = ((p41) adapter).getItem(i);
            String str = item.packageName + "/" + item.name;
            Object systemService = ActivityAppActivities.this.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", str));
            Toast.makeText(ActivityAppActivities.this, ActivityAppActivities.this.getString(u61.copy_success) + "\n" + str, 0).show();
            return true;
        }
    }

    public static final class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            f92.c(adapterView, "parent");
            Adapter adapter = adapterView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.contents.AdapterActivities");
            }
            ActivityInfo item = ((p41) adapter).getItem(i);
            Intent intent = new Intent(ActivityAppActivities.this.getContext(), (Class<?>) ActivityAppActivity.class);
            intent.putExtra("packageName", item.packageName);
            intent.putExtra("activity", item.name);
            ActivityAppActivities.this.startActivity(intent);
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f8483a == null) {
            this.f8483a = new HashMap();
        }
        View view = (View) this.f8483a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f8483a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void k(Editable editable) {
        String string = editable.toString();
        ListView listView = (ListView) _$_findCachedViewById(t61.activities);
        f92.c(listView, "activities");
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.contents.AdapterActivities");
        }
        ((p41) adapter).f(string);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        ComponentName component;
        super.onCreate(bundle);
        setContentView(2131558432);
        setBackArrow();
        ((EditText) _$_findCachedViewById(t61.apps_search_box)).setOnEditorActionListener(new a());
        Intent intent = getIntent();
        String strValueOf = (intent == null || !intent.hasExtra("keyword")) ? "" : String.valueOf(getIntent().getStringExtra("keyword"));
        m92 m92Var = new m92();
        m92Var.f6785a = 0L;
        if (strValueOf.length() > 0) {
            ((EditText) _$_findCachedViewById(t61.apps_search_box)).setText(strValueOf);
        }
        ((EditText) _$_findCachedViewById(t61.apps_search_box)).addTextChangedListener(new t31(new b(m92Var)));
        Intent intent2 = getIntent();
        String packageName = (intent2 == null || !intent2.hasExtra("packageName")) ? getPackageName() : String.valueOf(getIntent().getStringExtra("packageName"));
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(packageName);
        String className = (launchIntentForPackage == null || (component = launchIntentForPackage.getComponent()) == null) ? null : component.getClassName();
        dh0 dh0Var = new dh0(getContext());
        f92.c(packageName, "packageName");
        ArrayList<ActivityInfo> arrayListD = dh0Var.d(packageName);
        ListView listView = (ListView) _$_findCachedViewById(t61.activities);
        f92.c(listView, "activities");
        Context context = getContext();
        EditText editText = (EditText) _$_findCachedViewById(t61.apps_search_box);
        f92.c(editText, "apps_search_box");
        Editable text = editText.getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        p41 p41Var = new p41(context, arrayListD, string, className != null ? className : "");
        if (className != null) {
            p41Var.g(className);
        }
        m42 m42Var = m42.f6769a;
        listView.setAdapter((ListAdapter) p41Var);
        ((ListView) _$_findCachedViewById(t61.activities)).setOnItemLongClickListener(new c());
        ((ListView) _$_findCachedViewById(t61.activities)).setOnItemClickListener(new d());
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        setTitle((intent == null || !intent.hasExtra("appName")) ? "" : getIntent().getStringExtra("appName"));
    }
}
