package com.flydigi.device_manager.ui.device_list;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class k extends ei.c<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f14851a;

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final TextView f14852g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.tv_category_name);
            f0.o(viewFindViewById, "view.findViewById(R.id.tv_category_name)");
            this.f14852g = (TextView) viewFindViewById;
        }

        @yt.k
        public final TextView r() {
            return this.f14852g;
        }
    }

    public k(@yt.k String categoryName) {
        f0.p(categoryName, "categoryName");
        this.f14851a = categoryName;
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @yt.k
    public final String B() {
        return this.f14851a;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_device_section;
    }

    @Override // ei.c
    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f0.g(k.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        f0.n(obj, "null cannot be cast to non-null type com.flydigi.device_manager.ui.device_list.DeviceSectionItem");
        return f0.g(this.f14851a, ((k) obj).f14851a);
    }

    public int hashCode() {
        return this.f14851a.hashCode();
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        holder.r().setText(this.f14851a);
    }
}
