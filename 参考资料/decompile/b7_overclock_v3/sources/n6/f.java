package n6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.Iterator;
import java.util.UUID;
import n6.a;

/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f41973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f41974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41975c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothGattCharacteristic f41976d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothGattCharacteristic f41977e = null;

    public class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f41978f = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f41981c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41979a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f41980b = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C0471a f41982d = new C0471a();

        /* JADX INFO: renamed from: n6.f$a$a, reason: collision with other inner class name */
        public class C0471a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f41984a = -1;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f41985b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f41986c = -1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f41987d = -1;

            public C0471a() {
            }
        }

        public a() {
        }
    }

    public boolean a(BluetoothGattService bluetoothGattService) {
        if (!bluetoothGattService.getUuid().equals(a.g.f41947m)) {
            return false;
        }
        this.f41973a = bluetoothGattService;
        Iterator<BluetoothGattCharacteristic> it2 = bluetoothGattService.getCharacteristics().iterator();
        while (true) {
            if (!it2.hasNext()) {
                return true;
            }
            BluetoothGattCharacteristic next = it2.next();
            UUID uuid = next.getUuid();
            if (uuid.equals(a.g.f41949o) && (next.getProperties() & 16) > 0) {
                this.f41974b = next;
                this.f41975c = next.getDescriptor(a.g.f41950p) != null;
            } else if (uuid.equals(a.g.f41951q) && (next.getProperties() & 2) > 0) {
                this.f41976d = next;
            } else if (uuid.equals(a.g.f41952r) && (next.getProperties() & 8) > 0) {
                this.f41977e = next;
            }
        }
    }

    public BluetoothGattCharacteristic b() {
        return this.f41976d;
    }

    public BluetoothGattCharacteristic c() {
        return this.f41977e;
    }

    public BluetoothGattCharacteristic d() {
        return this.f41974b;
    }

    public a e() {
        int i10;
        a aVar = new a();
        if (i()) {
            byte[] value = this.f41974b.getValue();
            byte b10 = value[0];
            aVar.f41982d.f41984a = a.d.C0468a.a(b10, 0, 1);
            aVar.f41982d.f41985b = a.d.C0468a.a(b10, 1, 2);
            aVar.f41982d.f41986c = a.d.C0468a.a(b10, 3, 1);
            aVar.f41982d.f41987d = a.d.C0468a.a(b10, 4, 1);
            int i11 = aVar.f41982d.f41984a;
            if (i11 == 0) {
                aVar.f41979a = this.f41974b.getIntValue(17, 1).intValue();
                i10 = 1;
            } else if (i11 == 1) {
                aVar.f41979a = this.f41974b.getIntValue(18, 1).intValue();
                i10 = 2;
            }
            int i12 = i10 + 1;
            if (aVar.f41982d.f41986c == 1) {
                aVar.f41980b = this.f41974b.getIntValue(18, i12).intValue();
                i12 += 2;
            }
            if (aVar.f41982d.f41987d == 1) {
                int length = value.length - i12;
                if (length % 2 == 0) {
                    int i13 = length / 2;
                    aVar.f41981c = new int[i13];
                    for (int i14 = 0; i14 < i13; i14++) {
                        aVar.f41981c[i14] = (int) ((((double) this.f41974b.getIntValue(18, i12).intValue()) / 1024.0d) * 1000.0d);
                        i12 += 2;
                    }
                }
            }
        }
        return aVar;
    }

    public boolean f() {
        return this.f41976d != null;
    }

    public boolean g() {
        return this.f41975c;
    }

    public boolean h() {
        return this.f41977e != null;
    }

    public boolean i() {
        return this.f41974b != null;
    }

    public boolean j() {
        return this.f41973a != null;
    }

    public boolean k() {
        return j() && i() && g();
    }

    public void l() {
        this.f41973a = null;
        this.f41974b = null;
        this.f41975c = false;
        this.f41976d = null;
        this.f41977e = null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HEART RATE Service ");
        if (j()) {
            sb2.append("available with the following characteristics:");
            sb2.append("\n\t- HEART RATE MEASUREMENT");
            if (i()) {
                sb2.append(" available with the following descriptors:");
                sb2.append("\n\t\t- CLIENT CHARACTERISTIC CONFIGURATION");
                sb2.append(g() ? " available" : " not available or with wrong permissions");
            } else {
                sb2.append(" not available or with wrong properties");
            }
            sb2.append("\n\t- BODY SENSOR LOCATION");
            sb2.append(f() ? " available" : " not available or with wrong properties");
            sb2.append("\n\t- HEART RATE CONTROL POINT");
            sb2.append(h() ? " available" : " not available or with wrong properties");
        } else {
            sb2.append("not available.");
        }
        return sb2.toString();
    }
}
