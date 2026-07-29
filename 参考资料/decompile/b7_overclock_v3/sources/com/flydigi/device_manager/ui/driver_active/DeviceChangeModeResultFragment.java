package com.flydigi.device_manager.ui.driver_active;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.n0;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.gamepad.GamepadInfo;
import g.p0;
import i9.a;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceChangeModeResultFragment extends BaseGamepadFragment implements com.flydigi.sdk.bluetooth.m, com.flydigi.sdk.bluetooth.n, com.flydigi.sdk.bluetooth.e0 {
    public static final String K8 = "result_type";
    public static final int L8 = 1;
    public static final int M8 = 2;
    public static final int N8 = 3;
    public String A8;
    public String B8;
    public int D8;
    public TextView E8;
    public TextView F8;
    public TextView G8;
    public ImageView H8;
    public String I8;
    public boolean C8 = false;
    public String J8 = "all";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E6(View view) {
        int i10 = this.D8;
        if (i10 == 1) {
            this.f13317d8.finish();
        } else if (i10 == 2) {
            this.f13317d8.finish();
        } else if (i10 == 3) {
            m9.s.C(this.B8);
        }
    }

    public static DeviceChangeModeResultFragment F6(int i10, String str, String str2) {
        DeviceChangeModeResultFragment deviceChangeModeResultFragment = new DeviceChangeModeResultFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(K8, i10);
        bundle.putString("name", str);
        bundle.putString(m7.a.f40701a, str2);
        deviceChangeModeResultFragment.c5(bundle);
        return deviceChangeModeResultFragment;
    }

    public final void C6(int i10) {
        E0();
        com.flydigi.base.common.o.E(c3(i10));
    }

    public final void D6() {
        int i10 = this.D8;
        if (i10 == 1) {
            this.E8.setText(c3(R.string.device_finish));
            this.F8.setText(c3(R.string.device_change_type_to_flash_play));
            if (!TextUtils.isEmpty(this.A8)) {
                this.G8.setText(d3(R.string.firmware_version_, this.A8));
            }
        } else if (i10 == 2) {
            this.E8.setText(c3(R.string.device_finish));
            this.F8.setText(c3(R.string.device_change_type_to_tradition));
            if (!TextUtils.isEmpty(this.A8)) {
                this.G8.setText(d3(R.string.firmware_version_, this.A8));
            }
        } else if (i10 == 3) {
            this.E8.setText(c3(R.string.device_update_device));
            this.F8.setText(c3(R.string.device_current_not_support_flash_play));
            this.G8.setText(c3(R.string.device_please_update_new));
            this.H8.setBackgroundResource(R.drawable.device_connection_warn);
        }
        this.J8 = m9.t.i(this.I8);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void G0(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        if (this.J8 == null) {
            this.J8 = "all";
        }
        if (!z10 || this.C8) {
            return;
        }
        h3.a.j().d(a.d.f31952h).withString("key_device_code", this.J8).navigation(w1());
    }

    public final void G6() {
        x(c3(R.string.device_state_reconnect), false);
        this.C8 = true;
        m9.s.c0(this, 2);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.D8 = bundleT1.getInt(K8);
            this.I8 = bundleT1.getString("name");
            this.B8 = bundleT1.getString(m7.a.f40701a);
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_layout_fragment_change_mode_result;
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void P(boolean z10) {
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void R0() {
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void R1(@yt.l BluetoothDevice bluetoothDevice) {
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void V1(@yt.l BluetoothDevice bluetoothDevice) {
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        m9.s.i0(this);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void b0() {
        C6(R.string.device_connect_failed_notice);
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        m9.s.A(this);
        G6();
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void i0(@yt.l BluetoothDevice bluetoothDevice) {
        C6(R.string.device_connect_failed_notice);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.E8 = (TextView) F5(R.id.tv_next);
        this.F8 = (TextView) F5(R.id.tv_desc);
        this.G8 = (TextView) F5(R.id.tv_version);
        this.H8 = (ImageView) F5(R.id.iv_status_image);
        this.E8.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f14888a.E6(view2);
            }
        });
        D6();
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void l() {
        C6(R.string.device_connect_failed_notice);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void p2(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        if (z10 || bluetoothDevice == null) {
            return;
        }
        C6(R.string.device_connect_success);
    }

    @Override // com.flydigi.sdk.bluetooth.m
    public void q(int i10) {
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void q1(@yt.k List<BleDevice> list) {
        if (n0.z(list)) {
            BluetoothDevice bluetoothDeviceF = list.get(0).F();
            if (!bluetoothDeviceF.getName().toLowerCase().startsWith("dfu") && n0.b(bluetoothDeviceF.getAddress(), this.B8)) {
                m9.s.e0();
                m9.s.e(bluetoothDeviceF);
            }
        }
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@yt.k GamepadInfo gamepadInfo) {
        super.q6(gamepadInfo);
        this.A8 = gamepadInfo.getFirmwareVersion();
        this.I8 = gamepadInfo.getDeviceName();
        this.B8 = gamepadInfo.getAddress();
        this.J8 = gamepadInfo.getDeviceCode();
        if (gamepadInfo.isConnected()) {
            E0();
        }
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(int i10) {
        C6(R.string.device_connect_failed_notice);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void y(@yt.l BluetoothDevice bluetoothDevice) {
        C6(R.string.device_connect_failed_notice);
    }
}
