package h8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.o1;

/* JADX INFO: loaded from: classes7.dex */
public final class j extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o1 f30708e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_skill_relation);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 27;
        o1 o1Var = this.f30708e;
        o1 o1Var2 = null;
        if (o1Var == null) {
            f0.S("viewBinding");
            o1Var = null;
        }
        cFGPropertyKey.radius = o1Var.f54342d.getValue();
        o1 o1Var3 = this.f30708e;
        if (o1Var3 == null) {
            f0.S("viewBinding");
        } else {
            o1Var2 = o1Var3;
        }
        cFGPropertyKey.js_link = o1Var2.f54341c.getValue() ? 2 : 0;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        o1 o1VarA = o1.a(view);
        f0.o(o1VarA, "bind(view)");
        this.f30708e = o1VarA;
        if (o1VarA == null) {
            f0.S("viewBinding");
            o1VarA = null;
        }
        o1VarA.f54341c.setVisibility(o9.e.a(deviceInfo, m9.k.f40830p) ? 0 : 8);
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        o1 o1Var = this.f30708e;
        o1 o1Var2 = null;
        if (o1Var == null) {
            f0.S("viewBinding");
            o1Var = null;
        }
        o1Var.f54342d.setValue(pkey.radius);
        o1 o1Var3 = this.f30708e;
        if (o1Var3 == null) {
            f0.S("viewBinding");
        } else {
            o1Var2 = o1Var3;
        }
        o1Var2.f54341c.setValue(pkey.js_link == 2);
    }

    @Override // d8.a
    public void g() {
        o1 o1Var = this.f30708e;
        o1 o1Var2 = null;
        if (o1Var == null) {
            f0.S("viewBinding");
            o1Var = null;
        }
        o1Var.f54342d.U();
        o1 o1Var3 = this.f30708e;
        if (o1Var3 == null) {
            f0.S("viewBinding");
        } else {
            o1Var2 = o1Var3;
        }
        o1Var2.f54341c.setValue(false);
    }
}
