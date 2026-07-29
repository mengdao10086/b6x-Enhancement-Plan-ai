package n6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import n6.a;

/* JADX INFO: loaded from: classes7.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f41993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f41994b = null;

    public boolean a(BluetoothGattService bluetoothGattService) {
        if (!bluetoothGattService.getUuid().equals(a.g.f41942h)) {
            return false;
        }
        this.f41993a = bluetoothGattService;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            if (bluetoothGattCharacteristic.getUuid().equals(a.g.f41943i) && (bluetoothGattCharacteristic.getProperties() & 2) > 0) {
                this.f41994b = bluetoothGattCharacteristic;
            }
        }
        return true;
    }

    public BluetoothGattCharacteristic b() {
        return this.f41994b;
    }

    public boolean c() {
        return this.f41993a != null;
    }

    public boolean d() {
        return c() && e();
    }

    public boolean e() {
        return this.f41994b != null;
    }

    public void f() {
        this.f41993a = null;
        this.f41994b = null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TX POWER Service ");
        if (c()) {
            sb2.append("available with the following characteristics:");
            sb2.append("\n\t- TX POWER LEVEL");
            sb2.append(e() ? " available" : " not available or with wrong properties");
        } else {
            sb2.append("not available.");
        }
        return sb2.toString();
    }
}
