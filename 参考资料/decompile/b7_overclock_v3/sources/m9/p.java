package m9;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionController;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionControllerKt;
import com.flydigi.sdk.bluetooth.c0;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.k0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nGamepadDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GamepadDataInteractionController.kt\ncom/flydigi/sdk/gamepad/GamepadDataInteractionController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,666:1\n1855#2,2:667\n1855#2,2:669\n1855#2,2:671\n1855#2,2:673\n1855#2,2:675\n1855#2,2:677\n1855#2,2:679\n1855#2,2:681\n1855#2,2:683\n1855#2,2:685\n1855#2,2:687\n1855#2,2:689\n1855#2,2:691\n1855#2,2:693\n1855#2,2:695\n1855#2,2:697\n1855#2,2:699\n1855#2,2:701\n1855#2,2:703\n1855#2,2:705\n1855#2,2:707\n1855#2,2:709\n1855#2,2:711\n1855#2,2:713\n1855#2,2:715\n1855#2,2:717\n*S KotlinDebug\n*F\n+ 1 GamepadDataInteractionController.kt\ncom/flydigi/sdk/gamepad/GamepadDataInteractionController\n*L\n54#1:667,2\n61#1:669,2\n82#1:671,2\n89#1:673,2\n100#1:675,2\n132#1:677,2\n142#1:679,2\n150#1:681,2\n164#1:683,2\n193#1:685,2\n211#1:687,2\n257#1:689,2\n263#1:691,2\n279#1:693,2\n283#1:695,2\n290#1:697,2\n296#1:699,2\n300#1:701,2\n310#1:703,2\n319#1:705,2\n330#1:707,2\n340#1:709,2\n347#1:711,2\n358#1:713,2\n400#1:715,2\n438#1:717,2\n*E\n"})
public final class p extends c0 {

    @yt.k
    public final UUID S;

    @yt.k
    public final UUID T;

    @yt.k
    public final UUID U;

    @yt.k
    public final UUID V;
    public final UUID W;
    public final UUID X;

    @yt.k
    public ArrayList<r> Y;

