package com.flydigi.device_manager.ui.sync;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import c7.s1;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.data.bean.EntitySimpleConfig;
import com.flydigi.device_manager.R;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@kotlin.jvm.internal.t0({"SMAP\nLocalConfigItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalConfigItem.kt\ncom/flydigi/device_manager/ui/sync/LocalConfigItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
public final class LocalConfigItem extends AbstractModelItem<EntitySimpleConfig, a> {
    private final boolean shareMode;

    public static final class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final s1 f15392g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k View view, @yt.k eu.davidea.flexibleadapter.b<? extends ei.h<RecyclerView.e0>> adapter) {
            super(view, adapter);
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(adapter, "adapter");
            s1 s1VarA = s1.a(view);
            kotlin.jvm.internal.f0.o(s1VarA, "bind(view)");
            this.f15392g = s1VarA;
            s1VarA.f10452g.setOnClickListener(this);
            s1VarA.f10453h.setOnClickListener(this);
            s1VarA.f10450e.setOnClickListener(this);
            s1VarA.f10447b.setOnClickListener(this);
            s1VarA.f10448c.setOnClickListener(this);
        }

        @Override // gi.d
        public void q() {
            super.q();
            boolean zB = this.f29556c.B(getAdapterPosition());
            this.itemView.setActivated(zB);
            this.f15392g.f10447b.setImageResource(zB ? R.drawable.ic_check_yes : R.drawable.ic_check_no);
        }

        @yt.k
        public final s1 r() {
            return this.f15392g;
        }
    }

    public /* synthetic */ LocalConfigItem(EntitySimpleConfig entitySimpleConfig, boolean z10, int i10, kotlin.jvm.internal.u uVar) {
        this(entitySimpleConfig, (i10 & 2) != 0 ? false : z10);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@yt.k eu.davidea.flexibleadapter.b<ei.h<RecyclerView.e0>> adapter, @yt.k a holder, int i10, @yt.k List<Object> payloads) {
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        kotlin.jvm.internal.f0.p(holder, "holder");
        kotlin.jvm.internal.f0.p(payloads, "payloads");
        holder.r().f10455j.setText(z().getName());
        int version = z().getVersion();
        holder.r().f10451f.setImageResource(version != 1 ? version != 2 ? version != 3 ? R.drawable.main_ic_device_game_pad_gray : R.drawable.main_ic_device_game_pad_half_gray : R.drawable.main_ic_device_keyboard_mouse_gray : R.drawable.main_ic_device_game_pad_gray);
        holder.r().f10453h.setImageResource(R.drawable.main_ic_upload_white);
        v(adapter.t() == 2);
        ImageView imageView = holder.r().f10447b;
        kotlin.jvm.internal.f0.o(imageView, "holder.binding.cbSelect");
        o5.c.b(imageView, Boolean.valueOf(adapter.t() == 2), false, 2, null);
        holder.r().f10449d.setCanLeftSwipe((this.shareMode || adapter.t() == 2) ? false : true);
        holder.r().f10449d.setCanRightSwipe((this.shareMode || adapter.t() == 2) ? false : true);
        holder.r().f10449d.g();
        holder.r().f10447b.setImageResource(adapter.B(i10) ? R.drawable.ic_check_yes : R.drawable.ic_check_no);
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
        return R.layout.device_item_config_sync_game_config;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalConfigItem(@yt.k EntitySimpleConfig data, boolean z10) {
        super(data);
        kotlin.jvm.internal.f0.p(data, "data");
        this.shareMode = z10;
        v(z10);
    }
}
