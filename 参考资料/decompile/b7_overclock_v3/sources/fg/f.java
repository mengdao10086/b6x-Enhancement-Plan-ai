package fg;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import g.n0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f28315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothGattCharacteristic f28316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BluetoothGattDescriptor f28317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f28318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f28319e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f28320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f28321g;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {
        public static final int A1 = 1;
        public static final int B1 = 2;
        public static final int C1 = 3;
        public static final int D1 = 4;
        public static final int E1 = 5;
        public static final int F1 = 6;
        public static final int G1 = 7;
        public static final int H1 = 8;

        /* JADX INFO: renamed from: z1, reason: collision with root package name */
        public static final int f28322z1 = 0;
    }

    public f(int i10, BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, boolean z10, int i11) {
        this.f28315a = i10;
        this.f28316b = bluetoothGattCharacteristic;
        this.f28317c = bluetoothGattDescriptor;
        this.f28320f = bArr;
        this.f28318d = z10;
        this.f28321g = i11;
    }

    @n0
    public static f g(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) {
        return new f(0, bluetoothGattCharacteristic, null, null, z10, 0);
    }

    @n0
    public static f h(int i10) {
        return new f(8, null, null, null, false, i10);
    }

    @n0
    public static f i(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new f(1, bluetoothGattCharacteristic, null, null, false, 0);
    }

    @n0
    public static f j(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new f(6, bluetoothGattCharacteristic, null, null, false, 0);
    }

    @n0
    public static f k(@n0 BluetoothGattDescriptor bluetoothGattDescriptor) {
        return new f(4, null, bluetoothGattDescriptor, null, false, 0);
    }

    @n0
    public static f l() {
        return new f(7, null, null, null, false, 0);
    }

    @n0
    public static f m(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, @n0 byte[] bArr) {
        return new f(2, bluetoothGattCharacteristic, null, bArr, false, 0);
    }

    @n0
    public static f n(@n0 BluetoothGattDescriptor bluetoothGattDescriptor, @n0 byte[] bArr) {
        return new f(5, null, bluetoothGattDescriptor, bArr, false, 0);
    }

    @n0
    public static f o(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, @n0 byte[] bArr) {
        return new f(3, bluetoothGattCharacteristic, null, bArr, false, 0);
    }

    public static String u(int i10) {
        switch (i10) {
            case 0:
                return "CHARACTERISTIC_NOTIFICATION";
            case 1:
                return "READ_CHARACTERISTIC";
            case 2:
                return "WRITE_CHARACTERISTIC";
            case 3:
                return "WRITE_NO_RESPONSE_CHARACTERISTIC";
            case 4:
                return "READ_DESCRIPTOR";
            case 5:
                return "WRITE_DESCRIPTOR";
            case 6:
                return "READ_CHARACTERISTIC_TO_INDUCE_PAIRING";
            case 7:
                return "READ_RSSI";
            case 8:
                return "REQUEST_MTU";
            default:
                return "UNKNOWN " + i10;
        }
    }

    public BluetoothGattCharacteristic a() {
        if (this.f28315a == 0) {
            return this.f28316b;
        }
        return null;
    }

    public BluetoothGattCharacteristic b() {
        int i10 = this.f28315a;
        if (i10 == 1 || i10 == 6) {
            return this.f28316b;
        }
        return null;
    }

    public BluetoothGattDescriptor c() {
        if (this.f28315a == 4) {
            return this.f28317c;
        }
        return null;
    }

    public BluetoothGattCharacteristic d() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        if (this.f28315a != 2 || (bluetoothGattCharacteristic = this.f28316b) == null || (bluetoothGattCharacteristic.getProperties() & 8) <= 0) {
            return null;
        }
        byte[] bArr = this.f28320f;
        if (bArr != null) {
            this.f28316b.setValue(bArr);
        }
        this.f28316b.setWriteType(2);
        return this.f28316b;
    }

    public BluetoothGattDescriptor e() {
        if (this.f28315a != 5) {
            return null;
        }
        byte[] bArr = this.f28320f;
        if (bArr != null) {
            this.f28317c.setValue(bArr);
        }
        return this.f28317c;
    }

    public BluetoothGattCharacteristic f() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        if (this.f28315a != 3 || (bluetoothGattCharacteristic = this.f28316b) == null || (bluetoothGattCharacteristic.getProperties() & 4) <= 0) {
            return null;
        }
        byte[] bArr = this.f28320f;
        if (bArr != null) {
            this.f28316b.setValue(bArr);
        }
        this.f28316b.setWriteType(1);
        return this.f28316b;
    }

    public int p() {
        return this.f28319e;
    }

    public boolean q() {
        return this.f28318d;
    }

    public BluetoothGattCharacteristic r() {
        return this.f28316b;
    }

    public BluetoothGattDescriptor s() {
        return this.f28317c;
    }

    public int t() {
        return this.f28321g;
    }

    public int v() {
        return this.f28315a;
    }

    public void w() {
        this.f28319e++;
    }

    public void x(int i10) {
        this.f28319e = i10;
    }
}
