package com.flydigi.cyberfox.ui.connect;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.o;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.cyberfox.R;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.e0;
import i9.a;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes7.dex */
public final class ConnectHelpDialog extends BaseDialogFragment implements e0 {

    @yt.k
    public static final a H8 = new a(null);

    @yt.k
    public static final String I8 = "type";
    public static final int J8 = 1;
    public static final int K8 = 2;
    public h6.h E8;

    @yt.k
    public String F8 = "all";
    public int G8 = 1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ ConnectHelpDialog b(a aVar, String str, Integer num, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                num = 1;
            }
            return aVar.a(str, num);
        }

        @hk.m
        @yt.k
        public final ConnectHelpDialog a(@yt.k String deviceCode, @yt.l Integer num) {
            f0.p(deviceCode, "deviceCode");
            ConnectHelpDialog connectHelpDialog = new ConnectHelpDialog();
            connectHelpDialog.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode), new Pair("type", num)));
            return connectHelpDialog;
        }
    }

    @hk.m
    @yt.k
    public static final ConnectHelpDialog i6(@yt.k String str, @yt.l Integer num) {
        return H8.a(str, num);
    }

    public static final void j6(ConnectHelpDialog this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
        h3.a.j().d(a.c.f31943b).withString("key_device_code", q9.c.f47168e).navigation();
    }

    public static final void k6(ConnectHelpDialog this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        W5(1, R.style.DialogTheme);
        Bundle bundleT1 = T1();
        String string = bundleT1 != null ? bundleT1.getString("key_device_code") : null;
        if (string == null) {
            string = "all";
        }
        this.F8 = string;
        Bundle bundleT12 = T1();
        this.G8 = bundleT12 != null ? bundleT12.getInt("type", 1) : 1;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        h6.h hVarD = h6.h.d(inflater, viewGroup, false);
        f0.o(hVarD, "inflate(inflater, container, false)");
        this.E8 = hVarD;
        if (hVarD == null) {
            f0.S("viewBinding");
            hVarD = null;
        }
        FrameLayout root = hVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.cf_dialog_help_connect;
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
        attributes.height = this.G8 == 2 ? V2().getDimensionPixelSize(R.dimen.qb_px_350) : -2;
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
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        h6.h hVar = null;
        if (this.G8 == 2) {
            h6.h hVar2 = this.E8;
            if (hVar2 == null) {
                f0.S("viewBinding");
                hVar2 = null;
            }
            ImageView imageView = hVar2.f30597d;
            f0.o(imageView, "viewBinding.ivPic");
            o5.c.b(imageView, Boolean.FALSE, false, 2, null);
            h6.h hVar3 = this.E8;
            if (hVar3 == null) {
                f0.S("viewBinding");
                hVar3 = null;
            }
            hVar3.f30599f.setText(R.string.cf_title_firmware_upgrade_notice);
            h6.h hVar4 = this.E8;
            if (hVar4 == null) {
                f0.S("viewBinding");
                hVar4 = null;
            }
            Button button = hVar4.f30595b;
            f0.o(button, "viewBinding.btnAction");
            o5.c.b(button, Boolean.TRUE, false, 2, null);
            h6.h hVar5 = this.E8;
            if (hVar5 == null) {
                f0.S("viewBinding");
                hVar5 = null;
            }
            hVar5.f30598e.setText(R.string.cf_headset_x1_is_fault);
            h6.h hVar6 = this.E8;
            if (hVar6 == null) {
                f0.S("viewBinding");
                hVar6 = null;
            }
            o.r(hVar6.f30595b, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.connect.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ConnectHelpDialog.j6(this.f14232a, view2);
                }
            });
        } else {
            h6.h hVar7 = this.E8;
            if (hVar7 == null) {
                f0.S("viewBinding");
                hVar7 = null;
            }
            hVar7.f30597d.setImageResource(n0.b(this.F8, q9.c.f47167d) ? R.drawable.cf_pic_reset_t1 : n0.b(this.F8, q9.c.f47168e) ? R.drawable.cf_pic_reset_x1 : 0);
            h6.h hVar8 = this.E8;
            if (hVar8 == null) {
                f0.S("viewBinding");
                hVar8 = null;
            }
            hVar8.f30598e.setText(d3(R.string.cf_connection_failure_solution_desc, s6.a.f49519a.a(this.F8)));
        }
        h6.h hVar9 = this.E8;
        if (hVar9 == null) {
            f0.S("viewBinding");
        } else {
            hVar = hVar9;
        }
        o.r(hVar.f30596c, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.connect.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectHelpDialog.k6(this.f14231a, view2);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void q1(@yt.k List<BleDevice> list) {
        e0.a.a(this, list);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void s2() {
        e0.a.d(this);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void t0() {
        e0.a.c(this);
    }

    @Override // com.flydigi.sdk.bluetooth.e0
    public void x0(int i10) {
        e0.a.b(this, i10);
    }
}
