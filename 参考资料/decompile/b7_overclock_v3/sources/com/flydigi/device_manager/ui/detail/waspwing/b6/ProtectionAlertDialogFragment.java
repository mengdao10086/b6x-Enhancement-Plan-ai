package com.flydigi.device_manager.ui.detail.waspwing.b6;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import c7.z;
import com.blankj.utilcode.util.s0;
import com.flydigi.base.common.BaseDialogFragment;
import com.flydigi.device_manager.R;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
public final class ProtectionAlertDialogFragment extends BaseDialogFragment {

    @yt.k
    public static final a F8 = new a(null);
    public static final int G8 = 1;
    public static final int H8 = 2;

    @yt.k
    public static final String I8 = "key_device_code";

    @yt.k
    public static final String J8 = "key_protection_type";
    public z E8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final DialogFragment a(@yt.k String deviceCode, int i10) {
            f0.p(deviceCode, "deviceCode");
            ProtectionAlertDialogFragment protectionAlertDialogFragment = new ProtectionAlertDialogFragment();
            protectionAlertDialogFragment.c5(androidx.core.os.e.b(new Pair("key_device_code", deviceCode), new Pair(ProtectionAlertDialogFragment.J8, Integer.valueOf(i10))));
            return protectionAlertDialogFragment;
        }
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.device_dialog_protection_alert;
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
        if (dialogL5 != null) {
            dialogL5.setCancelable(false);
        }
        z zVarA = z.a(view);
        f0.o(zVarA, "bind(view)");
        this.E8 = zVarA;
        Bundle bundleT1 = T1();
        z zVar = null;
        Integer numValueOf = bundleT1 != null ? Integer.valueOf(bundleT1.getInt(J8)) : null;
        if (numValueOf == null || numValueOf.intValue() != 2) {
            z zVar2 = this.E8;
            if (zVar2 == null) {
                f0.S("viewBinding");
                zVar2 = null;
            }
            ImageView imageView = zVar2.f10633b;
            f0.o(imageView, "viewBinding.ivBg");
            Boolean bool = Boolean.FALSE;
            o5.c.b(imageView, bool, false, 2, null);
            z zVar3 = this.E8;
            if (zVar3 == null) {
                f0.S("viewBinding");
                zVar3 = null;
            }
            TextView textView = zVar3.f10635d;
            f0.o(textView, "viewBinding.tvTitle");
            o5.c.b(textView, bool, false, 2, null);
            z zVar4 = this.E8;
            if (zVar4 == null) {
                f0.S("viewBinding");
            } else {
                zVar = zVar4;
            }
            zVar.f10634c.setText(R.string.device_fragment_detail_cold_protection_msg);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("device_pic_waspwing_hot_protection_");
        Bundle bundleT12 = T1();
        sb2.append(bundleT12 != null ? bundleT12.getString("key_device_code", t9.c.f50958g) : null);
        int iG = s0.g(sb2.toString());
        if (iG > 0) {
            z zVar5 = this.E8;
            if (zVar5 == null) {
                f0.S("viewBinding");
                zVar5 = null;
            }
            com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.F(zVar5.f10633b).p(Integer.valueOf(iG));
            z zVar6 = this.E8;
            if (zVar6 == null) {
                f0.S("viewBinding");
                zVar6 = null;
            }
            f0.o(hVarP.s1(zVar6.f10633b), "{\n                    Gl…g.ivBg)\n                }");
        } else {
            z zVar7 = this.E8;
            if (zVar7 == null) {
                f0.S("viewBinding");
                zVar7 = null;
            }
            ImageView imageView2 = zVar7.f10633b;
            f0.o(imageView2, "viewBinding.ivBg");
            o5.c.b(imageView2, Boolean.FALSE, false, 2, null);
            z1 z1Var = z1.f38230a;
        }
        z zVar8 = this.E8;
        if (zVar8 == null) {
            f0.S("viewBinding");
            zVar8 = null;
        }
        zVar8.f10635d.setText(R.string.device_waspwing_protection_hot_state);
        z zVar9 = this.E8;
        if (zVar9 == null) {
            f0.S("viewBinding");
            zVar9 = null;
        }
        TextView textView2 = zVar9.f10635d;
        f0.o(textView2, "viewBinding.tvTitle");
        o5.c.b(textView2, Boolean.TRUE, false, 2, null);
        z zVar10 = this.E8;
        if (zVar10 == null) {
            f0.S("viewBinding");
        } else {
            zVar = zVar10;
        }
        zVar.f10634c.setText(Html.fromHtml(c3(R.string.device_fragment_detail_hot_protection_msg)));
    }
}
