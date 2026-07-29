package com.flydigi.community.ui.my.article;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.community.R;
import com.flydigi.community.ui.my.article.a;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.ArticleBean;
import i9.a;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class MyArticleFragment extends FZRecyclerViewFragment implements a.b {

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @k
    public static final a f13944x8 = new a(null);

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final int f13945y8 = 10;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public a.InterfaceC0141a f13946v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public boolean f13947w8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final MyArticleFragment a() {
            MyArticleFragment myArticleFragment = new MyArticleFragment();
            myArticleFragment.c5(androidx.core.os.e.a());
            return myArticleFragment;
        }
    }

    public static final void m6(MyArticleFragment this$0, MyArticleItem item, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(item, "$item");
        dialogFragment.I5();
        a.InterfaceC0141a interfaceC0141a = this$0.f13946v8;
        if (interfaceC0141a == null) {
            f0.S("mPresenter");
            interfaceC0141a = null;
        }
        interfaceC0141a.V(item);
    }

    public static final void o6(MyArticleFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.f13329p8.z();
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        this.f13946v8 = new MyArticlePresenter(this);
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@k View view, int i10) {
        f0.p(view, "view");
        if (!this.f13947w8 && !d6()) {
            ei.h hVarG2 = this.f13331r8.g2(i10);
            if (hVarG2 instanceof MyArticleItem) {
                int id2 = view.getId();
                if (id2 == R.id.btn_edit) {
                    ArticleBean articleBeanZ = ((MyArticleItem) hVarG2).z();
                    f0.o(articleBeanZ, "item.data");
                    p6(articleBeanZ);
                } else if (id2 == R.id.btn_delete) {
                    l6((MyArticleItem) hVarG2);
                } else {
                    MyArticleItem myArticleItem = (MyArticleItem) hVarG2;
                    if (f0.g(myArticleItem.z().getStatus(), ArticleBean.STATE_PUBLISHED)) {
                        h3.a.j().d(a.b.f31919d).withInt("id", myArticleItem.z().getId()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13293k).withParcelable(a.b.f31931p, myArticleItem.z()).navigation();
                    }
                }
            }
        }
        return false;
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.community.ui.my.article.a.b
    public void b(boolean z10, @k Throwable throwable) {
        f0.p(throwable, "throwable");
        super.b(z10, throwable);
        this.f13947w8 = false;
    }

    @Override // com.flydigi.community.ui.my.article.a.b
    public void c(boolean z10, @k List<MyArticleItem> data) {
        f0.p(data, "data");
        this.f13947w8 = false;
        if (z10) {
            this.f13331r8.I4(data);
        } else {
            this.f13331r8.r3(data);
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    public int c6() {
        return 10;
    }

    @Override // com.flydigi.community.ui.my.article.a.b
    public void i1(@k MyArticleItem item) {
        f0.p(item, "item");
        ToastUtils.T(R.string.community_delete_complete);
        eu.davidea.flexibleadapter.b bVar = this.f13331r8;
        bVar.E3(bVar.d2(item));
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        O5(R.string.community_empty_published_article, R.drawable.community_ic_empty);
    }

    public final void l6(final MyArticleItem myArticleItem) {
        if (!NetworkUtils.K()) {
            ToastUtils.T(R.string.net_state_error);
        } else {
            o5.a.t0(U1(), new FZDialog.a().b(Boolean.FALSE).t(c3(R.string.community_delete_config_dialog_title)).j(c3(R.string.community_delete_config_dialog_content)).g(c3(R.string.delete)).h(R.color.base_color_assist_red).e(R.color.colorPrimary).f(new FZDialog.c() { // from class: com.flydigi.community.ui.my.article.b
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    MyArticleFragment.m6(this.f13953a, myArticleItem, dialogFragment);
                }
            }).d(c3(R.string.cancel)).c(b6.c.f9082a).a());
        }
    }

    public final void n6() {
        this.f13330q8.D1(0);
        this.f13330q8.post(new Runnable() { // from class: com.flydigi.community.ui.my.article.c
            @Override // java.lang.Runnable
            public final void run() {
                MyArticleFragment.o6(this.f13955a);
            }
        });
    }

    public final void p6(ArticleBean articleBean) {
        h3.a.j().d(a.b.f31927l).withParcelable(a.b.f31931p, articleBean).navigation(w1(), 8196);
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        this.f13947w8 = true;
        a.InterfaceC0141a interfaceC0141a = this.f13946v8;
        if (interfaceC0141a == null) {
            f0.S("mPresenter");
            interfaceC0141a = null;
        }
        interfaceC0141a.D(i11 + 1, 10);
    }
}
