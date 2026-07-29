package com.flydigi.community.ui.comment.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.o;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.p;
import com.flydigi.community.R;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.flydigi.community.ui.comment.InputDialogFragment;
import com.flydigi.community.ui.comment.detail.CommentDetailFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.CommentBean;
import i9.a;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.b.f31920e)
public final class CommentDetailActivity extends p implements CommentDetailFragment.b, InputDialogFragment.b, CommentListFragment.b {
    public y5.b E7;

    @hk.e
    @Autowired(name = "id")
    public int F7;

    @hk.e
    @Autowired(name = DataConstant.COMMUNITY_ARTICLE_AUTHOR_ID)
    public int G7;

    @hk.e
    @Autowired(name = DataConstant.COMMUNITY_COMMENT_ID)
    public int H7;

    @hk.e
    @Autowired(name = DataConstant.COMMUNITY_MESSAGE_ID)
    public int I7;

    @l
    public InputDialogFragment J7;

    @l
    public String K2;

    @l
    public CommentDetailFragment K7;

    public static final void k4(CommentDetailActivity this$0, View view) {
        f0.p(this$0, "this$0");
        CommentListFragment.b.a.a(this$0, null, 1, null);
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment.b
    public void O(@l String str) {
        y5.b bVar = this.E7;
        if (bVar == null) {
            f0.S("viewBinding");
            bVar = null;
        }
        CharSequence text = bVar.f56262d.getText();
        InputDialogFragment inputDialogFragmentA = InputDialogFragment.I8.a(f0.g(text, getResources().getString(R.string.community_say_something)) ? null : text);
        this.J7 = inputDialogFragmentA;
        if (inputDialogFragmentA != null) {
            inputDialogFragmentA.n6(str, Boolean.valueOf(true ^ (str == null || str.length() == 0)));
            o5.a.t0(n3(), inputDialogFragmentA);
        }
    }

    @Override // com.flydigi.community.ui.comment.detail.CommentDetailFragment.b
    public void P(@k CommentBean comment, int i10) {
        f0.p(comment, "comment");
        y5.b bVar = this.E7;
        if (bVar == null) {
            f0.S("viewBinding");
            bVar = null;
        }
        LinearLayout linearLayout = bVar.f56260b;
        f0.o(linearLayout, "viewBinding.btnSendComment");
        o5.c.b(linearLayout, Boolean.TRUE, false, 2, null);
        if (i10 > 0) {
            this.C1.setText(getString(R.string.community_count_of_comment, new Object[]{Integer.valueOf(i10)}));
        }
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment.b
    public void P2(@k CommentBean comment) {
        f0.p(comment, "comment");
        InputDialogFragment inputDialogFragment = this.J7;
        if (inputDialogFragment != null) {
            inputDialogFragment.e6();
        }
        P(comment, comment.getReplyNum());
    }

    @Override // com.flydigi.community.ui.comment.InputDialogFragment.b
    public void S0(@k String text) {
        f0.p(text, "text");
        y5.b bVar = this.E7;
        if (bVar == null) {
            f0.S("viewBinding");
            bVar = null;
        }
        bVar.f56262d.setText(text);
        this.K2 = text;
    }

    @Override // com.flydigi.community.ui.comment.InputDialogFragment.b
    public void W0(@k String text) {
        f0.p(text, "text");
        CommentDetailFragment commentDetailFragment = this.K7;
        if (commentDetailFragment != null) {
            commentDetailFragment.s0(this.F7, this.G7, text);
        }
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.community_activity_comment_detail;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.community_title_comment_detail);
        h3.a.j().l(this);
        if (a4(CommentDetailFragment.class.getSimpleName()) == null) {
            CommentDetailFragment commentDetailFragmentA = CommentDetailFragment.Z8.a(this.F7, this.G7, this.H7, this.I7);
            this.K7 = commentDetailFragmentA;
            d0.v0(n3(), commentDetailFragmentA, R.id.fl_container);
        }
        y5.b bVar = this.E7;
        if (bVar == null) {
            f0.S("viewBinding");
            bVar = null;
        }
        o.r(bVar.f56262d, new View.OnClickListener() { // from class: com.flydigi.community.ui.comment.detail.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentDetailActivity.k4(this.f13853a, view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@k Menu menu) {
        f0.p(menu, "menu");
        if (this.I7 <= 0) {
            return true;
        }
        getMenuInflater().inflate(R.menu.community_menu_comment_detail, menu);
        return true;
    }

    @Override // com.flydigi.base.common.p, android.app.Activity
    public boolean onOptionsItemSelected(@k MenuItem item) {
        f0.p(item, "item");
        if (item.getItemId() != R.id.menu_show_article) {
            return super.onOptionsItemSelected(item);
        }
        h3.a.j().d(a.b.f31919d).withInt("id", this.F7).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13291i).withBoolean(DataConstant.COMMUNITY_ARTICLE_LOCATE_COMMENT, true).navigation(this);
        return true;
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        y5.b bVarC = y5.b.c(LayoutInflater.from(this));
        f0.o(bVarC, "inflate(LayoutInflater.from(this))");
        this.E7 = bVarC;
        if (bVarC == null) {
            f0.S("viewBinding");
            bVarC = null;
        }
        super.setContentView(bVarC.getRoot());
    }
}
