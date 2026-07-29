package com.flydigi.device_manager.view;

import android.content.Context;
import android.util.AttributeSet;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class ProductHelpItem extends ActionItemNormal {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public ProductHelpItem(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public ProductHelpItem(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ ProductHelpItem(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    @Override // com.flydigi.base.widget.action_item.ActionItemNormal, q5.b
    public int getLayoutId() {
        return R.layout.device_item_product_help_item;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public ProductHelpItem(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
    }
}
