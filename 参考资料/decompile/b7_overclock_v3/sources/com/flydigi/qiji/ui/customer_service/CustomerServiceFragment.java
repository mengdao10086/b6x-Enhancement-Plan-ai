package com.flydigi.qiji.ui.customer_service;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.o;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.common.n;
import com.flydigi.data.DataConstant;
import hk.m;
import i9.a;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nCustomerServiceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomerServiceFragment.kt\ncom/flydigi/qiji/ui/customer_service/CustomerServiceFragment\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,209:1\n26#2:210\n*S KotlinDebug\n*F\n+ 1 CustomerServiceFragment.kt\ncom/flydigi/qiji/ui/customer_service/CustomerServiceFragment\n*L\n159#1:210\n*E\n"})
public final class CustomerServiceFragment extends FZFragment {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @k
    public static final b f16101t8 = new b(null);

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final int f16102u8 = 10000;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public b9.k f16103o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public String f16104p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @l
    public ValueCallback<Uri[]> f16105q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public boolean f16106r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public boolean f16107s8;

    public static final class a {
        @JavascriptInterface
        public final void contact_cs() {
            if (a5.f.i().o()) {
                u9.b.p(7, "网页", "support");
            } else {
                h3.a.j().d(a.C0378a.f31905b).navigation();
            }
        }

        @JavascriptInterface
        public final void open_url(@k String url, @k String title) {
            f0.p(url, "url");
            f0.p(title, "title");
            n.b("网页JS传来参数：" + url + zc.f.f58383m + title, new Object[0]);
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, url).withString(DataConstant.WEB_TITLE, title).navigation();
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @m
        @k
        public final CustomerServiceFragment a(@l String str) {
            CustomerServiceFragment customerServiceFragment = new CustomerServiceFragment();
            customerServiceFragment.c5(androidx.core.os.e.b(new Pair(DataConstant.WEB_URL, str)));
            return customerServiceFragment;
        }
    }

