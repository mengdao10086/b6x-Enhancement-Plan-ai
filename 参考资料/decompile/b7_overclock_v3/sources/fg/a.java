package fg;

import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import com.blankj.utilcode.util.i0;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends Service {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f28145o = 512;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f28146p = 23;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f28147q = 23;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f28148r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f28149s = 60000;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f28150t = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothAdapter f28152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGatt f28153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothDevice f28154d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f28151a = "BLEService";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f28155e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Queue<f> f28156f = new LinkedList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f28157g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f28158h = new Handler();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f28159i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayMap<UUID, BluetoothGattCharacteristic> f28160j = new ArrayMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f28161k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f28162l = 60000;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f28163m = 23;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BluetoothGattCallback f28164n = new C0330a();

    /* JADX INFO: renamed from: fg.a$a, reason: collision with other inner class name */
    public class C0330a extends BluetoothGattCallback {
        public C0330a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            a.this.t0(bluetoothGatt, bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            a.this.C0(bluetoothGatt, bluetoothGattCharacteristic, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            a.this.D0(bluetoothGatt, bluetoothGattCharacteristic, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            a.this.E0(bluetoothGatt, i10, i11);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            a.this.F0(bluetoothGatt, bluetoothGattDescriptor, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            a.this.G0(bluetoothGatt, bluetoothGattDescriptor, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            a.this.H0(bluetoothGatt, i10, i11);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i10, int i11) {
            a.this.I0(bluetoothGatt, i10, i11);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            a.this.J0(bluetoothGatt, i10);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.x0();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public static final int f28167v1 = 0;

        /* JADX INFO: renamed from: w1, reason: collision with root package name */
        public static final int f28168w1 = 1;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        public static final int f28169x1 = 2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        public static final int f28170y1 = 3;
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f28171a;

        public d(f fVar) {
            this.f28171a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f28159i = null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request ");
            sb2.append(f.u(this.f28171a.v()));
            sb2.append(": TIME OUT");
            a.this.v0(this.f28171a);
        }
    }

    public boolean A() {
        if (this.f28154d == null || this.f28155e == 2 || this.f28152b == null) {
            return false;
        }
        a1(1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("request reconnect to BluetoothDevice ");
        sb2.append(this.f28154d.getAddress());
        sb2.append(" over GATT starts.");
        if (Build.VERSION.SDK_INT >= 23) {
            this.f28153c = this.f28154d.connectGatt(this, true, this.f28164n, 2);
        } else {
            this.f28153c = this.f28154d.connectGatt(this, true, this.f28164n);
        }
        return true;
    }

    public final boolean A0(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGatt bluetoothGatt;
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Process request read descriptor for descriptor ");
            sb2.append(bluetoothGattDescriptor.getUuid());
        }
        if (this.f28152b == null || (bluetoothGatt = this.f28153c) == null) {
            return false;
        }
        boolean descriptor = bluetoothGatt.readDescriptor(bluetoothGattDescriptor);
        if (this.f28161k) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Request read descriptor dispatched to system: ");
            sb3.append(descriptor);
        }
        return descriptor;
    }

    public final boolean B0() {
        BluetoothGatt bluetoothGatt;
        if (this.f28152b == null || (bluetoothGatt = this.f28153c) == null) {
            return false;
        }
        boolean remoteRssi = bluetoothGatt.readRemoteRssi();
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request read remote RSSI dispatched to system: ");
            sb2.append(remoteRssi);
        }
        return remoteRssi;
    }

    public int C() {
        return this.f28155e;
    }

    public final void C0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GattCallback - onCharacteristicRead, characteristic=");
            sb2.append(bluetoothGattCharacteristic.getUuid());
            sb2.append("status=");
            sb2.append(i10);
        }
        d dVar = this.f28159i;
        f fVarR0 = r0((dVar == null || dVar.f28171a.v() != 6) ? 1 : 6, bluetoothGattCharacteristic);
        boolean z10 = fVarR0 != null;
        if (i10 != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsuccessful read characteristic for characteristic ");
            sb3.append(bluetoothGattCharacteristic.getUuid().toString());
            sb3.append(" - status: ");
            sb3.append(fg.b.c(i10, false));
            if (z10) {
                v0(fVarR0);
            }
        } else if (z10) {
            x0();
        }
        k0(bluetoothGatt, bluetoothGattCharacteristic, i10);
    }

    public final void D0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GattCallback - onCharacteristicWrite, characteristic=");
            sb2.append(bluetoothGattCharacteristic.getUuid());
            sb2.append("status=");
            sb2.append(i10);
        }
        d dVar = this.f28159i;
        f fVarR0 = r0((dVar == null || dVar.f28171a.v() != 3) ? 2 : 3, bluetoothGattCharacteristic);
        boolean z10 = fVarR0 != null;
        if (i10 != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsuccessful write characteristic for characteristic ");
            sb3.append(bluetoothGattCharacteristic.getUuid().toString());
            sb3.append(" - status: ");
            sb3.append(fg.b.c(i10, false));
            if (z10) {
                v0(fVarR0);
            }
        } else if (z10) {
            x0();
        }
        l0(bluetoothGatt, bluetoothGattCharacteristic, i10);
    }

    public final void E0(BluetoothGatt bluetoothGatt, int i10, int i11) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GattCallback - onConnectionStateChange, newState=");
            sb2.append(i11);
            sb2.append(", status=");
            sb2.append(i10);
        }
        if (i10 == 0 && i11 == 2) {
            a1(2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Successful connection to device: ");
            sb3.append(bluetoothGatt.getDevice().getAddress());
            if (this.f28153c == null) {
                this.f28153c = bluetoothGatt;
            }
        } else if (i11 == 0) {
            if (this.f28155e == 3) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Successful disconnection from device: ");
                sb4.append(bluetoothGatt.getDevice().getAddress());
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Disconnected from device: ");
                sb5.append(bluetoothGatt.getDevice().getAddress());
            }
            a1(0);
            X0();
            this.f28160j.clear();
            bluetoothGatt.close();
            this.f28153c = null;
        }
        m0(bluetoothGatt, i10, i11);
    }

    public final void F0(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GattCallback - onDescriptorRead, descriptor=");
            sb2.append(bluetoothGattDescriptor.getUuid());
            sb2.append("status=");
            sb2.append(i10);
        }
        f fVarS0 = s0(4, bluetoothGattDescriptor);
        boolean z10 = fVarS0 != null;
        if (i10 != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsuccessful read descriptor for characteristic ");
            sb3.append(bluetoothGattDescriptor.getCharacteristic().getUuid().toString());
            sb3.append(" - status: ");
            sb3.append(fg.b.c(i10, false));
            if (z10) {
                v0(fVarS0);
            }
        } else if (z10) {
            x0();
        }
        n0(bluetoothGatt, bluetoothGattDescriptor, i10);
    }

    public final void G0(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GattCallback - onDescriptorWrite, descriptor=");
            sb2.append(bluetoothGattDescriptor.getUuid());
            sb2.append("status=");
            sb2.append(i10);
        }
        f fVarS0 = s0(5, bluetoothGattDescriptor);
        boolean z10 = fVarS0 != null;
        if (i10 != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsuccessful write descriptor for characteristic ");
            sb3.append(bluetoothGattDescriptor.getCharacteristic().getUuid().toString());
            sb3.append(" - status: ");
            sb3.append(fg.b.c(i10, false));
            if (z10) {
                v0(fVarS0);
            }
        } else if (z10) {
            x0();
        }
        o0(bluetoothGatt, bluetoothGattDescriptor, i10);
    }

    public final void H0(BluetoothGatt bluetoothGatt, int i10, int i11) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GattCallback - onMtuChanged, mtu=");
            sb2.append(i10);
            sb2.append(" status=");
            sb2.append(i11);
        }
        f fVarQ0 = q0(8);
        boolean z10 = fVarQ0 != null;
        if (i11 != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsuccessful MTU request - status: ");
            sb3.append(fg.b.c(i11, false));
            if (z10) {
                v0(fVarQ0);
            }
        } else if (z10) {
            x0();
        }
        this.f28163m = i10;
        p0(bluetoothGatt, i10, i11);
    }

    public final void I0(BluetoothGatt bluetoothGatt, int i10, int i11) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GattCallback - onRemoteRssiRead, rssi=");
            sb2.append(i10);
            sb2.append(" status=");
            sb2.append(i11);
        }
        f fVarQ0 = q0(7);
        boolean z10 = fVarQ0 != null;
        if (i11 != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsuccessful remote rssi read - status: ");
            sb3.append(fg.b.c(i11, false));
            if (z10) {
                v0(fVarQ0);
            }
        } else if (z10) {
            x0();
        }
        u0(bluetoothGatt, i10, i11);
    }

    public final void J0(BluetoothGatt bluetoothGatt, int i10) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GattCallback - onServicesDiscovered, status=");
            sb2.append(i10);
        }
        if (i10 == 0) {
            Iterator<BluetoothGattService> it2 = bluetoothGatt.getServices().iterator();
            while (it2.hasNext()) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : it2.next().getCharacteristics()) {
                    this.f28160j.put(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic);
                }
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsuccessful status for GATT Services discovery on callback: ");
            sb3.append(fg.b.c(i10, false));
        }
        x0();
        w0(bluetoothGatt, i10);
    }

    public boolean K0(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) {
        BluetoothGattDescriptor descriptor;
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for notification on characteristic with UUID ");
            sb2.append(bluetoothGattCharacteristic.getUuid().toString());
            sb2.append(" for ");
            sb2.append(z10 ? "activation" : "deactivation");
        }
        if (this.f28155e != 2 || bluetoothGattCharacteristic == null || !this.f28160j.containsKey(bluetoothGattCharacteristic.getUuid()) || (descriptor = bluetoothGattCharacteristic.getDescriptor(fg.d.f28183b)) == null) {
            return false;
        }
        f fVarG = f.g(bluetoothGattCharacteristic, z10);
        byte[] bArr = z10 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        c0(fVarG);
        c0(f.n(descriptor, bArr));
        return true;
    }

    public boolean L0(UUID uuid, boolean z10) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for notification on characteristic with UUID ");
            sb2.append(uuid.toString());
            sb2.append(" for ");
            sb2.append(z10 ? "activation" : "deactivation");
        }
        if (this.f28155e != 2) {
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f28160j.get(uuid);
        if (bluetoothGattCharacteristic != null) {
            return K0(bluetoothGattCharacteristic, z10);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("request characteristic notification not initiated: characteristic not found for UUID ");
        sb3.append(uuid);
        sb3.append(j3.b.f36044h);
        return false;
    }

    public final boolean M0(int i10) {
        BluetoothGatt bluetoothGatt;
        if (this.f28152b == null || (bluetoothGatt = this.f28153c) == null) {
            return false;
        }
        boolean zRequestMtu = bluetoothGatt.requestMtu(i10);
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request read remote RSSI dispatched to system: ");
            sb2.append(zRequestMtu);
        }
        return zRequestMtu;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean N0(int i10) {
        if (this.f28155e != 2 || this.f28154d == null) {
            return false;
        }
        if (i10 >= 23 && i10 <= 512) {
            c0(f.h(i10));
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("request MTU not initiated: value (");
        sb2.append(i10);
        sb2.append(") not in interval [");
        sb2.append(23);
        sb2.append(", ");
        sb2.append(512);
        sb2.append("].");
        return false;
    }

    public boolean O0(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for read on characteristic with UUID ");
            sb2.append(bluetoothGattCharacteristic.getUuid().toString());
        }
        if (this.f28155e != 2 || bluetoothGattCharacteristic == null || !this.f28160j.containsKey(bluetoothGattCharacteristic.getUuid()) || (bluetoothGattCharacteristic.getProperties() & 2) <= 0) {
            return false;
        }
        c0(f.i(bluetoothGattCharacteristic));
        return true;
    }

    public boolean P0(UUID uuid) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for read on characteristic with UUID ");
            sb2.append(uuid.toString());
        }
        if (this.f28155e != 2) {
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f28160j.get(uuid);
        if (bluetoothGattCharacteristic != null) {
            return O0(bluetoothGattCharacteristic);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("request read characteristic not initiated: characteristic not found for UUID ");
        sb3.append(uuid);
        sb3.append(j3.b.f36044h);
        return false;
    }

    public boolean Q0(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for read to induce pairing on characteristic with UUID ");
            sb2.append(bluetoothGattCharacteristic.getUuid().toString());
        }
        if (this.f28155e != 2 || bluetoothGattCharacteristic == null || !this.f28160j.containsKey(bluetoothGattCharacteristic.getUuid()) || (bluetoothGattCharacteristic.getProperties() & 2) <= 0) {
            return false;
        }
        f fVarJ = f.j(bluetoothGattCharacteristic);
        fVarJ.x(1);
        c0(fVarJ);
        return true;
    }

    public boolean R0(UUID uuid) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for read to induce pairing on characteristic with UUID ");
            sb2.append(uuid.toString());
        }
        if (this.f28155e != 2) {
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f28160j.get(uuid);
        if (bluetoothGattCharacteristic != null) {
            return Q0(bluetoothGattCharacteristic);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("request read to induce pairing characteristic not initiated: characteristic not found for UUID ");
        sb3.append(uuid);
        sb3.append(j3.b.f36044h);
        return false;
    }

    public boolean S0(BluetoothGattDescriptor bluetoothGattDescriptor) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for read on descriptor with UUID ");
            sb2.append(bluetoothGattDescriptor.getUuid().toString());
        }
        if (this.f28155e != 2 || bluetoothGattDescriptor == null || !this.f28160j.containsKey(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
            return false;
        }
        c0(f.k(bluetoothGattDescriptor));
        return true;
    }

    public boolean T0() {
        BluetoothDevice bluetoothDevice;
        if (this.f28155e != 2 || (bluetoothDevice = this.f28154d) == null || bluetoothDevice.getType() != 2) {
            return false;
        }
        c0(f.l());
        return true;
    }

    public boolean U0(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for write on characteristic with UUID ");
            sb2.append(bluetoothGattCharacteristic.getUuid().toString());
        }
        if (this.f28155e != 2 || bluetoothGattCharacteristic == null || !this.f28160j.containsKey(bluetoothGattCharacteristic.getUuid()) || (bluetoothGattCharacteristic.getProperties() & 8) <= 0) {
            return false;
        }
        c0(f.m(bluetoothGattCharacteristic, bArr));
        return true;
    }

    public boolean V0(UUID uuid, byte[] bArr) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for write on characteristic with UUID ");
            sb2.append(uuid.toString());
        }
        if (this.f28155e != 2) {
            return false;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f28160j.get(uuid);
        if (bluetoothGattCharacteristic != null) {
            return U0(bluetoothGattCharacteristic, bArr);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("request write characteristic not initiated: characteristic not found for UUID ");
        sb3.append(uuid);
        sb3.append(j3.b.f36044h);
        return false;
    }

    public boolean W0(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received for write without response on characteristic with UUID ");
            sb2.append(bluetoothGattCharacteristic.getUuid().toString());
        }
        if (this.f28155e != 2 || bluetoothGattCharacteristic == null || !this.f28160j.containsKey(bluetoothGattCharacteristic.getUuid()) || (bluetoothGattCharacteristic.getProperties() & 4) <= 0) {
            return false;
        }
        c0(f.o(bluetoothGattCharacteristic, bArr));
        return true;
    }

    public final void X0() {
        this.f28156f.clear();
        this.f28157g = false;
        d0();
    }

    public final boolean Y0(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) {
        BluetoothGatt bluetoothGatt;
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Process request set characteristic notification for characteristic ");
            sb2.append(bluetoothGattCharacteristic.getUuid());
            sb2.append(" with enabled=");
            sb2.append(z10);
        }
        if (this.f28152b == null || (bluetoothGatt = this.f28153c) == null) {
            return false;
        }
        boolean characteristicNotification = bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z10);
        if (this.f28161k) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Request set characteristic notification dispatched to system: ");
            sb3.append(characteristicNotification);
        }
        return characteristicNotification;
    }

    public synchronized void Z0(int i10) {
        this.f28162l = i10;
    }

    public synchronized void a1(int i10) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Connection state changes from ");
            sb2.append(fg.b.b(this.f28155e));
            sb2.append(" to ");
            sb2.append(fg.b.b(i10));
        }
        this.f28155e = i10;
    }

    public void b1(boolean z10) {
        this.f28161k = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Debug logs are now ");
        sb2.append(z10 ? "activated" : "deactivated");
        sb2.append(j3.b.f36044h);
    }

    public final void c0(f fVar) {
        if (fVar.p() < 2) {
            if (this.f28161k) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Add request of type ");
                sb2.append(f.u(fVar.v()));
                sb2.append("to the Queue of requests to process.");
            }
            this.f28156f.add(fVar);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Request ");
            sb3.append(f.u(fVar.v()));
            sb3.append(" failed after ");
            sb3.append(fVar.p());
            sb3.append(" attempts.");
        }
        if (this.f28157g) {
            return;
        }
        x0();
    }

    public final boolean c1(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Process request write characteristic for characteristic ");
            sb2.append(bluetoothGattCharacteristic.getUuid());
        }
        if (this.f28152b == null || (bluetoothGatt = this.f28153c) == null) {
            return false;
        }
        boolean zWriteCharacteristic = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        if (this.f28161k) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Request write characteristic dispatched to system: ");
            sb3.append(zWriteCharacteristic);
        }
        return zWriteCharacteristic;
    }

    public final void d0() {
        d dVar = this.f28159i;
        if (dVar != null) {
            this.f28158h.removeCallbacks(dVar);
            this.f28159i = null;
        }
    }

    public final boolean d1(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGatt bluetoothGatt;
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Process request write descriptor for descriptor ");
            sb2.append(bluetoothGattDescriptor.getUuid());
        }
        if (this.f28152b == null || (bluetoothGatt = this.f28153c) == null) {
            return false;
        }
        boolean zWriteDescriptor = bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
        if (this.f28161k) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Request write descriptor dispatched to system: ");
            sb3.append(zWriteDescriptor);
        }
        return zWriteDescriptor;
    }

    public boolean e0(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || this.f28155e == 2 || this.f28152b == null) {
            return false;
        }
        this.f28154d = bluetoothDevice;
        a1(1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("request connect to BluetoothDevice ");
        sb2.append(this.f28154d.getAddress());
        sb2.append(" over GATT starts.");
        if (Build.VERSION.SDK_INT >= 23) {
            this.f28153c = bluetoothDevice.connectGatt(this, false, this.f28164n, 2);
        } else {
            this.f28153c = bluetoothDevice.connectGatt(this, false, this.f28164n);
        }
        return true;
    }

    public void f0() {
        X0();
        this.f28160j.clear();
        if (this.f28152b == null) {
            a1(0);
            return;
        }
        if (this.f28153c == null) {
            a1(0);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request disconnect from BluetoothDevice ");
        sb2.append(this.f28153c.getDevice().getAddress());
        sb2.append(" starts.");
        a1(3);
        this.f28153c.disconnect();
    }

    public BluetoothGatt g0() {
        return this.f28153c;
    }

    public int h0() {
        return this.f28163m;
    }

    public List<BluetoothGattService> i0() {
        BluetoothGatt bluetoothGatt = this.f28153c;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public boolean j0() {
        if (this.f28152b != null && this.f28161k) {
            return true;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(FirmwareUpgradeStatisticsLog.f13300c);
        if (bluetoothManager == null) {
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.f28152b = adapter;
        return adapter != null;
    }

    public abstract void k0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10);

    public abstract void l0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10);

    public abstract void m0(BluetoothGatt bluetoothGatt, int i10, int i11);

    public abstract void n0(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10);

    public abstract void o0(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10);

    public abstract void p0(BluetoothGatt bluetoothGatt, int i10, int i11);

    public final f q0(int i10) {
        d dVar = this.f28159i;
        if (dVar != null && dVar.f28171a.v() == i10) {
            f fVar = this.f28159i.f28171a;
            d0();
            return fVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Received unexpected callback for request type = ");
        sb2.append(f.u(i10));
        return null;
    }

    public final f r0(int i10, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        d dVar = this.f28159i;
        if (dVar != null && dVar.f28171a.v() == i10 && bluetoothGattCharacteristic != null && this.f28159i.f28171a.r() != null && this.f28159i.f28171a.r().getUuid().equals(bluetoothGattCharacteristic.getUuid())) {
            f fVar = this.f28159i.f28171a;
            d0();
            return fVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Received unexpected callback for characteristic ");
        sb2.append(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : i0.f11859x);
        sb2.append(" with request type = ");
        sb2.append(f.u(i10));
        return null;
    }

    public final f s0(int i10, BluetoothGattDescriptor bluetoothGattDescriptor) {
        d dVar = this.f28159i;
        if (dVar != null && dVar.f28171a.v() == i10 && bluetoothGattDescriptor != null && this.f28159i.f28171a.s() != null && this.f28159i.f28171a.s().getUuid().equals(bluetoothGattDescriptor.getUuid())) {
            f fVar = this.f28159i.f28171a;
            d0();
            return fVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Received unexpected callback for descriptor ");
        sb2.append(bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid() : i0.f11859x);
        sb2.append(" with request type = ");
        sb2.append(f.u(i10));
        return null;
    }

    public abstract void t0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    public BluetoothDevice u() {
        return this.f28154d;
    }

    public abstract void u0(BluetoothGatt bluetoothGatt, int i10, int i11);

    public final void v0(f fVar) {
        if (fVar != null && fVar.p() < 2) {
            c0(fVar);
        } else if (fVar != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request ");
            sb2.append(f.u(fVar.v()));
            sb2.append(" failed");
            if (fVar.v() == 6 && this.f28154d.getBondState() == 10) {
                this.f28154d.createBond();
            }
        }
        x0();
    }

    public boolean w(String str) {
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received to connect to a device with address ");
            sb2.append(str);
        }
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return false;
        }
        BluetoothDevice remoteDevice = this.f28152b.getRemoteDevice(str);
        if (remoteDevice != null) {
            return e0(remoteDevice);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("request connect to device not initiated: unable to get a BluetoothDevice from address ");
        sb3.append(str);
        return false;
    }

    public abstract void w0(BluetoothGatt bluetoothGatt, int i10);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x0() {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fg.a.x0():void");
    }

    public final void y0(f fVar) {
        BluetoothGattCharacteristic bluetoothGattCharacteristicA = fVar.a();
        boolean z10 = bluetoothGattCharacteristicA != null && Y0(bluetoothGattCharacteristicA, fVar.q());
        if (!z10 && fVar.p() < 2) {
            c0(fVar);
            x0();
        } else {
            if (z10) {
                this.f28158h.postDelayed(new b(), 1000L);
                return;
            }
            fVar.x(2);
            d dVar = new d(fVar);
            this.f28159i = dVar;
            this.f28158h.postDelayed(dVar, 1000L);
        }
    }

    public final boolean z0(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (this.f28161k) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Process request read characteristic for characteristic ");
            sb2.append(bluetoothGattCharacteristic.getUuid());
        }
        if (this.f28152b == null || (bluetoothGatt = this.f28153c) == null) {
            return false;
        }
        boolean characteristic = bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        if (this.f28161k) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Request read characteristic dispatched to system: ");
            sb3.append(characteristic);
        }
        return characteristic;
    }
}
