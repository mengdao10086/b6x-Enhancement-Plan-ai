package s9;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionController;
import com.flydigi.sdk.bluetooth.AbstractDataInteractionControllerKt;
import com.flydigi.sdk.bluetooth.o;
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
@t0({"SMAP\nCyberfoxDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CyberfoxDataInteractionController.kt\ncom/flydigi/sdk/headset/controller/CyberfoxDataInteractionController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n1855#2,2:225\n1855#2,2:227\n1855#2,2:229\n1855#2,2:231\n1855#2,2:233\n1855#2,2:235\n1#3:237\n*S KotlinDebug\n*F\n+ 1 CyberfoxDataInteractionController.kt\ncom/flydigi/sdk/headset/controller/CyberfoxDataInteractionController\n*L\n73#1:225,2\n83#1:227,2\n91#1:229,2\n99#1:231,2\n105#1:233,2\n151#1:235,2\n*E\n"})
public final class e extends o {

    @k
    public ArrayList<q9.e> L;

    @l
    public HeadsetInfo M;

    @l
    public r9.a N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@k Context mContext, @k u filter) {
        super(mContext, filter, 1);
        f0.p(mContext, "mContext");
        f0.p(filter, "filter");
        this.L = new ArrayList<>();
    }

    public static final void w1(e this$0) {
        f0.p(this$0, "this$0");
        this$0.D1();
    }

    public static final void x1(e this$0) {
        f0.p(this$0, "this$0");
        this$0.B1();
    }

    public static final void y1(e this$0) {
        f0.p(this$0, "this$0");
        this$0.E1();
    }

    public static final void z1(e this$0) {
        f0.p(this$0, "this$0");
        this$0.C1();
    }

    public final String A1(byte b10, byte b11) {
        return (b10 >> 4) + j3.b.f36044h + (b10 & 15) + j3.b.f36044h + (b11 >> 4) + j3.b.f36044h + (b11 & 15);
    }

    public final void B1() {
        r9.a aVar = this.N;
        if (aVar != null) {
            AbstractDataInteractionController.R0(this, aVar.d(), null, 2, null);
        }
    }

    public final void C1() {
        r9.a aVar = this.N;
        if (aVar != null) {
            AbstractDataInteractionController.R0(this, aVar.a(), null, 2, null);
        }
    }

    public final void D1() {
        r9.a aVar = this.N;
        if (aVar != null) {
            AbstractDataInteractionController.R0(this, aVar.i(), null, 2, null);
        }
    }

    public final void E1() {
        r9.a aVar = this.N;
        if (aVar != null) {
            AbstractDataInteractionController.R0(this, aVar.c(), null, 2, null);
        }
    }

    public final void F1() {
        r9.a aVar = this.N;
        if (aVar != null) {
            AbstractDataInteractionController.R0(this, aVar.f(), null, 2, null);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void G0(@k Object obj) {
        f0.p(obj, "obj");
        super.G0(obj);
        if ((obj instanceof q9.e) && this.L.contains(obj)) {
            this.L.remove(obj);
        }
    }

    public final void G1() {
        r9.a aVar = this.N;
        if (aVar != null) {
            AbstractDataInteractionController.R0(this, aVar.g(), null, 2, null);
        }
    }

    public final void H1(int i10) {
        r9.a aVar = this.N;
        if (aVar != null) {
            AbstractDataInteractionController.R0(this, aVar.b(i10), null, 2, null);
        }
    }

    public final void I1(int i10) {
        r9.a aVar = this.N;
        if (aVar != null) {
            AbstractDataInteractionController.R0(this, aVar.h(i10), null, 2, null);
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    @k
    public UUID X0() {
        HeadsetInfo headsetInfo = this.M;
        if (f0.g(headsetInfo != null ? headsetInfo.getDeviceCode() : null, q9.c.f47168e)) {
            UUID uuidFromString = UUID.fromString("0000feef-0000-1000-8000-00805F9B34FB");
            f0.o(uuidFromString, "fromString(\"0000feef-0000-1000-8000-00805F9B34FB\")");
            return uuidFromString;
        }
        UUID uuidFromString2 = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        f0.o(uuidFromString2, "fromString(\"00001101-0000-1000-8000-00805F9B34FB\")");
        return uuidFromString2;
    }

    @Override // com.flydigi.sdk.bluetooth.o, com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void Z0(@k UUID uuid, @k byte[] value) {
        f0.p(uuid, "uuid");
        f0.p(value, "value");
        super.Z0(uuid, value);
        if ((value[0] & 255) == 254 && (value[1] & 255) == 239) {
            if ((value[2] & 255) == 128) {
                HeadsetInfo headsetInfo = this.M;
                if (headsetInfo != null) {
                    headsetInfo.setFirmwareLeft(A1(value[4], value[5]));
                    headsetInfo.setFirmwareRight(A1(value[6], value[7]));
                    headsetInfo.setFirmwareBox(A1(value[8], value[9]));
                    Iterator<T> it2 = this.L.iterator();
                    while (it2.hasNext()) {
                        ((q9.e) it2.next()).H2(headsetInfo);
                    }
                    return;
                }
                return;
            }
            if ((value[2] & 255) == 129) {
                HeadsetInfo headsetInfo2 = this.M;
                if (headsetInfo2 != null) {
                    headsetInfo2.setBatteryLeft(value[4]);
                    headsetInfo2.setBatteryRight(value[5]);
                    headsetInfo2.setBatteryBox(value[6]);
                    Iterator<T> it3 = this.L.iterator();
                    while (it3.hasNext()) {
                        ((q9.e) it3.next()).p(headsetInfo2);
                    }
                    return;
                }
                return;
            }
            if ((value[2] & 255) == 130) {
                HeadsetInfo headsetInfo3 = this.M;
                if (headsetInfo3 != null) {
                    headsetInfo3.setLatency(value[4]);
                    Iterator<T> it4 = this.L.iterator();
                    while (it4.hasNext()) {
                        e.a.g((q9.e) it4.next(), headsetInfo3, false, 2, null);
                    }
                    return;
                }
                return;
            }
            if ((value[2] & 255) != 132) {
                if ((value[2] & 255) == 135) {
                    Iterator<T> it5 = this.L.iterator();
                    while (it5.hasNext()) {
                        ((q9.e) it5.next()).o2(AbstractDataInteractionControllerKt.a(new byte[]{value[9], value[8], value[7], value[6], value[5], value[4]}, ":"), AbstractDataInteractionControllerKt.a(new byte[]{value[15], value[14], value[13], value[12], value[11], value[10]}, ":"));
                    }
                    return;
                }
                return;
            }
            HeadsetInfo headsetInfo4 = this.M;
            if (headsetInfo4 != null) {
                headsetInfo4.setEqMode(value[4]);
                Iterator<T> it6 = this.L.iterator();
                while (it6.hasNext()) {
                    e.a.a((q9.e) it6.next(), headsetInfo4, false, 2, null);
                }
            }
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void a1(@k BluetoothDevice device) {
        f0.p(device, "device");
        String address = device.getAddress();
        f0.o(address, "it.address");
        String name = device.getName();
        q9.g gVar = q9.g.f47181a;
        String name2 = device.getName();
        f0.o(name2, "it.name");
        HeadsetInfo headsetInfo = new HeadsetInfo(address, name, true, gVar.a(name2), null, null, null, 0, 0, 0, 0, 0, 4080, null);
        this.M = headsetInfo;
        l9.a.c("deviceCode: " + headsetInfo.getDeviceCode());
        HeadsetInfo headsetInfo2 = this.M;
        r9.a bVar = null;
        String deviceCode = headsetInfo2 != null ? headsetInfo2.getDeviceCode() : null;
        if (deviceCode != null) {
            int iHashCode = deviceCode.hashCode();
            if (iHashCode != -639242794) {
                if (iHashCode != 3769) {
                    if (iHashCode == 203009350 && deviceCode.equals(q9.c.f47167d)) {
                        bVar = new r9.c();
                    }
                } else if (deviceCode.equals(q9.c.f47168e)) {
                    bVar = new r9.d();
                }
            } else if (deviceCode.equals(q9.c.f47166c)) {
                bVar = new r9.b();
            }
        }
        this.N = bVar;
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void e0(@l BluetoothDevice bluetoothDevice) {
        super.e0(bluetoothDevice);
        HeadsetInfo headsetInfo = this.M;
        if (headsetInfo == null) {
            return;
        }
        headsetInfo.setConnected(false);
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractBluetoothController
    public void n0(@k Object obj) {
        f0.p(obj, "obj");
        super.n0(obj);
        if (!(obj instanceof q9.e) || this.L.contains(obj)) {
            return;
        }
        this.L.add(obj);
    }

    @Override // com.flydigi.sdk.bluetooth.o
    public void n1() {
        super.n1();
        P().postDelayed(new Runnable() { // from class: s9.b
            @Override // java.lang.Runnable
            public final void run() {
                e.w1(this.f49535a);
            }
        }, 500L);
        P().postDelayed(new Runnable() { // from class: s9.a
            @Override // java.lang.Runnable
            public final void run() {
                e.x1(this.f49534a);
            }
        }, 600L);
        P().postDelayed(new Runnable() { // from class: s9.d
            @Override // java.lang.Runnable
            public final void run() {
                e.y1(this.f49537a);
            }
        }, 700L);
        P().postDelayed(new Runnable() { // from class: s9.c
            @Override // java.lang.Runnable
            public final void run() {
                e.z1(this.f49536a);
            }
        }, 800L);
        HeadsetInfo headsetInfo = this.M;
        if (headsetInfo != null) {
            Iterator<T> it2 = this.L.iterator();
            while (it2.hasNext()) {
                ((q9.e) it2.next()).N0(headsetInfo);
            }
        }
    }

    public final int v1(@l BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return -1;
        }
        Object objInvoke = bluetoothDevice.getClass().getMethod("getBatteryLevel", new Class[0]).invoke(bluetoothDevice, new Object[0]);
        f0.n(objInvoke, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objInvoke).intValue();
    }
}
