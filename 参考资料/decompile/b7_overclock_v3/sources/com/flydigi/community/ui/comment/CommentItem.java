package com.flydigi.community.ui.comment;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.community.CommentBean;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nCommentItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentItem.kt\ncom/flydigi/community/ui/comment/CommentItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,184:1\n1#2:185\n*E\n"})
public final class CommentItem extends AbstractModelItem<CommentBean, a> {
    private final int authorId;
    private final boolean showAll;

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final y5.t f13825g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            y5.t tVarA = y5.t.a(view);
            f0.o(tVarA, "bind(view)");
            this.f13825g = tVarA;
            tVarA.f56433g.setOnClickListener(this);
            tVarA.f56428b.setOnClickListener(this);
            tVarA.f56430d.setOnClickListener(this);
            tVarA.f56429c.f56441e.setOnClickListener(this);
        }

        @yt.k
        public final y5.t r() {
            return this.f13825g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentItem(@yt.k CommentBean data, int i10, boolean z10) {
        super(data);
        f0.p(data, "data");
        this.authorId = i10;
        this.showAll = z10;
    }

    public static final void G(View widget, String str) {
        f0.p(widget, "widget");
        d6.c.c(widget.getContext(), str);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<?>> adapter, @yt.k a holder, int i10, @yt.k List<? extends Object> payloads) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        if (n0.z(payloads) && (payloads.get(0) instanceof CommentBean)) {
            Object obj = payloads.get(0);
            f0.n(obj, "null cannot be cast to non-null type com.flydigi.data.bean.community.CommentBean");
            A((CommentBean) obj);
        }
        y5.v vVar = holder.r().f56429c;
        f0.o(vVar, "holder.viewBinding.areaCommentContent");
        CommentBean data = z();
        f0.o(data, "data");
        E(vVar, data, payloads, false);
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
                y5.v vVar2 = holder.r().f56431e;
                f0.o(vVar2, "holder.viewBinding.areaReply1");
                CommentBean commentBean = z().getChild().get(0);
                f0.o(commentBean, "data.child[0]");
                E(vVar2, commentBean, payloads, true);
                y5.v vVar3 = holder.r().f56432f;
                f0.o(vVar3, "holder.viewBinding.areaReply2");
                CommentBean commentBean2 = z().getChild().get(1);
                f0.o(commentBean2, "data.child[1]");
                E(vVar3, commentBean2, payloads, true);
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
                y5.v vVar4 = holder.r().f56431e;
                f0.o(vVar4, "holder.viewBinding.areaReply1");
                CommentBean commentBean3 = z().getChild().get(0);
                f0.o(commentBean3, "data.child[0]");
                E(vVar4, commentBean3, payloads, true);
            }
        } else {
            ConstraintLayout constraintLayout2 = holder.r().f56430d;
            f0.o(constraintLayout2, "holder.viewBinding.areaReply");
            Boolean bool3 = Boolean.FALSE;
            o5.c.b(constraintLayout2, bool3, false, 2, null);
            TextView textView3 = holder.r().f56434h;
            f0.o(textView3, "holder.viewBinding.btnShowAll");
            o5.c.b(textView3, bool3, false, 2, null);
        }
        holder.r().f56433g.setVisibility(((n0.b(String.valueOf(z().getFromUserId()), a5.f.i().l()) || n0.b(String.valueOf(this.authorId), a5.f.i().l())) && z().isDelByOp() == 0) ? 0 : 8);
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<?>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0136  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(y5.v r18, com.flydigi.data.bean.community.CommentBean r19, java.util.List<? extends java.lang.Object> r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.community.ui.comment.CommentItem.E(y5.v, com.flydigi.data.bean.community.CommentBean, java.util.List, boolean):void");
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_comment;
    }
}
