package org.bouncycastle.jce;

import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static Enumeration a() {
        return co.e.e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        r0 = co.e.b(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static gr.c b(java.lang.String r8) {
        /*
            co.l r0 = ap.a.j(r8)
            if (r0 != 0) goto L24
            gm.y r1 = new gm.y     // Catch: java.lang.IllegalArgumentException -> L10
            r1.<init>(r8)     // Catch: java.lang.IllegalArgumentException -> L10
            co.l r0 = ap.a.k(r1)     // Catch: java.lang.IllegalArgumentException -> L10
            goto L11
        L10:
        L11:
            if (r0 != 0) goto L24
            co.l r0 = co.e.b(r8)
            if (r0 != 0) goto L24
            gm.y r1 = new gm.y     // Catch: java.lang.IllegalArgumentException -> L23
            r1.<init>(r8)     // Catch: java.lang.IllegalArgumentException -> L23
            co.l r0 = co.e.c(r1)     // Catch: java.lang.IllegalArgumentException -> L23
            goto L24
        L23:
        L24:
            if (r0 != 0) goto L28
            r8 = 0
            return r8
        L28:
            gr.c r7 = new gr.c
            ir.e r2 = r0.y()
            ir.i r3 = r0.B()
            java.math.BigInteger r4 = r0.E()
            java.math.BigInteger r5 = r0.C()
            byte[] r6 = r0.F()
            r0 = r7
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.b.b(java.lang.String):gr.c");
    }
}
