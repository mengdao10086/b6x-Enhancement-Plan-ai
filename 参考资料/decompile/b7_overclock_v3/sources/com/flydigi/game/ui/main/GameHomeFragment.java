package com.flydigi.game.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.b1;
import com.blankj.utilcode.util.n0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.base.common.o;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.BannerBean;
import com.flydigi.game.R;
import com.flydigi.game.adapter.GameItemAdapter;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameDetailBean;
import com.flydigi.game.data.bean.RecoGameBean;
import com.flydigi.game.data.bean.RecoGameEntity;
import com.flydigi.game.ui.main.GameHomeFragment;
import com.flydigi.game.ui.main.a;
import com.flydigi.game.ui.main.b;
import com.flydigi.game.utils.FZGameDownloadHandler;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tmall.ultraviewpager.UltraViewPager;
import g.p0;
import h0.d;
import i9.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mg.j;
import u9.g;
import u9.h;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class GameHomeFragment extends FZLazyFragment implements b.InterfaceC0163b {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public UltraViewPager f15884p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public RecyclerView f15885q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public com.flydigi.game.ui.main.a f15886r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public GameItemAdapter f15887s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public com.flydigi.game.ui.main.c f15888t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public SmartRefreshLayout f15889u8;

    public class a extends m5.c<BaseResponse<RecoGameBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15890a;

        public a(boolean z10) {
            this.f15890a = z10;
        }

        @Override // m5.c
        public void a(String str, int i10) {
            super.a(str, i10);
            if (this.f15890a) {
                GameHomeFragment.this.f15887s8.setEmptyView(GameHomeFragment.this.f13324k8);
            }
            GameHomeFragment.this.f15889u8.N();
            GameHomeFragment.this.f15889u8.g();
        }

        @Override // m5.c
        public void d(BaseResponse<RecoGameBean> baseResponse) {
            GameHomeFragment.this.p6(baseResponse.data, this.f15890a, true);
        }
    }

    public class b extends m5.c<BaseResponse<RecoGameBean>> {
        public b() {
        }

        @Override // m5.c
        public void a(String str, int i10) {
            super.a(str, i10);
            GameHomeFragment.this.f15889u8.N();
            GameHomeFragment.this.f15889u8.g();
        }

        @Override // m5.c
        public void d(BaseResponse<RecoGameBean> baseResponse) {
            GameHomeFragment.this.p6(baseResponse.data, false, false);
        }
    }

    public class c extends m5.c<BaseResponse<List<BannerBean>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15893a;

        public c(boolean z10) {
            this.f15893a = z10;
        }

        @Override // m5.c
        public void a(String str, int i10) {
            super.a(str, i10);
            GameHomeFragment.this.f15889u8.N();
            GameHomeFragment.this.f15889u8.g();
            if (this.f15893a) {
                return;
            }
            GameHomeFragment.this.f15888t8.m0();
        }

        @Override // m5.c
        public void d(BaseResponse<List<BannerBean>> baseResponse) {
            GameHomeFragment.this.q6(baseResponse.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A6() {
        ku.b.d(P4(), d.f(P4(), R.color.white));
        ku.b.c(P4());
    }

    public static GameHomeFragment B6() {
        return new GameHomeFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s6(BannerBean bannerBean) {
        HashMap map = new HashMap();
        map.put("title", bannerBean.getTitle());
        g.a().e(X1(), "GAME_BANNER_CLICK", map);
        u9.d.a(bannerBean.getType(), bannerBean.getData(), ArticleReadLog.f13288f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t6(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        GameBean item = this.f15887s8.getItem(i10);
        if (item == null || !n0.x(item.f15815id)) {
            return;
        }
        h.n(X1(), "游戏详情访问", item.f15815id, "list");
        h3.a.j().d(a.e.f31969e).withString(DataConstant.KEY_GAME_ID, item.f15815id).navigation(X1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u6(View view) {
        this.f15889u8.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v6(View view) {
        this.f15889u8.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w6(j jVar) {
        this.f15889u8.g();
        this.f15887s8.setEnableLoadMore(false);
        this.f15888t8.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x6() {
        this.f15889u8.N();
        this.f15888t8.O(false);
    }

    public static /* synthetic */ void y6(View view) {
        h3.a.j().d(a.e.f31971g).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z6(View view) {
        h3.a.j().d(a.e.f31970f).navigation(X1());
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        this.f15888t8 = new com.flydigi.game.ui.main.c(this);
    }

    @Override // com.flydigi.game.ui.main.b.InterfaceC0163b
    public void L0(List<GameDetailBean> list) {
        if (NetworkUtils.S()) {
            for (GameDetailBean gameDetailBean : list) {
                GameBean gameBeanConvertGameBean = gameDetailBean.convertGameBean();
                FZGameDownloadHandler.getInstance().start(gameDetailBean.link, gameDetailBean.pkgname);
                FZGameDownloadHandler.getInstance().addGameDownloadInfoToDB(gameBeanConvertGameBean);
            }
            o.E(c3(R.string.game_subscribed_game_start_downloading));
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_home;
    }

    @Override // com.flydigi.game.ui.main.b.InterfaceC0163b
    public void M1(z<BaseResponse<RecoGameBean>> zVar, boolean z10) {
        zVar.c(new a(z10));
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        Y5();
    }

    @Override // com.flydigi.base.common.FZFragment
    public void S5() {
        H5().e(new Runnable() { // from class: w8.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f54598a.A6();
            }
        });
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void U3(boolean z10) {
        super.U3(z10);
        if (!z10) {
            UltraViewPager ultraViewPager = this.f15884p8;
            if (ultraViewPager != null) {
                ultraViewPager.setInfiniteLoop(true);
                this.f15884p8.setAutoScroll(5000);
                return;
            }
            return;
        }
        UltraViewPager ultraViewPager2 = this.f15884p8;
        if (ultraViewPager2 != null) {
            ultraViewPager2.e();
        }
        SmartRefreshLayout smartRefreshLayout = this.f15889u8;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.N();
        }
    }

    @Override // com.flydigi.game.ui.main.b.InterfaceC0163b
    public void W() {
        this.f15889u8.N();
        this.f15888t8.O(true);
    }

    @Override // com.flydigi.game.ui.main.b.InterfaceC0163b
    public void Y(z<BaseResponse<RecoGameBean>> zVar) {
        zVar.c(new b());
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        GameItemAdapter gameItemAdapter = this.f15887s8;
        if (gameItemAdapter != null) {
            gameItemAdapter.setEnableLoadMore(false);
        }
        com.flydigi.game.ui.main.c cVar = this.f15888t8;
        if (cVar != null) {
            cVar.r();
        }
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        UltraViewPager ultraViewPager = this.f15884p8;
        if (ultraViewPager != null) {
            ultraViewPager.e();
        }
        SmartRefreshLayout smartRefreshLayout = this.f15889u8;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.N();
        }
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        UltraViewPager ultraViewPager;
        super.f4();
        com.flydigi.userBehavior.a.a().b(X1(), "游戏首页");
        if (!C3() || (ultraViewPager = this.f15884p8) == null) {
            return;
        }
        ultraViewPager.setInfiniteLoop(true);
        this.f15884p8.setAutoScroll(5000);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        com.blankj.utilcode.util.o.r(view.findViewById(R.id.btn_search), new View.OnClickListener() { // from class: w8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameHomeFragment.y6(view2);
            }
        });
        com.blankj.utilcode.util.o.r(view.findViewById(R.id.btn_download), new View.OnClickListener() { // from class: w8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f54591a.z6(view2);
            }
        });
        this.f15889u8 = (SmartRefreshLayout) view.findViewById(R.id.smart_refresh_layout);
        this.f15884p8 = (UltraViewPager) view.findViewById(R.id.ultra_view_pager);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_content);
        this.f15885q8 = recyclerView;
        P5(recyclerView);
        r6();
    }

    public final void p6(RecoGameBean recoGameBean, boolean z10, boolean z11) {
        List<RecoGameEntity> list;
        this.f15889u8.N();
        if (recoGameBean == null || (list = recoGameBean.datalist) == null) {
            if (!z11 || !z10) {
                this.f15887s8.loadMoreEnd();
                return;
            } else if (this.f15887s8.getData().size() == 0) {
                this.f15887s8.setEmptyView(this.f13322i8);
                return;
            } else {
                this.f15887s8.loadMoreEnd();
                return;
            }
        }
        if (recoGameBean.cur_page >= recoGameBean.total_page || list.size() == 0) {
            this.f15887s8.loadMoreEnd();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (RecoGameEntity recoGameEntity : recoGameBean.datalist) {
            GameBean gameBean = new GameBean();
            gameBean.catId = recoGameEntity.catId;
            gameBean.catName = recoGameEntity.catName;
            gameBean.type = 2;
            arrayList.add(gameBean);
            arrayList.addAll(recoGameEntity.games);
        }
        if (!z10) {
            this.f15887s8.addData((Collection) arrayList);
            this.f15887s8.loadMoreComplete();
            if (z11) {
                this.f15887s8.setEnableLoadMore(true);
                return;
            } else {
                this.f15888t8.O(true);
                return;
            }
        }
        if (arrayList.size() == 0 || this.f15887s8.getData().size() == 0) {
            this.f15887s8.setEmptyView(this.f13322i8);
        }
        this.f15887s8.setNewData(arrayList);
        this.f15887s8.setEnableLoadMore(true);
        if (z11) {
            this.f15889u8.N();
        }
    }

    public final void q6(List<BannerBean> list) {
        this.f15886r8.setData(list);
        this.f15884p8.j();
        int iB = b1.b(4.0f);
        int i10 = iB * 2;
        this.f15884p8.getIndicator().g(UltraViewPager.Orientation.HORIZONTAL).m(-1).setNormalColor(Color.parseColor("#6CFFFFFF")).e(81).k(0, 0, 0, i10).i(iB).h(i10).a();
        this.f15884p8.setInfiniteLoop(true);
        this.f15884p8.setAutoScroll(5000);
    }

    public final void r6() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField(xf.j.f55230b);
            declaredField.setAccessible(true);
            declaredField.set(this.f15884p8.getViewPager(), new p5.a(this.f15884p8.getViewPager().getContext()));
        } catch (IllegalAccessException | NoSuchFieldException e10) {
            e10.printStackTrace();
        }
        com.flydigi.game.ui.main.a aVar = new com.flydigi.game.ui.main.a();
        this.f15886r8 = aVar;
        this.f15884p8.setAdapter(aVar);
        this.f15886r8.c(new a.InterfaceC0162a() { // from class: w8.h
            @Override // com.flydigi.game.ui.main.a.InterfaceC0162a
            public final void a(BannerBean bannerBean) {
                this.f54597a.s6(bannerBean);
            }
        });
        this.f15887s8 = new GameItemAdapter(null, "list");
        this.f15885q8.setLayoutManager(new LinearLayoutManager(H1()));
        this.f15885q8.setAdapter(this.f15887s8);
        this.f15887s8.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: w8.f
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                this.f54595a.t6(baseQuickAdapter, view, i10);
            }
        });
        this.f13322i8.setOnClickListener(new View.OnClickListener() { // from class: w8.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f54593a.u6(view);
            }
        });
        this.f13324k8.setOnClickListener(new View.OnClickListener() { // from class: w8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f54592a.v6(view);
            }
        });
        this.f15887s8.setEnableLoadMore(true);
        this.f15887s8.setLoadMoreView(new p5.d());
        this.f15889u8.L(new sg.d() { // from class: w8.j
            @Override // sg.d
            public final void o(mg.j jVar) {
                this.f54599a.w6(jVar);
            }
        });
        this.f15887s8.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: w8.g
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public final void onLoadMoreRequested() {
                this.f54596a.x6();
            }
        }, this.f15885q8);
    }

    @Override // com.flydigi.game.ui.main.b.InterfaceC0163b
    public void s1(z<BaseResponse<List<BannerBean>>> zVar, boolean z10) {
        zVar.c(new c(z10));
    }
}
