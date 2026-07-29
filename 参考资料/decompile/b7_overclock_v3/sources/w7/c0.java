package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f53996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FrameLayout f53997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final e2 f53998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final f2 f53999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final RecyclerView f54000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f54002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f54003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f54004i;

    public c0(@g.n0 ConstraintLayout constraintLayout, @g.n0 FrameLayout frameLayout, @g.n0 e2 e2Var, @g.n0 f2 f2Var, @g.n0 RecyclerView recyclerView, @g.n0 ConstraintLayout constraintLayout2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f53996a = constraintLayout;
        this.f53997b = frameLayout;
        this.f53998c = e2Var;
        this.f53999d = f2Var;
        this.f54000e = recyclerView;
        this.f54001f = constraintLayout2;
        this.f54002g = textView;
        this.f54003h = textView2;
        this.f54004i = textView3;
    }

    @g.n0
    public static c0 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.area_property_panel;
        FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
        if (frameLayout != null && (viewA = j2.c.a(view, (i10 = R.id.layout_question))) != null) {
            e2 e2VarA = e2.a(viewA);
            i10 = R.id.layout_wait_click;
            View viewA2 = j2.c.a(view, i10);
            if (viewA2 != null) {
                f2 f2VarA = f2.a(viewA2);
                i10 = R.id.listview_1;
                RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                if (recyclerView != null) {
                    i10 = R.id.rl_top;
                    ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                    if (constraintLayout != null) {
                        i10 = R.id.tv_cancel;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_ok;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_title;
                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                if (textView3 != null) {
                                    return new c0((ConstraintLayout) view, frameLayout, e2VarA, f2VarA, recyclerView, constraintLayout, textView, textView2, textView3);
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
    public static c0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static c0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_property_joystick, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f53996a;
    }
}
