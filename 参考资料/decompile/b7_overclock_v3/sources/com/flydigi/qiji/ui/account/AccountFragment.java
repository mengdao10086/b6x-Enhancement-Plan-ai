package com.flydigi.qiji.ui.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.n0;
import com.fdg.flashplay.farsef.R;
import com.flydigi.account.ui.user.ProfileNewActivity;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.base.ui.StoragePermissionRequestActivity;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.OperateView;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.UpdateInfoBean;
import com.flydigi.data.event.BadgeEvent;
import com.flydigi.data.event.FZAccountLoginChangeEvent;
import com.flydigi.qiji.ui.UpdateDialog;
import com.tencent.connect.common.Constants;
import f.b;
import i9.a;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.v0;
import m5.c0;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AccountFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.k
    public static final a f16047t8 = new a(null);

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.l
    public b9.u f16048p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @hk.e
    @yt.l
    public UpdateInfoBean f16049q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.l
    public UpdateDialog f16050r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f16051s8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final AccountFragment a() {
            return new MainAccountFragment();
        }
    }

    public static final class b extends m5.c<BaseResponse<UpdateInfoBean>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f16053b;

        public b(boolean z10) {
            this.f16053b = z10;
        }

        @Override // m5.c
        public void c(boolean z10) {
            if (this.f16053b) {
                if (!z10) {
                    AccountFragment.this.E0();
                } else {
                    AccountFragment accountFragment = AccountFragment.this;
                    accountFragment.x(accountFragment.c3(R.string.app_check_updating), true);
                }
            }
        }

        @Override // m5.c
        public void d(@yt.k BaseResponse<UpdateInfoBean> updateInfoBeanBaseResponse) {
            f0.p(updateInfoBeanBaseResponse, "updateInfoBeanBaseResponse");
            UpdateInfoBean updateInfoBean = updateInfoBeanBaseResponse.data;
            if (updateInfoBean != null) {
                AccountFragment accountFragment = AccountFragment.this;
                UpdateInfoBean updateInfoBean2 = updateInfoBean;
                accountFragment.f16049q8 = updateInfoBean2;
                accountFragment.y6(updateInfoBean2, this.f16053b);
            }
        }

        @Override // m5.c, xi.g0
        public void onError(@yt.k Throwable throwable) {
            f0.p(throwable, "throwable");
            super.onError(throwable);
        }
    }

    public AccountFragment() {
        androidx.activity.result.g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.qiji.ui.account.f
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                AccountFragment.S6(this.f16060a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP1, "registerForActivityResul…)\n            }\n        }");
        this.f16051s8 = gVarP1;
    }

    public static final void A6(androidx.appcompat.app.j obj) {
        f0.p(obj, "obj");
        obj.dismiss();
    }

    public static final void B6(AccountFragment this$0, androidx.appcompat.app.j dialog) {
        f0.p(this$0, "this$0");
        f0.p(dialog, "dialog");
        dialog.dismiss();
        this$0.U6();
    }

    @hk.m
    @yt.k
    public static final AccountFragment C6() {
        return f16047t8.a();
    }

    public static final void D6(View view) {
        if (a5.f.i().o()) {
            h3.a.j().d(a.b.f31923h).navigation();
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    public static final void E6(AccountFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (!a5.f.i().o()) {
            h3.a.j().d(a.C0378a.f31905b).navigation();
            return;
        }
        Context contextR4 = this$0.R4();
        f0.o(contextR4, "requireContext()");
        if (n5.c.c(contextR4)) {
            h3.a.j().d(a.d.f31958n).navigation();
            return;
        }
        androidx.activity.result.g<Intent> gVar = this$0.f16051s8;
        StoragePermissionRequestActivity.a aVar = StoragePermissionRequestActivity.f13377k0;
        Context contextR42 = this$0.R4();
        f0.o(contextR42, "requireContext()");
        gVar.b(StoragePermissionRequestActivity.a.b(aVar, contextR42, null, 2, null));
    }

    public static final void F6(View view) {
        h3.a.j().d(a.d.f31957m).navigation();
    }

    public static final void G6(View view) {
        h3.a.j().d(a.i.f31988c).navigation();
    }

    public static final void H6(View view) {
        h3.a.j().d(a.i.f31989d).navigation();
    }

    public static final void I6(AccountFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.w6(true);
    }

    public static final void J6(View view, View view2) {
        view.setVisibility(8);
        o5.m.k(DataConstant.SP_APP).F(DataConstant.SP_APP_SHOW_WECHAT_OFFICIAL_ACCOUNT_FOLLOW_HINT, false);
    }

    public static final void K6(View view) {
        h3.a.j().d(a.f.f31973b).navigation();
    }

    public static final void L6(View view) {
        h3.a.j().d(a.C0378a.f31905b).navigation();
    }

    public static final void M6(View view) {
        h3.a.j().d(a.C0378a.f31906c).navigation();
    }

    public static final void N6(AccountFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (!a5.f.i().o()) {
            h3.a.j().d(a.C0378a.f31905b).navigation();
            return;
        }
        ProfileNewActivity.a aVar = ProfileNewActivity.F7;
        Context contextR4 = this$0.R4();
        f0.o(contextR4, "requireContext()");
        aVar.a(contextR4);
    }

    public static final void O6(View view) {
        if (a5.f.i().o()) {
            h3.a.j().d(a.b.f31925j).navigation();
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    public static final void P6(View view) {
        if (a5.f.i().o()) {
            h3.a.j().d(a.b.f31924i).navigation();
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    public static final void Q6(View view) {
        if (a5.f.i().o()) {
            h3.a.j().d(a.b.f31922g).navigation();
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    public static final void S6(AccountFragment this$0, ActivityResult activityResult) {
        f0.p(this$0, "this$0");
        if (activityResult.b() == -1) {
            this$0.R6();
        } else if (activityResult.b() == 0) {
            this$0.V6();
        }
    }

    public static final void T6(AccountFragment this$0) {
        f0.p(this$0, "this$0");
        androidx.fragment.app.g gVarW1 = this$0.w1();
        f0.m(gVarW1);
        ku.b.b(gVarW1);
        androidx.fragment.app.g gVarW12 = this$0.w1();
        f0.m(gVarW12);
        ku.b.h(gVarW12, true);
    }

    public static final void W6(DialogFragment dialogFragment) {
        dialogFragment.I5();
        PermissionUtils.C();
    }

    public static final void z6(AccountFragment this$0, androidx.appcompat.app.j dialog) {
        f0.p(this$0, "this$0");
        f0.p(dialog, "dialog");
        dialog.dismiss();
        this$0.X6();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_layout_fragment_main_account;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.l
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        this.f16048p8 = b9.u.d(inflater, viewGroup, false);
        return x6().getRoot();
    }

    public final void R6() {
        androidx.fragment.app.g gVarP4 = P4();
        f0.o(gVarP4, "requireActivity()");
        if (n5.c.c(gVarP4)) {
            h3.a.j().d(a.d.f31958n).navigation();
            return;
        }
        androidx.activity.result.g<Intent> gVar = this.f16051s8;
        StoragePermissionRequestActivity.a aVar = StoragePermissionRequestActivity.f13377k0;
        Context contextR4 = R4();
        f0.o(contextR4, "requireContext()");
        gVar.b(StoragePermissionRequestActivity.a.b(aVar, contextR4, null, 2, null));
    }

    @Override // com.flydigi.base.common.FZFragment
    public void S5() {
        if (w1() != null) {
            H5().e(new Runnable() { // from class: com.flydigi.qiji.ui.account.k
                @Override // java.lang.Runnable
                public final void run() {
                    AccountFragment.T6(this.f16065a);
                }
            });
        }
    }

    public final void U6() {
        X6();
    }

    public final void V6() {
        new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.community_storage_permission_must_granted_for_download_config)).q(c3(R.string.community_to_enable)).b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.qiji.ui.account.g
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                AccountFragment.W6(dialogFragment);
            }
        }).u(U1(), "storage_permission_denied");
    }

    public abstract void X6();

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        w6(false);
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        com.flydigi.userBehavior.a.a().b(X1(), "账号首页");
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        if (o5.p.d() && o5.m.k(DataConstant.SP_APP).e(DataConstant.SP_APP_SHOW_WECHAT_OFFICIAL_ACCOUNT_FOLLOW_HINT)) {
            final View viewF5 = F5(R.id.area_wechat_account);
            viewF5.setVisibility(0);
            com.blankj.utilcode.util.o.r(F5(R.id.btn_close), new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AccountFragment.J6(viewF5, view2);
                }
            });
            com.blankj.utilcode.util.o.r(F5(R.id.btn_follow), new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AccountFragment.K6(view2);
                }
            });
        }
        com.blankj.utilcode.util.o.r(x6().f9261p, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.L6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9262q, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.M6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9250e, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.N6(this.f16067a, view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9256k, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.O6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9259n, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.P6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9258m, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.Q6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9257l, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.D6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9254i, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.E6(this.f16066a, view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9260o, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.F6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9255j, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.G6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(x6().f9252g, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.H6(view2);
            }
        });
        OperateView operateView = x6().f9253h;
        v0 v0Var = v0.f37964a;
        String strC3 = c3(R.string.app_current_version_);
        f0.o(strC3, "getString(R.string.app_current_version_)");
        String str = String.format(strC3, Arrays.copyOf(new Object[]{com.blankj.utilcode.util.d.C()}, 1));
        f0.o(str, "format(format, *args)");
        operateView.setNotice(str);
        com.blankj.utilcode.util.o.r(x6().f9253h, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.account.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment.I6(this.f16068a, view2);
            }
        });
        v6();
        N5();
    }

    @tt.l(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@yt.k BadgeEvent event) {
        f0.p(event, "event");
        x6().f9256k.setMessageNotice(event.getUnreadMessageBean().getTotal());
        tt.c.f().x(BadgeEvent.class);
    }

    public final void v6() {
        com.bumptech.glide.request.h hVarE0 = new com.bumptech.glide.request.h().E0(R.drawable.main_ic_default_avatar);
        f0.o(hVarE0, "RequestOptions().placeho…e.main_ic_default_avatar)");
        com.bumptech.glide.request.h hVar = hVarE0;
        if (!a5.f.i().o()) {
            x6().f9251f.setVisibility(0);
            x6().f9263r.setVisibility(8);
            com.bumptech.glide.b.G(this).Y(hVar).t("").s1(x6().f9250e);
        } else {
            x6().f9251f.setVisibility(8);
            x6().f9263r.setVisibility(0);
            x6().f9263r.setText(a5.f.i().h().username);
            com.bumptech.glide.b.G(this).Y(hVar).t(a5.f.i().h().avatar).s1(x6().f9250e);
        }
    }

    public final void w6(boolean z10) {
        ((h5.d) m5.f0.i().k().g(h5.d.class)).r(n0.b(o5.m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_FLOAT_KEY_CHANNEL_NAME, ""), "nubia") ? Constants.VIA_REPORT_TYPE_SET_AVATAR : "6").s0(c0.r()).s0(c0.t()).s0(o5.l.d()).s0(y1()).c(new b(z10));
    }

    @yt.k
    public final b9.u x6() {
        b9.u uVar = this.f16048p8;
        f0.m(uVar);
        return uVar;
    }

    public final void y6(UpdateInfoBean updateInfoBean, boolean z10) {
        f0.m(updateInfoBean);
        if (!updateInfoBean.needUpdate()) {
            if (z10) {
                com.flydigi.base.common.o.E(c3(R.string.app_latest_version_notice));
                return;
            }
            return;
        }
        UpdateDialog updateDialog = this.f16050r8;
        if (updateDialog != null) {
            f0.m(updateDialog);
            if (updateDialog.isShowing()) {
                UpdateDialog updateDialog2 = this.f16050r8;
                f0.m(updateDialog2);
                updateDialog2.dismiss();
                this.f16050r8 = null;
            }
        }
        x6().f9253h.l(true);
        OperateView operateView = x6().f9253h;
        v0 v0Var = v0.f37964a;
        String strC3 = c3(R.string.app_latest_version_);
        f0.o(strC3, "getString(R.string.app_latest_version_)");
        String str = String.format(strC3, Arrays.copyOf(new Object[]{updateInfoBean.versionName}, 1));
        f0.o(str, "format(format, *args)");
        operateView.setNotice(str);
        if (!updateInfoBean.noNotice() || z10) {
            UpdateDialog updateDialogA = updateInfoBean.needForceUpdate() ? new UpdateDialog.a().e(updateInfoBean.upgrade_point).b(Boolean.FALSE).f(true).g(new i(this)).a(com.blankj.utilcode.util.a.P()) : new UpdateDialog.a().e(updateInfoBean.upgrade_point).f(false).b(Boolean.TRUE).c(j.f16064a).d(new h(this)).a(com.blankj.utilcode.util.a.P());
            this.f16050r8 = updateDialogA;
            if (updateDialogA != null) {
                updateDialogA.show();
            }
        }
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public final void onEvent(@yt.k FZAccountLoginChangeEvent event) {
        f0.p(event, "event");
        v6();
        if (event.isLogin()) {
            return;
        }
        x6().f9256k.setMessageNotice(0);
    }
}
