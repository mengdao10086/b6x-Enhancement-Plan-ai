package xf;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes7.dex */
public class y extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f55297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f55298d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f55299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f55300b;

        public a(String str, ValueCallback valueCallback) {
            this.f55299a = str;
            this.f55300b = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.a(this.f55299a, this.f55300b);
        }
    }

    public y(WebView webView) {
        super(webView);
        this.f55298d = new Handler(Looper.getMainLooper());
        this.f55297c = webView;
    }

    public static y j(WebView webView) {
        return new y(webView);
    }

    @Override // xf.j, xf.x
    public void a(String str, ValueCallback<String> valueCallback) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            i(str, valueCallback);
        } else {
            super.a(str, valueCallback);
        }
    }

    public final void i(String str, ValueCallback valueCallback) {
        this.f55298d.post(new a(str, valueCallback));
    }
}
