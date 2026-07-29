package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.flydigi.base.widget.IndicatorView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final IndicatorView f54326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f54327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f54328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f54329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageView f54330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54332i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f54334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ViewPager f54335l;

    public o(@g.n0 RelativeLayout relativeLayout, @g.n0 RelativeLayout relativeLayout2, @g.n0 IndicatorView indicatorView, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 ImageView imageView4, @g.n0 LinearLayout linearLayout, @g.n0 RelativeLayout relativeLayout3, @g.n0 LinearLayout linearLayout2, @g.n0 TextView textView, @g.n0 ViewPager viewPager) {
        this.f54324a = relativeLayout;
        this.f54325b = relativeLayout2;
        this.f54326c = indicatorView;
        this.f54327d = imageView;
        this.f54328e = imageView2;
        this.f54329f = imageView3;
        this.f54330g = imageView4;
        this.f54331h = linearLayout;
        this.f54332i = relativeLayout3;
        this.f54333j = linearLayout2;
        this.f54334k = textView;
        this.f54335l = viewPager;
    }

    @g.n0
    public static o a(@g.n0 View view) {
        int i10 = R.id.fl_progress;
        RelativeLayout relativeLayout = (RelativeLayout) j2.c.a(view, i10);
        if (relativeLayout != null) {
            i10 = R.id.indicator_view;
            IndicatorView indicatorView = (IndicatorView) j2.c.a(view, i10);
            if (indicatorView != null) {
                i10 = R.id.iv_arrow_left;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.iv_arrow_right;
                    ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.iv_cancel_notice;
                        ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                        if (imageView3 != null) {
                            i10 = R.id.iv_close;
                            ImageView imageView4 = (ImageView) j2.c.a(view, i10);
                            if (imageView4 != null) {
                                i10 = R.id.layout_cancel_notice;
                                LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                                if (linearLayout != null) {
                                    RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                    i10 = R.id.f15517top;
                                    LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                                    if (linearLayout2 != null) {
                                        i10 = R.id.tv_setting;
                                        TextView textView = (TextView) j2.c.a(view, i10);
                                        if (textView != null) {
                                            i10 = R.id.viewpager;
                                            ViewPager viewPager = (ViewPager) j2.c.a(view, i10);
                                            if (viewPager != null) {
                                                return new o(relativeLayout2, relativeLayout, indicatorView, imageView, imageView2, imageView3, imageView4, linearLayout, relativeLayout2, linearLayout2, textView, viewPager);
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
    public static o c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static o d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_game_strategy, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f54324a;
    }
}
