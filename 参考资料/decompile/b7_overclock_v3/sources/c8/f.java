package c8;

import android.content.Context;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.float_view.widget.FloatViewThreeCheckBoxView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.t0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends b8.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t0 f10669f;

    public static final class a implements FloatViewKeySetView.a {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewKeySetView.a
        public void a() {
            f.this.m(1);
        }
    }

    public static final class b implements FloatViewThreeCheckBoxView.a {
        public b() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewThreeCheckBoxView.a
        public void a(boolean z10) {
            f.this.r(true);
            t0 t0Var = f.this.f10669f;
            if (t0Var == null) {
                f0.S("viewBinding");
                t0Var = null;
            }
            FloatViewThreeCheckBoxView floatViewThreeCheckBoxView = t0Var.f54467g;
            String string = f.this.a().getString(R.string.floatview_property_joystick_keyboard_move_trigger_by, f.this.a().getString(R.string.floatview_property_joystick_keyboard_control_way_wasd));
            f0.o(string, "context.getString(\n     …                        )");
            floatViewThreeCheckBoxView.x(string);
        }

        @Override // com.flydigi.float_view.widget.FloatViewThreeCheckBoxView.a
        public void b(boolean z10) {
            f.this.r(true);
            t0 t0Var = f.this.f10669f;
            if (t0Var == null) {
                f0.S("viewBinding");
                t0Var = null;
            }
            FloatViewThreeCheckBoxView floatViewThreeCheckBoxView = t0Var.f54467g;
            String string = f.this.a().getString(R.string.floatview_property_joystick_keyboard_move_trigger_by, f.this.a().getString(R.string.floatview_property_joystick_keyboard_control_way_wasd_direction));
            f0.o(string, "context.getString(\n     …                        )");
            floatViewThreeCheckBoxView.x(string);
        }

        @Override // com.flydigi.float_view.widget.FloatViewThreeCheckBoxView.a
        public void c(boolean z10) {
            f.this.r(false);
            t0 t0Var = f.this.f10669f;
            if (t0Var == null) {
                f0.S("viewBinding");
                t0Var = null;
            }
            FloatViewThreeCheckBoxView floatViewThreeCheckBoxView = t0Var.f54467g;
            String string = f.this.a().getString(R.string.floatview_property_joystick_keyboard_move_trigger_by, f.this.a().getString(R.string.floatview_property_joystick_keyboard_control_way_right_mouse));
            f0.o(string, "context.getString(\n     …                        )");
            floatViewThreeCheckBoxView.x(string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@k Context context, @k GamepadInfo deviceInfo, @k CFGPropertyJS property) {
        super(context, deviceInfo, property, R.layout.floatview_property_joystick_move_keyboard);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        f0.p(property, "property");
    }

    @Override // b8.a
    @k
    public CFGPropertyJS d() {
        CFGPropertyJS cFGPropertyJSC = c();
        cFGPropertyJSC.type = 1;
        t0 t0Var = this.f10669f;
        t0 t0Var2 = null;
        if (t0Var == null) {
            f0.S("viewBinding");
            t0Var = null;
        }
        cFGPropertyJSC.radius = t0Var.f54465e.getValue();
        t0 t0Var3 = this.f10669f;
        if (t0Var3 == null) {
            f0.S("viewBinding");
            t0Var3 = null;
        }
        cFGPropertyJSC.start_delay = t0Var3.f54464d.getValue() * 5;
        t0 t0Var4 = this.f10669f;
        if (t0Var4 == null) {
            f0.S("viewBinding");
            t0Var4 = null;
        }
        cFGPropertyJSC.switchRKey = t0Var4.f54463c.getValue();
        t0 t0Var5 = this.f10669f;
        if (t0Var5 == null) {
            f0.S("viewBinding");
            t0Var5 = null;
        }
        Pair<Boolean, Boolean> value = t0Var5.f54466f.getValue();
        cFGPropertyJSC.ban = value.f().booleanValue() ? 127 : 0;
        cFGPropertyJSC.edge_dframe = value.h().booleanValue() ? 127 : 0;
        t0 t0Var6 = this.f10669f;
        if (t0Var6 == null) {
            f0.S("viewBinding");
        } else {
            t0Var2 = t0Var6;
        }
        Boolean[] value2 = t0Var2.f54467g.getValue();
        cFGPropertyJSC.js_mode = value2[1].booleanValue() ? 1 : value2[2].booleanValue() ? 2 : 0;
        return cFGPropertyJSC;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c4  */
    @Override // b8.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(@yt.k android.view.View r7) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c8.f.f(android.view.View):void");
    }

    @Override // b8.a
    public void g(@k CFGPropertyJS pkey) {
        f0.p(pkey, "pkey");
        k(pkey);
        t0 t0Var = this.f10669f;
        t0 t0Var2 = null;
        if (t0Var == null) {
            f0.S("viewBinding");
            t0Var = null;
        }
        t0Var.f54465e.setValue(pkey.radius);
        t0 t0Var3 = this.f10669f;
        if (t0Var3 == null) {
            f0.S("viewBinding");
            t0Var3 = null;
        }
        t0Var3.f54464d.setValue(pkey.start_delay / 5);
        t0 t0Var4 = this.f10669f;
        if (t0Var4 == null) {
            f0.S("viewBinding");
            t0Var4 = null;
        }
        t0Var4.f54463c.g(pkey.switchRKey, b());
        t0 t0Var5 = this.f10669f;
        if (t0Var5 == null) {
            f0.S("viewBinding");
            t0Var5 = null;
        }
        t0Var5.f54466f.q(pkey.ban == 127, pkey.edge_dframe == 127);
        int i10 = pkey.js_mode;
        if (i10 == 1) {
            r(true);
            t0 t0Var6 = this.f10669f;
            if (t0Var6 == null) {
                f0.S("viewBinding");
                t0Var6 = null;
            }
            t0Var6.f54467g.w(false, true, false);
            t0 t0Var7 = this.f10669f;
            if (t0Var7 == null) {
                f0.S("viewBinding");
            } else {
                t0Var2 = t0Var7;
            }
            FloatViewThreeCheckBoxView floatViewThreeCheckBoxView = t0Var2.f54467g;
            String string = a().getString(R.string.floatview_property_joystick_keyboard_move_trigger_by, a().getString(R.string.floatview_property_joystick_keyboard_control_way_wasd_direction));
            f0.o(string, "context.getString(\n     …on)\n                    )");
            floatViewThreeCheckBoxView.x(string);
            return;
        }
        if (i10 != 2) {
            r(true);
            t0 t0Var8 = this.f10669f;
            if (t0Var8 == null) {
                f0.S("viewBinding");
                t0Var8 = null;
            }
            t0Var8.f54467g.w(true, false, false);
            t0 t0Var9 = this.f10669f;
            if (t0Var9 == null) {
                f0.S("viewBinding");
            } else {
                t0Var2 = t0Var9;
            }
            FloatViewThreeCheckBoxView floatViewThreeCheckBoxView2 = t0Var2.f54467g;
            String string2 = a().getString(R.string.floatview_property_joystick_keyboard_move_trigger_by, a().getString(R.string.floatview_property_joystick_keyboard_control_way_wasd));
            f0.o(string2, "context.getString(\n     …sd)\n                    )");
            floatViewThreeCheckBoxView2.x(string2);
            return;
        }
        String firmwareVersion = b().getFirmwareVersion();
        f0.m(firmwareVersion);
        Objects.requireNonNull(firmwareVersion);
        f0.o(firmwareVersion, "requireNonNull(deviceInfo.firmwareVersion!!)");
        if (l9.c.b(m9.k.f40829o, firmwareVersion)) {
            r(false);
            t0 t0Var10 = this.f10669f;
            if (t0Var10 == null) {
                f0.S("viewBinding");
                t0Var10 = null;
            }
            t0Var10.f54467g.w(false, false, true);
            t0 t0Var11 = this.f10669f;
            if (t0Var11 == null) {
                f0.S("viewBinding");
            } else {
                t0Var2 = t0Var11;
            }
            FloatViewThreeCheckBoxView floatViewThreeCheckBoxView3 = t0Var2.f54467g;
            String string3 = a().getString(R.string.floatview_property_joystick_keyboard_move_trigger_by, a().getString(R.string.floatview_property_joystick_keyboard_control_way_right_mouse));
            f0.o(string3, "context.getString(\n     …se)\n                    )");
            floatViewThreeCheckBoxView3.x(string3);
            return;
        }
        r(true);
        t0 t0Var12 = this.f10669f;
        if (t0Var12 == null) {
            f0.S("viewBinding");
            t0Var12 = null;
        }
        t0Var12.f54467g.w(true, false, false);
        t0 t0Var13 = this.f10669f;
        if (t0Var13 == null) {
            f0.S("viewBinding");
        } else {
            t0Var2 = t0Var13;
        }
        FloatViewThreeCheckBoxView floatViewThreeCheckBoxView4 = t0Var2.f54467g;
        String string4 = a().getString(R.string.floatview_property_joystick_keyboard_move_trigger_by, a().getString(R.string.floatview_property_joystick_keyboard_control_way_wasd));
        f0.o(string4, "context.getString(\n     …sd)\n                    )");
        floatViewThreeCheckBoxView4.x(string4);
    }

    @Override // b8.a
    public void h() {
        t0 t0Var = this.f10669f;
        t0 t0Var2 = null;
        if (t0Var == null) {
            f0.S("viewBinding");
            t0Var = null;
        }
        t0Var.f54465e.U();
        t0 t0Var3 = this.f10669f;
        if (t0Var3 == null) {
            f0.S("viewBinding");
            t0Var3 = null;
        }
        t0Var3.f54464d.U();
        t0 t0Var4 = this.f10669f;
        if (t0Var4 == null) {
            f0.S("viewBinding");
            t0Var4 = null;
        }
        t0Var4.f54463c.f();
        t0 t0Var5 = this.f10669f;
        if (t0Var5 == null) {
            f0.S("viewBinding");
            t0Var5 = null;
        }
        t0Var5.f54466f.o();
        t0 t0Var6 = this.f10669f;
        if (t0Var6 == null) {
            f0.S("viewBinding");
        } else {
            t0Var2 = t0Var6;
        }
        t0Var2.f54467g.u();
    }

    public final void q(int i10) {
        t0 t0Var = this.f10669f;
        if (t0Var == null) {
            f0.S("viewBinding");
            t0Var = null;
        }
        t0Var.f54463c.g(i10, b());
    }

    public final void r(boolean z10) {
        t0 t0Var = this.f10669f;
        if (t0Var == null) {
            f0.S("viewBinding");
            t0Var = null;
        }
        t0Var.f54466f.setVisibility(z10 ? 0 : 8);
    }
}
