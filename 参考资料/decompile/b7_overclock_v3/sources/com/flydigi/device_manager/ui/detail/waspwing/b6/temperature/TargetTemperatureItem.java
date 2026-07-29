package com.flydigi.device_manager.ui.detail.waspwing.b6.temperature;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c7.m2;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.device_manager.R;
import ei.h;
import eu.davidea.flexibleadapter.b;
import gi.d;
import java.util.List;
import kotlin.jvm.internal.f0;
import o5.c;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class TargetTemperatureItem extends AbstractModelItem<Integer, a> {
    private final boolean forOverclock;
    private final boolean overclockAble;

    public static final class a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final m2 f14703g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k b<? extends h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            m2 m2VarA = m2.a(view);
            f0.o(m2VarA, "bind(view)");
            this.f14703g = m2VarA;
        }

        @Override // gi.d
        public void q() {
            super.q();
            ImageView imageView = this.f14703g.f10235b;
            f0.o(imageView, "viewBinding.ivCheckbox");
            c.a(imageView, Boolean.valueOf(this.f29556c.B(i())), false);
        }

        @k
        public final m2 r() {
            return this.f14703g;
        }
    }

    public TargetTemperatureItem(int i10, boolean z10, boolean z11) {
        super(Integer.valueOf(i10));
        this.forOverclock = z10;
        this.overclockAble = z11;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(@k b<h<RecyclerView.e0>> adapter, @k a holder, int i10, @k List<Object> payloads) {
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        holder.r().f10237d.setText(z() + " ℃");
        ImageView imageView = holder.r().f10235b;
        f0.o(imageView, "holder.viewBinding.ivCheckbox");
        c.a(imageView, Boolean.valueOf(adapter.v().contains(Integer.valueOf(i10))), false);
        TextView textView = holder.r().f10236c;
        f0.o(textView, "holder.viewBinding.tvOverclockLimit");
        c.a(textView, Boolean.valueOf(this.forOverclock), false);
        if (this.overclockAble) {
            return;
        }
        holder.r().getRoot().setAlpha(0.3f);
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k b<h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_target_temperature;
    }
}
