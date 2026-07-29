package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;

/* JADX INFO: loaded from: classes3.dex */
public interface w {

    public static final class a {
        public static void a(@yt.k w wVar, @yt.k BluetoothDevice device) {
            kotlin.jvm.internal.f0.p(device, "device");
            l9.a.e(wVar.getClass().getSimpleName() + " gatt连接失败");
        }

        public static void b(@yt.k w wVar, @yt.k BluetoothDevice device) {
            kotlin.jvm.internal.f0.p(device, "device");
            l9.a.e(wVar.getClass().getSimpleName() + " gatt连接超时");
        }

        public static void c(@yt.k w wVar, @yt.k BluetoothDevice device) {
            kotlin.jvm.internal.f0.p(device, "device");
            l9.a.e(wVar.getClass().getSimpleName() + " gatt已连接");
        }

        public static void d(@yt.k w wVar, @yt.k BluetoothDevice device) {
            kotlin.jvm.internal.f0.p(device, "device");
            l9.a.e(wVar.getClass().getSimpleName() + " gatt连接中");
        }

        public static void e(@yt.k w wVar, @yt.k BluetoothGatt gatt) {
            kotlin.jvm.internal.f0.p(gatt, "gatt");
            l9.a.e(wVar.getClass().getSimpleName() + " gatt连接已断开");
        }

        public static void f(@yt.k w wVar, int i10) {
            l9.a.e(wVar.getClass().getSimpleName() + " 当前信号值：" + i10);
        }
    }

    void A(@yt.k BluetoothDevice bluetoothDevice);

    void O2(@yt.k BluetoothGatt bluetoothGatt);

    void V0(@yt.k BluetoothDevice bluetoothDevice);

    void e2(@yt.k BluetoothDevice bluetoothDevice);

    void g2(@yt.k BluetoothDevice bluetoothDevice);

    void k1(int i10);
}
