package n6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import n6.a;

/* JADX INFO: loaded from: classes7.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f41991a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f41992b = null;

    public boolean a(BluetoothGattService bluetoothGattService) {
        if (!bluetoothGattService.getUuid().equals(a.g.f41939e)) {
            return false;
        }
        this.f41991a = bluetoothGattService;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            if (bluetoothGattCharacteristic.getUuid().equals(a.g.f41940f) && (bluetoothGattCharacteristic.getProperties() & 2) > 0 && (bluetoothGattCharacteristic.getProperties() & 8) > 0) {
                this.f41992b = bluetoothGattCharacteristic;
            }
        }
        return true;
    }

    public BluetoothGattCharacteristic b() {
        return this.f41992b;
    }

    public boolean c() {
        return this.f41992b != null;
    }

    public boolean d() {
        return this.f41991a != null;
    }

    public boolean e() {
        return d() && c();
    }

    public void f() {
        this.f41991a = null;
        this.f41992b = null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LINK LOSS Service ");
        if (d()) {
            sb2.append("available with the following characteristics:");
            sb2.append("\n\t- ALERT LEVEL");
            sb2.append(c() ? " available" : " not available or with wrong properties");
        } else {
            sb2.append("not available.");
        }
        return sb2.toString();
    }
}
