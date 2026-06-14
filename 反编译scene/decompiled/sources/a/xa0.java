package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.data.publisher.ScreenState$onReceive$1", f = "ScreenState.kt", l = {50}, m = "invokeSuspend")
public final class xa0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ya0 f3562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3563a;
    public int b;
    public int c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xa0(ya0 ya0Var, long j, b62 b62Var) {
        super(2, b62Var);
        this.f3562a = ya0Var;
        this.f7869a = j;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xa0 xa0Var = new xa0(this.f3562a, this.f7869a, b62Var);
        xa0Var.f3561a = (wd2) obj;
        return xa0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((xa0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0051 -> B:18:0x0054). Please report as a decompilation issue!!! */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = a.r62.c()
            int r1 = r10.d
            r2 = 1
            if (r1 == 0) goto L20
            if (r1 != r2) goto L18
            int r1 = r10.c
            int r3 = r10.b
            java.lang.Object r4 = r10.f3563a
            a.wd2 r4 = (a.wd2) r4
            a.h42.b(r11)
            r11 = r10
            goto L54
        L18:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L20:
            a.h42.b(r11)
            a.wd2 r11 = r10.f3561a
            r1 = 0
            r3 = 5
            r4 = r11
            r11 = r10
            r9 = r3
            r3 = r1
            r1 = r9
        L2c:
            if (r3 >= r1) goto L56
            long r5 = r11.f7869a
            a.ya0 r7 = r11.f3562a
            long r7 = a.ya0.a(r7)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L56
            a.ya0 r5 = r11.f3562a
            boolean r5 = a.ya0.b(r5)
            if (r5 == 0) goto L43
            goto L56
        L43:
            r5 = 1000(0x3e8, double:4.94E-321)
            r11.f3563a = r4
            r11.b = r3
            r11.c = r1
            r11.d = r2
            java.lang.Object r5 = a.ke2.a(r5, r11)
            if (r5 != r0) goto L54
            return r0
        L54:
            int r3 = r3 + r2
            goto L2c
        L56:
            a.m42 r11 = a.m42.f6769a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a.xa0.j(java.lang.Object):java.lang.Object");
    }
}
