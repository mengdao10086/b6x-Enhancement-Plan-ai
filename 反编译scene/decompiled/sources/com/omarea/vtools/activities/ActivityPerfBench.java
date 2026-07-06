package com.omarea.vtools.activities;

import a.ae1;
import a.b90;
import a.c60;
import a.e50;
import a.f92;
import a.fj0;
import a.g82;
import a.g91;
import a.g92;
import a.kl0;
import a.l30;
import a.m42;
import a.n30;
import a.n92;
import a.of2;
import a.on0;
import a.qc2;
import a.qe2;
import a.qf2;
import a.se0;
import a.t61;
import a.xd1;
import a.xd2;
import a.ym0;
import a.zd1;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.ui.SeekBar;
import com.omarea.ui.Tags;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityPerfBench extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qf2 f5390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kl0 f5389a = new kl0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8789a = new a(Scene.f4798a.c(), "CoreCount").i();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5391a = "addin/alive_benchmark.sh";

    public static final class a extends on0 {
        public a(Context context, String str) {
            super(context, str);
        }

        @Override // a.on0
        public String f() {
            return "" + ActivityPerfBench.this.f5389a.h();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8791a = new b();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f8792a = new c();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityPerfBench.this.startActivity(new Intent(ActivityPerfBench.this.getContext(), (Class<?>) ActivityCpuControl.class));
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityPerfBench.this.startActivity(new Intent(ActivityPerfBench.this.getContext(), (Class<?>) ActivitySwap.class));
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8795a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5394a;

        public f(ArrayList arrayList, n92 n92Var) {
            this.f5394a = arrayList;
            this.f8795a = n92Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b90 b90Var = new b90(ActivityPerfBench.this.getThemeMode().a(), this.f5394a, true, new xd1(this), 999);
            b90Var.K1("选择CPU核心");
            b90Var.B1(ActivityPerfBench.this.getSupportFragmentManager(), "cpu-bench-cores");
        }
    }

    public static final class g extends g92 implements g82<fj0, m42> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f8796a = new g();

        public g() {
            super(1);
        }

        public final void a(fj0 fj0Var) {
            f92.d(fj0Var, "it");
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(fj0 fj0Var) {
            a(fj0Var);
            return m42.f6769a;
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8797a;

        public h(n92 n92Var) {
            this.f8797a = n92Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            long progress = 1000 * ((long) ((SeekBar) ActivityPerfBench.this._$_findCachedViewById(t61.cpu_bench_duration)).getProgress());
            String string = new l30(new ae1(this, progress)).toString();
            f92.c(string, "json {\n                \"…\n            }.toString()");
            qf2 qf2VarM = ActivityPerfBench.this.m();
            if (qf2VarM != null) {
                of2.a(qf2VarM, null, 1, null);
            }
            if (view != null) {
                view.setVisibility(8);
            }
            Button button = (Button) ActivityPerfBench.this._$_findCachedViewById(t61.cpu_stop);
            if (button != null) {
                button.setVisibility(0);
            }
            ActivityPerfBench.this.o(qc2.d(xd2.a(qe2.b()), null, null, new zd1(this, string, progress, null), 3, null));
        }
    }

    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityPerfBench.this.p();
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e50 e50Var;
            String str;
            if (((Tags) ActivityPerfBench.this._$_findCachedViewById(t61.bat_state_type)).getCheckedIndex() == 0) {
                e50Var = e50.f677a;
                str = "dumpsys battery unplug";
            } else {
                e50Var = e50.f677a;
                str = "dumpsys battery set ac 2";
            }
            e50Var.Z(str);
            e50.f677a.Z("dumpsys battery set level " + ((SeekBar) ActivityPerfBench.this._$_findCachedViewById(t61.bat_capacity)).getProgress());
        }
    }

    public static final class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f8800a = new k();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e50.f677a.Z("dumpsys battery reset");
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityPerfBench activityPerfBench = ActivityPerfBench.this;
            activityPerfBench.n(((SeekBar) activityPerfBench._$_findCachedViewById(t61.lmk_app_count)).getProgress(), ((SeekBar) ActivityPerfBench.this._$_findCachedViewById(t61.lmk_app_interval)).getProgress());
        }
    }

    public static final class m extends g92 implements g82<l30, m42> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f8802a = new m();

        public m() {
            super(1);
        }

        public final void a(l30 l30Var) {
            f92.d(l30Var, "$receiver");
            l30Var.E("durationMS", 1);
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
            a(l30Var);
            return m42.f6769a;
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5392a == null) {
            this.f5392a = new HashMap();
        }
        View view = (View) this.f5392a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5392a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    public final qf2 m() {
        return this.f5390a;
    }

    public final void n(int i2, int i3) {
        c60 c60Var = c60.f5764a;
        String str = this.f5391a;
        String strM = c60Var.m(str, str, this);
        if (strM == null) {
            strM = ym0.f7994a.a();
        }
        String str2 = "sh " + strM + ' ' + i2 + ' ' + i3;
        RunnableNode runnableNode = new RunnableNode("");
        runnableNode.setTitle("KeepAlive Benchmark");
        runnableNode.setDesc(str2);
        se0 se0VarA = se0.f7388a.a(runnableNode, b.f8791a, c.f8792a, str2, null, false);
        se0VarA.z1(false);
        se0VarA.B1(getSupportFragmentManager(), "");
    }

    public final void o(qf2 qf2Var) {
        this.f5390a = qf2Var;
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558459);
        setBackArrow();
        onViewCreated();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
        p();
    }

    public final void onViewCreated() {
        setTitle("模拟测试");
        ((TextView) _$_findCachedViewById(t61.nav_core_control)).setOnClickListener(new d());
        ((TextView) _$_findCachedViewById(t61.nav_swap_control)).setOnClickListener(new e());
        ArrayList arrayList = new ArrayList();
        int i2 = this.f8789a;
        for (int i3 = 0; i3 < i2; i3++) {
            n30 n30Var = new n30();
            n30Var.i("CPU " + i3);
            n30Var.j("" + i3);
            n30Var.h(true);
            m42 m42Var = m42.f6769a;
            arrayList.add(n30Var);
        }
        n92 n92Var = new n92();
        int i4 = this.f8789a;
        boolean[] zArr = new boolean[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            zArr[i5] = true;
        }
        m42 m42Var2 = m42.f6769a;
        n92Var.f6891a = zArr;
        ((TextView) _$_findCachedViewById(t61.cpu_cpuset)).setOnClickListener(new f(arrayList, n92Var));
        ((Tags) _$_findCachedViewById(t61.cpu_load_type)).b(new String[]{"整数", "浮点"}, 0).j(g.f8796a);
        ((Tags) _$_findCachedViewById(t61.gpu_load_type)).b(new String[]{"RenderScript", "Float", "Render"}, 0);
        ((Tags) _$_findCachedViewById(t61.bat_state_type)).b(new String[]{"放电", "充电"}, 0);
        ((Button) _$_findCachedViewById(t61.cpu_start)).setOnClickListener(new h(n92Var));
        ((Button) _$_findCachedViewById(t61.cpu_stop)).setOnClickListener(new i());
        ((Button) _$_findCachedViewById(t61.bat_start)).setOnClickListener(new j());
        ((Button) _$_findCachedViewById(t61.bat_stop)).setOnClickListener(k.f8800a);
        ((Button) _$_findCachedViewById(t61.lmk_start)).setOnClickListener(new l());
    }

    public final void p() {
        qf2 qf2Var = this.f5390a;
        if (qf2Var != null) {
            of2.a(qf2Var, null, 1, null);
        }
        this.f5390a = null;
        e50 e50Var = e50.f677a;
        String string = new l30(m.f8802a).toString();
        f92.c(string, "json {\n            \"dura…to 1\n        }.toString()");
        e50.j1(e50Var, "cpu-bench", string, null, 4, null);
        Button button = (Button) _$_findCachedViewById(t61.cpu_start);
        if (button != null) {
            button.setVisibility(0);
        }
        Button button2 = (Button) _$_findCachedViewById(t61.cpu_stop);
        if (button2 != null) {
            button2.setVisibility(8);
        }
        TextView textView = (TextView) _$_findCachedViewById(t61.cpu_bench_result);
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
    }
}
