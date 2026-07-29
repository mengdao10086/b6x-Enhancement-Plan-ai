package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.FloatViewThreeCheckBoxView;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class t0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewKeySetView f54463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoCheckBoxView f54466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final FloatViewThreeCheckBoxView f54467g;

    public t0(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewKeySetView floatViewKeySetView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView2, @g.n0 FloatViewTwoCheckBoxView floatViewTwoCheckBoxView, @g.n0 FloatViewThreeCheckBoxView floatViewThreeCheckBoxView) {
        this.f54461a = propertyLinearLayout;
        this.f54462b = floatViewPropertyIntroductionView;
        this.f54463c = floatViewKeySetView;
        this.f54464d = floatViewSingleSeekBarView;
        this.f54465e = floatViewSingleSeekBarView2;
        this.f54466f = floatViewTwoCheckBoxView;
        this.f54467g = floatViewThreeCheckBoxView;
    }

    @g.n0
    public static t0 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.ksv_change_radius;
            FloatViewKeySetView floatViewKeySetView = (FloatViewKeySetView) j2.c.a(view, i10);
            if (floatViewKeySetView != null) {
                i10 = R.id.ssb_delay;
                FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                if (floatViewSingleSeekBarView != null) {
                    i10 = R.id.ssb_radius;
                    FloatViewSingleSeekBarView floatViewSingleSeekBarView2 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                    if (floatViewSingleSeekBarView2 != null) {
                        i10 = R.id.tcb_move_center_ban;
                        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = (FloatViewTwoCheckBoxView) j2.c.a(view, i10);
                        if (floatViewTwoCheckBoxView != null) {
                            i10 = R.id.tcb_trigger_mode;
                            FloatViewThreeCheckBoxView floatViewThreeCheckBoxView = (FloatViewThreeCheckBoxView) j2.c.a(view, i10);
                            if (floatViewThreeCheckBoxView != null) {
                                return new t0((PropertyLinearLayout) view, floatViewPropertyIntroductionView, floatViewKeySetView, floatViewSingleSeekBarView, floatViewSingleSeekBarView2, floatViewTwoCheckBoxView, floatViewThreeCheckBoxView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static t0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static t0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_joystick_move_keyboard, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54461a;
    }
}
