package com.flydigi.device_manager.ui.detail.waspwing.b6;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.k0;
import androidx.lifecycle.z0;
import c7.d0;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.e0;
import com.blankj.utilcode.util.s0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.DetailPresenter;
import com.flydigi.device_manager.ui.detail.c;
import com.flydigi.device_manager.ui.detail.item.QAItem;
import com.flydigi.device_manager.ui.detail.waspwing.ScanFragment;
import com.flydigi.device_manager.ui.detail.waspwing.b6.more.MoreSettingActivity;
import com.flydigi.device_manager.ui.detail.waspwing.b6.protection.ProtectionActivity;
import com.flydigi.device_manager.ui.detail.waspwing.led.LedActivity;
import com.flydigi.device_manager.ui.detail.waspwing.runmode.ExperimentalRunModeActivity;
import com.flydigi.device_manager.ui.detail.waspwing.runmode.RunModeSelectionActivity;
import com.flydigi.device_manager.ui.firmware.FirmwarePresenter;
import com.flydigi.device_manager.ui.firmware.a;
import com.flydigi.device_manager.ui.home.device.TipView;
import com.flydigi.device_manager.view.FirmwareUpgradeActionItem;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.yqritc.recyclerviewflexibledivider.a;
import eu.davidea.flexibleadapter.b;
import f.b;
import i9.a;
import java.util.HashMap;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.b0;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z;
import kotlin.z1;
import p1.a;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nB6DetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 B6DetailFragment.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b6/B6DetailFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,549:1\n106#2,15:550\n1855#3,2:565\n*S KotlinDebug\n*F\n+ 1 B6DetailFragment.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b6/B6DetailFragment\n*L\n81#1:550,15\n470#1:565,2\n*E\n"})
public final class B6DetailFragment extends FZFragment implements c.b, a.b, b.z, com.flydigi.sdk.bluetooth.m {

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.k
    public static final a f14660x8 = new a(null);

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final int f14661y8 = 1;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public static final int f14662z8 = 2;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.l
    public DialogFragment f14663o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public String f14664p8 = t9.c.f50958g;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public int f14665q8 = -1;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<QAItem> f14666r8 = new eu.davidea.flexibleadapter.b<>(null, this, true);

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public final c.a f14667s8 = new DetailPresenter(this);

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public d0 f14668t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public final z f14669u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public a.InterfaceC0156a f14670v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f14671w8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final B6DetailFragment a(@yt.k String deviceCode, int i10) {
            f0.p(deviceCode, "deviceCode");
            B6DetailFragment b6DetailFragment = new B6DetailFragment();
            b6DetailFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode), new Pair("ip_type", Integer.valueOf(i10))));
            return b6DetailFragment;
        }
    }

    public static final class b implements k0, a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f14672a;

        public b(ik.l function) {
            f0.p(function, "function");
            this.f14672a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f14672a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f14672a.i(obj);
        }

        public final boolean equals(@yt.l Object obj) {
            if ((obj instanceof k0) && (obj instanceof a0)) {
                return f0.g(a(), ((a0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@yt.k Animator animation) {
            f0.p(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@yt.k Animator animation) {
            f0.p(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@yt.k Animator animation) {
            f0.p(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@yt.k Animator animation) {
            f0.p(animation, "animation");
            d0 d0Var = B6DetailFragment.this.f14668t8;
            if (d0Var == null) {
                f0.S("viewBinding");
                d0Var = null;
            }
            TipView tipView = d0Var.f9915m.f10042b;
            f0.o(tipView, "viewBinding.areaTodoTips.areaTips");
            o5.c.b(tipView, Boolean.TRUE, false, 2, null);
            d0 d0Var2 = B6DetailFragment.this.f14668t8;
            if (d0Var2 == null) {
                f0.S("viewBinding");
                d0Var2 = null;
            }
            View view = d0Var2.f9911i;
            f0.o(view, "viewBinding.areaDivider");
            o5.c.b(view, Boolean.FALSE, false, 2, null);
        }
    }

    public B6DetailFragment() {
        final ik.a aVar = null;
        final ik.a<Fragment> aVar2 = new ik.a<Fragment>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.B6DetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Fragment o() {
                return this;
            }
        };
        final z zVarC = b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.B6DetailFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d1 o() {
                return (d1) aVar2.o();
            }
        });
        this.f14669u8 = FragmentViewModelLazyKt.h(this, n0.d(t9.l.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.B6DetailFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c1 o() {
                c1 c1VarO0 = FragmentViewModelLazyKt.p(zVarC).O0();
                f0.o(c1VarO0, "owner.viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.B6DetailFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final p1.a o() {
                p1.a aVar3;
                ik.a aVar4 = aVar;
                if (aVar4 != null && (aVar3 = (p1.a) aVar4.o()) != null) {
                    return aVar3;
                }
                d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                androidx.lifecycle.r rVar = d1VarP instanceof androidx.lifecycle.r ? (androidx.lifecycle.r) d1VarP : null;
                p1.a aVarJ0 = rVar != null ? rVar.j0() : null;
                return aVarJ0 == null ? a.C0519a.f46302b : aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.B6DetailFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final z0.b o() {
                z0.b bVarH0;
                d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                androidx.lifecycle.r rVar = d1VarP instanceof androidx.lifecycle.r ? (androidx.lifecycle.r) d1VarP : null;
                if (rVar == null || (bVarH0 = rVar.h0()) == null) {
                    bVarH0 = this.h0();
                }
                f0.o(bVarH0, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return bVarH0;
            }
        });
        androidx.activity.result.g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.c
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                B6DetailFragment.H6(this.f14678a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP1, "registerForActivityResul…}\n            }\n        }");
        this.f14671w8 = gVarP1;
    }

    public static final void A6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        MoreSettingActivity.a aVar = MoreSettingActivity.K2;
        Context contextR4 = this$0.R4();
        f0.o(contextR4, "requireContext()");
        this$0.x5(aVar.a(contextR4, this$0.f14665q8));
    }

    public static final void B6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        o5.a.t0(this$0.L2(), FlyocIntroDialogFragment.E8.a(1));
    }

    public static final void C6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        o5.a.t0(this$0.L2(), FlyocIntroDialogFragment.E8.a(2));
    }

    public static final void D6(B6DetailFragment this$0, View view) {
        Intent intentA;
        f0.p(this$0, "this$0");
        androidx.activity.result.g<Intent> gVar = this$0.f14671w8;
        WaspWingInfo waspWingInfoF = this$0.x6().h().f();
        if (waspWingInfoF != null) {
            RunModeSelectionActivity.a aVar = RunModeSelectionActivity.J7;
            Context contextR4 = this$0.R4();
            f0.o(contextR4, "requireContext()");
            intentA = aVar.a(contextR4, waspWingInfoF);
        } else {
            intentA = null;
        }
        gVar.b(intentA);
    }

    public static final void E6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        ExperimentalRunModeActivity.a aVar = ExperimentalRunModeActivity.H7;
        Context contextR4 = this$0.R4();
        f0.o(contextR4, "requireContext()");
        String str = this$0.f14664p8;
        WaspWingInfo waspWingInfoF = this$0.x6().h().f();
        this$0.x5(aVar.a(contextR4, str, waspWingInfoF != null ? waspWingInfoF.isExperimentalRunModeOn() : false));
    }

    public static final void F6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        ProtectionActivity.a aVar = ProtectionActivity.E7;
        Context contextR4 = this$0.R4();
        f0.o(contextR4, "requireContext()");
        String str = this$0.f14664p8;
        WaspWingInfo waspWingInfoF = this$0.x6().h().f();
        boolean z10 = false;
        boolean coldProtection = waspWingInfoF != null ? waspWingInfoF.getColdProtection() : false;
        WaspWingInfo waspWingInfoF2 = this$0.x6().h().f();
        if (waspWingInfoF2 != null && waspWingInfoF2.getRunMode() == 0) {
            z10 = true;
        }
        this$0.x5(aVar.a(contextR4, str, coldProtection, !z10));
    }

    public static final void H6(B6DetailFragment this$0, ActivityResult activityResult) {
        Intent intentA;
        int intExtra;
        WaspWingInfo waspWingInfoF;
        f0.p(this$0, "this$0");
        if (activityResult.b() != -1 || (intentA = activityResult.a()) == null || (intExtra = intentA.getIntExtra("key_result_data", -1)) == -1) {
            return;
        }
        WaspWingInfo waspWingInfoF2 = this$0.x6().h().f();
        boolean z10 = false;
        if (waspWingInfoF2 != null && intExtra == waspWingInfoF2.getRunMode()) {
            z10 = true;
        }
        if (z10 || (waspWingInfoF = this$0.x6().h().f()) == null) {
            return;
        }
        t9.j.f50990a.W(intExtra, (124 & 2) != 0 ? 0 : waspWingInfoF.getTargetTemperature(), (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void L6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        t9.j.x(this$0);
    }

    public static final void M6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.J6();
    }

    public static final void O6(B6DetailFragment this$0, ValueAnimator animation) {
        f0.p(this$0, "this$0");
        f0.p(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        f0.n(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        d0 d0Var = this$0.f14668t8;
        d0 d0Var2 = null;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        ViewGroup.LayoutParams layoutParams = d0Var.f9915m.f10042b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = iIntValue;
        }
        d0 d0Var3 = this$0.f14668t8;
        if (d0Var3 == null) {
            f0.S("viewBinding");
        } else {
            d0Var2 = d0Var3;
        }
        d0Var2.f9915m.f10042b.requestLayout();
    }

    public static final void y6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfoF = this$0.x6().h().f();
        if (waspWingInfoF != null) {
            LedActivity.a aVar = LedActivity.K7;
            Context contextR4 = this$0.R4();
            f0.o(contextR4, "requireContext()");
            this$0.x5(aVar.a(contextR4, waspWingInfoF));
        }
    }

    public static final void z6(B6DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        Postcard postcardWithString = h3.a.j().d(a.d.f31953i).withString("key_device_code", this$0.f14664p8);
        WaspWingInfo waspWingInfoF = this$0.x6().h().f();
        postcardWithString.withString("key_device_address", waspWingInfoF != null ? waspWingInfoF.getAddress() : null).withBoolean(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, !a5.f.i().p()).navigation();
    }

    public final void G6() {
        if (com.blankj.utilcode.util.n0.b(t9.c.f50958g, this.f14664p8) && o5.m.k(DataConstant.SP_APP).c(DataConstant.SP_APP_KEY_WASPWING_IP_TYPE)) {
            this.f14665q8 = o5.m.k(DataConstant.SP_APP).m(DataConstant.SP_APP_KEY_WASPWING_IP_TYPE);
        }
        d0 d0Var = this.f14668t8;
        d0 d0Var2 = null;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        com.bumptech.glide.b.G(this).p(Integer.valueOf(a5.b.m(this.f14664p8, Boolean.valueOf(this.f14665q8 != 0), this.f14665q8))).s1(d0Var.f9917o);
        if (this.f14665q8 != 0) {
            d0 d0Var3 = this.f14668t8;
            if (d0Var3 == null) {
                f0.S("viewBinding");
                d0Var3 = null;
            }
            ImageView imageView = d0Var3.f9918p;
            int iG = s0.g("device_bg_" + this.f14664p8 + '_' + this.f14665q8);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(imageView.getResources(), iG, options);
            int i10 = options.outWidth;
            int i11 = options.outHeight;
            androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
            ViewParent parent = imageView.getParent();
            f0.n(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            dVar.H((ConstraintLayout) parent);
            dVar.V0(imageView.getId(), "w," + i10 + ':' + i11);
            ViewParent parent2 = imageView.getParent();
            f0.n(parent2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            dVar.r((ConstraintLayout) parent2);
            com.bumptech.glide.b.G(this).p(Integer.valueOf(iG)).s1(imageView);
        }
        d0 d0Var4 = this.f14668t8;
        if (d0Var4 == null) {
            f0.S("viewBinding");
            d0Var4 = null;
        }
        d0Var4.f9922t.setText(a5.b.d(this.f14664p8, Boolean.valueOf(this.f14665q8 != 0), this.f14665q8));
        d0 d0Var5 = this.f14668t8;
        if (d0Var5 == null) {
            f0.S("viewBinding");
            d0Var5 = null;
        }
        d0Var5.f9925w.setText(a5.b.n(this.f14664p8, Boolean.valueOf(this.f14665q8 != 0), this.f14665q8));
        d0 d0Var6 = this.f14668t8;
        if (d0Var6 == null) {
            f0.S("viewBinding");
        } else {
            d0Var2 = d0Var6;
        }
        d0Var2.f9921s.n(new a.C0280a(X1()).A(V2().getDimensionPixelSize(R.dimen.qb_px_16), 0).m(R.drawable.base_view_divider).y());
        this.f14667s8.x(this.f14664p8);
    }

    public final void I6() {
        d0 d0Var = this.f14668t8;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        if (d0Var.f9912j.getVisibility() == 8) {
            HashMap map = new HashMap();
            map.put("device_code", this.f14664p8);
            u9.g.a().d(R4(), "Device_Detail_B3", "散热器已连接", map);
            d0 d0Var2 = this.f14668t8;
            if (d0Var2 == null) {
                f0.S("viewBinding");
                d0Var2 = null;
            }
            LinearLayout linearLayout = d0Var2.f9912j;
            f0.o(linearLayout, "viewBinding.areaFunction");
            Boolean bool = Boolean.TRUE;
            o5.c.b(linearLayout, bool, false, 2, null);
            d0 d0Var3 = this.f14668t8;
            if (d0Var3 == null) {
                f0.S("viewBinding");
                d0Var3 = null;
            }
            View view = d0Var3.f9911i;
            f0.o(view, "viewBinding.areaDivider");
            o5.c.b(view, bool, false, 2, null);
            d0 d0Var4 = this.f14668t8;
            if (d0Var4 == null) {
                f0.S("viewBinding");
                d0Var4 = null;
            }
            d0Var4.f9924v.setText(R.string.device_state_connected);
            d0 d0Var5 = this.f14668t8;
            if (d0Var5 == null) {
                f0.S("viewBinding");
                d0Var5 = null;
            }
            d0Var5.f9924v.setTextColor(h0.d.f(R4(), R.color.colorAccentGreen));
            a.InterfaceC0156a interfaceC0156a = this.f14670v8;
            if (interfaceC0156a == null) {
                f0.S("firmwarePresenter");
                interfaceC0156a = null;
            }
            String str = this.f14664p8;
            WaspWingInfo waspWingInfoF = x6().h().f();
            interfaceC0156a.b(str, waspWingInfoF != null ? waspWingInfoF.getFirmwareVersion() : null);
        }
        d0 d0Var6 = this.f14668t8;
        if (d0Var6 == null) {
            f0.S("viewBinding");
            d0Var6 = null;
        }
        if (d0Var6.f9915m.getRoot().getVisibility() == 0) {
            d0 d0Var7 = this.f14668t8;
            if (d0Var7 == null) {
                f0.S("viewBinding");
                d0Var7 = null;
            }
            TipView root = d0Var7.f9915m.getRoot();
            f0.o(root, "viewBinding.areaTodoTips.root");
            o5.c.b(root, Boolean.FALSE, false, 2, null);
        }
    }

    public final void J6() {
        o5.a.t0(U1(), ScanFragment.K8.a(this.f14664p8));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        if (string == null) {
            string = t9.c.f50958g;
        }
        this.f14664p8 = string;
        Bundle bundleT12 = T1();
        this.f14665q8 = bundleT12 != null ? bundleT12.getInt("ip_type") : -1;
        this.f14670v8 = new FirmwarePresenter(this);
        t9.j.D(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void K6() {
        d0 d0Var = this.f14668t8;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        TipView it2 = d0Var.f9915m.f10042b;
        if (v5.c.f()) {
            return;
        }
        if (!t9.j.o()) {
            d0 d0Var2 = this.f14668t8;
            if (d0Var2 == null) {
                f0.S("viewBinding");
                d0Var2 = null;
            }
            d0Var2.f9924v.setText(R.string.device_state_unconnected);
            d0 d0Var3 = this.f14668t8;
            if (d0Var3 == null) {
                f0.S("viewBinding");
                d0Var3 = null;
            }
            d0Var3.f9924v.setTextColor(h0.d.f(R4(), R.color.colorAccentRed));
            d0 d0Var4 = this.f14668t8;
            if (d0Var4 == null) {
                f0.S("viewBinding");
                d0Var4 = null;
            }
            TextView textView = d0Var4.f9923u;
            f0.o(textView, "viewBinding.tvOverclockState");
            Boolean bool = Boolean.FALSE;
            o5.c.b(textView, bool, false, 2, null);
            d0 d0Var5 = this.f14668t8;
            if (d0Var5 == null) {
                f0.S("viewBinding");
                d0Var5 = null;
            }
            ImageView imageView = d0Var5.f9919q;
            f0.o(imageView, "viewBinding.ivOverclockState");
            o5.c.b(imageView, bool, false, 2, null);
            d0 d0Var6 = this.f14668t8;
            if (d0Var6 == null) {
                f0.S("viewBinding");
                d0Var6 = null;
            }
            View view = d0Var6.f9916n;
            f0.o(view, "viewBinding.divider");
            o5.c.b(view, bool, false, 2, null);
            N6();
            f0.o(it2, "it");
            it2.f(false, R.string.device_tips_bluetooth_closed, R.string.device_tips_bluetooth_closed_desc, R.string.device_setting_now, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    B6DetailFragment.L6(this.f14683a, view2);
                }
            }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
            it2.setTag(R.id.device_tag_tip_type, 1);
            it2.setTag(R.id.device_tag_tip_ignored, bool);
            return;
        }
        if (t9.j.q()) {
            d0 d0Var7 = this.f14668t8;
            if (d0Var7 == null) {
                f0.S("viewBinding");
                d0Var7 = null;
            }
            TipView root = d0Var7.f9915m.getRoot();
            f0.o(root, "viewBinding.areaTodoTips.root");
            o5.c.b(root, Boolean.FALSE, false, 2, null);
            return;
        }
        d0 d0Var8 = this.f14668t8;
        if (d0Var8 == null) {
            f0.S("viewBinding");
            d0Var8 = null;
        }
        d0Var8.f9924v.setText(R.string.device_state_unconnected);
        d0 d0Var9 = this.f14668t8;
        if (d0Var9 == null) {
            f0.S("viewBinding");
            d0Var9 = null;
        }
        d0Var9.f9924v.setTextColor(h0.d.f(R4(), R.color.colorAccentRed));
        d0 d0Var10 = this.f14668t8;
        if (d0Var10 == null) {
            f0.S("viewBinding");
            d0Var10 = null;
        }
        TextView textView2 = d0Var10.f9923u;
        f0.o(textView2, "viewBinding.tvOverclockState");
        Boolean bool2 = Boolean.FALSE;
        o5.c.b(textView2, bool2, false, 2, null);
        d0 d0Var11 = this.f14668t8;
        if (d0Var11 == null) {
            f0.S("viewBinding");
            d0Var11 = null;
        }
        ImageView imageView2 = d0Var11.f9919q;
        f0.o(imageView2, "viewBinding.ivOverclockState");
        o5.c.b(imageView2, bool2, false, 2, null);
        d0 d0Var12 = this.f14668t8;
        if (d0Var12 == null) {
            f0.S("viewBinding");
            d0Var12 = null;
        }
        View view2 = d0Var12.f9916n;
        f0.o(view2, "viewBinding.divider");
        o5.c.b(view2, bool2, false, 2, null);
        N6();
        f0.o(it2, "it");
        it2.f(false, R.string.device_tips_device_disconnected, R.string.device_tips_device_disconnected_desc, R.string.device_tips_action_connect, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                B6DetailFragment.M6(this.f14677a, view3);
            }
        }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
        it2.setTag(R.id.device_tag_tip_type, 2);
        it2.setTag(R.id.device_tag_tip_ignored, bool2);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_detail_b6;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        QAItem qAItem;
        DeviceDetailBean.QaListBean qaListBeanD;
        f0.p(view, "view");
        if (i10 == -1 || (qAItem = (QAItem) this.f14666r8.g2(i10)) == null || (qaListBeanD = qAItem.D()) == null) {
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
        f0.o(data, "it.data");
        postcardD.withInt("id", Integer.parseInt(data)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13284b).navigation();
        return true;
    }

    public final void N6() {
        d0 d0Var = this.f14668t8;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        if (d0Var.f9915m.f10042b.getVisibility() != 0) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, V2().getDimensionPixelSize(R.dimen.qb_px_130));
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    B6DetailFragment.O6(this.f14676a, valueAnimator);
                }
            });
            valueAnimatorOfInt.addListener(new c());
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.start();
        }
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        d0 d0VarD = d0.d(inflater, viewGroup, false);
        f0.o(d0VarD, "inflate(inflater, container, false)");
        this.f14668t8 = d0VarD;
        if (d0VarD == null) {
            f0.S("viewBinding");
            d0VarD = null;
        }
        NestedScrollView nestedScrollViewB = d0VarD.getRoot();
        f0.o(nestedScrollViewB, "viewBinding.root");
        return nestedScrollViewB;
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        m.a.e(this, z10);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f14680a.K6();
            }
        });
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        t9.j.e0(this);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
        m.a.a(this);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void T0() {
        String firmwareVersion;
        d0 d0Var = this.f14668t8;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = d0Var.f9905c;
        WaspWingInfo waspWingInfoF = x6().h().f();
        if (waspWingInfoF == null || (firmwareVersion = waspWingInfoF.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        firmwareUpgradeActionItem.Q(firmwareVersion);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void W0() {
        String firmwareVersion;
        d0 d0Var = this.f14668t8;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = d0Var.f9905c;
        WaspWingInfo waspWingInfoF = x6().h().f();
        if (waspWingInfoF == null || (firmwareVersion = waspWingInfoF.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        firmwareUpgradeActionItem.Q(firmwareVersion);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void Y0(@yt.k List<? extends FirmwareInfoBean> data) {
        f0.p(data, "data");
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        m.a.b(this);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void i(@yt.k FirmwareInfoBean data) {
        String firmwareVersion;
        f0.p(data, "data");
        d0 d0Var = this.f14668t8;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = d0Var.f9905c;
        f0.o(firmwareUpgradeActionItem, "viewBinding.actionFirmwareUpgrade");
        WaspWingInfo waspWingInfoF = x6().h().f();
        if (waspWingInfoF == null || (firmwareVersion = waspWingInfoF.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        FirmwareUpgradeActionItem.U(firmwareUpgradeActionItem, firmwareVersion, Boolean.TRUE, null, 4, null);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        WaspWingInfo waspWingInfoF = x6().h().f();
        if (waspWingInfoF != null) {
            HashMap map = new HashMap();
            map.put("device_code", waspWingInfoF.getDeviceCode());
            map.put("led", waspWingInfoF.getLightState() ? com.flydigi.device_manager.ui.detail.waspwing.b7.n.a(waspWingInfoF) : "关");
            int runMode = waspWingInfoF.getRunMode();
            map.put("runMode", runMode != 0 ? runMode != 1 ? "固定功率" : "不能超频" : waspWingInfoF.getTargetTemperature() == 12 ? "智能变频-静音" : "智能变频-极寒");
            map.put("overclocking", waspWingInfoF.getOverClockUsable() ? "超频" : "未超频");
            if (waspWingInfoF.getRunMode() == 2) {
                map.put("windLevel", String.valueOf(waspWingInfoF.getWindLevelOverclock()));
            }
            map.put("cold_protection", waspWingInfoF.getColdProtection() ? "开" : "关");
            u9.g.a().d(R4(), "Device_Detail_Waspwing", "散热器设置", map);
            o5.m.i().B(DataConstant.SP_DEVICE_HAS_WASPWING_CONNECTED, e0.v(waspWingInfoF));
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        G6();
        d0 d0Var = this.f14668t8;
        d0 d0Var2 = null;
        if (d0Var == null) {
            f0.S("viewBinding");
            d0Var = null;
        }
        com.blankj.utilcode.util.o.r(d0Var.f9920r, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B6DetailFragment.B6(this.f14684a, view2);
            }
        });
        d0 d0Var3 = this.f14668t8;
        if (d0Var3 == null) {
            f0.S("viewBinding");
            d0Var3 = null;
        }
        com.blankj.utilcode.util.o.r(d0Var3.f9919q, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B6DetailFragment.C6(this.f14681a, view2);
            }
        });
        x6().h().k(l3(), new b(new ik.l<WaspWingInfo, z1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.B6DetailFragment$onViewCreated$3
            {
                super(1);
            }

            public final void b(WaspWingInfo it2) {
                int ipType = it2.getIpType();
                if (com.blankj.utilcode.util.n0.b(t9.c.f50958g, it2.getDeviceCode()) && o5.m.k(DataConstant.SP_APP).c(DataConstant.SP_APP_KEY_WASPWING_IP_TYPE)) {
                    ipType = o5.m.k(DataConstant.SP_APP).m(DataConstant.SP_APP_KEY_WASPWING_IP_TYPE);
                }
                if (!com.blankj.utilcode.util.n0.b(this.this$0.f14664p8, it2.getDeviceCode()) || this.this$0.f14665q8 != ipType) {
                    this.this$0.f14665q8 = ipType;
                    this.this$0.f14664p8 = it2.getDeviceCode();
                    this.this$0.G6();
                }
                boolean z10 = false;
                if (!it2.isConnected()) {
                    DialogFragment dialogFragment = this.this$0.f14663o8;
                    if (dialogFragment != null) {
                        dialogFragment.H5();
                    }
                    d0 d0Var4 = this.this$0.f14668t8;
                    if (d0Var4 == null) {
                        f0.S("viewBinding");
                        d0Var4 = null;
                    }
                    LinearLayout linearLayout = d0Var4.f9912j;
                    f0.o(linearLayout, "viewBinding.areaFunction");
                    o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
                    this.this$0.K6();
                    return;
                }
                this.this$0.I6();
                d0 d0Var5 = this.this$0.f14668t8;
                if (d0Var5 == null) {
                    f0.S("viewBinding");
                    d0Var5 = null;
                }
                TextView textView = d0Var5.f9923u;
                f0.o(textView, "viewBinding.tvOverclockState");
                o5.c.b(textView, Boolean.valueOf(it2.getOverClockUsable()), false, 2, null);
                d0 d0Var6 = this.this$0.f14668t8;
                if (d0Var6 == null) {
                    f0.S("viewBinding");
                    d0Var6 = null;
                }
                ImageView imageView = d0Var6.f9919q;
                f0.o(imageView, "viewBinding.ivOverclockState");
                o5.c.b(imageView, Boolean.valueOf(it2.getOverClockUsable()), false, 2, null);
                d0 d0Var7 = this.this$0.f14668t8;
                if (d0Var7 == null) {
                    f0.S("viewBinding");
                    d0Var7 = null;
                }
                View view2 = d0Var7.f9916n;
                f0.o(view2, "viewBinding.divider");
                o5.c.b(view2, Boolean.valueOf(it2.getOverClockUsable()), false, 2, null);
                d0 d0Var8 = this.this$0.f14668t8;
                if (d0Var8 == null) {
                    f0.S("viewBinding");
                    d0Var8 = null;
                }
                RunModeItem runModeItem = d0Var8.f9908f;
                f0.o(it2, "it");
                runModeItem.setDeviceInfo(it2);
                d0 d0Var9 = this.this$0.f14668t8;
                if (d0Var9 == null) {
                    f0.S("viewBinding");
                    d0Var9 = null;
                }
                d0Var9.f9910h.Q(it2.getTemperature() + " ℃");
                d0 d0Var10 = this.this$0.f14668t8;
                if (d0Var10 == null) {
                    f0.S("viewBinding");
                    d0Var10 = null;
                }
                ImageView imageView2 = d0Var10.f9918p;
                f0.o(imageView2, "viewBinding.ivDeviceBg");
                o5.c.a(imageView2, Boolean.valueOf(this.this$0.f14665q8 != 0), false);
                d0 d0Var11 = this.this$0.f14668t8;
                if (d0Var11 == null) {
                    f0.S("viewBinding");
                    d0Var11 = null;
                }
                ActionItemNormal actionItemNormal = d0Var11.f9904b;
                f0.o(actionItemNormal, "viewBinding.actionExperimentalMode");
                o5.c.b(actionItemNormal, Boolean.FALSE, false, 2, null);
                d0 d0Var12 = this.this$0.f14668t8;
                if (d0Var12 == null) {
                    f0.S("viewBinding");
                    d0Var12 = null;
                }
                ActionItemNormal actionItemNormal2 = d0Var12.f9909g;
                f0.o(actionItemNormal2, "viewBinding.actionSettingMore");
                o5.c.b(actionItemNormal2, Boolean.valueOf(com.blankj.utilcode.util.n0.b(it2.getDeviceCode(), t9.c.f50958g) && com.blankj.utilcode.util.n0.b("official", "official")), false, 2, null);
                if (it2.getLedData() == null) {
                    t9.j.f50990a.G(0);
                }
                if (!it2.getHotProtectionEnabled() && !it2.getColdProtectionEnabled()) {
                    DialogFragment dialogFragment2 = this.this$0.f14663o8;
                    if (dialogFragment2 != null) {
                        dialogFragment2.H5();
                        return;
                    }
                    return;
                }
                DialogFragment dialogFragment3 = this.this$0.f14663o8;
                if (dialogFragment3 != null && dialogFragment3.C3()) {
                    z10 = true;
                }
                if (z10) {
                    return;
                }
                DialogFragment dialogFragmentA = ProtectionAlertDialogFragment.F8.a(this.this$0.f14664p8, it2.getColdProtectionEnabled() ? 1 : 2);
                B6DetailFragment b6DetailFragment = this.this$0;
                b6DetailFragment.f14663o8 = dialogFragmentA;
                o5.a.t0(b6DetailFragment.L2(), dialogFragmentA);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(WaspWingInfo waspWingInfo) {
                b(waspWingInfo);
                return z1.f38230a;
            }
        }));
        d0 d0Var4 = this.f14668t8;
        if (d0Var4 == null) {
            f0.S("viewBinding");
            d0Var4 = null;
        }
        com.blankj.utilcode.util.o.r(d0Var4.f9908f, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B6DetailFragment.D6(this.f14686a, view2);
            }
        });
        d0 d0Var5 = this.f14668t8;
        if (d0Var5 == null) {
            f0.S("viewBinding");
            d0Var5 = null;
        }
        com.blankj.utilcode.util.o.r(d0Var5.f9904b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B6DetailFragment.E6(this.f14685a, view2);
            }
        });
        d0 d0Var6 = this.f14668t8;
        if (d0Var6 == null) {
            f0.S("viewBinding");
            d0Var6 = null;
        }
        com.blankj.utilcode.util.o.r(d0Var6.f9907e, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B6DetailFragment.F6(this.f14696a, view2);
            }
        });
        d0 d0Var7 = this.f14668t8;
        if (d0Var7 == null) {
            f0.S("viewBinding");
            d0Var7 = null;
        }
        com.blankj.utilcode.util.o.r(d0Var7.f9906d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B6DetailFragment.y6(this.f14688a, view2);
            }
        });
        d0 d0Var8 = this.f14668t8;
        if (d0Var8 == null) {
            f0.S("viewBinding");
            d0Var8 = null;
        }
        com.blankj.utilcode.util.o.r(d0Var8.f9905c, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B6DetailFragment.z6(this.f14682a, view2);
            }
        });
        d0 d0Var9 = this.f14668t8;
        if (d0Var9 == null) {
            f0.S("viewBinding");
        } else {
            d0Var2 = d0Var9;
        }
        com.blankj.utilcode.util.o.r(d0Var2.f9909g, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B6DetailFragment.A6(this.f14687a, view2);
            }
        });
        if (t9.j.q()) {
            return;
        }
        K6();
        H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f14679a.J6();
            }
        }, 250L);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
        m.a.c(this);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void o0() {
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
        m.a.d(this, i10);
    }

    @Override // com.flydigi.device_manager.ui.detail.c.b
    public void v(@yt.k DeviceDetailBean detailBean) {
        f0.p(detailBean, "detailBean");
        List<DeviceDetailBean.QaListBean> qaList = detailBean.getQaList();
        d0 d0Var = null;
        if (qaList == null || qaList.isEmpty()) {
            d0 d0Var2 = this.f14668t8;
            if (d0Var2 == null) {
                f0.S("viewBinding");
                d0Var2 = null;
            }
            LinearLayout linearLayout = d0Var2.f9913k;
            f0.o(linearLayout, "viewBinding.areaQa");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
            return;
        }
        d0 d0Var3 = this.f14668t8;
        if (d0Var3 == null) {
            f0.S("viewBinding");
            d0Var3 = null;
        }
        if (d0Var3.f9921s.getAdapter() == null) {
            d0 d0Var4 = this.f14668t8;
            if (d0Var4 == null) {
                f0.S("viewBinding");
                d0Var4 = null;
            }
            d0Var4.f9921s.setAdapter(this.f14666r8);
        }
        d0 d0Var5 = this.f14668t8;
        if (d0Var5 == null) {
            f0.S("viewBinding");
            d0Var5 = null;
        }
        LinearLayout linearLayout2 = d0Var5.f9913k;
        f0.o(linearLayout2, "viewBinding.areaQa");
        o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
        d0 d0Var6 = this.f14668t8;
        if (d0Var6 == null) {
            f0.S("viewBinding");
        } else {
            d0Var = d0Var6;
        }
        d0Var.f9926x.setText(detailBean.getQaTitle());
        this.f14666r8.m1();
        List<DeviceDetailBean.QaListBean> qaList2 = detailBean.getQaList();
        f0.o(qaList2, "detailBean.qaList");
        for (DeviceDetailBean.QaListBean it2 : qaList2) {
            eu.davidea.flexibleadapter.b<QAItem> bVar = this.f14666r8;
            f0.o(it2, "it");
            bVar.K0(new QAItem(it2));
        }
    }

    public final t9.l x6() {
        return (t9.l) this.f14669u8.getValue();
    }
}
