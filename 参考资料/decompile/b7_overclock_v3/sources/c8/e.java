package c8;

import android.content.Context;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import kotlin.jvm.internal.f0;
import o5.g;
import w7.s0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends b8.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s0 f10666f;

    public static final class a implements FloatViewKeySetView.a {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewKeySetView.a
        public void a() {
            e.this.m(3);
        }
    }

    public static final class b implements FloatViewKeySetView.a {
        public b() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewKeySetView.a
        public void a() {
            e.this.m(1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@k Context context, @k GamepadInfo deviceInfo, @k CFGPropertyJS property) {
        super(context, deviceInfo, property, R.layout.floatview_property_joystick_move);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
        f0.p(property, "property");
    }

    @Override // b8.a
    @k
    public CFGPropertyJS d() {
        CFGPropertyJS cFGPropertyJSC = c();
        cFGPropertyJSC.type = 1;
        s0 s0Var = this.f10666f;
        s0 s0Var2 = null;
        if (s0Var == null) {
            f0.S("viewBinding");
            s0Var = null;
        }
        cFGPropertyJSC.radius = s0Var.f54449f.getValue();
        s0 s0Var3 = this.f10666f;
        if (s0Var3 == null) {
            f0.S("viewBinding");
            s0Var3 = null;
        }
        cFGPropertyJSC.start_delay = s0Var3.f54448e.getValue() * 5;
        s0 s0Var4 = this.f10666f;
        if (s0Var4 == null) {
            f0.S("viewBinding");
            s0Var4 = null;
        }
        cFGPropertyJSC.ban = g.g(s0Var4.f54450g.getValue(), 127L);
        s0 s0Var5 = this.f10666f;
        if (s0Var5 == null) {
            f0.S("viewBinding");
            s0Var5 = null;
        }
        cFGPropertyJSC.double_click_key = s0Var5.f54447d.getValue();
        s0 s0Var6 = this.f10666f;
        if (s0Var6 == null) {
            f0.S("viewBinding");
        } else {
            s0Var2 = s0Var6;
        }
        cFGPropertyJSC.switchRKey = s0Var2.f54446c.getValue();
        cFGPropertyJSC.edge_dframe = 0;
        return cFGPropertyJSC;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    @Override // b8.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(@yt.k android.view.View r8) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.f0.p(r8, r0)
            w7.s0 r8 = w7.s0.a(r8)
            java.lang.String r0 = "bind(view)"
            kotlin.jvm.internal.f0.o(r8, r0)
            r7.f10666f = r8
            com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS r8 = r7.c()
            int r8 = r8.key_id
            r0 = 2
            java.lang.String r1 = "viewBinding.ksvDoubleClick"
            r2 = 240(0xf0, float:3.36E-43)
            r3 = 0
            java.lang.String r4 = "viewBinding"
            r5 = 0
            if (r8 != r2) goto L51
            com.flydigi.sdk.gamepad.GamepadInfo r8 = r7.b()
            boolean r8 = r8.isDriverConnected()
            if (r8 != 0) goto L3e
            com.flydigi.sdk.gamepad.GamepadInfo r8 = r7.b()
            java.lang.String r8 = r8.getFirmwareVersion()
            kotlin.jvm.internal.f0.m(r8)
            java.lang.String r6 = "5.9.3.0"
            boolean r8 = l9.c.b(r6, r8)
            if (r8 == 0) goto L51
        L3e:
            w7.s0 r8 = r7.f10666f
            if (r8 != 0) goto L46
            kotlin.jvm.internal.f0.S(r4)
            r8 = r5
        L46:
            com.flydigi.float_view.widget.FloatViewKeySetView r8 = r8.f54447d
            kotlin.jvm.internal.f0.o(r8, r1)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            o5.c.b(r8, r1, r3, r0, r5)
            goto L63
        L51:
            w7.s0 r8 = r7.f10666f
            if (r8 != 0) goto L59
            kotlin.jvm.internal.f0.S(r4)
            r8 = r5
        L59:
            com.flydigi.float_view.widget.FloatViewKeySetView r8 = r8.f54447d
            kotlin.jvm.internal.f0.o(r8, r1)
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            o5.c.b(r8, r1, r3, r0, r5)
        L63:
            w7.s0 r8 = r7.f10666f
            if (r8 != 0) goto L6b
            kotlin.jvm.internal.f0.S(r4)
            r8 = r5
        L6b:
            com.flydigi.float_view.widget.FloatViewKeySetView r8 = r8.f54446c
            com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS r0 = r7.c()
            int r0 = r0.key_id
            if (r0 != r2) goto L76
            goto L78
        L76:
            r3 = 8
        L78:
            r8.setVisibility(r3)
            w7.s0 r8 = r7.f10666f
            if (r8 != 0) goto L83
            kotlin.jvm.internal.f0.S(r4)
            r8 = r5
        L83:
            com.flydigi.float_view.widget.FloatViewKeySetView r8 = r8.f54447d
            c8.e$a r0 = new c8.e$a
            r0.<init>()
            r8.setOnButtonClickListener$float_view_officialRelease(r0)
            w7.s0 r8 = r7.f10666f
            if (r8 != 0) goto L95
            kotlin.jvm.internal.f0.S(r4)
            goto L96
        L95:
            r5 = r8
        L96:
            com.flydigi.float_view.widget.FloatViewKeySetView r8 = r5.f54446c
            c8.e$b r0 = new c8.e$b
            r0.<init>()
            r8.setOnButtonClickListener$float_view_officialRelease(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c8.e.f(android.view.View):void");
    }

    @Override // b8.a
    public void g(@k CFGPropertyJS pkey) {
        f0.p(pkey, "pkey");
        k(pkey);
        s0 s0Var = this.f10666f;
        s0 s0Var2 = null;
        if (s0Var == null) {
            f0.S("viewBinding");
            s0Var = null;
        }
        s0Var.f54449f.setValue(pkey.radius);
        s0 s0Var3 = this.f10666f;
        if (s0Var3 == null) {
            f0.S("viewBinding");
            s0Var3 = null;
        }
        s0Var3.f54448e.setValue(pkey.start_delay / 5);
        s0 s0Var4 = this.f10666f;
        if (s0Var4 == null) {
            f0.S("viewBinding");
            s0Var4 = null;
        }
        s0Var4.f54450g.setValue(g.f(pkey.ban, 127L));
        s0 s0Var5 = this.f10666f;
        if (s0Var5 == null) {
            f0.S("viewBinding");
            s0Var5 = null;
        }
        s0Var5.f54447d.g(pkey.double_click_key, b());
        s0 s0Var6 = this.f10666f;
        if (s0Var6 == null) {
            f0.S("viewBinding");
        } else {
            s0Var2 = s0Var6;
        }
        s0Var2.f54446c.g(pkey.switchRKey, b());
    }

    @Override // b8.a
    public void h() {
        s0 s0Var = this.f10666f;
        s0 s0Var2 = null;
        if (s0Var == null) {
            f0.S("viewBinding");
            s0Var = null;
        }
        s0Var.f54449f.U();
        s0 s0Var3 = this.f10666f;
        if (s0Var3 == null) {
            f0.S("viewBinding");
            s0Var3 = null;
        }
        s0Var3.f54448e.U();
        s0 s0Var4 = this.f10666f;
        if (s0Var4 == null) {
            f0.S("viewBinding");
            s0Var4 = null;
        }
        s0Var4.f54450g.U();
        s0 s0Var5 = this.f10666f;
        if (s0Var5 == null) {
            f0.S("viewBinding");
            s0Var5 = null;
        }
        s0Var5.f54447d.f();
        s0 s0Var6 = this.f10666f;
        if (s0Var6 == null) {
            f0.S("viewBinding");
        } else {
            s0Var2 = s0Var6;
        }
        s0Var2.f54446c.f();
    }

    public final void o(int i10) {
        s0 s0Var = this.f10666f;
        s0 s0Var2 = null;
        if (s0Var == null) {
            f0.S("viewBinding");
            s0Var = null;
        }
        if (i10 == s0Var.f54447d.getValue()) {
            n8.b.m(a(), a().getString(R.string.floatview_double_click_key_conflict_with_change_radius));
            return;
        }
        s0 s0Var3 = this.f10666f;
        if (s0Var3 == null) {
            f0.S("viewBinding");
        } else {
            s0Var2 = s0Var3;
        }
        s0Var2.f54446c.g(i10, b());
    }

    public final void p(int i10) {
        s0 s0Var = this.f10666f;
        s0 s0Var2 = null;
        if (s0Var == null) {
            f0.S("viewBinding");
            s0Var = null;
        }
        if (i10 == s0Var.f54446c.getValue()) {
            n8.b.m(a(), a().getString(R.string.floatview_double_click_key_conflict_with_change_radius));
            return;
        }
        s0 s0Var3 = this.f10666f;
        if (s0Var3 == null) {
            f0.S("viewBinding");
        } else {
            s0Var2 = s0Var3;
        }
        s0Var2.f54447d.g(i10, b());
    }
}
