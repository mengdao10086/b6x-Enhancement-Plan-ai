package n6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.Iterator;
import java.util.UUID;
import n6.a;

/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41967a = "GattServiceGaia";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattService f41968b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGattCharacteristic f41969c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothGattCharacteristic f41970d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothGattCharacteristic f41971e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f41972f = false;

    public boolean a(BluetoothGattService bluetoothGattService) {
        if (!bluetoothGattService.getUuid().equals(a.g.f41935a)) {
            return false;
        }
        this.f41968b = bluetoothGattService;
        Iterator<BluetoothGattCharacteristic> it2 = bluetoothGattService.getCharacteristics().iterator();
        while (true) {
            if (!it2.hasNext()) {
                return true;
            }
            BluetoothGattCharacteristic next = it2.next();
            UUID uuid = next.getUuid();
            if (uuid.equals(a.g.f41936b)) {
                this.f41969c = next;
            } else if (uuid.equals(a.g.f41937c) && (next.getProperties() & 8) > 0) {
                this.f41970d = next;
            } else if (uuid.equals(a.g.f41938d) && (next.getProperties() & 2) > 0) {
                this.f41971e = next;
                int properties = next.getProperties();
                this.f41972f = (properties & 4) > 0 && (properties & 16) > 0;
            }
        }
    }

    public BluetoothGattCharacteristic b() {
        return this.f41970d;
    }

    public BluetoothGattCharacteristic c() {
        return this.f41971e;
    }

    public BluetoothGattCharacteristic d() {
        return this.f41969c;
    }

    public boolean e() {
        return this.f41970d != null;
    }

    public boolean f() {
        return this.f41971e != null;
    }

    public boolean g() {
        return this.f41969c != null;
    }

    public boolean h() {
        return this.f41972f;
    }

    public boolean i() {
        return this.f41968b != null;
    }

    public boolean j() {
        return i() && e() && f() && g();
    }

    public void k() {
        this.f41968b = null;
        this.f41971e = null;
        this.f41969c = null;
        this.f41970d = null;
        this.f41972f = false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("GAIA Service ");
        if (i()) {
            sb2.append("available with the following characteristics:");
            sb2.append("\n\t- GAIA COMMAND");
            sb2.append(e() ? " available" : " not available or with wrong properties");
            sb2.append("\n\t- GAIA DATA");
            sb2.append(f() ? " available" : " not available or with wrong properties");
            sb2.append("\n\t- GAIA RESPONSE");
            sb2.append(g() ? " available" : " not available or with wrong properties");
        } else {
            sb2.append("not available.");
        }
        return sb2.toString();
    }
}
