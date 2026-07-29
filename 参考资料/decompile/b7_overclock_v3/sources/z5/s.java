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
import com.flydigi.data.bean.community.MyLikeArticleBean;
import com.flydigi.data.bean.community.TopicBean;
import com.flydigi.data.bean.community.TopicListBean;
import java.util.List;
import m5.c0;
import m5.f0;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public class s implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x5.a f57768a = (x5.a) f0.i().k().g(x5.a.class);

    @Override // z5.g
    public z<ArticleBean> a(int i10, int i11) {
        return this.f57768a.a(i10, i11).s0(c0.p());
    }

    @Override // z5.g
    public z<CommentDetailBean> b(int i10, int i11, int i12, int i13) {
        return this.f57768a.b(i10, i11, i12, i13).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<BaseResponse> c(int i10) {
        return this.f57768a.c(i10).s0(c0.r()).s0(c0.t());
    }

    @Override // z5.g
    public z<TopicBean> d(int i10) {
        return this.f57768a.d(i10).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<ArticleList> e(int i10, int i11, String str, int i12, int i13) {
        return this.f57768a.x(i10, i11, str, i12, i13).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<LikeArticleBean> f(int i10) {
        return this.f57768a.f(i10).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<ArticleList> g(int i10, int i11, int i12, int i13) {
        return this.f57768a.g(i10, i11, i12, i13).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<List<ArticleBean>> h(int i10, int i11) {
        return this.f57768a.z(i10, i11, f0.f40651g).s0(c0.p()).s0(c0.t()).A3(b6.o.f9096a);
    }

    @Override // z5.g
    public z<ArticleBean> i(@yt.k String str, @yt.l String str2, @yt.l String str3, int i10, @yt.l String str4, int i11, @yt.l String str5, @yt.l String str6, @yt.l String str7, @yt.l String str8, @yt.l String str9) {
        return this.f57768a.o(str, str2, str3, i10, str4, i11, str5, str6, str7, str8, str9).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<MyMessageBean> j(int i10, int i11) {
        return this.f57768a.v(a5.f.i().l(), i10, i11, 2).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public xi.a k(String str) {
        return null;
    }

    @Override // z5.g
    public z<MyPublishedArticlesBean> l(int i10, int i11, int i12) {
        return this.f57768a.l(i10, i11, i12).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<List<ArticleBean>> m(int i10, int i11) {
        return this.f57768a.m(i10, i11).s0(c0.p()).A3(new dj.o() { // from class: z5.r
            @Override // dj.o
            public final Object apply(Object obj) {
                return ((MyLikeArticleBean) obj).getList();
            }
        }).s0(c0.t());
    }

    @Override // z5.g
    public xi.j<List<CommunitySearchHistoryBean>> n() {
        return null;
    }

    @Override // z5.g
    public z<TopicListBean> o(boolean z10, int i10, int i11) {
        return this.f57768a.y(z10 ? 1 : 0, i10, i11).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<ArticleBean> p(int i10, @yt.k String str, @yt.l String str2, @yt.l String str3, int i11, @yt.l String str4, int i12, @yt.l String str5, @yt.l String str6, @yt.l String str7, @yt.l String str8, @yt.l String str9) {
        return this.f57768a.t(i10, str, str2, str3, i11, str4, i12, str5, str6, str7, str8, str9).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<BaseResponse> q(int i10) {
        return this.f57768a.n(i10).s0(c0.r()).s0(c0.t());
    }

    @Override // z5.g
    public z<ArticleList> r(boolean z10) {
        return this.f57768a.w().s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public xi.a s() {
        return null;
    }

    @Override // z5.g
    public z<CommentListBean> t(int i10, String str, int i11, int i12) {
        return this.f57768a.A(i10, a5.f.i().l(), str, i11, i12).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<MyMessageBean> u(int i10, int i11) {
        return this.f57768a.v(a5.f.i().l(), i10, i11, 1).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<CommentBean> v(int i10, int i11, int i12, int i13, int i14, int i15, String str) {
        return this.f57768a.r(i10, i11, i12, i13, i14, i15, str).s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public z<HotSearchKeyword> w(boolean z10) {
        return this.f57768a.i().s0(c0.p()).s0(c0.t());
    }

    @Override // z5.g
    public void x() {
    }

    @Override // z5.g
    @yt.k
    public z<BaseResponse> y(int i10) {
        return this.f57768a.p(String.valueOf(i10)).s0(c0.r()).s0(c0.t());
    }

    @Override // z5.g
    public z<LikeCommentBean> z(int i10) {
        return this.f57768a.s(i10).s0(c0.p()).s0(c0.t());
    }
}
