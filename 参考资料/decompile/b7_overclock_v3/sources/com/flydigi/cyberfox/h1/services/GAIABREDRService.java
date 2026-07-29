package com.flydigi.cyberfox.h1.services;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import o5.h;
import o6.c;

/* JADX INFO: loaded from: classes7.dex */
public class GAIABREDRService extends Service implements com.flydigi.cyberfox.h1.services.b, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14129a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14130b = "GAIABREDRService";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Handler> f14131c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBinder f14132d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o6.c f14133e = new o6.c(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f14134f = new b(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f14135g;

    public class a extends Binder {
        public a() {
        }

        public GAIABREDRService a() {
            return GAIABREDRService.this;
        }
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<GAIABREDRService> f14137a;

        public b(GAIABREDRService gAIABREDRService) {
            this.f14137a = new WeakReference<>(gAIABREDRService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f14137a.get().e(message);
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean A() {
        return this.f14135g.U(this);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public int B() {
        return this.f14135g.d0();
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public int C() {
        int iH = this.f14135g.H();
        int i10 = 1;
        if (iH != 1) {
            i10 = 2;
            if (iH != 2) {
                i10 = 3;
                if (iH != 3) {
                    return 0;
                }
            }
        }
        return i10;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void D() {
        this.f14135g.B();
    }

    public final boolean E(int i10, int i11, Object obj) {
        if (!this.f14131c.isEmpty()) {
            for (int i12 = 0; i12 < this.f14131c.size(); i12++) {
                this.f14131c.get(i12).obtainMessage(i10, i11, 0, obj).sendToTarget();
            }
        }
        return !this.f14131c.isEmpty();
    }

    public final boolean F(int i10, Object obj) {
        if (!this.f14131c.isEmpty()) {
            for (int i11 = 0; i11 < this.f14131c.size(); i11++) {
                this.f14131c.get(i11).obtainMessage(i10, obj).sendToTarget();
            }
        }
        return !this.f14131c.isEmpty();
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public n6.b G() {
        return null;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean H() {
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void I() {
        this.f14135g.Y();
    }

    public final void J() {
        unregisterReceiver(this.f14133e);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void K(boolean z10) {
        this.f14135g.c0(z10);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean L() {
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean N() {
        return this.f14135g.e0();
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean O(boolean z10) {
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean a(byte[] bArr) {
        return this.f14135g.V(bArr);
    }

    @Override // o6.c.a
    public void c(BluetoothDevice bluetoothDevice, int i10) {
        BluetoothDevice bluetoothDeviceU = u();
        if (bluetoothDevice == null || bluetoothDeviceU == null || !bluetoothDevice.getAddress().equals(bluetoothDeviceU.getAddress())) {
            return;
        }
        if (this.f14129a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ACTION_BOND_STATE_CHANGED for ");
            sb2.append(bluetoothDevice.getAddress());
            sb2.append(" with bond state ");
            sb2.append(fg.b.a(i10));
        }
        F(1, Integer.valueOf(i10));
        if (i10 == 12) {
            bluetoothDevice.fetchUuidsWithSdp();
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void d(int i10, boolean z10) throws Throwable {
        this.f14135g.g0(i10, z10);
    }

    public final void e(Message message) {
        String str;
        int i10 = message.what;
        if (i10 == 0) {
            int iIntValue = ((Integer) message.obj).intValue();
            if (this.f14129a) {
                String str2 = iIntValue == 2 ? "CONNECTED" : iIntValue == 1 ? "CONNECTING" : iIntValue == 3 ? "DISCONNECTING" : iIntValue == 0 ? "DISCONNECTED" : h.f42757n;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Handle a message from BR/EDR Provider: ");
                sb2.append("CONNECTION_STATE_HAS_CHANGED: ");
                sb2.append(str2);
            }
            h(iIntValue);
            return;
        }
        if (i10 == 1) {
            byte[] bArr = (byte[]) message.obj;
            if (this.f14129a) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Handle a message from BR/EDR Provider: ");
                sb3.append("GAIA_PACKET");
            }
            s(bArr);
            return;
        }
        if (i10 == 2) {
            int iIntValue2 = ((Integer) message.obj).intValue();
            if (iIntValue2 == 0) {
                str = "CONNECTION_FAILED";
            } else if (iIntValue2 == 1) {
                str = "CONNECTION_LOST";
            } else {
                str = "UNKNOWN " + iIntValue2;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Handle a message from BR/EDR Provider: ");
            sb4.append("ERROR: ");
            sb4.append(str);
            q(iIntValue2);
            return;
        }
        if (i10 == 3) {
            if (this.f14129a) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Handle a message from BR/EDR Provider: ");
                sb5.append("GAIA_READY");
            }
            y(4);
            return;
        }
        if (i10 == 4) {
            E(7, message.arg1, message.obj);
            return;
        }
        if (this.f14129a) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Handle a message from BR/EDR Provider: ");
            sb6.append("UNKNOWN MESSAGE: ");
            sb6.append(message.what);
            sb6.append(" obj: ");
            sb6.append(message.obj);
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public int f() {
        return 1;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean g() {
        return this.f14135g.K();
    }

    public final void h(int i10) {
        int i11 = 3;
        if (i10 == 2) {
            i11 = 2;
        } else if (i10 == 1) {
            i11 = 1;
        } else if (i10 != 3) {
            i11 = 0;
        }
        F(0, Integer.valueOf(i11));
        if (i10 == 0 && N()) {
            A();
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean i() {
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean j(int i10) {
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean k(boolean z10) {
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean l() {
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void m(boolean z10) {
        this.f14129a = z10;
        this.f14135g.b0(z10);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean n(byte b10) {
        return false;
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean o() {
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        v();
        return this.f14132d;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.f14135g == null) {
            this.f14135g = new c(this.f14134f, (BluetoothManager) getSystemService(FirmwareUpgradeStatisticsLog.f13300c));
        }
        this.f14135g.X(this.f14129a);
    }

    @Override // android.app.Service
    public void onDestroy() {
        D();
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        J();
        if (this.f14131c.isEmpty() && !N()) {
            D();
        }
        return super.onUnbind(intent);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean p(int i10) {
        return false;
    }

    public final void q(int i10) {
        F(-1, Integer.valueOf(i10));
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public synchronized void r(Handler handler) {
        if (!this.f14131c.contains(handler)) {
            this.f14131c.add(handler);
        }
    }

    public final void s(byte[] bArr) {
        F(3, bArr);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public synchronized void t(Handler handler) {
        if (this.f14131c.contains(handler)) {
            this.f14131c.remove(handler);
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public BluetoothDevice u() {
        return this.f14135g.G();
    }

    public final void v() {
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        registerReceiver(this.f14133e, intentFilter);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public boolean w(String str) {
        if (this.f14135g.H() == 2) {
            return false;
        }
        return this.f14135g.z(str, this);
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public int x() {
        BluetoothDevice bluetoothDeviceU = u();
        if (bluetoothDeviceU != null) {
            return bluetoothDeviceU.getBondState();
        }
        return 10;
    }

    public final boolean y(int i10) {
        if (!this.f14131c.isEmpty()) {
            for (int i11 = 0; i11 < this.f14131c.size(); i11++) {
                this.f14131c.get(i11).obtainMessage(i10).sendToTarget();
            }
        }
        return !this.f14131c.isEmpty();
    }

    @Override // com.flydigi.cyberfox.h1.services.b
    public void z(File file) {
        this.f14135g.k0(file);
    }
}
