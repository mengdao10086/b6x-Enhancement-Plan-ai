package y2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.text.TextUtils;
import cn.wch.blelib.exception.BLELibException;
import cn.wch.blelib.host.core.Connector;
import cn.wch.blelib.host.core.c;
import cn.wch.blelib.host.core.d;
import g.n0;
import g.v0;
import java.util.List;
import z2.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f56222c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f56223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cn.wch.blelib.host.core.a f56224b;

    /* JADX INFO: renamed from: y2.a$a, reason: collision with other inner class name */
    public class C0663a implements z2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z2.a f56225a;

        public C0663a(z2.a aVar) {
            this.f56225a = aVar;
        }

        @Override // z2.a
        public void a(String str, Throwable th2) {
            this.f56225a.a(str, th2);
        }

        @Override // z2.a
        public void b(String str) {
            this.f56225a.b(str);
        }

        @Override // z2.a
        public void c(String str, BluetoothDevice bluetoothDevice, int i10) {
            a.this.f56223a = null;
            this.f56225a.c(str, bluetoothDevice, i10);
        }

        @Override // z2.a
        public void d(String str) {
            a.this.f56223a = null;
            try {
                a.this.d(true);
            } catch (BLELibException e10) {
                e10.printStackTrace();
            }
            this.f56225a.d(str);
        }

        @Override // z2.a
        public void e(String str, d dVar) {
            a.this.f56223a = dVar;
            this.f56225a.e(str, dVar);
        }

        @Override // z2.a
        public void f(String str, List<BluetoothGattService> list) {
            this.f56225a.f(str, list);
        }
    }

    public static a e() {
        if (f56222c == null) {
            synchronized (a.class) {
                f56222c = new a();
            }
        }
        return f56222c;
    }

    public boolean b(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic) throws BLELibException {
        d dVar = this.f56223a;
        if (dVar != null) {
            return dVar.c(false, bluetoothGattCharacteristic);
        }
        throw new BLELibException("Connection is null,BT is disconnected");
    }

    public void c(c cVar, @n0 z2.a aVar) throws BLELibException {
        if (this.f56223a != null) {
            throw new BLELibException("Already Connected to a device,close connection!");
        }
        if (TextUtils.isEmpty(cVar.b()) || !BluetoothAdapter.checkBluetoothAddress(cVar.b())) {
            throw new BLELibException("MAC address is invalid");
        }
        if (aVar == null) {
            throw new BLELibException("ConnectCallback is null");
        }
        cn.wch.blelib.host.core.a aVar2 = this.f56224b;
        if (aVar2 == null) {
            throw new BLELibException("BleHostManager is null, do you invoke method init() first?");
        }
        aVar2.a(cVar, new C0663a(aVar));
    }

    public void d(boolean z10) throws BLELibException {
        e3.c.a("disconnect： " + z10);
        d dVar = this.f56223a;
        if (dVar == null) {
            return;
        }
        String str = dVar.f11074c;
        if (TextUtils.isEmpty(str) || !BluetoothAdapter.checkBluetoothAddress(str)) {
            throw new BLELibException("MAC address is invalid");
        }
        cn.wch.blelib.host.core.a aVar = this.f56224b;
        if (aVar == null) {
            throw new BLELibException("BleHostManager is null, do you invoke method init() first?");
        }
        aVar.d(str);
        if (z10) {
            this.f56224b.b(str);
            this.f56223a = null;
        }
    }

    public int f() throws BLELibException {
        d dVar = this.f56223a;
        if (dVar != null) {
            return dVar.e();
        }
        throw new BLELibException("Connection is null,BT is disconnected");
    }

    public boolean g(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic) throws BLELibException {
        d dVar = this.f56223a;
        if (dVar != null) {
            return dVar.f(bluetoothGattCharacteristic);
        }
        throw new BLELibException("Connection is null,BT is disconnected");
    }

    public void h(Context context) throws BLELibException {
        cn.wch.blelib.host.core.a aVarG = cn.wch.blelib.host.core.a.g(context);
        this.f56224b = aVarG;
        aVarG.h(context);
    }

    public boolean i(String str) {
        cn.wch.blelib.host.core.a aVar = this.f56224b;
        return aVar != null && aVar.i(str);
    }

    public boolean j(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, z2.d dVar) throws BLELibException {
        d dVar2 = this.f56223a;
        if (dVar2 != null) {
            return dVar2.m(bluetoothGattCharacteristic, dVar, true);
        }
        throw new BLELibException("Connection is null,BT is disconnected");
    }

    public byte[] k(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) throws BLELibException {
        d dVar = this.f56223a;
        if (dVar != null) {
            return dVar.i(bluetoothGattCharacteristic, z10);
        }
        throw new BLELibException("Connection is null,BT is disconnected");
    }

    public boolean l() {
        d dVar = this.f56223a;
        return dVar != null && dVar.j();
    }

    @v0(api = 21)
    public void m(int i10, z2.c cVar) throws BLELibException {
        d dVar = this.f56223a;
        if (dVar == null) {
            throw new BLELibException("Connection is null,BT is disconnected");
        }
        if (i10 < 23) {
            throw new BLELibException("MTU should more than 23");
        }
        if (cVar == null) {
            throw new BLELibException("MTUCallback is null");
        }
        dVar.k(i10, cVar);
    }

    public void n(e eVar) {
        d dVar = this.f56223a;
        if (dVar != null) {
            dVar.n(eVar);
        }
    }

    public int o(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i10) throws BLELibException {
        d dVar = this.f56223a;
        if (dVar == null) {
            throw new BLELibException("Connection is null,BT is disconnected");
        }
        Connector connectorD = dVar.d();
        if (connectorD == null || bluetoothGattCharacteristic == null || i10 < 0) {
            throw new BLELibException("Connector is null,or characteristic is null,or length is negative");
        }
        if ((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0) {
            throw new BLELibException("This characteristic doesn't has WRITE/WRITE_NO_RESPONSE Property");
        }
        if (bArr.length == 0 || i10 == 0) {
            return 0;
        }
        int iN = connectorD.N();
        e3.c.a("当前最大包长：" + iN);
        int iMin = Math.min(i10, bArr.length) / iN;
        int i11 = 0;
        for (int i12 = 0; i12 < iMin; i12++) {
            byte[] bArr2 = new byte[iN];
            System.arraycopy(bArr, i12 * iN, bArr2, 0, iN);
            if (!q(connectorD, bluetoothGattCharacteristic, bArr2)) {
                return i11;
            }
            i11 += iN;
            if (i12 == iMin - 1 && bArr.length % iN == 0) {
                break;
            }
        }
        int iMin2 = Math.min(i10, bArr.length) % iN;
        if (iMin2 == 0) {
            return i11;
        }
        byte[] bArr3 = new byte[iMin2];
        System.arraycopy(bArr, iMin * iN, bArr3, 0, iMin2);
        return !q(connectorD, bluetoothGattCharacteristic, bArr3) ? i11 : i11 + iMin2;
    }

    public boolean p(@n0 BluetoothGattCharacteristic bluetoothGattCharacteristic, @n0 byte[] bArr, int i10) throws BLELibException {
        d dVar = this.f56223a;
        if (dVar == null) {
            throw new BLELibException("Connection is null,BT is disconnected");
        }
        Connector connectorD = dVar.d();
        if (connectorD == null || bluetoothGattCharacteristic == null || i10 < 0) {
            throw new BLELibException("Connector is null,or characteristic is null,or length is negative");
        }
        if ((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0) {
            throw new BLELibException("This characteristic doesn't has WRITE/WRITE_NO_RESPONSE Property");
        }
        if (bArr.length == 0 || i10 == 0) {
            return true;
        }
        int iN = connectorD.N();
        e3.c.a("当前最大包长：" + iN);
        int iMin = Math.min(i10, bArr.length);
        if (iMin <= iN) {
            byte[] bArr2 = new byte[iMin];
            System.arraycopy(bArr, 0, bArr2, 0, iMin);
            return q(connectorD, bluetoothGattCharacteristic, bArr2);
        }
        throw new BLELibException("In this method,you should't write data which length more than maximum package length " + iN);
    }

    public final boolean q(Connector connector, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        if (connector == null) {
            return false;
        }
        return connector.f0(bluetoothGattCharacteristic, bArr);
    }
}
