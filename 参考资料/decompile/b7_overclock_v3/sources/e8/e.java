package e8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.q1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q1 f26737e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_mouse);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 3;
        q1 q1Var = this.f26737e;
        q1 q1Var2 = null;
        if (q1Var == null) {
            f0.S("viewBinding");
            q1Var = null;
        }
        cFGPropertyKey.senty_x = q1Var.f54405c.getValue().f().intValue();
        q1 q1Var3 = this.f26737e;
        if (q1Var3 == null) {
            f0.S("viewBinding");
        } else {
            q1Var2 = q1Var3;
        }
        cFGPropertyKey.senty_y = q1Var2.f54405c.getValue().h().intValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        q1 q1VarA = q1.a(view);
        f0.o(q1VarA, "bind(view)");
        this.f26737e = q1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        q1 q1Var = this.f26737e;
        if (q1Var == null) {
            f0.S("viewBinding");
            q1Var = null;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView = q1Var.f54405c;
        f0.o(floatViewTwoSeekBarView, "viewBinding.tsbMouse");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView, pkey.senty_x, pkey.senty_y, false, false, 12, null);
    }

    @Override // d8.a
    public void g() {
        q1 q1Var = this.f26737e;
        if (q1Var == null) {
            f0.S("viewBinding");
            q1Var = null;
        }
        q1Var.f54405c.k0();
    }
}
