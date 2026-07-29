package o6;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes7.dex */
public class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0484a f42773a;

    /* JADX INFO: renamed from: o6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0484a {
        void a(BluetoothDevice bluetoothDevice);
    }

    public a(InterfaceC0484a interfaceC0484a) {
        this.f42773a = interfaceC0484a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        BluetoothDevice bluetoothDevice;
        if (!intent.getAction().equals("android.bluetooth.device.action.FOUND") || (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) == null) {
            return;
        }
        this.f42773a.a(bluetoothDevice);
    }
}
