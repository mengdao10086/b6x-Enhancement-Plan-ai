package com.flydigi.community.ui.comment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.community.R;
import com.flydigi.community.ui.comment.MoreActionDialogFragment;
import com.flydigi.community.ui.comment.d;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.CommentBean;
import com.flydigi.data.bean.community.User;
import com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration;
import com.yqritc.recyclerviewflexibledivider.a;
import i9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nCommentListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentListFragment.kt\ncom/flydigi/community/ui/comment/CommentListFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,400:1\n1549#2:401\n1620#2,3:402\n1#3:405\n*S KotlinDebug\n*F\n+ 1 CommentListFragment.kt\ncom/flydigi/community/ui/comment/CommentListFragment\n*L\n131#1:401\n131#1:402,3\n*E\n"})
public class CommentListFragment extends FZRecyclerViewFragment implements d.b {

    @yt.k
    public static final a L8 = new a(null);

    @yt.k
    public static final String M8 = "article_id";

    @yt.k
    public static final String N8 = "author_id";

    @yt.k
    public static final String O8 = "article_type";

    @yt.k
    public static final String P8 = "key_comment_parent_id";

    @yt.k
    public static final String Q8 = "key_comment_parent_uid";

    @yt.k
    public static final String R8 = "key_closed";

    @yt.k
    public static final String S8 = "id";

    @yt.k
    public static final String T8 = "zan";
    public static final int U8 = 10;

    @yt.l
    public String B8;
    public boolean C8;
    public int D8;
    public int E8;
    public int F8;
    public int G8;
    public int H8;
    public int I8;
    public int J8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public d.a f13826v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public b f13827w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.l
    public InputDialogFragment f13828x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @yt.k
    public u f13829y8 = new u();

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @yt.k
    public com.flydigi.community.ui.comment.b f13830z8 = new com.flydigi.community.ui.comment.b(0);

