package n6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import n6.a;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f41962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f41963b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGattDescriptor f41964c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41965d = 0;

    public boolean a(BluetoothGattService bluetoothGattService) {
        if (!bluetoothGattService.getUuid().equals(a.g.f41944j)) {
            return false;
        }
        this.f41962a = bluetoothGattService;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            if (bluetoothGattCharacteristic.getUuid().equals(a.g.f41945k) && (bluetoothGattCharacteristic.getProperties() & 2) > 0) {
                this.f41963b = bluetoothGattCharacteristic;
                this.f41964c = bluetoothGattCharacteristic.getDescriptor(a.g.f41946l);
            }
        }
        return true;
    }

    public int b() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f41963b;
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(17, 0).intValue();
        }
        return -1;
    }

    public BluetoothGattCharacteristic c() {
        return this.f41963b;
    }

    public int d() {
        return this.f41965d;
    }

    public BluetoothGattDescriptor e() {
        return this.f41964c;
    }

    public boolean f() {
        return this.f41963b != null;
    }

    public boolean g() {
        return this.f41964c != null;
    }

    public boolean h() {
        return this.f41962a != null;
    }

    public boolean i() {
        return h() && f();
    }

    public void j() {
        byte[] value;
        if (!g() || (value = this.f41964c.getValue()) == null || value.length < 7 || value[4] != 1) {
            return;
        }
        this.f41965d = i6.b.b(value, 5, 2, true);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BATTERY Service ");
        if (h()) {
            sb2.append("available with the following characteristics:");
            sb2.append("\n\t- BATTERY LEVEL");
            if (f()) {
                sb2.append(" available with the following descriptors:");
                sb2.append("\n\t\t- PRESENTATION FORMAT");
                sb2.append(g() ? " available" : " not available or with wrong permissions");
            } else {
                sb2.append(" not available or with wrong properties");
            }
        } else {
            sb2.append("not available.");
        }
        return sb2.toString();
    }
}
