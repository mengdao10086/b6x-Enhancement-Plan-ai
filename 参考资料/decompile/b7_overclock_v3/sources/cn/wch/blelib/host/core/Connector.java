package cn.wch.blelib.host.core;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import g.v0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import z2.e;
import z2.f;
import z2.g;

/* JADX INFO: loaded from: classes2.dex */
public class Connector {
    public static final UUID C = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public Runnable B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cn.wch.blelib.host.core.c f11019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z2.a f11020d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f11023g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BluetoothGatt f11025i;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final BluetoothManager f11039w;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f11021e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f11022f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f11024h = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public STATE f11026j = STATE.BLE_DISCONNECTED;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<BluetoothGattService> f11027k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f11028l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f11029m = new byte[20];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11030n = 20;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f11031o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11032p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public z2.b f11033q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public z2.c f11034r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f11035s = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public NOTIFY_STATE f11040x = NOTIFY_STATE.DEFAULT;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f11041y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f11042z = 600;
    public final BluetoothGattCallback A = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, z2.d> f11036t = new HashMap();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<String, g> f11037u = new HashMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, f> f11038v = new HashMap();

    public enum NOTIFY_STATE {
        PREPARE,
        OPENED,
        CLOSED,
        DEFAULT
    }

    public enum STATE {
        BLE_CONNECTED,
        BLE_DISCONNECTED
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Connector.this.f11024h = false;
            if (Connector.this.f11025i != null) {
                Connector.this.f11025i.disconnect();
                Connector.this.f11025i.close();
            }
            if (Connector.this.f11020d != null) {
                e3.c.a("Connector " + Connector.this.f11018b + " ConnectTimeout");
                Connector.this.f11020d.d(Connector.this.f11018b);
            }
        }
    }

    public class b extends BluetoothGattCallback {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e3.c.a("discoverServices-->" + Connector.this.J());
            }
        }

        public b() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            z2.d dVar = (z2.d) Connector.this.f11036t.get(bluetoothGattCharacteristic.getUuid().toString());
            if (dVar != null) {
                dVar.b(Connector.this.f11018b, bluetoothGattCharacteristic.getValue());
                e3.c.a("onCharacteristicChanged:" + e3.b.a(bluetoothGattCharacteristic.getValue()));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            f fVar = (f) Connector.this.f11038v.get(bluetoothGattCharacteristic.getUuid().toString());
            if (bluetoothGattCharacteristic.getValue() == null || bluetoothGattCharacteristic.getValue().length == 0) {
                e3.c.a("READ NULL");
                if (fVar != null) {
                    fVar.c(Connector.this.f11018b);
                }
                Connector.this.f11021e = true;
                Connector.this.f11028l = false;
                Connector.this.f11032p = 0;
                return;
            }
            Connector.this.f11021e = false;
            e3.c.a("onCharacteristicRead:" + e3.b.a(bluetoothGattCharacteristic.getValue()));
            if (fVar != null) {
                fVar.b(Connector.this.f11018b, bluetoothGattCharacteristic.getValue());
            }
            Connector.this.f11032p = bluetoothGattCharacteristic.getValue().length;
            System.arraycopy(bluetoothGattCharacteristic.getValue(), 0, Connector.this.f11029m, 0, bluetoothGattCharacteristic.getValue().length);
            Connector.this.f11028l = false;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            if (i10 != 0) {
                e3.c.a("write error: " + i10);
                return;
            }
            Connector.this.f11028l = false;
            g gVar = (g) Connector.this.f11037u.get(bluetoothGattCharacteristic.getUuid().toString());
            if (gVar != null) {
                gVar.c(Connector.this.f11018b, bluetoothGattCharacteristic.getValue());
                e3.c.a(Connector.this.f11018b + " onCharacteristicWrite:" + e3.b.a(bluetoothGattCharacteristic.getValue()));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            if (i11 != 0) {
                if (i11 != 2) {
                    return;
                }
                Connector.this.f11026j = STATE.BLE_CONNECTED;
                if (Connector.this.f11020d != null) {
                    Connector.this.f11020d.e(Connector.this.f11018b, new d(Connector.this, bluetoothGatt));
                }
                bluetoothGatt.requestConnectionPriority(1);
                Connector.this.f11022f.postDelayed(new a(), 600L);
                return;
            }
            e3.c.a("DISCONNECT " + i10);
            Connector.this.L();
            if (Connector.this.f11024h) {
                e3.c.a(" try -->reConnect");
                Connector.this.G();
                return;
            }
            Connector.this.f11026j = STATE.BLE_DISCONNECTED;
            Connector.this.F();
            if (Connector.this.f11020d != null) {
                Connector.this.f11020d.c(Connector.this.f11018b, device, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            e3.c.a("onDescriptorWrite--> descriptor: " + bluetoothGattDescriptor.getUuid().toString() + " value: " + e3.b.a(bluetoothGattDescriptor.getValue()) + " status: " + i10);
            if (bluetoothGattDescriptor.getUuid().toString().equalsIgnoreCase(Connector.C.toString())) {
                if (i10 == 0 && e3.b.a(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE).equalsIgnoreCase(e3.b.a(bluetoothGattDescriptor.getValue()))) {
                    Connector.this.f11040x = NOTIFY_STATE.OPENED;
                } else if (i10 == 0 && e3.b.a(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE).equalsIgnoreCase(e3.b.a(bluetoothGattDescriptor.getValue()))) {
                    Connector.this.f11040x = NOTIFY_STATE.CLOSED;
                } else {
                    Connector.this.f11040x = NOTIFY_STATE.DEFAULT;
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            Connector.this.f11030n = i10 - 3;
            Connector connector = Connector.this;
            connector.f11029m = new byte[connector.f11030n];
            if (Connector.this.f11034r != null) {
                Connector.this.f11034r.a(bluetoothGatt, i10, i11);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyRead(BluetoothGatt bluetoothGatt, int i10, int i11, int i12) {
            super.onPhyRead(bluetoothGatt, i10, i11, i12);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i10, int i11, int i12) {
            super.onPhyUpdate(bluetoothGatt, i10, i11, i12);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (Connector.this.f11035s != null) {
                Connector.this.f11035s.a(i10, i11);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i10) {
            super.onReliableWriteCompleted(bluetoothGatt, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            e3.c.a("onServicesDiscovered-->" + i10);
            Connector.this.V();
            Connector.this.C();
            Connector.this.Q();
            Connector.this.f11025i.requestConnectionPriority(1);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e3.c.a("startDiscoverCountDown-->" + Connector.this.J());
        }
    }

    public Connector(Context context, String str, cn.wch.blelib.host.core.c cVar, z2.a aVar) {
        this.f11017a = context;
        this.f11018b = str;
        this.f11019c = cVar;
        this.f11020d = aVar;
        this.f11039w = (BluetoothManager) context.getSystemService(FirmwareUpgradeStatisticsLog.f13300c);
        b0();
    }

    @Deprecated
    public void A(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, g gVar) {
        if (gVar == null) {
            return;
        }
        e3.c.a("try write :" + e3.b.a(bArr));
        if (this.f11025i == null || bluetoothGattCharacteristic == null) {
            gVar.a(this.f11018b, new Throwable("GATT or Character is null"));
            return;
        }
        if (!T()) {
            gVar.a(this.f11018b, new Throwable("device is not connected"));
            return;
        }
        this.f11037u.put(bluetoothGattCharacteristic.getUuid().toString(), gVar);
        bluetoothGattCharacteristic.setValue(bArr);
        if (this.f11025i.writeCharacteristic(bluetoothGattCharacteristic)) {
            return;
        }
        e3.c.a("write fail");
        gVar.d(this.f11018b, bArr);
    }

    @Deprecated
    public boolean B(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        e3.c.a("try write :" + e3.b.a(bArr));
        if (this.f11025i == null || bluetoothGattCharacteristic == null || !T()) {
            return false;
        }
        bluetoothGattCharacteristic.setValue(bArr);
        return this.f11025i.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public final void C() {
        Runnable runnable = this.B;
        if (runnable != null) {
            this.f11022f.removeCallbacks(runnable);
        }
    }

    public boolean D() {
        return this.f11025i != null;
    }

    public void E() {
        if (this.f11024h) {
            V();
        }
        L();
    }

    public void F() {
        this.f11036t.clear();
        this.f11038v.clear();
        this.f11037u.clear();
    }

    public void G() {
        e3.c.a(this.f11018b + "  connect");
        BluetoothDevice remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.f11018b);
        if (remoteDevice == null) {
            e3.c.b("Connector", this.f11018b, "Adapter getRemoteDevice ,result is null");
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.f11025i = remoteDevice.connectGatt(this.f11017a, false, this.A, 2);
        } else {
            this.f11025i = remoteDevice.connectGatt(this.f11017a, false, this.A);
        }
    }

    public void H() {
        if (this.f11026j == STATE.BLE_CONNECTED && D()) {
            this.f11025i.disconnect();
        }
    }

    public void I(z2.b bVar) {
        this.f11033q = bVar;
        if (J()) {
            return;
        }
        bVar.a(new Throwable("Gatt is null"));
    }

    public boolean J() {
        if (this.f11025i == null) {
            return false;
        }
        e3.c.b("Connector", this.f11018b, "discoverServices");
        return this.f11025i.discoverServices();
    }

    public synchronized boolean K(boolean z10, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        e3.c.a("try--->change notification " + z10);
        boolean z11 = false;
        if (bluetoothGattCharacteristic == null) {
            return false;
        }
        if (!D()) {
            return false;
        }
        if (!this.f11025i.setCharacteristicNotification(bluetoothGattCharacteristic, z10)) {
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(C);
        if (descriptor != null) {
            descriptor.setValue(z10 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            this.f11040x = NOTIFY_STATE.PREPARE;
            if (!this.f11025i.writeDescriptor(descriptor)) {
                this.f11040x = NOTIFY_STATE.DEFAULT;
                e3.c.a("writeDescriptor fail");
                return false;
            }
            for (int i10 = 0; i10 < 150; i10++) {
                if ((z10 && this.f11040x == NOTIFY_STATE.OPENED) || (!z10 && this.f11040x == NOTIFY_STATE.CLOSED)) {
                    z11 = true;
                    break;
                }
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
            this.f11040x = NOTIFY_STATE.DEFAULT;
        }
        e3.c.a("Change Notify result: " + z11);
        return z11;
    }

    public final void L() {
        if (D()) {
            this.f11025i.disconnect();
            this.f11025i.close();
            this.f11025i = null;
        }
    }

    public String M() {
        return this.f11018b;
    }

    public int N() {
        return this.f11030n;
    }

    public int O() {
        return this.f11030n + 3;
    }

    public List<BluetoothGattService> P() {
        return this.f11027k;
    }

    public final void Q() {
        BluetoothGatt bluetoothGatt = this.f11025i;
        if (bluetoothGatt != null) {
            List<BluetoothGattService> services = bluetoothGatt.getServices();
            this.f11027k = services;
            z2.a aVar = this.f11020d;
            if (aVar != null) {
                aVar.f(this.f11018b, services);
            }
            z2.b bVar = this.f11033q;
            if (bVar != null) {
                bVar.b(this.f11027k);
            }
        }
    }

    public byte[] R() {
        return this.f11029m;
    }

    public int S() {
        return this.f11032p;
    }

    public boolean T() {
        return this.f11026j == STATE.BLE_CONNECTED;
    }

    public boolean U(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattDescriptor descriptor;
        return D() && (descriptor = bluetoothGattCharacteristic.getDescriptor(C)) != null && descriptor.getValue() == BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
    }

    public final void V() {
        this.f11024h = false;
        Runnable runnable = this.f11023g;
        if (runnable != null) {
            this.f11022f.removeCallbacks(runnable);
            this.f11023g = null;
        }
    }

    @v0(api = 21)
    public void W(int i10, z2.c cVar) {
        this.f11034r = cVar;
        BluetoothGatt bluetoothGatt = this.f11025i;
        if (bluetoothGatt != null) {
            bluetoothGatt.requestMtu(i10);
        }
    }

    public void X(cn.wch.blelib.host.core.c cVar) {
        this.f11019c = cVar;
    }

    public synchronized boolean Y(BluetoothGattCharacteristic bluetoothGattCharacteristic, z2.d dVar, boolean z10) {
        boolean z11;
        e3.c.a("setNotifyListener: " + bluetoothGattCharacteristic.getUuid().toString());
        if (!z10) {
            this.f11036t.put(bluetoothGattCharacteristic.getUuid().toString(), dVar);
            return true;
        }
        if (U(bluetoothGattCharacteristic)) {
            e3.c.a("notify has opened");
            this.f11036t.put(bluetoothGattCharacteristic.getUuid().toString(), dVar);
            return true;
        }
        this.f11036t.put(bluetoothGattCharacteristic.getUuid().toString(), dVar);
        int i10 = 0;
        while (true) {
            if (i10 >= 10) {
                z11 = false;
                break;
            }
            if (K(true, bluetoothGattCharacteristic)) {
                z11 = true;
                break;
            }
            i10++;
        }
        if (z11) {
            return true;
        }
        this.f11036t.remove(bluetoothGattCharacteristic.getUuid().toString());
        dVar.a(this.f11018b, new Throwable("open notify function fail"));
        return false;
    }

    public void Z(e eVar) {
        this.f11035s = eVar;
    }

    public void a0(boolean z10) {
        this.f11028l = z10;
    }

    public void b0() {
        z2.a aVar = this.f11020d;
        if (aVar != null) {
            aVar.b(this.f11018b);
        }
        y();
        G();
    }

    public final void c0() {
        c cVar = new c();
        this.B = cVar;
        this.f11022f.postDelayed(cVar, 500L);
    }

    public boolean d0(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        for (int i10 = 0; i10 < this.f11019c.c(); i10++) {
            e3.c.a("syncReadRepeat-->" + i10);
            if (e0(bluetoothGattCharacteristic)) {
                if (!this.f11021e) {
                    this.f11021e = false;
                    return true;
                }
                this.f11021e = false;
            }
        }
        return false;
    }

    public boolean e0(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f11025i == null || bluetoothGattCharacteristic == null || !T()) {
            return false;
        }
        a0(true);
        this.f11025i.readCharacteristic(bluetoothGattCharacteristic);
        return g0(this.f11019c.d());
    }

    public boolean f0(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        e3.c.a("try write :" + e3.b.a(bArr));
        if (this.f11025i == null || bluetoothGattCharacteristic == null || !T()) {
            return false;
        }
        bluetoothGattCharacteristic.setValue(bArr);
        a0(true);
        boolean zWriteCharacteristic = this.f11025i.writeCharacteristic(bluetoothGattCharacteristic);
        if (zWriteCharacteristic) {
            e3.c.a("wait...");
            zWriteCharacteristic = g0(this.f11019c.e());
        }
        e3.c.a("waitIdle " + zWriteCharacteristic);
        return zWriteCharacteristic;
    }

    public final boolean g0(long j10) {
        long j11 = (j10 * 50) + 1;
        while (true) {
            long j12 = j11 - 1;
            if (j11 <= 0) {
                e3.c.a("waitIdle Timeout!");
                this.f11028l = false;
                return false;
            }
            if (!this.f11028l) {
                e3.c.a("waitIdle break");
                return true;
            }
            if (!T()) {
                return false;
            }
            try {
                Thread.sleep(0L, 20000);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            j11 = j12;
        }
    }

    public final void y() {
        V();
        this.f11024h = true;
        a aVar = new a();
        this.f11023g = aVar;
        this.f11022f.postDelayed(aVar, this.f11019c.a());
    }

    public void z(BluetoothGattCharacteristic bluetoothGattCharacteristic, f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.f11025i == null || bluetoothGattCharacteristic == null) {
            fVar.a(this.f11018b, new Throwable("GATT or Character is null"));
        } else if (!T()) {
            fVar.a(this.f11018b, new Throwable("device is not connected"));
        } else {
            this.f11038v.put(bluetoothGattCharacteristic.getUuid().toString(), fVar);
            this.f11025i.readCharacteristic(bluetoothGattCharacteristic);
        }
    }
}
