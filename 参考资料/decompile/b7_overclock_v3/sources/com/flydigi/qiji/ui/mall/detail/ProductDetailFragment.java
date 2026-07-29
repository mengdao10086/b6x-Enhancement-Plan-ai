package com.flydigi.qiji.ui.mall.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import b9.m;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.o;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ProductDetailBean;
import com.flydigi.qiji.ui.mall.detail.b;
import i9.a;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import u9.h;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class ProductDetailFragment extends FZRecyclerViewFragment implements b.InterfaceC0169b {

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @k
    public static final a f16158y8 = new a(null);

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public int f16159v8 = -1;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public ProductDetailPresenter f16160w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public m f16161x8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @k
        public final ProductDetailFragment a(int i10) {
            ProductDetailFragment productDetailFragment = new ProductDetailFragment();
            productDetailFragment.c5(androidx.core.os.e.b(new Pair(a.f.f31978g, Integer.valueOf(i10))));
            return productDetailFragment;
        }
    }

    @hk.m
    @k
    public static final ProductDetailFragment k6(int i10) {
        return f16158y8.a(i10);
    }

    public static final void l6(ProductDetailFragment this$0, ProductDetailBean productDetail, View view) {
        f0.p(this$0, "this$0");
        f0.p(productDetail, "$productDetail");
        h.s(this$0.X1(), productDetail.getName());
        if (!o5.f.a(j1.a(), "com.taobao.taobao")) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, productDetail.getTbLink()).navigation();
            return;
        }
        Intent launchIntentForPackage = j1.a().getPackageManager().getLaunchIntentForPackage("com.taobao.taobao");
        if (launchIntentForPackage == null) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, productDetail.getTbLink()).navigation();
            return;
        }
        launchIntentForPackage.setAction("android.intent.action.VIEW");
        launchIntentForPackage.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
        launchIntentForPackage.setData(Uri.parse(productDetail.getTbLink()));
        if (com.blankj.utilcode.util.a.O0(launchIntentForPackage)) {
            return;
        }
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, productDetail.getTbLink()).navigation();
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        androidx.fragment.app.g gVarW1;
        super.K3(bundle);
        Bundle bundleT1 = T1();
        int i10 = bundleT1 != null ? bundleT1.getInt(a.f.f31978g) : -1;
        this.f16159v8 = i10;
        if (i10 == -1 && (gVarW1 = w1()) != null) {
            gVarW1.finish();
        }
        this.f16160w8 = new ProductDetailPresenter(this);
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_fragment_mall_product_detail;
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@l View view, int i10) {
        return false;
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    public int c6() {
        return Integer.MAX_VALUE;
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        m mVarA = m.a(view);
        f0.o(mVarA, "bind(view)");
        this.f16161x8 = mVarA;
    }

    @Override // com.flydigi.qiji.ui.mall.detail.b.InterfaceC0169b
    public void o(@k final ProductDetailBean productDetail) {
        f0.p(productDetail, "productDetail");
        h.r(X1(), productDetail.getName());
        m mVar = this.f16161x8;
        m mVar2 = null;
        if (mVar == null) {
            f0.S("viewBinding");
            mVar = null;
        }
        mVar.f9223f.setText(productDetail.getPrice().toString());
        eu.davidea.flexibleadapter.b bVar = this.f13331r8;
        String name = productDetail.getName();
        f0.o(name, "productDetail.name");
        String price = productDetail.getPrice();
        f0.o(price, "productDetail.price");
        String mainImgUrl = productDetail.getMainImgUrl();
        f0.o(mainImgUrl, "productDetail.mainImgUrl");
        bVar.K0(new f(name, price, mainImgUrl));
        this.f13331r8.K0(new g());
        for (ProductDetailBean.ImgsBean imgsBean : productDetail.getImgs()) {
            eu.davidea.flexibleadapter.b bVar2 = this.f13331r8;
            String url = imgsBean.getImgUrl().getUrl();
            f0.o(url, "item.imgUrl.url");
            bVar2.K0(new com.flydigi.qiji.ui.mall.detail.a(url));
        }
        m mVar3 = this.f16161x8;
        if (mVar3 == null) {
            f0.S("viewBinding");
        } else {
            mVar2 = mVar3;
        }
        o.r(mVar2.f9220c, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.mall.detail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductDetailFragment.l6(this.f16167a, productDetail, view);
            }
        });
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
        ProductDetailPresenter productDetailPresenter = this.f16160w8;
        if (productDetailPresenter == null) {
            f0.S("mPresenter");
            productDetailPresenter = null;
        }
        productDetailPresenter.a(this.f16159v8);
    }
}
