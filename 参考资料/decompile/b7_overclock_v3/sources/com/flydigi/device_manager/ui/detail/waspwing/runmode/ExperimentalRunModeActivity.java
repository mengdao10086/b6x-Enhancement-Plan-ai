package com.flydigi.device_manager.ui.detail.waspwing.runmode;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import c7.g;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.common.p;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.runmode.ExperimentalRunModeActivity;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.flydigi.web.WebFragment;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.v0;
import t9.i;
import t9.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class ExperimentalRunModeActivity extends p implements i {

    @k
    public static final a H7 = new a(null);

    @k
    public static final String I7 = "key_mode_opened";

    @k
    public static final String J7 = "key_device_code";
    public boolean E7;
    public boolean F7;
    public boolean G7;
    public g K2;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final Intent a(@k Context context, @k String deviceCode, boolean z10) {
            f0.p(context, "context");
            f0.p(deviceCode, "deviceCode");
            Intent intent = new Intent(context, (Class<?>) ExperimentalRunModeActivity.class);
            intent.putExtra(ExperimentalRunModeActivity.I7, z10).putExtra("key_device_code", deviceCode);
            return intent;
        }
    }

    public static final boolean n4(ExperimentalRunModeActivity this$0, View view, MotionEvent motionEvent) {
        f0.p(this$0, "this$0");
        if (motionEvent.getActionMasked() == 1) {
            if (this$0.E7) {
                this$0.F7 = true;
                this$0.G7 = false;
                j.N(j.f50990a, false, null, null, 6, null);
            } else {
                this$0.p4();
            }
        }
        return true;
    }

    public static final void o4(ExperimentalRunModeActivity this$0, WaspWingInfo waspWingInfo) {
        f0.p(this$0, "this$0");
        f0.p(waspWingInfo, "$waspWingInfo");
        this$0.E7 = waspWingInfo.isExperimentalRunModeOn();
        g gVar = this$0.K2;
        if (gVar == null) {
            f0.S("viewBinding");
            gVar = null;
        }
        gVar.f10037b.setChecked(waspWingInfo.isExperimentalRunModeOn());
    }

    public static final void q4(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void r4(ExperimentalRunModeActivity this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        dialogFragment.I5();
        this$0.F7 = true;
        g gVar = this$0.K2;
        if (gVar == null) {
            f0.S("viewBinding");
            gVar = null;
        }
        boolean zIsChecked = true ^ gVar.f10037b.isChecked();
        this$0.G7 = zIsChecked;
        j.f50990a.M(zIsChecked, Integer.valueOf(WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL), Integer.valueOf(WaspWingInfo.EXPERIMENTAL_RUN_MODE_WIND_LEVEL));
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@k BluetoothDevice bluetoothDevice) {
        i.a.b(this, bluetoothDevice);
    }

    @Override // t9.i
    public void F1(@k final WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        if (this.F7 && this.G7 == waspWingInfo.isExperimentalRunModeOn()) {
            this.F7 = false;
            runOnUiThread(new Runnable() { // from class: i7.d
                @Override // java.lang.Runnable
                public final void run() {
                    ExperimentalRunModeActivity.o4(this.f31879a, waspWingInfo);
                }
            });
        }
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@k BluetoothGatt bluetoothGatt) {
        i.a.e(this, bluetoothGatt);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@k BluetoothDevice bluetoothDevice) {
        i.a.d(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@k BluetoothDevice bluetoothDevice) {
        i.a.c(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_waspwing_experimental_run_mode;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@k BluetoothDevice bluetoothDevice) {
        i.a.a(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        i.a.f(this, i10);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.device_title_waspwing_experimental_mode);
        this.E7 = getIntent().getBooleanExtra(I7, false);
        g gVar = this.K2;
        g gVar2 = null;
        if (gVar == null) {
            f0.S("viewBinding");
            gVar = null;
        }
        gVar.f10037b.setChecked(this.E7);
        g gVar3 = this.K2;
        if (gVar3 == null) {
            f0.S("viewBinding");
        } else {
            gVar2 = gVar3;
        }
        gVar2.f10037b.setOnTouchListener(new View.OnTouchListener() { // from class: i7.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ExperimentalRunModeActivity.n4(this.f31876a, view, motionEvent);
            }
        });
        j.D(this);
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        j.e0(this);
    }

    public final void p4() {
        o5.a.t0(n3(), new FZDialog.a().t(getString(R.string.device_waspwing_experimental_run_mode_warning_title)).j(getString(R.string.device_waspwing_experimental_run_mode_important_info_content)).k(-65536).d(getString(R.string.cancel)).g(getString(R.string.next)).m(10).h(R.color.color_000000_a90).b(Boolean.FALSE).c(new FZDialog.c() { // from class: i7.c
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ExperimentalRunModeActivity.q4(dialogFragment);
            }
        }).f(new FZDialog.c() { // from class: i7.b
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ExperimentalRunModeActivity.r4(this.f31877a, dialogFragment);
            }
        }).a());
    }

    @Override // t9.i
    public void q2(@k byte[] bArr) {
        i.a.g(this, bArr);
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        g gVarC = g.c(getLayoutInflater());
        f0.o(gVarC, "inflate(layoutInflater)");
        this.K2 = gVarC;
        if (gVarC == null) {
            f0.S("viewBinding");
            gVarC = null;
        }
        setContentView(gVarC.getRoot());
        if (NetworkUtils.K()) {
            FragmentManager fragmentManagerN3 = n3();
            v0 v0Var = v0.f37964a;
            Object[] objArr = new Object[2];
            objArr[0] = m5.f0.f40651g;
            String stringExtra = getIntent().getStringExtra("key_device_code");
            if (stringExtra == null) {
                stringExtra = "";
            }
            objArr[1] = stringExtra;
            String str = String.format("https://bbs.flydigi.com/index/product/notice.html?lang=%s&device_type=%s", Arrays.copyOf(objArr, 2));
            f0.o(str, "format(format, *args)");
            d0.v0(fragmentManagerN3, WebFragment.e6(str), R.id.web_container);
        }
    }
}
