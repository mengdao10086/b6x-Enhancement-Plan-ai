package com.flydigi.qiji.ui.about_phone;

import a5.b;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.os.e;
import androidx.core.util.j;
import b9.h;
import com.blankj.utilcode.util.e0;
import com.blankj.utilcode.util.x;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.o;
import com.flydigi.base.widget.DividerPaddingLinearLayout;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.ui.home.device.w;
import com.flydigi.qiji.ui.about_phone.AboutPhoneFragment;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import o5.m;
import o5.p;
import u9.c;
import yt.k;
import yt.l;
import zc.f;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nAboutPhoneFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AboutPhoneFragment.kt\ncom/flydigi/qiji/ui/about_phone/AboutPhoneFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,151:1\n1#2:152\n*E\n"})
public final class AboutPhoneFragment extends BaseGamepadFragment {

    @k
    public static final a B8 = new a(null);
    public h A8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final AboutPhoneFragment a() {
            AboutPhoneFragment aboutPhoneFragment = new AboutPhoneFragment();
            aboutPhoneFragment.c5(e.a());
            return aboutPhoneFragment;
        }
    }

    public static final void F6(AboutPhoneFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.E6();
    }

    public static final void G6(AboutPhoneFragment this$0, View view) {
        f0.p(this$0, "this$0");
        GamepadInfo gamepadInfoK6 = this$0.k6();
        if (gamepadInfoK6 != null) {
            o5.a.t0(this$0.U1(), QrCodeDialogFragment.F8.a(gamepadInfoK6.getAddress(), gamepadInfoK6.getUuid()));
        }
    }

    public static final void H6(AboutPhoneFragment this$0, WaspWingInfo this_apply, View view) {
        f0.p(this$0, "this$0");
        f0.p(this_apply, "$this_apply");
        o5.a.t0(this$0.U1(), QrCodeDialogFragment.F8.a(this_apply.getAddress(), this_apply.getUuid()));
    }

    public final void E6() {
        Context contextX1 = X1();
        if (contextX1 == null || !p.a(contextX1, c.a(R4()))) {
            return;
        }
        o.E(contextX1.getString(R.string.app_copy_already));
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_fragment_about_phone;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        h hVarD = h.d(inflater, viewGroup, false);
        f0.o(hVarD, "inflate(inflater, container, false)");
        this.A8 = hVarD;
        if (hVarD == null) {
            f0.S("viewBinding");
            hVarD = null;
        }
        LinearLayout root = hVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        h hVar = this.A8;
        h hVar2 = null;
        if (hVar == null) {
            f0.S("viewBinding");
            hVar = null;
        }
        com.blankj.utilcode.util.o.r(hVar.f9193u, new View.OnClickListener() { // from class: d9.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutPhoneFragment.F6(this.f26113a, view2);
            }
        });
        h hVar3 = this.A8;
        if (hVar3 == null) {
            f0.S("viewBinding");
            hVar3 = null;
        }
        hVar3.f9174b.Q(a9.a.f312f);
        h hVar4 = this.A8;
        if (hVar4 == null) {
            f0.S("viewBinding");
            hVar4 = null;
        }
        hVar4.f9183k.Q(x.j() + f.f58383m + x.k());
        h hVar5 = this.A8;
        if (hVar5 == null) {
            f0.S("viewBinding");
            hVar5 = null;
        }
        hVar5.f9184l.Q(Build.VERSION.RELEASE);
        h hVar6 = this.A8;
        if (hVar6 == null) {
            f0.S("viewBinding");
            hVar6 = null;
        }
        com.blankj.utilcode.util.o.r(hVar6.f9178f, new View.OnClickListener() { // from class: d9.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutPhoneFragment.G6(this.f26114a, view2);
            }
        });
        final WaspWingInfo waspWingInfo = (WaspWingInfo) e0.h(m.i().q(DataConstant.SP_DEVICE_HAS_WASPWING_CONNECTED), WaspWingInfo.class);
        if (waspWingInfo == null) {
            h hVar7 = this.A8;
            if (hVar7 == null) {
                f0.S("viewBinding");
                hVar7 = null;
            }
            DividerPaddingLinearLayout dividerPaddingLinearLayout = hVar7.f9192t;
            f0.o(dividerPaddingLinearLayout, "viewBinding.areaWaspwingInfo");
            o5.c.b(dividerPaddingLinearLayout, Boolean.FALSE, false, 2, null);
            return;
        }
        h hVar8 = this.A8;
        if (hVar8 == null) {
            f0.S("viewBinding");
            hVar8 = null;
        }
        hVar8.f9187o.Q(b.c(waspWingInfo.getDeviceCode()));
        h hVar9 = this.A8;
        if (hVar9 == null) {
            f0.S("viewBinding");
            hVar9 = null;
        }
        hVar9.f9186n.Q(waspWingInfo.getAddress());
        h hVar10 = this.A8;
        if (hVar10 == null) {
            f0.S("viewBinding");
            hVar10 = null;
        }
        hVar10.f9185m.Q(waspWingInfo.getFirmwareVersion());
        h hVar11 = this.A8;
        if (hVar11 == null) {
            f0.S("viewBinding");
            hVar11 = null;
        }
        ActionItemNormal actionItemNormal = hVar11.f9188p;
        int runMode = waspWingInfo.getRunMode();
        String string = "";
        if (runMode == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c3(R.string.device_waspwing_run_mode_smart));
            float runModeSmartLevel = waspWingInfo.getRunModeSmartLevel();
            if (runModeSmartLevel == 0.0f) {
                string = '-' + c3(R.string.device_fragment_detail_waspwing_temperature_level_max);
            } else {
                if (runModeSmartLevel == 1.0f) {
                    string = '-' + c3(R.string.device_fragment_detail_waspwing_temperature_level_middle);
                } else {
                    if (runModeSmartLevel == 2.0f) {
                        if (waspWingInfo.getOverClockUsable()) {
                            string = '-' + c3(R.string.device_fragment_detail_waspwing_temperature_level_min) + '(' + c3(R.string.wasping_overclock_on) + ')';
                        } else {
                            string = '-' + c3(R.string.device_fragment_detail_waspwing_temperature_level_min);
                        }
                    }
                }
            }
            sb2.append(string);
            string = sb2.toString();
        } else if (runMode == 1) {
            string = c3(R.string.device_waspwing_run_mode_manual);
            f0.o(string, "getString(R.string.devic…waspwing_run_mode_manual)");
        } else if (runMode == 2) {
            string = c3(R.string.device_waspwing_run_mode_manual) + '-' + c3(R.string.wasping_overclock_on);
        }
        actionItemNormal.Q(string);
        h hVar12 = this.A8;
        if (hVar12 == null) {
            f0.S("viewBinding");
        } else {
            hVar2 = hVar12;
        }
        com.blankj.utilcode.util.o.r(hVar2.f9186n, new View.OnClickListener() { // from class: d9.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AboutPhoneFragment.H6(this.f26115a, waspWingInfo, view2);
            }
        });
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        h hVar = this.A8;
        h hVar2 = null;
        if (hVar == null) {
            f0.S("viewBinding");
            hVar = null;
        }
        hVar.f9179g.Q(j.a(deviceInfo.getDeviceCode(), "all") ? "" : b.d(deviceInfo.getDeviceCode(), Boolean.valueOf(deviceInfo.getIpType()), deviceInfo.getDeviceType()));
        h hVar3 = this.A8;
        if (hVar3 == null) {
            f0.S("viewBinding");
            hVar3 = null;
        }
        ActionItemNormal actionItemNormal = hVar3.f9178f;
        String address = deviceInfo.getAddress();
        if (address == null) {
            address = "";
        }
        actionItemNormal.Q(address);
        h hVar4 = this.A8;
        if (hVar4 == null) {
            f0.S("viewBinding");
            hVar4 = null;
        }
        ActionItemNormal actionItemNormal2 = hVar4.f9177e;
        String firmwareVersion = deviceInfo.getFirmwareVersion();
        actionItemNormal2.Q(firmwareVersion != null ? firmwareVersion : "");
        if (deviceInfo.isConnected()) {
            h hVar5 = this.A8;
            if (hVar5 == null) {
                f0.S("viewBinding");
                hVar5 = null;
            }
            hVar5.f9175c.Q(c3(w.c(deviceInfo, null, 1, null)));
        } else {
            h hVar6 = this.A8;
            if (hVar6 == null) {
                f0.S("viewBinding");
                hVar6 = null;
            }
            hVar6.f9175c.Q(c3(R.string.device_state_unconnected));
        }
        if (deviceInfo.isDriverConnected()) {
            h hVar7 = this.A8;
            if (hVar7 == null) {
                f0.S("viewBinding");
            } else {
                hVar2 = hVar7;
            }
            hVar2.f9176d.Q(deviceInfo.getDriverVersion());
            return;
        }
        h hVar8 = this.A8;
        if (hVar8 == null) {
            f0.S("viewBinding");
        } else {
            hVar2 = hVar8;
        }
        hVar2.f9176d.Q(c3(R.string.device_mapping_inactive));
    }
}
