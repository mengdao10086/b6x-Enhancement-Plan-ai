package uk;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.time.DurationUnit;
import kotlin.v0;
import uk.d;
import uk.e;
import uk.r;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@k
public abstract class b implements r.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final DurationUnit f52163b;

    @t0({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,180:1\n720#2,2:181\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n66#1:181,2\n*E\n"})
    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f52164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final b f52165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f52166c;

        public a(long j10, b timeSource, long j11) {
            f0.p(timeSource, "timeSource");
            this.f52164a = j10;
            this.f52165b = timeSource;
            this.f52166c = j11;
        }

        public /* synthetic */ a(long j10, b bVar, long j11, u uVar) {
            this(j10, bVar, j11);
        }

        @Override // uk.d
        public long C(@yt.k d other) {
            f0.p(other, "other");
            if (other instanceof a) {
                a aVar = (a) other;
                if (f0.g(this.f52165b, aVar.f52165b)) {
                    if (e.p(this.f52166c, aVar.f52166c) && e.d0(this.f52166c)) {
                        return e.f52169b.W();
                    }
                    long jG0 = e.g0(this.f52166c, aVar.f52166c);
                    long jN0 = g.n0(this.f52164a - aVar.f52164a, this.f52165b.b());
                    return e.p(jN0, e.x0(jG0)) ? e.f52169b.W() : e.h0(jN0, jG0);
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // uk.q
        @yt.k
        public d a(long j10) {
            return d.a.d(this, j10);
        }

        @Override // uk.q
        public boolean c() {
            return d.a.c(this);
        }

        @Override // uk.q
        public long d() {
            return e.d0(this.f52166c) ? e.x0(this.f52166c) : e.g0(g.n0(this.f52165b.c() - this.f52164a, this.f52165b.b()), this.f52166c);
        }

        @Override // uk.q
        public boolean e() {
            return d.a.b(this);
        }

        @Override // uk.d
        public boolean equals(@yt.l Object obj) {
            return (obj instanceof a) && f0.g(this.f52165b, ((a) obj).f52165b) && e.p(C((d) obj), e.f52169b.W());
        }

        public final long f() {
            if (e.d0(this.f52166c)) {
                return this.f52166c;
            }
            DurationUnit durationUnitB = this.f52165b.b();
            DurationUnit durationUnit = DurationUnit.MILLISECONDS;
            if (durationUnitB.compareTo(durationUnit) >= 0) {
                return e.h0(g.n0(this.f52164a, durationUnitB), this.f52166c);
            }
            long jB = i.b(1L, durationUnit, durationUnitB);
            long j10 = this.f52164a;
            long j11 = j10 / jB;
            long j12 = j10 % jB;
            long j13 = this.f52166c;
            long jP = e.P(j13);
            int iT = e.T(j13);
            int i10 = iT / 1000000;
            long jN0 = g.n0(j12, durationUnitB);
            e.a aVar = e.f52169b;
            return e.h0(e.h0(e.h0(jN0, g.m0(iT % 1000000, DurationUnit.NANOSECONDS)), g.n0(j11 + ((long) i10), durationUnit)), g.n0(jP, DurationUnit.SECONDS));
        }

        @Override // uk.d
        public int hashCode() {
            return e.Z(f());
        }

        @yt.k
        public String toString() {
            return "LongTimeMark(" + this.f52164a + j.h(this.f52165b.b()) + " + " + ((Object) e.u0(this.f52166c)) + " (=" + ((Object) e.u0(f())) + "), " + this.f52165b + ')';
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: z */
        public int compareTo(@yt.k d dVar) {
            return d.a.a(this, dVar);
        }

        @Override // uk.q
        @yt.k
        public d b(long j10) {
            return new a(this.f52164a, this.f52165b, e.h0(this.f52166c, j10), null);
        }
    }

    public b(@yt.k DurationUnit unit) {
        f0.p(unit, "unit");
        this.f52163b = unit;
    }

    @yt.k
    public final DurationUnit b() {
        return this.f52163b;
    }

    public abstract long c();

    @Override // uk.r
    @yt.k
    public d a() {
        return new a(c(), this, e.f52169b.W(), null);
    }
}
