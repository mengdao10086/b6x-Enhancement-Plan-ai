package a;

import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ma0 implements ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f1908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hj0 f1909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qx0 f1910a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Long f1911a;

    public ma0(Context context) {
        f92.d(context, "context");
        qx0 qx0VarD = qx0.d();
        this.f1910a = qx0VarD;
        f92.c(qx0VarD, "storage");
        this.f6786a = qx0VarD.f();
        this.f1911a = this.f1910a.k();
        this.f1909a = new hj0(new la0(this), "Analyser-Charge");
    }

    public final void b() {
        this.f1909a.c();
    }

    public final void c() {
        this.f1911a = Long.valueOf(fa0.z(fa0.f867a, 0L, 1, null));
        if (fa0.f867a.c() != 2) {
            b();
        } else if (Math.abs(fa0.f867a.b()) > 100) {
            this.f1910a.a(this.f6786a, fa0.f867a.b(), fa0.f867a.p(), fa0.f867a.a(), fa0.f867a.o());
        }
    }

    public final void d() {
        this.f1909a.e(5000L, 1000L);
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        int i = ka0.f6588a[aa0Var.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    @Override // a.ha0
    public boolean isAsync() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // a.ha0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(a.aa0 r7, java.util.HashMap<java.lang.String, java.lang.Object> r8) {
        /*
            r6 = this;
            java.lang.String r8 = "eventType"
            a.f92.d(r7, r8)
            int[] r8 = a.ka0.b
            int r7 = r7.ordinal()
            r7 = r8[r7]
            r8 = 1
            if (r7 == r8) goto L30
            r8 = 2
            if (r7 == r8) goto L26
            r0 = 3
            if (r7 == r0) goto L26
            r0 = 4
            if (r7 == r0) goto L1a
            goto L84
        L1a:
            a.fa0 r7 = a.fa0.f867a
            int r7 = r7.c()
            if (r7 != r8) goto L84
            r6.d()
            goto L84
        L26:
            long r7 = java.lang.System.currentTimeMillis()
            r6.f1908a = r7
            r6.b()
            goto L84
        L30:
            a.qx0 r7 = r6.f1910a
            int r7 = r7.e()
            long r0 = java.lang.System.currentTimeMillis()
            a.fa0 r8 = a.fa0.f867a
            int r8 = r8.a()
            r2 = -1
            if (r8 == r2) goto L4b
            a.fa0 r8 = a.fa0.f867a
            int r8 = r8.a()
            if (r8 != r7) goto L7c
        L4b:
            java.lang.Long r7 = r6.f1911a
            r2 = 0
            if (r7 != 0) goto L52
            goto L5a
        L52:
            long r7 = r7.longValue()
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 == 0) goto L6f
        L5a:
            java.lang.Long r7 = r6.f1911a
            java.lang.String r8 = "lastUpdate"
            a.f92.c(r7, r8)
            long r7 = r7.longValue()
            long r7 = r0 - r7
            r4 = 60000(0xea60, float:8.4078E-41)
            long r4 = (long) r4
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 > 0) goto L7c
        L6f:
            long r7 = r6.f1908a
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L84
            long r0 = r0 - r7
            r7 = 5000(0x1388, double:2.4703E-320)
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 <= 0) goto L84
        L7c:
            a.qx0 r7 = r6.f1910a
            int r7 = r7.l()
            r6.f6786a = r7
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ma0.onReceive(a.aa0, java.util.HashMap):void");
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // a.ha0
    public void onUnsubscribe() {
    }
}
