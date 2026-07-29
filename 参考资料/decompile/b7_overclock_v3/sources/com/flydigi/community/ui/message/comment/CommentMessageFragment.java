package com.flydigi.community.ui.message.comment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.community.R;
import com.flydigi.community.ui.message.comment.a;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.MyMessageBean;
import ei.h;
import i9.a;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class CommentMessageFragment extends FZRecyclerViewFragment implements a.b {

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @k
    public static final a f13909x8 = new a(null);

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final int f13910y8 = 20;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public a.InterfaceC0139a f13911v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @l
    public b f13912w8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final CommentMessageFragment a() {
            CommentMessageFragment commentMessageFragment = new CommentMessageFragment();
            commentMessageFragment.c5(androidx.core.os.e.a());
            return commentMessageFragment;
        }
    }

    public interface b {
        void p1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f13912w8 = (b) context;
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        this.f13911v8 = new CommentMessagePresenter(this);
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@l View view, int i10) {
        h hVarG2 = this.f13331r8.g2(i10);
        if (!(hVarG2 instanceof CommentRecordItem)) {
            return false;
        }
        MyMessageBean.Message messageZ = ((CommentRecordItem) hVarG2).z();
        f0.o(messageZ, "item.data");
        MyMessageBean.Message message = messageZ;
        if (kotlin.text.u.L1("1", message.getType(), true)) {
            h3.a.j().d(a.b.f31920e).withInt("id", message.getInfoId()).withInt(DataConstant.COMMUNITY_COMMENT_ID, message.getCommentId()).withInt(DataConstant.COMMUNITY_MESSAGE_ID, message.getId()).navigation();
        } else if (kotlin.text.u.L1("2", message.getType(), true)) {
            h3.a.j().d(a.b.f31919d).withInt("id", message.getInfoId()).withInt(DataConstant.COMMUNITY_MESSAGE_ID, message.getId()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13291i).navigation();
        }
        if (message.getIsRead() != 0) {
            return false;
        }
        message.setIsRead(1);
        b bVar = this.f13912w8;
        if (bVar != null) {
            bVar.p1();
        }
        this.f13331r8.notifyItemChanged(i10);
        return false;
    }

    @Override // com.flydigi.community.ui.message.comment.a.b
    public void c(boolean z10, @k List<CommentRecordItem> data) {
        f0.p(data, "data");
        if (z10) {
            this.f13331r8.I4(data);
        } else {
            this.f13331r8.r3(data);
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    public int c6() {
        return 20;
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        O5(R.string.base_empty_notice, R.drawable.community_ic_empty);
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        a.InterfaceC0139a interfaceC0139a = this.f13911v8;
        if (interfaceC0139a == null) {
            f0.S("mPresenter");
            interfaceC0139a = null;
        }
        interfaceC0139a.p(i11 + 1, 20);
    }
}
