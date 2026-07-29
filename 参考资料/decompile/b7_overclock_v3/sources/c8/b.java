package c8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.q0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends b8.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q0 f10661f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k Context context, @k GamepadInfo deviceInfo, @k CFGPropertyJS property) {
        super(context, deviceInfo, property, R.layout.floatview_property_joystick_fps);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        f0.p(property, "property");
    }

    @Override // b8.a
    @k
    public CFGPropertyJS d() {
        CFGPropertyJS cFGPropertyJSC = c();
        cFGPropertyJSC.type = 4;
        q0 q0Var = this.f10661f;
        q0 q0Var2 = null;
        if (q0Var == null) {
            f0.S("viewBinding");
            q0Var = null;
        }
        Pair<Integer, Integer> value = q0Var.f54402d.getValue();
        cFGPropertyJSC.senty_x = value.f().intValue();
        cFGPropertyJSC.senty_y = value.h().intValue();
        q0 q0Var3 = this.f10661f;
        if (q0Var3 == null) {
            f0.S("viewBinding");
        } else {
            q0Var2 = q0Var3;
        }
        Pair<Boolean, Boolean> value2 = q0Var2.f54401c.getValue();
        cFGPropertyJSC.reverse_type = (value2.f().booleanValue() && value2.h().booleanValue()) ? 3 : value2.f().booleanValue() ? 1 : value2.h().booleanValue() ? 2 : 0;
        return cFGPropertyJSC;
    }

    @Override // b8.a
    public void f(@k View view) {
        f0.p(view, "view");
        q0 q0VarA = q0.a(view);
        f0.o(q0VarA, "bind(view)");
        this.f10661f = q0VarA;
        String firmwareVersion = b().getFirmwareVersion();
        f0.m(firmwareVersion);
        if (l9.c.b(m9.k.f40828n, firmwareVersion) || b().isDriverConnected()) {
            q0 q0Var = this.f10661f;
            if (q0Var == null) {
                f0.S("viewBinding");
                q0Var = null;
            }
            FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = q0Var.f54401c;
            f0.o(floatViewTwoCheckBoxView, "viewBinding.tcbReverse");
            o5.c.b(floatViewTwoCheckBoxView, Boolean.TRUE, false, 2, null);
            return;
        }
        q0 q0Var2 = this.f10661f;
        if (q0Var2 == null) {
            f0.S("viewBinding");
            q0Var2 = null;
        }
        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView2 = q0Var2.f54401c;
        f0.o(floatViewTwoCheckBoxView2, "viewBinding.tcbReverse");
        o5.c.b(floatViewTwoCheckBoxView2, Boolean.FALSE, false, 2, null);
    }

    @Override // b8.a
    public void g(@k CFGPropertyJS pkey) {
        f0.p(pkey, "pkey");
        k(pkey);
        q0 q0Var = this.f10661f;
        q0 q0Var2 = null;
        if (q0Var == null) {
            f0.S("viewBinding");
            q0Var = null;
        }
        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = q0Var.f54401c;
        int i10 = pkey.reverse_type;
        floatViewTwoCheckBoxView.q(i10 == 1 || i10 == 3, i10 == 2 || i10 == 3);
        q0 q0Var3 = this.f10661f;
        if (q0Var3 == null) {
            f0.S("viewBinding");
        } else {
            q0Var2 = q0Var3;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView = q0Var2.f54402d;
        f0.o(floatViewTwoSeekBarView, "viewBinding.tsbJoystickSens");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView, pkey.senty_x, pkey.senty_y, false, false, 12, null);
    }

    @Override // b8.a
    public void h() {
        q0 q0Var = this.f10661f;
        q0 q0Var2 = null;
        if (q0Var == null) {
            f0.S("viewBinding");
            q0Var = null;
        }
        q0Var.f54401c.o();
        q0 q0Var3 = this.f10661f;
        if (q0Var3 == null) {
            f0.S("viewBinding");
        } else {
            q0Var2 = q0Var3;
        }
        q0Var2.f54402d.k0();
    }
}
