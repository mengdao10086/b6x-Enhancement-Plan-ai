package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class lc2 {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(java.util.Collection<? extends a.fe2<? extends T>> r4, a.b62<? super java.util.List<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof a.kc2
            if (r0 == 0) goto L13
            r0 = r5
            a.kc2 r0 = (a.kc2) r0
            int r1 = r0.f6593a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6593a = r1
            goto L18
        L13:
            a.kc2 r0 = new a.kc2
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f1616a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6593a
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.b
            java.util.Collection r4 = (java.util.Collection) r4
            a.h42.b(r5)
            goto L5e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            a.h42.b(r5)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L43
            java.util.List r4 = a.y42.e()
            goto L61
        L43:
            a.jc2 r5 = new a.jc2
            r2 = 0
            a.fe2[] r2 = new a.fe2[r2]
            java.lang.Object[] r2 = r4.toArray(r2)
            if (r2 == 0) goto L62
            a.fe2[] r2 = (a.fe2[]) r2
            r5.<init>(r2)
            r0.b = r4
            r0.f6593a = r3
            java.lang.Object r5 = r5.b(r0)
            if (r5 != r1) goto L5e
            return r1
        L5e:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L61:
            return r4
        L62:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.lc2.a(java.util.Collection, a.b62):java.lang.Object");
    }
}
