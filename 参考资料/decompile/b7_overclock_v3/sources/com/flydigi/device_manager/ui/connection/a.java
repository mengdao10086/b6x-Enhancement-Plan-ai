package com.flydigi.device_manager.ui.connection;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.flydigi.sdk.gamepad.GamepadInfo;

/* JADX INFO: loaded from: classes7.dex */
public interface a {

    /* JADX INFO: renamed from: com.flydigi.device_manager.ui.connection.a$a, reason: collision with other inner class name */
    public interface InterfaceC0154a {
        void a(@yt.k Context context, @yt.k BluetoothDevice bluetoothDevice, @yt.l GamepadInfo gamepadInfo);
    }

    public interface b {
        void J0(@yt.k BluetoothDevice bluetoothDevice, @yt.k String str, @yt.l GamepadInfo gamepadInfo);

        void X0(@yt.k BluetoothDevice bluetoothDevice);
    }
}
