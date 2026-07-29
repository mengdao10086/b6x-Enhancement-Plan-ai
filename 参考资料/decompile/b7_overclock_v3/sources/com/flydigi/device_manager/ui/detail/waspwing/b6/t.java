package com.flydigi.device_manager.ui.detail.waspwing.b6;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blankj.utilcode.util.ThreadUtils;
import com.flydigi.device_manager.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.tabs.TabLayout;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nWindTemperatureB6Item.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindTemperatureB6Item.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b6/WindTemperatureB6Item\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,201:1\n13586#2,2:202\n*S KotlinDebug\n*F\n+ 1 WindTemperatureB6Item.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b6/WindTemperatureB6Item\n*L\n106#1:202,2\n*E\n"})
public final class t extends q5.b {

    @yt.k
    public static final a G7 = new a(null);
    public static final int H7 = 180;
    public static final int I7 = 540;
    public static final int J7 = 1080;
    public int C2;
    public LinearLayout E7;
    public ImageView F7;
    public LineChart K2;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static final class b implements TabLayout.f {
        public b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@yt.l TabLayout.i iVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(@yt.k TabLayout.i tab) {
            f0.p(tab, "tab");
            t tVar = t.this;
            int iK = tab.k();
            tVar.C2 = iK != 0 ? iK != 1 ? iK != 2 ? t.this.C2 : t.J7 : 540 : 180;
            t9.j.f50990a.I();
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(@yt.l TabLayout.i iVar) {
        }
    }

    public static final class c extends ThreadUtils.d<Boolean> {
        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public /* bridge */ /* synthetic */ void l(Object obj) {
            r(((Boolean) obj).booleanValue());
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @yt.k
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean e() {
            t9.j.f50990a.I();
            return Boolean.TRUE;
        }

        public void r(boolean z10) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public t(@yt.k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public t(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ t(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void W(t this$0, View view) {
        f0.p(this$0, "this$0");
        LinearLayout linearLayout = this$0.E7;
        ImageView imageView = null;
        if (linearLayout == null) {
            f0.S("areaTemperatureHistories");
            linearLayout = null;
        }
        LinearLayout linearLayout2 = this$0.E7;
        if (linearLayout2 == null) {
            f0.S("areaTemperatureHistories");
            linearLayout2 = null;
        }
        o5.c.b(linearLayout, Boolean.valueOf(linearLayout2.getVisibility() != 0), false, 2, null);
        LinearLayout linearLayout3 = this$0.E7;
        if (linearLayout3 == null) {
            f0.S("areaTemperatureHistories");
            linearLayout3 = null;
        }
        if (linearLayout3.getVisibility() != 0) {
            ImageView imageView2 = this$0.F7;
            if (imageView2 == null) {
                f0.S("btnAction");
            } else {
                imageView = imageView2;
            }
            imageView.setImageResource(R.drawable.ic_down);
            return;
        }
        ImageView imageView3 = this$0.F7;
        if (imageView3 == null) {
            f0.S("btnAction");
        } else {
            imageView = imageView3;
        }
        imageView.setImageResource(R.drawable.ic_up);
        t9.j.f50990a.I();
    }

    @Override // q5.b
    public void N(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        f0.p(context, "context");
        super.N(context, attributeSet);
        View viewFindViewById = findViewById(R.id.btn_action);
        f0.o(viewFindViewById, "findViewById(R.id.btn_action)");
        ImageView imageView = (ImageView) viewFindViewById;
        this.F7 = imageView;
        View[] viewArr = new View[2];
        if (imageView == null) {
            f0.S("btnAction");
            imageView = null;
        }
        viewArr[0] = imageView;
        viewArr[1] = findViewById(R.id.area_title);
        com.blankj.utilcode.util.o.t(viewArr, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.W(this.f14701a, view);
            }
        });
        V();
        ((TabLayout) findViewById(R.id.tl_temperature_period)).c(new b());
        ThreadUtils.Q(new c(), 1L, TimeUnit.MINUTES);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T(int i10) {
        LineChart lineChart = this.K2;
        LineChart lineChart2 = null;
        if (lineChart == null) {
            f0.S("lcTemperature");
            lineChart = null;
        }
        la.m mVar = (la.m) lineChart.getData();
        if (mVar != null) {
            qa.e eVarU = (qa.f) mVar.k(0);
            if (eVarU == null) {
                eVarU = U();
                mVar.a(eVarU);
            }
            mVar.b(new Entry(eVarU.e1(), i10), 0);
            mVar.E();
            LineChart lineChart3 = this.K2;
            if (lineChart3 == null) {
                f0.S("lcTemperature");
                lineChart3 = null;
            }
            lineChart3.O();
            LineChart lineChart4 = this.K2;
            if (lineChart4 == null) {
                f0.S("lcTemperature");
            } else {
                lineChart2 = lineChart4;
            }
            lineChart2.F0(0.0f);
        }
    }

    public final LineDataSet U() {
        LineDataSet lineDataSet = new LineDataSet(null, "");
        lineDataSet.l(YAxis.AxisDependency.LEFT);
        lineDataSet.y1(getResources().getColor(R.color.colorPrimary));
        lineDataSet.R(getResources().getColor(R.color.color_000000_a30));
        lineDataSet.g2(1.0f);
        lineDataSet.x2(false);
        lineDataSet.c1(false);
        return lineDataSet;
    }

    public final void V() {
        View viewFindViewById = findViewById(R.id.area_temperature_history);
        f0.o(viewFindViewById, "findViewById(R.id.area_temperature_history)");
        this.E7 = (LinearLayout) viewFindViewById;
        LineChart lineChart = (LineChart) findViewById(R.id.lc_temperature);
        f0.o(lineChart, "this");
        this.K2 = lineChart;
        lineChart.getDescription().g(false);
        lineChart.setTouchEnabled(false);
        lineChart.setDragEnabled(false);
        lineChart.setScaleEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setPinchZoom(false);
        lineChart.setBackgroundColor(-1);
        lineChart.setData(new la.m());
        Legend legend = lineChart.getLegend();
        legend.T(Legend.LegendForm.LINE);
        Resources resources = lineChart.getResources();
        int i10 = R.color.color_000000_a50;
        legend.h(resources.getColor(i10));
        XAxis xAxis = lineChart.getXAxis();
        xAxis.h0(false);
        xAxis.y0(true);
        xAxis.g(false);
        YAxis axisLeft = lineChart.getAxisLeft();
        axisLeft.h(lineChart.getResources().getColor(i10));
        axisLeft.c0(30.0f);
        axisLeft.e0(-10.0f);
        axisLeft.h0(true);
        lineChart.getAxisRight().g(false);
        lineChart.getAxisRight().h0(false);
    }

    public final void X(int i10) {
        if (i10 != Integer.MAX_VALUE) {
            setTitle(getContext().getString(R.string.device_fragment_detail_b3_temperature_device, Integer.valueOf(i10)));
        }
    }

    public final void Y(@yt.k byte[] tempHistory) {
        f0.p(tempHistory, "tempHistory");
        LineChart lineChart = this.K2;
        if (lineChart == null) {
            f0.S("lcTemperature");
            lineChart = null;
        }
        lineChart.s();
        int length = tempHistory.length;
        int i10 = this.C2;
        if (length > i10) {
            tempHistory = kotlin.collections.m.G1(tempHistory, tempHistory.length - i10, tempHistory.length);
        }
        for (byte b10 : tempHistory) {
            T(b10);
        }
    }

    @Override // q5.b
    public int getLayoutId() {
        return R.layout.device_widget_wind_temperature_b6;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public t(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.C2 = 180;
    }
}
