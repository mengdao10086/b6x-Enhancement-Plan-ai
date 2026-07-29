package com.umeng.analytics.pro;

/* JADX INFO: loaded from: classes5.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23196a = "OpenId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f23197b;

    public static void a(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setDebug:");
        sb2.append(z10);
        f23197b = z10;
    }

    public static void b(String str, Object... objArr) {
        if (f23197b) {
            e(str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        if (f23197b) {
            e(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (f23197b) {
            e(str, objArr);
        }
    }

    private static String e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i10 = 0;
        objArr2[0] = str;
        sb2.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= objArr.length) {
                    break;
                }
                sb2.append(a(objArr[i10], objArr[i11]));
                if (i11 < length - 1) {
                    sb2.append(ag.c.f654g);
                }
                i10 = i11 + 1;
            }
            if (i10 == objArr.length - 1) {
                sb2.append(objArr[i10]);
            }
        }
        return sb2.toString();
    }

    public static void a(String str, Object... objArr) {
        if (f23197b) {
            e(str, objArr);
        }
    }

    private static String a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }
}
