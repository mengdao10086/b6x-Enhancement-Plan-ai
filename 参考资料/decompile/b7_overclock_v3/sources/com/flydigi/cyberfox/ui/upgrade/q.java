package com.flydigi.cyberfox.ui.upgrade;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.cyberfox.R;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.text.u;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFzOtaActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FzOtaActivity.kt\ncom/flydigi/cyberfox/ui/upgrade/FzOtaActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,202:1\n766#2:203\n857#2,2:204\n1855#2,2:206\n*S KotlinDebug\n*F\n+ 1 FzOtaActivity.kt\ncom/flydigi/cyberfox/ui/upgrade/FzOtaActivity\n*L\n93#1:203\n93#1:204,2\n93#1:206,2\n*E\n"})
public abstract class q extends uf.c implements e0, AdapterView.OnItemClickListener {

    @yt.l
    public String Tb;
    public h6.g Ub;

    @yt.k
    public String Vb = "all";
    public vf.a Wb;

    public static final void p7(List devices, q this$0) {
        vf.a aVar;
        f0.p(devices, "$devices");
        f0.p(this$0, "this$0");
        ArrayList<BleDevice> arrayList = new ArrayList();
        Iterator it2 = devices.iterator();
        while (true) {
            aVar = null;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            String name = ((BleDevice) next).F().getName();
            f0.o(name, "it.device.name");
            if (u.v2(name, "X1_OTA", false, 2, null)) {
                arrayList.add(next);
            }
        }
        for (BleDevice bleDevice : arrayList) {
            vf.a aVar2 = this$0.Wb;
            if (aVar2 == null) {
                f0.S("mAdapter");
                aVar2 = null;
            }
            aVar2.a(bleDevice.F(), bleDevice.S());
        }
        vf.a aVar3 = this$0.Wb;
        if (aVar3 == null) {
            f0.S("mAdapter");
        } else {
            aVar = aVar3;
        }
        if (aVar.getCount() >= 2) {
            this$0.b4().removeCallbacks(new n(this$0));
            this$0.b4().post(new n(this$0));
        }
    }

    public static final void q7(q this$0) {
        f0.p(this$0, "this$0");
        this$0.m4("升级成功");
        h6.g gVar = this$0.Ub;
        if (gVar == null) {
            f0.S("viewBinding");
            gVar = null;
        }
        ConstraintLayout constraintLayout = gVar.f30586c;
        f0.o(constraintLayout, "viewBinding.areaProgress");
        o5.c.b(constraintLayout, Boolean.FALSE, false, 2, null);
        h6.g gVar2 = this$0.Ub;
        if (gVar2 == null) {
            f0.S("viewBinding");
            gVar2 = null;
        }
        LinearLayout linearLayout = gVar2.f30585b;
        f0.o(linearLayout, "viewBinding.areaDevice");
        o5.c.b(linearLayout, Boolean.TRUE, false, 2, null);
    }

    public static final void r7(q this$0) {
        f0.p(this$0, "this$0");
        h6.g gVar = this$0.Ub;
        if (gVar == null) {
            f0.S("viewBinding");
            gVar = null;
        }
        ConstraintLayout constraintLayout = gVar.f30586c;
        f0.o(constraintLayout, "viewBinding.areaProgress");
        o5.c.b(constraintLayout, Boolean.TRUE, false, 2, null);
        h6.g gVar2 = this$0.Ub;
        if (gVar2 == null) {
            f0.S("viewBinding");
            gVar2 = null;
        }
        LinearLayout linearLayout = gVar2.f30585b;
        f0.o(linearLayout, "viewBinding.areaDevice");
        o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
    }

    public static final void t7(q this$0) {
        f0.p(this$0, "this$0");
        vf.a aVar = this$0.Wb;
        if (aVar == null) {
            f0.S("mAdapter");
            aVar = null;
        }
        aVar.b();
        this$0.b4().postDelayed(new n(this$0), 5000L);
    }

