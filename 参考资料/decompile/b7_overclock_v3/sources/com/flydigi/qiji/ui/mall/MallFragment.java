package com.flydigi.qiji.ui.mall;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.b1;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fdg.flashplay.farsef.R;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.BannerBean;
import com.flydigi.data.bean.MallProductBean;
import com.flydigi.qiji.ui.mall.a;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tmall.ultraviewpager.UltraViewPager;
import g.p0;
import h5.e;
import i9.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import l4.f;
import m5.c0;
import m5.f0;
import mg.j;
import o5.l;
import o5.m;
import u9.d;
import u9.g;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public class MallFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public UltraViewPager f16144p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public RecyclerView f16145q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public SmartRefreshLayout f16146r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public com.flydigi.qiji.ui.mall.a f16147s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public List<MallProductBean.DataBean> f16148t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public MallProductAdapter f16149u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public int f16150v8 = 1;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public final int f16151w8 = 10;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public Gson f16152x8;

    public class a extends GridLayoutManager {
        public a(Context context, int i10) {
            super(context, i10);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
        public boolean w() {
            return true;
        }
    }

    public class b extends TypeToken<List<BannerBean>> {
        public b() {
        }
    }

    public class c extends TypeToken<List<MallProductBean.DataBean>> {
        public c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A6(View view) {
        this.f16146r8.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B6(View view) {
        this.f16150v8 = 1;
        r6(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C6(BannerBean bannerBean) {
        String type = bannerBean.getType();
        HashMap map = new HashMap();
        map.put("title", bannerBean.getTitle());
        g.a().e(X1(), "MALL_BANNER_CLICK", map);
        d.a(type, bannerBean.getData(), ArticleReadLog.f13287e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D6(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        h3.a.j().d(a.f.f31977f).withInt(a.f.f31978g, this.f16148t8.get(i10).getId()).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E6(j jVar) {
        q6();
        this.f16150v8 = 1;
        r6(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F6(j jVar) {
        this.f16150v8++;
        r6(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G6() {
        ku.b.d(P4(), h0.d.f(P4(), R.color.white));
        ku.b.c(P4());
    }

    public static MallFragment H6() {
        return new MallFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t6(List list) throws Exception {
        if (list != null) {
            m.k(DataConstant.SP_MAIN).B(DataConstant.SP_MAIN_RECOMMEND_DATA_BANNER, this.f16152x8.toJson(list));
            s6(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u6(Throwable th2) throws Exception {
        s6(Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v6(Throwable th2) throws Exception {
        this.f16149u8.setEmptyView(this.f13324k8);
        this.f16146r8.u(200);
        this.f16146r8.X(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w6() throws Exception {
        this.f16146r8.u(200);
        this.f16146r8.X(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x6() {
        this.f16146r8.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y6(io.reactivex.disposables.b bVar) throws Exception {
        ThreadUtils.s0(new Runnable() { // from class: g9.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f29083a.x6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z6(boolean z10, MallProductBean mallProductBean) throws Exception {
        List<MallProductBean.DataBean> data = mallProductBean.getData();
        if (!z10 && data != null && data.size() > 0) {
            m.k(DataConstant.SP_MAIN).B(DataConstant.SP_MAIN_MALL_PRODUCT_LIST, this.f16152x8.toJson(data));
        }
        if (!z10) {
            this.f16148t8.clear();
            this.f16146r8.n0(true);
        }
        if (data != null) {
            this.f16148t8.addAll(data);
        }
        this.f16149u8.notifyDataSetChanged();
        if ((data != null ? data.size() : 0) != 10) {
            this.f16146r8.n0(false);
        }
        if (z10 || this.f16148t8.size() != 0) {
            return;
        }
        this.f16149u8.setEmptyView(this.f13322i8);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_fragment_mall;
    }

    @Override // com.flydigi.base.common.FZFragment
    public void S5() {
        H5().e(new Runnable() { // from class: g9.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f29082a.G6();
            }
        });
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void U3(boolean z10) {
        super.U3(z10);
        if (z10) {
            UltraViewPager ultraViewPager = this.f16144p8;
            if (ultraViewPager != null) {
                ultraViewPager.e();
                return;
            }
            return;
        }
        UltraViewPager ultraViewPager2 = this.f16144p8;
        if (ultraViewPager2 != null) {
            ultraViewPager2.setInfiniteLoop(true);
            this.f16144p8.setAutoScroll(5000);
        }
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        r6(false);
        q6();
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        UltraViewPager ultraViewPager = this.f16144p8;
        if (ultraViewPager != null) {
            ultraViewPager.e();
        }
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        UltraViewPager ultraViewPager;
        super.f4();
        com.flydigi.userBehavior.a.a().b(X1(), "商城首页");
        if (!C3() || (ultraViewPager = this.f16144p8) == null) {
            return;
        }
        ultraViewPager.setInfiniteLoop(true);
        this.f16144p8.setAutoScroll(5000);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        this.f16146r8.m(false);
        super.i4();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.f16144p8 = (UltraViewPager) F5(R.id.ultra_view_pager);
        this.f16145q8 = (RecyclerView) F5(R.id.rv_game_list);
        this.f16146r8 = (SmartRefreshLayout) F5(R.id.smart_refresh_layout);
        this.f16152x8 = f0.i().h();
        P5(this.f16145q8);
        this.f13324k8.setOnClickListener(new View.OnClickListener() { // from class: g9.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f29086a.A6(view2);
            }
        });
        this.f13322i8.setOnClickListener(new View.OnClickListener() { // from class: g9.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f29081a.B6(view2);
            }
        });
        try {
            Field declaredField = ViewPager.class.getDeclaredField(xf.j.f55230b);
            declaredField.setAccessible(true);
            declaredField.set(this.f16144p8.getViewPager(), new p5.a(this.f16144p8.getViewPager().getContext()));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        com.flydigi.qiji.ui.mall.a aVar = new com.flydigi.qiji.ui.mall.a();
        this.f16147s8 = aVar;
        this.f16144p8.setAdapter(aVar);
        this.f16147s8.c(new a.InterfaceC0167a() { // from class: g9.i
            @Override // com.flydigi.qiji.ui.mall.a.InterfaceC0167a
            public final void a(BannerBean bannerBean) {
                this.f29088a.C6(bannerBean);
            }
        });
        this.f16148t8 = new ArrayList();
        this.f16149u8 = new MallProductAdapter(this.f13317d8, this.f16148t8);
        this.f16145q8.setFocusable(false);
        this.f16145q8.setLayoutManager(new a(X1(), 2));
        this.f16145q8.setAdapter(this.f16149u8);
        this.f16149u8.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: g9.h
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i10) {
                this.f29087a.D6(baseQuickAdapter, view2, i10);
            }
        });
        this.f16146r8.L(new sg.d() { // from class: g9.f
            @Override // sg.d
            public final void o(mg.j jVar) {
                this.f29085a.E6(jVar);
            }
        });
        this.f16146r8.x(new sg.b() { // from class: g9.e
            @Override // sg.b
            public final void g(mg.j jVar) {
                this.f29084a.F6(jVar);
            }
        });
        this.f16150v8 = 1;
    }

    public final void o6() {
        List<BannerBean> list;
        String strQ = m.k(DataConstant.SP_MAIN).q(DataConstant.SP_MAIN_RECOMMEND_DATA_BANNER);
        if (TextUtils.isEmpty(strQ) || !strQ.startsWith("[") || (list = (List) this.f16152x8.fromJson(strQ, new b().getType())) == null) {
            return;
        }
        s6(list);
    }

    public final void p6() {
        List list;
        String strQ = m.k(DataConstant.SP_MAIN).q(DataConstant.SP_MAIN_MALL_PRODUCT_LIST);
        if (TextUtils.isEmpty(strQ) || !strQ.startsWith("[") || (list = (List) this.f16152x8.fromJson(strQ, new c().getType())) == null || list.size() <= 0) {
            return;
        }
        this.f16148t8.clear();
        this.f16148t8.addAll(list);
        this.f16149u8.notifyDataSetChanged();
    }

    public final void q6() {
        ((h5.d) f0.i().k().g(h5.d.class)).h(f.f39447b).s0(c0.p()).s0(c0.t()).s0(l.d()).F5(new dj.g() { // from class: g9.n
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f29093a.t6((List) obj);
            }
        }, new dj.g() { // from class: g9.m
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f29092a.u6((Throwable) obj);
            }
        });
    }

    public final void r6(final boolean z10) {
        ((e) f0.i().k().g(e.class)).b(1, this.f16150v8, 10).Z1(new dj.g() { // from class: g9.k
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f29090a.y6((io.reactivex.disposables.b) obj);
            }
        }).s0(c0.p()).s0(c0.t()).s0(l.d()).G5(new dj.g() { // from class: g9.o
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f29094a.z6(z10, (MallProductBean) obj);
            }
        }, new dj.g() { // from class: g9.l
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f29091a.v6((Throwable) obj);
            }
        }, new dj.a() { // from class: g9.j
            @Override // dj.a
            public final void run() throws Exception {
                this.f29089a.w6();
            }
        });
    }

    public final void s6(List<BannerBean> list) {
        if (list == null) {
            return;
        }
        this.f16147s8.setData(list);
        this.f16144p8.j();
        int iB = b1.b(4.0f);
        int i10 = iB * 2;
        this.f16144p8.getIndicator().g(UltraViewPager.Orientation.HORIZONTAL).m(-1).setNormalColor(Color.parseColor("#6CFFFFFF")).e(81).k(0, 0, 0, i10).i(iB).h(i10).a();
        this.f16144p8.setInfiniteLoop(true);
        this.f16144p8.setAutoScroll(5000);
    }
}
