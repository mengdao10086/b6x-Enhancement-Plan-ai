package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleCheckBoxView;
import com.flydigi.float_view.widget.FloatViewVibrateItemView;

/* JADX INFO: loaded from: classes7.dex */
public final class n0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final View f54304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final f2 f54305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleCheckBoxView f54307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f54308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f54309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f54310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final FloatViewVibrateItemView f54311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final FloatViewVibrateItemView f54312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final FloatViewVibrateItemView f54313k;

    public n0(@g.n0 FrameLayout frameLayout, @g.n0 View view, @g.n0 f2 f2Var, @g.n0 ConstraintLayout constraintLayout, @g.n0 FloatViewSingleCheckBoxView floatViewSingleCheckBoxView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 FloatViewVibrateItemView floatViewVibrateItemView, @g.n0 FloatViewVibrateItemView floatViewVibrateItemView2, @g.n0 FloatViewVibrateItemView floatViewVibrateItemView3) {
        this.f54303a = frameLayout;
        this.f54304b = view;
        this.f54305c = f2Var;
        this.f54306d = constraintLayout;
        this.f54307e = floatViewSingleCheckBoxView;
        this.f54308f = textView;
        this.f54309g = textView2;
        this.f54310h = textView3;
        this.f54311i = floatViewVibrateItemView;
        this.f54312j = floatViewVibrateItemView2;
        this.f54313k = floatViewVibrateItemView3;
    }

    @g.n0
    public static n0 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.area_mask;
        View viewA2 = j2.c.a(view, i10);
        if (viewA2 != null && (viewA = j2.c.a(view, (i10 = R.id.layout_wait_click))) != null) {
            f2 f2VarA = f2.a(viewA);
            i10 = R.id.rl_top;
            ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.scb_vibrate_enable;
                FloatViewSingleCheckBoxView floatViewSingleCheckBoxView = (FloatViewSingleCheckBoxView) j2.c.a(view, i10);
                if (floatViewSingleCheckBoxView != null) {
                    i10 = R.id.tv_cancel;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.tv_ok;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.tv_title;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.vi_vibrate_1;
                                FloatViewVibrateItemView floatViewVibrateItemView = (FloatViewVibrateItemView) j2.c.a(view, i10);
                                if (floatViewVibrateItemView != null) {
                                    i10 = R.id.vi_vibrate_2;
                                    FloatViewVibrateItemView floatViewVibrateItemView2 = (FloatViewVibrateItemView) j2.c.a(view, i10);
                                    if (floatViewVibrateItemView2 != null) {
                                        i10 = R.id.vi_vibrate_3;
                                        FloatViewVibrateItemView floatViewVibrateItemView3 = (FloatViewVibrateItemView) j2.c.a(view, i10);
                                        if (floatViewVibrateItemView3 != null) {
                                            return new n0((FrameLayout) view, viewA2, f2VarA, constraintLayout, floatViewSingleCheckBoxView, textView, textView2, textView3, floatViewVibrateItemView, floatViewVibrateItemView2, floatViewVibrateItemView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static n0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static n0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_panel_vibrate_setup, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54303a;
    }
}
