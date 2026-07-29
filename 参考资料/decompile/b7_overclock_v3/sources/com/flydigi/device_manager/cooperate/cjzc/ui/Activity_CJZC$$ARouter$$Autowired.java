package com.flydigi.device_manager.cooperate.cjzc.ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import h3.a;

/* JADX INFO: loaded from: classes7.dex */
public class Activity_CJZC$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.j().p(SerializationService.class);
        Activity_CJZC activity_CJZC = (Activity_CJZC) obj;
        activity_CJZC.Z7 = activity_CJZC.getIntent().getExtras() == null ? activity_CJZC.Z7 : activity_CJZC.getIntent().getExtras().getString("package_name", activity_CJZC.Z7);
    }
}
