package h8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.e1;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e1 f30700e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_auto_joystick_relation);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 7;
        e1 e1Var = this.f30700e;
        e1 e1Var2 = null;
        if (e1Var == null) {
            f0.S("viewBinding");
            e1Var = null;
        }
        cFGPropertyKey.radius = e1Var.f54063c.getValue();
        e1 e1Var3 = this.f30700e;
        if (e1Var3 == null) {
            f0.S("viewBinding");
        } else {
            e1Var2 = e1Var3;
        }
        Pair<Boolean, Boolean> value = e1Var2.f54064d.getValue();
        cFGPropertyKey.js_link = (value.f().booleanValue() ? 4 : 0) + 8 + (value.h().booleanValue() ? 2 : 0);
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        e1 e1VarA = e1.a(view);
        f0.o(e1VarA, "bind(view)");
        this.f30700e = e1VarA;
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        e1 e1Var = this.f30700e;
        e1 e1Var2 = null;
        if (e1Var == null) {
            f0.S("viewBinding");
            e1Var = null;
        }
        e1Var.f54063c.setValue(pkey.radius);
        int i10 = pkey.js_link - 8;
        if (i10 == 0) {
            e1 e1Var3 = this.f30700e;
            if (e1Var3 == null) {
                f0.S("viewBinding");
            } else {
                e1Var2 = e1Var3;
            }
            e1Var2.f54064d.q(false, false);
            return;
        }
        if (i10 == 2) {
            e1 e1Var4 = this.f30700e;
            if (e1Var4 == null) {
                f0.S("viewBinding");
            } else {
                e1Var2 = e1Var4;
            }
            e1Var2.f54064d.q(false, true);
            return;
        }
        if (i10 == 4) {
            e1 e1Var5 = this.f30700e;
            if (e1Var5 == null) {
                f0.S("viewBinding");
            } else {
                e1Var2 = e1Var5;
            }
            e1Var2.f54064d.q(true, false);
            return;
        }
        if (i10 != 6) {
            return;
        }
        e1 e1Var6 = this.f30700e;
        if (e1Var6 == null) {
            f0.S("viewBinding");
        } else {
            e1Var2 = e1Var6;
        }
        e1Var2.f54064d.q(true, true);
    }

    @Override // d8.a
    public void g() {
        e1 e1Var = this.f30700e;
        e1 e1Var2 = null;
        if (e1Var == null) {
            f0.S("viewBinding");
            e1Var = null;
        }
        e1Var.f54063c.U();
        e1 e1Var3 = this.f30700e;
        if (e1Var3 == null) {
            f0.S("viewBinding");
        } else {
            e1Var2 = e1Var3;
        }
        e1Var2.f54064d.o();
    }
}
