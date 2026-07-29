package com.flydigi.device_manager.ui.sync;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
public class SyncConfigActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        SyncConfigActivity syncConfigActivity = (SyncConfigActivity) obj;
        syncConfigActivity.K2 = syncConfigActivity.getIntent().getBooleanExtra(a.d.f31963s, syncConfigActivity.K2);
    }
}
