package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$setMainDevice$1$1$1$onConfirm$1", f = "FragmentUser.kt", l = {196, 197, 198}, m = "invokeSuspend")
public final class vw1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ww1 f3310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3311a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vw1(ww1 ww1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3310a = ww1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        vw1 vw1Var = new vw1(this.f3310a, b62Var);
        vw1Var.f7731a = (wd2) obj;
        return vw1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((vw1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[RETURN] */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = a.r62.c()
            int r1 = r8.b
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L32
            if (r1 == r5) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r8.f3311a
            a.wd2 r0 = (a.wd2) r0
            a.h42.b(r9)
            goto L7d
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            java.lang.Object r1 = r8.f3311a
            a.wd2 r1 = (a.wd2) r1
            a.h42.b(r9)
            goto L69
        L2a:
            java.lang.Object r1 = r8.f3311a
            a.wd2 r1 = (a.wd2) r1
            a.h42.b(r9)
            goto L5c
        L32:
            a.h42.b(r9)
            a.wd2 r9 = r8.f7731a
            a.sn0 r1 = new a.sn0
            a.ww1 r6 = r8.f3310a
            a.xw1 r6 = r6.f7830a
            a.yw1 r6 = r6.f7925a
            a.bx1 r6 = r6.f8016a
            a.cl r6 = r6.j()
            a.f92.b(r6)
            java.lang.String r7 = "activity!!"
            a.f92.c(r6, r7)
            r1.<init>(r6)
            r8.f3311a = r9
            r8.b = r5
            java.lang.Object r1 = a.sn0.b(r1, r4, r8, r5, r4)
            if (r1 != r0) goto L5b
            return r0
        L5b:
            r1 = r9
        L5c:
            r5 = 1000(0x3e8, double:4.94E-321)
            r8.f3311a = r1
            r8.b = r3
            java.lang.Object r9 = a.ke2.a(r5, r8)
            if (r9 != r0) goto L69
            return r0
        L69:
            a.fg2 r9 = a.qe2.c()
            a.uw1 r3 = new a.uw1
            r3.<init>(r8, r4)
            r8.f3311a = r1
            r8.b = r2
            java.lang.Object r9 = a.oc2.g(r9, r3, r8)
            if (r9 != r0) goto L7d
            return r0
        L7d:
            a.m42 r9 = a.m42.f6769a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.vw1.j(java.lang.Object):java.lang.Object");
    }
}
