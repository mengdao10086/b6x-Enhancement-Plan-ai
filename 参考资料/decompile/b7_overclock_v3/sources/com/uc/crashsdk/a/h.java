package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.material.timepicker.TimeModel;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.z;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import hb.u;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f22971a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f22972b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f22973c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f22974d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, a> f22975e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f22976f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f22977g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SparseArray<String> f22978h = new SparseArray<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f22979i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f22980j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f22981k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f22982l = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f22983a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22984b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f22985c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f22987e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f22988f;

        public a(String str, boolean z10, boolean z11) {
            this.f22987e = false;
            this.f22988f = false;
            this.f22986d = str;
            this.f22987e = z10;
            this.f22988f = z11;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        public final void a(String str, String str2) {
            this.f22985c.put(str, str2);
        }

        public final String b(String str) {
            String strA = a(str);
            return strA == null ? "" : strA;
        }

        public final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            String str2 = null;
            long jC = 0;
            HashMap map = new HashMap();
            Map mapC = h.c(str);
            int iC = 0;
            for (String str3 : mapC.keySet()) {
                String str4 = (String) mapC.get(str3);
                if (str3.equals(zc.f.f58384n)) {
                    str2 = str4;
                } else if (this.f22987e && str3.equals(CommonNetImpl.UP)) {
                    jC = g.c(str4);
                } else if (this.f22987e && str3.equals("pid")) {
                    iC = (int) g.c(str4);
                } else {
                    map.put(str3, str4);
                }
            }
            String str5 = this.f22986d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.f22983a = jC;
            this.f22984b = iC;
            this.f22986d = str2;
            this.f22985c = map;
            return true;
        }

        public final void a(String str, long j10) {
            long jD = d(str) + j10;
            if (jD <= 100) {
                j10 = jD < 0 ? 0L : jD;
            }
            a(str, String.valueOf(j10));
        }

        public final boolean a(a aVar) {
            if (!this.f22988f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.f22986d), null);
                return false;
            }
            for (String str : aVar.f22985c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long jD = aVar.d(str);
                    if (jD == 0) {
                        a(str, aVar.a(str));
                    } else if (jD < 100) {
                        a(str, jD);
                    }
                }
            }
            return true;
        }

        public final String a(String str) {
            return this.f22985c.get(str);
        }

        public final String a(boolean z10, boolean z11, boolean z12) {
            if (this.f22986d == null) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            if (z10) {
                h.b(sb2, zc.f.f58384n, "uc");
                h.b(sb2, "pre", com.uc.crashsdk.g.e());
                h.b(sb2, "pkg", com.uc.crashsdk.a.f22909a);
                h.b(sb2, "rom", Build.VERSION.RELEASE);
                h.b(sb2, "brd", Build.BRAND);
                h.b(sb2, "model", Build.MODEL);
                h.a(sb2, "sdk", Build.VERSION.SDK_INT);
                h.b(sb2, an.f23257w, com.uc.crashsdk.e.e());
                h.b(sb2, "hdw", com.uc.crashsdk.e.f());
                long jO = h.o();
                h.a(sb2, "ram", jO);
                h.b(sb2, "aram", h.a(jO));
                h.b(sb2, "cver", "3.3.2.2");
                h.b(sb2, "cseq", "211215141717");
                h.b(sb2, "ctag", "release");
                h.b(sb2, "aver", com.uc.crashsdk.a.a());
                h.b(sb2, "ver", com.uc.crashsdk.g.T());
                h.b(sb2, "sver", com.uc.crashsdk.g.U());
                h.b(sb2, "seq", com.uc.crashsdk.g.V());
                h.b(sb2, "grd", com.uc.crashsdk.b.A() ? "fg" : "bg");
                h.b(sb2, "os", l4.f.f39447b);
                h.b(sb2, "dn", com.uc.crashsdk.e.q());
                String strAb = com.uc.crashsdk.g.ab();
                if (TextUtils.isEmpty(strAb)) {
                    strAb = com.uc.crashsdk.e.q();
                }
                h.b(sb2, "k_uid", strAb);
                String strAc = com.uc.crashsdk.g.ac();
                if (!TextUtils.isEmpty(strAc)) {
                    h.b(sb2, "k_channel", strAc);
                }
                sb2.append("\n");
            }
            h.b(sb2, zc.f.f58384n, this.f22986d);
            h.a(sb2, this.f22985c);
            if (this.f22987e && !z11) {
                long j10 = this.f22983a;
                if (j10 != 0) {
                    h.b(sb2, CommonNetImpl.UP, String.valueOf(j10));
                }
                if (z12) {
                    h.b(sb2, "pid", String.format(Locale.US, TimeModel.f21107i, Integer.valueOf(Process.myPid())));
                } else {
                    int i10 = this.f22984b;
                    if (i10 != 0) {
                        h.b(sb2, "pid", String.format(Locale.US, TimeModel.f21107i, Integer.valueOf(i10)));
                    }
                }
            }
            sb2.append("\n");
            return sb2.toString();
        }
    }

    public static /* synthetic */ String a(long j10) {
        return j10 < PlaybackStateCompat.K0 ? "512M" : String.format(Locale.US, "%dG", Long.valueOf(((j10 / 1024) + 512) / 1024));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(u.f30904o);
        sb2.append(str2);
        sb2.append("`");
    }

    public static /* synthetic */ Map c(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] strArrSplit = str2.split(u.f30904o, 3);
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return map;
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    public static boolean e() {
        return f22980j;
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void i() {
        if (com.uc.crashsdk.g.Q()) {
            f.a(1, new e(303));
        }
    }

    public static byte[] j() {
        return new byte[]{127, 100, pq.b.f46992i, 31};
    }

    public static void k() {
        synchronized (f22981k) {
            f22982l = null;
        }
    }

    private static String m() {
        return com.uc.crashsdk.g.W() + "pv.wa";
    }

    private static String n() {
        return com.uc.crashsdk.g.W() + "cdt.wa";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long o() {
        Iterator<String> it2 = g.a(new File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            String next = it2.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e10) {
                    g.a(e10);
                    return 0L;
                }
            }
        }
    }

    public static /* synthetic */ void a(StringBuilder sb2, String str, long j10) {
        b(sb2, str, String.valueOf(j10));
    }

    public static void b() {
        a(2, 0L);
    }

    public static void c() {
        a(3, 0L);
    }

    private static void b(int i10, long j10) {
        if (com.uc.crashsdk.g.Q()) {
            f.a(1, new e(301, new Object[]{Integer.valueOf(i10)}), j10);
        }
    }

    private static boolean c(String str, String str2) {
        boolean z10;
        String string;
        byte[] bArrA;
        byte[] bArrA2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr = new byte[16];
            c.a(bArr, 0, c.a());
            c.a(bArr, 4, j());
            c.a(bArr, 8, com.uc.crashsdk.a.f());
            c.a(bArr, 12, d.d());
            bArrA2 = c.a(bytes, bArr);
        } catch (Throwable th2) {
            g.a(th2);
        }
        if (bArrA2 != null) {
            bytes = bArrA2;
            z10 = true;
        } else {
            z10 = false;
        }
        if (str == null) {
            str = "unknown";
        }
        String str3 = com.uc.crashsdk.g.R() ? "4ea4e41a3993" : "28ef1713347d";
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strD = g.d(str3 + str + strValueOf + "AppChk#2014");
        if (strD == null) {
            string = null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(com.uc.crashsdk.g.z());
            sb2.append("?chk=");
            sb2.append(strD.substring(strD.length() - 8, strD.length()));
            sb2.append("&vno=");
            sb2.append(strValueOf);
            sb2.append("&uuid=");
            sb2.append(str);
            sb2.append("&app=");
            sb2.append(str3);
            if (z10) {
                sb2.append("&enc=aes");
            }
            string = sb2.toString();
        }
        return (string == null || (bArrA = c.a(string, bytes)) == null || !new String(bArrA).contains("retcode=0")) ? false : true;
    }

    private static boolean d(String str) {
        boolean zC;
        File file = new File(str);
        for (a aVar : a(file, "cst", 30)) {
            String strA = aVar.a("prc");
            if (!g.a(strA)) {
                Map<String, a> map = f22975e;
                a aVar2 = map.get(strA);
                if (aVar2 != null) {
                    aVar2.a(aVar);
                } else {
                    map.put(strA, aVar);
                }
            }
        }
        Map<String, a> map2 = f22975e;
        StringBuilder sbA = a((Iterable<a>) map2.values(), true, false);
        if (com.uc.crashsdk.g.aa()) {
            zC = b(com.uc.crashsdk.e.q(), sbA.toString());
        } else {
            zC = c(com.uc.crashsdk.e.q(), sbA.toString());
        }
        g.b(file);
        if (zC || g.a(file, a((Iterable<a>) map2.values(), false, true).toString())) {
            map2.clear();
        }
        return true;
    }

    public static /* synthetic */ void a(StringBuilder sb2, Map map) {
        for (String str : map.keySet()) {
            b(sb2, str, (String) map.get(str));
        }
    }

    public static void a(String str) {
        synchronized (f22972b) {
            File file = new File(m());
            a aVar = new a(SocializeProtocolConstants.PROTOCOL_KEY_PV, true, true);
            String strC = g.c(file);
            if (!g.a(strC)) {
                aVar.c(strC);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    public static boolean b(int i10, Object[] objArr) {
        switch (i10) {
            case 351:
                if (!f22971a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                int iIntValue = ((Integer) objArr[1]).intValue();
                if (iIntValue == 1) {
                    if (f22980j) {
                        return false;
                    }
                    f22980j = true;
                }
                if (!com.uc.crashsdk.g.Z()) {
                    return false;
                }
                File file = new File(str);
                ArrayList<a> arrayListA = a(file, "crp", 100);
                if (iIntValue != 4) {
                    a aVar = new a("crp", false, false);
                    if (iIntValue == 1) {
                        aVar.a("et", String.valueOf(com.uc.crashsdk.b.I()));
                        aVar.a("ete", String.valueOf(com.uc.crashsdk.b.J()));
                    } else if (iIntValue == 3) {
                        aVar.a("et", "1");
                        aVar.a("ete", "1");
                    } else if (iIntValue == 2) {
                        aVar.a("hpv", "1");
                    }
                    aVar.a("prc", com.uc.crashsdk.e.h());
                    aVar.a(z.f23797c, com.uc.crashsdk.b.F() ? "1" : "0");
                    a(aVar);
                    arrayListA.add(0, aVar);
                }
                if (!arrayListA.isEmpty()) {
                    boolean zC = c(com.uc.crashsdk.e.q(), a((Iterable<a>) arrayListA, true, false).toString());
                    g.b(file);
                    if (!zC) {
                        g.a(file, a((Iterable<a>) arrayListA, false, true).toString());
                    }
                }
                return true;
            case 352:
                if (f22971a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (f22971a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case 354:
                if (!f22971a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                boolean zC2 = c(com.uc.crashsdk.e.q(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                if (zC2) {
                    g.b(file2);
                }
                return zC2;
            default:
                return false;
        }
    }

    public static void a() {
        a(0, com.uc.crashsdk.b.H() ? 700000L : 70000L);
    }

    private static void a(int i10, long j10) {
        if (com.uc.crashsdk.b.F()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i10)}), j10);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            String strReplaceAll = g.a(str2) ? "" : str2.replaceAll("[`=]", "-");
            Map<String, String> map = f22973c;
            synchronized (map) {
                if (map.get(str3) == null) {
                    int i10 = f22974d;
                    if (i10 >= 20) {
                        return false;
                    }
                    f22974d = i10 + 1;
                }
                map.put(str3, strReplaceAll);
                return true;
            }
        } catch (Throwable th2) {
            g.a(th2);
            return false;
        }
    }

    public static void b(boolean z10) {
        if (a(z10, "crash detail upload")) {
            return;
        }
        String str = com.uc.crashsdk.g.W() + "dt.wa";
        com.uc.crashsdk.b.a(f22976f, str, new e(352, new Object[]{str}));
        String strN = n();
        com.uc.crashsdk.b.a(f22977g, strN, new e(354, new Object[]{strN}));
    }

    private static boolean b(String str, String str2) {
        boolean z10;
        byte[] bArrA;
        byte[] bArrA2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strD = g.d(com.uc.crashsdk.g.e() + str + jCurrentTimeMillis + "AppChk#2014");
        try {
            bArrA2 = c.a(bytes, strD.substring(strD.length() - 16, strD.length()).getBytes());
        } catch (Throwable th2) {
            g.a(th2);
        }
        if (bArrA2 != null) {
            bytes = bArrA2;
            z10 = true;
        } else {
            z10 = false;
        }
        String strSubstring = strD.substring(strD.length() - 8, strD.length());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.uc.crashsdk.g.z());
        sb2.append("/api/v1/crashtrack/upload?chk=");
        sb2.append(strSubstring);
        sb2.append("&vno=");
        sb2.append(jCurrentTimeMillis);
        sb2.append("&uuid=");
        sb2.append(str);
        sb2.append("&app=");
        sb2.append(com.uc.crashsdk.g.e());
        if (z10) {
            sb2.append("&enc=aes");
        }
        String string = sb2.toString();
        return (string == null || (bArrA = c.a(string, bytes)) == null || !new String(bArrA).contains("retcode=0")) ? false : true;
    }

    private static void a(a aVar) {
        Map<String, String> map = f22973c;
        synchronized (map) {
            for (String str : map.keySet()) {
                aVar.a(str, f22973c.get(str));
            }
        }
    }

    public static void a(boolean z10) {
        a(1, z10);
    }

    public static boolean a(boolean z10, String str) {
        if (!com.uc.crashsdk.b.f23003d || z10 || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    private static boolean b(String str, String str2, boolean z10, boolean z11) {
        a aVar;
        File file = new File(n());
        ArrayList<a> arrayListA = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it2 = arrayListA.iterator();
        while (true) {
            if (!it2.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it2.next();
            if (str3.equals(aVar.b("prc") + aVar.b("typ"))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a("typ", str2);
            a(aVar);
            arrayListA.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z10) {
            aVar.a("lim", 1L);
        }
        if (z11) {
            aVar.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) arrayListA, false, false).toString());
    }

    private static void a(int i10, boolean z10) {
        if (a(z10, "crash rate")) {
            return;
        }
        String str = com.uc.crashsdk.g.W() + "cr.wa";
        com.uc.crashsdk.b.a(f22972b, str, new e(351, new Object[]{str, Integer.valueOf(i10)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5 A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00af A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.a(int, java.lang.Object[]):void");
    }

    public static void b(String str) {
        synchronized (f22981k) {
            f22982l = str;
            b.a(com.uc.crashsdk.b.k(), str + "\n");
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z10, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        boolean z12 = true;
        for (a aVar : iterable) {
            if (z12) {
                sb2.append(aVar.a(z10, z10, z11));
                z12 = false;
            } else {
                sb2.append(aVar.a(false, z10, z11));
            }
        }
        return sb2;
    }

    public static void a(String str, int i10, int i11) {
        if (com.uc.crashsdk.g.Q()) {
            synchronized (f22976f) {
                Map<String, a> map = f22975e;
                a aVar = map.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    map.put(str, aVar);
                    a(aVar);
                }
                SparseArray<String> sparseArray = f22978h;
                synchronized (sparseArray) {
                    if (sparseArray.size() == 0) {
                        a(100, SocializeProtocolConstants.PROTOCOL_KEY_PV);
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = sparseArray.get(i10);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i10, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i11));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z10, boolean z11) {
        if (!com.uc.crashsdk.g.Q()) {
            return false;
        }
        return com.uc.crashsdk.b.a(f22977g, n(), new e(353, new Object[]{str, str2, Boolean.valueOf(z10), Boolean.valueOf(z11)}));
    }

    private static void a(int i10, String str) {
        f22978h.put(i10, str);
    }

    private static ArrayList<a> a(File file, String str, int i10) {
        ArrayList<String> arrayListA = g.a(file, i10);
        ArrayList<a> arrayList = new ArrayList<>();
        for (String str2 : arrayListA) {
            a aVar = new a(str, false, false);
            if (aVar.c(str2)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
