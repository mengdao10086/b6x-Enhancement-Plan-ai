package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class o0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54338c;

    public o0(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView) {
        this.f54336a = propertyLinearLayout;
        this.f54337b = floatViewPropertyIntroductionView;
        this.f54338c = floatViewSingleSeekBarView;
    }

    @g.n0
    public static o0 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.ssb_radius;
            FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
            if (floatViewSingleSeekBarView != null) {
                return new o0((PropertyLinearLayout) view, floatViewPropertyIntroductionView, floatViewSingleSeekBarView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static o0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static o0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_joystick_direction, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54336a;
    }
}
