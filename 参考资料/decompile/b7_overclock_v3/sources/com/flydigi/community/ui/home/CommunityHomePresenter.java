package com.flydigi.community.ui.home;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.community.ui.home.a;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.LikeArticleBean;
import com.flydigi.data.bean.community.TopicListBean;
import dj.o;
import ik.l;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import o5.p;
import xi.e0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nCommunityHomePresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommunityHomePresenter.kt\ncom/flydigi/community/ui/home/CommunityHomePresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
public final class CommunityHomePresenter implements a.InterfaceC0138a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a.b f13888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final z5.f f13889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final io.reactivex.disposables.a f13890c;

    public static final class a extends io.reactivex.observers.d<List<? extends ArticleBean>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f13892c;

        public a(int i10) {
            this.f13892c = i10;
        }

        @Override // xi.g0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(@k List<ArticleBean> articles) {
            f0.p(articles, "articles");
            CommunityHomePresenter.this.f13888a.C1(this.f13892c == 1, articles);
        }

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(@k Throwable throwable) {
            f0.p(throwable, "throwable");
            CommunityHomePresenter.this.f13888a.b(this.f13892c == 1, throwable);
        }
    }

    public static final class b extends io.reactivex.observers.d<TopicListBean> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f13894c;

        public b(int i10) {
            this.f13894c = i10;
        }

        @Override // xi.g0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(@k TopicListBean topics) {
            f0.p(topics, "topics");
            CommunityHomePresenter.this.f13888a.G1(this.f13894c, topics.getTopics());
        }

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(@k Throwable throwable) {
            f0.p(throwable, "throwable");
        }
    }

    public CommunityHomePresenter(@k a.b mView) {
        f0.p(mView, "mView");
        this.f13888a = mView;
        this.f13889b = new z5.f();
        this.f13890c = new io.reactivex.disposables.a();
    }

    public static final void m0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void n0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final e0 o0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (e0) tmp0.i(obj);
    }

    public static final e0 p0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (e0) tmp0.i(obj);
    }

    public static final void q0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void r0(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void S(final int i10, int i11, boolean z10) {
        z<R> zVarS0 = this.f13889b.f(i11).s0(o5.l.d());
        final l<LikeArticleBean, z1> lVar = new l<LikeArticleBean, z1>() { // from class: com.flydigi.community.ui.home.CommunityHomePresenter$likeArticle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(LikeArticleBean likeArticleBean) {
                this.this$0.f13888a.x2(i10, likeArticleBean.getResult() == 1);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LikeArticleBean likeArticleBean) {
                b(likeArticleBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.home.f
            @Override // dj.g
            public final void accept(Object obj) {
                CommunityHomePresenter.m0(lVar, obj);
            }
        };
        final l<Throwable, z1> lVar2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.home.CommunityHomePresenter$likeArticle$2
            {
                super(1);
            }

            public final void b(Throwable throwable) {
                a.b bVar = this.this$0.f13888a;
                f0.o(throwable, "throwable");
                bVar.b(false, throwable);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13890c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.home.e
            @Override // dj.g
            public final void accept(Object obj) {
                CommunityHomePresenter.n0(lVar2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void W(final int i10, int i11, final int i12) {
        z<R> zVarS0 = this.f13889b.c(i11).s0(o5.l.d());
        final l<BaseResponse<?>, z1> lVar = new l<BaseResponse<?>, z1>() { // from class: com.flydigi.community.ui.home.CommunityHomePresenter$shareArticle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(BaseResponse<?> baseResponse) {
                this.this$0.f13888a.T(i10, i12 + 1);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<?> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.home.c
            @Override // dj.g
            public final void accept(Object obj) {
                CommunityHomePresenter.q0(lVar, obj);
            }
        };
        final CommunityHomePresenter$shareArticle$2 communityHomePresenter$shareArticle$2 = new l<Throwable, z1>() { // from class: com.flydigi.community.ui.home.CommunityHomePresenter$shareArticle$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13890c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.home.d
            @Override // dj.g
            public final void accept(Object obj) {
                CommunityHomePresenter.r0(communityHomePresenter$shareArticle$2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article_list.k.a
    public void j(int i10, int i11) {
        io.reactivex.observers.d<List<ArticleBean>> dVarK0 = k0(i10);
        if (i10 != 1) {
            this.f13889b.h(i10, i11).s0(o5.l.d()).c(dVarK0);
            return;
        }
        if (p.d()) {
            final z<TopicListBean> zVarE = this.f13889b.E(true, i10, i11);
            z<TopicListBean> zVarJ5 = this.f13889b.o(true, i10, i11).J5(lj.b.d());
            final l<z<TopicListBean>, e0<TopicListBean>> lVar = new l<z<TopicListBean>, e0<TopicListBean>>() { // from class: com.flydigi.community.ui.home.CommunityHomePresenter$loadData$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final e0<TopicListBean> i(@k z<TopicListBean> network) {
                    f0.p(network, "network");
                    return z.H3(network, zVarE.J5(lj.b.d()).n6(network));
                }
            };
            zVarJ5.m4(new o() { // from class: com.flydigi.community.ui.home.g
                @Override // dj.o
                public final Object apply(Object obj) {
                    return CommunityHomePresenter.o0(lVar, obj);
                }
            }).b4(aj.a.c()).c(l0(i10));
        }
        final z<List<ArticleBean>> zVarD = this.f13889b.D(i10, i11);
        z<List<ArticleBean>> zVarJ52 = this.f13889b.h(i10, i11).J5(lj.b.d());
        final l<z<List<ArticleBean>>, e0<List<ArticleBean>>> lVar2 = new l<z<List<ArticleBean>>, e0<List<ArticleBean>>>() { // from class: com.flydigi.community.ui.home.CommunityHomePresenter$loadData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final e0<List<ArticleBean>> i(@k z<List<ArticleBean>> network) {
                f0.p(network, "network");
                return z.H3(network, zVarD.J5(lj.b.d()).n6(network));
            }
        };
        zVarJ52.m4(new o() { // from class: com.flydigi.community.ui.home.h
            @Override // dj.o
            public final Object apply(Object obj) {
                return CommunityHomePresenter.p0(lVar2, obj);
            }
        }).b4(aj.a.c()).c(dVarK0);
    }

    public final io.reactivex.observers.d<List<ArticleBean>> k0(int i10) {
        return new a(i10);
    }

    public final io.reactivex.observers.d<TopicListBean> l0(int i10) {
        return new b(i10);
    }
}
