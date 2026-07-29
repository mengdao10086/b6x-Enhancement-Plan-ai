package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.ExpandView;

/* JADX INFO: loaded from: classes7.dex */
public final class w implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ExpandView f54503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ExpandView f54504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ExpandView f54505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ExpandView f54506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ExpandView f54507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ExpandView f54508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ExpandView f54509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ExpandView f54510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ExpandView f54511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ExpandView f54512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final ExpandView f54513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final ExpandView f54514n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final ExpandView f54515o;

    public w(@g.n0 RelativeLayout relativeLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 ExpandView expandView, @g.n0 ExpandView expandView2, @g.n0 ExpandView expandView3, @g.n0 ExpandView expandView4, @g.n0 ExpandView expandView5, @g.n0 ExpandView expandView6, @g.n0 ExpandView expandView7, @g.n0 ExpandView expandView8, @g.n0 ExpandView expandView9, @g.n0 ExpandView expandView10, @g.n0 ExpandView expandView11, @g.n0 ExpandView expandView12, @g.n0 ExpandView expandView13) {
        this.f54501a = relativeLayout;
        this.f54502b = constraintLayout;
        this.f54503c = expandView;
        this.f54504d = expandView2;
        this.f54505e = expandView3;
        this.f54506f = expandView4;
        this.f54507g = expandView5;
        this.f54508h = expandView6;
        this.f54509i = expandView7;
        this.f54510j = expandView8;
        this.f54511k = expandView9;
        this.f54512l = expandView10;
        this.f54513m = expandView11;
        this.f54514n = expandView12;
        this.f54515o = expandView13;
    }

    @g.n0
    public static w a(@g.n0 View view) {
        int i10 = R.id.layout_half;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.view_key_a;
            ExpandView expandView = (ExpandView) j2.c.a(view, i10);
            if (expandView != null) {
                i10 = R.id.view_key_b;
                ExpandView expandView2 = (ExpandView) j2.c.a(view, i10);
                if (expandView2 != null) {
                    i10 = R.id.view_key_combo;
                    ExpandView expandView3 = (ExpandView) j2.c.a(view, i10);
                    if (expandView3 != null) {
                        i10 = R.id.view_key_l3;
                        ExpandView expandView4 = (ExpandView) j2.c.a(view, i10);
                        if (expandView4 != null) {
                            i10 = R.id.view_key_lb;
                            ExpandView expandView5 = (ExpandView) j2.c.a(view, i10);
                            if (expandView5 != null) {
                                i10 = R.id.view_key_lba;
                                ExpandView expandView6 = (ExpandView) j2.c.a(view, i10);
                                if (expandView6 != null) {
                                    i10 = R.id.view_key_lbb;
                                    ExpandView expandView7 = (ExpandView) j2.c.a(view, i10);
                                    if (expandView7 != null) {
                                        i10 = R.id.view_key_leftstick;
                                        ExpandView expandView8 = (ExpandView) j2.c.a(view, i10);
                                        if (expandView8 != null) {
                                            i10 = R.id.view_key_lt;
                                            ExpandView expandView9 = (ExpandView) j2.c.a(view, i10);
                                            if (expandView9 != null) {
                                                i10 = R.id.view_key_lta;
                                                ExpandView expandView10 = (ExpandView) j2.c.a(view, i10);
                                                if (expandView10 != null) {
                                                    i10 = R.id.view_key_ltb;
                                                    ExpandView expandView11 = (ExpandView) j2.c.a(view, i10);
                                                    if (expandView11 != null) {
                                                        i10 = R.id.view_key_m1;
                                                        ExpandView expandView12 = (ExpandView) j2.c.a(view, i10);
                                                        if (expandView12 != null) {
                                                            i10 = R.id.view_key_select;
                                                            ExpandView expandView13 = (ExpandView) j2.c.a(view, i10);
                                                            if (expandView13 != null) {
                                                                return new w((RelativeLayout) view, constraintLayout, expandView, expandView2, expandView3, expandView4, expandView5, expandView6, expandView7, expandView8, expandView9, expandView10, expandView11, expandView12, expandView13);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static w c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static w d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_key_panel_half, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f54501a;
    }
}
