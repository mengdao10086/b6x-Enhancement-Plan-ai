package com.flydigi.community.ui.message.like;

import android.os.Bundle;
import android.view.View;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.community.R;
import com.flydigi.community.ui.message.like.a;
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
public final class LikeMessageFragment extends FZRecyclerViewFragment implements a.b {

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @k
    public static final a f13929w8 = new a(null);

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public static final int f13930x8 = 20;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public a.InterfaceC0140a f13931v8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final LikeMessageFragment a() {
            LikeMessageFragment likeMessageFragment = new LikeMessageFragment();
            likeMessageFragment.c5(androidx.core.os.e.a());
            return likeMessageFragment;
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        this.f13931v8 = new LikeMessagePresenter(this);
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@l View view, int i10) {
        h hVarG2 = this.f13331r8.g2(i10);
        if (!(hVarG2 instanceof LikeRecordItem)) {
            return false;
        }
        MyMessageBean.Message messageZ = ((LikeRecordItem) hVarG2).z();
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
        this.f13331r8.notifyItemChanged(i10);
        return false;
    }

    @Override // com.flydigi.community.ui.message.like.a.b
    public void c(boolean z10, @k List<LikeRecordItem> data) {
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
        a.InterfaceC0140a interfaceC0140a = this.f13931v8;
        if (interfaceC0140a == null) {
            f0.S("mPresenter");
            interfaceC0140a = null;
        }
        interfaceC0140a.p(i11 + 1, 20);
    }
}
