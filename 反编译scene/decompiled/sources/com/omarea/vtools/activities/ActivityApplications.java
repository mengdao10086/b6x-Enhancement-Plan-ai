package com.omarea.vtools.activities;

import a.a91;
import a.b62;
import a.b91;
import a.d72;
import a.e30;
import a.e50;
import a.f92;
import a.fg2;
import a.g91;
import a.gr1;
import a.h42;
import a.hr1;
import a.ih0;
import a.jl;
import a.k82;
import a.m42;
import a.m92;
import a.mh0;
import a.n92;
import a.oc2;
import a.p80;
import a.pj0;
import a.qc2;
import a.qe2;
import a.r62;
import a.rr1;
import a.t31;
import a.t61;
import a.t62;
import a.u61;
import a.u81;
import a.v81;
import a.vo0;
import a.wd2;
import a.wq1;
import a.x31;
import a.x62;
import a.xd2;
import a.y42;
import a.yb;
import a.z42;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.omarea.Scene;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityApplications extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gr1 f8561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mh0 f5173a = new mh0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rr1 f5174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wq1 f5175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f5176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5178a;

    public interface a {
        void a();
    }

    public static final class b implements a {
        public b() {
        }

        @Override // com.omarea.vtools.activities.ActivityApplications.a
        public void a() {
            qc2.d(xd2.a(qe2.c()), null, null, new u81(this, null), 3, null);
        }
    }

    public static final class c implements TabLayout.d {
        public c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
            if (gVar == null || gVar.f() != 2 || Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager() || ActivityApplications.this.f5173a.a(ActivityApplications.this.getContext(), ActivityApplications.this.f5177a)) {
                return;
            }
            Toast.makeText(ActivityApplications.this.getContext(), ActivityApplications.this.getString(u61.please_choose_backup_dir), 0).show();
            ActivityApplications.this.q();
        }
    }

    public static final class d implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8564a;

        public d(n92 n92Var) {
            this.f8564a = n92Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && i != 5 && i != 3) {
                return true;
            }
            ActivityApplications activityApplications = ActivityApplications.this;
            EditText editText = (EditText) activityApplications._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            Editable text = editText.getText();
            f92.c(text, "apps_search_box.text");
            activityApplications.p(text, (hr1) this.f8564a.f6891a);
            return true;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m92 f8565a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ n92 f5180a;

        public e(m92 m92Var, n92 n92Var) {
            this.f8565a = m92Var;
            this.f5180a = n92Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f8565a.f6785a = jCurrentTimeMillis;
            Scene.f4798a.j(new v81(this, jCurrentTimeMillis), 500L);
        }
    }

    public static final class f implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8566a;

        public f(n92 n92Var) {
            this.f8566a = n92Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.f8566a.f6891a = rr1.f7326a.b()[i];
            ActivityApplications activityApplications = ActivityApplications.this;
            EditText editText = (EditText) activityApplications._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            Editable text = editText.getText();
            f92.c(text, "apps_search_box.text");
            activityApplications.p(text, (hr1) this.f8566a.f6891a);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityApplications$onOptionsItemSelected$1", f = "ActivityApplications.kt", l = {90, 130}, m = "invokeSuspend")
    public static final class g extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8567a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f5183a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5185a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5186b;
        public Object c;
        public Object d;
        public Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(n92 n92Var, b62 b62Var) {
            super(2, b62Var);
            this.f8567a = n92Var;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            g gVar = ActivityApplications.this.new g(this.f8567a, b62Var);
            gVar.f5183a = (wd2) obj;
            return gVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((g) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [T, a.ih0] */
        @Override // a.s62
        public final Object j(Object obj) throws e30 {
            Object objC = r62.c();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            } else {
                h42.b(obj);
                wd2 wd2Var = this.f5183a;
                List<String> listA = new vo0(ActivityApplications.this).A();
                if (listA == null) {
                    listA = y42.e();
                }
                if (!listA.isEmpty()) {
                    n92 n92Var = new n92();
                    n92Var.f6891a = new ih0(ActivityApplications.this, 0, 0, 6, null);
                    ArrayList<ApplicationInfo> arrayListA = new pj0().a(ActivityApplications.this);
                    f92.c(arrayListA, "UninstalledApp().getList(context)");
                    ArrayList arrayList = new ArrayList(z42.m(arrayListA, 10));
                    Iterator<T> it = arrayListA.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((ApplicationInfo) it.next()).packageName);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : listA) {
                        if (t62.a(!arrayList.contains((String) obj2)).booleanValue()) {
                            arrayList2.add(obj2);
                        }
                    }
                    fg2 fg2VarC = qe2.c();
                    a91 a91Var = new a91(this, arrayList2, n92Var, null);
                    this.f5185a = wd2Var;
                    this.f5186b = listA;
                    this.c = n92Var;
                    this.d = arrayList;
                    this.e = arrayList2;
                    this.b = 1;
                    if (oc2.g(fg2VarC, a91Var, this) == objC) {
                        return objC;
                    }
                } else {
                    fg2 fg2VarC2 = qe2.c();
                    b91 b91Var = new b91(this, null);
                    this.f5185a = wd2Var;
                    this.f5186b = listA;
                    this.b = 2;
                    if (oc2.g(fg2VarC2, b91Var, this) == objC) {
                        return objC;
                    }
                }
            }
            return m42.f6769a;
        }
    }

    public ActivityApplications() {
        b bVar = new b();
        this.f5176a = bVar;
        this.f5174a = rr1.f7326a.a(bVar);
        this.f8561a = gr1.f6236a.a(this.f5176a);
        this.f5175a = wq1.f7814a.a(this.f5176a);
        this.f5177a = "/sdcard/Android/media/backups";
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5178a == null) {
            this.f5178a = new HashMap();
        }
        View view = (View) this.f5178a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5178a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void o() {
        try {
            this.f5174a.J1();
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        try {
            this.f8561a.I1();
        } catch (Exception e3) {
            e3.getStackTrace();
        }
        try {
            this.f5175a.I1();
        } catch (Exception e4) {
            e4.getStackTrace();
        }
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 8000) {
            if (i2 == -1) {
                o();
            }
        } else {
            if (intent == null || intent.getData() == null) {
                return;
            }
            this.f5173a.f(this, this.f5177a, intent.getData());
        }
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [T, a.hr1] */
    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558440);
        setBackArrow();
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(t61.tab_list);
        f92.c(tabLayout, "tab_list");
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(t61.tab_content);
        f92.c(viewPager, "tab_content");
        jl supportFragmentManager = getSupportFragmentManager();
        f92.c(supportFragmentManager, "supportFragmentManager");
        x31 x31Var = new x31(tabLayout, viewPager, this, supportFragmentManager, 0, 16, null);
        Drawable drawableD = yb.d(getContext(), 2131231165);
        f92.b(drawableD);
        f92.c(drawableD, "ContextCompat.getDrawabl…xt, R.drawable.tab_app)!!");
        x31Var.g("Installed", drawableD, this.f5174a);
        Drawable drawableD2 = yb.d(getContext(), 2131231168);
        f92.b(drawableD2);
        f92.c(drawableD2, "ContextCompat.getDrawabl….drawable.tab_security)!!");
        x31Var.g("System", drawableD2, this.f8561a);
        if (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager()) {
            Drawable drawableD3 = yb.d(getContext(), 2131231167);
            f92.b(drawableD3);
            f92.c(drawableD3, "ContextCompat.getDrawabl…R.drawable.tab_package)!!");
            x31Var.g("Backups", drawableD3, this.f5175a);
        }
        ViewPager viewPager2 = (ViewPager) _$_findCachedViewById(t61.tab_content);
        f92.c(viewPager2, "tab_content");
        viewPager2.setAdapter(x31Var.f());
        ViewPager viewPager3 = (ViewPager) _$_findCachedViewById(t61.tab_content);
        f92.c(viewPager3, "tab_content");
        viewPager3.setOffscreenPageLimit(4);
        ((TabLayout) _$_findCachedViewById(t61.tab_list)).c(new c());
        n92 n92Var = new n92();
        n92Var.f6891a = hr1.All;
        ((EditText) _$_findCachedViewById(t61.apps_search_box)).setOnEditorActionListener(new d(n92Var));
        m92 m92Var = new m92();
        m92Var.f6785a = 0L;
        ((EditText) _$_findCachedViewById(t61.apps_search_box)).addTextChangedListener(new t31(new e(m92Var, n92Var)));
        Spinner spinner = (Spinner) _$_findCachedViewById(t61.apps_filter);
        if (spinner == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Spinner");
        }
        spinner.setOnItemSelectedListener(new f(n92Var));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        f92.d(menu, "menu");
        getMenuInflater().inflate(2131623939, menu);
        MenuItem menuItemFindItem = menu.findItem(t61.action_batch_uninstall);
        if (menuItemFindItem == null) {
            return true;
        }
        menuItemFindItem.setVisible(f92.a(e50.f677a.y0(), "root"));
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, a.p80$b] */
    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f92.d(menuItem, "item");
        if (menuItem.getItemId() == 2131361929) {
            startActivityForResult(new Intent(getContext(), (Class<?>) ActivityAppRetrieve.class), 101);
            return true;
        }
        if (menuItem.getItemId() == 2131361904) {
            n92 n92Var = new n92();
            n92Var.f6891a = p80.a.G(p80.f2403a, this, null, 2, null);
            qc2.d(xd2.a(qe2.b()), null, null, new g(n92Var, null), 3, null);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_applictions));
    }

    public final void p(Editable editable, hr1 hr1Var) {
        String string = editable.toString();
        this.f5174a.N1(string);
        this.f5174a.K1(hr1Var);
        this.f8561a.M1(string);
        this.f8561a.J1(hr1Var);
        this.f5175a.M1(string);
        this.f5175a.J1(hr1Var);
    }

    public final void q() {
        Intent intent = null;
        if (Build.VERSION.SDK_INT >= 24) {
            Object systemService = getSystemService(StorageManager.class);
            f92.c(systemService, "getSystemService(StorageManager::class.java)");
            StorageVolume storageVolume = ((StorageManager) systemService).getStorageVolume(new File(this.f5177a));
            if (storageVolume != null) {
                intent = storageVolume.createAccessIntent(null);
            }
        }
        if (intent == null) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        }
        startActivityForResult(intent, 8000);
    }
}
