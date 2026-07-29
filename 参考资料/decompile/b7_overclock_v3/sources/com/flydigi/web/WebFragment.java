package com.flydigi.web;

import a5.f;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.flydigi.base.R;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.just.agentweb.AgentWeb;
import com.tencent.connect.common.Constants;
import g.p0;
import i9.a;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public class WebFragment extends FZFragment {

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static final String f16417w8 = "key_source";

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public static final int f16418x8 = 10000;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public String f16419o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public String f16420p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public String f16421q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public String f16422r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public AgentWeb f16423s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public d f16424t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public ValueCallback<Uri> f16425u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public ValueCallback<Uri[]> f16426v8;

    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
            if (WebFragment.this.f16424t8 != null) {
                WebFragment.this.f16424t8.C(icon);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (WebFragment.this.f16424t8 != null) {
                WebFragment.this.f16424t8.t1(title);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebFragment.this.f16426v8 = filePathCallback;
            WebFragment.this.h6();
            return true;
        }
    }

    public static class c {
        public c() {
        }

        @JavascriptInterface
        public void contact_cs() {
            if (f.i().o()) {
                u9.b.p(7, "网页", "support");
            } else {
                h3.a.j().d(a.C0378a.f31905b).navigation();
            }
        }

        @JavascriptInterface
        public void open_url(String url, String title) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, url).withString(DataConstant.WEB_TITLE, title).navigation();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public interface d {
        void C(Bitmap icon);

        void t1(String title);
    }

    public static WebFragment e6(String url) {
        return f6(url, Constants.JumpUrlConstants.SRC_TYPE_APP);
    }

    public static WebFragment f6(String url, String source) {
        WebFragment webFragment = new WebFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DataConstant.WEB_URL, url);
        bundle.putString(f16417w8, source);
        webFragment.c5(bundle);
        return webFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void F3(int requestCode, int resultCode, Intent data) {
        super.F3(requestCode, resultCode, data);
        if (requestCode == 10000) {
            if (this.f16425u8 == null && this.f16426v8 == null) {
                return;
            }
            Uri data2 = (data == null || resultCode != -1) ? null : data.getData();
            if (this.f16426v8 != null) {
                g6(requestCode, resultCode, data);
                return;
            }
            ValueCallback<Uri> valueCallback = this.f16425u8;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(data2);
                this.f16425u8 = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        super.H3(context);
        if (context instanceof d) {
            this.f16424t8 = (d) context;
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 final Bundle savedInstanceState) {
        super.K3(savedInstanceState);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.f16419o8 = bundleT1.getString(DataConstant.WEB_URL);
            this.f16420p8 = bundleT1.getString(f16417w8);
        } else {
            this.f13317d8.finish();
        }
        this.f16421q8 = f.i().k();
        this.f16422r8 = f.i().l();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.base_fragment_web;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void R3() {
        AgentWeb agentWeb = this.f16423s8;
        if (agentWeb != null) {
            agentWeb.t().a();
        }
        super.R3();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.flydigi.base.common.t
    public boolean V() {
        i6();
        return true;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        AgentWeb agentWeb = this.f16423s8;
        if (agentWeb != null) {
            agentWeb.t().b();
        }
        super.a4();
    }

    public final String d6() {
        String str;
        String str2 = this.f16419o8;
        if (!str2.toLowerCase().contains("flydigi") && !this.f16419o8.toLowerCase().contains("feizhi")) {
            return str2;
        }
        if (this.f16419o8.contains("?")) {
            str = this.f16419o8 + "&";
        } else {
            str = this.f16419o8 + "?";
        }
        return str + "source=" + this.f16420p8 + "&token=" + this.f16421q8 + "&uid=" + this.f16422r8;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        AgentWeb agentWeb = this.f16423s8;
        if (agentWeb != null) {
            agentWeb.t().d();
        }
        super.f4();
    }

    @TargetApi(21)
    public final void g6(int requestCode, int resultCode, Intent intent) {
        Uri[] uriArr;
        if (requestCode != 10000 || this.f16426v8 == null) {
            return;
        }
        if (resultCode != -1 || intent == null) {
            uriArr = null;
        } else {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                uriArr = new Uri[clipData.getItemCount()];
                for (int i10 = 0; i10 < clipData.getItemCount(); i10++) {
                    uriArr[i10] = clipData.getItemAt(i10).getUri();
                }
            } else {
                uriArr = null;
            }
            if (dataString != null) {
                uriArr = new Uri[]{Uri.parse(dataString)};
            }
        }
        this.f16426v8.onReceiveValue(uriArr);
        this.f16426v8 = null;
    }

    public final void h6() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        z5(Intent.createChooser(intent, "Image Chooser"), 10000);
    }

    public final void i6() {
        AgentWeb agentWeb = this.f16423s8;
        if (agentWeb == null) {
            this.f13317d8.finish();
        } else {
            if (agentWeb.c()) {
                return;
            }
            this.f13317d8.finish();
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle savedInstanceState) {
        super.j4(view, savedInstanceState);
        FrameLayout frameLayout = (FrameLayout) F5(R.id.web_container);
        a aVar = new a();
        AgentWeb agentWebA = AgentWeb.A(this).l0(frameLayout, new FrameLayout.LayoutParams(-1, -1)).d(R.color.colorAccent).m(AgentWeb.SecurityType.STRICT_CHECK).q(aVar).n(new b()).a(l4.f.f39447b, new c(null)).d().b().a(d6());
        this.f16423s8 = agentWebA;
        agentWebA.i().d().setSavePassword(false);
    }

    public void j6() {
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.f16419o8 = bundleT1.getString(DataConstant.WEB_URL);
            this.f16420p8 = bundleT1.getString(f16417w8);
            this.f16423s8.r().g(d6());
        }
    }

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return url.endsWith(".apk") ? o5.f.f(WebFragment.this.f13317d8, url) : super.shouldOverrideUrlLoading(view, url);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView view, final WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
