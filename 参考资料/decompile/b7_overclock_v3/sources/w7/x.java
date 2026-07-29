package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Guideline;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.ExpandView;

/* JADX INFO: loaded from: classes7.dex */
public final class x implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Guideline f54523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ExpandView f54524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ExpandView f54525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ExpandView f54526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ExpandView f54527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ExpandView f54528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ExpandView f54529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ExpandView f54530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ExpandView f54531j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ExpandView f54532k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ExpandView f54533l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final ExpandView f54534m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final ExpandView f54535n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final ExpandView f54536o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final ExpandView f54537p;

    public x(@g.n0 FrameLayout frameLayout, @g.n0 Guideline guideline, @g.n0 ExpandView expandView, @g.n0 ExpandView expandView2, @g.n0 ExpandView expandView3, @g.n0 ExpandView expandView4, @g.n0 ExpandView expandView5, @g.n0 ExpandView expandView6, @g.n0 ExpandView expandView7, @g.n0 ExpandView expandView8, @g.n0 ExpandView expandView9, @g.n0 ExpandView expandView10, @g.n0 ExpandView expandView11, @g.n0 ExpandView expandView12, @g.n0 ExpandView expandView13, @g.n0 ExpandView expandView14) {
        this.f54522a = frameLayout;
        this.f54523b = guideline;
        this.f54524c = expandView;
        this.f54525d = expandView2;
        this.f54526e = expandView3;
        this.f54527f = expandView4;
        this.f54528g = expandView5;
        this.f54529h = expandView6;
        this.f54530i = expandView7;
        this.f54531j = expandView8;
        this.f54532k = expandView9;
        this.f54533l = expandView10;
        this.f54534m = expandView11;
        this.f54535n = expandView12;
        this.f54536o = expandView13;
        this.f54537p = expandView14;
    }

    @g.n0
    public static x a(@g.n0 View view) {
        int i10 = R.id.guide_vertical;
        Guideline guideline = (Guideline) j2.c.a(view, i10);
        if (guideline != null) {
            i10 = R.id.view_key_alt;
            ExpandView expandView = (ExpandView) j2.c.a(view, i10);
            if (expandView != null) {
                i10 = R.id.view_key_ctrl;
                ExpandView expandView2 = (ExpandView) j2.c.a(view, i10);
                if (expandView2 != null) {
                    i10 = R.id.view_key_mouse;
                    ExpandView expandView3 = (ExpandView) j2.c.a(view, i10);
                    if (expandView3 != null) {
                        i10 = R.id.view_key_mouse_backward;
                        ExpandView expandView4 = (ExpandView) j2.c.a(view, i10);
                        if (expandView4 != null) {
                            i10 = R.id.view_key_mouse_forward;
                            ExpandView expandView5 = (ExpandView) j2.c.a(view, i10);
                            if (expandView5 != null) {
                                i10 = R.id.view_key_mouse_left;
                                ExpandView expandView6 = (ExpandView) j2.c.a(view, i10);
                                if (expandView6 != null) {
                                    i10 = R.id.view_key_mouse_middle;
                                    ExpandView expandView7 = (ExpandView) j2.c.a(view, i10);
                                    if (expandView7 != null) {
                                        i10 = R.id.view_key_mouse_middle_down;
                                        ExpandView expandView8 = (ExpandView) j2.c.a(view, i10);
                                        if (expandView8 != null) {
                                            i10 = R.id.view_key_mouse_middle_up;
                                            ExpandView expandView9 = (ExpandView) j2.c.a(view, i10);
                                            if (expandView9 != null) {
                                                i10 = R.id.view_key_mouse_right;
                                                ExpandView expandView10 = (ExpandView) j2.c.a(view, i10);
                                                if (expandView10 != null) {
                                                    i10 = R.id.view_key_place_holder;
                                                    ExpandView expandView11 = (ExpandView) j2.c.a(view, i10);
                                                    if (expandView11 != null) {
                                                        i10 = R.id.view_key_shift;
                                                        ExpandView expandView12 = (ExpandView) j2.c.a(view, i10);
                                                        if (expandView12 != null) {
                                                            i10 = R.id.view_key_wasd;
                                                            ExpandView expandView13 = (ExpandView) j2.c.a(view, i10);
                                                            if (expandView13 != null) {
                                                                i10 = R.id.view_key_win;
                                                                ExpandView expandView14 = (ExpandView) j2.c.a(view, i10);
                                                                if (expandView14 != null) {
                                                                    return new x((FrameLayout) view, guideline, expandView, expandView2, expandView3, expandView4, expandView5, expandView6, expandView7, expandView8, expandView9, expandView10, expandView11, expandView12, expandView13, expandView14);
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
    public static x c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static x d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_key_panel_keyboard, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54522a;
    }
}
