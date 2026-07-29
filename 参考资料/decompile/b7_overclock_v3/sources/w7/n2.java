package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.FloatViewThreeCheckBoxView;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;

/* JADX INFO: loaded from: classes7.dex */
public final class n2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FloatViewKeySetView f54319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FloatViewThreeCheckBoxView f54322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final FloatViewTwoCheckBoxView f54323f;

    public n2(@g.n0 ConstraintLayout constraintLayout, @g.n0 FloatViewKeySetView floatViewKeySetView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView2, @g.n0 FloatViewThreeCheckBoxView floatViewThreeCheckBoxView, @g.n0 FloatViewTwoCheckBoxView floatViewTwoCheckBoxView) {
        this.f54318a = constraintLayout;
        this.f54319b = floatViewKeySetView;
        this.f54320c = floatViewSingleSeekBarView;
        this.f54321d = floatViewSingleSeekBarView2;
        this.f54322e = floatViewThreeCheckBoxView;
        this.f54323f = floatViewTwoCheckBoxView;
    }

    @g.n0
    public static n2 a(@g.n0 View view) {
        int i10 = R.id.ksv_key;
        FloatViewKeySetView floatViewKeySetView = (FloatViewKeySetView) j2.c.a(view, i10);
        if (floatViewKeySetView != null) {
            i10 = R.id.ssb_duration;
            FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
            if (floatViewSingleSeekBarView != null) {
                i10 = R.id.ssb_level;
                FloatViewSingleSeekBarView floatViewSingleSeekBarView2 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                if (floatViewSingleSeekBarView2 != null) {
                    i10 = R.id.tcb_position;
                    FloatViewThreeCheckBoxView floatViewThreeCheckBoxView = (FloatViewThreeCheckBoxView) j2.c.a(view, i10);
                    if (floatViewThreeCheckBoxView != null) {
                        i10 = R.id.tcb_trigger_mode;
                        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = (FloatViewTwoCheckBoxView) j2.c.a(view, i10);
                        if (floatViewTwoCheckBoxView != null) {
                            return new n2((ConstraintLayout) view, floatViewKeySetView, floatViewSingleSeekBarView, floatViewSingleSeekBarView2, floatViewThreeCheckBoxView, floatViewTwoCheckBoxView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static n2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static n2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_vibrate_key_set_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54318a;
    }
}
