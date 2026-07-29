package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.blankj.utilcode.util.a1;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12023a = "KEY_UDID";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f12024b;

    public x() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean A() {
        return (Resources.getSystem().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String B(String str, String str2) {
        f12024b = n(str, str2);
        l1.d0().B(f12023a, f12024b);
        return f12024b;
    }

    @g.y0("android.permission.CHANGE_WIFI_STATE")
    public static void C(boolean z10) {
        WifiManager wifiManager = (WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        if (wifiManager == null || z10 == wifiManager.isWifiEnabled()) {
            return;
        }
        wifiManager.setWifiEnabled(z10);
    }

    public static String[] a() {
        return Build.SUPPORTED_ABIS;
    }

    @SuppressLint({"HardwareIds"})
    public static String b() {
        String string = Settings.Secure.getString(j1.a().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        return ("9774d56d682e549c".equals(string) || string == null) ? "" : string;
    }

    public static InetAddress c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && inetAddressNextElement.getHostAddress().indexOf(58) < 0) {
                            return inetAddressNextElement;
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"})
    public static String d() {
        String strE = e(null);
        if (!TextUtils.isEmpty(strE) || t()) {
            return strE;
        }
        C(true);
        C(false);
        return e(null);
    }

    @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE"})
    public static String e(String... strArr) {
        String strH = h();
        if (v(strH, strArr)) {
            return strH;
        }
        String strG = g();
        if (v(strG, strArr)) {
            return strG;
        }
        String strI = i();
        if (v(strI, strArr)) {
            return strI;
        }
        String strF = f();
        return v(strF, strArr) ? strF : "";
    }

    public static String f() {
        String str;
        String str2;
        a1.b bVarB = l1.B("getprop wifi.interface", false);
        if (bVarB.f11696a != 0 || (str = bVarB.f11697b) == null) {
            return "02:00:00:00:00:00";
        }
        a1.b bVarB2 = l1.B("cat /sys/class/net/" + str + "/address", false);
        return (bVarB2.f11696a != 0 || (str2 = bVarB2.f11697b) == null || str2.length() <= 0) ? "02:00:00:00:00:00" : str2;
    }

    public static String g() {
        NetworkInterface byInetAddress;
        byte[] hardwareAddress;
        try {
            InetAddress inetAddressC = c();
            if (inetAddressC == null || (byInetAddress = NetworkInterface.getByInetAddress(inetAddressC)) == null || (hardwareAddress = byInetAddress.getHardwareAddress()) == null || hardwareAddress.length <= 0) {
                return "02:00:00:00:00:00";
            }
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : hardwareAddress) {
                sb2.append(String.format("%02x:", Byte.valueOf(b10)));
            }
            return sb2.substring(0, sb2.length() - 1);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String h() {
        byte[] hardwareAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null && networkInterfaceNextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b10 : hardwareAddress) {
                        sb2.append(String.format("%02x:", Byte.valueOf(b10)));
                    }
                    return sb2.substring(0, sb2.length() - 1);
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    @g.y0("android.permission.ACCESS_WIFI_STATE")
    public static String i() {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) j1.a().getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "02:00:00:00:00:00";
            }
            String macAddress = connectionInfo.getMacAddress();
            return !TextUtils.isEmpty(macAddress) ? macAddress : "02:00:00:00:00:00";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String j() {
        return Build.MANUFACTURER;
    }

    public static String k() {
        String str = Build.MODEL;
        return str != null ? str.trim().replaceAll("\\s*", "") : "";
    }

    public static int l() {
        return Build.VERSION.SDK_INT;
    }

    public static String m() {
        return Build.VERSION.RELEASE;
    }

    public static String n(String str, String str2) {
        if (str2.equals("")) {
            return str + UUID.randomUUID().toString().replace("-", "");
        }
        return str + UUID.nameUUIDFromBytes(str2.getBytes()).toString().replace("-", "");
    }

    public static String o() {
        return q("", true);
    }

    public static String p(String str) {
        return q(str, true);
    }

    public static String q(String str, boolean z10) {
        if (!z10) {
            return s(str);
        }
        if (f12024b == null) {
            synchronized (x.class) {
                if (f12024b == null) {
                    String strR = l1.d0().r(f12023a, null);
                    if (strR == null) {
                        return s(str);
                    }
                    f12024b = strR;
                    return f12024b;
                }
            }
        }
        return f12024b;
    }

    public static String r(boolean z10) {
        return q("", z10);
    }

    public static String s(String str) {
        try {
            String strB = b();
            if (!TextUtils.isEmpty(strB)) {
                return B(str + 2, strB);
            }
        } catch (Exception unused) {
        }
        return B(str + 9, "");
    }

    public static boolean t() {
        WifiManager wifiManager = (WifiManager) j1.a().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    @g.v0(api = 17)
    public static boolean u() {
        return Settings.Secure.getInt(j1.a().getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static boolean v(String str, String... strArr) {
        if (TextUtils.isEmpty(str) || "02:00:00:00:00:00".equals(str)) {
            return false;
        }
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (str2 != null && str2.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    @g.v0(api = 17)
    public static boolean w() {
        return Settings.Global.getInt(j1.a().getContentResolver(), "development_settings_enabled", 0) > 0;
    }

    public static boolean x() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/", "/system/sbin/", "/usr/bin/", "/vendor/bin/"};
        for (int i10 = 0; i10 < 11; i10++) {
            if (new File(strArr[i10] + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean y() {
        /*
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r1 = "generic"
            boolean r2 = r0.startsWith(r1)
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L63
            java.lang.String r2 = r0.toLowerCase()
            java.lang.String r5 = "vbox"
            boolean r2 = r2.contains(r5)
            if (r2 != 0) goto L63
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r2 = "test-keys"
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L63
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r2 = "google_sdk"
            boolean r5 = r0.contains(r2)
            if (r5 != 0) goto L63
            java.lang.String r5 = "Emulator"
            boolean r5 = r0.contains(r5)
            if (r5 != 0) goto L63
            java.lang.String r5 = "Android SDK built for x86"
            boolean r0 = r0.contains(r5)
            if (r0 != 0) goto L63
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r5 = "Genymotion"
            boolean r0 = r0.contains(r5)
            if (r0 != 0) goto L63
            java.lang.String r0 = android.os.Build.BRAND
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L58
            java.lang.String r0 = android.os.Build.DEVICE
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L63
        L58:
            java.lang.String r0 = android.os.Build.PRODUCT
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L61
            goto L63
        L61:
            r0 = 0
            goto L64
        L63:
            r0 = 1
        L64:
            if (r0 == 0) goto L67
            return r4
        L67:
            android.app.Application r0 = com.blankj.utilcode.util.j1.a()
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            if (r0 == 0) goto L7c
            java.lang.String r0 = r0.getNetworkOperatorName()
            if (r0 == 0) goto L7c
            goto L7e
        L7c:
            java.lang.String r0 = ""
        L7e:
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "android"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8b
            return r4
        L8b:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = "tel:123456"
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r0.setData(r1)
            java.lang.String r1 = "android.intent.action.DIAL"
            r0.setAction(r1)
            android.app.Application r1 = com.blankj.utilcode.util.j1.a()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            android.content.ComponentName r0 = r0.resolveActivity(r1)
            if (r0 != 0) goto Lae
            r0 = 1
            goto Laf
        Lae:
            r0 = 0
        Laf:
            if (r0 == 0) goto Lb2
            return r4
        Lb2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.x.y():boolean");
    }

    @g.y0(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET", "android.permission.CHANGE_WIFI_STATE"})
    public static boolean z(String str) {
        if (TextUtils.isEmpty(str) && str.length() < 33) {
            return false;
        }
        if (str.equals(f12024b) || str.equals(l1.d0().r(f12023a, null))) {
            return true;
        }
        int length = str.length() - 33;
        int i10 = length + 1;
        String strSubstring = str.substring(length, i10);
        if (strSubstring.startsWith("1")) {
            String strD = d();
            if (strD.equals("")) {
                return false;
            }
            return str.substring(i10).equals(n("", strD));
        }
        if (!strSubstring.startsWith("2")) {
            return false;
        }
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        return str.substring(i10).equals(n("", strB));
    }
}
