package xf;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class k0 implements s, n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f55262g = "k0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f55263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f55264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<androidx.core.util.k<Integer, Integer>> f55265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f55266d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f55267e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f55268f;

    public k0(Activity activity, WebView webView) {
        this.f55265c = null;
        this.f55263a = activity;
        this.f55264b = webView;
        this.f55265c = new HashSet();
    }

    @Override // xf.s
    public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = this.f55263a;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.setRequestedOrientation(0);
        Window window = activity.getWindow();
        if ((window.getAttributes().flags & 128) == 0) {
            androidx.core.util.k<Integer, Integer> kVar = new androidx.core.util.k<>(128, 0);
            window.setFlags(128, 128);
            this.f55265c.add(kVar);
        }
        if ((window.getAttributes().flags & 16777216) == 0) {
            androidx.core.util.k<Integer, Integer> kVar2 = new androidx.core.util.k<>(16777216, 0);
            window.setFlags(16777216, 16777216);
            this.f55265c.add(kVar2);
        }
        if (this.f55266d != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        WebView webView = this.f55264b;
        if (webView != null) {
            webView.setVisibility(8);
        }
        if (this.f55267e == null) {
            FrameLayout frameLayout = (FrameLayout) activity.getWindow().getDecorView();
            FrameLayout frameLayout2 = new FrameLayout(activity);
            this.f55267e = frameLayout2;
            frameLayout2.setBackgroundColor(-16777216);
            frameLayout.addView(this.f55267e);
        }
        this.f55268f = customViewCallback;
        ViewGroup viewGroup = this.f55267e;
        this.f55266d = view;
        viewGroup.addView(view);
        this.f55267e.setVisibility(0);
    }

    @Override // xf.s
    public boolean b() {
        return this.f55266d != null;
    }

    @Override // xf.n
    public boolean c() {
        if (!b()) {
            return false;
        }
        d();
        return true;
    }

    @Override // xf.s
    public void d() {
        View view;
        if (this.f55266d == null) {
            return;
        }
        Activity activity = this.f55263a;
        if (activity != null && activity.getRequestedOrientation() != 1) {
            this.f55263a.setRequestedOrientation(1);
        }
        if (!this.f55265c.isEmpty()) {
            for (androidx.core.util.k<Integer, Integer> kVar : this.f55265c) {
                this.f55263a.getWindow().setFlags(kVar.f4742b.intValue(), kVar.f4741a.intValue());
            }
            this.f55265c.clear();
        }
        this.f55266d.setVisibility(8);
        ViewGroup viewGroup = this.f55267e;
        if (viewGroup != null && (view = this.f55266d) != null) {
            viewGroup.removeView(view);
        }
        ViewGroup viewGroup2 = this.f55267e;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.f55268f;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.f55266d = null;
        WebView webView = this.f55264b;
        if (webView != null) {
            webView.setVisibility(0);
        }
    }
}
