package h8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.g1;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g1 f30701e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_extend_view);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 21;
        g1 g1Var = this.f30701e;
        if (g1Var == null) {
            f0.S("viewBinding");
            g1Var = null;
        }
        cFGPropertyKey.radius = g1Var.f54117c.getValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        g1 g1VarA = g1.a(view);
        f0.o(g1VarA, "bind(view)");
        this.f30701e = g1VarA;
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        g1 g1Var = this.f30701e;
        if (g1Var == null) {
            f0.S("viewBinding");
            g1Var = null;
        }
        g1Var.f54117c.setValue(pkey.radius);
    }

    @Override // d8.a
    public void g() {
        g1 g1Var = this.f30701e;
        if (g1Var == null) {
            f0.S("viewBinding");
            g1Var = null;
        }
        g1Var.f54117c.U();
    }
}
