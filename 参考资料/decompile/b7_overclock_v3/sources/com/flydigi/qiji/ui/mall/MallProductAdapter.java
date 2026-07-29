package com.flydigi.qiji.ui.mall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import c4.c;
import com.blankj.utilcode.util.b1;
import com.bumptech.glide.b;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.request.h;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fdg.flashplay.farsef.R;
import com.flydigi.data.bean.MallProductBean;
import g.p0;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public class MallProductAdapter extends BaseQuickAdapter<MallProductBean.DataBean, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16155a;

    public MallProductAdapter(Context context, @p0 List<MallProductBean.DataBean> list) {
        super(R.layout.main_item_mall_product, list);
        this.f16155a = context;
        setHeaderView(LayoutInflater.from(context).inflate(R.layout.main_item_mall_product_header, (ViewGroup) null, false));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void convert(@k BaseViewHolder baseViewHolder, MallProductBean.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_product, dataBean.getName());
        b.E(this.f16155a).t(dataBean.getListImgUrl()).a(h.a1(new c(new l(), new RoundedCornersTransformation(b1.b(13.0f), 0, RoundedCornersTransformation.CornerType.TOP)))).s1((ImageView) baseViewHolder.getView(R.id.iv_product));
    }
}
