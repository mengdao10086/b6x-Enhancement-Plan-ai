package com.flydigi.device_manager.ui.detail.waspwing.b7;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import c7.y2;
import com.blankj.utilcode.util.d1;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.IntroductionDialogFragment;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.slider.Slider;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nRunModeItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunModeItem.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b7/RunModeItem\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,345:1\n55#2,4:346\n55#2,4:350\n*S KotlinDebug\n*F\n+ 1 RunModeItem.kt\ncom/flydigi/device_manager/ui/detail/waspwing/b7/RunModeItem\n*L\n296#1:346,4\n298#1:350,4\n*E\n"})
public final class RunModeItem extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public WaspWingInfo f14717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public y2 f14718b;

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

    public /* synthetic */ RunModeItem(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void A(RunModeItem this$0, View view) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null || waspWingInfoCopy.getTargetTemperature() >= 16) {
            return;
        }
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : waspWingInfoCopy.getTargetTemperature() + 1, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void B(RunModeItem this$0, View view) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null || waspWingInfoCopy.getWindLevel() <= this$0.f14718b.f10629x.getValueFrom()) {
            return;
        }
        int windLevel = (int) (waspWingInfoCopy.getWindLevel() - this$0.f14718b.f10629x.getStepSize());
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : windLevel, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : windLevel, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void C(RunModeItem this$0, View view) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null || waspWingInfoCopy.getWindLevel() >= this$0.f14718b.f10629x.getValueTo()) {
            return;
        }
        int windLevel = (int) (waspWingInfoCopy.getWindLevel() + this$0.f14718b.f10629x.getStepSize());
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : windLevel, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : windLevel, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void D(RunModeItem this$0, View view) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null) {
            return;
        }
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 104, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 104, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void p(RunModeItem this$0, Slider slider, float f10, boolean z10) {
        WaspWingInfo waspWingInfo;
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        f0.p(slider, "slider");
        if (!z10 || (waspWingInfo = this$0.f14717a) == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null) {
            return;
        }
        int i10 = (int) f10;
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : i10, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : i10, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void q(RunModeItem this$0, View view) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null) {
            return;
        }
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 104, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : WaspWingInfo.COLD_LEVEL_STANDARD_B7, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void r(RunModeItem this$0, View view) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null) {
            return;
        }
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 104, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 155, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void s(RunModeItem this$0, View view) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null) {
            return;
        }
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 104, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 254, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void t(RunModeItem this$0, View view) {
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0) == null) {
            return;
        }
        t9.j.f50990a.W(0, (124 & 2) != 0 ? 0 : 10, (124 & 4) != 0 ? 0 : WaspWingInfo.WIND_LEVEL_MIN, (124 & 8) != 0 ? 0 : 104, (124 & 16) != 0 ? 0 : WaspWingInfo.WIND_LEVEL_MIN, (124 & 32) != 0 ? 0 : 155, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void u(RunModeItem this$0, View view) {
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0) == null) {
            return;
        }
        t9.j.f50990a.W(0, (124 & 2) != 0 ? 0 : 0, (124 & 4) != 0 ? 0 : 8000, (124 & 8) != 0 ? 0 : 10, (124 & 16) != 0 ? 0 : 8000, (124 & 32) != 0 ? 0 : 254, (124 & 64) == 0 ? 0 : 0);
    }

    public static final void v(View view) {
        IntroductionDialogFragment.a aVar = IntroductionDialogFragment.I8;
        String strD = d1.d(R.string.device_waspwing_cold_level);
        f0.o(strD, "getString(R.string.device_waspwing_cold_level)");
        String strD2 = d1.d(R.string.device_waspwing_wind_level_low);
        String strD3 = d1.d(R.string.device_waspwing_cold_level_quiet_desc);
        f0.o(strD3, "getString(R.string.devic…ng_cold_level_quiet_desc)");
        String strD4 = d1.d(R.string.device_fragment_detail_waspwing_temperature_level_min);
        String strD5 = d1.d(R.string.device_fragment_detail_b5_wind_speed_min_desc);
        f0.o(strD5, "getString(R.string.devic…l_b5_wind_speed_min_desc)");
        IntroductionDialogFragment introductionDialogFragmentA = aVar.a(strD, CollectionsKt__CollectionsKt.r(new IntroductionDialogFragment.Introduction(strD2, strD3), new IntroductionDialogFragment.Introduction(strD4, strD5)));
        Activity activityP = com.blankj.utilcode.util.a.P();
        f0.n(activityP, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        introductionDialogFragmentA.Z5(((androidx.fragment.app.g) activityP).n3(), "introduction");
    }

    public static final void w(RunModeItem this$0, View view) {
        ArrayList<IntroductionDialogFragment.Introduction> arrayListR;
        f0.p(this$0, "this$0");
        IntroductionDialogFragment.a aVar = IntroductionDialogFragment.I8;
        WaspWingInfo waspWingInfo = this$0.f14717a;
        String strD = d1.d(waspWingInfo != null && waspWingInfo.getRunMode() == 3 ? R.string.device_waspwing_cold_level_limit : R.string.device_waspwing_cold_level);
        f0.o(strD, "getString(if (mWaspwingI…vice_waspwing_cold_level)");
        WaspWingInfo waspWingInfo2 = this$0.f14717a;
        if (waspWingInfo2 != null && waspWingInfo2.getRunMode() == 3) {
            String strD2 = d1.d(R.string.device_waspwing_cold_level_limit_desc);
            f0.o(strD2, "getString(R.string.devic…ng_cold_level_limit_desc)");
            String strD3 = d1.d(R.string.device_waspwing_cold_level_standard);
            String strD4 = d1.d(R.string.device_waspwing_cold_level_standard_desc);
            f0.o(strD4, "getString(R.string.devic…cold_level_standard_desc)");
            String strD5 = d1.d(R.string.device_waspwing_cold_level_strong);
            String strD6 = d1.d(R.string.device_waspwing_cold_level_strong_desc);
            f0.o(strD6, "getString(R.string.devic…g_cold_level_strong_desc)");
            String strD7 = d1.d(R.string.device_waspwing_cold_level_strongest);
            String strD8 = d1.d(R.string.device_waspwing_cold_level_strongest_desc);
            f0.o(strD8, "getString(R.string.devic…old_level_strongest_desc)");
            arrayListR = CollectionsKt__CollectionsKt.r(new IntroductionDialogFragment.Introduction("", strD2), new IntroductionDialogFragment.Introduction(strD3, strD4), new IntroductionDialogFragment.Introduction(strD5, strD6), new IntroductionDialogFragment.Introduction(strD7, strD8));
        } else {
            String strD9 = d1.d(R.string.device_waspwing_cold_level_standard);
            String strD10 = d1.d(R.string.device_waspwing_cold_level_standard_desc);
            f0.o(strD10, "getString(R.string.devic…cold_level_standard_desc)");
            String strD11 = d1.d(R.string.device_waspwing_cold_level_strong);
            String strD12 = d1.d(R.string.device_waspwing_cold_level_strong_desc);
            f0.o(strD12, "getString(R.string.devic…g_cold_level_strong_desc)");
            String strD13 = d1.d(R.string.device_waspwing_cold_level_strongest);
            String strD14 = d1.d(R.string.device_waspwing_cold_level_strongest_desc);
            f0.o(strD14, "getString(R.string.devic…old_level_strongest_desc)");
            arrayListR = CollectionsKt__CollectionsKt.r(new IntroductionDialogFragment.Introduction(strD9, strD10), new IntroductionDialogFragment.Introduction(strD11, strD12), new IntroductionDialogFragment.Introduction(strD13, strD14));
        }
        IntroductionDialogFragment introductionDialogFragmentA = aVar.a(strD, arrayListR);
        Activity activityP = com.blankj.utilcode.util.a.P();
        f0.n(activityP, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        introductionDialogFragmentA.Z5(((androidx.fragment.app.g) activityP).n3(), "introduction");
    }

    public static final void x(RunModeItem this$0, View view) {
        f0.p(this$0, "this$0");
        IntroductionDialogFragment.a aVar = IntroductionDialogFragment.I8;
        WaspWingInfo waspWingInfo = this$0.f14717a;
        String strD = d1.d(waspWingInfo != null && waspWingInfo.getRunMode() == 3 ? R.string.device_waspwing_wind_level_limit : R.string.device_waspwing_wind_level);
        f0.o(strD, "getString(\n             …      }\n                )");
        IntroductionDialogFragment.Introduction[] introductionArr = new IntroductionDialogFragment.Introduction[1];
        WaspWingInfo waspWingInfo2 = this$0.f14717a;
        String strD2 = d1.d(waspWingInfo2 != null && waspWingInfo2.getRunMode() == 3 ? R.string.device_waspwing_wind_level_limit_desc : R.string.device_waspwing_wind_level_fixed_desc);
        f0.o(strD2, "getString(\n             …                        )");
        introductionArr[0] = new IntroductionDialogFragment.Introduction("", strD2);
        IntroductionDialogFragment introductionDialogFragmentA = aVar.a(strD, CollectionsKt__CollectionsKt.r(introductionArr));
        Activity activityP = com.blankj.utilcode.util.a.P();
        f0.n(activityP, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        introductionDialogFragmentA.Z5(((androidx.fragment.app.g) activityP).n3(), "introduction");
    }

    public static final void y(View view) {
        IntroductionDialogFragment.a aVar = IntroductionDialogFragment.I8;
        String strD = d1.d(R.string.device_waspwing_target_temperature);
        f0.o(strD, "getString(R.string.devic…pwing_target_temperature)");
        String strD2 = d1.d(R.string.device_waspwing_target_temperature_desc);
        f0.o(strD2, "getString(R.string.devic…_target_temperature_desc)");
        IntroductionDialogFragment introductionDialogFragmentA = aVar.a(strD, CollectionsKt__CollectionsKt.r(new IntroductionDialogFragment.Introduction("", strD2)));
        Activity activityP = com.blankj.utilcode.util.a.P();
        f0.n(activityP, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        introductionDialogFragmentA.Z5(((androidx.fragment.app.g) activityP).n3(), "introduction");
    }

    public static final void z(RunModeItem this$0, View view) {
        WaspWingInfo waspWingInfoCopy;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.f14717a;
        if (waspWingInfo == null || (waspWingInfoCopy = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0)) == null) {
            return;
        }
        waspWingInfoCopy.getTargetTemperature();
        t9.j.f50990a.W(waspWingInfoCopy.getRunMode(), (124 & 2) != 0 ? 0 : waspWingInfoCopy.getTargetTemperature() - 1, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0 ? 0 : 0, (124 & 16) != 0 ? 0 : 0, (124 & 32) != 0 ? 0 : 0, (124 & 64) == 0 ? 0 : 0);
    }

    public final void setDeviceInfo(@yt.k WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        this.f14717a = waspWingInfo;
        ActionItemNormal actionItemNormal = this.f14718b.f10607b;
        int runMode = waspWingInfo.getRunMode();
        actionItemNormal.Q(runMode != 0 ? (runMode == 1 || runMode == 2) ? getContext().getString(R.string.device_waspwing_run_mode_manual_b6) : runMode != 3 ? "" : getContext().getString(R.string.device_waspwing_run_mode_experimental_smart) : getContext().getString(R.string.device_waspwing_run_mode_smart));
        ConstraintLayout constraintLayout = this.f14718b.f10613h;
        f0.o(constraintLayout, "viewBinding.areaSmart");
        o5.c.b(constraintLayout, Boolean.valueOf(waspWingInfo.getRunMode() == 0), false, 2, null);
        LinearLayout linearLayout = this.f14718b.f10608c;
        f0.o(linearLayout, "viewBinding.areaExperimentalSmart");
        o5.c.b(linearLayout, Boolean.valueOf(waspWingInfo.getRunMode() != 0), false, 2, null);
        LinearLayout linearLayout2 = this.f14718b.f10611f;
        f0.o(linearLayout2, "viewBinding.areaExperimentalSmartTargetTemperature");
        o5.c.b(linearLayout2, Boolean.valueOf(waspWingInfo.getRunMode() == 3), false, 2, null);
        if (waspWingInfo.getRunMode() == 1) {
            this.f14718b.f10630y.setText(R.string.device_waspwing_cold_level);
            this.f14718b.f10631z.setText(R.string.device_waspwing_wind_level);
        } else {
            this.f14718b.f10630y.setText(R.string.device_waspwing_cold_level_limit);
            this.f14718b.f10631z.setText(R.string.device_waspwing_wind_level_limit);
        }
        if (waspWingInfo.getRunMode() == 0) {
            this.f14718b.f10622q.setSelected(waspWingInfo.getWindLevel() == 4500);
            ConstraintLayout constraintLayout2 = this.f14718b.f10622q;
            f0.o(constraintLayout2, "viewBinding.btnRunLevelQuiet");
            int childCount = constraintLayout2.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = constraintLayout2.getChildAt(i10);
                f0.o(childAt, "getChildAt(index)");
                childAt.setSelected(waspWingInfo.getWindLevel() == 4500);
            }
            this.f14718b.f10623r.setSelected(waspWingInfo.getWindLevel() == 5500);
            ConstraintLayout constraintLayout3 = this.f14718b.f10623r;
            f0.o(constraintLayout3, "viewBinding.btnRunLevelStandard");
            int childCount2 = constraintLayout3.getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = constraintLayout3.getChildAt(i11);
                f0.o(childAt2, "getChildAt(index)");
                childAt2.setSelected(waspWingInfo.getWindLevel() == 4500);
            }
            return;
        }
        this.f14718b.f10620o.setEnabled(((float) waspWingInfo.getWindLevel()) > this.f14718b.f10629x.getValueFrom());
        this.f14718b.f10621p.setEnabled(((float) waspWingInfo.getWindLevel()) < this.f14718b.f10629x.getValueTo());
        y2 y2Var = this.f14718b;
        y2Var.f10618m.setAlpha(y2Var.f10620o.isEnabled() ? 1.0f : 0.3f);
        ImageView imageView = this.f14718b.f10619n;
        imageView.setAlpha(imageView.isEnabled() ? 1.0f : 0.3f);
        this.f14718b.f10618m.setEnabled(waspWingInfo.getTargetTemperature() > -16);
        this.f14718b.f10619n.setEnabled(waspWingInfo.getTargetTemperature() < 16);
        ImageView imageView2 = this.f14718b.f10618m;
        imageView2.setAlpha(imageView2.isEnabled() ? 1.0f : 0.3f);
        ImageView imageView3 = this.f14718b.f10619n;
        imageView3.setAlpha(imageView3.isEnabled() ? 1.0f : 0.3f);
        this.f14718b.f10614i.setSelected(waspWingInfo.getColdLevel() == 104);
        this.f14718b.f10615j.setSelected(waspWingInfo.getColdLevel() == 149);
        this.f14718b.f10616k.setSelected(waspWingInfo.getColdLevel() == 155);
        this.f14718b.f10617l.setSelected(waspWingInfo.getColdLevel() == 254);
        this.f14718b.f10615j.setEnabled(waspWingInfo.getOverClockUsable());
        this.f14718b.f10616k.setEnabled(waspWingInfo.getOverClockUsable());
        this.f14718b.f10617l.setEnabled(waspWingInfo.getOverClockUsableLevel() == 2);
        this.f14718b.B.setText(waspWingInfo.getTargetTemperature() + "  ℃");
        this.f14718b.A.setText(String.valueOf(waspWingInfo.getWindLevel()));
        this.f14718b.f10629x.setValue(((float) waspWingInfo.getWindLevel()) < this.f14718b.f10629x.getValueFrom() ? this.f14718b.f10629x.getValueFrom() : ((float) waspWingInfo.getWindLevel()) > this.f14718b.f10629x.getValueTo() ? this.f14718b.f10629x.getValueTo() : waspWingInfo.getWindLevel());
    }

    public final void setOnRunModeClickListener(@yt.k View.OnClickListener listener) {
        f0.p(listener, "listener");
        com.blankj.utilcode.util.o.r(this.f14718b.f10607b, listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public RunModeItem(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        LayoutInflater.from(context).inflate(R.layout.device_widget_run_mode_item_b7, (ViewGroup) this, true);
        y2 y2VarA = y2.a(this);
        f0.o(y2VarA, "bind(this)");
        this.f14718b = y2VarA;
        y2VarA.f10629x.h(new Slider.a() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.t
            @Override // com.google.android.material.slider.Slider.a, com.google.android.material.slider.a
            /* JADX INFO: renamed from: c */
            public final void a(Slider slider, float f10, boolean z10) {
                RunModeItem.p(this.f14741a, slider, f10, z10);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10620o, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.B(this.f14724a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10621p, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.C(this.f14722a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10614i, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.D(this.f14744a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10615j, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.q(this.f14736a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10616k, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.r(this.f14743a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10617l, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.s(this.f14745a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10622q, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.t(this.f14747a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10623r, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.u(this.f14746a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10627v, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.v(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10624s, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.w(this.f14742a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10625t, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.x(this.f14720a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10626u, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.y(view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10618m, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.z(this.f14738a, view);
            }
        });
        com.blankj.utilcode.util.o.r(this.f14718b.f10619n, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.b7.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeItem.A(this.f14737a, view);
            }
        });
    }
}
