package com.flydigi.device_manager.ui.detail.waspwing;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;

/* JADX INFO: loaded from: classes7.dex */
public class WaspwingUpgradeActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        WaspwingUpgradeActivity waspwingUpgradeActivity = (WaspwingUpgradeActivity) obj;
        waspwingUpgradeActivity.K2 = waspwingUpgradeActivity.getIntent().getExtras() == null ? waspwingUpgradeActivity.K2 : waspwingUpgradeActivity.getIntent().getExtras().getString("key_device_code", waspwingUpgradeActivity.K2);
        waspwingUpgradeActivity.E7 = waspwingUpgradeActivity.getIntent().getBooleanExtra(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, waspwingUpgradeActivity.E7);
        waspwingUpgradeActivity.F7 = waspwingUpgradeActivity.getIntent().getExtras() == null ? waspwingUpgradeActivity.F7 : waspwingUpgradeActivity.getIntent().getExtras().getString("key_device_address", waspwingUpgradeActivity.F7);
    }
}
