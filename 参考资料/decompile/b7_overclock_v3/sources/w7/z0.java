package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class z0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoSeekBarView f54583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoSeekBarView f54584d;

    public z0(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewTwoSeekBarView floatViewTwoSeekBarView, @g.n0 FloatViewTwoSeekBarView floatViewTwoSeekBarView2) {
        this.f54581a = propertyLinearLayout;
        this.f54582b = floatViewPropertyIntroductionView;
        this.f54583c = floatViewTwoSeekBarView;
        this.f54584d = floatViewTwoSeekBarView2;
    }

    @g.n0
    public static z0 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.tsb_motion_sens;
            FloatViewTwoSeekBarView floatViewTwoSeekBarView = (FloatViewTwoSeekBarView) j2.c.a(view, i10);
            if (floatViewTwoSeekBarView != null) {
                i10 = R.id.tsb_motion_sens_joystick_r;
                FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = (FloatViewTwoSeekBarView) j2.c.a(view, i10);
                if (floatViewTwoSeekBarView2 != null) {
                    return new z0((PropertyLinearLayout) view, floatViewPropertyIntroductionView, floatViewTwoSeekBarView, floatViewTwoSeekBarView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static z0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static z0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_key_fps_motion_view_alwayson, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54581a;
    }
}
