package o9;

import com.flydigi.sdk.gamepad.GamepadInfo;
import hk.m;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final e f42951a = new e();

    @m
    public static final boolean a(@k GamepadInfo deviceInfo, @k String firmwareNeeded) {
        f0.p(deviceInfo, "deviceInfo");
        f0.p(firmwareNeeded, "firmwareNeeded");
        if (!deviceInfo.isDriverMode()) {
            String firmwareVersion = deviceInfo.getFirmwareVersion();
            if (firmwareVersion == null) {
                firmwareVersion = "";
            }
            if (!l9.c.b(firmwareNeeded, firmwareVersion)) {
                return false;
            }
        }
        return true;
    }

    @m
    public static final boolean b(@k GamepadInfo deviceInfo, int i10) {
        f0.p(deviceInfo, "deviceInfo");
        switch (i10) {
            case 11:
                if (!deviceInfo.isSupportMotion() && !deviceInfo.isGamepadKeyboard()) {
                    return false;
                }
            case 10:
            case 13:
            case 14:
                return true;
            case 12:
            default:
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @m
    public static final boolean c(@k GamepadInfo deviceInfo, int i10, int i11) {
        f0.p(deviceInfo, "deviceInfo");
        if (i10 == 11) {
            return a(deviceInfo, m9.k.f40817c);
        }
        if (i10 != 15) {
            if (i10 != 32) {
                if (i10 == 20) {
                    return deviceInfo.isDriverMode();
                }
                if (i10 == 21) {
                    return deviceInfo.isDriverMode();
                }
                if (i10 == 50) {
                    return deviceInfo.isSupportLunpan();
                }
                if (i10 == 51) {
                    return a(deviceInfo, m9.k.f40828n);
                }
                switch (i10) {
                    case 1:
                        if (i11 != 0 && i11 != 1 && i11 != 2 && i11 != 3) {
                            if (i11 == 5) {
                                return a(deviceInfo, m9.k.f40823i);
                            }
                            if (i11 != 7) {
                                return false;
                            }
                        }
                        break;
                    case 2:
                    case 6:
                    case 7:
                    case 8:
                        break;
                    case 3:
                        if (!deviceInfo.isSupportMotion() && !deviceInfo.isGamepadKeyboard()) {
                            return false;
                        }
                        break;
                    case 4:
                        if (!deviceInfo.isSupportMotion() && !deviceInfo.isGamepadKeyboard()) {
                            return false;
                        }
                        break;
                    case 5:
                        if (deviceInfo.isGamepadKeyboard() && !a(deviceInfo, m9.k.f40827m)) {
                            return false;
                        }
                        break;
                    default:
                        switch (i10) {
                            case 24:
                                return deviceInfo.isSupportLunpan();
                            case 25:
                                return deviceInfo.isSupportLunpan();
                            case 26:
                                return deviceInfo.isSupportLunpan();
                            case 27:
                                if (!deviceInfo.isGamepadKeyboard() || !a(deviceInfo, m9.k.f40829o)) {
                                    return false;
                                }
                                break;
                            default:
                                switch (i10) {
                                    case 34:
                                        break;
                                    case 35:
                                        return deviceInfo.isSupportMotion();
                                    case 36:
                                        return a(deviceInfo, m9.k.f40831q);
                                    default:
                                        return false;
                                }
                                break;
                        }
                        break;
                }
            }
        } else if (!deviceInfo.isSupportMotion() || !a(deviceInfo, m9.k.f40828n)) {
            return false;
        }
        return true;
    }
}
