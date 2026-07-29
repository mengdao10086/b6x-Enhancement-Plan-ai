package com.flydigi.device_manager.ui.detail;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.e1;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import c7.u0;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.connection.ScanFragment;
import com.flydigi.device_manager.ui.detail.c;
import com.flydigi.device_manager.ui.detail.item.QAItem;
import com.flydigi.device_manager.ui.firmware.FirmwarePresenter;
import com.flydigi.device_manager.ui.firmware.a;
import com.flydigi.device_manager.ui.home.device.TipView;
import com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment;
import com.flydigi.device_manager.ui.mapping_mode.TraditionMappingModeFragment;
import com.flydigi.device_manager.view.FirmwareUpgradeActionItem;
import com.flydigi.device_manager.view.MappingTestActionItem;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.yqritc.recyclerviewflexibledivider.a;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v0;
import w.w;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nGamepadDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GamepadDetailFragment.kt\ncom/flydigi/device_manager/ui/detail/GamepadDetailFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1188:1\n1855#2,2:1189\n*S KotlinDebug\n*F\n+ 1 GamepadDetailFragment.kt\ncom/flydigi/device_manager/ui/detail/GamepadDetailFragment\n*L\n852#1:1189,2\n*E\n"})
public final class GamepadDetailFragment extends BaseGamepadFragment implements com.flydigi.sdk.bluetooth.m, a.b, c.b, b.z, ScanFragment.b, SwitchMappingModeFragment.b, TraditionMappingModeFragment.b {

    @yt.k
    public static final a L8 = new a(null);
    public static final int M8 = 1;
    public static final int N8 = 2;
    public static final int O8 = 3;
    public static final int P8 = 4;
    public static final int Q8 = 5;
    public static final int R8 = 6;

    @yt.k
    public static final String S8 = "key_device_info";

    @yt.k
    public static final String T8 = "key_selected_device_code";
    public c.a A8;
    public a.InterfaceC0156a B8;

    @yt.l
    public TipView C8;
    public String D8;
    public boolean E8;
    public boolean F8;
    public u0 H8;
    public boolean J8;

    @yt.k
    public final eu.davidea.flexibleadapter.b<QAItem> G8 = new eu.davidea.flexibleadapter.b<>(null, this, true);
    public boolean I8 = true;

