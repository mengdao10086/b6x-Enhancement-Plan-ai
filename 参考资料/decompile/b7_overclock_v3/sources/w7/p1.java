package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewSingleCheckBoxView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class p1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f54377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewKeySetView f54378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleCheckBoxView f54379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f54383i;

    public p1(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 ImageView imageView, @g.n0 FloatViewKeySetView floatViewKeySetView, @g.n0 FloatViewSingleCheckBoxView floatViewSingleCheckBoxView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView2, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView3, @g.n0 TextView textView) {
        this.f54375a = propertyLinearLayout;
        this.f54376b = floatViewPropertyIntroductionView;
        this.f54377c = imageView;
        this.f54378d = floatViewKeySetView;
        this.f54379e = floatViewSingleCheckBoxView;
        this.f54380f = floatViewSingleSeekBarView;
        this.f54381g = floatViewSingleSeekBarView2;
        this.f54382h = floatViewSingleSeekBarView3;
        this.f54383i = textView;
    }

    @g.n0
    public static p1 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.iv_change_radius_help;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.ksv_change_radius;
                FloatViewKeySetView floatViewKeySetView = (FloatViewKeySetView) j2.c.a(view, i10);
                if (floatViewKeySetView != null) {
                    i10 = R.id.scb_reverse;
                    FloatViewSingleCheckBoxView floatViewSingleCheckBoxView = (FloatViewSingleCheckBoxView) j2.c.a(view, i10);
                    if (floatViewSingleCheckBoxView != null) {
                        i10 = R.id.ssb_radius_after_change;
                        FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                        if (floatViewSingleSeekBarView != null) {
                            i10 = R.id.ssb_radius_wheel;
                            FloatViewSingleSeekBarView floatViewSingleSeekBarView2 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                            if (floatViewSingleSeekBarView2 != null) {
                                i10 = R.id.ssb_radius_wheel_ban;
                                FloatViewSingleSeekBarView floatViewSingleSeekBarView3 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                                if (floatViewSingleSeekBarView3 != null) {
                                    i10 = R.id.tv_change_radius;
                                    TextView textView = (TextView) j2.c.a(view, i10);
                                    if (textView != null) {
                                        return new p1((PropertyLinearLayout) view, floatViewPropertyIntroductionView, imageView, floatViewKeySetView, floatViewSingleCheckBoxView, floatViewSingleSeekBarView, floatViewSingleSeekBarView2, floatViewSingleSeekBarView3, textView);
                                    }
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
    public static p1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static p1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_key_moba_wheel_joystick_relation, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54375a;
    }
}
