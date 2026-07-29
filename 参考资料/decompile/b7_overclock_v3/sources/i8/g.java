package i8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.b2;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b2 f31897e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_right_up);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 2;
        b2 b2Var = this.f31897e;
        b2 b2Var2 = null;
        if (b2Var == null) {
            f0.S("viewBinding");
            b2Var = null;
        }
        cFGPropertyKey.range = b2Var.f53992c.getValue();
        b2 b2Var3 = this.f31897e;
        if (b2Var3 == null) {
            f0.S("viewBinding");
        } else {
            b2Var2 = b2Var3;
        }
        cFGPropertyKey.duration = b2Var2.f53993d.getValue() * 5;
        cFGPropertyKey.angle = 45;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        b2 b2VarA = b2.a(view);
        f0.o(b2VarA, "bind(view)");
        this.f31897e = b2VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        b2 b2Var = this.f31897e;
        b2 b2Var2 = null;
        if (b2Var == null) {
            f0.S("viewBinding");
            b2Var = null;
        }
        b2Var.f53992c.setValue(pkey.range);
        b2 b2Var3 = this.f31897e;
        if (b2Var3 == null) {
            f0.S("viewBinding");
        } else {
            b2Var2 = b2Var3;
        }
        b2Var2.f53993d.setValue(pkey.duration / 5);
    }

    @Override // d8.a
    public void g() {
        b2 b2Var = this.f31897e;
        b2 b2Var2 = null;
        if (b2Var == null) {
            f0.S("viewBinding");
            b2Var = null;
        }
        b2Var.f53992c.U();
        b2 b2Var3 = this.f31897e;
        if (b2Var3 == null) {
            f0.S("viewBinding");
        } else {
            b2Var2 = b2Var3;
        }
        b2Var2.f53993d.U();
    }
}
