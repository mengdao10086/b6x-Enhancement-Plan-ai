package com.iir_eq.ui.activity;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.flydigi.cyberfox.R;
import com.umeng.socialize.common.SocializeConstants;
import g.n0;
import g.p0;
import java.util.UUID;
import sf.f;

/* JADX INFO: loaded from: classes7.dex */
public class LeScanActivity extends uf.d implements rf.b {
    public static final int N7 = 1;
    public static final byte[] O7 = null;
    public static final byte[] P7 = null;
    public static final byte[] Q7 = null;
    public static final String R7 = "mode";
    public static final int S7 = 1;
    public static final int T7 = 2;
    public static final int U7 = 3;
    public qf.c K7;
    public int L7;
    public final Handler J7 = new Handler();
    public final Runnable M7 = new c();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            f0.b.J(LeScanActivity.this, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            LeScanActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LeScanActivity.this.w4();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21714a;

        public d(boolean z10) {
            this.f21714a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f21714a) {
                LeScanActivity leScanActivity = LeScanActivity.this;
                leScanActivity.m4(leScanActivity.getString(R.string.connect_failed));
            } else {
                if (LeScanActivity.this.K7.e()) {
                    return;
                }
                LeScanActivity.this.K7.b();
            }
        }
    }

    @Override // rf.a
    public void A2(boolean z10) {
        runOnUiThread(new d(z10));
    }

    public final boolean A4() {
        if (Build.VERSION.SDK_INT < 23 || h0.d.a(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        if (f0.b.P(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            new AlertDialog.Builder(this).setMessage(R.string.ble_location_permission_tip).setNegativeButton(R.string.f14112no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.yes, new a()).create().show();
            return false;
        }
        f0.b.J(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
        return false;
    }

    @Override // rf.b
    public void Q2(int i10) {
    }

    @Override // rf.a
    public void T0(byte[] bArr) {
    }

    @Override // uf.d, rf.c
    public void U1() {
        super.U1();
        this.J7.postDelayed(this.M7, 5000L);
    }

    @Override // rf.b
    public void V(int i10) {
        qf.c cVar = this.K7;
        UUID uuid = tf.a.f51249a;
        if (!cVar.l(uuid, tf.a.f51250b)) {
            this.K7.b();
        } else {
            if (this.L7 != 3 || this.K7.f(uuid, tf.a.f51251c, tf.a.f51252d)) {
                return;
            }
            this.K7.b();
        }
    }

    @Override // rf.b
    public void b2(int i10, int i11) {
    }

    @Override // rf.b
    public void g0(int i10) {
    }

    @Override // uf.d, rf.c
    public void h() {
        this.J7.removeCallbacks(this.M7);
        super.h();
    }

    @Override // uf.d
    public boolean o4() {
        if (A4()) {
            return z4();
        }
        return false;
    }

    @Override // uf.d, com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        y4();
    }

    @Override // uf.d, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        if (isFinishing()) {
            this.J7.removeCallbacks(this.M7);
            qf.c cVar = this.K7;
            if (cVar != null) {
                cVar.j(this);
            }
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, @n0 String[] strArr, @n0 int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 != 1 || strArr == null || strArr.length <= 0) {
            return;
        }
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if ("android.permission.ACCESS_COARSE_LOCATION".equals(strArr[i11]) || "android.permission.ACCESS_FINE_LOCATION".equals(strArr[i11])) {
                int i12 = iArr[i11];
            }
        }
    }

    @Override // uf.d
    public boolean p4(BluetoothDevice bluetoothDevice, byte[] bArr) {
        return bluetoothDevice.getName() != null && bluetoothDevice.getName().startsWith("X1_OTA");
    }

    @Override // uf.d
    public sf.b q4() {
        return f.a(this);
    }

    @Override // uf.d
    public void u4(BluetoothDevice bluetoothDevice) {
        int i10 = this.L7;
        if (i10 == 2 || i10 == 3) {
            this.K7.c(this, bluetoothDevice);
        } else if (i10 == 1) {
            Intent intent = new Intent();
            intent.putExtra(uf.d.I7, bluetoothDevice);
            setResult(-1, intent);
            finish();
        }
    }

    public final void y4() {
        int intExtra = getIntent().getIntExtra(R7, 2);
        this.L7 = intExtra;
        if (intExtra == 2 || intExtra == 3) {
            qf.c cVarG = qf.c.g();
            this.K7 = cVarG;
            cVarG.a(this);
        }
    }

    public final boolean z4() {
        if (Build.VERSION.SDK_INT < 23 || ((LocationManager) getSystemService(SocializeConstants.KEY_LOCATION)).isProviderEnabled("gps")) {
            return true;
        }
        new AlertDialog.Builder(this).setMessage(R.string.ble_gps_enable_tip).setNegativeButton(R.string.f14112no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.yes, new b()).create().show();
        return false;
    }
}
