package i8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.w1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w1 f31893e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_left);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 2;
        w1 w1Var = this.f31893e;
        w1 w1Var2 = null;
        if (w1Var == null) {
            f0.S("viewBinding");
            w1Var = null;
        }
        cFGPropertyKey.range = w1Var.f54520c.getValue();
        w1 w1Var3 = this.f31893e;
        if (w1Var3 == null) {
            f0.S("viewBinding");
        } else {
            w1Var2 = w1Var3;
        }
        cFGPropertyKey.duration = w1Var2.f54521d.getValue() * 5;
        cFGPropertyKey.angle = 270;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        w1 w1VarA = w1.a(view);
        f0.o(w1VarA, "bind(view)");
        this.f31893e = w1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        w1 w1Var = this.f31893e;
        w1 w1Var2 = null;
        if (w1Var == null) {
            f0.S("viewBinding");
            w1Var = null;
        }
        w1Var.f54520c.setValue(pkey.range);
        w1 w1Var3 = this.f31893e;
        if (w1Var3 == null) {
            f0.S("viewBinding");
        } else {
            w1Var2 = w1Var3;
        }
        w1Var2.f54521d.setValue(pkey.duration / 5);
    }

    @Override // d8.a
    public void g() {
        w1 w1Var = this.f31893e;
        w1 w1Var2 = null;
        if (w1Var == null) {
            f0.S("viewBinding");
            w1Var = null;
        }
        w1Var.f54520c.U();
        w1 w1Var3 = this.f31893e;
        if (w1Var3 == null) {
            f0.S("viewBinding");
        } else {
            w1Var2 = w1Var3;
        }
        w1Var2.f54521d.U();
    }
}
