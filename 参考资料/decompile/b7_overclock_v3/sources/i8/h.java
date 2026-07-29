package i8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.c2;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c2 f31898e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_slide_up);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 2;
        c2 c2Var = this.f31898e;
        c2 c2Var2 = null;
        if (c2Var == null) {
            f0.S("viewBinding");
            c2Var = null;
        }
        cFGPropertyKey.range = c2Var.f54013c.getValue();
        c2 c2Var3 = this.f31898e;
        if (c2Var3 == null) {
            f0.S("viewBinding");
        } else {
            c2Var2 = c2Var3;
        }
        cFGPropertyKey.duration = c2Var2.f54014d.getValue() * 5;
        cFGPropertyKey.angle = 0;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        c2 c2VarA = c2.a(view);
        f0.o(c2VarA, "bind(view)");
        this.f31898e = c2VarA;
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        c2 c2Var = this.f31898e;
        c2 c2Var2 = null;
        if (c2Var == null) {
            f0.S("viewBinding");
            c2Var = null;
        }
        c2Var.f54013c.setValue(pkey.range);
        c2 c2Var3 = this.f31898e;
        if (c2Var3 == null) {
            f0.S("viewBinding");
        } else {
            c2Var2 = c2Var3;
        }
        c2Var2.f54014d.setValue(pkey.duration / 5);
    }

    @Override // d8.a
    public void g() {
        c2 c2Var = this.f31898e;
        c2 c2Var2 = null;
        if (c2Var == null) {
            f0.S("viewBinding");
            c2Var = null;
        }
        c2Var.f54013c.U();
        c2 c2Var3 = this.f31898e;
        if (c2Var3 == null) {
            f0.S("viewBinding");
        } else {
            c2Var2 = c2Var3;
        }
        c2Var2.f54014d.U();
    }
}