    public static final class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@l WebView webView, @l String str) {
            super.onPageFinished(webView, str);
            if (CustomerServiceFragment.this.f16106r8) {
                return;
            }
            LinearLayout linearLayout = CustomerServiceFragment.this.k6().f9209e;
            f0.o(linearLayout, "viewBinding.progressBar");
            Boolean bool = Boolean.FALSE;
            o5.c.b(linearLayout, bool, false, 2, null);
            LinearLayout linearLayout2 = CustomerServiceFragment.this.k6().f9206b;
            f0.o(linearLayout2, "viewBinding.areaMessage");
            o5.c.b(linearLayout2, bool, false, 2, null);
            WebView webView2 = CustomerServiceFragment.this.k6().f9212h;
            f0.o(webView2, "viewBinding.viewWeb");
            o5.c.b(webView2, Boolean.TRUE, false, 2, null);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@l WebView webView, @l String str, @l Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            LinearLayout linearLayout = CustomerServiceFragment.this.k6().f9209e;
            f0.o(linearLayout, "viewBinding.progressBar");
            o5.c.b(linearLayout, Boolean.TRUE, false, 2, null);
            CustomerServiceFragment.this.f16106r8 = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@l WebView webView, @l WebResourceRequest webResourceRequest, @l WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            WebView webView2 = CustomerServiceFragment.this.k6().f9212h;
            f0.o(webView2, "viewBinding.viewWeb");
            Boolean bool = Boolean.FALSE;
            o5.c.b(webView2, bool, false, 2, null);
            LinearLayout linearLayout = CustomerServiceFragment.this.k6().f9209e;
            f0.o(linearLayout, "viewBinding.progressBar");
            o5.c.b(linearLayout, bool, false, 2, null);
            LinearLayout linearLayout2 = CustomerServiceFragment.this.k6().f9206b;
            f0.o(linearLayout2, "viewBinding.areaMessage");
            o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
            CustomerServiceFragment.this.f16106r8 = true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@k WebView view, @k String url) {
            f0.p(view, "view");
            f0.p(url, "url");
            CustomerServiceFragment.this.f16107s8 = false;
            if (kotlin.text.u.K1(url, ".apk", false, 2, null)) {
                return o5.f.f(CustomerServiceFragment.this.f13317d8, url);
            }
            if (!kotlin.text.u.v2(url, "https://cloud.dtyunxi.com/iservice-visitor-web-h5/index.html", false, 2, null) && !kotlin.text.u.v2(url, "https://cloud.dtyunxi.com/iservice-visitor-web-h5/index.html", false, 2, null)) {
                return super.shouldOverrideUrlLoading(view, url);
            }
            if (a5.f.i().o()) {
                CustomerServiceFragment.this.f16107s8 = true;
                return super.shouldOverrideUrlLoading(view, url);
            }
            h3.a.j().d(a.C0378a.f31905b).navigation();
            return true;
        }
    }

    public static final class d extends WebChromeClient {
        public d() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(@l WebView webView, @l ValueCallback<Uri[]> valueCallback, @l WebChromeClient.FileChooserParams fileChooserParams) {
            CustomerServiceFragment.this.f16105q8 = valueCallback;
            CustomerServiceFragment.this.o6();
            return true;
        }
    }

    @m
    @k
    public static final CustomerServiceFragment i6(@l String str) {
        return f16101t8.a(str);
    }

    public static final void l6(CustomerServiceFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.k6().f9212h.reload();
    }

    public static final void m6(CustomerServiceFragment this$0, int i10) {
        f0.p(this$0, "this$0");
        if (i10 > 0) {
            this$0.k6().f9212h.evaluateJavascript("window.localStorage.getItem('sessionId')", new ValueCallback() { // from class: com.flydigi.qiji.ui.customer_service.h
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    CustomerServiceFragment.n6((String) obj);
                }
            });
        }
    }

    public static final void n6(String str) {
        o5.m.k(DataConstant.SP_APP).B(DataConstant.SP_APP_CUSTOMER_SERVICE_SESSION_ID, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void F3(int i10, int i11, @l Intent intent) {
        super.F3(i10, i11, intent);
        if (i10 != 10000 || this.f16105q8 == null) {
            return;
        }
        if (i11 == -1) {
            Uri[] uriArr = new Uri[0];
            if (intent != null) {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i12 = 0; i12 < itemCount; i12++) {
                        Uri uri = clipData.getItemAt(i12).getUri();
                        f0.o(uri, "item.uri");
                        uriArr[i12] = uri;
                    }
                }
                if (dataString != null) {
                    Uri uri2 = Uri.parse(dataString);
                    f0.o(uri2, "parse(dataString)");
                    uriArr = new Uri[]{uri2};
                }
            }
            ValueCallback<Uri[]> valueCallback = this.f16105q8;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(uriArr);
            }
        }
        this.f16105q8 = null;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString(DataConstant.WEB_URL) : null;
        if (string == null) {
            string = u9.b.a(0, "", "", 0);
            f0.o(string, "buildCustomerServiceUrl(0, \"\", \"\", 0)");
        }
        p6(string);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_fragment_customer_service;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        b9.k kVarD = b9.k.d(inflater, viewGroup, false);
        f0.o(kVarD, "inflate(inflater, container, false)");
        q6(kVarD);
        FrameLayout root = k6().getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        k6().f9212h.setWebViewClient(new c());
        k6().f9212h.setWebChromeClient(new d());
        k6().f9212h.getSettings().setDomStorageEnabled(true);
        k6().f9212h.getSettings().setDatabaseEnabled(true);
        k6().f9212h.getSettings().setJavaScriptEnabled(true);
        k6().f9212h.addJavascriptInterface(new a(), l4.f.f39447b);
        o.r(k6().f9206b, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.customer_service.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CustomerServiceFragment.l6(this.f16116a, view2);
            }
        });
        k6().f9212h.loadUrl(j6());
        androidx.fragment.app.g gVarW1 = w1();
        if (gVarW1 != null) {
            KeyboardUtils.o(gVarW1, new KeyboardUtils.c() { // from class: com.flydigi.qiji.ui.customer_service.i
                @Override // com.blankj.utilcode.util.KeyboardUtils.c
                public final void a(int i10) {
                    CustomerServiceFragment.m6(this.f16118a, i10);
                }
            });
        }
    }

    @k
    public final String j6() {
        String str = this.f16104p8;
        if (str != null) {
            return str;
        }
        f0.S("url");
        return null;
    }

    @k
    public final b9.k k6() {
        b9.k kVar = this.f16103o8;
        if (kVar != null) {
            return kVar;
        }
        f0.S("viewBinding");
        return null;
    }

    public final void o6() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        z5(Intent.createChooser(intent, "Image Chooser"), 10000);
    }

    public final void p6(@k String str) {
        f0.p(str, "<set-?>");
        this.f16104p8 = str;
    }

    public final void q6(@k b9.k kVar) {
        f0.p(kVar, "<set-?>");
        this.f16103o8 = kVar;
    }
}
