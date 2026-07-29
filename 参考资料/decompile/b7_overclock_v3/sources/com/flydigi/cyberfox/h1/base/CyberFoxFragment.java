package com.flydigi.cyberfox.h1.base;

import android.bluetooth.BluetoothDevice;
import android.os.Message;
import android.os.SystemClock;
import com.flydigi.cyberfox.h1.services.b;
import g.n0;
import i6.a;
import java.util.HashMap;
import k6.g;
import o5.h;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CyberFoxFragment extends ServiceFragment implements g.c {
    public static final String C8 = "CyberFoxFragment";
    public long A8;
    public boolean B8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public g f14114v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public int f14115w8 = -1;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public Boolean f14116x8 = Boolean.FALSE;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public int f14117y8 = 1;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public final boolean f14118z8 = false;

    public void A6(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当前信号强度为");
        sb2.append(i10);
        sb2.append(" dBm");
    }

    public void B6(double d10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("upgrade percentage:");
        sb2.append(d10);
    }

    public void C6(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("upgrade step:");
        sb2.append(i10);
    }

    public void D6(int i10) {
        b bVar = this.f14120o8;
        if (bVar == null || !bVar.g()) {
            return;
        }
        this.f14114v8.V(i10);
    }

    public void E6(boolean z10) {
        b bVar = this.f14120o8;
        if (bVar == null || !bVar.g()) {
            return;
        }
        this.f14114v8.W(z10);
    }

    public void F6(boolean z10) {
        this.B8 = z10;
        n6();
    }

    public void G6(long j10) {
        this.A8 = j10;
    }

    public void H6() {
    }

    @Override // k6.g.c
    public void K0(@n0 String str, String str2) {
        HashMap map = new HashMap(1);
        map.put("errorMessage", str2);
        u9.g.a().e(X1(), "Headset_Gaia_Error", map);
    }

    @Override // k6.g.c
    public void U0() {
    }

    @Override // k6.g.c
    public boolean a(byte[] bArr) {
        b bVar = this.f14120o8;
        return bVar != null && bVar.a(bArr);
    }

    @Override // k6.g.c
    public void a0(@n0 String str) {
        HashMap map = new HashMap(1);
        map.put("errorMessage", "指令发送失败");
        u9.g.a().e(X1(), "Headset_Gaia_Error", map);
    }

    @Override // k6.g.c
    public void d(int i10) {
        A6(i10);
    }

    @Override // com.flydigi.cyberfox.h1.base.ServiceFragment
    public void e6(Message message) {
        switch (message.what) {
            case -1:
                p6(((Integer) message.obj).intValue());
                break;
            case 0:
                int iIntValue = ((Integer) message.obj).intValue();
                String str = iIntValue == 2 ? "CONNECTED" : iIntValue == 1 ? "CONNECTING" : iIntValue == 3 ? "DISCONNECTING" : iIntValue == 0 ? "DISCONNECTED" : h.f42757n;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Handle a message from Bluetooth service: ");
                sb2.append("CONNECTION_STATE_HAS_CHANGED: ");
                sb2.append(str);
                v6(iIntValue);
                if (iIntValue == 2) {
                    m6();
                } else if (iIntValue == 0) {
                    G5().removeCallbacks(this.f14125t8);
                    G5().postDelayed(this.f14125t8, 1000L);
                }
                break;
            case 1:
                int iIntValue2 = ((Integer) message.obj).intValue();
                u6(iIntValue2);
                String str2 = iIntValue2 == 12 ? "BONDED" : iIntValue2 == 11 ? "BONDING" : "BOND NONE";
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Handle a message from Bluetooth service: ");
                sb3.append("DEVICE_BOND_STATE_HAS_CHANGED: ");
                sb3.append(str2);
                break;
            case 2:
                ((n6.b) message.obj).f41955b.j();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Handle a message from Bluetooth service: ");
                sb4.append("GATT_SUPPORT");
                break;
            case 3:
                this.f14114v8.q((byte[]) message.obj);
                break;
            case 4:
                n6();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Handle a message from Bluetooth service: ");
                sb5.append("GAIA_READY");
                break;
            case 5:
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Handle a message from Bluetooth service: ");
                sb6.append("GATT_READY");
                break;
            case 6:
                int i10 = message.arg1;
                q6(i10, message.obj);
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Handle a message from Bluetooth service: ");
                sb7.append("GATT_MESSAGE > ");
                sb7.append(i10);
                break;
            default:
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Handle a message from Bluetooth service: ");
                sb8.append("UNKNOWN MESSAGE: ");
                sb8.append(message.what);
                break;
        }
    }

    @Override // k6.g.c
    public void f1(@n0 String str) {
        HashMap map = new HashMap(1);
        map.put("errorMessage", "指令发送超时");
        u9.g.a().e(X1(), "Headset_Gaia_Error", map);
    }

    @Override // com.flydigi.cyberfox.h1.base.ServiceFragment
    public void h6() {
        v6(this.f14120o8.C());
        u6(this.f14120o8.x());
    }

    @Override // com.flydigi.cyberfox.h1.base.ServiceFragment
    public void i6() {
        this.f14114v8 = new g(this, d6() != 1 ? 0 : 1);
        m6();
        v6(this.f14120o8.C());
        u6(this.f14120o8.x());
        n6();
    }

    @Override // k6.g.c
    public void l0(int i10) {
        x6(i10);
    }

    public void l6(int i10) {
    }

    public final void m6() {
        BluetoothDevice bluetoothDeviceU = this.f14120o8.u();
        w6(bluetoothDeviceU == null ? "" : bluetoothDeviceU.getName());
    }

    @Override // k6.g.c
    public void n(int i10) {
        y6(i10);
    }

    public final void n6() {
        b bVar;
        if (this.B8 && (bVar = this.f14120o8) != null && bVar.C() == 2 && this.f14120o8.g()) {
            this.f14114v8.I(6);
            this.f14114v8.I(5);
            this.f14114v8.I(4);
        }
    }

    public final void o6(boolean z10) {
        if (z10 && !this.f14120o8.O(true)) {
            this.f14114v8.J(2, true);
        } else {
            if (z10) {
                return;
            }
            this.f14120o8.O(false);
            this.f14114v8.J(2, false);
        }
    }

    public void p6(int i10) {
    }

    public void q6(int i10, Object obj) {
        if (i10 == 2) {
            d(((Integer) obj).intValue());
        } else if (i10 == 11) {
            ((Integer) obj).intValue();
        }
    }

    @Override // k6.g.c
    public void r(boolean z10) {
        if (z10) {
            t6((this.f14115w8 * 100) / a.f31860d);
        }
    }

    public void r6(jg.b bVar) {
    }

    @Override // k6.g.c
    public void s(boolean z10) {
        z6(Boolean.valueOf(z10));
    }

    public void s6(int i10, Object obj) {
        if (i10 == 0) {
            H6();
            return;
        }
        if (i10 == 1) {
            l6(((Integer) obj).intValue());
            return;
        }
        if (i10 == 2) {
            int iIntValue = ((Integer) obj).intValue();
            if (iIntValue == 0 && this.A8 == 0) {
                this.A8 = SystemClock.elapsedRealtime();
            }
            C6(iIntValue);
            return;
        }
        if (i10 == 3) {
            this.A8 = 0L;
            r6((jg.b) obj);
        } else {
            if (i10 != 4) {
                return;
            }
            B6(((Double) obj).doubleValue());
        }
    }

    public void t6(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当前电量为");
        sb2.append(i10);
    }

    public void u6(int i10) {
    }

    @Override // k6.g.c
    public void v0(int i10) {
        this.f14115w8 = i10;
        t6((i10 * 100) / a.f31860d);
    }

    public void v6(int i10) {
    }

    @Override // k6.g.c
    public void w0() {
    }

    public void w6(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当前已连接");
        sb2.append(str);
    }

    public void x6(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Firmware Version: ");
        sb2.append(i10);
    }

    public void y6(int i10) {
        this.f14117y8 = i10;
        String str = i10 != 0 ? i10 != 1 ? i10 != 2 ? "unknown" : "180ms" : "110ms" : "50ms";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当前耳机延迟为");
        sb2.append(str);
    }

    public void z6(Boolean bool) {
        this.f14116x8 = bool;
        bool.booleanValue();
    }
}
