package com.omarea.vtools.activities;

import a.a21;
import a.a42;
import a.af1;
import a.b62;
import a.cf1;
import a.d72;
import a.df1;
import a.e50;
import a.ec2;
import a.f92;
import a.ff1;
import a.g91;
import a.g92;
import a.h42;
import a.hf1;
import a.i52;
import a.if1;
import a.k82;
import a.kf1;
import a.lf1;
import a.m42;
import a.mf1;
import a.n92;
import a.nb2;
import a.om0;
import a.p80;
import a.qc2;
import a.qe2;
import a.r62;
import a.t61;
import a.u61;
import a.v62;
import a.v72;
import a.wd2;
import a.x62;
import a.xd2;
import a.y60;
import a.z32;
import a.ze1;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.model.ProcessInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityProcess extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nb2 f8855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om0 f5463a = new om0(Scene.f4798a.c());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f5464a = a42.a(new g());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f5466a;
    public boolean b;

    @x62(c = "com.omarea.vtools.activities.ActivityProcess", f = "ActivityProcess.kt", l = {247}, m = "getDetail")
    public static final class a extends v62 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8856a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public /* synthetic */ Object f5468a;
        public Object b;
        public Object c;

        public a(b62 b62Var) {
            super(b62Var);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            this.f5468a = obj;
            this.f8856a |= Integer.MIN_VALUE;
            return ActivityProcess.this.n(null, this);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityProcess$loadIcon$1", f = "ActivityProcess.kt", l = {}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8857a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ImageView f5469a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ProcessInfo f5470a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ProcessInfo processInfo, ImageView imageView, b62 b62Var) {
            super(2, b62Var);
            this.f5470a = processInfo;
            this.f5469a = imageView;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = ActivityProcess.this.new b(this.f5470a, this.f5469a, b62Var);
            bVar.f8857a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [T, android.graphics.drawable.Drawable] */
        @Override // a.s62
        public final Object j(Object obj) {
            ImageView imageView;
            af1 af1Var;
            ImageView imageView2;
            ze1 ze1Var;
            ?? LoadIcon;
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            n92 n92Var = new n92();
            n92Var.f6891a = null;
            try {
                String str = this.f5470a.name;
                f92.c(str, "item.name");
                LoadIcon = ActivityProcess.this.o().getPackageInfo((String) i52.A(ec2.d0(str, new String[]{":"}, false, 0, 6, null)), 0).applicationInfo.loadIcon(ActivityProcess.this.o());
                n92Var.f6891a = LoadIcon;
            } catch (Exception unused) {
                if (((Drawable) n92Var.f6891a) != null) {
                    imageView2 = this.f5469a;
                    ze1Var = new ze1(this, n92Var);
                } else {
                    imageView = this.f5469a;
                    af1Var = new af1(this);
                    imageView.post(af1Var);
                }
            } catch (Throwable th) {
                if (((Drawable) n92Var.f6891a) != null) {
                    this.f5469a.post(new ze1(this, n92Var));
                } else {
                    this.f5469a.post(new af1(this));
                }
                throw th;
            }
            if (LoadIcon != 0) {
                imageView2 = this.f5469a;
                ze1Var = new ze1(this, n92Var);
                imageView2.post(ze1Var);
                return m42.f6769a;
            }
            imageView = this.f5469a;
            af1Var = new af1(this);
            imageView.post(af1Var);
            return m42.f6769a;
        }
    }

    public static final class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            qc2.d(xd2.a(qe2.b()), null, null, new cf1(this, i, null), 3, null);
        }
    }

    public static final class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            ListView listView = (ListView) ActivityProcess.this._$_findCachedViewById(t61.process_list);
            f92.c(listView, "process_list");
            a21 a21Var = (a21) listView.getAdapter();
            if (a21Var == null) {
                return true;
            }
            f92.c(textView, "v");
            a21Var.n(textView.getText().toString());
            return true;
        }
    }

    public static final class e implements AdapterView.OnItemSelectedListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ((ListView) ActivityProcess.this._$_findCachedViewById(t61.process_list)).smoothScrollToPosition(0);
            ListView listView = (ListView) ActivityProcess.this._$_findCachedViewById(t61.process_list);
            f92.c(listView, "process_list");
            a21 a21Var = (a21) listView.getAdapter();
            if (a21Var != null) {
                int i2 = 1;
                if (i == 0) {
                    i2 = 4;
                } else if (i == 1) {
                    i2 = 8;
                } else if (i == 2) {
                    i2 = 16;
                }
                a21Var.p(i2);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static final class f implements AdapterView.OnItemSelectedListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ((ListView) ActivityProcess.this._$_findCachedViewById(t61.process_list)).smoothScrollToPosition(0);
            ListView listView = (ListView) ActivityProcess.this._$_findCachedViewById(t61.process_list);
            f92.c(listView, "process_list");
            a21 a21Var = (a21) listView.getAdapter();
            if (a21Var != null) {
                int i2 = 1;
                if (i == 0) {
                    i2 = 32;
                } else if (i == 1) {
                    i2 = 4;
                }
                a21Var.m(i2);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public static final class g extends g92 implements v72<PackageManager> {
        public g() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PackageManager i() {
            return ActivityProcess.this.getContext().getPackageManager();
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5472a;

        public h(ArrayList arrayList) {
            this.f5472a = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ListView listView = (ListView) ActivityProcess.this._$_findCachedViewById(t61.process_list);
            a21 a21Var = (a21) (listView != null ? listView.getAdapter() : null);
            if (a21Var != null) {
                a21Var.k(this.f5472a);
            }
        }
    }

    public ActivityProcess() {
        new nb2("u[0-9]+_.*");
        this.f8855a = new nb2(".*\\..*");
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5465a == null) {
            this.f5465a = new HashMap();
        }
        View view = (View) this.f5465a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5465a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object n(com.omarea.model.ProcessInfo r7, a.b62<? super com.omarea.model.ProcessInfo> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.omarea.vtools.activities.ActivityProcess.a
            if (r0 == 0) goto L13
            r0 = r8
            com.omarea.vtools.activities.ActivityProcess$a r0 = (com.omarea.vtools.activities.ActivityProcess.a) r0
            int r1 = r0.f8856a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8856a = r1
            goto L18
        L13:
            com.omarea.vtools.activities.ActivityProcess$a r0 = new com.omarea.vtools.activities.ActivityProcess$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f5468a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f8856a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.c
            com.omarea.model.ProcessInfo r7 = (com.omarea.model.ProcessInfo) r7
            java.lang.Object r7 = r0.b
            com.omarea.vtools.activities.ActivityProcess r7 = (com.omarea.vtools.activities.ActivityProcess) r7
            a.h42.b(r8)
            goto L4e
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            a.h42.b(r8)
            a.om0 r8 = r6.f5463a
            int r2 = r7.pid
            r0.b = r6
            r0.c = r7
            r0.f8856a = r3
            java.lang.Object r8 = r8.b(r2, r0)
            if (r8 != r1) goto L4d
            return r1
        L4d:
            r7 = r6
        L4e:
            com.omarea.model.ProcessInfo r8 = (com.omarea.model.ProcessInfo) r8
            if (r8 == 0) goto L96
            java.lang.String r0 = r8.name
            java.lang.String r1 = "detail.name"
            a.f92.c(r0, r1)
            java.lang.String r1 = ":"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            java.util.List r0 = a.ec2.d0(r0, r1, r2, r3, r4, r5)
            java.lang.Object r0 = a.i52.A(r0)
            java.lang.String r0 = (java.lang.String) r0
            android.content.pm.PackageManager r1 = r7.o()     // Catch: java.lang.Exception -> L94
            r2 = 0
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r0, r2)     // Catch: java.lang.Exception -> L94
            java.lang.String r2 = "pm.getApplicationInfo(name, 0)"
            a.f92.c(r1, r2)     // Catch: java.lang.Exception -> L94
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L94
            r2.<init>()     // Catch: java.lang.Exception -> L94
            java.lang.String r3 = ""
            r2.append(r3)     // Catch: java.lang.Exception -> L94
            android.content.pm.PackageManager r7 = r7.o()     // Catch: java.lang.Exception -> L94
            java.lang.CharSequence r7 = r1.loadLabel(r7)     // Catch: java.lang.Exception -> L94
            r2.append(r7)     // Catch: java.lang.Exception -> L94
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Exception -> L94
        L94:
            r8.friendlyName = r0
        L96:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityProcess.n(com.omarea.model.ProcessInfo, a.b62):java.lang.Object");
    }

    public final PackageManager o() {
        return (PackageManager) this.f5464a.getValue();
    }

    @Override // a.g91, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558471);
        setBackArrow();
        r(this);
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        t();
        super.onPause();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_processes));
        u();
    }

    public final boolean p(ProcessInfo processInfo) {
        String str = processInfo.name;
        String str2 = processInfo.command;
        f92.c(str2, "processInfo.command");
        boolean z = false;
        if (ec2.C(str2, "app_process", false, 2, null)) {
            f92.c(str, "name");
            if (this.f8855a.f(str)) {
                return true;
            }
        }
        try {
            f92.c(str, "name");
            if (getPackageManager().getPackageInfo((String) i52.A(ec2.d0(str, new String[]{":"}, false, 0, 6, null)), 0) != null) {
                z = true;
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public final void q(ImageView imageView, ProcessInfo processInfo) {
        qc2.d(xd2.a(qe2.b()), null, null, new b(processInfo, imageView, null), 3, null);
    }

    public final void r(Context context) {
        Bundle extras;
        String string;
        List listD0;
        boolean zG = this.f5463a.g();
        this.b = zG;
        if (zG) {
            TextView textView = (TextView) _$_findCachedViewById(t61.process_unsupported);
            f92.c(textView, "process_unsupported");
            textView.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(t61.process_view);
            f92.c(relativeLayout, "process_view");
            relativeLayout.setVisibility(0);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(t61.process_unsupported);
            f92.c(textView2, "process_unsupported");
            textView2.setVisibility(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(t61.process_view);
            f92.c(relativeLayout2, "process_view");
            relativeLayout2.setVisibility(8);
            if (f92.a(e50.f677a.y0(), "basic")) {
                TextView textView3 = (TextView) _$_findCachedViewById(t61.process_unsupported);
                f92.c(textView3, "process_unsupported");
                textView3.setText(getString(u61.only_adb_or_root_mode));
            }
        }
        if (this.b) {
            ListView listView = (ListView) _$_findCachedViewById(t61.process_list);
            f92.c(listView, "process_list");
            a21 a21Var = new a21(context, null, null, 0, 0, 30, null);
            Intent intent = getIntent();
            String str = (intent == null || (extras = intent.getExtras()) == null || (string = extras.getString("name")) == null || (listD0 = ec2.d0(string, new String[]{":"}, false, 0, 6, null)) == null) ? null : (String) i52.A(listD0);
            if (str != null) {
                a21Var.n(str);
                a21Var.m(1);
                ((Spinner) _$_findCachedViewById(t61.process_filter)).setSelection(2);
                ((EditText) _$_findCachedViewById(t61.process_search)).setText(str);
            }
            m42 m42Var = m42.f6769a;
            listView.setAdapter((ListAdapter) a21Var);
            ((ListView) _$_findCachedViewById(t61.process_list)).setOnItemClickListener(new c());
        }
        ((EditText) _$_findCachedViewById(t61.process_search)).setOnEditorActionListener(new d());
        Spinner spinner = (Spinner) _$_findCachedViewById(t61.process_sort_mode);
        f92.c(spinner, "process_sort_mode");
        spinner.setOnItemSelectedListener(new e());
        Spinner spinner2 = (Spinner) _$_findCachedViewById(t61.process_filter);
        f92.c(spinner2, "process_filter");
        spinner2.setOnItemSelectedListener(new f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void s(ProcessInfo processInfo) {
        Object next;
        List listD0;
        p80.b bVar;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        View viewInflate = LayoutInflater.from(this).inflate(2131558538, (ViewGroup) null);
        String str = processInfo.name;
        f92.c(str, "detail.name");
        String str2 = (String) i52.A(ec2.d0(str, new String[]{":"}, false, 0, 6, null));
        try {
            ApplicationInfo applicationInfo = o().getApplicationInfo(str2, 0);
            f92.c(applicationInfo, "pm.getApplicationInfo(name, 0)");
            str2 = "" + applicationInfo.loadLabel(o());
        } catch (Exception unused) {
        }
        processInfo.friendlyName = str2;
        p80.a aVar = p80.f2403a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, this, viewInflate, false, 4, null);
        viewInflate.findViewById(t61.ProcessBasic).setOnClickListener(new df1(this, processInfo, bVarT));
        View viewFindViewById = viewInflate.findViewById(t61.ProcessFriendlyName);
        f92.c(viewFindViewById, "findViewById<TextView>(R.id.ProcessFriendlyName)");
        ((TextView) viewFindViewById).setText(processInfo.friendlyName);
        View viewFindViewById2 = viewInflate.findViewById(t61.ProcessName);
        f92.c(viewFindViewById2, "findViewById<TextView>(R.id.ProcessName)");
        ((TextView) viewFindViewById2).setText(processInfo.name);
        View viewFindViewById3 = viewInflate.findViewById(t61.ProcessMemoryCompact);
        if (y60.f7952a.d("/proc/1/reclaim")) {
            viewFindViewById3.setVisibility(0);
            viewFindViewById3.setOnClickListener(new ff1(this, processInfo, bVarT));
        } else {
            String str3 = processInfo.cGroup;
            f92.c(str3, "detail.cGroup");
            Iterator it = ec2.d0(str3, new String[]{"\n"}, false, 0, 6, null).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (ec2.C((String) next, "memory:/apps/", false, 2, null)) {
                        break;
                    }
                }
            }
            String str4 = (String) next;
            String str5 = (str4 == null || (listD0 = ec2.d0(str4, new String[]{":"}, false, 0, 6, null)) == null) ? null : (String) i52.K(listD0);
            n92 n92Var = new n92();
            n92Var.f6891a = null;
            String str6 = "/dev/memcg" + str5;
            if (str5 != null) {
                String[] strArr = {str6 + "/memory.force_shrink_anon", str6 + "/memory.force_empty"};
                int i = 0;
                while (true) {
                    if (i >= 2) {
                        break;
                    }
                    ?? r9 = strArr[i];
                    if (y60.f7952a.d(r9)) {
                        n92Var.f6891a = r9;
                        break;
                    }
                    i++;
                }
            }
            if (str5 == null || ((String) n92Var.f6891a) == null) {
                viewFindViewById3.setVisibility(8);
            } else {
                viewFindViewById3.setVisibility(0);
                viewFindViewById3.setOnClickListener(new hf1(str6, n92Var, this, processInfo, bVarT));
            }
        }
        View viewFindViewById4 = viewInflate.findViewById(t61.ProcessCommand);
        f92.c(viewFindViewById4, "findViewById<TextView>(R.id.ProcessCommand)");
        ((TextView) viewFindViewById4).setText(processInfo.command);
        View viewFindViewById5 = viewInflate.findViewById(t61.ProcessCmdline);
        f92.c(viewFindViewById5, "findViewById<TextView>(R.id.ProcessCmdline)");
        ((TextView) viewFindViewById5).setText(processInfo.cmdline);
        View viewFindViewById6 = viewInflate.findViewById(t61.ProcessPID);
        f92.c(viewFindViewById6, "findViewById<TextView>(R.id.ProcessPID)");
        ((TextView) viewFindViewById6).setText(String.valueOf(processInfo.pid));
        View viewFindViewById7 = viewInflate.findViewById(t61.ProcessPPid);
        f92.c(viewFindViewById7, "findViewById<TextView>(R.id.ProcessPPid)");
        ((TextView) viewFindViewById7).setText(String.valueOf(processInfo.PPid));
        View viewFindViewById8 = viewInflate.findViewById(t61.ProcessCPU);
        f92.c(viewFindViewById8, "findViewById<TextView>(R.id.ProcessCPU)");
        ((TextView) viewFindViewById8).setText(String.valueOf(processInfo.getCpu()) + "%");
        View viewFindViewById9 = viewInflate.findViewById(t61.ProcessCpuSet);
        f92.c(viewFindViewById9, "findViewById<TextView>(R.id.ProcessCpuSet)");
        ((TextView) viewFindViewById9).setText("" + processInfo.cpuSet.toString());
        View viewFindViewById10 = viewInflate.findViewById(t61.ProcessCGroup);
        f92.c(viewFindViewById10, "findViewById<TextView>(R.id.ProcessCGroup)");
        ((TextView) viewFindViewById10).setText("" + processInfo.cGroup);
        View viewFindViewById11 = viewInflate.findViewById(t61.ProcessOOMADJ);
        f92.c(viewFindViewById11, "findViewById<TextView>(R.id.ProcessOOMADJ)");
        ((TextView) viewFindViewById11).setText("" + processInfo.oomAdj);
        View viewFindViewById12 = viewInflate.findViewById(t61.ProcessOOMScoreAdj);
        f92.c(viewFindViewById12, "findViewById<TextView>(R.id.ProcessOOMScoreAdj)");
        ((TextView) viewFindViewById12).setText("" + processInfo.oomScoreAdj);
        View viewFindViewById13 = viewInflate.findViewById(t61.ProcessState);
        f92.c(viewFindViewById13, "findViewById<TextView>(R.id.ProcessState)");
        ((TextView) viewFindViewById13).setText(processInfo.getState());
        View viewFindViewById14 = viewInflate.findViewById(t61.ProcessCpus);
        f92.c(viewFindViewById14, "findViewById<TextView>(R.id.ProcessCpus)");
        ((TextView) viewFindViewById14).setText(processInfo.cpusAllowed);
        View viewFindViewById15 = viewInflate.findViewById(t61.ProcessMEM);
        f92.c(viewFindViewById15, "findViewById<TextView>(R.id.ProcessMEM)");
        TextView textView = (TextView) viewFindViewById15;
        long j = 8192;
        if (processInfo.res > j) {
            sb = new StringBuilder();
            bVar = bVarT;
            sb.append(String.valueOf((int) (processInfo.res / ((long) 1024))));
            sb.append("MB");
        } else {
            bVar = bVarT;
            sb = new StringBuilder();
            sb.append(String.valueOf(processInfo.res));
            sb.append("KB");
        }
        textView.setText(sb.toString());
        View viewFindViewById16 = viewInflate.findViewById(t61.ProcessSHR);
        f92.c(viewFindViewById16, "findViewById<TextView>(R.id.ProcessSHR)");
        TextView textView2 = (TextView) viewFindViewById16;
        if (processInfo.shr > j) {
            sb2 = new StringBuilder();
            sb2.append(String.valueOf((int) (processInfo.shr / ((long) 1024))));
            sb2.append("MB");
        } else {
            sb2 = new StringBuilder();
            sb2.append(String.valueOf(processInfo.shr));
            sb2.append("KB");
        }
        textView2.setText(sb2.toString());
        View viewFindViewById17 = viewInflate.findViewById(t61.ProcessSWAP);
        f92.c(viewFindViewById17, "findViewById<TextView>(R.id.ProcessSWAP)");
        TextView textView3 = (TextView) viewFindViewById17;
        if (processInfo.swap > j) {
            sb3 = new StringBuilder();
            sb3.append(String.valueOf((int) (processInfo.swap / ((long) 1024))));
            sb3.append("MB");
        } else {
            sb3 = new StringBuilder();
            sb3.append(String.valueOf(processInfo.swap));
            sb3.append("KB");
        }
        textView3.setText(sb3.toString());
        View viewFindViewById18 = viewInflate.findViewById(t61.ProcessUSER);
        f92.c(viewFindViewById18, "findViewById<TextView>(R.id.ProcessUSER)");
        ((TextView) viewFindViewById18).setText(processInfo.user);
        if (p(processInfo)) {
            View viewFindViewById19 = viewInflate.findViewById(t61.ProcessIcon);
            f92.c(viewFindViewById19, "findViewById(R.id.ProcessIcon)");
            q((ImageView) viewFindViewById19, processInfo);
            Button button = (Button) viewInflate.findViewById(t61.ProcessStopApp);
            Button button2 = (Button) viewInflate.findViewById(t61.ProcessAppOptions);
            button.setOnClickListener(new if1(this, processInfo, bVar));
            button2.setOnClickListener(new kf1(viewInflate, this, processInfo, bVar));
            f92.c(button, "btn");
            button.setVisibility(0);
            f92.c(button2, "options");
            button2.setVisibility(0);
        }
        viewInflate.findViewById(t61.ProcessKill).setOnClickListener(new lf1(this, processInfo, bVar));
    }

    public final void t() {
        Timer timer = this.f5466a;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            this.f5466a = null;
        }
    }

    public final void u() {
        if (this.b && this.f5466a == null) {
            Timer timer = new Timer("ProcessManager");
            timer.schedule(new mf1(this), 0L, 3000L);
            m42 m42Var = m42.f6769a;
            this.f5466a = timer;
        }
    }

    public final void v() {
        ArrayList<ProcessInfo> arrayListA = this.f5463a.a();
        ListView listView = (ListView) _$_findCachedViewById(t61.process_list);
        if (listView != null) {
            listView.post(new h(arrayListA));
        }
    }
}
