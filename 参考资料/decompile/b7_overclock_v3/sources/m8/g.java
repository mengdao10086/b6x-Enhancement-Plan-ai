package m8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.b2;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b2 f40720e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_right_up);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(2);
        b2 b2Var = this.f40720e;
        if (b2Var == null) {
            f0.S("viewBinding");
            b2Var = null;
        }
        cFGSubPropertyMacro.setRange(b2Var.f53992c.getValue());
        cFGSubPropertyMacro.setAngle(45);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        b2 b2VarA = b2.a(view);
        f0.o(b2VarA, "bind(view)");
        this.f40720e = b2VarA;
        if (b2VarA == null) {
            f0.S("viewBinding");
            b2VarA = null;
        }
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = b2VarA.f53993d;
        f0.o(floatViewSingleSeekBarView, "viewBinding.tsbSlideTime");
        o5.c.b(floatViewSingleSeekBarView, Boolean.FALSE, false, 2, null);
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        b2 b2Var = this.f40720e;
        if (b2Var == null) {
            f0.S("viewBinding");
            b2Var = null;
        }
        b2Var.f53992c.setValue(pkey.getRange());
    }

    @Override // j8.a
    public void g() {
        b2 b2Var = this.f40720e;
        if (b2Var == null) {
            f0.S("viewBinding");
            b2Var = null;
        }
        b2Var.f53992c.U();
    }
}
