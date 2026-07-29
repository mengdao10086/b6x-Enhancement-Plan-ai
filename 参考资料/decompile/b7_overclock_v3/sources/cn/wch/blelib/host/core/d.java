package cn.wch.blelib.host.core;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import cn.wch.blelib.exception.BLELibException;
import g.n0;
import g.v0;
import z2.e;
import z2.f;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Connector f11072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGatt f11073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11074c;

    public d(@n0 Connector connector, @n0 BluetoothGatt bluetoothGatt) {
        this.f11072a = connector;
        this.f11073b = bluetoothGatt;
        this.f11074c = connector.M();
    }

    public void a() {
        this.f11072a.E();
    }

    public void b() {
        this.f11072a.H();
    }

    public boolean c(boolean z10, @n0 BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if ((bluetoothGattCharacteristic.getProperties() & 16) > 0) {
            return this.f11072a.K(z10, bluetoothGattCharacteristic);
        }
        return false;
    }

    public Connector d() {
        return this.f11072a;
    }

    public int e() throws BLELibException {
        Connector connector = this.f11072a;
        if (connector != null) {
            return connector.O();
        }
        throw new BLELibException("connector is null");
    }

    public boolean f(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if ((bluetoothGattCharacteristic.getProperties() & 16) > 0) {
            return this.f11072a.U(bluetoothGattCharacteristic);
        }
        return false;
    }

    public boolean g() {
        return this.f11072a.T();
    }

    public void h(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, f fVar) {
        this.f11072a.z(bluetoothGattCharacteristic, fVar);
    }

    public byte[] i(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) {
        if ((bluetoothGattCharacteristic.getProperties() & 2) == 0) {
            return null;
        }
        if (!z10 ? this.f11072a.d0(bluetoothGattCharacteristic) : this.f11072a.e0(bluetoothGattCharacteristic)) {
            return null;
        }
        byte[] bArrR = this.f11072a.R();
        int iS = this.f11072a.S();
        byte[] bArr = new byte[iS];
        System.arraycopy(bArrR, 0, bArr, 0, iS);
        return bArr;
    }

    public boolean j() {
        BluetoothGatt bluetoothGatt = this.f11073b;
        if (bluetoothGatt != null) {
            return bluetoothGatt.readRemoteRssi();
        }
        return false;
    }

    @v0(api = 21)
    public void k(int i10, z2.c cVar) {
        Connector connector = this.f11072a;
        if (connector == null) {
            return;
        }
        connector.W(i10, cVar);
    }

    public final d l(@n0 c cVar) {
        this.f11072a.X(cVar);
        return this;
    }

    public boolean m(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, z2.d dVar, boolean z10) {
        if ((bluetoothGattCharacteristic.getProperties() & 16) > 0) {
            return this.f11072a.Y(bluetoothGattCharacteristic, dVar, z10);
        }
        dVar.a(this.f11074c, new Throwable("This characteristic do not has NOTIFY Property"));
        return false;
    }

    public void n(e eVar) {
        Connector connector;
        if (this.f11073b == null || (connector = this.f11072a) == null) {
            return;
        }
        connector.Z(eVar);
    }

    public byte[] o(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, @n0 byte[] bArr, @n0 BluetoothGattCharacteristic bluetoothGattCharacteristic2, int i10, long j10) {
        if (q(bluetoothGattCharacteristic, bArr, bArr.length) != bArr.length || i10 < 0) {
            return null;
        }
        if (j10 > 0) {
            try {
                Thread.sleep(j10);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
        byte[] bArr2 = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            byte[] bArrI = i(bluetoothGattCharacteristic2, false);
            if (bArrI == null || bArrI.length == 0) {
                return null;
            }
            int length = bArrI.length + i11 > i10 ? i10 - i11 : bArrI.length;
            System.arraycopy(bArrI, 0, bArr2, i11, length);
            i11 += length;
        }
        return bArr2;
    }

    public byte[] p(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, @n0 byte[] bArr, @n0 BluetoothGattCharacteristic bluetoothGattCharacteristic2, long j10) {
        if (q(bluetoothGattCharacteristic, bArr, bArr.length) != bArr.length) {
            return null;
        }
        if (j10 > 0) {
            try {
                Thread.sleep(j10);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
        return i(bluetoothGattCharacteristic2, false);
    }

    public int q(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, @n0 byte[] bArr, int i10) {
        if (this.f11072a == null || bluetoothGattCharacteristic == null || bArr == null || i10 < 0) {
            return -1;
        }
        if ((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0) {
            return -2;
        }
        if (bArr.length == 0 || i10 == 0) {
            return 0;
        }
        int iN = this.f11072a.N();
        int iMin = Math.min(i10, bArr.length) / iN;
        int i11 = 0;
        for (int i12 = 0; i12 < iMin; i12++) {
            byte[] bArr2 = new byte[iN];
            System.arraycopy(bArr, i12 * iN, bArr2, 0, iN);
            if (!this.f11072a.f0(bluetoothGattCharacteristic, bArr2)) {
                return i11;
            }
            i11 += iN;
            if (i12 == iMin - 1 && bArr.length % iN == 0) {
                break;
            }
        }
        int iMin2 = Math.min(i10, bArr.length) % iN;
        byte[] bArr3 = new byte[iMin2];
        if (iMin2 == 0) {
            return i11;
        }
        System.arraycopy(bArr, iMin * iN, bArr3, 0, iMin2);
        if (!this.f11072a.f0(bluetoothGattCharacteristic, bArr3)) {
            return i11;
        }
        int i13 = i11 + iMin2;
        e3.c.a("final write " + iMin2);
        return i13;
    }

    public boolean r(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, @n0 byte[] bArr, int i10) {
        if (this.f11072a == null || bluetoothGattCharacteristic == null || bArr == null || i10 < 0) {
            return false;
        }
        if ((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0) {
            return false;
        }
        if (bArr.length == 0 || i10 == 0) {
            return true;
        }
        int iMin = Math.min(i10, bArr.length);
        byte[] bArr2 = new byte[iMin];
        System.arraycopy(bArr, 0, bArr2, 0, iMin);
        return this.f11072a.f0(bluetoothGattCharacteristic, bArr2);
    }
}
