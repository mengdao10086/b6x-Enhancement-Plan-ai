package com.flydigi.community.ui.my.config;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.community.R;
import com.flydigi.community.ui.my.config.a;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.ReasonBean;
import i9.a;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class MySharedConfigFragment extends FZRecyclerViewFragment implements a.b {

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @k
    public static final a f13962x8 = new a(null);

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final int f13963y8 = 10;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public a.InterfaceC0142a f13964v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public boolean f13965w8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final MySharedConfigFragment a() {
            MySharedConfigFragment mySharedConfigFragment = new MySharedConfigFragment();
            mySharedConfigFragment.c5(androidx.core.os.e.a());
            return mySharedConfigFragment;
        }
    }

    public static final void m6(MySharedConfigFragment this$0, MySharedConfigItem item, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        f0.p(item, "$item");
        dialogFragment.I5();
        a.InterfaceC0142a interfaceC0142a = this$0.f13964v8;
        if (interfaceC0142a == null) {
            f0.S("mPresenter");
            interfaceC0142a = null;
        }
        interfaceC0142a.z(item);
    }

    public static final void s6(MySharedConfigFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.URL_WEB_HELP_SHARE_CONFIG).navigation(this$0.X1());
        dialogFragment.I5();
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        this.f13964v8 = new MySharedConfigPresenter(this);
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@k View view, int i10) {
        f0.p(view, "view");
        if (!this.f13965w8 && !d6()) {
            ei.h hVarG2 = this.f13331r8.g2(i10);
            if (hVarG2 instanceof MySharedConfigItem) {
                int id2 = view.getId();
                if (id2 == R.id.btn_edit) {
                    ArticleBean articleBeanZ = ((MySharedConfigItem) hVarG2).z();
                    f0.o(articleBeanZ, "item.data");
                    o6(articleBeanZ);
                } else if (id2 == R.id.btn_delete) {
                    l6((MySharedConfigItem) hVarG2);
                } else if (id2 == R.id.tv_state) {
                    MySharedConfigItem mySharedConfigItem = (MySharedConfigItem) hVarG2;
                    String status = mySharedConfigItem.z().getStatus();
                    ReasonBean reason = mySharedConfigItem.z().getReason();
                    p6(status, reason != null ? reason.getReason() : null);
                } else {
                    MySharedConfigItem mySharedConfigItem2 = (MySharedConfigItem) hVarG2;
                    if (f0.g(mySharedConfigItem2.z().getStatus(), ArticleBean.STATE_PUBLISHED)) {
                        h3.a.j().d(a.b.f31919d).withInt("id", mySharedConfigItem2.z().getId()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13293k).navigation();
                    }
                }
            }
        }
        return false;
    }

    @Override // com.flydigi.community.ui.my.config.a.b
    public void M2(@k MySharedConfigItem item) {
        f0.p(item, "item");
        ToastUtils.T(R.string.community_delete_complete);
        eu.davidea.flexibleadapter.b bVar = this.f13331r8;
        bVar.E3(bVar.d2(item));
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.community.ui.my.article.a.b
    public void b(boolean z10, @k Throwable throwable) {
        f0.p(throwable, "throwable");
        super.b(z10, throwable);
        this.f13965w8 = false;
    }

    @Override // com.flydigi.community.ui.my.config.a.b
    public void c(boolean z10, @k List<MySharedConfigItem> data) {
        f0.p(data, "data");
        this.f13965w8 = false;
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

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        O5(R.string.community_empty_shared_config, R.drawable.community_ic_empty);
    }

    public final void l6(final MySharedConfigItem mySharedConfigItem) {
        if (!NetworkUtils.K()) {
            ToastUtils.T(R.string.net_state_error);
        } else {
            o5.a.t0(U1(), new FZDialog.a().b(Boolean.FALSE).t(c3(R.string.community_delete_config_dialog_title)).j(c3(R.string.community_delete_config_dialog_content)).g(c3(R.string.delete)).h(R.color.base_color_assist_red).e(R.color.colorPrimary).f(new FZDialog.c() { // from class: com.flydigi.community.ui.my.config.c
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    MySharedConfigFragment.m6(this.f13972a, mySharedConfigItem, dialogFragment);
                }
            }).d(c3(R.string.cancel)).c(b6.c.f9082a).a());
        }
    }

    public final void n6() {
        this.f13329p8.z();
    }

    public final void o6(ArticleBean articleBean) {
        h3.a.j().d(a.b.f31927l).withParcelable(a.b.f31931p, articleBean).withInt(a.b.f31933r, 1).navigation(w1(), 8196);
    }

    public final void p6(String str, String str2) {
        if (str != null) {
            if (f0.g(str, ArticleBean.STATE_IN_AUDIT)) {
                q6();
            } else if (f0.g(str, "fail")) {
                r6(str2);
            }
        }
    }

    public final void q6() {
        o5.a.t0(U1(), new FZDialog.a().b(Boolean.FALSE).t(c3(R.string.community_comment_state_in_audit)).j(c3(R.string.community_comment_state_in_audit_content)).q(c3(R.string.confirm)).p(b6.c.f9082a).a());
    }

    public final void r6(String str) {
        if (str != null) {
            FZDialog.a aVarG = new FZDialog.a().b(Boolean.FALSE).t(c3(R.string.community_article_reject_title)).j(kotlin.text.u.l2(str, "\\n", "\n", false, 4, null)).l(17).g(c3(R.string.confirm));
            int i10 = R.color.colorPrimary;
            o5.a.t0(U1(), aVarG.h(i10).e(i10).f(b6.c.f9082a).d(c3(R.string.community_show_help)).c(new FZDialog.c() { // from class: com.flydigi.community.ui.my.config.b
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    MySharedConfigFragment.s6(this.f13971a, dialogFragment);
                }
            }).a());
        }
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        this.f13965w8 = true;
        a.InterfaceC0142a interfaceC0142a = this.f13964v8;
        if (interfaceC0142a == null) {
            f0.S("mPresenter");
            interfaceC0142a = null;
        }
        interfaceC0142a.P(i11 + 1, 10);
    }
}
