package com.flydigi.community.ui.home;

import android.os.Bundle;
import android.view.View;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.community.R;
import com.flydigi.community.ui.article_list.BaseArticleListFragment;
import com.flydigi.community.ui.home.a;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.TopicBean;
import hk.m;
import i9.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nCommunityHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommunityHomeFragment.kt\ncom/flydigi/community/ui/home/CommunityHomeFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
public final class CommunityHomeFragment extends BaseArticleListFragment<a.InterfaceC0138a> implements a.b {

    @k
    public static final a A8 = new a(null);

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @l
    public CategoryItem f13886y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @k
    public i f13887z8 = new i();

    @t0({"SMAP\nCommunityHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommunityHomeFragment.kt\ncom/flydigi/community/ui/home/CommunityHomeFragment$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final CommunityHomeFragment a() {
            CommunityHomeFragment communityHomeFragment = new CommunityHomeFragment();
            communityHomeFragment.c5(androidx.core.os.e.a());
            return communityHomeFragment;
        }
    }

    @m
    @k
    public static final CommunityHomeFragment u6() {
        return A8.a();
    }

    public static final void v6(androidx.fragment.app.g it2) {
        f0.p(it2, "$it");
        ku.b.d(it2, h0.d.f(it2, R.color.white));
        ku.b.c(it2);
    }

    @Override // com.flydigi.community.ui.article_list.BaseArticleListFragment, com.flydigi.community.ui.article_list.k.b
    public void C1(boolean z10, @k List<ArticleBean> articles) {
        CategoryItem categoryItem;
        f0.p(articles, "articles");
        super.C1(z10, articles);
        if (!z10 || (categoryItem = this.f13886y8) == null) {
            return;
        }
        if (this.f13331r8.d2(categoryItem) >= 0) {
            this.f13331r8.L4(categoryItem);
        } else {
            this.f13331r8.S0(categoryItem);
            this.f13331r8.S0(this.f13887z8);
        }
    }

    @Override // com.flydigi.community.ui.home.a.b
    public void G1(int i10, @k List<TopicBean> topics) {
        z1 z1Var;
        f0.p(topics, "topics");
        CategoryItem categoryItem = this.f13886y8;
        if (categoryItem != null) {
            categoryItem.A(topics);
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            this.f13886y8 = new CategoryItem(topics);
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        q6(ArticleReadLog.f13283a);
        p6(new CommunityHomePresenter(this));
    }

    @Override // com.flydigi.community.ui.article_list.BaseArticleListFragment, eu.davidea.flexibleadapter.b.z
    public boolean M(@k View view, int i10) {
        ei.h hVarG2;
        f0.p(view, "view");
        if (super.M(view, i10) || (hVarG2 = this.f13331r8.g2(i10)) == null) {
            return false;
        }
        if (hVarG2 instanceof CategoryItem) {
            if (view.getId() != R.id.btn_more) {
                return false;
            }
            h3.a.j().d(a.b.f31926k).withParcelableArrayList(a.b.f31928m, new ArrayList<>(((CategoryItem) hVarG2).z())).navigation();
            return true;
        }
        if (!(hVarG2 instanceof i)) {
            return false;
        }
        int id2 = view.getId();
        if (id2 != R.id.btn_post) {
            if (!(id2 == R.id.btn_search || id2 == R.id.area_search)) {
                return false;
            }
            h3.a.j().d(a.b.f31921f).navigation();
        } else if (a5.f.i().o()) {
            h3.a.j().d(a.b.f31927l).navigation();
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
        return true;
    }

    @Override // com.flydigi.base.common.FZFragment
    public void S5() {
        final androidx.fragment.app.g gVarW1 = w1();
        if (gVarW1 != null) {
            H5().e(new Runnable() { // from class: com.flydigi.community.ui.home.b
                @Override // java.lang.Runnable
                public final void run() {
                    CommunityHomeFragment.v6(gVarW1);
                }
            });
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        y0(0, 0);
    }

    @Override // com.flydigi.community.ui.article_list.BaseArticleListFragment, com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        com.flydigi.userBehavior.a.a().b(X1(), "社区首页");
    }
}
