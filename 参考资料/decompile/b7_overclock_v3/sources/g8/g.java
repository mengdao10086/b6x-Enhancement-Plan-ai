package g8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.a1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a1 f29077e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_fps_motion_view);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 3;
        a1 a1Var = this.f29077e;
        a1 a1Var2 = null;
        if (a1Var == null) {
            f0.S("viewBinding");
            a1Var = null;
        }
        Pair<Integer, Integer> value = a1Var.f53964c.getValue();
        cFGPropertyKey.senty_x = value.f().intValue();
        cFGPropertyKey.senty_y = value.h().intValue();
        a1 a1Var3 = this.f29077e;
        if (a1Var3 == null) {
            f0.S("viewBinding");
        } else {
            a1Var2 = a1Var3;
        }
        Pair<Integer, Integer> value2 = a1Var2.f53965d.getValue();
        cFGPropertyKey.senVisualRJsX = value2.f().intValue();
        cFGPropertyKey.senVisualRJsY = value2.h().intValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        a1 a1VarA = a1.a(view);
        f0.o(a1VarA, "bind(view)");
        this.f29077e = a1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        a1 a1Var = this.f29077e;
        a1 a1Var2 = null;
        if (a1Var == null) {
            f0.S("viewBinding");
            a1Var = null;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView = a1Var.f53964c;
        f0.o(floatViewTwoSeekBarView, "viewBinding.tsbMotionSens");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView, pkey.senty_x, pkey.senty_y, false, false, 12, null);
        a1 a1Var3 = this.f29077e;
        if (a1Var3 == null) {
            f0.S("viewBinding");
        } else {
            a1Var2 = a1Var3;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = a1Var2.f53965d;
        f0.o(floatViewTwoSeekBarView2, "viewBinding.tsbMotionSensJoystickR");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView2, pkey.senVisualRJsX, pkey.senVisualRJsY, false, false, 12, null);
    }

    @Override // d8.a
    public void g() {
        a1 a1Var = this.f29077e;
        a1 a1Var2 = null;
        if (a1Var == null) {
            f0.S("viewBinding");
            a1Var = null;
        }
        a1Var.f53964c.k0();
        a1 a1Var3 = this.f29077e;
        if (a1Var3 == null) {
            f0.S("viewBinding");
        } else {
            a1Var2 = a1Var3;
        }
        a1Var2.f53965d.k0();
    }
}
