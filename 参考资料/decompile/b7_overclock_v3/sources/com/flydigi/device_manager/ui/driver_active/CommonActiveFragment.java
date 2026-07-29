package com.flydigi.device_manager.ui.driver_active;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import c7.n0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import i9.a;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class CommonActiveFragment extends FZFragment {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.k
    public static final b f14853t8 = new b(null);

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public static final String f14854u8 = "key_active_type";

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @yt.k
    public static final String f14855v8 = "key_device_code";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f14856o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public n0 f14857p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public c f14858q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public String f14859r8 = DriverActivationActivity.O7;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public String f14860s8 = "all";

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
        public final void open_url(@yt.k String url, @yt.k String title) {
            kotlin.jvm.internal.f0.p(url, "url");
            kotlin.jvm.internal.f0.p(title, "title");
            com.flydigi.base.common.n.b("网页JS传来参数：" + url + zc.f.f58383m + title, new Object[0]);
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, url).withString(DataConstant.WEB_TITLE, title).navigation();
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ CommonActiveFragment b(b bVar, String str, String str2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = "all";
            }
            return bVar.a(str, str2);
        }

        @yt.k
        public final CommonActiveFragment a(@yt.k String activeType, @yt.l String str) {
            kotlin.jvm.internal.f0.p(activeType, "activeType");
            CommonActiveFragment commonActiveFragment = new CommonActiveFragment();
            commonActiveFragment.c5(androidx.core.os.e.b(new Pair("key_active_type", activeType), new Pair("key_device_code", str)));
            return commonActiveFragment;
        }
    }

    public interface c {
        void n();
    }

    public static final class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@yt.l WebView webView, @yt.l String str) {
            super.onPageFinished(webView, str);
            if (CommonActiveFragment.this.f14856o8) {
                return;
            }
            n0 n0Var = CommonActiveFragment.this.f14857p8;
            if (n0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var = null;
            }
            LinearLayout linearLayout = n0Var.f10251g;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.progressBar");
            Boolean bool = Boolean.FALSE;
            o5.c.b(linearLayout, bool, false, 2, null);
            n0 n0Var2 = CommonActiveFragment.this.f14857p8;
            if (n0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var2 = null;
            }
            LinearLayout linearLayout2 = n0Var2.f10246b;
            kotlin.jvm.internal.f0.o(linearLayout2, "viewBinding.areaMessage");
            o5.c.b(linearLayout2, bool, false, 2, null);
            n0 n0Var3 = CommonActiveFragment.this.f14857p8;
            if (n0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var3 = null;
            }
            WebView webView2 = n0Var3.f10255k;
            kotlin.jvm.internal.f0.o(webView2, "viewBinding.viewWeb");
            o5.c.b(webView2, Boolean.TRUE, false, 2, null);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@yt.l WebView webView, @yt.l String str, @yt.l Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            n0 n0Var = CommonActiveFragment.this.f14857p8;
            if (n0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var = null;
            }
            LinearLayout linearLayout = n0Var.f10251g;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.progressBar");
            o5.c.b(linearLayout, Boolean.TRUE, false, 2, null);
            CommonActiveFragment.this.f14856o8 = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@yt.l WebView webView, @yt.l WebResourceRequest webResourceRequest, @yt.l WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            n0 n0Var = CommonActiveFragment.this.f14857p8;
            if (n0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var = null;
            }
            WebView webView2 = n0Var.f10255k;
            kotlin.jvm.internal.f0.o(webView2, "viewBinding.viewWeb");
            Boolean bool = Boolean.FALSE;
            o5.c.b(webView2, bool, false, 2, null);
            n0 n0Var2 = CommonActiveFragment.this.f14857p8;
            if (n0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var2 = null;
            }
            LinearLayout linearLayout = n0Var2.f10251g;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.progressBar");
            o5.c.b(linearLayout, bool, false, 2, null);
            n0 n0Var3 = CommonActiveFragment.this.f14857p8;
            if (n0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var3 = null;
            }
            LinearLayout linearLayout2 = n0Var3.f10246b;
            kotlin.jvm.internal.f0.o(linearLayout2, "viewBinding.areaMessage");
            o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
            CommonActiveFragment.this.f14856o8 = true;
        }
    }

    public static final void j6(CommonActiveFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.i6();
    }

    public static final void k6(CommonActiveFragment this$0, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        c cVar = this$0.f14858q8;
        if (cVar == null) {
            kotlin.jvm.internal.f0.S("listener");
            cVar = null;
        }
        cVar.n();
        dialogFragment.I5();
    }

    public static final void l6(CommonActiveFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        new FZDialog.a().t(this$0.c3(R.string.device_driver_active_reason_title)).j(this$0.c3(R.string.device_driver_active_reason_content)).b(Boolean.FALSE).q(this$0.c3(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.f
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                CommonActiveFragment.m6(dialogFragment);
            }
        }).u(this$0.U1(), LoadingDialogFragment.E8);
    }

    public static final void m6(DialogFragment dialogFragment) {
        if (dialogFragment != null) {
            dialogFragment.I5();
        }
    }

    public static final void n6(CommonActiveFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        n0 n0Var = this$0.f14857p8;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        n0Var.f10255k.reload();
    }

    public static final void o6(CommonActiveFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.p6();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        kotlin.jvm.internal.f0.p(context, "context");
        super.H3(context);
        if (context instanceof c) {
            this.f14858q8 = (c) context;
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString("key_active_type") : null;
        if (string == null) {
            string = DriverActivationActivity.O7;
        }
        this.f14859r8 = string;
        Bundle bundleT12 = T1();
        String string2 = bundleT12 != null ? bundleT12.getString("key_device_code") : null;
        if (string2 == null) {
            string2 = "all";
        }
        this.f14860s8 = string2;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_driver_active_help;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        n0 n0VarD = n0.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(n0VarD, "inflate(inflater, container, false)");
        this.f14857p8 = n0VarD;
        if (n0VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0VarD = null;
        }
        LinearLayout root = n0VarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        i6();
    }

    public final void i6() {
        if (o5.b.a(X1())) {
            H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.h
                @Override // java.lang.Runnable
                public final void run() {
                    CommonActiveFragment.j6(this.f14887a);
                }
            }, 1000L);
        } else {
            new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.device_driver_active_failure_cause_by_permission)).b(Boolean.FALSE).q(c3(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.e
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    CommonActiveFragment.k6(this.f14881a, dialogFragment);
                }
            }).u(U1(), LoadingDialogFragment.E8);
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        n0 n0Var = this.f14857p8;
        n0 n0Var2 = null;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        com.blankj.utilcode.util.o.r(n0Var.f10247c, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonActiveFragment.l6(this.f14879a, view2);
            }
        });
        n0 n0Var3 = this.f14857p8;
        if (n0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var3 = null;
        }
        n0Var3.f10255k.getSettings().setDomStorageEnabled(true);
        n0 n0Var4 = this.f14857p8;
        if (n0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var4 = null;
        }
        n0Var4.f10255k.getSettings().setDatabaseEnabled(true);
        n0 n0Var5 = this.f14857p8;
        if (n0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var5 = null;
        }
        n0Var5.f10255k.getSettings().setJavaScriptEnabled(true);
        n0 n0Var6 = this.f14857p8;
        if (n0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var6 = null;
        }
        n0Var6.f10255k.getSettings().setCacheMode(1);
        n0 n0Var7 = this.f14857p8;
        if (n0Var7 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var7 = null;
        }
        n0Var7.f10255k.addJavascriptInterface(new a(), l4.f.f39447b);
        n0 n0Var8 = this.f14857p8;
        if (n0Var8 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var8 = null;
        }
        n0Var8.f10255k.setWebViewClient(new d());
        n0 n0Var9 = this.f14857p8;
        if (n0Var9 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            n0Var2 = n0Var9;
        }
        com.blankj.utilcode.util.o.r(n0Var2.f10246b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonActiveFragment.n6(this.f14877a, view2);
            }
        });
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.g
            @Override // java.lang.Runnable
            public final void run() {
                CommonActiveFragment.o6(this.f14885a);
            }
        });
    }

    public final void p6() {
        n0 n0Var = this.f14857p8;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        n0Var.f10255k.loadUrl("https://bbs.flydigi.com/activate/index.html?active_type=" + this.f14859r8 + "&lang=" + m5.f0.f40651g + "&device_type=" + this.f14860s8 + "&manufacture=" + com.blankj.utilcode.util.x.j() + "&model=" + com.blankj.utilcode.util.x.k());
    }
}
