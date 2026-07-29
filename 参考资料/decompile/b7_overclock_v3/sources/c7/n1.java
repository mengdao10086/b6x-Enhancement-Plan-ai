package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.view.StingerTestView;

/* JADX INFO: loaded from: classes7.dex */
public final class n1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final StingerTestView f10257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final StingerTestView f10258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final Guideline f10262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ImageView f10263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ImageView f10264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ImageView f10265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ImageView f10266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ImageView f10267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final ImageView f10268m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f10269n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10270o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f10271p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f10272q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final TextView f10273r;

    public n1(@g.n0 ConstraintLayout constraintLayout, @g.n0 StingerTestView stingerTestView, @g.n0 StingerTestView stingerTestView2, @g.n0 ConstraintLayout constraintLayout2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 Guideline guideline, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 ImageView imageView4, @g.n0 ImageView imageView5, @g.n0 ImageView imageView6, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7) {
        this.f10256a = constraintLayout;
        this.f10257b = stingerTestView;
        this.f10258c = stingerTestView2;
        this.f10259d = constraintLayout2;
        this.f10260e = textView;
        this.f10261f = textView2;
        this.f10262g = guideline;
        this.f10263h = imageView;
        this.f10264i = imageView2;
        this.f10265j = imageView3;
        this.f10266k = imageView4;
        this.f10267l = imageView5;
        this.f10268m = imageView6;
        this.f10269n = textView3;
        this.f10270o = textView4;
        this.f10271p = textView5;
        this.f10272q = textView6;
        this.f10273r = textView7;
    }

    @g.n0
    public static n1 a(@g.n0 View view) {
        int i10 = R.id.area_left;
        StingerTestView stingerTestView = (StingerTestView) j2.c.a(view, i10);
        if (stingerTestView != null) {
            i10 = R.id.area_right;
            StingerTestView stingerTestView2 = (StingerTestView) j2.c.a(view, i10);
            if (stingerTestView2 != null) {
                i10 = R.id.area_test;
                ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout != null) {
                    i10 = R.id.btn_finish;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.btn_reset;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.guide;
                            Guideline guideline = (Guideline) j2.c.a(view, i10);
                            if (guideline != null) {
                                i10 = R.id.iv_click;
                                ImageView imageView = (ImageView) j2.c.a(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.iv_fire;
                                    ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                    if (imageView2 != null) {
                                        i10 = R.id.iv_fire_right;
                                        ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                        if (imageView3 != null) {
                                            i10 = R.id.iv_install;
                                            ImageView imageView4 = (ImageView) j2.c.a(view, i10);
                                            if (imageView4 != null) {
                                                i10 = R.id.iv_left_arrow;
                                                ImageView imageView5 = (ImageView) j2.c.a(view, i10);
                                                if (imageView5 != null) {
                                                    i10 = R.id.iv_right_arrow;
                                                    ImageView imageView6 = (ImageView) j2.c.a(view, i10);
                                                    if (imageView6 != null) {
                                                        i10 = R.id.tv_click;
                                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                                        if (textView3 != null) {
                                                            i10 = R.id.tv_click_desc;
                                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                                            if (textView4 != null) {
                                                                i10 = R.id.tv_install;
                                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                                if (textView5 != null) {
                                                                    i10 = R.id.tv_install_desc;
                                                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                                                    if (textView6 != null) {
                                                                        i10 = R.id.tv_title;
                                                                        TextView textView7 = (TextView) j2.c.a(view, i10);
                                                                        if (textView7 != null) {
                                                                            return new n1((ConstraintLayout) view, stingerTestView, stingerTestView2, constraintLayout, textView, textView2, guideline, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView3, textView4, textView5, textView6, textView7);
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
    public static n1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static n1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_shadow_stinger_test, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10256a;
    }
}
