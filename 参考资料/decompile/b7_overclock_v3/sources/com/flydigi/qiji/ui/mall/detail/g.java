package com.flydigi.qiji.ui.mall.detail;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.fdg.flashplay.farsef.R;
import ei.h;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends ei.c<a> {

    public static final class a extends gi.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k eu.davidea.flexibleadapter.b<? extends h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
        }
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
        return R.layout.main_item_mall_product_detail_section;
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
    }
}
