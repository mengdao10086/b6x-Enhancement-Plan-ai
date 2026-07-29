package c8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import kotlin.jvm.internal.f0;
import w7.o0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends b8.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o0 f10660f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k Context context, @k GamepadInfo deviceInfo, @k CFGPropertyJS property) {
        super(context, deviceInfo, property, R.layout.floatview_property_joystick_direction);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        f0.p(property, "property");
    }

    @Override // b8.a
    @k
    public CFGPropertyJS d() {
        CFGPropertyJS cFGPropertyJSC = c();
        cFGPropertyJSC.type = 6;
        o0 o0Var = this.f10660f;
        if (o0Var == null) {
            f0.S("viewBinding");
            o0Var = null;
        }
        cFGPropertyJSC.radius = o0Var.f54338c.getValue();
        return cFGPropertyJSC;
    }

    @Override // b8.a
    public void f(@k View view) {
        f0.p(view, "view");
        o0 o0VarA = o0.a(view);
        f0.o(o0VarA, "bind(view)");
        this.f10660f = o0VarA;
    }

    @Override // b8.a
    public void g(@k CFGPropertyJS pkey) {
        f0.p(pkey, "pkey");
        k(pkey);
        o0 o0Var = this.f10660f;
        if (o0Var == null) {
            f0.S("viewBinding");
            o0Var = null;
        }
        o0Var.f54338c.setValue(pkey.radius);
    }

    @Override // b8.a
    public void h() {
        o0 o0Var = this.f10660f;
        if (o0Var == null) {
            f0.S("viewBinding");
            o0Var = null;
        }
        o0Var.f54338c.U();
    }
}
