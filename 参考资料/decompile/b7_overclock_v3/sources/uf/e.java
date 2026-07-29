package uf;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.flydigi.cyberfox.ui.upgrade.q;
import wf.g;

/* JADX INFO: loaded from: classes7.dex */
public class e extends q implements rf.a {
    public static final String Zb = "spp_ota_device_name";

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    public static final String f52120ac = "spp_ota_device_addr";
    public qf.d Xb;
    public final BroadcastReceiver Yb = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            wf.e.g(e.this.K2, "onReceive " + intent);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                e.this.A7((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10));
            }
        }
    }

    @Override // uf.c, rf.a
    public void A2(boolean z10) {
        if (this.P7) {
            return;
        }
        super.A2(z10);
    }

    public final void A7(BluetoothDevice bluetoothDevice, int i10) {
        wf.e.g(this.K2, "onReceiveBondState " + i10 + "; device to connect " + this.O7 + "; bond changed device " + bluetoothDevice);
        if (bluetoothDevice.equals(this.O7)) {
            if (i10 == 12) {
                z7();
            } else if (i10 == 10) {
                y7();
            }
        }
    }

    @Override // uf.c
    public int B5(int i10) {
        if (i10 == 1) {
            int i11 = this.f52048c8;
            if (i11 <= 661 && i11 > 0 && i11 < 661) {
                return i11;
            }
            return 661;
        }
        int i12 = this.f52048c8;
        if (i12 <= 512 && i12 > 0 && i12 < 512) {
            return i12;
        }
        return 512;
    }

    public final void B7() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        registerReceiver(this.Yb, intentFilter);
    }

    @Override // uf.c
    public void J6(String str) {
        g.d(this, f52120ac, str);
    }

    @Override // uf.c
    public void K6(String str) {
        g.d(this, Zb, str);
    }

    @Override // uf.c
    public void M5() {
        super.M5();
        qf.d dVarK = qf.d.k();
        this.Xb = dVarK;
        dVarK.h(this);
        B7();
    }

    @Override // uf.c
    public boolean Q6(byte[] bArr) {
        if (!this.P7) {
            if (this.Xb.o(bArr)) {
                r6();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("sendData: +++++++++");
                sb2.append(wf.a.o(bArr));
                r4(this.K2, "sendData mConnector.write(data  , isResponse) send true mWritten reset to false length" + bArr.length + " data:  " + wf.a.o(bArr));
                return true;
            }
            r4(this.K2, "sendData mConnector.write(data) return false failCount = " + this.f52065j8);
        }
        return false;
    }

    @Override // uf.c
    public boolean R5() {
        return false;
    }

    @Override // uf.c
    public String W5() {
        return g.b(this, f52120ac, "--").toString();
    }

    @Override // uf.c
    public String X5() {
        return g.b(this, Zb, "--").toString();
    }

    @Override // com.flydigi.cyberfox.ui.upgrade.q, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            unregisterReceiver(this.Yb);
            qf.d dVar = this.Xb;
            if (dVar != null) {
                dVar.n(this);
                this.Xb.j();
            }
        }
    }

    @Override // uf.c
    public void r6() {
        super.r6();
        boolean zBooleanValue = ((Boolean) g.b(getApplicationContext(), tf.a.G, Boolean.TRUE)).booleanValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(zBooleanValue);
        sb2.append("");
        boolean zBooleanValue2 = ((Boolean) g.b(getApplicationContext(), tf.a.M, Boolean.FALSE)).booleanValue();
        if (!zBooleanValue || zBooleanValue2) {
            return;
        }
        u6(100L);
    }

    @Override // uf.c
    public void u5() {
        if (this.P7) {
            return;
        }
        x7();
    }

    @Override // uf.c
    public void w5() {
        qf.d dVar = this.Xb;
        if (dVar != null) {
            dVar.j();
        }
    }

    @Override // uf.c
    public void w6(int i10) {
        startActivityForResult(new Intent(this, (Class<?>) b.class), i10);
    }

    public final void x7() {
        boolean zBooleanValue = ((Boolean) g.b(getApplicationContext(), tf.a.G, Boolean.TRUE)).booleanValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(zBooleanValue);
        sb2.append("");
        if (this.P7 || !this.Xb.i(this.O7, zBooleanValue)) {
            return;
        }
        b6();
    }

    @Override // uf.c
    public String y5() {
        return "SppOtaActivity";
    }

    public final void y7() {
    }

    public final void z7() {
    }
}
