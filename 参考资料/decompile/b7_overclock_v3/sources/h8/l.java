package h8;

import android.content.Context;
import android.view.View;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import w7.p1;

/* JADX INFO: loaded from: classes7.dex */
public final class l extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p1 f30710e;

    public static final class a implements FloatViewSingleSeekBarView.c {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleSeekBarView.c
        public void a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleSeekBarView.c
        public void b() {
            l lVar = l.this;
            String str = l.this.a().getString(R.string.floatview_radius_prevention) + l.this.a().getString(R.string.floatview_introduction);
            String string = l.this.a().getString(R.string.floatview_radius_prevention_desc);
            f0.o(string, "context.getString(R.stri…w_radius_prevention_desc)");
            lVar.j(str, string);
        }
    }

    public static final class b implements FloatViewKeySetView.a {
        public b() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewKeySetView.a
        public void a() {
            l.this.k(1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_wheel_joystick_relation);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    public static final void o(l this$0, View view) {
        f0.p(this$0, "this$0");
        String str = this$0.a().getString(R.string.floatview_radius_changed) + this$0.a().getString(R.string.floatview_introduction);
        String string = this$0.a().getString(R.string.floatview_radius_change_radius_desc);
        f0.o(string, "context.getString(R.stri…adius_change_radius_desc)");
        this$0.j(str, string);
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 24;
        p1 p1Var = this.f30710e;
        p1 p1Var2 = null;
        if (p1Var == null) {
            f0.S("viewBinding");
            p1Var = null;
        }
        cFGPropertyKey.radius = p1Var.f54381g.getValue();
        p1 p1Var3 = this.f30710e;
        if (p1Var3 == null) {
            f0.S("viewBinding");
            p1Var3 = null;
        }
        cFGPropertyKey.ban = p1Var3.f54382h.getValue();
        p1 p1Var4 = this.f30710e;
        if (p1Var4 == null) {
            f0.S("viewBinding");
            p1Var4 = null;
        }
        cFGPropertyKey.radius_change = o5.g.g(p1Var4.f54380f.getValue(), 255L);
        p1 p1Var5 = this.f30710e;
        if (p1Var5 == null) {
            f0.S("viewBinding");
            p1Var5 = null;
        }
        cFGPropertyKey.js_link = p1Var5.f54379e.getValue() ? 2 : 0;
        p1 p1Var6 = this.f30710e;
        if (p1Var6 == null) {
            f0.S("viewBinding");
        } else {
            p1Var2 = p1Var6;
        }
        cFGPropertyKey.switchRKey = p1Var2.f54378d.getValue();
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        p1 p1VarA = p1.a(view);
        f0.o(p1VarA, "bind(view)");
        this.f30710e = p1VarA;
        p1 p1Var = null;
        if (p1VarA == null) {
            f0.S("viewBinding");
            p1VarA = null;
        }
        p1VarA.f54382h.setOnHelpClickListener$float_view_officialRelease(new a());
        p1 p1Var2 = this.f30710e;
        if (p1Var2 == null) {
            f0.S("viewBinding");
            p1Var2 = null;
        }
        o.r(p1Var2.f54377c, new View.OnClickListener() { // from class: h8.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                l.o(this.f30709a, view2);
            }
        });
        p1 p1Var3 = this.f30710e;
        if (p1Var3 == null) {
            f0.S("viewBinding");
        } else {
            p1Var = p1Var3;
        }
        p1Var.f54378d.setOnButtonClickListener$float_view_officialRelease(new b());
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        p1 p1Var = this.f30710e;
        p1 p1Var2 = null;
        if (p1Var == null) {
            f0.S("viewBinding");
            p1Var = null;
        }
        p1Var.f54381g.setValue(pkey.radius);
        p1 p1Var3 = this.f30710e;
        if (p1Var3 == null) {
            f0.S("viewBinding");
            p1Var3 = null;
        }
        p1Var3.f54382h.setValue(pkey.ban);
        p1 p1Var4 = this.f30710e;
        if (p1Var4 == null) {
            f0.S("viewBinding");
            p1Var4 = null;
        }
        p1Var4.f54380f.setValue(o5.g.f(pkey.radius_change, 255L));
        p1 p1Var5 = this.f30710e;
        if (p1Var5 == null) {
            f0.S("viewBinding");
            p1Var5 = null;
        }
        p1Var5.f54379e.setValue(pkey.js_link == 2);
        p1 p1Var6 = this.f30710e;
        if (p1Var6 == null) {
            f0.S("viewBinding");
        } else {
            p1Var2 = p1Var6;
        }
        p1Var2.f54378d.g(pkey.switchRKey, b());
    }

    @Override // d8.a
    public void g() {
        p1 p1Var = this.f30710e;
        p1 p1Var2 = null;
        if (p1Var == null) {
            f0.S("viewBinding");
            p1Var = null;
        }
        p1Var.f54381g.U();
        p1 p1Var3 = this.f30710e;
        if (p1Var3 == null) {
            f0.S("viewBinding");
            p1Var3 = null;
        }
        p1Var3.f54382h.U();
        p1 p1Var4 = this.f30710e;
        if (p1Var4 == null) {
            f0.S("viewBinding");
            p1Var4 = null;
        }
        p1Var4.f54380f.U();
        p1 p1Var5 = this.f30710e;
        if (p1Var5 == null) {
            f0.S("viewBinding");
            p1Var5 = null;
        }
        p1Var5.f54379e.U();
        p1 p1Var6 = this.f30710e;
        if (p1Var6 == null) {
            f0.S("viewBinding");
        } else {
            p1Var2 = p1Var6;
        }
        p1Var2.f54378d.f();
    }

    public final void p(int i10) {
        p1 p1Var = this.f30710e;
        if (p1Var == null) {
            f0.S("viewBinding");
            p1Var = null;
        }
        p1Var.f54378d.g(i10, b());
    }
}
