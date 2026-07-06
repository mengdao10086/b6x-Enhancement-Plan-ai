package com.omarea.vtools.activities;

import a.a42;
import a.b62;
import a.b90;
import a.bb2;
import a.bc2;
import a.c60;
import a.ce1;
import a.d42;
import a.d72;
import a.de1;
import a.e42;
import a.e50;
import a.e51;
import a.e90;
import a.ea2;
import a.ee1;
import a.f92;
import a.fa0;
import a.fg2;
import a.fj0;
import a.g42;
import a.g82;
import a.g91;
import a.g92;
import a.ge1;
import a.h42;
import a.he1;
import a.hn0;
import a.hz0;
import a.i52;
import a.ie1;
import a.j42;
import a.jm0;
import a.k82;
import a.kk0;
import a.kl0;
import a.l30;
import a.l90;
import a.l92;
import a.m42;
import a.me1;
import a.ml0;
import a.n30;
import a.n52;
import a.n92;
import a.ne1;
import a.oc2;
import a.oe1;
import a.of2;
import a.on0;
import a.p80;
import a.pe1;
import a.q92;
import a.qc2;
import a.qe1;
import a.qe2;
import a.qf2;
import a.qy0;
import a.r62;
import a.re1;
import a.ry0;
import a.s42;
import a.se1;
import a.t52;
import a.t61;
import a.ty0;
import a.u42;
import a.u61;
import a.ue1;
import a.v62;
import a.v72;
import a.wd2;
import a.x62;
import a.xd2;
import a.y42;
import a.z32;
import a.z42;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.ui.BlurViewLinearLayout;
import com.omarea.ui.BlurViewRelativeLayout;
import com.omarea.ui.SeekBar;
import com.omarea.ui.Tags;
import com.omarea.ui.bench.CyclesPowerView;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityPowerBench extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kl0 f5401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qf2 f5402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ry0 f5403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f5404a = a42.a(u.f8834a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<qy0> f5406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Integer> f5408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f5409a;
    public final z32 b;
    public final z32 c;
    public final z32 d;
    public final z32 e;
    public final z32 f;
    public final z32 g;
    public final z32 h;

    public static final class a extends g92 implements v72<String[]> {
        public a() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String[] i() {
            Set setKeySet = ActivityPowerBench.this.H().keySet();
            f92.c(setKeySet, "calcOptions.keys");
            Object[] array = setKeySet.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerBench$startTest$6", f = "ActivityPowerBench.kt", l = {}, m = "invokeSuspend")
    public static final class a0 extends d72 implements k82<wd2, b62<? super p80.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8807a;
        public int b;

        public a0(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a0 a0Var = ActivityPowerBench.this.new a0(b62Var);
            a0Var.f8807a = (wd2) obj;
            return a0Var;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super p80.b> b62Var) {
            return ((a0) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            p80.a aVar = p80.f2403a;
            ActivityPowerBench activityPowerBench = ActivityPowerBench.this;
            String string = activityPowerBench.getString(u61.pb_done);
            f92.c(string, "getString(R.string.pb_done)");
            return p80.a.C(aVar, activityPowerBench, string, null, 4, null);
        }
    }

    public static final class b extends g92 implements v72<Map<String, ? extends String>> {
        public b() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, String> i() {
            return t52.f(j42.a("int", ActivityPowerBench.this.getString(u61.pb_int_full)), j42.a("float", ActivityPowerBench.this.getString(u61.pb_float_full)), j42.a("pi", ActivityPowerBench.this.getString(u61.pb_pi_full)), j42.a("json", ActivityPowerBench.this.getString(u61.pb_json_full)), j42.a("chess", ActivityPowerBench.this.getString(u61.pb_cheese_full)));
        }
    }

    public static final class b0 implements Runnable {
        public b0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            LinearLayout linearLayout = (LinearLayout) ActivityPowerBench.this._$_findCachedViewById(t61.rootView);
            f92.c(linearLayout, "rootView");
            linearLayout.setKeepScreenOn(false);
        }
    }

    public static final class c extends g92 implements v72<LinkedHashMap<String, String>> {
        public c() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LinkedHashMap<String, String> i() {
            return t52.e(j42.a("int", ActivityPowerBench.this.getString(u61.pb_int)), j42.a("float", ActivityPowerBench.this.getString(u61.pb_float)), j42.a("pi", " π "), j42.a("chess", ActivityPowerBench.this.getString(u61.pb_cheese)));
        }
    }

    public static final class c0 extends g92 implements g82<l30, m42> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8811a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5412a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean[] f5413a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ boolean f5414b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(int i, long j, String str, boolean[] zArr, int i2, int i3, boolean z) {
            super(1);
            this.b = i;
            this.f8811a = j;
            this.f5412a = str;
            this.f5413a = zArr;
            this.c = i2;
            this.d = i3;
            this.f5414b = z;
        }

        public final void a(l30 l30Var) throws Exception {
            f92.d(l30Var, "$receiver");
            l30Var.E("coreCount", Integer.valueOf(((SeekBar) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_bench_threads)).getProgress()));
            l30Var.E("targetLoad", Integer.valueOf(this.b));
            l30Var.E("durationMS", Long.valueOf(this.f8811a));
            l30Var.E("period", Integer.valueOf(((SeekBar) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_bench_period)).getProgress()));
            l30Var.E("mode", this.f5412a);
            l30Var.H("cpus", s42.h(this.f5413a));
            l30Var.E("ddrMinFreq", Integer.valueOf(this.c));
            l30Var.E("ramAccess", Integer.valueOf(this.d));
            l30Var.E("perfStat", Boolean.valueOf(this.f5414b));
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
            a(l30Var);
            return m42.f6769a;
        }
    }

    public static final class d extends on0 {
        public d(Context context, String str) {
            super(context, str);
        }

        @Override // a.on0
        public String f() {
            return "" + ActivityPowerBench.this.f5401a.h();
        }
    }

    public static final class d0 extends g92 implements v72<m42> {
        public d0() {
            super(0);
        }

        public final void a() {
            if (ActivityPowerBench.this.f5401a.B()) {
                e50.f677a.O0(new String[]{"@ioctl", "/proc/perfmgr_powerhal/ioctl_powerhal", "0x40046703", "1"});
            }
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ m42 i() {
            a();
            return m42.f6769a;
        }
    }

    public static final class e extends g92 implements v72<Integer> {
        public e() {
            super(0);
        }

        public final int a() {
            kl0 kl0Var = ActivityPowerBench.this.f5401a;
            ArrayList<String[]> arrayListF = ActivityPowerBench.this.f5401a.f();
            f92.c(arrayListF, "cpuUtil.clusterInfo");
            Object objJ = i52.J(arrayListF);
            f92.c(objJ, "cpuUtil.clusterInfo.last()");
            Object objZ = u42.z((Object[]) objJ);
            f92.c(objZ, "cpuUtil.clusterInfo.last().last()");
            return kl0Var.l(Integer.parseInt((String) objZ));
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Integer i() {
            return Integer.valueOf(a());
        }
    }

    public static final class e0 extends g92 implements v72<m42> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l92 f8815a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5416a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ HashSet f5417a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ int[] f5418a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ l92 f5419b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(l92 l92Var, l92 l92Var2, ArrayList arrayList, HashSet hashSet, int[] iArr, int i) {
            super(0);
            this.f8815a = l92Var;
            this.f5419b = l92Var2;
            this.f5416a = arrayList;
            this.f5417a = hashSet;
            this.f5418a = iArr;
            this.b = i;
        }

        public final void a() {
            int iIntValue;
            int iG = this.f8815a.f6687a;
            while (iG <= this.f8815a.f6687a && this.f5419b.f6687a <= ActivityPowerBench.this.I()) {
                ArrayList arrayList = this.f5416a;
                f92.c(arrayList, "clusters");
                Iterator it = i52.c0(arrayList).iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    n52 n52Var = (n52) it.next();
                    if (this.f5417a.contains(Integer.valueOf(n52Var.a()))) {
                        String[] strArrD = ActivityPowerBench.this.f5401a.d(n52Var.a());
                        f92.c(strArrD, "cpuUtil.getAvailableFrequencies(cluster.index)");
                        ArrayList arrayList2 = new ArrayList(strArrD.length);
                        int length = strArrD.length;
                        while (iIntValue < length) {
                            String str = strArrD[iIntValue];
                            f92.c(str, "it");
                            arrayList2.add(Integer.valueOf(Integer.parseInt(str)));
                            iIntValue++;
                        }
                        List listS = i52.S(arrayList2, new ue1());
                        this.f5418a[n52Var.a()] = ((Number) i52.J(listS)).intValue();
                        Iterator it2 = listS.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            int iIntValue2 = ((Number) it2.next()).intValue();
                            if (iIntValue2 >= this.f5419b.f6687a && iIntValue2 <= this.b) {
                                this.f5418a[n52Var.a()] = iIntValue2;
                                break;
                            }
                        }
                    }
                }
                iG = u42.G(this.f5418a);
                l92 l92Var = this.f5419b;
                int i = l92Var.f6687a;
                Integer numA = u42.A(this.f5418a);
                if (numA != null) {
                    iIntValue = numA.intValue();
                }
                l92Var.f6687a = Math.max(i, iIntValue) + 100000;
            }
            this.f8815a.f6687a = iG;
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ m42 i() {
            a();
            return m42.f6769a;
        }
    }

    public static final class f extends g92 implements v72<Integer> {
        public f() {
            super(0);
        }

        public final int a() {
            int i = Integer.MAX_VALUE;
            for (String[] strArr : ActivityPowerBench.this.f5401a.f()) {
                kl0 kl0Var = ActivityPowerBench.this.f5401a;
                f92.c(strArr, "cpu");
                Object objN = u42.n(strArr);
                f92.c(objN, "cpu.first()");
                int iM = kl0Var.m(Integer.parseInt((String) objN));
                if (iM < i) {
                    i = iM;
                }
            }
            return i;
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Integer i() {
            return Integer.valueOf(a());
        }
    }

    public static final class f0 extends g92 implements g82<l30, m42> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f0 f8817a = new f0();

        public f0() {
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

    public static final class g extends g92 implements v72<List<Integer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f8818a = new g();

        public g() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Integer> i() {
            List<Integer> listD = new ml0().d();
            return listD.isEmpty() ? y42.i(0, 1) : listD;
        }
    }

    public static final class g0 implements Runnable {
        public g0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            LinearLayout linearLayout = (LinearLayout) ActivityPowerBench.this._$_findCachedViewById(t61.rootView);
            f92.c(linearLayout, "rootView");
            linearLayout.setKeepScreenOn(false);
        }
    }

    public static final class h extends g92 implements v72<Integer> {
        public h() {
            super(0);
        }

        public final int a() {
            Integer num;
            Iterator it = ActivityPowerBench.this.M().iterator();
            if (it.hasNext()) {
                Integer numValueOf = Integer.valueOf(((Number) it.next()).intValue());
                while (it.hasNext()) {
                    Integer numValueOf2 = Integer.valueOf(((Number) it.next()).intValue());
                    if (numValueOf.compareTo(numValueOf2) < 0) {
                        numValueOf = numValueOf2;
                    }
                }
                num = numValueOf;
            } else {
                num = null;
            }
            Integer num2 = num;
            if (num2 != null) {
                return num2.intValue();
            }
            return 0;
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Integer i() {
            return Integer.valueOf(a());
        }
    }

    public static final class h0 extends g92 implements v72<ty0> {
        public h0() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ty0 i() {
            return new ty0(ActivityPowerBench.this.getBaseContext());
        }
    }

    public static final class i extends g92 implements v72<Integer> {
        public i() {
            super(0);
        }

        public final int a() {
            Integer num;
            Iterator it = ActivityPowerBench.this.M().iterator();
            if (it.hasNext()) {
                Integer numValueOf = Integer.valueOf(((Number) it.next()).intValue());
                while (it.hasNext()) {
                    Integer numValueOf2 = Integer.valueOf(((Number) it.next()).intValue());
                    if (numValueOf.compareTo(numValueOf2) > 0) {
                        numValueOf = numValueOf2;
                    }
                }
                num = numValueOf;
            } else {
                num = null;
            }
            Integer num2 = num;
            if (num2 != null) {
                return num2.intValue();
            }
            return 0;
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ Integer i() {
            return Integer.valueOf(a());
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5420a;

        public j(ArrayList arrayList) {
            this.f5420a = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((CyclesPowerView) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_bench_chart)).setSamples(this.f5420a);
        }
    }

    public static final class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p80.a aVar;
            ActivityPowerBench activityPowerBench;
            String string;
            String string2;
            String str;
            g91.i(ActivityPowerBench.this, false, 1, null);
            if (hz0.f1282a.b0()) {
                aVar = p80.f2403a;
                activityPowerBench = ActivityPowerBench.this;
                string = activityPowerBench.getString(u61.warn);
                f92.c(string, "getString(R.string.warn)");
                string2 = ActivityPowerBench.this.getString(u61.pb_perf_control);
                str = "getString(R.string.pb_perf_control)";
            } else {
                if (SystemClock.elapsedRealtime() >= 300000) {
                    ge1 ge1Var = new ge1(this);
                    if (!fa0.f867a.h()) {
                        ge1Var.i();
                        return;
                    }
                    p80.a aVar2 = p80.f2403a;
                    ActivityPowerBench activityPowerBench2 = ActivityPowerBench.this;
                    String string3 = activityPowerBench2.getString(u61.pb_power_invalid);
                    f92.c(string3, "getString(R.string.pb_power_invalid)");
                    String string4 = ActivityPowerBench.this.getString(u61.pb_power_invalid_full);
                    f92.c(string4, "getString(R.string.pb_power_invalid_full)");
                    aVar2.i(activityPowerBench2, (16 & 2) != 0 ? "" : string3, (16 & 4) != 0 ? "" : string4, (16 & 8) != 0 ? null : new se1(ge1Var), (16 & 16) != 0 ? null : null);
                    return;
                }
                aVar = p80.f2403a;
                activityPowerBench = ActivityPowerBench.this;
                string = activityPowerBench.getString(u61.pb_wait_idle);
                f92.c(string, "getString(R.string.pb_wait_idle)");
                string2 = ActivityPowerBench.this.getString(u61.pb_wait_idle_full);
                str = "getString(R.string.pb_wait_idle_full)";
            }
            p80.a aVar3 = aVar;
            ActivityPowerBench activityPowerBench3 = activityPowerBench;
            String str2 = string;
            String str3 = string2;
            f92.c(str3, str);
            p80.a.B(aVar3, activityPowerBench3, str2, str3, null, 8, null).i(false);
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CyclesPowerView cyclesPowerView = (CyclesPowerView) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_bench_chart);
            cyclesPowerView.setShowFreq(!cyclesPowerView.getShowFreq());
            boolean showFreq = cyclesPowerView.getShowFreq();
            TextView textView = (TextView) ActivityPowerBench.this._$_findCachedViewById(t61.chart_left_title);
            f92.c(textView, "chart_left_title");
            textView.setText(showFreq ? "(MHz)" : "(M Cycles)");
        }
    }

    public static final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList<ry0> arrayListJ = ActivityPowerBench.this.R().j();
            ArrayList arrayList = new ArrayList(z42.m(arrayListJ, 10));
            for (ry0 ry0Var : arrayListJ) {
                n30 n30Var = new n30(ActivityPowerBench.this.O(ry0Var), String.valueOf(ry0Var.f()));
                n30Var.g(ry0Var);
                arrayList.add(n30Var);
            }
            b90 b90Var = new b90(ActivityPowerBench.this.getThemeMode().a(), arrayList, false, new he1(this), 0, 16, null);
            b90Var.L1(false);
            b90Var.J1(new ie1(this));
            b90Var.B1(ActivityPowerBench.this.getSupportFragmentManager(), "PowerBenchSessions");
        }
    }

    public static final class n implements View.OnClickListener {
        public n() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ActivityPowerBench.this.f5406a.size() < 2) {
                Scene.c cVar = Scene.f4798a;
                String string = ActivityPowerBench.this.getString(u61.pb_need_more);
                f92.c(string, "getString(R.string.pb_need_more)");
                Scene.c.p(cVar, string, 0, 2, null);
                return;
            }
            ActivityPowerBench activityPowerBench = ActivityPowerBench.this;
            String strO = activityPowerBench.O(ActivityPowerBench.v(activityPowerBench));
            e90 e90Var = l90.f6685a;
            ActivityPowerBench activityPowerBench2 = ActivityPowerBench.this;
            String string2 = activityPowerBench2.getString(u61.fps_export_type_img);
            f92.c(string2, "getString(R.string.fps_export_type_img)");
            String string3 = ActivityPowerBench.this.getString(u61.fps_export_type_csv);
            f92.c(string3, "getString(R.string.fps_export_type_csv)");
            e90Var.b(activityPowerBench2, new String[]{string2, string3}, 0, new me1(this, strO)).o();
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerBench$onViewCreated$15", f = "ActivityPowerBench.kt", l = {423}, m = "invokeSuspend")
    public static final class o extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8828a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5422a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5423b;

        public o(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            o oVar = ActivityPowerBench.this.new o(b62Var);
            oVar.f8828a = (wd2) obj;
            return oVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((o) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [T, a.d42] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8828a;
                n92 n92Var = new n92();
                ?? G = ActivityPowerBench.this.R().g();
                n92Var.f6891a = G;
                if (((d42) G) != null) {
                    fg2 fg2VarC = qe2.c();
                    ne1 ne1Var = new ne1(this, n92Var, null);
                    this.f5422a = wd2Var;
                    this.f5423b = n92Var;
                    this.b = 1;
                    if (oc2.g(fg2VarC, ne1Var, this) == objC) {
                        return objC;
                    }
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

    public static final class p extends g92 implements v72<m42> {
        public p() {
            super(0);
        }

        public final void a() {
            p80.a.s(p80.f2403a, ActivityPowerBench.this, 2131558534, false, 4, null);
        }

        @Override // a.v72
        public /* bridge */ /* synthetic */ m42 i() {
            a();
            return m42.f6769a;
        }
    }

    public static final class q extends g92 implements g82<fj0, m42> {
        public q() {
            super(1);
        }

        public final void a(fj0 fj0Var) {
            f92.d(fj0Var, "it");
            String str = ActivityPowerBench.this.F()[fj0Var.g()];
            f92.c(str, "calcModes[it.getCheckedIndex()]");
            LinearLayout linearLayout = (LinearLayout) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_ram_access_opt);
            f92.c(linearLayout, "cpu_ram_access_opt");
            linearLayout.setVisibility((f92.a(str, "int") || f92.a(str, "float")) ? 0 : 8);
            if (f92.a(str, "pi")) {
                Scene.c cVar = Scene.f4798a;
                String string = ActivityPowerBench.this.getString(u61.pb_pi_warn);
                f92.c(string, "getString(R.string.pb_pi_warn)");
                Scene.c.p(cVar, string, 0, 2, null);
            }
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(fj0 fj0Var) {
            a(fj0Var);
            return m42.f6769a;
        }
    }

    public static final class r implements SeekBar.OnSeekBarChangeListener {
        public r() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (((com.omarea.ui.SeekBar) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_max_freq)).getProgress() < i) {
                ((com.omarea.ui.SeekBar) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_max_freq)).setProgress(i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
        }
    }

    public static final class s implements SeekBar.OnSeekBarChangeListener {
        public s() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (((com.omarea.ui.SeekBar) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_min_freq)).getProgress() > i) {
                ((com.omarea.ui.SeekBar) ActivityPowerBench.this._$_findCachedViewById(t61.cpu_min_freq)).setProgress(i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
        }
    }

    public static final class t implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5424a;

        public t(ArrayList arrayList) {
            this.f5424a = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new b90(ActivityPowerBench.this.getThemeMode().a(), this.f5424a, true, new oe1(this), 4).B1(ActivityPowerBench.this.getSupportFragmentManager(), "cpu-bench-cores");
        }
    }

    public static final class u extends g92 implements v72<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f8834a = new u();

        public u() {
            super(0);
        }

        @Override // a.v72
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String i() {
            String strB = jm0.f6525a.b();
            if (strB == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = strB.toUpperCase();
            f92.c(upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerBench", f = "ActivityPowerBench.kt", l = {486, 490, 491, 498}, m = "powerSat")
    public static final class v extends v62 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8835a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f5425a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public /* synthetic */ Object f5427a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5428b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public Object f5429c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public Object f5430d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;

        public v(b62 b62Var) {
            super(b62Var);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            this.f5427a = obj;
            this.f8835a |= Integer.MIN_VALUE;
            return ActivityPowerBench.this.T(0, this);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerBench", f = "ActivityPowerBench.kt", l = {663, 670, 677, 723, 729, 731, 737, 743, 756}, m = "startTest")
    public static final class w extends v62 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8836a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f5431a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public /* synthetic */ Object f5433a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5434b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f5435b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public Object f5436c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public Object f5437d;
        public int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public Object f5438e;
        public int f;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public Object f5439f;
        public int g;

        /* JADX INFO: renamed from: g, reason: collision with other field name */
        public Object f5440g;
        public int h;

        /* JADX INFO: renamed from: h, reason: collision with other field name */
        public Object f5441h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;
        public Object m;
        public Object n;
        public Object o;
        public Object p;
        public Object q;

        public w(b62 b62Var) {
            super(b62Var);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            this.f5433a = obj;
            this.f8836a |= Integer.MIN_VALUE;
            return ActivityPowerBench.this.W(null, this);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerBench$startTest$3", f = "ActivityPowerBench.kt", l = {}, m = "invokeSuspend")
    public static final class x extends d72 implements k82<wd2, b62<? super p80.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n92 f8837a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f5442a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(n92 n92Var, b62 b62Var) {
            super(2, b62Var);
            this.f8837a = n92Var;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            x xVar = ActivityPowerBench.this.new x(this.f8837a, b62Var);
            xVar.f5442a = (wd2) obj;
            return xVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super p80.b> b62Var) {
            return ((x) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            p80.a aVar = p80.f2403a;
            ActivityPowerBench activityPowerBench = ActivityPowerBench.this;
            String string = activityPowerBench.getString(u61.pb_set_freq_fail);
            f92.c(string, "getString(R.string.pb_set_freq_fail)");
            return p80.a.B(aVar, activityPowerBench, string, ActivityPowerBench.this.getString(u61.pb_set_freq_fail_full) + "\n" + ((StringBuilder) this.f8837a.f6891a).toString(), null, 8, null);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerBench$startTest$4", f = "ActivityPowerBench.kt", l = {}, m = "invokeSuspend")
    public static final class y extends d72 implements k82<wd2, b62<? super p80.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8838a;
        public int b;

        public y(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            y yVar = ActivityPowerBench.this.new y(b62Var);
            yVar.f8838a = (wd2) obj;
            return yVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super p80.b> b62Var) {
            return ((y) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            p80.a aVar = p80.f2403a;
            ActivityPowerBench activityPowerBench = ActivityPowerBench.this;
            String string = activityPowerBench.getString(u61.pb_temp_high);
            f92.c(string, "getString(R.string.pb_temp_high)");
            String string2 = ActivityPowerBench.this.getString(u61.pb_temp_high_full);
            f92.c(string2, "getString(R.string.pb_temp_high_full)");
            return p80.a.B(aVar, activityPowerBench, string, string2, null, 8, null);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPowerBench$startTest$5", f = "ActivityPowerBench.kt", l = {}, m = "invokeSuspend")
    public static final class z extends d72 implements k82<wd2, b62<? super p80.b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8839a;
        public int b;

        public z(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            z zVar = ActivityPowerBench.this.new z(b62Var);
            zVar.f8839a = (wd2) obj;
            return zVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super p80.b> b62Var) {
            return ((z) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            r62.c();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
            p80.a aVar = p80.f2403a;
            ActivityPowerBench activityPowerBench = ActivityPowerBench.this;
            String string = activityPowerBench.getString(u61.pb_freq_changed);
            f92.c(string, "getString(R.string.pb_freq_changed)");
            String string2 = ActivityPowerBench.this.getString(u61.pb_freq_changed_full);
            f92.c(string2, "getString(R.string.pb_freq_changed_full)");
            return p80.a.B(aVar, activityPowerBench, string, string2, null, 8, null);
        }
    }

    public ActivityPowerBench() {
        kl0 kl0Var = new kl0();
        this.f5401a = kl0Var;
        this.f5405a = kl0Var.s(0);
        this.f5406a = new ArrayList<>();
        this.f8805a = new d(Scene.f4798a.c(), "CoreCount").i();
        this.b = a42.a(new f());
        this.c = a42.a(new e());
        this.d = a42.a(g.f8818a);
        a42.a(new h());
        a42.a(new i());
        this.e = a42.a(new c());
        this.f = a42.a(new b());
        this.g = a42.a(new a());
        this.f5408a = new ArrayList();
        int i2 = this.f8805a;
        boolean[] zArr = new boolean[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            zArr[i3] = true;
        }
        this.f5409a = zArr;
        this.h = a42.a(new h0());
    }

    public static /* synthetic */ String C(ActivityPowerBench activityPowerBench, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 11;
        }
        return activityPowerBench.A(i2, i3);
    }

    public static /* synthetic */ String D(ActivityPowerBench activityPowerBench, String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 11;
        }
        return activityPowerBench.B(str, i2);
    }

    public static final /* synthetic */ ry0 v(ActivityPowerBench activityPowerBench) {
        ry0 ry0Var = activityPowerBench.f5403a;
        if (ry0Var != null) {
            return ry0Var;
        }
        f92.m("session");
        throw null;
    }

    public final String A(int i2, int i3) {
        return B(String.valueOf(i2), i3);
    }

    public final String B(String str, int i2) {
        return str + bc2.r(" ", Math.max(0, i2 - str.length()));
    }

    public final void E() throws Throwable {
        Object objA;
        Scene.c cVar;
        String string;
        String str;
        c60 c60Var;
        File file;
        Charset charset;
        ry0 ry0Var = this.f5403a;
        if (ry0Var == null) {
            f92.m("session");
            throw null;
        }
        String strO = O(ry0Var);
        ty0 ty0VarR = R();
        ArrayList<qy0> arrayList = this.f5406a;
        boolean[] zArr = this.f5409a;
        ry0 ry0Var2 = this.f5403a;
        if (ry0Var2 == null) {
            f92.m("session");
            throw null;
        }
        String strD = ty0VarR.d(arrayList, zArr, ry0Var2.c());
        try {
            e42 e42Var = g42.f6169a;
            String str2 = c60.f5764a.e() + "/" + strO + ".csv";
            c60Var = c60.f5764a;
            file = new File(str2);
            charset = bb2.f5692a;
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th);
            g42.a(objA);
        }
        if (strD == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strD.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        c60Var.i(file, bytes);
        objA = Boolean.TRUE;
        g42.a(objA);
        if (g42.c(objA)) {
            objA = null;
        }
        if (f92.a((Boolean) objA, Boolean.TRUE)) {
            cVar = Scene.f4798a;
            string = getString(u61.fps_export_success);
            str = "getString(R.string.fps_export_success)";
        } else {
            cVar = Scene.f4798a;
            string = getString(u61.fps_export_fail);
            str = "getString(R.string.fps_export_fail)";
        }
        f92.c(string, str);
        Scene.c.p(cVar, string, 0, 2, null);
    }

    public final String[] F() {
        return (String[]) this.g.getValue();
    }

    public final Map<String, String> G() {
        return (Map) this.f.getValue();
    }

    public final LinkedHashMap<String, String> H() {
        return (LinkedHashMap) this.e.getValue();
    }

    public final int I() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final int J() {
        return ((Number) this.b.getValue()).intValue();
    }

    public final String K() {
        return L(this.f5409a);
    }

    public final String L(boolean[] zArr) {
        ea2 ea2VarO = u42.o(zArr);
        ArrayList arrayList = new ArrayList();
        for (Integer num : ea2VarO) {
            if (zArr[num.intValue()]) {
                arrayList.add(num);
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        List listW = i52.w(arrayList, 1);
        List listI = y42.i(j42.a(i52.A(arrayList), i52.A(arrayList)));
        Iterator it = listW.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (((Number) ((d42) i52.J(listI)).d()).intValue() + 1 == iIntValue) {
                listI.set(y42.g(listI), j42.a(((d42) i52.J(listI)).c(), Integer.valueOf(iIntValue)));
            } else {
                listI.add(j42.a(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue)));
            }
        }
        return i52.H(listI, ",", null, null, 0, null, ce1.f5785a, 30, null);
    }

    public final List<Integer> M() {
        return (List) this.d.getValue();
    }

    public final String N() {
        StringBuilder sb = new StringBuilder();
        ArrayList<String[]> arrayListF = this.f5401a.f();
        f92.c(arrayListF, "cpuUtil.clusterInfo");
        Iterator it = i52.c0(arrayListF).iterator();
        while (it.hasNext()) {
            sb.append(D(this, "cluster" + ((n52) it.next()).a(), 0, 2, null));
        }
        sb.append(D(this, "Power(mW)", 0, 2, null));
        sb.append(D(this, "-#I(mW)", 0, 2, null));
        sb.append(D(this, "Score", 0, 2, null));
        sb.append(D(this, "CPU(°C)", 0, 2, null));
        sb.append(D(this, "Score/mW", 0, 2, null));
        sb.append(D(this, "Cycles/mW", 0, 2, null));
        sb.append("\n");
        String string = sb.toString();
        f92.c(string, "headers.toString()");
        return string;
    }

    public final String O(ry0 ry0Var) {
        String str;
        String strD = ry0Var.d();
        String strL = L(ry0Var.a());
        int iG = ry0Var.g();
        int iB = ry0Var.b();
        if (f92.a(strD, "int") || f92.a(strD, "float")) {
            str = getString(u61.pb_random_mem_access) + ' ' + ry0Var.e() + "    ";
        } else {
            str = "";
        }
        return P() + "     " + G().get(strD) + "     " + ry0Var.h() + getString(u61.pb_threads) + "    " + str + "CPU " + strL + "    " + getString(u61.pb_target_load) + ' ' + iG + "    " + getString(u61.pb_ddr_min) + ' ' + iB;
    }

    public final String P() {
        return (String) this.f5404a.getValue();
    }

    public final String Q(boolean[] zArr, qy0 qy0Var) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String[]> arrayListF = this.f5401a.f();
        if (qy0Var.e().length() > 0) {
            int size = arrayListF.size() + 6;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(D(this, "--------", 0, 2, null));
            }
        }
        sb.append("\n");
        for (String[] strArr : arrayListF) {
            ArrayList<Integer> arrayListC = qy0Var.c();
            String str = strArr[0];
            f92.c(str, "cluster[0]");
            Integer num = arrayListC.get(Integer.parseInt(str));
            f92.c(num, "stat.frequencies[cluster[0].toInt()]");
            sb.append(C(this, num.intValue(), 0, 2, null));
        }
        sb.append(C(this, qy0Var.f(), 0, 2, null));
        sb.append(C(this, qy0Var.b(), 0, 2, null));
        sb.append(C(this, qy0Var.g(), 0, 2, null));
        sb.append(C(this, qy0Var.h(), 0, 2, null));
        int iIntValue = 0;
        for (n52 n52Var : i52.c0(qy0Var.a())) {
            if (zArr[n52Var.a()]) {
                iIntValue += ((Number) n52Var.b()).intValue();
            }
        }
        if (qy0Var.b() > 0) {
            double dG = ((double) qy0Var.g()) / ((double) qy0Var.b());
            double dB = ((double) iIntValue) / ((double) qy0Var.b());
            q92 q92Var = q92.f7191a;
            String str2 = String.format(" %.2f", Arrays.copyOf(new Object[]{Double.valueOf(dG)}, 1));
            f92.c(str2, "java.lang.String.format(format, *args)");
            sb.append(D(this, str2, 0, 2, null));
            q92 q92Var2 = q92.f7191a;
            String str3 = String.format(" %.2f", Arrays.copyOf(new Object[]{Double.valueOf(dB)}, 1));
            f92.c(str3, "java.lang.String.format(format, *args)");
            sb.append(D(this, str3, 0, 2, null));
        }
        if (qy0Var.e().length() > 0) {
            sb.append("\n");
            sb.append(qy0Var.e());
        }
        String string = sb.toString();
        f92.c(string, "text.toString()");
        return string;
    }

    public final ty0 R() {
        return (ty0) this.h.getValue();
    }

    public final void S(ry0 ry0Var, ArrayList<qy0> arrayList) {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(t61.cpu_title);
        f92.c(frameLayout, "cpu_title");
        frameLayout.setVisibility(8);
        BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.cpu_options);
        f92.c(blurViewLinearLayout, "cpu_options");
        blurViewLinearLayout.setVisibility(8);
        BlurViewRelativeLayout blurViewRelativeLayout = (BlurViewRelativeLayout) _$_findCachedViewById(t61.cpu_bench_chart_view);
        f92.c(blurViewRelativeLayout, "cpu_bench_chart_view");
        blurViewRelativeLayout.setVisibility(0);
        TextView textView = (TextView) _$_findCachedViewById(t61.cpu_bench_legend);
        f92.c(textView, "cpu_bench_legend");
        textView.setText(O(ry0Var));
        TextView textView2 = (TextView) _$_findCachedViewById(t61.cpu_bench_result);
        if (textView2 != null) {
            textView2.setText((CharSequence) null);
            kk0.b(textView2, getString(u61.pb_idle_power) + "#I     " + ry0Var.c() + "mW\n");
            kk0.b(textView2, N());
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                kk0.b(textView2, Q(ry0Var.a(), (qy0) it.next()));
            }
        }
        TextView textView3 = (TextView) _$_findCachedViewById(t61.cpu_bench_result);
        f92.c(textView3, "cpu_bench_result");
        textView3.setVisibility(0);
        this.f5403a = ry0Var;
        this.f5406a.clear();
        this.f5406a.addAll(arrayList);
        Scene.f4798a.j(new j(arrayList), 50L);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x039a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x039b -> B:63:0x03a7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object T(int r32, a.b62<? super a.qy0> r33) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instruction units count: 1234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityPowerBench.T(int, a.b62):java.lang.Object");
    }

    public final void U() {
        Object next;
        HashSet hashSet = new HashSet();
        ArrayList<String[]> arrayListF = this.f5401a.f();
        f92.c(arrayListF, "cpuUtil.clusterInfo");
        Iterator it = i52.c0(arrayListF).iterator();
        while (true) {
            if (!it.hasNext()) {
                this.f5408a = i52.S(i52.Y(hashSet), new re1());
                com.omarea.ui.SeekBar seekBar = (com.omarea.ui.SeekBar) _$_findCachedViewById(t61.cpu_min_freq);
                seekBar.setFormatter(new pe1(this));
                seekBar.setMax(this.f5408a.size() - 1);
                seekBar.setMin(0);
                seekBar.setProgress(0);
                com.omarea.ui.SeekBar seekBar2 = (com.omarea.ui.SeekBar) _$_findCachedViewById(t61.cpu_max_freq);
                seekBar2.setFormatter(new qe1(this));
                seekBar2.setMax(this.f5408a.size() - 1);
                seekBar2.setMin(0);
                seekBar2.setProgress(seekBar2.getMax());
                return;
            }
            n52 n52Var = (n52) it.next();
            Object objB = n52Var.b();
            f92.c(objB, "cluster.value");
            Object[] objArr = (Object[]) objB;
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                String str = (String) obj;
                f92.c(str, "it");
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    next = it2.next();
                    if (this.f5409a[((Number) next).intValue()]) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            if (next != null) {
                for (String str2 : this.f5401a.d(n52Var.a())) {
                    f92.c(str2, "freq");
                    hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                }
            }
        }
    }

    public final void V(qf2 qf2Var) {
        this.f5402a = qf2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0ad7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0bf4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0bf5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0c5b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0cc4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0776 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0796 A[LOOP:2: B:55:0x0790->B:57:0x0796, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0838 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0839  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x08e9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x095a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0a6e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0a70  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0a74  */
    /* JADX WARN: Type inference failed for: r7v27, types: [T, java.lang.StringBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0bf5 -> B:110:0x0c20). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object W(boolean[] r85, a.b62<? super a.m42> r86) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instruction units count: 3696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityPowerBench.W(boolean[], a.b62):java.lang.Object");
    }

    public final void X() {
        qf2 qf2Var = this.f5402a;
        if (qf2Var != null) {
            of2.a(qf2Var, null, 1, null);
        }
        this.f5402a = null;
        BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.cpu_options);
        f92.c(blurViewLinearLayout, "cpu_options");
        blurViewLinearLayout.setVisibility(0);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(t61.cpu_title);
        f92.c(frameLayout, "cpu_title");
        frameLayout.setVisibility(0);
        e50 e50Var = e50.f677a;
        String string = new l30(f0.f8817a).toString();
        f92.c(string, "json {\n            \"dura…to 1\n        }.toString()");
        e50.j1(e50Var, "cpu-bench", string, null, 4, null);
        ArrayList<String[]> arrayListF = this.f5401a.f();
        f92.c(arrayListF, "cpuUtil.clusterInfo");
        for (n52 n52Var : i52.c0(arrayListF)) {
            this.f5401a.F(this.f5405a, n52Var.a());
            kl0 kl0Var = this.f5401a;
            int iA = n52Var.a();
            kl0 kl0Var2 = this.f5401a;
            Object objB = n52Var.b();
            f92.c(objB, "cluster.value");
            Object objN = u42.n((Object[]) objB);
            f92.c(objN, "cluster.value.first()");
            kl0Var.G(iA, String.valueOf(kl0Var2.l(Integer.parseInt((String) objN))));
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.rootView);
        if (linearLayout != null) {
            linearLayout.post(new g0());
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5407a == null) {
            this.f5407a = new HashMap();
        }
        View view = (View) this.f5407a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5407a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.g91, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        qf2 qf2Var = this.f5402a;
        if (qf2Var != null && qf2Var != null && qf2Var.a()) {
            X();
            return;
        }
        BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) _$_findCachedViewById(t61.cpu_options);
        f92.c(blurViewLinearLayout, "cpu_options");
        if (blurViewLinearLayout.getVisibility() != 8) {
            super.onBackPressed();
            return;
        }
        BlurViewLinearLayout blurViewLinearLayout2 = (BlurViewLinearLayout) _$_findCachedViewById(t61.cpu_options);
        f92.c(blurViewLinearLayout2, "cpu_options");
        blurViewLinearLayout2.setVisibility(0);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(t61.cpu_title);
        f92.c(frameLayout, "cpu_title");
        frameLayout.setVisibility(0);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558461);
        onViewCreated();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
        X();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        g91.i(this, false, 1, null);
    }

    public final void onViewCreated() {
        StringBuilder sb;
        Object objN;
        U();
        TextView textView = (TextView) _$_findCachedViewById(t61.cpu_title_text);
        f92.c(textView, "cpu_title_text");
        String string = getString(u61.pb_more);
        f92.c(string, "getString(R.string.pb_more)");
        kk0.a(textView, string, new p());
        Tags tags = (Tags) _$_findCachedViewById(t61.cpu_load_type);
        Collection<String> collectionValues = H().values();
        f92.c(collectionValues, "calcOptions.values");
        Object[] array = collectionValues.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        tags.b((String[]) array, 0).j(new q());
        com.omarea.ui.SeekBar seekBar = (com.omarea.ui.SeekBar) _$_findCachedViewById(t61.cpu_bench_threads);
        boolean[] zArr = this.f5409a;
        ArrayList arrayList = new ArrayList();
        for (boolean z2 : zArr) {
            if (z2) {
                arrayList.add(Boolean.valueOf(z2));
            }
        }
        seekBar.setMax(arrayList.size());
        seekBar.setProgress(seekBar.getMax());
        com.omarea.ui.SeekBar seekBar2 = (com.omarea.ui.SeekBar) _$_findCachedViewById(t61.ddr_min_freq);
        seekBar2.setMax(M().size() - 1);
        seekBar2.setMin(0);
        seekBar2.setProgress(seekBar2.getMin());
        seekBar2.setFormatter(this.f5401a.B() ? new de1(this) : new ee1(this));
        com.omarea.ui.SeekBar seekBar3 = (com.omarea.ui.SeekBar) _$_findCachedViewById(t61.cpu_temp_limit);
        hn0 hn0Var = new hn0();
        if (hn0Var.f() && hn0Var.d()) {
            seekBar3.setProgress(104);
        }
        ((com.omarea.ui.SeekBar) _$_findCachedViewById(t61.cpu_min_freq)).setOnSeekBarChangeListener(new r());
        ((com.omarea.ui.SeekBar) _$_findCachedViewById(t61.cpu_max_freq)).setOnSeekBarChangeListener(new s());
        ArrayList arrayList2 = new ArrayList();
        int i2 = this.f8805a;
        for (int i3 = 0; i3 < i2; i3++) {
            n30 n30Var = new n30();
            n30Var.i("CPU " + i3);
            n30Var.j("" + i3);
            n30Var.h(true);
            m42 m42Var = m42.f6769a;
            arrayList2.add(n30Var);
        }
        ((TextView) _$_findCachedViewById(t61.cpu_cpuset)).setOnClickListener(new t(arrayList2));
        TextView textView2 = (TextView) _$_findCachedViewById(t61.cpu_bench_result);
        File file = new File("/system/fonts/DroidSansMono.ttf");
        if (file.exists()) {
            textView2.setTypeface(Typeface.createFromFile(file));
        }
        ((Button) _$_findCachedViewById(t61.cpu_start)).setOnClickListener(new k());
        ((ImageView) _$_findCachedViewById(t61.chart_toggle_cycles)).setOnClickListener(new l());
        TextView textView3 = (TextView) _$_findCachedViewById(t61.chart_left_title);
        f92.c(textView3, "chart_left_title");
        textView3.setText(((CyclesPowerView) _$_findCachedViewById(t61.cpu_bench_chart)).getShowFreq() ? "(MHz)" : "(M Cycles)");
        ArrayList<Integer> arrayListA = new e51().a();
        ArrayList<String[]> arrayListF = this.f5401a.f();
        f92.c(arrayListF, "cpuUtil.clusterInfo");
        int i4 = 0;
        for (Object obj : arrayListF) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                y42.l();
                throw null;
            }
            String[] strArr = (String[]) obj;
            if (strArr.length > 1) {
                sb = new StringBuilder();
                sb.append("■ CPU ");
                f92.c(strArr, "it");
                sb.append((String) u42.n(strArr));
                sb.append('~');
                objN = u42.z(strArr);
            } else {
                sb = new StringBuilder();
                sb.append("■ CPU ");
                f92.c(strArr, "it");
                objN = u42.n(strArr);
            }
            sb.append((String) objN);
            sb.append("  ");
            String string2 = sb.toString();
            TextView textView4 = (TextView) _$_findCachedViewById(t61.cpu_cluster_legend);
            SpannableString spannableString = new SpannableString(string2);
            Integer num = arrayListA.get(i4);
            f92.c(num, "colors.get(cIndex)");
            spannableString.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
            m42 m42Var2 = m42.f6769a;
            textView4.append(spannableString);
            i4 = i5;
        }
        ((ImageView) _$_findCachedViewById(t61.cpu_bench_history)).setOnClickListener(new m());
        ((ImageView) _$_findCachedViewById(t61.cpu_bench_export)).setOnClickListener(new n());
        qc2.d(xd2.a(qe2.b()), null, null, new o(null), 3, null);
    }
}
