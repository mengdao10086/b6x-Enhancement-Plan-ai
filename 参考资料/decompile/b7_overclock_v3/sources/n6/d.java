package n6;

import android.bluetooth.BluetoothGattService;
import n6.a;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f41966a = null;

    public boolean a(BluetoothGattService bluetoothGattService) {
        if (!bluetoothGattService.getUuid().equals(a.g.f41948n)) {
            return false;
        }
        this.f41966a = bluetoothGattService;
        return true;
    }

    public boolean b() {
        return this.f41966a != null;
    }

    public boolean c() {
        return b();
    }

    public void d() {
        this.f41966a = null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DEVICE INFORMATION Service ");
        sb2.append(b() ? "available." : "not available.");
        return sb2.toString();
    }
}
