package qk;

import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public final class p extends n implements h<Long>, s<Long> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f47423e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final p f47424f = new p(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final p a() {
            return p.f47424f;
        }
    }

    public p(long j10, long j11) {
        super(j10, j11, 1L);
    }

    @kotlin.k(message = "Can throw an exception when it's impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @v0(version = "1.7")
    @kotlin.q
    public static /* synthetic */ void r() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qk.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return p(((Number) comparable).longValue());
    }

    @Override // qk.n
    public boolean equals(@yt.l Object obj) {
        if (obj instanceof p) {
            if (!isEmpty() || !((p) obj).isEmpty()) {
                p pVar = (p) obj;
                if (g() != pVar.g() || j() != pVar.j()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // qk.n
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (g() ^ (g() >>> 32))) + (j() ^ (j() >>> 32)));
    }

    @Override // qk.n, qk.h
    public boolean isEmpty() {
        return g() > j();
    }

    public boolean p(long j10) {
        return g() <= j10 && j10 <= j();
    }

    @Override // qk.s
    @yt.k
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Long d() {
        if (j() != Long.MAX_VALUE) {
            return Long.valueOf(j() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Long e() {
        return Long.valueOf(j());
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Long a() {
        return Long.valueOf(g());
    }

    @Override // qk.n
    @yt.k
    public String toString() {
        return g() + ".." + j();
    }
}
