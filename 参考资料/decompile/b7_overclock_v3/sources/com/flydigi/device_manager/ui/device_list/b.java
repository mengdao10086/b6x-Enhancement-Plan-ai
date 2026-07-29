package com.flydigi.device_manager.ui.device_list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.b1;
import com.flydigi.device_manager.R;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends ei.c<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f14841a;

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final TextView f14842g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.tv_category_name);
            f0.o(viewFindViewById, "view.findViewById(R.id.tv_category_name)");
            this.f14842g = (TextView) viewFindViewById;
        }

        @yt.k
        public final TextView r() {
            return this.f14842g;
        }
    }

    public b(@yt.k String categoryName) {
        f0.p(categoryName, "categoryName");
        this.f14841a = categoryName;
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
        return this.f14841a;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_device_group_header;
    }

    @Override // ei.c
    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f0.g(b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        f0.n(obj, "null cannot be cast to non-null type com.flydigi.device_manager.ui.device_list.DeviceCategoryItem");
        return f0.g(this.f14841a, ((b) obj).f14841a);
    }

    public int hashCode() {
        return this.f14841a.hashCode();
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        holder.r().setText(this.f14841a);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        f0.n(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i10 != 0 ? b1.b(48.0f) : 0;
        ViewGroup.LayoutParams layoutParams2 = holder.itemView.getLayoutParams();
        f0.n(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = b1.b(8.0f);
    }
}
