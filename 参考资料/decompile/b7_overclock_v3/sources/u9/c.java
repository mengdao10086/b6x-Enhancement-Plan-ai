package u9;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InputDevice;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.e0;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.x;
import com.flydigi.data.DataConstant;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.umeng.socialize.common.SocializeConstants;
import o5.m;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static String a(Context context) {
        String str = ((((g() + "\r\n" + d()) + "\r\n" + f(context)) + "\r\n" + b(context)) + "\r\n" + c(context)) + "\r\n" + e(context);
        String strQ = m.i().q(DataConstant.SP_DEVICE_HAS_WASPWING_CONNECTED);
        if (!n0.x(strQ)) {
            return str;
        }
        return str + "\r\n" + h(strQ);
    }

    public static String b(Context context) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Developer Option:");
            sb2.append("\r\n\t开发者选项：");
            String str = "已开启";
            sb2.append(o5.b.e(context) ? "已开启" : "未开启");
            String string = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append("\r\n\tUSB调试：");
            sb3.append(o5.b.k(context) ? "已开启" : "未开启");
            String string2 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(string2);
            sb4.append("\r\n\t网络ADB调试：");
            sb4.append(o5.b.i(context) ? "已开启" : "未开启");
            String string3 = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(string3);
            sb5.append("\r\n\t无线调试：");
            sb5.append(o5.b.m(context) ? "已开启" : "未开启");
            String string4 = sb5.toString();
            if (o5.h.l() || o5.h.d()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(string4);
                sb6.append("\r\n\tUSB调试（安全选项）：");
                sb6.append(o5.b.l() ? "已开启" : "未开启");
                string4 = sb6.toString();
            }
            if (!o5.h.h()) {
                return string4;
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(string4);
            sb7.append("\r\n\t\"仅充电\"模式下允许ADB调试：");
            sb7.append(o5.b.f(context) ? "已开启" : "未开启");
            String string5 = sb7.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(string5);
            sb8.append("\r\n\t连接USB时总是弹出提示：");
            if (!o5.b.g(context)) {
                str = "未开启";
            }
            sb8.append(str);
            return sb8.toString();
        } catch (Exception unused) {
            return "Developer Option:";
        }
    }

    public static String c(Context context) {
        StringBuilder sb2 = new StringBuilder("DisplayInfo:\r\n");
        for (Display display : ((DisplayManager) context.getSystemService("display")).getDisplays()) {
            display.getRealMetrics(new DisplayMetrics());
            sb2.append("\t");
            sb2.append(display.toString());
            sb2.append("\r\n");
        }
        return sb2.toString();
    }

    public static String d() {
        String str = "Gamepad Info：\r\n\t产品型号：" + v5.a.j().g() + "（" + v5.a.j().e() + "）";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("\r\n\t芯片类型：");
        sb2.append(v5.a.j().d().getChipType() == 1 ? "WCH" : "NORDIC");
        return ((sb2.toString() + "\r\n\t映射模式：" + v5.a.j().d().getReadableMappingMode()) + "\r\n\t固件版本：" + v5.a.j().c()) + "\r\n\t驱动版本：" + v5.a.j().h();
    }

    public static String e(Context context) {
        StringBuilder sb2 = new StringBuilder("InputInfo:\r\n");
        InputManager inputManager = (InputManager) context.getSystemService("input");
        for (int i10 : inputManager.getInputDeviceIds()) {
            InputDevice inputDevice = inputManager.getInputDevice(i10);
            sb2.append("\t");
            sb2.append(inputDevice.toString());
            sb2.append("\r\n");
        }
        return sb2.toString();
    }

    public static String f(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Permission Info：");
        sb2.append("\r\n\t悬浮窗权限：");
        sb2.append(o5.d.o(context) ? "已开启" : "未开启");
        String string = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(string);
        sb3.append("\r\n\t定位权限：");
        sb3.append(PermissionUtils.z("android.permission.ACCESS_FINE_LOCATION") ? "已开启" : "未开启");
        String string2 = sb3.toString();
        LocationManager locationManager = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        int i10 = Build.VERSION.SDK_INT;
        boolean zIsLocationEnabled = i10 >= 28 ? locationManager.isLocationEnabled() : locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("passive");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(string2);
        sb4.append("\r\n\t位置服务：");
        sb4.append(zIsLocationEnabled ? "已开启" : "未开启");
        String string3 = sb4.toString();
        if (i10 < 23) {
            return string3;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(string3);
        sb5.append("\r\n\t忽略省电：");
        sb5.append(o5.b.h(context) ? "已开启" : "未开启");
        return sb5.toString();
    }

    public static String g() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Basic Info:\r\n\t");
        sb2.append(x.b());
        sb2.append("\r\n\t");
        sb2.append(Build.MANUFACTURER);
        sb2.append(fh.a.f28350w);
        sb2.append(Build.MODEL);
        sb2.append(fh.a.f28350w);
        sb2.append(Build.DISPLAY);
        sb2.append("\r\n\tAndroid ");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append(ee.a.f26978c);
        int i10 = Build.VERSION.SDK_INT;
        sb2.append(i10);
        sb2.append(ee.a.f26979d);
        String string = sb2.toString();
        if (i10 < 23) {
            return string;
        }
        return string + "\r\n\tSECURITY_PATCH:" + Build.VERSION.SECURITY_PATCH;
    }

    public static String h(String radiator) {
        WaspWingInfo waspWingInfo = (WaspWingInfo) e0.h(radiator, WaspWingInfo.class);
        if (waspWingInfo == null) {
            return "";
        }
        String str = (("Radiator Info：\r\n\t产品型号：" + a5.b.c(waspWingInfo.getDeviceCode()) + "（" + waspWingInfo.getAddress() + "）") + "\r\n\t固件版本：" + waspWingInfo.getFirmwareVersion()) + "\r\n\t运行模式：";
        int runMode = waspWingInfo.getRunMode();
        if (runMode != 0) {
            if (runMode == 1) {
                return str + "手动调节";
            }
            if (runMode != 2) {
                return str;
            }
            return str + "手动调节（已超频）";
        }
        String str2 = str + "智能变频";
        int runModeSmartLevel = (int) waspWingInfo.getRunModeSmartLevel();
        if (runModeSmartLevel == 0) {
            return str2 + "-静音";
        }
        if (runModeSmartLevel == 1) {
            return str2 + "-标准";
        }
        if (runModeSmartLevel != 2) {
            return str2;
        }
        String str3 = str2 + "-极寒";
        if (!waspWingInfo.getOverClockUsable()) {
            return str3;
        }
        return str3 + "（已超频）";
    }
}
