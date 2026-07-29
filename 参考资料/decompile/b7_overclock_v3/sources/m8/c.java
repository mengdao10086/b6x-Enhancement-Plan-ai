package m8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.w1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w1 f40716e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_left);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(2);
        w1 w1Var = this.f40716e;
        if (w1Var == null) {
            f0.S("viewBinding");
            w1Var = null;
        }
        cFGSubPropertyMacro.setRange(w1Var.f54520c.getValue());
        cFGSubPropertyMacro.setAngle(270);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        w1 w1VarA = w1.a(view);
        f0.o(w1VarA, "bind(view)");
        this.f40716e = w1VarA;
        if (w1VarA == null) {
            f0.S("viewBinding");
            w1VarA = null;
        }
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = w1VarA.f54521d;
        f0.o(floatViewSingleSeekBarView, "viewBinding.tsbSlideTime");
        o5.c.b(floatViewSingleSeekBarView, Boolean.FALSE, false, 2, null);
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        w1 w1Var = this.f40716e;
        if (w1Var == null) {
            f0.S("viewBinding");
            w1Var = null;
        }
        w1Var.f54520c.setValue(pkey.getRange());
    }

    @Override // j8.a
    public void g() {
        w1 w1Var = this.f40716e;
        if (w1Var == null) {
            f0.S("viewBinding");
            w1Var = null;
        }
        w1Var.f54520c.U();
    }
}
