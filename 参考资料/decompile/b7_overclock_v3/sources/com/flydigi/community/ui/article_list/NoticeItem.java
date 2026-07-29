package com.flydigi.community.ui.article_list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.community.R;
import com.flydigi.data.bean.community.NoticeBean;
import java.util.List;
import kotlin.jvm.internal.f0;
import y5.q;

/* JADX INFO: loaded from: classes2.dex */
public final class NoticeItem extends AbstractModelItem<List<? extends NoticeBean>, a> {

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final q f13815g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            q qVarA = q.a(view);
            f0.o(qVarA, "bind(view)");
            this.f13815g = qVarA;
        }

        @yt.k
        public final q r() {
            return this.f13815g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticeItem(@yt.k List<NoticeBean> data) {
        super(data);
        f0.p(data, "data");
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @yt.k List<Object> payloads) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        holder.r().f56419c.setText(z().get(0).getTag());
        holder.r().f56420d.setText(z().get(0).getTitle());
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_article_notice;
    }
}
