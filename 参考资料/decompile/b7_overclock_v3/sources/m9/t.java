package m9;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.Objects;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final t f40884a = new t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f40885b;

    @hk.m
    public static final boolean a(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        if (androidx.core.util.j.a(deviceInfo.getFirmwareVersion(), "9.9.9.9") || deviceInfo.getChipType() == 0) {
            return false;
        }
        if (deviceInfo.getDeviceType() == 68) {
            String firmwareVersion = deviceInfo.getFirmwareVersion();
            return l9.c.b(k.f40835u, firmwareVersion != null ? firmwareVersion : "");
        }
        if (deviceInfo.getDeviceType() == 22 || deviceInfo.getDeviceType() == 23) {
            String firmwareVersion2 = deviceInfo.getFirmwareVersion();
            return l9.c.b(k.f40836v, firmwareVersion2 != null ? firmwareVersion2 : "");
        }
        if (deviceInfo.getDeviceType() != 20) {
            return deviceInfo.getDeviceType() == 69 || deviceInfo.getChipType() == 3;
        }
        String firmwareVersion3 = deviceInfo.getFirmwareVersion();
        return l9.c.b(k.f40834t, firmwareVersion3 != null ? firmwareVersion3 : "");
    }

    @hk.m
    public static final boolean b(@yt.k GamepadInfo gamepadInfo) {
        f0.p(gamepadInfo, "gamepadInfo");
        if (!gamepadInfo.isDriverMode()) {
            String firmwareVersion = gamepadInfo.getFirmwareVersion();
            if (firmwareVersion == null) {
                firmwareVersion = "";
            }
            if (!l9.c.b(k.f40828n, firmwareVersion)) {
                return false;
            }
        }
        return true;
    }

    @hk.m
    public static final boolean c(@yt.k GamepadInfo gamepadInfo) {
        f0.p(gamepadInfo, "gamepadInfo");
        if (!gamepadInfo.isDriverMode()) {
            String firmwareVersion = gamepadInfo.getFirmwareVersion();
            if (firmwareVersion == null) {
                firmwareVersion = "";
            }
            if (!l9.c.b(k.f40826l, firmwareVersion)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    @hk.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean d(@yt.k com.flydigi.sdk.gamepad.GamepadInfo r3) {
        /*
            java.lang.String r0 = "gamepadInfo"
            kotlin.jvm.internal.f0.p(r3, r0)
            boolean r0 = r3.isGamepadHalf()
            java.lang.String r1 = ""
            if (r0 == 0) goto L1c
            java.lang.String r0 = r3.getFirmwareVersion()
            if (r0 != 0) goto L14
            r0 = r1
        L14:
            java.lang.String r2 = "5.8.7.2"
            boolean r0 = l9.c.b(r2, r0)
            if (r0 != 0) goto L2c
        L1c:
            java.lang.String r3 = r3.getFirmwareVersion()
            if (r3 != 0) goto L23
            goto L24
        L23:
            r1 = r3
        L24:
            java.lang.String r3 = "5.8.7.0"
            boolean r3 = l9.c.b(r3, r1)
            if (r3 == 0) goto L2e
        L2c:
            r3 = 1
            goto L2f
        L2e:
            r3 = 0
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.t.d(com.flydigi.sdk.gamepad.GamepadInfo):boolean");
    }

    @hk.m
    public static final boolean e(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        if (deviceInfo.isSupportMotor()) {
            String firmwareVersion = deviceInfo.getFirmwareVersion();
            if (firmwareVersion == null) {
                firmwareVersion = "";
            }
            if (l9.c.b(k.f40833s, firmwareVersion)) {
                return true;
            }
        }
        return false;
    }

    @hk.m
    public static final boolean f(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        if (!deviceInfo.isSupportSwitch()) {
            return false;
        }
        if (deviceInfo.getDeviceType() == 22) {
            String firmwareVersion = deviceInfo.getFirmwareVersion();
            return l9.c.b(k.f40837w, firmwareVersion != null ? firmwareVersion : "");
        }
        if (!androidx.core.util.j.a(h.B, deviceInfo.getDeviceCode())) {
            return true;
        }
        String firmwareVersion2 = deviceInfo.getFirmwareVersion();
        return l9.c.b(k.f40838x, firmwareVersion2 != null ? firmwareVersion2 : "");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0116 A[ORIG_RETURN, RETURN] */
    @hk.m
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String h(@yt.k java.lang.String r1) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.t.h(java.lang.String):java.lang.String");
    }

    @hk.m
    @yt.k
    public static final String i(@yt.l String str) {
        return j(k(str), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091  */
    @hk.m
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String j(int r7, @yt.l java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.t.j(int, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0016  */
    @hk.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int k(@yt.l java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.t.k(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0153 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0177 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x017a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060 A[RETURN, SYNTHETIC] */
    @hk.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int l(@yt.k java.lang.String r1) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.t.l(java.lang.String):int");
    }

    @hk.m
    @yt.k
    public static final String m(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        return n(deviceInfo.getDeviceCode(), deviceInfo.getDeviceType(), deviceInfo.getChipType());
    }

    @hk.m
    @yt.k
    public static final String n(@yt.k String deviceCode, int i10, int i11) {
        f0.p(deviceCode, "deviceCode");
        return i10 == 23 ? h.f40782y : Objects.equals(deviceCode, h.f40771n) ? h.f40770m : Objects.equals(deviceCode, h.f40783z) ? h.f40778u : Objects.equals(deviceCode, h.f40780w) ? h.f40779v : i11 == 1 ? Objects.equals(deviceCode, h.f40778u) ? "f1wch" : Objects.equals(deviceCode, h.f40773p) ? "q1wch" : deviceCode : deviceCode;
    }

    @hk.m
    @yt.l
    public static final String o(@yt.k Context context, @yt.l String str) {
        f0.p(context, "context");
        Object systemService = context.getSystemService("input");
        f0.n(systemService, "null cannot be cast to non-null type android.hardware.input.InputManager");
        InputManager inputManager = (InputManager) systemService;
        int[] inputDeviceIds = inputManager.getInputDeviceIds();
        for (int i10 = 0; inputDeviceIds != null && i10 < inputDeviceIds.length; i10++) {
            InputDevice inputDevice = inputManager.getInputDevice(inputDeviceIds[i10]);
            if (inputDevice != null && s(inputDevice.getName(), null, 2, null)) {
                return (str == null || !androidx.core.util.j.a(str, inputDevice.getName())) ? inputDevice.getName() : inputDevice.getName();
            }
        }
        return null;
    }

    public static /* synthetic */ String p(Context context, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        return o(context, str);
    }

    @hk.m
    public static final boolean q(@yt.k Context context) {
        f0.p(context, "context");
        Object systemService = context.getSystemService("input");
        f0.n(systemService, "null cannot be cast to non-null type android.hardware.input.InputManager");
        InputManager inputManager = (InputManager) systemService;
        int[] inputDeviceIds = inputManager.getInputDeviceIds();
        for (int i10 = 0; inputDeviceIds != null && i10 < inputDeviceIds.length; i10++) {
            InputDevice inputDevice = inputManager.getInputDevice(inputDeviceIds[i10]);
            if (inputDevice != null && s(inputDevice.getName(), null, 2, null)) {
                return true;
            }
        }
        return false;
    }

    @hk.m
    public static final boolean r(@yt.l String str, @yt.l Boolean bool) {
        if (str == null) {
            return false;
        }
        if (StringsKt__StringsKt.T2(str, "-i", true)) {
            str = str.substring(0, StringsKt__StringsKt.o3(str, "-i", 0, true));
            f0.o(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        boolean z10 = kotlin.text.u.t2(str, "dfu", true) || kotlin.text.u.t2(str, com.flydigi.sdk.bluetooth.v.f16329e, true) || kotlin.text.u.t2(str, com.flydigi.sdk.bluetooth.v.f16326b, true) || kotlin.text.u.t2(str, com.flydigi.sdk.bluetooth.v.f16327c, true);
        return z10 ? ((kotlin.text.u.t2(str, com.flydigi.sdk.bluetooth.v.f16326b, true) || kotlin.text.u.t2(str, com.flydigi.sdk.bluetooth.v.f16327c, true)) && !f0.g(bool, Boolean.FALSE)) ? c.f40730a.a(str) : z10 : z10;
    }

    public static /* synthetic */ boolean s(String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.TRUE;
        }
        return r(str, bool);
    }

    public final boolean g() {
        return f40885b;
    }

    public final void t(boolean z10) {
        f40885b = z10;
    }
}
