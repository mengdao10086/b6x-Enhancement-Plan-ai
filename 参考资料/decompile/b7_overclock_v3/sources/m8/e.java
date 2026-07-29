package m8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.a2;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a2 f40718e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_right_down);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(2);
        a2 a2Var = this.f40718e;
        if (a2Var == null) {
            f0.S("viewBinding");
            a2Var = null;
        }
        cFGSubPropertyMacro.setRange(a2Var.f53968c.getValue());
        cFGSubPropertyMacro.setAngle(135);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        a2 a2VarA = a2.a(view);
        f0.o(a2VarA, "bind(view)");
        this.f40718e = a2VarA;
        if (a2VarA == null) {
            f0.S("viewBinding");
            a2VarA = null;
        }
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = a2VarA.f53969d;
        f0.o(floatViewSingleSeekBarView, "viewBinding.tsbSlideTime");
        o5.c.b(floatViewSingleSeekBarView, Boolean.FALSE, false, 2, null);
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        a2 a2Var = this.f40718e;
        if (a2Var == null) {
            f0.S("viewBinding");
            a2Var = null;
        }
        a2Var.f53968c.setValue(pkey.getRange());
    }

    @Override // j8.a
    public void g() {
        a2 a2Var = this.f40718e;
        if (a2Var == null) {
            f0.S("viewBinding");
            a2Var = null;
        }
        a2Var.f53968c.U();
    }
}
