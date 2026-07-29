package c8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import kotlin.jvm.internal.f0;
import o5.g;
import w7.p0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends b8.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p0 f10664f;

    public static final class a implements FloatViewKeySetView.a {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewKeySetView.a
        public void a() {
            d.this.m(2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@k Context context, @k GamepadInfo deviceInfo, @k CFGPropertyJS property) {
        super(context, deviceInfo, property, R.layout.floatview_property_joystick_fixed_move);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        f0.p(property, "property");
    }

    @Override // b8.a
    @k
    public CFGPropertyJS d() {
        CFGPropertyJS cFGPropertyJSC = c();
        cFGPropertyJSC.type = 11;
        p0 p0Var = this.f10664f;
        p0 p0Var2 = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        cFGPropertyJSC.radius = p0Var.f54373f.getValue();
        p0 p0Var3 = this.f10664f;
        if (p0Var3 == null) {
            f0.S("viewBinding");
            p0Var3 = null;
        }
        cFGPropertyJSC.start_delay = p0Var3.f54372e.getValue() * 5;
        p0 p0Var4 = this.f10664f;
        if (p0Var4 == null) {
            f0.S("viewBinding");
            p0Var4 = null;
        }
        cFGPropertyJSC.ban = g.g(p0Var4.f54374g.getValue(), 127L);
        p0 p0Var5 = this.f10664f;
        if (p0Var5 == null) {
            f0.S("viewBinding");
            p0Var5 = null;
        }
        cFGPropertyJSC.edge_dframe = p0Var5.f54371d.getValue();
        p0 p0Var6 = this.f10664f;
        if (p0Var6 == null) {
            f0.S("viewBinding");
        } else {
            p0Var2 = p0Var6;
        }
        cFGPropertyJSC.switchRKey = p0Var2.f54370c.getValue();
        return cFGPropertyJSC;
    }

    @Override // b8.a
    public void f(@k View view) {
        f0.p(view, "view");
        p0 p0VarA = p0.a(view);
        f0.o(p0VarA, "bind(view)");
        this.f10664f = p0VarA;
        p0 p0Var = null;
        if (c().key_id == 240) {
            p0 p0Var2 = this.f10664f;
            if (p0Var2 == null) {
                f0.S("viewBinding");
                p0Var2 = null;
            }
            FloatViewKeySetView floatViewKeySetView = p0Var2.f54370c;
            f0.o(floatViewKeySetView, "viewBinding.ksvChangeRadius");
            o5.c.b(floatViewKeySetView, Boolean.TRUE, false, 2, null);
        } else {
            p0 p0Var3 = this.f10664f;
            if (p0Var3 == null) {
                f0.S("viewBinding");
                p0Var3 = null;
            }
            FloatViewKeySetView floatViewKeySetView2 = p0Var3.f54370c;
            f0.o(floatViewKeySetView2, "viewBinding.ksvChangeRadius");
            o5.c.b(floatViewKeySetView2, Boolean.FALSE, false, 2, null);
        }
        p0 p0Var4 = this.f10664f;
        if (p0Var4 == null) {
            f0.S("viewBinding");
        } else {
            p0Var = p0Var4;
        }
        p0Var.f54370c.setOnButtonClickListener$float_view_officialRelease(new a());
    }

    @Override // b8.a
    public void g(@k CFGPropertyJS pkey) {
        f0.p(pkey, "pkey");
        k(pkey);
        p0 p0Var = this.f10664f;
        p0 p0Var2 = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        p0Var.f54373f.setValue(pkey.radius);
        p0 p0Var3 = this.f10664f;
        if (p0Var3 == null) {
            f0.S("viewBinding");
            p0Var3 = null;
        }
        p0Var3.f54372e.setValue(pkey.start_delay / 5);
        p0 p0Var4 = this.f10664f;
        if (p0Var4 == null) {
            f0.S("viewBinding");
            p0Var4 = null;
        }
        p0Var4.f54374g.setValue(g.f(pkey.ban, 127L));
        p0 p0Var5 = this.f10664f;
        if (p0Var5 == null) {
            f0.S("viewBinding");
            p0Var5 = null;
        }
        p0Var5.f54371d.setValue(pkey.edge_dframe);
        p0 p0Var6 = this.f10664f;
        if (p0Var6 == null) {
            f0.S("viewBinding");
        } else {
            p0Var2 = p0Var6;
        }
        p0Var2.f54370c.g(pkey.switchRKey, b());
    }

    @Override // b8.a
    public void h() {
        p0 p0Var = this.f10664f;
        p0 p0Var2 = null;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        p0Var.f54373f.U();
        p0 p0Var3 = this.f10664f;
        if (p0Var3 == null) {
            f0.S("viewBinding");
            p0Var3 = null;
        }
        p0Var3.f54372e.U();
        p0 p0Var4 = this.f10664f;
        if (p0Var4 == null) {
            f0.S("viewBinding");
            p0Var4 = null;
        }
        p0Var4.f54374g.U();
        p0 p0Var5 = this.f10664f;
        if (p0Var5 == null) {
            f0.S("viewBinding");
            p0Var5 = null;
        }
        p0Var5.f54371d.U();
        p0 p0Var6 = this.f10664f;
        if (p0Var6 == null) {
            f0.S("viewBinding");
        } else {
            p0Var2 = p0Var6;
        }
        p0Var2.f54370c.f();
    }

    public final void o(int i10) {
        p0 p0Var = this.f10664f;
        if (p0Var == null) {
            f0.S("viewBinding");
            p0Var = null;
        }
        p0Var.f54370c.g(i10, b());
    }
}
