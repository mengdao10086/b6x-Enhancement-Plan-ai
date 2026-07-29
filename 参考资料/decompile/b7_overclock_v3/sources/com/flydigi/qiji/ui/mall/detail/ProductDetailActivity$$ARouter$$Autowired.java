package com.flydigi.qiji.ui.mall.detail;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import i9.a;

/* JADX INFO: loaded from: classes3.dex */
public class ProductDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        ProductDetailActivity productDetailActivity = (ProductDetailActivity) obj;
        productDetailActivity.K2 = productDetailActivity.getIntent().getIntExtra(a.f.f31978g, productDetailActivity.K2);
    }
}
