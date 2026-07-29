package com.flydigi.community.ui.my.article;

import com.flydigi.data.bean.community.ArticleBean;
import ik.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class MyArticlePresenter$getMyPublishedArticle$disposable$2 extends FunctionReferenceImpl implements l<ArticleBean, MyArticleItem> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MyArticlePresenter$getMyPublishedArticle$disposable$2 f13952c = new MyArticlePresenter$getMyPublishedArticle$disposable$2();

    public MyArticlePresenter$getMyPublishedArticle$disposable$2() {
        super(1, MyArticleItem.class, "<init>", "<init>(Lcom/flydigi/data/bean/community/ArticleBean;)V", 0);
    }

    @Override // ik.l
    @k
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final MyArticleItem i(@k ArticleBean p02) {
        f0.p(p02, "p0");
        return new MyArticleItem(p02);
    }
}
