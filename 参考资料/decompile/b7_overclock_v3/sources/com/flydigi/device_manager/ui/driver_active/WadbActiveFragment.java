package com.flydigi.device_manager.ui.driver_active;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import c7.n0;
import com.blankj.utilcode.util.l0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import i9.a;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class WadbActiveFragment extends FZFragment {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.k
    public static final b f14864t8 = new b(null);

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public static final String f14865u8 = "key_active_type";

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @yt.k
    public static final String f14866v8 = "key_device_code";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f14867o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public n0 f14868p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public c f14869q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public String f14870r8 = DriverActivationActivity.O7;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public String f14871s8 = "all";

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

        public static /* synthetic */ WadbActiveFragment b(b bVar, String str, String str2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = "all";
            }
            return bVar.a(str, str2);
        }

        @yt.k
        public final WadbActiveFragment a(@yt.k String activeType, @yt.l String str) {
            kotlin.jvm.internal.f0.p(activeType, "activeType");
            WadbActiveFragment wadbActiveFragment = new WadbActiveFragment();
            wadbActiveFragment.c5(androidx.core.os.e.b(new Pair("key_active_type", activeType), new Pair("key_device_code", str)));
            return wadbActiveFragment;
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
            if (WadbActiveFragment.this.f14867o8) {
                return;
            }
            n0 n0Var = WadbActiveFragment.this.f14868p8;
            if (n0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var = null;
            }
            LinearLayout linearLayout = n0Var.f10251g;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.progressBar");
            Boolean bool = Boolean.FALSE;
            o5.c.b(linearLayout, bool, false, 2, null);
            n0 n0Var2 = WadbActiveFragment.this.f14868p8;
            if (n0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var2 = null;
            }
            LinearLayout linearLayout2 = n0Var2.f10246b;
            kotlin.jvm.internal.f0.o(linearLayout2, "viewBinding.areaMessage");
            o5.c.b(linearLayout2, bool, false, 2, null);
            n0 n0Var3 = WadbActiveFragment.this.f14868p8;
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
            n0 n0Var = WadbActiveFragment.this.f14868p8;
            if (n0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var = null;
            }
            LinearLayout linearLayout = n0Var.f10251g;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.progressBar");
            o5.c.b(linearLayout, Boolean.TRUE, false, 2, null);
            WadbActiveFragment.this.f14867o8 = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@yt.l WebView webView, @yt.l WebResourceRequest webResourceRequest, @yt.l WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            n0 n0Var = WadbActiveFragment.this.f14868p8;
            if (n0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var = null;
            }
            WebView webView2 = n0Var.f10255k;
            kotlin.jvm.internal.f0.o(webView2, "viewBinding.viewWeb");
            Boolean bool = Boolean.FALSE;
            o5.c.b(webView2, bool, false, 2, null);
            n0 n0Var2 = WadbActiveFragment.this.f14868p8;
            if (n0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var2 = null;
            }
            LinearLayout linearLayout = n0Var2.f10251g;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.progressBar");
            o5.c.b(linearLayout, bool, false, 2, null);
            n0 n0Var3 = WadbActiveFragment.this.f14868p8;
            if (n0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                n0Var3 = null;
            }
            LinearLayout linearLayout2 = n0Var3.f10246b;
            kotlin.jvm.internal.f0.o(linearLayout2, "viewBinding.areaMessage");
            o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
            WadbActiveFragment.this.f14867o8 = true;
        }
    }

    public static final void m6(WadbActiveFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.l6();
    }

    public static final void n6(WadbActiveFragment this$0, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        c cVar = this$0.f14869q8;
        if (cVar == null) {
            kotlin.jvm.internal.f0.S("listener");
            cVar = null;
        }
        cVar.n();
        dialogFragment.I5();
    }

    public static final void o6(WadbActiveFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.t6(!o5.b.m(this$0.R4()) ? "enable" : "pair");
    }

    public static final void p6(WadbActiveFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        new FZDialog.a().t(this$0.c3(R.string.device_driver_active_reason_title)).j(this$0.c3(R.string.device_driver_active_reason_content)).b(Boolean.FALSE).q(this$0.c3(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.e0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                WadbActiveFragment.q6(dialogFragment);
            }
        }).u(this$0.U1(), LoadingDialogFragment.E8);
    }

    public static final void q6(DialogFragment dialogFragment) {
        if (dialogFragment != null) {
            dialogFragment.I5();
        }
    }

    public static final void r6(WadbActiveFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        n0 n0Var = this$0.f14868p8;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        n0Var.f10255k.reload();
    }

    public static final void s6(WadbActiveFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (!l0.a()) {
            this$0.u6();
            return;
        }
        if (o5.b.m(this$0.R4())) {
            Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
            kotlin.jvm.internal.f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
            ((IRemoteProvider) objNavigation).n(this$0.R4(), DataConstant.REMOTE_ACTION_WIRELESS_ADB_PAIR, DataConstant.REMOTE_ACTION_WIRELESS_ADB_PAIR, true);
        } else {
            Object objNavigation2 = h3.a.j().d(a.g.f31983b).navigation();
            kotlin.jvm.internal.f0.n(objNavigation2, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
            ((IRemoteProvider) objNavigation2).c(this$0.R4(), DataConstant.FLOAT_WINDOW_ACTION_ENABLE_WIFI_ADB);
        }
        o5.f.g(this$0.R4());
    }

    public static final void v6(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void w6(DialogFragment dialogFragment) {
        dialogFragment.I5();
        if (Build.VERSION.SDK_INT < 26) {
            com.blankj.utilcode.util.a.O0(com.blankj.utilcode.util.f0.m(com.blankj.utilcode.util.d.l()));
            return;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", com.blankj.utilcode.util.d.l());
        intent.putExtra("android.provider.extra.CHANNEL_ID", com.blankj.utilcode.util.d.y());
        com.blankj.utilcode.util.a.O0(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        kotlin.jvm.internal.f0.p(context, "context");
        super.H3(context);
        if (context instanceof c) {
            this.f14869q8 = (c) context;
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
        this.f14870r8 = string;
        Bundle bundleT12 = T1();
        String string2 = bundleT12 != null ? bundleT12.getString("key_device_code") : null;
        if (string2 == null) {
            string2 = "all";
        }
        this.f14871s8 = string2;
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
        this.f14868p8 = n0VarD;
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
        l6();
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.g0
            @Override // java.lang.Runnable
            public final void run() {
                WadbActiveFragment.o6(this.f14886a);
            }
        });
        if (o5.b.m(R4()) && !o5.b.i(R4())) {
            Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
            kotlin.jvm.internal.f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
            ((IRemoteProvider) objNavigation).l(R4(), DataConstant.REMOTE_ACTION_WIRELESS_ADB_ENABLE_NET_ADB);
        } else if (o5.b.i(R4()) && !v5.a.j().m()) {
            Object objNavigation2 = h3.a.j().d(a.g.f31983b).navigation();
            kotlin.jvm.internal.f0.n(objNavigation2, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
            ((IRemoteProvider) objNavigation2).l(R4(), DataConstant.REMOTE_ACTION_START_DRIVER_MANUAL);
        }
        Object objNavigation3 = h3.a.j().d(a.g.f31983b).navigation();
        kotlin.jvm.internal.f0.n(objNavigation3, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation3).n(R4(), DataConstant.REMOTE_ACTION_WIRELESS_ADB_PAIR, DataConstant.REMOTE_ACTION_WIRELESS_ADB_PAIR, false);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        n0 n0Var = this.f14868p8;
        n0 n0Var2 = null;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        com.blankj.utilcode.util.o.r(n0Var.f10247c, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WadbActiveFragment.p6(this.f14946a, view2);
            }
        });
        n0 n0Var3 = this.f14868p8;
        if (n0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var3 = null;
        }
        n0Var3.f10255k.getSettings().setDomStorageEnabled(true);
        n0 n0Var4 = this.f14868p8;
        if (n0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var4 = null;
        }
        n0Var4.f10255k.getSettings().setDatabaseEnabled(true);
        n0 n0Var5 = this.f14868p8;
        if (n0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var5 = null;
        }
        n0Var5.f10255k.getSettings().setJavaScriptEnabled(true);
        n0 n0Var6 = this.f14868p8;
        if (n0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var6 = null;
        }
        n0Var6.f10255k.getSettings().setCacheMode(1);
        n0 n0Var7 = this.f14868p8;
        if (n0Var7 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var7 = null;
        }
        n0Var7.f10255k.addJavascriptInterface(new a(), l4.f.f39447b);
        n0 n0Var8 = this.f14868p8;
        if (n0Var8 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var8 = null;
        }
        n0Var8.f10255k.setWebViewClient(new d());
        n0 n0Var9 = this.f14868p8;
        if (n0Var9 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var9 = null;
        }
        com.blankj.utilcode.util.o.r(n0Var9.f10246b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WadbActiveFragment.r6(this.f14874a, view2);
            }
        });
        n0 n0Var10 = this.f14868p8;
        if (n0Var10 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var10 = null;
        }
        Button button = n0Var10.f10248d;
        kotlin.jvm.internal.f0.o(button, "viewBinding.btnOpenPermission");
        o5.c.b(button, Boolean.TRUE, false, 2, null);
        n0 n0Var11 = this.f14868p8;
        if (n0Var11 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            n0Var2 = n0Var11;
        }
        com.blankj.utilcode.util.o.r(n0Var2.f10248d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WadbActiveFragment.s6(this.f14947a, view2);
            }
        });
    }

    public final void l6() {
        if (o5.b.a(X1())) {
            H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.f0
                @Override // java.lang.Runnable
                public final void run() {
                    WadbActiveFragment.m6(this.f14884a);
                }
            }, 1000L);
        } else {
            new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.device_driver_active_failure_cause_by_permission)).b(Boolean.FALSE).q(c3(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.b0
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    WadbActiveFragment.n6(this.f14876a, dialogFragment);
                }
            }).u(U1(), LoadingDialogFragment.E8);
        }
    }

    public final void t6(String str) {
        n0 n0Var = this.f14868p8;
        if (n0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            n0Var = null;
        }
        n0Var.f10255k.loadUrl("https://bbs.flydigi.com/activate/index.html?active_type=" + this.f14870r8 + "&lang=" + m5.f0.f40651g + "&device_type=" + this.f14871s8 + "&manufacture=" + com.blankj.utilcode.util.x.j() + "&model=" + com.blankj.utilcode.util.x.k() + "&step=" + str);
    }

    public final void u6() {
        new FZDialog.a().t(d3(R.string.base_request_permission, c3(R.string.device_notification_permission))).j(c3(R.string.device_notification_permission_reason)).b(Boolean.FALSE).d(c3(R.string.cancel)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.c0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                WadbActiveFragment.v6(dialogFragment);
            }
        }).g(c3(R.string.device_setting_now)).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.driver_active.d0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                WadbActiveFragment.w6(dialogFragment);
            }
        }).a().Z5(U1(), "notification");
    }
}
