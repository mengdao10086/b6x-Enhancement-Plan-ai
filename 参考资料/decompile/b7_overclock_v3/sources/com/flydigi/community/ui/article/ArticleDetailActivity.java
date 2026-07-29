package com.flydigi.community.ui.article;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.community.R;
import com.flydigi.community.ui.article.ArticleDetailFragment;
import com.flydigi.community.ui.article.f;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.flydigi.community.ui.comment.InputDialogFragment;
import com.flydigi.community.ui.comment.d;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.CommentBean;
import i9.a;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.b.f31919d)
public final class ArticleDetailActivity extends com.flydigi.base.common.p implements ArticleDetailFragment.c, InputDialogFragment.b, CommentListFragment.b {

    @hk.e
    @Autowired(name = DataConstant.COMMUNITY_MESSAGE_ID)
    public int E7;

    @hk.e
    @Autowired(name = DataConstant.COMMUNITY_ARTICLE_TYPE)
    public int F7;

    @hk.e
    @Autowired(name = DataConstant.COMMUNITY_ARTICLE_SOURCE)
    @yt.k
    public String G7 = "";

    @hk.e
    @Autowired(name = DataConstant.COMMUNITY_ARTICLE_LOCATE_COMMENT)
    public boolean H7;

    @hk.e
    @yt.l
    @Autowired(name = a.b.f31931p)
    public ArticleBean I7;
    public y5.a J7;

    @hk.e
    @Autowired(name = "id")
    public int K2;
    public boolean K7;

    @yt.l
    public f.b L7;

    @yt.l
    public d.b M7;

    @yt.l
    public com.google.android.material.badge.a N7;
    public boolean O7;

    @yt.l
    public InputDialogFragment P7;

    @yt.l
    public String Q7;

    public static final void o4(ArticleDetailActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.finish();
    }

    public static final void p4(ArticleDetailActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        f.b bVar = this$0.L7;
        if (bVar != null) {
            bVar.c0();
        }
    }

    public static final void q4(ArticleDetailActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        f.b bVar = this$0.L7;
        if (bVar != null) {
            bVar.r2();
        }
    }

    public static final void r4(ArticleDetailActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        ArticleBean articleBean = this$0.I7;
        boolean z10 = false;
        if (articleBean != null && articleBean.isComment() == 0) {
            z10 = true;
        }
        if (z10) {
            com.flydigi.base.common.o.E(this$0.getString(R.string.community_comment_is_disabled));
        } else {
            CommentListFragment.b.a.a(this$0, null, 1, null);
        }
    }

    public static final void s4(ArticleDetailActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        ArticleBean articleBean = this$0.I7;
        boolean z10 = false;
        if (articleBean != null && articleBean.isComment() == 0) {
            z10 = true;
        }
        if (z10) {
            com.flydigi.base.common.o.E(this$0.getString(R.string.community_comment_is_disabled));
        } else {
            CommentListFragment.b.a.a(this$0, null, 1, null);
        }
    }

