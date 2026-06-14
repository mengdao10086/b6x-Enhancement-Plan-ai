package com.omarea.vtools.activities;

import a.e50;
import a.f92;
import a.g91;
import a.m92;
import a.n92;
import a.qc2;
import a.qe2;
import a.t31;
import a.t61;
import a.u41;
import a.u61;
import a.w71;
import a.xd2;
import a.y71;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
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
public final class ActivityAppComponents extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8492a;

    public static final class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && i != 5 && i != 3) {
                return true;
            }
            ActivityAppComponents activityAppComponents = ActivityAppComponents.this;
            EditText editText = (EditText) activityAppComponents._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            Editable text = editText.getText();
            f92.c(text, "apps_search_box.text");
            activityAppComponents.m(text);
            return true;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m92 f8494a;

        public b(m92 m92Var) {
            this.f8494a = m92Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f8494a.f6785a = jCurrentTimeMillis;
            Scene.f4798a.j(new w71(this, jCurrentTimeMillis), 500L);
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
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.contents.AdapterComponents");
            }
            ComponentInfo item = ((u41) adapter).getItem(i);
            String str = item.packageName + "/" + item.name;
            Object systemService = ActivityAppComponents.this.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", str));
            Toast.makeText(ActivityAppComponents.this, ActivityAppComponents.this.getString(u61.copy_success) + "\n" + str, 0).show();
            return true;
        }
    }

    public static final class d implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5111a;
        public final /* synthetic */ String b;

        public d(String str, String str2) {
            this.f5111a = str;
            this.b = str2;
        }

        /* JADX WARN: Type inference failed for: r7v3, types: [T, a.u41] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            n92 n92Var = new n92();
            f92.c(adapterView, "parent");
            Adapter adapter = adapterView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.contents.AdapterComponents");
            }
            ?? r7 = (u41) adapter;
            n92Var.f6891a = r7;
            ComponentInfo item = ((u41) r7).getItem(i);
            if (!f92.a(e50.f677a.y0(), "basic")) {
                qc2.d(xd2.a(qe2.b()), null, null, new y71(this, item, n92Var, null), 3, null);
                return;
            }
            Scene.c cVar = Scene.f4798a;
            String string = ActivityAppComponents.this.getString(u61.only_adb_or_root_mode);
            f92.c(string, "getString(R.string.only_adb_or_root_mode)");
            Scene.c.p(cVar, string, 0, 2, null);
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f8492a == null) {
            this.f8492a = new HashMap();
        }
        View view = (View) this.f8492a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f8492a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<android.content.pm.ComponentInfo> l(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            if (r4 != 0) goto L5
            goto L61
        L5:
            int r1 = r4.hashCode()
            switch(r1) {
                case -1655966961: goto L4f;
                case -987494927: goto L39;
                case -808719889: goto L23;
                case 1984153269: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L61
        Ld:
            java.lang.String r1 = "service"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L61
            a.dh0 r4 = new a.dh0
            android.content.Context r1 = r2.getContext()
            r4.<init>(r1)
            java.util.ArrayList r3 = r4.g(r3)
            goto L6e
        L23:
            java.lang.String r1 = "receiver"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L61
            a.dh0 r4 = new a.dh0
            android.content.Context r1 = r2.getContext()
            r4.<init>(r1)
            java.util.ArrayList r3 = r4.f(r3)
            goto L6e
        L39:
            java.lang.String r1 = "provider"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L61
            a.dh0 r4 = new a.dh0
            android.content.Context r1 = r2.getContext()
            r4.<init>(r1)
            java.util.ArrayList r3 = r4.e(r3)
            goto L6e
        L4f:
            java.lang.String r1 = "activity"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L61
            a.dh0 r4 = new a.dh0
            android.content.Context r1 = r2.getContext()
            r4.<init>(r1)
            goto L6a
        L61:
            a.dh0 r4 = new a.dh0
            android.content.Context r1 = r2.getContext()
            r4.<init>(r1)
        L6a:
            java.util.ArrayList r3 = r4.d(r3)
        L6e:
            r0.<init>(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppComponents.l(java.lang.String, java.lang.String):java.util.ArrayList");
    }

    public final void m(Editable editable) {
        String string = editable.toString();
        ListView listView = (ListView) _$_findCachedViewById(t61.activities);
        f92.c(listView, "activities");
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.contents.AdapterComponents");
        }
        ((u41) adapter).g(string);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
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
        Intent intent3 = getIntent();
        String stringExtra = (intent3 == null || !intent3.hasExtra("type")) ? "activity" : getIntent().getStringExtra("type");
        f92.c(packageName, "packageName");
        ArrayList<ComponentInfo> arrayListL = l(packageName, stringExtra);
        ListView listView = (ListView) _$_findCachedViewById(t61.activities);
        f92.c(listView, "activities");
        Context context = getContext();
        String str = stringExtra != null ? stringExtra : "";
        EditText editText = (EditText) _$_findCachedViewById(t61.apps_search_box);
        f92.c(editText, "apps_search_box");
        Editable text = editText.getText();
        listView.setAdapter((ListAdapter) new u41(context, arrayListL, str, (text == null || (string = text.toString()) == null) ? "" : string, null, 16, null));
        ((ListView) _$_findCachedViewById(t61.activities)).setOnItemLongClickListener(new c());
        ((ListView) _$_findCachedViewById(t61.activities)).setOnItemClickListener(new d(packageName, stringExtra));
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        setTitle((intent == null || !intent.hasExtra("appName")) ? "" : getIntent().getStringExtra("appName"));
    }
}
