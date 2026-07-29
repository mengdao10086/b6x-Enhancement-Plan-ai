package i8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.v1;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v1 f31891e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_down);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 2;
        v1 v1Var = this.f31891e;
        v1 v1Var2 = null;
        if (v1Var == null) {
            f0.S("viewBinding");
            v1Var = null;
        }
        cFGPropertyKey.range = v1Var.f54499c.getValue();
        v1 v1Var3 = this.f31891e;
        if (v1Var3 == null) {
            f0.S("viewBinding");
        } else {
            v1Var2 = v1Var3;
        }
        cFGPropertyKey.duration = v1Var2.f54500d.getValue() * 5;
        cFGPropertyKey.angle = 180;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        v1 v1VarA = v1.a(view);
        f0.o(v1VarA, "bind(view)");
        this.f31891e = v1VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        v1 v1Var = this.f31891e;
        v1 v1Var2 = null;
        if (v1Var == null) {
            f0.S("viewBinding");
            v1Var = null;
        }
        v1Var.f54499c.setValue(pkey.range);
        v1 v1Var3 = this.f31891e;
        if (v1Var3 == null) {
            f0.S("viewBinding");
        } else {
            v1Var2 = v1Var3;
        }
        v1Var2.f54500d.setValue(pkey.duration / 5);
    }

    @Override // d8.a
    public void g() {
        v1 v1Var = this.f31891e;
        v1 v1Var2 = null;
        if (v1Var == null) {
            f0.S("viewBinding");
            v1Var = null;
        }
        v1Var.f54499c.U();
        v1 v1Var3 = this.f31891e;
        if (v1Var3 == null) {
            f0.S("viewBinding");
        } else {
            v1Var2 = v1Var3;
        }
        v1Var2.f54500d.U();
    }
}
