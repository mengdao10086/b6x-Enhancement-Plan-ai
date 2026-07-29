package com.flydigi.community.ui.comment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.community.R;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class MoreActionDialogFragment extends BaseDialogFragment {

    @yt.k
    public static final a G8 = new a(null);
    public y5.h E8;

    @yt.l
    public b F8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final MoreActionDialogFragment a() {
            MoreActionDialogFragment moreActionDialogFragment = new MoreActionDialogFragment();
            moreActionDialogFragment.c5(androidx.core.os.e.a());
            return moreActionDialogFragment;
        }
    }

    public interface b {
        void a();
    }

    public static final void j6(MoreActionDialogFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.I5();
    }

    public static final void k6(MoreActionDialogFragment this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.F8;
        if (bVar != null) {
            bVar.a();
        }
        this$0.I5();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        W5(1, R.style.DialogTheme);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.community_dialog_more_action;
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
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void h4() {
        Dialog dialogL5;
        Window window;
        super.h4();
        if (L5() == null || (dialogL5 = L5()) == null || (window = dialogL5.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(R.style.dialog_anim_enter_bottom);
    }

    @yt.l
    public final b i6() {
        return this.F8;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        y5.h hVarA = y5.h.a(view);
        f0.o(hVarA, "bind(view)");
        this.E8 = hVarA;
        y5.h hVar = null;
        if (hVarA == null) {
            f0.S("viewBinding");
            hVarA = null;
        }
        com.blankj.utilcode.util.o.r(hVarA.f56335b, new View.OnClickListener() { // from class: com.flydigi.community.ui.comment.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoreActionDialogFragment.j6(this.f13883a, view2);
            }
        });
        y5.h hVar2 = this.E8;
        if (hVar2 == null) {
            f0.S("viewBinding");
        } else {
            hVar = hVar2;
        }
        com.blankj.utilcode.util.o.r(hVar.f56336c, new View.OnClickListener() { // from class: com.flydigi.community.ui.comment.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoreActionDialogFragment.k6(this.f13884a, view2);
            }
        });
    }

    public final void l6(@yt.l b bVar) {
        this.F8 = bVar;
    }
}
