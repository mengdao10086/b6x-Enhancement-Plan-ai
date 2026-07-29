package g8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.y0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y0 f29075e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_fps_motion_shoot);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 4;
        y0 y0Var = this.f29075e;
        y0 y0Var2 = null;
        if (y0Var == null) {
            f0.S("viewBinding");
            y0Var = null;
        }
        Pair<Integer, Integer> value = y0Var.f54561c.getValue();
        cFGPropertyKey.senty_x = value.f().intValue();
        cFGPropertyKey.senty_y = value.h().intValue();
        y0 y0Var3 = this.f29075e;
        if (y0Var3 == null) {
            f0.S("viewBinding");
        } else {
            y0Var2 = y0Var3;
        }
        Pair<Integer, Integer> value2 = y0Var2.f54562d.getValue();
        cFGPropertyKey.sentyRJsX = value2.f().intValue();
        cFGPropertyKey.sentyRJsY = value2.h().intValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        y0 y0VarA = y0.a(view);
        f0.o(y0VarA, "bind(view)");
        this.f29075e = y0VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        y0 y0Var = this.f29075e;
        y0 y0Var2 = null;
        if (y0Var == null) {
            f0.S("viewBinding");
            y0Var = null;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView = y0Var.f54561c;
        f0.o(floatViewTwoSeekBarView, "viewBinding.tsbMotionSens");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView, pkey.senty_x, pkey.senty_y, false, false, 12, null);
        y0 y0Var3 = this.f29075e;
        if (y0Var3 == null) {
            f0.S("viewBinding");
        } else {
            y0Var2 = y0Var3;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = y0Var2.f54562d;
        f0.o(floatViewTwoSeekBarView2, "viewBinding.tsbMotionSensJoystickR");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView2, pkey.sentyRJsX, pkey.sentyRJsY, false, false, 12, null);
    }

    @Override // d8.a
    public void g() {
        y0 y0Var = this.f29075e;
        y0 y0Var2 = null;
        if (y0Var == null) {
            f0.S("viewBinding");
            y0Var = null;
        }
        y0Var.f54561c.k0();
        y0 y0Var3 = this.f29075e;
        if (y0Var3 == null) {
            f0.S("viewBinding");
        } else {
            y0Var2 = y0Var3;
        }
        y0Var2.f54562d.k0();
    }
}
