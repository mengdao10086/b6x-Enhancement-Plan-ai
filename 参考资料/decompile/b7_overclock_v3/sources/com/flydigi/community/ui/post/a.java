package com.flydigi.community.ui.post;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.community.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ei.c<C0144a> {

    /* JADX INFO: renamed from: com.flydigi.community.ui.post.a$a, reason: collision with other inner class name */
    public static final class C0144a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final y5.o f14004g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0144a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<?> adapter) {
            super(view, adapter);
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(adapter, "adapter");
            y5.o oVarA = y5.o.a(view);
            kotlin.jvm.internal.f0.o(oVarA, "bind(view)");
            this.f14004g = oVarA;
            oVarA.f56395b.setOnClickListener(this);
        }
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public C0144a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        kotlin.jvm.internal.f0.p(view, "view");
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        return new C0144a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_add_media;
    }

    @Override // ei.c
    public boolean equals(@yt.l Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k C0144a holder, int i10, @yt.k List<Object> payloads) {
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        kotlin.jvm.internal.f0.p(holder, "holder");
        kotlin.jvm.internal.f0.p(payloads, "payloads");
    }
}
