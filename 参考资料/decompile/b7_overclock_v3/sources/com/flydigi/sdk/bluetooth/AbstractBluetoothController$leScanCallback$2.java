package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractBluetoothController$leScanCallback$2 extends Lambda implements ik.a<BluetoothAdapter.LeScanCallback> {
    public final /* synthetic */ AbstractBluetoothController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractBluetoothController$leScanCallback$2(AbstractBluetoothController abstractBluetoothController) {
        super(0);
        this.this$0 = abstractBluetoothController;
    }

    public static final void f(AbstractBluetoothController this$0, BluetoothDevice device, int i10, byte[] bArr) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.P().removeCallbacks(this$0.D());
        kotlin.jvm.internal.f0.o(device, "device");
        this$0.f0(kotlin.collections.s.k(new BleDevice(device, device.getName(), i10, bArr, System.nanoTime())));
    }

    @Override // ik.a
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final BluetoothAdapter.LeScanCallback o() {
        final AbstractBluetoothController abstractBluetoothController = this.this$0;
        return new BluetoothAdapter.LeScanCallback() { // from class: com.flydigi.sdk.bluetooth.h
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public final void onLeScan(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
                AbstractBluetoothController$leScanCallback$2.f(abstractBluetoothController, bluetoothDevice, i10, bArr);
            }
        };
    }
}
