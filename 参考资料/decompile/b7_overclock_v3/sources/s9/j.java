package s9;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionController;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionControllerKt;
import com.flydigi.sdk.bluetooth.c0;
import com.flydigi.sdk.bluetooth.u;
import com.flydigi.sdk.headset.HeadsetInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import q9.e;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nHeadsetDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeadsetDataInteractionController.kt\ncom/flydigi/sdk/headset/controller/HeadsetDataInteractionController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,289:1\n1855#2,2:290\n1855#2,2:292\n1855#2,2:294\n1855#2,2:296\n1855#2,2:298\n1855#2,2:300\n1855#2,2:302\n1855#2,2:304\n1855#2,2:306\n1855#2,2:308\n1855#2,2:310\n*S KotlinDebug\n*F\n+ 1 HeadsetDataInteractionController.kt\ncom/flydigi/sdk/headset/controller/HeadsetDataInteractionController\n*L\n37#1:290,2\n44#1:292,2\n61#1:294,2\n70#1:296,2\n79#1:298,2\n85#1:300,2\n138#1:302,2\n148#1:304,2\n156#1:306,2\n164#1:308,2\n170#1:310,2\n*E\n"})
public final class j extends c0 {

    @k
    public final UUID S;

    @k
    public final UUID T;

    @k
    public final UUID U;

    @k
    public final UUID V;

    @k
    public ArrayList<q9.e> W;

