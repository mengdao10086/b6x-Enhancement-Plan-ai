package i8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.x1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x1 f31892e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_left_down);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 2;
        x1 x1Var = this.f31892e;
        x1 x1Var2 = null;
        if (x1Var == null) {
            f0.S("viewBinding");
            x1Var = null;
        }
        cFGPropertyKey.range = x1Var.f54543c.getValue();
        x1 x1Var3 = this.f31892e;
        if (x1Var3 == null) {
            f0.S("viewBinding");
        } else {
            x1Var2 = x1Var3;
        }
        cFGPropertyKey.duration = x1Var2.f54544d.getValue() * 5;
        cFGPropertyKey.angle = 225;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        x1 x1VarA = x1.a(view);
        f0.o(x1VarA, "bind(view)");
        this.f31892e = x1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        x1 x1Var = this.f31892e;
        x1 x1Var2 = null;
        if (x1Var == null) {
            f0.S("viewBinding");
            x1Var = null;
        }
        x1Var.f54543c.setValue(pkey.range);
        x1 x1Var3 = this.f31892e;
        if (x1Var3 == null) {
            f0.S("viewBinding");
        } else {
            x1Var2 = x1Var3;
        }
        x1Var2.f54544d.setValue(pkey.duration / 5);
    }

    @Override // d8.a
    public void g() {
        x1 x1Var = this.f31892e;
        x1 x1Var2 = null;
        if (x1Var == null) {
            f0.S("viewBinding");
            x1Var = null;
        }
        x1Var.f54543c.U();
        x1 x1Var3 = this.f31892e;
        if (x1Var3 == null) {
            f0.S("viewBinding");
        } else {
            x1Var2 = x1Var3;
        }
        x1Var2.f54544d.U();
    }
}
