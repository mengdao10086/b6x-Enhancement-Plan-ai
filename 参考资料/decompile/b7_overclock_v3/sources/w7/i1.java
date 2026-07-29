package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class i1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoCheckBoxView f54155d;

    public i1(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView, @g.n0 FloatViewTwoCheckBoxView floatViewTwoCheckBoxView) {
        this.f54152a = propertyLinearLayout;
        this.f54153b = floatViewPropertyIntroductionView;
        this.f54154c = floatViewSingleSeekBarView;
        this.f54155d = floatViewTwoCheckBoxView;
    }

    @g.n0
    public static i1 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.ssb_radius;
            FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
            if (floatViewSingleSeekBarView != null) {
                i10 = R.id.tcb_joystick_relation;
                FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = (FloatViewTwoCheckBoxView) j2.c.a(view, i10);
                if (floatViewTwoCheckBoxView != null) {
                    return new i1((PropertyLinearLayout) view, floatViewPropertyIntroductionView, floatViewSingleSeekBarView, floatViewTwoCheckBoxView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static i1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static i1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_key_moba_left_joystick_relation, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54152a;
    }
}
