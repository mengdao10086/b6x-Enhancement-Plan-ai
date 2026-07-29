package com.flydigi.community.ui.article_list;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.community.ui.article_list.d;
import com.flydigi.data.bean.community.ArticleList;
import com.flydigi.data.bean.community.LikeArticleBean;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nArticleListPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArticleListPresenter.kt\ncom/flydigi/community/ui/article_list/ArticleListPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class ArticleListPresenter implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final d.b f13802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final z5.f f13805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f13806e;

    public ArticleListPresenter(@yt.k d.b mView, int i10, int i11) {
        f0.p(mView, "mView");
        this.f13802a = mView;
        this.f13803b = i10;
        this.f13804c = i11;
        this.f13805d = new z5.f();
        this.f13806e = new io.reactivex.disposables.a();
    }

    public static final void k0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void l0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void m0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void n0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void o0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void p0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void S(final int i10, int i11, boolean z10) {
        z<R> zVarS0 = this.f13805d.f(i11).s0(o5.l.d());
        final ik.l<LikeArticleBean, z1> lVar = new ik.l<LikeArticleBean, z1>() { // from class: com.flydigi.community.ui.article_list.ArticleListPresenter$likeArticle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(LikeArticleBean likeArticleBean) {
                this.this$0.f13802a.x2(i10, likeArticleBean.getResult() == 1);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LikeArticleBean likeArticleBean) {
                b(likeArticleBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article_list.f
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleListPresenter.k0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article_list.ArticleListPresenter$likeArticle$2
            {
                super(1);
            }

            public final void b(Throwable it2) {
                d.b bVar = this.this$0.f13802a;
                f0.o(it2, "it");
                bVar.b(false, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13806e.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article_list.j
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleListPresenter.l0(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void W(final int i10, int i11, final int i12) {
        z<R> zVarS0 = this.f13805d.c(i11).s0(o5.l.d());
        final ik.l<BaseResponse<?>, z1> lVar = new ik.l<BaseResponse<?>, z1>() { // from class: com.flydigi.community.ui.article_list.ArticleListPresenter$shareArticle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(BaseResponse<?> baseResponse) {
                this.this$0.f13802a.T(i10, i12 + 1);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<?> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article_list.e
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleListPresenter.o0(lVar, obj);
            }
        };
        final ArticleListPresenter$shareArticle$2 articleListPresenter$shareArticle$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article_list.ArticleListPresenter$shareArticle$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13806e.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article_list.g
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleListPresenter.p0(articleListPresenter$shareArticle$2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void j(final int i10, int i11) {
        z<R> zVarS0 = this.f13805d.g(this.f13803b, this.f13804c, i10, i11).s0(o5.l.d());
        final ik.l<ArticleList, z1> lVar = new ik.l<ArticleList, z1>() { // from class: com.flydigi.community.ui.article_list.ArticleListPresenter$loadData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ArticleList articleList) {
                if (i10 == 1) {
                    this.f13802a.z(articleList.getNotice());
                }
                this.f13802a.C1(i10 == 1, articleList.getList());
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArticleList articleList) {
                b(articleList);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article_list.i
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleListPresenter.m0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article_list.ArticleListPresenter$loadData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(@yt.k Throwable throwable) {
                f0.p(throwable, "throwable");
                this.this$0.f13802a.b(i10 == 1, throwable);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13806e.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article_list.h
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleListPresenter.n0(lVar2, obj);
            }
        }));
    }
}
