package m8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.v1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v1 f40714e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_down);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(2);
        v1 v1Var = this.f40714e;
        if (v1Var == null) {
            f0.S("viewBinding");
            v1Var = null;
        }
        cFGSubPropertyMacro.setRange(v1Var.f54499c.getValue());
        cFGSubPropertyMacro.setAngle(180);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        v1 v1VarA = v1.a(view);
        f0.o(v1VarA, "bind(view)");
        this.f40714e = v1VarA;
        if (v1VarA == null) {
            f0.S("viewBinding");
            v1VarA = null;
        }
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = v1VarA.f54500d;
        f0.o(floatViewSingleSeekBarView, "viewBinding.tsbSlideTime");
        o5.c.b(floatViewSingleSeekBarView, Boolean.FALSE, false, 2, null);
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        v1 v1Var = this.f40714e;
        if (v1Var == null) {
            f0.S("viewBinding");
            v1Var = null;
        }
        v1Var.f54499c.setValue(pkey.getRange());
    }

    @Override // j8.a
    public void g() {
        v1 v1Var = this.f40714e;
        if (v1Var == null) {
            f0.S("viewBinding");
            v1Var = null;
        }
        v1Var.f54499c.U();
    }
}
