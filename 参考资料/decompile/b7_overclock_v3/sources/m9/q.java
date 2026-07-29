package m9;

import com.flydigi.sdk.gamepad.GamepadInfo;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import rb.a0;
import v7.a;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final q f40881a = new q();

    @hk.m
    public static final void A(@yt.k GamepadInfo deviceInfo, byte b10, int i10, int i11) {
        f0.p(deviceInfo, "deviceInfo");
        if (b10 == 0 || b10 == 255) {
            y(deviceInfo, 18, 0, i11);
            deviceInfo.setDeviceCode(h.G);
            deviceInfo.setDeviceName("Flydigi Emulator Gamepad");
            deviceInfo.setAddress("00:00:00:00");
            deviceInfo.setFirmwareVersion("9.9.9.9");
        } else {
            y(deviceInfo, b10, i10, i11);
        }
        deviceInfo.setConnectMode(1);
        deviceInfo.setMappingMode(0);
        deviceInfo.setSupportFlashplay(false);
    }

    public static /* synthetic */ void B(GamepadInfo gamepadInfo, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i11 = 1;
        }
        A(gamepadInfo, b10, i10, i11);
    }

    @hk.m
    public static final void y(@yt.k GamepadInfo deviceInfo, int i10, int i11, int i12) {
        f0.p(deviceInfo, "deviceInfo");
        if (i10 != 28) {
            if (i10 != 29) {
                if (i10 != 91) {
                    switch (i10) {
                        case 16:
                            f40881a.x(deviceInfo, i10, i11, i12);
                            break;
                        case 17:
                            f40881a.w(deviceInfo, i10, i11, i12);
                            break;
                        case 18:
                            f40881a.a(deviceInfo, i10, i11, i12);
                            break;
                        case 19:
                            f40881a.b(deviceInfo, i10, i11, i12);
                            break;
                        case 20:
                        case 23:
                            f40881a.d(deviceInfo, i10, i11, i12);
                            break;
                        case 21:
                            f40881a.e(deviceInfo, i10, i11, i12);
                            break;
                        case 22:
                            f40881a.f(deviceInfo, i10, i11, i12);
                            break;
                        case 24:
                        case 26:
                            break;
                        default:
                            switch (i10) {
                                case 31:
                                    break;
                                case 32:
                                    f40881a.t(deviceInfo, i10, i11, i12);
                                    break;
                                case 33:
                                    f40881a.u(deviceInfo, i10, i11, i12);
                                    break;
                                case 34:
                                    f40881a.v(deviceInfo, i10, i11, i12);
                                    break;
                                default:
                                    switch (i10) {
                                        case 48:
                                        case 50:
                                            f40881a.n(deviceInfo, i10, i11, i12);
                                            break;
                                        case 49:
                                            f40881a.c(deviceInfo, i10, i11, i12);
                                            break;
                                        default:
                                            switch (i10) {
                                                case 64:
                                                    f40881a.q(deviceInfo, i10, i11, i12);
                                                    break;
                                                case 65:
                                                    f40881a.r(deviceInfo, i10, i11, i12);
                                                    break;
                                                case 66:
                                                    f40881a.s(deviceInfo, i10, i11, i12);
                                                    break;
                                                case 67:
                                                    f40881a.o(deviceInfo, i10, i11, i12);
                                                    break;
                                                case 68:
                                                    f40881a.k(deviceInfo, i10, i11, i12);
                                                    break;
                                                case 69:
                                                    f40881a.p(deviceInfo, i10, i11, i12);
                                                    break;
                                                default:
                                                    switch (i10) {
                                                        case 82:
                                                        case 83:
                                                            f40881a.j(deviceInfo, i10, i11, i12);
                                                            break;
                                                        case 84:
                                                        case 86:
                                                        case 87:
                                                            f40881a.m(deviceInfo, i10, i11, i12);
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                        case 25:
                            f40881a.i(deviceInfo, i10, i11, i12);
                            break;
                    }
                }
                f40881a.h(deviceInfo, i10, i11, i12);
                return;
            }
            f40881a.l(deviceInfo, i10, i11, i12);
            return;
        }
        f40881a.g(deviceInfo, i10, i11, i12);
    }

    public static /* synthetic */ void z(GamepadInfo gamepadInfo, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = -1;
        }
        if ((i13 & 8) != 0) {
            i12 = 1;
        }
        y(gamepadInfo, i10, i11, i12);
    }

    public final void a(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40767j);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(true);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(true);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 18, 19, 20, 37, 38, 39, 40, 41, 42));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(105, 107, 109, 111));
    }

    public final void b(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40768k);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(true);
        gamepadInfo.setSupportLed(true);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, Integer.valueOf(m.f40854e0), 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 18, 19, 20, 6, 9, 37, 38, 39, 40, 41, 42, 53, 54));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(105, 107, 109, 111));
    }

    public final void c(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40774q);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(1);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.E());
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(200, Integer.valueOf(mb.e.f41076x1), 223, Integer.valueOf(mb.e.f41040l1)));
        gamepadInfo.setIpType(i10 != 49);
    }

    public final void d(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40778u);
        boolean z10 = false;
        gamepadInfo.setChipType(i11 == -1 ? 0 : i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(true);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(true);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 18, 19, 20, 37, 38, 39, 40, 41, 42));
        gamepadInfo.setBatteryLevelGap(i11 == 1 ? CollectionsKt__CollectionsKt.L(102, 109, 111, 118) : CollectionsKt__CollectionsKt.L(105, 107, 109, 111));
        if (i10 != 20 && i10 != 23) {
            z10 = true;
        }
        gamepadInfo.setIpType(z10);
    }

    public final void e(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40783z);
        int i13 = i11;
        if (i13 == -1) {
            i13 = 1;
        }
        gamepadInfo.setChipType(i13);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(true);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(true);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 18, 19, 20, 37, 38, 39, 40, 41, 42));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(105, 107, 109, 111));
        gamepadInfo.setIpType(i10 != 21);
    }

    public final void f(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        int i13;
        gamepadInfo.setDeviceCode(h.f40782y);
        String deviceName = gamepadInfo.getDeviceName();
        if (deviceName != null && kotlin.text.u.v2(deviceName, com.flydigi.sdk.bluetooth.v.f16329e, false, 2, null)) {
            i13 = 2;
        } else {
            i13 = i11;
            if (i13 == -1) {
                i13 = 1;
            }
        }
        gamepadInfo.setChipType(i13);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(true);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(true);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 18, 19, 20, 37, 38, 39, 40, 41, 42));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(104, 110, 113, 118));
        gamepadInfo.setIpType(i10 != 22);
        gamepadInfo.setSupportSwitch(true);
    }

    public final void g(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        String str = h.f40779v;
        if (i10 != 28 && (i10 == 88 || i10 == 80 || i10 == 81)) {
            str = h.f40780w;
        }
        gamepadInfo.setDeviceCode(str);
        int i13 = i11;
        if (i13 == -1) {
            i13 = 3;
        }
        gamepadInfo.setChipType(i13);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        boolean z10 = false;
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(true);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 37, 38, 12, 10, 13, 11, 39, 40, 41, 42, 6, 9, 20, 19));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(1, 2, 3, 4));
        if (i10 != 28 && i10 != 80) {
            z10 = true;
        }
        gamepadInfo.setIpType(z10);
        gamepadInfo.setSupportSwitch(true);
    }

    public final void h(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(t.j(i10, gamepadInfo.get_deviceName()));
        int i13 = i11;
        if (i13 == -1) {
            i13 = 3;
        }
        gamepadInfo.setChipType(i13);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(true);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 37, 38, 12, 10, 13, 11, 39, 40, 41, 42, 6, 9, 20, 19));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(1, 2, 3, 4));
        gamepadInfo.setIpType(i10 != 85);
        gamepadInfo.setSupportSwitch(true);
    }

    public final void i(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        if (i10 == 31) {
            gamepadInfo.setDeviceCode(h.F);
        } else {
            gamepadInfo.setDeviceCode(h.D);
        }
        gamepadInfo.setChipType(2);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        boolean z10 = false;
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 39, 40, 20, 19));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(1, 2, 3, 4));
        if (i10 != 25 && i10 != 31) {
            z10 = true;
        }
        gamepadInfo.setIpType(z10);
        gamepadInfo.setSupportSwitch(true);
    }

    public final void j(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.E);
        gamepadInfo.setChipType(2);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 39, 40, 20, 19));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(1, 2, 3, 4));
        gamepadInfo.setIpType(i10 != 82);
        gamepadInfo.setSupportSwitch(true);
    }

    public final void k(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.A);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(2);
        if (i11 == -1) {
            i11 = 1;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 12, 14, 256));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(Integer.valueOf(a.c.f52773i), 208, 213, 222));
        gamepadInfo.setIpType(i10 != 68);
    }

    public final void l(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.B);
        int i13 = i11;
        if (i13 == -1) {
            i13 = 1;
        }
        gamepadInfo.setChipType(i13);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(true);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(true);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 19, 39, 40, 41, 42));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(1, 2, 3, 4));
        gamepadInfo.setIpType(i10 != 24);
        gamepadInfo.setSupportSwitch(true);
    }

    public final void m(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.C);
        int i13 = i11;
        if (i13 == -1) {
            i13 = 3;
        }
        gamepadInfo.setChipType(i13);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(true);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 19, 20, 39, 40, 41, 42));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(1, 2, 3, 4, 5));
        gamepadInfo.setIpType(i10 != 84);
        gamepadInfo.setSupportSwitch(true);
    }

    public final void n(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40773p);
        boolean z10 = false;
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(1);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.E());
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.E());
        if (i10 != 48 && i10 != 50) {
            z10 = true;
        }
        gamepadInfo.setIpType(z10);
    }

    public final void o(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        String deviceName = gamepadInfo.getDeviceName();
        boolean z10 = deviceName != null && StringsKt__StringsKt.T2(deviceName, "2t", true);
        gamepadInfo.setDeviceCode(z10 ? h.f40765h : h.f40764g);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(2);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(z10);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 4, 5, 12, 10, 14, 6, 39));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(198, 205, 216, 227));
        gamepadInfo.setIpType(i10 != 67);
    }

    public final void p(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40766i);
        if (i11 == -1) {
            i11 = 1;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(2);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 4, 5, 12, 10, 14, 6, 39));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(198, 205, 216, 227));
        gamepadInfo.setIpType(i10 != 69);
    }

    public final void q(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40760c);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(2);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 4, 5, 12, 10, 14));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(195, 201, 216, 226));
        gamepadInfo.setIpType(i10 != 64);
    }

    public final void r(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40762e);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(2);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 4, 5, 12, 10, 14));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(195, 201, 216, 226));
        gamepadInfo.setIpType(i10 != 65);
    }

    public final void s(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40763f);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(2);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 4, 5, 12, 10, 14));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(195, 201, 216, 226));
        gamepadInfo.setIpType(i10 != 66);
    }

    public final void t(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40769l);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 14));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(Integer.valueOf(a0.f47918w), 198, Integer.valueOf(a.c.f52776l), 214));
        gamepadInfo.setIpType(i10 != 32);
    }

    public final void u(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        String deviceName = gamepadInfo.getDeviceName();
        gamepadInfo.setDeviceCode(deviceName != null && StringsKt__StringsKt.T2(deviceName, "2t", true) ? h.f40771n : h.f40770m);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        String deviceName2 = gamepadInfo.getDeviceName();
        gamepadInfo.setSupportMotion(deviceName2 != null && StringsKt__StringsKt.T2(deviceName2, "2t", true));
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 14, 37, 38));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(Integer.valueOf(a0.f47918w), 198, Integer.valueOf(a.c.f52776l), 214));
        gamepadInfo.setIpType(i10 != 33);
    }

    public final void v(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40772o);
        if (i11 == -1) {
            i11 = 1;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(true);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 14, 37, 38));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(Integer.valueOf(a0.f47918w), 198, Integer.valueOf(a.c.f52776l), 214));
        gamepadInfo.setIpType(i10 != 34);
    }

    public final void w(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40775r);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(true);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(true);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 18, 19, 20));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.L(Integer.valueOf(a0.f47918w), 198, Integer.valueOf(a.c.f52776l), 214));
    }

    public final void x(GamepadInfo gamepadInfo, int i10, int i11, int i12) {
        gamepadInfo.setDeviceCode(h.f40777t);
        if (i11 == -1) {
            i11 = 0;
        }
        gamepadInfo.setChipType(i11);
        gamepadInfo.setMotionChipType(i12);
        gamepadInfo.setDeviceType(i10);
        gamepadInfo.setDeviceMode(0);
        gamepadInfo.setMappingMode(-1);
        gamepadInfo.setUsb0Device(0);
        gamepadInfo.setUsb1Device(0);
        gamepadInfo.setSupportFlashplay(false);
        gamepadInfo.setDriverConnected(false);
        gamepadInfo.setDriverVersion(null);
        gamepadInfo.setBattery(0);
        gamepadInfo.setSupportLinearButton(false);
        gamepadInfo.setSupportMotion(false);
        gamepadInfo.setSupportLunpan(false);
        gamepadInfo.setSupportLed(false);
        gamepadInfo.setSupportMotor(false);
        gamepadInfo.setSupportKeys(CollectionsKt__CollectionsKt.L(240, 241, 14, 15, 4, 5, 7, 8, 0, 1, 2, 3, 12, 10, 13, 11, 6, 9, 18, 19, 20));
        gamepadInfo.setBatteryLevelGap(CollectionsKt__CollectionsKt.E());
    }
}
