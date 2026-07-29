package com.flydigi.cyberfox.h1.services;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import androidx.collection.l;
import g.f0;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import k6.k;
import n6.a;
import o6.c;
import p6.b;

/* JADX INFO: loaded from: classes7.dex */
public class GAIAGATTBLEService extends fg.a implements c.a, k.a, com.flydigi.cyberfox.h1.services.b, b.InterfaceC0527b {
    public static final int E7 = 1000;
    public k D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f14140u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f14141v = "GAIAGATTBLEService";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<Handler> f14144w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final IBinder f14145x = new f();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList<UUID> f14146y = new ArrayList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final o6.c f14147z = new o6.c(this);
    public boolean A = false;
    public boolean B = false;
    public boolean C = true;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final n6.b f14138k0 = new n6.b();
    public boolean K0 = false;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final Handler f14139k1 = new Handler();

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final p6.b f14142v1 = new p6.b(this);
    public final Queue<Double> C1 = new LinkedList();
    public long K1 = 0;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f14143v2 = false;
    public int C2 = 0;
    public final Runnable K2 = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GAIAGATTBLEService.this.K0) {
                GAIAGATTBLEService gAIAGATTBLEService = GAIAGATTBLEService.this;
                gAIAGATTBLEService.K0 = gAIAGATTBLEService.T0();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GAIAGATTBLEService.this.A();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GAIAGATTBLEService.this.f14143v2 || !GAIAGATTBLEService.this.r1()) {
                GAIAGATTBLEService.this.C2 = 0;
                return;
            }
            GAIAGATTBLEService.k1(GAIAGATTBLEService.this);
            GAIAGATTBLEService gAIAGATTBLEService = GAIAGATTBLEService.this;
            gAIAGATTBLEService.Q0(gAIAGATTBLEService.f14138k0.f41955b.c());
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface d {
        public static final int A0 = 11;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public static final int f14151p0 = 0;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public static final int f14152q0 = 1;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static final int f14153r0 = 2;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public static final int f14154s0 = 3;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public static final int f14155t0 = 4;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public static final int f14156u0 = 5;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public static final int f14157v0 = 6;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public static final int f14158w0 = 7;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public static final int f14159x0 = 8;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public static final int f14160y0 = 9;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public static final int f14161z0 = 10;
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface e {
        public static final int B0 = 0;
        public static final int C0 = 1;
    }

    public class f extends Binder {
        public f() {
        }

        public GAIAGATTBLEService a() {
            return GAIAGATTBLEService.this;
        }
    }

    public static /* synthetic */ int k1(GAIAGATTBLEService gAIAGATTBLEService) {
        int i10 = gAIAGATTBLEService.C2;
        gAIAGATTBLEService.C2 = i10 + 1;
        return i10;
    }

    @Override // fg.a, com.flydigi.cyberfox.h1.services.b
    public boolean A() {
        return super.A();
    }

    public boolean A1(int i10) {
        return N0(i10);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public int B() {
        k kVar = this.D;
        if (kVar != null) {
            return kVar.I();
        }
        return 0;
    }

    public boolean B1(int i10) {
        return this.f14142v1.B(i10);
    }

    @Override // fg.a, com.flydigi.cyberfox.h1.services.b
    @SuppressLint({"WrongConstant"})
    public int C() {
        int iC = super.C();
        int i10 = 1;
        if (iC != 1) {
            i10 = 2;
            if (iC != 2) {
                i10 = 3;
                if (iC != 3) {
                    return 0;
                }
            }
        }
        return i10;
    }

    public boolean C1(int i10) {
        return this.f14142v1.C(i10);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void D() {
        if (s1()) {
            v1();
        } else {
            E1();
            f0();
        }
    }

    public final void D1() {
        unregisterReceiver(this.f14147z);
    }

    @Override // k6.k.a
    public boolean E(byte[] bArr, boolean z10) {
        if (!this.D.J() || !z10) {
            return w1(bArr);
        }
        if (this.K1 <= 0) {
            this.K1 = System.currentTimeMillis();
        }
        return this.f14142v1.w(bArr);
    }

    public final void E1() {
        for (int i10 = 0; i10 < this.f14146y.size(); i10++) {
            L0(this.f14146y.get(i10), false);
        }
    }

    @Override // k6.k.a
    public void F() {
        if (N()) {
            return;
        }
        this.D.v();
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public n6.b G() {
        return this.f14138k0;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean H() {
        return this.f14138k0.f41959f.f() && O0(this.f14138k0.f41959f.b());
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void I() {
        if (this.D != null) {
            if (this.f14142v1.j()) {
                this.f14142v1.c();
            }
            this.C1.clear();
            this.D.E();
        }
    }

    @Override // p6.b.InterfaceC0527b
    public void J() {
        I();
        z1(6, 8);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void K(boolean z10) {
        if (z10 && this.D == null) {
            k kVar = new k(this, 0);
            this.D = kVar;
            kVar.G(this.f14140u);
        } else {
            if (z10) {
                return;
            }
            this.D = null;
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean L() {
        if (!this.f14138k0.a()) {
            return false;
        }
        boolean z10 = true;
        for (int i10 = 0; i10 < this.f14138k0.f41961h.size(); i10++) {
            l<Integer, n6.c> lVar = this.f14138k0.f41961h;
            if (!O0(lVar.get(lVar.k(i10)).c())) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // k6.k.a
    public void M(boolean z10) {
        K0(this.f14138k0.f41955b.c(), z10);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean N() {
        k kVar = this.D;
        return kVar != null && kVar.K();
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean O(boolean z10) {
        return false;
    }

    @Override // k6.k.a
    public void P(double d10) {
        if (this.D.J()) {
            this.C1.add(Double.valueOf(d10));
        } else {
            y1(7, 4, Double.valueOf(d10));
        }
    }

    @Override // p6.b.InterfaceC0527b
    public void Q(int i10) {
        if (i10 > 0) {
            double dDoubleValue = 0.0d;
            while (i10 > 0 && !this.C1.isEmpty()) {
                dDoubleValue = this.C1.poll().doubleValue();
                i10--;
            }
            y1(7, 4, Double.valueOf(dDoubleValue));
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean a(byte[] bArr) {
        return w1(bArr);
    }

    @Override // fg.a
    public synchronized void a1(int i10) {
        super.a1(i10);
        int i11 = 3;
        if (i10 == 2) {
            i11 = 2;
        } else if (i10 == 1) {
            i11 = 1;
        } else if (i10 != 3) {
            i11 = 0;
        }
        z1(0, Integer.valueOf(i11));
    }

    @Override // k6.k.a
    public void b(int i10) {
        y1(7, 2, Integer.valueOf(i10));
    }

    @Override // o6.c.a
    public void c(BluetoothDevice bluetoothDevice, int i10) {
        BluetoothDevice bluetoothDeviceU = u();
        if (bluetoothDevice == null || bluetoothDeviceU == null || !bluetoothDevice.getAddress().equals(bluetoothDeviceU.getAddress())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ACTION_BOND_STATE_CHANGED for ");
        sb2.append(bluetoothDevice.getAddress());
        sb2.append(" with bond state ");
        sb2.append(fg.b.a(i10));
        z1(1, Integer.valueOf(i10));
        if (i10 == 12) {
            y1(6, 11, 1);
            t1();
        } else if (i10 == 11) {
            this.f14143v2 = true;
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void d(int i10, boolean z10) throws Throwable {
        k kVar = this.D;
        if (kVar != null) {
            kVar.Q(i10, z10);
        }
    }

    @Override // k6.k.a
    public void e(int i10) throws Throwable {
        if (y1(7, 1, Integer.valueOf(i10))) {
            return;
        }
        d(i10, true);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public int f() {
        return 0;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean g() {
        return this.B;
    }

    @Override // k6.k.a
    public void h(jg.b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ERROR during upgrade: ");
        sb2.append(bVar.d());
        y1(7, 3, bVar);
        if (this.f14142v1.j()) {
            this.f14142v1.c();
            this.C1.clear();
        }
    }

    @Override // fg.a
    public int h0() {
        return super.h0();
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean i() {
        return this.f14138k0.f41958e.d() && O0(this.f14138k0.f41958e.b());
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean j(@f0(from = 0, to = 2) int i10) {
        if (this.f14138k0.f41957d.e()) {
            return W0(this.f14138k0.f41957d.b(), new byte[]{(byte) i10});
        }
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean k(boolean z10) {
        if (this.f14138k0.f41959f.i() && this.f14138k0.f41959f.g()) {
            return K0(this.f14138k0.f41959f.d(), z10);
        }
        return false;
    }

    @Override // fg.a
    public void k0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
        if (bluetoothGattCharacteristic != null) {
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            if (this.A || !uuid.equals(a.g.f41938d)) {
                if (i10 == 0 && uuid.equals(a.g.f41940f) && bluetoothGattCharacteristic.getService().getUuid().equals(a.g.f41939e)) {
                    y1(6, 1, Integer.valueOf(bluetoothGattCharacteristic.getIntValue(17, 0).intValue()));
                    return;
                }
                if (i10 == 0 && uuid.equals(a.g.f41943i)) {
                    y1(6, 0, Integer.valueOf(bluetoothGattCharacteristic.getIntValue(33, 0).intValue()));
                    return;
                }
                if (i10 == 0 && uuid.equals(a.g.f41945k)) {
                    y1(6, 3, Integer.valueOf(bluetoothGattCharacteristic.getService().getInstanceId()));
                    return;
                } else {
                    if (i10 == 0 && uuid.equals(a.g.f41951q)) {
                        y1(6, 5, Integer.valueOf(bluetoothGattCharacteristic.getValue()[0]));
                        return;
                    }
                    return;
                }
            }
            if (i10 == 0) {
                t1();
                return;
            }
            if (i10 == 15 || i10 == 5 || i10 == 8 || i10 == 137 || i10 == 133 || i10 == 47) {
                if (this.C2 < 3) {
                    this.f14139k1.postDelayed(new c(), 1000L);
                    return;
                }
                this.C2 = 0;
                if (N()) {
                    I();
                    y1(7, 3, 4);
                }
                D();
            }
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean l() {
        return this.A;
    }

    @Override // fg.a
    public void l0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void m(boolean z10) {
        b1(z10);
        this.f14140u = z10;
        this.f14142v1.D(z10);
        k kVar = this.D;
        if (kVar != null) {
            kVar.G(z10);
        }
    }

    @Override // fg.a
    public void m0(BluetoothGatt bluetoothGatt, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onConnectionStateChange: ");
        sb2.append(fg.b.c(i10, true));
        if (i10 == 0 && i11 == 2) {
            y1(6, 11, 0);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Attempting to start service discovery: ");
            sb3.append(bluetoothGatt.discoverServices());
            return;
        }
        if (i11 == 0) {
            v1();
            if (N()) {
                this.f14139k1.postDelayed(new b(), 1000L);
            }
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean n(byte b10) {
        if (this.f14138k0.f41959f.h()) {
            return U0(this.f14138k0.f41959f.c(), new byte[]{b10});
        }
        return false;
    }

    @Override // fg.a
    public void n0(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
        if (i10 == 0 && bluetoothGattDescriptor.getCharacteristic().getUuid().equals(a.g.f41945k)) {
            n6.c cVar = this.f14138k0.f41961h.get(Integer.valueOf(bluetoothGattDescriptor.getCharacteristic().getService().getInstanceId()));
            if (cVar != null) {
                cVar.j();
            }
        }
    }

    public boolean n1(boolean z10) {
        if (!this.C && z10) {
            return false;
        }
        this.D.X(z10);
        return true;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean o() {
        return this.f14138k0.f41956c.e() && O0(this.f14138k0.f41956c.b());
    }

    @Override // fg.a
    public void o0(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
        UUID uuid = bluetoothGattDescriptor.getUuid();
        UUID uuid2 = bluetoothGattDescriptor.getCharacteristic().getUuid();
        if (i10 == 0) {
            this.f14146y.add(uuid2);
            if (this.f14140u) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Successful write descriptor ");
                sb2.append(uuid.toString());
                sb2.append(" for characteristic ");
                sb2.append(uuid2.toString());
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsuccessful write descriptor ");
            sb3.append(uuid.toString());
            sb3.append(" for characteristic ");
            sb3.append(uuid2.toString());
            sb3.append(" with status ");
            sb3.append(fg.b.c(i10, false));
        }
        if (i10 == 0 && this.f14138k0.f41955b.j() && uuid.equals(a.g.f41950p) && uuid2.equals(a.g.f41936b)) {
            this.B = true;
            x1(4);
            if (N()) {
                this.D.L();
                return;
            }
            return;
        }
        if (!(i10 == 0 && this.f14138k0.f41959f.k() && uuid2.equals(a.g.f41949o)) && this.f14138k0.f41955b.h() && uuid.equals(a.g.f41950p) && uuid2.equals(a.g.f41938d)) {
            if (i10 == 0) {
                y1(6, 7, Boolean.valueOf(Arrays.equals(bluetoothGattDescriptor.getValue(), BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)));
                return;
            }
            this.C = false;
            this.D.M();
            y1(6, 6, Boolean.FALSE);
        }
    }

    public int o1() {
        return this.f14142v1.f();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f14145x;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b1(false);
        this.f14142v1.D(false);
        j0();
        Z0(60000);
        u1();
    }

    @Override // android.app.Service
    public void onDestroy() {
        D();
        D1();
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (this.f14144w.isEmpty()) {
            D();
        }
        return super.onUnbind(intent);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean p(@f0(from = 0, to = 2) int i10) {
        if (this.f14138k0.f41956c.e()) {
            return U0(this.f14138k0.f41956c.b(), new byte[]{(byte) i10});
        }
        return false;
    }

    @Override // fg.a
    public void p0(BluetoothGatt bluetoothGatt, int i10, int i11) {
        if (i11 == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MTU size had been updated to ");
            sb2.append(i10);
            y1(6, 10, Integer.valueOf(i10));
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("MTU request failed, mtu size is: ");
            sb3.append(i10);
            y1(6, 9, Boolean.FALSE);
        }
        this.D.W(i10 - 3);
    }

    public int p1() {
        return this.f14142v1.g();
    }

    @Override // p6.b.InterfaceC0527b
    public void q() {
        this.D.N();
        this.C1.clear();
    }

    public void q1() {
        if (this.C) {
            this.D.H();
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public synchronized void r(Handler handler) {
        if (!this.f14144w.contains(handler)) {
            this.f14144w.add(handler);
        }
    }

    public final boolean r1() {
        return super.C() == 2;
    }

    @Override // p6.b.InterfaceC0527b
    public boolean s(byte[] bArr) {
        boolean zW0 = W0(this.f14138k0.f41955b.c(), bArr);
        if (zW0 && this.f14140u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Attempt to send RWCP segment on DATA ENDPOINT characteristic: ");
            sb2.append(i6.b.f(bArr));
        } else if (!zW0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Attempt to send RWCP segment on DATA ENDPOINT characteristic FAILED: ");
            sb3.append(i6.b.f(bArr));
        }
        return zW0;
    }

    public final boolean s1() {
        return super.C() == 0;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public synchronized void t(Handler handler) {
        if (this.f14144w.contains(handler)) {
            this.f14144w.remove(handler);
        }
    }

    @Override // fg.a
    public void t0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            if (uuid.equals(a.g.f41936b)) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                if (value != null) {
                    k kVar = this.D;
                    if (kVar != null) {
                        kVar.q(value);
                        return;
                    } else {
                        z1(3, value);
                        return;
                    }
                }
                return;
            }
            if (uuid.equals(a.g.f41949o)) {
                y1(6, 4, this.f14138k0.f41959f.e());
                return;
            }
            if (uuid.equals(a.g.f41938d)) {
                byte[] value2 = bluetoothGattCharacteristic.getValue();
                if (value2 != null) {
                    this.f14142v1.l(value2);
                    return;
                }
                return;
            }
            if (this.f14140u) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received notification over characteristic: ");
                sb2.append(bluetoothGattCharacteristic.getUuid());
            }
        }
    }

    public final void t1() {
        this.A = true;
        x1(5);
        if (this.f14138k0.f41955b.j()) {
            K0(this.f14138k0.f41955b.d(), true);
        }
        if (this.f14138k0.a()) {
            for (int i10 = 0; i10 < this.f14138k0.f41961h.size(); i10++) {
                if (this.f14140u) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Battery service is supported, request presentation format descriptors for service ");
                    sb2.append(i10 + 1);
                    sb2.append(j3.b.f36044h);
                }
                l<Integer, n6.c> lVar = this.f14138k0.f41961h;
                n6.c cVar = lVar.get(lVar.k(i10));
                if (cVar.g()) {
                    S0(cVar.e());
                }
            }
        }
    }

    @Override // fg.a, com.flydigi.cyberfox.h1.services.b
    public BluetoothDevice u() {
        return super.u();
    }

    @Override // fg.a
    public void u0(BluetoothGatt bluetoothGatt, int i10, int i11) {
        if (i11 == 0 && this.K0) {
            y1(6, 2, Integer.valueOf(i10));
            this.f14139k1.postDelayed(this.K2, 1000L);
        }
    }

    public final void u1() {
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        registerReceiver(this.f14147z, intentFilter);
    }

    @Override // k6.k.a
    public void v() {
        this.C = false;
        y1(6, 6, Boolean.FALSE);
    }

    public final void v1() {
        this.A = false;
        this.B = false;
        this.K0 = false;
        this.f14143v2 = false;
        this.C2 = 0;
        k kVar = this.D;
        if (kVar != null) {
            kVar.v();
        }
        this.f14142v1.c();
        this.C1.clear();
        this.f14146y.clear();
    }

    @Override // fg.a, com.flydigi.cyberfox.h1.services.b
    public boolean w(String str) {
        return super.w(str);
    }

    @Override // fg.a
    public void w0(BluetoothGatt bluetoothGatt, int i10) {
        if (i10 == 0) {
            this.f14138k0.g(bluetoothGatt.getServices());
            z1(2, this.f14138k0);
            if (this.f14138k0.f41955b.j()) {
                Q0(this.f14138k0.f41955b.c());
            } else {
                t1();
            }
            if (this.f14140u) {
                this.f14138k0.toString();
            }
        }
    }

    public final boolean w1(byte[] bArr) {
        if (this.f14138k0.f41955b.e()) {
            return U0(this.f14138k0.f41955b.b(), bArr);
        }
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public int x() {
        BluetoothDevice bluetoothDeviceU = u();
        if (bluetoothDeviceU != null) {
            return bluetoothDeviceU.getBondState();
        }
        return 10;
    }

    public final boolean x1(int i10) {
        if (!this.f14144w.isEmpty()) {
            for (int i11 = 0; i11 < this.f14144w.size(); i11++) {
                this.f14144w.get(i11).obtainMessage(i10).sendToTarget();
            }
        }
        return !this.f14144w.isEmpty();
    }

    @Override // k6.k.a
    public void y() {
        y1(7, 0, null);
    }

    public final boolean y1(int i10, int i11, Object obj) {
        if (!this.f14144w.isEmpty()) {
            for (int i12 = 0; i12 < this.f14144w.size(); i12++) {
                this.f14144w.get(i12).obtainMessage(i10, i11, 0, obj).sendToTarget();
            }
        }
        return !this.f14144w.isEmpty();
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void z(File file) {
        if (this.D != null) {
            super.g0().requestConnectionPriority(1);
            this.D.Y(file);
            this.C1.clear();
            this.K1 = 0L;
        }
    }

    public final boolean z1(int i10, Object obj) {
        if (!this.f14144w.isEmpty()) {
            for (int i11 = 0; i11 < this.f14144w.size(); i11++) {
                this.f14144w.get(i11).obtainMessage(i10, obj).sendToTarget();
            }
        }
        return !this.f14144w.isEmpty();
    }
}
