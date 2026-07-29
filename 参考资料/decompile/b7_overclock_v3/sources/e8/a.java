package e8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.u0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u0 f26728e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_flymouse);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        u0 u0Var = this.f26728e;
        u0 u0Var2 = null;
        if (u0Var == null) {
            f0.S("viewBinding");
            u0Var = null;
        }
        if (u0Var.f54477c.getValue().h().booleanValue()) {
            cFGPropertyKey.type = 36;
        } else {
            cFGPropertyKey.type = 32;
        }
        u0 u0Var3 = this.f26728e;
        if (u0Var3 == null) {
            f0.S("viewBinding");
            u0Var3 = null;
        }
        cFGPropertyKey.cursorControlSpeedX = u0Var3.f54478d.getValue().f().intValue();
        u0 u0Var4 = this.f26728e;
        if (u0Var4 == null) {
            f0.S("viewBinding");
            u0Var4 = null;
        }
        cFGPropertyKey.cursorControlSpeedY = u0Var4.f54478d.getValue().h().intValue();
        u0 u0Var5 = this.f26728e;
        if (u0Var5 == null) {
            f0.S("viewBinding");
            u0Var5 = null;
        }
        cFGPropertyKey.cursorRJsX = u0Var5.f54479e.getValue().f().intValue();
        u0 u0Var6 = this.f26728e;
        if (u0Var6 == null) {
            f0.S("viewBinding");
        } else {
            u0Var2 = u0Var6;
        }
        cFGPropertyKey.cursorRJsY = u0Var2.f54479e.getValue().h().intValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        u0 u0VarA = u0.a(view);
        f0.o(u0VarA, "bind(view)");
        this.f26728e = u0VarA;
        if (deviceInfo.isGamepadKeyboard()) {
            u0 u0Var = this.f26728e;
            if (u0Var == null) {
                f0.S("viewBinding");
                u0Var = null;
            }
            u0Var.f54476b.a(R.string.floatview_property_key_fly_mouse_desc_keyboard);
            u0 u0Var2 = this.f26728e;
            if (u0Var2 == null) {
                f0.S("viewBinding");
                u0Var2 = null;
            }
            FloatViewTwoSeekBarView floatViewTwoSeekBarView = u0Var2.f54479e;
            f0.o(floatViewTwoSeekBarView, "viewBinding.tsbFlyMouseRightJoystick");
            o5.c.b(floatViewTwoSeekBarView, Boolean.FALSE, false, 2, null);
        } else {
            u0 u0Var3 = this.f26728e;
            if (u0Var3 == null) {
                f0.S("viewBinding");
                u0Var3 = null;
            }
            u0Var3.f54476b.a(R.string.floatview_property_key_fly_mouse_desc_gamepad);
            u0 u0Var4 = this.f26728e;
            if (u0Var4 == null) {
                f0.S("viewBinding");
                u0Var4 = null;
            }
            FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = u0Var4.f54479e;
            f0.o(floatViewTwoSeekBarView2, "viewBinding.tsbFlyMouseRightJoystick");
            o5.c.b(floatViewTwoSeekBarView2, Boolean.TRUE, false, 2, null);
        }
        if (o9.e.a(deviceInfo, m9.k.f40831q)) {
            u0 u0Var5 = this.f26728e;
            if (u0Var5 == null) {
                f0.S("viewBinding");
                u0Var5 = null;
            }
            FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = u0Var5.f54477c;
            f0.o(floatViewTwoCheckBoxView, "viewBinding.tcbTriggerMode");
            o5.c.b(floatViewTwoCheckBoxView, Boolean.TRUE, false, 2, null);
            return;
        }
        u0 u0Var6 = this.f26728e;
        if (u0Var6 == null) {
            f0.S("viewBinding");
            u0Var6 = null;
        }
        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView2 = u0Var6.f54477c;
        f0.o(floatViewTwoCheckBoxView2, "viewBinding.tcbTriggerMode");
        o5.c.b(floatViewTwoCheckBoxView2, Boolean.FALSE, false, 2, null);
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        u0 u0Var = this.f26728e;
        u0 u0Var2 = null;
        if (u0Var == null) {
            f0.S("viewBinding");
            u0Var = null;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView = u0Var.f54478d;
        f0.o(floatViewTwoSeekBarView, "viewBinding.tsbFlyMouse");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView, pkey.cursorControlSpeedX, pkey.cursorControlSpeedY, false, false, 12, null);
        u0 u0Var3 = this.f26728e;
        if (u0Var3 == null) {
            f0.S("viewBinding");
            u0Var3 = null;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = u0Var3.f54479e;
        f0.o(floatViewTwoSeekBarView2, "viewBinding.tsbFlyMouseRightJoystick");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView2, pkey.cursorRJsX, pkey.cursorRJsY, false, false, 12, null);
        u0 u0Var4 = this.f26728e;
        if (u0Var4 == null) {
            f0.S("viewBinding");
        } else {
            u0Var2 = u0Var4;
        }
        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = u0Var2.f54477c;
        int i10 = pkey.type;
        floatViewTwoCheckBoxView.q(i10 == 32, i10 == 36);
    }

    @Override // d8.a
    public void g() {
        u0 u0Var = this.f26728e;
        u0 u0Var2 = null;
        if (u0Var == null) {
            f0.S("viewBinding");
            u0Var = null;
        }
        u0Var.f54477c.o();
        u0 u0Var3 = this.f26728e;
        if (u0Var3 == null) {
            f0.S("viewBinding");
            u0Var3 = null;
        }
        u0Var3.f54478d.k0();
        u0 u0Var4 = this.f26728e;
        if (u0Var4 == null) {
            f0.S("viewBinding");
        } else {
            u0Var2 = u0Var4;
        }
        u0Var2.f54479e.k0();
    }
}
