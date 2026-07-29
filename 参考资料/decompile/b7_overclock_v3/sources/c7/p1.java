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
public final class p1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final StingerTestView f10331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final StingerTestView f10332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final Guideline f10337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ImageView f10338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ImageView f10339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ImageView f10340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ImageView f10341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final ImageView f10342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final ImageView f10343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f10345p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f10346q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final TextView f10347r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.n0
    public final TextView f10348s;

    public p1(@g.n0 ConstraintLayout constraintLayout, @g.n0 StingerTestView stingerTestView, @g.n0 StingerTestView stingerTestView2, @g.n0 ConstraintLayout constraintLayout2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 Guideline guideline, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 ImageView imageView4, @g.n0 ImageView imageView5, @g.n0 ImageView imageView6, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7, @g.n0 TextView textView8) {
        this.f10330a = constraintLayout;
        this.f10331b = stingerTestView;
        this.f10332c = stingerTestView2;
        this.f10333d = constraintLayout2;
        this.f10334e = textView;
        this.f10335f = textView2;
        this.f10336g = textView3;
        this.f10337h = guideline;
        this.f10338i = imageView;
        this.f10339j = imageView2;
        this.f10340k = imageView3;
        this.f10341l = imageView4;
        this.f10342m = imageView5;
        this.f10343n = imageView6;
        this.f10344o = textView4;
        this.f10345p = textView5;
        this.f10346q = textView6;
        this.f10347r = textView7;
        this.f10348s = textView8;
    }

    @g.n0
    public static p1 a(@g.n0 View view) {
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
                        i10 = R.id.btn_help;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.btn_reset;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
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
                                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                                            if (textView4 != null) {
                                                                i10 = R.id.tv_click_desc;
                                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                                if (textView5 != null) {
                                                                    i10 = R.id.tv_install;
                                                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                                                    if (textView6 != null) {
                                                                        i10 = R.id.tv_install_desc;
                                                                        TextView textView7 = (TextView) j2.c.a(view, i10);
                                                                        if (textView7 != null) {
                                                                            i10 = R.id.tv_title;
                                                                            TextView textView8 = (TextView) j2.c.a(view, i10);
                                                                            if (textView8 != null) {
                                                                                return new p1((ConstraintLayout) view, stingerTestView, stingerTestView2, constraintLayout, textView, textView2, textView3, guideline, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView4, textView5, textView6, textView7, textView8);
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
    public static p1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static p1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_stinger_test, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10330a;
    }
}
