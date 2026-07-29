package com.flydigi.device_manager.ui.device_list;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends ei.c<C0155a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f14838a;

    /* JADX INFO: renamed from: com.flydigi.device_manager.ui.device_list.a$a, reason: collision with other inner class name */
    public static final class C0155a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final TextView f14839g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.k
        public final View f14840h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0155a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            View viewFindViewById = view.findViewById(R.id.tv_category_name);
            f0.o(viewFindViewById, "view.findViewById(R.id.tv_category_name)");
            this.f14839g = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.iv_flag);
            f0.o(viewFindViewById2, "view.findViewById(R.id.iv_flag)");
            this.f14840h = viewFindViewById2;
        }

        @Override // gi.d
        public void q() {
            super.q();
            boolean zB = this.f29556c.B(getAdapterPosition());
            this.itemView.setActivated(zB);
            this.f14840h.setVisibility(zB ? 0 : 8);
            this.f14839g.setTypeface(null, zB ? 1 : 0);
            TextView textView = this.f14839g;
            textView.setTextColor(textView.getResources().getColor(zB ? R.color.color_000000_a90 : R.color.color_000000_a50));
            this.f14839g.setTextSize(0, r1.getResources().getDimensionPixelSize(zB ? R.dimen.sp_14 : R.dimen.sp_12));
        }

        @yt.k
        public final View r() {
            return this.f14840h;
        }

        @yt.k
        public final TextView s() {
            return this.f14839g;
        }
    }

    public a(@yt.k String categoryName) {
        f0.p(categoryName, "categoryName");
        this.f14838a = categoryName;
    }

    @Override // ei.c, ei.h
    @yt.k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public C0155a i(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new C0155a(view, adapter);
    }

    @yt.k
    public final String B() {
        return this.f14838a;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_device_category;
    }

    @Override // ei.c
    public boolean equals(@l Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return this.f14838a.hashCode();
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k C0155a holder, int i10, @l List<Object> list) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        holder.s().setText(this.f14838a);
        holder.s().setTypeface(null, adapter.B(i10) ? 1 : 0);
        holder.s().setTextSize(0, holder.s().getResources().getDimensionPixelSize(adapter.B(i10) ? R.dimen.sp_14 : R.dimen.sp_12));
        holder.s().setTextColor(holder.s().getResources().getColor(adapter.B(i10) ? R.color.color_000000_a90 : R.color.color_000000_a50));
        holder.r().setVisibility(adapter.B(i10) ? 0 : 8);
    }
}
