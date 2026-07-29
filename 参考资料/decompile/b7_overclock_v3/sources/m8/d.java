package m8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.y1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y1 f40717e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_left_up);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(2);
        y1 y1Var = this.f40717e;
        if (y1Var == null) {
            f0.S("viewBinding");
            y1Var = null;
        }
        cFGSubPropertyMacro.setRange(y1Var.f54565c.getValue());
        cFGSubPropertyMacro.setAngle(315);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        y1 y1VarA = y1.a(view);
        f0.o(y1VarA, "bind(view)");
        this.f40717e = y1VarA;
        if (y1VarA == null) {
            f0.S("viewBinding");
            y1VarA = null;
        }
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = y1VarA.f54566d;
        f0.o(floatViewSingleSeekBarView, "viewBinding.tsbSlideTime");
        o5.c.b(floatViewSingleSeekBarView, Boolean.FALSE, false, 2, null);
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        y1 y1Var = this.f40717e;
        if (y1Var == null) {
            f0.S("viewBinding");
            y1Var = null;
        }
        y1Var.f54565c.setValue(pkey.getRange());
    }

    @Override // j8.a
    public void g() {
        y1 y1Var = this.f40717e;
        if (y1Var == null) {
            f0.S("viewBinding");
            y1Var = null;
        }
        y1Var.f54565c.U();
    }
}
