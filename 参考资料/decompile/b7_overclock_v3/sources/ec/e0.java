package ec;

import android.net.Uri;
import g.p0;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends x1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f26822n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v0 f26823o = new v0.c().z("SinglePeriodTimeline").F(Uri.EMPTY).a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f26824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f26825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f26826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f26827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f26828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f26829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f26830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f26831i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f26832j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final Object f26833k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public final v0 f26834l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public final v0.f f26835m;

    @Deprecated
    public e0(long j10, boolean z10, boolean z11, boolean z12, @p0 Object obj, @p0 Object obj2) {
        this(j10, j10, 0L, 0L, z10, z11, z12, obj, obj2);
    }

    @Override // ya.x1
    public int b(Object obj) {
        return f26822n.equals(obj) ? 0 : -1;
    }

    @Override // ya.x1
    public x1.b g(int i10, x1.b bVar, boolean z10) {
        hd.a.c(i10, 0, 1);
        return bVar.p(null, z10 ? f26822n : null, 0, this.f26827e, -this.f26829g);
    }

    @Override // ya.x1
    public int i() {
        return 1;
    }

    @Override // ya.x1
    public Object m(int i10) {
        hd.a.c(i10, 0, 1);
        return f26822n;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[PHI: r1
  0x002a: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x0012, B:5:0x0018, B:10:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // ya.x1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ya.x1.c o(int r25, ya.x1.c r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            hd.a.c(r3, r1, r2)
            long r1 = r0.f26830h
            boolean r14 = r0.f26832j
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r14 == 0) goto L2a
            r5 = 0
            int r7 = (r27 > r5 ? 1 : (r27 == r5 ? 0 : -1))
            if (r7 == 0) goto L2a
            long r5 = r0.f26828f
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L23
        L20:
            r16 = r3
            goto L2c
        L23:
            long r1 = r1 + r27
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L2a
            goto L20
        L2a:
            r16 = r1
        L2c:
            java.lang.Object r4 = ya.x1.c.f57238r
            ya.v0 r5 = r0.f26834l
            java.lang.Object r6 = r0.f26833k
            long r7 = r0.f26824b
            long r9 = r0.f26825c
            long r11 = r0.f26826d
            boolean r13 = r0.f26831i
            ya.v0$f r15 = r0.f26835m
            long r1 = r0.f26828f
            r18 = r1
            r20 = 0
            r21 = 0
            long r1 = r0.f26829g
            r22 = r1
            r3 = r26
            ya.x1$c r1 = r3.i(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ec.e0.o(int, ya.x1$c, long):ya.x1$c");
    }

    @Override // ya.x1
    public int q() {
        return 1;
    }

    public e0(long j10, boolean z10, boolean z11, boolean z12, @p0 Object obj, v0 v0Var) {
        this(j10, j10, 0L, 0L, z10, z11, z12, obj, v0Var);
    }

    @Deprecated
    public e0(long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, @p0 Object obj, @p0 Object obj2) {
        this(ya.g.f56663b, ya.g.f56663b, ya.g.f56663b, j10, j11, j12, j13, z10, z11, z12, obj, obj2);
    }

    public e0(long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, @p0 Object obj, v0 v0Var) {
        this(ya.g.f56663b, ya.g.f56663b, ya.g.f56663b, j10, j11, j12, j13, z10, z11, obj, v0Var, z12 ? v0Var.f57133c : null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    public e0(long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z10, boolean z11, boolean z12, @p0 Object obj, @p0 Object obj2) {
        v0 v0Var = f26823o;
        this(j10, j11, j12, j13, j14, j15, j16, z10, z11, obj, v0Var.a().E(obj2).a(), z12 ? v0Var.f57133c : null);
    }

    public e0(long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z10, boolean z11, @p0 Object obj, v0 v0Var, @p0 v0.f fVar) {
        this.f26824b = j10;
        this.f26825c = j11;
        this.f26826d = j12;
        this.f26827e = j13;
        this.f26828f = j14;
        this.f26829g = j15;
        this.f26830h = j16;
        this.f26831i = z10;
        this.f26832j = z11;
        this.f26833k = obj;
        this.f26834l = (v0) hd.a.g(v0Var);
        this.f26835m = fVar;
    }
}