    @yt.k
    public final Runnable K8 = new Runnable() { // from class: com.flydigi.device_manager.ui.detail.n
        @Override // java.lang.Runnable
        public final void run() {
            GamepadDetailFragment.d7(this.f14623a);
        }
    };

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ GamepadDetailFragment c(a aVar, String str, Boolean bool, Boolean bool2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "all";
            }
            if ((i10 & 2) != 0) {
                bool = Boolean.FALSE;
            }
            if ((i10 & 4) != 0) {
                bool2 = Boolean.FALSE;
            }
            return aVar.b(str, bool, bool2);
        }

        @hk.m
        @yt.k
        public final GamepadDetailFragment a(@yt.k GamepadInfo deviceInfo) {
            kotlin.jvm.internal.f0.p(deviceInfo, "deviceInfo");
            GamepadDetailFragment gamepadDetailFragment = new GamepadDetailFragment();
            gamepadDetailFragment.c5(androidx.core.os.e.b(new Pair("key_device_info", deviceInfo), new Pair(GamepadDetailFragment.T8, deviceInfo.getDeviceCode())));
            return gamepadDetailFragment;
        }

        @hk.m
        @yt.k
        public final GamepadDetailFragment b(@yt.k String deviceCode, @yt.l Boolean bool, @yt.l Boolean bool2) {
            kotlin.jvm.internal.f0.p(deviceCode, "deviceCode");
            GamepadDetailFragment gamepadDetailFragment = new GamepadDetailFragment();
            GamepadInfo gamepadInfo = new GamepadInfo(deviceCode);
            m9.q.z(gamepadInfo, m9.t.l(deviceCode), 0, 0, 12, null);
            gamepadDetailFragment.c5(androidx.core.os.e.b(new Pair("key_device_info", gamepadInfo), new Pair(GamepadDetailFragment.T8, deviceCode), new Pair(DataConstant.DEVICE_KEY_AUTO_CONNECT, bool), new Pair(DataConstant.DEVICE_KEY_AUTO_SWITCH_MODE, bool2)));
            return gamepadDetailFragment;
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
            TipView tipView = GamepadDetailFragment.this.C8;
            if (tipView != null) {
                o5.c.b(tipView, Boolean.FALSE, false, 2, null);
            }
            u0 u0Var = GamepadDetailFragment.this.H8;
            if (u0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var = null;
            }
            View view = u0Var.f10499h;
            kotlin.jvm.internal.f0.o(view, "viewBinding.areaDivider");
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

    public static final class c implements r3.b {
        public c() {
        }

        @Override // r3.b
        public void a(@yt.k p3.b controller) {
            kotlin.jvm.internal.f0.p(controller, "controller");
            androidx.fragment.app.g gVarW1 = GamepadDetailFragment.this.w1();
            if (gVarW1 != null) {
                ku.b.d(gVarW1, h0.d.f(j1.a(), R.color.color_white));
                ku.b.c(gVarW1);
            }
        }

        @Override // r3.b
        public void b(@yt.k p3.b controller) {
            kotlin.jvm.internal.f0.p(controller, "controller");
            androidx.fragment.app.g gVarW1 = GamepadDetailFragment.this.w1();
            if (gVarW1 != null) {
                ku.b.d(gVarW1, h0.d.f(j1.a(), R.color.color_000000_a50));
            }
        }
    }

    public static final class d extends s3.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f14585f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, int i10) {
            super(i10, 48);
            this.f14585f = str;
        }

        @Override // s3.a
        public void e(@yt.k View view, @yt.k p3.b controller) {
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(controller, "controller");
            super.e(view, controller);
            View viewFindViewById = view.findViewById(R.id.tv_guide);
            kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(R.id.tv_guide)");
            ((TextView) viewFindViewById).setText(GamepadDetailFragment.this.d3(R.string.device_guide_gamepad_apex2_3, a5.b.c(this.f14585f)));
        }
    }

    public static final class e extends s3.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f14587f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, int i10) {
            super(i10, 48);
            this.f14587f = str;
        }

        @Override // s3.a
        public void e(@yt.k View view, @yt.k p3.b controller) {
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(controller, "controller");
            super.e(view, controller);
            View viewFindViewById = view.findViewById(R.id.tv_guide);
            kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(R.id.tv_guide)");
            ((TextView) viewFindViewById).setText(GamepadDetailFragment.this.d3(R.string.device_guide_gamepad_apex2_4, a5.b.c(this.f14587f)));
        }
    }

    public static final class f implements Animator.AnimatorListener {
        public f() {
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
            TipView tipView = GamepadDetailFragment.this.C8;
            if (tipView != null) {
                o5.c.b(tipView, Boolean.TRUE, false, 2, null);
            }
            u0 u0Var = GamepadDetailFragment.this.H8;
            if (u0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var = null;
            }
            View view = u0Var.f10499h;
            kotlin.jvm.internal.f0.o(view, "viewBinding.areaDivider");
            o5.c.b(view, Boolean.FALSE, false, 2, null);
        }
    }

    public static final void A7(String deviceCode, View view, final p3.b bVar) {
        kotlin.jvm.internal.f0.p(deviceCode, "$deviceCode");
        View viewFindViewById = view.findViewById(R.id.iv_guide_bg);
        kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(R.id.iv_guide_bg)");
        ImageView imageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_guide);
        kotlin.jvm.internal.f0.o(viewFindViewById2, "view.findViewById(R.id.iv_guide)");
        ImageView imageView2 = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_guide);
        kotlin.jvm.internal.f0.o(viewFindViewById3, "view.findViewById(R.id.tv_guide)");
        TextView textView = (TextView) viewFindViewById3;
        int identifier = imageView.getContext().getResources().getIdentifier("device_guide_gamepad_" + deviceCode + "_2_bg", "drawable", j1.a().getPackageName());
        if (identifier != 0) {
            o5.c.b(imageView, Boolean.TRUE, false, 2, null);
            com.bumptech.glide.b.F(imageView).p(Integer.valueOf(identifier)).s1(imageView);
        } else {
            o5.c.b(imageView, Boolean.FALSE, false, 2, null);
        }
        int identifier2 = imageView2.getContext().getResources().getIdentifier("device_guide_gamepad_" + deviceCode + "_2", "drawable", j1.a().getPackageName());
        if (identifier2 != 0) {
            o5.c.b(imageView2, Boolean.TRUE, false, 2, null);
            com.bumptech.glide.b.F(imageView2).p(Integer.valueOf(identifier2)).s1(imageView2);
        } else {
            o5.c.b(imageView2, Boolean.FALSE, false, 2, null);
        }
        int identifier3 = imageView2.getContext().getResources().getIdentifier("device_guide_gamepad_" + deviceCode + "_2", w.b.f53669e, j1.a().getPackageName());
        if (identifier3 != 0) {
            o5.c.b(textView, Boolean.TRUE, false, 2, null);
            textView.setText(identifier3);
        } else {
            o5.c.b(textView, Boolean.FALSE, false, 2, null);
        }
        com.blankj.utilcode.util.o.r(view.findViewById(R.id.btn_skip), new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GamepadDetailFragment.B7(bVar, view2);
            }
        });
    }

    public static final void B7(p3.b bVar, View view) {
        bVar.l();
    }

    public static final void C7(View view, p3.b bVar) {
        View viewFindViewById = view.findViewById(R.id.iv_guide);
        kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(R.id.iv_guide)");
        View viewFindViewById2 = view.findViewById(R.id.tv_guide);
        kotlin.jvm.internal.f0.o(viewFindViewById2, "view.findViewById(R.id.tv_guide)");
        ((TextView) viewFindViewById2).setVisibility(4);
        ((ImageView) viewFindViewById).setVisibility(4);
    }

    public static final void D7(GamepadDetailFragment this$0, View view, p3.b bVar) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        View viewFindViewById = view.findViewById(R.id.iv_guide);
        kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(R.id.iv_guide)");
        View viewFindViewById2 = view.findViewById(R.id.tv_guide);
        kotlin.jvm.internal.f0.o(viewFindViewById2, "view.findViewById(R.id.tv_guide)");
        View viewFindViewById3 = view.findViewById(R.id.btn_skip);
        kotlin.jvm.internal.f0.o(viewFindViewById3, "view.findViewById(R.id.btn_skip)");
        View viewFindViewById4 = view.findViewById(R.id.btn_ok);
        kotlin.jvm.internal.f0.o(viewFindViewById4, "view.findViewById(R.id.btn_ok)");
        ((TextView) viewFindViewById4).setText(this$0.V2().getString(R.string.device_just_know));
        ((TextView) viewFindViewById3).setVisibility(4);
        ((TextView) viewFindViewById2).setVisibility(4);
        ((ImageView) viewFindViewById).setVisibility(4);
    }

    public static final void E7(String deviceCode, boolean z10, GamepadDetailFragment this$0) {
        kotlin.jvm.internal.f0.p(deviceCode, "$deviceCode");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        ScanFragment scanFragmentA = ScanFragment.f14524f9.a(deviceCode, z10);
        scanFragmentA.U7(this$0);
        o5.a.t0(this$0.U1(), scanFragmentA);
    }

    public static /* synthetic */ void G7(GamepadDetailFragment gamepadDetailFragment, int i10, int i11, Boolean bool, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = -1;
        }
        if ((i12 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        gamepadDetailFragment.F7(i10, i11, bool);
    }

    public static final void H7(GamepadDetailFragment this$0, int i10, int i11, Boolean bool) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.k6() != null) {
            SwitchMappingModeFragment switchMappingModeFragmentA = SwitchMappingModeFragment.f15304i9.a(i10, i11, -1, (88 & 8) != 0 ? Boolean.FALSE : null, (88 & 16) != 0 ? Boolean.FALSE : null, (88 & 32) != 0 ? Boolean.FALSE : bool, (88 & 64) != 0 ? null : null);
            switchMappingModeFragmentA.C7(this$0);
            o5.a.t0(this$0.U1(), switchMappingModeFragmentA);
        }
    }

    public static final void J7(GamepadInfo deviceInfo, View view) {
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        h3.a.j().d(a.d.f31955k).withInt("type", deviceInfo.getDeviceType()).navigation();
    }

    public static final void K7(GamepadDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        m9.s.v(this$0);
    }

    public static final void L7(GamepadDetailFragment this$0, GamepadInfo deviceInfo, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        if (v5.c.f()) {
            h3.a.j().d(a.d.f31948d).navigation();
        } else {
            this$0.h(deviceInfo.getDeviceCode(), true);
        }
    }

    public static final void M7(GamepadInfo deviceInfo, GamepadDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (deviceInfo.getDeviceType() == 67 && com.flydigi.device_manager.ui.home.device.w.a(deviceInfo) == R.drawable.device_ic_battery_level_1) {
            this$0.u7();
        } else {
            this$0.R7();
        }
    }

    public static final void N7(GamepadDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.r7();
    }

    public static final void P7(GamepadDetailFragment this$0, ValueAnimator animation) {
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
    }

    public static final void d7(GamepadDetailFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.c7();
    }

    @hk.m
    @yt.k
    public static final GamepadDetailFragment e7(@yt.k GamepadInfo gamepadInfo) {
        return L8.a(gamepadInfo);
    }

    @hk.m
    @yt.k
    public static final GamepadDetailFragment f7(@yt.k String str, @yt.l Boolean bool, @yt.l Boolean bool2) {
        return L8.b(str, bool, bool2);
    }

    public static final void h7(GamepadDetailFragment this$0, ValueAnimator animation) {
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
    }

    public static final void i7(GamepadDetailFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        GamepadInfo gamepadInfoK6 = this$0.k6();
        if (gamepadInfoK6 != null) {
            this$0.p7(gamepadInfoK6);
        }
    }

    public static final void l7(GamepadDetailFragment this$0, GamepadInfo deviceInfo, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        this$0.Q7(deviceInfo);
    }

    public static final void m7(GamepadDetailFragment this$0, GamepadInfo deviceInfo, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        this$0.S7(deviceInfo);
    }

    public static final void n7(GamepadDetailFragment this$0, GamepadInfo deviceInfo, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        G7(this$0, deviceInfo.getMappingMode(), 0, Boolean.FALSE, 2, null);
    }

    public static final void o7(GamepadDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        com.flydigi.userBehavior.a.a().b(this$0.X1(), "外设管理_设备详情页_空间站");
        h3.a.j().d(a.d.f31956l).navigation();
    }

    public static final void q7(GamepadDetailFragment this$0, GamepadInfo deviceInfo) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.G(this$0).p(Integer.valueOf(a5.b.m(deviceInfo.getDeviceCode(), Boolean.valueOf(deviceInfo.getIpType()), deviceInfo.getDeviceType())));
        u0 u0Var = this$0.H8;
        if (u0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var = null;
        }
        hVarP.s1(u0Var.f10498g.f10133d);
        u0 u0Var2 = this$0.H8;
        if (u0Var2 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var2 = null;
        }
        u0Var2.f10498g.f10134e.setText(a5.b.d(deviceInfo.getDeviceCode(), Boolean.valueOf(deviceInfo.getIpType()), deviceInfo.getDeviceType()));
        u0 u0Var3 = this$0.H8;
        if (u0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var3 = null;
        }
        u0Var3.f10498g.f10137h.setText(a5.b.n(deviceInfo.getDeviceCode(), Boolean.valueOf(deviceInfo.getIpType()), deviceInfo.getDeviceType()));
        u0 u0Var4 = this$0.H8;
        if (u0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var4 = null;
        }
        TextView textView = u0Var4.f10498g.f10136g;
        int connectState = deviceInfo.getConnectState();
        if (connectState == 0) {
            textView.setText(this$0.c3(R.string.device_state_unconnected));
            textView.setTextColor(h0.d.f(textView.getContext(), R.color.color_fa5555));
        } else if (connectState == 1) {
            textView.setText(this$0.c3(R.string.device_state_connecting));
            textView.setTextColor(h0.d.f(textView.getContext(), R.color.colorText_f5a623));
        } else if (connectState == 2) {
            textView.setText(this$0.c3(R.string.device_state_connected));
            textView.setTextColor(h0.d.f(textView.getContext(), R.color.color_5dd522));
        }
        if (deviceInfo.isConnected()) {
            u0 u0Var5 = this$0.H8;
            if (u0Var5 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var5 = null;
            }
            TextView textView2 = u0Var5.f10498g.f10135f;
            kotlin.jvm.internal.f0.o(textView2, "viewBinding.areaDeviceCard.tvMappingMode");
            Boolean bool = Boolean.TRUE;
            o5.c.b(textView2, bool, false, 2, null);
            u0 u0Var6 = this$0.H8;
            if (u0Var6 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var6 = null;
            }
            View view = u0Var6.f10498g.f10139j;
            kotlin.jvm.internal.f0.o(view, "viewBinding.areaDeviceCard.viewDivider2");
            o5.c.b(view, bool, false, 2, null);
            if (deviceInfo.getBattery() == 0) {
                u0 u0Var7 = this$0.H8;
                if (u0Var7 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var7 = null;
                }
                ImageView imageView = u0Var7.f10498g.f10132c;
                kotlin.jvm.internal.f0.o(imageView, "viewBinding.areaDeviceCard.ivBattery");
                Boolean bool2 = Boolean.FALSE;
                o5.c.b(imageView, bool2, false, 2, null);
                u0 u0Var8 = this$0.H8;
                if (u0Var8 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var8 = null;
                }
                View view2 = u0Var8.f10498g.f10138i;
                kotlin.jvm.internal.f0.o(view2, "viewBinding.areaDeviceCard.viewDivider1");
                o5.c.b(view2, bool2, false, 2, null);
            } else {
                u0 u0Var9 = this$0.H8;
                if (u0Var9 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var9 = null;
                }
                ImageView imageView2 = u0Var9.f10498g.f10132c;
                kotlin.jvm.internal.f0.o(imageView2, "viewBinding.areaDeviceCard.ivBattery");
                o5.c.b(imageView2, bool, false, 2, null);
                u0 u0Var10 = this$0.H8;
                if (u0Var10 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var10 = null;
                }
                View view3 = u0Var10.f10498g.f10138i;
                kotlin.jvm.internal.f0.o(view3, "viewBinding.areaDeviceCard.viewDivider1");
                o5.c.b(view3, bool, false, 2, null);
                u0 u0Var11 = this$0.H8;
                if (u0Var11 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var11 = null;
                }
                u0Var11.f10498g.f10132c.setImageResource(com.flydigi.device_manager.ui.home.device.w.a(deviceInfo));
            }
            u0 u0Var12 = this$0.H8;
            if (u0Var12 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var12 = null;
            }
            u0Var12.f10498g.f10135f.setText(com.flydigi.device_manager.ui.home.device.w.c(deviceInfo, null, 1, null));
            u0 u0Var13 = this$0.H8;
            if (u0Var13 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var13 = null;
            }
            ActionItemNormal actionItemNormal = u0Var13.f10496e;
            Boolean bool3 = Boolean.FALSE;
            actionItemNormal.Q(this$0.c3(com.flydigi.device_manager.ui.home.device.w.b(deviceInfo, bool3)));
            if (!deviceInfo.isGamepadHalf() || u9.b.d()) {
                u0 u0Var14 = this$0.H8;
                if (u0Var14 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var14 = null;
                }
                TextView textView3 = u0Var14.f10498g.f10135f;
                kotlin.jvm.internal.f0.o(textView3, "viewBinding.areaDeviceCard.tvMappingMode");
                o5.c.b(textView3, bool, false, 2, null);
                u0 u0Var15 = this$0.H8;
                if (u0Var15 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var15 = null;
                }
                View view4 = u0Var15.f10498g.f10139j;
                kotlin.jvm.internal.f0.o(view4, "viewBinding.areaDeviceCard.viewDivider2");
                o5.c.b(view4, bool, false, 2, null);
            } else {
                u0 u0Var16 = this$0.H8;
                if (u0Var16 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var16 = null;
                }
                TextView textView4 = u0Var16.f10498g.f10135f;
                kotlin.jvm.internal.f0.o(textView4, "viewBinding.areaDeviceCard.tvMappingMode");
                o5.c.b(textView4, bool3, false, 2, null);
                u0 u0Var17 = this$0.H8;
                if (u0Var17 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    u0Var17 = null;
                }
                View view5 = u0Var17.f10498g.f10139j;
                kotlin.jvm.internal.f0.o(view5, "viewBinding.areaDeviceCard.viewDivider2");
                o5.c.b(view5, bool3, false, 2, null);
            }
        } else {
            u0 u0Var18 = this$0.H8;
            if (u0Var18 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var18 = null;
            }
            TextView textView5 = u0Var18.f10498g.f10135f;
            kotlin.jvm.internal.f0.o(textView5, "viewBinding.areaDeviceCard.tvMappingMode");
            Boolean bool4 = Boolean.FALSE;
            o5.c.b(textView5, bool4, false, 2, null);
            u0 u0Var19 = this$0.H8;
            if (u0Var19 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var19 = null;
            }
            View view6 = u0Var19.f10498g.f10139j;
            kotlin.jvm.internal.f0.o(view6, "viewBinding.areaDeviceCard.viewDivider2");
            o5.c.b(view6, bool4, false, 2, null);
            u0 u0Var20 = this$0.H8;
            if (u0Var20 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var20 = null;
            }
            View view7 = u0Var20.f10498g.f10138i;
            kotlin.jvm.internal.f0.o(view7, "viewBinding.areaDeviceCard.viewDivider1");
            o5.c.b(view7, bool4, false, 2, null);
            u0 u0Var21 = this$0.H8;
            if (u0Var21 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var21 = null;
            }
            ImageView imageView3 = u0Var21.f10498g.f10132c;
            kotlin.jvm.internal.f0.o(imageView3, "viewBinding.areaDeviceCard.ivBattery");
            o5.c.b(imageView3, bool4, false, 2, null);
        }
        this$0.I7(deviceInfo);
        this$0.k7(deviceInfo);
        this$0.t7(deviceInfo);
        TipView tipView = this$0.C8;
        if (tipView != null) {
            tipView.removeCallbacks(this$0.K8);
        }
        if (!deviceInfo.isDriverConnected()) {
            this$0.c7();
            return;
        }
        TipView tipView2 = this$0.C8;
        if (tipView2 != null) {
            tipView2.e(false);
        }
        this$0.J8 = false;
    }

    public static final void s7(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void v7(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void w7(GamepadDetailFragment this$0, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        dialogFragment.I5();
        this$0.j7();
    }

    public static final void y7(String deviceCode, View view, final p3.b bVar) {
        kotlin.jvm.internal.f0.p(deviceCode, "$deviceCode");
        View viewFindViewById = view.findViewById(R.id.iv_guide_bg);
        kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(R.id.iv_guide_bg)");
        ImageView imageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_guide);
        kotlin.jvm.internal.f0.o(viewFindViewById2, "view.findViewById(R.id.iv_guide)");
        ImageView imageView2 = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_guide);
        kotlin.jvm.internal.f0.o(viewFindViewById3, "view.findViewById(R.id.tv_guide)");
        TextView textView = (TextView) viewFindViewById3;
        int identifier = imageView.getContext().getResources().getIdentifier("device_guide_gamepad_" + deviceCode + "_1_bg", "drawable", j1.a().getPackageName());
        if (identifier != 0) {
            o5.c.b(imageView, Boolean.TRUE, false, 2, null);
            com.bumptech.glide.b.F(imageView).p(Integer.valueOf(identifier)).s1(imageView);
        } else {
            o5.c.b(imageView, Boolean.FALSE, false, 2, null);
        }
        int identifier2 = imageView2.getContext().getResources().getIdentifier("device_guide_gamepad_" + deviceCode + "_1", "drawable", j1.a().getPackageName());
        if (identifier2 != 0) {
            o5.c.b(imageView2, Boolean.TRUE, false, 2, null);
            com.bumptech.glide.b.F(imageView2).p(Integer.valueOf(identifier2)).s1(imageView2);
        } else {
            o5.c.b(imageView2, Boolean.FALSE, false, 2, null);
        }
        int identifier3 = imageView.getContext().getResources().getIdentifier("device_guide_gamepad_" + deviceCode + "_1", w.b.f53669e, j1.a().getPackageName());
        if (identifier3 != 0) {
            o5.c.b(textView, Boolean.TRUE, false, 2, null);
            textView.setText(identifier3);
        } else {
            o5.c.b(textView, Boolean.FALSE, false, 2, null);
        }
        com.blankj.utilcode.util.o.r(view.findViewById(R.id.btn_skip), new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GamepadDetailFragment.z7(bVar, view2);
            }
        });
    }

    public static final void z7(p3.b bVar, View view) {
        bVar.l();
    }

    @Override // com.flydigi.device_manager.ui.connection.ScanFragment.b
    public void F() {
        this.E8 = false;
    }

    public final void F7(final int i10, final int i11, final Boolean bool) {
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.o
            @Override // java.lang.Runnable
            public final void run() {
                GamepadDetailFragment.H7(this.f14624a, i10, i11, bool);
            }
        });
    }

    public final void I7(final GamepadInfo gamepadInfo) {
        TipView tipView;
        if (gamepadInfo.isConnecting() || (tipView = this.C8) == null) {
            return;
        }
        if (!v5.c.f() && !m9.s.s()) {
            O7();
            tipView.f(false, R.string.device_tips_bluetooth_closed, R.string.device_tips_bluetooth_closed_desc, R.string.device_setting_now, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GamepadDetailFragment.K7(this.f14817a, view);
                }
            }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
            tipView.setTag(R.id.device_tag_tip_type, 1);
            tipView.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
            return;
        }
        if (gamepadInfo.isDisconnected()) {
            O7();
            tipView.f(false, R.string.device_tips_gamepad_disconnected, v5.c.f() ? R.string.device_tips_gamepad_disconnected_desc_emulator : R.string.device_tips_gamepad_disconnected_desc, v5.c.f() ? R.string.device_connect_emulator_manual : R.string.device_tips_action_connect_again, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GamepadDetailFragment.L7(this.f14819a, gamepadInfo, view);
                }
            }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
            tipView.setTag(R.id.device_tag_tip_type, 2);
            tipView.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
            return;
        }
        if (!v5.c.f() && gamepadInfo.isConnected() && gamepadInfo.isDriverMode() && !gamepadInfo.isDriverConnected()) {
            O7();
            tipView.f(false, R.string.device_tips_flymapping_inactive_desc, R.string.device_tips_flymapping_inactive, R.string.device_tips_action_activate, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GamepadDetailFragment.M7(gamepadInfo, this, view);
                }
            }, null, 1, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GamepadDetailFragment.N7(this.f14638a, view);
                }
            });
            tipView.setTag(R.id.device_tag_tip_type, 3);
            tipView.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
            return;
        }
        if (v5.c.f() || !gamepadInfo.isConnected() || (!(gamepadInfo.getDeviceType() == 48 || gamepadInfo.getDeviceType() == 50) || gamepadInfo.isGamepadKeyboard())) {
            g7();
            return;
        }
        O7();
        tipView.f(false, R.string.device_tips_keyboard_disconnected, R.string.device_tips_keyboard_disconnected_desc, R.string.device_tips_action_connect, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GamepadDetailFragment.J7(gamepadInfo, view);
            }
        }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
        tipView.setTag(R.id.device_tag_tip_type, 5);
        tipView.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.E8 = bundleT1 != null ? bundleT1.getBoolean(DataConstant.DEVICE_KEY_AUTO_CONNECT) : false;
        Bundle bundleT12 = T1();
        this.F8 = bundleT12 != null ? bundleT12.getBoolean(DataConstant.DEVICE_KEY_AUTO_SWITCH_MODE) : false;
        this.A8 = new DetailPresenter(this);
        this.B8 = new FirmwarePresenter(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_gamepad_detail;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        QAItem qAItem;
        DeviceDetailBean.QaListBean qaListBeanD;
        kotlin.jvm.internal.f0.p(view, "view");
        if (i10 == -1 || (qAItem = (QAItem) this.G8.g2(i10)) == null || (qaListBeanD = qAItem.D()) == null) {
            return false;
        }
        int dataType = qaListBeanD.getDataType();
        if (dataType != 1) {
            if (dataType != 2) {
                return false;
            }
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_TITLE, qaListBeanD.getName()).withString(DataConstant.WEB_URL, qaListBeanD.getData()).navigation();
            return true;
        }
        Postcard postcardD = h3.a.j().d(a.b.f31919d);
        String data = qaListBeanD.getData();
        kotlin.jvm.internal.f0.o(data, "it.data");
        postcardD.withInt("id", Integer.parseInt(data)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13284b).navigation();
        return true;
    }

    @Override // com.flydigi.device_manager.ui.connection.ScanFragment.b
    public void O() {
        this.E8 = false;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        u0 u0VarD = u0.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(u0VarD, "inflate(inflater, container, false)");
        this.H8 = u0VarD;
        if (u0VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0VarD = null;
        }
        NestedScrollView nestedScrollViewB = u0VarD.getRoot();
        kotlin.jvm.internal.f0.o(nestedScrollViewB, "viewBinding.root");
        return nestedScrollViewB;
    }

    public final void O7() {
        TipView tipView = this.C8;
        if (tipView != null && tipView.getVisibility() == 0) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, V2().getDimensionPixelSize(R.dimen.qb_px_130));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.flydigi.device_manager.ui.detail.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GamepadDetailFragment.P7(this.f14611a, valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new f());
        valueAnimatorOfInt.setDuration(250L);
        valueAnimatorOfInt.start();
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        m.a.e(this, z10);
        u0 u0Var = this.H8;
        if (u0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var = null;
        }
        u0Var.f10501j.getRoot().post(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.m
            @Override // java.lang.Runnable
            public final void run() {
                GamepadDetailFragment.i7(this.f14622a);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment.b
    public void Q(int i10, int i11) {
        SwitchMappingModeFragment.b.a.a(this, i10, i11);
    }

    public final void Q7(GamepadInfo gamepadInfo) {
        if (gamepadInfo.isConnected()) {
            if (gamepadInfo.isDriverMode() && !gamepadInfo.isDriverConnected()) {
                com.flydigi.base.common.o.E(c3(R.string.device_active_mapping_before_testing));
                return;
            }
            if ((gamepadInfo.getDeviceType() == 48 || gamepadInfo.getDeviceType() == 50) && !gamepadInfo.isGamepadKeyboard()) {
                com.flydigi.base.common.o.E(c3(R.string.device_please_connect_keyboard_and_mouse));
            } else if (!o5.d.o(X1())) {
                h3.a.j().d(a.d.f31959o).navigation(w1());
            } else {
                com.flydigi.userBehavior.a.a().b(w1(), "外设管理_设备详情页_按键测试");
                h3.a.j().d(a.d.f31954j).withString("key_device_code", gamepadInfo.getDeviceCode()).withParcelable("key_device_info", gamepadInfo).navigation();
            }
        }
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
        m.a.a(this);
    }

    public final void R7() {
        if (!o5.b.i(X1())) {
            j7();
            return;
        }
        i9.b.f(this, DataConstant.REMOTE_ACTION_START_DRIVER_MANUAL);
        this.J8 = true;
        TipView tipView = this.C8;
        if (tipView != null) {
            if (kotlin.jvm.internal.f0.g(tipView.getTag(R.id.device_tag_tip_type), 3)) {
                tipView.e(true);
            }
            tipView.removeCallbacks(this.K8);
            tipView.postDelayed(this.K8, 5000L);
        }
    }

    public final void S7(GamepadInfo gamepadInfo) {
        if (gamepadInfo.isSupportFlashplay() || gamepadInfo.isDisconnected()) {
            h3.a.j().d(a.d.f31952h).withString("key_device_code", gamepadInfo.getDeviceCode()).navigation(w1());
        } else {
            h3.a.j().d(a.d.f31951g).withString("key_device_code", gamepadInfo.getDeviceCode()).withString("device_name", gamepadInfo.getDeviceName()).withString(DataConstant.DEVICE_ADDRESS, gamepadInfo.getAddress()).withString(DataConstant.DEVICE_KEY_FIRMWARE_VERSION, gamepadInfo.getFirmwareVersion()).withBoolean(DataConstant.DEVICE_KEY_REMOVE_BOND_WHEN_UPGRADE_FIRMWARE, true).navigation(w1());
        }
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void T0() {
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void W0() {
        u0 u0Var = this.H8;
        if (u0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = u0Var.f10494c;
        GamepadInfo gamepadInfoK6 = k6();
        firmwareUpgradeActionItem.Q(gamepadInfoK6 != null ? gamepadInfoK6.getFirmwareVersion() : null);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void Y0(@yt.k List<? extends FirmwareInfoBean> data) {
        kotlin.jvm.internal.f0.p(data, "data");
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        m.a.b(this);
    }

    public final void c7() {
        GamepadInfo gamepadInfoK6 = k6();
        if (((gamepadInfoK6 == null || gamepadInfoK6.isDriverConnected()) ? false : true) && this.J8) {
            j7();
        }
        this.J8 = false;
        TipView tipView = this.C8;
        if (tipView != null) {
            tipView.e(false);
        }
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        m9.s.A(this);
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        kotlin.jvm.internal.f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).l(X1(), DataConstant.REMOTE_ACTION_REQUEST_BLUETOOTH_STATE);
    }

    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void g4(@yt.k Bundle outState) {
        kotlin.jvm.internal.f0.p(outState, "outState");
        super.g4(outState);
        outState.putParcelable("key_device_info", k6());
    }

    public final void g7() {
        TipView tipView = this.C8;
        if (tipView != null && tipView.getVisibility() == 0) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(V2().getDimensionPixelSize(R.dimen.qb_px_130), 0);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.flydigi.device_manager.ui.detail.q
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GamepadDetailFragment.h7(this.f14630a, valueAnimator);
                }
            });
            valueAnimatorOfInt.addListener(new b());
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.start();
        }
    }

    @Override // com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment.b, com.flydigi.device_manager.ui.mapping_mode.TraditionMappingModeFragment.b
    public void h(@yt.k final String deviceCode, final boolean z10) {
        kotlin.jvm.internal.f0.p(deviceCode, "deviceCode");
        this.F8 = false;
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.r
            @Override // java.lang.Runnable
            public final void run() {
                GamepadDetailFragment.E7(deviceCode, z10, this);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void i(@yt.k FirmwareInfoBean data) {
        String firmwareVersion;
        kotlin.jvm.internal.f0.p(data, "data");
        u0 u0Var = this.H8;
        if (u0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = u0Var.f10494c;
        kotlin.jvm.internal.f0.o(firmwareUpgradeActionItem, "viewBinding.actionFirmwareUpgrade");
        GamepadInfo gamepadInfoK6 = k6();
        if (gamepadInfoK6 == null || (firmwareVersion = gamepadInfoK6.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        FirmwareUpgradeActionItem.U(firmwareUpgradeActionItem, firmwareVersion, Boolean.TRUE, null, 4, null);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        Fragment fragmentS = o5.a.s(U1(), ScanFragment.class);
        if (fragmentS != null) {
            com.blankj.utilcode.util.d0.c0(fragmentS);
        }
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        GamepadInfo gamepadInfo;
        int deviceType;
        androidx.fragment.app.g gVarW1;
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        this.C8 = (TipView) view.findViewById(R.id.area_todo_tips);
        u0 u0Var = this.H8;
        String str = null;
        if (u0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var = null;
        }
        boolean z10 = false;
        u0Var.f10502k.n(new a.C0280a(X1()).A(V2().getDimensionPixelSize(R.dimen.qb_px_16), 0).m(R.drawable.base_view_divider).y());
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString(T8) : null;
        if (string == null) {
            string = "all";
        }
        this.D8 = string;
        if (bundle != null) {
            gamepadInfo = (GamepadInfo) bundle.getParcelable("key_device_info");
        } else {
            Bundle bundleT12 = T1();
            gamepadInfo = bundleT12 != null ? (GamepadInfo) bundleT12.getParcelable("key_device_info") : null;
        }
        y6(gamepadInfo);
        String str2 = this.D8;
        if (str2 == null) {
            kotlin.jvm.internal.f0.S("selectedDeviceCode");
            str2 = null;
        }
        if ((str2.length() == 0) && (gVarW1 = w1()) != null) {
            gVarW1.finish();
        }
        GamepadInfo gamepadInfoK6 = k6();
        if (gamepadInfoK6 != null) {
            if (gamepadInfoK6.getDeviceType() == 0) {
                String str3 = this.D8;
                if (str3 == null) {
                    kotlin.jvm.internal.f0.S("selectedDeviceCode");
                    str3 = null;
                }
                deviceType = m9.t.l(str3);
            } else {
                deviceType = gamepadInfoK6.getDeviceType();
            }
            int i10 = deviceType;
            if (i10 != 0) {
                String str4 = this.D8;
                if (str4 == null) {
                    kotlin.jvm.internal.f0.S("selectedDeviceCode");
                    str4 = null;
                }
                if (!n0.b(str4, gamepadInfoK6.getDeviceCode())) {
                    m9.q.z(gamepadInfoK6, i10, gamepadInfoK6.getChipType(), 0, 8, null);
                }
            }
            p7(gamepadInfoK6);
        }
        c.a aVar = this.A8;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("mPresenter");
            aVar = null;
        }
        String str5 = this.D8;
        if (str5 == null) {
            kotlin.jvm.internal.f0.S("selectedDeviceCode");
            str5 = null;
        }
        aVar.x(str5);
        if (this.E8) {
            GamepadInfo gamepadInfoK62 = k6();
            if (gamepadInfoK62 != null && !gamepadInfoK62.isConnected()) {
                z10 = true;
            }
            if (z10) {
                String str6 = this.D8;
                if (str6 == null) {
                    kotlin.jvm.internal.f0.S("selectedDeviceCode");
                } else {
                    str = str6;
                }
                h(str, true);
            }
        }
    }

    public final void j7() {
        GamepadInfo gamepadInfoK6 = k6();
        if (gamepadInfoK6 != null) {
            h3.a.j().d(a.d.f31950f).withString("key_device_code", gamepadInfoK6.getDeviceCode()).navigation();
        }
    }

    public final void k7(final GamepadInfo gamepadInfo) {
        u0 u0Var = this.H8;
        u0 u0Var2 = null;
        if (u0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var = null;
        }
        MappingTestActionItem mappingTestActionItem = u0Var.f10497f;
        int i10 = 8;
        mappingTestActionItem.setVisibility(gamepadInfo.isConnected() ? 0 : 8);
        com.blankj.utilcode.util.o.r(mappingTestActionItem, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GamepadDetailFragment.l7(this.f14605a, gamepadInfo, view);
            }
        });
        if (v5.c.f()) {
            u0 u0Var3 = this.H8;
            if (u0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var3 = null;
            }
            FirmwareUpgradeActionItem firmwareUpgradeActionItem = u0Var3.f10494c;
            kotlin.jvm.internal.f0.o(firmwareUpgradeActionItem, "viewBinding.actionFirmwareUpgrade");
            Boolean bool = Boolean.FALSE;
            o5.c.b(firmwareUpgradeActionItem, bool, false, 2, null);
            u0 u0Var4 = this.H8;
            if (u0Var4 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var4 = null;
            }
            ActionItemNormal actionItemNormal = u0Var4.f10496e;
            kotlin.jvm.internal.f0.o(actionItemNormal, "viewBinding.actionSwitchMappingMode");
            o5.c.b(actionItemNormal, bool, false, 2, null);
            u0 u0Var5 = this.H8;
            if (u0Var5 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var5 = null;
            }
            ActionItemNormal actionItemNormal2 = u0Var5.f10493b;
            kotlin.jvm.internal.f0.o(actionItemNormal2, "viewBinding.actionApexSpace");
            o5.c.b(actionItemNormal2, bool, false, 2, null);
            return;
        }
        u0 u0Var6 = this.H8;
        if (u0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var6 = null;
        }
        FirmwareUpgradeActionItem it2 = u0Var6.f10494c;
        kotlin.jvm.internal.f0.o(it2, "it");
        o5.c.b(it2, Boolean.valueOf(gamepadInfo.isConnected() || gamepadInfo.getChipType() == 0), false, 2, null);
        if (gamepadInfo.isConnected()) {
            String firmwareVersion = gamepadInfo.getFirmwareVersion();
            String str = firmwareVersion != null ? firmwareVersion : "";
            Boolean bool2 = Boolean.FALSE;
            it2.T(str, bool2, bool2);
        } else {
            Boolean bool3 = Boolean.FALSE;
            it2.T("", bool3, bool3);
        }
        com.blankj.utilcode.util.o.r(it2, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GamepadDetailFragment.m7(this.f14600a, gamepadInfo, view);
            }
        });
        u0 u0Var7 = this.H8;
        if (u0Var7 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var7 = null;
        }
        ActionItemNormal actionItemNormal3 = u0Var7.f10496e;
        actionItemNormal3.setVisibility((gamepadInfo.isConnected() && gamepadInfo.isSupportFlashplay() && com.flydigi.device_manager.ui.p.a() && (!gamepadInfo.isGamepadHalf() || u9.b.d())) ? 0 : 8);
        com.blankj.utilcode.util.o.r(actionItemNormal3, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GamepadDetailFragment.n7(this.f14603a, gamepadInfo, view);
            }
        });
        u0 u0Var8 = this.H8;
        if (u0Var8 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            u0Var2 = u0Var8;
        }
        ActionItemNormal actionItemNormal4 = u0Var2.f10493b;
        if (gamepadInfo.isSupportLed() && gamepadInfo.isConnected()) {
            i10 = 0;
        }
        actionItemNormal4.setVisibility(i10);
        com.blankj.utilcode.util.o.r(actionItemNormal4, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GamepadDetailFragment.o7(this.f14818a, view);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
        m.a.c(this);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void o0() {
    }

    public final void p7(final GamepadInfo gamepadInfo) {
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.p
            @Override // java.lang.Runnable
            public final void run() {
                GamepadDetailFragment.q7(this.f14628a, gamepadInfo);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
        m.a.d(this, i10);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@yt.k GamepadInfo deviceInfo) {
        kotlin.jvm.internal.f0.p(deviceInfo, "deviceInfo");
        a.InterfaceC0156a interfaceC0156a = null;
        if (!v5.c.f() && deviceInfo.isDisconnected()) {
            String deviceCode = deviceInfo.getDeviceCode();
            String str = this.D8;
            if (str == null) {
                kotlin.jvm.internal.f0.S("selectedDeviceCode");
                str = null;
            }
            if (!n0.b(deviceCode, str)) {
                return;
            }
        }
        if (deviceInfo.isConnected() && deviceInfo.isGamepadKeyboard()) {
            u0 u0Var = this.H8;
            if (u0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var = null;
            }
            View viewFindViewById = u0Var.f10497f.findViewById(R.id.area_usb);
            kotlin.jvm.internal.f0.o(viewFindViewById, "viewBinding.actionTest.f…ById<View>(R.id.area_usb)");
            o5.c.b(viewFindViewById, Boolean.TRUE, false, 2, null);
        } else {
            u0 u0Var2 = this.H8;
            if (u0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var2 = null;
            }
            View viewFindViewById2 = u0Var2.f10497f.findViewById(R.id.area_usb);
            kotlin.jvm.internal.f0.o(viewFindViewById2, "viewBinding.actionTest.f…ById<View>(R.id.area_usb)");
            o5.c.b(viewFindViewById2, Boolean.FALSE, false, 2, null);
        }
        String str2 = this.D8;
        if (str2 == null) {
            kotlin.jvm.internal.f0.S("selectedDeviceCode");
            str2 = null;
        }
        if (!n0.b(str2, deviceInfo.getDeviceCode()) && !n0.b("all", deviceInfo.getDeviceCode())) {
            this.D8 = deviceInfo.getDeviceCode();
            c.a aVar = this.A8;
            if (aVar == null) {
                kotlin.jvm.internal.f0.S("mPresenter");
                aVar = null;
            }
            aVar.x(deviceInfo.getDeviceCode());
        }
        p7(deviceInfo);
        if (!deviceInfo.isConnected()) {
            this.I8 = true;
            return;
        }
        this.I8 = false;
        this.E8 = false;
        a.InterfaceC0156a interfaceC0156a2 = this.B8;
        if (interfaceC0156a2 == null) {
            kotlin.jvm.internal.f0.S("firmwarePresenter");
        } else {
            interfaceC0156a = interfaceC0156a2;
        }
        interfaceC0156a.b(m9.t.m(deviceInfo), deviceInfo.getFirmwareVersion());
        if (this.F8 && deviceInfo.isFlashplayMode() && deviceInfo.isGamepadHalf() && !u9.b.d()) {
            F7(deviceInfo.getMappingMode(), 0, Boolean.TRUE);
            return;
        }
        int iB = com.flydigi.device_manager.ui.p.b(deviceInfo);
        if (deviceInfo.getMappingMode() != -1 && iB != -1 && iB != deviceInfo.getMappingMode()) {
            F7(deviceInfo.getMappingMode(), iB, Boolean.TRUE);
        }
        if (n0.b(deviceInfo.getDeviceCode(), m9.h.f40768k)) {
            x7(deviceInfo.getDeviceCode());
        }
    }

    public final void r7() {
        new FZDialog.a().t(c3(R.string.device_driver_active_reason_title)).j(c3(R.string.device_driver_active_reason_content)).b(Boolean.FALSE).q(c3(R.string.confirm)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.detail.k
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                GamepadDetailFragment.s7(dialogFragment);
            }
        }).u(U1(), LoadingDialogFragment.E8);
    }

    public final void t7(GamepadInfo gamepadInfo) {
        u0 u0Var = null;
        if (!kotlin.jvm.internal.f0.g(gamepadInfo.getDeviceCode(), m9.h.f40773p) && !kotlin.jvm.internal.f0.g(gamepadInfo.getDeviceCode(), m9.h.f40774q) && !kotlin.jvm.internal.f0.g(gamepadInfo.getDeviceCode(), m9.h.f40770m) && !kotlin.jvm.internal.f0.g(gamepadInfo.getDeviceCode(), m9.h.f40771n)) {
            u0 u0Var2 = this.H8;
            if (u0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var2 = null;
            }
            View viewFindViewById = u0Var2.f10497f.findViewById(R.id.area_usb);
            kotlin.jvm.internal.f0.o(viewFindViewById, "viewBinding.actionTest.f…ById<View>(R.id.area_usb)");
            o5.c.b(viewFindViewById, Boolean.FALSE, false, 2, null);
            return;
        }
        if (!gamepadInfo.isGamepadKeyboard()) {
            u0 u0Var3 = this.H8;
            if (u0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var3 = null;
            }
            View viewFindViewById2 = u0Var3.f10497f.findViewById(R.id.area_usb);
            kotlin.jvm.internal.f0.o(viewFindViewById2, "viewBinding.actionTest.f…ById<View>(R.id.area_usb)");
            o5.c.b(viewFindViewById2, Boolean.FALSE, false, 2, null);
            return;
        }
        u0 u0Var4 = this.H8;
        if (u0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var4 = null;
        }
        View viewFindViewById3 = u0Var4.f10497f.findViewById(R.id.area_usb);
        kotlin.jvm.internal.f0.o(viewFindViewById3, "viewBinding.actionTest.f…ById<View>(R.id.area_usb)");
        o5.c.b(viewFindViewById3, Boolean.TRUE, false, 2, null);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(h0.d.f(j1.a(), R.color.colorPrimary));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(h0.d.f(j1.a(), R.color.color_fa5555));
        String strC3 = gamepadInfo.getUsb0Device() != 0 ? c3(R.string.device_state_connected) : c3(R.string.device_state_unconnected);
        kotlin.jvm.internal.f0.o(strC3, "if (deviceInfo.usb0Devic…nconnected)\n            }");
        v0 v0Var = v0.f37964a;
        String strC32 = c3(R.string.device_usb0);
        kotlin.jvm.internal.f0.o(strC32, "getString(R.string.device_usb0)");
        String str = String.format(strC32, Arrays.copyOf(new Object[]{strC3}, 1));
        kotlin.jvm.internal.f0.o(str, "format(format, *args)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(gamepadInfo.getUsb0Device() != 0 ? foregroundColorSpan : foregroundColorSpan2, 5, spannableStringBuilder.length(), 18);
        u0 u0Var5 = this.H8;
        if (u0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var5 = null;
        }
        ((TextView) u0Var5.f10497f.findViewById(R.id.tv_usb1_state)).setText(spannableStringBuilder);
        String strC33 = gamepadInfo.getUsb1Device() != 0 ? c3(R.string.device_state_connected) : c3(R.string.device_state_unconnected);
        kotlin.jvm.internal.f0.o(strC33, "if (deviceInfo.usb1Devic…nconnected)\n            }");
        String strC34 = c3(R.string.device_usb1);
        kotlin.jvm.internal.f0.o(strC34, "getString(R.string.device_usb1)");
        String str2 = String.format(strC34, Arrays.copyOf(new Object[]{strC33}, 1));
        kotlin.jvm.internal.f0.o(str2, "format(format, *args)");
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str2);
        if (gamepadInfo.getUsb1Device() == 0) {
            foregroundColorSpan = foregroundColorSpan2;
        }
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, spannableStringBuilder2.length(), 18);
        u0 u0Var6 = this.H8;
        if (u0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            u0Var = u0Var6;
        }
        ((TextView) u0Var.f10497f.findViewById(R.id.tv_usb2_state)).setText(spannableStringBuilder2);
    }

    public final void u7() {
        FZDialog.a aVarF = new FZDialog.a().j(c3(R.string.device_driver_active_low_battery)).b(Boolean.FALSE).d(c3(R.string.cancel)).g(c3(R.string.device_driver_active)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.detail.l
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                GamepadDetailFragment.v7(dialogFragment);
            }
        }).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.detail.j
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                GamepadDetailFragment.w7(this.f14619a, dialogFragment);
            }
        });
        Context contextX1 = X1();
        kotlin.jvm.internal.f0.n(contextX1, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        aVarF.u(((androidx.fragment.app.g) contextX1).n3(), "lowBattery");
    }

    @Override // com.flydigi.device_manager.ui.detail.c.b
    public void v(@yt.k DeviceDetailBean detailBean) {
        kotlin.jvm.internal.f0.p(detailBean, "detailBean");
        List<DeviceDetailBean.QaListBean> qaList = detailBean.getQaList();
        u0 u0Var = null;
        if (qaList == null || qaList.isEmpty()) {
            u0 u0Var2 = this.H8;
            if (u0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var2 = null;
            }
            LinearLayout linearLayout = u0Var2.f10500i;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.areaQa");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
            return;
        }
        u0 u0Var3 = this.H8;
        if (u0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var3 = null;
        }
        if (u0Var3.f10502k.getAdapter() == null) {
            u0 u0Var4 = this.H8;
            if (u0Var4 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                u0Var4 = null;
            }
            u0Var4.f10502k.setAdapter(this.G8);
        }
        u0 u0Var5 = this.H8;
        if (u0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var5 = null;
        }
        LinearLayout linearLayout2 = u0Var5.f10500i;
        kotlin.jvm.internal.f0.o(linearLayout2, "viewBinding.areaQa");
        o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
        u0 u0Var6 = this.H8;
        if (u0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            u0Var = u0Var6;
        }
        u0Var.f10503l.setText(detailBean.getQaTitle());
        this.G8.m1();
        List<DeviceDetailBean.QaListBean> qaList2 = detailBean.getQaList();
        kotlin.jvm.internal.f0.o(qaList2, "detailBean.qaList");
        for (DeviceDetailBean.QaListBean it2 : qaList2) {
            eu.davidea.flexibleadapter.b<QAItem> bVar = this.G8;
            kotlin.jvm.internal.f0.o(it2, "it");
            bVar.K0(new QAItem(it2));
        }
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void v6() {
        super.v6();
        TipView tipView = this.C8;
        if (tipView != null) {
            if (kotlin.jvm.internal.f0.g(tipView.getTag(R.id.device_tag_tip_type), 3)) {
                tipView.e(true);
            }
            tipView.removeCallbacks(this.K8);
            tipView.postDelayed(this.K8, e1.f2443l);
        }
    }

    public final void x7(final String str) {
        p3.a aVarG = o3.b.d(this).f(str).g(new c());
        com.app.hubert.guide.model.a aVarD = com.app.hubert.guide.model.a.D();
        int i10 = R.layout.device_page_new_device_guide;
        com.app.hubert.guide.model.a aVarI = aVarD.I(i10, new int[0]);
        Application applicationA = j1.a();
        int i11 = R.color.color_000000_a50;
        p3.a aVarA = aVarG.a(aVarI.E(h0.d.f(applicationA, i11)).J(new r3.d() { // from class: com.flydigi.device_manager.ui.detail.t
            @Override // r3.d
            public final void a(View view, p3.b bVar) {
                GamepadDetailFragment.y7(str, view, bVar);
            }
        })).a(com.app.hubert.guide.model.a.D().I(i10, new int[0]).E(h0.d.f(j1.a(), i11)).J(new r3.d() { // from class: com.flydigi.device_manager.ui.detail.u
            @Override // r3.d
            public final void a(View view, p3.b bVar) {
                GamepadDetailFragment.A7(str, view, bVar);
            }
        }));
        com.app.hubert.guide.model.a aVarD2 = com.app.hubert.guide.model.a.D();
        u0 u0Var = this.H8;
        u0 u0Var2 = null;
        if (u0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            u0Var = null;
        }
        MappingTestActionItem mappingTestActionItem = u0Var.f10497f;
        int i12 = R.layout.device_page_new_device_guide_highlight;
        p3.a aVarA2 = aVarA.a(aVarD2.m(mappingTestActionItem, new d(str, i12)).E(h0.d.f(j1.a(), i11)).I(i10, new int[0]).J(new r3.d() { // from class: com.flydigi.device_manager.ui.detail.v
            @Override // r3.d
            public final void a(View view, p3.b bVar) {
                GamepadDetailFragment.C7(view, bVar);
            }
        }));
        com.app.hubert.guide.model.a aVarD3 = com.app.hubert.guide.model.a.D();
        u0 u0Var3 = this.H8;
        if (u0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            u0Var2 = u0Var3;
        }
        aVarA2.a(aVarD3.m(u0Var2.f10493b, new e(str, i12)).I(i10, new int[0]).E(h0.d.f(j1.a(), i11)).J(new r3.d() { // from class: com.flydigi.device_manager.ui.detail.s
            @Override // r3.d
            public final void a(View view, p3.b bVar) {
                GamepadDetailFragment.D7(this.f14634a, view, bVar);
            }
        })).i(1).d().p();
    }
}
