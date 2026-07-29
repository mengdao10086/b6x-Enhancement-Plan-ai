package com.flydigi.community.ui.article_list;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.ContentAddBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import y5.a0;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageItem extends AbstractModelItem<ContentAddBean, a> {

    @yt.l
    private final Integer addonCount;

    @yt.k
    private final List<ContentAddBean> allData;
    private final boolean empty;

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final a0 f13814g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            a0 a0VarA = a0.a(view);
            f0.o(a0VarA, "bind(view)");
            this.f13814g = a0VarA;
        }

        @yt.k
        public final a0 r() {
            return this.f13814g;
        }
    }

    public /* synthetic */ ImageItem(List list, ContentAddBean contentAddBean, boolean z10, Integer num, int i10, u uVar) {
        this((i10 & 1) != 0 ? new ArrayList() : list, contentAddBean, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? 0 : num);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @yt.l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        if (this.empty) {
            ImageView imageView = holder.r().f56257c;
            f0.o(imageView, "holder.viewBinding.ivImage");
            o5.c.b(imageView, Boolean.FALSE, false, 2, null);
            return;
        }
        ImageView imageView2 = holder.r().f56257c;
        f0.o(imageView2, "holder.viewBinding.ivImage");
        o5.c.b(imageView2, Boolean.TRUE, false, 2, null);
        com.bumptech.glide.h<Drawable> hVarT = com.bumptech.glide.b.F(holder.itemView).t(z().url);
        int i11 = R.drawable.pic_banner_place_holder;
        hVarT.E0(i11).x(i11).c().s1(holder.r().f56257c);
        TextView textView = holder.r().f56258d;
        Integer num = this.addonCount;
        textView.setVisibility(num != null && f0.t(num.intValue(), 0) == 1 ? 0 : 8);
        TextView textView2 = holder.r().f56258d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('+');
        sb2.append(this.addonCount);
        textView2.setText(sb2.toString());
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @yt.k
    public final List<ContentAddBean> D() {
        return this.allData;
    }

    public final boolean E() {
        return this.empty;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_image;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageItem(@yt.k List<? extends ContentAddBean> allData, @yt.k ContentAddBean data, boolean z10, @yt.l Integer num) {
        super(data);
        f0.p(allData, "allData");
        f0.p(data, "data");
        this.allData = allData;
        this.empty = z10;
        this.addonCount = num;
    }
}
