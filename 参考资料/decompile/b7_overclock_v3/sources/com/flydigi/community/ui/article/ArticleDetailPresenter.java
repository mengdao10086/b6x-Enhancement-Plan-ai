package com.flydigi.community.ui.article;

import com.blankj.utilcode.util.j1;
import com.flydigi.base.net.ApiException;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.community.R;
import com.flydigi.community.ui.article.f;
import com.flydigi.data.bean.CfgInfoBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.LikeArticleBean;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import java.io.File;
import java.io.IOException;
import kotlin.z1;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nArticleDetailPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArticleDetailPresenter.kt\ncom/flydigi/community/ui/article/ArticleDetailPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,83:1\n1#2:84\n*E\n"})
public final class ArticleDetailPresenter implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final f.b f13709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final z5.f f13710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f13711c;

    public ArticleDetailPresenter(@yt.k f.b mView) {
        kotlin.jvm.internal.f0.p(mView, "mView");
        this.f13709a = mView;
        this.f13710b = new z5.f();
        this.f13711c = new io.reactivex.disposables.a();
    }

    public static final CFGEntity o0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (CFGEntity) tmp0.i(obj);
    }

    public static final void p0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void q0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final ArticleBean r0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (ArticleBean) tmp0.i(obj);
    }

    public static final void s0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void t0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void u0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void v0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void w0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void x0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.community.ui.article.f.a
    public void F(@yt.k final CfgInfoBean config) {
        kotlin.jvm.internal.f0.p(config, "config");
        final int iConvertNetDeviceTypeToLocal = config.convertNetDeviceTypeToLocal();
        xi.z<File> zVarF = e6.z.F(config.getUrl());
        final ik.l<File, CFGEntity> lVar = new ik.l<File, CFGEntity>() { // from class: com.flydigi.community.ui.article.ArticleDetailPresenter$downloadConfig$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CFGEntity i(@yt.k File file) throws JSONException, IOException {
                kotlin.jvm.internal.f0.p(file, "file");
                CFGEntity cFGEntityJ0 = e6.z.j0(file, true, iConvertNetDeviceTypeToLocal);
                cFGEntityJ0.setGamepad(m9.t.i(config.getGamepad()));
                return cFGEntityJ0;
            }
        };
        xi.z zVarS0 = zVarF.A3(new dj.o() { // from class: com.flydigi.community.ui.article.l0
            @Override // dj.o
            public final Object apply(Object obj) {
                return ArticleDetailPresenter.o0(lVar, obj);
            }
        }).s0(o5.l.d());
        final ik.l<CFGEntity, z1> lVar2 = new ik.l<CFGEntity, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailPresenter$downloadConfig$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(CFGEntity it2) {
                f.b bVar = this.this$0.f13709a;
                CfgInfoBean cfgInfoBean = config;
                kotlin.jvm.internal.f0.o(it2, "it");
                bVar.B2(cfgInfoBean, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CFGEntity cFGEntity) {
                b(cFGEntity);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article.h0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailPresenter.p0(lVar2, obj);
            }
        };
        final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailPresenter$downloadConfig$3
            {
                super(1);
            }

            public final void b(Throwable it2) {
                f.b bVar = this.this$0.f13709a;
                kotlin.jvm.internal.f0.o(it2, "it");
                bVar.K2(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13711c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.e0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailPresenter.q0(lVar3, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article.f.a
    public void J(int i10, int i11) {
        xi.z<R> zVarS0 = this.f13710b.c(i10).s0(o5.l.d());
        final ArticleDetailPresenter$shareArticle$1 articleDetailPresenter$shareArticle$1 = new ik.l<BaseResponse<?>, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailPresenter$shareArticle$1
            public final void b(BaseResponse<?> baseResponse) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<?> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article.k0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailPresenter.w0(articleDetailPresenter$shareArticle$1, obj);
            }
        };
        final ArticleDetailPresenter$shareArticle$2 articleDetailPresenter$shareArticle$2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailPresenter$shareArticle$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13711c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.j0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailPresenter.x0(articleDetailPresenter$shareArticle$2, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article.f.a
    public void a(int i10, int i11) {
        xi.z<ArticleBean> zVarA = this.f13710b.a(i10, i11);
        final ArticleDetailPresenter$getArticleDetail$1 articleDetailPresenter$getArticleDetail$1 = new ik.l<ArticleBean, ArticleBean>() { // from class: com.flydigi.community.ui.article.ArticleDetailPresenter$getArticleDetail$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ArticleBean i(@yt.k ArticleBean data) throws ApiException {
                kotlin.jvm.internal.f0.p(data, "data");
                if (data.getId() != 0) {
                    return data;
                }
                throw new ApiException(-10000, j1.a().getString(R.string.community_empty_content));
            }
        };
        xi.z zVarS0 = zVarA.A3(new dj.o() { // from class: com.flydigi.community.ui.article.m0
            @Override // dj.o
            public final Object apply(Object obj) {
                return ArticleDetailPresenter.r0(articleDetailPresenter$getArticleDetail$1, obj);
            }
        }).s0(o5.l.d());
        final ArticleDetailPresenter$getArticleDetail$2 articleDetailPresenter$getArticleDetail$2 = new ArticleDetailPresenter$getArticleDetail$2(this.f13709a);
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article.i0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailPresenter.s0(articleDetailPresenter$getArticleDetail$2, obj);
            }
        };
        final ArticleDetailPresenter$getArticleDetail$3 articleDetailPresenter$getArticleDetail$3 = new ArticleDetailPresenter$getArticleDetail$3(this.f13709a);
        this.f13711c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.g0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailPresenter.t0(articleDetailPresenter$getArticleDetail$3, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article.f.a
    public void b0(int i10) {
        xi.z<R> zVarS0 = this.f13710b.f(i10).s0(o5.l.d());
        final ik.l<LikeArticleBean, z1> lVar = new ik.l<LikeArticleBean, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailPresenter$likeArchive$1
            {
                super(1);
            }

            public final void b(LikeArticleBean likeArticleBean) {
                if (likeArticleBean.getResult() == 1) {
                    this.this$0.f13709a.z1();
                } else {
                    this.this$0.f13709a.X();
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LikeArticleBean likeArticleBean) {
                b(likeArticleBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article.f0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailPresenter.u0(lVar, obj);
            }
        };
        final ArticleDetailPresenter$likeArchive$2 articleDetailPresenter$likeArchive$2 = new ArticleDetailPresenter$likeArchive$2(this.f13709a);
        this.f13711c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.d0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailPresenter.v0(articleDetailPresenter$likeArchive$2, obj);
            }
        }));
    }
}