    public static final void u7(q this$0) {
        f0.p(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("result_file_path", this$0.Tb);
        z1 z1Var = z1.f38230a;
        this$0.n6(-1, intent);
        this$0.o6();
    }

    @Override // uf.c
    public void Z5() {
        super.Z5();
        v7(false);
    }

    @Override // uf.c
    public void a6() {
        super.a6();
        q9.f.H();
    }

    @Override // uf.c
    public void c6() {
        super.c6();
        v7(false);
    }

    @Override // uf.c
    public void e6() {
        super.e6();
        v7(false);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.cf_activity_upgrade_firmware;
    }

    @Override // uf.c
    public void g6() {
        super.g6();
        v7(false);
    }

    @Override // uf.c
    public void h6() {
        super.h6();
        v7(false);
    }

    @Override // uf.c
    public void i6() {
        super.i6();
        c4().f(new Runnable() { // from class: com.flydigi.cyberfox.ui.upgrade.m
            @Override // java.lang.Runnable
            public final void run() {
                q.q7(this.f14283a);
            }
        }, 5000L);
        if (S5()) {
            q9.f.G(this, 2);
        }
    }

    @Override // uf.c
    public void l6() {
        runOnUiThread(new Runnable() { // from class: com.flydigi.cyberfox.ui.upgrade.k
            @Override // java.lang.Runnable
            public final void run() {
                q.r7(this.f14281a);
            }
        });
    }

    @Override // uf.a, com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // uf.c, com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        getWindow().addFlags(128);
        super.onCreate(bundle);
        q9.f.u(this);
        e4();
        h6.g gVar = this.Ub;
        h6.g gVar2 = null;
        if (gVar == null) {
            f0.S("viewBinding");
            gVar = null;
        }
        gVar.f30587d.setOnItemClickListener(this);
        this.C1.setText(R.string.cf_upgrade_firmware);
        this.Tb = getIntent().getStringExtra("ota_file");
        String stringExtra = getIntent().getStringExtra("key_device_code");
        if (stringExtra == null) {
            stringExtra = "all";
        }
        this.Vb = stringExtra;
        this.Wb = new vf.a(this);
        h6.g gVar3 = this.Ub;
        if (gVar3 == null) {
            f0.S("viewBinding");
            gVar3 = null;
        }
        ListView listView = gVar3.f30587d;
        vf.a aVar = this.Wb;
        if (aVar == null) {
            f0.S("mAdapter");
            aVar = null;
        }
        listView.setAdapter((ListAdapter) aVar);
        com.bumptech.glide.h<Drawable> hVarN = com.bumptech.glide.b.H(this).p(Integer.valueOf(R.drawable.cf_firmware_upgrade_progress));
        h6.g gVar4 = this.Ub;
        if (gVar4 == null) {
            f0.S("viewBinding");
        } else {
            gVar2 = gVar4;
        }
        hVarN.s1(gVar2.f30588e);
    }

    @Override // uf.c, com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        q9.f.I(this);
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(@yt.l AdapterView<?> adapterView, @yt.l View view, int i10, long j10) {
        if (S5()) {
            if (adapterView != null) {
                int childCount = adapterView.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    adapterView.getChildAt(i11).setSelected(false);
                }
            }
            if (view != null) {
                view.setSelected(true);
            }
            vf.a aVar = this.Wb;
            if (aVar == null) {
                f0.S("mAdapter");
                aVar = null;
            }
            BluetoothDevice bluetoothDeviceC = aVar.getItem(i10);
            wf.g.a(this);
            Intent intent = new Intent();
            intent.putExtra(uf.d.I7, bluetoothDeviceC);
            z1 z1Var = z1.f38230a;
            m6(-1, intent);
            if (s5()) {
                F6();
            }
        }
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        q9.f.H();
        if (isFinishing()) {
            wf.g.a(this);
        }
        super.onPause();
    }

    @Override // uf.c, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (S5()) {
            q9.f.G(this, 2);
        }
    }

    @Override // uf.c
    public void p6() {
        v7(false);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void q1(@yt.k final List<BleDevice> devices) {
        f0.p(devices, "devices");
        e0.a.a(this, devices);
        runOnUiThread(new Runnable() { // from class: com.flydigi.cyberfox.ui.upgrade.p
            @Override // java.lang.Runnable
            public final void run() {
                q.p7(devices, this);
            }
        });
    }

    @Override // uf.c
    public void q6() {
        runOnUiThread(new Runnable() { // from class: com.flydigi.cyberfox.ui.upgrade.o
            @Override // java.lang.Runnable
            public final void run() {
                q.u7(this.f14285a);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
        e0.a.d(this);
    }

    public final void s7() {
        q9.f.H();
        vf.a aVar = this.Wb;
        if (aVar == null) {
            f0.S("mAdapter");
            aVar = null;
        }
        if (aVar.isEmpty()) {
            v7(true);
        }
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        h6.g gVarC = h6.g.c(getLayoutInflater());
        f0.o(gVarC, "inflate(layoutInflater)");
        this.Ub = gVarC;
        if (gVarC == null) {
            f0.S("viewBinding");
            gVarC = null;
        }
        setContentView(gVarC.getRoot());
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
        e0.a.c(this);
        runOnUiThread(new Runnable() { // from class: com.flydigi.cyberfox.ui.upgrade.l
            @Override // java.lang.Runnable
            public final void run() {
                q.t7(this.f14282a);
            }
        });
    }

    public final void v7(boolean z10) {
        FirmwareUpgradeResultActivity.G7.a(this, this.Vb, z10);
        finish();
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(int i10) {
        e0.a.b(this, i10);
        v7(false);
    }
}
