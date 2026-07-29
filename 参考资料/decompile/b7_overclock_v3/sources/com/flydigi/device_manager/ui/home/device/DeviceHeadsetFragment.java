package com.flydigi.device_manager.ui.home.device;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.k0;
import androidx.lifecycle.z0;
import c7.y0;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.headset.HeadsetInfo;
import kotlin.Pair;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nDeviceHeadsetFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceHeadsetFragment.kt\ncom/flydigi/device_manager/ui/home/device/DeviceHeadsetFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,141:1\n172#2,9:142\n*S KotlinDebug\n*F\n+ 1 DeviceHeadsetFragment.kt\ncom/flydigi/device_manager/ui/home/device/DeviceHeadsetFragment\n*L\n29#1:142,9\n*E\n"})
public final class DeviceHeadsetFragment extends FZFragment {

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public static final a f15140r8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public y0 f15141o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public final kotlin.z f15142p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public final BroadcastReceiver f15143q8 = new b();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final DeviceHeadsetFragment a(@yt.k HeadsetInfo deviceInfo) {
            kotlin.jvm.internal.f0.p(deviceInfo, "deviceInfo");
            DeviceHeadsetFragment deviceHeadsetFragment = new DeviceHeadsetFragment();
            deviceHeadsetFragment.c5(androidx.core.os.e.b(new Pair("key_device_info", deviceInfo)));
            return deviceHeadsetFragment;
        }
    }

    public static final class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@yt.l Context context, @yt.l Intent intent) {
            BluetoothDevice bluetoothDevice = intent != null ? (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE") : null;
            int intExtra = intent != null ? intent.getIntExtra("android.bluetooth.device.extra.BATTERY_LEVEL", -1) : -1;
            String address = bluetoothDevice != null ? bluetoothDevice.getAddress() : null;
            HeadsetInfo headsetInfoF = DeviceHeadsetFragment.this.c6().j().f();
            if (n0.b(address, headsetInfoF != null ? headsetInfoF.getAddress() : null)) {
                DeviceHeadsetFragment.this.c6().l(intExtra);
            }
        }
    }

    public static final class c implements k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f15145a;

        public c(ik.l function) {
            kotlin.jvm.internal.f0.p(function, "function");
            this.f15145a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f15145a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f15145a.i(obj);
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

    public DeviceHeadsetFragment() {
        final ik.a aVar = null;
        this.f15142p8 = FragmentViewModelLazyKt.h(this, kotlin.jvm.internal.n0.d(q9.h.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceHeadsetFragment$special$$inlined$activityViewModels$default$1
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
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceHeadsetFragment$special$$inlined$activityViewModels$default$2
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
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceHeadsetFragment$special$$inlined$activityViewModels$default$3
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
    public static final DeviceHeadsetFragment d6(@yt.k HeadsetInfo headsetInfo) {
        return f15140r8.a(headsetInfo);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        HeadsetInfo headsetInfo;
        super.K3(bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 == null || (headsetInfo = (HeadsetInfo) bundleT1.getParcelable("key_device_info")) == null) {
            return;
        }
        c6().m(headsetInfo);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_home_headset;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        y0 y0VarD = y0.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(y0VarD, "inflate(inflater, container, false)");
        this.f15141o8 = y0VarD;
        if (y0VarD == null) {
            kotlin.jvm.internal.f0.S("binding");
            y0VarD = null;
        }
        ConstraintLayout root = y0VarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "binding.root");
        return root;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        P4().unregisterReceiver(this.f15143q8);
    }

    public final q9.h c6() {
        return (q9.h) this.f15142p8.getValue();
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        P4().registerReceiver(this.f15143q8, new IntentFilter("android.intent.action.BATTERY_LEVEL_CHANGED"));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        c6().h().k(l3(), new c(new ik.l<Integer, z1>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceHeadsetFragment$onViewCreated$1
            {
                super(1);
            }

            public final void b(Integer it2) {
                y0 y0Var = this.this$0.f15141o8;
                if (y0Var == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    y0Var = null;
                }
                TextView textView = y0Var.f10596c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(it2);
                sb2.append('%');
                textView.setText(sb2.toString());
                y0 y0Var2 = this.this$0.f15141o8;
                if (y0Var2 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    y0Var2 = null;
                }
                TextView textView2 = y0Var2.f10596c;
                kotlin.jvm.internal.f0.o(it2, "it");
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(it2.intValue() >= 80 ? R.drawable.device_ic_battery_level_5 : it2.intValue() >= 60 ? R.drawable.device_ic_battery_level_4 : it2.intValue() >= 40 ? R.drawable.device_ic_battery_level_3 : it2.intValue() >= 20 ? R.drawable.device_ic_battery_level_2 : it2.intValue() >= 0 ? R.drawable.device_ic_battery_level_1 : 0, 0, 0, 0);
                y0 y0Var3 = this.this$0.f15141o8;
                if (y0Var3 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    y0Var3 = null;
                }
                TextView textView3 = y0Var3.f10596c;
                kotlin.jvm.internal.f0.o(textView3, "binding.tvBattery");
                o5.c.b(textView3, Boolean.valueOf(it2.intValue() != -1), false, 2, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Integer num) {
                b(num);
                return z1.f38230a;
            }
        }));
        c6().j().k(l3(), new c(new ik.l<HeadsetInfo, z1>() { // from class: com.flydigi.device_manager.ui.home.device.DeviceHeadsetFragment$onViewCreated$2

            @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n+ 2 DeviceHeadsetFragment.kt\ncom/flydigi/device_manager/ui/home/device/DeviceHeadsetFragment$onViewCreated$2\n*L\n1#1,69:1\n114#2,2:70\n*E\n"})
            public static final class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ DeviceHeadsetFragment f15146a;

                public a(DeviceHeadsetFragment deviceHeadsetFragment) {
                    this.f15146a = deviceHeadsetFragment;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f15146a.c6().g();
                }
            }

            {
                super(1);
            }

            public final void b(HeadsetInfo headsetInfo) {
                com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.G(this.this$0).p(Integer.valueOf(a5.b.l(headsetInfo.getDeviceCode())));
                y0 y0Var = this.this$0.f15141o8;
                if (y0Var == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    y0Var = null;
                }
                hVarP.s1(y0Var.f10595b);
                y0 y0Var2 = this.this$0.f15141o8;
                if (y0Var2 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    y0Var2 = null;
                }
                y0Var2.f10597d.setText(a5.b.c(headsetInfo.getDeviceCode()));
                y0 y0Var3 = this.this$0.f15141o8;
                if (y0Var3 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    y0Var3 = null;
                }
                y0Var3.f10598e.setText(headsetInfo.getConnected() ? R.string.device_state_connected : R.string.device_state_unconnected);
                y0 y0Var4 = this.this$0.f15141o8;
                if (y0Var4 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    y0Var4 = null;
                }
                y0Var4.f10598e.setTextColor(com.blankj.utilcode.util.t.a(headsetInfo.getConnected() ? R.color.colorAccentGreen : R.color.colorAccentRed));
                if (headsetInfo.getConnected()) {
                    Handler handler = this.this$0.G5();
                    kotlin.jvm.internal.f0.o(handler, "handler");
                    handler.postDelayed(new a(this.this$0), 1500L);
                    return;
                }
                y0 y0Var5 = this.this$0.f15141o8;
                if (y0Var5 == null) {
                    kotlin.jvm.internal.f0.S("binding");
                    y0Var5 = null;
                }
                TextView textView = y0Var5.f10596c;
                kotlin.jvm.internal.f0.o(textView, "binding.tvBattery");
                o5.c.b(textView, Boolean.FALSE, false, 2, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(HeadsetInfo headsetInfo) {
                b(headsetInfo);
                return z1.f38230a;
            }
        }));
    }
}
