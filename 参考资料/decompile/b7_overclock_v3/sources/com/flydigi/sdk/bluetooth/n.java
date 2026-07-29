package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes3.dex */
public interface n {

    @t0({"SMAP\nBluetoothCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothCallback.kt\ncom/flydigi/sdk/bluetooth/BondStateCallback$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"})
    public static final class a {
        public static void a(@yt.k n nVar, @yt.l BluetoothDevice bluetoothDevice, boolean z10) {
            if (z10) {
                if (bluetoothDevice != null) {
                    l9.a.e("与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")配对成功");
                    return;
                }
                return;
            }
            if (bluetoothDevice != null) {
                l9.a.e("与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")配对失败");
            }
        }

        public static void b(@yt.k n nVar, @yt.l BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice != null) {
                l9.a.e("开始与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")配对");
            }
        }

        public static void c(@yt.k n nVar, @yt.l BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice != null) {
                l9.a.e("与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")配对超时");
            }
        }

        public static void d(@yt.k n nVar, @yt.l BluetoothDevice bluetoothDevice, boolean z10) {
            if (z10) {
                if (bluetoothDevice != null) {
                    l9.a.e("与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")取消配对成功");
                    return;
                }
                return;
            }
            if (bluetoothDevice != null) {
                l9.a.e("与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")取消配对失败");
            }
        }

        public static void e(@yt.k n nVar, @yt.l BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice != null) {
                l9.a.e("开始与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")取消配对");
            }
        }

        public static void f(@yt.k n nVar, @yt.l BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice != null) {
                l9.a.e("与" + bluetoothDevice.getName() + ee.a.f26978c + bluetoothDevice.getAddress() + ")取消配对超时");
            }
        }
    }

    void G0(@yt.l BluetoothDevice bluetoothDevice, boolean z10);

    void R1(@yt.l BluetoothDevice bluetoothDevice);

    void V1(@yt.l BluetoothDevice bluetoothDevice);

    void i0(@yt.l BluetoothDevice bluetoothDevice);

    void p2(@yt.l BluetoothDevice bluetoothDevice, boolean z10);

    void y(@yt.l BluetoothDevice bluetoothDevice);
}
