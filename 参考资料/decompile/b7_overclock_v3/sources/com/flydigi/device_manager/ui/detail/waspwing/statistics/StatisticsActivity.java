package com.flydigi.device_manager.ui.detail.waspwing.statistics;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.flydigi.base.common.p;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.statistics.StatisticsActivity;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import t9.c;
import t9.i;
import t9.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class StatisticsActivity extends p implements i {

    @k
    public static final a E7 = new a(null);

    @k
    public static final String F7 = "key_device_code";
    public c7.k K2;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final Intent a(@k Context requireContext, @k String deviceCode) {
            f0.p(requireContext, "requireContext");
            f0.p(deviceCode, "deviceCode");
            Intent intentPutExtra = new Intent(requireContext, (Class<?>) StatisticsActivity.class).putExtra("key_device_code", deviceCode);
            f0.o(intentPutExtra, "Intent(requireContext, S…_DEVICE_CODE, deviceCode)");
            return intentPutExtra;
        }
    }

    @m
    @k
    public static final Intent k4(@k Context context, @k String str) {
        return E7.a(context, str);
    }

    public static final void n4(StatisticsActivity this$0, WaspWingInfo waspWingInfo) {
        f0.p(this$0, "this$0");
        f0.p(waspWingInfo, "$waspWingInfo");
        this$0.l4().f10163h.setText(waspWingInfo.getTemperature() + "°C");
        this$0.l4().f10164i.setText(((int) waspWingInfo.getHotSurfaceTemperature()) + "°C");
        this$0.l4().f10165j.setText(String.valueOf(waspWingInfo.getSpeed()));
        this$0.l4().f10161f.setText(String.valueOf(waspWingInfo.getColdRunLevel()));
        this$0.l4().f10166k.setText("当前电压：" + waspWingInfo.m6());
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@k BluetoothDevice bluetoothDevice) {
        i.a.b(this, bluetoothDevice);
    }

    @Override // t9.i
    public void F1(@k final WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        runOnUiThread(new Runnable() { // from class: j7.a
            @Override // java.lang.Runnable
            public final void run() {
                StatisticsActivity.n4(this.f36185a, waspWingInfo);
            }
        });
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
        return R.layout.device_activity_waspwing_statistics;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@k BluetoothDevice bluetoothDevice) {
        i.a.a(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        i.a.f(this, i10);
    }

    @k
    public final c7.k l4() {
        c7.k kVar = this.K2;
        if (kVar != null) {
            return kVar;
        }
        f0.S("binding");
        return null;
    }

    public final String m4(int i10) {
        return Integer.toString(i10);
    }

    public final void o4(@k c7.k kVar) {
        f0.p(kVar, "<set-?>");
        this.K2 = kVar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        super.onPause();
        j.e0(this);
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        j.D(this);
    }

    @Override // t9.i
    public void q2(@k byte[] bArr) {
        i.a.g(this, bArr);
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        c7.k kVarC = c7.k.c(getLayoutInflater());
        f0.o(kVarC, "inflate(layoutInflater)");
        o4(kVarC);
        setContentView(l4().getRoot());
        TextView textView = l4().f10162g;
        int i11 = R.string.device_waspwing_protection_hot_desc;
        Object[] objArr = new Object[1];
        objArr[0] = getString(f0.g(getIntent().getStringExtra("key_device_code"), c.f50960i) ? R.string.device_waspwing_protection_hot_desc_red : f0.g(getIntent().getStringExtra("key_device_code"), c.f50959h) ? R.string.device_waspwing_protection_hot_desc_blue : R.string.device_title_waspwing_led);
        textView.setText(getString(i11, objArr));
    }
}
