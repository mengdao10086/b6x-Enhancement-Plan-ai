package com.flydigi.device_manager.ui.connection;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.web.WebFragment;
import i9.a;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31948d)
public final class EmulatorConnectionActivity extends com.flydigi.device_manager.d {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.device_connect_guide);
        getWindow().setFormat(-3);
        try {
            getWindow().setFlags(16777216, 16777216);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (a4(WebFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), WebFragment.e6(com.flydigi.device_manager.o.f14458b), WebFragment.class.getSimpleName(), R.id.fl_container);
        }
    }

    @Override // com.flydigi.device_manager.d
    public void s4(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        super.s4(deviceInfo);
        if (deviceInfo.isConnected()) {
            com.flydigi.base.common.o.G(getString(R.string.device_connect_success_emulator), 0, 17);
            finish();
        }
    }
}
