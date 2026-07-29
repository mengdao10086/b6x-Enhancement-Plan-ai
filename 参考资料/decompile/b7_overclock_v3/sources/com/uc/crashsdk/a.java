package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.uc.crashsdk.export.LogType;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import v7.a;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22909a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f22910b = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f22912d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f22913e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<String> f22914f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f22915g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f22916h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f22917i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f22918j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final HashMap<String, Object[]> f22919k = new HashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final List<String> f22920l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f22921m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f22922n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f22923o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f22924p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final HashMap<String, Object[]> f22925q = new HashMap<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final List<String> f22926r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int f22927s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static int f22928t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static int f22929u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f22930v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f22931w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static int f22932x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final SparseArray<Object[]> f22933y = new SparseArray<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final List<Integer> f22934z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f22911c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    public static String a() {
        String str = f22916h;
        return str != null ? str : o() ? f22916h : "";
    }

    public static long b() {
        return f22918j;
    }

    public static int c() {
        if (f22917i == -1) {
            o();
        }
        return f22917i;
    }

    public static void d() {
        StringBuilder sb2 = new StringBuilder();
        synchronized (f22913e) {
            for (String str : f22914f) {
                String str2 = f22913e.get(str);
                sb2.append(str);
                sb2.append(": ");
                if (str2 != null) {
                    sb2.append(str2);
                }
                sb2.append("\n");
            }
        }
        sb2.append(String.format(Locale.US, "(saved at %s)\n", e.n()));
        com.uc.crashsdk.a.b.a(b.h(), sb2.toString());
    }

    public static void e() {
        if (!f22912d && !b.f23003d) {
            throw new AssertionError();
        }
        synchronized (f22913e) {
            for (String str : f22914f) {
                JNIBridge.nativeAddHeaderInfo(str, f22913e.get(str));
            }
        }
    }

    public static byte[] f() {
        return new byte[]{24, 99, 121, 60};
    }

    public static void g() {
        if (!f22912d && !b.f23003d) {
            throw new AssertionError();
        }
        synchronized (f22919k) {
            for (String str : f22920l) {
                Object[] objArr = f22919k.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), iIntValue, ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    public static String h() {
        StringBuilder sb2 = new StringBuilder();
        synchronized (f22919k) {
            boolean z10 = true;
            for (String str : f22920l) {
                if (LogType.isForJava(((Integer) f22919k.get(str)[0]).intValue())) {
                    if (!z10) {
                        sb2.append("`");
                    }
                    sb2.append(str);
                    z10 = false;
                }
            }
        }
        return sb2.toString();
    }

    public static void i() {
        if (!f22912d && !b.f23003d) {
            throw new AssertionError();
        }
        synchronized (f22925q) {
            for (String str : f22926r) {
                Object[] objArr = f22925q.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddCallbackInfo(str, iIntValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    public static String j() {
        String string;
        synchronized (f22925q) {
            StringBuilder sb2 = new StringBuilder();
            List<String> list = f22926r;
            synchronized (list) {
                boolean z10 = true;
                for (String str : list) {
                    if (LogType.isForJava(((Integer) f22925q.get(str)[0]).intValue())) {
                        if (!z10) {
                            sb2.append("`");
                        }
                        sb2.append(str);
                        z10 = false;
                    }
                }
            }
            string = sb2.toString();
        }
        return string;
    }

    public static void k() {
        if (!f22912d && !b.f23003d) {
            throw new AssertionError();
        }
        synchronized (A) {
            for (String str : B) {
                Object[] objArr = A.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if ((1048577 & iIntValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, iIntValue, iIntValue2) != 0) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it2.next())) {
                    }
                }
            }
        }
    }

    public static String l() {
        StringBuilder sb2 = new StringBuilder();
        synchronized (A) {
            boolean z10 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z10) {
                        sb2.append("`");
                    }
                    sb2.append(str);
                    z10 = false;
                }
            }
        }
        return sb2.toString();
    }

    public static String m() throws Throwable {
        if (!G) {
            String strA = com.uc.crashsdk.a.b.a(b.m());
            f22915g = strA;
            G = true;
            if (strA == null) {
                f22915g = "";
            }
        }
        return f22915g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(a.c.f52772h));
        } else if (b.f23003d) {
            JNIBridge.set(128, f22915g);
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(f22909a, 0);
            f22916h = packageInfo.versionName;
            f22918j = packageInfo.lastUpdateTime;
            f22917i = packageInfo.versionCode;
            return true;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.b(th2);
            return false;
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.f23003d || !b.f23006g) {
                String str = String.format(Locale.US, "%s/%s/%s", g.T(), g.U(), g.V());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + str);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }

    private static StringBuilder b(String str, boolean z10) {
        String strA;
        StringBuilder sb2 = new StringBuilder();
        try {
            Object[] objArr = f22925q.get(str);
            try {
                if (objArr == null) {
                    strA = "Unknown callback: " + str;
                } else {
                    Callable callable = (Callable) objArr[1];
                    strA = callable != null ? (String) callable.call() : d.a(str, z10);
                }
                if (strA != null) {
                    sb2.append(strA);
                }
            } catch (Throwable th2) {
                sb2.append("[DEBUG] Callback occurred new exception:\n");
                sb2.append(Log.getStackTraceString(th2));
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        try {
            if (sb2.length() == 0) {
                sb2.append("(data is null)\n");
            }
        } catch (Throwable th4) {
            com.uc.crashsdk.a.g.a(th4);
        }
        return sb2;
    }

    public static void a(String str, String str2) {
        Map<String, String> map = f22913e;
        synchronized (map) {
            if (!map.containsKey(str)) {
                f22914f.add(str);
            }
            map.put(str, str2);
            if (b.f23003d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.y();
        }
    }

    public static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] strArrSplit = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : strArrSplit) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void a(OutputStream outputStream, String str) {
        synchronized (f22913e) {
            for (String str2 : f22914f) {
                try {
                    StringBuilder sb2 = new StringBuilder(11);
                    sb2.append(str2);
                    sb2.append(": ");
                    String str3 = f22913e.get(str2);
                    if (str3 != null) {
                        sb2.append(str3);
                    }
                    sb2.append("\n");
                    outputStream.write(sb2.toString().getBytes(str));
                } catch (Throwable th2) {
                    e.a(th2, outputStream);
                }
            }
        }
    }

    public static int b(String str, String str2) {
        int iAddType;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            Object[] objArr = map.get(str);
            if (objArr != null) {
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= iIntValue) {
                    list.remove(0);
                }
                list.add(str2);
                iAddType = LogType.isForJava(iIntValue2) ? LogType.addType(0, 16) : 0;
                if (!b.f23003d) {
                    if (LogType.isForNative(iIntValue2)) {
                        iAddType = LogType.addType(iAddType, 1);
                    }
                    if (LogType.isForANR(iIntValue2)) {
                        iAddType = LogType.addType(iAddType, 1048576);
                    }
                }
                iAddType = iAddType;
                iAddType = iIntValue2;
            } else {
                iAddType = 0;
            }
            if (b.f23003d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(iAddType)) {
                    iAddType = LogType.addType(iAddType, 1);
                }
                if (LogType.isForANR(iAddType)) {
                    iAddType = LogType.addType(iAddType, 1048576);
                }
            }
        }
        return iAddType;
    }

    public static int a(String str, String str2, boolean z10, boolean z11, int i10, boolean z12) {
        int iRemoveType;
        int iIntValue;
        boolean z13;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        HashMap<String, Object[]> map = f22919k;
        synchronized (map) {
            if (map.containsKey(str)) {
                iIntValue = ((Integer) map.get(str)[0]).intValue();
                iRemoveType = LogType.addType(iIntValue, i10);
            } else {
                iRemoveType = i10;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                int i11 = f22921m;
                if (i11 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    f22921m = i11 + 1;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                int i12 = f22922n;
                if (i12 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    f22922n = i12 + 1;
                }
            }
            if (LogType.isForUnexp(iRemoveType) && !LogType.isForUnexp(iIntValue)) {
                int i13 = f22923o;
                if (i13 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                } else {
                    f22923o = i13 + 1;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                int i14 = f22924p;
                if (i14 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    f22924p = i14 + 1;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z13 = false;
            } else {
                if (iIntValue == 0) {
                    f22920l.add(str);
                }
                z13 = true;
            }
            if (!z13) {
                return iRemoveType;
            }
            if (b.f23003d && (1048833 & i10) != 0) {
                int iNativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z10, z11, i10, z12);
                if (!LogType.isForNative(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForUnexp(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                }
                if (!LogType.isForANR(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            map.put(str, new Object[]{Integer.valueOf(iRemoveType), str2, Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12)});
            return iRemoveType;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(java.io.OutputStream r11, java.lang.String r12, java.lang.String r13, java.util.ArrayList<java.lang.String> r14) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:12:0x0025, B:14:0x002f, B:20:0x0045, B:22:0x0050, B:17:0x003e), top: B:73:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0 A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:34:0x007f, B:36:0x009b, B:38:0x00a3, B:40:0x00b0, B:41:0x00b5), top: B:69:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:34:0x007f, B:36:0x009b, B:38:0x00a3, B:40:0x00b0, B:41:0x00b5), top: B:69:0x007f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r18, java.lang.String r19, java.util.ArrayList<java.lang.String> r20) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.util.ArrayList):void");
    }

    public static String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            Object[] objArr = map.get(str);
            int iIntValue = ((Integer) objArr[0]).intValue();
            List list = (List) objArr[2];
            sb2.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(iIntValue)));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                sb2.append((String) it2.next());
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public static String a(String str) {
        HashMap<String, Object[]> map = f22919k;
        synchronized (map) {
            Object[] objArr = map.get(str);
            if (objArr == null) {
                return null;
            }
            int i10 = 1;
            String str2 = (String) objArr[1];
            boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean zBooleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = str2;
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(zBooleanValue ? 1 : 0);
            if (!zBooleanValue2) {
                i10 = 0;
            }
            objArr2[3] = Integer.valueOf(i10);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            if (str.equals(it2.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0013, B:11:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:32:0x005d, B:23:0x0047, B:26:0x004c, B:30:0x0057, B:27:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:52:0x009a, B:54:0x00a1, B:56:0x00a9, B:58:0x00af, B:60:0x00b3, B:61:0x00b8, B:63:0x00be, B:65:0x00c6, B:67:0x00cc, B:69:0x00d0, B:70:0x00d5, B:72:0x00db, B:79:0x00ed, B:81:0x00ef, B:83:0x00f3, B:85:0x00f9, B:87:0x0105, B:89:0x010b, B:91:0x0112, B:92:0x0117, B:94:0x011d, B:96:0x0123, B:97:0x0128, B:99:0x012e, B:101:0x0134, B:103:0x013c, B:104:0x0158, B:76:0x00e5, B:43:0x007c, B:46:0x0081, B:47:0x008b, B:50:0x0092), top: B:109:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009a A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0013, B:11:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:32:0x005d, B:23:0x0047, B:26:0x004c, B:30:0x0057, B:27:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:52:0x009a, B:54:0x00a1, B:56:0x00a9, B:58:0x00af, B:60:0x00b3, B:61:0x00b8, B:63:0x00be, B:65:0x00c6, B:67:0x00cc, B:69:0x00d0, B:70:0x00d5, B:72:0x00db, B:79:0x00ed, B:81:0x00ef, B:83:0x00f3, B:85:0x00f9, B:87:0x0105, B:89:0x010b, B:91:0x0112, B:92:0x0117, B:94:0x011d, B:96:0x0123, B:97:0x0128, B:99:0x012e, B:101:0x0134, B:103:0x013c, B:104:0x0158, B:76:0x00e5, B:43:0x007c, B:46:0x0081, B:47:0x008b, B:50:0x0092), top: B:109:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r16, int r17, java.util.concurrent.Callable<java.lang.String> r18, long r19, int r21) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long, int):int");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(2:50|8)|(3:57|10|(4:55|12|63|59)(4:54|16|(1:18)(1:19)|(1:24)(1:23)))(3:53|13|(4:56|15|60|59)(5:58|16|(0)(0)|(1:21)|24))|48|28|61|59|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x008d, TryCatch #2 {all -> 0x008d, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005d, B:21:0x0075, B:23:0x007b, B:24:0x0083, B:19:0x006b, B:13:0x002f), top: B:50:0x0015, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[Catch: all -> 0x008d, TryCatch #2 {all -> 0x008d, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005d, B:21:0x0075, B:23:0x007b, B:24:0x0083, B:19:0x006b, B:13:0x002f), top: B:50:0x0015, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r10, java.lang.String r11, java.lang.String r12, java.util.ArrayList<java.lang.String> r13) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    public static String a(String str, boolean z10) {
        String string;
        HashMap<String, Object[]> map = f22925q;
        synchronized (map) {
            Object[] objArr = map.get(str);
            long jLongValue = ((Long) objArr[2]).longValue();
            if (jLongValue != 0) {
                string = JNIBridge.nativeGetCallbackInfo(str, jLongValue, ((Integer) objArr[3]).intValue(), z10);
            } else {
                string = b(str, z10).toString();
            }
        }
        return string;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        SparseArray<Object[]> sparseArray = f22933y;
        synchronized (sparseArray) {
            int id2 = (int) thread.getId();
            if (sparseArray.get(id2) == null) {
                f22934z.add(Integer.valueOf(id2));
            }
            sparseArray.put(id2, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:34:0x00c3, B:36:0x00ca, B:37:0x00d3, B:39:0x00d8, B:41:0x00dc, B:42:0x00e5), top: B:55:0x00c3, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:34:0x00c3, B:36:0x00ca, B:37:0x00d3, B:39:0x00d8, B:41:0x00dc, B:42:0x00e5), top: B:55:0x00c3, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    public static int a(String str, int i10, int i11) {
        int iRemoveType;
        int iIntValue;
        boolean z10;
        if (str == null || i10 <= 0) {
            return 0;
        }
        if (i10 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            if (map.containsKey(str)) {
                iIntValue = ((Integer) map.get(str)[1]).intValue();
                iRemoveType = LogType.addType(iIntValue, i11);
            } else {
                iRemoveType = i11;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                int i12 = C;
                if (i12 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    C = i12 + 1;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                int i13 = D;
                if (i13 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    D = i13 + 1;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                int i14 = E;
                if (i14 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    E = i14 + 1;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z10 = false;
            } else {
                if (iIntValue == 0) {
                    B.add(str);
                }
                z10 = true;
            }
            if (!z10) {
                return iRemoveType;
            }
            if (b.f23003d && (i11 & 1048577) != 0) {
                int iNativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i10, iRemoveType);
                if (!LogType.isForNative(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForANR(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            map.put(str, new Object[]{Integer.valueOf(i10), Integer.valueOf(iRemoveType), new ArrayList()});
            return iRemoveType;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int a(int i10, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            str = Thread.currentThread().getName();
        }
        ?? r02 = 0;
        r02 = 0;
        if (LogType.isForNative(i10) || LogType.isForANR(i10)) {
            if (b.f23003d) {
                synchronized (f22933y) {
                    JNIBridge.nativeCmd(4, i10, str, null);
                }
                boolean zIsForNative = LogType.isForNative(i10);
                r02 = zIsForNative;
                if (LogType.isForANR(i10)) {
                    r02 = (zIsForNative ? 1 : 0) | 1048576;
                }
            } else {
                com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
            }
        }
        if (!LogType.isForJava(i10)) {
            return r02;
        }
        a(str, Thread.currentThread());
        return r02 | 16;
    }

    public static boolean a(boolean z10) {
        int iG;
        if (!b.f23002c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (e.F() || b.L()) {
            return false;
        }
        if (z10) {
            com.uc.crashsdk.a.f.a(F);
            iG = 0;
        } else {
            if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (g.G() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            iG = g.G() * 1000;
        }
        com.uc.crashsdk.a.f.a(0, F, iG);
        return true;
    }

    public static void a(int i10) {
        if (i10 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (b.f23003d && f22911c) {
                JNIBridge.nativeCmd(11, g.G(), String.valueOf(g.H()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            a(false);
            return;
        }
        if (i10 != 202) {
            if (!f22912d) {
                throw new AssertionError();
            }
            return;
        }
        p();
        Locale locale = Locale.US;
        String str = String.format(locale, "%s/%s/%s", g.T(), g.U(), g.V());
        f22915g = m();
        if (b.f23003d) {
            JNIBridge.set(128, f22915g);
        }
        boolean z10 = !str.equals(f22915g);
        if (z10) {
            com.uc.crashsdk.a.b.a(b.m(), str);
        }
        if (z10 && g.u()) {
            com.uc.crashsdk.a.a.a("crashsdk", String.format(locale, "Is new version ('%s' -> '%s'), deleting old stats data!", f22915g, str));
            b.v();
        }
    }
}
