package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes3.dex */
public interface t {

    @t0({"SMAP\nBluetoothCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothCallback.kt\ncom/flydigi/sdk/bluetooth/ConnectionStateCallback$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"})
    public static final class a {
        public static void a(@yt.k t tVar, @yt.l BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice != null) {
                l9.a.e("与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")连接成功");
            }
        }

        public static void b(@yt.k t tVar, @yt.l BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice != null) {
                l9.a.e("与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")断开连接");
            }
        }
    }

    void N(@yt.l BluetoothDevice bluetoothDevice);

    void e0(@yt.l BluetoothDevice bluetoothDevice);
}
