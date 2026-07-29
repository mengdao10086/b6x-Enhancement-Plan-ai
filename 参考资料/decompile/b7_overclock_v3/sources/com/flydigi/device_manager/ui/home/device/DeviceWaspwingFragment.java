package com.flydigi.device_manager.ui.home.device;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.k0;
import androidx.lifecycle.z0;
import c7.z0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import kotlin.Pair;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nDeviceWaspwingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceWaspwingFragment.kt\ncom/flydigi/device_manager/ui/home/device/DeviceWaspwingFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,94:1\n172#2,9:95\n*S KotlinDebug\n*F\n+ 1 DeviceWaspwingFragment.kt\ncom/flydigi/device_manager/ui/home/device/DeviceWaspwingFragment\n*L\n25#1:95,9\n*E\n"})
public final class DeviceWaspwingFragment extends FZFragment {

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public static final a f15152q8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public z0 f15153o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public final kotlin.z f15154p8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final DeviceWaspwingFragment a(@yt.k WaspWingInfo deviceInfo) {
            kotlin.jvm.internal.f0.p(deviceInfo, "deviceInfo");
            DeviceWaspwingFragment deviceWaspwingFragment = new DeviceWaspwingFragment();
            deviceWaspwingFragment.c5(androidx.core.os.e.b(new Pair("key_device_info", deviceInfo)));
            return deviceWaspwingFragment;
        }
    }

    public static final class b implements k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f15155a;

        public b(ik.l function) {
            kotlin.jvm.internal.f0.p(function, "function");
            this.f15155a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f15155a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f15155a.i(obj);
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

    public DeviceWaspwingFragment() {
        final ik.a aVar = null;
        this.f15154p8 = FragmentViewModelLazyKt.h(this, n0.d(t9.l.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceWaspwingFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c1 o() {
                c1 c1VarO0 = this.P4().O0();
                kotlin.jvm.internal.f0.o(c1VarO0, "requireActivity().viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceWaspwingFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final p1.a o() {
                p1.a aVar2;
                ik.a aVar3 = aVar;
                if (aVar3 != null && (aVar2 = (p1.a) aVar3.o()) != null) {
                    return aVar2;
                }
                p1.a aVarJ0 = this.P4().j0();
                kotlin.jvm.internal.f0.o(aVarJ0, "requireActivity().defaultViewModelCreationExtras");
                return aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceWaspwingFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final z0.b o() {
                z0.b bVarH0 = this.P4().h0();
                kotlin.jvm.internal.f0.o(bVarH0, "requireActivity().defaultViewModelProviderFactory");
                return bVarH0;
            }
        });
    }

    @hk.m
    @yt.k
    public static final DeviceWaspwingFragment b6(@yt.k WaspWingInfo waspWingInfo) {
        return f15152q8.a(waspWingInfo);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        WaspWingInfo waspWingInfo;
        super.K3(bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 == null || (waspWingInfo = (WaspWingInfo) bundleT1.getParcelable("key_device_info")) == null) {
            return;
        }
        a6().i(waspWingInfo);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_home_waspwing;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        c7.z0 z0VarD = c7.z0.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(z0VarD, "inflate(inflater, container, false)");
        this.f15153o8 = z0VarD;
        if (z0VarD == null) {
            kotlin.jvm.internal.f0.S("binding");
            z0VarD = null;
        }
        ConstraintLayout root = z0VarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "binding.root");
        return root;
    }

    public final t9.l a6() {
        return (t9.l) this.f15154p8.getValue();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        a6().h().k(l3(), new b(new ik.l<WaspWingInfo, z1>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceWaspwingFragment$onViewCreated$1
            {
                super(1);
            }

            public final void b(WaspWingInfo waspWingInfo) {
                int ipType = waspWingInfo.getIpType();
                if (com.blankj.utilcode.util.n0.b(t9.c.f50958g, waspWingInfo.getDeviceCode()) && o5.m.k(DataConstant.SP_APP).c(DataConstant.SP_APP_KEY_WASPWING_IP_TYPE)) {
                    ipType = o5.m.k(DataConstant.SP_APP).m(DataConstant.SP_APP_KEY_WASPWING_IP_TYPE);
                }
                com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.G(this.this$0).p(Integer.valueOf(a5.b.m(waspWingInfo.getDeviceCode(), Boolean.valueOf(ipType > 0), ipType)));
                c7.z0 z0Var = this.this$0.f15153o8;
                if (z0Var == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    z0Var = null;
                }
                hVarP.s1(z0Var.f10637b);
                c7.z0 z0Var2 = this.this$0.f15153o8;
                if (z0Var2 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    z0Var2 = null;
                }
                z0Var2.f10638c.setText(a5.b.d(waspWingInfo.getDeviceCode(), Boolean.valueOf(ipType > 0), ipType));
                if (waspWingInfo.isConnected()) {
                    c7.z0 z0Var3 = this.this$0.f15153o8;
                    if (z0Var3 == null) {
                        kotlin.jvm.internal.f0.S("binding");
                        z0Var3 = null;
                    }
                    z0Var3.f10639d.setText(R.string.device_state_connected);
                    c7.z0 z0Var4 = this.this$0.f15153o8;
                    if (z0Var4 == null) {
                        kotlin.jvm.internal.f0.S("binding");
                        z0Var4 = null;
                    }
                    z0Var4.f10639d.setTextColor(com.blankj.utilcode.util.t.a(R.color.colorAccentGreen));
                } else {
                    c7.z0 z0Var5 = this.this$0.f15153o8;
                    if (z0Var5 == null) {
                        kotlin.jvm.internal.f0.S("binding");
                        z0Var5 = null;
                    }
                    z0Var5.f10639d.setText(R.string.device_state_unconnected);
                    c7.z0 z0Var6 = this.this$0.f15153o8;
                    if (z0Var6 == null) {
                        kotlin.jvm.internal.f0.S("binding");
                        z0Var6 = null;
                    }
                    z0Var6.f10639d.setTextColor(com.blankj.utilcode.util.t.a(R.color.colorAccentRed));
                }
                c7.z0 z0Var7 = this.this$0.f15153o8;
                if (z0Var7 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    z0Var7 = null;
                }
                z0Var7.f10640e.setText(this.this$0.d3(R.string.device_fragment_detail_b3_temperature_device, Integer.valueOf(waspWingInfo.getTemperature())));
                c7.z0 z0Var8 = this.this$0.f15153o8;
                if (z0Var8 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    z0Var8 = null;
                }
                TextView textView = z0Var8.f10640e;
                kotlin.jvm.internal.f0.o(textView, "binding.tvTemperatureB3");
                o5.c.b(textView, Boolean.valueOf(waspWingInfo.isConnected()), false, 2, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(WaspWingInfo waspWingInfo) {
                b(waspWingInfo);
                return z1.f38230a;
            }
        }));
    }
}
