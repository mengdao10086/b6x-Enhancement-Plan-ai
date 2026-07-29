package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.ExpandView;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ExpandView f54022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f54024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f54025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final e2 f54026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final f2 f54027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final RecyclerView f54028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final RecyclerView f54029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f54031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f54032n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f54033o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f54034p;

    public d0(@g.n0 ConstraintLayout constraintLayout, @g.n0 FrameLayout frameLayout, @g.n0 FrameLayout frameLayout2, @g.n0 ExpandView expandView, @g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 TextView textView, @g.n0 e2 e2Var, @g.n0 f2 f2Var, @g.n0 RecyclerView recyclerView, @g.n0 RecyclerView recyclerView2, @g.n0 RelativeLayout relativeLayout, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5) {
        this.f54019a = constraintLayout;
        this.f54020b = frameLayout;
        this.f54021c = frameLayout2;
        this.f54022d = expandView;
        this.f54023e = linearLayout;
        this.f54024f = imageView;
        this.f54025g = textView;
        this.f54026h = e2Var;
        this.f54027i = f2Var;
        this.f54028j = recyclerView;
        this.f54029k = recyclerView2;
        this.f54030l = relativeLayout;
        this.f54031m = textView2;
        this.f54032n = textView3;
        this.f54033o = textView4;
        this.f54034p = textView5;
    }

    @g.n0
    public static d0 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.area_key;
        FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
        if (frameLayout != null) {
            i10 = R.id.area_property_panel;
            FrameLayout frameLayout2 = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout2 != null) {
                i10 = R.id.iv_key;
                ExpandView expandView = (ExpandView) j2.c.a(view, i10);
                if (expandView != null) {
                    i10 = R.id.key_display_state;
                    LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.key_display_state_image;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.key_display_state_text;
                            TextView textView = (TextView) j2.c.a(view, i10);
                            if (textView != null && (viewA = j2.c.a(view, (i10 = R.id.layout_question))) != null) {
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
                                            RelativeLayout relativeLayout = (RelativeLayout) j2.c.a(view, i10);
                                            if (relativeLayout != null) {
                                                i10 = R.id.tv_cancel;
                                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                                if (textView2 != null) {
                                                    i10 = R.id.tv_copy_key_property;
                                                    TextView textView3 = (TextView) j2.c.a(view, i10);
                                                    if (textView3 != null) {
                                                        i10 = R.id.tv_ok;
                                                        TextView textView4 = (TextView) j2.c.a(view, i10);
                                                        if (textView4 != null) {
                                                            i10 = R.id.tv_title;
                                                            TextView textView5 = (TextView) j2.c.a(view, i10);
                                                            if (textView5 != null) {
                                                                return new d0((ConstraintLayout) view, frameLayout, frameLayout2, expandView, linearLayout, imageView, textView, e2VarA, f2VarA, recyclerView, recyclerView2, relativeLayout, textView2, textView3, textView4, textView5);
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
    public static d0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static d0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_property_key, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54019a;
    }
}
