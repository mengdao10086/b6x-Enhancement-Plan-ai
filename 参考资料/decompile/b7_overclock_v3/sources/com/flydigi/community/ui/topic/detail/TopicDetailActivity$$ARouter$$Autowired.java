package com.flydigi.community.ui.topic.detail;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.TopicBean;
import i9.a;

/* JADX INFO: loaded from: classes2.dex */
public class TopicDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        TopicDetailActivity topicDetailActivity = (TopicDetailActivity) obj;
        topicDetailActivity.F7 = topicDetailActivity.getIntent().getExtras() == null ? topicDetailActivity.F7 : topicDetailActivity.getIntent().getExtras().getString(DataConstant.COMMUNITY_ARTICLE_SOURCE, topicDetailActivity.F7);
        topicDetailActivity.G7 = (TopicBean) topicDetailActivity.getIntent().getParcelableExtra(a.b.f31929n);
        topicDetailActivity.H7 = topicDetailActivity.getIntent().getIntExtra(a.b.f31930o, topicDetailActivity.H7);
    }
}
