package com.flydigi.community.ui.article;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.ArticleBean;
import i9.a;

/* JADX INFO: loaded from: classes2.dex */
public class ArticleDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        ArticleDetailActivity articleDetailActivity = (ArticleDetailActivity) obj;
        articleDetailActivity.K2 = articleDetailActivity.getIntent().getIntExtra("id", articleDetailActivity.K2);
        articleDetailActivity.E7 = articleDetailActivity.getIntent().getIntExtra(DataConstant.COMMUNITY_MESSAGE_ID, articleDetailActivity.E7);
        articleDetailActivity.F7 = articleDetailActivity.getIntent().getIntExtra(DataConstant.COMMUNITY_ARTICLE_TYPE, articleDetailActivity.F7);
        articleDetailActivity.G7 = articleDetailActivity.getIntent().getExtras() == null ? articleDetailActivity.G7 : articleDetailActivity.getIntent().getExtras().getString(DataConstant.COMMUNITY_ARTICLE_SOURCE, articleDetailActivity.G7);
        articleDetailActivity.H7 = articleDetailActivity.getIntent().getBooleanExtra(DataConstant.COMMUNITY_ARTICLE_LOCATE_COMMENT, articleDetailActivity.H7);
        articleDetailActivity.I7 = (ArticleBean) articleDetailActivity.getIntent().getParcelableExtra(a.b.f31931p);
    }
}
