package com.flydigi.device_manager.ui.driver_active.permission;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import c7.k1;
import com.flydigi.device_manager.R;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends s<j, a> {

    public static final class a extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final k1 f14917a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View itemView) {
            super(itemView);
            f0.p(itemView, "itemView");
            k1 k1VarA = k1.a(itemView);
            f0.o(k1VarA, "bind(itemView)");
            this.f14917a = k1VarA;
        }

        @yt.k
        public final k1 h() {
            return this.f14917a;
        }
    }

    public i() {
        super(new k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@yt.k a holder, int i10) {
        f0.p(holder, "holder");
        holder.h().f10173d.setText(getItem(i10).h());
        holder.h().f10172c.setText(y0.c.a(getItem(i10).f(), 63));
        com.bumptech.glide.b.F(holder.h().f10171b).p(Integer.valueOf(getItem(i10).g())).s1(holder.h().f10171b);
        TextView textView = holder.h().f10173d;
        f0.o(textView, "holder.viewBinding.tvTitle");
        o5.c.b(textView, Boolean.valueOf(holder.h().f10173d.length() != 0), false, 2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @yt.k
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@yt.k ViewGroup parent, int i10) {
        f0.p(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_fragment_permission_instruction_item, parent, false);
        f0.o(viewInflate, "from(parent.context)\n   …tion_item, parent, false)");
        return new a(viewInflate);
    }
}
