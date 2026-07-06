package a;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<T>] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class he2<T> extends hc2<T> implements fe2<T> {
    public he2(l62 l62Var, boolean z) {
        super(l62Var, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object J0(a.he2 r4, a.b62 r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof a.ge2
            if (r0 == 0) goto L13
            r0 = r5
            a.ge2 r0 = (a.ge2) r0
            int r1 = r0.f6200a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6200a = r1
            goto L18
        L13:
            a.ge2 r0 = new a.ge2
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f1002a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6200a
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.b
            a.he2 r4 = (a.he2) r4
            a.h42.b(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            a.h42.b(r5)
            r0.b = r4
            r0.f6200a = r3
            java.lang.Object r5 = r4.F(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.he2.J0(a.he2, a.b62):java.lang.Object");
    }

    @Override // a.fe2
    public Object s(b62<? super T> b62Var) {
        return J0(this, b62Var);
    }

    @Override // a.fe2
    public T z() {
        return (T) T();
    }
}
