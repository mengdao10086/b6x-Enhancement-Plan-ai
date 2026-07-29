package com.flydigi.device_manager.ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;

/* JADX INFO: loaded from: classes7.dex */
public class OpenFloatWindowNoticeActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        OpenFloatWindowNoticeActivity openFloatWindowNoticeActivity = (OpenFloatWindowNoticeActivity) obj;
        openFloatWindowNoticeActivity.K2 = openFloatWindowNoticeActivity.getIntent().getBooleanExtra(DataConstant.DEVICE_KEY_CAN_JUMP, openFloatWindowNoticeActivity.K2);
    }
}
