package com.flydigi.community.ui.article_list;

import android.os.Bundle;
import com.blankj.utilcode.util.n0;
import com.flydigi.community.ui.article_list.d;
import com.flydigi.data.bean.community.NavBean;
import com.flydigi.data.bean.community.NoticeBean;
import hk.m;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nArticleListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArticleListFragment.kt\ncom/flydigi/community/ui/article_list/ArticleListFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
public final class ArticleListFragment extends BaseArticleListFragment<d.a> implements d.b {

    @yt.k
    public static final String A8 = "key_nav_id";

    @yt.k
    public static final String B8 = "key_topic_name";

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @yt.k
    public static final a f13800z8 = new a(null);

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public boolean f13801y8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @yt.k
        public final ArticleListFragment a(@yt.k String topicName, @yt.k NavBean nav) {
            f0.p(topicName, "topicName");
            f0.p(nav, "nav");
            ArticleListFragment articleListFragment = new ArticleListFragment();
            articleListFragment.c5(androidx.core.os.e.b(new Pair(ArticleListFragment.B8, topicName), new Pair(ArticleListFragment.A8, nav)));
            return articleListFragment;
        }
    }

    @m
    @yt.k
    public static final ArticleListFragment t6(@yt.k String str, @yt.k NavBean navBean) {
        return f13800z8.a(str, navBean);
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        String string;
        super.K3(bundle);
        Bundle bundleT1 = T1();
        NavBean navBean = bundleT1 != null ? (NavBean) bundleT1.getParcelable(A8) : null;
        if (navBean != null) {
            StringBuilder sb2 = new StringBuilder();
            Bundle bundleT12 = T1();
            if (bundleT12 == null || (string = bundleT12.getString(B8)) == null) {
                string = "";
            }
            sb2.append(string);
            sb2.append('_');
            sb2.append(navBean.getName());
            q6(sb2.toString());
            p6(new ArticleListPresenter(this, navBean.getTopicId(), navBean.getType()));
        }
    }

    @Override // com.flydigi.community.ui.article_list.BaseArticleListFragment
    public boolean m6() {
        return this.f13801y8;
    }

    @Override // com.flydigi.community.ui.article_list.BaseArticleListFragment
    public void r6(boolean z10) {
        this.f13801y8 = z10;
    }

    @Override // com.flydigi.community.ui.article_list.d.b
    public void z(@yt.k List<NoticeBean> notice) {
        f0.p(notice, "notice");
        this.f13331r8.B3();
        n0.z(notice);
        this.f13331r8.S0(new NoticeItem(notice));
    }
}
