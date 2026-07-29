package com.flydigi.cyberfox.ui.connect;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: loaded from: classes7.dex */
public class ConnectActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        ConnectActivity connectActivity = (ConnectActivity) obj;
        connectActivity.K2 = connectActivity.getIntent().getExtras() == null ? connectActivity.K2 : connectActivity.getIntent().getExtras().getString("key_device_code", connectActivity.K2);
    }
}
