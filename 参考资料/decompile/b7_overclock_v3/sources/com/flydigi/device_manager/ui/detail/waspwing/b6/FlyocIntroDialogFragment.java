package com.flydigi.device_manager.ui.detail.waspwing.b6;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.device_manager.R;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes7.dex */
public final class FlyocIntroDialogFragment extends BaseDialogFragment {

    @yt.k
    public static final a E8 = new a(null);

    @yt.k
    public static final String F8 = "key_type";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final DialogFragment a(int i10) {
            FlyocIntroDialogFragment flyocIntroDialogFragment = new FlyocIntroDialogFragment();
            flyocIntroDialogFragment.c5(androidx.core.os.e.b(new Pair("key_type", Integer.valueOf(i10))));
            return flyocIntroDialogFragment;
        }
    }

    public static final void h6(FlyocIntroDialogFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.device_dialog_flyoc_intro;
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
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        Dialog dialogL5 = L5();
        boolean z10 = false;
        if (dialogL5 != null) {
            dialogL5.setCancelable(false);
        }
        ((Button) view.findViewById(R.id.btn_action)).setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FlyocIntroDialogFragment.h6(this.f14697a, view2);
            }
        });
        Bundle bundleT1 = T1();
        if (bundleT1 != null && bundleT1.getInt("key_type") == 2) {
            z10 = true;
        }
        if (z10) {
            ((TextView) view.findViewById(R.id.tv_tech_name)).setText(R.string.device_waspwing_flyoc_intro_1);
            ((TextView) view.findViewById(R.id.tv_tech_desc)).setText(R.string.device_waspwing_flyoc_intro_2);
        }
    }
}
