package com.flydigi.device_manager.ui.home.device;

import androidx.lifecycle.k0;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.GamepadInfo;

/* JADX INFO: loaded from: classes7.dex */
public final class w {

    public static final class a implements k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f15208a;

        public a(ik.l function) {
            kotlin.jvm.internal.f0.p(function, "function");
            this.f15208a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f15208a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f15208a.i(obj);
        }

        public final boolean equals(@yt.l Object obj) {
            if ((obj instanceof k0) && (obj instanceof kotlin.jvm.internal.a0)) {
                return kotlin.jvm.internal.f0.g(a(), ((kotlin.jvm.internal.a0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    public static final int a(@yt.k GamepadInfo gamepadInfo) {
        kotlin.jvm.internal.f0.p(gamepadInfo, "<this>");
        int batteryLevel = gamepadInfo.getBatteryLevel();
        if (batteryLevel != 0) {
            return batteryLevel != 1 ? batteryLevel != 2 ? batteryLevel != 3 ? batteryLevel != 4 ? R.drawable.device_ic_battery_level_5 : R.drawable.device_ic_battery_level_4 : R.drawable.device_ic_battery_level_3 : R.drawable.device_ic_battery_level_2 : R.drawable.device_ic_battery_level_1;
        }
        return 0;
    }

    public static final int b(@yt.k GamepadInfo gamepadInfo, @yt.l Boolean bool) {
        kotlin.jvm.internal.f0.p(gamepadInfo, "<this>");
        return v5.c.f() ? R.string.device_mapping_mode_emulator : gamepadInfo.isFlashplayMode() ? R.string.device_t_mapping_mode : gamepadInfo.isDriverMode() ? (!kotlin.jvm.internal.f0.g(bool, Boolean.TRUE) || gamepadInfo.isDriverConnected()) ? (!gamepadInfo.isGamepadHalf() || u9.b.d()) ? R.string.device_traditional_mapping_mode : R.string.device_mapping_mode_tradition_pro : R.string.device_mapping_inactive : R.string.device_unknown_mode;
    }

    public static /* synthetic */ int c(GamepadInfo gamepadInfo, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.TRUE;
        }
        return b(gamepadInfo, bool);
    }
}
