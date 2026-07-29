package com.flydigi.sdk.bluetooth;

import com.flydigi.sdk.bluetooth.data.BleDevice;
import java.util.List;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes3.dex */
public interface e0 {

    @t0({"SMAP\nBluetoothCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothCallback.kt\ncom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,129:1\n1855#2,2:130\n*S KotlinDebug\n*F\n+ 1 BluetoothCallback.kt\ncom/flydigi/sdk/bluetooth/ScanDeviceCallback$DefaultImpls\n*L\n45#1:130,2\n*E\n"})
    public static final class a {
        public static void a(@yt.k e0 e0Var, @yt.k List<BleDevice> devices) {
            kotlin.jvm.internal.f0.p(devices, "devices");
            for (BleDevice bleDevice : devices) {
                l9.a.e("扫到设备：" + bleDevice.F().getName() + ee.a.f26978c + bleDevice.F().getAddress() + "),信号强度：" + bleDevice.S());
            }
        }

        public static void b(@yt.k e0 e0Var, int i10) {
            l9.a.e("扫描失败，code：" + i10);
        }

        public static void c(@yt.k e0 e0Var) {
            l9.a.e("开始扫描");
        }

        public static void d(@yt.k e0 e0Var) {
            l9.a.e("扫描结束");
        }
    }

    void q1(@yt.k List<BleDevice> list);

    void s2();

    void t0();

    void x0(int i10);
}
