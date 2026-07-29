package com.flydigi.community.ui.post;

import android.view.View;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.community.TopicBean;
import java.util.List;
import y5.i0;

/* JADX INFO: loaded from: classes2.dex */
public final class TopicItem extends AbstractModelItem<TopicBean, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final i0 f14003g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(adapter, "adapter");
            i0 i0VarA = i0.a(view);
            kotlin.jvm.internal.f0.o(i0VarA, "bind(view)");
            this.f14003g = i0VarA;
        }

        @yt.k
        public final i0 r() {
            return this.f14003g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicItem(@yt.k TopicBean data) {
        super(data);
        kotlin.jvm.internal.f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<?>> adapter, @yt.k a holder, int i10, @yt.k List<? extends Object> payloads) {
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        kotlin.jvm.internal.f0.p(holder, "holder");
        kotlin.jvm.internal.f0.p(payloads, "payloads");
        holder.r().f56357c.setText(z().getTitle());
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<?>> adapter) {
        kotlin.jvm.internal.f0.p(view, "view");
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_tag_topic;
    }
}
