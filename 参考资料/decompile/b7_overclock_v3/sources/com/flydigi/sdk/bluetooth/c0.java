package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import com.flydigi.sdk.bluetooth.ota.OtaStatus;
import com.flydigi.sdk.bluetooth.q;
import h0.i0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import k9.c;
import kotlin.Pair;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nLeDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LeDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/LeDataInteractionController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,496:1\n1#2:497\n1855#3,2:498\n1855#3,2:500\n*S KotlinDebug\n*F\n+ 1 LeDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/LeDataInteractionController\n*L\n332#1:498,2\n468#1:500,2\n*E\n"})
public abstract class c0 extends AbstractDataInteractionController {

    @yt.l
    public BluetoothGatt I;

    @yt.l
    public BluetoothGattService J;

    @yt.l
    public BluetoothGattCharacteristic K;

    @yt.l
    public BluetoothGattCharacteristic L;

    @yt.l
    public BluetoothGattCallback M;

    @yt.l
    public k9.c N;

    @yt.k
    public ArrayList<k9.b> O;
    public boolean P;

    @yt.k
    public final Runnable Q;

    @yt.k
    public final q R;

    @t0({"SMAP\nLeDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LeDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,496:1\n1855#2,2:497\n*S KotlinDebug\n*F\n+ 1 LeDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/LeDataInteractionController$characteristicObservable$1\n*L\n188#1:497,2\n*E\n"})
    public static final class a implements q.a {
        public a() {
        }

        @Override // com.flydigi.sdk.bluetooth.q.a
        public void a(@yt.k q observer, @yt.l byte[] bArr) {
            kotlin.jvm.internal.f0.p(observer, "observer");
            c0.this.P().removeCallbacks(c0.this.Q);
            observer.a();
            if (bArr != null) {
                c0 c0Var = c0.this;
                if (c0Var.E() == 1) {
                    k9.c cVar = c0Var.N;
                    if (cVar != null && cVar.k(bArr)) {
                        c0Var.u0(false);
                        Iterator it2 = c0Var.O.iterator();
                        while (it2.hasNext()) {
                            ((k9.b) it2.next()).C();
                        }
                    }
                }
                c0Var.K1(bArr);
            }
            c0.this.e1();
        }
    }

