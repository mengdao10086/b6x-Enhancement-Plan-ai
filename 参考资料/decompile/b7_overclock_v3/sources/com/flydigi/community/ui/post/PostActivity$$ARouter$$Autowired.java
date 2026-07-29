package com.flydigi.community.ui.post;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.TopicBean;
import i9.a;

/* JADX INFO: loaded from: classes2.dex */
public class PostActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        PostActivity postActivity = (PostActivity) obj;
        postActivity.H7 = (ArticleBean) postActivity.getIntent().getParcelableExtra(a.b.f31931p);
        postActivity.I7 = (TopicBean) postActivity.getIntent().getParcelableExtra(a.b.f31929n);
        postActivity.J7 = (ConfigBean) postActivity.getIntent().getParcelableExtra("key_config");
        postActivity.K7 = postActivity.getIntent().getIntExtra(a.b.f31933r, postActivity.K7);
    }
}
