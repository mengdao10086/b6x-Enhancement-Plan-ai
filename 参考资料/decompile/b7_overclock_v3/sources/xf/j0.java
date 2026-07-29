package xf;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes7.dex */
public class j0 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f55234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f55235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f55236c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f55237a;

        public a(String str) {
            this.f55237a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.g(this.f55237a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.a();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.a();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f55241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f55242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f55243c;

        public d(String str, String str2, String str3) {
            this.f55241a = str;
            this.f55242b = str2;
            this.f55243c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.b(this.f55241a, this.f55242b, this.f55243c);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.f();
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f55246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f55247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f55248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f55249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55250e;

        public f(String str, String str2, String str3, String str4, String str5) {
            this.f55246a = str;
            this.f55247b = str2;
            this.f55248c = str3;
            this.f55249d = str4;
            this.f55250e = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.d(this.f55246a, this.f55247b, this.f55248c, this.f55249d, this.f55250e);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f55252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f55253b;

        public g(String str, byte[] bArr) {
            this.f55252a = str;
            this.f55253b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.c(this.f55252a, this.f55253b);
        }
    }

    public j0(WebView webView, o oVar) {
        this.f55234a = null;
        this.f55235b = webView;
        this.f55236c = oVar;
        this.f55234a = new Handler(Looper.getMainLooper());
    }

    @Override // xf.r
    public void a() {
        if (com.just.agentweb.a.R()) {
            this.f55235b.reload();
        } else {
            this.f55234a.post(new c());
        }
    }

    @Override // xf.r
    public void b(String str, String str2, String str3) {
        if (com.just.agentweb.a.R()) {
            this.f55235b.loadData(str, str2, str3);
        } else {
            this.f55234a.post(new d(str, str2, str3));
        }
    }

    @Override // xf.r
    public void c(String str, byte[] bArr) {
        if (com.just.agentweb.a.R()) {
            this.f55235b.postUrl(str, bArr);
        } else {
            this.f55234a.post(new g(str, bArr));
        }
    }

    @Override // xf.r
    public void d(String str, String str2, String str3, String str4, String str5) {
        if (com.just.agentweb.a.R()) {
            this.f55235b.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f55234a.post(new f(str, str2, str3, str4, str5));
        }
    }

    @Override // xf.r
    public o e() {
        o oVar = this.f55236c;
        if (oVar != null) {
            return oVar;
        }
        o oVarB = o.b();
        this.f55236c = oVarB;
        return oVarB;
    }

    @Override // xf.r
    public void f() {
        if (com.just.agentweb.a.R()) {
            this.f55235b.stopLoading();
        } else {
            this.f55234a.post(new e());
        }
    }

    @Override // xf.r
    public void g(String str) {
        if (!com.just.agentweb.a.R()) {
            h(str);
            return;
        }
        o oVar = this.f55236c;
        if (oVar == null || oVar.d()) {
            this.f55235b.loadUrl(str);
        } else {
            this.f55235b.loadUrl(str, this.f55236c.c());
        }
    }

    public final void h(String str) {
        this.f55234a.post(new a(str));
    }

    public final void i() {
        this.f55234a.post(new b());
    }
}
