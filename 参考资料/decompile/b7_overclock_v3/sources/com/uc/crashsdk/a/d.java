package com.uc.crashsdk.a;

import androidx.work.p;
import com.tencent.connect.common.Constants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import hb.u;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f22940a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f22941b = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f22943d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f22944e = "hsdk";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f22945f = "alid ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f22946g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f22948i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f22942c = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f22947h = new Object();

    public static void a() {
        f.a(0, new e(500), com.uc.crashsdk.b.H() ? p.f8749g : 90000L);
    }

    public static String b() {
        try {
            return "inv" + f22945f + "cras" + f22944e;
        } catch (Throwable th2) {
            g.b(th2);
            return "";
        }
    }

    public static void c() {
        synchronized (f22947h) {
            f22948i = null;
        }
    }

    public static byte[] d() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean e() {
        if (!com.uc.crashsdk.e.F() && !com.uc.crashsdk.b.L()) {
            a(true);
            return f22941b;
        }
        return true;
    }

    private static String f() {
        String strA = f22948i;
        if (g.a(strA)) {
            synchronized (f22947h) {
                strA = g.a(com.uc.crashsdk.b.j(), (com.uc.crashsdk.g.R() ? "https://errlogos.umeng.com" : "https://errlog.umeng.com") + "/api/crashsdk/validate", true);
                f22948i = strA;
            }
        }
        return strA;
    }

    private static String g() {
        byte[] bArrA;
        String strF;
        byte[] bArrA2;
        byte[] bArrA3;
        StringBuilder sb2 = new StringBuilder();
        a(sb2, Constants.PARAM_PLATFORM, com.uc.crashsdk.g.e());
        a(sb2, "pkgname", com.uc.crashsdk.a.f22909a);
        a(sb2, UMModuleRegister.PROCESS, com.uc.crashsdk.e.h());
        a(sb2, db.d.f26139i, com.uc.crashsdk.a.a());
        a(sb2, "cver", "3.3.2.2");
        a(sb2, "ctag", "release");
        a(sb2, "inter", com.uc.crashsdk.g.R() ? "true" : "false");
        a(sb2, "os", l4.f.f39447b);
        String string = sb2.toString();
        byte[] bArr = new byte[16];
        c.a(bArr, 0, h.j());
        c.a(bArr, 4, c.a());
        c.a(bArr, 8, d());
        c.a(bArr, 12, com.uc.crashsdk.a.f());
        try {
            bArrA = c.a(string.getBytes(), bArr, true);
        } catch (Throwable th2) {
            g.a(th2);
            bArrA = null;
        }
        if (bArrA == null || (strF = f()) == null || (bArrA2 = c.a(strF, bArrA)) == null) {
            return null;
        }
        try {
            bArrA3 = c.a(bArrA2, bArr, false);
        } catch (Throwable th3) {
            g.a(th3);
            bArrA3 = null;
        }
        if (bArrA3 != null) {
            return new String(bArrA3);
        }
        return null;
    }

    public static void a(int i10) {
        if (i10 != 500) {
            if (!f22940a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (f22942c) {
            f22946g = null;
            a(!com.uc.crashsdk.b.F());
            if (g.b(f22946g)) {
                h.a(f22946g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    private static StringBuilder a(StringBuilder sb2, String str, String str2) {
        if (sb2.length() > 0) {
            sb2.append("`");
        }
        sb2.append(str);
        sb2.append(u.f30904o);
        sb2.append(str2);
        return sb2;
    }
}
