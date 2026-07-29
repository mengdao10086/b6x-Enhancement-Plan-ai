package com.flydigi.cyberfox.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.cyberfox.R;
import h6.e;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import o5.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FirmwareUpgradeActionItem extends ActionItemNormal {
    public e E7;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FirmwareUpgradeActionItem(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FirmwareUpgradeActionItem(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FirmwareUpgradeActionItem(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static /* synthetic */ void U(FirmwareUpgradeActionItem firmwareUpgradeActionItem, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        firmwareUpgradeActionItem.T(bool);
    }

    @Override // com.flydigi.base.widget.action_item.ActionItemNormal, q5.b
    public void N(@l Context context, @l AttributeSet attributeSet) {
        super.N(context, attributeSet);
        e eVarA = e.a(this);
        f0.o(eVarA, "bind(this)");
        this.E7 = eVarA;
    }

    public final void T(@l Boolean bool) {
        Boolean bool2 = Boolean.TRUE;
        e eVar = null;
        if (!f0.g(bool, bool2)) {
            e eVar2 = this.E7;
            if (eVar2 == null) {
                f0.S("viewBinding");
                eVar2 = null;
            }
            TextView textView = eVar2.f30577f;
            f0.o(textView, "viewBinding.tvStateHint");
            c.b(textView, Boolean.FALSE, false, 2, null);
            return;
        }
        e eVar3 = this.E7;
        if (eVar3 == null) {
            f0.S("viewBinding");
            eVar3 = null;
        }
        TextView textView2 = eVar3.f30577f;
        f0.o(textView2, "viewBinding.tvStateHint");
        c.b(textView2, bool2, false, 2, null);
        e eVar4 = this.E7;
        if (eVar4 == null) {
            f0.S("viewBinding");
            eVar4 = null;
        }
        eVar4.f30577f.setText(R.string.cf_firmware_out_of_date);
        e eVar5 = this.E7;
        if (eVar5 == null) {
            f0.S("viewBinding");
        } else {
            eVar = eVar5;
        }
        eVar.f30577f.setBackgroundResource(R.drawable.cf_shape_bg_red_r12);
    }

    @Override // com.flydigi.base.widget.action_item.ActionItemNormal, q5.b
    public int getLayoutId() {
        return R.layout.cf_action_item_firmware_upgrade;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FirmwareUpgradeActionItem(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
    }
}
