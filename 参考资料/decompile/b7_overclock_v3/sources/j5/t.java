package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f36147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f36148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f36149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ImageView f36150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ImageView f36151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final LinearLayout f36152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final LinearLayout f36153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f36154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f36155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextView f36156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final TextView f36157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final TextView f36158l;

    public t(@n0 FrameLayout frameLayout, @n0 LinearLayout linearLayout, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 ImageView imageView3, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4, @n0 TextView textView5) {
        this.f36147a = frameLayout;
        this.f36148b = linearLayout;
        this.f36149c = imageView;
        this.f36150d = imageView2;
        this.f36151e = imageView3;
        this.f36152f = linearLayout2;
        this.f36153g = linearLayout3;
        this.f36154h = textView;
        this.f36155i = textView2;
        this.f36156j = textView3;
        this.f36157k = textView4;
        this.f36158l = textView5;
    }

    @n0
    public static t a(@n0 View view) {
        int i10 = R.id.cb_no_more_notice;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.iv_checkbox;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_close;
                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.iv_content;
                    ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                    if (imageView3 != null) {
                        i10 = R.id.ll_double;
                        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R.id.ll_ok;
                            LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                            if (linearLayout3 != null) {
                                i10 = R.id.tv_cancel;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_confirm;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_content;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.tv_ok;
                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                            if (textView4 != null) {
                                                i10 = R.id.tv_title;
                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                if (textView5 != null) {
                                                    return new t((FrameLayout) view, linearLayout, imageView, imageView2, imageView3, linearLayout2, linearLayout3, textView, textView2, textView3, textView4, textView5);
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
    public static t c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static t d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fz_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f36147a;
    }
}
