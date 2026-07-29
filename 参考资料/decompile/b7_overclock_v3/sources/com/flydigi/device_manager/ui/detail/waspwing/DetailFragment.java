package com.flydigi.device_manager.ui.detail.waspwing;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.k0;
import androidx.lifecycle.z0;
import c7.f0;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.e0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.DividerPaddingLinearLayout;
import com.flydigi.base.widget.action_item.ActionItemSwitch;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.DetailPresenter;
import com.flydigi.device_manager.ui.detail.c;
import com.flydigi.device_manager.ui.detail.item.QAItem;
import com.flydigi.device_manager.ui.firmware.FirmwarePresenter;
import com.flydigi.device_manager.ui.firmware.a;
import com.flydigi.device_manager.ui.home.device.TipView;
import com.flydigi.device_manager.view.FirmwareUpgradeActionItem;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.yqritc.recyclerviewflexibledivider.a;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.util.HashMap;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.b0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import p1.a;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DetailFragment.kt\ncom/flydigi/device_manager/ui/detail/waspwing/DetailFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,431:1\n106#2,15:432\n1855#3,2:447\n*S KotlinDebug\n*F\n+ 1 DetailFragment.kt\ncom/flydigi/device_manager/ui/detail/waspwing/DetailFragment\n*L\n62#1:432,15\n355#1:447,2\n*E\n"})
public final class DetailFragment extends FZFragment implements c.b, a.b, b.z, com.flydigi.sdk.bluetooth.m {

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public static final a f14639u8 = new a(null);

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final int f14640v8 = 1;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static final int f14641w8 = 2;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.k
    public String f14642o8 = t9.c.f50954c;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<QAItem> f14643p8 = new eu.davidea.flexibleadapter.b<>(null, this, true);

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public final c.a f14644q8 = new DetailPresenter(this);

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public f0 f14645r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public final kotlin.z f14646s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public a.InterfaceC0156a f14647t8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final DetailFragment a(@yt.k String deviceCode) {
            kotlin.jvm.internal.f0.p(deviceCode, "deviceCode");
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode)));
            return detailFragment;
        }
    }

    public static final class b implements k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f14648a;

        public b(ik.l function) {
            kotlin.jvm.internal.f0.p(function, "function");
            this.f14648a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f14648a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f14648a.i(obj);
        }

        public final boolean equals(@yt.l Object obj) {
            if ((obj instanceof k0) && (obj instanceof kotlin.jvm.internal.a0)) {
                return kotlin.jvm.internal.f0.g(a(), ((kotlin.jvm.internal.a0) obj).a());
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
            f0 f0Var = DetailFragment.this.f14645r8;
            if (f0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var = null;
            }
            TipView tipView = f0Var.f10007i.f10042b;
            kotlin.jvm.internal.f0.o(tipView, "viewBinding.areaTodoTips.areaTips");
            o5.c.b(tipView, Boolean.TRUE, false, 2, null);
            f0 f0Var2 = DetailFragment.this.f14645r8;
            if (f0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var2 = null;
            }
            View view = f0Var2.f10004f;
            kotlin.jvm.internal.f0.o(view, "viewBinding.areaDivider");
            o5.c.b(view, Boolean.FALSE, false, 2, null);
        }
    }

    public DetailFragment() {
        final ik.a aVar = null;
        final ik.a<Fragment> aVar2 = new ik.a<Fragment>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.DetailFragment$special$$inlined$viewModels$default$1
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
        final kotlin.z zVarC = b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.DetailFragment$special$$inlined$viewModels$default$2
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
        this.f14646s8 = FragmentViewModelLazyKt.h(this, n0.d(t9.l.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.DetailFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c1 o() {
                c1 c1VarO0 = FragmentViewModelLazyKt.p(zVarC).O0();
                kotlin.jvm.internal.f0.o(c1VarO0, "owner.viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.DetailFragment$special$$inlined$viewModels$default$4
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
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.DetailFragment$special$$inlined$viewModels$default$5
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
                kotlin.jvm.internal.f0.o(bVarH0, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return bVarH0;
            }
        });
    }

    public static final void n6(DetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Postcard postcardWithString = h3.a.j().d(a.d.f31953i).withString("key_device_code", this$0.f14642o8);
        WaspWingInfo waspWingInfoF = this$0.m6().h().f();
        postcardWithString.withString("key_device_address", waspWingInfoF != null ? waspWingInfoF.getAddress() : null).withBoolean(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, !a5.f.i().p()).navigation();
    }

    public static final void o6(boolean z10) {
        if (z10) {
            t9.j.f50990a.R();
        } else {
            t9.j.f50990a.Q();
        }
    }

    public static final void t6(DetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        t9.j.x(this$0);
    }

    public static final void u6(DetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.r6();
    }

    public static final void w6(DetailFragment this$0, ValueAnimator animation) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.f0.n(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        f0 f0Var = this$0.f14645r8;
        f0 f0Var2 = null;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        ViewGroup.LayoutParams layoutParams = f0Var.f10007i.f10042b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = iIntValue;
        }
        f0 f0Var3 = this$0.f14645r8;
        if (f0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            f0Var2 = f0Var3;
        }
        f0Var2.f10007i.f10042b.requestLayout();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        if (string == null) {
            string = t9.c.f50954c;
        }
        this.f14642o8 = string;
        this.f14647t8 = new FirmwarePresenter(this);
        t9.j.D(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_detail_waspwing;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        QAItem qAItem;
        DeviceDetailBean.QaListBean qaListBeanD;
        kotlin.jvm.internal.f0.p(view, "view");
        if (i10 == -1 || (qAItem = (QAItem) this.f14643p8.g2(i10)) == null || (qaListBeanD = qAItem.D()) == null) {
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

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        f0 f0VarD = f0.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(f0VarD, "inflate(inflater, container, false)");
        this.f14645r8 = f0VarD;
        if (f0VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0VarD = null;
        }
        NestedScrollView nestedScrollViewB = f0VarD.getRoot();
        kotlin.jvm.internal.f0.o(nestedScrollViewB, "viewBinding.root");
        return nestedScrollViewB;
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
        m.a.e(this, z10);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f14752a.s6();
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
        f0 f0Var = this.f14645r8;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = f0Var.f10000b;
        WaspWingInfo waspWingInfoF = m6().h().f();
        if (waspWingInfoF == null || (firmwareVersion = waspWingInfoF.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        firmwareUpgradeActionItem.Q(firmwareVersion);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void W0() {
        String firmwareVersion;
        f0 f0Var = this.f14645r8;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = f0Var.f10000b;
        WaspWingInfo waspWingInfoF = m6().h().f();
        if (waspWingInfoF == null || (firmwareVersion = waspWingInfoF.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        firmwareUpgradeActionItem.Q(firmwareVersion);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void Y0(@yt.k List<? extends FirmwareInfoBean> data) {
        kotlin.jvm.internal.f0.p(data, "data");
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        m.a.b(this);
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void i(@yt.k FirmwareInfoBean data) {
        String firmwareVersion;
        kotlin.jvm.internal.f0.p(data, "data");
        f0 f0Var = this.f14645r8;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = f0Var.f10000b;
        kotlin.jvm.internal.f0.o(firmwareUpgradeActionItem, "viewBinding.actionFirmwareUpgrade");
        WaspWingInfo waspWingInfoF = m6().h().f();
        if (waspWingInfoF == null || (firmwareVersion = waspWingInfoF.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        FirmwareUpgradeActionItem.U(firmwareUpgradeActionItem, firmwareVersion, Boolean.TRUE, null, 4, null);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        WaspWingInfo waspWingInfoF = m6().h().f();
        if (waspWingInfoF != null) {
            HashMap map = new HashMap();
            map.put("device_code", waspWingInfoF.getDeviceCode());
            map.put("led", waspWingInfoF.getLightState() ? "开" : "关");
            int runMode = waspWingInfoF.getRunMode();
            String string = "";
            if (runMode == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(c3(R.string.device_waspwing_run_mode_smart));
                float runModeSmartLevel = waspWingInfoF.getRunModeSmartLevel();
                if (runModeSmartLevel == 0.0f) {
                    string = '-' + c3(R.string.device_fragment_detail_waspwing_temperature_level_max);
                } else {
                    if (runModeSmartLevel == 1.0f) {
                        string = '-' + c3(R.string.device_fragment_detail_waspwing_temperature_level_middle);
                    } else {
                        if (runModeSmartLevel == 2.0f) {
                            if (waspWingInfoF.getOverClockUsable()) {
                                string = '-' + c3(R.string.device_fragment_detail_waspwing_temperature_level_min);
                            } else {
                                string = '-' + c3(R.string.device_fragment_detail_waspwing_temperature_level_min) + '(' + c3(R.string.wasping_overclock_on) + ')';
                            }
                        }
                    }
                }
                sb2.append(string);
                string = sb2.toString();
            } else if (runMode == 1) {
                string = c3(R.string.device_waspwing_run_mode_manual);
                kotlin.jvm.internal.f0.o(string, "getString(R.string.devic…waspwing_run_mode_manual)");
            } else if (runMode == 2) {
                string = c3(R.string.device_waspwing_run_mode_manual) + '(' + c3(R.string.wasping_overclock_on) + ')';
            }
            map.put("runMode", string);
            u9.g.a().d(R4(), "Device_Detail_Waspwing", "散热器设置", map);
            o5.m.i().B(DataConstant.SP_DEVICE_HAS_WASPWING_CONNECTED, e0.v(waspWingInfoF));
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        p6();
        m6().h().k(l3(), new b(new ik.l<WaspWingInfo, z1>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.DetailFragment$onViewCreated$1
            {
                super(1);
            }

            public final void b(WaspWingInfo it2) {
                if (!com.blankj.utilcode.util.n0.b(this.this$0.f14642o8, it2.getDeviceCode())) {
                    this.this$0.f14642o8 = it2.getDeviceCode();
                    this.this$0.p6();
                }
                f0 f0Var = null;
                if (!it2.isConnected()) {
                    f0 f0Var2 = this.this$0.f14645r8;
                    if (f0Var2 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        f0Var2 = null;
                    }
                    DividerPaddingLinearLayout dividerPaddingLinearLayout = f0Var2.f10005g;
                    kotlin.jvm.internal.f0.o(dividerPaddingLinearLayout, "viewBinding.areaFunction");
                    o5.c.b(dividerPaddingLinearLayout, Boolean.FALSE, false, 2, null);
                    this.this$0.s6();
                    return;
                }
                this.this$0.q6();
                if (it2.getOverClockUsable() && (it2.getRunMode() == 2 || (it2.getRunMode() == 0 && it2.getTargetTemperature() == 16 && it2.getWindLevelOverclock() == 134 && it2.getColdLevelOverclock() == 173))) {
                    f0 f0Var3 = this.this$0.f14645r8;
                    if (f0Var3 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        f0Var3 = null;
                    }
                    TextView textView = f0Var3.f10012n;
                    kotlin.jvm.internal.f0.o(textView, "viewBinding.tvOverclockState");
                    Boolean bool = Boolean.TRUE;
                    o5.c.b(textView, bool, false, 2, null);
                    f0 f0Var4 = this.this$0.f14645r8;
                    if (f0Var4 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        f0Var4 = null;
                    }
                    View view2 = f0Var4.f10008j;
                    kotlin.jvm.internal.f0.o(view2, "viewBinding.divider");
                    o5.c.b(view2, bool, false, 2, null);
                } else {
                    f0 f0Var5 = this.this$0.f14645r8;
                    if (f0Var5 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        f0Var5 = null;
                    }
                    TextView textView2 = f0Var5.f10012n;
                    kotlin.jvm.internal.f0.o(textView2, "viewBinding.tvOverclockState");
                    Boolean bool2 = Boolean.FALSE;
                    o5.c.b(textView2, bool2, false, 2, null);
                    f0 f0Var6 = this.this$0.f14645r8;
                    if (f0Var6 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        f0Var6 = null;
                    }
                    View view3 = f0Var6.f10008j;
                    kotlin.jvm.internal.f0.o(view3, "viewBinding.divider");
                    o5.c.b(view3, bool2, false, 2, null);
                }
                f0 f0Var7 = this.this$0.f14645r8;
                if (f0Var7 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    f0Var7 = null;
                }
                f0Var7.f10001c.U(it2.getLightState());
                f0 f0Var8 = this.this$0.f14645r8;
                if (f0Var8 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    f0Var8 = null;
                }
                WindSpeedSwitchItem windSpeedSwitchItem = f0Var8.f10003e;
                kotlin.jvm.internal.f0.o(it2, "it");
                windSpeedSwitchItem.setDeviceInfo(it2);
                f0 f0Var9 = this.this$0.f14645r8;
                if (f0Var9 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                } else {
                    f0Var = f0Var9;
                }
                f0Var.f10002d.Q(kotlin.jvm.internal.f0.g(it2.getDeviceCode(), t9.c.f50954c) ? it2.getTemperature() - 4 : it2.getTemperature());
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(WaspWingInfo waspWingInfo) {
                b(waspWingInfo);
                return z1.f38230a;
            }
        }));
        f0 f0Var = this.f14645r8;
        f0 f0Var2 = null;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        f0Var.f10000b.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DetailFragment.n6(this.f14749a, view2);
            }
        });
        f0 f0Var3 = this.f14645r8;
        if (f0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            f0Var2 = f0Var3;
        }
        f0Var2.f10001c.setOnCheckedChangeListener(new ActionItemSwitch.b() { // from class: com.flydigi.device_manager.ui.detail.waspwing.e
            @Override // com.flydigi.base.widget.action_item.ActionItemSwitch.b
            public final void a(boolean z10) {
                DetailFragment.o6(z10);
            }
        });
        if (t9.j.q()) {
            return;
        }
        s6();
        H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f14751a.r6();
            }
        }, 250L);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
        m.a.c(this);
    }

    public final t9.l m6() {
        return (t9.l) this.f14646s8.getValue();
    }

    @Override // com.flydigi.device_manager.ui.firmware.a.b
    public void o0() {
    }

    public final void p6() {
        com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.G(this).p(Integer.valueOf(a5.b.l(this.f14642o8)));
        f0 f0Var = this.f14645r8;
        f0 f0Var2 = null;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        hVarP.s1(f0Var.f10009k);
        f0 f0Var3 = this.f14645r8;
        if (f0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var3 = null;
        }
        f0Var3.f10011m.setText(a5.b.c(this.f14642o8));
        f0 f0Var4 = this.f14645r8;
        if (f0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var4 = null;
        }
        f0Var4.f10014p.setText(a5.b.n(this.f14642o8, Boolean.FALSE, 0));
        f0 f0Var5 = this.f14645r8;
        if (f0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var5 = null;
        }
        f0Var5.f10010l.n(new a.C0280a(X1()).A(V2().getDimensionPixelSize(R.dimen.qb_px_16), 0).m(R.drawable.base_view_divider).y());
        f0 f0Var6 = this.f14645r8;
        if (f0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            f0Var2 = f0Var6;
        }
        f0Var2.f10003e.setDeviceCode(this.f14642o8);
        this.f14644q8.x(this.f14642o8);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
        m.a.d(this, i10);
    }

    public final void q6() {
        f0 f0Var = this.f14645r8;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        if (f0Var.f10005g.getVisibility() == 8) {
            HashMap map = new HashMap();
            map.put("device_code", this.f14642o8);
            u9.g.a().d(R4(), "Device_Detail_B3", "B3已连接", map);
            f0 f0Var2 = this.f14645r8;
            if (f0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var2 = null;
            }
            DividerPaddingLinearLayout dividerPaddingLinearLayout = f0Var2.f10005g;
            kotlin.jvm.internal.f0.o(dividerPaddingLinearLayout, "viewBinding.areaFunction");
            Boolean bool = Boolean.TRUE;
            o5.c.b(dividerPaddingLinearLayout, bool, false, 2, null);
            f0 f0Var3 = this.f14645r8;
            if (f0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var3 = null;
            }
            View view = f0Var3.f10004f;
            kotlin.jvm.internal.f0.o(view, "viewBinding.areaDivider");
            o5.c.b(view, bool, false, 2, null);
            f0 f0Var4 = this.f14645r8;
            if (f0Var4 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var4 = null;
            }
            f0Var4.f10013o.setText(R.string.device_state_connected);
            f0 f0Var5 = this.f14645r8;
            if (f0Var5 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var5 = null;
            }
            f0Var5.f10013o.setTextColor(h0.d.f(R4(), R.color.colorAccentGreen));
            a.InterfaceC0156a interfaceC0156a = this.f14647t8;
            if (interfaceC0156a == null) {
                kotlin.jvm.internal.f0.S("firmwarePresenter");
                interfaceC0156a = null;
            }
            String str = this.f14642o8;
            WaspWingInfo waspWingInfoF = m6().h().f();
            interfaceC0156a.b(str, waspWingInfoF != null ? waspWingInfoF.getFirmwareVersion() : null);
        }
        f0 f0Var6 = this.f14645r8;
        if (f0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var6 = null;
        }
        if (f0Var6.f10007i.getRoot().getVisibility() == 0) {
            f0 f0Var7 = this.f14645r8;
            if (f0Var7 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var7 = null;
            }
            TipView root = f0Var7.f10007i.getRoot();
            kotlin.jvm.internal.f0.o(root, "viewBinding.areaTodoTips.root");
            o5.c.b(root, Boolean.FALSE, false, 2, null);
        }
    }

    public final void r6() {
        o5.a.t0(U1(), ScanFragment.K8.a(this.f14642o8));
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
    public final void s6() {
        f0 f0Var = this.f14645r8;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        TipView it2 = f0Var.f10007i.f10042b;
        if (v5.c.f()) {
            return;
        }
        if (!t9.j.o()) {
            f0 f0Var2 = this.f14645r8;
            if (f0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var2 = null;
            }
            f0Var2.f10013o.setText(R.string.device_state_unconnected);
            f0 f0Var3 = this.f14645r8;
            if (f0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var3 = null;
            }
            f0Var3.f10013o.setTextColor(h0.d.f(R4(), R.color.colorAccentRed));
            f0 f0Var4 = this.f14645r8;
            if (f0Var4 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var4 = null;
            }
            TextView textView = f0Var4.f10012n;
            kotlin.jvm.internal.f0.o(textView, "viewBinding.tvOverclockState");
            Boolean bool = Boolean.FALSE;
            o5.c.b(textView, bool, false, 2, null);
            f0 f0Var5 = this.f14645r8;
            if (f0Var5 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var5 = null;
            }
            View view = f0Var5.f10008j;
            kotlin.jvm.internal.f0.o(view, "viewBinding.divider");
            o5.c.b(view, bool, false, 2, null);
            v6();
            kotlin.jvm.internal.f0.o(it2, "it");
            it2.f(false, R.string.device_tips_bluetooth_closed, R.string.device_tips_bluetooth_closed_desc, R.string.device_setting_now, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DetailFragment.t6(this.f14748a, view2);
                }
            }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
            it2.setTag(R.id.device_tag_tip_type, 1);
            it2.setTag(R.id.device_tag_tip_ignored, bool);
            return;
        }
        if (t9.j.q()) {
            f0 f0Var6 = this.f14645r8;
            if (f0Var6 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var6 = null;
            }
            TipView root = f0Var6.f10007i.getRoot();
            kotlin.jvm.internal.f0.o(root, "viewBinding.areaTodoTips.root");
            o5.c.b(root, Boolean.FALSE, false, 2, null);
            return;
        }
        f0 f0Var7 = this.f14645r8;
        if (f0Var7 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var7 = null;
        }
        f0Var7.f10013o.setText(R.string.device_state_unconnected);
        f0 f0Var8 = this.f14645r8;
        if (f0Var8 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var8 = null;
        }
        f0Var8.f10013o.setTextColor(h0.d.f(R4(), R.color.colorAccentRed));
        f0 f0Var9 = this.f14645r8;
        if (f0Var9 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var9 = null;
        }
        TextView textView2 = f0Var9.f10012n;
        kotlin.jvm.internal.f0.o(textView2, "viewBinding.tvOverclockState");
        Boolean bool2 = Boolean.FALSE;
        o5.c.b(textView2, bool2, false, 2, null);
        f0 f0Var10 = this.f14645r8;
        if (f0Var10 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var10 = null;
        }
        View view2 = f0Var10.f10008j;
        kotlin.jvm.internal.f0.o(view2, "viewBinding.divider");
        o5.c.b(view2, bool2, false, 2, null);
        v6();
        kotlin.jvm.internal.f0.o(it2, "it");
        it2.f(false, R.string.device_tips_device_disconnected, R.string.device_tips_device_disconnected_desc, R.string.device_tips_action_connect, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DetailFragment.u6(this.f14659a, view3);
            }
        }, (224 & 32) != 0 ? null : null, (224 & 64) != 0 ? 0 : 0, (224 & 128) != 0 ? null : null);
        it2.setTag(R.id.device_tag_tip_type, 2);
        it2.setTag(R.id.device_tag_tip_ignored, bool2);
    }

    @Override // com.flydigi.device_manager.ui.detail.c.b
    public void v(@yt.k DeviceDetailBean detailBean) {
        kotlin.jvm.internal.f0.p(detailBean, "detailBean");
        List<DeviceDetailBean.QaListBean> qaList = detailBean.getQaList();
        f0 f0Var = null;
        if (qaList == null || qaList.isEmpty()) {
            f0 f0Var2 = this.f14645r8;
            if (f0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var2 = null;
            }
            LinearLayout linearLayout = f0Var2.f10006h;
            kotlin.jvm.internal.f0.o(linearLayout, "viewBinding.areaQa");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
            return;
        }
        f0 f0Var3 = this.f14645r8;
        if (f0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var3 = null;
        }
        if (f0Var3.f10010l.getAdapter() == null) {
            f0 f0Var4 = this.f14645r8;
            if (f0Var4 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                f0Var4 = null;
            }
            f0Var4.f10010l.setAdapter(this.f14643p8);
        }
        f0 f0Var5 = this.f14645r8;
        if (f0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var5 = null;
        }
        LinearLayout linearLayout2 = f0Var5.f10006h;
        kotlin.jvm.internal.f0.o(linearLayout2, "viewBinding.areaQa");
        o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
        f0 f0Var6 = this.f14645r8;
        if (f0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            f0Var = f0Var6;
        }
        f0Var.f10015q.setText(detailBean.getQaTitle());
        this.f14643p8.m1();
        List<DeviceDetailBean.QaListBean> qaList2 = detailBean.getQaList();
        kotlin.jvm.internal.f0.o(qaList2, "detailBean.qaList");
        for (DeviceDetailBean.QaListBean it2 : qaList2) {
            eu.davidea.flexibleadapter.b<QAItem> bVar = this.f14643p8;
            kotlin.jvm.internal.f0.o(it2, "it");
            bVar.K0(new QAItem(it2));
        }
    }

    public final void v6() {
        f0 f0Var = this.f14645r8;
        if (f0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            f0Var = null;
        }
        if (f0Var.f10007i.f10042b.getVisibility() != 0) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, V2().getDimensionPixelSize(R.dimen.qb_px_130));
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DetailFragment.w6(this.f14656a, valueAnimator);
                }
            });
            valueAnimatorOfInt.addListener(new c());
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.start();
        }
    }
}
