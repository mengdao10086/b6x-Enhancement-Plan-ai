package h8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.k1;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k1 f30703e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_look_map);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        k1 k1Var = this.f30703e;
        k1 k1Var2 = null;
        if (k1Var == null) {
            f0.S("viewBinding");
            k1Var = null;
        }
        if (k1Var.f54225d.getValue().h().booleanValue() && b().isSupportLunpan()) {
            cFGPropertyKey.type = 25;
        } else {
            cFGPropertyKey.type = 8;
        }
        k1 k1Var3 = this.f30703e;
        if (k1Var3 == null) {
            f0.S("viewBinding");
        } else {
            k1Var2 = k1Var3;
        }
        cFGPropertyKey.radius = k1Var2.f54224c.getValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        k1 k1VarA = k1.a(view);
        f0.o(k1VarA, "bind(view)");
        this.f30703e = k1VarA;
        boolean zIsSupportLunpan = deviceInfo.isSupportLunpan();
        k1 k1Var = null;
        if (zIsSupportLunpan) {
            k1 k1Var2 = this.f30703e;
            if (k1Var2 == null) {
                f0.S("viewBinding");
            } else {
                k1Var = k1Var2;
            }
            k1Var.f54225d.p(true, true);
            return;
        }
        k1 k1Var3 = this.f30703e;
        if (k1Var3 == null) {
            f0.S("viewBinding");
        } else {
            k1Var = k1Var3;
        }
        k1Var.f54225d.p(true, false);
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        k1 k1Var = this.f30703e;
        k1 k1Var2 = null;
        if (k1Var == null) {
            f0.S("viewBinding");
            k1Var = null;
        }
        k1Var.f54224c.setValue(pkey.radius);
        k1 k1Var3 = this.f30703e;
        if (k1Var3 == null) {
            f0.S("viewBinding");
        } else {
            k1Var2 = k1Var3;
        }
        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = k1Var2.f54225d;
        int i10 = pkey.type;
        floatViewTwoCheckBoxView.q(i10 == 8, i10 == 25);
    }

    @Override // d8.a
    public void g() {
        k1 k1Var = this.f30703e;
        k1 k1Var2 = null;
        if (k1Var == null) {
            f0.S("viewBinding");
            k1Var = null;
        }
        k1Var.f54224c.U();
        k1 k1Var3 = this.f30703e;
        if (k1Var3 == null) {
            f0.S("viewBinding");
        } else {
            k1Var2 = k1Var3;
        }
        k1Var2.f54225d.o();
    }
}
