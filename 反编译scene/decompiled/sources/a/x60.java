package a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x60 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f3534a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x60 f7856a = new x60();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ArrayList<String> f3535a = new ArrayList<>();
    public static String b = "";

    public static /* synthetic */ Object l(x60 x60Var, List list, int i, b62 b62Var, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 436;
        }
        return x60Var.k(list, i, b62Var);
    }

    public final d42<String, String> a(String[] strArr) {
        f92.d(strArr, "files");
        int i = 0;
        for (String str : g(strArr)) {
            if (str != null) {
                return new d42<>(strArr[i], str);
            }
            i++;
        }
        return null;
    }

    public final String b() {
        Object obj;
        List listD0;
        String str;
        if (b.length() == 0) {
            Iterator it = ec2.d0(d("/proc/mounts"), new String[]{"\n"}, false, 0, 6, null).iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (bc2.x((String) next, "debugfs", false, 2, null)) {
                    obj = next;
                    break;
                }
            }
            String str2 = (String) obj;
            String str3 = "";
            if (str2 != null && (listD0 = ec2.d0(str2, new String[]{""}, false, 0, 6, null)) != null && (str = (String) listD0.get(1)) != null) {
                str3 = str;
            }
            b = str3;
        }
        return b;
    }

    public final String c() {
        String string;
        List<String> listH;
        String str;
        String str2 = f3534a;
        if (str2 == null || str2.length() == 0) {
            String str3 = (String) i52.C(ec2.d0(d("/proc/version"), new String[]{"-"}, false, 0, 6, null));
            if (str3 == null || (listH = new nb2("[\\s]+").h(str3, 0)) == null || (str = (String) i52.K(listH)) == null) {
                string = null;
            } else {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                string = ec2.r0(str).toString();
            }
            f3534a = string;
        }
        String str4 = f3534a;
        return str4 != null ? str4 : "";
    }

    public final String d(String str) {
        f92.d(str, "propName");
        return (String) pc2.b(null, new u60(str, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r5, a.b62<? super java.lang.String> r6) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof a.v60
            if (r0 == 0) goto L13
            r0 = r6
            a.v60 r0 = (a.v60) r0
            int r1 = r0.f7662a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7662a = r1
            goto L18
        L13:
            a.v60 r0 = new a.v60
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f3250a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7662a
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.c
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.b
            a.x60 r5 = (a.x60) r5
            a.h42.b(r6)
            goto L82
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            a.h42.b(r6)
            java.util.ArrayList<java.lang.String> r6 = a.x60.f3535a
            boolean r6 = r6.contains(r5)
            if (r6 != 0) goto L73
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            boolean r2 = r6.exists()
            if (r2 == 0) goto L6e
            boolean r2 = r6.canRead()
            if (r2 == 0) goto L6e
            java.nio.charset.Charset r2 = a.bb2.f5692a     // Catch: java.lang.Exception -> L6e
            java.lang.String r6 = a.o72.d(r6, r2)     // Catch: java.lang.Exception -> L6e
            if (r6 == 0) goto L66
            java.lang.CharSequence r6 = a.ec2.r0(r6)     // Catch: java.lang.Exception -> L6e
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Exception -> L6e
            return r5
        L66:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch: java.lang.Exception -> L6e
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.CharSequence"
            r6.<init>(r2)     // Catch: java.lang.Exception -> L6e
            throw r6     // Catch: java.lang.Exception -> L6e
        L6e:
            java.util.ArrayList<java.lang.String> r6 = a.x60.f3535a
            r6.add(r5)
        L73:
            a.e50 r6 = a.e50.f677a
            r0.b = r4
            r0.c = r5
            r0.f7662a = r3
            java.lang.Object r6 = r6.o0(r5, r0)
            if (r6 != r1) goto L82
            return r1
        L82:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r5 = "error"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L8f
            java.lang.String r5 = ""
            return r5
        L8f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.x60.e(java.lang.String, a.b62):java.lang.Object");
    }

    public final Object f(String[] strArr, b62<? super String[]> b62Var) {
        return e50.f677a.p0(strArr, b62Var);
    }

    public final String[] g(String[] strArr) {
        f92.d(strArr, "files");
        return (String[]) pc2.b(null, new w60(strArr, null), 1, null);
    }

    public final boolean h() {
        return ((String) i52.A(ec2.d0(c(), new String[]{"."}, false, 0, 6, null))).compareTo("5") > 0;
    }

    public final boolean i(String str, String str2) {
        f92.d(str, "propName");
        f92.d(str2, "value");
        return !f92.a(e50.f677a.Z0(str, str2, 292, 3000L), "error");
    }

    public final boolean j(String str, String str2) {
        f92.d(str, "propName");
        f92.d(str2, "value");
        return !f92.a(e50.f677a.Z0(str, str2, 436, 3000L), "error");
    }

    public final Object k(List<d42<String, String>> list, int i, b62<? super m42> b62Var) {
        d30 d30Var = new d30();
        for (d42<String, String> d42Var : list) {
            g30 g30Var = new g30();
            g30Var.x("path", d42Var.c());
            g30Var.x("text", d42Var.d());
            g30Var.v("mode", i);
            m42 m42Var = m42.f6769a;
            d30Var.k(g30Var);
        }
        e50 e50Var = e50.f677a;
        String string = d30Var.toString();
        f92.c(string, "builder.toString()");
        Object objA1 = e50Var.a1(string, b62Var);
        return objA1 == r62.c() ? objA1 : m42.f6769a;
    }
}
