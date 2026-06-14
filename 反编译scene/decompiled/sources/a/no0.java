package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class no0 extends r50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final io0 f6937a = new io0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f2128a = "http://scene7.omarea.com:8080";
    public static String b = "http://119.91.234.23:8080";
    public static String c = "http://vtools.online";

    /* JADX WARN: Multi-variable type inference failed */
    public no0() {
        super(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void B(no0 no0Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        no0Var.A(z);
    }

    public static /* synthetic */ Object E(no0 no0Var, String str, b62 b62Var, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return no0Var.C(str, b62Var);
    }

    public final void A(boolean z) {
        if (!z) {
            String strH = Scene.f4798a.h("area", "");
            if (!(strH == null || strH.length() == 0)) {
                return;
            }
        }
        qc2.d(xd2.a(qe2.b()), null, null, new jo0(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(java.lang.String r8, a.b62<? super java.lang.Boolean> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof a.lo0
            if (r0 == 0) goto L13
            r0 = r9
            a.lo0 r0 = (a.lo0) r0
            int r1 = r0.f6726a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6726a = r1
            goto L18
        L13:
            a.lo0 r0 = new a.lo0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f1841a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6726a
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r8 = r0.c
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.b
            a.no0 r8 = (a.no0) r8
            a.h42.b(r9)
            goto L51
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            a.h42.b(r9)
            r5 = 3000(0xbb8, double:1.482E-320)
            a.mo0 r9 = new a.mo0
            r9.<init>(r7, r8, r3)
            r0.b = r7
            r0.c = r8
            r0.f6726a = r4
            java.lang.Object r9 = a.wg2.c(r5, r9, r0)
            if (r9 != r1) goto L51
            return r1
        L51:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L68
            if (r9 == 0) goto L60
            java.lang.CharSequence r8 = a.ec2.r0(r9)
            java.lang.String r3 = r8.toString()
            goto L68
        L60:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.CharSequence"
            r8.<init>(r9)
            throw r8
        L68:
            java.lang.String r8 = "OK"
            boolean r8 = a.f92.a(r3, r8)
            java.lang.Boolean r8 = a.t62.a(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.no0.C(java.lang.String, a.b62):java.lang.Object");
    }

    public final void D(Runnable runnable) {
        f92.d(runnable, "next");
        qc2.d(xd2.a(qe2.b()), null, null, new ko0(this, runnable, null), 3, null);
    }
}
