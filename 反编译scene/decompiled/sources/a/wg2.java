package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class wg2 {
    public static final tg2 a(long j, qf2 qf2Var) {
        return new tg2("Timed out waiting for " + j + " ms", qf2Var);
    }

    public static final <U, T extends U> Object b(ug2<U, ? super T> ug2Var, k82<? super wd2, ? super b62<? super T>, ? extends Object> k82Var) {
        uf2.c(ug2Var, ke2.b(((ji2) ug2Var).f6514a.c()).e(ug2Var.f7595a, ug2Var));
        return yi2.c(ug2Var, ug2Var, k82Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, a.ug2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(long r7, a.k82<? super a.wd2, ? super a.b62<? super T>, ? extends java.lang.Object> r9, a.b62<? super T> r10) {
        /*
            boolean r0 = r10 instanceof a.vg2
            if (r0 == 0) goto L13
            r0 = r10
            a.vg2 r0 = (a.vg2) r0
            int r1 = r0.f7695a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7695a = r1
            goto L18
        L13:
            a.vg2 r0 = new a.vg2
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f3280a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7695a
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r7 = r0.c
            a.n92 r7 = (a.n92) r7
            java.lang.Object r8 = r0.b
            a.k82 r8 = (a.k82) r8
            long r8 = r0.f3279a
            a.h42.b(r10)     // Catch: a.tg2 -> L34
            goto L6f
        L34:
            r8 = move-exception
            goto L72
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            a.h42.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L48
            return r4
        L48:
            a.n92 r10 = new a.n92
            r10.<init>()
            r10.f6891a = r4
            r0.f3279a = r7     // Catch: a.tg2 -> L70
            r0.b = r9     // Catch: a.tg2 -> L70
            r0.c = r10     // Catch: a.tg2 -> L70
            r0.f7695a = r3     // Catch: a.tg2 -> L70
            a.ug2 r2 = new a.ug2     // Catch: a.tg2 -> L70
            r2.<init>(r7, r0)     // Catch: a.tg2 -> L70
            r10.f6891a = r2     // Catch: a.tg2 -> L70
            java.lang.Object r7 = b(r2, r9)     // Catch: a.tg2 -> L70
            java.lang.Object r8 = a.r62.c()     // Catch: a.tg2 -> L70
            if (r7 != r8) goto L6b
            a.z62.c(r0)     // Catch: a.tg2 -> L70
        L6b:
            if (r7 != r1) goto L6e
            return r1
        L6e:
            r10 = r7
        L6f:
            return r10
        L70:
            r8 = move-exception
            r7 = r10
        L72:
            a.qf2 r9 = r8.f7499a
            T r7 = r7.f6891a
            a.ug2 r7 = (a.ug2) r7
            if (r9 != r7) goto L7b
            return r4
        L7b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.wg2.c(long, a.k82, a.b62):java.lang.Object");
    }
}
