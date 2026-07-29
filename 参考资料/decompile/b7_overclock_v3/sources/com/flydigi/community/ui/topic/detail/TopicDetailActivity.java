package com.flydigi.community.ui.topic.detail;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.h;
import com.flydigi.base.common.o;
import com.flydigi.base.common.p;
import com.flydigi.community.R;
import com.flydigi.community.ui.article_list.ArticleListFragment;
import com.flydigi.community.ui.topic.detail.e;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.NavBean;
import com.flydigi.data.bean.community.TopicBean;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.b;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import i9.a;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nTopicDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopicDetailActivity.kt\ncom/flydigi/community/ui/topic/detail/TopicDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,272:1\n1#2:273\n1864#3,3:274\n*S KotlinDebug\n*F\n+ 1 TopicDetailActivity.kt\ncom/flydigi/community/ui/topic/detail/TopicDetailActivity\n*L\n258#1:274,3\n*E\n"})
@Route(path = a.b.f31918c)
public final class TopicDetailActivity extends p implements e.b {

    @k
    public static final a J7 = new a(null);
    public static final int K7 = 1;
    public e.a E7;

    @hk.e
    @Autowired(name = DataConstant.COMMUNITY_ARTICLE_SOURCE)
    @k
    public String F7 = "";

    @hk.e
    @l
    @Autowired(name = a.b.f31929n)
    public TopicBean G7;

    @hk.e
    @Autowired(name = a.b.f31930o)
    public int H7;

