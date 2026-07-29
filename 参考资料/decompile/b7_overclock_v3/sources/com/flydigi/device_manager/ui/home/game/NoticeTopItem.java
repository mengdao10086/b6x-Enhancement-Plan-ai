package com.flydigi.device_manager.ui.home.game;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.data.bean.NoticeBean;
import com.flydigi.device_manager.R;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class NoticeTopItem extends AbstractModelItem<NoticeBean.TopBean, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final TextView f15240g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.k
        public final TextView f15241h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @yt.k
        public final TextView f15242i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.tv_title);
            kotlin.jvm.internal.f0.o(viewFindViewById, "view.findViewById(R.id.tv_title)");
            this.f15240g = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.tv_content);
            kotlin.jvm.internal.f0.o(viewFindViewById2, "view.findViewById(R.id.tv_content)");
            this.f15241h = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.btn_action);
            kotlin.jvm.internal.f0.o(viewFindViewById3, "view.findViewById(R.id.btn_action)");
            this.f15242i = (TextView) viewFindViewById3;
        }

        @yt.k
        public final TextView r() {
            return this.f15242i;
        }

        @yt.k
        public final TextView s() {
            return this.f15241h;
        }

        @yt.k
        public final TextView t() {
            return this.f15240g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticeTopItem(@yt.k NoticeBean.TopBean data) {
        super(data);
        kotlin.jvm.internal.f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @yt.k List<Object> payloads) {
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        kotlin.jvm.internal.f0.p(holder, "holder");
        kotlin.jvm.internal.f0.p(payloads, "payloads");
        holder.t().setText(z().getTitle());
        holder.s().setText(z().getContent());
        kotlin.jvm.internal.f0.o(z().getButton(), "data.button");
        if (!r1.isEmpty()) {
            holder.r().setText(z().getButton().get(0).getText());
        } else {
            holder.r().setText(holder.r().getResources().getString(R.string.device_more));
        }
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
        return R.layout.device_item_my_game_zone_header_notice;
    }
}
