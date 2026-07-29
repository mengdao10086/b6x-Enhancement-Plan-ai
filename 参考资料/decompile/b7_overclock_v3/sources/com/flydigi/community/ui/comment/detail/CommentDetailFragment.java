package com.flydigi.community.ui.comment.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.o;
import com.flydigi.community.R;
import com.flydigi.community.ui.comment.CommentItem;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.flydigi.community.ui.comment.InputDialogFragment;
import com.flydigi.community.ui.comment.detail.b;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.CommentBean;
import com.flydigi.data.bean.community.CommentDetailArticleBean;
import com.flydigi.data.bean.community.User;
import i9.a;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class CommentDetailFragment extends CommentListFragment implements b.InterfaceC0137b {

    @k
    public static final a Z8 = new a(null);
    public b.a V8;
    public int W8;

    @l
    public CommentBean X8;

    @l
    public b Y8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final CommentDetailFragment a(int i10, int i11, int i12, int i13) {
            CommentDetailFragment commentDetailFragment = new CommentDetailFragment();
            commentDetailFragment.c5(androidx.core.os.e.b(new Pair(CommentListFragment.M8, Integer.valueOf(i10)), new Pair(CommentListFragment.N8, Integer.valueOf(i11)), new Pair(CommentListFragment.P8, Integer.valueOf(i12)), new Pair(DataConstant.COMMUNITY_MESSAGE_ID, Integer.valueOf(i13))));
            return commentDetailFragment;
        }
    }

    public interface b extends CommentListFragment.b {
        void P(@k CommentBean commentBean, int i10);
    }

    public static final void S6(CommentDetailFragment this$0, CommentBean it2, boolean z10, int i10) {
        f0.p(this$0, "this$0");
        f0.p(it2, "$it");
        this$0.f13331r8.B3();
        this$0.f13331r8.S0(new CommentHostItem(it2, z10));
        b bVar = this$0.Y8;
        if (bVar != null) {
            bVar.P(it2, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.community.ui.comment.CommentListFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.Y8 = (b) context;
        }
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment, com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        this.V8 = new CommentDetailPresenter(this);
        Bundle bundleT1 = T1();
        this.W8 = bundleT1 != null ? bundleT1.getInt(DataConstant.COMMUNITY_MESSAGE_ID) : 0;
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment, eu.davidea.flexibleadapter.b.z
    public boolean M(@k View view, int i10) {
        f0.p(view, "view");
        ei.h hVarG2 = this.f13331r8.g2(i10);
        if (!(hVarG2 instanceof CommentHostItem)) {
            return super.M(view, i10);
        }
        CommentBean commentBeanZ = ((CommentHostItem) hVarG2).z();
        int id2 = view.getId();
        if (id2 == R.id.tv_like_num) {
            if (commentBeanZ.isDelByOp() == 1) {
                o.E(c3(R.string.community_comment_is_deleted));
                return false;
            }
            if (!a5.f.i().o()) {
                h3.a.j().d(a.C0378a.f31905b).navigation();
            } else if (n0.b(a5.f.i().l(), String.valueOf(commentBeanZ.getFromUserId()))) {
                o.E(c3(R.string.community_can_not_prize_self));
            } else if (commentBeanZ.isLiked() == 1) {
                u6().N(i10, commentBeanZ.getId());
            } else {
                u6().C(i10, commentBeanZ.getId());
            }
        } else if (id2 == R.id.btn_more_action) {
            P6(commentBeanZ.getId(), -1);
        } else if (!y6()) {
            N6(commentBeanZ.getId());
            O6(commentBeanZ.getFromUserId());
            b bVar = this.Y8;
            if (bVar != null) {
                User user = commentBeanZ.getUser();
                bVar.O(user != null ? user.getUsername() : null);
            }
        }
        return false;
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment, com.flydigi.community.ui.comment.d.b
    public void N2(@k CommentBean comment, int i10) {
        f0.p(comment, "comment");
        o.E(c3(R.string.community_comment_success));
        u9.h.i(X1(), o6(), p6(), v6(), "评论");
        CommentBean it2 = comment.getChild().get(0);
        eu.davidea.flexibleadapter.b bVar = this.f13331r8;
        f0.o(it2, "it");
        bVar.J0(1, z6(it2));
        InputDialogFragment inputDialogFragmentS6 = s6();
        if (inputDialogFragmentS6 != null) {
            inputDialogFragmentS6.e6();
        }
        b bVar2 = this.Y8;
        if (bVar2 != null) {
            bVar2.P2(comment);
        }
        N6(0);
        O6(0);
    }

    @Override // com.flydigi.community.ui.comment.detail.b.InterfaceC0137b
    public void R(@l final CommentBean commentBean, @l CommentDetailArticleBean commentDetailArticleBean, final int i10) {
        final boolean z10 = false;
        E6(commentDetailArticleBean != null ? commentDetailArticleBean.getInfoId() : 0);
        this.X8 = commentBean;
        if (commentBean != null) {
            K6(commentBean.getId());
            I6(commentBean.getFromUserId());
            if ((n0.b(Integer.valueOf(r6()), a5.f.i().l()) || n0.b(String.valueOf(q6()), a5.f.i().l())) && commentBean.isDelByOp() == 0) {
                z10 = true;
            }
            H5().e(new Runnable() { // from class: com.flydigi.community.ui.comment.detail.c
                @Override // java.lang.Runnable
                public final void run() {
                    CommentDetailFragment.S6(this.f13854a, commentBean, z10, i10);
                }
            });
        }
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment, com.flydigi.community.ui.comment.d.b
    public void d1(int i10) {
        if (i10 != -1) {
            super.d1(i10);
            return;
        }
        androidx.fragment.app.g gVarW1 = w1();
        if (gVarW1 != null) {
            gVarW1.finish();
        }
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment, com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        this.f13329p8.C(true);
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment, eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        b.a aVar = this.V8;
        if (aVar == null) {
            f0.S("presenter");
            aVar = null;
        }
        aVar.b(t6(), i11 + 1, 10, this.W8);
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment
    @k
    public CommentItem z6(@k CommentBean it2) {
        f0.p(it2, "it");
        return new CommentItem(it2, q6(), true);
    }
}
