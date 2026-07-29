package c8;

import android.content.Context;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import kotlin.jvm.internal.f0;
import w7.r0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends b8.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r0 f10662f;

    public static final class a implements FloatViewSingleSeekBarView.c {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleSeekBarView.c
        public void a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleSeekBarView.c
        public void b() {
            c cVar = c.this;
            String str = c.this.a().getString(R.string.floatview_radius_prevention) + c.this.a().getString(R.string.floatview_introduction);
            String string = c.this.a().getString(R.string.floatview_radius_prevention_desc);
            f0.o(string, "context.getString(R.stri…w_radius_prevention_desc)");
            cVar.l(str, string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@k Context context, @k GamepadInfo deviceInfo, @k CFGPropertyJS property) {
        super(context, deviceInfo, property, R.layout.floatview_property_joystick_mapkey);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        f0.p(property, "property");
    }

    @Override // b8.a
    @k
    public CFGPropertyJS d() {
        CFGPropertyJS cFGPropertyJSC = c();
        cFGPropertyJSC.type = 2;
        r0 r0Var = this.f10662f;
        r0 r0Var2 = null;
        if (r0Var == null) {
            f0.S("viewBinding");
            r0Var = null;
        }
        cFGPropertyJSC.ban = r0Var.f54428d.getValue() ? 1 : 0;
        r0 r0Var3 = this.f10662f;
        if (r0Var3 == null) {
            f0.S("viewBinding");
            r0Var3 = null;
        }
        cFGPropertyJSC.start_delay = r0Var3.f54429e.getValue();
        r0 r0Var4 = this.f10662f;
        if (r0Var4 == null) {
            f0.S("viewBinding");
        } else {
            r0Var2 = r0Var4;
        }
        cFGPropertyJSC.edge_dframe = r0Var2.f54427c.getValue() ? 1 : 0;
        return cFGPropertyJSC;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4  */
    @Override // b8.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(@yt.k android.view.View r11) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c8.c.f(android.view.View):void");
    }

    @Override // b8.a
    public void g(@k CFGPropertyJS pkey) {
        f0.p(pkey, "pkey");
        k(pkey);
        r0 r0Var = this.f10662f;
        r0 r0Var2 = null;
        if (r0Var == null) {
            f0.S("viewBinding");
            r0Var = null;
        }
        r0Var.f54428d.setValue(pkey.ban == 1);
        r0 r0Var3 = this.f10662f;
        if (r0Var3 == null) {
            f0.S("viewBinding");
            r0Var3 = null;
        }
        r0Var3.f54427c.setValue(pkey.edge_dframe == 1);
        r0 r0Var4 = this.f10662f;
        if (r0Var4 == null) {
            f0.S("viewBinding");
        } else {
            r0Var2 = r0Var4;
        }
        r0Var2.f54429e.setValue(pkey.start_delay);
    }

    @Override // b8.a
    public void h() {
        r0 r0Var = this.f10662f;
        r0 r0Var2 = null;
        if (r0Var == null) {
            f0.S("viewBinding");
            r0Var = null;
        }
        r0Var.f54428d.U();
        r0 r0Var3 = this.f10662f;
        if (r0Var3 == null) {
            f0.S("viewBinding");
            r0Var3 = null;
        }
        r0Var3.f54427c.U();
        r0 r0Var4 = this.f10662f;
        if (r0Var4 == null) {
            f0.S("viewBinding");
        } else {
            r0Var2 = r0Var4;
        }
        r0Var2.f54429e.U();
    }
}
