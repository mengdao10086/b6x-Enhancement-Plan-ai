package n6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import n6.a;

/* JADX INFO: loaded from: classes7.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f41989a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f41990b = null;

    public boolean a(BluetoothGattService bluetoothGattService) {
        if (!bluetoothGattService.getUuid().equals(a.g.f41941g)) {
            return false;
        }
        this.f41989a = bluetoothGattService;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            if (bluetoothGattCharacteristic.getUuid().equals(a.g.f41940f) && (bluetoothGattCharacteristic.getProperties() & 4) > 0) {
                this.f41990b = bluetoothGattCharacteristic;
            }
        }
        return true;
    }

    public BluetoothGattCharacteristic b() {
        return this.f41990b;
    }

    public boolean c() {
        return this.f41990b != null;
    }

    public boolean d() {
        return this.f41989a != null;
    }

    public boolean e() {
        return d() && c();
    }

    public void f() {
        this.f41989a = null;
        this.f41990b = null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("IMMEDIATE ALERT Service ");
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
