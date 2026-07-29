package com.flydigi.device_manager.ui.connection;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c7.r2;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.v0;

/* JADX INFO: loaded from: classes7.dex */
public final class KeyboardMouseConnectGuideFragment extends BaseGamepadFragment {

    @yt.k
    public static final a C8 = new a(null);

    @yt.k
    public static final String D8 = "type";
    public int A8;
    public r2 B8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final KeyboardMouseConnectGuideFragment a(int i10) {
            KeyboardMouseConnectGuideFragment keyboardMouseConnectGuideFragment = new KeyboardMouseConnectGuideFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i10);
            keyboardMouseConnectGuideFragment.c5(bundle);
            return keyboardMouseConnectGuideFragment;
        }
    }

    @hk.m
    @yt.k
    public static final KeyboardMouseConnectGuideFragment D6(int i10) {
        return C8.a(i10);
    }

    public static final void E6(View view) {
        u9.b.p(3, "连接向导", "support");
    }

    public final int C6(int i10) {
        return i10 != 0 ? i10 != 1 ? (i10 == 2 || i10 == 3) ? R.string.device_mouse : R.string.device_state_connected : R.string.device_keyboard : R.string.device_state_unconnected;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.A8 = bundleT1.getInt("type");
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_layout_fragment_keyboard_mouse_connect_guide;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        r2 r2VarD = r2.d(inflater, viewGroup, false);
        f0.o(r2VarD, "inflate(inflater, container, false)");
        this.B8 = r2VarD;
        if (r2VarD == null) {
            f0.S("viewBinding");
            r2VarD = null;
        }
        ConstraintLayout constraintLayoutB = r2VarD.getRoot();
        f0.o(constraintLayoutB, "viewBinding.root");
        return constraintLayoutB;
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        int i10 = this.A8;
        r2 r2Var = null;
        if (i10 == 48 || i10 == 50) {
            r2 r2Var2 = this.B8;
            if (r2Var2 == null) {
                f0.S("viewBinding");
                r2Var2 = null;
            }
            LinearLayout linearLayout = r2Var2.f10403c;
            f0.o(linearLayout, "viewBinding.areaStep2");
            Boolean bool = Boolean.FALSE;
            o5.c.b(linearLayout, bool, false, 2, null);
            r2 r2Var3 = this.B8;
            if (r2Var3 == null) {
                f0.S("viewBinding");
                r2Var3 = null;
            }
            LinearLayout linearLayout2 = r2Var3.f10404d;
            f0.o(linearLayout2, "viewBinding.areaStep3");
            o5.c.b(linearLayout2, bool, false, 2, null);
            com.bumptech.glide.h<Drawable> hVarP = com.bumptech.glide.b.G(this).p(Integer.valueOf(R.drawable.device_gif_q1_keyboard_mouse_1));
            r2 r2Var4 = this.B8;
            if (r2Var4 == null) {
                f0.S("viewBinding");
                r2Var4 = null;
            }
            hVarP.s1(r2Var4.f10406f);
            r2 r2Var5 = this.B8;
            if (r2Var5 == null) {
                f0.S("viewBinding");
                r2Var5 = null;
            }
            r2Var5.f10409i.setText("1." + c3(R.string.device_wee2_keyboard_mouse_step_3_action));
        } else if (i10 == 33) {
            com.bumptech.glide.h<Drawable> hVarP2 = com.bumptech.glide.b.G(this).p(Integer.valueOf(R.drawable.device_gif_wee2_keyboard_mouse_1));
            r2 r2Var6 = this.B8;
            if (r2Var6 == null) {
                f0.S("viewBinding");
                r2Var6 = null;
            }
            hVarP2.s1(r2Var6.f10406f);
            r2 r2Var7 = this.B8;
            if (r2Var7 == null) {
                f0.S("viewBinding");
                r2Var7 = null;
            }
            r2Var7.f10409i.setText("1." + c3(R.string.device_wee2_keyboard_mouse_step_1_action));
            com.bumptech.glide.h<Drawable> hVarP3 = com.bumptech.glide.b.G(this).p(Integer.valueOf(R.drawable.device_gif_wee2_keyboard_mouse_2));
            r2 r2Var8 = this.B8;
            if (r2Var8 == null) {
                f0.S("viewBinding");
                r2Var8 = null;
            }
            hVarP3.s1(r2Var8.f10407g);
            r2 r2Var9 = this.B8;
            if (r2Var9 == null) {
                f0.S("viewBinding");
                r2Var9 = null;
            }
            r2Var9.f10410j.setText("2." + c3(R.string.device_wee2_keyboard_mouse_step_2_action));
            com.bumptech.glide.h<Drawable> hVarP4 = com.bumptech.glide.b.G(this).p(Integer.valueOf(R.drawable.device_gif_wee2_keyboard_mouse_3));
            r2 r2Var10 = this.B8;
            if (r2Var10 == null) {
                f0.S("viewBinding");
                r2Var10 = null;
            }
            hVarP4.s1(r2Var10.f10408h);
            r2 r2Var11 = this.B8;
            if (r2Var11 == null) {
                f0.S("viewBinding");
                r2Var11 = null;
            }
            r2Var11.f10411k.setText("3." + c3(R.string.device_wee2_keyboard_mouse_step_3_action));
        }
        r2 r2Var12 = this.B8;
        if (r2Var12 == null) {
            f0.S("viewBinding");
        } else {
            r2Var = r2Var12;
        }
        com.blankj.utilcode.util.o.r(r2Var.f10405e, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.connection.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KeyboardMouseConnectGuideFragment.E6(view2);
            }
        });
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        super.q6(deviceInfo);
        r2 r2Var = this.B8;
        r2 r2Var2 = null;
        if (r2Var == null) {
            f0.S("viewBinding");
            r2Var = null;
        }
        TextView textView = r2Var.f10413m;
        v0 v0Var = v0.f37964a;
        String strC3 = c3(R.string.device_usb0);
        f0.o(strC3, "getString(R.string.device_usb0)");
        String str = String.format(strC3, Arrays.copyOf(new Object[]{c3(C6(deviceInfo.getUsb0Device()))}, 1));
        f0.o(str, "format(format, *args)");
        textView.setText(str);
        r2 r2Var3 = this.B8;
        if (r2Var3 == null) {
            f0.S("viewBinding");
        } else {
            r2Var2 = r2Var3;
        }
        TextView textView2 = r2Var2.f10414n;
        String strC32 = c3(R.string.device_usb1);
        f0.o(strC32, "getString(R.string.device_usb1)");
        String str2 = String.format(strC32, Arrays.copyOf(new Object[]{c3(C6(deviceInfo.getUsb1Device()))}, 1));
        f0.o(str2, "format(format, *args)");
        textView2.setText(str2);
    }
}
