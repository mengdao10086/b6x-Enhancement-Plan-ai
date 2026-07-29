package m8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;
import kotlin.jvm.internal.f0;
import w7.c2;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends j8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c2 f40721e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_up);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // j8.a
    @k
    public CFGSubPropertyMacro c() {
        CFGSubPropertyMacro cFGSubPropertyMacro = new CFGSubPropertyMacro();
        cFGSubPropertyMacro.setType(2);
        c2 c2Var = this.f40721e;
        if (c2Var == null) {
            f0.S("viewBinding");
            c2Var = null;
        }
        cFGSubPropertyMacro.setRange(c2Var.f54013c.getValue());
        cFGSubPropertyMacro.setAngle(0);
        return cFGSubPropertyMacro;
    }

    @Override // j8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        c2 c2VarA = c2.a(view);
        f0.o(c2VarA, "bind(view)");
        this.f40721e = c2VarA;
        if (c2VarA == null) {
            f0.S("viewBinding");
            c2VarA = null;
        }
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = c2VarA.f54014d;
        f0.o(floatViewSingleSeekBarView, "viewBinding.tsbSlideTime");
        o5.c.b(floatViewSingleSeekBarView, Boolean.FALSE, false, 2, null);
    }

    @Override // j8.a
    public void f(@k CFGSubPropertyMacro pkey) {
        f0.p(pkey, "pkey");
        c2 c2Var = this.f40721e;
        if (c2Var == null) {
            f0.S("viewBinding");
            c2Var = null;
        }
        c2Var.f54013c.setValue(pkey.getRange());
    }

    @Override // j8.a
    public void g() {
        c2 c2Var = this.f40721e;
        if (c2Var == null) {
            f0.S("viewBinding");
            c2Var = null;
        }
        c2Var.f54013c.U();
    }
}
