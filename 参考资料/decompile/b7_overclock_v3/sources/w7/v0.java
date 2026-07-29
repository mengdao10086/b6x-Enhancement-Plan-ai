package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewSingleCheckBoxView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class v0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final View f54490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final View f54491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleCheckBoxView f54493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoCheckBoxView f54495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoSeekBarView f54496i;

    public v0(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 View view, @g.n0 View view2, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewSingleCheckBoxView floatViewSingleCheckBoxView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView, @g.n0 FloatViewTwoCheckBoxView floatViewTwoCheckBoxView, @g.n0 FloatViewTwoSeekBarView floatViewTwoSeekBarView) {
        this.f54488a = propertyLinearLayout;
        this.f54489b = constraintLayout;
        this.f54490c = view;
        this.f54491d = view2;
        this.f54492e = floatViewPropertyIntroductionView;
        this.f54493f = floatViewSingleCheckBoxView;
        this.f54494g = floatViewSingleSeekBarView;
        this.f54495h = floatViewTwoCheckBoxView;
        this.f54496i = floatViewTwoSeekBarView;
    }

    @g.n0
    public static v0 a(@g.n0 View view) {
        View viewA;
        View viewA2;
        int i10 = R.id.area_float_fps_assist_shoot_motion;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null && (viewA = j2.c.a(view, (i10 = R.id.area_float_fps_assist_shoot_motion_mask_1))) != null && (viewA2 = j2.c.a(view, (i10 = R.id.area_float_fps_assist_shoot_motion_mask_2))) != null) {
            i10 = R.id.introduction_view;
            FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
            if (floatViewPropertyIntroductionView != null) {
                i10 = R.id.scb_motion;
                FloatViewSingleCheckBoxView floatViewSingleCheckBoxView = (FloatViewSingleCheckBoxView) j2.c.a(view, i10);
                if (floatViewSingleCheckBoxView != null) {
                    i10 = R.id.ssb_assist_shoot;
                    FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                    if (floatViewSingleSeekBarView != null) {
                        i10 = R.id.tcb_trigger_mode;
                        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = (FloatViewTwoCheckBoxView) j2.c.a(view, i10);
                        if (floatViewTwoCheckBoxView != null) {
                            i10 = R.id.tsb_motion_sens;
                            FloatViewTwoSeekBarView floatViewTwoSeekBarView = (FloatViewTwoSeekBarView) j2.c.a(view, i10);
                            if (floatViewTwoSeekBarView != null) {
                                return new v0((PropertyLinearLayout) view, constraintLayout, viewA, viewA2, floatViewPropertyIntroductionView, floatViewSingleCheckBoxView, floatViewSingleSeekBarView, floatViewTwoCheckBoxView, floatViewTwoSeekBarView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static v0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static v0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_key_fps_assist_shoot, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54488a;
    }
}