    @t0({"SMAP\nLeDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LeDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,496:1\n1#2:497\n1855#3,2:498\n*S KotlinDebug\n*F\n+ 1 LeDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/LeDataInteractionController$mGattCallback$1\n*L\n125#1:498,2\n*E\n"})
    public static final class b extends BluetoothGattCallback {
        public b() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(@yt.l BluetoothGatt bluetoothGatt, @yt.l BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Pair<UUID, List<byte[]>> pairO;
            BluetoothGattCharacteristic bluetoothGattCharacteristicA;
            if (bluetoothGattCharacteristic != null) {
                c0 c0Var = c0.this;
                if (l9.a.f39473a.b()) {
                    byte[] value = bluetoothGattCharacteristic.getValue();
                    kotlin.jvm.internal.f0.o(value, "it.value");
                    l9.a.c("onCharacteristicChanged " + AbstractDataInteractionControllerKt.b(value, null, 1, null) + " from " + bluetoothGattCharacteristic.getUuid());
                }
                k9.c cVar = c0Var.N;
                if (!kotlin.jvm.internal.f0.g((cVar == null || (bluetoothGattCharacteristicA = c.b.a(cVar, null, 1, null)) == null) ? null : bluetoothGattCharacteristicA.getUuid(), bluetoothGattCharacteristic.getUuid())) {
                    if (kotlin.jvm.internal.f0.g(c0Var.F1(), bluetoothGattCharacteristic.getUuid())) {
                        UUID uuid = bluetoothGattCharacteristic.getUuid();
                        kotlin.jvm.internal.f0.o(uuid, "it.uuid");
                        byte[] value2 = bluetoothGattCharacteristic.getValue();
                        kotlin.jvm.internal.f0.o(value2, "it.value");
                        c0Var.Z0(uuid, value2);
                        return;
                    }
                    return;
                }
                byte[] value3 = bluetoothGattCharacteristic.getValue();
                if (value3 != null) {
                    kotlin.jvm.internal.f0.o(value3, "value");
                    k9.c cVar2 = c0Var.N;
                    if (cVar2 != null && cVar2.e(value3)) {
                        k9.c cVar3 = c0Var.N;
                        if (cVar3 == null || (pairO = cVar3.o()) == null) {
                            return;
                        }
                        AbstractDataInteractionController.P0(c0Var, pairO.f(), pairO.h(), null, null, 12, null);
                        return;
                    }
                    k9.c cVar4 = c0Var.N;
                    if (!(cVar4 != null && cVar4.m(value3))) {
                        k9.c cVar5 = c0Var.N;
                        c0Var.P = cVar5 != null && cVar5.p(value3);
                        if (!c0Var.P) {
                            c0Var.U1(OtaStatus.ERR_DEVICE_NOT_PREPARED, null);
                            return;
                        }
                        j9.b bVarD = c0Var.z1().d();
                        if (bVarD != null ? kotlin.jvm.internal.f0.g(bVarD.n(), Boolean.TRUE) : false) {
                            c0Var.z1().b();
                            return;
                        }
                        return;
                    }
                    c0Var.u0(false);
                    k9.c cVar6 = c0Var.N;
                    if (cVar6 != null && cVar6.i(value3)) {
                        Iterator it2 = c0Var.O.iterator();
                        while (it2.hasNext()) {
                            ((k9.b) it2.next()).C();
                        }
                    } else {
                        OtaStatus otaStatus = OtaStatus.ERR_OTA_FAILED;
                        k9.c cVar7 = c0Var.N;
                        c0Var.U1(otaStatus, cVar7 != null ? cVar7.c(value3) : null);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(@yt.l BluetoothGatt bluetoothGatt, @yt.l BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            if (bluetoothGattCharacteristic != null) {
                c0 c0Var = c0.this;
                byte[] value = bluetoothGattCharacteristic.getValue();
                kotlin.jvm.internal.f0.o(value, "it.value");
                l9.a.c("onCharacteristicRead:" + AbstractDataInteractionControllerKt.b(value, null, 1, null));
                UUID uuid = bluetoothGattCharacteristic.getUuid();
                kotlin.jvm.internal.f0.o(uuid, "it.uuid");
                byte[] value2 = bluetoothGattCharacteristic.getValue();
                kotlin.jvm.internal.f0.o(value2, "it.value");
                c0Var.M1(uuid, value2);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(@yt.l BluetoothGatt bluetoothGatt, @yt.l BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            if (bluetoothGattCharacteristic != null) {
                c0 c0Var = c0.this;
                byte[] value = bluetoothGattCharacteristic.getValue();
                kotlin.jvm.internal.f0.o(value, "it.value");
                l9.a.c("onCharacteristicWritten:" + AbstractDataInteractionControllerKt.b(value, null, 1, null) + " status:" + i10);
                UUID uuid = bluetoothGattCharacteristic.getUuid();
                kotlin.jvm.internal.f0.o(uuid, "it.uuid");
                byte[] value2 = bluetoothGattCharacteristic.getValue();
                kotlin.jvm.internal.f0.o(value2, "it.value");
                c0Var.N1(uuid, value2);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(@yt.k BluetoothGatt gatt, int i10, int i11) {
            kotlin.jvm.internal.f0.p(gatt, "gatt");
            l9.a.c("onConnectionStateChange status：" + i10 + " newState:" + i11);
            if (i11 == 0) {
                c0.this.T1(gatt);
            } else {
                if (i11 != 2) {
                    return;
                }
                c0.this.S1(gatt);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(@yt.k BluetoothGatt gatt, @yt.k BluetoothGattDescriptor descriptor, int i10, @yt.k byte[] value) {
            kotlin.jvm.internal.f0.p(gatt, "gatt");
            kotlin.jvm.internal.f0.p(descriptor, "descriptor");
            kotlin.jvm.internal.f0.p(value, "value");
            super.onDescriptorRead(gatt, descriptor, i10, value);
            l9.a.c("onDescriptorRead:read " + AbstractDataInteractionControllerKt.b(value, null, 1, null) + " from " + descriptor.getUuid() + " status:" + i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(@yt.l BluetoothGatt bluetoothGatt, @yt.l BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            byte[] value;
            l9.a.c("onDescriptorWritten:" + ((bluetoothGattDescriptor == null || (value = bluetoothGattDescriptor.getValue()) == null) ? null : AbstractDataInteractionControllerKt.b(value, null, 1, null)) + " to " + (bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid() : null) + " status:" + i10);
            if (bluetoothGattDescriptor != null) {
                c0.this.O1(bluetoothGattDescriptor);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(@yt.l BluetoothGatt bluetoothGatt, int i10, int i11) {
            super.onReadRemoteRssi(bluetoothGatt, i10, i11);
            if (i11 == 0) {
                c0.this.V1(i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(@yt.l BluetoothGatt bluetoothGatt, int i10) {
            l9.a.c("onReliableWriteCompleted");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(@yt.l BluetoothGatt bluetoothGatt, int i10) {
            if (c0.this.s1()) {
                l9.a.c("onServicesDiscovered status:" + i10);
                if (i10 != 0 || bluetoothGatt == null) {
                    return;
                }
                c0.this.W1(bluetoothGatt);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(@yt.k Context mContext, @yt.k u filter, int i10) {
        super(mContext, filter, i10);
        kotlin.jvm.internal.f0.p(mContext, "mContext");
        kotlin.jvm.internal.f0.p(filter, "filter");
        this.M = new b();
        this.O = new ArrayList<>();
        this.Q = new Runnable() { // from class: com.flydigi.sdk.bluetooth.y
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                c0.r1(this.f16335a);
            }
        };
        this.R = new q(new a());
    }

    public static final void Q1(c0 this$0, BluetoothDevice device) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(device, "$device");
        if (this$0.V0() == 1) {
            this$0.d1(0);
            this$0.R1(device);
        }
    }

    public static final void r1(c0 this$0) throws InterruptedException {
        j9.b bVarD;
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.R.e() || (bVarD = this$0.R.d()) == null || !this$0.s1()) {
            return;
        }
        if (kotlin.jvm.internal.f0.g(bVarD.n(), Boolean.TRUE) && bVarD.o() > 0) {
            bVarD.s(bVarD.o() - 1);
            l9.a.f("characteristic write timeout for " + AbstractDataInteractionControllerKt.b(bVarD.k(), null, 1, null) + " , try to write again");
            this$0.f1(bVarD);
            return;
        }
        l9.a.f("characteristic write timeout for " + AbstractDataInteractionControllerKt.b(bVarD.k(), null, 1, null) + " , try to write next");
        this$0.R.a();
        this$0.L1(bVarD.k());
        this$0.e1();
    }

    public static final void u1(k9.c factory, byte[] bArr, c0 this$0) {
        kotlin.jvm.internal.f0.p(factory, "$factory");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Pair<UUID, List<byte[]>> pairD = factory.d(bArr);
        AbstractDataInteractionController.P0(this$0, pairD.f(), pairD.h(), null, null, 12, null);
    }

    public static final void v1(c0 this$0, k9.c factory, byte[] bArr) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(factory, "$factory");
        this$0.c2(factory, bArr);
    }

    @yt.l
    public final BluetoothGatt A1() {
        return this.I;
    }

    @yt.k
    public abstract UUID B1();

    @yt.l
    public final BluetoothGattService C1() {
        return this.J;
    }

    @yt.l
    public final BluetoothGatt D1() {
        return this.I;
    }

    @yt.l
    public final BluetoothGattCharacteristic E1() {
        return this.L;
    }

    @yt.l
    public abstract UUID F1();

    @Override // com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void G0(@yt.k Object obj) {
        kotlin.jvm.internal.f0.p(obj, "obj");
        super.G0(obj);
        if ((obj instanceof k9.b) && this.O.contains(obj)) {
            this.O.remove(obj);
        }
    }

    @yt.l
    public final Boolean G1() {
        BluetoothGatt bluetoothGatt;
        if (s1() && (bluetoothGatt = this.I) != null) {
            return Boolean.valueOf(bluetoothGatt.readRemoteRssi());
        }
        return null;
    }

    @yt.l
    public final BluetoothGattCharacteristic H1() {
        return this.K;
    }

    @yt.l
    public abstract UUID I1();

    public void J1(@yt.k BluetoothGattService service) {
        kotlin.jvm.internal.f0.p(service, "service");
        this.K = service.getCharacteristic(I1());
        this.L = service.getCharacteristic(F1());
    }

    public abstract void K1(@yt.k byte[] bArr);

    public abstract void L1(@yt.k byte[] bArr);

    public abstract void M1(@yt.k UUID uuid, @yt.k byte[] bArr);

    @g.i
    public void N1(@yt.k UUID uuid, @yt.k byte[] value) {
        kotlin.jvm.internal.f0.p(uuid, "uuid");
        kotlin.jvm.internal.f0.p(value, "value");
        j9.b bVarD = this.R.d();
        if (bVarD == null || !androidx.core.util.j.a(bVarD.k(), value) || kotlin.jvm.internal.f0.g(bVarD.n(), Boolean.TRUE)) {
            return;
        }
        this.R.b();
    }

    @g.i
    public void O1(@yt.k BluetoothGattDescriptor descriptor) {
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
    }

    @g.i
    public void P1(@yt.k final BluetoothDevice device) {
        kotlin.jvm.internal.f0.p(device, "device");
        l9.a.e("gatt connect starting");
        P().postDelayed(new Runnable() { // from class: com.flydigi.sdk.bluetooth.z
            @Override // java.lang.Runnable
            public final void run() {
                c0.Q1(this.f16336a, device);
            }
        }, 5000L);
    }

    @g.i
    public void R1(@yt.k BluetoothDevice device) {
        kotlin.jvm.internal.f0.p(device, "device");
        l9.a.e("gatt connect timeout");
    }

    @g.i
    public void S1(@yt.k BluetoothGatt gatt) {
        kotlin.jvm.internal.f0.p(gatt, "gatt");
        if (s1()) {
            l9.a.e(gatt.getDevice().getName() + "'s gatt connected");
            d1(2);
            this.I = gatt;
            gatt.discoverServices();
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void T0() {
        BluetoothDevice bluetoothDeviceM;
        if (s1() && (bluetoothDeviceM = M()) != null) {
            if (bluetoothDeviceM.getType() != 2 && bluetoothDeviceM.getType() != 3) {
                l9.a.f("current device is not a valid BLE device");
            } else if (V0() == 0) {
                P1(bluetoothDeviceM);
                d1(1);
                int i10 = Build.VERSION.SDK_INT;
                this.I = i10 >= 26 ? bluetoothDeviceM.connectGatt(N(), false, this.M, 2, 3) : i10 >= 23 ? bluetoothDeviceM.connectGatt(N(), false, this.M, 2) : bluetoothDeviceM.connectGatt(N(), false, this.M);
            }
        }
    }

    @g.i
    public void T1(@yt.k BluetoothGatt gatt) {
        kotlin.jvm.internal.f0.p(gatt, "gatt");
        if (s1()) {
            if (K()) {
                U1(OtaStatus.ERR_DEVICE_NOT_CONNECTED, (byte) -1);
            }
            d1(0);
            l9.a.e(gatt.getDevice().getName() + "'s gatt disconnected");
            w1();
            S0();
        }
    }

    public final void U1(OtaStatus otaStatus, Byte b10) {
        u0(false);
        Iterator<T> it2 = this.O.iterator();
        while (it2.hasNext()) {
            ((k9.b) it2.next()).S0(otaStatus, b10 != null ? Integer.valueOf(b10.byteValue()) : null);
        }
    }

    public abstract void V1(int i10);

    @g.i
    public void W1(@yt.k BluetoothGatt gatt) {
        kotlin.jvm.internal.f0.p(gatt, "gatt");
        if (s1()) {
            BluetoothGattService service = gatt.getService(X0());
            this.J = service;
            if (service != null) {
                J1(service);
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.L;
            if (bluetoothGattCharacteristic != null) {
                gatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(B1());
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                gatt.writeDescriptor(descriptor);
            }
        }
    }

    public final void X1(@yt.k BluetoothGatt gatt) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        kotlin.jvm.internal.f0.p(gatt, "gatt");
        Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
        method.setAccessible(true);
        method.invoke(gatt, new Object[0]);
    }

    public final void Y1(@yt.l BluetoothGattService bluetoothGattService) {
        this.J = bluetoothGattService;
    }

    public final void Z1(@yt.l BluetoothGatt bluetoothGatt) {
        this.I = bluetoothGatt;
    }

    public final void a2(@yt.l BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.L = bluetoothGattCharacteristic;
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void b0() {
        super.b0();
        y1();
    }

    public final void b2(@yt.l BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.K = bluetoothGattCharacteristic;
    }

    public final void c2(k9.c cVar, byte[] bArr) {
        z1 z1Var;
        if (bArr != null) {
            int i10 = 0;
            int iQ = cVar.q();
            int length = bArr.length % iQ == 0 ? bArr.length / iQ : (int) Math.floor((bArr.length / iQ) + 1);
            ArrayList arrayList = new ArrayList();
            while (i10 < length) {
                arrayList.add(cVar.a(bArr, i10).h());
                i10++;
            }
            arrayList.addAll(cVar.n(i10 - 1).h());
            if (!arrayList.isEmpty()) {
                J0(arrayList);
            }
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            U1(OtaStatus.ERR_FIRMWARE_NOT_FOUND, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f1(@yt.k j9.b r17) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.sdk.bluetooth.c0.f1(j9.b):void");
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void n0(@yt.k Object obj) {
        kotlin.jvm.internal.f0.p(obj, "obj");
        super.n0(obj);
        if (!(obj instanceof k9.b) || this.O.contains(obj)) {
            return;
        }
        this.O.add(obj);
    }

    public final boolean s1() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 30 || i0.d(N(), "android.permission.BLUETOOTH_CONNECT") != 0) {
            return i10 <= 30 && i0.d(N(), "android.permission.BLUETOOTH") == 0;
        }
        return true;
    }

    public final void t1(int i10, @yt.l final byte[] bArr) {
        Object objValueOf;
        BluetoothGatt bluetoothGatt = this.I;
        if (bluetoothGatt != null) {
            u0(true);
            final k9.c cVarA = k9.c.f37079a.a(i10);
            if (cVarA != null) {
                this.N = cVarA;
                if (cVarA.g(i10, bluetoothGatt) != null) {
                    P().postDelayed(new Runnable() { // from class: com.flydigi.sdk.bluetooth.b0
                        @Override // java.lang.Runnable
                        public final void run() {
                            c0.u1(cVarA, bArr, this);
                        }
                    }, 100L);
                    objValueOf = Boolean.valueOf(P().postDelayed(new Runnable() { // from class: com.flydigi.sdk.bluetooth.a0
                        @Override // java.lang.Runnable
                        public final void run() {
                            c0.v1(this.f16251a, cVarA, bArr);
                        }
                    }, 500L));
                } else {
                    U1(OtaStatus.ERR_DEVICE_NOT_PREPARED, null);
                    objValueOf = z1.f38230a;
                }
            } else {
                objValueOf = null;
            }
            if (objValueOf != null) {
                return;
            }
        }
        U1(OtaStatus.ERR_DEVICE_NOT_CONNECTED, null);
        z1 z1Var = z1.f38230a;
    }

    public final void w1() {
        if (s1()) {
            l9.a.e("gatt disconnect");
            x1();
            BluetoothGatt bluetoothGatt = this.I;
            if (bluetoothGatt != null) {
                bluetoothGatt.close();
            }
            this.I = null;
            this.J = null;
            this.K = null;
            this.L = null;
            d1(0);
        }
    }

    public final void x1() {
        BluetoothGatt bluetoothGatt;
        if (s1() && (bluetoothGatt = this.I) != null) {
            bluetoothGatt.disconnect();
        }
    }

    public final void y1() {
        BluetoothGatt bluetoothGatt = this.I;
        if (bluetoothGatt != null) {
            T1(bluetoothGatt);
        }
    }

    @yt.k
    public final q z1() {
        return this.R;
    }
}
