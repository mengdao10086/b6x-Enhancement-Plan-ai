package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$updateState$1", f = "FragmentPerf.kt", l = {553, 554}, m = "invokeSuspend")
public final class iv1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f6447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1412a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1413b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f1414b;
    public Object c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv1(kv1 kv1Var, boolean z, b62 b62Var) {
        super(2, b62Var);
        this.f6447a = kv1Var;
        this.f1414b = z;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        iv1 iv1Var = new iv1(this.f6447a, this.f1414b, b62Var);
        iv1Var.f1411a = (wd2) obj;
        return iv1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((iv1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009e A[RETURN] */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r8) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r7 = this;
            java.lang.Object r0 = a.r62.c()
            int r1 = r7.b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3b
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r0 = r7.c
            a.i92 r0 = (a.i92) r0
            java.lang.Object r0 = r7.f1413b
            a.i92 r0 = (a.i92) r0
            java.lang.Object r0 = r7.f1412a
            a.wd2 r0 = (a.wd2) r0
            a.h42.b(r8)
            goto L9f
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L27:
            java.lang.Object r1 = r7.d
            a.i92 r1 = (a.i92) r1
            java.lang.Object r4 = r7.c
            a.i92 r4 = (a.i92) r4
            java.lang.Object r5 = r7.f1413b
            a.i92 r5 = (a.i92) r5
            java.lang.Object r6 = r7.f1412a
            a.wd2 r6 = (a.wd2) r6
            a.h42.b(r8)
            goto L6d
        L3b:
            a.h42.b(r8)
            a.wd2 r6 = r7.f1411a
            a.i92 r5 = new a.i92
            r5.<init>()
            a.hn0 r8 = new a.hn0
            r8.<init>()
            boolean r8 = r8.d()
            r5.b = r8
            a.i92 r1 = new a.i92
            r1.<init>()
            boolean r8 = r7.f1414b
            if (r8 == 0) goto L82
            a.e50 r8 = a.e50.f677a
            r7.f1412a = r6
            r7.f1413b = r5
            r7.c = r1
            r7.d = r1
            r7.b = r3
            java.lang.Object r8 = r8.L0(r7)
            if (r8 != r0) goto L6c
            return r0
        L6c:
            r4 = r1
        L6d:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L83
            a.kv1 r8 = r7.f6447a
            a.wu0 r8 = a.kv1.C1(r8)
            boolean r8 = r8.s()
            if (r8 != 0) goto L83
            goto L84
        L82:
            r4 = r1
        L83:
            r3 = 0
        L84:
            r1.b = r3
            a.fg2 r8 = a.qe2.c()
            a.hv1 r1 = new a.hv1
            r3 = 0
            r1.<init>(r7, r5, r4, r3)
            r7.f1412a = r6
            r7.f1413b = r5
            r7.c = r4
            r7.b = r2
            java.lang.Object r8 = a.oc2.g(r8, r1, r7)
            if (r8 != r0) goto L9f
            return r0
        L9f:
            a.m42 r8 = a.m42.f6769a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.iv1.j(java.lang.Object):java.lang.Object");
    }
}
