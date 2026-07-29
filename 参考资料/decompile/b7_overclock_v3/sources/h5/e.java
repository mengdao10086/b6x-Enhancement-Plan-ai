package h5;

import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.bean.MallProductBean;
import com.flydigi.data.bean.ProductDetailBean;
import nu.f;
import nu.s;
import nu.t;
import xi.z;

/* JADX INFO: loaded from: classes2.dex */
public interface e {
    @f("https://shop.flydigi.com//api/v1/product/{productId}")
    z<BaseResponse<ProductDetailBean>> a(@s("productId") int id2);

    @f("https://shop.flydigi.com//api/v1/product/by_category/paginate")
    z<BaseResponse<MallProductBean>> b(@t("id") int id2, @t("page") int page, @t("page_size") int pageSize);
}
