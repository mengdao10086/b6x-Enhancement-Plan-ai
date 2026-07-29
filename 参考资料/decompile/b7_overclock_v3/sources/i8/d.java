package i8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.y1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y1 f31894e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_left_up);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 2;
        y1 y1Var = this.f31894e;
        y1 y1Var2 = null;
        if (y1Var == null) {
            f0.S("viewBinding");
            y1Var = null;
        }
        cFGPropertyKey.range = y1Var.f54565c.getValue();
        y1 y1Var3 = this.f31894e;
        if (y1Var3 == null) {
            f0.S("viewBinding");
        } else {
            y1Var2 = y1Var3;
        }
        cFGPropertyKey.duration = y1Var2.f54566d.getValue() * 5;
        cFGPropertyKey.angle = 315;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        y1 y1VarA = y1.a(view);
        f0.o(y1VarA, "bind(view)");
        this.f31894e = y1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        y1 y1Var = this.f31894e;
        y1 y1Var2 = null;
        if (y1Var == null) {
            f0.S("viewBinding");
            y1Var = null;
        }
        y1Var.f54565c.setValue(pkey.range);
        y1 y1Var3 = this.f31894e;
        if (y1Var3 == null) {
            f0.S("viewBinding");
        } else {
            y1Var2 = y1Var3;
        }
        y1Var2.f54566d.setValue(pkey.duration / 5);
    }

    @Override // d8.a
    public void g() {
        y1 y1Var = this.f31894e;
        y1 y1Var2 = null;
        if (y1Var == null) {
            f0.S("viewBinding");
            y1Var = null;
        }
        y1Var.f54565c.U();
        y1 y1Var3 = this.f31894e;
        if (y1Var3 == null) {
            f0.S("viewBinding");
        } else {
            y1Var2 = y1Var3;
        }
        y1Var2.f54566d.U();
    }
}
