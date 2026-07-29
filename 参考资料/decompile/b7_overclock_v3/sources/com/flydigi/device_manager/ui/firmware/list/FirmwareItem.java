package com.flydigi.device_manager.ui.firmware.list;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c7.x1;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.o;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.firmware.list.FirmwareItem;
import ei.h;
import eu.davidea.flexibleadapter.b;
import gi.d;
import java.util.List;
import kotlin.jvm.internal.f0;
import o5.c;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class FirmwareItem extends AbstractModelItem<FirmwareInfoBean, a> {

    public static final class a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @k
        public final x1 f15007g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@k View view, @k b<? extends h<?>> adapter) {
            super(view, adapter);
            f0.p(view, "view");
            f0.p(adapter, "adapter");
            x1 x1VarA = x1.a(view);
            f0.o(x1VarA, "bind(view)");
            this.f15007g = x1VarA;
            x1VarA.f10571e.setOnClickListener(this);
            o.r(x1VarA.f10572f, new View.OnClickListener() { // from class: l7.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FirmwareItem.a.s(this.f39466a, view2);
                }
            });
        }

        public static final void s(a this$0, View view) {
            f0.p(this$0, "this$0");
            Context context = this$0.f15007g.f10572f.getContext();
            int i10 = R.string.device_more;
            if (n0.b(context.getString(i10), this$0.f15007g.f10572f.getText().toString())) {
                this$0.f15007g.f10572f.setText(R.string.collapsed);
                TextView textView = this$0.f15007g.f10570d;
                textView.setMaxHeight(textView.getResources().getDisplayMetrics().heightPixels);
            } else if (n0.b(this$0.f15007g.f10572f.getContext().getString(R.string.collapsed), this$0.f15007g.f10572f.getText().toString())) {
                this$0.f15007g.f10572f.setText(i10);
                this$0.f15007g.f10570d.setMaxLines(3);
            }
        }

        @k
        public final x1 t() {
            return this.f15007g;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirmwareItem(@k FirmwareInfoBean data) {
        super(data);
        f0.p(data, "data");
    }

    public static final void D(a holder) {
        f0.p(holder, "$holder");
        if ((holder.t().f10570d.getLayout() != null ? holder.t().f10570d.getLayout().getEllipsisCount(holder.t().f10570d.getLineCount() - 1) : 0) > 0) {
            TextView textView = holder.t().f10572f;
            f0.o(textView, "holder.viewBinding.tvMore");
            c.b(textView, Boolean.TRUE, false, 2, null);
        } else {
            TextView textView2 = holder.t().f10572f;
            f0.o(textView2, "holder.viewBinding.tvMore");
            c.b(textView2, Boolean.FALSE, false, 2, null);
        }
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void o(@k b<h<RecyclerView.e0>> adapter, @k final a holder, int i10, @k List<Object> payloads) {
        String str;
        f0.p(adapter, "adapter");
        f0.p(holder, "holder");
        f0.p(payloads, "payloads");
        TextView textView = holder.t().f10573g;
        if (i10 == 0) {
            str = z().title + '(' + holder.t().getRoot().getContext().getString(R.string.device_firmware_upgrade_version_latest) + ')';
        } else {
            str = z().title;
        }
        textView.setText(str);
        holder.t().f10569c.setText(z().date);
        holder.t().f10570d.setText(z().desc);
        holder.t().f10568b.setImageResource(i10 == 0 ? R.drawable.device_ic_bluetooth_active : R.drawable.device_ic_bluetooth_inactive);
        holder.t().f10570d.post(new Runnable() { // from class: l7.a
            @Override // java.lang.Runnable
            public final void run() {
                FirmwareItem.D(holder);
            }
        });
    }

    @Override // ei.c, ei.h
    @k
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public a i(@k View view, @k b<h<RecyclerView.e0>> adapter) {
        f0.p(view, "view");
        f0.p(adapter, "adapter");
        return new a(view, adapter);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_firmware;
    }
}
