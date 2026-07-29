package com.iir_eq.ui.activity;

import android.content.Context;
import android.content.Intent;
import com.flydigi.cyberfox.R;
import com.flydigi.cyberfox.ui.upgrade.q;
import rf.b;
import tf.a;
import wf.g;

/* JADX INFO: loaded from: classes7.dex */
public class LeOtaActivity extends q implements b {
    public static final String Yb = "ble_ota_device_name";
    public static final String Zb = "ble_ota_device_addr";
    public qf.b Xb;

    public static void y7(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) LeOtaActivity.class);
        intent.putExtra("key_device_code", str);
        intent.putExtra("ota_file", str2);
        context.startActivity(intent);
    }

    @Override // uf.c, rf.a
    public void A2(boolean z10) {
        if (this.P7) {
            return;
        }
        if (z10) {
            w7();
        } else {
            super.A2(z10);
        }
    }

    @Override // uf.c
    public int B5(int i10) {
        return this.f52048c8;
    }

    @Override // uf.c
    public void J6(String str) {
        g.d(this, Zb, str);
    }

    @Override // uf.c
    public void K6(String str) {
        g.d(this, Yb, str);
    }

    @Override // uf.c
    public void M5() {
        super.M5();
        qf.b bVar = new qf.b();
        this.Xb = bVar;
        bVar.j(this);
    }

    @Override // rf.b
    public void Q2(int i10) {
        if (i10 == 0) {
            super.r6();
            u6(10L);
        }
    }

    @Override // uf.c
    public synchronized boolean Q6(byte[] bArr) {
        if (this.P7) {
            return true;
        }
        if (this.Xb.A(bArr)) {
            this.f52051d8 = false;
            return true;
        }
        this.f52065j8++;
        return false;
    }

    @Override // uf.c
    public boolean R5() {
        return true;
    }

    @Override // rf.b
    public void V(int i10) {
        if (this.P7) {
            return;
        }
        if (!this.Xb.z(a.f51255g, a.f51256h)) {
            d7(R.string.ota_error_service_uuid);
            O6(129, 1000L);
        } else if (this.Xb.y(512)) {
            d7(R.string.configing_mtu);
        } else {
            x7();
        }
    }

    @Override // uf.c
    public String W5() {
        return g.b(this, Zb, "--").toString();
    }

    @Override // uf.c
    public String X5() {
        return g.b(this, Yb, "--").toString();
    }

    @Override // rf.b
    public void b2(int i10, int i11) {
        if (this.P7) {
            return;
        }
        if (i10 == 0) {
            this.f52048c8 = i11;
            d7(R.string.config_mtu_successfully);
        } else {
            d7(R.string.config_mtu_failed);
        }
        x7();
    }

    @Override // rf.b
    public void g0(int i10) {
        if (this.P7 || i10 != 0) {
            return;
        }
        super.A2(true);
    }

    @Override // com.flydigi.cyberfox.ui.upgrade.q, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        qf.b bVar;
        super.onPause();
        if (!isFinishing() || (bVar = this.Xb) == null) {
            return;
        }
        bVar.x(this);
        this.Xb.k();
    }

    @Override // uf.c
    public void u5() {
        if (this.P7) {
            return;
        }
        if (!this.Xb.l(this, this.O7)) {
            this.Xb.k();
        } else {
            this.f52065j8 = 0L;
            b6();
        }
    }

    @Override // uf.c
    public void w5() {
        qf.b bVar = this.Xb;
        if (bVar != null) {
            bVar.k();
        }
    }

    @Override // uf.c
    public void w6(int i10) {
        Intent intent = new Intent(this, (Class<?>) LeScanActivity.class);
        intent.putExtra(LeScanActivity.R7, 1);
        startActivityForResult(intent, i10);
    }

    public final void w7() {
        if (this.P7 || this.Xb.n()) {
            return;
        }
        this.Xb.k();
        d7(R.string.discover_services_error);
    }

    public final void x7() {
        if (this.P7 || this.Xb.o(a.f51255g, a.f51256h, a.f51257i)) {
            return;
        }
        this.Xb.w();
        this.Xb.k();
    }

    @Override // uf.c
    public String y5() {
        return "LeOtaActivity";
    }
}
