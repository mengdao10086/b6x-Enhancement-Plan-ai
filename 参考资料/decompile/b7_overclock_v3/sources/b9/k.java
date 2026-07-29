package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f9205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f9206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f9207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ProgressBar f9208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinearLayout f9209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f9210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f9211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final WebView f9212h;

    public k(@n0 FrameLayout frameLayout, @n0 LinearLayout linearLayout, @n0 ImageView imageView, @n0 ProgressBar progressBar, @n0 LinearLayout linearLayout2, @n0 TextView textView, @n0 TextView textView2, @n0 WebView webView) {
        this.f9205a = frameLayout;
        this.f9206b = linearLayout;
        this.f9207c = imageView;
        this.f9208d = progressBar;
        this.f9209e = linearLayout2;
        this.f9210f = textView;
        this.f9211g = textView2;
        this.f9212h = webView;
    }

    @n0
    public static k a(@n0 View view) {
        int i10 = R.id.area_message;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, R.id.area_message);
        if (linearLayout != null) {
            i10 = R.id.iv_message;
            ImageView imageView = (ImageView) j2.c.a(view, R.id.iv_message);
            if (imageView != null) {
                i10 = R.id.pb_loading;
                ProgressBar progressBar = (ProgressBar) j2.c.a(view, R.id.pb_loading);
                if (progressBar != null) {
                    i10 = R.id.progress_bar;
                    LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, R.id.progress_bar);
                    if (linearLayout2 != null) {
                        i10 = R.id.tv_error_tip;
                        TextView textView = (TextView) j2.c.a(view, R.id.tv_error_tip);
                        if (textView != null) {
                            i10 = R.id.tv_loading;
                            TextView textView2 = (TextView) j2.c.a(view, R.id.tv_loading);
                            if (textView2 != null) {
                                i10 = R.id.view_web;
                                WebView webView = (WebView) j2.c.a(view, R.id.view_web);
                                if (webView != null) {
                                    return new k((FrameLayout) view, linearLayout, imageView, progressBar, linearLayout2, textView, textView2, webView);
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
    public static k c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static k d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_fragment_customer_service, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9205a;
    }
}
