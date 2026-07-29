package m8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.x1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x1 f40715e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_left_down);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(2);
        x1 x1Var = this.f40715e;
        if (x1Var == null) {
            f0.S("viewBinding");
            x1Var = null;
        }
        cFGSubPropertyMacro.setRange(x1Var.f54543c.getValue());
        cFGSubPropertyMacro.setAngle(225);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        x1 x1VarA = x1.a(view);
        f0.o(x1VarA, "bind(view)");
        this.f40715e = x1VarA;
        if (x1VarA == null) {
            f0.S("viewBinding");
            x1VarA = null;
        }
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = x1VarA.f54544d;
        f0.o(floatViewSingleSeekBarView, "viewBinding.tsbSlideTime");
        o5.c.b(floatViewSingleSeekBarView, Boolean.FALSE, false, 2, null);
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        x1 x1Var = this.f40715e;
        if (x1Var == null) {
            f0.S("viewBinding");
            x1Var = null;
        }
        x1Var.f54543c.setValue(pkey.getRange());
    }

    @Override // j8.a
    public void g() {
        x1 x1Var = this.f40715e;
        if (x1Var == null) {
            f0.S("viewBinding");
            x1Var = null;
        }
        x1Var.f54543c.U();
    }
}
