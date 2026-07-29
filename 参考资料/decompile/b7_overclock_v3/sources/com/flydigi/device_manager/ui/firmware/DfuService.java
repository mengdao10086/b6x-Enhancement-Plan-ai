package com.flydigi.device_manager.ui.firmware;

import android.app.Activity;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes7.dex */
public class DfuService extends DfuBaseService {
    @Override // no.nordicsemi.android.dfu.DfuBaseService
    public Class<? extends Activity> getNotificationTarget() {
        return FirmwareUpgradeActivity.class;
    }

    @Override // no.nordicsemi.android.dfu.DfuBaseService
    public boolean isDebug() {
        return false;
    }
}
