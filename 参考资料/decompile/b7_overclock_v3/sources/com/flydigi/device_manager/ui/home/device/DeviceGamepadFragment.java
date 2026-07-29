package com.flydigi.device_manager.ui.home.device;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import c7.x0;
import com.alibaba.android.arouter.facade.Postcard;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.event.ExitAppEvent;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.home.device.w;
import com.flydigi.device_manager.ui.home.device.x;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.gamepad.GamepadInfo;
import i9.a;
import java.util.HashMap;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nDeviceGamepadFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceGamepadFragment.kt\ncom/flydigi/device_manager/ui/home/device/DeviceGamepadFragment\n+ 2 Handler.kt\nandroidx/core/os/HandlerKt\n*L\n1#1,698:1\n33#2,12:699\n*S KotlinDebug\n*F\n+ 1 DeviceGamepadFragment.kt\ncom/flydigi/device_manager/ui/home/device/DeviceGamepadFragment\n*L\n470#1:699,12\n*E\n"})
public final class DeviceGamepadFragment extends BaseGamepadFragment implements x.b, com.flydigi.sdk.bluetooth.m {

    @yt.k
    public static final a G8 = new a(null);
    public static final int H8 = 1;
    public static final int I8 = 2;
    public static final int J8 = 3;
    public static final int K8 = 4;
    public static final int L8 = 5;
    public static final int M8 = 6;
    public x0 A8;

    @yt.l
    public TipView C8;
    public boolean D8;
    public boolean E8;

    @yt.k
    public x.a B8 = new DeviceInfoPresenter(this);

    @yt.k
    public final kotlin.reflect.i<z1> F8 = new DeviceGamepadFragment$checkActiveResultRunnable$1(this);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final DeviceGamepadFragment a() {
            DeviceGamepadFragment deviceGamepadFragment = new DeviceGamepadFragment();
            deviceGamepadFragment.c5(androidx.core.os.e.a());
            return deviceGamepadFragment;
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@yt.k Animator animation) {
            kotlin.jvm.internal.f0.p(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@yt.k Animator animation) {
            kotlin.jvm.internal.f0.p(animation, "animation");
            TipView tipView = DeviceGamepadFragment.this.C8;
            if (tipView != null) {
                o5.c.b(tipView, Boolean.FALSE, false, 2, null);
            }
            x0 x0Var = DeviceGamepadFragment.this.A8;
            if (x0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                x0Var = null;
            }
            View view = x0Var.f10558e;
            kotlin.jvm.internal.f0.o(view, "viewBinding.containerDivider");
            o5.c.b(view, Boolean.TRUE, false, 2, null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@yt.k Animator animation) {
            kotlin.jvm.internal.f0.p(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@yt.k Animator animation) {
            kotlin.jvm.internal.f0.p(animation, "animation");
        }
    }

    @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n+ 2 DeviceGamepadFragment.kt\ncom/flydigi/device_manager/ui/home/device/DeviceGamepadFragment\n*L\n1#1,69:1\n471#2,2:70\n*E\n"})
    public static final class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            tt.c.f().q(new ExitAppEvent(false));
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@yt.k Animator animation) {
            kotlin.jvm.internal.f0.p(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@yt.k Animator animation) {
            kotlin.jvm.internal.f0.p(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@yt.k Animator animation) {
            kotlin.jvm.internal.f0.p(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@yt.k Animator animation) {
            kotlin.jvm.internal.f0.p(animation, "animation");
            TipView tipView = DeviceGamepadFragment.this.C8;
            if (tipView != null) {
                o5.c.b(tipView, Boolean.TRUE, false, 2, null);
            }
            x0 x0Var = DeviceGamepadFragment.this.A8;
            if (x0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                x0Var = null;
            }
            View view = x0Var.f10558e;
            kotlin.jvm.internal.f0.o(view, "viewBinding.containerDivider");
            o5.c.b(view, Boolean.FALSE, false, 2, null);
        }
    }

    public static final void A7(View view) {
    }

    public static final void B7(DeviceGamepadFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.n7();
    }

    public static final void C7(GamepadInfo deviceInfo, View view) {
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        h3.a.j().d(a.d.f31955k).withInt("type", deviceInfo.getDeviceType()).navigation();
    }

    public static final void E7(DeviceGamepadFragment this$0, ValueAnimator animation) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.f0.n(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        TipView tipView = this$0.C8;
        ViewGroup.LayoutParams layoutParams = tipView != null ? tipView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = iIntValue;
        }
        TipView tipView2 = this$0.C8;
        if (tipView2 != null) {
            tipView2.requestLayout();
        }
        TipView tipView3 = this$0.C8;
        if (tipView3 != null) {
            tipView3.invalidate();
        }
    }

    public static final void G7(kotlin.reflect.i tmp0) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        ((ik.a) tmp0).o();
    }

    public static final void H7(kotlin.reflect.i tmp0) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        ((ik.a) tmp0).o();
    }

