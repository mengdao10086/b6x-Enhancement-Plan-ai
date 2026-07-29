package com.flydigi.device_manager.ui.home.game;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends ei.c<a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final View f15275g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.btn_config_manage);
            kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(R.id.btn_config_manage)");
            this.f15275g = viewFindViewById;
            viewFindViewById.setOnClickListener(this);
        }
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        kotlin.jvm.internal.f0.p(view, "view");
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_my_game_zone_header;
    }

    @Override // ei.c
    public boolean equals(@yt.l Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @yt.l List<Object> list) {
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        kotlin.jvm.internal.f0.p(holder, "holder");
    }
}
