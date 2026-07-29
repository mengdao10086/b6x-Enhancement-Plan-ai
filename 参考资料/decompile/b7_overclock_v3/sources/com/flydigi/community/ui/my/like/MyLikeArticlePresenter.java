package com.flydigi.community.ui.my.like;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.community.ui.my.like.a;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.LikeArticleBean;
import ik.l;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nMyLikeArticlePresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyLikeArticlePresenter.kt\ncom/flydigi/community/ui/my/like/MyLikeArticlePresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class MyLikeArticlePresenter implements a.InterfaceC0143a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a.b f13981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final z5.f f13982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final io.reactivex.disposables.a f13983c;

    public MyLikeArticlePresenter(@k a.b mView) {
        f0.p(mView, "mView");
        this.f13981a = mView;
        this.f13982b = new z5.f();
        this.f13983c = new io.reactivex.disposables.a();
    }

    public static final void k0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void l0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void m0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void n0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void o0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void p0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void S(final int i10, int i11, boolean z10) {
        z<R> zVarS0 = this.f13982b.f(i11).s0(o5.l.d());
        final l<LikeArticleBean, z1> lVar = new l<LikeArticleBean, z1>() { // from class: com.flydigi.community.ui.my.like.MyLikeArticlePresenter$likeArticle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(LikeArticleBean likeArticleBean) {
                this.this$0.j0().x2(i10, likeArticleBean.getResult() == 1);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LikeArticleBean likeArticleBean) {
                b(likeArticleBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.my.like.c
            @Override // dj.g
            public final void accept(Object obj) {
                MyLikeArticlePresenter.k0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.my.like.MyLikeArticlePresenter$likeArticle$2
            {
                super(1);
            }

            public final void b(Throwable it2) {
                a.b bVarJ0 = this.this$0.j0();
                f0.o(it2, "it");
                bVarJ0.b(false, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13983c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.my.like.d
            @Override // dj.g
            public final void accept(Object obj) {
                MyLikeArticlePresenter.l0(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void W(final int i10, int i11, final int i12) {
        z<R> zVarS0 = this.f13982b.c(i11).s0(o5.l.d());
        final l<BaseResponse<?>, z1> lVar = new l<BaseResponse<?>, z1>() { // from class: com.flydigi.community.ui.my.like.MyLikeArticlePresenter$shareArticle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(BaseResponse<?> baseResponse) {
                this.this$0.j0().T(i10, i12 + 1);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<?> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.my.like.f
            @Override // dj.g
            public final void accept(Object obj) {
                MyLikeArticlePresenter.o0(lVar, obj);
            }
        };
        final MyLikeArticlePresenter$shareArticle$2 myLikeArticlePresenter$shareArticle$2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.my.like.MyLikeArticlePresenter$shareArticle$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13983c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.my.like.g
            @Override // dj.g
            public final void accept(Object obj) {
                MyLikeArticlePresenter.p0(myLikeArticlePresenter$shareArticle$2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void j(final int i10, int i11) {
        z<R> zVarS0 = this.f13982b.m(i10, i11).s0(o5.l.d());
        final l<List<ArticleBean>, z1> lVar = new l<List<ArticleBean>, z1>() { // from class: com.flydigi.community.ui.my.like.MyLikeArticlePresenter$loadData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(List<ArticleBean> articles) {
                a.b bVarJ0 = this.this$0.j0();
                boolean z10 = i10 == 1;
                f0.o(articles, "articles");
                bVarJ0.C1(z10, articles);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<ArticleBean> list) {
                b(list);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.my.like.e
            @Override // dj.g
            public final void accept(Object obj) {
                MyLikeArticlePresenter.m0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.my.like.MyLikeArticlePresenter$loadData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Throwable throwable) {
                a.b bVarJ0 = this.this$0.j0();
                boolean z10 = i10 == 1;
                f0.o(throwable, "throwable");
                bVarJ0.b(z10, throwable);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13983c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.my.like.b
            @Override // dj.g
            public final void accept(Object obj) {
                MyLikeArticlePresenter.n0(lVar2, obj);
            }
        }));
    }

    @k
    public final a.b j0() {
        return this.f13981a;
    }
}
