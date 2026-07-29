package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class j0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f54169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f54170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f54171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f54172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final View f54173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final View f54174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f54176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ImageView f54179l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f54180m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54181n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54182o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final ImageView f54183p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f54184q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54185r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.n0
    public final TextView f54186s;

    public j0(@g.n0 RelativeLayout relativeLayout, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 ImageView imageView4, @g.n0 View view, @g.n0 View view2, @g.n0 LinearLayout linearLayout, @g.n0 TextView textView, @g.n0 RelativeLayout relativeLayout2, @g.n0 RelativeLayout relativeLayout3, @g.n0 ImageView imageView5, @g.n0 TextView textView2, @g.n0 RelativeLayout relativeLayout4, @g.n0 RelativeLayout relativeLayout5, @g.n0 ImageView imageView6, @g.n0 TextView textView3, @g.n0 RelativeLayout relativeLayout6, @g.n0 TextView textView4) {
        this.f54168a = relativeLayout;
        this.f54169b = imageView;
        this.f54170c = imageView2;
        this.f54171d = imageView3;
        this.f54172e = imageView4;
        this.f54173f = view;
        this.f54174g = view2;
        this.f54175h = linearLayout;
        this.f54176i = textView;
        this.f54177j = relativeLayout2;
        this.f54178k = relativeLayout3;
        this.f54179l = imageView5;
        this.f54180m = textView2;
        this.f54181n = relativeLayout4;
        this.f54182o = relativeLayout5;
        this.f54183p = imageView6;
        this.f54184q = textView3;
        this.f54185r = relativeLayout6;
        this.f54186s = textView4;
    }

    @g.n0
    public static j0 a(@g.n0 View view) {
        View viewA;
        View viewA2;
        int i10 = R.id.iv_guide_finish;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_step_0;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.iv_step_1;
                ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                if (imageView3 != null) {
                    i10 = R.id.iv_step_1_bg;
                    ImageView imageView4 = (ImageView) j2.c.a(view, i10);
                    if (imageView4 != null && (viewA = j2.c.a(view, (i10 = R.id.layout_guide_line_x))) != null && (viewA2 = j2.c.a(view, (i10 = R.id.layout_guide_line_y))) != null) {
                        i10 = R.id.layout_guide_step_0;
                        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.layout_guide_step_0_tv;
                            TextView textView = (TextView) j2.c.a(view, i10);
                            if (textView != null) {
                                i10 = R.id.layout_guide_step_1;
                                RelativeLayout relativeLayout = (RelativeLayout) j2.c.a(view, i10);
                                if (relativeLayout != null) {
                                    i10 = R.id.layout_guide_step_1_center;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) j2.c.a(view, i10);
                                    if (relativeLayout2 != null) {
                                        i10 = R.id.layout_guide_step_1_target;
                                        ImageView imageView5 = (ImageView) j2.c.a(view, i10);
                                        if (imageView5 != null) {
                                            i10 = R.id.layout_guide_step_1_tv;
                                            TextView textView2 = (TextView) j2.c.a(view, i10);
                                            if (textView2 != null) {
                                                i10 = R.id.layout_guide_step_2;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) j2.c.a(view, i10);
                                                if (relativeLayout3 != null) {
                                                    i10 = R.id.layout_guide_step_2_center;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) j2.c.a(view, i10);
                                                    if (relativeLayout4 != null) {
                                                        i10 = R.id.layout_guide_step_2_target;
                                                        ImageView imageView6 = (ImageView) j2.c.a(view, i10);
                                                        if (imageView6 != null) {
                                                            i10 = R.id.layout_guide_step_2_tv;
                                                            TextView textView3 = (TextView) j2.c.a(view, i10);
                                                            if (textView3 != null) {
                                                                RelativeLayout relativeLayout5 = (RelativeLayout) view;
                                                                i10 = R.id.tv_start_guide;
                                                                TextView textView4 = (TextView) j2.c.a(view, i10);
                                                                if (textView4 != null) {
                                                                    return new j0(relativeLayout5, imageView, imageView2, imageView3, imageView4, viewA, viewA2, linearLayout, textView, relativeLayout, relativeLayout2, imageView5, textView2, relativeLayout3, relativeLayout4, imageView6, textView3, relativeLayout5, textView4);
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
    public static j0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static j0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_setting_config_teach, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f54168a;
    }
}
