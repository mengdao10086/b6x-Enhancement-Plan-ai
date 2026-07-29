package o6;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes7.dex */
public class c extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f42775a;

    public interface a {
        void c(BluetoothDevice bluetoothDevice, int i10);
    }

    public c(a aVar) {
        this.f42775a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        BluetoothDevice bluetoothDevice;
        if (!intent.getAction().equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
            if (!intent.getAction().equals("android.bluetooth.device.action.PAIRING_REQUEST") || (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) == null) {
                return;
            }
            this.f42775a.c(bluetoothDevice, 11);
            return;
        }
        BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
        if (bluetoothDevice2 == null || intExtra <= -1) {
            return;
        }
        this.f42775a.c(bluetoothDevice2, intExtra);
    }
}
