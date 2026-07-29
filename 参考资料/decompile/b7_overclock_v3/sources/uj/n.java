package uj;

import kotlin.c2;
import kotlin.i1;
import kotlin.jvm.internal.f0;
import kotlin.m1;
import kotlin.q1;
import kotlin.s;
import kotlin.v0;
import kotlin.v1;
import kotlin.w1;

/* JADX INFO: loaded from: classes5.dex */
public class n {
    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final short a(short s10, short s11) {
        return f0.t(s10 & v1.f38215d, 65535 & s11) >= 0 ? s10 : s11;
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int b(int i10, int i11) {
        return Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) >= 0 ? i10 : i11;
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final byte c(byte b10, byte b11) {
        return f0.t(b10 & 255, b11 & 255) >= 0 ? b10 : b11;
    }

    @s
    @v0(version = "1.4")
    public static final int d(int i10, @yt.k int... other) {
        f0.p(other, "other");
        int iR = m1.r(other);
        for (int i11 = 0; i11 < iR; i11++) {
            i10 = b(i10, m1.p(other, i11));
        }
        return i10;
    }

    @s
    @v0(version = "1.4")
    public static final long e(long j10, @yt.k long... other) {
        f0.p(other, "other");
        int iR = q1.r(other);
        for (int i10 = 0; i10 < iR; i10++) {
            j10 = j(j10, q1.p(other, i10));
        }
        return j10;
    }

    @c2(markerClass = {s.class})
    @bk.f
    @v0(version = "1.5")
    public static final short f(short s10, short s11, short s12) {
        return a(s10, a(s11, s12));
    }

    @c2(markerClass = {s.class})
    @bk.f
    @v0(version = "1.5")
    public static final int g(int i10, int i11, int i12) {
        return b(i10, b(i11, i12));
    }

    @s
    @v0(version = "1.4")
    public static final byte h(byte b10, @yt.k byte... other) {
        f0.p(other, "other");
        int iR = i1.r(other);
        for (int i10 = 0; i10 < iR; i10++) {
            b10 = c(b10, i1.p(other, i10));
        }
        return b10;
    }

    @c2(markerClass = {s.class})
    @bk.f
    @v0(version = "1.5")
    public static final byte i(byte b10, byte b11, byte b12) {
        return c(b10, c(b11, b12));
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final long j(long j10, long j11) {
        return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) >= 0 ? j10 : j11;
    }

    @c2(markerClass = {s.class})
    @bk.f
    @v0(version = "1.5")
    public static final long k(long j10, long j11, long j12) {
        return j(j10, j(j11, j12));
    }

    @s
    @v0(version = "1.4")
    public static final short l(short s10, @yt.k short... other) {
        f0.p(other, "other");
        int iR = w1.r(other);
        for (int i10 = 0; i10 < iR; i10++) {
            s10 = a(s10, w1.p(other, i10));
        }
        return s10;
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final short m(short s10, short s11) {
        return f0.t(s10 & v1.f38215d, 65535 & s11) <= 0 ? s10 : s11;
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int n(int i10, int i11) {
        return Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) <= 0 ? i10 : i11;
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final byte o(byte b10, byte b11) {
        return f0.t(b10 & 255, b11 & 255) <= 0 ? b10 : b11;
    }

    @s
    @v0(version = "1.4")
    public static final int p(int i10, @yt.k int... other) {
        f0.p(other, "other");
        int iR = m1.r(other);
        for (int i11 = 0; i11 < iR; i11++) {
            i10 = n(i10, m1.p(other, i11));
        }
        return i10;
    }

    @s
    @v0(version = "1.4")
    public static final long q(long j10, @yt.k long... other) {
        f0.p(other, "other");
        int iR = q1.r(other);
        for (int i10 = 0; i10 < iR; i10++) {
            j10 = v(j10, q1.p(other, i10));
        }
        return j10;
    }

    @c2(markerClass = {s.class})
    @bk.f
    @v0(version = "1.5")
    public static final short r(short s10, short s11, short s12) {
        return m(s10, m(s11, s12));
    }

    @c2(markerClass = {s.class})
    @bk.f
    @v0(version = "1.5")
    public static final int s(int i10, int i11, int i12) {
        return n(i10, n(i11, i12));
    }

    @s
    @v0(version = "1.4")
    public static final byte t(byte b10, @yt.k byte... other) {
        f0.p(other, "other");
        int iR = i1.r(other);
        for (int i10 = 0; i10 < iR; i10++) {
            b10 = o(b10, i1.p(other, i10));
        }
        return b10;
    }

    @c2(markerClass = {s.class})
    @bk.f
    @v0(version = "1.5")
    public static final byte u(byte b10, byte b11, byte b12) {
        return o(b10, o(b11, b12));
    }

    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final long v(long j10, long j11) {
        return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) <= 0 ? j10 : j11;
    }

    @c2(markerClass = {s.class})
    @bk.f
    @v0(version = "1.5")
    public static final long w(long j10, long j11, long j12) {
        return v(j10, v(j11, j12));
    }

    @s
    @v0(version = "1.4")
    public static final short x(short s10, @yt.k short... other) {
        f0.p(other, "other");
        int iR = w1.r(other);
        for (int i10 = 0; i10 < iR; i10++) {
            s10 = m(s10, w1.p(other, i10));
        }
        return s10;
    }
}
