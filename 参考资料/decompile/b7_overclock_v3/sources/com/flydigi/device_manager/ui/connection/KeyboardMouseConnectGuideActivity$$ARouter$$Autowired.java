package com.flydigi.device_manager.ui.connection;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: loaded from: classes7.dex */
public class KeyboardMouseConnectGuideActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        KeyboardMouseConnectGuideActivity keyboardMouseConnectGuideActivity = (KeyboardMouseConnectGuideActivity) obj;
        keyboardMouseConnectGuideActivity.K2 = keyboardMouseConnectGuideActivity.getIntent().getIntExtra("type", keyboardMouseConnectGuideActivity.K2);
    }
}
