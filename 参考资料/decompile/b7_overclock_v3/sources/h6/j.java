package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final NestedScrollView f30608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f30609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f30610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ConstraintLayout f30611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinearLayout f30612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final FrameLayout f30613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final FrameLayout f30614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final FrameLayout f30615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f30616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextView f30617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final ImageView f30618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final ImageView f30619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final ImageView f30620m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final TextView f30621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final TextView f30622o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final TextView f30623p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final TextView f30624q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public final TextView f30625r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @n0
    public final TextView f30626s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @n0
    public final TextView f30627t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @n0
    public final TextView f30628u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @n0
    public final TextView f30629v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @n0
    public final TextView f30630w;

    public j(@n0 NestedScrollView nestedScrollView, @n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 ConstraintLayout constraintLayout, @n0 LinearLayout linearLayout3, @n0 FrameLayout frameLayout, @n0 FrameLayout frameLayout2, @n0 FrameLayout frameLayout3, @n0 TextView textView, @n0 TextView textView2, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 ImageView imageView3, @n0 TextView textView3, @n0 TextView textView4, @n0 TextView textView5, @n0 TextView textView6, @n0 TextView textView7, @n0 TextView textView8, @n0 TextView textView9, @n0 TextView textView10, @n0 TextView textView11, @n0 TextView textView12) {
        this.f30608a = nestedScrollView;
        this.f30609b = linearLayout;
        this.f30610c = linearLayout2;
        this.f30611d = constraintLayout;
        this.f30612e = linearLayout3;
        this.f30613f = frameLayout;
        this.f30614g = frameLayout2;
        this.f30615h = frameLayout3;
        this.f30616i = textView;
        this.f30617j = textView2;
        this.f30618k = imageView;
        this.f30619l = imageView2;
        this.f30620m = imageView3;
        this.f30621n = textView3;
        this.f30622o = textView4;
        this.f30623p = textView5;
        this.f30624q = textView6;
        this.f30625r = textView7;
        this.f30626s = textView8;
        this.f30627t = textView9;
        this.f30628u = textView10;
        this.f30629v = textView11;
        this.f30630w = textView12;
    }

    @n0
    public static j a(@n0 View view) {
        int i10 = R.id.area_latency_level;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_setting;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.area_setting_latency;
                ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout != null) {
                    i10 = R.id.area_setting_latency_option;
                    LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R.id.btn_latency_high;
                        FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
                        if (frameLayout != null) {
                            i10 = R.id.btn_latency_low;
                            FrameLayout frameLayout2 = (FrameLayout) j2.c.a(view, i10);
                            if (frameLayout2 != null) {
                                i10 = R.id.btn_latency_middle;
                                FrameLayout frameLayout3 = (FrameLayout) j2.c.a(view, i10);
                                if (frameLayout3 != null) {
                                    i10 = R.id.btn_manual;
                                    TextView textView = (TextView) j2.c.a(view, i10);
                                    if (textView != null) {
                                        i10 = R.id.btn_upgrade;
                                        TextView textView2 = (TextView) j2.c.a(view, i10);
                                        if (textView2 != null) {
                                            i10 = R.id.iv_device;
                                            ImageView imageView = (ImageView) j2.c.a(view, i10);
                                            if (imageView != null) {
                                                i10 = R.id.iv_tech_name;
                                                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                                if (imageView2 != null) {
                                                    i10 = R.id.switch_led;
                                                    ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                                    if (imageView3 != null) {
                                                        i10 = R.id.tv_device_name;
                                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                                        if (textView3 != null) {
                                                            i10 = R.id.tv_latency_level;
                                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                                            if (textView4 != null) {
                                                                i10 = R.id.tv_latency_level_desc;
                                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                                if (textView5 != null) {
                                                                    i10 = R.id.tv_latency_low_hint;
                                                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                                                    if (textView6 != null) {
                                                                        i10 = R.id.tv_setting_latency_hint;
                                                                        TextView textView7 = (TextView) j2.c.a(view, i10);
                                                                        if (textView7 != null) {
                                                                            i10 = R.id.tv_setting_latency_title;
                                                                            TextView textView8 = (TextView) j2.c.a(view, i10);
                                                                            if (textView8 != null) {
                                                                                i10 = R.id.tv_setting_led_hint;
                                                                                TextView textView9 = (TextView) j2.c.a(view, i10);
                                                                                if (textView9 != null) {
                                                                                    i10 = R.id.tv_state;
                                                                                    TextView textView10 = (TextView) j2.c.a(view, i10);
                                                                                    if (textView10 != null) {
                                                                                        i10 = R.id.tv_tech_desc;
                                                                                        TextView textView11 = (TextView) j2.c.a(view, i10);
                                                                                        if (textView11 != null) {
                                                                                            i10 = R.id.tv_tech_name;
                                                                                            TextView textView12 = (TextView) j2.c.a(view, i10);
                                                                                            if (textView12 != null) {
                                                                                                return new j((NestedScrollView) view, linearLayout, linearLayout2, constraintLayout, linearLayout3, frameLayout, frameLayout2, frameLayout3, textView, textView2, imageView, imageView2, imageView3, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static j c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static j d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.cf_fragment_detail_h1, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f30608a;
    }
}
