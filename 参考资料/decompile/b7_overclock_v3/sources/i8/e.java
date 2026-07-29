package i8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.a2;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a2 f31895e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_right_down);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 2;
        a2 a2Var = this.f31895e;
        a2 a2Var2 = null;
        if (a2Var == null) {
            f0.S("viewBinding");
            a2Var = null;
        }
        cFGPropertyKey.range = a2Var.f53968c.getValue();
        a2 a2Var3 = this.f31895e;
        if (a2Var3 == null) {
            f0.S("viewBinding");
        } else {
            a2Var2 = a2Var3;
        }
        cFGPropertyKey.duration = a2Var2.f53969d.getValue() * 5;
        cFGPropertyKey.angle = 135;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        a2 a2VarA = a2.a(view);
        f0.o(a2VarA, "bind(view)");
        this.f31895e = a2VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        a2 a2Var = this.f31895e;
        a2 a2Var2 = null;
        if (a2Var == null) {
            f0.S("viewBinding");
            a2Var = null;
        }
        a2Var.f53968c.setValue(pkey.range);
        a2 a2Var3 = this.f31895e;
        if (a2Var3 == null) {
            f0.S("viewBinding");
        } else {
            a2Var2 = a2Var3;
        }
        a2Var2.f53969d.setValue(pkey.duration / 5);
    }

    @Override // d8.a
    public void g() {
        a2 a2Var = this.f31895e;
        a2 a2Var2 = null;
        if (a2Var == null) {
            f0.S("viewBinding");
            a2Var = null;
        }
        a2Var.f53968c.U();
        a2 a2Var3 = this.f31895e;
        if (a2Var3 == null) {
            f0.S("viewBinding");
        } else {
            a2Var2 = a2Var3;
        }
        a2Var2.f53969d.U();
    }
}
