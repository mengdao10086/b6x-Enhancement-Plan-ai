package com.flydigi.device_manager.ui.detail.waspwing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c7.z2;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.slider.Slider;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class WindSpeedSwitchItem extends q5.b {

    @yt.l
    public WaspWingInfo C2;

    @yt.k
    public String E7;
    public z2 K2;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public WindSpeedSwitchItem(@yt.k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public WindSpeedSwitchItem(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ WindSpeedSwitchItem(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void W(final WindSpeedSwitchItem this$0, Slider slider, final float f10, boolean z10) {
        f0.p(this$0, "this$0");
        f0.p(slider, "<anonymous parameter 0>");
        if (z10) {
            this$0.getHandler().removeCallbacks(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.a0
                @Override // java.lang.Runnable
                public final void run() {
                    WindSpeedSwitchItem.X(this.f14657a, f10);
                }
            });
            this$0.getHandler().postDelayed(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.z
                @Override // java.lang.Runnable
                public final void run() {
                    WindSpeedSwitchItem.Y(this.f14815a, f10);
                }
            }, 100L);
        }
    }

    public static final void X(WindSpeedSwitchItem this$0, float f10) {
        f0.p(this$0, "this$0");
        this$0.c0(f10);
    }

    public static final void Y(WindSpeedSwitchItem this$0, float f10) {
        f0.p(this$0, "this$0");
        this$0.c0(f10);
    }

    public static final void Z(WindSpeedSwitchItem this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.getHandler().removeCallbacksAndMessages(null);
        t9.j jVar = t9.j.f50990a;
        WaspWingInfo waspWingInfo = this$0.C2;
        jVar.W(0, (124 & 2) != 0 ? 0 : waspWingInfo != null ? waspWingInfo.getTargetTemperature() : 18, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void a0(WindSpeedSwitchItem this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.getHandler().removeCallbacksAndMessages(null);
        t9.j.f50990a.W(1, (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 115, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void b0(WindSpeedSwitchItem this$0, View view) {
        f0.p(this$0, "this$0");
        z2 z2Var = this$0.K2;
        z2 z2Var2 = null;
        if (z2Var == null) {
            f0.S("viewBinding");
            z2Var = null;
        }
        Object tag = z2Var.f10644b.getTag();
        f0.n(tag, "null cannot be cast to non-null type kotlin.Boolean");
        if (!((Boolean) tag).booleanValue()) {
            ToastUtils.P(R.string.device_fragment_detail_waspwing_run_mode_overclock_can_not_use);
            return;
        }
        t9.j jVar = t9.j.f50990a;
        z2 z2Var3 = this$0.K2;
        if (z2Var3 == null) {
            f0.S("viewBinding");
        } else {
            z2Var2 = z2Var3;
        }
        jVar.W(!z2Var2.f10646d.isSelected() ? 2 : 1, (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : 134, (124 & 32) != 0 ? 0 : WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, (124 & 64) == 0 ? 0 : 0);
    }

    @Override // q5.b
    public void N(@yt.l Context context, @yt.l AttributeSet attributeSet) {
        super.N(context, attributeSet);
        z2 z2VarA = z2.a(this);
        f0.o(z2VarA, "bind(this)");
        this.K2 = z2VarA;
        z2 z2Var = null;
        if (z2VarA == null) {
            f0.S("viewBinding");
            z2VarA = null;
        }
        z2VarA.f10651i.h(new Slider.a() { // from class: com.flydigi.device_manager.ui.detail.waspwing.y
            @Override // com.google.android.material.slider.Slider.a, com.google.android.material.slider.a
            /* JADX INFO: renamed from: c */
            public final void a(Slider slider, float f10, boolean z10) {
                WindSpeedSwitchItem.W(this.f14814a, slider, f10, z10);
            }
        });
        z2 z2Var2 = this.K2;
        if (z2Var2 == null) {
            f0.S("viewBinding");
            z2Var2 = null;
        }
        com.blankj.utilcode.util.o.r(z2Var2.f10648f, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindSpeedSwitchItem.Z(this.f14812a, view);
            }
        });
        z2 z2Var3 = this.K2;
        if (z2Var3 == null) {
            f0.S("viewBinding");
            z2Var3 = null;
        }
        com.blankj.utilcode.util.o.r(z2Var3.f10647e, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindSpeedSwitchItem.a0(this.f14811a, view);
            }
        });
        z2 z2Var4 = this.K2;
        if (z2Var4 == null) {
            f0.S("viewBinding");
        } else {
            z2Var = z2Var4;
        }
        com.blankj.utilcode.util.o.r(z2Var.f10646d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindSpeedSwitchItem.b0(this.f14813a, view);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0(float r45) {
        /*
            Method dump skipped, instruction units count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.detail.waspwing.WindSpeedSwitchItem.c0(float):void");
    }

    public final void d0(int i10) {
        z2 z2Var = this.K2;
        z2 z2Var2 = null;
        if (z2Var == null) {
            f0.S("viewBinding");
            z2Var = null;
        }
        z2Var.f10651i.setEnabled(true);
        z2 z2Var3 = this.K2;
        if (z2Var3 == null) {
            f0.S("viewBinding");
            z2Var3 = null;
        }
        z2Var3.f10651i.setValueFrom(120.0f);
        z2 z2Var4 = this.K2;
        if (z2Var4 == null) {
            f0.S("viewBinding");
            z2Var4 = null;
        }
        z2Var4.f10651i.setValue(i10);
        z2 z2Var5 = this.K2;
        if (z2Var5 == null) {
            f0.S("viewBinding");
            z2Var5 = null;
        }
        z2Var5.f10651i.setValueTo(255.0f);
        z2 z2Var6 = this.K2;
        if (z2Var6 == null) {
            f0.S("viewBinding");
        } else {
            z2Var2 = z2Var6;
        }
        z2Var2.f10651i.setTickVisible(false);
    }

    @Override // q5.b
    public int getLayoutId() {
        return R.layout.device_widget_wind_seek_bar;
    }

    public final void setDeviceCode(@yt.k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        if (f0.g(this.E7, deviceCode)) {
            return;
        }
        this.E7 = deviceCode;
        z2 z2Var = null;
        if (f0.g(deviceCode, t9.c.f50955d) || f0.g(deviceCode, t9.c.f50956e)) {
            z2 z2Var2 = this.K2;
            if (z2Var2 == null) {
                f0.S("viewBinding");
                z2Var2 = null;
            }
            z2Var2.f10659q.setText(R.string.device_title_waspwing_mode);
            z2 z2Var3 = this.K2;
            if (z2Var3 == null) {
                f0.S("viewBinding");
                z2Var3 = null;
            }
            ConstraintLayout constraintLayout = z2Var3.f10645c;
            f0.o(constraintLayout, "viewBinding.areaSettingRunMode");
            o5.c.b(constraintLayout, Boolean.TRUE, false, 2, null);
            return;
        }
        z2 z2Var4 = this.K2;
        if (z2Var4 == null) {
            f0.S("viewBinding");
            z2Var4 = null;
        }
        z2Var4.f10659q.setText(R.string.device_fragment_detail_b3_wind_speed);
        z2 z2Var5 = this.K2;
        if (z2Var5 == null) {
            f0.S("viewBinding");
            z2Var5 = null;
        }
        z2Var5.f10656n.setText(R.string.device_fragment_detail_b3_wind_speed_min);
        z2 z2Var6 = this.K2;
        if (z2Var6 == null) {
            f0.S("viewBinding");
            z2Var6 = null;
        }
        z2Var6.f10654l.setText(R.string.device_fragment_detail_b3_wind_speed_max);
        z2 z2Var7 = this.K2;
        if (z2Var7 == null) {
            f0.S("viewBinding");
            z2Var7 = null;
        }
        TextView textView = z2Var7.f10655m;
        f0.o(textView, "viewBinding.tvMiddle");
        Boolean bool = Boolean.FALSE;
        o5.c.b(textView, bool, false, 2, null);
        z2 z2Var8 = this.K2;
        if (z2Var8 == null) {
            f0.S("viewBinding");
            z2Var8 = null;
        }
        z2Var8.f10651i.setValueTo(255.0f);
        z2 z2Var9 = this.K2;
        if (z2Var9 == null) {
            f0.S("viewBinding");
            z2Var9 = null;
        }
        z2Var9.f10651i.setValueFrom(120.0f);
        z2 z2Var10 = this.K2;
        if (z2Var10 == null) {
            f0.S("viewBinding");
            z2Var10 = null;
        }
        ConstraintLayout constraintLayout2 = z2Var10.f10645c;
        f0.o(constraintLayout2, "viewBinding.areaSettingRunMode");
        o5.c.b(constraintLayout2, bool, false, 2, null);
        z2 z2Var11 = this.K2;
        if (z2Var11 == null) {
            f0.S("viewBinding");
        } else {
            z2Var = z2Var11;
        }
        z2Var.f10644b.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x0341  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setDeviceInfo(@yt.k com.flydigi.sdk.waspwing.WaspWingInfo r12) {
        /*
            Method dump skipped, instruction units count: 891
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.detail.waspwing.WindSpeedSwitchItem.setDeviceInfo(com.flydigi.sdk.waspwing.WaspWingInfo):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public WindSpeedSwitchItem(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.E7 = "all";
    }
}
