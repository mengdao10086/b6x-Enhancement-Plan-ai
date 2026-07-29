package qk;

import kotlin.c2;
import kotlin.p1;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@c2(markerClass = {kotlin.s.class})
@v0(version = "1.5")
public final class b0 extends z implements h<p1>, s<p1> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f47393e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final b0 f47394f = new b0(-1, 0, null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final b0 a() {
            return b0.f47394f;
        }
    }

    public b0(long j10, long j11) {
        super(j10, j11, 1L, null);
    }

    public /* synthetic */ b0(long j10, long j11, kotlin.jvm.internal.u uVar) {
        this(j10, j11);
    }

    @kotlin.k(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @v0(version = "1.7")
    @kotlin.q
    public static /* synthetic */ void q() {
    }

    @Override // qk.h
    public /* bridge */ /* synthetic */ Comparable a() {
        return p1.d(s());
    }

    @Override // qk.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return o(((p1) comparable).l0());
    }

    @Override // qk.s
    public /* bridge */ /* synthetic */ Comparable d() {
        return p1.d(p());
    }

    @Override // qk.h
    public /* bridge */ /* synthetic */ Comparable e() {
        return p1.d(r());
    }

    @Override // qk.z
    public boolean equals(@yt.l Object obj) {
        if (obj instanceof b0) {
            if (!isEmpty() || !((b0) obj).isEmpty()) {
                b0 b0Var = (b0) obj;
                if (g() != b0Var.g() || j() != b0Var.j()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // qk.z
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) p1.j(j() ^ p1.j(j() >>> 32))) + (((int) p1.j(g() ^ p1.j(g() >>> 32))) * 31);
    }

    @Override // qk.z, qk.h
    public boolean isEmpty() {
        return Long.compare(g() ^ Long.MIN_VALUE, j() ^ Long.MIN_VALUE) > 0;
    }

    public boolean o(long j10) {
        return Long.compare(g() ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE) <= 0 && Long.compare(j10 ^ Long.MIN_VALUE, j() ^ Long.MIN_VALUE) <= 0;
    }

    public long p() {
        if (j() != -1) {
            return p1.j(j() + p1.j(((long) 1) & 4294967295L));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    public long r() {
        return j();
    }

    public long s() {
        return g();
    }

    @Override // qk.z
    @yt.k
    public String toString() {
        return ((Object) p1.g0(g())) + ".." + ((Object) p1.g0(j()));
    }
}
