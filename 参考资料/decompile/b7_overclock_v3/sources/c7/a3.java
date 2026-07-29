package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class a3 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f9813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f9816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final LineChart f9817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TabLayout f9818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f9819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f9820h;

    public a3(@g.n0 ConstraintLayout constraintLayout, @g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 ImageView imageView, @g.n0 LineChart lineChart, @g.n0 TabLayout tabLayout, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f9813a = constraintLayout;
        this.f9814b = linearLayout;
        this.f9815c = linearLayout2;
        this.f9816d = imageView;
        this.f9817e = lineChart;
        this.f9818f = tabLayout;
        this.f9819g = textView;
        this.f9820h = textView2;
    }

    @g.n0
    public static a3 a(@g.n0 View view) {
        int i10 = R.id.area_temperature_history;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_title;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.btn_action;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.lc_temperature;
                    LineChart lineChart = (LineChart) j2.c.a(view, i10);
                    if (lineChart != null) {
                        i10 = R.id.tl_temperature_period;
                        TabLayout tabLayout = (TabLayout) j2.c.a(view, i10);
                        if (tabLayout != null) {
                            i10 = R.id.tv_desc;
                            TextView textView = (TextView) j2.c.a(view, i10);
                            if (textView != null) {
                                i10 = R.id.tv_title;
                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                if (textView2 != null) {
                                    return new a3((ConstraintLayout) view, linearLayout, linearLayout2, imageView, lineChart, tabLayout, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static a3 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static a3 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_widget_wind_temperature_b6, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9813a;
    }
}