    @l
    public HeadsetInfo X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@k Context mContext, @k u filter) {
        super(mContext, filter, 1);
        f0.p(mContext, "mContext");
        f0.p(filter, "filter");
        UUID uuidFromString = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString, "fromString(\"00002902-0000-1000-8000-00805f9b34fb\")");
        this.S = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("01000100-0000-1000-8000-009078563412");
        f0.o(uuidFromString2, "fromString(\"01000100-0000-1000-8000-009078563412\")");
        this.T = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("03000100-0000-1000-8000-009078563412");
        f0.o(uuidFromString3, "fromString(\"03000100-0000-1000-8000-009078563412\")");
        this.U = uuidFromString3;
        UUID uuidFromString4 = UUID.fromString("02000100-0000-1000-8000-009078563412");
        f0.o(uuidFromString4, "fromString(\"02000100-0000-1000-8000-009078563412\")");
        this.V = uuidFromString4;
        this.W = new ArrayList<>();
    }

    public static final void h2(j this$0) {
        f0.p(this$0, "this$0");
        this$0.q2();
    }

    public static final void i2(j this$0) {
        f0.p(this$0, "this$0");
        this$0.o2();
    }

    public static final void j2(j this$0) {
        f0.p(this$0, "this$0");
        this$0.p2();
    }

    public static final void k2(j this$0) {
        f0.p(this$0, "this$0");
        this$0.n2();
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @k
    public UUID B1() {
        return this.S;
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @k
    public UUID F1() {
        return this.V;
    }

    @Override // com.flydigi.sdk.bluetooth.c0, com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void G0(@k Object obj) {
        f0.p(obj, "obj");
        super.G0(obj);
        if ((obj instanceof q9.e) && this.W.contains(obj)) {
            this.W.remove(obj);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    @k
    public UUID I1() {
        return this.U;
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void K1(@k byte[] value) {
        f0.p(value, "value");
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void L1(@k byte[] value) {
        f0.p(value, "value");
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void M1(@k UUID uuid, @k byte[] value) {
        f0.p(uuid, "uuid");
        f0.p(value, "value");
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void O1(@k BluetoothGattDescriptor descriptor) {
        f0.p(descriptor, "descriptor");
        super.O1(descriptor);
        P().postDelayed(new Runnable() { // from class: s9.i
            @Override // java.lang.Runnable
            public final void run() {
                j.j2(this.f49541a);
            }
        }, 500L);
        P().postDelayed(new Runnable() { // from class: s9.g
            @Override // java.lang.Runnable
            public final void run() {
                j.k2(this.f49539a);
            }
        }, 550L);
        P().postDelayed(new Runnable() { // from class: s9.h
            @Override // java.lang.Runnable
            public final void run() {
                j.h2(this.f49540a);
            }
        }, 600L);
        P().postDelayed(new Runnable() { // from class: s9.f
            @Override // java.lang.Runnable
            public final void run() {
                j.i2(this.f49538a);
            }
        }, 650L);
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void P1(@k BluetoothDevice device) {
        f0.p(device, "device");
        super.P1(device);
        if (this.X == null) {
            String address = device.getAddress();
            f0.o(address, "device.address");
            this.X = new HeadsetInfo(address, device.getName(), false, null, null, null, null, 0, 0, 0, 0, 0, 4092, null);
        }
        Iterator<T> it2 = this.W.iterator();
        while (it2.hasNext()) {
            ((q9.e) it2.next()).V0(device);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void R1(@k BluetoothDevice device) {
        f0.p(device, "device");
        super.R1(device);
        Iterator<T> it2 = this.W.iterator();
        while (it2.hasNext()) {
            ((q9.e) it2.next()).A(device);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void S1(@k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        super.S1(gatt);
        HeadsetInfo headsetInfo = this.X;
        if (headsetInfo == null) {
            String address = gatt.getDevice().getAddress();
            f0.o(address, "gatt.device.address");
            this.X = new HeadsetInfo(address, gatt.getDevice().getName(), true, null, null, null, null, 0, 0, 0, 0, 0, 4088, null);
        } else {
            if (headsetInfo != null) {
                String address2 = gatt.getDevice().getAddress();
                f0.o(address2, "gatt.device.address");
                headsetInfo.setAddress(address2);
            }
            HeadsetInfo headsetInfo2 = this.X;
            if (headsetInfo2 != null) {
                headsetInfo2.setDeviceName(gatt.getDevice().getName());
            }
            HeadsetInfo headsetInfo3 = this.X;
            if (headsetInfo3 != null) {
                headsetInfo3.setConnected(true);
            }
        }
        BluetoothDevice it2 = gatt.getDevice();
        v0(it2);
        for (q9.e eVar : this.W) {
            f0.o(it2, "it");
            eVar.e2(it2);
        }
        l2();
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void T1(@k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        super.T1(gatt);
        this.X = null;
        Iterator<T> it2 = this.W.iterator();
        while (it2.hasNext()) {
            ((q9.e) it2.next()).O2(gatt);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.c0
    public void V1(int i10) {
        Iterator<T> it2 = this.W.iterator();
        while (it2.hasNext()) {
            ((q9.e) it2.next()).k1(i10);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    @k
    public UUID X0() {
        return this.T;
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void Z0(@k UUID uuid, @k byte[] value) {
        f0.p(uuid, "uuid");
        f0.p(value, "value");
        if ((value[0] & 255) == 254 && (value[1] & 255) == 239) {
            if ((value[2] & 255) == 128) {
                HeadsetInfo headsetInfo = this.X;
                if (headsetInfo != null) {
                    headsetInfo.setFirmwareLeft(m2(value[4], value[5]));
                    headsetInfo.setFirmwareRight(m2(value[6], value[7]));
                    headsetInfo.setFirmwareBox(m2(value[8], value[9]));
                    Iterator<T> it2 = this.W.iterator();
                    while (it2.hasNext()) {
                        ((q9.e) it2.next()).H2(headsetInfo);
                    }
                    return;
                }
                return;
            }
            if ((value[2] & 255) == 129) {
                HeadsetInfo headsetInfo2 = this.X;
                if (headsetInfo2 != null) {
                    headsetInfo2.setBatteryLeft(value[4]);
                    headsetInfo2.setBatteryRight(value[5]);
                    headsetInfo2.setBatteryBox(value[6]);
                    Iterator<T> it3 = this.W.iterator();
                    while (it3.hasNext()) {
                        ((q9.e) it3.next()).p(headsetInfo2);
                    }
                    return;
                }
                return;
            }
            if ((value[2] & 255) == 130) {
                HeadsetInfo headsetInfo3 = this.X;
                if (headsetInfo3 != null) {
                    headsetInfo3.setLatency(value[4]);
                    Iterator<T> it4 = this.W.iterator();
                    while (it4.hasNext()) {
                        e.a.g((q9.e) it4.next(), headsetInfo3, false, 2, null);
                    }
                    return;
                }
                return;
            }
            if ((value[2] & 255) != 132) {
                if ((value[2] & 255) == 135) {
                    Iterator<T> it5 = this.W.iterator();
                    while (it5.hasNext()) {
                        ((q9.e) it5.next()).o2(AbstractDataInteractionControllerKt.a(new byte[]{value[9], value[8], value[7], value[6], value[5], value[4]}, ":"), AbstractDataInteractionControllerKt.a(new byte[]{value[15], value[14], value[13], value[12], value[11], value[10]}, ":"));
                    }
                    return;
                }
                return;
            }
            HeadsetInfo headsetInfo4 = this.X;
            if (headsetInfo4 != null) {
                headsetInfo4.setEqMode(value[4]);
                Iterator<T> it6 = this.W.iterator();
                while (it6.hasNext()) {
                    e.a.a((q9.e) it6.next(), headsetInfo4, false, 2, null);
                }
            }
        }
    }

    public final void l2() {
        HeadsetInfo headsetInfo = this.X;
        if (headsetInfo != null) {
            Iterator<T> it2 = this.W.iterator();
            while (it2.hasNext()) {
                ((q9.e) it2.next()).N0(headsetInfo);
            }
        }
    }

    public final String m2(byte b10, byte b11) {
        return (b10 >> 4) + j3.b.f36044h + (b10 & 15) + j3.b.f36044h + (b11 >> 4) + j3.b.f36044h + (b11 & 15);
    }

    @Override // com.flydigi.sdk.bluetooth.c0, com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void n0(@k Object obj) {
        f0.p(obj, "obj");
        super.n0(obj);
        if (!(obj instanceof q9.e) || this.W.contains(obj)) {
            return;
        }
        this.W.add(obj);
    }

    public final void n2() {
        AbstractDataInteractionController.R0(this, new byte[]{-2, -17, 1, 0}, null, 2, null);
    }

    public final void o2() {
        AbstractDataInteractionController.R0(this, new byte[]{-2, -17, 4, 0}, null, 2, null);
    }

    public final void p2() {
        AbstractDataInteractionController.R0(this, new byte[]{-2, -17, 0, 0}, null, 2, null);
    }

    public final void q2() {
        AbstractDataInteractionController.R0(this, new byte[]{-2, -17, 2, 0}, null, 2, null);
    }

    public final void r2() {
        AbstractDataInteractionController.R0(this, new byte[]{-2, -17, 7, 0}, null, 2, null);
    }

    public final void s2() {
        AbstractDataInteractionController.R0(this, new byte[]{-2, -17, 6, 0}, null, 2, null);
    }

    public final void t2(int i10) {
        AbstractDataInteractionController.R0(this, new byte[]{-2, -17, 5, 1, (byte) i10}, null, 2, null);
    }

    public final void u2(int i10) {
        AbstractDataInteractionController.R0(this, new byte[]{-2, -17, 3, 1, (byte) i10}, null, 2, null);
    }
}
