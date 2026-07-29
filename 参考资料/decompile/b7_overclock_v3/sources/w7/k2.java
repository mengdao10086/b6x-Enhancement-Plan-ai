package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class k2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageButton f54230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f54231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageButton f54232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ImageView f54233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ImageButton f54234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ImageView f54235j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ImageView f54236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f54237l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f54238m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f54239n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f54240o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f54241p;

    public k2(@g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 LinearLayout linearLayout3, @g.n0 LinearLayout linearLayout4, @g.n0 ImageButton imageButton, @g.n0 ImageView imageView, @g.n0 ImageButton imageButton2, @g.n0 ImageView imageView2, @g.n0 ImageButton imageButton3, @g.n0 ImageView imageView3, @g.n0 ImageView imageView4, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5) {
        this.f54226a = linearLayout;
        this.f54227b = linearLayout2;
        this.f54228c = linearLayout3;
        this.f54229d = linearLayout4;
        this.f54230e = imageButton;
        this.f54231f = imageView;
        this.f54232g = imageButton2;
        this.f54233h = imageView2;
        this.f54234i = imageButton3;
        this.f54235j = imageView3;
        this.f54236k = imageView4;
        this.f54237l = textView;
        this.f54238m = textView2;
        this.f54239n = textView3;
        this.f54240o = textView4;
        this.f54241p = textView5;
    }

    @g.n0
    public static k2 a(@g.n0 View view) {
        int i10 = R.id.area_checkbox;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_title;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.container;
                LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R.id.iv_checkbox_1;
                    ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
                    if (imageButton != null) {
                        i10 = R.id.iv_checkbox_1_help;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.iv_checkbox_2;
                            ImageButton imageButton2 = (ImageButton) j2.c.a(view, i10);
                            if (imageButton2 != null) {
                                i10 = R.id.iv_checkbox_2_help;
                                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                if (imageView2 != null) {
                                    i10 = R.id.iv_checkbox_3;
                                    ImageButton imageButton3 = (ImageButton) j2.c.a(view, i10);
                                    if (imageButton3 != null) {
                                        i10 = R.id.iv_checkbox_3_help;
                                        ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                        if (imageView3 != null) {
                                            i10 = R.id.iv_title_help;
                                            ImageView imageView4 = (ImageView) j2.c.a(view, i10);
                                            if (imageView4 != null) {
                                                i10 = R.id.tv_checkbox_1;
                                                TextView textView = (TextView) j2.c.a(view, i10);
                                                if (textView != null) {
                                                    i10 = R.id.tv_checkbox_2;
                                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                                    if (textView2 != null) {
                                                        i10 = R.id.tv_checkbox_3;
                                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                                        if (textView3 != null) {
                                                            i10 = R.id.tv_desc;
                                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                                            if (textView4 != null) {
                                                                i10 = R.id.tv_title;
                                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                                if (textView5 != null) {
                                                                    return new k2((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, imageButton, imageView, imageButton2, imageView2, imageButton3, imageView3, imageView4, textView, textView2, textView3, textView4, textView5);
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
    public static k2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static k2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_three_checkbox_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f54226a;
    }
}
