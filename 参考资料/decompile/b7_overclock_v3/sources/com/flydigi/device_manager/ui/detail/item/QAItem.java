package com.flydigi.device_manager.ui.detail.item;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.data.bean.DeviceDetailBean;
import com.flydigi.device_manager.R;
import ei.h;
import eu.davidea.flexibleadapter.b;
import gi.d;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class QAItem extends AbstractModelItem<DeviceDetailBean.QaListBean, a> {

    @k
    private final DeviceDetailBean.QaListBean data;

    public static final class a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final ActionItemNormal f14618g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k b<? extends h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.item_qa);
            f0.o(viewFindViewById, "view.findViewById(R.id.item_qa)");
            this.f14618g = (ActionItemNormal) viewFindViewById;
        }

        @k
        public final ActionItemNormal r() {
            return this.f14618g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QAItem(@k DeviceDetailBean.QaListBean data) {
        super(data);
        f0.p(data, "data");
        this.data = data;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@k b<h<RecyclerView.e0>> adapter, @k a holder, int i10, @l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        holder.r().setTitle(z().getName());
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k b<h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @k
    public final DeviceDetailBean.QaListBean D() {
        return this.data;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_qa;
    }
}
