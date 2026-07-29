package o6;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.ParcelUuid;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes7.dex */
public class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f42776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothDevice f42777b;

    public interface a {
        void a(BluetoothDevice bluetoothDevice, ParcelUuid[] parcelUuidArr);
    }

    public d(a aVar, BluetoothDevice bluetoothDevice) {
        this.f42776a = aVar;
        this.f42777b = bluetoothDevice;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        BluetoothDevice bluetoothDevice;
        String action = intent.getAction();
        if (action == null || !action.equals("android.bluetooth.device.action.UUID")) {
            return;
        }
        BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
        if (bluetoothDevice2 == null || (bluetoothDevice = this.f42777b) == null || !bluetoothDevice.equals(bluetoothDevice2) || parcelableArrayExtra == null) {
            return;
        }
        ParcelUuid[] parcelUuidArr = new ParcelUuid[parcelableArrayExtra.length];
        for (int i10 = 0; i10 < parcelableArrayExtra.length; i10++) {
            parcelUuidArr[i10] = (ParcelUuid) parcelableArrayExtra[i10];
        }
        this.f42776a.a(bluetoothDevice2, parcelUuidArr);
    }
}
