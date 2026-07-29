package com.flydigi.cyberfox.ui.upgrade;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.sdk.headset.HeadsetInfo;

/* JADX INFO: loaded from: classes7.dex */
public class UpgradeActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        UpgradeActivity upgradeActivity = (UpgradeActivity) obj;
        String string = upgradeActivity.getIntent().getExtras() == null ? upgradeActivity.K2 : upgradeActivity.getIntent().getExtras().getString("key_device_code", upgradeActivity.K2);
        upgradeActivity.K2 = string;
        if (string == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The field 'deviceCode' is null, in class '");
            sb2.append(UpgradeActivity.class.getName());
            sb2.append("!");
        }
        upgradeActivity.E7 = (HeadsetInfo) upgradeActivity.getIntent().getParcelableExtra("key_device_info");
        upgradeActivity.F7 = (FirmwareInfoBean) upgradeActivity.getIntent().getParcelableExtra(DataConstant.DEVICE_KEY_FIRMWARE_INFO);
    }
}
