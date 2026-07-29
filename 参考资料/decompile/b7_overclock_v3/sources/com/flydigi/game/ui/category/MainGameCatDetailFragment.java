package com.flydigi.game.ui.category;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.base.common.o;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DataConstant;
import com.flydigi.game.R;
import com.flydigi.game.adapter.GameItemAdapter;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.api.GameApiService;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameCatEntity;
import com.flydigi.game.data.bean.GameInCat;
import com.flydigi.game.ui.category.MainGameCatDetailFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import g.p0;
import i9.a;
import java.util.Collection;
import java.util.List;
import m5.c;
import m5.c0;
import m5.f0;
import mg.j;
import o5.l;
import o5.p;
import p5.d;
import u9.h;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class MainGameCatDetailFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final String f15833y8 = "game_cat_bean";

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public SmartRefreshLayout f15834p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public RecyclerView f15835q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public GameItemAdapter f15836r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public int f15837s8 = 1;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public final int f15838t8 = 15;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public GameCatEntity f15839u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public View f15840v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public View f15841w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public View f15842x8;

    public class a extends c<BaseResponse<GameInCat>> {
        public a() {
        }

        @Override // m5.c
        public void a(String str, int i10) {
            super.a(str, i10);
            o.w(MainGameCatDetailFragment.this.c3(R.string.net_state_error));
            if (MainGameCatDetailFragment.this.s3()) {
                if (MainGameCatDetailFragment.this.f15837s8 != 1) {
                    MainGameCatDetailFragment.this.f15836r8.loadMoreFail();
                } else {
                    MainGameCatDetailFragment.this.f15834p8.N();
                    MainGameCatDetailFragment.this.f15836r8.setEmptyView(MainGameCatDetailFragment.this.f15842x8);
                }
            }
        }

        @Override // m5.c
        public void d(BaseResponse<GameInCat> baseResponse) {
            if (MainGameCatDetailFragment.this.s3()) {
                if (MainGameCatDetailFragment.this.f15837s8 == 1) {
                    MainGameCatDetailFragment.this.f15834p8.N();
                } else {
                    MainGameCatDetailFragment.this.f15836r8.loadMoreComplete();
                }
                MainGameCatDetailFragment.this.m6(baseResponse.data);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResponse n6(BaseResponse baseResponse) throws Exception {
        List<GameBean> list;
        GameInCat gameInCat = (GameInCat) baseResponse.data;
        if (gameInCat != null && (list = gameInCat.list) != null) {
            for (GameBean gameBean : list) {
                gameBean.installed = p.c(gameBean.packageName);
                GameBean installedGameBean = DBManager.getInstalledGameBean(gameBean.packageName);
                if (installedGameBean != null) {
                    gameBean.localPath = installedGameBean.localPath;
                    gameBean.progress = installedGameBean.progress;
                    gameBean.wifiRequired = installedGameBean.wifiRequired;
                    gameBean.updateAble = installedGameBean.updateAble;
                }
            }
        }
        return baseResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o6(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        GameBean item = this.f15836r8.getItem(i10);
        if (item != null) {
            h.n(X1(), "游戏详情访问", item.f15815id, "list");
            h3.a.j().d(a.e.f31969e).withString(DataConstant.KEY_GAME_ID, item.f15815id).navigation(X1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p6(View view) {
        this.f15837s8 = 1;
        l6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q6(View view) {
        this.f15837s8 = 1;
        l6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r6(j jVar) {
        this.f15837s8 = 1;
        l6();
    }

    public static MainGameCatDetailFragment s6(GameCatEntity gameCatEntity) {
        MainGameCatDetailFragment mainGameCatDetailFragment = new MainGameCatDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f15833y8, gameCatEntity);
        mainGameCatDetailFragment.c5(bundle);
        return mainGameCatDetailFragment;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_category_detail;
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        this.f15836r8.setEmptyView(this.f15840v8);
        this.f15834p8.z();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        if (T1() != null) {
            this.f15839u8 = (GameCatEntity) T1().get(f15833y8);
            this.f15834p8 = (SmartRefreshLayout) F5(R.id.smart_refresh_layout);
            this.f15835q8 = (RecyclerView) F5(R.id.rv_content);
            this.f15836r8 = new GameItemAdapter(null, "list");
            this.f15835q8.setLayoutManager(new LinearLayoutManager(H1()));
            this.f15835q8.setHasFixedSize(true);
            this.f15835q8.setAdapter(this.f15836r8);
            this.f15836r8.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: s8.g
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i10) {
                    this.f49530a.o6(baseQuickAdapter, view2, i10);
                }
            });
            this.f15840v8 = w2().inflate(R.layout.base_layout_view_placeholder_loading, (ViewGroup) this.f15835q8.getParent(), false);
            this.f15841w8 = w2().inflate(R.layout.base_layout_view_placehoder_empty, (ViewGroup) this.f15835q8.getParent(), false);
            this.f15842x8 = w2().inflate(R.layout.base_layout_view_placehoder_error, (ViewGroup) this.f15835q8.getParent(), false);
            this.f15841w8.setOnClickListener(new View.OnClickListener() { // from class: s8.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f49529a.p6(view2);
                }
            });
            this.f15842x8.setOnClickListener(new View.OnClickListener() { // from class: s8.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f49528a.q6(view2);
                }
            });
            this.f15836r8.setEnableLoadMore(true);
            this.f15836r8.setLoadMoreView(new d());
            this.f15836r8.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: s8.h
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
                public final void onLoadMoreRequested() {
                    this.f49531a.l6();
                }
            }, this.f15835q8);
            this.f15834p8.L(new sg.d() { // from class: s8.j
                @Override // sg.d
                public final void o(mg.j jVar) {
                    this.f49533a.r6(jVar);
                }
            });
        }
    }

    public final void l6() {
        ((GameApiService) f0.i().k().g(GameApiService.class)).getGameByCat(this.f15837s8, 15, this.f15839u8.f15817id).s0(c0.r()).A3(new dj.o() { // from class: s8.i
            @Override // dj.o
            public final Object apply(Object obj) {
                return MainGameCatDetailFragment.n6((BaseResponse) obj);
            }
        }).s0(c0.t()).s0(l.d()).c(new a());
    }

    public final void m6(GameInCat gameInCat) {
        if (this.f15837s8 == 1) {
            this.f15836r8.setNewData(gameInCat.list);
        } else {
            this.f15836r8.addData((Collection) gameInCat.list);
        }
        if (gameInCat.total == 0) {
            this.f15836r8.setEmptyView(this.f15841w8);
        }
        if (gameInCat.cur_page >= gameInCat.total_page) {
            this.f15836r8.loadMoreEnd();
        }
        this.f15837s8++;
    }
}
