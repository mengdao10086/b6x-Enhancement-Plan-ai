package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class y implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final View f54549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final View f54550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final View f54551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final r f54553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final p f54554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final q f54555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f54556l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f54557m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f54558n;

    public y(@g.n0 RelativeLayout relativeLayout, @g.n0 RelativeLayout relativeLayout2, @g.n0 RelativeLayout relativeLayout3, @g.n0 RelativeLayout relativeLayout4, @g.n0 View view, @g.n0 View view2, @g.n0 View view3, @g.n0 LinearLayout linearLayout, @g.n0 r rVar, @g.n0 p pVar, @g.n0 q qVar, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f54545a = relativeLayout;
        this.f54546b = relativeLayout2;
        this.f54547c = relativeLayout3;
        this.f54548d = relativeLayout4;
        this.f54549e = view;
        this.f54550f = view2;
        this.f54551g = view3;
        this.f54552h = linearLayout;
        this.f54553i = rVar;
        this.f54554j = pVar;
        this.f54555k = qVar;
        this.f54556l = textView;
        this.f54557m = textView2;
        this.f54558n = textView3;
    }

    @g.n0
    public static y a(@g.n0 View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i10 = R.id.btn_key_basic;
        RelativeLayout relativeLayout = (RelativeLayout) j2.c.a(view, i10);
        if (relativeLayout != null) {
            i10 = R.id.btn_key_combination;
            RelativeLayout relativeLayout2 = (RelativeLayout) j2.c.a(view, i10);
            if (relativeLayout2 != null) {
                i10 = R.id.btn_key_other;
                RelativeLayout relativeLayout3 = (RelativeLayout) j2.c.a(view, i10);
                if (relativeLayout3 != null && (viewA = j2.c.a(view, (i10 = R.id.indicator_key_basic))) != null && (viewA2 = j2.c.a(view, (i10 = R.id.indicator_key_combination))) != null && (viewA3 = j2.c.a(view, (i10 = R.id.indicator_key_other))) != null) {
                    i10 = R.id.layout_whole;
                    LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout != null && (viewA4 = j2.c.a(view, (i10 = R.id.panel_key_basic))) != null) {
                        r rVarA = r.a(viewA4);
                        i10 = R.id.panel_key_combination;
                        View viewA5 = j2.c.a(view, i10);
                        if (viewA5 != null) {
                            p pVarA = p.a(viewA5);
                            i10 = R.id.panel_key_other;
                            View viewA6 = j2.c.a(view, i10);
                            if (viewA6 != null) {
                                q qVarA = q.a(viewA6);
                                i10 = R.id.tv_key_basic;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_key_combination;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_key_other;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            return new y((RelativeLayout) view, relativeLayout, relativeLayout2, relativeLayout3, viewA, viewA2, viewA3, linearLayout, rVarA, pVarA, qVarA, textView, textView2, textView3);
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
    public static y c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static y d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_key_panel_whole, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f54545a;
    }
}
