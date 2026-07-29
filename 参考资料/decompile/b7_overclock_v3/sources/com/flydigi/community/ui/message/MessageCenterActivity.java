package com.flydigi.community.ui.message;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.e0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.p;
import com.flydigi.community.R;
import com.flydigi.community.ui.message.c;
import com.flydigi.community.ui.message.comment.CommentMessageFragment;
import com.flydigi.community.ui.message.like.LikeMessageFragment;
import com.flydigi.data.bean.UnreadMessageBean;
import i9.a;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@Route(extras = 10000000, path = a.b.f31925j)
public final class MessageCenterActivity extends p implements c.b, CommentMessageFragment.b {

    @l
    public UnreadMessageBean E7;
    public y5.d F7;
    public c.a K2;

    public static final class a extends e0 {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
        }

        @Override // androidx.fragment.app.e0
        @k
        public Fragment a(int i10) {
            return i10 == 0 ? CommentMessageFragment.f13909x8.a() : LikeMessageFragment.f13929w8.a();
        }

        @Override // k2.a
        public int getCount() {
            return 2;
        }
    }

    public static final void l4(MessageCenterActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.n4();
    }

    public static final void m4(MessageCenterActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.o4();
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.community_activity_message_center;
    }

    @Override // com.flydigi.community.ui.message.c.b
    public void j(@k UnreadMessageBean data) {
        f0.p(data, "data");
        this.E7 = data;
        p4();
        q4();
    }

    public final void n4() {
        y5.d dVar = this.F7;
        y5.d dVar2 = null;
        if (dVar == null) {
            f0.S("viewBinding");
            dVar = null;
        }
        dVar.f56286c.setSelected(false);
        y5.d dVar3 = this.F7;
        if (dVar3 == null) {
            f0.S("viewBinding");
            dVar3 = null;
        }
        dVar3.f56285b.setSelected(true);
        y5.d dVar4 = this.F7;
        if (dVar4 == null) {
            f0.S("viewBinding");
        } else {
            dVar2 = dVar4;
        }
        dVar2.f56289f.U(0, false);
    }

    public final void o4() {
        y5.d dVar = this.F7;
        c.a aVar = null;
        if (dVar == null) {
            f0.S("viewBinding");
            dVar = null;
        }
        dVar.f56285b.setSelected(false);
        y5.d dVar2 = this.F7;
        if (dVar2 == null) {
            f0.S("viewBinding");
            dVar2 = null;
        }
        dVar2.f56286c.setSelected(true);
        y5.d dVar3 = this.F7;
        if (dVar3 == null) {
            f0.S("viewBinding");
            dVar3 = null;
        }
        dVar3.f56289f.U(1, false);
        UnreadMessageBean unreadMessageBean = this.E7;
        if ((unreadMessageBean != null ? unreadMessageBean.getLikeNum() : 0) > 0) {
            c.a aVar2 = this.K2;
            if (aVar2 == null) {
                f0.S("mPresenter");
            } else {
                aVar = aVar2;
            }
            aVar.q(2);
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.community_my_message);
        this.K2 = new MessagePresenter(this);
        y5.d dVar = this.F7;
        y5.d dVar2 = null;
        if (dVar == null) {
            f0.S("viewBinding");
            dVar = null;
        }
        dVar.f56289f.setAdapter(new a(n3()));
        y5.d dVar3 = this.F7;
        if (dVar3 == null) {
            f0.S("viewBinding");
            dVar3 = null;
        }
        TextView textView = dVar3.f56285b;
        o.r(textView, new View.OnClickListener() { // from class: com.flydigi.community.ui.message.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterActivity.l4(this.f13908a, view);
            }
        });
        textView.setSelected(true);
        p4();
        y5.d dVar4 = this.F7;
        if (dVar4 == null) {
            f0.S("viewBinding");
        } else {
            dVar2 = dVar4;
        }
        o.r(dVar2.f56286c, new View.OnClickListener() { // from class: com.flydigi.community.ui.message.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterActivity.m4(this.f13907a, view);
            }
        });
        q4();
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        c.a aVar = this.K2;
        if (aVar == null) {
            f0.S("mPresenter");
            aVar = null;
        }
        aVar.f();
    }

    @Override // com.flydigi.community.ui.message.comment.CommentMessageFragment.b
    public void p1() {
        UnreadMessageBean unreadMessageBean = this.E7;
        if (unreadMessageBean != null) {
            unreadMessageBean.setCommentNum(unreadMessageBean.getCommentNum() - 1);
        }
    }

    public final void p4() {
        y5.d dVar = this.F7;
        if (dVar == null) {
            f0.S("viewBinding");
            dVar = null;
        }
        TextView textView = dVar.f56287d;
        UnreadMessageBean unreadMessageBean = this.E7;
        textView.setVisibility((unreadMessageBean != null ? unreadMessageBean.getCommentNum() : 0) > 0 ? 0 : 8);
        UnreadMessageBean unreadMessageBean2 = this.E7;
        textView.setText(String.valueOf(unreadMessageBean2 != null ? unreadMessageBean2.getCommentNum() : 0));
    }

    public final void q4() {
        y5.d dVar = this.F7;
        if (dVar == null) {
            f0.S("viewBinding");
            dVar = null;
        }
        TextView textView = dVar.f56288e;
        UnreadMessageBean unreadMessageBean = this.E7;
        textView.setVisibility((unreadMessageBean != null ? unreadMessageBean.getLikeNum() : 0) > 0 ? 0 : 8);
        UnreadMessageBean unreadMessageBean2 = this.E7;
        textView.setText(String.valueOf(unreadMessageBean2 != null ? unreadMessageBean2.getLikeNum() : 0));
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        y5.d dVarC = y5.d.c(getLayoutInflater());
        f0.o(dVarC, "inflate(layoutInflater)");
        this.F7 = dVarC;
        if (dVarC == null) {
            f0.S("viewBinding");
            dVarC = null;
        }
        super.setContentView(dVarC.getRoot());
    }
}
