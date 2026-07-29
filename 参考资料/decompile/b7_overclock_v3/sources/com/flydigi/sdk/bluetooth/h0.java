package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.ParcelUuid;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class h0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothDevice f16293b;

    public interface a {
        void a(BluetoothDevice bluetoothDevice, ParcelUuid[] parcelUuidArr);
    }

    public h0(a aVar, BluetoothDevice bluetoothDevice) {
        this.f16292a = aVar;
        this.f16293b = bluetoothDevice;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null || !action.equals("android.bluetooth.device.action.UUID")) {
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
        BluetoothDevice bluetoothDevice2 = this.f16293b;
        if (bluetoothDevice2 == null || !bluetoothDevice2.equals(bluetoothDevice) || parcelableArrayExtra == null) {
            return;
        }
        ParcelUuid[] parcelUuidArr = new ParcelUuid[parcelableArrayExtra.length];
        for (int i10 = 0; i10 < parcelableArrayExtra.length; i10++) {
            parcelUuidArr[i10] = (ParcelUuid) parcelableArrayExtra[i10];
        }
        this.f16292a.a(bluetoothDevice, parcelUuidArr);
    }
}