    @Override // com.flydigi.community.ui.article.ArticleDetailFragment.c
    public void J2(@yt.k ArticleBean article) {
        kotlin.jvm.internal.f0.p(article, "article");
        this.I7 = article;
        this.K2 = article.getId();
        this.F7 = article.getType();
        if (!this.K7) {
            com.flydigi.userBehavior.a.a().b(this, "社区_访问帖子_" + article.getId());
            u9.h.i(this, article.getId(), article.getType(), this.G7, "浏览");
            this.K7 = true;
        }
        y5.a aVar = this.J7;
        y5.a aVar2 = null;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar = null;
        }
        aVar.f56254n.setText(article.getAuthor());
        com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.H(this).t(article.getAvatar());
        int i10 = R.drawable.main_ic_default_avatar;
        com.bumptech.glide.h hVarG = hVarP.E0(i10).x(i10).g();
        y5.a aVar3 = this.J7;
        if (aVar3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar3 = null;
        }
        hVarG.s1(aVar3.f56252l);
        if (com.blankj.utilcode.util.d0.A(n3(), CommentListFragment.class) == null) {
            CommentListFragment commentListFragmentA = CommentListFragment.L8.a(this.K2, this.E7, article.getAuthorId() != 0 ? article.getAuthorId() : article.getUid(), this.G7, article.isComment() == 0, (96 & 32) != 0 ? 0 : 0, (96 & 64) != 0 ? 0 : 0);
            this.M7 = commentListFragmentA;
            com.blankj.utilcode.util.d0.v0(n3(), commentListFragmentA, R.id.container_comment);
        }
        com.google.android.material.badge.a aVar4 = this.N7;
        if (aVar4 == null) {
            com.google.android.material.badge.a aVarD = com.google.android.material.badge.a.d(this);
            aVarD.X(article.getLikes());
            aVarD.W(3);
            aVarD.N(8388659);
            aVarD.M(0);
            aVarD.d0(true);
            aVarD.T(getResources().getDimensionPixelOffset(R.dimen.qb_px_44));
            aVarD.a0(getResources().getDimensionPixelOffset(R.dimen.qb_px_16));
            this.N7 = aVarD;
            y5.a aVar5 = this.J7;
            if (aVar5 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                aVar5 = null;
            }
            SuperButton superButton = aVar5.f56246f;
            y5.a aVar6 = this.J7;
            if (aVar6 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                aVar6 = null;
            }
            ViewParent parent = aVar6.f56246f.getParent();
            kotlin.jvm.internal.f0.n(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
            com.google.android.material.badge.b.d(aVarD, superButton, (FrameLayout) parent);
        } else if (aVar4 != null) {
            aVar4.X(article.getLikes());
        }
        y5.a aVar7 = this.J7;
        if (aVar7 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar7 = null;
        }
        aVar7.f56246f.setIcon(h0.d.i(this, article.isLiked() ? R.drawable.community_ic_liked : R.drawable.ic_like));
        y5.a aVar8 = this.J7;
        if (aVar8 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            aVar2 = aVar8;
        }
        aVar2.f56246f.setIconColor(h0.d.f(this, article.isLiked() ? R.color.colorAccentRed : R.color.color_000000_a50));
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment.b
    public void O(@yt.l String str) {
        y5.a aVar = this.J7;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar = null;
        }
        CharSequence text = aVar.f56253m.getTextView().getText();
        InputDialogFragment inputDialogFragmentA = InputDialogFragment.I8.a(kotlin.jvm.internal.f0.g(text, getResources().getString(R.string.community_say_something)) ? null : text);
        this.P7 = inputDialogFragmentA;
        if (inputDialogFragmentA != null) {
            inputDialogFragmentA.n6(str, Boolean.valueOf(true ^ (str == null || str.length() == 0)));
            o5.a.t0(n3(), inputDialogFragmentA);
        }
    }

