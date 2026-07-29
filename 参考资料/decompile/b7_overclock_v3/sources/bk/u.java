package bk;

import kotlin.l1;
import kotlin.p1;
import kotlin.s0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public final class u {
    public static final int a(int i10, int i11, int i12) {
        int iA = r.a(i10, i12);
        int iA2 = r.a(i11, i12);
        int iCompare = Integer.compare(iA ^ Integer.MIN_VALUE, iA2 ^ Integer.MIN_VALUE);
        int iJ = l1.j(iA - iA2);
        return iCompare >= 0 ? iJ : l1.j(iJ + i12);
    }

    public static final long b(long j10, long j11, long j12) {
        long jA = t.a(j10, j12);
        long jA2 = t.a(j11, j12);
        int iCompare = Long.compare(jA ^ Long.MIN_VALUE, jA2 ^ Long.MIN_VALUE);
        long j13 = p1.j(jA - jA2);
        return iCompare >= 0 ? j13 : p1.j(j13 + j12);
    }

    @v0(version = "1.3")
    @s0
    public static final long c(long j10, long j11, long j12) {
        if (j12 > 0) {
            return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) >= 0 ? j11 : p1.j(j11 - b(j11, j10, p1.j(j12)));
        }
        if (j12 < 0) {
            return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) <= 0 ? j11 : p1.j(j11 + b(j10, j11, p1.j(-j12)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @v0(version = "1.3")
    @s0
    public static final int d(int i10, int i11, int i12) {
        if (i12 > 0) {
            return Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) >= 0 ? i11 : l1.j(i11 - a(i11, i10, l1.j(i12)));
        }
        if (i12 < 0) {
            return Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) <= 0 ? i11 : l1.j(i11 + a(i10, i11, l1.j(-i12)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
