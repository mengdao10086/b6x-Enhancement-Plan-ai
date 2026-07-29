package z5;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.bean.CommunitySearchHistoryBean;
import com.flydigi.data.bean.HotSearchKeyword;
import com.flydigi.data.bean.MyMessageBean;
import com.flydigi.data.bean.MyPublishedArticlesBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.ArticleList;
import com.flydigi.data.bean.community.CommentBean;
import com.flydigi.data.bean.community.CommentDetailBean;
import com.flydigi.data.bean.community.CommentListBean;
import com.flydigi.data.bean.community.LikeArticleBean;
import com.flydigi.data.bean.community.LikeCommentBean;
import com.flydigi.data.bean.community.TopicBean;
import com.flydigi.data.bean.community.TopicListBean;
import java.util.List;
import java.util.Objects;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f57747a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f57748b = new s();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(int i10, int i11, List list) throws Exception {
        if (i10 == 1) {
            this.f57747a.V(list, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(int i10, boolean z10, int i11, TopicListBean topicListBean) throws Exception {
        if (i10 == 1) {
            this.f57747a.X(topicListBean, z10, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(String str, int i10, int i11, int i12, ArticleList articleList) throws Exception {
        this.f57747a.W(str + "#" + i10 + "#" + i11 + "#" + i12, articleList);
    }

    public z<List<ArticleBean>> D(int i10, int i11) {
        return this.f57747a.h(i10, i11);
    }

    public z<TopicListBean> E(boolean z10, int i10, int i11) {
        return this.f57747a.o(z10, i10, i11);
    }

    @Override // z5.g
    public z<ArticleBean> a(int i10, int i11) {
        return this.f57748b.a(i10, i11);
    }

    @Override // z5.g
    public z<CommentDetailBean> b(int i10, int i11, int i12, int i13) {
        return this.f57748b.b(i10, i11, i12, i13);
    }

    @Override // z5.g
    public z<BaseResponse> c(int i10) {
        return this.f57748b.c(i10);
    }

    @Override // z5.g
    public z<TopicBean> d(int i10) {
        return this.f57748b.d(i10);
    }

    @Override // z5.g
    public z<ArticleList> e(final int i10, final int i11, final String str, final int i12, int i13) {
        return this.f57747a.e(i10, i11, str, i12, i13).L5(this.f57748b.e(i10, i11, str, i12, i13).Y1(new dj.g() { // from class: z5.c
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f57740a.H(str, i10, i11, i12, (ArticleList) obj);
            }
        }));
    }

    @Override // z5.g
    public z<LikeArticleBean> f(int i10) {
        return this.f57748b.f(i10);
    }

    @Override // z5.g
    public z<ArticleList> g(int i10, int i11, int i12, int i13) {
        return this.f57748b.g(i10, i11, i12, i13);
    }

    @Override // z5.g
    public z<List<ArticleBean>> h(final int i10, final int i11) {
        return this.f57748b.h(i10, i11).Y1(new dj.g() { // from class: z5.a
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f57733a.F(i10, i11, (List) obj);
            }
        });
    }

    @Override // z5.g
    public z<ArticleBean> i(@yt.k String str, @yt.l String str2, @yt.l String str3, int i10, @yt.l String str4, int i11, @yt.l String str5, @yt.l String str6, @yt.l String str7, @yt.l String str8, @yt.l String str9) {
        return this.f57748b.i(str, str2, str3, i10, str4, i11, str5, str6, str7, str8, str9);
    }

    @Override // z5.g
    public z<MyMessageBean> j(int i10, int i11) {
        return this.f57748b.j(i10, i11);
    }

    @Override // z5.g
    public xi.a k(String str) {
        return this.f57747a.k(str);
    }

    @Override // z5.g
    public z<MyPublishedArticlesBean> l(int i10, int i11, int i12) {
        return this.f57748b.l(i10, i11, i12);
    }

    @Override // z5.g
    public z<List<ArticleBean>> m(int i10, int i11) {
        return this.f57748b.m(i10, i11);
    }

    @Override // z5.g
    public xi.j<List<CommunitySearchHistoryBean>> n() {
        return this.f57747a.n();
    }

    @Override // z5.g
    public z<TopicListBean> o(final boolean z10, final int i10, final int i11) {
        return this.f57748b.o(z10, i10, i11).Y1(new dj.g() { // from class: z5.b
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f57736a.G(i10, z10, i11, (TopicListBean) obj);
            }
        });
    }

    @Override // z5.g
    public z<ArticleBean> p(int i10, @yt.k String str, @yt.l String str2, @yt.l String str3, int i11, @yt.l String str4, int i12, @yt.l String str5, @yt.l String str6, @yt.l String str7, @yt.l String str8, @yt.l String str9) {
        return this.f57748b.p(i10, str, str2, str3, i11, str4, i12, str5, str6, str7, str8, str9);
    }

    @Override // z5.g
    public z<BaseResponse> q(int i10) {
        return this.f57748b.q(i10);
    }

    @Override // z5.g
    public z<ArticleList> r(boolean z10) {
        z<ArticleList> zVarR = this.f57747a.r(z10);
        z<ArticleList> zVarR2 = this.f57748b.r(z10);
        final q qVar = this.f57747a;
        Objects.requireNonNull(qVar);
        return zVarR.L5(zVarR2.Y1(new dj.g() { // from class: z5.e
            @Override // dj.g
            public final void accept(Object obj) throws Throwable {
                qVar.T((ArticleList) obj);
            }
        })).L5(this.f57747a.r(true));
    }

    @Override // z5.g
    public xi.a s() {
        return this.f57747a.s();
    }

    @Override // z5.g
    public z<CommentListBean> t(int i10, String str, int i11, int i12) {
        return this.f57748b.t(i10, str, i11, i12);
    }

    @Override // z5.g
    public z<MyMessageBean> u(int i10, int i11) {
        return this.f57748b.u(i10, i11);
    }

    @Override // z5.g
    public z<CommentBean> v(int i10, int i11, int i12, int i13, int i14, int i15, String str) {
        return this.f57748b.v(i10, i11, i12, i13, i14, i15, str);
    }

    @Override // z5.g
    public z<HotSearchKeyword> w(boolean z10) {
        z<HotSearchKeyword> zVarW = this.f57747a.w(z10);
        z<HotSearchKeyword> zVarW2 = this.f57748b.w(z10);
        final q qVar = this.f57747a;
        Objects.requireNonNull(qVar);
        return zVarW.L5(zVarW2.Y1(new dj.g() { // from class: z5.d
            @Override // dj.g
            public final void accept(Object obj) throws Throwable {
                qVar.U((HotSearchKeyword) obj);
            }
        })).L5(this.f57747a.w(true));
    }

    @Override // z5.g
    public void x() {
        this.f57747a.x();
    }

    @Override // z5.g
    @yt.k
    public z<BaseResponse> y(int i10) {
        return this.f57748b.y(i10);
    }

    @Override // z5.g
    public z<LikeCommentBean> z(int i10) {
        return this.f57748b.z(i10);
    }
}
