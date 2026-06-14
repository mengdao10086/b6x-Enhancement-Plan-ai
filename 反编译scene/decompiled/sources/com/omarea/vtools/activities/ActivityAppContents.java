package com.omarea.vtools.activities;

import a.b62;
import a.bc2;
import a.c81;
import a.d72;
import a.d81;
import a.dh0;
import a.e81;
import a.f81;
import a.f92;
import a.fg2;
import a.g81;
import a.g91;
import a.h42;
import a.hf2;
import a.i52;
import a.iq1;
import a.k82;
import a.kh0;
import a.m42;
import a.m92;
import a.oc2;
import a.qc2;
import a.qe2;
import a.qi0;
import a.r62;
import a.rh0;
import a.t31;
import a.t61;
import a.t62;
import a.u61;
import a.u90;
import a.wd2;
import a.wz0;
import a.x62;
import a.xd2;
import a.y42;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.model.AppInfo;
import com.omarea.vtools.activities.ActivityApplications;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityAppContents extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kh0 f8509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u90 f5124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActivityApplications.a f5125a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String> f5127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5128a;
    public String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<AppInfo> f5129b;

    public static final class a implements ActivityApplications.a {
        public a() {
        }

        @Override // com.omarea.vtools.activities.ActivityApplications.a
        public void a() {
            qc2.d(xd2.a(qe2.c()), null, null, new c81(this, null), 3, null);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityAppContents$onCreate$1", f = "ActivityAppContents.kt", l = {55}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8511a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5131a;
        public int b;

        public b(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = ActivityAppContents.this.new b(b62Var);
            bVar.f8511a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8511a;
                new dh0(ActivityAppContents.this).c();
                fg2 fg2VarC = qe2.c();
                d81 d81Var = new d81(this, null);
                this.f5131a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, d81Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    public static final class c implements rh0<Integer> {
        public c() {
        }

        @Override // a.rh0
        public /* bridge */ /* synthetic */ void a(Integer num) {
            c(num.intValue());
        }

        @Override // a.rh0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer getValue() {
            return Integer.valueOf(ActivityAppContents.this.f5127a.indexOf(ActivityAppContents.this.f5126a));
        }

        public void c(int i) {
            ActivityAppContents activityAppContents = ActivityAppContents.this;
            Object obj = activityAppContents.f5127a.get(i);
            f92.c(obj, "types.get(value)");
            activityAppContents.f5126a = (String) obj;
            ActivityAppContents.this.u();
        }
    }

    public static final class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && i != 5 && i != 3) {
                return true;
            }
            ActivityAppContents activityAppContents = ActivityAppContents.this;
            EditText editText = (EditText) activityAppContents._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            activityAppContents.w(editText.getText().toString());
            return true;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m92 f8514a;

        public e(m92 m92Var) {
            this.f8514a = m92Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f8514a.f6785a = jCurrentTimeMillis;
            Scene.f4798a.j(new e81(this, jCurrentTimeMillis), 500L);
        }
    }

    public static final class f implements AdapterView.OnItemLongClickListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListView listView = (ListView) ActivityAppContents.this._$_findCachedViewById(t61.app_list);
            f92.c(listView, "app_list");
            ListAdapter adapter = listView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppBasic");
            }
            AppInfo item = ((wz0) adapter).getItem(i);
            ActivityAppContents activityAppContents = ActivityAppContents.this;
            new iq1(activityAppContents, item, activityAppContents.f5125a).c0();
            return true;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityAppContents$setList$1", f = "ActivityAppContents.kt", l = {119}, m = "invokeSuspend")
    public static final class g extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8516a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5134a;
        public int b;

        public g(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            g gVar = ActivityAppContents.this.new g(b62Var);
            gVar.f8516a = (wd2) obj;
            return gVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((g) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8516a;
                ActivityAppContents activityAppContents = ActivityAppContents.this;
                ArrayList<AppInfo> arrayListC = ActivityAppContents.k(activityAppContents).c();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : arrayListC) {
                    AppInfo appInfo = (AppInfo) obj2;
                    boolean z = false;
                    if (!bc2.x(appInfo.getPackageName(), "com.android.overlay", false, 2, null) && !bc2.x(appInfo.getPackageName(), "com.android.theme", false, 2, null)) {
                        z = true;
                    }
                    if (t62.a(z).booleanValue()) {
                        arrayList.add(obj2);
                    }
                }
                activityAppContents.f5129b = new ArrayList(arrayList);
                fg2 fg2VarC = qe2.c();
                f81 f81Var = new f81(this, null);
                this.f5134a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, f81Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wz0 f8517a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ListView f5135a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5137a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WeakReference f5138a;

        public h(ListView listView, wz0 wz0Var, WeakReference weakReference, String str) {
            this.f5135a = listView;
            this.f8517a = wz0Var;
            this.f5138a = weakReference;
            this.f5137a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f5135a.setAdapter((ListAdapter) this.f8517a);
                this.f5135a.setOnItemClickListener(new g81(this));
            } catch (Exception unused) {
            }
        }
    }

    public ActivityAppContents() {
        ArrayList<String> arrayListC = y42.c("activity", "service", "receiver", "provider");
        this.f5127a = arrayListC;
        this.f5126a = (String) i52.A(arrayListC);
        this.b = "";
    }

    public static final /* synthetic */ kh0 k(ActivityAppContents activityAppContents) {
        kh0 kh0Var = activityAppContents.f8509a;
        if (kh0Var != null) {
            return kh0Var;
        }
        f92.m("appListHelper");
        throw null;
    }

    public static final /* synthetic */ u90 n(ActivityAppContents activityAppContents) {
        u90 u90Var = activityAppContents.f5124a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("processBarDialog");
        throw null;
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5128a == null) {
            this.f5128a = new HashMap();
        }
        View view = (View) this.f5128a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5128a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558435);
        this.f5124a = new u90(this, null, 2, null);
        boolean z = false;
        this.f8509a = new kh0(this, z, 2, null);
        setBackArrow();
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.loading_view);
        f92.c(linearLayout, "loading_view");
        linearLayout.setVisibility(0);
        qc2.d(xd2.a(qe2.b()), null, null, new b(null), 3, null);
        qi0 qi0Var = new qi0(null, 1, null);
        Spinner spinner = (Spinner) _$_findCachedViewById(t61.contents_filter);
        f92.c(spinner, "contents_filter");
        qi0Var.h(spinner, new c());
        ((EditText) _$_findCachedViewById(t61.apps_search_box)).setOnEditorActionListener(new d());
        m92 m92Var = new m92();
        m92Var.f6785a = 0L;
        ((EditText) _$_findCachedViewById(t61.apps_search_box)).addTextChangedListener(new t31(new e(m92Var)));
        f fVar = new f();
        ListView listView = (ListView) _$_findCachedViewById(t61.app_list);
        f92.c(listView, "app_list");
        listView.setOnItemLongClickListener(fVar);
        u();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_am));
    }

    public final void u() {
        u90 u90Var = this.f5124a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        qc2.d(hf2.f6309a, qe2.a(), null, new g(null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x006f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(java.util.ArrayList<com.omarea.model.AppInfo> r17, android.widget.ListView r18) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityAppContents.v(java.util.ArrayList, android.widget.ListView):void");
    }

    public final void w(String str) {
        f92.d(str, "value");
        if (!f92.a(this.b, str)) {
            this.b = str;
            ListView listView = (ListView) _$_findCachedViewById(t61.app_list);
            if (listView != null) {
                v(this.f5129b, listView);
            }
        }
    }
}
