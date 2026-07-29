package com.flydigi.qiji.ui.mall.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.fdg.flashplay.farsef.R;
import ei.h;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends ei.c<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final String f16171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final String f16172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final String f16173c;

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final ImageView f16174g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @k
        public final TextView f16175h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @k
        public final TextView f16176i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<? extends h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.iv_product);
            f0.o(viewFindViewById, "view.findViewById(R.id.iv_product)");
            this.f16174g = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.tv_product);
            f0.o(viewFindViewById2, "view.findViewById(R.id.tv_product)");
            this.f16175h = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.tv_price);
            f0.o(viewFindViewById3, "view.findViewById(R.id.tv_price)");
            this.f16176i = (TextView) viewFindViewById3;
        }

        @k
        public final ImageView r() {
            return this.f16174g;
        }

        @k
        public final TextView s() {
            return this.f16175h;
        }

        @k
        public final TextView t() {
            return this.f16176i;
        }
    }

    public f(@k String name, @k String price, @k String cover) {
        f0.p(name, "name");
        f0.p(price, "price");
        f0.p(cover, "cover");
        this.f16171a = name;
        this.f16172b = price;
        this.f16173c = cover;
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k eu.davidea.flexibleadapter.b<h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.main_item_mall_product_detail_header;
    }

    @Override // ei.c
    public boolean equals(@l Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@k eu.davidea.flexibleadapter.b<h<RecyclerView.e0>> adapter, @k a holder, int i10, @l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        holder.s().setText(this.f16171a);
        holder.t().setText(this.f16172b);
        com.bumptech.glide.b.F(holder.r()).t(this.f16173c).s1(holder.r());
    }
}