    @yt.k
    public GamepadInfo Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f40880a0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@yt.k Context mContext, @yt.k com.flydigi.sdk.bluetooth.u filter) {
        super(mContext, filter, 4);
        f0.p(mContext, "mContext");
        f0.p(filter, "filter");
        UUID uuidFromString = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString, "fromString(\"00002902-0000-1000-8000-00805f9b34fb\")");
        this.S = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("6e400001-b5a3-f393-e0a9-e50e24dcca9e");
        f0.o(uuidFromString2, "fromString(\"6e400001-b5a3-f393-e0a9-e50e24dcca9e\")");
        this.T = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e");
        f0.o(uuidFromString3, "fromString(\"6e400002-b5a3-f393-e0a9-e50e24dcca9e\")");
        this.U = uuidFromString3;
        UUID uuidFromString4 = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e");
        f0.o(uuidFromString4, "fromString(\"6e400003-b5a3-f393-e0a9-e50e24dcca9e\")");
        this.V = uuidFromString4;
        this.W = UUID.fromString("00002a26-0000-1000-8000-00805f9b34fb");
        this.X = UUID.fromString("0000180a-0000-1000-8000-00805f9b34fb");
        this.Y = new ArrayList<>();
        this.Z = new GamepadInfo();
    }

    public static /* synthetic */ void A2(p pVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        pVar.z2(z10);
    }

    public static final void i2(p this$0) {
        f0.p(this$0, "this$0");
        this$0.o2();
    }

    public static final void j2(p this$0) {
        f0.p(this$0, "this$0");
        this$0.h2();
    }

    public static /* synthetic */ void v2(p pVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        pVar.u2(z10);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @yt.k
    public UUID B1() {
        return this.S;
    }

    public final void B2() {
        AbstractDataInteractionController.R0(this, e.f40735a.j(), null, 2, null);
    }

    public final void C2() {
        AbstractDataInteractionController.R0(this, e.f40735a.k(), null, 2, null);
    }

    public final void D2() {
        AbstractDataInteractionController.R0(this, e.f40735a.l(), null, 2, null);
    }

    public final void E2() {
        AbstractDataInteractionController.R0(this, e.f40745k, null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @yt.k
    public UUID F1() {
        return this.V;
    }

    public final void F2() {
        AbstractDataInteractionController.R0(this, e.f40748n, null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0, com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void G0(@yt.k Object obj) {
        f0.p(obj, "obj");
        super.G0(obj);
        if ((obj instanceof r) && this.Y.contains(obj)) {
            this.Y.remove(obj);
        }
    }

    public final void G2() {
        AbstractDataInteractionController.R0(this, e.e(3), null, 2, null);
    }

    public final void H2() {
        AbstractDataInteractionController.R0(this, e.f40738d, null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @yt.k
    public UUID I1() {
        return this.U;
    }

    public final void I2(int i10) {
        AbstractDataInteractionController.R0(this, e.u(i10), null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void J1(@yt.k BluetoothGattService service) {
        f0.p(service, "service");
        b2(service.getCharacteristics().size() > 1 ? service.getCharacteristic(I1()) : service.getCharacteristic(F1()));
        a2(service.getCharacteristic(F1()));
    }

    public final void J2(int i10) {
        AbstractDataInteractionController.R0(this, e.f40735a.m(i10), null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void K1(@yt.k byte[] value) {
        f0.p(value, "value");
        if (e.r(value)) {
            Iterator<T> it2 = this.Y.iterator();
            while (it2.hasNext()) {
                ((r) it2.next()).U();
            }
        }
    }

    public final void K2(@yt.k byte[] color, int i10) {
        f0.p(color, "color");
        AbstractDataInteractionController.R0(this, e.f40735a.v(color, i10), null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void L1(@yt.k byte[] value) {
        f0.p(value, "value");
        if (e.r(value)) {
            Iterator<T> it2 = this.Y.iterator();
            while (it2.hasNext()) {
                ((r) it2.next()).U();
            }
        }
    }

    public final void L2(byte b10, boolean z10) {
        AbstractDataInteractionController.R0(this, e.f40735a.n(b10, z10), null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void M1(@yt.k UUID uuid, @yt.k byte[] value) {
        f0.p(uuid, "uuid");
        f0.p(value, "value");
        if (f0.g(uuid, this.W)) {
            this.Z.setFirmwareVersion(new String(value, kotlin.text.d.f38161b));
            l9.a.c("固件版本：" + this.Z.getFirmwareVersion());
            String firmwareVersion = this.Z.getFirmwareVersion();
            if (firmwareVersion != null) {
                o2();
                if (l9.c.b(k.f40822h, firmwareVersion)) {
                    return;
                }
                this.Z.setMappingMode(0);
                this.Z.setSupportFlashplay(false);
                for (r rVar : this.Y) {
                    BluetoothDevice bluetoothDeviceM = M();
                    GamepadInfo gamepadInfo = this.Z;
                    rVar.u0(bluetoothDeviceM, gamepadInfo.copy((536866815 & 1) != 0 ? gamepadInfo.address : null, (536866815 & 2) != 0 ? gamepadInfo.deviceName : null, (536866815 & 4) != 0 ? gamepadInfo.deviceCode : null, (536866815 & 8) != 0 ? gamepadInfo.chipType : 0, (536866815 & 16) != 0 ? gamepadInfo.motionChipType : 0, (536866815 & 32) != 0 ? gamepadInfo.deviceType : 0, (536866815 & 64) != 0 ? gamepadInfo.deviceMode : 0, (536866815 & 128) != 0 ? gamepadInfo.connectMode : 0, (536866815 & 256) != 0 ? gamepadInfo.connectState : 0, (536866815 & 512) != 0 ? gamepadInfo.mappingMode : 0, (536866815 & 1024) != 0 ? gamepadInfo.usb0Device : 0, (536866815 & 2048) != 0 ? gamepadInfo.usb1Device : 0, (536866815 & 4096) != 0 ? gamepadInfo.firmwareVersion : null, (536866815 & 8192) != 0 ? gamepadInfo.isSupportFlashplay : false, (536866815 & 16384) != 0 ? gamepadInfo.isDriverConnected : false, (536866815 & 32768) != 0 ? gamepadInfo.driverVersion : null, (536866815 & 65536) != 0 ? gamepadInfo.battery : 0, (536866815 & 131072) != 0 ? gamepadInfo.isSupportLinearButton : false, (536866815 & 262144) != 0 ? gamepadInfo.isSupportMotion : false, (536866815 & 524288) != 0 ? gamepadInfo.isSupportLunpan : false, (536866815 & 1048576) != 0 ? gamepadInfo.isSupportLed : false, (536866815 & 2097152) != 0 ? gamepadInfo.isSupportMotor : false, (536866815 & 4194304) != 0 ? gamepadInfo.supportKeys : null, (536866815 & 8388608) != 0 ? gamepadInfo.batteryLevelGap : null, (536866815 & 16777216) != 0 ? gamepadInfo.ipType : false, (536866815 & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? gamepadInfo.isSupportSwitch : false, (536866815 & 67108864) != 0 ? gamepadInfo.switchChipVersion : null, (536866815 & 134217728) != 0 ? gamepadInfo.isSupportTrigger : false, (536866815 & 268435456) != 0 ? gamepadInfo.uuid : null));
                }
            }
        }
    }

    public final void M2(byte[] bArr) {
        byte[] bArrA = b.f40729a.m(bArr) ? e.f40735a.a(true, this.Z.isSystemConnect(), bArr, this.Z.isGamepadKeyboard()) : b.M(bArr) ? e.f40735a.a(false, this.Z.isSystemConnect(), bArr, this.Z.isGamepadKeyboard()) : null;
        if (bArrA != null) {
            Iterator<T> it2 = this.Y.iterator();
            while (it2.hasNext()) {
                ((r) it2.next()).B1(bArr, bArrA);
            }
        }
    }

    public final void N2() {
        AbstractDataInteractionController.R0(this, e.x(), null, 2, null);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void O1(@yt.k BluetoothGattDescriptor descriptor) {
        f0.p(descriptor, "descriptor");
        super.O1(descriptor);
        if (!f0.g(descriptor.getUuid(), B1()) || K()) {
            return;
        }
        l2();
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void P1(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        super.P1(device);
        Iterator<T> it2 = this.Y.iterator();
        while (it2.hasNext()) {
            ((r) it2.next()).V0(device);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void R1(@yt.k BluetoothDevice device) {
        f0.p(device, "device");
        super.R1(device);
        Iterator<T> it2 = this.Y.iterator();
        while (it2.hasNext()) {
            ((r) it2.next()).A(device);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void S1(@yt.k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        super.S1(gatt);
        BluetoothDevice device = gatt.getDevice();
        v0(device);
        this.Z.setConnectState(2);
        this.Z.setAddress(device.getAddress());
        GamepadInfo gamepadInfo = this.Z;
        String name = device.getName();
        f0.o(name, "name");
        gamepadInfo.set_deviceName(name);
        t0(this.Z.getChipType());
        if (device.getBondState() == 12) {
            this.Z.setConnectMode(1);
        } else {
            this.Z.setConnectMode(0);
        }
        for (r rVar : this.Y) {
            f0.o(device, "this");
            rVar.e2(device);
        }
        String name2 = device.getName();
        f0.o(name2, "name");
        if (!kotlin.text.u.v2(name2, com.flydigi.sdk.bluetooth.v.f16329e, false, 2, null)) {
            String name3 = device.getName();
            f0.o(name3, "name");
            if (!kotlin.text.u.v2(name3, com.flydigi.sdk.bluetooth.v.f16330f, false, 2, null)) {
                return;
            }
        }
        for (r rVar2 : this.Y) {
            GamepadInfo gamepadInfo2 = this.Z;
            rVar2.u0(device, gamepadInfo2.copy((536866815 & 1) != 0 ? gamepadInfo2.address : null, (536866815 & 2) != 0 ? gamepadInfo2.deviceName : null, (536866815 & 4) != 0 ? gamepadInfo2.deviceCode : null, (536866815 & 8) != 0 ? gamepadInfo2.chipType : 0, (536866815 & 16) != 0 ? gamepadInfo2.motionChipType : 0, (536866815 & 32) != 0 ? gamepadInfo2.deviceType : 0, (536866815 & 64) != 0 ? gamepadInfo2.deviceMode : 0, (536866815 & 128) != 0 ? gamepadInfo2.connectMode : 0, (536866815 & 256) != 0 ? gamepadInfo2.connectState : 0, (536866815 & 512) != 0 ? gamepadInfo2.mappingMode : 0, (536866815 & 1024) != 0 ? gamepadInfo2.usb0Device : 0, (536866815 & 2048) != 0 ? gamepadInfo2.usb1Device : 0, (536866815 & 4096) != 0 ? gamepadInfo2.firmwareVersion : null, (536866815 & 8192) != 0 ? gamepadInfo2.isSupportFlashplay : false, (536866815 & 16384) != 0 ? gamepadInfo2.isDriverConnected : false, (536866815 & 32768) != 0 ? gamepadInfo2.driverVersion : null, (536866815 & 65536) != 0 ? gamepadInfo2.battery : 0, (536866815 & 131072) != 0 ? gamepadInfo2.isSupportLinearButton : false, (536866815 & 262144) != 0 ? gamepadInfo2.isSupportMotion : false, (536866815 & 524288) != 0 ? gamepadInfo2.isSupportLunpan : false, (536866815 & 1048576) != 0 ? gamepadInfo2.isSupportLed : false, (536866815 & 2097152) != 0 ? gamepadInfo2.isSupportMotor : false, (536866815 & 4194304) != 0 ? gamepadInfo2.supportKeys : null, (536866815 & 8388608) != 0 ? gamepadInfo2.batteryLevelGap : null, (536866815 & 16777216) != 0 ? gamepadInfo2.ipType : false, (536866815 & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? gamepadInfo2.isSupportSwitch : false, (536866815 & 67108864) != 0 ? gamepadInfo2.switchChipVersion : null, (536866815 & 134217728) != 0 ? gamepadInfo2.isSupportTrigger : false, (536866815 & 268435456) != 0 ? gamepadInfo2.uuid : null));
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void T1(@yt.k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        super.T1(gatt);
        this.f40880a0 = 0;
        Iterator<T> it2 = this.Y.iterator();
        while (it2.hasNext()) {
            ((r) it2.next()).O2(gatt);
        }
        this.Z.reset();
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void V1(int i10) {
        Iterator<T> it2 = this.Y.iterator();
        while (it2.hasNext()) {
            ((r) it2.next()).k1(i10);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    @yt.k
    public UUID X0() {
        return this.T;
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void Z0(@yt.k UUID uuid, @yt.k byte[] value) {
        f0.p(uuid, "uuid");
        f0.p(value, "value");
        b bVar = b.f40729a;
        if (b.k(bVar, value, null, 2, null)) {
            j9.b bVarD = z1().d();
            if (bVarD != null && bVar.j(bVarD.k(), value)) {
                z1().b();
            }
            Iterator<T> it2 = this.Y.iterator();
            while (it2.hasNext()) {
                ((r) it2.next()).H(value);
            }
        }
        if (value.length == 20 && value[0] == -91) {
            if (value[1] == 1) {
                int i10 = value[6] & 15;
                int i11 = value[7] >> 4;
                int i12 = value[7] & 15;
                this.Z.setSwitchChipVersion(i10 + j3.b.f36044h + i11 + j3.b.f36044h + i12);
                if (i12 == 0 && i11 == 0 && i10 == 0) {
                    l9.a.f("onReceiveDataFromDevice can not read firmware version of switch chip");
                } else {
                    l9.a.c("onReceiveDataFromDevice firmware version of switch chip: " + this.Z.getSwitchChipVersion());
                }
            } else if (value[1] == -96) {
                GamepadInfo gamepadInfo = this.Z;
                int i13 = value[2] & 255;
                int i14 = value[3] & 255;
                int i15 = value[4] & 255;
                int i16 = value[5] & 255;
                int i17 = value[6] & 255;
                int i18 = value[7] & 255;
                int i19 = value[8] & 255;
                int i20 = value[9] & 255;
                int i21 = value[10] & 255;
                int i22 = 255 & value[11];
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i13);
                sb2.append(i14);
                sb2.append(i15);
                sb2.append(i16);
                sb2.append(i17);
                sb2.append(i18);
                sb2.append(i19);
                sb2.append(i20);
                sb2.append(i21);
                sb2.append(i22);
                gamepadInfo.setUuid(sb2.toString());
                l9.a.c("onReceiveDataFromDevice uuid: " + this.Z.getUuid());
            } else if (value[1] == -95) {
                Iterator<Integer> it3 = new qk.m(0, 2).iterator();
                while (it3.hasNext()) {
                    int iB = ((k0) it3).b() * 5;
                    int i23 = iB + 6;
                    if ((value[i23] & 255) != 255 || (value[iB + 5] & 255) != 255 || (value[iB + 4] & 255) != 255 || (value[iB + 3] & 255) != 255) {
                        byte b10 = value[i23];
                        byte b11 = value[iB + 5];
                        byte b12 = value[iB + 4];
                        byte b13 = value[iB + 3];
                    }
                }
            }
            for (r rVar : this.Y) {
                GamepadInfo gamepadInfo2 = this.Z;
                rVar.I2(gamepadInfo2.copy((536866815 & 1) != 0 ? gamepadInfo2.address : null, (536866815 & 2) != 0 ? gamepadInfo2.deviceName : null, (536866815 & 4) != 0 ? gamepadInfo2.deviceCode : null, (536866815 & 8) != 0 ? gamepadInfo2.chipType : 0, (536866815 & 16) != 0 ? gamepadInfo2.motionChipType : 0, (536866815 & 32) != 0 ? gamepadInfo2.deviceType : 0, (536866815 & 64) != 0 ? gamepadInfo2.deviceMode : 0, (536866815 & 128) != 0 ? gamepadInfo2.connectMode : 0, (536866815 & 256) != 0 ? gamepadInfo2.connectState : 0, (536866815 & 512) != 0 ? gamepadInfo2.mappingMode : 0, (536866815 & 1024) != 0 ? gamepadInfo2.usb0Device : 0, (536866815 & 2048) != 0 ? gamepadInfo2.usb1Device : 0, (536866815 & 4096) != 0 ? gamepadInfo2.firmwareVersion : null, (536866815 & 8192) != 0 ? gamepadInfo2.isSupportFlashplay : false, (536866815 & 16384) != 0 ? gamepadInfo2.isDriverConnected : false, (536866815 & 32768) != 0 ? gamepadInfo2.driverVersion : null, (536866815 & 65536) != 0 ? gamepadInfo2.battery : 0, (536866815 & 131072) != 0 ? gamepadInfo2.isSupportLinearButton : false, (536866815 & 262144) != 0 ? gamepadInfo2.isSupportMotion : false, (536866815 & 524288) != 0 ? gamepadInfo2.isSupportLunpan : false, (536866815 & 1048576) != 0 ? gamepadInfo2.isSupportLed : false, (536866815 & 2097152) != 0 ? gamepadInfo2.isSupportMotor : false, (536866815 & 4194304) != 0 ? gamepadInfo2.supportKeys : null, (536866815 & 8388608) != 0 ? gamepadInfo2.batteryLevelGap : null, (536866815 & 16777216) != 0 ? gamepadInfo2.ipType : false, (536866815 & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? gamepadInfo2.isSupportSwitch : false, (536866815 & 67108864) != 0 ? gamepadInfo2.switchChipVersion : null, (536866815 & 134217728) != 0 ? gamepadInfo2.isSupportTrigger : false, (536866815 & 268435456) != 0 ? gamepadInfo2.uuid : null));
            }
        } else {
            b bVar2 = b.f40729a;
            if (bVar2.q(value)) {
                l9.a.c("onReceiveDataFromDevice heartValue " + AbstractDataInteractionControllerKt.b(value, null, 1, null));
                int iK0 = bVar2.k0(value);
                t0(bVar2.j0(value));
                if (iK0 != 0) {
                    q.y(this.Z, iK0, E(), bVar2.m0(value));
                }
                k2(value);
                this.Z.setBattery(bVar2.i0(value));
                if (this.Z.getBattery() == 0) {
                    int i24 = this.f40880a0;
                    if (i24 == 0) {
                        this.f40880a0 = i24 + 1;
                        P().postDelayed(new Runnable() { // from class: m9.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                p.i2(this.f40878a);
                            }
                        }, 3000L);
                    }
                } else {
                    this.f40880a0 = 0;
                }
                m2(value);
                if (t.f(this.Z)) {
                    String switchChipVersion = this.Z.getSwitchChipVersion();
                    if (switchChipVersion == null || switchChipVersion.length() == 0) {
                        g2();
                    }
                }
                String uuid2 = this.Z.getUuid();
                if (uuid2 == null || uuid2.length() == 0) {
                    P().postDelayed(new Runnable() { // from class: m9.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            p.j2(this.f40879a);
                        }
                    }, 50L);
                }
                n2(value);
                this.Z.setSupportFlashplay(bVar2.c(value));
                for (r rVar2 : this.Y) {
                    BluetoothDevice bluetoothDeviceM = M();
                    GamepadInfo gamepadInfo3 = this.Z;
                    rVar2.u0(bluetoothDeviceM, gamepadInfo3.copy((536866815 & 1) != 0 ? gamepadInfo3.address : null, (536866815 & 2) != 0 ? gamepadInfo3.deviceName : null, (536866815 & 4) != 0 ? gamepadInfo3.deviceCode : null, (536866815 & 8) != 0 ? gamepadInfo3.chipType : 0, (536866815 & 16) != 0 ? gamepadInfo3.motionChipType : 0, (536866815 & 32) != 0 ? gamepadInfo3.deviceType : 0, (536866815 & 64) != 0 ? gamepadInfo3.deviceMode : 0, (536866815 & 128) != 0 ? gamepadInfo3.connectMode : 0, (536866815 & 256) != 0 ? gamepadInfo3.connectState : 0, (536866815 & 512) != 0 ? gamepadInfo3.mappingMode : 0, (536866815 & 1024) != 0 ? gamepadInfo3.usb0Device : 0, (536866815 & 2048) != 0 ? gamepadInfo3.usb1Device : 0, (536866815 & 4096) != 0 ? gamepadInfo3.firmwareVersion : null, (536866815 & 8192) != 0 ? gamepadInfo3.isSupportFlashplay : false, (536866815 & 16384) != 0 ? gamepadInfo3.isDriverConnected : false, (536866815 & 32768) != 0 ? gamepadInfo3.driverVersion : null, (536866815 & 65536) != 0 ? gamepadInfo3.battery : 0, (536866815 & 131072) != 0 ? gamepadInfo3.isSupportLinearButton : false, (536866815 & 262144) != 0 ? gamepadInfo3.isSupportMotion : false, (536866815 & 524288) != 0 ? gamepadInfo3.isSupportLunpan : false, (536866815 & 1048576) != 0 ? gamepadInfo3.isSupportLed : false, (536866815 & 2097152) != 0 ? gamepadInfo3.isSupportMotor : false, (536866815 & 4194304) != 0 ? gamepadInfo3.supportKeys : null, (536866815 & 8388608) != 0 ? gamepadInfo3.batteryLevelGap : null, (536866815 & 16777216) != 0 ? gamepadInfo3.ipType : false, (536866815 & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? gamepadInfo3.isSupportSwitch : false, (536866815 & 67108864) != 0 ? gamepadInfo3.switchChipVersion : null, (536866815 & 134217728) != 0 ? gamepadInfo3.isSupportTrigger : false, (536866815 & 268435456) != 0 ? gamepadInfo3.uuid : null));
                }
                return;
            }
        }
        Iterator<T> it4 = this.Y.iterator();
        while (it4.hasNext()) {
            ((r) it4.next()).a2(value);
        }
        if (!b.M(value)) {
            l9.a.e("onReceiveDataFromDevice callback " + AbstractDataInteractionControllerKt.b(value, null, 1, null));
            return;
        }
        if (l9.a.f39473a.b()) {
            l9.a.c("onReceiveDataFromDevice operate " + AbstractDataInteractionControllerKt.b(value, null, 1, null));
        }
        if (this.Z.isGamepadHalf() || this.Z.isDriverMode()) {
            M2(value);
        }
        if (this.Z.getDeviceMode() == 1) {
            List<Integer> listP0 = b.p0(value);
            if (!listP0.isEmpty()) {
                Iterator<T> it5 = this.Y.iterator();
                while (it5.hasNext()) {
                    ((r) it5.next()).n0(listP0);
                }
            } else {
                Iterator<T> it6 = this.Y.iterator();
                while (it6.hasNext()) {
                    ((r) it6.next()).k0();
                }
            }
            Pair<Integer, Integer> pairS0 = b.f40729a.s0(value);
            Iterator<T> it7 = this.Y.iterator();
            while (it7.hasNext()) {
                ((r) it7.next()).R2(pairS0);
            }
            return;
        }
        List<Integer> listO0 = b.o0(value);
        if (!listO0.isEmpty()) {
            Iterator<T> it8 = this.Y.iterator();
            while (it8.hasNext()) {
                ((r) it8.next()).n0(listO0);
            }
        } else {
            Iterator<T> it9 = this.Y.iterator();
            while (it9.hasNext()) {
                ((r) it9.next()).k0();
            }
        }
        Pair<Float, Float> pairQ0 = b.q0(value);
        boolean zB = b.b(null, pairQ0, 1, null);
        if (pairQ0 != null) {
            Iterator<T> it10 = this.Y.iterator();
            while (it10.hasNext()) {
                ((r) it10.next()).B0(zB, pairQ0);
            }
        }
        Pair<Float, Float> pairT0 = b.t0(value);
        boolean zB2 = b.b(null, pairT0, 1, null);
        if (pairT0 != null) {
            Iterator<T> it11 = this.Y.iterator();
            while (it11.hasNext()) {
                ((r) it11.next()).Z1(zB2, pairT0);
            }
        }
        if (this.Z.isSupportLunpan()) {
            Pair<Float, Float> pairU0 = b.u0(value);
            boolean zB3 = b.b(null, pairU0, 1, null);
            if (pairU0 != null) {
                Iterator<T> it12 = this.Y.iterator();
                while (it12.hasNext()) {
                    ((r) it12.next()).M0(zB3, pairU0);
                }
            }
        }
        if (this.Z.isSupportLinearButton()) {
            b bVar3 = b.f40729a;
            int iR0 = bVar3.r0(value, 12);
            int iR02 = bVar3.r0(value, 13);
            Iterator<T> it13 = this.Y.iterator();
            while (it13.hasNext()) {
                ((r) it13.next()).z0(iR0, iR02);
            }
        }
        if (this.Z.isGamepadKeyboard() || this.Z.isSupportMotion()) {
            Pair<Integer, Integer> pairS02 = b.f40729a.s0(value);
            Iterator<T> it14 = this.Y.iterator();
            while (it14.hasNext()) {
                ((r) it14.next()).R2(pairS02);
            }
        }
    }

    public final void f2() {
        AbstractDataInteractionController.R0(this, e.f40747m, null, 2, null);
    }

    public final void g2() {
        AbstractDataInteractionController.R0(this, e.f40735a.g(), null, 2, null);
    }

    public final void h2() {
        AbstractDataInteractionController.R0(this, e.f40746l, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.flydigi.sdk.gamepad.GamepadInfo] */
    /* JADX WARN: Type inference failed for: r1v3, types: [m9.r] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [int] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k2(byte[] r7) {
        /*
            r6 = this;
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.Z
            int r0 = r0.getDeviceMode()
            r1 = 33
            r2 = -1
            if (r0 == r2) goto L1b
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.Z
            int r0 = r0.getDeviceType()
            if (r0 == r1) goto L1b
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.Z
            boolean r0 = r0.isGamepadKeyboard()
            if (r0 == 0) goto L8e
        L1b:
            m9.b r0 = m9.b.f40729a
            boolean r3 = r0.q(r7)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3c
            com.flydigi.sdk.gamepad.GamepadInfo r3 = r6.Z
            int r5 = r0.n0(r5, r7)
            r3.setUsb0Device(r5)
            com.flydigi.sdk.gamepad.GamepadInfo r3 = r6.Z
            int r4 = r0.n0(r4, r7)
            r3.setUsb1Device(r4)
            boolean r7 = r0.b0(r7)
            goto L5c
        L3c:
            boolean r3 = m9.b.M(r7)
            if (r3 == 0) goto L5b
            com.flydigi.sdk.gamepad.GamepadInfo r3 = r6.Z
            int r5 = r0.n0(r5, r7)
            r3.setUsb0Device(r5)
            com.flydigi.sdk.gamepad.GamepadInfo r3 = r6.Z
            int r4 = r0.n0(r4, r7)
            r3.setUsb1Device(r4)
            boolean r7 = r0.s(r7)
            r0 = r7
            r7 = -1
            goto L5d
        L5b:
            r7 = -1
        L5c:
            r0 = -1
        L5d:
            if (r7 != r0) goto L60
            goto L62
        L60:
            if (r0 == r2) goto L63
        L62:
            r7 = r0
        L63:
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.Z
            int r0 = r0.getDeviceType()
            if (r0 != r1) goto L8e
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.Z
            int r0 = r0.getDeviceMode()
            if (r0 == r2) goto L89
            java.util.ArrayList<m9.r> r0 = r6.Y
            java.util.Iterator r0 = r0.iterator()
        L79:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L89
            java.lang.Object r1 = r0.next()
            m9.r r1 = (m9.r) r1
            r1.m2(r7)
            goto L79
        L89:
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.Z
            r0.setDeviceMode(r7)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.p.k2(byte[]):void");
    }

    public final void l2() {
        BluetoothGattService bluetoothGattServiceC1;
        BluetoothGatt bluetoothGattD1 = D1();
        if (bluetoothGattD1 == null || (bluetoothGattServiceC1 = C1()) == null) {
            return;
        }
        if (bluetoothGattServiceC1.getCharacteristics().size() <= 1) {
            o2();
            return;
        }
        BluetoothGattService service = bluetoothGattD1.getService(this.X);
        if (service != null) {
            bluetoothGattD1.readCharacteristic(service.getCharacteristic(this.W));
        } else {
            o2();
        }
    }

    public final void m2(byte[] bArr) {
        String firmwareVersion = this.Z.getFirmwareVersion();
        if ((firmwareVersion == null || firmwareVersion.length() == 0) && b.f40729a.q(bArr)) {
            int i10 = bArr[16] >> 4;
            int i11 = bArr[16] & 15;
            int i12 = bArr[17] >> 4;
            int i13 = bArr[17] & 15;
            this.Z.setFirmwareVersion(i10 + j3.b.f36044h + i11 + j3.b.f36044h + i12 + j3.b.f36044h + i13);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0, com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void n0(@yt.k Object obj) {
        f0.p(obj, "obj");
        super.n0(obj);
        if (!(obj instanceof r) || this.Y.contains(obj)) {
            return;
        }
        this.Y.add(obj);
    }

    public final void n2(byte[] bArr) {
        if (this.Z.getMappingMode() == -1) {
            this.Z.setMappingMode(b.f40729a.l0(bArr));
            if (this.Z.getDeviceType() == 68 && this.Z.getMappingMode() == 4 && (t.f40884a.g() || this.Z.isSystemConnect())) {
                t2();
            }
            l9.a.e("当前映射模式：" + this.Z.getReadableMappingMode());
        }
    }

    public final void o2() {
        AbstractDataInteractionController.R0(this, e.f40736b, null, 2, null);
    }

    public final void p2(byte b10) {
        AbstractDataInteractionController.R0(this, e.h(b10), null, 2, null);
    }

    public final void q2(int i10, int i11, int i12) {
        AbstractDataInteractionController.R0(this, e.f40735a.o(i10, i11, i12), null, 2, null);
    }

    public final void r2(int i10) {
        AbstractDataInteractionController.R0(this, e.f40735a.i(i10), null, 2, null);
    }

    public final void s2() {
        AbstractDataInteractionController.R0(this, e.f40744j, null, 2, null);
    }

    public final void t2() {
        AbstractDataInteractionController.R0(this, e.f40735a.d(), null, 2, null);
    }

    public final void u2(boolean z10) {
        AbstractDataInteractionController.R0(this, e.b(z10), null, 2, null);
    }

    public final void w2() {
        AbstractDataInteractionController.R0(this, e.f40735a.f(), null, 2, null);
    }

    public final void x2() {
        AbstractDataInteractionController.R0(this, e.e(2), null, 2, null);
    }

    public final void y2() {
        AbstractDataInteractionController.R0(this, e.e(1), null, 2, null);
    }

    public final void z2(boolean z10) {
        AbstractDataInteractionController.R0(this, e.s(this.Z.getConnectMode() == 1, z10), null, 2, null);
    }
}
