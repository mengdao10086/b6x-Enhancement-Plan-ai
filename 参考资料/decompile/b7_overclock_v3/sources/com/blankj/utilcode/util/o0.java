package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f11971a = File.separatorChar;

    public o0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static String B() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
    }

    public static String C() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
    }

    public static String D() {
        return !l1.z0() ? "" : a(Environment.getExternalStorageDirectory());
    }

    public static String E() {
        String strM = m();
        return TextUtils.isEmpty(strM) ? K() : strM;
    }

    public static String F() {
        return a(j1.a().getCacheDir());
    }

    public static String G() {
        return a(j1.a().getCodeCacheDir());
    }

    public static String H() {
        return Build.VERSION.SDK_INT < 24 ? j1.a().getApplicationInfo().dataDir : a(j1.a().getDataDir());
    }

    public static String I(String str) {
        return a(j1.a().getDatabasePath(str));
    }

    public static String J() {
        return j1.a().getApplicationInfo().dataDir + "/databases";
    }

    public static String K() {
        return a(j1.a().getFilesDir());
    }

    public static String L() {
        return a(j1.a().getNoBackupFilesDir());
    }

    public static String M() {
        return j1.a().getApplicationInfo().dataDir + "/shared_prefs";
    }

    public static String N(String str) {
        char[] charArray = str.toCharArray();
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < charArray.length; i12++) {
            if (charArray[i12] != f11971a) {
                if (i10 == -1) {
                    i10 = i12;
                }
                i11 = i12;
            }
        }
        if (i10 >= 0 && i11 >= i10) {
            return str.substring(i10, i11 + 1);
        }
        throw new IllegalArgumentException("segment of <" + str + "> is illegal");
    }

    public static String O() {
        return a(Environment.getRootDirectory());
    }

    public static String P() {
        String strD = D();
        return TextUtils.isEmpty(strD) ? O() : strD;
    }

    public static String Q(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str == null) {
            str = "";
        }
        int length = str.length();
        String strN = N(str2);
        if (length == 0) {
            return f11971a + strN;
        }
        char cCharAt = str.charAt(length - 1);
        char c10 = f11971a;
        if (cCharAt == c10) {
            return str + strN;
        }
        return str + c10 + strN;
    }

    public static String a(File file) {
        return file == null ? "" : file.getAbsolutePath();
    }

    public static String b() {
        String strI = i();
        return TextUtils.isEmpty(strI) ? H() : strI;
    }

    public static String c() {
        String strH = h();
        return TextUtils.isEmpty(strH) ? F() : strH;
    }

    public static String d() {
        return a(Environment.getDataDirectory());
    }

    public static String e() {
        return a(Environment.getDownloadCacheDirectory());
    }

    public static String f() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
    }

    public static String g() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_ALARMS));
    }

    public static String h() {
        return !l1.z0() ? "" : a(j1.a().getExternalCacheDir());
    }

    public static String i() {
        File externalCacheDir;
        return (l1.z0() && (externalCacheDir = j1.a().getExternalCacheDir()) != null) ? a(externalCacheDir.getParentFile()) : "";
    }

    public static String j() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_DCIM));
    }

    public static String k() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));
    }

    public static String l() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String m() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(null));
    }

    public static String n() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_MOVIES));
    }

    public static String o() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_MUSIC));
    }

    public static String p() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS));
    }

    public static String q() {
        return !l1.z0() ? "" : a(j1.a().getObbDir());
    }

    public static String r() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    public static String s() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_PODCASTS));
    }

    public static String t() {
        return !l1.z0() ? "" : a(j1.a().getExternalFilesDir(Environment.DIRECTORY_RINGTONES));
    }

    public static String u() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    public static String v() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
    }

    public static String w() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String x() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
    }

    public static String y() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
    }

    public static String z() {
        return !l1.z0() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
    }
}
