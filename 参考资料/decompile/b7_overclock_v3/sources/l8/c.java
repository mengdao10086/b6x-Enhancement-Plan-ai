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
import w7.m1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nPropertyMobaRightJoystickRelationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PropertyMobaRightJoystickRelationImpl.kt\ncom/flydigi/float_view/ui/property/macro/impl/moba/PropertyMobaRightJoystickRelationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
public final class c extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m1 f39472e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_right_joystick_control);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(6);
        m1 m1Var = this.f39472e;
        m1 m1Var2 = null;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        cFGSubPropertyMacro.setRadius(m1Var.f54274d.getValue());
        m1 m1Var3 = this.f39472e;
        if (m1Var3 == null) {
            f0.S("viewBinding");
        } else {
            m1Var2 = m1Var3;
        }
        cFGSubPropertyMacro.setJsLink(m1Var2.f54273c.getValue() ? 2 : 0);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        z1 z1Var;
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        m1 m1VarA = m1.a(view);
        f0.o(m1VarA, "bind(view)");
        this.f39472e = m1VarA;
        if (m1VarA == null) {
            f0.S("viewBinding");
            m1VarA = null;
        }
        m1VarA.f54272b.a(R.string.floatview_property_macro_key_moba_right_joystick_releation_desc);
        String firmwareVersion = deviceInfo.getFirmwareVersion();
        if (firmwareVersion != null) {
            m1 m1Var = this.f39472e;
            if (m1Var == null) {
                f0.S("viewBinding");
                m1Var = null;
            }
            m1Var.f54273c.setEnabled(l9.c.b(m9.k.f40821g, firmwareVersion));
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            m1 m1Var2 = this.f39472e;
            if (m1Var2 == null) {
                f0.S("viewBinding");
                m1Var2 = null;
            }
            FloatViewSingleCheckBoxView floatViewSingleCheckBoxView = m1Var2.f54273c;
            f0.o(floatViewSingleCheckBoxView, "viewBinding.scbJoystickReverse");
            o5.c.b(floatViewSingleCheckBoxView, Boolean.FALSE, false, 2, null);
        }
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        m1 m1Var = this.f39472e;
        m1 m1Var2 = null;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        m1Var.f54274d.setValue(pkey.getRadius());
        int jsLink = pkey.getJsLink();
        if (jsLink == 2 || jsLink == 6) {
            m1 m1Var3 = this.f39472e;
            if (m1Var3 == null) {
                f0.S("viewBinding");
            } else {
                m1Var2 = m1Var3;
            }
            m1Var2.f54273c.setValue(true);
            return;
        }
        m1 m1Var4 = this.f39472e;
        if (m1Var4 == null) {
            f0.S("viewBinding");
        } else {
            m1Var2 = m1Var4;
        }
        m1Var2.f54273c.setValue(false);
    }

    @Override // j8.a
    public void g() {
        m1 m1Var = this.f39472e;
        m1 m1Var2 = null;
        if (m1Var == null) {
            f0.S("viewBinding");
            m1Var = null;
        }
        m1Var.f54274d.U();
        m1 m1Var3 = this.f39472e;
        if (m1Var3 == null) {
            f0.S("viewBinding");
        } else {
            m1Var2 = m1Var3;
        }
        m1Var2.f54273c.U();
    }
}
