package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;

/* JADX INFO: loaded from: classes7.dex */
public final class e0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final e2 f54051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final f2 f54052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final RecyclerView f54053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final RecyclerView f54054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final FloatViewSingleSeekBarView f54057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f54058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f54059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f54060m;

    public e0(@g.n0 ConstraintLayout constraintLayout, @g.n0 FrameLayout frameLayout, @g.n0 LinearLayout linearLayout, @g.n0 e2 e2Var, @g.n0 f2 f2Var, @g.n0 RecyclerView recyclerView, @g.n0 RecyclerView recyclerView2, @g.n0 ConstraintLayout constraintLayout2, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView, @g.n0 FloatViewSingleSeekBarView floatViewSingleSeekBarView2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f54048a = constraintLayout;
        this.f54049b = frameLayout;
        this.f54050c = linearLayout;
        this.f54051d = e2Var;
        this.f54052e = f2Var;
        this.f54053f = recyclerView;
        this.f54054g = recyclerView2;
        this.f54055h = constraintLayout2;
        this.f54056i = floatViewSingleSeekBarView;
        this.f54057j = floatViewSingleSeekBarView2;
        this.f54058k = textView;
        this.f54059l = textView2;
        this.f54060m = textView3;
    }

    @g.n0
    public static e0 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.area_property_panel;
        FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
        if (frameLayout != null) {
            i10 = R.id.layout_macro;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null && (viewA = j2.c.a(view, (i10 = R.id.layout_question))) != null) {
                e2 e2VarA = e2.a(viewA);
                i10 = R.id.layout_wait_click;
                View viewA2 = j2.c.a(view, i10);
                if (viewA2 != null) {
                    f2 f2VarA = f2.a(viewA2);
                    i10 = R.id.listview_1;
                    RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                    if (recyclerView != null) {
                        i10 = R.id.listview_2;
                        RecyclerView recyclerView2 = (RecyclerView) j2.c.a(view, i10);
                        if (recyclerView2 != null) {
                            i10 = R.id.rl_top;
                            ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                            if (constraintLayout != null) {
                                i10 = R.id.ssb_hold;
                                FloatViewSingleSeekBarView floatViewSingleSeekBarView = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                                if (floatViewSingleSeekBarView != null) {
                                    i10 = R.id.ssb_period;
                                    FloatViewSingleSeekBarView floatViewSingleSeekBarView2 = (FloatViewSingleSeekBarView) j2.c.a(view, i10);
                                    if (floatViewSingleSeekBarView2 != null) {
                                        i10 = R.id.tv_cancel;
                                        TextView textView = (TextView) j2.c.a(view, i10);
                                        if (textView != null) {
                                            i10 = R.id.tv_ok;
                                            TextView textView2 = (TextView) j2.c.a(view, i10);
                                            if (textView2 != null) {
                                                i10 = R.id.tv_title;
                                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                                if (textView3 != null) {
                                                    return new e0((ConstraintLayout) view, frameLayout, linearLayout, e2VarA, f2VarA, recyclerView, recyclerView2, constraintLayout, floatViewSingleSeekBarView, floatViewSingleSeekBarView2, textView, textView2, textView3);
                                                }
                                            }
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
    public static e0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static e0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_property_submacro, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54048a;
    }
}
