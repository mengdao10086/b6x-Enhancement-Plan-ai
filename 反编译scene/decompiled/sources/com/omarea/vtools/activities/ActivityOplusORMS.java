package com.omarea.vtools.activities;

import a.b62;
import a.bj0;
import a.c60;
import a.d72;
import a.ec2;
import a.f92;
import a.fd1;
import a.fg2;
import a.g91;
import a.gd1;
import a.h42;
import a.hd1;
import a.id1;
import a.k82;
import a.m42;
import a.n92;
import a.oc2;
import a.p80;
import a.q92;
import a.qc2;
import a.qe2;
import a.r62;
import a.s60;
import a.t61;
import a.u61;
import a.u90;
import a.v62;
import a.wd2;
import a.x62;
import a.xd2;
import a.y60;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.omarea.Scene;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityOplusORMS extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u90 f8776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5377a = "";
    public final String b = c60.f5764a.e() + "/Android/scene-orms.xml";

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y60 y60Var = y60.f7952a;
            String str = bj0.c;
            f92.c(str, "ORMS.CloudFile");
            y60Var.b(str);
            Scene.c.p(Scene.f4798a, "OK ^_^", 0, 2, null);
            ActivityOplusORMS.this.finishAfterTransition();
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityOplusORMS$onOptionsItemSelected$2", f = "ActivityOplusORMS.kt", l = {157, 164, 170}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8778a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5380a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5381b;

        public b(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = ActivityOplusORMS.this.new b(b62Var);
            bVar.f8778a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.String] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            ?? r1 = this.b;
            try {
                if (r1 == 0) {
                    h42.b(obj);
                    wd2 wd2Var = this.f8778a;
                    n92 n92Var = new n92();
                    n92Var.f6891a = new bj0().a(false);
                    f92.c((EditText) ActivityOplusORMS.this._$_findCachedViewById(t61.thermal_config), "thermal_config");
                    if (!f92.a((String) r6, r7.getText().toString())) {
                        fg2 fg2VarC = qe2.c();
                        fd1 fd1Var = new fd1(this, n92Var, null);
                        this.f5380a = wd2Var;
                        this.f5381b = n92Var;
                        this.b = 1;
                        if (oc2.g(fg2VarC, fd1Var, this) == objC) {
                            return objC;
                        }
                        ActivityOplusORMS.this.r();
                    } else {
                        fg2 fg2VarC2 = qe2.c();
                        gd1 gd1Var = new gd1(this, null);
                        this.f5380a = wd2Var;
                        this.f5381b = n92Var;
                        this.b = 2;
                        if (oc2.g(fg2VarC2, gd1Var, this) == objC) {
                            return objC;
                        }
                    }
                } else if (r1 == 1) {
                    h42.b(obj);
                    ActivityOplusORMS.this.r();
                } else if (r1 == 2) {
                    h42.b(obj);
                } else {
                    if (r1 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                }
            } catch (Exception e) {
                fg2 fg2VarC3 = qe2.c();
                hd1 hd1Var = new hd1(this, null);
                this.f5380a = r1;
                this.f5381b = e;
                this.b = 3;
                if (oc2.g(fg2VarC3, hd1Var, this) == objC) {
                    return objC;
                }
            }
            return m42.f6769a;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8779a;
        public final /* synthetic */ String b;

        public c(String str, String str2) {
            this.f8779a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Scene.c cVar;
            String str;
            if (y60.f7952a.l(this.f8779a, this.b)) {
                cVar = Scene.f4798a;
                str = "OK, ^_^";
            } else {
                cVar = Scene.f4798a;
                str = ">_<";
            }
            Scene.c.p(cVar, str, 0, 2, null);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityOplusORMS$onViewCreated$1", f = "ActivityOplusORMS.kt", l = {51, 56}, m = "invokeSuspend")
    public static final class d extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8780a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5383a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5384b;
        public Object c;

        public d(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            d dVar = ActivityOplusORMS.this.new d(b62Var);
            dVar.f8780a = (wd2) obj;
            return dVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((d) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    h42.b(obj);
                    return m42.f6769a;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            h42.b(obj);
            wd2 wd2Var = this.f8780a;
            String str = bj0.f5709a;
            String str2 = bj0.c;
            y60 y60Var = y60.f7952a;
            f92.c(str2, "file2");
            if (y60Var.d(str2)) {
                ActivityOplusORMS.this.f5377a = str2;
            } else {
                y60 y60Var2 = y60.f7952a;
                f92.c(str, "file1");
                if (!y60Var2.d(str)) {
                    fg2 fg2VarC = qe2.c();
                    id1 id1Var = new id1(this, null);
                    this.f5383a = wd2Var;
                    this.f5384b = str;
                    this.c = str2;
                    this.b = 1;
                    if (oc2.g(fg2VarC, id1Var, this) == objC) {
                        return objC;
                    }
                    return m42.f6769a;
                }
                ActivityOplusORMS.this.f5377a = str;
            }
            ActivityOplusORMS activityOplusORMS = ActivityOplusORMS.this;
            this.f5383a = wd2Var;
            this.f5384b = str;
            this.c = str2;
            this.b = 2;
            if (activityOplusORMS.o(this) == objC) {
                return objC;
            }
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityOplusORMS", f = "ActivityOplusORMS.kt", l = {96}, m = "readConfig")
    public static final class e extends v62 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8781a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public /* synthetic */ Object f5386a;
        public Object b;
        public Object c;
        public Object d;

        public e(b62 b62Var) {
            super(b62Var);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            this.f5386a = obj;
            this.f8781a |= Integer.MIN_VALUE;
            return ActivityOplusORMS.this.o(this);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityOplusORMS$readConfig$2", f = "ActivityOplusORMS.kt", l = {}, m = "invokeSuspend")
    public static final class f extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8782a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f5387a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(n92 n92Var, b62 b62Var) {
            super(2, b62Var);
            this.f8782a = n92Var;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            f fVar = ActivityOplusORMS.this.new f(this.f8782a, b62Var);
            fVar.f5387a = (wd2) obj;
            return fVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((f) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            ((EditText) ActivityOplusORMS.this._$_findCachedViewById(t61.thermal_config)).setText((String) this.f8782a.f6891a);
            ActivityOplusORMS.this.setTitle(new File(ActivityOplusORMS.this.f5377a).getName());
            return m42.f6769a;
        }
    }

    public static final /* synthetic */ u90 k(ActivityOplusORMS activityOplusORMS) {
        u90 u90Var = activityOplusORMS.f8776a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("progressBarDialog");
        throw null;
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5378a == null) {
            this.f5378a = new HashMap();
        }
        View view = (View) this.f5378a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5378a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void n() {
        Intent intent = new Intent(this, (Class<?>) ActivityFileSelector.class);
        intent.putExtra("extension", ".xml");
        startActivityForResult(intent, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object o(a.b62<? super a.m42> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.omarea.vtools.activities.ActivityOplusORMS.e
            if (r0 == 0) goto L13
            r0 = r8
            com.omarea.vtools.activities.ActivityOplusORMS$e r0 = (com.omarea.vtools.activities.ActivityOplusORMS.e) r0
            int r1 = r0.f8781a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8781a = r1
            goto L18
        L13:
            com.omarea.vtools.activities.ActivityOplusORMS$e r0 = new com.omarea.vtools.activities.ActivityOplusORMS$e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f5386a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f8781a
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r1 = r0.d
            a.n92 r1 = (a.n92) r1
            java.lang.Object r1 = r0.c
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.b
            com.omarea.vtools.activities.ActivityOplusORMS r0 = (com.omarea.vtools.activities.ActivityOplusORMS) r0
            a.h42.b(r8)     // Catch: java.lang.Exception -> L71
            goto L71
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3d:
            a.h42.b(r8)
            a.y60 r8 = a.y60.f7952a     // Catch: java.lang.Exception -> L71
            java.lang.String r2 = r7.f5377a     // Catch: java.lang.Exception -> L71
            java.lang.String r8 = r8.i(r2)     // Catch: java.lang.Exception -> L71
            a.n92 r2 = new a.n92     // Catch: java.lang.Exception -> L71
            r2.<init>()     // Catch: java.lang.Exception -> L71
            a.bj0 r4 = new a.bj0     // Catch: java.lang.Exception -> L71
            r4.<init>()     // Catch: java.lang.Exception -> L71
            java.lang.String r4 = r4.d(r8)     // Catch: java.lang.Exception -> L71
            r2.f6891a = r4     // Catch: java.lang.Exception -> L71
            a.fg2 r4 = a.qe2.c()     // Catch: java.lang.Exception -> L71
            com.omarea.vtools.activities.ActivityOplusORMS$f r5 = new com.omarea.vtools.activities.ActivityOplusORMS$f     // Catch: java.lang.Exception -> L71
            r6 = 0
            r5.<init>(r2, r6)     // Catch: java.lang.Exception -> L71
            r0.b = r7     // Catch: java.lang.Exception -> L71
            r0.c = r8     // Catch: java.lang.Exception -> L71
            r0.d = r2     // Catch: java.lang.Exception -> L71
            r0.f8781a = r3     // Catch: java.lang.Exception -> L71
            java.lang.Object r8 = a.oc2.g(r4, r5, r0)     // Catch: java.lang.Exception -> L71
            if (r8 != r1) goto L71
            return r1
        L71:
            a.m42 r8 = a.m42.f6769a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityOplusORMS.o(a.b62):java.lang.Object");
    }

    @Override // a.cl, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 99) {
            p();
            return;
        }
        if (i2 != -1 || intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("file")) {
            Toast.makeText(this, getString(u61.img_file_not_found), 0).show();
            return;
        }
        Bundle extras2 = intent.getExtras();
        f92.b(extras2);
        String string = extras2.getString("file");
        f92.b(string);
        f92.c(string, "data.extras!!.getString(\"file\")!!");
        ((EditText) _$_findCachedViewById(t61.thermal_config)).setText(y60.f7952a.i(string));
        Scene.c.p(Scene.f4798a, "OK, ^_^", 0, 2, null);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558457);
        setBackArrow();
        onViewCreated();
        this.f8776a = new u90(this, null, 2, null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        f92.d(menu, "menu");
        getMenuInflater().inflate(2131623940, menu);
        Integer[] numArr = {2131361930, Integer.valueOf(t61.action_auto), Integer.valueOf(t61.action_import), Integer.valueOf(t61.action_export), Integer.valueOf(t61.action_mt)};
        for (int i = 0; i < 5; i++) {
            menu.findItem(numArr[i].intValue()).setVisible(true);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        p80.a aVar;
        Context context;
        String string;
        String str;
        Runnable cVar;
        Runnable runnable;
        int i;
        Object obj;
        f92.d(menuItem, "item");
        super.onOptionsItemSelected(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == 2131361930) {
            r();
        } else {
            if (itemId == 2131361928) {
                aVar = p80.f2403a;
                string = getString(u61.orms_restore);
                f92.c(string, "getString(R.string.orms_restore)");
                cVar = new a();
                runnable = null;
                i = 16;
                obj = null;
                str = "";
                context = this;
            } else if (itemId == 2131361896) {
                u90 u90Var = this.f8776a;
                if (u90Var == null) {
                    f92.m("progressBarDialog");
                    throw null;
                }
                u90.e(u90Var, null, 1, null);
                qc2.d(xd2.a(qe2.b()), null, null, new b(null), 3, null);
            } else if (itemId == 2131361915) {
                n();
            } else if (itemId == 2131361910) {
                String str2 = c60.f5764a.e() + '/' + new File(this.f5377a).getName();
                EditText editText = (EditText) _$_findCachedViewById(t61.thermal_config);
                f92.c(editText, "thermal_config");
                String string2 = editText.getText().toString();
                aVar = p80.f2403a;
                context = getContext();
                string = getString(u61.editor_export);
                f92.c(string, "getString(R.string.editor_export)");
                q92 q92Var = q92.f7191a;
                String string3 = getString(u61.orms_export_warn);
                f92.c(string3, "getString(R.string.orms_export_warn)");
                str = String.format(string3, Arrays.copyOf(new Object[]{str2}, 1));
                f92.c(str, "java.lang.String.format(format, *args)");
                cVar = new c(str2, string2);
                runnable = null;
                i = 16;
                obj = null;
            } else if (itemId == 2131361922) {
                s();
            }
            aVar.i(context, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : str, (16 & 8) != 0 ? null : cVar, (16 & 16) != 0 ? null : runnable);
        }
        return true;
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_oplus_orms));
    }

    public final void onViewCreated() {
        qc2.d(xd2.a(qe2.b()), null, null, new d(null), 3, null);
    }

    public final void p() {
        String strI = y60.f7952a.i(this.b);
        if (strI == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string = ec2.r0(strI).toString();
        EditText editText = (EditText) _$_findCachedViewById(t61.thermal_config);
        f92.c(editText, "thermal_config");
        if (editText.getText().toString() == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (!f92.a(string, ec2.r0(r2).toString())) {
            ((EditText) _$_findCachedViewById(t61.thermal_config)).setText(string);
            r();
        } else {
            Scene.c cVar = Scene.f4798a;
            String string2 = getString(u61.editor_unchanged);
            f92.c(string2, "getString(R.string.editor_unchanged)");
            Scene.c.p(cVar, string2, 0, 2, null);
        }
    }

    public final void q() {
        s60.f7366a.a("am stack list | grep bin.mt.plus | cut -f1 -d ':' | cut -f2 -d '=' | xargs am stack remove");
    }

    @SuppressLint({"RestrictedApi"})
    public final void r() {
        String str;
        bj0 bj0Var = new bj0();
        EditText editText = (EditText) _$_findCachedViewById(t61.thermal_config);
        f92.c(editText, "thermal_config");
        Object text = editText.getText();
        if (text == null) {
            text = "";
        }
        String strG = bj0Var.g(text.toString());
        y60 y60Var = y60.f7952a;
        String str2 = bj0.b;
        f92.c(str2, "ORMS.CloudDir");
        String str3 = y60Var.c(str2) ? bj0.c : "/sdcard/orms_core_config.xml";
        y60 y60Var2 = y60.f7952a;
        f92.c(str3, "out");
        f92.c(strG, "content");
        if (y60Var2.l(str3, strG)) {
            str = "^_^ -> " + str3;
        } else {
            str = ">_<!";
        }
        Toast.makeText(this, str, 0).show();
    }

    public final void s() {
        String str = this.b;
        y60 y60Var = y60.f7952a;
        EditText editText = (EditText) _$_findCachedViewById(t61.thermal_config);
        f92.c(editText, "thermal_config");
        y60Var.l(str, editText.getText().toString());
        try {
            q();
            ComponentName componentName = new ComponentName("bin.mt.plus", "bin.mt.plus.OpenFileActivity");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setComponent(componentName);
            intent.addFlags(16384);
            intent.addFlags(8388608);
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/xml");
            startActivityForResult(intent, 99);
        } catch (Exception unused) {
        }
    }
}
