package com.flydigi.device_manager.ui.detail.waspwing.b6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c7.x2;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.slider.Slider;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes7.dex */
public final class RunModeItem extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public WaspWingInfo f14674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public x2 f14675b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public RunModeItem(@yt.k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public RunModeItem(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ RunModeItem(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(com.flydigi.device_manager.ui.detail.waspwing.b6.RunModeItem r39, com.google.android.material.slider.Slider r40, float r41, boolean r42) {
        /*
            r0 = r39
            r1 = r41
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.f0.p(r0, r2)
            java.lang.String r2 = "slider"
            r3 = r40
            kotlin.jvm.internal.f0.p(r3, r2)
            if (r42 == 0) goto L88
            com.flydigi.sdk.waspwing.WaspWingInfo r2 = r0.f14674a
            if (r2 == 0) goto L88
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = -1
            r37 = 1
            r38 = 0
            com.flydigi.sdk.waspwing.WaspWingInfo r2 = com.flydigi.sdk.waspwing.WaspWingInfo.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            if (r2 == 0) goto L88
            t9.j r3 = t9.j.f50990a
            r4 = 2
            int r5 = r2.getTargetTemperature()
            r6 = 0
            r7 = 0
            int r8 = (int) r1
            boolean r2 = r2.getOverClockUsable()
            if (r2 == 0) goto L7d
            c7.x2 r0 = r0.f14675b
            com.google.android.material.slider.Slider r0 = r0.f10580g
            float r0 = r0.getValueTo()
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L75
            r0 = 1
            goto L76
        L75:
            r0 = 0
        L76:
            if (r0 == 0) goto L7d
            r0 = 200(0xc8, float:2.8E-43)
            r9 = 200(0xc8, float:2.8E-43)
            goto L81
        L7d:
            r0 = 178(0xb2, float:2.5E-43)
            r9 = 178(0xb2, float:2.5E-43)
        L81:
            r10 = 0
            r11 = 76
            r12 = 0
            t9.j.X(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.detail.waspwing.b6.RunModeItem.d(com.flydigi.device_manager.ui.detail.waspwing.b6.RunModeItem, com.google.android.material.slider.Slider, float, boolean):void");
    }

    public static final void e(RunModeItem this$0, View view) {
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14674a;
        if (waspWingInfo == null || waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0) == null) {
            return;
        }
        t9.j.f50990a.W(0, (124 & 2) != 0 ? 0 : 12, (124 & 4) != 0 ? 0 : WaspWingInfo.WIND_LEVEL_MIN, (124 & 8) != 0 ? 0 : 125, (124 & 16) != 0 ? 0 : 5000, (124 & 32) != 0 ? 0 : 178, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void f(RunModeItem this$0, View view) {
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14674a;
        if (waspWingInfo == null || waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0) == null) {
            return;
        }
        t9.j.f50990a.W(0, (124 & 2) != 0 ? 0 : 8, (124 & 4) != 0 ? 0 : WaspWingInfo.WIND_LEVEL_MIN, (124 & 8) != 0 ? 0 : 125, (124 & 16) != 0 ? 0 : WaspWingInfo.WIND_LEVEL_MAX, (124 & 32) != 0 ? 0 : 178, (124 & 64) == 0 ? 0 : 0);
    }

    public final void setDeviceInfo(@yt.k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        this.f14674a = waspWingInfo;
        this.f14675b.f10575b.Q(waspWingInfo.getRunMode() == 0 ? getContext().getString(R.string.device_waspwing_run_mode_smart) : getContext().getString(R.string.device_waspwing_run_mode_manual_b6));
        TextView textView = this.f14675b.f10588o;
        f0.o(textView, "viewBinding.tvOverclockLimit");
        o5.c.b(textView, Boolean.valueOf(!waspWingInfo.getOverClockUsable()), false, 2, null);
        ConstraintLayout constraintLayout = this.f14675b.f10576c;
        f0.o(constraintLayout, "viewBinding.areaManual");
        o5.c.b(constraintLayout, Boolean.valueOf(waspWingInfo.getRunMode() != 0), false, 2, null);
        ConstraintLayout constraintLayout2 = this.f14675b.f10577d;
        f0.o(constraintLayout2, "viewBinding.areaSmart");
        o5.c.b(constraintLayout2, Boolean.valueOf(waspWingInfo.getRunMode() == 0), false, 2, null);
        if (waspWingInfo.getRunMode() == 0) {
            this.f14675b.f10578e.setSelected(waspWingInfo.getTargetTemperature() == 12);
            this.f14675b.f10579f.setSelected(waspWingInfo.getTargetTemperature() <= 10);
        } else {
            this.f14675b.f10580g.setEnabled(waspWingInfo.getOverClockUsable() && !waspWingInfo.isExperimentalRunModeOn());
            this.f14675b.f10580g.setValue(((float) waspWingInfo.getWindLevel()) < this.f14675b.f10580g.getValueFrom() ? this.f14675b.f10580g.getValueFrom() : ((float) waspWingInfo.getWindLevel()) > this.f14675b.f10580g.getValueTo() ? this.f14675b.f10580g.getValueTo() : waspWingInfo.getWindLevel());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public RunModeItem(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        LayoutInflater.from(context).inflate(R.layout.device_widget_run_mode_item_b6, (ViewGroup) this, true);
        x2 x2VarA = x2.a(this);
        f0.o(x2VarA, "bind(this)");
        this.f14675b = x2VarA;
        x2VarA.f10580g.h(new Slider.a() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.r
            @Override // com.google.android.material.slider.Slider.a, com.google.android.material.slider.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final void a(Slider slider, float f10, boolean z10) {
                RunModeItem.d(this.f14700a, slider, f10, z10);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14675b.f10578e, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.e(this.f14699a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14675b.f10579f, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b6.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.f(this.f14698a, view);
            }
        });
    }
}
