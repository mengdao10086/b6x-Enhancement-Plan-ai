package com.flydigi.community.ui.article_list;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.n0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.base.ui.image_preview.PreviewBean;
import com.flydigi.community.R;
import com.flydigi.community.ui.article_list.k;
import com.flydigi.community.ui.article_list.k.a;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ContentAddBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration;
import com.yqritc.recyclerviewflexibledivider.a;
import i9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nBaseArticleListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseArticleListFragment.kt\ncom/flydigi/community/ui/article_list/BaseArticleListFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,253:1\n1549#2:254\n1620#2,3:255\n*S KotlinDebug\n*F\n+ 1 BaseArticleListFragment.kt\ncom/flydigi/community/ui/article_list/BaseArticleListFragment\n*L\n46#1:254\n46#1:255,3\n*E\n"})
public abstract class BaseArticleListFragment<P extends k.a> extends FZRecyclerViewFragment implements k.b {

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public P f13808v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public boolean f13809w8 = true;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.k
    public String f13810x8 = ArticleReadLog.f13283a;

    public static final class a implements UMShareListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseArticleListFragment<P> f13811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArticleBean f13813c;

        public a(BaseArticleListFragment<P> baseArticleListFragment, int i10, ArticleBean articleBean) {
            this.f13811a = baseArticleListFragment;
            this.f13812b = i10;
            this.f13813c = articleBean;
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(@yt.k SHARE_MEDIA p02) {
            f0.p(p02, "p0");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(@yt.k SHARE_MEDIA p02, @yt.k Throwable p12) {
            f0.p(p02, "p0");
            f0.p(p12, "p1");
            ToastUtils.T(R.string.community_share_failed);
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(@yt.k SHARE_MEDIA p02) {
            f0.p(p02, "p0");
            ToastUtils.T(R.string.community_share_success);
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(@yt.k SHARE_MEDIA p02) {
            f0.p(p02, "p0");
            this.f13811a.k6().W(this.f13812b, this.f13813c.getId(), this.f13813c.getShareCount());
            u9.h.i(this.f13811a.X1(), this.f13813c.getId(), this.f13813c.getType(), this.f13811a.l6(), "分享");
        }
    }

    public static final boolean o6(BaseArticleListFragment this$0, int i10, RecyclerView recyclerView) {
        f0.p(this$0, "this$0");
        return !(this$0.f13331r8.g2(i10) instanceof ArticleItem);
    }

    @Override // com.flydigi.community.ui.article_list.k.b
    public void C1(boolean z10, @yt.k List<ArticleBean> articles) {
        f0.p(articles, "articles");
        ArrayList arrayList = new ArrayList(t.Y(articles, 10));
        Iterator<T> it2 = articles.iterator();
        while (it2.hasNext()) {
            arrayList.add(new ArticleItem((ArticleBean) it2.next(), Boolean.valueOf(m6())));
        }
        List listQ5 = CollectionsKt___CollectionsKt.Q5(arrayList);
        if (!z10) {
            this.f13331r8.r3(listQ5);
        } else {
            this.f13329p8.N();
            this.f13331r8.I4(listQ5);
        }
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) {
        ei.h hVarG2;
        f0.p(view, "view");
        if (!d6() && (hVarG2 = this.f13331r8.g2(i10)) != null) {
            if (hVarG2 instanceof NoticeItem) {
                NoticeItem noticeItem = (NoticeItem) hVarG2;
                u9.d.a(noticeItem.z().get(0).getDataType(), noticeItem.z().get(0).getData(), this.f13810x8);
            } else if (hVarG2 instanceof ArticleItem) {
                ArticleBean articleBean = ((ArticleItem) hVarG2).z();
                int id2 = view.getId();
                if (id2 == R.id.btn_share) {
                    f0.o(articleBean, "articleBean");
                    s6(articleBean, i10);
                } else if (id2 == R.id.btn_comment) {
                    h3.a.j().d(a.b.f31919d).withInt("id", articleBean.getId()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, this.f13810x8).withBoolean(DataConstant.COMMUNITY_ARTICLE_LOCATE_COMMENT, true).withParcelable(a.b.f31931p, articleBean).navigation();
                } else if (id2 == R.id.btn_like) {
                    n6(i10, articleBean.getId(), articleBean.isLiked());
                } else if (id2 == R.id.area_image_single) {
                    List<ContentAddBean> image = articleBean.getImage();
                    if (image != null) {
                        ArrayList arrayList = new ArrayList();
                        PreviewBean previewBean = new PreviewBean();
                        previewBean.url = image.get(0).url;
                        arrayList.add(previewBean);
                        h3.a.j().d(i9.a.f31901c).withSerializable("main_image_urls", arrayList).navigation();
                    }
                } else {
                    h3.a.j().d(a.b.f31919d).withInt("id", articleBean.getId()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, this.f13810x8).withParcelable(a.b.f31931p, articleBean).navigation();
                }
            }
        }
        return false;
    }

    @Override // com.flydigi.community.ui.article_list.k.b
    public void T(int i10, int i11) {
        ei.h hVarG2 = this.f13331r8.g2(i10);
        if (hVarG2 == null || !(hVarG2 instanceof ArticleItem)) {
            return;
        }
        ((ArticleItem) hVarG2).z().setShareCount(i11);
        new ArrayList(1).add(3);
        this.f13331r8.L4(hVarG2);
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    public int c6() {
        return 10;
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        Fragment fragmentS0 = U1().s0("share");
        if (fragmentS0 != null) {
            ((DialogFragment) fragmentS0).I5();
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    @yt.l
    public RecyclerView.n g6() {
        return new a.C0280a(X1()).l(R.color.color_000000_a04).C(R.dimen.qb_px_16).w(new FlexibleDividerDecoration.i() { // from class: com.flydigi.community.ui.article_list.l
            @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.i
            public final boolean a(int i10, RecyclerView recyclerView) {
                return BaseArticleListFragment.o6(this.f13824a, i10, recyclerView);
            }
        }).s().y();
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        this.f13330q8.setBackgroundResource(R.color.color_white);
    }

    @yt.k
    public final P k6() {
        P p10 = this.f13808v8;
        if (p10 != null) {
            return p10;
        }
        f0.S("mPresenter");
        return null;
    }

    @yt.k
    public final String l6() {
        return this.f13810x8;
    }

    public boolean m6() {
        return this.f13809w8;
    }

    public final void n6(int i10, int i11, boolean z10) {
        if (a5.f.i().o()) {
            k6().S(i10, i11, z10);
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    public final void p6(@yt.k P p10) {
        f0.p(p10, "<set-?>");
        this.f13808v8 = p10;
    }

    public final void q6(@yt.k String str) {
        f0.p(str, "<set-?>");
        this.f13810x8 = str;
    }

    public void r6(boolean z10) {
        this.f13809w8 = z10;
    }

    public final void s6(ArticleBean articleBean, int i10) {
        String description;
        String strC3;
        androidx.fragment.app.g gVarP4 = P4();
        f0.o(gVarP4, "requireActivity()");
        String str = "https://bs.flydigi.com/topicDetail?id=" + articleBean.getId();
        if (n0.x(articleBean.getTitle())) {
            description = articleBean.getTitle();
            f0.m(description);
        } else if (n0.x(articleBean.getDescription())) {
            description = articleBean.getDescription();
            f0.m(description);
        } else {
            description = "";
        }
        if (n0.x(articleBean.getTitle())) {
            strC3 = articleBean.getDescription();
            if (strC3 == null) {
                strC3 = c3(R.string.community_share_article_desc);
                f0.o(strC3, "getString(R.string.community_share_article_desc)");
            }
        } else {
            strC3 = c3(R.string.community_share_article_desc);
            f0.o(strC3, "{\n                    ge…e_desc)\n                }");
        }
        u9.f.b(gVarP4, str, description, strC3, R.mipmap.ic_launcher, new a(this, i10, articleBean));
    }

    @Override // com.flydigi.community.ui.article_list.k.b
    public void x2(int i10, boolean z10) {
        ei.h hVarG2 = this.f13331r8.g2(i10);
        if (hVarG2 instanceof ArticleItem) {
            ArrayList arrayList = new ArrayList(1);
            if (z10) {
                arrayList.add(1);
                ArticleItem articleItem = (ArticleItem) hVarG2;
                articleItem.z().setLike(1);
                ArticleBean articleBeanZ = articleItem.z();
                articleBeanZ.setLikes(articleBeanZ.getLikes() + 1);
            } else {
                arrayList.add(2);
                ArticleItem articleItem2 = (ArticleItem) hVarG2;
                articleItem2.z().setLike(0);
                ArticleBean articleBeanZ2 = articleItem2.z();
                articleBeanZ2.setLikes(articleBeanZ2.getLikes() - 1);
            }
            if (z10) {
                ArticleItem articleItem3 = (ArticleItem) hVarG2;
                u9.h.i(X1(), articleItem3.z().getId(), articleItem3.z().getType(), this.f13810x8, "点赞");
            }
            this.f13331r8.M4(hVarG2, arrayList);
        }
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        k6().j(i11 + 1, c6());
    }
}
