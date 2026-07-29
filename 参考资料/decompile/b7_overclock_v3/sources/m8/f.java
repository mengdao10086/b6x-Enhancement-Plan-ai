package m8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.z1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z1 f40719e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_right);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(2);
        z1 z1Var = this.f40719e;
        if (z1Var == null) {
            f0.S("viewBinding");
            z1Var = null;
        }
        cFGSubPropertyMacro.setRange(z1Var.f54587c.getValue());
        cFGSubPropertyMacro.setAngle(90);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        z1 z1VarA = z1.a(view);
        f0.o(z1VarA, "bind(view)");
        this.f40719e = z1VarA;
        if (z1VarA == null) {
            f0.S("viewBinding");
            z1VarA = null;
        }
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = z1VarA.f54588d;
        f0.o(floatViewSingleSeekBarView, "viewBinding.tsbSlideTime");
        o5.c.b(floatViewSingleSeekBarView, Boolean.FALSE, false, 2, null);
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        z1 z1Var = this.f40719e;
        if (z1Var == null) {
            f0.S("viewBinding");
            z1Var = null;
        }
        z1Var.f54587c.setValue(pkey.getRange());
    }

    @Override // j8.a
    public void g() {
        z1 z1Var = this.f40719e;
        if (z1Var == null) {
            f0.S("viewBinding");
            z1Var = null;
        }
        z1Var.f54587c.U();
    }
}
