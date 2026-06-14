package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zz1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a02 f8113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3921a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zz1(a02 a02Var, b62 b62Var) {
        super(2, b62Var);
        this.f8113a = a02Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        zz1 zz1Var = new zz1(this.f8113a, b62Var);
        zz1Var.f3920a = (wd2) obj;
        return zz1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((zz1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[RETURN] */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = a.r62.c()
            int r1 = r6.b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L31
            if (r1 == r4) goto L29
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            java.lang.Object r0 = r6.f3921a
            a.wd2 r0 = (a.wd2) r0
            a.h42.b(r7)
            goto L70
        L19:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L21:
            java.lang.Object r1 = r6.f3921a
            a.wd2 r1 = (a.wd2) r1
            a.h42.b(r7)
            goto L5b
        L29:
            java.lang.Object r1 = r6.f3921a
            a.wd2 r1 = (a.wd2) r1
            a.h42.b(r7)
            goto L4e
        L31:
            a.h42.b(r7)
            a.wd2 r7 = r6.f3920a
            a.a02 r1 = r6.f8113a
            a.l02 r1 = r1.f2a
            a.ez0 r1 = a.l02.h(r1)
            a.a02 r5 = r6.f8113a
            int r5 = r5.f5555a
            r6.f3921a = r7
            r6.b = r4
            java.lang.Object r1 = r1.n(r5, r6)
            if (r1 != r0) goto L4d
            return r0
        L4d:
            r1 = r7
        L4e:
            r4 = 200(0xc8, double:9.9E-322)
            r6.f3921a = r1
            r6.b = r3
            java.lang.Object r7 = a.ke2.a(r4, r6)
            if (r7 != r0) goto L5b
            return r0
        L5b:
            a.fg2 r7 = a.qe2.c()
            a.yz1 r3 = new a.yz1
            r4 = 0
            r3.<init>(r6, r4)
            r6.f3921a = r1
            r6.b = r2
            java.lang.Object r7 = a.oc2.g(r7, r3, r6)
            if (r7 != r0) goto L70
            return r0
        L70:
            a.m42 r7 = a.m42.f6769a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.zz1.j(java.lang.Object):java.lang.Object");
    }
}
