package com.uc.crashsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.an;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f22961a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f22962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f22963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f22964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f22965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f22966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f22967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f22968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f22969i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f22970j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int i10 = fileInputStream2.read(bArr);
                        if (i10 == -1) {
                            a(fileInputStream2);
                            a(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i10);
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static void b(File file) {
        a(file, "");
    }

    public static String c(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        StringBuilder sb2;
        String string = "";
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bArr = new byte[256];
                sb2 = new StringBuilder();
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                try {
                    a(th, false);
                } finally {
                    a(fileInputStream2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        while (true) {
            int i10 = fileInputStream.read(bArr);
            if (i10 <= 0) {
                break;
            }
            sb2.append(new String(bArr, 0, i10));
            return string;
        }
        string = sb2.toString();
        a(fileInputStream);
        return string;
    }

    public static String d(File file) {
        return a(file, 64, true);
    }

    public static byte[] e(File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                try {
                    a(th, false);
                    return null;
                } finally {
                    a(fileInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static boolean f() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean g() {
        int iIndexOf;
        String strI = i();
        if (!a(strI) && (iIndexOf = strI.indexOf(" root ")) > 0) {
            String strSubstring = strI.substring(0, iIndexOf);
            if (strSubstring.contains("x") || strSubstring.contains(an.aB)) {
                return true;
            }
        }
        return false;
    }

    public static String h() {
        l();
        return a(f22966f) ? "" : f22966f;
    }

    public static String i() {
        l();
        return a(f22967g) ? "" : f22967g;
    }

    public static void j() {
        f.a(0, new e(gg.b.f29491t1), 15000L);
    }

    public static void k() {
        if (com.uc.crashsdk.b.f23003d && f22968h) {
            JNIBridge.set(123, f22966f);
            JNIBridge.set(124, f22967g);
        }
    }

    private static void l() {
        String strTrim;
        int iIndexOf;
        int iIndexOf2;
        if (f22968h) {
            return;
        }
        synchronized (f22969i) {
            if (f22968h) {
                return;
            }
            String strA = a(new String[]{"sh", "-c", "type su"});
            if (!a(strA) && (iIndexOf = (strTrim = strA.trim()).indexOf(32)) > 0 && strTrim.contains("/su") && (iIndexOf2 = strTrim.indexOf(47, iIndexOf + 1)) > 0) {
                String strSubstring = strTrim.substring(iIndexOf2);
                f22966f = strSubstring;
                String strA2 = a(new String[]{"ls", "-l", strSubstring});
                if (!a(strA2)) {
                    f22967g = strA2.trim();
                }
            }
            f22968h = true;
            k();
        }
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static String d() {
        String str = f22965e;
        return str != null ? str : "";
    }

    public static void b(Throwable th2) {
        a(th2, true);
    }

    public static String d(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            int length = bArrDigest.length;
            StringBuilder sb2 = new StringBuilder(length * 2);
            int i10 = length + 0;
            for (int i11 = 0; i11 < i10; i11++) {
                byte b10 = bArrDigest[i11];
                char[] cArr = f22970j;
                char c10 = cArr[(b10 & 240) >> 4];
                char c11 = cArr[b10 & 15];
                sb2.append(c10);
                sb2.append(c11);
            }
            return sb2.toString();
        } catch (Exception e10) {
            a.a("crashsdk", "getMD5: ", e10);
            return null;
        }
    }

    public static String b() {
        return f22963c;
    }

    public static String a(File file, int i10, boolean z10) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i10];
                int i11 = fileInputStream.read(bArr);
                if (i11 > 0) {
                    return new String(bArr, 0, i11);
                }
            } catch (Throwable th2) {
                th = th2;
                if (z10) {
                    try {
                        a(th, false);
                    } finally {
                        a(fileInputStream);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        return null;
    }

    public static boolean e() {
        if (g()) {
            return true;
        }
        return f();
    }

    public static long c(String str) {
        if (a(str)) {
            return 0L;
        }
        try {
            long j10 = Long.parseLong(str.trim());
            if (j10 < 0) {
                return 0L;
            }
            return j10;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static String c() {
        return f22964d;
    }

    public static ArrayList<String> a(File file, int i10) {
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList<>();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2, 512);
                int i11 = 0;
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        arrayList.add(line);
                        i11++;
                        if (i10 > 0 && i11 >= i10) {
                            break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = fileReader2;
                        try {
                            a(th, false);
                            a(fileReader);
                        } catch (Throwable th3) {
                            a(fileReader);
                            a(bufferedReader);
                            throw th3;
                        }
                    }
                }
                a(fileReader2);
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        a(bufferedReader);
        return arrayList;
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                a(fileOutputStream2);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    a(th, false);
                    return false;
                } finally {
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(File file, String str) {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str, 0, str.length());
                a(fileWriter2);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = fileWriter2;
                try {
                    a(th, false);
                    return false;
                } finally {
                    a(fileWriter);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                a(th2, true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[PHI: r2
  0x0029: PHI (r2v2 java.lang.String) = (r2v1 java.lang.String), (r2v3 java.lang.String) binds: [B:7:0x0017, B:9:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r2, java.lang.String r3, boolean r4) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 == 0) goto L2a
            java.lang.String r2 = com.uc.crashsdk.a.b.a(r2)
            boolean r0 = a(r2)
            if (r0 == 0) goto L17
            goto L2a
        L17:
            if (r4 == 0) goto L29
            java.lang.String r2 = r2.trim()
            java.lang.String r4 = r2.toLowerCase()
            java.lang.String r0 = "http"
            boolean r4 = r4.startsWith(r0)
            if (r4 == 0) goto L2a
        L29:
            r1 = r2
        L2a:
            if (r1 != 0) goto L2d
            goto L2e
        L2d:
            r3 = r1
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.g.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static void a(Throwable th2) {
        a(th2, false);
    }

    private static void a(Throwable th2, boolean z10) {
        if (!z10) {
            try {
                if (!com.uc.crashsdk.g.O()) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        th2.printStackTrace();
    }

    public static void a(Context context) {
        if (f22962b != null) {
            a.b("mContext is existed");
        }
        f22962b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        f22963c = applicationInfo.dataDir;
        f22964d = applicationInfo.sourceDir;
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            f22965e = (String) obj;
        } catch (Throwable th2) {
            a(th2, false);
        }
    }

    public static Context a() {
        return f22962b;
    }

    public static void a(int i10) {
        if (i10 != 800) {
            if (!f22961a) {
                throw new AssertionError();
            }
        } else {
            l();
        }
    }

    private static String a(String[] strArr) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 512);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb2.append(line);
                        } else {
                            return sb2.toString().trim();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        a(th, false);
                        return null;
                    } finally {
                        a(bufferedReader);
                        a(inputStreamReader);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }
}
