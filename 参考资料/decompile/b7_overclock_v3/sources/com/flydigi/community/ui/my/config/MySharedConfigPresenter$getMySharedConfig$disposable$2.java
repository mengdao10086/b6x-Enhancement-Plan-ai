package com.flydigi.community.ui.my.config;

import com.flydigi.data.bean.community.ArticleBean;
import ik.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class MySharedConfigPresenter$getMySharedConfig$disposable$2 extends FunctionReferenceImpl implements l<ArticleBean, MySharedConfigItem> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MySharedConfigPresenter$getMySharedConfig$disposable$2 f13970c = new MySharedConfigPresenter$getMySharedConfig$disposable$2();

    public MySharedConfigPresenter$getMySharedConfig$disposable$2() {
        super(1, MySharedConfigItem.class, "<init>", "<init>(Lcom/flydigi/data/bean/community/ArticleBean;)V", 0);
    }

    @Override // ik.l
    @k
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final MySharedConfigItem i(@k ArticleBean p02) {
        f0.p(p02, "p0");
        return new MySharedConfigItem(p02);
    }
}
