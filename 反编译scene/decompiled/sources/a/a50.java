package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$tryReconnect$1", f = "Daemon.kt", l = {1431}, m = "invokeSuspend")
public final class a50 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f31a;
    public int b;
    public int c;

    public a50(b62 b62Var) {
        super(2, b62Var);
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        a50 a50Var = new a50(b62Var);
        a50Var.f5571a = (wd2) obj;
        return a50Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((a50) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0042 -> B:16:0x0045). Please report as a decompilation issue!!! */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = a.r62.c()
            int r1 = r9.c
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 != r3) goto L17
            int r1 = r9.b
            java.lang.Object r4 = r9.f31a
            a.wd2 r4 = (a.wd2) r4
            a.h42.b(r10)
            r10 = r9
            goto L45
        L17:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1f:
            a.h42.b(r10)
            a.wd2 r10 = r9.f5571a
            r4 = r10
            r1 = r2
            r10 = r9
        L27:
            r5 = 10
            r6 = 0
            if (r1 >= r5) goto L47
            a.e50 r5 = a.e50.f677a
            r7 = 0
            boolean r5 = a.e50.B1(r5, r7, r3, r6)
            if (r5 != 0) goto L47
            r5 = 300(0x12c, double:1.48E-321)
            r10.f31a = r4
            r10.b = r1
            r10.c = r3
            java.lang.Object r5 = a.ke2.a(r5, r10)
            if (r5 != r0) goto L45
            return r0
        L45:
            int r1 = r1 + r3
            goto L27
        L47:
            a.e50 r10 = a.e50.f677a
            a.o30 r0 = a.o30.STATUS_STOP
            a.e50.H(r10, r0)
            a.e50 r10 = a.e50.f677a
            a.e50.J(r10, r2)
            a.e50 r10 = a.e50.f677a
            java.lang.String r10 = a.e50.E(r10)
            java.lang.String r0 = "root"
            boolean r10 = a.f92.a(r10, r0)
            if (r10 == 0) goto L66
            a.e50 r10 = a.e50.f677a
            a.e50.s1(r10, r2, r3, r6)
        L66:
            a.m42 r10 = a.m42.f6769a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a50.j(java.lang.Object):java.lang.Object");
    }
}
