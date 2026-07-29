package z5;

import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.f1;
import com.blankj.utilcode.util.j1;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DBManager;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.List;
import xi.e0;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public class q implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f57763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f57764b;

    public class a extends TypeToken<List<ArticleBean>> {
        public a() {
        }
    }

    public class b extends TypeToken<List<ArticleBean>> {
        public b() {
        }
    }

    public q() {
        File file = new File(j1.a().getCacheDir(), "api");
        this.f57763a = file;
        b0.k(file);
        this.f57764b = new Gson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ HotSearchKeyword J(String str) throws Exception {
        return (HotSearchKeyword) this.f57764b.fromJson(str, HotSearchKeyword.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ File K(int i10, int i11, File file) throws Exception {
        return new File(this.f57763a, "getRecommendArticles#" + i10 + "#" + i11);
    }

    public static /* synthetic */ String L(File file) throws Exception {
        return !file.exists() ? "" : a0.q(file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ e0 M(String str) throws Exception {
        return (str == null || str.length() == 0) ? z.e2() : z.m3((List) this.f57764b.fromJson(str, new a().getType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ArticleList N(String str) throws Exception {
        return (ArticleList) this.f57764b.fromJson(str, ArticleList.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ File O(boolean z10, int i10, int i11, File file) throws Exception {
        return new File(this.f57763a, "getTopics#" + z10 + "#" + i10 + "#" + i11);
    }

    public static /* synthetic */ String P(File file) throws Exception {
        return (b0.g0(file) && f1.J0(b0.H(file))) ? a0.q(file) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ e0 Q(String str) throws Exception {
        return (str == null || str.length() == 0) ? z.e2() : z.m3((TopicListBean) this.f57764b.fromJson(str, TopicListBean.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ArticleList R(String str) throws Exception {
        return (ArticleList) this.f57764b.fromJson(str, ArticleList.class);
    }

    public void S() {
        b0.q(this.f57763a);
    }

    public void T(ArticleList articleList) throws Throwable {
        if (articleList.getList() == null || articleList.getList().isEmpty()) {
            return;
        }
        a0.U(new File(this.f57763a, "hotSearchArticles"), this.f57764b.toJson(articleList), false);
    }

    public void U(HotSearchKeyword hotSearchKeyword) throws Throwable {
        if (hotSearchKeyword.getKeywordList() == null || hotSearchKeyword.getKeywordList().isEmpty()) {
            return;
        }
        a0.U(new File(this.f57763a, "hotSearchKeywords"), this.f57764b.toJson(hotSearchKeyword), false);
    }

    public void V(List<ArticleBean> list, int i10, int i11) throws Throwable {
        a0.U(new File(this.f57763a, "getRecommendArticles#" + i10 + "#" + i11), this.f57764b.toJson(list, new b().getType()), false);
    }

    public void W(String str, ArticleList articleList) throws Throwable {
        a0.U(new File(this.f57763a, "search#" + str), this.f57764b.toJson(articleList), false);
    }

    public void X(TopicListBean topicListBean, boolean z10, int i10, int i11) throws Throwable {
        a0.U(new File(this.f57763a, "getTopics#" + z10 + "#" + i10 + "#" + i11), this.f57764b.toJson(topicListBean), false);
    }

    @Override // z5.g
    public z<ArticleBean> a(int i10, int i11) {
        return null;
    }

    @Override // z5.g
    public z<CommentDetailBean> b(int i10, int i11, int i12, int i13) {
        return null;
    }

    @Override // z5.g
    public z<BaseResponse> c(int i10) {
        return null;
    }

    @Override // z5.g
    public z<TopicBean> d(int i10) {
        return null;
    }

    @Override // z5.g
    public z<ArticleList> e(int i10, int i11, String str, int i12, int i13) {
        String str2 = str + "#" + i10 + "#" + i11 + "#" + i12;
        File file = new File(this.f57763a, "search#" + str2);
        return file.exists() ? z.m3(file).A3(b7.g.f9102a).A3(new dj.o() { // from class: z5.k
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f57752a.R((String) obj);
            }
        }) : z.e2();
    }

    @Override // z5.g
    public z<LikeArticleBean> f(int i10) {
        return null;
    }

    @Override // z5.g
    public z<ArticleList> g(int i10, int i11, int i12, int i13) {
        return null;
    }

    @Override // z5.g
    public z<List<ArticleBean>> h(final int i10, final int i11) {
        return z.m3(this.f57763a).A3(new dj.o() { // from class: z5.m
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f57754a.K(i10, i11, (File) obj);
            }
        }).A3(new dj.o() { // from class: z5.p
            @Override // dj.o
            public final Object apply(Object obj) {
                return q.L((File) obj);
            }
        }).l2(new dj.o() { // from class: z5.l
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f57753a.M((String) obj);
            }
        });
    }

    @Override // z5.g
    public z<ArticleBean> i(@yt.k String str, @yt.l String str2, @yt.l String str3, int i10, @yt.l String str4, int i11, @yt.l String str5, @yt.l String str6, @yt.l String str7, @yt.l String str8, @yt.l String str9) {
        return z.e2();
    }

    @Override // z5.g
    public z<MyMessageBean> j(int i10, int i11) {
        return z.e2();
    }

    @Override // z5.g
    public xi.a k(String str) {
        return DBManager.getInstance().updateCommunitySearchHistory(str);
    }

    @Override // z5.g
    public z<MyPublishedArticlesBean> l(int i10, int i11, int i12) {
        return z.e2();
    }

    @Override // z5.g
    public z<List<ArticleBean>> m(int i10, int i11) {
        return z.e2();
    }

    @Override // z5.g
    public xi.j<List<CommunitySearchHistoryBean>> n() {
        return DBManager.getInstance().getCommunitySearchHistory();
    }

    @Override // z5.g
    public z<TopicListBean> o(final boolean z10, final int i10, final int i11) {
        return z.m3(this.f57763a).A3(new dj.o() { // from class: z5.n
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f57757a.O(z10, i10, i11, (File) obj);
            }
        }).A3(new dj.o() { // from class: z5.o
            @Override // dj.o
            public final Object apply(Object obj) {
                return q.P((File) obj);
            }
        }).l2(new dj.o() { // from class: z5.j
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f57751a.Q((String) obj);
            }
        });
    }

    @Override // z5.g
    public z<ArticleBean> p(int i10, @yt.k String str, @yt.l String str2, @yt.l String str3, int i11, @yt.l String str4, int i12, @yt.l String str5, @yt.l String str6, @yt.l String str7, @yt.l String str8, @yt.l String str9) {
        return z.e2();
    }

    @Override // z5.g
    public z<BaseResponse> q(int i10) {
        return null;
    }

    @Override // z5.g
    public z<ArticleList> r(boolean z10) {
        File file = new File(this.f57763a, "hotSearchArticles");
        if (file.exists()) {
            long jH = b0.H(file);
            if (z10 || f1.J0(jH)) {
                return z.m3(file).A3(b7.g.f9102a).A3(new dj.o() { // from class: z5.i
                    @Override // dj.o
                    public final Object apply(Object obj) {
                        return this.f57750a.N((String) obj);
                    }
                });
            }
        }
        return z.e2();
    }

    @Override // z5.g
    public xi.a s() {
        return DBManager.getInstance().deleteCommunitySearchHistory();
    }

    @Override // z5.g
    public z<CommentListBean> t(int i10, String str, int i11, int i12) {
        return null;
    }

    @Override // z5.g
    public z<MyMessageBean> u(int i10, int i11) {
        return z.e2();
    }

    @Override // z5.g
    public z<CommentBean> v(int i10, int i11, int i12, int i13, int i14, int i15, String str) {
        return null;
    }

    @Override // z5.g
    public z<HotSearchKeyword> w(boolean z10) {
        File file = new File(this.f57763a, "hotSearchKeywords");
        if (file.exists()) {
            long jH = b0.H(file);
            if (z10 || f1.J0(jH)) {
                return z.m3(file).A3(b7.g.f9102a).A3(new dj.o() { // from class: z5.h
                    @Override // dj.o
                    public final Object apply(Object obj) {
                        return this.f57749a.J((String) obj);
                    }
                });
            }
        }
        return z.e2();
    }

    @Override // z5.g
    public void x() {
        for (File file : b0.m0(this.f57763a)) {
            if (file.getName().startsWith("search#")) {
                b0.o(file);
            }
        }
    }

    @Override // z5.g
    @yt.k
    public z<BaseResponse> y(int i10) {
        return z.e2();
    }

    @Override // z5.g
    public z<LikeCommentBean> z(int i10) {
        return null;
    }
}
