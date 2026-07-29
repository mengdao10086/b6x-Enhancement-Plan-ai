package com.flydigi.device_manager.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import c7.r0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import i9.a;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes7.dex */
public final class OpenFloatWindowNoticeFragment extends FZFragment {

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public static final a f14485r8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f14486o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public r0 f14487p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f14488q8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final OpenFloatWindowNoticeFragment a(boolean z10) {
            OpenFloatWindowNoticeFragment openFloatWindowNoticeFragment = new OpenFloatWindowNoticeFragment();
            openFloatWindowNoticeFragment.c5(androidx.core.os.e.b(new Pair(DataConstant.DEVICE_KEY_CAN_JUMP, Boolean.valueOf(z10))));
            return openFloatWindowNoticeFragment;
        }
    }

    @hk.m
    @yt.k
    public static final OpenFloatWindowNoticeFragment d6(boolean z10) {
        return f14485r8.a(z10);
    }

    public static final void e6(OpenFloatWindowNoticeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.f14488q8 = true;
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).c(this$0.f13317d8, DataConstant.FLOAT_WINDOW_ACTION_SHOW_DISPLAY_OVER_OTHER_APP_PERMISSION);
        if (o5.d.u(this$0.X1())) {
            return;
        }
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.URL_FLOAT_WINDOW_OPEN_FAILED).navigation();
        com.flydigi.base.common.o.w(this$0.c3(R.string.device_auto_open_failed));
    }

    public static final void f6(OpenFloatWindowNoticeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.f14486o8) {
            this$0.c6();
        }
    }

    public static final void h6(OpenFloatWindowNoticeFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        o5.d.v(this$0.X1(), true);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.f14486o8 = bundleT1 != null ? bundleT1.getBoolean(DataConstant.DEVICE_KEY_CAN_JUMP) : false;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_float_notice;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        r0 r0VarD = r0.d(inflater, viewGroup, false);
        f0.o(r0VarD, "inflate(inflater, container, false)");
        this.f14487p8 = r0VarD;
        if (r0VarD == null) {
            f0.S("viewBinding");
            r0VarD = null;
        }
        ConstraintLayout constraintLayoutB = r0VarD.getRoot();
        f0.o(constraintLayoutB, "viewBinding.root");
        return constraintLayoutB;
    }

    public final void c6() {
        androidx.appcompat.app.f fVar = this.f13317d8;
        if (fVar != null) {
            fVar.finish();
        }
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        if (!o5.d.o(H1())) {
            if (this.f14488q8 && o5.h.l()) {
                g6();
                return;
            }
            return;
        }
        if (this.f14486o8) {
            c6();
            return;
        }
        androidx.appcompat.app.f fVar = this.f13317d8;
        if (fVar != null) {
            fVar.finish();
        }
    }

    public final void g6() {
        new FZDialog.a().j(c3(R.string.device_permission_display_over_other_app_need_granted_)).q(c3(R.string.device_driver_active)).n(R.drawable.float_ic_other_open_float_window).b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.s
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                OpenFloatWindowNoticeFragment.h6(this.f15387a, dialogFragment);
            }
        }).a().Z5(U1(), "display_over_other_app");
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        r0 r0Var = this.f14487p8;
        r0 r0Var2 = null;
        if (r0Var == null) {
            f0.S("viewBinding");
            r0Var = null;
        }
        com.blankj.utilcode.util.o.r(r0Var.f10393b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OpenFloatWindowNoticeFragment.e6(this.f15382a, view2);
            }
        });
        r0 r0Var3 = this.f14487p8;
        if (r0Var3 == null) {
            f0.S("viewBinding");
            r0Var3 = null;
        }
        TextView textView = r0Var3.f10395d;
        com.blankj.utilcode.util.o.r(textView, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OpenFloatWindowNoticeFragment.f6(this.f15381a, view2);
            }
        });
        textView.setVisibility(this.f14486o8 ? 0 : 8);
        if (o5.h.l() || o5.h.d()) {
            r0 r0Var4 = this.f14487p8;
            if (r0Var4 == null) {
                f0.S("viewBinding");
                r0Var4 = null;
            }
            r0Var4.f10396e.setText(R.string.device_need_display_over_other_app_permission_miui);
            r0 r0Var5 = this.f14487p8;
            if (r0Var5 == null) {
                f0.S("viewBinding");
            } else {
                r0Var2 = r0Var5;
            }
            r0Var2.f10394c.setImageResource(R.drawable.float_ic_xiaomi_open_float_window);
            return;
        }
        if (o5.h.p()) {
            r0 r0Var6 = this.f14487p8;
            if (r0Var6 == null) {
                f0.S("viewBinding");
                r0Var6 = null;
            }
            r0Var6.f10396e.setText(R.string.device_need_display_over_other_app_permission);
            r0 r0Var7 = this.f14487p8;
            if (r0Var7 == null) {
                f0.S("viewBinding");
            } else {
                r0Var2 = r0Var7;
            }
            r0Var2.f10394c.setImageResource(R.drawable.float_ic_ov_open_float_window);
            return;
        }
        if (o5.h.m()) {
            r0 r0Var8 = this.f14487p8;
            if (r0Var8 == null) {
                f0.S("viewBinding");
                r0Var8 = null;
            }
            r0Var8.f10396e.setText(R.string.device_need_display_over_other_app_permission);
            r0 r0Var9 = this.f14487p8;
            if (r0Var9 == null) {
                f0.S("viewBinding");
            } else {
                r0Var2 = r0Var9;
            }
            r0Var2.f10394c.setImageResource(R.drawable.float_ic_oppo_open_float_window);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            r0 r0Var10 = this.f14487p8;
            if (r0Var10 == null) {
                f0.S("viewBinding");
                r0Var10 = null;
            }
            r0Var10.f10396e.setText(R.string.device_need_display_over_other_app_permission);
            r0 r0Var11 = this.f14487p8;
            if (r0Var11 == null) {
                f0.S("viewBinding");
            } else {
                r0Var2 = r0Var11;
            }
            r0Var2.f10394c.setImageResource(R.drawable.float_ic_other_open_float_window_android_11);
            return;
        }
        r0 r0Var12 = this.f14487p8;
        if (r0Var12 == null) {
            f0.S("viewBinding");
            r0Var12 = null;
        }
        r0Var12.f10396e.setText(R.string.device_need_display_over_other_app_permission);
        r0 r0Var13 = this.f14487p8;
        if (r0Var13 == null) {
            f0.S("viewBinding");
        } else {
            r0Var2 = r0Var13;
        }
        r0Var2.f10394c.setImageResource(R.drawable.float_ic_other_open_float_window);
    }
}
