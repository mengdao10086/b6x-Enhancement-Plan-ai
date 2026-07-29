package com.flydigi.device_manager.ui.detail;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;
import com.flydigi.sdk.gamepad.GamepadInfo;

/* JADX INFO: loaded from: classes7.dex */
public class DetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        DetailActivity detailActivity = (DetailActivity) obj;
        detailActivity.K2 = detailActivity.getIntent().getIntExtra(DataConstant.DEVICE_KEY_DEVICE_TYPE, detailActivity.K2);
        String string = detailActivity.getIntent().getExtras() == null ? detailActivity.E7 : detailActivity.getIntent().getExtras().getString("key_device_code", detailActivity.E7);
        detailActivity.E7 = string;
        if (string == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The field 'deviceCode' is null, in class '");
            sb2.append(DetailActivity.class.getName());
            sb2.append("!");
        }
        detailActivity.F7 = detailActivity.getIntent().getBooleanExtra(DataConstant.DEVICE_KEY_AUTO_CONNECT, detailActivity.F7);
        detailActivity.G7 = detailActivity.getIntent().getBooleanExtra(DataConstant.DEVICE_KEY_AUTO_SWITCH_MODE, detailActivity.G7);
        detailActivity.H7 = (GamepadInfo) detailActivity.getIntent().getParcelableExtra("key_device_info");
        detailActivity.I7 = detailActivity.getIntent().getIntExtra("ip_type", detailActivity.I7);
    }
}
