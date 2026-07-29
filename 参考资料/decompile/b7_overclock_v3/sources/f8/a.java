package f8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.r1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r1 f27997e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_singletouch_continue);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 1;
        cFGPropertyKey.sub_type = 1;
        r1 r1Var = this.f27997e;
        if (r1Var == null) {
            f0.S("viewBinding");
            r1Var = null;
        }
        cFGPropertyKey.click_times = r1Var.f54432c.getValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        r1 r1VarA = r1.a(view);
        f0.o(r1VarA, "bind(view)");
        this.f27997e = r1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        r1 r1Var = this.f27997e;
        if (r1Var == null) {
            f0.S("viewBinding");
            r1Var = null;
        }
        r1Var.f54432c.setValue(pkey.click_times);
    }

    @Override // d8.a
    public void g() {
        r1 r1Var = this.f27997e;
        if (r1Var == null) {
            f0.S("viewBinding");
            r1Var = null;
        }
        r1Var.f54432c.U();
    }
}
