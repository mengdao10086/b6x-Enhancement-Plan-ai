package qk;

import java.util.Iterator;
import kotlin.c2;
import kotlin.p1;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@c2(markerClass = {kotlin.s.class})
@v0(version = "1.5")
public class z implements Iterable<p1>, jk.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f47439d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f47440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f47441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f47442c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final z a(long j10, long j11, long j12) {
            return new z(j10, j11, j12, null);
        }
    }

    public z(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f47440a = j10;
        this.f47441b = bk.u.c(j10, j11, j12);
        this.f47442c = j12;
    }

    public /* synthetic */ z(long j10, long j11, long j12, kotlin.jvm.internal.u uVar) {
        this(j10, j11, j12);
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof z) {
            if (!isEmpty() || !((z) obj).isEmpty()) {
                z zVar = (z) obj;
                if (this.f47440a != zVar.f47440a || this.f47441b != zVar.f47441b || this.f47442c != zVar.f47442c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long g() {
        return this.f47440a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j10 = this.f47440a;
        int iJ = ((int) p1.j(j10 ^ p1.j(j10 >>> 32))) * 31;
        long j11 = this.f47441b;
        int iJ2 = (iJ + ((int) p1.j(j11 ^ p1.j(j11 >>> 32)))) * 31;
        long j12 = this.f47442c;
        return ((int) (j12 ^ (j12 >>> 32))) + iJ2;
    }

    public boolean isEmpty() {
        long j10 = this.f47442c;
        long j11 = this.f47440a;
        long j12 = this.f47441b;
        if (j10 > 0) {
            if (Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) > 0) {
                return true;
            }
        } else if (Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @yt.k
    public final Iterator<p1> iterator() {
        return new a0(this.f47440a, this.f47441b, this.f47442c, null);
    }

    public final long j() {
        return this.f47441b;
    }

    public final long l() {
        return this.f47442c;
    }

    @yt.k
    public String toString() {
        StringBuilder sb2;
        long j10;
        if (this.f47442c > 0) {
            sb2 = new StringBuilder();
            sb2.append((Object) p1.g0(this.f47440a));
            sb2.append("..");
            sb2.append((Object) p1.g0(this.f47441b));
            sb2.append(" step ");
            j10 = this.f47442c;
        } else {
            sb2 = new StringBuilder();
            sb2.append((Object) p1.g0(this.f47440a));
            sb2.append(" downTo ");
            sb2.append((Object) p1.g0(this.f47441b));
            sb2.append(" step ");
            j10 = -this.f47442c;
        }
        sb2.append(j10);
        return sb2.toString();
    }
}
