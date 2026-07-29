package com.flydigi.device_manager.ui.detail.waspwing.b7;

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
import androidx.activity.result.ActivityResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.z0;
import c7.e0;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.s0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.DetailPresenter;
import com.flydigi.device_manager.ui.detail.c;
import com.flydigi.device_manager.ui.detail.item.QAItem;
import com.flydigi.device_manager.ui.detail.waspwing.ScanFragment;
import com.flydigi.device_manager.ui.detail.waspwing.b6.protection.ProtectionActivity;
import com.flydigi.device_manager.ui.detail.waspwing.b7.n;
import com.flydigi.device_manager.ui.detail.waspwing.led.LedActivity;
import com.flydigi.device_manager.ui.detail.waspwing.runmode.RunModeSelectionActivity;
import com.flydigi.device_manager.ui.detail.waspwing.statistics.StatisticsActivity;
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
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import p1.a;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nB7DetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 B7DetailFragment.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b7/B7DetailFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,570:1\n106#2,15:571\n1855#3,2:586\n*S KotlinDebug\n*F\n+ 1 B7DetailFragment.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b7/B7DetailFragment\n*L\n86#1:571,15\n476#1:586,2\n*E\n"})
public final class B7DetailFragment extends FZFragment implements c.b, a.b, b.z, com.flydigi.sdk.bluetooth.m {

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.k
    public static final a f14704x8 = new a(null);

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final int f14705y8 = 1;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public static final int f14706z8 = 2;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.k
    public String f14707o8 = t9.c.f50960i;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public int f14708p8 = -1;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<QAItem> f14709q8 = new eu.davidea.flexibleadapter.b<>(null, this, true);

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public final c.a f14710r8 = new DetailPresenter(this);

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public e0 f14711s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.k
    public final kotlin.z f14712t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public a.InterfaceC0156a f14713u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @yt.l
    public DialogFragment f14714v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f14715w8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final B7DetailFragment a(@yt.k String deviceCode, int i10) {
            f0.p(deviceCode, "deviceCode");
            B7DetailFragment b7DetailFragment = new B7DetailFragment();
            b7DetailFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode), new Pair("ip_type", Integer.valueOf(i10))));
            return b7DetailFragment;
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public b() {
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
            e0 e0Var = B7DetailFragment.this.f14711s8;
            if (e0Var == null) {
                f0.S("viewBinding");
                e0Var = null;
            }
            TipView tipView = e0Var.f9960l.f10042b;
            f0.o(tipView, "viewBinding.areaTodoTips.areaTips");
            o5.c.b(tipView, Boolean.TRUE, false, 2, null);
            e0 e0Var2 = B7DetailFragment.this.f14711s8;
            if (e0Var2 == null) {
                f0.S("viewBinding");
                e0Var2 = null;
            }
            View view = e0Var2.f9957i;
            f0.o(view, "viewBinding.areaDivider");
            o5.c.b(view, Boolean.FALSE, false, 2, null);
        }
    }

    public B7DetailFragment() {
        final ik.a aVar = null;
        final ik.a<Fragment> aVar2 = new ik.a<Fragment>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.B7DetailFragment$special$$inlined$viewModels$default$1
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
        final kotlin.z zVarC = kotlin.b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.B7DetailFragment$special$$inlined$viewModels$default$2
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
        this.f14712t8 = FragmentViewModelLazyKt.h(this, n0.d(t9.l.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.B7DetailFragment$special$$inlined$viewModels$default$3
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
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.B7DetailFragment$special$$inlined$viewModels$default$4
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
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.B7DetailFragment$special$$inlined$viewModels$default$5
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
        androidx.activity.result.g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.l
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                B7DetailFragment.D6(this.f14733a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP1, "registerForActivityResul…}\n            }\n        }");
        this.f14715w8 = gVarP1;
    }

    public static final void A6(B7DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        ProtectionActivity.a aVar = ProtectionActivity.E7;
        Context contextR4 = this$0.R4();
        f0.o(contextR4, "requireContext()");
        String str = this$0.f14707o8;
        WaspWingInfo waspWingInfoF = this$0.v6().h().f();
        boolean z10 = false;
        boolean coldProtection = waspWingInfoF != null ? waspWingInfoF.getColdProtection() : false;
        WaspWingInfo waspWingInfoF2 = this$0.v6().h().f();
        if (waspWingInfoF2 != null && waspWingInfoF2.getRunMode() == 0) {
            z10 = true;
        }
        this$0.x5(aVar.a(contextR4, str, coldProtection, !z10));
    }

    public static final void B6(B7DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfoF = this$0.v6().h().f();
        if (waspWingInfoF != null) {
            LedActivity.a aVar = LedActivity.K7;
            Context contextR4 = this$0.R4();
            f0.o(contextR4, "requireContext()");
            this$0.x5(aVar.a(contextR4, waspWingInfoF));
        }
    }

    public static final void D6(B7DetailFragment this$0, ActivityResult activityResult) {
        Intent intentA;
        WaspWingInfo waspWingInfoF;
        f0.p(this$0, "this$0");
        if (activityResult.b() != -1 || (intentA = activityResult.a()) == null) {
            return;
        }
        int intExtra = intentA.getIntExtra("key_result_data", -1);
        int intExtra2 = intentA.getIntExtra(RunModeSelectionActivity.K7, -1);
        if (intExtra != -1) {
            WaspWingInfo waspWingInfoF2 = this$0.v6().h().f();
            boolean z10 = false;
            if (waspWingInfoF2 != null && intExtra == waspWingInfoF2.getRunMode()) {
                z10 = true;
            }
            if (!z10 && (waspWingInfoF = this$0.v6().h().f()) != null) {
                t9.j.f50990a.W(intExtra, (124 & 2) != 0 ? 0 : waspWingInfoF.getTargetTemperature(), (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
            }
        }
        if (intExtra2 == -1 || intExtra2 == intExtra || this$0.v6().h().f() == null) {
            return;
        }
        t9.j.f50990a.U(intExtra2);
    }

    public static final void H6(B7DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        t9.j.x(this$0);
    }

    public static final void I6(B7DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.F6();
    }

    public static final void K6(B7DetailFragment this$0, ValueAnimator animation) {
        f0.p(this$0, "this$0");
        f0.p(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        f0.n(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        e0 e0Var = this$0.f14711s8;
        e0 e0Var2 = null;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        ViewGroup.LayoutParams layoutParams = e0Var.f9960l.f10042b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = iIntValue;
        }
        e0 e0Var3 = this$0.f14711s8;
        if (e0Var3 == null) {
            f0.S("viewBinding");
        } else {
            e0Var2 = e0Var3;
        }
        e0Var2.f9960l.f10042b.requestLayout();
    }

    public static final void w6(View view) {
        u9.b.q(1, "外设管理", "", 2);
    }

    public static final void x6(B7DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        Postcard postcardWithString = h3.a.j().d(a.d.f31953i).withString("key_device_code", this$0.f14707o8);
        WaspWingInfo waspWingInfoF = this$0.v6().h().f();
        postcardWithString.withString("key_device_address", waspWingInfoF != null ? waspWingInfoF.getAddress() : null).withBoolean(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, !a5.f.i().p()).navigation();
    }

    public static final void y6(B7DetailFragment this$0, View view) {
        Intent intentA;
        f0.p(this$0, "this$0");
        androidx.activity.result.g<Intent> gVar = this$0.f14715w8;
        WaspWingInfo waspWingInfoF = this$0.v6().h().f();
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

    public static final void z6(B7DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        StatisticsActivity.a aVar = StatisticsActivity.E7;
        Context contextR4 = this$0.R4();
        f0.o(contextR4, "requireContext()");
        this$0.x5(aVar.a(contextR4, this$0.f14707o8));
    }

    public final void C6() {
        e0 e0Var = this.f14711s8;
        e0 e0Var2 = null;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        com.bumptech.glide.b.G(this).p(Integer.valueOf(a5.b.m(this.f14707o8, Boolean.valueOf(this.f14708p8 != 0), this.f14708p8))).s1(e0Var.f9961m);
        if (this.f14708p8 != 0) {
            e0 e0Var3 = this.f14711s8;
            if (e0Var3 == null) {
                f0.S("viewBinding");
                e0Var3 = null;
            }
            ImageView imageView = e0Var3.f9962n;
            int iG = s0.g("device_bg_" + this.f14707o8 + '_' + this.f14708p8);
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
        e0 e0Var4 = this.f14711s8;
        if (e0Var4 == null) {
            f0.S("viewBinding");
            e0Var4 = null;
        }
        e0Var4.f9964p.setText(a5.b.d(this.f14707o8, Boolean.valueOf(this.f14708p8 != 0), this.f14708p8));
        e0 e0Var5 = this.f14711s8;
        if (e0Var5 == null) {
            f0.S("viewBinding");
            e0Var5 = null;
        }
        e0Var5.f9966r.setText(a5.b.n(this.f14707o8, Boolean.valueOf(this.f14708p8 != 0), this.f14708p8));
        e0 e0Var6 = this.f14711s8;
        if (e0Var6 == null) {
            f0.S("viewBinding");
        } else {
            e0Var2 = e0Var6;
        }
        e0Var2.f9963o.n(new a.C0280a(X1()).A(V2().getDimensionPixelSize(R.dimen.qb_px_16), 0).m(R.drawable.base_view_divider).y());
        this.f14710r8.x(this.f14707o8);
    }

    public final void E6() {
        e0 e0Var = this.f14711s8;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        if (e0Var.f9958j.getVisibility() == 8) {
            HashMap map = new HashMap();
            map.put("device_code", this.f14707o8);
            u9.g.a().d(R4(), "Device_Detail_B3", "散热器已连接", map);
            e0 e0Var2 = this.f14711s8;
            if (e0Var2 == null) {
                f0.S("viewBinding");
                e0Var2 = null;
            }
            LinearLayout linearLayout = e0Var2.f9958j;
            f0.o(linearLayout, "viewBinding.areaFunction");
            Boolean bool = Boolean.TRUE;
            o5.c.b(linearLayout, bool, false, 2, null);
            e0 e0Var3 = this.f14711s8;
            if (e0Var3 == null) {
                f0.S("viewBinding");
                e0Var3 = null;
            }
            View view = e0Var3.f9957i;
            f0.o(view, "viewBinding.areaDivider");
            o5.c.b(view, bool, false, 2, null);
            e0 e0Var4 = this.f14711s8;
            if (e0Var4 == null) {
                f0.S("viewBinding");
                e0Var4 = null;
            }
            e0Var4.f9965q.setText(R.string.device_state_connected);
            e0 e0Var5 = this.f14711s8;
            if (e0Var5 == null) {
                f0.S("viewBinding");
                e0Var5 = null;
            }
            e0Var5.f9965q.setTextColor(h0.d.f(R4(), R.color.colorAccentGreen));
            a.InterfaceC0156a interfaceC0156a = this.f14713u8;
            if (interfaceC0156a == null) {
                f0.S("firmwarePresenter");
                interfaceC0156a = null;
            }
            String str = this.f14707o8;
            WaspWingInfo waspWingInfoF = v6().h().f();
            interfaceC0156a.b(str, waspWingInfoF != null ? waspWingInfoF.getFirmwareVersion() : null);
        }
        e0 e0Var6 = this.f14711s8;
        if (e0Var6 == null) {
            f0.S("viewBinding");
            e0Var6 = null;
        }
        if (e0Var6.f9960l.getRoot().getVisibility() == 0) {
            e0 e0Var7 = this.f14711s8;
            if (e0Var7 == null) {
                f0.S("viewBinding");
                e0Var7 = null;
            }
            TipView root = e0Var7.f9960l.getRoot();
            f0.o(root, "viewBinding.areaTodoTips.root");
            o5.c.b(root, Boolean.FALSE, false, 2, null);
        }
    }

    public final void F6() {
        o5.a.t0(U1(), ScanFragment.K8.a(this.f14707o8));
    }

    public final void G6() {
        e0 e0Var = this.f14711s8;
        e0 e0Var2 = null;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        TipView it2 = e0Var.f9960l.f10042b;
        if (v5.c.f()) {
            return;
        }
        if (!t9.j.o()) {
            e0 e0Var3 = this.f14711s8;
            if (e0Var3 == null) {
                f0.S("viewBinding");
                e0Var3 = null;
            }
            e0Var3.f9965q.setText(R.string.device_state_unconnected);
            e0 e0Var4 = this.f14711s8;
            if (e0Var4 == null) {
                f0.S("viewBinding");
            } else {
                e0Var2 = e0Var4;
            }
            e0Var2.f9965q.setTextColor(h0.d.f(R4(), R.color.colorAccentRed));
            J6();
            f0.o(it2, "it");
            it2.f(false, R.string.device_tips_bluetooth_closed, R.string.device_tips_bluetooth_closed_desc, R.string.device_setting_now, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    B7DetailFragment.H6(this.f14727a, view);
                }
            }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
            it2.setTag(R.id.device_tag_tip_type, 1);
            it2.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
            return;
        }
        if (t9.j.q()) {
            e0 e0Var5 = this.f14711s8;
            if (e0Var5 == null) {
                f0.S("viewBinding");
                e0Var5 = null;
            }
            TipView root = e0Var5.f9960l.getRoot();
            f0.o(root, "viewBinding.areaTodoTips.root");
            o5.c.b(root, Boolean.FALSE, false, 2, null);
            return;
        }
        e0 e0Var6 = this.f14711s8;
        if (e0Var6 == null) {
            f0.S("viewBinding");
            e0Var6 = null;
        }
        e0Var6.f9965q.setText(R.string.device_state_unconnected);
        e0 e0Var7 = this.f14711s8;
        if (e0Var7 == null) {
            f0.S("viewBinding");
        } else {
            e0Var2 = e0Var7;
        }
        e0Var2.f9965q.setTextColor(h0.d.f(R4(), R.color.colorAccentRed));
        J6();
        f0.o(it2, "it");
        it2.f(false, R.string.device_tips_device_disconnected, R.string.device_tips_device_disconnected_desc, R.string.device_tips_action_connect, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                B7DetailFragment.I6(this.f14730a, view);
            }
        }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
        it2.setTag(R.id.device_tag_tip_type, 2);
        it2.setTag(R.id.device_tag_tip_ignored, Boolean.FALSE);
    }

    public final void J6() {
        e0 e0Var = this.f14711s8;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        if (e0Var.f9960l.f10042b.getVisibility() != 0) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, V2().getDimensionPixelSize(R.dimen.qb_px_130));
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    B7DetailFragment.K6(this.f14719a, valueAnimator);
                }
            });
            valueAnimatorOfInt.addListener(new b());
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.start();
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        if (string == null) {
            string = t9.c.f50960i;
        }
        this.f14707o8 = string;
        Bundle bundleT12 = T1();
        this.f14708p8 = bundleT12 != null ? bundleT12.getInt("ip_type") : -1;
        this.f14713u8 = new FirmwarePresenter(this);
        t9.j.D(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_detail_b7;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        QAItem qAItem;
        DeviceDetailBean.QaListBean qaListBeanD;
        f0.p(view, "view");
        if (i10 == -1 || (qAItem = (QAItem) this.f14709q8.g2(i10)) == null || (qaListBeanD = qAItem.D()) == null) {
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

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        e0 e0VarD = e0.d(inflater, viewGroup, false);
        f0.o(e0VarD, "inflate(inflater, container, false)");
        this.f14711s8 = e0VarD;
        if (e0VarD == null) {
            f0.S("viewBinding");
            e0VarD = null;
        }
        NestedScrollView nestedScrollViewB = e0VarD.getRoot();
        f0.o(nestedScrollViewB, "viewBinding.root");
        return nestedScrollViewB;
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        m.a.e(this, z10);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f14723a.G6();
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
        e0 e0Var = this.f14711s8;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = e0Var.f9951c;
        WaspWingInfo waspWingInfoF = v6().h().f();
        if (waspWingInfoF == null || (firmwareVersion = waspWingInfoF.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        firmwareUpgradeActionItem.Q(firmwareVersion);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void W0() {
        String firmwareVersion;
        e0 e0Var = this.f14711s8;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = e0Var.f9951c;
        WaspWingInfo waspWingInfoF = v6().h().f();
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
        e0 e0Var = this.f14711s8;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = e0Var.f9951c;
        f0.o(firmwareUpgradeActionItem, "viewBinding.actionFirmwareUpgrade");
        WaspWingInfo waspWingInfoF = v6().h().f();
        if (waspWingInfoF == null || (firmwareVersion = waspWingInfoF.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        FirmwareUpgradeActionItem.U(firmwareUpgradeActionItem, firmwareVersion, Boolean.TRUE, null, 4, null);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        WaspWingInfo waspWingInfoF = v6().h().f();
        if (waspWingInfoF != null) {
            HashMap map = new HashMap();
            map.put("device_code", waspWingInfoF.getDeviceCode());
            map.put("led", waspWingInfoF.getLightState() ? n.a(waspWingInfoF) : "关");
            int runMode = waspWingInfoF.getRunMode();
            map.put("runMode", runMode != 0 ? runMode != 1 ? "固定功率" : "不能超频" : waspWingInfoF.getTargetTemperature() == 12 ? "智能变频-静音" : "智能变频-极寒");
            map.put("overclocking", waspWingInfoF.getOverClockUsable() ? "超频" : "未超频");
            if (waspWingInfoF.getRunMode() == 2) {
                map.put("windLevel", String.valueOf(waspWingInfoF.getWindLevel()));
            }
            map.put("cold_protection", waspWingInfoF.getColdProtection() ? "开" : "关");
            u9.g.a().d(R4(), "Device_Detail_Waspwing", "散热器设置", map);
            o5.m.i().B(DataConstant.SP_DEVICE_HAS_WASPWING_CONNECTED, com.blankj.utilcode.util.e0.v(waspWingInfoF));
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        C6();
        v6().h().k(l3(), new n.a(new B7DetailFragment$onViewCreated$1(this)));
        e0 e0Var = this.f14711s8;
        e0 e0Var2 = null;
        if (e0Var == null) {
            f0.S("viewBinding");
            e0Var = null;
        }
        e0Var.f9955g.setOnRunModeClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B7DetailFragment.y6(this.f14731a, view2);
            }
        });
        e0 e0Var3 = this.f14711s8;
        if (e0Var3 == null) {
            f0.S("viewBinding");
            e0Var3 = null;
        }
        com.blankj.utilcode.util.o.r(e0Var3.f9956h, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B7DetailFragment.z6(this.f14729a, view2);
            }
        });
        e0 e0Var4 = this.f14711s8;
        if (e0Var4 == null) {
            f0.S("viewBinding");
            e0Var4 = null;
        }
        com.blankj.utilcode.util.o.r(e0Var4.f9954f, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B7DetailFragment.A6(this.f14726a, view2);
            }
        });
        e0 e0Var5 = this.f14711s8;
        if (e0Var5 == null) {
            f0.S("viewBinding");
            e0Var5 = null;
        }
        com.blankj.utilcode.util.o.r(e0Var5.f9952d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B7DetailFragment.B6(this.f14728a, view2);
            }
        });
        e0 e0Var6 = this.f14711s8;
        if (e0Var6 == null) {
            f0.S("viewBinding");
            e0Var6 = null;
        }
        com.blankj.utilcode.util.o.r(e0Var6.f9950b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B7DetailFragment.w6(view2);
            }
        });
        e0 e0Var7 = this.f14711s8;
        if (e0Var7 == null) {
            f0.S("viewBinding");
        } else {
            e0Var2 = e0Var7;
        }
        com.blankj.utilcode.util.o.r(e0Var2.f9951c, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                B7DetailFragment.x6(this.f14725a, view2);
            }
        });
        if (t9.j.q()) {
            return;
        }
        G6();
        H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f14721a.F6();
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
        e0 e0Var = null;
        if (qaList == null || qaList.isEmpty()) {
            e0 e0Var2 = this.f14711s8;
            if (e0Var2 == null) {
                f0.S("viewBinding");
                e0Var2 = null;
            }
            LinearLayout linearLayout = e0Var2.f9959k;
            f0.o(linearLayout, "viewBinding.areaQa");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
            return;
        }
        e0 e0Var3 = this.f14711s8;
        if (e0Var3 == null) {
            f0.S("viewBinding");
            e0Var3 = null;
        }
        if (e0Var3.f9963o.getAdapter() == null) {
            e0 e0Var4 = this.f14711s8;
            if (e0Var4 == null) {
                f0.S("viewBinding");
                e0Var4 = null;
            }
            e0Var4.f9963o.setAdapter(this.f14709q8);
        }
        e0 e0Var5 = this.f14711s8;
        if (e0Var5 == null) {
            f0.S("viewBinding");
            e0Var5 = null;
        }
        LinearLayout linearLayout2 = e0Var5.f9959k;
        f0.o(linearLayout2, "viewBinding.areaQa");
        o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
        e0 e0Var6 = this.f14711s8;
        if (e0Var6 == null) {
            f0.S("viewBinding");
        } else {
            e0Var = e0Var6;
        }
        e0Var.f9967s.setText(detailBean.getQaTitle());
        this.f14709q8.m1();
        List<DeviceDetailBean.QaListBean> qaList2 = detailBean.getQaList();
        f0.o(qaList2, "detailBean.qaList");
        for (DeviceDetailBean.QaListBean it2 : qaList2) {
            eu.davidea.flexibleadapter.b<QAItem> bVar = this.f14709q8;
            f0.o(it2, "it");
            bVar.K0(new QAItem(it2));
        }
    }

    public final t9.l v6() {
        return (t9.l) this.f14712t8.getValue();
    }
}