    @Override // com.flydigi.community.ui.comment.CommentListFragment.b
    public void P2(@yt.k CommentBean comment) {
        kotlin.jvm.internal.f0.p(comment, "comment");
        InputDialogFragment inputDialogFragment = this.P7;
        if (inputDialogFragment != null) {
            inputDialogFragment.e6();
        }
        y5.a aVar = this.J7;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar = null;
        }
        aVar.f56253m.setText(getResources().getString(R.string.community_say_something));
    }

    @Override // com.flydigi.community.ui.comment.InputDialogFragment.b
    public void S0(@yt.k String text) {
        kotlin.jvm.internal.f0.p(text, "text");
        y5.a aVar = this.J7;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar = null;
        }
        aVar.f56253m.setText(text);
        this.Q7 = text;
    }

    @Override // com.flydigi.community.ui.comment.InputDialogFragment.b
    public void W0(@yt.k String text) {
        ArticleBean articleBean;
        kotlin.jvm.internal.f0.p(text, "text");
        ArticleBean articleBean2 = this.I7;
        int uid = 0;
        if (articleBean2 != null && articleBean2.getAuthorId() == 0) {
            ArticleBean articleBean3 = this.I7;
            if (!(articleBean3 != null && articleBean3.getUid() == 0) && (articleBean = this.I7) != null) {
                uid = articleBean.getUid();
            }
        } else {
            ArticleBean articleBean4 = this.I7;
            if (articleBean4 != null) {
                uid = articleBean4.getAuthorId();
            }
        }
        d.b bVar = this.M7;
        if (bVar != null) {
            bVar.s0(this.K2, uid, text);
        }
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.community_activity_article_detail;
    }

    @Override // com.flydigi.community.ui.article.ArticleDetailFragment.c
    public void n1(boolean z10) {
        y5.a aVar = this.J7;
        y5.a aVar2 = null;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar = null;
        }
        aVar.f56246f.setIcon(h0.d.i(this, z10 ? R.drawable.community_ic_liked : R.drawable.ic_like));
        y5.a aVar3 = this.J7;
        if (aVar3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.f56246f.setIconColor(h0.d.f(this, z10 ? R.color.colorAccentRed : R.color.color_000000_a50));
        ArticleBean articleBean = this.I7;
        if (articleBean != null) {
            int likes = articleBean.getLikes();
            articleBean.setLikes(z10 ? likes + 1 : likes - 1);
            com.google.android.material.badge.a aVar4 = this.N7;
            if (aVar4 != null) {
                aVar4.X(articleBean.getLikes());
            }
            if (!z10) {
                com.flydigi.userBehavior.a.a().b(this, "社区_取消点赞帖子_" + this.K2);
                return;
            }
            com.flydigi.userBehavior.a.a().b(this, "社区_点赞帖子_" + this.K2);
            u9.h.i(this, this.K2, this.F7, this.G7, "点赞");
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        if (com.blankj.utilcode.util.d0.A(n3(), ArticleDetailFragment.class) == null) {
            ArticleDetailFragment articleDetailFragmentA = ArticleDetailFragment.A8.a(this.K2, this.E7, this.G7, this.I7);
            this.L7 = articleDetailFragmentA;
            com.blankj.utilcode.util.d0.v0(n3(), articleDetailFragmentA, R.id.container_article);
        }
        y5.a aVar = this.J7;
        y5.a aVar2 = null;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar = null;
        }
        com.blankj.utilcode.util.o.r(aVar.f56244d, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArticleDetailActivity.o4(this.f13726a, view);
            }
        });
        y5.a aVar3 = this.J7;
        if (aVar3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar3 = null;
        }
        com.blankj.utilcode.util.o.r(aVar3.f56248h, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArticleDetailActivity.p4(this.f13728a, view);
            }
        });
        y5.a aVar4 = this.J7;
        if (aVar4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar4 = null;
        }
        com.blankj.utilcode.util.o.r(aVar4.f56246f, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArticleDetailActivity.q4(this.f13724a, view);
            }
        });
        y5.a aVar5 = this.J7;
        if (aVar5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVar5 = null;
        }
        com.blankj.utilcode.util.o.r(aVar5.f56247g, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArticleDetailActivity.r4(this.f13732a, view);
            }
        });
        y5.a aVar6 = this.J7;
        if (aVar6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            aVar2 = aVar6;
        }
        com.blankj.utilcode.util.o.r(aVar2.f56253m, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArticleDetailActivity.s4(this.f13730a, view);
            }
        });
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        y5.a aVarC = y5.a.c(getLayoutInflater());
        kotlin.jvm.internal.f0.o(aVarC, "inflate(layoutInflater)");
        this.J7 = aVarC;
        if (aVarC == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            aVarC = null;
        }
        setContentView(aVarC.getRoot());
    }
}
