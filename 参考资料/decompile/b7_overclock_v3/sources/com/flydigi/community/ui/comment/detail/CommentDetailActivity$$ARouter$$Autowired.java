package com.flydigi.community.ui.comment.detail;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;

/* JADX INFO: loaded from: classes2.dex */
public class CommentDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        CommentDetailActivity commentDetailActivity = (CommentDetailActivity) obj;
        commentDetailActivity.F7 = commentDetailActivity.getIntent().getIntExtra("id", commentDetailActivity.F7);
        commentDetailActivity.G7 = commentDetailActivity.getIntent().getIntExtra(DataConstant.COMMUNITY_ARTICLE_AUTHOR_ID, commentDetailActivity.G7);
        commentDetailActivity.H7 = commentDetailActivity.getIntent().getIntExtra(DataConstant.COMMUNITY_COMMENT_ID, commentDetailActivity.H7);
        commentDetailActivity.I7 = commentDetailActivity.getIntent().getIntExtra(DataConstant.COMMUNITY_MESSAGE_ID, commentDetailActivity.I7);
    }
}