    @yt.k
    public String A8 = "zan";
    public int K8 = -1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final CommentListFragment a(int i10, int i11, int i12, @yt.k String source, boolean z10, int i13, int i14) {
            f0.p(source, "source");
            CommentListFragment commentListFragment = new CommentListFragment();
            commentListFragment.c5(androidx.core.os.e.b(new Pair(CommentListFragment.M8, Integer.valueOf(i10)), new Pair(CommentListFragment.O8, Integer.valueOf(i11)), new Pair(CommentListFragment.N8, Integer.valueOf(i12)), new Pair(CommentListFragment.R8, Boolean.valueOf(z10)), new Pair(CommentListFragment.P8, Integer.valueOf(i13)), new Pair(CommentListFragment.Q8, Integer.valueOf(i14)), new Pair(DataConstant.COMMUNITY_ARTICLE_SOURCE, source)));
            return commentListFragment;
        }
    }

    public interface b {

        public static final class a {
            public static /* synthetic */ void a(b bVar, String str, int i10, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInputDialog");
                }
                if ((i10 & 1) != 0) {
                    str = null;
                }
                bVar.O(str);
            }
        }

        void O(@yt.l String str);

        void P2(@yt.k CommentBean commentBean);
    }

    public static final class c implements MoreActionDialogFragment.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f13833c;

        public c(int i10, int i11) {
            this.f13832b = i10;
            this.f13833c = i11;
        }

        @Override // com.flydigi.community.ui.comment.MoreActionDialogFragment.b
        public void a() {
            CommentListFragment.this.C6(this.f13832b, this.f13833c);
        }
    }

    public static final boolean A6(int i10, RecyclerView recyclerView) {
        return i10 == 0;
    }

    public static final void B6(CommentListFragment this$0, mg.j it2) {
        f0.p(this$0, "this$0");
        f0.p(it2, "it");
        this$0.y0(this$0.f13331r8.getItemCount(), this$0.f13331r8.l2() / 10);
    }

    public static final void D6(CommentListFragment this$0, int i10, int i11, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        this$0.u6().L(i10, i11);
        dialogFragment.I5();
    }

    public static final void Q6(CommentListFragment this$0) {
        f0.p(this$0, "this$0");
        if (this$0.f13331r8.d2(this$0.f13830z8) < 0) {
            this$0.f13331r8.S0(this$0.f13830z8);
        } else {
            this$0.f13331r8.L4(this$0.f13830z8);
        }
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void B(@yt.l String str) {
        if (str != null) {
            com.flydigi.base.common.o.E(str);
        }
        this.I8 = 0;
        this.J8 = 0;
        this.K8 = -1;
    }

    public final void C6(final int i10, final int i11) {
        if (i10 == 0) {
            com.flydigi.base.common.o.E(c3(R.string.community_delete_message_error));
        } else {
            o5.a.t0(U1(), new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.community_delete_message_hint)).g(c3(android.R.string.ok)).d(c3(android.R.string.cancel)).c(b6.c.f9082a).f(new FZDialog.c() { // from class: com.flydigi.community.ui.comment.e
                @Override // com.flydigi.base.widget.FZDialog.c
                public final void a(DialogFragment dialogFragment) {
                    CommentListFragment.D6(this.f13863a, i11, i10, dialogFragment);
                }
            }).b(Boolean.FALSE).a());
        }
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void E2(@yt.l String str) {
        if (str != null) {
            com.flydigi.base.common.o.E(str);
        }
    }

    public final void E6(int i10) {
        this.E8 = i10;
    }

    public final void F6(int i10) {
        this.D8 = i10;
    }

    public final void G6(int i10) {
        this.F8 = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f13827w8 = (b) context;
        }
    }

    public final void H6(boolean z10) {
        this.C8 = z10;
    }

    public final void I6(int i10) {
        this.H8 = i10;
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, eu.davidea.flexibleadapter.b.s
    public void J(int i10) {
        this.f13329p8.w();
    }

    public final void J6(@yt.l InputDialogFragment inputDialogFragment) {
        this.f13828x8 = inputDialogFragment;
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void K(@yt.l String str) {
        f0.m(str);
        com.flydigi.base.common.o.E(str);
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void K1(@yt.l String str) {
        if (str != null) {
            com.flydigi.base.common.o.E(str);
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        L6(new CommentListPresenter(this));
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.E8 = bundleT1.getInt(M8);
            this.D8 = bundleT1.getInt(O8);
            this.F8 = bundleT1.getInt(N8);
            this.C8 = bundleT1.getBoolean(R8);
            this.B8 = bundleT1.getString(DataConstant.COMMUNITY_ARTICLE_SOURCE);
            this.G8 = bundleT1.getInt(P8);
            this.H8 = bundleT1.getInt(Q8);
        }
    }

    public final void K6(int i10) {
        this.G8 = i10;
    }

    public final void L6(@yt.k d.a aVar) {
        f0.p(aVar, "<set-?>");
        this.f13826v8 = aVar;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        f0.p(view, "view");
        if (d6()) {
            return false;
        }
        ei.h hVarG2 = this.f13331r8.g2(i10);
        if (hVarG2 instanceof com.flydigi.community.ui.comment.b) {
            if (view.getId() == R.id.tv_sort) {
                if (f0.g(this.A8, "id")) {
                    this.A8 = "zan";
                } else if (f0.g(this.A8, "zan")) {
                    this.A8 = "id";
                }
                y0(0, 0);
            }
        } else if (hVarG2 instanceof CommentItem) {
            CommentBean commentBeanZ = ((CommentItem) hVarG2).z();
            int id2 = view.getId();
            if (id2 == R.id.tv_like_num) {
                if (commentBeanZ.isDelByOp() == 1) {
                    com.flydigi.base.common.o.E(c3(R.string.community_comment_is_deleted));
                    return false;
                }
                if (!a5.f.i().o()) {
                    h3.a.j().d(a.C0378a.f31905b).navigation();
                } else if (n0.b(a5.f.i().l(), String.valueOf(commentBeanZ.getFromUserId()))) {
                    com.flydigi.base.common.o.E(c3(R.string.community_can_not_prize_self));
                } else if (commentBeanZ.isLiked() == 1) {
                    u6().N(i10, commentBeanZ.getId());
                } else {
                    u6().C(i10, commentBeanZ.getId());
                }
            } else if (id2 == R.id.btn_more_action) {
                P6(commentBeanZ.getId(), i10);
            } else if (id2 == R.id.area_reply) {
                h3.a.j().d(a.b.f31920e).withInt(DataConstant.COMMUNITY_COMMENT_ID, commentBeanZ.getId()).withInt("id", this.E8).withInt(DataConstant.COMMUNITY_ARTICLE_AUTHOR_ID, this.F8).navigation();
            } else if (!this.C8) {
                this.K8 = i10;
                this.I8 = commentBeanZ.getId();
                this.J8 = commentBeanZ.getFromUserId();
                b bVar = this.f13827w8;
                if (bVar == null) {
                    f0.S("interactionListener");
                    bVar = null;
                }
                User user = commentBeanZ.getUser();
                bVar.O(user != null ? user.getUsername() : null);
            }
        }
        return false;
    }

    public final void M6(@yt.l String str) {
        this.B8 = str;
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void N2(@yt.k CommentBean comment, int i10) {
        f0.p(comment, "comment");
        com.flydigi.userBehavior.a.a().b(X1(), "社区_评论帖子_" + this.E8);
        u9.h.i(X1(), this.E8, this.D8, this.B8, "评论");
        if (i10 < 0) {
            this.f13331r8.M4(this.f13830z8, 2);
            this.f13331r8.J0(1, z6(comment));
        } else {
            ei.h hVarG2 = this.f13331r8.g2(i10);
            if (hVarG2 != null) {
                this.f13331r8.M4(hVarG2, comment);
            }
        }
        if (this.f13331r8.d2(this.f13829y8) >= 0) {
            this.f13331r8.A3();
        }
        b bVar = this.f13827w8;
        if (bVar == null) {
            f0.S("interactionListener");
            bVar = null;
        }
        bVar.P2(comment);
        InputDialogFragment inputDialogFragment = this.f13828x8;
        if (inputDialogFragment != null) {
            inputDialogFragment.e6();
        }
        this.I8 = 0;
        this.J8 = 0;
        this.K8 = -1;
    }

    public final void N6(int i10) {
        this.I8 = i10;
    }

    public final void O6(int i10) {
        this.J8 = i10;
    }

    public final void P6(int i10, int i11) {
        MoreActionDialogFragment moreActionDialogFragmentA = MoreActionDialogFragment.G8.a();
        moreActionDialogFragmentA.l6(new c(i10, i11));
        o5.a.t0(U1(), moreActionDialogFragmentA);
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void S1(int i10) {
        com.flydigi.base.common.o.E(c3(R.string.community_zan_success));
        ei.h hVarG2 = this.f13331r8.g2(i10);
        CommentItem commentItem = hVarG2 instanceof CommentItem ? (CommentItem) hVarG2 : null;
        if (commentItem == null) {
            return;
        }
        this.f13331r8.M4(commentItem, Boolean.TRUE);
    }

    @Override // com.flydigi.base.common.FZFragment
    public void U5() {
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        if (!this.C8) {
            y0(0, 0);
        } else {
            this.f13331r8.S0(this.f13830z8);
            this.f13331r8.Q0(new com.flydigi.community.ui.comment.a());
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    public int c6() {
        return 10;
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void d0(int i10) {
        com.flydigi.base.common.o.E(c3(R.string.community_dislike_success));
        ei.h hVarG2 = this.f13331r8.g2(i10);
        CommentItem commentItem = hVarG2 instanceof CommentItem ? (CommentItem) hVarG2 : null;
        if (commentItem == null) {
            return;
        }
        this.f13331r8.M4(commentItem, Boolean.FALSE);
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void d1(int i10) {
        com.flydigi.base.common.o.E(c3(R.string.community_delete_message_success));
        this.f13331r8.E3(i10);
        this.f13331r8.M4(this.f13830z8, 1);
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void e1(int i10, @yt.k String sort) {
        f0.p(sort, "sort");
        this.f13830z8.D(i10);
        this.f13830z8.E(sort);
        H5().e(new Runnable() { // from class: com.flydigi.community.ui.comment.g
            @Override // java.lang.Runnable
            public final void run() {
                CommentListFragment.Q6(this.f13867a);
            }
        });
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    @yt.l
    public RecyclerView.n g6() {
        return new a.C0280a(X1()).l(R.color.color_000000_a04).D(R.dimen.qb_px_54, R.dimen.qb_px_0).w(new FlexibleDividerDecoration.i() { // from class: com.flydigi.community.ui.comment.f
            @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.i
            public final boolean a(int i10, RecyclerView recyclerView) {
                return CommentListFragment.A6(i10, recyclerView);
            }
        }).y();
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        this.f13330q8.setBackgroundResource(R.color.color_white);
        this.f13329p8.C(false);
        this.f13332s8 = null;
        this.f13329p8.n0(true);
        this.f13329p8.x(new sg.b() { // from class: com.flydigi.community.ui.comment.h
            @Override // sg.b
            public final void g(mg.j jVar) {
                CommentListFragment.B6(this.f13868a, jVar);
            }
        });
    }

    public final int o6() {
        return this.E8;
    }

    public final int p6() {
        return this.D8;
    }

    public final int q6() {
        return this.F8;
    }

    public final int r6() {
        return this.H8;
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void s0(int i10, int i11, @yt.k String content) {
        f0.p(content, "content");
        if (this.I8 == 0) {
            this.I8 = this.G8;
        }
        if (this.J8 == 0) {
            this.J8 = this.H8;
        }
        u6().I(i10, i11, this.I8, this.J8, this.G8, this.H8, content, this.K8);
    }

    @yt.l
    public final InputDialogFragment s6() {
        return this.f13828x8;
    }

    public final int t6() {
        return this.G8;
    }

    @yt.k
    public final d.a u6() {
        d.a aVar = this.f13826v8;
        if (aVar != null) {
            return aVar;
        }
        f0.S("mPresenter");
        return null;
    }

    @yt.l
    public final String v6() {
        return this.B8;
    }

    @Override // com.flydigi.community.ui.comment.d.b
    public void w(boolean z10, @yt.k List<CommentBean> comments) {
        f0.p(comments, "comments");
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(comments, 10));
        Iterator<T> it2 = comments.iterator();
        while (it2.hasNext()) {
            arrayList.add(z6((CommentBean) it2.next()));
        }
        if (!z10) {
            eu.davidea.flexibleadapter.b bVar = this.f13331r8;
            bVar.O0(bVar.getItemCount(), arrayList);
            if (arrayList.size() < 10) {
                J(comments.size());
                return;
            } else {
                this.f13329p8.I(true);
                return;
            }
        }
        this.f13329p8.N();
        this.f13331r8.I4(arrayList);
        if (n0.o(comments)) {
            J(comments.size());
            this.f13331r8.Q0(this.f13829y8);
        } else if (comments.size() == c6()) {
            this.f13331r8.A3();
        } else if (arrayList.size() < 10) {
            J(comments.size());
        }
    }

    public final int w6() {
        return this.I8;
    }

    public final int x6() {
        return this.J8;
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        u6().Y(this.E8, this.A8, i11 + 1, 10);
    }

    public final boolean y6() {
        return this.C8;
    }

    @yt.k
    public CommentItem z6(@yt.k CommentBean it2) {
        f0.p(it2, "it");
        return new CommentItem(it2, this.F8, false);
    }
}
