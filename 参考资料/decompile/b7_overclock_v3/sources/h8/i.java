package h8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.n1;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n1 f30707e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_right_joystick_relation);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 6;
        n1 n1Var = this.f30707e;
        n1 n1Var2 = null;
        if (n1Var == null) {
            f0.S("viewBinding");
            n1Var = null;
        }
        cFGPropertyKey.radius = n1Var.f54316c.getValue();
        n1 n1Var3 = this.f30707e;
        if (n1Var3 == null) {
            f0.S("viewBinding");
        } else {
            n1Var2 = n1Var3;
        }
        Pair<Boolean, Boolean> value = n1Var2.f54317d.getValue();
        cFGPropertyKey.js_link = (value.f().booleanValue() ? 4 : 0) + (value.h().booleanValue() ? 2 : 0);
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        n1 n1VarA = n1.a(view);
        f0.o(n1VarA, "bind(view)");
        this.f30707e = n1VarA;
        boolean zA = o9.e.a(deviceInfo, m9.k.f40821g);
        n1 n1Var = null;
        if (zA) {
            n1 n1Var2 = this.f30707e;
            if (n1Var2 == null) {
                f0.S("viewBinding");
            } else {
                n1Var = n1Var2;
            }
            n1Var.f54317d.p(true, true);
            return;
        }
        n1 n1Var3 = this.f30707e;
        if (n1Var3 == null) {
            f0.S("viewBinding");
        } else {
            n1Var = n1Var3;
        }
        n1Var.f54317d.p(false, true);
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        n1 n1Var = this.f30707e;
        n1 n1Var2 = null;
        if (n1Var == null) {
            f0.S("viewBinding");
            n1Var = null;
        }
        n1Var.f54316c.setValue(pkey.radius);
        int i10 = pkey.js_link;
        if (i10 == 2) {
            n1 n1Var3 = this.f30707e;
            if (n1Var3 == null) {
                f0.S("viewBinding");
            } else {
                n1Var2 = n1Var3;
            }
            n1Var2.f54317d.q(false, true);
            return;
        }
        if (i10 == 4) {
            n1 n1Var4 = this.f30707e;
            if (n1Var4 == null) {
                f0.S("viewBinding");
            } else {
                n1Var2 = n1Var4;
            }
            n1Var2.f54317d.q(true, false);
            return;
        }
        if (i10 != 6) {
            return;
        }
        n1 n1Var5 = this.f30707e;
        if (n1Var5 == null) {
            f0.S("viewBinding");
        } else {
            n1Var2 = n1Var5;
        }
        n1Var2.f54317d.q(true, true);
    }

    @Override // d8.a
    public void g() {
        n1 n1Var = this.f30707e;
        n1 n1Var2 = null;
        if (n1Var == null) {
            f0.S("viewBinding");
            n1Var = null;
        }
        n1Var.f54316c.U();
        n1 n1Var3 = this.f30707e;
        if (n1Var3 == null) {
            f0.S("viewBinding");
        } else {
            n1Var2 = n1Var3;
        }
        n1Var2.f54317d.o();
    }
}
