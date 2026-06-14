package com.omarea.vtools.activities;

import a.ab1;
import a.b62;
import a.b90;
import a.bb1;
import a.bb2;
import a.bc2;
import a.c60;
import a.cb1;
import a.co0;
import a.d42;
import a.d72;
import a.db1;
import a.di;
import a.e42;
import a.e50;
import a.e90;
import a.eb1;
import a.ec2;
import a.eh;
import a.ey0;
import a.f92;
import a.fe2;
import a.fg2;
import a.g42;
import a.g82;
import a.g91;
import a.g92;
import a.h42;
import a.i52;
import a.ih0;
import a.j92;
import a.jm0;
import a.k82;
import a.k92;
import a.ki;
import a.kk0;
import a.l90;
import a.l92;
import a.m42;
import a.ml0;
import a.n30;
import a.n52;
import a.n92;
import a.oa1;
import a.oc2;
import a.p80;
import a.pa1;
import a.ph0;
import a.py0;
import a.q92;
import a.qa1;
import a.qc2;
import a.qe2;
import a.r62;
import a.ra1;
import a.s80;
import a.sa1;
import a.su0;
import a.t61;
import a.t62;
import a.ta1;
import a.tj0;
import a.u42;
import a.u61;
import a.ua1;
import a.vj0;
import a.w90;
import a.wd2;
import a.wu0;
import a.x62;
import a.xd2;
import a.y42;
import a.ya1;
import a.yb;
import a.yb2;
import a.za1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.model.FpsWatchSession;
import com.omarea.ui.BlurViewLinearLayout;
import com.omarea.ui.BlurViewRelativeLayout;
import com.omarea.ui.fps.BatteryIOView;
import com.omarea.ui.fps.CpuCyclesView;
import com.omarea.ui.fps.CpuFrequencyStat;
import com.omarea.ui.fps.CpuFrequencyView;
import com.omarea.ui.fps.CpuLoadsView;
import com.omarea.ui.fps.CpuTemperatureView;
import com.omarea.ui.fps.DDRView;
import com.omarea.ui.fps.FpsDataView;
import com.omarea.ui.fps.FpsJankView;
import com.omarea.ui.fps.FrameTimeView;
import com.omarea.ui.fps.GpuLoadView;
import com.omarea.ui.fps.PowerView;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityFpsSession extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final py0 f8652a = new py0(Scene.f4798a.c());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5251a;

    public static final class a extends g92 implements g82<String, m42> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8653a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j) {
            super(1);
            this.f8653a = j;
        }

        public final void a(String str) {
            f92.d(str, "remark");
            ActivityFpsSession.this.f8652a.d0(this.f8653a, str);
            ey0 ey0VarL = ActivityFpsSession.this.f8652a.l(this.f8653a);
            if (ey0VarL.a().length() > 0) {
                qc2.d(xd2.a(qe2.b()), null, null, new qa1(ey0VarL, str, null), 3, null);
            }
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(String str) {
            a(str);
            return m42.f6769a;
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityFpsSession.this.s();
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8655a;

        public c(long j) {
            this.f8655a = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList<ArrayList<Float>> arrayListA = ActivityFpsSession.this.f8652a.A(this.f8655a);
            int size = ((ArrayList) i52.A(arrayListA)).size();
            Float[] fArr = new Float[size];
            for (int i = 0; i < size; i++) {
                fArr[i] = Float.valueOf(0.0f);
            }
            for (ArrayList<Float> arrayList : arrayListA) {
                f92.c(arrayList, "row");
                for (n52 n52Var : i52.c0(arrayList)) {
                    int iA = n52Var.a();
                    fArr[iA] = Float.valueOf(fArr[iA].floatValue() + ((Number) n52Var.b()).floatValue());
                }
            }
            StringBuilder sb = new StringBuilder("CPU    AVG\n");
            int size2 = arrayListA.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("CPU" + i2 + "   " + ((int) (fArr[i2].floatValue() / size2)) + '\n');
            }
            p80.a aVar = p80.f2403a;
            ActivityFpsSession activityFpsSession = ActivityFpsSession.this;
            w90 w90Var = new w90();
            String string = sb.toString();
            f92.c(string, "text.toString()");
            p80.a.B(aVar, activityFpsSession, "CPU Usage", w90Var.c(string), null, 8, null);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityFpsSession.this.t();
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CpuFrequencyView cpuFrequencyView = (CpuFrequencyView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_cpu_frequencies);
            f92.c(cpuFrequencyView, "chart_cpu_frequencies");
            if (cpuFrequencyView.getVisibility() == 8) {
                CpuFrequencyView cpuFrequencyView2 = (CpuFrequencyView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_cpu_frequencies);
                f92.c(cpuFrequencyView2, "chart_cpu_frequencies");
                cpuFrequencyView2.setVisibility(0);
                CpuFrequencyStat cpuFrequencyStat = (CpuFrequencyStat) ActivityFpsSession.this._$_findCachedViewById(t61.chart_cpu_frequencies_stat);
                f92.c(cpuFrequencyStat, "chart_cpu_frequencies_stat");
                cpuFrequencyStat.setVisibility(8);
                return;
            }
            CpuFrequencyView cpuFrequencyView3 = (CpuFrequencyView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_cpu_frequencies);
            f92.c(cpuFrequencyView3, "chart_cpu_frequencies");
            cpuFrequencyView3.setVisibility(8);
            CpuFrequencyStat cpuFrequencyStat2 = (CpuFrequencyStat) ActivityFpsSession.this._$_findCachedViewById(t61.chart_cpu_frequencies_stat);
            f92.c(cpuFrequencyStat2, "chart_cpu_frequencies_stat");
            cpuFrequencyStat2.setVisibility(0);
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8658a;

        public f(long j) {
            this.f8658a = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList<ArrayList<Integer>> arrayListY = ActivityFpsSession.this.f8652a.y(this.f8658a);
            int size = ((ArrayList) i52.A(arrayListY)).size();
            Integer[] numArr = new Integer[size];
            for (int i = 0; i < size; i++) {
                numArr[i] = 0;
            }
            for (ArrayList<Integer> arrayList : arrayListY) {
                f92.c(arrayList, "row");
                for (n52 n52Var : i52.c0(arrayList)) {
                    int iA = n52Var.a();
                    numArr[iA] = Integer.valueOf(numArr[iA].intValue() + ((Number) n52Var.b()).intValue());
                }
            }
            StringBuilder sb = new StringBuilder("CPU    AVG\n");
            int size2 = arrayListY.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("CPU" + i2 + "   " + (numArr[i2].intValue() / size2) + '\n');
            }
            p80.a aVar = p80.f2403a;
            ActivityFpsSession activityFpsSession = ActivityFpsSession.this;
            w90 w90Var = new w90();
            String string = sb.toString();
            f92.c(string, "text.toString()");
            p80.a.B(aVar, activityFpsSession, "CPU Frequencies", w90Var.c(string), null, 8, null);
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8659a;

        public g(long j) {
            this.f8659a = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList<ArrayList<Integer>> arrayListX = ActivityFpsSession.this.f8652a.x(this.f8659a);
            int size = ((ArrayList) i52.A(arrayListX)).size();
            Integer[] numArr = new Integer[size];
            for (int i = 0; i < size; i++) {
                numArr[i] = 0;
            }
            for (ArrayList<Integer> arrayList : arrayListX) {
                f92.c(arrayList, "row");
                for (n52 n52Var : i52.c0(arrayList)) {
                    int iA = n52Var.a();
                    numArr[iA] = Integer.valueOf(numArr[iA].intValue() + ((Number) n52Var.b()).intValue());
                }
            }
            StringBuilder sb = new StringBuilder("CPU    AVG\n");
            int size2 = arrayListX.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append("CPU" + i2 + "   " + (numArr[i2].intValue() / size2) + '\n');
            }
            p80.a aVar = p80.f2403a;
            ActivityFpsSession activityFpsSession = ActivityFpsSession.this;
            w90 w90Var = new w90();
            String string = sb.toString();
            f92.c(string, "text.toString()");
            p80.a.B(aVar, activityFpsSession, "CPU Cycles", w90Var.c(string), null, 8, null);
        }
    }

    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CharSequence charSequence;
            FpsDataView.a[] aVarArrValues = FpsDataView.a.values();
            ((FpsDataView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_session)).setRightDimension(aVarArrValues[(u42.t(aVarArrValues, ((FpsDataView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_session)).getRightDimension()) + 1) % aVarArrValues.length]);
            TextView textView = (TextView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_right);
            f92.c(textView, "chart_right");
            int i = oa1.f7001a[((FpsDataView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_session)).getRightDimension().ordinal()];
            if (i == 1) {
                charSequence = "Temperature(℃)";
            } else if (i == 2) {
                charSequence = "Battery(%)";
            } else if (i != 3) {
                charSequence = "";
            } else {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#87d3ff"));
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Color.parseColor("#80fc6bc5"));
                StyleSpan styleSpan = new StyleSpan(1);
                SpannableString spannableString = new SpannableString("CPU/GPU Load(%)");
                spannableString.setSpan(foregroundColorSpan2, 0, 3, 33);
                spannableString.setSpan(styleSpan, 0, 3, 33);
                spannableString.setSpan(foregroundColorSpan, 4, 8, 33);
                spannableString.setSpan(styleSpan, 4, 8, 33);
                m42 m42Var = m42.f6769a;
                charSequence = spannableString;
            }
            textView.setText(charSequence);
        }
    }

    public static final class i implements s80 {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5256a;
        public final /* synthetic */ ArrayList b;

        public i(ArrayList arrayList, ArrayList arrayList2) {
            this.f5256a = arrayList;
            this.b = arrayList2;
        }

        @Override // a.s80
        public void a(List<n30> list, boolean[] zArr) {
            f92.d(list, "selected");
            f92.d(zArr, "status");
            ArrayList arrayList = new ArrayList();
            int length = zArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                if (!zArr[i]) {
                    String strE = ((n30) this.f5256a.get(i2)).e();
                    f92.b(strE);
                    arrayList.add(Integer.valueOf(Integer.parseInt(strE)));
                }
                i++;
                i2 = i3;
            }
            CpuLoadsView cpuLoadsView = (CpuLoadsView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_cpu_loads);
            this.b.clear();
            this.b.addAll(arrayList);
            cpuLoadsView.h();
        }
    }

    public static final class j implements s80 {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5257a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ ArrayList c;

        public j(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f5257a = arrayList;
            this.b = arrayList2;
            this.c = arrayList3;
        }

        @Override // a.s80
        public void a(List<n30> list, boolean[] zArr) {
            f92.d(list, "selected");
            f92.d(zArr, "status");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f5257a;
            f92.c(arrayList2, "clusters");
            int i = 0;
            int i2 = 0;
            for (Object obj : arrayList2) {
                int i3 = i2 + 1;
                Object obj2 = null;
                if (i2 < 0) {
                    y42.l();
                    throw null;
                }
                String[] strArr = (String[]) obj;
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    f92.c(strArr, "it");
                    if (u42.k(strArr, ((n30) next).e())) {
                        obj2 = next;
                        break;
                    }
                }
                if (obj2 == null) {
                    f92.c(strArr, "it");
                    for (String str : strArr) {
                        f92.c(str, "it");
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    }
                }
                i2 = i3;
            }
            int length = zArr.length;
            int i4 = 0;
            while (i < length) {
                int i5 = i4 + 1;
                if (!zArr[i]) {
                    String strE = ((n30) this.b.get(i4)).e();
                    f92.b(strE);
                    arrayList.add(Integer.valueOf(Integer.parseInt(strE)));
                }
                i++;
                i4 = i5;
            }
            CpuFrequencyView cpuFrequencyView = (CpuFrequencyView) ActivityFpsSession.this._$_findCachedViewById(t61.chart_cpu_frequencies);
            this.c.clear();
            this.c.addAll(arrayList);
            cpuFrequencyView.h();
            CpuFrequencyStat cpuFrequencyStat = (CpuFrequencyStat) ActivityFpsSession.this._$_findCachedViewById(t61.chart_cpu_frequencies_stat);
            this.c.clear();
            this.c.addAll(arrayList);
            cpuFrequencyStat.h();
        }
    }

    public static final class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) ActivityFpsSession.this._$_findCachedViewById(t61.session_threads);
            if (blurViewLinearLayout != null) {
                blurViewLinearLayout.setVisibility(0);
            }
        }
    }

    public static final class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f5258a;

        public l(ArrayList arrayList) {
            this.f5258a = arrayList;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n92 n92Var = new n92();
            String strH = Scene.f4798a.h("chart_optional", "info,ft,power,ddr,gpu,cpu_t");
            f92.b(strH);
            n92Var.f6891a = ec2.d0(strH, new String[]{","}, false, 0, 6, null);
            for (n30 n30Var : this.f5258a) {
                n30Var.h(i52.v((List) n92Var.f6891a, n30Var.e()));
            }
            new b90(ActivityFpsSession.this.getThemeMode().a(), this.f5258a, true, new ta1(this, n92Var), 0, 16, null).B1(ActivityFpsSession.this.getSupportFragmentManager(), "fps-chart");
        }
    }

    public static final class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8665a;

        public m(ArrayList arrayList) {
            this.f8665a = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String strH = Scene.f4798a.h("chart_optional", "info,ft,power,ddr,gpu,cpu_t");
            f92.b(strH);
            List listD0 = ec2.d0(strH, new String[]{","}, false, 0, 6, null);
            for (n30 n30Var : this.f8665a) {
                n30Var.h(i52.v(listD0, n30Var.e()));
            }
            qc2.d(xd2.a(qe2.c()), null, null, new ua1(this, null), 3, null);
        }
    }

    public static final class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BlurViewRelativeLayout blurViewRelativeLayout = (BlurViewRelativeLayout) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_mA);
            f92.c(blurViewRelativeLayout, "chart_power_mA");
            blurViewRelativeLayout.setVisibility(0);
            BlurViewRelativeLayout blurViewRelativeLayout2 = (BlurViewRelativeLayout) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_watt);
            f92.c(blurViewRelativeLayout2, "chart_power_watt");
            blurViewRelativeLayout2.setVisibility(8);
        }
    }

    public static final class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BlurViewRelativeLayout blurViewRelativeLayout = (BlurViewRelativeLayout) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_mA);
            f92.c(blurViewRelativeLayout, "chart_power_mA");
            blurViewRelativeLayout.setVisibility(0);
            BlurViewRelativeLayout blurViewRelativeLayout2 = (BlurViewRelativeLayout) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_watt);
            f92.c(blurViewRelativeLayout2, "chart_power_watt");
            blurViewRelativeLayout2.setVisibility(8);
        }
    }

    public static final class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f5259a;

        public p(Long l) {
            this.f5259a = l;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StringBuilder sb;
            ActivityFpsSession activityFpsSession;
            int i;
            py0 py0Var = ActivityFpsSession.this.f8652a;
            Long l = this.f5259a;
            f92.c(l, "sessionId");
            ArrayList<Float> arrayListS = py0Var.S(l.longValue());
            double dT = i52.t(arrayListS);
            Float fN = i52.N(arrayListS);
            float fFloatValue = fN != null ? fN.floatValue() : 0.0f;
            Float fP = i52.P(arrayListS);
            float fFloatValue2 = fP != null ? fP.floatValue() : 0.0f;
            StringBuilder sb2 = new StringBuilder();
            yb2.g(sb2, "AVG ", Integer.valueOf((int) dT), "%\n");
            yb2.g(sb2, "MAX ", Integer.valueOf((int) fFloatValue), "%\n");
            yb2.g(sb2, "MIN ", Integer.valueOf((int) fFloatValue2), "%");
            p80.a aVar = p80.f2403a;
            ActivityFpsSession activityFpsSession2 = ActivityFpsSession.this;
            w90 w90Var = new w90();
            String string = sb2.toString();
            f92.c(string, "text.toString()");
            p80.a.B(aVar, activityFpsSession2, "GPU Usage", w90Var.c(string), null, 8, null);
            StringBuilder sb3 = new StringBuilder();
            if (fFloatValue < 96.0f || u42.k(new String[]{"mt6895", "mt6983", "mt6985"}, jm0.f6525a.b())) {
                return;
            }
            if (fFloatValue >= 98.0f) {
                sb = new StringBuilder();
                activityFpsSession = ActivityFpsSession.this;
                i = u61.fps_warn_gpu_load;
            } else {
                sb = new StringBuilder();
                activityFpsSession = ActivityFpsSession.this;
                i = u61.fps_warn_gpu_load2;
            }
            sb.append(activityFpsSession.getString(i));
            sb.append(fFloatValue);
            sb.append('%');
            sb3.append(sb.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("    ≥96% ");
            ArrayList arrayList = new ArrayList();
            for (Object obj : arrayListS) {
                if (((Number) obj).floatValue() > ((float) 96)) {
                    arrayList.add(obj);
                }
            }
            sb4.append(arrayList.size());
            sb4.append(ActivityFpsSession.this.getString(u61.fps_warn_seconds));
            sb3.append(sb4.toString());
            ActivityFpsSession.this.q(sb3);
        }
    }

    public static final class q implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f5260a;

        public q(Long l) {
            this.f5260a = l;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            py0 py0Var = ActivityFpsSession.this.f8652a;
            Long l = this.f5260a;
            f92.c(l, "sessionId");
            ArrayList<Integer> arrayListR = py0Var.R(l.longValue());
            double dU = i52.u(arrayListR);
            Object objValueOf = (Integer) i52.L(arrayListR);
            if (objValueOf == null) {
                objValueOf = Float.valueOf(0.0f);
            }
            Integer num = (Integer) i52.O(arrayListR);
            int iIntValue = num != null ? num.intValue() : 0;
            StringBuilder sb = new StringBuilder();
            yb2.g(sb, "AVG ", Integer.valueOf((int) dU), "\n");
            yb2.g(sb, "MAX ", objValueOf, "\n");
            yb2.g(sb, "MIN ", Integer.valueOf(iIntValue));
            p80.a aVar = p80.f2403a;
            ActivityFpsSession activityFpsSession = ActivityFpsSession.this;
            w90 w90Var = new w90();
            String string = sb.toString();
            f92.c(string, "text.toString()");
            p80.a.B(aVar, activityFpsSession, "GPU Frequency", w90Var.c(string), null, 8, null);
        }
    }

    public static final class r implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f5261a;

        public r(Long l) {
            this.f5261a = l;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            py0 py0Var = ActivityFpsSession.this.f8652a;
            Long l = this.f5261a;
            f92.c(l, "sessionId");
            ArrayList<Integer> arrayListI = py0Var.I(l.longValue());
            double dU = i52.u(arrayListI);
            Integer num = (Integer) i52.L(arrayListI);
            int iIntValue = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) i52.O(arrayListI);
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            StringBuilder sb = new StringBuilder();
            yb2.g(sb, "AVG ", Integer.valueOf((int) dU), "\n");
            yb2.g(sb, "MAX ", Integer.valueOf(iIntValue), "\n");
            yb2.g(sb, "MIN ", Integer.valueOf(iIntValue2));
            p80.a aVar = p80.f2403a;
            ActivityFpsSession activityFpsSession = ActivityFpsSession.this;
            w90 w90Var = new w90();
            String string = sb.toString();
            f92.c(string, "text.toString()");
            p80.a.B(aVar, activityFpsSession, "DDR", w90Var.c(string), null, 8, null);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$15", f = "ActivityFpsSession.kt", l = {883, 893, 898}, m = "invokeSuspend")
    public static final class s extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8671a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f5263a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5264a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5265b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(Long l, b62 b62Var) {
            super(2, b62Var);
            this.f5263a = l;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            s sVar = ActivityFpsSession.this.new s(this.f5263a, b62Var);
            sVar.f8671a = (wd2) obj;
            return sVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((s) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.StringBuilder] */
        @Override // a.s62
        public final Object j(Object obj) {
            wd2 wd2Var;
            k92 k92Var;
            k92 k92Var2;
            k92 k92Var3;
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var2 = this.f8671a;
                k92 k92Var4 = new k92();
                py0 py0Var = ActivityFpsSession.this.f8652a;
                Long l = this.f5263a;
                f92.c(l, "sessionId");
                k92Var4.f6587a = py0Var.D(l.longValue());
                k92 k92Var5 = new k92();
                py0 py0Var2 = ActivityFpsSession.this.f8652a;
                Long l2 = this.f5263a;
                f92.c(l2, "sessionId");
                k92Var5.f6587a = py0Var2.E(l2.longValue());
                k92 k92Var6 = new k92();
                py0 py0Var3 = ActivityFpsSession.this.f8652a;
                Long l3 = this.f5263a;
                f92.c(l3, "sessionId");
                k92Var6.f6587a = py0Var3.B(l3.longValue());
                fg2 fg2VarC = qe2.c();
                za1 za1Var = new za1(this, k92Var4, k92Var5, k92Var6, null);
                this.f5264a = wd2Var2;
                this.f5265b = k92Var4;
                this.c = k92Var5;
                this.d = k92Var6;
                this.b = 1;
                if (oc2.g(fg2VarC, za1Var, this) == objC) {
                    return objC;
                }
                wd2Var = wd2Var2;
                k92Var = k92Var4;
                k92Var2 = k92Var5;
                k92Var3 = k92Var6;
            } else {
                if (i != 1) {
                    if (i == 2) {
                    } else if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                    return m42.f6769a;
                }
                k92Var3 = (k92) this.d;
                k92Var2 = (k92) this.c;
                k92Var = (k92) this.f5265b;
                wd2Var = (wd2) this.f5264a;
                h42.b(obj);
            }
            n92 n92Var = new n92();
            ?? sb = new StringBuilder();
            n92Var.f6891a = sb;
            float f = k92Var.f6587a;
            if (f > 93) {
                py0 py0Var4 = ActivityFpsSession.this.f8652a;
                Long l4 = this.f5263a;
                f92.c(l4, "sessionId");
                ArrayList<Double> arrayListC = py0Var4.C(l4.longValue());
                ((StringBuilder) n92Var.f6891a).append(ActivityFpsSession.this.getString(u61.fps_warn_soc) + k92Var.f6587a + "℃    ");
                StringBuilder sb2 = (StringBuilder) n92Var.f6891a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("    ≥90℃ ");
                ArrayList arrayList = new ArrayList();
                Iterator it = arrayListC.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    Iterator it2 = it;
                    if (t62.a(((Number) next).doubleValue() > ((double) 93)).booleanValue()) {
                        arrayList.add(next);
                    }
                    it = it2;
                }
                sb3.append(arrayList.size());
                sb3.append(ActivityFpsSession.this.getString(u61.fps_warn_seconds));
                sb2.append(sb3.toString());
                fg2 fg2VarC2 = qe2.c();
                ab1 ab1Var = new ab1(this, n92Var, null);
                this.f5264a = wd2Var;
                this.f5265b = k92Var;
                this.c = k92Var2;
                this.d = k92Var3;
                this.e = n92Var;
                this.f = arrayListC;
                this.b = 2;
                if (oc2.g(fg2VarC2, ab1Var, this) == objC) {
                    return objC;
                }
            } else if (f > 0 && f == k92Var2.f6587a) {
                ((StringBuilder) sb).append(ActivityFpsSession.this.getString(u61.fps_warn_soc_virtual) + ' ' + k92Var.f6587a + (char) 8451);
                fg2 fg2VarC3 = qe2.c();
                bb1 bb1Var = new bb1(this, n92Var, null);
                this.f5264a = wd2Var;
                this.f5265b = k92Var;
                this.c = k92Var2;
                this.d = k92Var3;
                this.e = n92Var;
                this.b = 3;
                if (oc2.g(fg2VarC3, bb1Var, this) == objC) {
                    return objC;
                }
            }
            return m42.f6769a;
        }
    }

    public static final class t implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FpsWatchSession f8672a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f5267a;

        public t(FpsWatchSession fpsWatchSession, String str) {
            this.f8672a = fpsWatchSession;
            this.f5267a = str;
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
            e90 e90Var = l90.f6685a;
            ActivityFpsSession activityFpsSession = ActivityFpsSession.this;
            String string = activityFpsSession.getString(u61.fps_export_type_img);
            f92.c(string, "getString(R.string.fps_export_type_img)");
            String string2 = ActivityFpsSession.this.getString(u61.fps_export_type_csv);
            f92.c(string2, "getString(R.string.fps_export_type_csv)");
            e90Var.b(activityFpsSession, new String[]{string, string2}, 0, new ya1(this)).o();
        }
    }

    public static final class u implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FpsWatchSession f8673a;

        public u(FpsWatchSession fpsWatchSession) {
            this.f8673a = fpsWatchSession;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String strZ;
            py0 py0Var = ActivityFpsSession.this.f8652a;
            Long l = this.f8673a.sessionId;
            f92.c(l, "item.sessionId");
            FpsWatchSession fpsWatchSessionR = py0Var.r(l.longValue());
            String str = fpsWatchSessionR != null ? fpsWatchSessionR.cloudId : null;
            if (str == null || str.length() == 0) {
                py0 py0Var2 = ActivityFpsSession.this.f8652a;
                Long l2 = this.f8673a.sessionId;
                f92.c(l2, "item.sessionId");
                d42<String, String> d42VarB = new co0().B(py0Var2.g(l2.longValue()));
                if (d42VarB != null) {
                    py0 py0Var3 = ActivityFpsSession.this.f8652a;
                    Long l3 = this.f8673a.sessionId;
                    f92.c(l3, "item.sessionId");
                    py0Var3.c0(l3.longValue(), d42VarB.c());
                    strZ = d42VarB.d();
                } else {
                    strZ = null;
                }
            } else {
                strZ = new co0().z(str);
            }
            if (strZ == null) {
                Scene.c cVar = Scene.f4798a;
                String string = ActivityFpsSession.this.getString(u61.fps_share_fail);
                f92.c(string, "getString(R.string.fps_share_fail)");
                Scene.c.p(cVar, string, 0, 2, null);
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            q92 q92Var = q92.f7191a;
            String string2 = ActivityFpsSession.this.getString(u61.share_pvp_link);
            f92.c(string2, "getString(R.string.share_pvp_link)");
            String str2 = String.format(string2, Arrays.copyOf(new Object[]{strZ}, 1));
            f92.c(str2, "java.lang.String.format(format, *args)");
            intent.putExtra("android.intent.extra.TEXT", str2);
            intent.setType("text/plain");
            ActivityFpsSession.this.startActivity(intent);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$3", f = "ActivityFpsSession.kt", l = {686}, m = "invokeSuspend")
    public static final class v extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8674a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f5270a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5271a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5272b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(Long l, b62 b62Var) {
            super(2, b62Var);
            this.f5270a = l;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            v vVar = ActivityFpsSession.this.new v(this.f5270a, b62Var);
            vVar.f8674a = (wd2) obj;
            return vVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((v) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.omarea.model.FpsWatchSession] */
        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8674a;
                n92 n92Var = new n92();
                py0 py0Var = ActivityFpsSession.this.f8652a;
                Long l = this.f5270a;
                f92.c(l, "sessionId");
                ?? R = py0Var.r(l.longValue());
                if (R == 0) {
                    return m42.f6769a;
                }
                n92Var.f6891a = R;
                j92 j92Var = new j92();
                py0 py0Var2 = ActivityFpsSession.this.f8652a;
                Long l2 = this.f5270a;
                f92.c(l2, "sessionId");
                j92Var.f6490a = py0Var2.N(l2.longValue());
                py0 py0Var3 = ActivityFpsSession.this.f8652a;
                Long l3 = this.f5270a;
                f92.c(l3, "sessionId");
                ArrayList<Float> arrayListM = py0Var3.M(l3.longValue());
                j92 j92Var2 = new j92();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : arrayListM) {
                    if (t62.a(((Number) obj2).floatValue() >= ((float) 45)).booleanValue()) {
                        arrayList.add(obj2);
                    }
                }
                j92Var2.f6490a = (((double) arrayList.size()) * 100.0d) / ((double) arrayListM.size());
                n92 n92Var2 = new n92();
                py0 py0Var4 = ActivityFpsSession.this.f8652a;
                Long l4 = this.f5270a;
                f92.c(l4, "sessionId");
                n92Var2.f6891a = py0Var4.a0(l4.longValue());
                k92 k92Var = new k92();
                Float fN = i52.N((ArrayList) n92Var2.f6891a);
                k92Var.f6587a = fN != null ? fN.floatValue() : -1.0f;
                l92 l92Var = new l92();
                py0 py0Var5 = ActivityFpsSession.this.f8652a;
                Long l5 = this.f5270a;
                f92.c(l5, "sessionId");
                l92Var.f6687a = py0Var5.F(l5.longValue());
                k92 k92Var2 = new k92();
                py0 py0Var6 = ActivityFpsSession.this.f8652a;
                Long l6 = this.f5270a;
                f92.c(l6, "sessionId");
                k92Var2.f6587a = py0Var6.O(l6.longValue());
                k92 k92Var3 = new k92();
                py0 py0Var7 = ActivityFpsSession.this.f8652a;
                Long l7 = this.f5270a;
                f92.c(l7, "sessionId");
                k92Var3.f6587a = py0Var7.P(l7.longValue());
                k92 k92Var4 = new k92();
                py0 py0Var8 = ActivityFpsSession.this.f8652a;
                Long l8 = this.f5270a;
                f92.c(l8, "sessionId");
                k92Var4.f6587a = py0Var8.L(l8.longValue());
                j92 j92Var3 = new j92();
                py0 py0Var9 = ActivityFpsSession.this.f8652a;
                Long l9 = this.f5270a;
                f92.c(l9, "sessionId");
                j92Var3.f6490a = py0Var9.Q(l9.longValue());
                fg2 fg2VarC = qe2.c();
                cb1 cb1Var = new cb1(this, k92Var, n92Var2, n92Var, j92Var2, j92Var, k92Var2, k92Var3, k92Var4, j92Var3, l92Var, null);
                this.f5271a = wd2Var;
                this.f5272b = n92Var;
                this.c = j92Var;
                this.d = arrayListM;
                this.e = j92Var2;
                this.f = n92Var2;
                this.g = k92Var;
                this.h = l92Var;
                this.i = k92Var2;
                this.j = k92Var3;
                this.k = k92Var4;
                this.l = j92Var3;
                this.b = 1;
                if (oc2.g(fg2VarC, cb1Var, this) == objC) {
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

    @x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$4", f = "ActivityFpsSession.kt", l = {724}, m = "invokeSuspend")
    public static final class w extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8675a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Long f5274a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5275a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5276b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(Long l, b62 b62Var) {
            super(2, b62Var);
            this.f5274a = l;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            w wVar = ActivityFpsSession.this.new w(this.f5274a, b62Var);
            wVar.f8675a = (wd2) obj;
            return wVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((w) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8675a;
                l92 l92Var = new l92();
                py0 py0Var = ActivityFpsSession.this.f8652a;
                Long l = this.f5274a;
                f92.c(l, "sessionId");
                l92Var.f6687a = py0Var.G(l.longValue());
                l92 l92Var2 = new l92();
                py0 py0Var2 = ActivityFpsSession.this.f8652a;
                Long l2 = this.f5274a;
                f92.c(l2, "sessionId");
                l92Var2.f6687a = py0Var2.H(l2.longValue());
                j92 j92Var = new j92();
                py0 py0Var3 = ActivityFpsSession.this.f8652a;
                Long l3 = this.f5274a;
                f92.c(l3, "sessionId");
                j92Var.f6490a = py0Var3.X(l3.longValue());
                j92 j92Var2 = new j92();
                py0 py0Var4 = ActivityFpsSession.this.f8652a;
                Long l4 = this.f5274a;
                f92.c(l4, "sessionId");
                j92Var2.f6490a = py0Var4.Y(l4.longValue());
                j92 j92Var3 = new j92();
                py0 py0Var5 = ActivityFpsSession.this.f8652a;
                Long l5 = this.f5274a;
                f92.c(l5, "sessionId");
                j92Var3.f6490a = py0Var5.V(l5.longValue());
                l92 l92Var3 = new l92();
                py0 py0Var6 = ActivityFpsSession.this.f8652a;
                Long l6 = this.f5274a;
                f92.c(l6, "sessionId");
                l92Var3.f6687a = py0Var6.T(l6.longValue());
                l92 l92Var4 = new l92();
                py0 py0Var7 = ActivityFpsSession.this.f8652a;
                Long l7 = this.f5274a;
                f92.c(l7, "sessionId");
                l92Var4.f6687a = py0Var7.u(l7.longValue());
                l92 l92Var5 = new l92();
                py0 py0Var8 = ActivityFpsSession.this.f8652a;
                Long l8 = this.f5274a;
                f92.c(l8, "sessionId");
                l92Var5.f6687a = py0Var8.K(l8.longValue());
                fg2 fg2VarC = qe2.c();
                db1 db1Var = new db1(this, l92Var, l92Var2, j92Var, j92Var2, j92Var3, l92Var3, l92Var4, l92Var5, null);
                this.f5275a = wd2Var;
                this.f5276b = l92Var;
                this.c = l92Var2;
                this.d = j92Var;
                this.e = j92Var2;
                this.f = j92Var3;
                this.g = l92Var3;
                this.h = l92Var4;
                this.i = l92Var5;
                this.b = 1;
                if (oc2.g(fg2VarC, db1Var, this) == objC) {
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

    @x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$5", f = "ActivityFpsSession.kt", l = {742, 743}, m = "invokeSuspend")
    public static final class x extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8676a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ FpsWatchSession f5277a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5279a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5280b;
        public Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(FpsWatchSession fpsWatchSession, b62 b62Var) {
            super(2, b62Var);
            this.f5277a = fpsWatchSession;
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            x xVar = ActivityFpsSession.this.new x(this.f5277a, b62Var);
            xVar.f8676a = (wd2) obj;
            return xVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((x) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Type inference failed for: r12v5, types: [T, android.graphics.drawable.Drawable] */
        @Override // a.s62
        public final Object j(Object obj) {
            wd2 wd2Var;
            n92 n92Var;
            n92 n92Var2;
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2Var = this.f8676a;
                n92Var = new n92();
                ih0 ih0Var = new ih0(ActivityFpsSession.this.getContext(), 0, 0, 6, null);
                String str = this.f5277a.packageName;
                f92.c(str, "item.packageName");
                fe2<Drawable> fe2VarL = ih0Var.l(str);
                this.f5279a = wd2Var;
                this.f5280b = n92Var;
                this.c = n92Var;
                this.b = 1;
                obj = fe2VarL.s(this);
                if (obj == objC) {
                    return objC;
                }
                n92Var2 = n92Var;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                    return m42.f6769a;
                }
                n92Var = (n92) this.c;
                n92Var2 = (n92) this.f5280b;
                wd2Var = (wd2) this.f5279a;
                h42.b(obj);
            }
            n92Var.f6891a = (Drawable) obj;
            fg2 fg2VarC = qe2.c();
            eb1 eb1Var = new eb1(this, n92Var2, null);
            this.f5279a = wd2Var;
            this.f5280b = n92Var2;
            this.b = 2;
            if (oc2.g(fg2VarC, eb1Var, this) == objC) {
                return objC;
            }
            return m42.f6769a;
        }
    }

    public static final class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BlurViewRelativeLayout blurViewRelativeLayout = (BlurViewRelativeLayout) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_mA);
            f92.c(blurViewRelativeLayout, "chart_power_mA");
            blurViewRelativeLayout.setVisibility(8);
            BlurViewRelativeLayout blurViewRelativeLayout2 = (BlurViewRelativeLayout) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_watt);
            f92.c(blurViewRelativeLayout2, "chart_power_watt");
            blurViewRelativeLayout2.setVisibility(0);
        }
    }

    public static final class z implements View.OnClickListener {
        public z() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BlurViewRelativeLayout blurViewRelativeLayout = (BlurViewRelativeLayout) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_mA);
            f92.c(blurViewRelativeLayout, "chart_power_mA");
            blurViewRelativeLayout.setVisibility(8);
            BlurViewRelativeLayout blurViewRelativeLayout2 = (BlurViewRelativeLayout) ActivityFpsSession.this._$_findCachedViewById(t61.chart_power_watt);
            f92.c(blurViewRelativeLayout2, "chart_power_watt");
            blurViewRelativeLayout2.setVisibility(0);
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.f5251a == null) {
            this.f5251a = new HashMap();
        }
        View view = (View) this.f5251a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        this.f5251a.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.g91, a.v0, a.cl, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        f92.d(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Window window = getWindow();
        f92.c(window, "this.window");
        ki kiVarI = eh.I(window.getDecorView());
        if (configuration.orientation == 2) {
            if (kiVarI != null) {
                kiVarI.a(di.d());
            }
            if (kiVarI != null) {
                kiVarI.a(di.a());
                return;
            }
            return;
        }
        if (kiVarI != null) {
            kiVarI.b(di.d());
        }
        if (kiVarI != null) {
            kiVarI.b(di.a());
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(2131558449);
        setBackArrow();
        setTitle(u61.menu_fps_chart);
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        long j2 = extras.getLong("sessionId");
        String string = extras.getString("appName");
        long j3 = extras.getLong("beginTime");
        String string2 = extras.containsKey("packageName") ? extras.getString("packageName") : null;
        if (!(string == null || string.length() == 0)) {
            setTitle(string);
        }
        FpsWatchSession fpsWatchSession = new FpsWatchSession();
        fpsWatchSession.sessionId = Long.valueOf(j2);
        fpsWatchSession.appName = string;
        fpsWatchSession.packageName = string2;
        fpsWatchSession.beginTime = Long.valueOf(j3);
        m42 m42Var = m42.f6769a;
        x(fpsWatchSession);
        qc2.d(xd2.a(qe2.c()), null, null, new ra1(j2, null, this), 3, null);
        ((BlurViewLinearLayout) _$_findCachedViewById(t61.session_threads)).setOnClickListener(new sa1(j2, string, this));
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().w();
    }

    public final void q(CharSequence charSequence) {
        TextView textView = (TextView) _$_findCachedViewById(t61.fps_warning);
        if (textView != null) {
            textView.post(new pa1(textView, charSequence));
        }
    }

    public final void r(long j2) {
        StringBuilder sb;
        Object objN;
        StringBuilder sb2;
        Object objN2;
        ((ImageView) _$_findCachedViewById(t61.chart_right_icon)).setOnClickListener(new h());
        ((ImageView) _$_findCachedViewById(t61.cpu_core_options)).setOnClickListener(new b());
        ((ImageView) _$_findCachedViewById(t61.cpu_load_stat)).setOnClickListener(new c(j2));
        ((ImageView) _$_findCachedViewById(t61.cpu_core_options4)).setOnClickListener(new d());
        ((ImageView) _$_findCachedViewById(t61.cpu_stat_switch)).setOnClickListener(new e());
        ((ImageView) _$_findCachedViewById(t61.cpu_freq_stat)).setOnClickListener(new f(j2));
        TextView textView = (TextView) _$_findCachedViewById(t61.chart_cpu_loads_legend);
        SpannableString spannableString = new SpannableString("■ Total  ");
        spannableString.setSpan(new ForegroundColorSpan(((CpuLoadsView) _$_findCachedViewById(t61.chart_cpu_loads)).getMainColor()), 0, spannableString.length(), 33);
        m42 m42Var = m42.f6769a;
        textView.append(spannableString);
        CpuLoadsView cpuLoadsView = (CpuLoadsView) _$_findCachedViewById(t61.chart_cpu_loads);
        ArrayList<Integer> colors = cpuLoadsView.getColors();
        ArrayList<String[]> clusters = cpuLoadsView.getClusters();
        f92.c(clusters, "clusters");
        Iterator<T> it = clusters.iterator();
        int i2 = 0;
        while (true) {
            char c2 = '~';
            int i3 = 1;
            if (!it.hasNext()) {
                TextView textView2 = (TextView) _$_findCachedViewById(t61.chart_cpu_cycles_legend);
                SpannableString spannableString2 = new SpannableString("  ■ TEMP(℃)");
                spannableString2.setSpan(new ForegroundColorSpan(((CpuLoadsView) _$_findCachedViewById(t61.chart_cpu_loads)).getMainColor()), 0, spannableString2.length(), 33);
                m42 m42Var2 = m42.f6769a;
                textView2.append(spannableString2);
                ((ImageView) _$_findCachedViewById(t61.cpu_cycles_stat)).setOnClickListener(new g(j2));
                CpuFrequencyView cpuFrequencyView = (CpuFrequencyView) _$_findCachedViewById(t61.chart_cpu_frequencies);
                ArrayList<Integer> colors2 = cpuFrequencyView.getColors();
                ArrayList<String[]> clusters2 = cpuFrequencyView.getClusters();
                f92.c(clusters2, "clusters");
                int i4 = 0;
                for (Object obj : clusters2) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        y42.l();
                        throw null;
                    }
                    String[] strArr = (String[]) obj;
                    if (strArr.length > i3) {
                        sb = new StringBuilder();
                        sb.append("■ CPU ");
                        f92.c(strArr, "it");
                        sb.append((String) u42.n(strArr));
                        sb.append(c2);
                        objN = u42.z(strArr);
                    } else {
                        sb = new StringBuilder();
                        sb.append("■ CPU ");
                        f92.c(strArr, "it");
                        objN = u42.n(strArr);
                    }
                    sb.append((String) objN);
                    sb.append("  ");
                    String string = sb.toString();
                    TextView textView3 = (TextView) _$_findCachedViewById(t61.chart_cpu_frequencies_legend);
                    SpannableString spannableString3 = new SpannableString(string);
                    Integer num = colors2.get(i4);
                    f92.c(num, "colors.get(cIndex)");
                    spannableString3.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableString3.length(), 33);
                    m42 m42Var3 = m42.f6769a;
                    textView3.append(spannableString3);
                    i4 = i5;
                    i3 = 1;
                    c2 = '~';
                }
                EditText editText = (EditText) _$_findCachedViewById(t61.fps_remark_hint);
                f92.c(editText, "fps_remark_hint");
                kk0.c(editText, new a(j2));
                return;
            }
            Object next = it.next();
            int i6 = i2 + 1;
            if (i2 < 0) {
                y42.l();
                throw null;
            }
            String[] strArr2 = (String[]) next;
            if (strArr2.length > 1) {
                sb2 = new StringBuilder();
                sb2.append("■ CPU ");
                f92.c(strArr2, "it");
                sb2.append((String) u42.n(strArr2));
                sb2.append('~');
                objN2 = u42.z(strArr2);
            } else {
                sb2 = new StringBuilder();
                sb2.append("■ CPU ");
                f92.c(strArr2, "it");
                objN2 = u42.n(strArr2);
            }
            sb2.append((String) objN2);
            sb2.append("  ");
            String string2 = sb2.toString();
            TextView textView4 = (TextView) _$_findCachedViewById(t61.chart_cpu_loads_legend);
            SpannableString spannableString4 = new SpannableString(string2);
            Integer num2 = colors.get(i2);
            f92.c(num2, "colors.get(cIndex)");
            spannableString4.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString4.length(), 33);
            m42 m42Var4 = m42.f6769a;
            textView4.append(spannableString4);
            TextView textView5 = (TextView) _$_findCachedViewById(t61.chart_cpu_cycles_legend);
            SpannableString spannableString5 = new SpannableString(string2);
            Integer num3 = colors.get(i2);
            f92.c(num3, "colors.get(cIndex)");
            spannableString5.setSpan(new ForegroundColorSpan(num3.intValue()), 0, spannableString5.length(), 33);
            m42 m42Var5 = m42.f6769a;
            textView5.append(spannableString5);
            i2 = i6;
        }
    }

    public final void s() {
        ArrayList<String[]> clusters = ((CpuLoadsView) _$_findCachedViewById(t61.chart_cpu_loads)).getClusters();
        ArrayList<Integer> excludedCores = ((CpuLoadsView) _$_findCachedViewById(t61.chart_cpu_loads)).getExcludedCores();
        ArrayList arrayList = new ArrayList();
        n30 n30Var = new n30();
        n30Var.i("MultiCore Total");
        n30Var.j("-1");
        n30Var.h(!excludedCores.contains(-1));
        m42 m42Var = m42.f6769a;
        arrayList.add(n30Var);
        f92.c(clusters, "clusters");
        int i2 = 0;
        for (Object obj : clusters) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                y42.l();
                throw null;
            }
            String[] strArr = (String[]) obj;
            f92.c(strArr, "it");
            for (String str : strArr) {
                n30 n30Var2 = new n30();
                n30Var2.i("CPU Core " + str);
                n30Var2.j(str);
                f92.c(str, "it");
                n30Var2.h(excludedCores.contains(Integer.valueOf(Integer.parseInt(str))) ^ true);
                m42 m42Var2 = m42.f6769a;
                arrayList.add(n30Var2);
            }
            i2 = i3;
        }
        new b90(getThemeMode().a(), arrayList, true, new i(arrayList, excludedCores), 999).B1(getSupportFragmentManager(), "chart-cpu-options");
    }

    public final void t() {
        StringBuilder sb;
        Object objN;
        ArrayList<String[]> clusters = ((CpuFrequencyView) _$_findCachedViewById(t61.chart_cpu_frequencies)).getClusters();
        ArrayList<Integer> excludedCores = ((CpuFrequencyView) _$_findCachedViewById(t61.chart_cpu_frequencies)).getExcludedCores();
        ArrayList arrayList = new ArrayList();
        f92.c(clusters, "clusters");
        int i2 = 0;
        for (Object obj : clusters) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                y42.l();
                throw null;
            }
            String[] strArr = (String[]) obj;
            n30 n30Var = new n30();
            if (strArr.length > 1) {
                sb = new StringBuilder();
                sb.append("CPU Core ");
                f92.c(strArr, "it");
                sb.append((String) u42.n(strArr));
                sb.append('~');
                objN = u42.z(strArr);
            } else {
                sb = new StringBuilder();
                sb.append("CPU Core ");
                f92.c(strArr, "it");
                objN = u42.n(strArr);
            }
            sb.append((String) objN);
            n30Var.i(sb.toString());
            n30Var.j((String) u42.n(strArr));
            f92.b(n30Var.e());
            n30Var.h(!excludedCores.contains(Integer.valueOf(Integer.parseInt(r5))));
            m42 m42Var = m42.f6769a;
            arrayList.add(n30Var);
            i2 = i3;
        }
        new b90(getThemeMode().a(), arrayList, true, new j(clusters, arrayList, excludedCores), 999).B1(getSupportFragmentManager(), "chart-cpu-options");
    }

    public final void u(FpsWatchSession fpsWatchSession, String str) {
        Object objA;
        Scene.c cVar;
        String string;
        String str2;
        c60 c60Var;
        File file;
        Charset charset;
        if (yb.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            Scene.c cVar2 = Scene.f4798a;
            String string2 = getString(u61.kr_write_external_storage);
            f92.c(string2, "getString(R.string.kr_write_external_storage)");
            Scene.c.p(cVar2, string2, 0, 2, null);
            return;
        }
        py0 py0Var = this.f8652a;
        Long l2 = fpsWatchSession.sessionId;
        f92.c(l2, "item.sessionId");
        String strF = py0Var.f(l2.longValue());
        try {
            e42 e42Var = g42.f6169a;
            String str3 = c60.f5764a.e() + "/" + str;
            c60Var = c60.f5764a;
            file = new File(str3);
            charset = bb2.f5692a;
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th);
            g42.a(objA);
        }
        if (strF == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strF.getBytes(charset);
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
            str2 = "getString(R.string.fps_export_success)";
        } else {
            cVar = Scene.f4798a;
            string = getString(u61.fps_export_fail);
            str2 = "getString(R.string.fps_export_fail)";
        }
        f92.c(string, str2);
        Scene.c.p(cVar, string, 0, 2, null);
    }

    public final void v(String str) {
        ph0 ph0Var = new ph0(this, getThemeMode());
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.session_detail);
        f92.c(linearLayout, "session_detail");
        ph0Var.b(linearLayout, str, new k());
    }

    public final Runnable w() {
        n30 n30Var = new n30("Info", "info");
        n30Var.g((BlurViewLinearLayout) _$_findCachedViewById(t61.chart_info));
        m42 m42Var = m42.f6769a;
        n30 n30Var2 = new n30("Jank", "jank");
        n30Var2.g((BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_jank));
        m42 m42Var2 = m42.f6769a;
        n30 n30Var3 = new n30("Frame Time", "ft");
        n30Var3.g((BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_ftime));
        m42 m42Var3 = m42.f6769a;
        n30 n30Var4 = new n30("Power", "power");
        n30Var4.g((FrameLayout) _$_findCachedViewById(t61.chart_power));
        m42 m42Var4 = m42.f6769a;
        ArrayList arrayListC = y42.c(n30Var, n30Var2, n30Var3, n30Var4);
        if (f92.a(e50.f677a.y0(), "root")) {
            n30 n30Var5 = new n30("DDR", "ddr");
            n30Var5.g((BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_ddr));
            m42 m42Var5 = m42.f6769a;
            arrayListC.add(n30Var5);
            n30 n30Var6 = new n30("GPU", "gpu");
            n30Var6.g((BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_gpu));
            m42 m42Var6 = m42.f6769a;
            arrayListC.add(n30Var6);
            n30 n30Var7 = new n30("CPU temperature", "cpu_t");
            n30Var7.g((BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_cpu_t));
            m42 m42Var7 = m42.f6769a;
            arrayListC.add(n30Var7);
        }
        ((ImageView) _$_findCachedViewById(t61.module_filter)).setOnClickListener(new l(arrayListC));
        return new m(arrayListC);
    }

    public final void x(FpsWatchSession fpsWatchSession) {
        String upperCase;
        TextView textView;
        String strF;
        String strK;
        StringBuilder sb;
        String str;
        String str2;
        f92.d(fpsWatchSession, "item");
        vj0 vj0Var = new vj0();
        Long l2 = fpsWatchSession.beginTime;
        f92.c(l2, "item.beginTime");
        String strB = vj0Var.b(l2.longValue());
        ((ImageView) _$_findCachedViewById(t61.module_export)).setOnClickListener(new t(fpsWatchSession, strB));
        ((ImageView) _$_findCachedViewById(t61.module_share)).setOnClickListener(new u(fpsWatchSession));
        Runnable runnableW = w();
        Long l3 = fpsWatchSession.sessionId;
        qc2.d(xd2.a(qe2.b()), null, null, new v(l3, null), 3, null);
        qc2.d(xd2.a(qe2.b()), null, null, new w(l3, null), 3, null);
        String str3 = fpsWatchSession.packageName;
        if (!(str3 == null || str3.length() == 0)) {
            qc2.d(xd2.a(qe2.a()), null, null, new x(fpsWatchSession, null), 3, null);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(t61.chart_session_time);
        f92.c(textView2, "chart_session_time");
        textView2.setText(strB);
        TextView textView3 = (TextView) _$_findCachedViewById(t61.chart_session_name);
        f92.c(textView3, "chart_session_name");
        textView3.setText(getTitle());
        py0 py0Var = this.f8652a;
        f92.c(l3, "sessionId");
        FpsWatchSession fpsWatchSessionR = py0Var.r(l3.longValue());
        if (fpsWatchSessionR != null && (str2 = fpsWatchSessionR.sessionDesc) != null) {
            ((EditText) _$_findCachedViewById(t61.fps_remark_hint)).setText(str2);
        }
        ((FpsDataView) _$_findCachedViewById(t61.chart_session)).setSessionId(l3.longValue());
        ey0 ey0VarL = this.f8652a.l(l3.longValue());
        TextView textView4 = (TextView) _$_findCachedViewById(t61.chart_platform);
        f92.c(textView4, "chart_platform");
        String str4 = "###";
        if (ey0VarL.g().length() == 0) {
            upperCase = "###";
        } else {
            String strG = ey0VarL.g();
            Locale locale = Locale.ENGLISH;
            f92.c(locale, "Locale.ENGLISH");
            if (strG == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            upperCase = strG.toUpperCase(locale);
            f92.c(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        }
        textView4.setText(upperCase);
        String strD = ey0VarL.d();
        if (strD == null || strD.length() == 0) {
            textView = (TextView) _$_findCachedViewById(t61.chart_phone);
            f92.c(textView, "chart_phone");
            strF = ey0VarL.f();
            if (strF.length() == 0) {
                strF = "###";
            }
        } else {
            textView = (TextView) _$_findCachedViewById(t61.chart_phone);
            f92.c(textView, "chart_phone");
            strF = ey0VarL.d();
        }
        textView.setText(strF);
        TextView textView5 = (TextView) _$_findCachedViewById(t61.chart_os);
        f92.c(textView5, "chart_os");
        textView5.setText(tj0.f7508a.c(ey0VarL.h()));
        TextView textView6 = (TextView) _$_findCachedViewById(t61.chart_mode);
        f92.c(textView6, "chart_mode");
        if (!(ey0VarL.e().length() == 0) && !bc2.o(ey0VarL.e(), "#", false, 2, null)) {
            if (ec2.C(ey0VarL.e(), "#", false, 2, null)) {
                int iN = ec2.N(ey0VarL.e(), "#", 0, false, 6, null);
                String strE = ey0VarL.e();
                if (strE == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = strE.substring(0, iN);
                f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                su0 su0Var = wu0.f3480a;
                String strE2 = ey0VarL.e();
                int i2 = iN + 1;
                if (strE2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring2 = strE2.substring(i2);
                f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                strK = su0Var.k(strSubstring2);
                int iHashCode = strSubstring.hashCode();
                if (iHashCode != -273856726) {
                    if (iHashCode != 83970) {
                        if (iHashCode == 2066636008 && strSubstring.equals("FAS_RS")) {
                            sb = new StringBuilder();
                            str = "🐷";
                            sb.append(str);
                            sb.append(strK);
                            strK = sb.toString();
                        }
                    } else if (strSubstring.equals("UGT")) {
                        sb = new StringBuilder();
                        str = "❤️";
                        sb.append(str);
                        sb.append(strK);
                        strK = sb.toString();
                    }
                } else if (strSubstring.equals("SOURCE_SCENE_ONLINE")) {
                    sb = new StringBuilder();
                    sb.append('*');
                    sb.append(strK);
                    strK = sb.toString();
                }
            } else {
                strK = wu0.f3480a.k(ey0VarL.e());
            }
            str4 = strK;
        }
        textView6.setText(str4);
        ((BatteryIOView) _$_findCachedViewById(t61.chart_battery_io)).setSessionId(l3.longValue());
        ((PowerView) _$_findCachedViewById(t61.chart_power_w)).setSessionId(l3.longValue());
        ((ImageView) _$_findCachedViewById(t61.chart_toggle_w)).setOnClickListener(new y());
        ((TextView) _$_findCachedViewById(t61.chart_toggle_w_text)).setOnClickListener(new z());
        ((ImageView) _$_findCachedViewById(t61.chart_toggle_ma)).setOnClickListener(new n());
        ((TextView) _$_findCachedViewById(t61.chart_toggle_ma_text)).setOnClickListener(new o());
        ((CpuLoadsView) _$_findCachedViewById(t61.chart_cpu_loads)).setSessionId(l3.longValue());
        ((CpuFrequencyView) _$_findCachedViewById(t61.chart_cpu_frequencies)).setSessionId(l3.longValue());
        ((CpuFrequencyStat) _$_findCachedViewById(t61.chart_cpu_frequencies_stat)).setSessionId(l3.longValue());
        ((FpsJankView) _$_findCachedViewById(t61.chart_jank_view)).setSessionId(l3.longValue());
        ((FrameTimeView) _$_findCachedViewById(t61.chart_ftime_view)).setSessionId(l3.longValue());
        if (f92.a(e50.f677a.y0(), "root")) {
            ((GpuLoadView) _$_findCachedViewById(t61.chart_gpu_frequency)).setSessionId(l3.longValue());
            ((ImageView) _$_findCachedViewById(t61.gpu_usage_stat)).setOnClickListener(new p(l3));
            ((ImageView) _$_findCachedViewById(t61.gpu_freq_stat)).setOnClickListener(new q(l3));
            if (new ml0().a() > 0) {
                ((DDRView) _$_findCachedViewById(t61.chart_ddr_frequency)).setSessionId(l3.longValue());
                ((ImageView) _$_findCachedViewById(t61.ddr_freq_stat)).setOnClickListener(new r(l3));
            } else {
                BlurViewRelativeLayout blurViewRelativeLayout = (BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_ddr);
                f92.c(blurViewRelativeLayout, "chart_ddr");
                blurViewRelativeLayout.setVisibility(8);
            }
            ((CpuTemperatureView) _$_findCachedViewById(t61.chart_cpu_temperature)).setSessionId(l3.longValue());
            qc2.d(xd2.a(qe2.b()), null, null, new s(l3, null), 3, null);
            ((CpuCyclesView) _$_findCachedViewById(t61.chart_cpu_cycles)).setSessionId(l3.longValue());
        } else {
            BlurViewRelativeLayout blurViewRelativeLayout2 = (BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_gpu);
            f92.c(blurViewRelativeLayout2, "chart_gpu");
            blurViewRelativeLayout2.setVisibility(8);
            BlurViewRelativeLayout blurViewRelativeLayout3 = (BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_ddr);
            f92.c(blurViewRelativeLayout3, "chart_ddr");
            blurViewRelativeLayout3.setVisibility(8);
            BlurViewRelativeLayout blurViewRelativeLayout4 = (BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_cpu_t);
            f92.c(blurViewRelativeLayout4, "chart_cpu_t");
            blurViewRelativeLayout4.setVisibility(8);
            BlurViewRelativeLayout blurViewRelativeLayout5 = (BlurViewRelativeLayout) _$_findCachedViewById(t61.chart_cycles);
            f92.c(blurViewRelativeLayout5, "chart_cycles");
            blurViewRelativeLayout5.setVisibility(8);
        }
        runnableW.run();
    }
}
