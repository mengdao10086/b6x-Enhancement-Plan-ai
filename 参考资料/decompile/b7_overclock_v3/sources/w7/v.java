package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.ExpandView;

/* JADX INFO: loaded from: classes7.dex */
public final class v implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ExpandView f54484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ExpandView f54485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ExpandView f54486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ExpandView f54487f;

    public v(@g.n0 RelativeLayout relativeLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 ExpandView expandView, @g.n0 ExpandView expandView2, @g.n0 ExpandView expandView3, @g.n0 ExpandView expandView4) {
        this.f54482a = relativeLayout;
        this.f54483b = constraintLayout;
        this.f54484c = expandView;
        this.f54485d = expandView2;
        this.f54486e = expandView3;
        this.f54487f = expandView4;
    }

    @g.n0
    public static v a(@g.n0 View view) {
        int i10 = R.id.layout_half;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.view_key_combo;
            ExpandView expandView = (ExpandView) j2.c.a(view, i10);
            if (expandView != null) {
                i10 = R.id.view_key_l3;
                ExpandView expandView2 = (ExpandView) j2.c.a(view, i10);
                if (expandView2 != null) {
                    i10 = R.id.view_key_leftstick;
                    ExpandView expandView3 = (ExpandView) j2.c.a(view, i10);
                    if (expandView3 != null) {
                        i10 = R.id.view_key_lt;
                        ExpandView expandView4 = (ExpandView) j2.c.a(view, i10);
                        if (expandView4 != null) {
                            return new v((RelativeLayout) view, constraintLayout, expandView, expandView2, expandView3, expandView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static v c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static v d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_key_panel_g1, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f54482a;
    }
}
