package com.omarea.vtools.activities;

import a.ad1;
import a.b62;
import a.bd1;
import a.cd1;
import a.cy0;
import a.d72;
import a.dd1;
import a.f92;
import a.fg2;
import a.g91;
import a.h42;
import a.hf2;
import a.k82;
import a.m11;
import a.m42;
import a.n11;
import a.oc2;
import a.qc2;
import a.qe2;
import a.qi0;
import a.r62;
import a.t61;
import a.u61;
import a.wd2;
import a.x62;
import a.yi0;
import a.yn0;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.Scene;
import com.omarea.model.MagiskModuleUnofficial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityModules extends g91 implements m11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yi0 f8772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5369a = "*";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<MagiskModuleUnofficial> f5370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5371a;
    public boolean b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8773a;

        public a(Context context) {
            this.f8773a = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityModules.this.startActivityForResult(new Intent(this.f8773a, (Class<?>) ActivityModuleUpload.class), 0);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityModules$refresh$1", f = "ActivityModules.kt", l = {134, 138}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8774a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5374a;
        public int b;

        public b(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = ActivityModules.this.new b(b62Var);
            bVar.f8774a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            Object obj2 = this.b;
            if (obj2 == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8774a;
                yi0 yi0Var = ActivityModules.this.f8772a;
                f92.b(yi0Var);
                this.f5374a = wd2Var;
                this.b = 1;
                obj2 = wd2Var;
                if (yi0Var.d(this) == objC) {
                    return objC;
                }
            } else {
                if (obj2 != 1) {
                    if (obj2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                    ActivityModules.this.b = false;
                    return m42.f6769a;
                }
                wd2 wd2Var2 = (wd2) this.f5374a;
                h42.b(obj);
                obj2 = wd2Var2;
            }
            if (!ActivityModules.this.isDestroyed()) {
                fg2 fg2VarC = qe2.c();
                cd1 cd1Var = new cd1(this, null);
                this.f5374a = obj2;
                this.b = 2;
                if (oc2.g(fg2VarC, cd1Var, this) == objC) {
                    return objC;
                }
                ActivityModules.this.b = false;
            }
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityModules$refreshCloudList$1", f = "ActivityModules.kt", l = {116}, m = "invokeSuspend")
    public static final class c extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8775a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5376a;
        public int b;

        public c(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            c cVar = ActivityModules.this.new c(b62Var);
            cVar.f8775a = (wd2) obj;
            return cVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((c) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            try {
                if (i == 0) {
                    h42.b(obj);
                    wd2 wd2Var = this.f8775a;
                    ActivityModules.this.f5370a = new yn0().A().get(10L, TimeUnit.SECONDS);
                    fg2 fg2VarC = qe2.c();
                    dd1 dd1Var = new dd1(this, null);
                    this.f5376a = wd2Var;
                    this.b = 1;
                    if (oc2.g(fg2VarC, dd1Var, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                }
            } catch (Exception unused) {
            }
            return m42.f6769a;
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5371a == null) {
            this.f5371a = new HashMap();
        }
        View view = (View) this.f5371a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5371a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007f A[Catch: Exception -> 0x0126, TryCatch #0 {Exception -> 0x0126, blocks: (B:9:0x0031, B:11:0x003c, B:19:0x0060, B:21:0x0066, B:26:0x0078, B:36:0x00b1, B:38:0x00bf, B:42:0x00e9, B:44:0x00f2, B:48:0x0107, B:49:0x010d, B:39:0x00cf, B:40:0x00d6, B:41:0x00d7, B:27:0x007f, B:32:0x008e, B:33:0x0093, B:18:0x004b), top: B:56:0x0031 }] */
    @Override // a.m11
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.view.View r12, int r13) {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityModules.a(android.view.View, int):void");
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            r();
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558470);
        setBackArrow();
        p(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131623943, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        f92.d(menuItem, "item");
        if (menuItem.getItemId() != 2131361927) {
            return super.onOptionsItemSelected(menuItem);
        }
        r();
        q();
        return true;
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_modules));
    }

    public final void p(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.H2(1);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.module_list);
        f92.c(recyclerView, "module_list");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((ImageView) _$_findCachedViewById(t61.module_upload)).setOnClickListener(new a(context));
        yi0 yi0Var = new yi0(context);
        this.f8772a = yi0Var;
        f92.b(yi0Var);
        ArrayList<cy0> arrayListE = yi0Var.e();
        r();
        if (arrayListE.size() < 1) {
            q();
        }
        qi0 qi0Var = new qi0(null, 1, null);
        EditText editText = (EditText) _$_findCachedViewById(t61.module_search);
        f92.c(editText, "module_search");
        qi0Var.f(editText, new ad1(this));
        Spinner spinner = (Spinner) _$_findCachedViewById(t61.module_source);
        f92.c(spinner, "module_source");
        qi0Var.h(spinner, new bd1(this));
    }

    public final void q() {
        if (this.b) {
            Scene.c.p(Scene.f4798a, "Loading…", 0, 2, null);
            return;
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.module_list);
        f92.c(recyclerView, "module_list");
        recyclerView.setAdapter(new n11(getContext(), new ArrayList()));
        this.b = true;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.loading_view);
        f92.c(linearLayout, "loading_view");
        linearLayout.setVisibility(0);
        qc2.d(hf2.f6309a, qe2.b(), null, new b(null), 2, null);
    }

    public final void r() {
        qc2.d(hf2.f6309a, qe2.b(), null, new c(null), 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        r0 = new java.util.ArrayList<>();
        r1 = r7.f5370a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r1 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        a.f92.b(r1);
        r2 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r1.hasNext() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r4 = r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (a.f92.a(((com.omarea.model.MagiskModuleUnofficial) r4).getSource(), r7.f5369a) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        r2.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        r0.addAll(r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityModules.s():void");
    }
}
