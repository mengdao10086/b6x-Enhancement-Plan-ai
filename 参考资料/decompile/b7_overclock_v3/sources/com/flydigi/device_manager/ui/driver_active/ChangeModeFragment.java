package com.flydigi.device_manager.ui.driver_active;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import g.p0;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
public class ChangeModeFragment extends BaseGamepadFragment implements com.flydigi.sdk.bluetooth.n {
    public TextView A8;
    public GamepadInfo B8;
    public a C8;

    public interface a {
        void X0(int i10, String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D6() {
        GamepadInfo gamepadInfo = this.B8;
        if (gamepadInfo != null) {
            m9.s.C(gamepadInfo.getAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E6(View view) {
        GamepadInfo gamepadInfo = this.B8;
        if (gamepadInfo == null || !gamepadInfo.isConnected()) {
            return;
        }
        if (!this.B8.isSupportFlashplay()) {
            this.C8.X0(3, this.B8.getDeviceName(), this.B8.getAddress());
            return;
        }
        x(c3(R.string.device_mode_switching), false);
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(this.f13317d8, DataConstant.REMOTE_ACTION_SWITCH_MODE_T);
        H5().f(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f14875a.D6();
            }
        }, 1000L);
    }

    public static ChangeModeFragment F6() {
        return new ChangeModeFragment();
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void G0(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        E0();
        if (z10) {
            com.flydigi.base.common.o.E(c3(R.string.device_switch_succeed));
            G6(true);
        } else {
            h3.a.j().d(a.d.f31951g).withString("key_device_code", this.B8.getDeviceCode()).withBoolean(DataConstant.DEVICE_KEY_REMOVE_BOND_WHEN_UPGRADE_FIRMWARE, false).navigation(w1());
            this.f13317d8.finish();
        }
    }

    public final void G6(boolean z10) {
        if (!com.flydigi.device_manager.ui.p.a()) {
            this.A8.setText(c3(R.string.device_phone_not_support_flash));
            this.A8.setEnabled(false);
            return;
        }
        if (this.B8.getDeviceType() == 16) {
            this.A8.setText(c3(R.string.device_not_support_flash));
            this.A8.setEnabled(false);
            return;
        }
        if (this.B8.isFlashplayMode()) {
            this.A8.setText(c3(R.string.device_flash_play_type));
            this.A8.setEnabled(true);
            if (z10) {
                this.C8.X0(2, this.B8.getDeviceName(), this.B8.getAddress());
            }
        }
        if (this.B8.isDriverMode()) {
            this.A8.setText(c3(R.string.device_tradition_type));
            this.A8.setEnabled(true);
            if (z10) {
                this.C8.X0(1, this.B8.getDeviceName(), this.B8.getAddress());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        super.H3(context);
        this.C8 = (a) context;
    }

    public void H6() {
        if (this.B8.isGamepadHalf()) {
            F5(R.id.iv_mark).setVisibility(8);
            F5(R.id.tv_desc2).setVisibility(8);
            ((TextView) F5(R.id.tv_desc1)).setText(d3(R.string.flash_mode_desc, a5.b.d(this.B8.getDeviceCode(), Boolean.valueOf(this.B8.getIpType()), this.B8.getDeviceType())));
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_layout_fragment_choose_mode;
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

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        m9.s.A(this);
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void i0(@yt.l BluetoothDevice bluetoothDevice) {
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        TextView textView = (TextView) F5(R.id.btn_click);
        this.A8 = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f14873a.E6(view2);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void p2(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@yt.k GamepadInfo gamepadInfo) {
        super.q6(gamepadInfo);
        this.B8 = gamepadInfo;
        if (gamepadInfo.isConnected()) {
            H6();
            G6(false);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.n
    public void y(@yt.l BluetoothDevice bluetoothDevice) {
    }
}
