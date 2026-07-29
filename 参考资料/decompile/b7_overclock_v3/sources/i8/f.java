package i8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.z1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z1 f31896e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_right);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 2;
        z1 z1Var = this.f31896e;
        z1 z1Var2 = null;
        if (z1Var == null) {
            f0.S("viewBinding");
            z1Var = null;
        }
        cFGPropertyKey.range = z1Var.f54587c.getValue();
        z1 z1Var3 = this.f31896e;
        if (z1Var3 == null) {
            f0.S("viewBinding");
        } else {
            z1Var2 = z1Var3;
        }
        cFGPropertyKey.duration = z1Var2.f54588d.getValue() * 5;
        cFGPropertyKey.angle = 90;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        z1 z1VarA = z1.a(view);
        f0.o(z1VarA, "bind(view)");
        this.f31896e = z1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        z1 z1Var = this.f31896e;
        z1 z1Var2 = null;
        if (z1Var == null) {
            f0.S("viewBinding");
            z1Var = null;
        }
        z1Var.f54587c.setValue(pkey.range);
        z1 z1Var3 = this.f31896e;
        if (z1Var3 == null) {
            f0.S("viewBinding");
        } else {
            z1Var2 = z1Var3;
        }
        z1Var2.f54588d.setValue(pkey.duration / 5);
    }

    @Override // d8.a
    public void g() {
        z1 z1Var = this.f31896e;
        z1 z1Var2 = null;
        if (z1Var == null) {
            f0.S("viewBinding");
            z1Var = null;
        }
        z1Var.f54587c.U();
        z1 z1Var3 = this.f31896e;
        if (z1Var3 == null) {
            f0.S("viewBinding");
        } else {
            z1Var2 = z1Var3;
        }
        z1Var2.f54588d.U();
    }
}
