package h8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.i1;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i1 f30702e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_left_joystick_relation);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 5;
        i1 i1Var = this.f30702e;
        i1 i1Var2 = null;
        if (i1Var == null) {
            f0.S("viewBinding");
            i1Var = null;
        }
        cFGPropertyKey.radius = i1Var.f54154c.getValue();
        i1 i1Var3 = this.f30702e;
        if (i1Var3 == null) {
            f0.S("viewBinding");
        } else {
            i1Var2 = i1Var3;
        }
        Pair<Boolean, Boolean> value = i1Var2.f54155d.getValue();
        cFGPropertyKey.js_link = (value.f().booleanValue() ? 4 : 0) + (value.h().booleanValue() ? 2 : 0);
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        i1 i1VarA = i1.a(view);
        f0.o(i1VarA, "bind(view)");
        this.f30702e = i1VarA;
        i1 i1Var = null;
        if (deviceInfo.isGamepadKeyboard()) {
            i1 i1Var2 = this.f30702e;
            if (i1Var2 == null) {
                f0.S("viewBinding");
                i1Var2 = null;
            }
            i1Var2.f54153b.a(R.string.floatview_property_key_left_joystick_relation_for_keyboard);
        } else {
            i1 i1Var3 = this.f30702e;
            if (i1Var3 == null) {
                f0.S("viewBinding");
                i1Var3 = null;
            }
            i1Var3.f54153b.a(R.string.floatview_property_key_moba_left_joystick_relation_desc);
        }
        if (o9.e.a(deviceInfo, m9.k.f40821g)) {
            i1 i1Var4 = this.f30702e;
            if (i1Var4 == null) {
                f0.S("viewBinding");
            } else {
                i1Var = i1Var4;
            }
            i1Var.f54155d.p(true, true);
            return;
        }
        i1 i1Var5 = this.f30702e;
        if (i1Var5 == null) {
            f0.S("viewBinding");
        } else {
            i1Var = i1Var5;
        }
        i1Var.f54155d.p(false, true);
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        i1 i1Var = this.f30702e;
        i1 i1Var2 = null;
        if (i1Var == null) {
            f0.S("viewBinding");
            i1Var = null;
        }
        i1Var.f54154c.setValue(pkey.radius);
        int i10 = pkey.js_link;
        if (i10 == 2) {
            i1 i1Var3 = this.f30702e;
            if (i1Var3 == null) {
                f0.S("viewBinding");
            } else {
                i1Var2 = i1Var3;
            }
            i1Var2.f54155d.q(false, true);
            return;
        }
        if (i10 == 4) {
            i1 i1Var4 = this.f30702e;
            if (i1Var4 == null) {
                f0.S("viewBinding");
            } else {
                i1Var2 = i1Var4;
            }
            i1Var2.f54155d.q(true, false);
            return;
        }
        if (i10 != 6) {
            return;
        }
        i1 i1Var5 = this.f30702e;
        if (i1Var5 == null) {
            f0.S("viewBinding");
        } else {
            i1Var2 = i1Var5;
        }
        i1Var2.f54155d.q(true, true);
    }

    @Override // d8.a
    public void g() {
        i1 i1Var = this.f30702e;
        i1 i1Var2 = null;
        if (i1Var == null) {
            f0.S("viewBinding");
            i1Var = null;
        }
        i1Var.f54154c.U();
        i1 i1Var3 = this.f30702e;
        if (i1Var3 == null) {
            f0.S("viewBinding");
        } else {
            i1Var2 = i1Var3;
        }
        i1Var2.f54155d.q(false, false);
    }
}
