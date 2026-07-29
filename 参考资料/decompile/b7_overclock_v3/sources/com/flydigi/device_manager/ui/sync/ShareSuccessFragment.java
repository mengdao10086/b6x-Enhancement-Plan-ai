package com.flydigi.device_manager.ui.sync;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import c7.o1;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.base.common.FZFragment;
import com.flydigi.device_manager.R;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class ShareSuccessFragment extends FZFragment {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public static final a f15393p8 = new a(null);

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public static final String f15394q8 = "key_game_name";

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public static final String f15395r8 = "key_code";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public o1 f15396o8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final ShareSuccessFragment a(@yt.k String gameName, @yt.k String code) {
            kotlin.jvm.internal.f0.p(gameName, "gameName");
            kotlin.jvm.internal.f0.p(code, "code");
            ShareSuccessFragment shareSuccessFragment = new ShareSuccessFragment();
            shareSuccessFragment.c5(androidx.core.os.e.b(new Pair("key_game_name", gameName), new Pair("key_code", code)));
            return shareSuccessFragment;
        }
    }

    @hk.m
    @yt.k
    public static final ShareSuccessFragment a6(@yt.k String str, @yt.k String str2) {
        return f15393p8.a(str, str2);
    }

    public static final void b6(ShareSuccessFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Bundle bundleT1 = this$0.T1();
        com.blankj.utilcode.util.p.c(bundleT1 != null ? bundleT1.getString("key_code") : null);
        ToastUtils.T(R.string.link_copied);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_share_success;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        o1 o1VarA = o1.a(view);
        kotlin.jvm.internal.f0.o(o1VarA, "bind(view)");
        this.f15396o8 = o1VarA;
        o1 o1Var = null;
        if (o1VarA == null) {
            kotlin.jvm.internal.f0.S("binding");
            o1VarA = null;
        }
        TextView textView = o1VarA.f10309d;
        int i10 = R.string.device_cloud_sync_share_game_name;
        Object[] objArr = new Object[1];
        Bundle bundleT1 = T1();
        objArr[0] = bundleT1 != null ? bundleT1.getString("key_game_name") : null;
        textView.setText(d3(i10, objArr));
        o1 o1Var2 = this.f15396o8;
        if (o1Var2 == null) {
            kotlin.jvm.internal.f0.S("binding");
            o1Var2 = null;
        }
        TextView textView2 = o1Var2.f10312g;
        int i11 = R.string.device_cloud_sync_share_code;
        Object[] objArr2 = new Object[1];
        Bundle bundleT12 = T1();
        objArr2[0] = bundleT12 != null ? bundleT12.getString("key_code") : null;
        textView2.setText(d3(i11, objArr2));
        o1 o1Var3 = this.f15396o8;
        if (o1Var3 == null) {
            kotlin.jvm.internal.f0.S("binding");
        } else {
            o1Var = o1Var3;
        }
        com.blankj.utilcode.util.o.r(o1Var.f10307b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareSuccessFragment.b6(this.f15437a, view2);
            }
        });
    }
}
