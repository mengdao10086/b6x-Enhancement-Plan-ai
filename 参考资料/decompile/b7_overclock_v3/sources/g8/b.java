package g8;

import android.content.Context;
import android.view.View;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleCheckBoxView;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import com.flydigi.float_view.widget.FloatViewTwoCheckBoxView;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import w7.v0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v0 f29068e;

    public static final class a implements FloatViewTwoCheckBoxView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamepadInfo f29069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f29070b;

        public a(GamepadInfo gamepadInfo, b bVar) {
            this.f29069a = gamepadInfo;
            this.f29070b = bVar;
        }

        @Override // com.flydigi.float_view.widget.FloatViewTwoCheckBoxView.a
        public void a(boolean z10) {
            if (u9.b.d() && !this.f29069a.isDriverConnected()) {
                n8.b.m(this.f29070b.a(), this.f29070b.a().getString(R.string.floatview_fps_assist_shoot_mode_toast_for_vivo));
                return;
            }
            v0 v0Var = this.f29070b.f29068e;
            v0 v0Var2 = null;
            if (v0Var == null) {
                f0.S("viewBinding");
                v0Var = null;
            }
            View view = v0Var.f54490c;
            f0.o(view, "viewBinding.areaFloatFpsAssistShootMotionMask1");
            Boolean bool = Boolean.TRUE;
            o5.c.b(view, bool, false, 2, null);
            v0 v0Var3 = this.f29070b.f29068e;
            if (v0Var3 == null) {
                f0.S("viewBinding");
                v0Var3 = null;
            }
            View view2 = v0Var3.f54491d;
            f0.o(view2, "viewBinding.areaFloatFpsAssistShootMotionMask2");
            o5.c.b(view2, bool, false, 2, null);
            v0 v0Var4 = this.f29070b.f29068e;
            if (v0Var4 == null) {
                f0.S("viewBinding");
            } else {
                v0Var2 = v0Var4;
            }
            v0Var2.f54492e.a(R.string.floatview_fps_assist_shoot_mode_help);
        }

        @Override // com.flydigi.float_view.widget.FloatViewTwoCheckBoxView.a
        public void b(boolean z10) {
            if (this.f29069a.isSupportMotion()) {
                this.f29070b.q(true);
                v0 v0Var = this.f29070b.f29068e;
                v0 v0Var2 = null;
                if (v0Var == null) {
                    f0.S("viewBinding");
                    v0Var = null;
                }
                View view = v0Var.f54490c;
                f0.o(view, "viewBinding.areaFloatFpsAssistShootMotionMask1");
                Boolean bool = Boolean.FALSE;
                o5.c.b(view, bool, false, 2, null);
                v0 v0Var3 = this.f29070b.f29068e;
                if (v0Var3 == null) {
                    f0.S("viewBinding");
                    v0Var3 = null;
                }
                if (v0Var3.f54493f.T()) {
                    v0 v0Var4 = this.f29070b.f29068e;
                    if (v0Var4 == null) {
                        f0.S("viewBinding");
                        v0Var4 = null;
                    }
                    View view2 = v0Var4.f54491d;
                    f0.o(view2, "viewBinding.areaFloatFpsAssistShootMotionMask2");
                    o5.c.b(view2, bool, false, 2, null);
                    v0 v0Var5 = this.f29070b.f29068e;
                    if (v0Var5 == null) {
                        f0.S("viewBinding");
                    } else {
                        v0Var2 = v0Var5;
                    }
                    v0Var2.f54492e.a(R.string.floatview_fps_assist_shoot_motion_on);
                    return;
                }
                v0 v0Var6 = this.f29070b.f29068e;
                if (v0Var6 == null) {
                    f0.S("viewBinding");
                    v0Var6 = null;
                }
                View view3 = v0Var6.f54491d;
                f0.o(view3, "viewBinding.areaFloatFpsAssistShootMotionMask2");
                o5.c.b(view3, Boolean.TRUE, false, 2, null);
                v0 v0Var7 = this.f29070b.f29068e;
                if (v0Var7 == null) {
                    f0.S("viewBinding");
                } else {
                    v0Var2 = v0Var7;
                }
                v0Var2.f54492e.a(R.string.floatview_fps_assist_shoot_motion_off);
            }
        }
    }

    /* JADX INFO: renamed from: g8.b$b, reason: collision with other inner class name */
    public static final class C0347b implements FloatViewTwoCheckBoxView.b {
        public C0347b() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewTwoCheckBoxView.b
        public void a() {
            if (u9.b.d()) {
                b bVar = b.this;
                String string = bVar.a().getString(R.string.floatview_fps_assist_shoot_mode);
                f0.o(string, "context.getString(R.stri…ew_fps_assist_shoot_mode)");
                String string2 = b.this.a().getString(R.string.floatview_fps_assist_shoot_mode_help_for_vivo);
                f0.o(string2, "context.getString(R.stri…shoot_mode_help_for_vivo)");
                bVar.j(string, string2);
                return;
            }
            b bVar2 = b.this;
            String string3 = bVar2.a().getString(R.string.floatview_fps_assist_shoot_mode);
            f0.o(string3, "context.getString(R.stri…ew_fps_assist_shoot_mode)");
            String string4 = b.this.a().getString(R.string.floatview_fps_assist_shoot_mode_help);
            f0.o(string4, "context.getString(R.stri…s_assist_shoot_mode_help)");
            bVar2.j(string3, string4);
        }

        @Override // com.flydigi.float_view.widget.FloatViewTwoCheckBoxView.b
        public void b() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewTwoCheckBoxView.b
        public void c() {
        }
    }

    public static final class c implements FloatViewSingleCheckBoxView.a {
        public c() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleCheckBoxView.a
        public void a(boolean z10) {
            b.this.q(z10);
        }
    }

    public static final class d implements FloatViewSingleSeekBarView.c {
        public d() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleSeekBarView.c
        public void a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewSingleSeekBarView.c
        public void b() {
            b bVar = b.this;
            String str = b.this.a().getString(R.string.floatview_property_key_assist_shoot) + b.this.a().getString(R.string.floatview_introduction);
            String string = b.this.a().getString(R.string.floatview_fps_assist_shoot_help);
            f0.o(string, "context.getString(R.stri…ew_fps_assist_shoot_help)");
            bVar.j(str, string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_fps_assist_shoot);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    public static final void p(b this$0, View view) {
        f0.p(this$0, "this$0");
        String str = this$0.a().getString(R.string.floatview_motion) + this$0.a().getString(R.string.floatview_introduction);
        String string = this$0.a().getString(R.string.floatview_fps_assist_shoot_motion_help);
        f0.o(string, "context.getString(R.stri…assist_shoot_motion_help)");
        this$0.j(str, string);
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 34;
        v0 v0Var = this.f29068e;
        v0 v0Var2 = null;
        if (v0Var == null) {
            f0.S("viewBinding");
            v0Var = null;
        }
        cFGPropertyKey.senVisualRJsX = v0Var.f54494g.getValue();
        v0 v0Var3 = this.f29068e;
        if (v0Var3 == null) {
            f0.S("viewBinding");
            v0Var3 = null;
        }
        cFGPropertyKey.angle = v0Var3.f54495h.getValue().h().booleanValue() ? 1 : 0;
        v0 v0Var4 = this.f29068e;
        if (v0Var4 == null) {
            f0.S("viewBinding");
            v0Var4 = null;
        }
        cFGPropertyKey.range = v0Var4.f54493f.getValue() ? 1 : 0;
        v0 v0Var5 = this.f29068e;
        if (v0Var5 == null) {
            f0.S("viewBinding");
        } else {
            v0Var2 = v0Var5;
        }
        Pair<Integer, Integer> value = v0Var2.f54496i.getValue();
        cFGPropertyKey.senty_x = value.f().intValue();
        cFGPropertyKey.senty_y = value.h().intValue();
        if (b().isGamepadHalf() && cFGPropertyKey.range == 0) {
            cFGPropertyKey.senty_x = 0;
            cFGPropertyKey.senty_y = 0;
        }
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
        v0 v0VarA = v0.a(view);
        f0.o(v0VarA, "bind(view)");
        this.f29068e = v0VarA;
        v0 v0Var = null;
        if (deviceInfo.isGamepadHalf()) {
            v0 v0Var2 = this.f29068e;
            if (v0Var2 == null) {
                f0.S("viewBinding");
                v0Var2 = null;
            }
            v0Var2.f54495h.setVisibility(deviceInfo.isDriverConnected() ? 0 : 8);
            v0 v0Var3 = this.f29068e;
            if (v0Var3 == null) {
                f0.S("viewBinding");
                v0Var3 = null;
            }
            v0Var3.f54492e.a(R.string.floatview_fps_assist_shoot_motion_off);
            if (deviceInfo.isSupportMotion()) {
                v0 v0Var4 = this.f29068e;
                if (v0Var4 == null) {
                    f0.S("viewBinding");
                    v0Var4 = null;
                }
                FloatViewTwoSeekBarView floatViewTwoSeekBarView = v0Var4.f54496i;
                StringBuilder sb2 = new StringBuilder();
                Context contextA = a();
                int i10 = R.string.floatview_motion;
                sb2.append(contextA.getString(i10));
                sb2.append('-');
                sb2.append(a().getString(R.string.floatview_vertical_sensitivity));
                floatViewTwoSeekBarView.o0(sb2.toString(), a().getString(i10) + '-' + a().getString(R.string.floatview_horizontal_sensitivity));
            } else {
                v0 v0Var5 = this.f29068e;
                if (v0Var5 == null) {
                    f0.S("viewBinding");
                    v0Var5 = null;
                }
                FloatViewTwoSeekBarView floatViewTwoSeekBarView2 = v0Var5.f54496i;
                String string = a().getString(R.string.floatview_vertical_sensitivity);
                f0.o(string, "context.getString(R.stri…iew_vertical_sensitivity)");
                String string2 = a().getString(R.string.floatview_horizontal_sensitivity);
                f0.o(string2, "context.getString(R.stri…w_horizontal_sensitivity)");
                floatViewTwoSeekBarView2.o0(string, string2);
            }
            v0 v0Var6 = this.f29068e;
            if (v0Var6 == null) {
                f0.S("viewBinding");
                v0Var6 = null;
            }
            FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = v0Var6.f54495h;
            f0.o(floatViewTwoCheckBoxView, "viewBinding.tcbTriggerMode");
            Boolean bool = Boolean.TRUE;
            o5.c.b(floatViewTwoCheckBoxView, bool, false, 2, null);
            v0 v0Var7 = this.f29068e;
            if (v0Var7 == null) {
                f0.S("viewBinding");
                v0Var7 = null;
            }
            FloatViewSingleCheckBoxView floatViewSingleCheckBoxView = v0Var7.f54493f;
            f0.o(floatViewSingleCheckBoxView, "viewBinding.scbMotion");
            o5.c.b(floatViewSingleCheckBoxView, bool, false, 2, null);
            v0 v0Var8 = this.f29068e;
            if (v0Var8 == null) {
                f0.S("viewBinding");
                v0Var8 = null;
            }
            View view2 = v0Var8.f54490c;
            f0.o(view2, "viewBinding.areaFloatFpsAssistShootMotionMask1");
            o5.c.b(view2, bool, false, 2, null);
            v0 v0Var9 = this.f29068e;
            if (v0Var9 == null) {
                f0.S("viewBinding");
                v0Var9 = null;
            }
            View view3 = v0Var9.f54491d;
            f0.o(view3, "viewBinding.areaFloatFpsAssistShootMotionMask2");
            o5.c.b(view3, bool, false, 2, null);
        } else {
            v0 v0Var10 = this.f29068e;
            if (v0Var10 == null) {
                f0.S("viewBinding");
                v0Var10 = null;
            }
            v0Var10.f54492e.a(R.string.floatview_property_key_fps_assist_shoot_desc);
            v0 v0Var11 = this.f29068e;
            if (v0Var11 == null) {
                f0.S("viewBinding");
                v0Var11 = null;
            }
            FloatViewTwoSeekBarView floatViewTwoSeekBarView3 = v0Var11.f54496i;
            String string3 = a().getString(R.string.floatview_vertical_sensitivity);
            f0.o(string3, "context.getString(R.stri…iew_vertical_sensitivity)");
            String string4 = a().getString(R.string.floatview_horizontal_sensitivity);
            f0.o(string4, "context.getString(R.stri…w_horizontal_sensitivity)");
            floatViewTwoSeekBarView3.o0(string3, string4);
            v0 v0Var12 = this.f29068e;
            if (v0Var12 == null) {
                f0.S("viewBinding");
                v0Var12 = null;
            }
            FloatViewTwoCheckBoxView floatViewTwoCheckBoxView2 = v0Var12.f54495h;
            f0.o(floatViewTwoCheckBoxView2, "viewBinding.tcbTriggerMode");
            Boolean bool2 = Boolean.FALSE;
            o5.c.b(floatViewTwoCheckBoxView2, bool2, false, 2, null);
            v0 v0Var13 = this.f29068e;
            if (v0Var13 == null) {
                f0.S("viewBinding");
                v0Var13 = null;
            }
            FloatViewSingleCheckBoxView floatViewSingleCheckBoxView2 = v0Var13.f54493f;
            f0.o(floatViewSingleCheckBoxView2, "viewBinding.scbMotion");
            o5.c.b(floatViewSingleCheckBoxView2, bool2, false, 2, null);
            v0 v0Var14 = this.f29068e;
            if (v0Var14 == null) {
                f0.S("viewBinding");
                v0Var14 = null;
            }
            View view4 = v0Var14.f54490c;
            f0.o(view4, "viewBinding.areaFloatFpsAssistShootMotionMask1");
            o5.c.b(view4, bool2, false, 2, null);
            v0 v0Var15 = this.f29068e;
            if (v0Var15 == null) {
                f0.S("viewBinding");
                v0Var15 = null;
            }
            View view5 = v0Var15.f54491d;
            f0.o(view5, "viewBinding.areaFloatFpsAssistShootMotionMask2");
            o5.c.b(view5, bool2, false, 2, null);
        }
        v0 v0Var16 = this.f29068e;
        if (v0Var16 == null) {
            f0.S("viewBinding");
            v0Var16 = null;
        }
        v0Var16.f54495h.setOnCheckBoxClickListener$float_view_officialRelease(new a(deviceInfo, this));
        v0 v0Var17 = this.f29068e;
        if (v0Var17 == null) {
            f0.S("viewBinding");
            v0Var17 = null;
        }
        v0Var17.f54495h.setOnHelpClickListener$float_view_officialRelease(new C0347b());
        v0 v0Var18 = this.f29068e;
        if (v0Var18 == null) {
            f0.S("viewBinding");
            v0Var18 = null;
        }
        o.r(v0Var18.f54490c, new View.OnClickListener() { // from class: g8.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                b.p(this.f29067a, view6);
            }
        });
        v0 v0Var19 = this.f29068e;
        if (v0Var19 == null) {
            f0.S("viewBinding");
            v0Var19 = null;
        }
        v0Var19.f54493f.setOnCheckBoxClickListener$float_view_officialRelease(new c());
        v0 v0Var20 = this.f29068e;
        if (v0Var20 == null) {
            f0.S("viewBinding");
        } else {
            v0Var = v0Var20;
        }
        v0Var.f54494g.setOnHelpClickListener$float_view_officialRelease(new d());
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
        v0 v0Var = this.f29068e;
        v0 v0Var2 = null;
        if (v0Var == null) {
            f0.S("viewBinding");
            v0Var = null;
        }
        FloatViewTwoSeekBarView floatViewTwoSeekBarView = v0Var.f54496i;
        f0.o(floatViewTwoSeekBarView, "viewBinding.tsbMotionSens");
        FloatViewTwoSeekBarView.n0(floatViewTwoSeekBarView, pkey.senty_x, pkey.senty_y, false, false, 12, null);
        if (pkey.senVisualRJsX > -1) {
            v0 v0Var3 = this.f29068e;
            if (v0Var3 == null) {
                f0.S("viewBinding");
                v0Var3 = null;
            }
            v0Var3.f54494g.setValue(pkey.senVisualRJsX);
        }
        if (b().isGamepadHalf()) {
            boolean z10 = false;
            if (pkey.angle == 1) {
                v0 v0Var4 = this.f29068e;
                if (v0Var4 == null) {
                    f0.S("viewBinding");
                    v0Var4 = null;
                }
                v0Var4.f54495h.q(false, true);
                if (b().isSupportMotion()) {
                    v0 v0Var5 = this.f29068e;
                    if (v0Var5 == null) {
                        f0.S("viewBinding");
                        v0Var5 = null;
                    }
                    View view = v0Var5.f54490c;
                    f0.o(view, "viewBinding.areaFloatFpsAssistShootMotionMask1");
                    o5.c.b(view, Boolean.FALSE, false, 2, null);
                }
            } else {
                v0 v0Var6 = this.f29068e;
                if (v0Var6 == null) {
                    f0.S("viewBinding");
                    v0Var6 = null;
                }
                v0Var6.f54495h.q(true, false);
                v0 v0Var7 = this.f29068e;
                if (v0Var7 == null) {
                    f0.S("viewBinding");
                    v0Var7 = null;
                }
                View view2 = v0Var7.f54490c;
                f0.o(view2, "viewBinding.areaFloatFpsAssistShootMotionMask1");
                o5.c.b(view2, Boolean.TRUE, false, 2, null);
            }
            if (b().isSupportMotion()) {
                v0 v0Var8 = this.f29068e;
                if (v0Var8 == null) {
                    f0.S("viewBinding");
                } else {
                    v0Var2 = v0Var8;
                }
                v0Var2.f54493f.setValue(pkey.range == 1);
                if (pkey.angle == 1 && pkey.range == 1) {
                    z10 = true;
                }
                q(z10);
            }
        }
    }

    @Override // d8.a
    public void g() {
        v0 v0Var = this.f29068e;
        v0 v0Var2 = null;
        if (v0Var == null) {
            f0.S("viewBinding");
            v0Var = null;
        }
        v0Var.f54495h.o();
        v0 v0Var3 = this.f29068e;
        if (v0Var3 == null) {
            f0.S("viewBinding");
            v0Var3 = null;
        }
        v0Var3.f54494g.U();
        v0 v0Var4 = this.f29068e;
        if (v0Var4 == null) {
            f0.S("viewBinding");
            v0Var4 = null;
        }
        v0Var4.f54496i.k0();
        v0 v0Var5 = this.f29068e;
        if (v0Var5 == null) {
            f0.S("viewBinding");
        } else {
            v0Var2 = v0Var5;
        }
        v0Var2.f54493f.U();
    }

    public final void q(boolean z10) {
        v0 v0Var = this.f29068e;
        v0 v0Var2 = null;
        if (v0Var == null) {
            f0.S("viewBinding");
            v0Var = null;
        }
        v0Var.f54491d.setVisibility(z10 ? 8 : 0);
        v0 v0Var3 = this.f29068e;
        if (v0Var3 == null) {
            f0.S("viewBinding");
        } else {
            v0Var2 = v0Var3;
        }
        v0Var2.f54492e.a(z10 ? R.string.floatview_fps_assist_shoot_motion_on : R.string.floatview_fps_assist_shoot_motion_off);
    }
}
