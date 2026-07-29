package com.flydigi.community.ui.search.result;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import c6.d;
import com.blankj.utilcode.util.b1;
import com.blankj.utilcode.util.d1;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.net.ApiException;
import com.flydigi.base.widget.recyclerview.adapter.MessageItem;
import com.flydigi.community.R;
import com.flydigi.community.ui.article_list.ArticleItem;
import com.flydigi.community.ui.search.DeviceCategoryBean;
import com.flydigi.community.ui.search.result.ResultFragment;
import com.flydigi.community.ui.search.result.a;
import com.flydigi.community.ui.search.result.b;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.community.ArticleBean;
import dj.g;
import dj.o;
import ei.h;
import eu.davidea.flexibleadapter.b;
import g.n0;
import g.p0;
import i9.a;
import java.util.ArrayList;
import java.util.List;
import o5.l;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public class ResultFragment extends FZFragment implements b.InterfaceC0148b, b.z, b.s, View.OnClickListener {
    public static final String F8 = "type";
    public static final String G8 = "category_id";
    public static final String H8 = "keyword";
    public static final String I8 = "device_categories";
    public static final int J8 = 20;
    public eu.davidea.flexibleadapter.b A8;
    public t5.b B8;
    public b.a C8;
    public ArrayList<DeviceCategoryBean> D8;
    public String E8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public int f14067o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public int f14068p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f14069q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public boolean f14070r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public TextView f14071s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public View f14072t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public TextView f14073u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public View f14074v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public TextView f14075w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public View f14076x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public TextView f14077y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public RecyclerView f14078z8;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e6(PopupWindow popupWindow, int i10) {
        popupWindow.dismiss();
        this.f14068p8 = this.D8.get(i10).b();
        k6();
        l6();
    }

    public static /* synthetic */ ArticleItem f6(ArticleBean articleBean) throws Exception {
        return new ArticleItem(articleBean, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g6() {
        this.f14078z8.D1(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h6(int i10, ArrayList arrayList, List list) throws Exception {
        if (i10 == 0) {
            this.f14069q8 = false;
            this.A8.I4(list);
            return;
        }
        if (i10 != 1) {
            this.A8.r3(list);
            return;
        }
        this.f14069q8 = true;
        this.f14078z8.setPadding(0, b1.b(20.0f), 0, 0);
        this.A8.B3();
        if (arrayList.size() % 20 == 0) {
            this.A8.e4(this, this.B8);
        } else {
            J(arrayList.size());
        }
        this.A8.I4(list);
        this.f14078z8.postDelayed(new Runnable() { // from class: c6.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f9771a.g6();
            }
        }, 250L);
    }

    public static /* synthetic */ void i6(Throwable th2) throws Exception {
    }

    public static ResultFragment j6(int i10, int i11, String str, ArrayList<DeviceCategoryBean> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i10);
        bundle.putInt(G8, i11);
        bundle.putString(H8, str);
        bundle.putParcelableArrayList(I8, arrayList);
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.c5(bundle);
        return resultFragment;
    }

    @Override // com.flydigi.community.ui.search.result.b.InterfaceC0148b
    public void A1(final int i10, final ArrayList<ArticleBean> arrayList) {
        this.f13323j8.setVisibility(8);
        this.f14078z8.setVisibility(0);
        this.f14070r8 = false;
        if (i10 == 1 && arrayList.isEmpty()) {
            this.A8.m1();
            x(c3(R.string.community_action_search), false);
            this.C8.o();
            return;
        }
        if (i10 == 0) {
            E0();
            this.A8.m1();
            this.f14078z8.setPadding(0, 0, 0, 0);
            if (!arrayList.isEmpty()) {
                this.A8.S0(new d());
            }
            this.A8.S0(new c6.c());
        }
        z.P2(arrayList).A3(new o() { // from class: c6.h
            @Override // dj.o
            public final Object apply(Object obj) {
                return ResultFragment.f6((ArticleBean) obj);
            }
        }).Y6().v1().s0(l.d()).F5(new g() { // from class: c6.f
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f9766a.h6(i10, arrayList, (List) obj);
            }
        }, new g() { // from class: c6.g
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                ResultFragment.i6((Throwable) obj);
            }
        });
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void J(int i10) {
        this.A8.A3();
        if (this.A8.i2(Integer.valueOf(R.layout.base_item_message_state)) > 0) {
            return;
        }
        this.A8.Q0(new t5.a(c3(R.string.base_no_more_data)));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (T1() != null) {
            this.f14067o8 = T1().getInt("type", -1);
            this.f14068p8 = T1().getInt(G8);
            this.D8 = T1().getParcelableArrayList(I8);
        }
        this.C8 = new c(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.community_fragment_search_result;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(View view, int i10) {
        h hVarG2 = this.A8.g2(i10);
        if (hVarG2 instanceof ArticleItem) {
            ArticleBean articleBeanZ = ((ArticleItem) hVarG2).z();
            u9.h.j(w1(), "搜索-点击帖子", this.E8, "");
            h3.a.j().d(a.b.f31919d).withInt("id", articleBeanZ.getId()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, this.f14069q8 ? ArticleReadLog.f13290h : ArticleReadLog.f13283a).navigation();
            return false;
        }
        if (!(hVarG2 instanceof MessageItem)) {
            return false;
        }
        m6(this.E8, 1);
        return false;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void U3(boolean z10) {
        super.U3(z10);
        if (z10) {
            return;
        }
        com.flydigi.userBehavior.a.a().b(X1(), "社区_搜索结果页_" + this.E8);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k @n0 View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        if (d1.a("AndroidAlpha", "AndroidAbroad")) {
            F5(R.id.area_filter).setVisibility(8);
        }
        this.f14071s8 = (TextView) F5(R.id.tv_type_all);
        this.f14072t8 = F5(R.id.tv_type_all_indicator);
        this.f14073u8 = (TextView) F5(R.id.tv_type_raider);
        this.f14074v8 = F5(R.id.tv_type_raider_indicator);
        this.f14075w8 = (TextView) F5(R.id.tv_type_config);
        this.f14076x8 = F5(R.id.tv_type_config_indicator);
        this.f14077y8 = (TextView) F5(R.id.tv_handle_category);
        ((View) this.f14071s8.getParent()).setOnClickListener(this);
        ((View) this.f14073u8.getParent()).setOnClickListener(this);
        ((View) this.f14075w8.getParent()).setOnClickListener(this);
        ((View) this.f14077y8.getParent()).setOnClickListener(this);
        k6();
        this.f14078z8 = (RecyclerView) F5(R.id.recycler_view);
        this.B8 = new t5.b();
        j jVar = new j(X1(), 1);
        jVar.l(h0.d.i(X1(), R.drawable.shape_divider_list_item));
        this.f14078z8.n(jVar);
        eu.davidea.flexibleadapter.b bVar = new eu.davidea.flexibleadapter.b(null, this, true);
        this.A8 = bVar;
        bVar.c4(20);
        this.f14078z8.setAdapter(this.A8);
        FrameLayout frameLayout = (FrameLayout) this.f14078z8.getParent();
        View viewInflate = w2().inflate(R.layout.base_layout_view_placeholder_loading, (ViewGroup) frameLayout, false);
        this.f13323j8 = viewInflate;
        frameLayout.addView(viewInflate);
    }

    public final void k6() {
        this.f14071s8.setSelected(this.f14067o8 == -1);
        this.f14072t8.setVisibility(this.f14067o8 == -1 ? 0 : 8);
        this.f14073u8.setSelected(this.f14067o8 == 0);
        this.f14074v8.setVisibility(this.f14067o8 == 0 ? 0 : 8);
        this.f14075w8.setSelected(this.f14067o8 == 2);
        this.f14076x8.setVisibility(this.f14067o8 != 2 ? 8 : 0);
        for (DeviceCategoryBean deviceCategoryBean : this.D8) {
            if (this.f14068p8 == deviceCategoryBean.b()) {
                this.f14077y8.setText(deviceCategoryBean.a());
                return;
            }
        }
    }

    public final void l6() {
        m6(this.E8, 1);
    }

    @Override // com.flydigi.community.ui.search.result.b.InterfaceC0148b
    public void m(Throwable th2) {
        this.f13323j8.setVisibility(8);
        this.f14078z8.setVisibility(0);
        if (this.f14070r8) {
            if (th2 instanceof ApiException) {
                com.flydigi.base.common.o.E(c3(((ApiException) th2).a() == -101 ? R.string.net_state_error : R.string.api_error_notice));
            } else {
                com.flydigi.base.common.o.E(c3(R.string.api_error_notice));
            }
            this.A8.r3(null);
        } else {
            this.A8.m1();
            if (th2 instanceof ApiException) {
                this.A8.K0(new MessageItem(c3(((ApiException) th2).a() == -101 ? R.string.net_state_error : R.string.api_error_notice)));
            } else {
                this.A8.K0(new MessageItem(c3(R.string.api_error_notice)));
            }
        }
        this.f14070r8 = false;
    }

    public void m6(String str, int i10) {
        if (com.blankj.utilcode.util.n0.m(str.trim())) {
            com.flydigi.base.common.o.E(c3(R.string.community_warning_empty_search_keyword));
        } else {
            this.E8 = str;
            this.C8.e(this.f14067o8, this.f14068p8, str, i10, 20);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.btn_type_all) {
            this.f14067o8 = -1;
            k6();
            l6();
            return;
        }
        if (id2 == R.id.btn_type_raider) {
            this.f14067o8 = 0;
            k6();
            l6();
        } else if (id2 == R.id.btn_type_config) {
            this.f14067o8 = 2;
            k6();
            l6();
        } else if (id2 == R.id.btn_handle_category) {
            a aVar = new a(X1(), this.D8);
            aVar.f(new a.b() { // from class: c6.e
                @Override // com.flydigi.community.ui.search.result.a.b
                public final void a(PopupWindow popupWindow, int i10) {
                    this.f9765a.e6(popupWindow, i10);
                }
            });
            aVar.showAsDropDown(this.f14077y8, -36, 0);
        }
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        this.f14070r8 = true;
        m6(this.E8, i11 + 1);
    }
}
