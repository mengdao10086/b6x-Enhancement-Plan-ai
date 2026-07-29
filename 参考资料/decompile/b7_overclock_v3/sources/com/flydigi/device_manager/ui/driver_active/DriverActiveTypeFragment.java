package com.flydigi.device_manager.ui.driver_active;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import org.json.JSONException;

/* JADX INFO: loaded from: classes7.dex */
public final class DriverActiveTypeFragment extends BaseGamepadFragment {

    @yt.k
    public static final b C8 = new b(null);

    @yt.l
    public a A8;
    public c7.c0 B8;

    public interface a {
        void b1();

        void f1(@yt.k String str);
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final DriverActiveTypeFragment a() {
            return new DriverActiveTypeFragment();
        }
    }

    public static final void G6(DriverActiveTypeFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.L6();
    }

    public static final void H6(DriverActiveTypeFragment this$0, View view) throws JSONException {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        a aVar = this$0.A8;
        if (aVar != null) {
            aVar.b1();
        }
        u9.h.e(view.getContext(), "Module_Driver_Active_Switch_Flashplay_Mode", "连接激活_开启映射_切换智连模式", true);
    }

    public static final void I6(DriverActiveTypeFragment this$0, View view) throws JSONException {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        a aVar = this$0.A8;
        if (aVar != null) {
            aVar.f1(DriverActivationActivity.O7);
        }
        u9.h.e(view.getContext(), "Module_Driver_Active_By_Utool", "连接激活_开启映射_小游开启", true);
    }

    public static final void J6(DriverActiveTypeFragment this$0, View view) throws JSONException {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        a aVar = this$0.A8;
        if (aVar != null) {
            aVar.f1(DriverActivationActivity.P7);
        }
        u9.h.e(view.getContext(), "Module_Driver_Active_By_Pc", "连接激活_开启映射_电脑开启", true);
    }

    public static final void K6(DriverActiveTypeFragment this$0, View view) throws JSONException {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        a aVar = this$0.A8;
        if (aVar != null) {
            aVar.f1(DriverActivationActivity.Q7);
        }
        u9.h.e(view.getContext(), "Module_Driver_Active_By_wadb", "连接激活_开启映射_无线激活", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        kotlin.jvm.internal.f0.p(context, "context");
        super.H3(context);
        this.A8 = (a) context;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_active_type;
    }

    public final void L6() {
        GamepadInfo gamepadInfoK6 = k6();
        if (gamepadInfoK6 != null && gamepadInfoK6.getDeviceType() == 67) {
            c7.c0 c0Var = this.B8;
            if (c0Var == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                c0Var = null;
            }
            c0Var.f9877i.setText(R.string.device_driver_active_by_wasp_desc);
        } else {
            c7.c0 c0Var2 = this.B8;
            if (c0Var2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                c0Var2 = null;
            }
            c0Var2.f9877i.setText(R.string.device_driver_active_by_utool_desc);
        }
        GamepadInfo gamepadInfoK62 = k6();
        if ((gamepadInfoK62 == null || gamepadInfoK62.isGamepadHalf()) ? false : true) {
            c7.c0 c0Var3 = this.B8;
            if (c0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                c0Var3 = null;
            }
            TextView textView = c0Var3.f9873e;
            kotlin.jvm.internal.f0.o(textView, "viewBinding.btnSwitchToFlashplayMode");
            o5.c.b(textView, Boolean.TRUE, false, 2, null);
            return;
        }
        c7.c0 c0Var4 = this.B8;
        if (c0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            c0Var4 = null;
        }
        TextView textView2 = c0Var4.f9873e;
        kotlin.jvm.internal.f0.o(textView2, "viewBinding.btnSwitchToFlashplayMode");
        o5.c.b(textView2, Boolean.FALSE, false, 2, null);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        c7.c0 c0VarD = c7.c0.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(c0VarD, "inflate(inflater, container, false)");
        this.B8 = c0VarD;
        if (c0VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            c0VarD = null;
        }
        NestedScrollView root = c0VarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        c7.c0 c0Var = this.B8;
        c7.c0 c0Var2 = null;
        if (c0Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            c0Var = null;
        }
        com.blankj.utilcode.util.o.r(c0Var.f9873e, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws JSONException {
                DriverActiveTypeFragment.H6(this.f14940a, view2);
            }
        });
        c7.c0 c0Var3 = this.B8;
        if (c0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            c0Var3 = null;
        }
        com.blankj.utilcode.util.o.r(c0Var3.f9871c, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws JSONException {
                DriverActiveTypeFragment.I6(this.f14938a, view2);
            }
        });
        c7.c0 c0Var4 = this.B8;
        if (c0Var4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            c0Var4 = null;
        }
        com.blankj.utilcode.util.o.r(c0Var4.f9870b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws JSONException {
                DriverActiveTypeFragment.J6(this.f14941a, view2);
            }
        });
        c7.c0 c0Var5 = this.B8;
        if (c0Var5 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            c0Var5 = null;
        }
        c0Var5.f9872d.setVisibility((Build.VERSION.SDK_INT < 30 || o5.h.g()) ? 8 : 0);
        c7.c0 c0Var6 = this.B8;
        if (c0Var6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            c0Var2 = c0Var6;
        }
        com.blankj.utilcode.util.o.r(c0Var2.f9872d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws JSONException {
                DriverActiveTypeFragment.K6(this.f14939a, view2);
            }
        });
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@yt.k GamepadInfo deviceInfo) {
        kotlin.jvm.internal.f0.p(deviceInfo, "deviceInfo");
        super.q6(deviceInfo);
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.driver_active.u
            @Override // java.lang.Runnable
            public final void run() {
                DriverActiveTypeFragment.G6(this.f14942a);
            }
        });
    }
}
