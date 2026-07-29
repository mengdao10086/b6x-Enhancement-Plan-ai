package com.flydigi.community.ui.article;

import com.flydigi.community.ui.article.f;
import com.flydigi.data.bean.community.ArticleBean;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class ArticleDetailPresenter$getArticleDetail$2 extends FunctionReferenceImpl implements ik.l<ArticleBean, z1> {
    public ArticleDetailPresenter$getArticleDetail$2(Object obj) {
        super(1, obj, f.b.class, "showArticle", "showArticle(Lcom/flydigi/data/bean/community/ArticleBean;)V", 0);
    }

    public final void X0(@yt.k ArticleBean p02) {
        kotlin.jvm.internal.f0.p(p02, "p0");
        ((f.b) this.receiver).c1(p02);
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(ArticleBean articleBean) {
        X0(articleBean);
        return z1.f38230a;
    }
}