    @l
    public MenuItem I7;
    public y5.f K2;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static final class b implements UMShareListener {
        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(@k SHARE_MEDIA p02) {
            f0.p(p02, "p0");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(@k SHARE_MEDIA p02, @k Throwable p12) {
            f0.p(p02, "p0");
            f0.p(p12, "p1");
            ToastUtils.T(R.string.community_share_failed);
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(@k SHARE_MEDIA p02) {
            f0.p(p02, "p0");
            ToastUtils.T(R.string.community_share_success);
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(@k SHARE_MEDIA p02) {
            f0.p(p02, "p0");
        }
    }

    public static final class c extends FragmentStateAdapter {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ List<NavBean> f14097m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List<NavBean> list) {
            super(TopicDetailActivity.this);
            this.f14097m = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @k
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public ArticleListFragment n(int i10) {
            String title;
            ArticleListFragment.a aVar = ArticleListFragment.f13800z8;
            TopicBean topicBean = TopicDetailActivity.this.G7;
            if (topicBean == null || (title = topicBean.getTitle()) == null) {
                title = "";
            }
            return aVar.a(title, this.f14097m.get(i10));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f14097m.size();
        }
    }

    public static final void o4(Ref.BooleanRef hasReset, final TopicDetailActivity this$0, AppBarLayout appBarLayout, int i10) {
        Drawable icon;
        Drawable drawableMutate;
        f0.p(hasReset, "$hasReset");
        f0.p(this$0, "this$0");
        if (Math.abs(i10) != 0) {
            if (hasReset.element) {
                hasReset.element = false;
                this$0.c4().e(new Runnable() { // from class: com.flydigi.community.ui.topic.detail.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        TopicDetailActivity.p4(this.f14105a);
                    }
                });
                return;
            }
            return;
        }
        hasReset.element = true;
        ku.b.b(this$0);
        y5.f fVar = this$0.K2;
        y5.f fVar2 = null;
        if (fVar == null) {
            f0.S("viewBinding");
            fVar = null;
        }
        Drawable navigationIcon = fVar.f56320c.getNavigationIcon();
        if (navigationIcon != null && (drawableMutate = navigationIcon.mutate()) != null) {
            n0.c.n(drawableMutate, -1);
            y5.f fVar3 = this$0.K2;
            if (fVar3 == null) {
                f0.S("viewBinding");
                fVar3 = null;
            }
            fVar3.f56320c.setNavigationIcon(drawableMutate);
        }
        y5.f fVar4 = this$0.K2;
        if (fVar4 == null) {
            f0.S("viewBinding");
        } else {
            fVar2 = fVar4;
        }
        fVar2.f56322e.setTitle("");
        MenuItem menuItem = this$0.I7;
        if (menuItem == null || (icon = menuItem.getIcon()) == null) {
            return;
        }
        n0.c.n(icon, -1);
    }

    public static final void p4(TopicDetailActivity this$0) {
        String title;
        Drawable icon;
        Drawable drawableMutate;
        f0.p(this$0, "this$0");
        ku.b.c(this$0);
        y5.f fVar = this$0.K2;
        y5.f fVar2 = null;
        if (fVar == null) {
            f0.S("viewBinding");
            fVar = null;
        }
        Drawable navigationIcon = fVar.f56320c.getNavigationIcon();
        if (navigationIcon != null && (drawableMutate = navigationIcon.mutate()) != null) {
            n0.c.n(drawableMutate, -16777216);
            y5.f fVar3 = this$0.K2;
            if (fVar3 == null) {
                f0.S("viewBinding");
                fVar3 = null;
            }
            fVar3.f56320c.setNavigationIcon(drawableMutate);
        }
        MenuItem menuItem = this$0.I7;
        if (menuItem != null && (icon = menuItem.getIcon()) != null) {
            n0.c.n(icon, -16777216);
        }
        y5.f fVar4 = this$0.K2;
        if (fVar4 == null) {
            f0.S("viewBinding");
            fVar4 = null;
        }
        fVar4.f56320c.setTitleTextColor(h0.d.f(this$0, R.color.color_000000_a90));
        y5.f fVar5 = this$0.K2;
        if (fVar5 == null) {
            f0.S("viewBinding");
        } else {
            fVar2 = fVar5;
        }
        Toolbar toolbar = fVar2.f56320c;
        TopicBean topicBean = this$0.G7;
        if (topicBean == null || (title = topicBean.getTitle()) == null) {
            title = "";
        }
        toolbar.setTitle(title);
    }

    public static final void q4(TopicDetailActivity this$0, View view) {
        f0.p(this$0, "this$0");
        if (a5.f.i().o()) {
            h3.a.j().d(a.b.f31927l).withParcelable(a.b.f31929n, this$0.G7).navigation(this$0, 1);
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation(this$0);
        }
    }

    public static final void t4(List nav, TabLayout.i tab, int i10) {
        f0.p(nav, "$nav");
        f0.p(tab, "tab");
        tab.D(((NavBean) nav.get(i10)).getName());
    }

    @Override // com.flydigi.community.ui.topic.detail.e.b
    public void A0(@k TopicBean topic) {
        f0.p(topic, "topic");
        u4(topic, true);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.community_activity_topic_detail;
    }

    @Override // com.flydigi.base.common.p
    public void h4() {
        super.h4();
        ku.b.h(this, true);
    }

    public final int n4() {
        List<NavBean> nav;
        TopicBean topicBean = this.G7;
        if (topicBean != null && (nav = topicBean.getNav()) != null) {
            int i10 = 0;
            for (Object obj : nav) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                if (((NavBean) obj).getType() == 2) {
                    return i10;
                }
                i10 = i11;
            }
        }
        return 0;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @l Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (1 == i10 && i11 == -1) {
            y5.f fVar = this.K2;
            y5.f fVar2 = null;
            if (fVar == null) {
                f0.S("viewBinding");
                fVar = null;
            }
            fVar.f56328k.setCurrentItem(n4());
            y5.f fVar3 = this.K2;
            if (fVar3 == null) {
                f0.S("viewBinding");
                fVar3 = null;
            }
            RecyclerView.g adapter = fVar3.f56328k.getAdapter();
            if (adapter != null) {
                y5.f fVar4 = this.K2;
                if (fVar4 == null) {
                    f0.S("viewBinding");
                } else {
                    fVar2 = fVar4;
                }
                adapter.notifyItemChanged(fVar2.f56328k.getCurrentItem());
            }
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        TopicBean topicBean = this.G7;
        if (topicBean != null) {
            this.H7 = topicBean.getId();
        }
        if (this.G7 == null && this.H7 == 0) {
            finish();
        }
        y5.f fVar = this.K2;
        y5.f fVar2 = null;
        if (fVar == null) {
            f0.S("viewBinding");
            fVar = null;
        }
        Q3(fVar.f56320c);
        y5.f fVar3 = this.K2;
        if (fVar3 == null) {
            f0.S("viewBinding");
            fVar3 = null;
        }
        com.blankj.utilcode.util.f.a(fVar3.f56320c);
        y5.f fVar4 = this.K2;
        if (fVar4 == null) {
            f0.S("viewBinding");
            fVar4 = null;
        }
        fVar4.f56322e.setTitle("");
        y5.f fVar5 = this.K2;
        if (fVar5 == null) {
            f0.S("viewBinding");
            fVar5 = null;
        }
        fVar5.f56322e.setCollapsedTitleTextColor(h0.d.f(this, R.color.color_000000_a90));
        y5.f fVar6 = this.K2;
        if (fVar6 == null) {
            f0.S("viewBinding");
            fVar6 = null;
        }
        fVar6.f56322e.setExpandedTitleColor(0);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        y5.f fVar7 = this.K2;
        if (fVar7 == null) {
            f0.S("viewBinding");
            fVar7 = null;
        }
        fVar7.f56319b.e(new AppBarLayout.h() { // from class: com.flydigi.community.ui.topic.detail.b
            @Override // com.google.android.material.appbar.AppBarLayout.h, com.google.android.material.appbar.AppBarLayout.c
            public final void a(AppBarLayout appBarLayout, int i10) {
                TopicDetailActivity.o4(booleanRef, this, appBarLayout, i10);
            }
        });
        y5.f fVar8 = this.K2;
        if (fVar8 == null) {
            f0.S("viewBinding");
        } else {
            fVar2 = fVar8;
        }
        fVar2.f56321d.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.community.ui.topic.detail.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicDetailActivity.q4(this.f14101a, view);
            }
        });
        this.E7 = new TopicDetailPresenter(this);
        TopicBean topicBean2 = this.G7;
        if (topicBean2 != null) {
            u4(topicBean2, false);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@k Menu menu) {
        f0.p(menu, "menu");
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.community_menu_topic_detail, menu);
        this.I7 = menu.findItem(R.id.menu_share);
        return true;
    }

    @Override // com.flydigi.base.common.p, android.app.Activity
    public boolean onOptionsItemSelected(@k MenuItem item) {
        f0.p(item, "item");
        if (item.getItemId() != R.id.menu_share) {
            return super.onOptionsItemSelected(item);
        }
        r4();
        return true;
    }

    @Override // com.flydigi.base.common.c, androidx.appcompat.app.f, android.app.Activity
    public void onPostCreate(@l Bundle bundle) {
        super.onPostCreate(bundle);
        e.a aVar = this.E7;
        if (aVar == null) {
            f0.S("mPresenter");
            aVar = null;
        }
        aVar.T(this.H7);
    }

    public final void r4() {
        z1 z1Var;
        TopicBean topicBean = this.G7;
        if (topicBean != null) {
            String str = "https://bs.flydigi.com/topicListDetail/" + topicBean.getId();
            String string = getString(R.string.community_share_topic, new Object[]{topicBean.getTitle()});
            f0.o(string, "getString(\n             …t.title\n                )");
            String subTitle = topicBean.getSubTitle();
            if (subTitle == null) {
                subTitle = "";
            }
            u9.f.b(this, str, string, subTitle, R.mipmap.ic_launcher, new b());
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            o.E(getString(R.string.community_share_content_error));
        }
    }

    public final void s4(final List<NavBean> list) {
        y5.f fVar = this.K2;
        y5.f fVar2 = null;
        if (fVar == null) {
            f0.S("viewBinding");
            fVar = null;
        }
        if (fVar.f56328k.getAdapter() != null) {
            return;
        }
        y5.f fVar3 = this.K2;
        if (fVar3 == null) {
            f0.S("viewBinding");
            fVar3 = null;
        }
        fVar3.f56328k.setAdapter(new c(list));
        y5.f fVar4 = this.K2;
        if (fVar4 == null) {
            f0.S("viewBinding");
            fVar4 = null;
        }
        fVar4.f56328k.setOffscreenPageLimit(list.size());
        y5.f fVar5 = this.K2;
        if (fVar5 == null) {
            f0.S("viewBinding");
            fVar5 = null;
        }
        TabLayout tabLayout = fVar5.f56324g;
        y5.f fVar6 = this.K2;
        if (fVar6 == null) {
            f0.S("viewBinding");
        } else {
            fVar2 = fVar6;
        }
        new com.google.android.material.tabs.b(tabLayout, fVar2.f56328k, new b.InterfaceC0211b() { // from class: com.flydigi.community.ui.topic.detail.c
            @Override // com.google.android.material.tabs.b.InterfaceC0211b
            public final void a(TabLayout.i iVar, int i10) {
                TopicDetailActivity.t4(list, iVar, i10);
            }
        }).a();
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        y5.f fVarC = y5.f.c(LayoutInflater.from(this));
        f0.o(fVarC, "inflate(\n            Lay…ater.from(this)\n        )");
        this.K2 = fVarC;
        if (fVarC == null) {
            f0.S("viewBinding");
            fVarC = null;
        }
        super.setContentView(fVarC.getRoot());
    }

    public final void u4(TopicBean topicBean, boolean z10) {
        if (z10) {
            com.flydigi.userBehavior.a.a().b(this, "社区_话题_" + topicBean.getTitle());
        }
        y5.f fVar = this.K2;
        y5.f fVar2 = null;
        if (fVar == null) {
            f0.S("viewBinding");
            fVar = null;
        }
        fVar.f56327j.setText('#' + topicBean.getTitle());
        y5.f fVar3 = this.K2;
        if (fVar3 == null) {
            f0.S("viewBinding");
            fVar3 = null;
        }
        fVar3.f56326i.setText(topicBean.getSubTitle());
        y5.f fVar4 = this.K2;
        if (fVar4 == null) {
            f0.S("viewBinding");
            fVar4 = null;
        }
        fVar4.f56325h.setVisibility(topicBean.getCount() <= 0 ? 8 : 0);
        y5.f fVar5 = this.K2;
        if (fVar5 == null) {
            f0.S("viewBinding");
            fVar5 = null;
        }
        fVar5.f56325h.setText(getString(R.string.community_count_of_topic, new Object[]{Integer.valueOf(topicBean.getCount())}));
        h<Drawable> hVarP = com.bumptech.glide.b.H(this).t(topicBean.getBgImage());
        int i10 = R.drawable.pic_banner_place_holder;
        h hVarX = hVarP.E0(i10).x(i10);
        y5.f fVar6 = this.K2;
        if (fVar6 == null) {
            f0.S("viewBinding");
        } else {
            fVar2 = fVar6;
        }
        hVarX.s1(fVar2.f56323f);
        List<NavBean> nav = topicBean.getNav();
        if (nav != null) {
            s4(nav);
        }
    }

    @Override // com.flydigi.community.ui.topic.detail.e.b
    public void y2(@l String str) {
        if (str != null) {
            ToastUtils.W(str, new Object[0]);
        }
    }
}
