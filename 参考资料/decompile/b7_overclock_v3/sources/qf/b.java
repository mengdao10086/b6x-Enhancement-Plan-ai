package qf;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f47317j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f47318k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f47319l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f47320m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f47321n = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGatt f47323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothGattCharacteristic f47324c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UUID f47329h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47322a = getClass().getSimpleName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f47326e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f47327f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f47328g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BluetoothGattCallback f47330i = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<rf.a> f47325d = new ArrayList();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic != null) {
                String unused = b.this.f47322a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onCharacteristicChanged++++++ ");
                sb2.append(wf.a.o(bluetoothGattCharacteristic.getValue()));
            } else {
                String unused2 = b.this.f47322a;
            }
            b.this.t(bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            if (i10 == 0) {
                b.this.v(0);
            } else {
                b.this.v(1);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            String unused = b.this.f47322a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onConnectionStateChange++++++ ");
            sb2.append(i10);
            sb2.append("; ");
            sb2.append(i11);
            b.this.f47323b = bluetoothGatt;
            if (i10 == 0 && i11 == 2) {
                b.this.r(true);
            } else {
                b.this.k();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            if (bluetoothGattDescriptor.getUuid().equals(b.this.f47329h)) {
                if (i10 == 0) {
                    b.this.q(0);
                } else {
                    b.this.q(1);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            String unused = b.this.f47322a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onMtuChanged+++++ ");
            sb2.append(i10);
            sb2.append("; ");
            sb2.append(i11);
            if (i11 == 0) {
                b.this.s(0, i10);
            } else {
                b.this.s(1, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            String unused = b.this.f47322a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServicesDiscovered++++++ ");
            sb2.append(i10);
            sb2.append("; ");
            sb2.append(i10);
            b.this.f47323b = bluetoothGatt;
            if (i10 == 0) {
                b.this.u(0);
                return;
            }
            b.this.u(1);
            b.this.w();
            b.this.k();
        }
    }

    public boolean A(byte[] bArr) {
        if (this.f47323b == null) {
            return false;
        }
        this.f47324c.setValue(bArr);
        this.f47324c.setWriteType(2);
        return this.f47323b.writeCharacteristic(this.f47324c);
    }

    public boolean B(byte[] bArr) {
        if (this.f47323b == null) {
            return false;
        }
        this.f47324c.setValue(bArr);
        this.f47324c.setWriteType(1);
        return this.f47323b.writeCharacteristic(this.f47324c);
    }

    public void j(rf.a aVar) {
        synchronized (this.f47327f) {
            if (!this.f47325d.contains(aVar)) {
                this.f47325d.add(aVar);
            }
        }
    }

    public void k() {
        BluetoothGatt bluetoothGatt = this.f47323b;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
        BluetoothGatt bluetoothGatt2 = this.f47323b;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.close();
        }
        r(false);
        this.f47323b = null;
    }

    public boolean l(Context context, BluetoothDevice bluetoothDevice) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connect+++++++ ");
        sb2.append(bluetoothDevice);
        sb2.append("; ");
        sb2.append(this.f47328g);
        synchronized (this.f47326e) {
            if (this.f47328g != 0) {
                return true;
            }
            this.f47328g = 1;
            if (this.f47323b != null) {
                this.f47323b = null;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                this.f47323b = bluetoothDevice.connectGatt(context, false, this.f47330i, 2);
            } else {
                this.f47323b = bluetoothDevice.connectGatt(context, false, this.f47330i);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("connect: +++++");
            sb3.append(this.f47323b);
            return this.f47323b != null;
        }
    }

    public boolean m(Context context, String str) {
        return l(context, BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str));
    }

    public boolean n() {
        BluetoothGatt bluetoothGatt = this.f47323b;
        if (bluetoothGatt != null) {
            return bluetoothGatt.discoverServices();
        }
        return false;
    }

    public boolean o(UUID uuid, UUID uuid2, UUID uuid3) {
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        BluetoothGatt bluetoothGatt = this.f47323b;
        if (bluetoothGatt == null || (service = bluetoothGatt.getService(uuid)) == null || (characteristic = service.getCharacteristic(uuid2)) == null || (descriptor = characteristic.getDescriptor(uuid3)) == null || !this.f47323b.setCharacteristicNotification(characteristic, true) || !descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)) {
            return false;
        }
        this.f47329h = uuid3;
        return this.f47323b.writeDescriptor(descriptor);
    }

    public boolean p() {
        return this.f47328g == 2;
    }

    public final void q(int i10) {
        synchronized (this.f47327f) {
            for (rf.a aVar : this.f47325d) {
                if (aVar instanceof rf.b) {
                    ((rf.b) aVar).g0(i10);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(boolean r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f47326e
            monitor-enter(r0)
            if (r5 == 0) goto L26
            int r1 = r4.f47328g     // Catch: java.lang.Throwable -> L24
            r2 = 2
            if (r1 == r2) goto L26
            java.util.List<rf.a> r5 = r4.f47325d     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L24
        L10:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L21
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L24
            rf.a r1 = (rf.a) r1     // Catch: java.lang.Throwable -> L24
            r3 = 1
            r1.A2(r3)     // Catch: java.lang.Throwable -> L24
            goto L10
        L21:
            r4.f47328g = r2     // Catch: java.lang.Throwable -> L24
            goto L45
        L24:
            r5 = move-exception
            goto L47
        L26:
            if (r5 != 0) goto L45
            int r5 = r4.f47328g     // Catch: java.lang.Throwable -> L24
            if (r5 == 0) goto L45
            java.util.List<rf.a> r5 = r4.f47325d     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L24
        L32:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L24
            r2 = 0
            if (r1 == 0) goto L43
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L24
            rf.a r1 = (rf.a) r1     // Catch: java.lang.Throwable -> L24
            r1.A2(r2)     // Catch: java.lang.Throwable -> L24
            goto L32
        L43:
            r4.f47328g = r2     // Catch: java.lang.Throwable -> L24
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
            return
        L47:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: qf.b.r(boolean):void");
    }

    public final void s(int i10, int i11) {
        synchronized (this.f47327f) {
            for (rf.a aVar : this.f47325d) {
                if (aVar instanceof rf.b) {
                    ((rf.b) aVar).b2(i10, i11);
                }
            }
        }
    }

    public final void t(byte[] bArr) {
        synchronized (this.f47327f) {
            Iterator<rf.a> it2 = this.f47325d.iterator();
            while (it2.hasNext()) {
                it2.next().T0(bArr);
            }
        }
    }

    public final void u(int i10) {
        synchronized (this.f47327f) {
            for (rf.a aVar : this.f47325d) {
                if (aVar instanceof rf.b) {
                    ((rf.b) aVar).V(i10);
                }
            }
        }
    }

    public final void v(int i10) {
        synchronized (this.f47327f) {
            for (rf.a aVar : this.f47325d) {
                if (aVar instanceof rf.b) {
                    ((rf.b) aVar).Q2(i10);
                }
            }
        }
    }

    public boolean w() {
        try {
            BluetoothGatt bluetoothGatt = this.f47323b;
            if (bluetoothGatt != null) {
                return ((Boolean) bluetoothGatt.getClass().getMethod("refresh", new Class[0]).invoke(this.f47323b, new Object[0])).booleanValue();
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
        return false;
    }

    public void x(rf.a aVar) {
        synchronized (this.f47327f) {
            this.f47325d.remove(aVar);
        }
    }

    public boolean y(int i10) {
        BluetoothGatt bluetoothGatt = this.f47323b;
        if (bluetoothGatt != null) {
            return bluetoothGatt.requestMtu(i10);
        }
        return false;
    }

    public boolean z(UUID uuid, UUID uuid2) {
        BluetoothGattService service;
        BluetoothGatt bluetoothGatt = this.f47323b;
        if (bluetoothGatt == null || (service = bluetoothGatt.getService(uuid)) == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        this.f47324c = characteristic;
        if (characteristic == null) {
            return false;
        }
        characteristic.setWriteType(2);
        return true;
    }
}
