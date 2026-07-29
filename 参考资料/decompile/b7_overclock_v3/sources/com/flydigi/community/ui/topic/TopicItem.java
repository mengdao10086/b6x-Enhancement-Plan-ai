package com.flydigi.community.ui.topic;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.community.TopicBean;
import ei.h;
import java.util.List;
import kotlin.jvm.internal.f0;
import y5.j0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class TopicItem extends AbstractModelItem<TopicBean, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final j0 f14084g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            j0 j0VarA = j0.a(view);
            f0.o(j0VarA, "bind(view)");
            this.f14084g = j0VarA;
        }

        @k
        public final j0 r() {
            return this.f14084g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicItem(@k TopicBean data) {
        super(data);
        f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@k eu.davidea.flexibleadapter.b<h<?>> adapter, @k a holder, int i10, @k List<? extends Object> payloads) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        com.bumptech.glide.h<Drawable> hVarT = com.bumptech.glide.b.F(holder.r().f56363b).t(z().getIconImage());
        int i11 = R.drawable.community_pic_default_category;
        hVarT.E0(i11).x(i11).s1(holder.r().f56363b);
        holder.r().f56364c.setText('#' + z().getTitle());
        holder.r().f56365d.setVisibility(z().getCount() <= 0 ? 8 : 0);
        holder.r().f56365d.setText(holder.r().f56365d.getResources().getString(R.string.community_count_of_topic, Integer.valueOf(z().getCount())));
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k eu.davidea.flexibleadapter.b<h<?>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_topic;
    }
}