    public static final void K7(kotlin.reflect.i tmp0) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        ((ik.a) tmp0).o();
    }

    public static final void d7(DeviceGamepadFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.L7();
    }

    public static final void e7(DeviceGamepadFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        TipView tipView = this$0.C8;
        if (tipView != null) {
            tipView.requestLayout();
        }
        TipView tipView2 = this$0.C8;
        if (tipView2 != null) {
            tipView2.invalidate();
        }
    }

    @hk.m
    @yt.k
    public static final DeviceGamepadFragment f7() {
        return G8.a();
    }

    public static final void h7(DeviceGamepadFragment this$0, ValueAnimator animation) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.f0.n(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        TipView tipView = this$0.C8;
        ViewGroup.LayoutParams layoutParams = tipView != null ? tipView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = iIntValue;
        }
        TipView tipView2 = this$0.C8;
        if (tipView2 != null) {
            tipView2.requestLayout();
        }
        TipView tipView3 = this$0.C8;
        if (tipView3 != null) {
            tipView3.invalidate();
        }
    }

    public static final void i7(DeviceGamepadFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        GamepadInfo gamepadInfoF = this$0.l6().h().f();
        if (gamepadInfoF == null || !gamepadInfoF.isConnected()) {
            return;
        }
        h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 1).withParcelable("key_device_info", gamepadInfoF).withString("key_device_code", gamepadInfoF.getDeviceCode()).navigation();
    }

    public static final void m7(DeviceGamepadFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        o5.m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_MAIN_TCPIP_HAVE_ABLE_TO_ACTIVE, false);
        i9.b.f(this$0, DataConstant.REMOTE_ACTION_KILL_DRIVER);
        Handler handler = this$0.G5();
        kotlin.jvm.internal.f0.o(handler, "handler");
        handler.postDelayed(new c(), 1000L);
    }

    public static final void o7(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void q7(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void r7(DeviceGamepadFragment this$0, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        dialogFragment.I5();
        this$0.j7();
    }

    public static final void t7(DeviceGamepadFragment this$0, final GamepadInfo deviceInfo, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        this$0.H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.home.device.j
            @Override // java.lang.Runnable
            public final void run() {
                DeviceGamepadFragment.u7(deviceInfo);
            }
        });
    }

    public static final void u7(GamepadInfo deviceInfo) {
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 1).withParcelable("key_device_info", deviceInfo).withBoolean(DataConstant.DEVICE_KEY_AUTO_SWITCH_MODE, true).navigation();
    }

    public static final void v7(boolean z10, HashMap umeng, DeviceGamepadFragment this$0, final GamepadInfo deviceInfo, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(umeng, "$umeng");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        if (!z10) {
            umeng.put("action", "切换");
        }
        this$0.H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.home.device.i
            @Override // java.lang.Runnable
            public final void run() {
                DeviceGamepadFragment.w7(deviceInfo);
            }
        });
        u9.g.a().e(this$0.X1(), "SWITCH_MAPPING_MODE_ON_10", umeng);
    }

    public static final void w7(GamepadInfo deviceInfo) {
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 1).withParcelable("key_device_info", deviceInfo).withBoolean(DataConstant.DEVICE_KEY_AUTO_SWITCH_MODE, true).navigation();
    }

    public static final void x7(boolean z10, HashMap umeng, DeviceGamepadFragment this$0, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(umeng, "$umeng");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        if (((FZDialog) dialogFragment).s6()) {
            o5.m.k(DataConstant.SP_APP).F(DataConstant.SP_SUGGEST_TRADITION_MODE_FOR_ANDROID_Q, true);
            if (!z10) {
                umeng.put("action", "不再提示");
            }
        } else if (!z10) {
            umeng.put("action", "取消");
        }
        u9.g.a().e(this$0.X1(), "SWITCH_MAPPING_MODE_ON_10", umeng);
    }

    public static final void z7(GamepadInfo deviceInfo, DeviceGamepadFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (deviceInfo.getDeviceType() == 67 && w.a(deviceInfo) == R.drawable.device_ic_battery_level_1) {
            this$0.p7();
        } else {
            this$0.I7();
        }
    }

    @Override // com.flydigi.device_manager.ui.home.device.x.b
    public void C0() {
        GamepadInfo gamepadInfoK6 = k6();
        if (!(gamepadInfoK6 != null && gamepadInfoK6.isConnected())) {
            g7();
            return;
        }
        D7();
        TipView tipView = this.C8;
        if (tipView != null) {
            tipView.f(false, R.string.device_tips_firmware_out_of_date, R.string.device_tips_firmware_out_of_date_desc, R.string.device_tips_action_upgrade, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DeviceGamepadFragment.d7(this.f15200a, view);
                }
            }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
        }
        TipView tipView2 = this.C8;
        if (tipView2 != null) {
            tipView2.setTag(R.id.device_tag_tip_type, 6);
        }
        TipView tipView3 = this.C8;
        if (tipView3 != null) {
            tipView3.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
        }
        TipView tipView4 = this.C8;
        if (tipView4 != null) {
            tipView4.post(new Runnable() { // from class: com.flydigi.device_manager.ui.home.device.h
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceGamepadFragment.e7(this.f15190a);
                }
            });
        }
    }

    @Override // com.flydigi.device_manager.ui.home.device.x.b
    public void D0() {
        x.b.a.a(this);
        g7();
    }

    public final void D7() {
        ViewGroup.LayoutParams layoutParams;
        x0 x0Var = this.A8;
        x0 x0Var2 = null;
        if (x0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            x0Var = null;
        }
        ViewStub viewStub = x0Var.f10557d;
        kotlin.jvm.internal.f0.o(viewStub, "viewBinding.areaTodoTips");
        o5.c.b(viewStub, Boolean.TRUE, false, 2, null);
        if (this.C8 == null) {
            x0 x0Var3 = this.A8;
            if (x0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                x0Var2 = x0Var3;
            }
            this.C8 = (TipView) x0Var2.getRoot().findViewById(R.id.area_tips);
        }
        TipView tipView = this.C8;
        if (tipView != null && tipView.getVisibility() == 0) {
            TipView tipView2 = this.C8;
            if (!((tipView2 == null || (layoutParams = tipView2.getLayoutParams()) == null || layoutParams.height != 0) ? false : true)) {
                return;
            }
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, V2().getDimensionPixelSize(R.dimen.qb_px_130));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.flydigi.device_manager.ui.home.device.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DeviceGamepadFragment.E7(this.f15197a, valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new d());
        valueAnimatorOfInt.setDuration(250L);
        valueAnimatorOfInt.start();
    }

    public final void F7(long j10) {
        TipView tipView;
        TipView tipView2 = this.C8;
        if ((tipView2 != null ? kotlin.jvm.internal.f0.g(tipView2.getTag(R.id.device_tag_tip_type), 3) : false) && (tipView = this.C8) != null) {
            tipView.e(true);
        }
        TipView tipView3 = this.C8;
        if (tipView3 != null) {
            final kotlin.reflect.i<z1> iVar = this.F8;
            tipView3.removeCallbacks(new Runnable() { // from class: com.flydigi.device_manager.ui.home.device.l
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceGamepadFragment.G7(iVar);
                }
            });
        }
        TipView tipView4 = this.C8;
        if (tipView4 != null) {
            final kotlin.reflect.i<z1> iVar2 = this.F8;
            tipView4.postDelayed(new Runnable() { // from class: com.flydigi.device_manager.ui.home.device.k
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceGamepadFragment.H7(iVar2);
                }
            }, j10);
        }
    }

    public final void I7() {
        if (!o5.b.i(X1())) {
            j7();
            return;
        }
        i9.b.f(this, DataConstant.REMOTE_ACTION_START_DRIVER_MANUAL);
        this.E8 = true;
        F7(7000L);
    }

    public final void J7(GamepadInfo gamepadInfo) {
        TipView tipView = this.C8;
        if (tipView != null) {
            final kotlin.reflect.i<z1> iVar = this.F8;
            tipView.removeCallbacks(new Runnable() { // from class: com.flydigi.device_manager.ui.home.device.n
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceGamepadFragment.K7(iVar);
                }
            });
        }
        if (!gamepadInfo.isDriverConnected()) {
            b7();
            return;
        }
        TipView tipView2 = this.C8;
        if (tipView2 != null) {
            tipView2.e(false);
        }
        this.E8 = false;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_home_gamepad;
    }

    public final void L7() {
        GamepadInfo gamepadInfoK6 = k6();
        if (gamepadInfoK6 != null) {
            h3.a.j().d(a.d.f31952h).withString("device_name", gamepadInfoK6.getDeviceName()).withString(DataConstant.DEVICE_ADDRESS, gamepadInfoK6.getAddress()).withString("key_device_code", gamepadInfoK6.getDeviceCode()).withString(DataConstant.DEVICE_KEY_FIRMWARE_VERSION, gamepadInfoK6.getFirmwareVersion()).navigation();
        }
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        x0 x0VarD = x0.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(x0VarD, "inflate(inflater, container, false)");
        this.A8 = x0VarD;
        if (x0VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            x0VarD = null;
        }
        LinearLayout root = x0VarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        m.a.e(this, z10);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
        m.a.a(this);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        m.a.b(this);
    }

    public final void b7() {
        GamepadInfo gamepadInfoK6 = k6();
        if (((gamepadInfoK6 == null || gamepadInfoK6.isDriverConnected()) ? false : true) && this.E8) {
            j7();
        }
        TipView tipView = this.C8;
        if (tipView != null) {
            tipView.e(false);
        }
        this.E8 = false;
    }

    public final void c7() {
        Fragment fragmentB = com.blankj.utilcode.util.d0.B(U1(), "switch_mapping_mode");
        if (fragmentB != null && fragmentB.s3() && A3()) {
            ((DialogFragment) fragmentB).I5();
        }
    }

    public final void g7() {
        TipView tipView = this.C8;
        if (tipView != null && tipView.getVisibility() == 0) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(V2().getDimensionPixelSize(R.dimen.qb_px_130), 0);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.flydigi.device_manager.ui.home.device.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DeviceGamepadFragment.h7(this.f15173a, valueAnimator);
                }
            });
            valueAnimatorOfInt.addListener(new b());
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.start();
            return;
        }
        GamepadInfo gamepadInfoK6 = k6();
        if (gamepadInfoK6 != null && gamepadInfoK6.isConnected()) {
            x0 x0Var = this.A8;
            if (x0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                x0Var = null;
            }
            View view = x0Var.f10558e;
            kotlin.jvm.internal.f0.o(view, "viewBinding.containerDivider");
            o5.c.b(view, Boolean.TRUE, false, 2, null);
        }
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        x0 x0Var = this.A8;
        if (x0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            x0Var = null;
        }
        com.blankj.utilcode.util.o.r(x0Var.f10555b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceGamepadFragment.i7(this.f15201a, view2);
            }
        });
        l6().h().k(l3(), new w.a(new ik.l<GamepadInfo, z1>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceGamepadFragment$onViewCreated$2
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(GamepadInfo it2) {
                x0 x0Var2;
                x0 x0Var3;
                x0 x0Var4;
                x0 x0Var5;
                Boolean bool;
                x0 x0Var6;
                x0 x0Var7;
                x0 x0Var8;
                x0 x0Var9;
                x0 x0Var10;
                x0 x0Var11;
                x0 x0Var12 = this.this$0.A8;
                if (x0Var12 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    x0Var12 = null;
                }
                x0Var12.f10563j.setText(a5.b.d(it2.getDeviceCode(), Boolean.valueOf(it2.getIpType()), it2.getDeviceType()));
                com.bumptech.glide.h hVarC0 = com.bumptech.glide.b.G(this.this$0).p(Integer.valueOf(a5.b.m(it2.getDeviceCode(), Boolean.valueOf(it2.getIpType()), it2.getDeviceType()))).C0(gg.b.f29491t1);
                x0 x0Var13 = this.this$0.A8;
                if (x0Var13 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    x0Var13 = null;
                }
                hVarC0.s1(x0Var13.f10560g);
                androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                x0 x0Var14 = this.this$0.A8;
                if (x0Var14 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    x0Var14 = null;
                }
                dVar.H(x0Var14.f10555b);
                if (it2.isConnected()) {
                    int i10 = R.id.iv_device;
                    dVar.W(i10, this.this$0.V2().getDimensionPixelSize(R.dimen.qb_px_88));
                    dVar.k1(i10, 6, 0);
                    dVar.k1(i10, 7, 0);
                    int i11 = R.id.tv_name;
                    dVar.K(i10, 7, i11, 6);
                    dVar.K(i11, 3, 0, 3);
                    dVar.K(i11, 6, i10, 7);
                    dVar.k1(R.id.area_notice, 3, 0);
                    if (!it2.isGamepadHalf() || u9.b.d()) {
                        x0 x0Var15 = this.this$0.A8;
                        if (x0Var15 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var15 = null;
                        }
                        TextView textView = x0Var15.f10562i;
                        kotlin.jvm.internal.f0.o(textView, "viewBinding.tvMappingMode");
                        Boolean bool2 = Boolean.TRUE;
                        bool = null;
                        o5.c.b(textView, bool2, false, 2, null);
                        x0 x0Var16 = this.this$0.A8;
                        if (x0Var16 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var6 = null;
                        } else {
                            x0Var6 = x0Var16;
                        }
                        View view2 = x0Var6.f10566m;
                        kotlin.jvm.internal.f0.o(view2, "viewBinding.viewDivider2");
                        o5.c.b(view2, bool2, false, 2, null);
                    } else {
                        x0 x0Var17 = this.this$0.A8;
                        if (x0Var17 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var17 = null;
                        }
                        TextView textView2 = x0Var17.f10562i;
                        kotlin.jvm.internal.f0.o(textView2, "viewBinding.tvMappingMode");
                        Boolean bool3 = Boolean.FALSE;
                        bool = null;
                        o5.c.b(textView2, bool3, false, 2, null);
                        x0 x0Var18 = this.this$0.A8;
                        if (x0Var18 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var11 = null;
                        } else {
                            x0Var11 = x0Var18;
                        }
                        View view3 = x0Var11.f10566m;
                        kotlin.jvm.internal.f0.o(view3, "viewBinding.viewDivider2");
                        o5.c.b(view3, bool3, false, 2, null);
                    }
                    x0 x0Var19 = this.this$0.A8;
                    if (x0Var19 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        x0Var7 = bool;
                    } else {
                        x0Var7 = x0Var19;
                    }
                    TextView textView3 = x0Var7.f10562i;
                    kotlin.jvm.internal.f0.o(it2, "it");
                    textView3.setText(w.c(it2, bool, 1, bool));
                    if (it2.getBattery() != 0) {
                        x0 x0Var20 = this.this$0.A8;
                        if (x0Var20 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var20 = null;
                        }
                        x0Var20.f10559f.setImageResource(w.a(it2));
                        x0 x0Var21 = this.this$0.A8;
                        if (x0Var21 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var21 = null;
                        }
                        View view4 = x0Var21.f10565l;
                        kotlin.jvm.internal.f0.o(view4, "viewBinding.viewDivider1");
                        Boolean bool4 = Boolean.TRUE;
                        o5.c.b(view4, bool4, false, 2, null);
                        x0 x0Var22 = this.this$0.A8;
                        if (x0Var22 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var10 = null;
                        } else {
                            x0Var10 = x0Var22;
                        }
                        ImageView imageView = x0Var10.f10559f;
                        kotlin.jvm.internal.f0.o(imageView, "viewBinding.ivBattery");
                        o5.c.b(imageView, bool4, false, 2, null);
                    } else {
                        x0 x0Var23 = this.this$0.A8;
                        if (x0Var23 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var8 = null;
                        } else {
                            x0Var8 = x0Var23;
                        }
                        View view5 = x0Var8.f10565l;
                        kotlin.jvm.internal.f0.o(view5, "viewBinding.viewDivider1");
                        Boolean bool5 = Boolean.FALSE;
                        o5.c.b(view5, bool5, false, 2, null);
                        x0 x0Var24 = this.this$0.A8;
                        if (x0Var24 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            x0Var9 = null;
                        } else {
                            x0Var9 = x0Var24;
                        }
                        ImageView imageView2 = x0Var9.f10559f;
                        kotlin.jvm.internal.f0.o(imageView2, "viewBinding.ivBattery");
                        o5.c.b(imageView2, bool5, false, 2, null);
                    }
                    dVar.D1(R.id.iv_info_more, 0);
                    x0Var5 = null;
                } else {
                    int i12 = R.id.iv_device;
                    dVar.W(i12, 0);
                    Resources resourcesV2 = this.this$0.V2();
                    int i13 = R.dimen.qb_px_64;
                    dVar.k1(i12, 6, resourcesV2.getDimensionPixelSize(i13));
                    dVar.k1(i12, 7, this.this$0.V2().getDimensionPixelSize(i13));
                    x0 x0Var25 = this.this$0.A8;
                    if (x0Var25 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        x0Var25 = null;
                    }
                    TextView textView4 = x0Var25.f10562i;
                    kotlin.jvm.internal.f0.o(textView4, "viewBinding.tvMappingMode");
                    Boolean bool6 = Boolean.FALSE;
                    o5.c.b(textView4, bool6, false, 2, null);
                    x0 x0Var26 = this.this$0.A8;
                    if (x0Var26 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        x0Var2 = null;
                    } else {
                        x0Var2 = x0Var26;
                    }
                    View view6 = x0Var2.f10565l;
                    kotlin.jvm.internal.f0.o(view6, "viewBinding.viewDivider1");
                    o5.c.b(view6, bool6, false, 2, null);
                    x0 x0Var27 = this.this$0.A8;
                    if (x0Var27 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        x0Var3 = null;
                    } else {
                        x0Var3 = x0Var27;
                    }
                    View view7 = x0Var3.f10566m;
                    kotlin.jvm.internal.f0.o(view7, "viewBinding.viewDivider2");
                    o5.c.b(view7, bool6, false, 2, null);
                    x0 x0Var28 = this.this$0.A8;
                    if (x0Var28 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        x0Var4 = null;
                    } else {
                        x0Var4 = x0Var28;
                    }
                    ImageView imageView3 = x0Var4.f10559f;
                    kotlin.jvm.internal.f0.o(imageView3, "viewBinding.ivBattery");
                    o5.c.b(imageView3, bool6, false, 2, null);
                    dVar.D1(R.id.iv_info_more, 8);
                    dVar.K(i12, 7, 0, 7);
                    int i14 = R.id.tv_name;
                    dVar.K(i14, 3, i12, 4);
                    dVar.K(i14, 6, 0, 6);
                    dVar.k1(i14, 6, this.this$0.V2().getDimensionPixelSize(R.dimen.qb_px_24));
                    Resources resourcesV22 = this.this$0.V2();
                    int i15 = R.dimen.qb_px_16;
                    dVar.k1(i14, 3, resourcesV22.getDimensionPixelSize(i15));
                    dVar.k1(R.id.area_notice, 3, this.this$0.V2().getDimensionPixelSize(i15));
                    dVar.F(R.id.area_info, 4);
                    TipView tipView = this.this$0.C8;
                    if (tipView != null) {
                        o5.c.b(tipView, bool6, false, 2, null);
                    }
                    x0 x0Var29 = this.this$0.A8;
                    if (x0Var29 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        x0Var29 = null;
                    }
                    View view8 = x0Var29.f10558e;
                    kotlin.jvm.internal.f0.o(view8, "viewBinding.containerDivider");
                    x0Var5 = null;
                    o5.c.b(view8, bool6, false, 2, null);
                }
                x0 x0Var30 = this.this$0.A8;
                if (x0Var30 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    x0Var30 = x0Var5;
                }
                TextView textView5 = x0Var30.f10564k;
                int connectState = it2.getConnectState();
                if (connectState == 0) {
                    textView5.setText(textView5.getContext().getString(R.string.device_state_unconnected));
                    textView5.setTextColor(h0.d.f(textView5.getContext(), R.color.color_fa5555));
                } else if (connectState == 1) {
                    textView5.setText(textView5.getContext().getString(R.string.device_state_connecting));
                    textView5.setTextColor(h0.d.f(textView5.getContext(), R.color.colorText_f5a623));
                } else if (connectState == 2) {
                    textView5.setText(textView5.getContext().getString(R.string.device_state_connected));
                    textView5.setTextColor(h0.d.f(textView5.getContext(), R.color.color_5dd522));
                }
                x0 x0Var31 = this.this$0.A8;
                if (x0Var31 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    x0Var31 = x0Var5;
                }
                dVar.r(x0Var31.f10555b);
                DeviceGamepadFragment deviceGamepadFragment = this.this$0;
                kotlin.jvm.internal.f0.o(it2, "it");
                deviceGamepadFragment.y7(it2);
                this.this$0.k7(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(GamepadInfo gamepadInfo) {
                b(gamepadInfo);
                return z1.f38230a;
            }
        }));
    }

    public final void j7() {
        Postcard postcardD = h3.a.j().d(a.d.f31950f);
        GamepadInfo gamepadInfoK6 = k6();
        postcardD.withString("key_device_code", gamepadInfoK6 != null ? gamepadInfoK6.getDeviceCode() : null).navigation();
    }

    public final void k7(GamepadInfo gamepadInfo) {
        if (!gamepadInfo.isConnected() || gamepadInfo.getMappingMode() == -1) {
            this.D8 = false;
            c7();
        } else {
            if (this.D8) {
                return;
            }
            int iB = com.flydigi.device_manager.ui.p.b(gamepadInfo);
            boolean z10 = gamepadInfo.isFlashplayMode() && gamepadInfo.isGamepadHalf() && !u9.b.e(true);
            if (iB != -1 && iB != gamepadInfo.getMappingMode()) {
                s7(gamepadInfo, true);
            } else if (!z10) {
                c7();
            } else if (!o5.m.k(DataConstant.SP_APP).f(DataConstant.SP_SUGGEST_TRADITION_MODE_FOR_ANDROID_Q, false)) {
                s7(gamepadInfo, false);
            }
            this.D8 = true;
        }
        J7(gamepadInfo);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
        m.a.c(this);
    }

    public final void l7() {
        TipView tipView = this.C8;
        if (tipView != null && tipView.getVisibility() == 8) {
            TipView tipView2 = this.C8;
            if (tipView2 != null) {
                o5.c.b(tipView2, Boolean.TRUE, false, 2, null);
            }
            TipView tipView3 = this.C8;
            if (tipView3 != null) {
                tipView3.f(false, R.string.device_tips_flymapping_out_of_date, R.string.device_tips_flymapping_inactive_desc, R.string.device_tips_action_upgrade, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceGamepadFragment.m7(this.f15202a, view);
                    }
                }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
            }
            TipView tipView4 = this.C8;
            if (tipView4 != null) {
                tipView4.setTag(R.id.device_tag_tip_type, 6);
            }
            TipView tipView5 = this.C8;
            if (tipView5 != null) {
                tipView5.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
            }
        }
    }

    public final void n7() {
        new FZDialog.a().t(c3(R.string.device_driver_active_reason_title)).j(c3(R.string.device_driver_active_reason_content)).b(Boolean.FALSE).q(c3(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.device.g
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                DeviceGamepadFragment.o7(dialogFragment);
            }
        }).u(U1(), LoadingDialogFragment.E8);
    }

    public final void p7() {
        new FZDialog.a().j(c3(R.string.device_driver_active_low_battery)).b(Boolean.FALSE).d(c3(R.string.cancel)).g(c3(R.string.device_driver_active)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.device.f
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                DeviceGamepadFragment.q7(dialogFragment);
            }
        }).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.device.v
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                DeviceGamepadFragment.r7(this.f15207a, dialogFragment);
            }
        }).u(U1(), "lowBattery");
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
        m.a.d(this, i10);
    }

    public final void s7(final GamepadInfo gamepadInfo, final boolean z10) {
        final HashMap map = new HashMap();
        if (!z10) {
            map.put("action", "显示");
        }
        c7();
        FZDialog.a aVarT = new FZDialog.a().j(c3(z10 ? R.string.device_switch_mode_hint_force : R.string.device_switch_mode_hint_suggest)).b(Boolean.FALSE).t(c3(R.string.notice));
        if (z10) {
            aVarT.q(c3(R.string.device_switch_mode)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.device.c
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    DeviceGamepadFragment.t7(this.f15175a, gamepadInfo, dialogFragment);
                }
            });
        } else {
            aVarT.g(c3(R.string.device_switch_mode)).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.device.e
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    DeviceGamepadFragment.v7(z10, map, this, gamepadInfo, dialogFragment);
                }
            }).s(true).d(c3(R.string.cancel)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.device.d
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    DeviceGamepadFragment.x7(z10, map, this, dialogFragment);
                }
            });
        }
        aVarT.a().Z5(U1(), "switch_mapping_mode");
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void u6() {
        super.u6();
        l7();
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void v6() {
        super.v6();
        F7(1500L);
    }

    public final void y7(final GamepadInfo gamepadInfo) {
        if (!v5.c.f() && gamepadInfo.isConnected() && !gamepadInfo.isDriverConnected() && gamepadInfo.isDriverMode()) {
            D7();
            TipView tipView = this.C8;
            if (tipView != null) {
                tipView.f(false, R.string.device_tips_flymapping_inactive_desc, R.string.device_tips_flymapping_inactive, R.string.device_tips_action_activate, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceGamepadFragment.z7(gamepadInfo, this, view);
                    }
                }, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceGamepadFragment.A7(view);
                    }
                }, 1, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceGamepadFragment.B7(this.f15199a, view);
                    }
                });
            }
            TipView tipView2 = this.C8;
            if (tipView2 != null) {
                tipView2.setTag(R.id.device_tag_tip_type, 3);
            }
            TipView tipView3 = this.C8;
            if (tipView3 != null) {
                tipView3.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
                return;
            }
            return;
        }
        if ((gamepadInfo.getDeviceType() == 48 || gamepadInfo.getDeviceType() == 50) && gamepadInfo.isConnected() && !gamepadInfo.isGamepadKeyboard()) {
            D7();
            TipView tipView4 = this.C8;
            if (tipView4 != null) {
                tipView4.f(false, R.string.device_tips_keyboard_disconnected, R.string.device_tips_keyboard_disconnected_desc, R.string.device_tips_action_connect, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.device.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceGamepadFragment.C7(gamepadInfo, view);
                    }
                }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
            }
            TipView tipView5 = this.C8;
            if (tipView5 != null) {
                tipView5.setTag(R.id.device_tag_tip_type, 5);
            }
            TipView tipView6 = this.C8;
            if (tipView6 != null) {
                tipView6.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
                return;
            }
            return;
        }
        if (v5.c.f() || !gamepadInfo.isConnected()) {
            g7();
            return;
        }
        x.a aVar = this.B8;
        Context contextR4 = R4();
        kotlin.jvm.internal.f0.o(contextR4, "requireContext()");
        String strM = m9.t.m(gamepadInfo);
        String firmwareVersion = gamepadInfo.getFirmwareVersion();
        if (firmwareVersion == null) {
            firmwareVersion = "";
        }
        aVar.a(contextR4, strM, firmwareVersion);
    }
}
