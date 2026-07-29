package g8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.x0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x0 f29074e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_fps_look_map);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 26;
        x0 x0Var = this.f29074e;
        if (x0Var == null) {
            f0.S("viewBinding");
            x0Var = null;
        }
        cFGPropertyKey.radius = x0Var.f54540c.getValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        x0 x0VarA = x0.a(view);
        f0.o(x0VarA, "bind(view)");
        this.f29074e = x0VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        x0 x0Var = this.f29074e;
        if (x0Var == null) {
            f0.S("viewBinding");
            x0Var = null;
        }
        x0Var.f54540c.setValue(pkey.radius);
    }

    @Override // d8.a
    public void g() {
        x0 x0Var = this.f29074e;
        if (x0Var == null) {
            f0.S("viewBinding");
            x0Var = null;
        }
        x0Var.f54540c.U();
    }
}
