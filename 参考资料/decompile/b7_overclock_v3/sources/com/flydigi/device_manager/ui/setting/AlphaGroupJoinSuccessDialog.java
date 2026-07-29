package com.flydigi.device_manager.ui.setting;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.os.e;
import c7.d3;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.setting.AlphaGroupJoinSuccessDialog;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class AlphaGroupJoinSuccessDialog extends BaseDialogFragment {

    @k
    public static final a F8 = new a(null);
    public d3 E8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final AlphaGroupJoinSuccessDialog a() {
            AlphaGroupJoinSuccessDialog alphaGroupJoinSuccessDialog = new AlphaGroupJoinSuccessDialog();
            alphaGroupJoinSuccessDialog.c5(e.a());
            return alphaGroupJoinSuccessDialog;
        }
    }

    @m
    @k
    public static final AlphaGroupJoinSuccessDialog h6() {
        return F8.a();
    }

    public static final void i6(AlphaGroupJoinSuccessDialog this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        d3 d3VarD = d3.d(inflater, viewGroup, false);
        f0.o(d3VarD, "inflate(inflater, container, false)");
        this.E8 = d3VarD;
        if (d3VarD == null) {
            f0.S("viewBinding");
            d3VarD = null;
        }
        FrameLayout root = d3VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.main_dialog_alpha_group_join_success;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        Window window;
        super.f4();
        Dialog dialogL5 = L5();
        if (dialogL5 == null || (window = dialogL5.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        f0.o(attributes, "it.attributes");
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(R.color.transparent);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void h4() {
        Dialog dialogL5;
        Window window;
        super.h4();
        if (L5() == null || (dialogL5 = L5()) == null || (window = dialogL5.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(R.style.dialog_anim_fade);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        U5(false);
        d3 d3Var = this.E8;
        if (d3Var == null) {
            f0.S("viewBinding");
            d3Var = null;
        }
        o.r(d3Var.f9944b, new View.OnClickListener() { // from class: q7.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlphaGroupJoinSuccessDialog.i6(this.f47129a, view2);
            }
        });
    }
}
