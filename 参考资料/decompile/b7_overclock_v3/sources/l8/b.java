package l8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import w7.i1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nPropertyMobaLeftJoystickRelationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PropertyMobaLeftJoystickRelationImpl.kt\ncom/flydigi/float_view/ui/property/macro/impl/moba/PropertyMobaLeftJoystickRelationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
public final class b extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i1 f39471e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_left_joystick_relation);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(5);
        i1 i1Var = this.f39471e;
        i1 i1Var2 = null;
        if (i1Var == null) {
            f0.S("viewBinding");
            i1Var = null;
        }
        cFGSubPropertyMacro.setRadius(i1Var.f54154c.getValue());
        i1 i1Var3 = this.f39471e;
        if (i1Var3 == null) {
            f0.S("viewBinding");
        } else {
            i1Var2 = i1Var3;
        }
        Pair<Boolean, Boolean> value = i1Var2.f54155d.getValue();
        cFGSubPropertyMacro.setJsLink((value.f().booleanValue() ? 4 : 0) + (value.h().booleanValue() ? 2 : 0));
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        z1 z1Var;
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        i1 i1VarA = i1.a(view);
        f0.o(i1VarA, "bind(view)");
        this.f39471e = i1VarA;
        if (deviceInfo.isGamepadKeyboard()) {
            i1 i1Var = this.f39471e;
            if (i1Var == null) {
                f0.S("viewBinding");
                i1Var = null;
            }
            i1Var.f54153b.a(R.string.floatview_property_key_left_joystick_relation_for_keyboard);
        } else {
            i1 i1Var2 = this.f39471e;
            if (i1Var2 == null) {
                f0.S("viewBinding");
                i1Var2 = null;
            }
            i1Var2.f54153b.a(R.string.floatview_property_macro_key_moba_left_joystick_relation_desc);
        }
        if (deviceInfo.getFirmwareVersion() != null) {
            i1 i1Var3 = this.f39471e;
            if (i1Var3 == null) {
                f0.S("viewBinding");
                i1Var3 = null;
            }
            i1Var3.f54155d.p(false, true);
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            i1 i1Var4 = this.f39471e;
            if (i1Var4 == null) {
                f0.S("viewBinding");
                i1Var4 = null;
            }
            FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = i1Var4.f54155d;
            f0.o(floatViewTwoCheckBoxView, "viewBinding.tcbJoystickRelation");
            o5.c.b(floatViewTwoCheckBoxView, Boolean.FALSE, false, 2, null);
        }
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        i1 i1Var = this.f39471e;
        i1 i1Var2 = null;
        if (i1Var == null) {
            f0.S("viewBinding");
            i1Var = null;
        }
        i1Var.f54154c.setValue(pkey.getRadius());
        int jsLink = pkey.getJsLink();
        if (jsLink == 2) {
            i1 i1Var3 = this.f39471e;
            if (i1Var3 == null) {
                f0.S("viewBinding");
            } else {
                i1Var2 = i1Var3;
            }
            i1Var2.f54155d.q(false, true);
            return;
        }
        if (jsLink == 4) {
            i1 i1Var4 = this.f39471e;
            if (i1Var4 == null) {
                f0.S("viewBinding");
            } else {
                i1Var2 = i1Var4;
            }
            i1Var2.f54155d.q(true, false);
            return;
        }
        if (jsLink != 6) {
            return;
        }
        i1 i1Var5 = this.f39471e;
        if (i1Var5 == null) {
            f0.S("viewBinding");
        } else {
            i1Var2 = i1Var5;
        }
        i1Var2.f54155d.q(true, true);
    }

    @Override // j8.a
    public void g() {
        i1 i1Var = this.f39471e;
        i1 i1Var2 = null;
        if (i1Var == null) {
            f0.S("viewBinding");
            i1Var = null;
        }
        i1Var.f54154c.U();
        i1 i1Var3 = this.f39471e;
        if (i1Var3 == null) {
            f0.S("viewBinding");
        } else {
            i1Var2 = i1Var3;
        }
        i1Var2.f54155d.q(false, false);
    }
}
