package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class p0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewKeySetView f54370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54374g;

    public p0(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewKeySetView floatViewKeySetView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView2, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView3, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView4) {
        this.f54368a = propertyLinearLayout;
        this.f54369b = floatViewPropertyIntroductionView;
        this.f54370c = floatViewKeySetView;
        this.f54371d = floatViewSingleSeekBarView;
        this.f54372e = floatViewSingleSeekBarView2;
        this.f54373f = floatViewSingleSeekBarView3;
        this.f54374g = floatViewSingleSeekBarView4;
    }

    @g.n0
    public static p0 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.ksv_change_radius;
            FloatViewKeySetView floatViewKeySetView = (FloatViewKeySetView) j2.c.a(view, i10);
            if (floatViewKeySetView != null) {
                i10 = R.id.ssb_center_ban;
                FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                if (floatViewSingleSeekBarView != null) {
                    i10 = R.id.ssb_delay;
                    FloatViewSingleSeekBarView floatViewSingleSeekBarView2 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                    if (floatViewSingleSeekBarView2 != null) {
                        i10 = R.id.ssb_radius;
                        FloatViewSingleSeekBarView floatViewSingleSeekBarView3 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                        if (floatViewSingleSeekBarView3 != null) {
                            i10 = R.id.ssb_radius_change;
                            FloatViewSingleSeekBarView floatViewSingleSeekBarView4 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                            if (floatViewSingleSeekBarView4 != null) {
                                return new p0((PropertyLinearLayout) view, floatViewPropertyIntroductionView, floatViewKeySetView, floatViewSingleSeekBarView, floatViewSingleSeekBarView2, floatViewSingleSeekBarView3, floatViewSingleSeekBarView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static p0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static p0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_joystick_fixed_move, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54368a;
    }
}
