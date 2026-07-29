package com.flydigi.device_manager.ui.firmware;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;

/* JADX INFO: loaded from: classes7.dex */
public class FirmwareUpgradeActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        FirmwareUpgradeActivity firmwareUpgradeActivity = (FirmwareUpgradeActivity) obj;
        firmwareUpgradeActivity.J7 = firmwareUpgradeActivity.getIntent().getExtras() == null ? firmwareUpgradeActivity.J7 : firmwareUpgradeActivity.getIntent().getExtras().getString("key_device_code", firmwareUpgradeActivity.J7);
        firmwareUpgradeActivity.L7 = firmwareUpgradeActivity.getIntent().getBooleanExtra(DataConstant.DEVICE_KEY_FIRMWARE_FORCE_LATEST, firmwareUpgradeActivity.L7);
    }
}
