package com.tencent.open.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.webkit.WebSettings;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class i {
    public static String a(int i10) {
        if (i10 == 10103) {
            return "shareToQQ";
        }
        if (i10 == 10104) {
            return "shareToQzone";
        }
        if (i10 == 10105) {
            return "addToQQFavorites";
        }
        if (i10 == 10106) {
            return "sendToMyComputer";
        }
        if (i10 == 10107) {
            return "shareToTroopBar";
        }
        if (i10 == 11101) {
            return "action_login";
        }
        if (i10 == 10100) {
            return "action_request";
        }
        return null;
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String b(Context context, String str) {
        String strA = "";
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            String strA2 = k.a(messageDigest.digest());
            messageDigest.reset();
            SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + strA2);
            messageDigest.update(k.j(packageName + "_" + strA2 + "_" + str + ""));
            strA = k.a(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("-->signEncryped: ");
            sb2.append(strA);
            SLog.v("openSDK_LOG.SystemUtils", sb2.toString());
            return strA;
        } catch (Exception e10) {
            e10.printStackTrace();
            SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e10);
            return strA;
        }
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int d(Context context, String str) {
        return a(a(context, Constants.PACKAGE_TIM), str);
    }

    public static int e(Context context, String str) {
        return a(a(context, Constants.PACKAGE_QQ_SPEED), str);
    }

    private static boolean f(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            SLog.e("openSDK_LOG.SystemUtils", "PackageManager.NameNotFoundException " + str, e10);
            return false;
        } catch (Exception e11) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e11);
            return false;
        }
    }

    public static boolean c(Context context) {
        boolean zF = f(context, "com.tencent.mobileqq");
        boolean zF2 = f(context, Constants.PACKAGE_TIM);
        boolean zF3 = f(context, Constants.PACKAGE_QQ_PAD);
        boolean zF4 = f(context, Constants.PACKAGE_QQ_SPEED);
        SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq=" + zF + ", tim=" + zF2 + ", pad=" + zF3 + ", speed=" + zF4);
        return zF || zF2 || zF3 || zF4;
    }

    public static boolean d(Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !a();
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int i10 = 0;
        while (i10 < strArrSplit.length && i10 < strArrSplit2.length) {
            try {
                int i11 = Integer.parseInt(strArrSplit[i10]);
                int i12 = Integer.parseInt(strArrSplit2[i10]);
                if (i11 < i12) {
                    return -1;
                }
                if (i11 > i12) {
                    return 1;
                }
                i10++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (strArrSplit.length > i10) {
            return 1;
        }
        return strArrSplit2.length > i10 ? -1 : 0;
    }

    public static boolean a(Context context, String str, String str2) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (k.g(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static String a(Activity activity, String str) {
        if (activity == null) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] bArrA = e.a(str);
            if (bArrA == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(bArrA, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArrA, 8, bArr2, 0, 16);
            return e.a(activity.getPackageName(), e.a(bArr2), bArr);
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e10);
            return "";
        }
    }

    public static boolean b(Context context) {
        boolean zF = f(context, "com.tencent.mobileqq");
        SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled " + zF);
        return zF;
    }

    public static boolean a(Context context, Intent intent) {
        return (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.lang.String r10, java.lang.String r11, int r12) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.i.a(java.lang.String, java.lang.String, int):boolean");
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr, 0, 8192);
            if (i10 != -1) {
                outputStream.write(bArr, 0, i10);
                j10 += (long) i10;
            } else {
                SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j10);
                return j10;
            }
        }
    }

    public static int a(String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return 11101;
        }
        if ("action_request".equals(str)) {
            return Constants.REQUEST_API;
        }
        return -1;
    }

    public static String a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
            SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e10) {
            SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e10);
            return null;
        } catch (Exception e11) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e11);
            return null;
        }
    }

    private static boolean a() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static void a(WebSettings webSettings) {
        try {
            webSettings.setSavePassword(false);
            webSettings.setAllowFileAccess(false);
            webSettings.setAllowFileAccessFromFileURLs(false);
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e10);
        }
    }
}
