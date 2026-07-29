package uk;

import kotlin.time.DurationUnit;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@k
public final class p extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f52184c;

    public p() {
        super(DurationUnit.NANOSECONDS);
    }

    @Override // uk.b
    public long c() {
        return this.f52184c;
    }

    public final void d(long j10) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f52184c + j.h(b()) + " is advanced by " + ((Object) e.u0(j10)) + '.');
    }

    public final void e(long j10) {
        long j11;
        long jR0 = e.r0(j10, b());
        if (jR0 == Long.MIN_VALUE || jR0 == Long.MAX_VALUE) {
            double dO0 = this.f52184c + e.o0(j10, b());
            if (dO0 > 9.223372036854776E18d || dO0 < -9.223372036854776E18d) {
                d(j10);
            }
            j11 = (long) dO0;
        } else {
            long j12 = this.f52184c;
            j11 = j12 + jR0;
            if ((jR0 ^ j12) >= 0 && (j12 ^ j11) < 0) {
                d(j10);
            }
        }
        this.f52184c = j11;
    }
}
