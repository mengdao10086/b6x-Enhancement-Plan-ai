package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class a2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f53966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f53967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f53968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f53969d;

    public a2(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView2) {
        this.f53966a = propertyLinearLayout;
        this.f53967b = floatViewPropertyIntroductionView;
        this.f53968c = floatViewSingleSeekBarView;
        this.f53969d = floatViewSingleSeekBarView2;
    }

    @g.n0
    public static a2 a(@g.n0 View view) {
        int i10 = R.id.introduction_view;
        FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
        if (floatViewPropertyIntroductionView != null) {
            i10 = R.id.tsb_slide_size;
            FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
            if (floatViewSingleSeekBarView != null) {
                i10 = R.id.tsb_slide_time;
                FloatViewSingleSeekBarView floatViewSingleSeekBarView2 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                if (floatViewSingleSeekBarView2 != null) {
                    return new a2((PropertyLinearLayout) view, floatViewPropertyIntroductionView, floatViewSingleSeekBarView, floatViewSingleSeekBarView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static a2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static a2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_key_slide_right_down, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f53966a;
    }
}
