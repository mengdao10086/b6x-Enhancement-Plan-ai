package com.flydigi.device_manager.ui.driver_active;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;

/* JADX INFO: loaded from: classes7.dex */
public class DriverActivationActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        DriverActivationActivity driverActivationActivity = (DriverActivationActivity) obj;
        driverActivationActivity.K7 = driverActivationActivity.getIntent().getBooleanExtra(DataConstant.DEVICE_KEY_DRIVER_ACTIVE_FROM_PERMISSION_CHECK, driverActivationActivity.K7);
        driverActivationActivity.L7 = driverActivationActivity.getIntent().getBooleanExtra(DataConstant.DEVICE_KEY_ACTIVATION_FAILED, driverActivationActivity.L7);
    }
}
