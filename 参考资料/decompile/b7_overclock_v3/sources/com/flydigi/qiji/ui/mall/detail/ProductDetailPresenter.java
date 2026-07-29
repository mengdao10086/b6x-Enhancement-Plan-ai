package com.flydigi.qiji.ui.mall.detail;

import com.flydigi.data.bean.ProductDetailBean;
import com.flydigi.qiji.ui.mall.detail.b;
import ik.l;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class ProductDetailPresenter implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final b.InterfaceC0169b f16162a;

    public ProductDetailPresenter(@k b.InterfaceC0169b mView) {
        f0.p(mView, "mView");
        this.f16162a = mView;
    }

    public static final void e(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void f(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.qiji.ui.mall.detail.b.a
    public void a(int i10) {
        z zVarS0 = ((h5.e) m5.f0.i().k().g(h5.e.class)).a(i10).s0(c0.p()).s0(c0.t()).s0(o5.l.d());
        final l<ProductDetailBean, z1> lVar = new l<ProductDetailBean, z1>() { // from class: com.flydigi.qiji.ui.mall.detail.ProductDetailPresenter$getProductDetail$1
            {
                super(1);
            }

            public final void b(ProductDetailBean it2) {
                b.InterfaceC0169b interfaceC0169b = this.this$0.f16162a;
                f0.o(it2, "it");
                interfaceC0169b.o(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ProductDetailBean productDetailBean) {
                b(productDetailBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.qiji.ui.mall.detail.e
            @Override // dj.g
            public final void accept(Object obj) {
                ProductDetailPresenter.e(lVar, obj);
            }
        };
        final ProductDetailPresenter$getProductDetail$2 productDetailPresenter$getProductDetail$2 = new l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.mall.detail.ProductDetailPresenter$getProductDetail$2
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.mall.detail.d
            @Override // dj.g
            public final void accept(Object obj) {
                ProductDetailPresenter.f(productDetailPresenter$getProductDetail$2, obj);
            }
        });
    }
}
