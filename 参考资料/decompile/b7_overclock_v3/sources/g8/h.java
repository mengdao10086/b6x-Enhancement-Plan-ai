package g8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.b1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b1 f29078e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_fps_mouse_relation);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 4;
        b1 b1Var = this.f29078e;
        if (b1Var == null) {
            f0.S("viewBinding");
            b1Var = null;
        }
        Pair<Integer, Integer> value = b1Var.f53989c.getValue();
        cFGPropertyKey.senty_x = value.f().intValue();
        cFGPropertyKey.senty_y = value.h().intValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        b1 b1VarA = b1.a(view);
        f0.o(b1VarA, "bind(view)");
        this.f29078e = b1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        b1 b1Var = this.f29078e;
        if (b1Var == null) {
            f0.S("viewBinding");
            b1Var = null;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView = b1Var.f53989c;
        f0.o(floatViewTwoSeekBarView, "viewBinding.tsbMouseSens");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView, pkey.senty_x, pkey.senty_y, false, false, 12, null);
    }

    @Override // d8.a
    public void g() {
        b1 b1Var = this.f29078e;
        if (b1Var == null) {
            f0.S("viewBinding");
            b1Var = null;
        }
        b1Var.f53989c.k0();
    }
}
