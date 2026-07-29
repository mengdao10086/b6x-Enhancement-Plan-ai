package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.c;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import j3.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p4.f;

/* JADX INFO: loaded from: classes5.dex */
public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static String mDefaultEnvelopeDir = z.b().b(z.f23795a);
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeFileLock = new Object();
    private static String sCurrentProcessName = "";

    private static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(applicationContext, th2);
                return false;
            }
        } else {
            try {
                if (applicationContext.getPackageManager().checkPermission(str, applicationContext.getPackageName()) != 0) {
                    return false;
                }
            } catch (Throwable th3) {
                UMCrashManager.reportCrash(applicationContext, th3);
                return false;
            }
        }
        return true;
    }

    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    if (file.isDirectory() && (list = file.list()) != null) {
                        return list.length;
                    }
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            }
        }
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
                if (TextUtils.isEmpty(processName)) {
                    int iMyPid = Process.myPid();
                    String processName2 = getProcessName(iMyPid);
                    if (TextUtils.isEmpty(processName2)) {
                        ActivityManager activityManager = (ActivityManager) context.getSystemService(c.f2369r);
                        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it2.next();
                                if (next.pid == iMyPid) {
                                    sCurrentProcessName = next.processName;
                                    break;
                                }
                            }
                        }
                    } else {
                        sCurrentProcessName = processName2;
                    }
                } else {
                    sCurrentProcessName = processName;
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context.getApplicationContext(), th2);
            }
        }
        return sCurrentProcessName;
    }

    private static long getDistanceDays(long j10, long j11) {
        return (j10 < j11 ? j11 - j10 : j10 - j11) / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        String str;
        File file;
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + b.f36044h + mDefaultEnvelopeDir;
                }
                file = new File(mDefaultEnvelopeDirPath);
            } finally {
            }
            if (file.exists() || file.mkdir()) {
                str = mDefaultEnvelopeDirPath;
            } else {
                ULog.d("--->>> Create Envelope Directory failed!!!");
                str = mDefaultEnvelopeDirPath;
            }
        }
        return str;
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.2
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLastModified = file2.lastModified() - file3.lastModified();
                        if (jLastModified > 0) {
                            return 1;
                        }
                        return jLastModified == 0 ? 0 : -1;
                    }
                });
                return fileArrListFiles[0];
            }
            return null;
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        long j10;
        synchronized (mEnvelopeBuildTimeLock) {
            j10 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j10;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j10;
        synchronized (mEnvelopeBuildTimeLock) {
            j10 = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j10;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        try {
            String currentProcessName = getCurrentProcessName(context);
            if (!TextUtils.isEmpty(currentProcessName)) {
                String strB = z.b().b(z.B);
                String strReplace = currentProcessName.replace(':', '_');
                ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                return strB + strReplace;
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
        return mDefaultEnvelopeDir;
    }

    private static String getProcessName(int i10) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i10 + "/cmdline"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            if (!TextUtils.isEmpty(line)) {
                line = line.trim();
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return line;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
    }

    public static String getSubProcessName(Context context) {
        String strSubstring;
        strSubstring = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int iIndexOf = currentProcessName.indexOf(":");
            strSubstring = iIndexOf >= 0 ? currentProcessName.substring(iIndexOf + 1) : "";
            if (iIndexOf < 0) {
                String packageName = context.getPackageName();
                return currentProcessName.length() > packageName.length() ? currentProcessName.substring(packageName.length() + 1, currentProcessName.length()) : currentProcessName;
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th2);
        }
        return strSubstring;
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        File[] fileArrListFiles;
        String str = uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL ? "i" : "a";
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = an.aD;
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_Silent) {
            str = "h";
        }
        String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath == null) {
            return false;
        }
        File file = new File(envelopeDirPath);
        synchronized (mEnvelopeFileLock) {
            try {
                fileArrListFiles = file.listFiles();
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            }
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.getName().startsWith(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, f.f46367b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th2);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        return file.delete();
                    }
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(appContext, th2);
                }
            }
            return true;
        }
    }

    public static void removeRedundantEnvelopeFiles(Context context, int i10) {
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > i10) {
                Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLastModified = file2.lastModified() - file3.lastModified();
                        if (jLastModified > 0) {
                            return 1;
                        }
                        return jLastModified == 0 ? 0 : -1;
                    }
                });
                if (fileArrListFiles.length > i10) {
                    for (int i11 = 0; i11 < fileArrListFiles.length - i10; i11++) {
                        try {
                            if (!fileArrListFiles[i11].delete()) {
                                ULog.d("--->>> remove [" + i11 + "] file fail.");
                            }
                        } catch (Throwable th2) {
                            UMCrashManager.reportCrash(context, th2);
                        }
                    }
                }
            }
        }
    }

    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (bArr == null) {
            return 101;
        }
        File file = new File(getEnvelopeDirPath(context) + File.separator + str);
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e10) {
                    e = e10;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                boolean zA = com.umeng.commonsdk.statistics.internal.a.a(context).a(str);
                boolean zB = com.umeng.commonsdk.statistics.internal.a.a(context).b(str);
                if (zA) {
                    updateLastSuccessfulBuildTime(context);
                }
                if (zB) {
                    updateLastInstantBuildTime(context);
                }
                return 0;
            } catch (IOException e11) {
                e = e11;
                fileOutputStream2 = fileOutputStream;
                UMCrashManager.reportCrash(context, e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th3) {
                        UMCrashManager.reportCrash(context, th3);
                    }
                }
                return 101;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th5) {
                        UMCrashManager.reportCrash(context, th5);
                    }
                }
                throw th;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        String legacyEnvelopeDir;
        if (context == null) {
            return;
        }
        try {
            legacyEnvelopeDir = getLegacyEnvelopeDir(context);
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
        if (TextUtils.isEmpty(legacyEnvelopeDir) || legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                try {
                    if (file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    UMCrashManager.reportCrash(context, th3);
                    return;
                }
            }
            try {
                String envelopeDirPath = getEnvelopeDirPath(context);
                for (int i10 = 0; i10 < fileArrListFiles.length; i10++) {
                    fileArrListFiles[i10].renameTo(new File(envelopeDirPath + File.separator + fileArrListFiles[i10].getName()));
                }
                if (file.isDirectory()) {
                    file.delete();
                    return;
                }
                return;
            } catch (Throwable th4) {
                UMCrashManager.reportCrash(context, th4);
                return;
            }
            UMCrashManager.reportCrash(context, th2);
        }
    }

    public static byte[] toByteArray(String str) throws IOException {
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            FileChannel channel = null;
            try {
                try {
                    channel = new RandomAccessFile(str, SsManifestParser.e.J).getChannel();
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                    bArr = new byte[(int) channel.size()];
                    if (mappedByteBufferLoad.remaining() > 0) {
                        mappedByteBufferLoad.get(bArr, 0, mappedByteBufferLoad.remaining());
                    }
                } catch (IOException e10) {
                    UMCrashManager.reportCrash(appContext, e10);
                    throw e10;
                }
            } finally {
                try {
                    channel.close();
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(appContext, th2);
                }
            }
        }
        return bArr;
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
