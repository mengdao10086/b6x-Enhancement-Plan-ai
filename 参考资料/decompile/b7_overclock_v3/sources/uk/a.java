package uk;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.time.DurationUnit;
import kotlin.v0;
import uk.d;
import uk.r;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.k(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@v0(version = "1.3")
@k
public abstract class a implements r.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final DurationUnit f52159b;

    /* JADX INFO: renamed from: uk.a$a, reason: collision with other inner class name */
    public static final class C0603a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f52160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final a f52161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f52162c;

        public C0603a(double d10, a timeSource, long j10) {
            f0.p(timeSource, "timeSource");
            this.f52160a = d10;
            this.f52161b = timeSource;
            this.f52162c = j10;
        }

        public /* synthetic */ C0603a(double d10, a aVar, long j10, u uVar) {
            this(d10, aVar, j10);
        }

        @Override // uk.d
        public long C(@yt.k d other) {
            f0.p(other, "other");
            if (other instanceof C0603a) {
                C0603a c0603a = (C0603a) other;
                if (f0.g(this.f52161b, c0603a.f52161b)) {
                    if (e.p(this.f52162c, c0603a.f52162c) && e.d0(this.f52162c)) {
                        return e.f52169b.W();
                    }
                    long jG0 = e.g0(this.f52162c, c0603a.f52162c);
                    long jL0 = g.l0(this.f52160a - c0603a.f52160a, this.f52161b.b());
                    return e.p(jL0, e.x0(jG0)) ? e.f52169b.W() : e.h0(jL0, jG0);
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
            return e.g0(g.l0(this.f52161b.c() - this.f52160a, this.f52161b.b()), this.f52162c);
        }

        @Override // uk.q
        public boolean e() {
            return d.a.b(this);
        }

        @Override // uk.d
        public boolean equals(@yt.l Object obj) {
            return (obj instanceof C0603a) && f0.g(this.f52161b, ((C0603a) obj).f52161b) && e.p(C((d) obj), e.f52169b.W());
        }

        @Override // uk.d
        public int hashCode() {
            return e.Z(e.h0(g.l0(this.f52160a, this.f52161b.b()), this.f52162c));
        }

        @yt.k
        public String toString() {
            return "DoubleTimeMark(" + this.f52160a + j.h(this.f52161b.b()) + " + " + ((Object) e.u0(this.f52162c)) + ", " + this.f52161b + ')';
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: z */
        public int compareTo(@yt.k d dVar) {
            return d.a.a(this, dVar);
        }

        @Override // uk.q
        @yt.k
        public d b(long j10) {
            return new C0603a(this.f52160a, this.f52161b, e.h0(this.f52162c, j10), null);
        }
    }

    public a(@yt.k DurationUnit unit) {
        f0.p(unit, "unit");
        this.f52159b = unit;
    }

    @yt.k
    public final DurationUnit b() {
        return this.f52159b;
    }

    public abstract double c();

    @Override // uk.r
    @yt.k
    public d a() {
        return new C0603a(c(), this, e.f52169b.W(), null);
    }
}
