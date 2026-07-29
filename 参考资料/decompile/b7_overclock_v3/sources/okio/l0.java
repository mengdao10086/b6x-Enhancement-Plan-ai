package okio;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lokio/l0;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "Lokio/l;", "a", "Lokio/l;", "upstream", "b", "Lokio/j;", "buffer", "Lokio/p0;", "c", "Lokio/p0;", "expectedSegment", "", "d", "I", "expectedPos", "", "e", "Z", "closed", "f", "J", "pos", "<init>", "(Lokio/l;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class l0 implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final l f44132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final j f44133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public p0 f44134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f44135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f44136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f44137f;

    public l0(@yt.k l upstream) {
        kotlin.jvm.internal.f0.p(upstream, "upstream");
        this.f44132a = upstream;
        j jVarG = upstream.g();
        this.f44133b = jVarG;
        p0 p0Var = jVarG.f44116a;
        this.f44134c = p0Var;
        this.f44135d = p0Var == null ? -1 : p0Var.f44175b;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    @Override // okio.t0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long F1(@yt.k okio.j r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.f0.p(r9, r0)
            r0 = 0
            r1 = 0
            r3 = 1
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 < 0) goto Lf
            r5 = 1
            goto L10
        Lf:
            r5 = 0
        L10:
            if (r5 == 0) goto L87
            boolean r5 = r8.f44136e
            r5 = r5 ^ r3
            if (r5 == 0) goto L7b
            okio.p0 r5 = r8.f44134c
            if (r5 == 0) goto L2a
            okio.j r6 = r8.f44133b
            okio.p0 r6 = r6.f44116a
            if (r5 != r6) goto L2b
            int r5 = r8.f44135d
            kotlin.jvm.internal.f0.m(r6)
            int r6 = r6.f44175b
            if (r5 != r6) goto L2b
        L2a:
            r0 = 1
        L2b:
            if (r0 == 0) goto L6f
            if (r4 != 0) goto L30
            return r1
        L30:
            okio.l r0 = r8.f44132a
            long r1 = r8.f44137f
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L40
            r9 = -1
            return r9
        L40:
            okio.p0 r0 = r8.f44134c
            if (r0 != 0) goto L53
            okio.j r0 = r8.f44133b
            okio.p0 r0 = r0.f44116a
            if (r0 == 0) goto L53
            r8.f44134c = r0
            kotlin.jvm.internal.f0.m(r0)
            int r0 = r0.f44175b
            r8.f44135d = r0
        L53:
            okio.j r0 = r8.f44133b
            long r0 = r0.m2()
            long r2 = r8.f44137f
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.j r2 = r8.f44133b
            long r4 = r8.f44137f
            r3 = r9
            r6 = r10
            r2.u(r3, r4, r6)
            long r0 = r8.f44137f
            long r0 = r0 + r10
            r8.f44137f = r0
            return r10
        L6f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L7b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L87:
            java.lang.Long r9 = java.lang.Long.valueOf(r10)
            java.lang.String r10 = "byteCount < 0: "
            java.lang.String r9 = kotlin.jvm.internal.f0.C(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.l0.F1(okio.j, long):long");
    }

    @Override // okio.t0
    @yt.k
    public v0 U() {
        return this.f44132a.U();
    }

    @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f44136e = true;
    }
}
