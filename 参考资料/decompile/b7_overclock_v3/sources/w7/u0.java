package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class u0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoCheckBoxView f54477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoSeekBarView f54478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoSeekBarView f54479e;

    public u0(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewTwoCheckBoxView floatViewTwoCheckBoxView, @g.n0 FloatViewTwoSeekBarView floatViewTwoSeekBarView, @g.n0 FloatViewTwoSeekBarView floatViewTwoSeekBarView2) {
        this.f54475a = propertyLinearLayout;
        this.f54476b = floatViewPropertyIntroductionView;
        this.f54477c = floatViewTwoCheckBoxView;
        this.f54478d = floatViewTwoSeekBarView;
        this.f54479e = floatViewTwoSeekBarView2;
    }

    @g.n0
    public static u0 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.tcb_trigger_mode;
            FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = (FloatViewTwoCheckBoxView) j2.c.a(view, i10);
            if (floatViewTwoCheckBoxView != null) {
                i10 = R.id.tsb_fly_mouse;
                FloatViewTwoSeekBarView floatViewTwoSeekBarView = (FloatViewTwoSeekBarView) j2.c.a(view, i10);
                if (floatViewTwoSeekBarView != null) {
                    i10 = R.id.tsb_fly_mouse_right_joystick;
                    FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = (FloatViewTwoSeekBarView) j2.c.a(view, i10);
                    if (floatViewTwoSeekBarView2 != null) {
                        return new u0((PropertyLinearLayout) view, floatViewPropertyIntroductionView, floatViewTwoCheckBoxView, floatViewTwoSeekBarView, floatViewTwoSeekBarView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static u0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static u0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_key_flymouse, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54475a;
    }
}
