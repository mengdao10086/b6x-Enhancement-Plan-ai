package xf;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes7.dex */
public abstract class j implements x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f55230b = "j";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f55231a;

    public class a implements ValueCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f55232a;

        public a(ValueCallback valueCallback) {
            this.f55232a = valueCallback;
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            ValueCallback valueCallback = this.f55232a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(str);
            }
        }
    }

    public j(WebView webView) {
        this.f55231a = webView;
    }

    @Override // xf.x
    public void a(String str, ValueCallback<String> valueCallback) {
        g(str, valueCallback);
    }

    @Override // xf.i0
    public void b(String str, String... strArr) {
        d(str, null, strArr);
    }

    @Override // xf.x
    public void c(String str) {
        a(str, null);
    }

    @Override // xf.i0
    public void d(String str, ValueCallback<String> valueCallback, String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript:" + str);
        if (strArr == null || strArr.length == 0) {
            sb2.append("()");
        } else {
            sb2.append(ee.a.f26978c);
            sb2.append(f(strArr));
            sb2.append(ee.a.f26979d);
        }
        a(sb2.toString(), valueCallback);
    }

    @Override // xf.i0
    public void e(String str) {
        b(str, null);
    }

    public final String f(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str = strArr[i10];
            if (com.just.agentweb.a.O(str)) {
                sb2.append(str);
            } else {
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\"");
            }
            if (i10 != strArr.length - 1) {
                sb2.append(" , ");
            }
        }
        return sb2.toString();
    }

    public final void g(String str, ValueCallback<String> valueCallback) {
        this.f55231a.evaluateJavascript(str, new a(valueCallback));
    }

    public final void h(String str) {
        this.f55231a.loadUrl(str);
    }
}
