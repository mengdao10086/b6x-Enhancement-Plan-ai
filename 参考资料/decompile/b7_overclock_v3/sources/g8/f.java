package g8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.z0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z0 f29076e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_fps_motion_view_alwayson);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 15;
        z0 z0Var = this.f29076e;
        z0 z0Var2 = null;
        if (z0Var == null) {
            f0.S("viewBinding");
            z0Var = null;
        }
        Pair<Integer, Integer> value = z0Var.f54583c.getValue();
        cFGPropertyKey.senty_x = value.f().intValue();
        cFGPropertyKey.senty_y = value.h().intValue();
        z0 z0Var3 = this.f29076e;
        if (z0Var3 == null) {
            f0.S("viewBinding");
        } else {
            z0Var2 = z0Var3;
        }
        Pair<Integer, Integer> value2 = z0Var2.f54584d.getValue();
        cFGPropertyKey.senVisualRJsX = value2.f().intValue();
        cFGPropertyKey.senVisualRJsY = value2.h().intValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        z0 z0VarA = z0.a(view);
        f0.o(z0VarA, "bind(view)");
        this.f29076e = z0VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        z0 z0Var = this.f29076e;
        z0 z0Var2 = null;
        if (z0Var == null) {
            f0.S("viewBinding");
            z0Var = null;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView = z0Var.f54583c;
        f0.o(floatViewTwoSeekBarView, "viewBinding.tsbMotionSens");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView, pkey.senty_x, pkey.senty_y, false, false, 12, null);
        z0 z0Var3 = this.f29076e;
        if (z0Var3 == null) {
            f0.S("viewBinding");
        } else {
            z0Var2 = z0Var3;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = z0Var2.f54584d;
        f0.o(floatViewTwoSeekBarView2, "viewBinding.tsbMotionSensJoystickR");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView2, pkey.senVisualRJsX, pkey.senVisualRJsY, false, false, 12, null);
    }

    @Override // d8.a
    public void g() {
        z0 z0Var = this.f29076e;
        z0 z0Var2 = null;
        if (z0Var == null) {
            f0.S("viewBinding");
            z0Var = null;
        }
        z0Var.f54583c.k0();
        z0 z0Var3 = this.f29076e;
        if (z0Var3 == null) {
            f0.S("viewBinding");
        } else {
            z0Var2 = z0Var3;
        }
        z0Var2.f54584d.k0();
    }
}
