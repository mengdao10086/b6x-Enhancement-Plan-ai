package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RuntimeException f23089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static RuntimeException f23090b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f23091c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static CustomInfo f23092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static VersionInfo f23093e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f23095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f23096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f23097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f23098j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f23094f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f23099k = new Object();

    public static int A() {
        return f23092d.mLogMaxBytesLimit;
    }

    public static int B() {
        return f23092d.mLogMaxUploadBytesLimit;
    }

    public static long C() {
        return f23092d.mMaxUploadBytesPerDay;
    }

    public static int D() {
        return f23092d.mMaxUploadBuiltinLogCountPerDay;
    }

    public static int E() {
        return f23092d.mMaxUploadCustomLogCountPerDay;
    }

    public static int F() {
        return f23092d.mMaxCustomLogCountPerTypePerDay;
    }

    public static int G() {
        return f23092d.mInfoUpdateInterval;
    }

    public static int H() {
        return f23092d.mInfoSaveFrequency;
    }

    public static int I() {
        return f23092d.mReservedJavaFileHandleCount;
    }

    public static int J() {
        return f23092d.mFdDumpMinLimit;
    }

    public static int K() {
        return f23092d.mThreadsDumpMinLimit;
    }

    public static boolean L() {
        return f23092d.mAutoDetectLifeCycle;
    }

    public static boolean M() {
        return f23092d.mMonitorBattery;
    }

    public static int N() {
        return f23092d.mAnrTraceStrategy;
    }

    public static boolean O() {
        CustomInfo customInfo = f23092d;
        return customInfo == null || customInfo.mDebug;
    }

    public static boolean P() {
        CustomInfo customInfo = f23092d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean Q() {
        return f23092d.mEnableStatReport;
    }

    public static boolean R() {
        return f23092d.mIsInternational;
    }

    public static boolean S() {
        return f23092d.mAddPvForNewDay;
    }

    public static String T() {
        return com.uc.crashsdk.a.g.a(f23093e.mVersion) ? a.a() : a(f23093e.mVersion);
    }

    public static String U() {
        return com.uc.crashsdk.a.g.a(f23093e.mSubVersion) ? "release" : f23093e.mSubVersion;
    }

    public static String V() {
        return com.uc.crashsdk.a.g.a(f23093e.mBuildId) ? ad() : a(f23093e.mBuildId);
    }

    public static String W() {
        if (f23096h == null) {
            f23096h = com.uc.crashsdk.a.g.b() + File.separatorChar + f23092d.mTagFilesFolderName + File.separatorChar;
        }
        return f23096h;
    }

    public static String X() {
        if (f23097i == null) {
            f23097i = com.uc.crashsdk.a.g.b() + File.separatorChar + f23092d.mCrashLogsFolderName + File.separatorChar;
        }
        return f23097i;
    }

    public static String Y() {
        if (f23098j == null) {
            if (com.uc.crashsdk.a.g.a(f23092d.mLogsBackupPathName)) {
                f23098j = (com.uc.crashsdk.a.g.b() + File.separatorChar + "msdb" + File.separatorChar) + File.separatorChar + f23092d.mCrashLogsFolderName + File.separatorChar;
            } else {
                String strTrim = f23092d.mLogsBackupPathName.trim();
                String str = File.separator;
                if (!strTrim.endsWith(str)) {
                    strTrim = strTrim + str;
                }
                f23098j = strTrim;
            }
        }
        return f23098j;
    }

    public static boolean Z() {
        return f23092d.mEnableCrpStat;
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        f23092d = customInfo2;
        c(customInfo2);
        if (!f23092d.mZipLog) {
            f23089a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (f23092d.mEncryptLog) {
            f23090b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        f23093e = new VersionInfo(versionInfo);
        if (b.L()) {
            return;
        }
        try {
            a();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
    }

    public static boolean aa() {
        return f23092d.mEnableStatToWPKDirect;
    }

    public static String ab() {
        return f23092d.mUserId;
    }

    public static String ac() {
        return f23092d.mChannel;
    }

    private static String ad() {
        ZipFile zipFile;
        Throwable th2;
        String str = f23095g;
        if (str != null) {
            return str;
        }
        try {
            try {
                zipFile = new ZipFile(com.uc.crashsdk.a.g.c());
                try {
                    f23095g = Long.toHexString(zipFile.getEntry("classes.dex").getCrc());
                    com.uc.crashsdk.a.a.a("crashsdk", "version unique build id: " + f23095g);
                    zipFile.close();
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        f23095g = "";
                        com.uc.crashsdk.a.g.a(th2);
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return f23095g;
                    } catch (Throwable th4) {
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th4;
                    }
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th5) {
            zipFile = null;
            th2 = th5;
        }
        return f23095g;
    }

    private static void ae() {
        if (b.f23003d) {
            JNIBridge.nativeSet(24, 1L, a.f22910b, null);
        }
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, f23092d.mTagFilesFolderName);
        JNIBridge.set(105, f23092d.mCrashLogsFolderName);
        JNIBridge.set(106, Y());
        JNIBridge.set(107, e.h());
        JNIBridge.set(108, b.a());
        JNIBridge.set(109, T());
        JNIBridge.set(110, U());
        JNIBridge.set(111, V());
        JNIBridge.set(112, "211215141717");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, e.q());
        JNIBridge.set(5, f23092d.mCallNativeDefaultHandler);
        JNIBridge.set(6, f23092d.mDumpUserSolibBuildId);
        JNIBridge.set(7, f23092d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, f23092d.mNativeCrashLogFileName);
        JNIBridge.set(101, f23092d.mUnexpCrashLogFileName);
        JNIBridge.set(35, f23092d.mEnableMemoryGroup);
        JNIBridge.set(36, f23092d.mEnableLibcMallocDetail);
        JNIBridge.set(131, f23092d.mLibcMallocDetailConfig);
        JNIBridge.set(102, f23092d.mAppId);
        JNIBridge.set(38, f23092d.mCrashRateUploadUrl);
        JNIBridge.set(39, f23092d.mCrashSDKAuthUrl);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mZippedLogExtension.equals(".tmp")) {
            throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
        long jB = e.b();
        if (jB >= 1) {
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = 268435456L;
            customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
            customInfo.mMaxUploadCustomLogCountPerDay = 2000;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (jB >= 2) {
                customInfo.mSyncUploadSetupCrashLogs = true;
                customInfo.mSyncUploadLogs = true;
                if (jB >= 3) {
                    customInfo.mBackupLogs = true;
                    customInfo.mPrintStackInfos = true;
                    customInfo.mDebug = true;
                }
            }
        }
    }

    public static void d() {
        JNIBridge.set(23, f23092d.mIsInternational);
        if (b.H()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, f23092d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, f23092d.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(b.B());
        JNIBridge.set(2, b.F());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(113, a.f22909a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, f23092d.mThreadsDumpMinLimit);
        JNIBridge.set(122, a.a());
        JNIBridge.set(33, a.c());
        ae();
        b.K();
        b.D();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return f23092d.mAppId;
    }

    public static boolean f() {
        if (com.uc.crashsdk.a.g.b(f23092d.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(f23092d.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(f23092d.mUnexpCrashLogFileName);
    }

    public static String g() {
        return f23092d.mJavaCrashLogFileName;
    }

    public static int h() {
        return f23092d.mCrashRestartInterval;
    }

    public static boolean i() {
        return f23092d.mCallJavaDefaultHandler;
    }

    public static boolean j() {
        return f23092d.mDumpHprofDataForJavaOOM;
    }

    public static boolean k() {
        return f23092d.mRenameFileToDefaultName;
    }

    public static int l() {
        return f23092d.mMaxBuiltinLogFilesCount;
    }

    public static int m() {
        return f23092d.mMaxCustomLogFilesCount;
    }

    public static int n() {
        return f23092d.mMaxJavaLogcatLineCount;
    }

    public static int o() {
        return f23092d.mUnexpDelayMillSeconds;
    }

    public static int p() {
        return f23092d.mUnexpSubTypes;
    }

    public static boolean q() {
        return f23092d.mBackupLogs;
    }

    public static boolean r() {
        return f23092d.mSyncUploadSetupCrashLogs;
    }

    public static boolean s() {
        return f23092d.mSyncUploadLogs;
    }

    public static boolean t() {
        return f23092d.mOmitJavaCrash;
    }

    public static boolean u() {
        return f23092d.mAutoDeleteOldVersionStats;
    }

    public static boolean v() {
        return f23092d.mZipLog;
    }

    public static String w() {
        return f23092d.mZippedLogExtension;
    }

    public static boolean x() {
        return f23092d.mEncryptLog;
    }

    public static String y() {
        return f23092d.mCrashLogUploadUrl;
    }

    public static String z() {
        return f23092d.mCrashRateUploadUrl;
    }

    public static void a(CustomInfo customInfo) {
        boolean z10 = f23091c;
        if (!z10 && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!z10 && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f23094f) {
            f23093e = new VersionInfo(versionInfo);
            e.c();
            if (b.f23003d) {
                JNIBridge.set(109, T());
                JNIBridge.set(110, U());
                JNIBridge.set(111, V());
                JNIBridge.set(112, "211215141717");
                JNIBridge.cmd(2);
            }
        }
    }

    public static void a() {
        b.y();
        b.x();
        if (f23092d.mBackupLogs) {
            File file = new File(Y());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static void c() {
        JNIBridge.set(11, P());
        JNIBridge.set(12, f23092d.mBackupLogs);
        JNIBridge.set(13, f23092d.mCrashRestartInterval);
        JNIBridge.set(14, f23092d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, f23092d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, f23092d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, f23092d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, O());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, f23092d.mOmitNativeCrash);
        JNIBridge.set(32, f23092d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, f23092d.mDisableSignals);
        JNIBridge.set(9, f23092d.mDisableBackgroundSignals);
        CustomInfo customInfo = f23092d;
        JNIBridge.nativeSet(3, customInfo.mZipLog ? 1L : 0L, customInfo.mZippedLogExtension, null);
        JNIBridge.set(4, f23092d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    private static String a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", "-");
    }

    public static int b(CustomInfo customInfo) {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        synchronized (f23099k) {
            i10 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (f23092d == null) {
                    f23092d = new CustomInfo();
                }
                CustomInfo customInfo2 = f23092d;
                boolean z12 = true;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i11 = 0;
                    z10 = false;
                } else {
                    String str = customInfo.mAppId;
                    customInfo2.mAppId = str;
                    if (b.f23003d) {
                        JNIBridge.set(102, str);
                    }
                    i11 = 1;
                    z10 = true;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i11++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    String str2 = customInfo.mNativeCrashLogFileName;
                    customInfo2.mNativeCrashLogFileName = str2;
                    if (b.f23003d) {
                        JNIBridge.set(100, str2);
                    }
                    i11++;
                    z10 = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    String str3 = customInfo.mUnexpCrashLogFileName;
                    customInfo2.mUnexpCrashLogFileName = str3;
                    if (b.f23003d) {
                        JNIBridge.set(101, str3);
                    }
                    i11++;
                    z10 = true;
                }
                if (z10) {
                    e.c();
                    if (b.f23003d) {
                        JNIBridge.cmd(2);
                    }
                }
                boolean z13 = customInfo2.mPrintStackInfos;
                boolean z14 = customInfo.mPrintStackInfos;
                if (z13 != z14) {
                    customInfo2.mPrintStackInfos = z14;
                    if (b.f23003d) {
                        JNIBridge.set(11, z14);
                    }
                    i11++;
                }
                boolean z15 = customInfo2.mDebug;
                boolean z16 = customInfo.mDebug;
                if (z15 != z16) {
                    customInfo2.mDebug = z16;
                    if (b.f23003d) {
                        JNIBridge.set(18, z16);
                    }
                    i11++;
                }
                boolean z17 = customInfo2.mBackupLogs;
                boolean z18 = customInfo.mBackupLogs;
                if (z17 != z18) {
                    customInfo2.mBackupLogs = z18;
                    if (b.f23003d) {
                        JNIBridge.set(12, z18);
                    }
                    i11++;
                }
                boolean z19 = customInfo2.mOmitNativeCrash;
                boolean z20 = customInfo.mOmitNativeCrash;
                if (z19 != z20) {
                    customInfo2.mOmitNativeCrash = z20;
                    if (b.f23003d) {
                        JNIBridge.set(21, z20);
                    }
                    i11++;
                }
                int i12 = customInfo2.mCrashRestartInterval;
                int i13 = customInfo.mCrashRestartInterval;
                if (i12 != i13) {
                    customInfo2.mCrashRestartInterval = i13;
                    if (b.f23003d) {
                        JNIBridge.set(13, i13);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        b.M();
                    }
                    i11++;
                }
                int i14 = customInfo2.mMaxBuiltinLogFilesCount;
                int i15 = customInfo.mMaxBuiltinLogFilesCount;
                if (i14 != i15) {
                    customInfo2.mMaxBuiltinLogFilesCount = i15;
                    if (b.f23003d) {
                        JNIBridge.set(14, i15);
                    }
                    i11++;
                }
                int i16 = customInfo2.mMaxNativeLogcatLineCount;
                int i17 = customInfo.mMaxNativeLogcatLineCount;
                if (i16 != i17) {
                    customInfo2.mMaxNativeLogcatLineCount = i17;
                    if (b.f23003d) {
                        JNIBridge.set(15, i17);
                    }
                    i11++;
                }
                int i18 = customInfo2.mMaxJavaLogcatLineCount;
                int i19 = customInfo.mMaxJavaLogcatLineCount;
                if (i18 != i19) {
                    customInfo2.mMaxJavaLogcatLineCount = i19;
                    i11++;
                }
                int i20 = customInfo2.mMaxUnexpLogcatLineCount;
                int i21 = customInfo.mMaxUnexpLogcatLineCount;
                if (i20 != i21) {
                    customInfo2.mMaxUnexpLogcatLineCount = i21;
                    if (b.f23003d) {
                        JNIBridge.set(16, i21);
                    }
                    i11++;
                }
                int i22 = customInfo2.mMaxAnrLogcatLineCount;
                int i23 = customInfo.mMaxAnrLogcatLineCount;
                if (i22 != i23) {
                    customInfo2.mMaxAnrLogcatLineCount = i23;
                    if (b.f23003d) {
                        JNIBridge.set(31, i23);
                    }
                    i11++;
                }
                boolean z21 = customInfo2.mZipLog;
                boolean z22 = customInfo.mZipLog;
                if (z21 != z22) {
                    customInfo2.mZipLog = z22;
                    if (!z22) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        f23089a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i11++;
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    z12 = z11;
                } else {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i11++;
                }
                if (z12 && b.f23003d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                int i24 = customInfo2.mLogMaxBytesLimit;
                int i25 = customInfo.mLogMaxBytesLimit;
                if (i24 != i25) {
                    customInfo2.mLogMaxBytesLimit = i25;
                    if (b.f23003d) {
                        JNIBridge.set(4, i25);
                    }
                    i11++;
                }
                boolean z23 = customInfo2.mEncryptLog;
                boolean z24 = customInfo.mEncryptLog;
                if (z23 != z24) {
                    customInfo2.mEncryptLog = z24;
                    if (z24) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        f23090b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i11++;
                }
                boolean z25 = customInfo2.mSyncUploadSetupCrashLogs;
                boolean z26 = customInfo.mSyncUploadSetupCrashLogs;
                if (z25 != z26) {
                    customInfo2.mSyncUploadSetupCrashLogs = z26;
                    i11++;
                }
                boolean z27 = customInfo2.mSyncUploadLogs;
                boolean z28 = customInfo.mSyncUploadLogs;
                if (z27 != z28) {
                    customInfo2.mSyncUploadLogs = z28;
                    i11++;
                }
                int i26 = customInfo2.mMaxCustomLogFilesCount;
                int i27 = customInfo.mMaxCustomLogFilesCount;
                if (i26 != i27) {
                    customInfo2.mMaxCustomLogFilesCount = i27;
                    i11++;
                }
                boolean z29 = customInfo2.mOmitJavaCrash;
                boolean z30 = customInfo.mOmitJavaCrash;
                if (z29 != z30) {
                    customInfo2.mOmitJavaCrash = z30;
                    i11++;
                }
                int i28 = customInfo2.mLogMaxUploadBytesLimit;
                int i29 = customInfo.mLogMaxUploadBytesLimit;
                if (i28 != i29) {
                    customInfo2.mLogMaxUploadBytesLimit = i29;
                    i11++;
                }
                long j10 = customInfo2.mMaxUploadBytesPerDay;
                long j11 = customInfo.mMaxUploadBytesPerDay;
                if (j10 != j11) {
                    customInfo2.mMaxUploadBytesPerDay = j11;
                    i11++;
                }
                int i30 = customInfo2.mMaxUploadBuiltinLogCountPerDay;
                int i31 = customInfo.mMaxUploadBuiltinLogCountPerDay;
                if (i30 != i31) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = i31;
                    i11++;
                }
                int i32 = customInfo2.mMaxUploadCustomLogCountPerDay;
                int i33 = customInfo.mMaxUploadCustomLogCountPerDay;
                if (i32 != i33) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = i33;
                    i11++;
                }
                int i34 = customInfo2.mMaxCustomLogCountPerTypePerDay;
                int i35 = customInfo.mMaxCustomLogCountPerTypePerDay;
                if (i34 != i35) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = i35;
                    i11++;
                }
                int i36 = customInfo2.mMaxAnrLogCountPerProcess;
                int i37 = customInfo.mMaxAnrLogCountPerProcess;
                if (i36 != i37) {
                    customInfo2.mMaxAnrLogCountPerProcess = i37;
                    if (b.f23003d) {
                        JNIBridge.set(32, f23092d.mMaxAnrLogCountPerProcess);
                    }
                    i11++;
                }
                boolean z31 = customInfo2.mCallJavaDefaultHandler;
                boolean z32 = customInfo.mCallJavaDefaultHandler;
                if (z31 != z32) {
                    customInfo2.mCallJavaDefaultHandler = z32;
                    i11++;
                }
                boolean z33 = customInfo2.mCallNativeDefaultHandler;
                boolean z34 = customInfo.mCallNativeDefaultHandler;
                if (z33 != z34) {
                    customInfo2.mCallNativeDefaultHandler = z34;
                    i11++;
                    if (b.f23003d) {
                        JNIBridge.set(5, f23092d.mCallNativeDefaultHandler);
                    }
                }
                boolean z35 = customInfo2.mDumpUserSolibBuildId;
                boolean z36 = customInfo.mDumpUserSolibBuildId;
                if (z35 != z36) {
                    customInfo2.mDumpUserSolibBuildId = z36;
                    i11++;
                    if (b.f23003d) {
                        JNIBridge.set(6, f23092d.mDumpUserSolibBuildId);
                    }
                }
                boolean z37 = customInfo2.mDumpHprofDataForJavaOOM;
                boolean z38 = customInfo.mDumpHprofDataForJavaOOM;
                if (z37 != z38) {
                    customInfo2.mDumpHprofDataForJavaOOM = z38;
                    i11++;
                }
                boolean z39 = customInfo2.mRenameFileToDefaultName;
                boolean z40 = customInfo.mRenameFileToDefaultName;
                if (z39 != z40) {
                    customInfo2.mRenameFileToDefaultName = z40;
                    i11++;
                }
                boolean z41 = customInfo2.mAutoDeleteOldVersionStats;
                boolean z42 = customInfo.mAutoDeleteOldVersionStats;
                if (z41 != z42) {
                    customInfo2.mAutoDeleteOldVersionStats = z42;
                    i11++;
                }
                int i38 = customInfo2.mFdDumpMinLimit;
                int i39 = customInfo.mFdDumpMinLimit;
                if (i38 != i39) {
                    customInfo2.mFdDumpMinLimit = i39;
                    if (b.f23003d) {
                        JNIBridge.set(10, i39);
                    }
                    i11++;
                }
                int i40 = customInfo2.mThreadsDumpMinLimit;
                int i41 = customInfo.mThreadsDumpMinLimit;
                if (i40 != i41) {
                    customInfo2.mThreadsDumpMinLimit = i41;
                    if (b.f23003d) {
                        JNIBridge.set(22, i41);
                    }
                    i11++;
                }
                int i42 = customInfo2.mInfoUpdateInterval;
                int i43 = customInfo.mInfoUpdateInterval;
                if (i42 != i43) {
                    if (i42 <= 0 && i43 > 0) {
                        a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i11++;
                }
                int i44 = customInfo2.mInfoSaveFrequency;
                int i45 = customInfo.mInfoSaveFrequency;
                if (i44 != i45) {
                    customInfo2.mInfoSaveFrequency = i45;
                    i11++;
                }
                long j12 = customInfo2.mDisableBackgroundSignals;
                long j13 = customInfo.mDisableBackgroundSignals;
                if (j12 != j13) {
                    customInfo2.mDisableBackgroundSignals = j13;
                    if (b.f23003d) {
                        JNIBridge.set(9, j13);
                    }
                    i11++;
                }
                boolean z43 = customInfo2.mEnableStatReport;
                boolean z44 = customInfo.mEnableStatReport;
                if (z43 != z44) {
                    customInfo2.mEnableStatReport = z44;
                    if (z44) {
                        e.B();
                    }
                    i11++;
                }
                boolean z45 = customInfo2.mEnableCrpStat;
                boolean z46 = customInfo.mEnableCrpStat;
                if (z45 != z46) {
                    customInfo2.mEnableCrpStat = z46;
                    i11++;
                }
                boolean z47 = customInfo2.mEnableStatToWPKDirect;
                boolean z48 = customInfo.mEnableStatToWPKDirect;
                if (z47 != z48) {
                    customInfo2.mEnableStatToWPKDirect = z48;
                    i11++;
                }
                boolean z49 = customInfo2.mIsInternational;
                boolean z50 = customInfo.mIsInternational;
                if (z49 != z50) {
                    customInfo2.mIsInternational = z50;
                    if (b.f23003d) {
                        JNIBridge.set(23, z50);
                    }
                    e.l();
                    com.uc.crashsdk.a.d.c();
                    h.k();
                    i11++;
                }
                boolean z51 = customInfo2.mAutoDetectLifeCycle;
                boolean z52 = customInfo.mAutoDetectLifeCycle;
                if (z51 != z52) {
                    customInfo2.mAutoDetectLifeCycle = z52;
                    if (z52) {
                        b.C();
                    }
                    i11++;
                }
                boolean z53 = customInfo2.mMonitorBattery;
                boolean z54 = customInfo.mMonitorBattery;
                if (z53 != z54) {
                    customInfo2.mMonitorBattery = z54;
                    e.c(b.B());
                    i11++;
                }
                int i46 = customInfo2.mUnexpSubTypes;
                int i47 = customInfo.mUnexpSubTypes;
                if (i46 != i47) {
                    customInfo2.mUnexpSubTypes = i47;
                    i11++;
                }
                boolean z55 = customInfo2.mEnableMemoryGroup;
                boolean z56 = customInfo.mEnableMemoryGroup;
                if (z55 != z56) {
                    customInfo2.mEnableMemoryGroup = z56;
                    if (b.f23003d) {
                        JNIBridge.set(35, z56);
                    }
                    i11++;
                }
                boolean z57 = customInfo2.mEnableLibcMallocDetail;
                boolean z58 = customInfo.mEnableLibcMallocDetail;
                if (z57 != z58) {
                    customInfo2.mEnableLibcMallocDetail = z58;
                    if (b.f23003d) {
                        JNIBridge.set(36, z58);
                    }
                    i11++;
                }
                String str4 = customInfo2.mLibcMallocDetailConfig;
                String str5 = customInfo.mLibcMallocDetailConfig;
                if (str4 != str5) {
                    customInfo2.mLibcMallocDetailConfig = str5;
                    if (b.f23003d) {
                        JNIBridge.set(131, str5);
                    }
                    i11++;
                }
                if (!a(customInfo.mUserId, customInfo2.mUserId)) {
                    customInfo2.mUserId = customInfo.mUserId;
                    i11++;
                }
                if (!a(customInfo.mChannel, customInfo2.mChannel)) {
                    customInfo2.mChannel = customInfo.mChannel;
                    i11++;
                }
                if (!a(customInfo2.mCrashLogUploadUrl, customInfo.mCrashLogUploadUrl)) {
                    customInfo2.mCrashLogUploadUrl = customInfo.mCrashLogUploadUrl;
                    i11++;
                }
                if (!a(customInfo2.mCrashRateUploadUrl, customInfo.mCrashRateUploadUrl)) {
                    String str6 = customInfo.mCrashRateUploadUrl;
                    customInfo2.mCrashRateUploadUrl = str6;
                    i11++;
                    if (b.f23003d) {
                        JNIBridge.set(38, str6);
                    }
                }
                if (!a(customInfo2.mCrashSDKAuthUrl, customInfo.mCrashSDKAuthUrl)) {
                    String str7 = customInfo.mCrashSDKAuthUrl;
                    customInfo2.mCrashSDKAuthUrl = str7;
                    i11++;
                    if (b.f23003d) {
                        JNIBridge.set(39, str7);
                    }
                }
                i10 = i11;
            }
        }
        return i10;
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = f23092d;
            if (customInfo2 == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(customInfo2);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e10) {
                        com.uc.crashsdk.a.g.a(e10);
                        StringBuilder sb2 = new StringBuilder("Field ");
                        sb2.append(str);
                        sb2.append(" must be a ");
                        sb2.append(field.getType().getName());
                        sb2.append(", but give a ");
                        sb2.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = f23093e;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.f22910b = string4;
            ae();
        }
        return versionInfo;
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
