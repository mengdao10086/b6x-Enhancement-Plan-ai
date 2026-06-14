package com.omarea.vtools.activities;

import a.b62;
import a.b90;
import a.ba1;
import a.d72;
import a.da1;
import a.e50;
import a.ea1;
import a.ec2;
import a.f92;
import a.fa1;
import a.g91;
import a.ga1;
import a.h42;
import a.hf2;
import a.hz0;
import a.i52;
import a.ia1;
import a.ja1;
import a.k82;
import a.ka1;
import a.ke2;
import a.kl0;
import a.la1;
import a.m42;
import a.n30;
import a.p80;
import a.qc2;
import a.qe2;
import a.r62;
import a.rl0;
import a.s80;
import a.s91;
import a.t61;
import a.t91;
import a.tx0;
import a.u42;
import a.u61;
import a.u91;
import a.v62;
import a.v91;
import a.w91;
import a.wd2;
import a.wu0;
import a.x62;
import a.x91;
import a.xd2;
import a.y42;
import a.y91;
import a.z91;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.common.ui.OverScrollView;
import com.omarea.model.CpuClusterStatus;
import com.omarea.model.CpuStatus;
import com.omarea.ui.BlurView;
import com.omarea.ui.BlurViewLinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityCpuControl extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CpuStatus f5214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f5218a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public HashMap f5221b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5222b;
    public boolean c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<CheckBox> f5216a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f5219a = {""};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String[] f5223b = {""};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CpuStatus f5220b = new CpuStatus();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<Integer, String[]> f5217a = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String[] f5224c = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kl0 f5212a = new kl0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rl0 f5213a = new rl0();

    public interface a {
        void a(boolean[] zArr);
    }

    public interface b {
        void a(String str);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8613a;

        public c(int i) {
            this.f8613a = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String[] strArrP = ActivityCpuControl.this.P(this.f8613a);
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.perf_choose_cpu_min);
            f92.c(string, "getString(R.string.perf_choose_cpu_min)");
            ArrayList arrayListX = ActivityCpuControl.this.X(strArrP);
            ActivityCpuControl activityCpuControl2 = ActivityCpuControl.this;
            String str = activityCpuControl2.f5220b.clusters.get(this.f8613a).min_freq;
            f92.c(str, "status.clusters[cluster].min_freq");
            activityCpuControl.T(string, arrayListX, u42.t(strArrP, activityCpuControl2.O(strArrP, str)), new s91(this, view));
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8614a;

        public d(int i) {
            this.f8614a = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String[] strArrP = ActivityCpuControl.this.P(this.f8614a);
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.perf_choose_cpu_max);
            f92.c(string, "getString(R.string.perf_choose_cpu_max)");
            ArrayList arrayListX = ActivityCpuControl.this.X(strArrP);
            ActivityCpuControl activityCpuControl2 = ActivityCpuControl.this;
            String str = activityCpuControl2.f5220b.clusters.get(this.f8614a).max_freq;
            f92.c(str, "status.clusters[cluster].max_freq");
            activityCpuControl.T(string, arrayListX, u42.t(strArrP, activityCpuControl2.O(strArrP, str)), new t91(this, view));
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8615a;

        public e(int i) {
            this.f8615a = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.perf_choose_cpu_governor);
            f92.c(string, "getString(R.string.perf_choose_cpu_governor)");
            ActivityCpuControl activityCpuControl2 = ActivityCpuControl.this;
            activityCpuControl.T(string, activityCpuControl2.c0(activityCpuControl2.f5224c), u42.t(ActivityCpuControl.this.f5224c, ActivityCpuControl.this.f5220b.clusters.get(this.f8615a).governor), new u91(this, view));
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8616a;

        public f(int i) {
            this.f8616a = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl.this.f5220b.clusters.get(this.f8616a).governor_params = ActivityCpuControl.this.f5212a.q(this.f8616a);
            Intent intent = new Intent(ActivityCpuControl.this, (Class<?>) ActivityPerfOptions.class);
            intent.putExtra("dir", ActivityCpuControl.this.f5212a.u(this.f8616a));
            ActivityCpuControl.this.startActivity(intent);
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8617a;

        public g(int i) {
            this.f8617a = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String strX = ActivityCpuControl.this.f5212a.x(this.f8617a);
            StringBuilder sb = new StringBuilder();
            f92.c(strX, "result");
            if (strX.length() > 0) {
                ArrayList arrayList = new ArrayList();
                long j = 0;
                Iterator it = ec2.d0(strX, new String[]{"\n"}, false, 0, 6, null).iterator();
                while (it.hasNext()) {
                    List listD0 = ec2.d0((String) it.next(), new String[]{" "}, false, 0, 6, null);
                    if (listD0.size() == 2) {
                        j += Long.parseLong((String) listD0.get(1));
                        arrayList.add(new v91(listD0));
                    }
                }
                Iterator it2 = arrayList.iterator();
                f92.c(it2, "data.iterator()");
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    sb.append(ActivityCpuControl.this.d0((String) entry.getKey()));
                    sb.append("    ");
                    sb.append(((Number) entry.getValue()).longValue());
                    sb.append("    ");
                    sb.append(((long) ((((Number) entry.getValue()).doubleValue() * 10000.0d) / j)) / 100.0d);
                    sb.append("%\n");
                }
            }
            p80.a aVar = p80.f2403a;
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.perf_time_in_state);
            f92.c(string, "getString(R.string.perf_time_in_state)");
            String string2 = sb.toString();
            f92.c(string2, "msg.toString()");
            p80.a.B(aVar, activityCpuControl, string, string2, null, 8, null);
        }
    }

    public static final class h implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f8618a;

        public h(a aVar) {
            this.f8618a = aVar;
        }

        @Override // com.omarea.vtools.activities.ActivityCpuControl.a
        public void a(boolean[] zArr) {
            f92.d(zArr, "result");
            this.f8618a.a(zArr);
            ActivityCpuControl.this.g0();
        }
    }

    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String str = activityCpuControl.f5220b.cpusetBg;
            f92.c(str, "status.cpusetBg");
            activityCpuControl.L(str, new w91(this));
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String str = activityCpuControl.f5220b.cpusetSysBg;
            f92.c(str, "status.cpusetSysBg");
            activityCpuControl.L(str, new x91(this));
        }
    }

    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String str = activityCpuControl.f5220b.cpusetFg;
            f92.c(str, "status.cpusetFg");
            activityCpuControl.L(str, new y91(this));
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String str = activityCpuControl.f5220b.cpusetTop;
            f92.c(str, "status.cpusetTop");
            activityCpuControl.L(str, new z91(this));
        }
    }

    public static final class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8623a;

        public m(int i) {
            this.f8623a = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
            }
            boolean zIsChecked = ((CheckBox) view).isChecked();
            ActivityCpuControl.this.f5212a.E(this.f8623a, zIsChecked);
            ActivityCpuControl.this.f5220b.coreOnline.set(this.f8623a, Boolean.valueOf(zIsChecked));
        }
    }

    public static final class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl.this.Z();
        }
    }

    public static final class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intent intent = new Intent(ActivityCpuControl.this.getContext(), (Class<?>) ActivityPerfOptions.class);
            intent.putExtra("config", 2131820552);
            intent.putExtra("title", "Sched");
            ActivityCpuControl.this.startActivity(intent);
        }
    }

    public static final class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.perf_choose_gpu_min);
            f92.c(string, "getString(R.string.perf_choose_gpu_min)");
            ActivityCpuControl activityCpuControl2 = ActivityCpuControl.this;
            activityCpuControl.T(string, activityCpuControl2.Y(activityCpuControl2.f5219a), u42.t(ActivityCpuControl.this.f5219a, ActivityCpuControl.this.f5220b.gpuMinFreq), new ea1(this, view));
        }
    }

    public static final class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.perf_choose_gpu_max);
            f92.c(string, "getString(R.string.perf_choose_gpu_max)");
            ActivityCpuControl activityCpuControl2 = ActivityCpuControl.this;
            activityCpuControl.T(string, activityCpuControl2.Y(activityCpuControl2.f5219a), u42.t(ActivityCpuControl.this.f5219a, ActivityCpuControl.this.f5220b.gpuMaxFreq), new fa1(this, view));
        }
    }

    public static final class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.perf_choose_gpu_governor);
            f92.c(string, "getString(R.string.perf_choose_gpu_governor)");
            ActivityCpuControl activityCpuControl2 = ActivityCpuControl.this;
            activityCpuControl.T(string, activityCpuControl2.c0(activityCpuControl2.f5223b), u42.t(ActivityCpuControl.this.f5223b, ActivityCpuControl.this.f5220b.adrenoGovernor), new ga1(this, view));
        }
    }

    public static final class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                BlurView blurView = (BlurView) ActivityCpuControl.this._$_findCachedViewById(t61.gpu_params);
                f92.c(blurView, "gpu_params");
                blurView.setVisibility(ActivityCpuControl.this.f5222b ? 0 : 8);
                int i = ActivityCpuControl.this.b - 1;
                if (i >= 0) {
                    int i2 = 0;
                    while (true) {
                        CheckBox checkBox = new CheckBox(ActivityCpuControl.this.getContext());
                        checkBox.setText("CPU" + i2);
                        ActivityCpuControl.this.f5216a.add(checkBox);
                        GridLayout gridLayout = (GridLayout) ActivityCpuControl.this._$_findCachedViewById(t61.cpu_cores);
                        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                        layoutParams.height = -2;
                        layoutParams.width = 0;
                        layoutParams.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1.0f);
                        m42 m42Var = m42.f6769a;
                        gridLayout.addView(checkBox, layoutParams);
                        if (i2 == i) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                ActivityCpuControl.this.M();
                ActivityCpuControl.this.c = true;
            } catch (Exception unused) {
            }
            ActivityCpuControl.this.g0();
            OverScrollView overScrollView = (OverScrollView) ActivityCpuControl.this._$_findCachedViewById(t61.root);
            f92.c(overScrollView, "root");
            overScrollView.setVisibility(0);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityCpuControl$onViewCreated$1", f = "ActivityCpuControl.kt", l = {}, m = "invokeSuspend")
    public static final class t extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8630a;
        public int b;

        public t(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            t tVar = ActivityCpuControl.this.new t(b62Var);
            tVar.f8630a = (wd2) obj;
            return tVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((t) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            ActivityCpuControl.this.R();
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityCpuControl$onViewCreated$2", f = "ActivityCpuControl.kt", l = {651}, m = "invokeSuspend")
    public static final class u extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8631a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5234a;
        public int b;

        public u(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            u uVar = ActivityCpuControl.this.new u(b62Var);
            uVar.f8631a = (wd2) obj;
            return uVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((u) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                this.f5234a = this.f8631a;
                this.b = 1;
                if (ke2.a(50L, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            p80.a aVar = p80.f2403a;
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.warn);
            f92.c(string, "getString(R.string.warn)");
            String string2 = ActivityCpuControl.this.getString(u61.perf_warn);
            f92.c(string2, "getString(R.string.perf_warn)");
            aVar.M(activityCpuControl, string, string2, ja1.f6493a, new ka1(this)).i(false);
            return m42.f6769a;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityCpuControl$onViewCreated$3", f = "ActivityCpuControl.kt", l = {664}, m = "invokeSuspend")
    public static final class v extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8632a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5236a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String[] f5237a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(String[] strArr, b62 b62Var) {
            super(2, b62Var);
            this.f5237a = strArr;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            v vVar = ActivityCpuControl.this.new v(this.f5237a, b62Var);
            vVar.f8632a = (wd2) obj;
            return vVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((v) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                this.f5236a = this.f8632a;
                this.b = 1;
                if (ke2.a(50L, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            p80.a aVar = p80.f2403a;
            ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
            String string = activityCpuControl.getString(u61.warn);
            f92.c(string, "getString(R.string.warn)");
            String string2 = ActivityCpuControl.this.getString(u61.perf_warn2);
            f92.c(string2, "getString(R.string.perf_warn2)");
            aVar.M(activityCpuControl, (16 & 2) != 0 ? "" : string, (16 & 4) != 0 ? "" : string2, (16 & 8) != 0 ? null : new la1(this), (16 & 16) != 0 ? null : null).i(false);
            return m42.f6769a;
        }
    }

    public static final class w implements s80 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f8633a;

        public w(b bVar) {
            this.f8633a = bVar;
        }

        @Override // a.s80
        public void a(List<n30> list, boolean[] zArr) {
            f92.d(list, "selected");
            f92.d(zArr, "status");
            if (!list.isEmpty()) {
                this.f8633a.a("" + ((n30) i52.A(list)).e());
            }
        }
    }

    public static final class x implements s80 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f8634a;

        public x(a aVar) {
            this.f8634a = aVar;
        }

        @Override // a.s80
        public void a(List<n30> list, boolean[] zArr) {
            f92.d(list, "selected");
            f92.d(zArr, "status");
            if (!(zArr.length == 0)) {
                this.f8634a.a(zArr);
            }
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityCpuControl", f = "ActivityCpuControl.kt", l = {530, 545}, m = "updateState")
    public static final class y extends v62 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8635a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public /* synthetic */ Object f5239a;
        public Object b;

        public y(b62 b62Var) {
            super(b62Var);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            this.f5239a = obj;
            this.f8635a |= Integer.MIN_VALUE;
            return ActivityCpuControl.this.f0(this);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityCpuControl$updateState$3", f = "ActivityCpuControl.kt", l = {}, m = "invokeSuspend")
    public static final class z extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8636a;
        public int b;

        public z(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            z zVar = ActivityCpuControl.this.new z(b62Var);
            zVar.f8636a = (wd2) obj;
            return zVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((z) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            ActivityCpuControl.this.g0();
            return m42.f6769a;
        }
    }

    public final void J(int i2) {
        View viewInflate = View.inflate(getContext(), 2131558552, null);
        ((LinearLayout) _$_findCachedViewById(t61.cpu_cluster_list)).addView(viewInflate);
        View viewFindViewById = viewInflate.findViewById(t61.cluster_title);
        f92.c(viewFindViewById, "view.findViewById<TextView>(R.id.cluster_title)");
        ((TextView) viewFindViewById).setText("CPU - Cluster " + i2);
        f92.c(viewInflate, "view");
        viewInflate.setTag("cluster_" + i2);
        TextView textView = (TextView) viewInflate.findViewById(t61.cluster_min_freq);
        TextView textView2 = (TextView) viewInflate.findViewById(t61.cluster_max_freq);
        TextView textView3 = (TextView) viewInflate.findViewById(t61.cluster_governor);
        View viewFindViewById2 = viewInflate.findViewById(t61.cluster_governor_params);
        View viewFindViewById3 = viewInflate.findViewById(t61.cluster_time_in_state);
        textView.setOnClickListener(new c(i2));
        textView2.setOnClickListener(new d(i2));
        textView3.setOnClickListener(new e(i2));
        viewFindViewById2.setOnClickListener(new f(i2));
        viewFindViewById3.setOnClickListener(new g(i2));
    }

    public final void K() {
        ((TextView) _$_findCachedViewById(t61.cpuset_bg)).setOnClickListener(new i());
        ((TextView) _$_findCachedViewById(t61.cpuset_system_bg)).setOnClickListener(new j());
        ((TextView) _$_findCachedViewById(t61.cpuset_foreground)).setOnClickListener(new k());
        ((TextView) _$_findCachedViewById(t61.cpuset_top_app)).setOnClickListener(new l());
    }

    public final void L(String str, a aVar) {
        if (str.length() > 0) {
            boolean[] zArrW = W(str);
            String string = getString(u61.perf_choose_cores);
            f92.c(string, "getString(R.string.perf_choose_cores)");
            U(string, Q(zArrW), new h(aVar));
        }
    }

    @SuppressLint({"InflateParams"})
    public final void M() {
        try {
            int i2 = this.f8612a;
            for (int i3 = 0; i3 < i2; i3++) {
                J(i3);
            }
            N();
            int size = this.f5216a.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f5216a.get(i4).setOnClickListener(new m(i4));
            }
            K();
            ((Switch) _$_findCachedViewById(t61.cpu_apply_onboot)).setOnClickListener(new n());
        } catch (Exception unused) {
        }
        if (this.f5215a != null) {
            BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.nav_more);
            f92.c(blurViewLinearLayout, "nav_more");
            blurViewLinearLayout.setVisibility(8);
        } else {
            qc2.d(xd2.a(qe2.c()), null, null, new ba1((TextView) _$_findCachedViewById(t61.cpu_cpuctl), null, this), 3, null);
            qc2.d(xd2.a(qe2.c()), null, null, new da1((TextView) _$_findCachedViewById(t61.cpu_stune), null, this), 3, null);
            ((TextView) _$_findCachedViewById(t61.cpu_sched)).setOnClickListener(new o());
        }
    }

    public final void N() {
        if (this.f5222b) {
            ((TextView) _$_findCachedViewById(t61.gpu_min_freq)).setOnClickListener(new p());
            ((TextView) _$_findCachedViewById(t61.gpu_max_freq)).setOnClickListener(new q());
            ((TextView) _$_findCachedViewById(t61.gpu_governor)).setOnClickListener(new r());
        }
    }

    public final String O(String[] strArr, String str) {
        try {
            if (u42.k(strArr, str)) {
                return str;
            }
            int i2 = 0;
            String str2 = (strArr.length == 0) ^ true ? strArr[0] : "";
            int length = strArr.length;
            while (i2 < length) {
                String str3 = strArr[i2];
                if (Integer.parseInt(str3) > Integer.parseInt(str)) {
                    break;
                }
                i2++;
                str2 = str3;
            }
            return str2;
        } catch (Exception unused) {
            return str;
        }
    }

    public final String[] P(int i2) {
        String[] strArr = this.f5217a.get(Integer.valueOf(i2));
        if (strArr == null || strArr.length < 2) {
            HashMap<Integer, String[]> map = this.f5217a;
            Integer numValueOf = Integer.valueOf(i2);
            String[] strArrD = this.f5212a.d(i2);
            f92.c(strArrD, "cpuUtil.getAvailableFrequencies(cluster)");
            map.put(numValueOf, strArrD);
        }
        String[] strArr2 = this.f5217a.get(Integer.valueOf(i2));
        f92.b(strArr2);
        return strArr2;
    }

    public final ArrayList<n30> Q(boolean[] zArr) {
        ArrayList<n30> arrayList = new ArrayList<>();
        int i2 = this.b;
        for (int i3 = 0; i3 < i2; i3++) {
            n30 n30Var = new n30();
            n30Var.i("Cpu" + i3);
            if (i3 < zArr.length) {
                n30Var.h(zArr[i3]);
            }
            m42 m42Var = m42.f6769a;
            arrayList.add(n30Var);
        }
        return arrayList;
    }

    public final void R() {
        this.f8612a = this.f5212a.f().size();
        String[] strArrE = this.f5212a.e();
        f92.c(strArrE, "cpuUtil.availableGovernors");
        this.f5224c = strArrE;
        int i2 = this.f8612a;
        for (int i3 = 0; i3 < i2; i3++) {
            HashMap<Integer, String[]> map = this.f5217a;
            Integer numValueOf = Integer.valueOf(i3);
            String[] strArrD = this.f5212a.d(i3);
            f92.c(strArrD, "cpuUtil.getAvailableFrequencies(cluster)");
            map.put(numValueOf, strArrD);
        }
        this.b = this.f5212a.h();
        boolean zS = this.f5213a.s();
        this.f5222b = zS;
        if (zS) {
            String[] strArrF = this.f5213a.f();
            f92.c(strArrF, "gpuUtils.governors");
            this.f5223b = strArrF;
            String[] strArrD2 = this.f5213a.d();
            f92.c(strArrD2, "gpuUtils.frequencies");
            this.f5219a = strArrD2;
        }
        S();
        Scene.f4798a.i(new s());
    }

    public final void S() {
        this.f5214a = new tx0(getContext()).h(this.f5215a);
        Switch r0 = (Switch) _$_findCachedViewById(t61.cpu_apply_onboot);
        f92.c(r0, "cpu_apply_onboot");
        r0.setChecked(this.f5214a != null);
        if (this.f5215a != null) {
            BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.cpu_apply_boot);
            f92.c(blurViewLinearLayout, "cpu_apply_boot");
            blurViewLinearLayout.setVisibility(8);
            BlurViewLinearLayout blurViewLinearLayout2 = (BlurViewLinearLayout) _$_findCachedViewById(t61.cpu_help_text);
            f92.c(blurViewLinearLayout2, "cpu_help_text");
            blurViewLinearLayout2.setVisibility(8);
            if (this.f5214a != null) {
                wu0 wu0Var = new wu0();
                String str = this.f5215a;
                f92.b(str);
                String packageName = getPackageName();
                f92.c(packageName, "packageName");
                wu0Var.u(str, packageName, "manual");
                CpuStatus cpuStatus = this.f5214a;
                f92.b(cpuStatus);
                this.f5220b = cpuStatus;
            }
        }
    }

    public final void T(String str, ArrayList<n30> arrayList, int i2, b bVar) {
        int i3 = 0;
        for (Object obj : arrayList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                y42.l();
                throw null;
            }
            ((n30) obj).h(i3 == i2);
            i3 = i4;
        }
        b90 b90Var = new b90(getThemeMode().a(), arrayList, false, new w(bVar), 0, 16, null);
        b90Var.K1(str);
        b90Var.B1(getSupportFragmentManager(), "cpu-control");
    }

    public final void U(String str, ArrayList<n30> arrayList, a aVar) {
        b90 b90Var = new b90(getThemeMode().a(), arrayList, true, new x(aVar), 0, 16, null);
        b90Var.K1(str);
        b90Var.B1(getSupportFragmentManager(), "cpu-control");
    }

    public final String V(boolean[] zArr) {
        StringBuilder sb = new StringBuilder();
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(i2);
            }
        }
        String string = sb.toString();
        f92.c(string, "stringBuilder.toString()");
        return string;
    }

    public final boolean[] W(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.b;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Boolean.FALSE);
        }
        if (!(str.length() == 0) && !f92.a(str, "error")) {
            for (String str2 : ec2.d0(str, new String[]{","}, false, 0, 6, null)) {
                if (ec2.C(str2, "-", false, 2, null)) {
                    try {
                        List listD0 = ec2.d0(str2, new String[]{"-"}, false, 0, 6, null);
                        int i4 = Integer.parseInt((String) listD0.get(0));
                        int i5 = Integer.parseInt((String) listD0.get(1));
                        if (i4 <= i5) {
                            while (true) {
                                if (i4 < arrayList.size()) {
                                    arrayList.set(i4, Boolean.TRUE);
                                }
                                if (i4 != i5) {
                                    i4++;
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    int i6 = Integer.parseInt(str2);
                    if (i6 < arrayList.size()) {
                        arrayList.set(i6, Boolean.TRUE);
                    }
                }
            }
        }
        return i52.W(arrayList);
    }

    public final ArrayList<n30> X(String[] strArr) {
        ArrayList<n30> arrayList = new ArrayList<>();
        for (String str : strArr) {
            n30 n30Var = new n30();
            n30Var.i(d0(str));
            n30Var.j(str);
            m42 m42Var = m42.f6769a;
            arrayList.add(n30Var);
        }
        return arrayList;
    }

    public final ArrayList<n30> Y(String[] strArr) {
        ArrayList<n30> arrayList = new ArrayList<>();
        for (String str : strArr) {
            n30 n30Var = new n30();
            n30Var.i(e0(str));
            n30Var.j(str);
            m42 m42Var = m42.f6769a;
            arrayList.add(n30Var);
        }
        return arrayList;
    }

    public final void Z() {
        tx0 tx0Var = new tx0(getContext());
        if (this.f5215a == null) {
            Switch r1 = (Switch) _$_findCachedViewById(t61.cpu_apply_onboot);
            f92.c(r1, "cpu_apply_onboot");
            if (!r1.isChecked()) {
                tx0.k(tx0Var, null, null, 2, null);
                return;
            }
        }
        ArrayList<CpuClusterStatus> arrayList = this.f5220b.clusters;
        if (arrayList != null) {
            int i2 = 0;
            for (Object obj : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    y42.l();
                    throw null;
                }
                ((CpuClusterStatus) obj).governor_params = this.f5212a.q(i2);
                i2 = i3;
            }
        }
        if (!tx0Var.j(this.f5220b, this.f5215a)) {
            Toast.makeText(getContext(), getString(u61.perf_save_fail), 0).show();
        } else if (this.f5215a != null) {
            tx0Var.l();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5221b == null) {
            this.f5221b = new HashMap();
        }
        View view = (View) this.f5221b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5221b.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    public final void a0(TextView textView, String str) {
        if (textView == null || !(!f92.a(textView.getText(), str))) {
            return;
        }
        textView.setText(str);
    }

    public final void b0() {
        try {
            if (this.f5218a != null) {
                Timer timer = this.f5218a;
                f92.b(timer);
                timer.cancel();
                this.f5218a = null;
            }
        } catch (Exception unused) {
        }
    }

    public final ArrayList<n30> c0(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            n30 n30Var = new n30();
            n30Var.i(str);
            n30Var.j(str);
            arrayList.add(n30Var);
        }
        return new ArrayList<>(arrayList);
    }

    public final String d0(String str) {
        if (str.length() <= 3) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length() - 3;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(0, length);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append(" MHz");
        return sb.toString();
    }

    public final String e0(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() <= 3) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length() - 3;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(0, length);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append(" MHz");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x012f A[Catch: Exception -> 0x0132, TRY_LEAVE, TryCatch #0 {Exception -> 0x0132, blocks: (B:13:0x002d, B:38:0x012b, B:40:0x012f, B:18:0x003e, B:34:0x00f3, B:21:0x0046, B:23:0x004b, B:25:0x0057, B:26:0x0063, B:27:0x0087, B:29:0x008b, B:30:0x00bf), top: B:44:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object f0(a.b62<? super a.m42> r11) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityCpuControl.f0(a.b62):java.lang.Object");
    }

    public final void g0() {
        try {
            int i2 = this.f8612a;
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.f5220b.clusters.size() > i3) {
                    View viewFindViewWithTag = ((LinearLayout) _$_findCachedViewById(t61.cpu_cluster_list)).findViewWithTag("cluster_" + i3);
                    TextView textView = (TextView) viewFindViewWithTag.findViewById(t61.cluster_min_freq);
                    TextView textView2 = (TextView) viewFindViewWithTag.findViewById(t61.cluster_max_freq);
                    TextView textView3 = (TextView) viewFindViewWithTag.findViewById(t61.cluster_governor);
                    CpuClusterStatus cpuClusterStatus = this.f5220b.clusters.get(i3);
                    f92.b(cpuClusterStatus);
                    f92.c(cpuClusterStatus, "status.clusters[cluster]!!");
                    CpuClusterStatus cpuClusterStatus2 = cpuClusterStatus;
                    String str = cpuClusterStatus2.min_freq;
                    f92.c(str, "status.min_freq");
                    a0(textView, d0(str));
                    String str2 = cpuClusterStatus2.max_freq;
                    f92.c(str2, "status.max_freq");
                    a0(textView2, d0(str2));
                    String str3 = cpuClusterStatus2.governor;
                    f92.c(str3, "status.governor");
                    a0(textView3, str3);
                }
            }
            if (this.f5222b) {
                TextView textView4 = (TextView) _$_findCachedViewById(t61.gpu_min_freq);
                f92.c(textView4, "gpu_min_freq");
                String str4 = this.f5220b.gpuMinFreq;
                f92.c(str4, "status.gpuMinFreq");
                textView4.setText(e0(str4));
                TextView textView5 = (TextView) _$_findCachedViewById(t61.gpu_max_freq);
                f92.c(textView5, "gpu_max_freq");
                String str5 = this.f5220b.gpuMaxFreq;
                f92.c(str5, "status.gpuMaxFreq");
                textView5.setText(e0(str5));
                TextView textView6 = (TextView) _$_findCachedViewById(t61.gpu_governor);
                f92.c(textView6, "gpu_governor");
                textView6.setText(this.f5220b.adrenoGovernor);
            }
            int i4 = this.b;
            for (int i5 = 0; i5 < i4; i5++) {
                CheckBox checkBox = this.f5216a.get(i5);
                f92.c(checkBox, "cores[i]");
                Boolean bool = this.f5220b.coreOnline.get(i5);
                f92.c(bool, "status.coreOnline[i]");
                checkBox.setChecked(bool.booleanValue());
            }
            TextView textView7 = (TextView) _$_findCachedViewById(t61.cpuset_bg);
            f92.c(textView7, "cpuset_bg");
            textView7.setText(this.f5220b.cpusetBg);
            TextView textView8 = (TextView) _$_findCachedViewById(t61.cpuset_system_bg);
            f92.c(textView8, "cpuset_system_bg");
            textView8.setText(this.f5220b.cpusetSysBg);
            TextView textView9 = (TextView) _$_findCachedViewById(t61.cpuset_foreground);
            f92.c(textView9, "cpuset_foreground");
            textView9.setText(this.f5220b.cpusetFg);
            TextView textView10 = (TextView) _$_findCachedViewById(t61.cpuset_top_app);
            f92.c(textView10, "cpuset_top_app");
            textView10.setText(this.f5220b.cpusetTop);
        } catch (Exception unused) {
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558445);
        setBackArrow();
        onViewCreated();
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b0();
        Z();
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onStart() {
        String string;
        super.onStart();
        if (this.f5215a == null) {
            string = getString(u61.menu_core_control);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(u61.perf_custom));
            sb.append("[");
            sb.append(wu0.f3480a.k("" + this.f5215a));
            sb.append("]");
            string = sb.toString();
        }
        setTitle(string);
        if ((this.f5214a == null || this.f5215a == null) && this.f5218a == null) {
            Timer timer = new Timer("ActivityCPUController");
            timer.schedule(new ia1(this), 300L, 1000L);
            m42 m42Var = m42.f6769a;
            this.f5218a = timer;
        }
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onStop() {
        super.onStop();
        b0();
    }

    public final void onViewCreated() {
        if (getIntent().hasExtra("cpuModeName")) {
            this.f5215a = getIntent().getStringExtra("cpuModeName");
        }
        OverScrollView overScrollView = (OverScrollView) _$_findCachedViewById(t61.root);
        f92.c(overScrollView, "root");
        overScrollView.setVisibility(8);
        qc2.d(hf2.f6309a, qe2.b(), null, new t(null), 2, null);
        if (hz0.f1282a.b0() && this.f5215a == null) {
            qc2.d(xd2.a(qe2.c()), null, null, new u(null), 3, null);
        } else if (f92.a(e50.f677a.y0(), "root")) {
            String[] strArrW = this.f5212a.w();
            if (strArrW.length > 0) {
                qc2.d(xd2.a(qe2.c()), null, null, new v(strArrW, null), 3, null);
            }
        }
    }
}
