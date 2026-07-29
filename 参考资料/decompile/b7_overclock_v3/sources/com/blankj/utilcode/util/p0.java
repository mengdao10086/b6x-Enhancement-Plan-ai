package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {
    public p0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @g.y0("android.permission.CALL_PHONE")
    public static void a(String str) {
        j1.a().startActivity(l1.M(str));
    }

    public static void b(String str) {
        j1.a().startActivity(l1.O(str));
    }

    @g.y0("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds"})
    public static String c() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            return "";
        }
        TelephonyManager telephonyManagerN = n();
        String deviceId = telephonyManagerN.getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        if (i10 < 26) {
            return "";
        }
        String imei = telephonyManagerN.getImei();
        if (!TextUtils.isEmpty(imei)) {
            return imei;
        }
        String meid = telephonyManagerN.getMeid();
        return TextUtils.isEmpty(meid) ? "" : meid;
    }

    @g.y0("android.permission.READ_PHONE_STATE")
    public static String d() {
        return f(true);
    }

    @g.y0("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds"})
    public static String e() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                n().getSubscriberId();
            } catch (SecurityException e10) {
                e10.printStackTrace();
                return "";
            }
        }
        return n().getSubscriberId();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6 A[PHI: r0
  0x00b6: PHI (r0v7 java.lang.String) = (r0v5 java.lang.String), (r0v5 java.lang.String), (r0v9 java.lang.String), (r0v9 java.lang.String) binds: [B:52:0x00ad, B:54:0x00b3, B:43:0x0099, B:45:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    @g.y0("android.permission.READ_PHONE_STATE")
    @android.annotation.SuppressLint({"HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(boolean r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 29
            if (r0 < r2) goto L9
            return r1
        L9:
            android.telephony.TelephonyManager r2 = n()
            r3 = 26
            r4 = 1
            r5 = 0
            if (r0 < r3) goto L2f
            if (r10 == 0) goto L22
            java.lang.String r10 = r2.getImei(r5)
            java.lang.String r0 = r2.getImei(r4)
            java.lang.String r10 = h(r10, r0)
            return r10
        L22:
            java.lang.String r10 = r2.getMeid(r5)
            java.lang.String r0 = r2.getMeid(r4)
            java.lang.String r10 = h(r10, r0)
            return r10
        L2f:
            if (r10 == 0) goto L34
            java.lang.String r0 = "ril.gsm.imei"
            goto L36
        L34:
            java.lang.String r0 = "ril.cdma.meid"
        L36:
            java.lang.String r0 = m(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r6 = 2
            if (r3 != 0) goto L56
            java.lang.String r10 = ","
            java.lang.String[] r10 = r0.split(r10)
            int r0 = r10.length
            if (r0 != r6) goto L53
            r0 = r10[r5]
            r10 = r10[r4]
            java.lang.String r10 = h(r0, r10)
            return r10
        L53:
            r10 = r10[r5]
            return r10
        L56:
            java.lang.String r0 = r2.getDeviceId()
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            java.lang.String r7 = "getDeviceId"
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            r8[r5] = r9     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            java.lang.reflect.Method r3 = r3.getMethod(r7, r8)     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            if (r10 == 0) goto L6f
            goto L70
        L6f:
            r4 = 2
        L70:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            r7[r5] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            java.lang.Object r2 = r3.invoke(r2, r7)     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.reflect.InvocationTargetException -> L7d java.lang.IllegalAccessException -> L82 java.lang.NoSuchMethodException -> L87
            goto L8c
        L7d:
            r2 = move-exception
            r2.printStackTrace()
            goto L8b
        L82:
            r2 = move-exception
            r2.printStackTrace()
            goto L8b
        L87:
            r2 = move-exception
            r2.printStackTrace()
        L8b:
            r2 = r1
        L8c:
            if (r10 == 0) goto La2
            r10 = 15
            if (r0 == 0) goto L99
            int r3 = r0.length()
            if (r3 >= r10) goto L99
            r0 = r1
        L99:
            if (r2 == 0) goto Lb6
            int r3 = r2.length()
            if (r3 >= r10) goto Lb6
            goto Lb7
        La2:
            r10 = 14
            if (r0 == 0) goto Lad
            int r3 = r0.length()
            if (r3 != r10) goto Lad
            r0 = r1
        Lad:
            if (r2 == 0) goto Lb6
            int r3 = r2.length()
            if (r3 != r10) goto Lb6
            goto Lb7
        Lb6:
            r1 = r2
        Lb7:
            java.lang.String r10 = h(r0, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.p0.f(boolean):java.lang.String");
    }

    @g.y0("android.permission.READ_PHONE_STATE")
    public static String g() {
        return f(false);
    }

    public static String h(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        return (zIsEmpty && zIsEmpty2) ? "" : (zIsEmpty || zIsEmpty2) ? !zIsEmpty ? str : str2 : str.compareTo(str2) <= 0 ? str : str2;
    }

    public static int i() {
        return n().getPhoneType();
    }

    @g.y0("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds"})
    public static String j() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 29) {
            return i10 >= 26 ? Build.getSerial() : Build.SERIAL;
        }
        try {
            return Build.getSerial();
        } catch (SecurityException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String k() {
        String simOperator = n().getSimOperator();
        if (simOperator == null) {
            return "";
        }
        switch (simOperator) {
            case "46000":
            case "46002":
            case "46007":
            case "46020":
                return "中国移动";
            case "46001":
            case "46006":
            case "46009":
                return "中国联通";
            case "46003":
            case "46005":
            case "46011":
                return "中国电信";
            default:
                return simOperator;
        }
    }

    public static String l() {
        return n().getSimOperatorName();
    }

    public static String m(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static TelephonyManager n() {
        return (TelephonyManager) j1.a().getSystemService("phone");
    }

    public static boolean o() {
        return n().getPhoneType() != 0;
    }

    public static boolean p() {
        return n().getSimState() == 5;
    }

    public static void q(String str, String str2) {
        j1.a().startActivity(l1.c0(str, str2));
    }
}
