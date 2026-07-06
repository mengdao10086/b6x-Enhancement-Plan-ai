package a;

import com.omarea.Scene;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ar0 f7823a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f3481a = "";
    public static String b = "";
    public static String c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final su0 f3480a = new su0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final dx0 f3478a = new dx0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ri0 f3479a = new ri0(Scene.f4798a.c());
    public static String d = "powersave";
    public static String e = "performance";
    public static String f = "fast";
    public static String g = "balance";
    public static String h = "pedestal";
    public static String i = "auto";
    public static String j = "igoned";
    public static String k = "balance";
    public static String l = "init";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ArrayList<tu0> f3482a = new ArrayList<>();

    public final void m() {
        f3481a = "";
    }

    public final void n() {
        qc2.d(xd2.a(qe2.b()), null, null, new uu0(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object o(java.lang.String r12, java.lang.String r13, java.lang.String r14, a.b62<? super a.wu0> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof a.vu0
            if (r0 == 0) goto L13
            r0 = r15
            a.vu0 r0 = (a.vu0) r0
            int r1 = r0.f7725a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7725a = r1
            goto L18
        L13:
            a.vu0 r0 = new a.vu0
            r0.<init>(r11, r15)
        L18:
            r9 = r0
            java.lang.Object r15 = r9.f3306a
            java.lang.Object r0 = a.r62.c()
            int r1 = r9.f7725a
            r2 = 1
            if (r1 == 0) goto L50
            if (r1 != r2) goto L48
            java.lang.Object r12 = r9.g
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = r9.f3307b
            java.lang.Object r12 = r9.f
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r12 = r9.e
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r12 = r9.d
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r9.c
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r9.b
            a.wu0 r14 = (a.wu0) r14
            a.h42.b(r15)
            r10 = r13
            r13 = r12
            r12 = r10
            goto Lb2
        L48:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L50:
            a.h42.b(r15)
            java.lang.String r15 = a.wu0.j
            boolean r15 = a.f92.a(r12, r15)
            r15 = r15 ^ r2
            if (r15 == 0) goto Lb8
            a.su0 r15 = a.wu0.f3480a
            java.lang.String r6 = r15.e()
            a.ri0 r15 = a.wu0.f3479a
            java.lang.Boolean r15 = r15.d(r13)
            java.lang.Boolean r1 = a.t62.a(r2)
            boolean r15 = a.f92.a(r15, r1)
            if (r15 == 0) goto L75
            java.lang.String r1 = "game"
            goto L77
        L75:
            java.lang.String r1 = "app"
        L77:
            r3 = r1
            java.lang.String r1 = a.wu0.f3481a
            boolean r1 = a.f92.a(r1, r6)
            r1 = r1 ^ r2
            if (r1 == 0) goto L84
            r11.q()
        L84:
            java.lang.String r1 = a.wu0.b
            int r1 = r1.length()
            if (r1 != 0) goto L8e
            r1 = r2
            goto L8f
        L8e:
            r1 = 0
        L8f:
            if (r1 == 0) goto L92
            return r11
        L92:
            a.e50 r1 = a.e50.f677a
            r7 = 0
            r8 = 0
            r9.b = r11
            r9.c = r12
            r9.d = r13
            r9.e = r14
            r9.f = r6
            r9.f3307b = r15
            r9.g = r3
            r9.f7725a = r2
            r2 = r3
            r3 = r13
            r4 = r12
            r5 = r14
            java.lang.Object r14 = r1.S0(r2, r3, r4, r5, r6, r7, r8, r9)
            if (r14 != r0) goto Lb1
            return r0
        Lb1:
            r14 = r11
        Lb2:
            a.dx0 r15 = a.wu0.f3478a
            r15.c(r12)
            goto Lb9
        Lb8:
            r14 = r11
        Lb9:
            a.dx0 r12 = a.wu0.f3478a
            r12.d(r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.wu0.o(java.lang.String, java.lang.String, java.lang.String, a.b62):java.lang.Object");
    }

    public final ar0 p() {
        ar0 ar0Var;
        if (f92.a(c, f3480a.e()) && (ar0Var = f7823a) != null) {
            return ar0Var;
        }
        try {
            File file = new File(c60.f5764a.d(Scene.f4798a.c(), "manifest.json"));
            Charset charsetDefaultCharset = Charset.defaultCharset();
            f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
            String strD = o72.d(file, charsetDefaultCharset);
            ar0 ar0Var2 = new ar0();
            ar0Var2.q(new g30(strD));
            return ar0Var2;
        } catch (Exception unused) {
            return null;
        }
    }

    public final wu0 q() {
        String strD = bv0.f5735a.a() ? "/data/powercfg.sh" : c60.f5764a.d(Scene.f4798a.c(), "powercfg.sh");
        b = strD;
        if (strD.length() > 0) {
            String strD2 = c60.f5764a.d(Scene.f4798a.c(), "features/env.conf");
            StringBuilder sb = new StringBuilder();
            if (new File(strD2).exists()) {
                File file = new File(strD2);
                Charset charsetDefaultCharset = Charset.defaultCharset();
                f92.c(charsetDefaultCharset, "Charset.defaultCharset()");
                Iterator<T> it = o72.c(file, charsetDefaultCharset).iterator();
                while (it.hasNext()) {
                    sb.append("export " + ((String) it.next()) + '\n');
                }
            }
            sb.append("sh " + b + ' ' + l + " > /dev/null 2>&1");
            e50 e50Var = e50.f677a;
            String string = sb.toString();
            f92.c(string, "cmd.toString()");
            e50Var.a0(string, 5000L);
            f3478a.c("");
            f3481a = f3480a.e();
        }
        return this;
    }

    public final boolean r() {
        ar0 ar0VarP = p();
        if (ar0VarP != null) {
            return ar0VarP.i();
        }
        return false;
    }

    public final boolean s() {
        if (bv0.f5735a.a()) {
            return true;
        }
        String strE = f3480a.e();
        int iHashCode = strE.hashCode();
        if (iHashCode == -610722744 ? !strE.equals("SOURCE_SCENE_CUSTOM") : !(iHashCode == -273856726 && strE.equals("SOURCE_SCENE_ONLINE"))) {
            return false;
        }
        if (new bv0().f()) {
            ar0 ar0VarP = p();
            if (f92.a(ar0VarP != null ? ar0VarP.a() : null, "SCENE9")) {
                return true;
            }
        }
        return false;
    }

    public final boolean t() {
        ar0 ar0VarP = p();
        if (ar0VarP != null) {
            return ar0VarP.l();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a.wu0 u(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.wu0.u(java.lang.String, java.lang.String, java.lang.String):a.wu0");
    }
}
