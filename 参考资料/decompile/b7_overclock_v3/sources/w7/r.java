package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.ExpandView;

/* JADX INFO: loaded from: classes7.dex */
public final class r implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Guideline f54407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ExpandView f54408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ExpandView f54409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ExpandView f54410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ExpandView f54411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ExpandView f54412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ExpandView f54413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ExpandView f54414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ExpandView f54415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ExpandView f54416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ExpandView f54417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final ExpandView f54418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final ExpandView f54419n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final ExpandView f54420o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final ExpandView f54421p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final ExpandView f54422q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final ExpandView f54423r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.n0
    public final ExpandView f54424s;

    public r(@g.n0 ConstraintLayout constraintLayout, @g.n0 Guideline guideline, @g.n0 ExpandView expandView, @g.n0 ExpandView expandView2, @g.n0 ExpandView expandView3, @g.n0 ExpandView expandView4, @g.n0 ExpandView expandView5, @g.n0 ExpandView expandView6, @g.n0 ExpandView expandView7, @g.n0 ExpandView expandView8, @g.n0 ExpandView expandView9, @g.n0 ExpandView expandView10, @g.n0 ExpandView expandView11, @g.n0 ExpandView expandView12, @g.n0 ExpandView expandView13, @g.n0 ExpandView expandView14, @g.n0 ExpandView expandView15, @g.n0 ExpandView expandView16, @g.n0 ExpandView expandView17) {
        this.f54406a = constraintLayout;
        this.f54407b = guideline;
        this.f54408c = expandView;
        this.f54409d = expandView2;
        this.f54410e = expandView3;
        this.f54411f = expandView4;
        this.f54412g = expandView5;
        this.f54413h = expandView6;
        this.f54414i = expandView7;
        this.f54415j = expandView8;
        this.f54416k = expandView9;
        this.f54417l = expandView10;
        this.f54418m = expandView11;
        this.f54419n = expandView12;
        this.f54420o = expandView13;
        this.f54421p = expandView14;
        this.f54422q = expandView15;
        this.f54423r = expandView16;
        this.f54424s = expandView17;
    }

    @g.n0
    public static r a(@g.n0 View view) {
        int i10 = R.id.guide_vertical;
        Guideline guideline = (Guideline) j2.c.a(view, i10);
        if (guideline != null) {
            i10 = R.id.view_key_a;
            ExpandView expandView = (ExpandView) j2.c.a(view, i10);
            if (expandView != null) {
                i10 = R.id.view_key_b;
                ExpandView expandView2 = (ExpandView) j2.c.a(view, i10);
                if (expandView2 != null) {
                    i10 = R.id.view_key_c;
                    ExpandView expandView3 = (ExpandView) j2.c.a(view, i10);
                    if (expandView3 != null) {
                        i10 = R.id.view_key_down;
                        ExpandView expandView4 = (ExpandView) j2.c.a(view, i10);
                        if (expandView4 != null) {
                            i10 = R.id.view_key_lb;
                            ExpandView expandView5 = (ExpandView) j2.c.a(view, i10);
                            if (expandView5 != null) {
                                i10 = R.id.view_key_left;
                                ExpandView expandView6 = (ExpandView) j2.c.a(view, i10);
                                if (expandView6 != null) {
                                    i10 = R.id.view_key_leftstick;
                                    ExpandView expandView7 = (ExpandView) j2.c.a(view, i10);
                                    if (expandView7 != null) {
                                        i10 = R.id.view_key_lt;
                                        ExpandView expandView8 = (ExpandView) j2.c.a(view, i10);
                                        if (expandView8 != null) {
                                            i10 = R.id.view_key_lunpan;
                                            ExpandView expandView9 = (ExpandView) j2.c.a(view, i10);
                                            if (expandView9 != null) {
                                                i10 = R.id.view_key_rb;
                                                ExpandView expandView10 = (ExpandView) j2.c.a(view, i10);
                                                if (expandView10 != null) {
                                                    i10 = R.id.view_key_right;
                                                    ExpandView expandView11 = (ExpandView) j2.c.a(view, i10);
                                                    if (expandView11 != null) {
                                                        i10 = R.id.view_key_rightstick;
                                                        ExpandView expandView12 = (ExpandView) j2.c.a(view, i10);
                                                        if (expandView12 != null) {
                                                            i10 = R.id.view_key_rt;
                                                            ExpandView expandView13 = (ExpandView) j2.c.a(view, i10);
                                                            if (expandView13 != null) {
                                                                i10 = R.id.view_key_up;
                                                                ExpandView expandView14 = (ExpandView) j2.c.a(view, i10);
                                                                if (expandView14 != null) {
                                                                    i10 = R.id.view_key_x;
                                                                    ExpandView expandView15 = (ExpandView) j2.c.a(view, i10);
                                                                    if (expandView15 != null) {
                                                                        i10 = R.id.view_key_y;
                                                                        ExpandView expandView16 = (ExpandView) j2.c.a(view, i10);
                                                                        if (expandView16 != null) {
                                                                            i10 = R.id.view_key_z;
                                                                            ExpandView expandView17 = (ExpandView) j2.c.a(view, i10);
                                                                            if (expandView17 != null) {
                                                                                return new r((ConstraintLayout) view, guideline, expandView, expandView2, expandView3, expandView4, expandView5, expandView6, expandView7, expandView8, expandView9, expandView10, expandView11, expandView12, expandView13, expandView14, expandView15, expandView16, expandView17);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static r c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static r d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_gamepad_whole_single_key, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54406a;
    }
}
