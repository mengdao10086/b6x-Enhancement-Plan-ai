package uk;

import kotlin.jvm.internal.f0;
import kotlin.v0;
import uk.d;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@k
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f52185a = a.f52186a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f52186a = new a();
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final b f52187b = new b();

        @v0(version = "1.7")
        @hk.f
        @k
        public static final class a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f52188a;

            public /* synthetic */ a(long j10) {
                this.f52188a = j10;
            }

            public static final /* synthetic */ a f(long j10) {
                return new a(j10);
            }

            public static final int g(long j10, long j11) {
                return e.j(p(j10, j11), e.f52169b.W());
            }

            public static int h(long j10, @yt.k d other) {
                f0.p(other, "other");
                return f(j10).compareTo(other);
            }

            public static long i(long j10) {
                return j10;
            }

            public static long j(long j10) {
                return o.f52182b.d(j10);
            }

            public static boolean k(long j10, Object obj) {
                return (obj instanceof a) && j10 == ((a) obj).w();
            }

            public static final boolean l(long j10, long j11) {
                return j10 == j11;
            }

            public static boolean m(long j10) {
                return e.e0(j(j10));
            }

            public static boolean n(long j10) {
                return !e.e0(j(j10));
            }

            public static int o(long j10) {
                return com.flydigi.data.bean.a.a(j10);
            }

            public static final long p(long j10, long j11) {
                return o.f52182b.c(j10, j11);
            }

            public static long r(long j10, long j11) {
                return o.f52182b.b(j10, e.x0(j11));
            }

            public static long s(long j10, @yt.k d other) {
                f0.p(other, "other");
                if (other instanceof a) {
                    return p(j10, ((a) other).w());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) v(j10)) + " and " + other);
            }

            public static long u(long j10, long j11) {
                return o.f52182b.b(j10, j11);
            }

            public static String v(long j10) {
                return "ValueTimeMark(reading=" + j10 + ')';
            }

            @Override // uk.d
            public long C(@yt.k d other) {
                f0.p(other, "other");
                return s(this.f52188a, other);
            }

            @Override // uk.d, uk.q
            public /* bridge */ /* synthetic */ d a(long j10) {
                return f(q(j10));
            }

            @Override // uk.d, uk.q
            public /* bridge */ /* synthetic */ d b(long j10) {
                return f(t(j10));
            }

            @Override // uk.q
            public boolean c() {
                return n(this.f52188a);
            }

            @Override // uk.q
            public long d() {
                return j(this.f52188a);
            }

            @Override // uk.q
            public boolean e() {
                return m(this.f52188a);
            }

            @Override // uk.d
            public boolean equals(Object obj) {
                return k(this.f52188a, obj);
            }

            @Override // uk.d
            public int hashCode() {
                return o(this.f52188a);
            }

            public long q(long j10) {
                return r(this.f52188a, j10);
            }

            public long t(long j10) {
                return u(this.f52188a, j10);
            }

            public String toString() {
                return v(this.f52188a);
            }

            public final /* synthetic */ long w() {
                return this.f52188a;
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int compareTo(@yt.k d dVar) {
                return d.a.a(this, dVar);
            }

            @Override // uk.q
            public /* bridge */ /* synthetic */ q a(long j10) {
                return f(q(j10));
            }

            @Override // uk.q
            public /* bridge */ /* synthetic */ q b(long j10) {
                return f(t(j10));
            }
        }

        @Override // uk.r.c, uk.r
        public /* bridge */ /* synthetic */ d a() {
            return a.f(b());
        }

        public long b() {
            return o.f52182b.e();
        }

        @yt.k
        public String toString() {
            return o.f52182b.toString();
        }

        @Override // uk.r
        public /* bridge */ /* synthetic */ q a() {
            return a.f(b());
        }
    }

    @v0(version = "1.8")
    @k
    public interface c extends r {
        @Override // uk.r
        @yt.k
        d a();
    }

    @yt.k
    q a();
}
