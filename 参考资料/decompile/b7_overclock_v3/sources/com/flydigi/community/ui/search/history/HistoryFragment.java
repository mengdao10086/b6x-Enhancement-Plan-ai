package com.flydigi.community.ui.search.history;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.b1;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.TagFlowLayout;
import com.flydigi.community.R;
import com.flydigi.community.ui.search.history.HotArticleItem;
import com.flydigi.community.ui.search.history.a;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.CommunitySearchHistoryBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.yqritc.recyclerviewflexibledivider.a;
import dj.g;
import dj.o;
import eu.davidea.flexibleadapter.b;
import g.n0;
import g.p0;
import i9.a;
import java.util.List;
import o5.l;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public class HistoryFragment extends FZFragment implements a.b, b.z {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public a.InterfaceC0146a f14050o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public View f14051p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public TagFlowLayout<String> f14052q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public View f14053r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public TagFlowLayout<String> f14054s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public View f14055t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public RecyclerView f14056u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public eu.davidea.flexibleadapter.b<HotArticleItem> f14057v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public c f14058w8;

    public class a extends TagFlowLayout.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f14059b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List list, List list2) {
            super(list);
            this.f14059b = list2;
        }

        @Override // com.flydigi.base.widget.TagFlowLayout.a
        public View c(int i10) {
            View viewInflate = LayoutInflater.from(HistoryFragment.this.X1()).inflate(R.layout.community_item_search_keyword, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.tv_keyword)).setText(((CommunitySearchHistoryBean) this.f14059b.get(i10)).getKeyword());
            return viewInflate;
        }
    }

    public class b extends TagFlowLayout.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f14061b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, List list2) {
            super(list);
            this.f14061b = list2;
        }

        @Override // com.flydigi.base.widget.TagFlowLayout.a
        public View c(int i10) {
            View viewInflate = LayoutInflater.from(HistoryFragment.this.X1()).inflate(R.layout.community_item_search_keyword, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.tv_keyword)).setText((CharSequence) this.f14061b.get(i10));
            return viewInflate;
        }
    }

    public interface c {
        void R0(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f6(List list) throws Exception {
        this.f14057v8.I4(list);
        this.f14055t8.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g6(Throwable th2) throws Exception {
        this.f14055t8.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h6(List list, int i10, View view) {
        this.f14058w8.R0("hot", (String) list.get(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i6(DialogFragment dialogFragment) {
        this.f14050o8.s();
        dialogFragment.I5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j6(View view) {
        new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.community_hint_delete_search_history)).g(c3(android.R.string.ok)).d(c3(android.R.string.cancel)).c(b6.c.f9082a).f(new FZDialog.c() { // from class: b6.b
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                this.f9081a.i6(dialogFragment);
            }
        }).b(Boolean.FALSE).a().Z5(L2(), FZDialog.class.getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k6(List list, int i10, View view) {
        String keyword = ((CommunitySearchHistoryBean) list.get(i10)).getKeyword();
        this.f14050o8.k(keyword);
        this.f14058w8.R0("history", keyword);
    }

    public static HistoryFragment l6() {
        Bundle bundle = new Bundle();
        HistoryFragment historyFragment = new HistoryFragment();
        historyFragment.c5(bundle);
        return historyFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@n0 Context context) {
        super.H3(context);
        this.f14058w8 = (c) context;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        this.f14050o8 = new HistoryPresenter(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.community_fragment_search;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(View view, int i10) {
        HotArticleItem hotArticleItem = (HotArticleItem) this.f14057v8.g2(i10);
        if (hotArticleItem == null) {
            return false;
        }
        h3.a.j().d(a.b.f31919d).withInt("id", hotArticleItem.z().getId()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13283a).navigation();
        return true;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void U3(boolean z10) {
        super.U3(z10);
        if (z10) {
            return;
        }
        com.flydigi.userBehavior.a.a().b(X1(), "社区_搜索首页");
    }

    @Override // com.flydigi.community.ui.search.history.a.b
    public void W1(List<ArticleBean> list) {
        if (list == null || list.isEmpty()) {
            View view = this.f14055t8;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            this.f14055t8.setVisibility(8);
            return;
        }
        if (this.f14056u8 == null) {
            RecyclerView recyclerView = (RecyclerView) F5(R.id.recycler_view);
            this.f14056u8 = recyclerView;
            recyclerView.n(new a.C0280a(X1()).j(R.color.colorDivider).t(b1.b(0.5f)).y());
            this.f14055t8 = (View) this.f14056u8.getParent();
        }
        if (this.f14057v8 == null) {
            this.f14057v8 = new eu.davidea.flexibleadapter.b<>(null, this);
        }
        if (this.f14056u8.getAdapter() == null) {
            this.f14056u8.setAdapter(this.f14057v8);
        }
        z.P2(list).A3(new o() { // from class: b6.h
            @Override // dj.o
            public final Object apply(Object obj) {
                return new HotArticleItem((ArticleBean) obj);
            }
        }).Y6().v1().s0(l.d()).F5(new g() { // from class: b6.g
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f9088a.f6((List) obj);
            }
        }, new g() { // from class: b6.f
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f9087a.g6((Throwable) obj);
            }
        });
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        com.flydigi.userBehavior.a.a().b(X1(), "社区_搜索首页");
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        this.f14050o8.n();
        this.f14050o8.M();
    }

    @Override // com.flydigi.community.ui.search.history.a.b
    public void i2(final List<CommunitySearchHistoryBean> list) {
        if (list == null || list.isEmpty()) {
            View view = this.f14051p8;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            this.f14051p8.setVisibility(8);
            return;
        }
        if (this.f14052q8 == null) {
            this.f14052q8 = (TagFlowLayout) F5(R.id.area_search_history_keywords);
            ((ImageButton) F5(R.id.btn_delete)).setOnClickListener(new View.OnClickListener() { // from class: b6.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f9080a.j6(view2);
                }
            });
            this.f14051p8 = (View) this.f14052q8.getParent();
        }
        this.f14052q8.setAdapter(new a(list, list));
        this.f14052q8.setOnItemClickListener(new TagFlowLayout.b() { // from class: b6.e
            @Override // com.flydigi.base.widget.TagFlowLayout.b
            public final void a(int i10, View view2) {
                this.f9085a.k6(list, i10, view2);
            }
        });
        this.f14051p8.setVisibility(0);
    }

    public void m6(String str) {
        if (this.f14050o8 == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f14050o8.k(str);
    }

    @Override // com.flydigi.community.ui.search.history.a.b
    public void u(final List<String> list) {
        if (list == null || list.isEmpty()) {
            View view = this.f14053r8;
            if (view == null || view.getVisibility() != 0) {
                return;
            }
            this.f14053r8.setVisibility(8);
            return;
        }
        if (this.f14054s8 == null) {
            TagFlowLayout<String> tagFlowLayout = (TagFlowLayout) F5(R.id.area_search_hot_keywords);
            this.f14054s8 = tagFlowLayout;
            this.f14053r8 = (View) tagFlowLayout.getParent();
        }
        this.f14054s8.setAdapter(new b(list, list));
        this.f14054s8.setOnItemClickListener(new TagFlowLayout.b() { // from class: b6.d
            @Override // com.flydigi.base.widget.TagFlowLayout.b
            public final void a(int i10, View view2) {
                this.f9083a.h6(list, i10, view2);
            }
        });
        this.f14053r8.setVisibility(0);
    }
}
