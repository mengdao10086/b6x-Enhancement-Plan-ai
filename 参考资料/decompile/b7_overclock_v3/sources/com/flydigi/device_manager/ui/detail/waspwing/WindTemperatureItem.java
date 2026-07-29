package com.flydigi.device_manager.ui.detail.waspwing;

import android.content.Context;
import android.util.AttributeSet;
import c7.b3;
import com.flydigi.device_manager.R;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class WindTemperatureItem extends q5.b {
    public b3 C2;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public WindTemperatureItem(@yt.k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public WindTemperatureItem(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ WindTemperatureItem(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    @Override // q5.b
    public void N(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        f0.p(context, "context");
        super.N(context, attributeSet);
        b3 b3VarA = b3.a(this);
        f0.o(b3VarA, "bind(this)");
        this.C2 = b3VarA;
    }

    public final void Q(int i10) {
        b3 b3Var = this.C2;
        if (b3Var == null) {
            f0.S("viewBinding");
            b3Var = null;
        }
        b3Var.f9863c.setText(getContext().getString(R.string.device_fragment_detail_b3_temperature_device, Integer.valueOf(i10)));
    }

    @Override // q5.b
    public int getLayoutId() {
        return R.layout.device_widget_wind_temperature;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public WindTemperatureItem(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
    }
}
