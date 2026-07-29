package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.ExpandView;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ExpandView f54385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ExpandView f54386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ExpandView f54387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ExpandView f54388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ExpandView f54389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ExpandView f54390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ExpandView f54391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ExpandView f54392i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ExpandView f54393j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ExpandView f54394k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ExpandView f54395l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final ExpandView f54396m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final ExpandView f54397n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final ExpandView f54398o;

    public q(@g.n0 ConstraintLayout constraintLayout, @g.n0 ExpandView expandView, @g.n0 ExpandView expandView2, @g.n0 ExpandView expandView3, @g.n0 ExpandView expandView4, @g.n0 ExpandView expandView5, @g.n0 ExpandView expandView6, @g.n0 ExpandView expandView7, @g.n0 ExpandView expandView8, @g.n0 ExpandView expandView9, @g.n0 ExpandView expandView10, @g.n0 ExpandView expandView11, @g.n0 ExpandView expandView12, @g.n0 ExpandView expandView13, @g.n0 ExpandView expandView14) {
        this.f54384a = constraintLayout;
        this.f54385b = expandView;
        this.f54386c = expandView2;
        this.f54387d = expandView3;
        this.f54388e = expandView4;
        this.f54389f = expandView5;
        this.f54390g = expandView6;
        this.f54391h = expandView7;
        this.f54392i = expandView8;
        this.f54393j = expandView9;
        this.f54394k = expandView10;
        this.f54395l = expandView11;
        this.f54396m = expandView12;
        this.f54397n = expandView13;
        this.f54398o = expandView14;
    }

    @g.n0
    public static q a(@g.n0 View view) {
        int i10 = R.id.view_key_back;
        ExpandView expandView = (ExpandView) j2.c.a(view, i10);
        if (expandView != null) {
            i10 = R.id.view_key_combo;
            ExpandView expandView2 = (ExpandView) j2.c.a(view, i10);
            if (expandView2 != null) {
                i10 = R.id.view_key_home;
                ExpandView expandView3 = (ExpandView) j2.c.a(view, i10);
                if (expandView3 != null) {
                    i10 = R.id.view_key_l3;
                    ExpandView expandView4 = (ExpandView) j2.c.a(view, i10);
                    if (expandView4 != null) {
                        i10 = R.id.view_key_m1;
                        ExpandView expandView5 = (ExpandView) j2.c.a(view, i10);
                        if (expandView5 != null) {
                            i10 = R.id.view_key_m2;
                            ExpandView expandView6 = (ExpandView) j2.c.a(view, i10);
                            if (expandView6 != null) {
                                i10 = R.id.view_key_m3;
                                ExpandView expandView7 = (ExpandView) j2.c.a(view, i10);
                                if (expandView7 != null) {
                                    i10 = R.id.view_key_m4;
                                    ExpandView expandView8 = (ExpandView) j2.c.a(view, i10);
                                    if (expandView8 != null) {
                                        i10 = R.id.view_key_m5;
                                        ExpandView expandView9 = (ExpandView) j2.c.a(view, i10);
                                        if (expandView9 != null) {
                                            i10 = R.id.view_key_m6;
                                            ExpandView expandView10 = (ExpandView) j2.c.a(view, i10);
                                            if (expandView10 != null) {
                                                i10 = R.id.view_key_menu;
                                                ExpandView expandView11 = (ExpandView) j2.c.a(view, i10);
                                                if (expandView11 != null) {
                                                    i10 = R.id.view_key_r3;
                                                    ExpandView expandView12 = (ExpandView) j2.c.a(view, i10);
                                                    if (expandView12 != null) {
                                                        i10 = R.id.view_key_select;
                                                        ExpandView expandView13 = (ExpandView) j2.c.a(view, i10);
                                                        if (expandView13 != null) {
                                                            i10 = R.id.view_key_start;
                                                            ExpandView expandView14 = (ExpandView) j2.c.a(view, i10);
                                                            if (expandView14 != null) {
                                                                return new q((ConstraintLayout) view, expandView, expandView2, expandView3, expandView4, expandView5, expandView6, expandView7, expandView8, expandView9, expandView10, expandView11, expandView12, expandView13, expandView14);
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
    public static q c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static q d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_gamepad_whole_other_key, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54384a;
    }
}
