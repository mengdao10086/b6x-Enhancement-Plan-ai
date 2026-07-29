package com.flydigi.device_manager.ui.mapping_test;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.sdk.gamepad.GamepadInfo;
import h3.a;

/* JADX INFO: loaded from: classes7.dex */
public class KeyMappingTestActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.j().p(SerializationService.class);
        KeyMappingTestActivity keyMappingTestActivity = (KeyMappingTestActivity) obj;
        keyMappingTestActivity.E7 = keyMappingTestActivity.getIntent().getExtras() == null ? keyMappingTestActivity.E7 : keyMappingTestActivity.getIntent().getExtras().getString("key_device_code", keyMappingTestActivity.E7);
        keyMappingTestActivity.F7 = (GamepadInfo) keyMappingTestActivity.getIntent().getParcelableExtra("key_device_info");
    }
}
