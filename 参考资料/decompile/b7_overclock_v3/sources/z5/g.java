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
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public interface g {
    z<ArticleBean> a(int i10, int i11);

    z<CommentDetailBean> b(int i10, int i11, int i12, int i13);

    z<BaseResponse> c(int i10);

    z<TopicBean> d(int i10);

    z<ArticleList> e(int i10, int i11, String str, int i12, int i13);

    z<LikeArticleBean> f(int i10);

    z<ArticleList> g(int i10, int i11, int i12, int i13);

    z<List<ArticleBean>> h(int i10, int i11);

    z<ArticleBean> i(@yt.k String str, @yt.l String str2, @yt.l String str3, int i10, @yt.l String str4, int i11, @yt.l String str5, @yt.l String str6, @yt.l String str7, @yt.l String str8, @yt.l String str9);

    z<MyMessageBean> j(int i10, int i11);

    xi.a k(String str);

    z<MyPublishedArticlesBean> l(int i10, int i11, int i12);

    z<List<ArticleBean>> m(int i10, int i11);

    xi.j<List<CommunitySearchHistoryBean>> n();

    z<TopicListBean> o(boolean z10, int i10, int i11);

    z<ArticleBean> p(int i10, @yt.k String str, @yt.l String str2, @yt.l String str3, int i11, @yt.l String str4, int i12, @yt.l String str5, @yt.l String str6, @yt.l String str7, @yt.l String str8, @yt.l String str9);

    z<BaseResponse> q(int i10);

    z<ArticleList> r(boolean z10);

    xi.a s();

    z<CommentListBean> t(int i10, String str, int i11, int i12);

    z<MyMessageBean> u(int i10, int i11);

    z<CommentBean> v(int i10, int i11, int i12, int i13, int i14, int i15, String str);

    z<HotSearchKeyword> w(boolean z10);

    void x();

    @yt.k
    z<BaseResponse> y(int i10);

    z<LikeCommentBean> z(int i10);
}
