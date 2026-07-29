package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class y0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoSeekBarView f54561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoSeekBarView f54562d;

    public y0(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewTwoSeekBarView floatViewTwoSeekBarView, @g.n0 FloatViewTwoSeekBarView floatViewTwoSeekBarView2) {
        this.f54559a = propertyLinearLayout;
        this.f54560b = floatViewPropertyIntroductionView;
        this.f54561c = floatViewTwoSeekBarView;
        this.f54562d = floatViewTwoSeekBarView2;
    }

    @g.n0
    public static y0 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.tsb_motion_sens;
            FloatViewTwoSeekBarView floatViewTwoSeekBarView = (FloatViewTwoSeekBarView) j2.c.a(view, i10);
            if (floatViewTwoSeekBarView != null) {
                i10 = R.id.tsb_motion_sens_joystick_r;
                FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = (FloatViewTwoSeekBarView) j2.c.a(view, i10);
                if (floatViewTwoSeekBarView2 != null) {
                    return new y0((PropertyLinearLayout) view, floatViewPropertyIntroductionView, floatViewTwoSeekBarView, floatViewTwoSeekBarView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static y0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static y0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_key_fps_motion_shoot, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54559a;
    }
}
