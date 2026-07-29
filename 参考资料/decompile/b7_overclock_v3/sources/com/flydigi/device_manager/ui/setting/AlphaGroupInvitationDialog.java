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
import c7.c3;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.setting.AlphaGroupInvitationDialog;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class AlphaGroupInvitationDialog extends BaseDialogFragment {

    @k
    public static final a G8 = new a(null);
    public c3 E8;

    @l
    public b F8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final AlphaGroupInvitationDialog a() {
            AlphaGroupInvitationDialog alphaGroupInvitationDialog = new AlphaGroupInvitationDialog();
            alphaGroupInvitationDialog.c5(e.a());
            return alphaGroupInvitationDialog;
        }
    }

    public interface b {
        void a();

        void b();
    }

    @m
    @k
    public static final AlphaGroupInvitationDialog i6() {
        return G8.a();
    }

    public static final void k6(AlphaGroupInvitationDialog this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.F8;
        if (bVar != null) {
            bVar.a();
        }
        this$0.e6();
    }

    public static final void l6(AlphaGroupInvitationDialog this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.F8;
        if (bVar != null) {
            bVar.b();
        }
        this$0.e6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        c3 c3VarD = c3.d(inflater, viewGroup, false);
        f0.o(c3VarD, "inflate(inflater, container, false)");
        this.E8 = c3VarD;
        if (c3VarD == null) {
            f0.S("viewBinding");
            c3VarD = null;
        }
        FrameLayout root = c3VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.main_dialog_alpha_group_invitation;
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
        c3 c3Var = this.E8;
        c3 c3Var2 = null;
        if (c3Var == null) {
            f0.S("viewBinding");
            c3Var = null;
        }
        o.r(c3Var.f9895b, new View.OnClickListener() { // from class: q7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlphaGroupInvitationDialog.k6(this.f47128a, view2);
            }
        });
        c3 c3Var3 = this.E8;
        if (c3Var3 == null) {
            f0.S("viewBinding");
        } else {
            c3Var2 = c3Var3;
        }
        o.r(c3Var2.f9896c, new View.OnClickListener() { // from class: q7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlphaGroupInvitationDialog.l6(this.f47127a, view2);
            }
        });
    }

    @l
    public final b j6() {
        return this.F8;
    }

    public final void m6(@l b bVar) {
        this.F8 = bVar;
    }
}
