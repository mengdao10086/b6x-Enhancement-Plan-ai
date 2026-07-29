package com.flydigi.qiji.ui.customer_service;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;

/* JADX INFO: loaded from: classes3.dex */
public class CustomerServiceActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        CustomerServiceActivity customerServiceActivity = (CustomerServiceActivity) obj;
        customerServiceActivity.K2 = customerServiceActivity.getIntent().getExtras() == null ? customerServiceActivity.K2 : customerServiceActivity.getIntent().getExtras().getString(DataConstant.WEB_URL, customerServiceActivity.K2);
    }
}
