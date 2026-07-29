package qk;

import kotlin.collections.l0;

/* JADX INFO: loaded from: classes5.dex */
public class n implements Iterable<Long>, jk.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f47415d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f47416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f47417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f47418c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final n a(long j10, long j11, long j12) {
            return new n(j10, j11, j12);
        }
    }

    public n(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f47416a = j10;
        this.f47417b = bk.n.d(j10, j11, j12);
        this.f47418c = j12;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof n) {
            if (!isEmpty() || !((n) obj).isEmpty()) {
                n nVar = (n) obj;
                if (this.f47416a != nVar.f47416a || this.f47417b != nVar.f47417b || this.f47418c != nVar.f47418c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long g() {
        return this.f47416a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j10 = 31;
        long j11 = this.f47416a;
        long j12 = this.f47417b;
        long j13 = j10 * (((j11 ^ (j11 >>> 32)) * j10) + (j12 ^ (j12 >>> 32)));
        long j14 = this.f47418c;
        return (int) (j13 + (j14 ^ (j14 >>> 32)));
    }

    public boolean isEmpty() {
        long j10 = this.f47418c;
        long j11 = this.f47416a;
        long j12 = this.f47417b;
        if (j10 > 0) {
            if (j11 > j12) {
                return true;
            }
        } else if (j11 < j12) {
            return true;
        }
        return false;
    }

    public final long j() {
        return this.f47417b;
    }

    public final long l() {
        return this.f47418c;
    }

    @Override // java.lang.Iterable
    @yt.k
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public l0 iterator() {
        return new o(this.f47416a, this.f47417b, this.f47418c);
    }

    @yt.k
    public String toString() {
        StringBuilder sb2;
        long j10;
        if (this.f47418c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f47416a);
            sb2.append("..");
            sb2.append(this.f47417b);
            sb2.append(" step ");
            j10 = this.f47418c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f47416a);
            sb2.append(" downTo ");
            sb2.append(this.f47417b);
            sb2.append(" step ");
            j10 = -this.f47418c;
        }
        sb2.append(j10);
        return sb2.toString();
    }
}
