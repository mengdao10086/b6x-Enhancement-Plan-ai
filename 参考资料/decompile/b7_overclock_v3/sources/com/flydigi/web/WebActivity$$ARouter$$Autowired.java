package com.flydigi.web;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;
import h3.a;

/* JADX INFO: loaded from: classes3.dex */
public class WebActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object target) {
        this.serializationService = (SerializationService) a.j().p(SerializationService.class);
        WebActivity webActivity = (WebActivity) target;
        webActivity.K2 = webActivity.getIntent().getExtras() == null ? webActivity.K2 : webActivity.getIntent().getExtras().getString(DataConstant.WEB_URL, webActivity.K2);
        webActivity.E7 = webActivity.getIntent().getExtras() == null ? webActivity.E7 : webActivity.getIntent().getExtras().getString(DataConstant.WEB_TITLE, webActivity.E7);
    }
}
