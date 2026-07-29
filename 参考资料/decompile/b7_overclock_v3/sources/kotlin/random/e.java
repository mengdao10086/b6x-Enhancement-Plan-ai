package kotlin.random;

import kotlin.c2;
import kotlin.i1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.l1;
import kotlin.p1;
import kotlin.s;
import kotlin.v0;
import qk.b0;
import qk.y;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
public final class e {
    public static final void a(int i10, int i11) {
        if (!(Integer.compare(i11 ^ Integer.MIN_VALUE, i10 ^ Integer.MIN_VALUE) > 0)) {
            throw new IllegalArgumentException(d.c(l1.d(i10), l1.d(i11)).toString());
        }
    }

    public static final void b(long j10, long j11) {
        if (!(Long.compare(j11 ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE) > 0)) {
            throw new IllegalArgumentException(d.c(p1.d(j10), p1.d(j11)).toString());
        }
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] c(@k Random random, int i10) {
        f0.p(random, "<this>");
        return i1.e(random.d(i10));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] d(@k Random nextUBytes, @k byte[] array) {
        f0.p(nextUBytes, "$this$nextUBytes");
        f0.p(array, "array");
        nextUBytes.f(array);
        return array;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] e(@k Random nextUBytes, @k byte[] array, int i10, int i11) {
        f0.p(nextUBytes, "$this$nextUBytes");
        f0.p(array, "array");
        nextUBytes.h(array, i10, i11);
        return array;
    }

    public static /* synthetic */ byte[] f(Random random, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = i1.r(bArr);
        }
        return e(random, bArr, i10, i11);
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int g(@k Random random) {
        f0.p(random, "<this>");
        return l1.j(random.o());
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int h(@k Random random, @k y range) {
        f0.p(random, "<this>");
        f0.p(range, "range");
        if (!range.isEmpty()) {
            return Integer.compare(range.j() ^ Integer.MIN_VALUE, (-1) ^ Integer.MIN_VALUE) < 0 ? i(random, range.g(), l1.j(range.j() + 1)) : Integer.compare(range.g() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) > 0 ? l1.j(i(random, l1.j(range.g() - 1), range.j()) + 1) : g(random);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int i(@k Random nextUInt, int i10, int i11) {
        f0.p(nextUInt, "$this$nextUInt");
        a(i10, i11);
        return l1.j(nextUInt.q(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int j(@k Random nextUInt, int i10) {
        f0.p(nextUInt, "$this$nextUInt");
        return i(nextUInt, 0, i10);
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final long k(@k Random random) {
        f0.p(random, "<this>");
        return p1.j(random.r());
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final long l(@k Random random, @k b0 range) {
        f0.p(random, "<this>");
        f0.p(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (Long.compare(range.j() ^ Long.MIN_VALUE, (-1) ^ Long.MIN_VALUE) < 0) {
            return n(random, range.g(), p1.j(range.j() + p1.j(((long) 1) & 4294967295L)));
        }
        if (Long.compare(range.g() ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE) <= 0) {
            return k(random);
        }
        long j10 = ((long) 1) & 4294967295L;
        return p1.j(n(random, p1.j(range.g() - p1.j(j10)), range.j()) + p1.j(j10));
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final long m(@k Random nextULong, long j10) {
        f0.p(nextULong, "$this$nextULong");
        return n(nextULong, 0L, j10);
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final long n(@k Random nextULong, long j10, long j11) {
        f0.p(nextULong, "$this$nextULong");
        b(j10, j11);
        return p1.j(nextULong.u(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
