package q9;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import androidx.core.util.j;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x0;
import com.flydigi.sdk.bluetooth.t;
import com.flydigi.sdk.headset.HeadsetInfo;
import kotlin.jvm.internal.f0;
import q9.e;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends x0 implements e, t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final j0<HeadsetInfo> f47182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final LiveData<HeadsetInfo> f47183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final j0<Integer> f47184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final LiveData<Integer> f47185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final j0<HeadsetInfo> f47186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public final LiveData<HeadsetInfo> f47187i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f47188j;

    public h() {
        j0<HeadsetInfo> j0Var = new j0<>();
        this.f47182d = j0Var;
        this.f47183e = j0Var;
        j0<Integer> j0Var2 = new j0<>();
        this.f47184f = j0Var2;
        this.f47185g = j0Var2;
        j0<HeadsetInfo> j0Var3 = new j0<>();
        this.f47186h = j0Var3;
        this.f47187i = j0Var3;
        f.u(this);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@k BluetoothDevice bluetoothDevice) {
        e.a.c(this, bluetoothDevice);
    }

    @Override // q9.e
    public void H2(@k HeadsetInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        m(deviceInfo);
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void N(@l BluetoothDevice bluetoothDevice) {
        HeadsetInfo headsetInfoCopy;
        t.a.b(this, bluetoothDevice);
        HeadsetInfo headsetInfoF = this.f47182d.f();
        if (headsetInfoF == null || (headsetInfoCopy = headsetInfoF.copy((4095 & 1) != 0 ? headsetInfoF.address : null, (4095 & 2) != 0 ? headsetInfoF.deviceName : null, (4095 & 4) != 0 ? headsetInfoF.connected : false, (4095 & 8) != 0 ? headsetInfoF.deviceCode : null, (4095 & 16) != 0 ? headsetInfoF.firmwareLeft : null, (4095 & 32) != 0 ? headsetInfoF.firmwareRight : null, (4095 & 64) != 0 ? headsetInfoF.firmwareBox : null, (4095 & 128) != 0 ? headsetInfoF.batteryLeft : 0, (4095 & 256) != 0 ? headsetInfoF.batteryRight : 0, (4095 & 512) != 0 ? headsetInfoF.batteryBox : 0, (4095 & 1024) != 0 ? headsetInfoF.latency : 0, (4095 & 2048) != 0 ? headsetInfoF.eqMode : 0)) == null) {
            return;
        }
        if (j.a(bluetoothDevice != null ? bluetoothDevice.getAddress() : null, headsetInfoCopy.getAddress())) {
            headsetInfoCopy.setConnected(false);
            m(headsetInfoCopy);
        }
    }

    @Override // q9.e
    public void N0(@k HeadsetInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        m(deviceInfo);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@k BluetoothGatt bluetoothGatt) {
        e.a.f(this, bluetoothGatt);
    }

    @Override // q9.e
    public void P0(@k HeadsetInfo deviceInfo, boolean z10) {
        f0.p(deviceInfo, "deviceInfo");
        m(deviceInfo);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@k BluetoothDevice bluetoothDevice) {
        e.a.e(this, bluetoothDevice);
    }

    @Override // q9.e
    public void Z0(@k HeadsetInfo deviceInfo, boolean z10) {
        f0.p(deviceInfo, "deviceInfo");
        m(deviceInfo);
    }

    @Override // androidx.lifecycle.x0
    public void e() {
        super.e();
        f.I(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // com.flydigi.sdk.bluetooth.t
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e0(@yt.l android.bluetooth.BluetoothDevice r18) {
        /*
            r17 = this;
            r0 = r17
            com.flydigi.sdk.bluetooth.t.a.a(r17, r18)
            if (r18 == 0) goto L68
            androidx.lifecycle.j0<com.flydigi.sdk.headset.HeadsetInfo> r1 = r0.f47182d
            java.lang.Object r1 = r1.f()
            r2 = r1
            com.flydigi.sdk.headset.HeadsetInfo r2 = (com.flydigi.sdk.headset.HeadsetInfo) r2
            if (r2 == 0) goto L2d
            java.lang.String r1 = "value"
            kotlin.jvm.internal.f0.o(r2, r1)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 4095(0xfff, float:5.738E-42)
            r16 = 0
            com.flydigi.sdk.headset.HeadsetInfo r1 = com.flydigi.sdk.headset.HeadsetInfo.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            if (r1 != 0) goto L5c
        L2d:
            com.flydigi.sdk.headset.HeadsetInfo r1 = new com.flydigi.sdk.headset.HeadsetInfo
            java.lang.String r3 = r18.getAddress()
            java.lang.String r2 = "it.address"
            kotlin.jvm.internal.f0.o(r3, r2)
            java.lang.String r4 = r18.getName()
            r5 = 1
            q9.g r2 = q9.g.f47181a
            java.lang.String r6 = r18.getName()
            java.lang.String r7 = "it.name"
            kotlin.jvm.internal.f0.o(r6, r7)
            java.lang.String r6 = r2.a(r6)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 4080(0xff0, float:5.717E-42)
            r16 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L5c:
            r2 = 1
            r1.setConnected(r2)
            androidx.lifecycle.j0<com.flydigi.sdk.headset.HeadsetInfo> r2 = r0.f47186h
            r2.o(r1)
            r0.m(r1)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.h.e0(android.bluetooth.BluetoothDevice):void");
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@k BluetoothDevice bluetoothDevice) {
        e.a.d(this, bluetoothDevice);
    }

    public final void g() {
        HeadsetInfo headsetInfoF = this.f47182d.f();
        if (headsetInfoF != null) {
            l(f.f47178a.e(f.i(headsetInfoF.getAddress())));
        }
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@k BluetoothDevice bluetoothDevice) {
        e.a.b(this, bluetoothDevice);
    }

    @k
    public final LiveData<Integer> h() {
        return this.f47185g;
    }

    @k
    public final LiveData<HeadsetInfo> i() {
        return this.f47187i;
    }

    @k
    public final LiveData<HeadsetInfo> j() {
        return this.f47183e;
    }

    public final void k() {
        String address;
        if (this.f47188j) {
            return;
        }
        this.f47188j = true;
        if (true ^ f.h().isEmpty()) {
            e0(f.h().get(0));
            return;
        }
        HeadsetInfo headsetInfoF = this.f47182d.f();
        if (headsetInfoF == null || (address = headsetInfoF.getAddress()) == null) {
            return;
        }
        N(f.i(address));
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        e.a.h(this, i10);
    }

    public final void l(int i10) {
        this.f47184f.o(Integer.valueOf(i10));
    }

    public final void m(@k HeadsetInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        this.f47182d.o(deviceInfo.copy((4095 & 1) != 0 ? deviceInfo.address : null, (4095 & 2) != 0 ? deviceInfo.deviceName : null, (4095 & 4) != 0 ? deviceInfo.connected : false, (4095 & 8) != 0 ? deviceInfo.deviceCode : null, (4095 & 16) != 0 ? deviceInfo.firmwareLeft : null, (4095 & 32) != 0 ? deviceInfo.firmwareRight : null, (4095 & 64) != 0 ? deviceInfo.firmwareBox : null, (4095 & 128) != 0 ? deviceInfo.batteryLeft : 0, (4095 & 256) != 0 ? deviceInfo.batteryRight : 0, (4095 & 512) != 0 ? deviceInfo.batteryBox : 0, (4095 & 1024) != 0 ? deviceInfo.latency : 0, (4095 & 2048) != 0 ? deviceInfo.eqMode : 0));
    }

    @Override // q9.e
    public void o2(@l String str, @l String str2) {
    }

    @Override // q9.e
    public void p(@k HeadsetInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        m(deviceInfo);
    }
}
