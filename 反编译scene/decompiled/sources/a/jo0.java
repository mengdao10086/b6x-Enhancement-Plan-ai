package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.SceneServer$areaSelfTest$1", f = "SceneServer.kt", l = {62}, m = "invokeSuspend")
public final class jo0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ no0 f6530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1567a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1568b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Object f1569c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public Object f1570d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo0(no0 no0Var, b62 b62Var) {
        super(2, b62Var);
        this.f6530a = no0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        jo0 jo0Var = new jo0(this.f6530a, b62Var);
        jo0Var.f1566a = (wd2) obj;
        return jo0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((jo0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x007c -> B:14:0x0086). Please report as a decompilation issue!!! */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = a.r62.c()
            int r1 = r11.d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L37
            if (r1 != r3) goto L2f
            int r1 = r11.c
            java.lang.Object r2 = r11.e
            java.lang.String[] r2 = (java.lang.String[]) r2
            java.lang.Object r4 = r11.f1570d
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r11.b
            java.lang.Object r5 = r11.f1569c
            java.lang.String[] r5 = (java.lang.String[]) r5
            java.lang.Object r6 = r11.f1568b
            java.lang.String[] r6 = (java.lang.String[]) r6
            java.lang.Object r7 = r11.f1567a
            a.wd2 r7 = (a.wd2) r7
            a.h42.b(r12)
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r2
            r2 = r1
            r1 = r0
            r0 = r11
            goto L86
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L37:
            a.h42.b(r12)
            a.wd2 r12 = r11.f1566a
            r1 = 3
            java.lang.String[] r4 = new java.lang.String[r1]
            java.lang.String r5 = a.no0.x()
            r4[r2] = r5
            java.lang.String r5 = a.no0.y()
            r4[r3] = r5
            r5 = 2
            java.lang.String r6 = a.no0.z()
            r4[r5] = r6
            java.lang.String r5 = "cn"
            java.lang.String r6 = "cn2"
            java.lang.String r7 = "gb"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7}
            r7 = r12
            r6 = r4
            r12 = r11
        L5f:
            if (r2 >= r1) goto La4
            r8 = r4[r2]
            a.no0 r9 = r12.f6530a
            r12.f1567a = r7
            r12.f1568b = r6
            r12.f1569c = r5
            r12.b = r2
            r12.f1570d = r8
            r12.e = r4
            r12.c = r1
            r12.d = r3
            java.lang.Object r8 = r9.C(r8, r12)
            if (r8 != r0) goto L7c
            return r0
        L7c:
            r10 = r0
            r0 = r12
            r12 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r2
            r2 = r1
            r1 = r10
        L86:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L98
            com.omarea.Scene$c r12 = com.omarea.Scene.f4798a
            r0 = r6[r4]
            java.lang.String r1 = "area"
            r12.m(r1, r0)
            goto La4
        L98:
            int r12 = r4 + 1
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r10 = r2
            r2 = r12
            r12 = r0
            r0 = r1
            r1 = r10
            goto L5f
        La4:
            a.m42 r12 = a.m42.f6769a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: a.jo0.j(java.lang.Object):java.lang.Object");
    }
}
