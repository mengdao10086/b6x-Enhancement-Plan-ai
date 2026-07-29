package com.flydigi.community.ui.comment.detail;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.n0;
import com.bumptech.glide.i;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.base.widget.superlink.a;
import com.flydigi.community.R;
import com.flydigi.data.bean.community.CommentBean;
import com.flydigi.data.bean.community.User;
import java.util.List;
import kotlin.jvm.internal.f0;
import top.androidman.SuperButton;
import y5.t;
import y5.v;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class CommentHostItem extends AbstractModelItem<CommentBean, a> {
    private final boolean canDelete;

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final t f13852g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            t tVarA = t.a(view);
            f0.o(tVarA, "bind(view)");
            this.f13852g = tVarA;
            tVarA.f56433g.setOnClickListener(this);
            tVarA.f56428b.setOnClickListener(this);
            tVarA.f56430d.setOnClickListener(this);
            tVarA.f56429c.f56441e.setOnClickListener(this);
        }

        @k
        public final t r() {
            return this.f13852g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentHostItem(@k CommentBean data, boolean z10) {
        super(data);
        f0.p(data, "data");
        this.canDelete = z10;
    }

    public static final void H(View widget, String str) {
        f0.p(widget, "widget");
        d6.c.c(widget.getContext(), str);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void o(@k eu.davidea.flexibleadapter.b<ei.h<?>> adapter, @k a holder, int i10, @k List<? extends Object> payloads) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        v vVar = holder.r().f56429c;
        f0.o(vVar, "holder.viewBinding.areaCommentContent");
        CommentBean data = z();
        f0.o(data, "data");
        G(vVar, data, payloads, false);
        if (n0.z(z().getChild())) {
            ConstraintLayout constraintLayout = holder.r().f56430d;
            f0.o(constraintLayout, "holder.viewBinding.areaReply");
            Boolean bool = Boolean.TRUE;
            o5.c.b(constraintLayout, bool, false, 2, null);
            if (z().getChild().size() >= 2) {
                ConstraintLayout root = holder.r().f56431e.getRoot();
                f0.o(root, "holder.viewBinding.areaReply1.root");
                o5.c.b(root, bool, false, 2, null);
                ConstraintLayout root2 = holder.r().f56432f.getRoot();
                f0.o(root2, "holder.viewBinding.areaReply2.root");
                o5.c.b(root2, bool, false, 2, null);
                TextView textView = holder.r().f56434h;
                f0.o(textView, "holder.viewBinding.btnShowAll");
                o5.c.b(textView, bool, false, 2, null);
                v vVar2 = holder.r().f56431e;
                f0.o(vVar2, "holder.viewBinding.areaReply1");
                CommentBean commentBean = z().getChild().get(0);
                f0.o(commentBean, "data.child[0]");
                G(vVar2, commentBean, payloads, true);
                v vVar3 = holder.r().f56432f;
                f0.o(vVar3, "holder.viewBinding.areaReply2");
                CommentBean commentBean2 = z().getChild().get(1);
                f0.o(commentBean2, "data.child[1]");
                G(vVar3, commentBean2, payloads, true);
            } else {
                ConstraintLayout root3 = holder.r().f56431e.getRoot();
                f0.o(root3, "holder.viewBinding.areaReply1.root");
                o5.c.b(root3, bool, false, 2, null);
                ConstraintLayout root4 = holder.r().f56432f.getRoot();
                f0.o(root4, "holder.viewBinding.areaReply2.root");
                Boolean bool2 = Boolean.FALSE;
                o5.c.b(root4, bool2, false, 2, null);
                TextView textView2 = holder.r().f56434h;
                f0.o(textView2, "holder.viewBinding.btnShowAll");
                o5.c.b(textView2, bool2, false, 2, null);
                v vVar4 = holder.r().f56431e;
                f0.o(vVar4, "holder.viewBinding.areaReply1");
                CommentBean commentBean3 = z().getChild().get(0);
                f0.o(commentBean3, "data.child[0]");
                G(vVar4, commentBean3, payloads, true);
            }
        } else {
            ConstraintLayout constraintLayout2 = holder.r().f56430d;
            f0.o(constraintLayout2, "holder.viewBinding.areaReply");
            o5.c.b(constraintLayout2, Boolean.FALSE, false, 2, null);
        }
        holder.r().f56433g.setVisibility(this.canDelete ? 0 : 8);
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k eu.davidea.flexibleadapter.b<ei.h<?>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    public final boolean E() {
        return this.canDelete;
    }

    public final void G(v vVar, CommentBean commentBean, List<? extends Object> list, boolean z10) {
        String username;
        i iVarF = com.bumptech.glide.b.F(vVar.getRoot());
        User user = commentBean.getUser();
        com.bumptech.glide.h<Drawable> hVarT = iVarF.t(user != null ? user.getAvatar() : null);
        int i10 = R.drawable.main_ic_default_avatar;
        hVarT.E0(i10).x(i10).g().s1(vVar.f56438b);
        TextView textView = vVar.f56442f;
        User user2 = commentBean.getUser();
        if (user2 == null || (username = user2.getUsername()) == null) {
            username = "";
        }
        textView.setText(username);
        vVar.f56443g.setText(commentBean.getTmText());
        vVar.f56440d.setText(d6.c.b(commentBean.getContent()));
        if (z10) {
            SuperButton superButton = vVar.f56441e;
            f0.o(superButton, "areaComment.tvLikeNum");
            o5.c.b(superButton, Boolean.FALSE, false, 2, null);
            return;
        }
        vVar.f56440d.setSuperLinkClickListener(new a.InterfaceC0134a() { // from class: com.flydigi.community.ui.comment.detail.h
            @Override // com.flydigi.base.widget.superlink.a.InterfaceC0134a
            public final void e(View view, String str) {
                CommentHostItem.H(view, str);
            }
        });
        SuperButton superButton2 = vVar.f56441e;
        f0.o(superButton2, "areaComment.tvLikeNum");
        o5.c.b(superButton2, Boolean.TRUE, false, 2, null);
        vVar.f56441e.setText(String.valueOf(commentBean.getLikeNum()));
        SuperButton superButton3 = vVar.f56441e;
        superButton3.setIcon(h0.d.i(superButton3.getContext(), commentBean.isLiked() == 1 ? R.drawable.community_ic_liked : R.drawable.ic_like));
        SuperButton superButton4 = vVar.f56441e;
        superButton4.setIconColor(h0.d.f(superButton4.getContext(), commentBean.isLiked() == 1 ? R.color.colorAccentRed : R.color.color_000000_a50));
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_comment_host;
    }
}
