package com.flydigi.qiji.ui.customer_service;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.n0;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.base.common.o;
import com.flydigi.base.widget.ratingbar.CBRatingBar;
import com.flydigi.data.DataConstant;
import com.flydigi.qiji.ui.customer_service.a;
import hk.m;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nCustomerServiceEvaluateDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomerServiceEvaluateDialogFragment.kt\ncom/flydigi/qiji/ui/customer_service/CustomerServiceEvaluateDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1#2:137\n*E\n"})
public final class CustomerServiceEvaluateDialogFragment extends BaseDialogFragment implements a.b {

    @k
    public static final a I8 = new a(null);

    @k
    public static final String J8 = "key_session_id";
    public a.InterfaceC0165a E8;
    public b9.e F8;

    @l
    public String G8;

    @l
    public b H8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final CustomerServiceEvaluateDialogFragment a(@k String sessionId) {
            f0.p(sessionId, "sessionId");
            CustomerServiceEvaluateDialogFragment customerServiceEvaluateDialogFragment = new CustomerServiceEvaluateDialogFragment();
            customerServiceEvaluateDialogFragment.c5(androidx.core.os.e.b(new Pair(CustomerServiceEvaluateDialogFragment.J8, sessionId)));
            return customerServiceEvaluateDialogFragment;
        }
    }

    public interface b {
        void dismiss();
    }

    @m
    @k
    public static final CustomerServiceEvaluateDialogFragment j6(@k String str) {
        return I8.a(str);
    }

    public static final void l6(View view, CustomerServiceEvaluateDialogFragment this$0, int i10) {
        f0.p(view, "$view");
        f0.p(this$0, "this$0");
        String[] stringArray = view.getResources().getStringArray(R.array.app_rating_level);
        f0.o(stringArray, "view.resources.getString…R.array.app_rating_level)");
        b9.e eVar = this$0.F8;
        b9.e eVar2 = null;
        if (eVar == null) {
            f0.S("viewBinding");
            eVar = null;
        }
        eVar.f9160g.setText(stringArray[i10 - 1]);
        b9.e eVar3 = this$0.F8;
        if (eVar3 == null) {
            f0.S("viewBinding");
            eVar3 = null;
        }
        TextView textView = eVar3.f9160g;
        f0.o(textView, "viewBinding.tvLevel");
        o5.c.b(textView, Boolean.TRUE, false, 2, null);
        b9.e eVar4 = this$0.F8;
        if (eVar4 == null) {
            f0.S("viewBinding");
        } else {
            eVar2 = eVar4;
        }
        eVar2.f9157d.setEnabled(true);
    }

    public static final void m6(CustomerServiceEvaluateDialogFragment this$0, View view) {
        f0.p(this$0, "this$0");
        String str = this$0.G8;
        if (str != null) {
            KeyboardUtils.k(view);
            a.InterfaceC0165a interfaceC0165a = this$0.E8;
            b9.e eVar = null;
            if (interfaceC0165a == null) {
                f0.S("mPresenter");
                interfaceC0165a = null;
            }
            b9.e eVar2 = this$0.F8;
            if (eVar2 == null) {
                f0.S("viewBinding");
                eVar2 = null;
            }
            int touchCount = eVar2.f9158e.getTouchCount();
            b9.e eVar3 = this$0.F8;
            if (eVar3 == null) {
                f0.S("viewBinding");
            } else {
                eVar = eVar3;
            }
            interfaceC0165a.t(str, touchCount, String.valueOf(eVar.f9159f.getText()));
        }
    }

    public static final void n6(CustomerServiceEvaluateDialogFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
    }

    @Override // com.flydigi.qiji.ui.customer_service.a.b
    public void E1() {
        o5.m.k(DataConstant.SP_APP).H(DataConstant.SP_APP_CUSTOMER_SERVICE_SESSION_ID);
        o.E(c3(R.string.app_submit_success));
        e6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString(J8) : null;
        this.G8 = string;
        if (n0.m(string)) {
            e6();
        }
        this.E8 = new CustomerServiceEvaluatePresenter(this);
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        b9.e eVarD = b9.e.d(inflater, viewGroup, false);
        f0.o(eVarD, "inflate(inflater, container, false)");
        this.F8 = eVarD;
        if (eVarD == null) {
            f0.S("viewBinding");
            eVarD = null;
        }
        FrameLayout root = eVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.main_dialog_customer_service_evaluate;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public void e6() {
        super.e6();
        b bVar = this.H8;
        if (bVar != null) {
            bVar.dismiss();
        }
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

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@k final View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        U5(false);
        b9.e eVar = this.F8;
        b9.e eVar2 = null;
        if (eVar == null) {
            f0.S("viewBinding");
            eVar = null;
        }
        eVar.f9158e.r(new CBRatingBar.b() { // from class: com.flydigi.qiji.ui.customer_service.d
            @Override // com.flydigi.base.widget.ratingbar.CBRatingBar.b
            public final void a(int i10) {
                CustomerServiceEvaluateDialogFragment.l6(view, this, i10);
            }
        });
        b9.e eVar3 = this.F8;
        if (eVar3 == null) {
            f0.S("viewBinding");
            eVar3 = null;
        }
        com.blankj.utilcode.util.o.r(eVar3.f9157d, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.customer_service.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CustomerServiceEvaluateDialogFragment.m6(this.f16110a, view2);
            }
        });
        b9.e eVar4 = this.F8;
        if (eVar4 == null) {
            f0.S("viewBinding");
            eVar4 = null;
        }
        com.blankj.utilcode.util.o.r(eVar4.f9156c, new View.OnClickListener() { // from class: com.flydigi.qiji.ui.customer_service.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CustomerServiceEvaluateDialogFragment.n6(this.f16111a, view2);
            }
        });
        b9.e eVar5 = this.F8;
        if (eVar5 == null) {
            f0.S("viewBinding");
            eVar5 = null;
        }
        eVar5.f9158e.A(60.0f);
        b9.e eVar6 = this.F8;
        if (eVar6 == null) {
            f0.S("viewBinding");
            eVar6 = null;
        }
        eVar6.f9158e.setTouchCount(3);
        String[] stringArray = view.getResources().getStringArray(R.array.app_rating_level);
        f0.o(stringArray, "view.resources.getString…R.array.app_rating_level)");
        b9.e eVar7 = this.F8;
        if (eVar7 == null) {
            f0.S("viewBinding");
            eVar7 = null;
        }
        eVar7.f9160g.setText(stringArray[2]);
        b9.e eVar8 = this.F8;
        if (eVar8 == null) {
            f0.S("viewBinding");
            eVar8 = null;
        }
        TextView textView = eVar8.f9160g;
        f0.o(textView, "viewBinding.tvLevel");
        o5.c.b(textView, Boolean.TRUE, false, 2, null);
        b9.e eVar9 = this.F8;
        if (eVar9 == null) {
            f0.S("viewBinding");
        } else {
            eVar2 = eVar9;
        }
        eVar2.f9157d.setEnabled(true);
    }

    @l
    public final b k6() {
        return this.H8;
    }

    @Override // com.flydigi.qiji.ui.customer_service.a.b
    public void m(@k Throwable throwable) {
        f0.p(throwable, "throwable");
        String message = throwable.getMessage();
        if (message != null) {
            o.E(message);
        }
        e6();
    }

    public final void o6(@l b bVar) {
        this.H8 = bVar;
    }
}
