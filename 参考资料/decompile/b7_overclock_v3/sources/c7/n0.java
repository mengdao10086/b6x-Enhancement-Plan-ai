package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class n0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f10247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Button f10248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f10249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ProgressBar f10250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final WebView f10255k;

    public n0(@g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 SuperButton superButton, @g.n0 Button button, @g.n0 ImageView imageView, @g.n0 ProgressBar progressBar, @g.n0 LinearLayout linearLayout3, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 WebView webView) {
        this.f10245a = linearLayout;
        this.f10246b = linearLayout2;
        this.f10247c = superButton;
        this.f10248d = button;
        this.f10249e = imageView;
        this.f10250f = progressBar;
        this.f10251g = linearLayout3;
        this.f10252h = textView;
        this.f10253i = textView2;
        this.f10254j = textView3;
        this.f10255k = webView;
    }

    @g.n0
    public static n0 a(@g.n0 View view) {
        int i10 = R.id.area_message;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.btn_help;
            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
            if (superButton != null) {
                i10 = R.id.btn_open_permission;
                Button button = (Button) j2.c.a(view, i10);
                if (button != null) {
                    i10 = R.id.iv_message;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.pb_loading;
                        ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
                        if (progressBar != null) {
                            i10 = R.id.progress_bar;
                            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R.id.tv_error_tip;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_hint;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_loading;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.view_web;
                                            WebView webView = (WebView) j2.c.a(view, i10);
                                            if (webView != null) {
                                                return new n0((LinearLayout) view, linearLayout, superButton, button, imageView, progressBar, linearLayout2, textView, textView2, textView3, webView);
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
    public static n0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static n0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_driver_active_help, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10245a;
    }
}
