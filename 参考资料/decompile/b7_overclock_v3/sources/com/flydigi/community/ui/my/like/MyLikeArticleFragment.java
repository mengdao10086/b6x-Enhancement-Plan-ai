package com.flydigi.community.ui.my.like;

import android.os.Bundle;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.community.ui.article_list.BaseArticleListFragment;
import com.flydigi.community.ui.my.like.a;
import hk.m;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class MyLikeArticleFragment extends BaseArticleListFragment<a.InterfaceC0143a> implements a.b {

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @k
    public static final a f13980y8 = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final MyLikeArticleFragment a() {
            MyLikeArticleFragment myLikeArticleFragment = new MyLikeArticleFragment();
            myLikeArticleFragment.c5(androidx.core.os.e.a());
            return myLikeArticleFragment;
        }
    }

    @m
    @k
    public static final MyLikeArticleFragment t6() {
        return f13980y8.a();
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        q6(ArticleReadLog.f13295m);
        p6(new MyLikeArticlePresenter(this));
    }
}
