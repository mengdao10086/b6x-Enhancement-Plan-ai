package com.flydigi.community.ui.comment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.community.R;
import java.util.List;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ei.c<C0135a> {

    /* JADX INFO: renamed from: com.flydigi.community.ui.comment.a$a, reason: collision with other inner class name */
    public static final class C0135a extends gi.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0135a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
        }
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public C0135a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new C0135a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_comment_closed;
    }

    @Override // ei.c
    public boolean equals(@yt.l Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k C0135a holder, int i10, @yt.l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
    }
}
