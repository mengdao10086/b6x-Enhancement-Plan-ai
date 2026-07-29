package com.flydigi.device_manager.ui.sync;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c7.r1;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.R;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class GameItem extends AbstractModelItem<LocalGameBean, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final r1 f15391g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(adapter, "adapter");
            r1 r1VarA = r1.a(view);
            kotlin.jvm.internal.f0.o(r1VarA, "bind(view)");
            this.f15391g = r1VarA;
        }

        @Override // gi.d
        public void q() {
            super.q();
            View view = this.f15391g.f10400d;
            kotlin.jvm.internal.f0.o(view, "binding.viewCover");
            o5.c.b(view, Boolean.valueOf(!this.f29556c.B(getAdapterPosition())), false, 2, null);
        }

        @yt.k
        public final r1 r() {
            return this.f15391g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameItem(@yt.k LocalGameBean data) {
        super(data);
        kotlin.jvm.internal.f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @yt.k List<Object> payloads) {
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        kotlin.jvm.internal.f0.p(holder, "holder");
        kotlin.jvm.internal.f0.p(payloads, "payloads");
        holder.r().f10398b.setImageDrawable(com.blankj.utilcode.util.d.e(z().localPackageName));
        holder.r().f10399c.setText(z().name);
        View view = holder.r().f10400d;
        kotlin.jvm.internal.f0.o(view, "holder.binding.viewCover");
        o5.c.b(view, Boolean.valueOf(!adapter.B(i10)), false, 2, null);
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        kotlin.jvm.internal.f0.p(view, "view");
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_config_sync_game;
    }
}
