package com.flydigi.device_manager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import c7.y1;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import o5.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FirmwareUpgradeActionItem extends ActionItemNormal {
    public y1 E7;

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

    public static /* synthetic */ void U(FirmwareUpgradeActionItem firmwareUpgradeActionItem, String str, Boolean bool, Boolean bool2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i10 & 4) != 0) {
            bool2 = Boolean.FALSE;
        }
        firmwareUpgradeActionItem.T(str, bool, bool2);
    }

    @Override // com.flydigi.base.widget.action_item.ActionItemNormal, q5.b
    public void N(@l Context context, @l AttributeSet attributeSet) {
        super.N(context, attributeSet);
        y1 y1VarA = y1.a(this);
        f0.o(y1VarA, "bind(this)");
        this.E7 = y1VarA;
    }

    @Override // com.flydigi.base.widget.action_item.ActionItemNormal
    public void R(@l String str, int i10) {
        super.R(str, i10);
        y1 y1Var = this.E7;
        if (y1Var == null) {
            f0.S("viewBinding");
            y1Var = null;
        }
        TextView textView = y1Var.f10604f;
        f0.o(textView, "viewBinding.tvStateHint");
        c.b(textView, Boolean.FALSE, false, 2, null);
    }

    public final void T(@k String state, @l Boolean bool, @l Boolean bool2) {
        f0.p(state, "state");
        Q(state);
        Boolean bool3 = Boolean.TRUE;
        y1 y1Var = null;
        if (f0.g(bool, bool3)) {
            y1 y1Var2 = this.E7;
            if (y1Var2 == null) {
                f0.S("viewBinding");
                y1Var2 = null;
            }
            TextView textView = y1Var2.f10604f;
            f0.o(textView, "viewBinding.tvStateHint");
            c.b(textView, bool3, false, 2, null);
            y1 y1Var3 = this.E7;
            if (y1Var3 == null) {
                f0.S("viewBinding");
                y1Var3 = null;
            }
            y1Var3.f10604f.setText(R.string.device_state_firmware_out_of_date);
            y1 y1Var4 = this.E7;
            if (y1Var4 == null) {
                f0.S("viewBinding");
            } else {
                y1Var = y1Var4;
            }
            y1Var.f10604f.setBackgroundResource(R.drawable.device_shape_bg_red_r12);
            return;
        }
        if (!f0.g(bool2, bool3)) {
            y1 y1Var5 = this.E7;
            if (y1Var5 == null) {
                f0.S("viewBinding");
                y1Var5 = null;
            }
            TextView textView2 = y1Var5.f10604f;
            f0.o(textView2, "viewBinding.tvStateHint");
            c.b(textView2, Boolean.FALSE, false, 2, null);
            return;
        }
        y1 y1Var6 = this.E7;
        if (y1Var6 == null) {
            f0.S("viewBinding");
            y1Var6 = null;
        }
        TextView textView3 = y1Var6.f10604f;
        f0.o(textView3, "viewBinding.tvStateHint");
        c.b(textView3, bool3, false, 2, null);
        y1 y1Var7 = this.E7;
        if (y1Var7 == null) {
            f0.S("viewBinding");
            y1Var7 = null;
        }
        y1Var7.f10604f.setText(R.string.device_state_firmware_up_to_date);
        y1 y1Var8 = this.E7;
        if (y1Var8 == null) {
            f0.S("viewBinding");
        } else {
            y1Var = y1Var8;
        }
        y1Var.f10604f.setBackgroundResource(R.drawable.device_shape_bg_blue_r12);
    }

    @Override // com.flydigi.base.widget.action_item.ActionItemNormal, q5.b
    public int getLayoutId() {
        return R.layout.device_item_firmware_upgrade_action;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FirmwareUpgradeActionItem(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
    }
}
