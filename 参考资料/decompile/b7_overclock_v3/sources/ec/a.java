package ec;

import g.p0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hb.q f26811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public hb.k f26812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public hb.l f26813c;

    public a(hb.q qVar) {
        this.f26811a = qVar;
    }

    @Override // ec.y
    public void b(long j10, long j11) {
        ((hb.k) hd.a.g(this.f26812b)).b(j10, j11);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    @Override // ec.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(ed.h r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, hb.m r15) throws java.io.IOException {
        /*
            r7 = this;
            hb.g r6 = new hb.g
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f26813c = r6
            hb.k r8 = r7.f26812b
            if (r8 == 0) goto L10
            return
        L10:
            hb.q r8 = r7.f26811a
            hb.k[] r8 = r8.b(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L20
            r8 = r8[r13]
            r7.f26812b = r8
            goto L75
        L20:
            int r10 = r8.length
            r0 = 0
        L22:
            if (r0 >= r10) goto L71
            r1 = r8[r0]
            boolean r2 = r1.i(r6)     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            if (r2 == 0) goto L35
            r7.f26812b = r1     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            hd.a.i(r14)
            r6.n()
            goto L71
        L35:
            hb.k r1 = r7.f26812b
            if (r1 != 0) goto L67
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L65
            goto L67
        L42:
            r8 = move-exception
            hb.k r9 = r7.f26812b
            if (r9 != 0) goto L4f
            long r9 = r6.getPosition()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L50
        L4f:
            r13 = 1
        L50:
            hd.a.i(r13)
            r6.n()
            throw r8
        L57:
            hb.k r1 = r7.f26812b
            if (r1 != 0) goto L67
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L65
            goto L67
        L65:
            r1 = 0
            goto L68
        L67:
            r1 = 1
        L68:
            hd.a.i(r1)
            r6.n()
            int r0 = r0 + 1
            goto L22
        L71:
            hb.k r10 = r7.f26812b
            if (r10 == 0) goto L7b
        L75:
            hb.k r8 = r7.f26812b
            r8.c(r15)
            return
        L7b:
            com.google.android.exoplayer2.source.UnrecognizedInputFormatException r10 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            java.lang.String r8 = hd.u0.T(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = hd.a.g(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ec.a.c(ed.h, android.net.Uri, java.util.Map, long, long, hb.m):void");
    }

    @Override // ec.y
    public long d() {
        hb.l lVar = this.f26813c;
        if (lVar != null) {
            return lVar.getPosition();
        }
        return -1L;
    }

    @Override // ec.y
    public void e() {
        hb.k kVar = this.f26812b;
        if (kVar instanceof nb.f) {
            ((nb.f) kVar).j();
        }
    }

    @Override // ec.y
    public int f(hb.z zVar) throws IOException {
        return ((hb.k) hd.a.g(this.f26812b)).f((hb.l) hd.a.g(this.f26813c), zVar);
    }

    @Override // ec.y
    public void release() {
        hb.k kVar = this.f26812b;
        if (kVar != null) {
            kVar.release();
            this.f26812b = null;
        }
        this.f26813c = null;
    }
}
