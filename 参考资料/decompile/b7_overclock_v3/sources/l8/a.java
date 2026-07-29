package l8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleCheckBoxView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import w7.h1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nPropertyMobaLeftJoystickControlImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PropertyMobaLeftJoystickControlImpl.kt\ncom/flydigi/float_view/ui/property/macro/impl/moba/PropertyMobaLeftJoystickControlImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
public final class a extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h1 f39470e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_left_joystick_control);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(12);
        h1 h1Var = this.f39470e;
        h1 h1Var2 = null;
        if (h1Var == null) {
            f0.S("viewBinding");
            h1Var = null;
        }
        cFGSubPropertyMacro.setRadius(h1Var.f54137d.getValue());
        h1 h1Var3 = this.f39470e;
        if (h1Var3 == null) {
            f0.S("viewBinding");
        } else {
            h1Var2 = h1Var3;
        }
        cFGSubPropertyMacro.setJsLink(h1Var2.f54136c.getValue() ? 2 : 0);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        z1 z1Var;
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        h1 h1VarA = h1.a(view);
        f0.o(h1VarA, "bind(view)");
        this.f39470e = h1VarA;
        String firmwareVersion = deviceInfo.getFirmwareVersion();
        if (firmwareVersion != null) {
            if (!deviceInfo.isFlashplayMode() || l9.c.b(m9.k.f40828n, firmwareVersion)) {
                h1 h1Var = this.f39470e;
                if (h1Var == null) {
                    f0.S("viewBinding");
                    h1Var = null;
                }
                FloatViewSingleCheckBoxView floatViewSingleCheckBoxView = h1Var.f54136c;
                f0.o(floatViewSingleCheckBoxView, "viewBinding.scbJoystickReverse");
                o5.c.b(floatViewSingleCheckBoxView, Boolean.TRUE, false, 2, null);
            } else {
                h1 h1Var2 = this.f39470e;
                if (h1Var2 == null) {
                    f0.S("viewBinding");
                    h1Var2 = null;
                }
                FloatViewSingleCheckBoxView floatViewSingleCheckBoxView2 = h1Var2.f54136c;
                f0.o(floatViewSingleCheckBoxView2, "viewBinding.scbJoystickReverse");
                o5.c.b(floatViewSingleCheckBoxView2, Boolean.FALSE, false, 2, null);
            }
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            h1 h1Var3 = this.f39470e;
            if (h1Var3 == null) {
                f0.S("viewBinding");
                h1Var3 = null;
            }
            FloatViewSingleCheckBoxView floatViewSingleCheckBoxView3 = h1Var3.f54136c;
            f0.o(floatViewSingleCheckBoxView3, "viewBinding.scbJoystickReverse");
            o5.c.b(floatViewSingleCheckBoxView3, Boolean.FALSE, false, 2, null);
        }
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        h1 h1Var = this.f39470e;
        h1 h1Var2 = null;
        if (h1Var == null) {
            f0.S("viewBinding");
            h1Var = null;
        }
        h1Var.f54137d.setValue(pkey.getRadius());
        h1 h1Var3 = this.f39470e;
        if (h1Var3 == null) {
            f0.S("viewBinding");
        } else {
            h1Var2 = h1Var3;
        }
        h1Var2.f54136c.setValue(pkey.getJsLink() == 2);
    }

    @Override // j8.a
    public void g() {
        h1 h1Var = this.f39470e;
        h1 h1Var2 = null;
        if (h1Var == null) {
            f0.S("viewBinding");
            h1Var = null;
        }
        h1Var.f54137d.U();
        h1 h1Var3 = this.f39470e;
        if (h1Var3 == null) {
            f0.S("viewBinding");
        } else {
            h1Var2 = h1Var3;
        }
        h1Var2.f54136c.U();
    }
}
