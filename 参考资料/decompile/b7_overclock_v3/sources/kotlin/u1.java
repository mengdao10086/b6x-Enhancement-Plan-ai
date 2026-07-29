package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "UNumbersKt")
public final class u1 {
    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int A(int i10) {
        return l1.j(Integer.lowestOneBit(i10));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final short B(short s10) {
        return v1.j((short) Integer.lowestOneBit(s10 & v1.f38215d));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int a(byte b10) {
        return Integer.numberOfLeadingZeros(b10 & 255) - 24;
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int b(long j10) {
        return Long.numberOfLeadingZeros(j10);
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int c(int i10) {
        return Integer.numberOfLeadingZeros(i10);
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int d(short s10) {
        return Integer.numberOfLeadingZeros(s10 & v1.f38215d) - 16;
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int e(byte b10) {
        return Integer.bitCount(l1.j(b10 & 255));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int f(long j10) {
        return Long.bitCount(j10);
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int g(int i10) {
        return Integer.bitCount(i10);
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int h(short s10) {
        return Integer.bitCount(l1.j(s10 & v1.f38215d));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int i(byte b10) {
        return Integer.numberOfTrailingZeros(b10 | 256);
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int j(long j10) {
        return Long.numberOfTrailingZeros(j10);
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int k(int i10) {
        return Integer.numberOfTrailingZeros(i10);
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int l(short s10) {
        return Integer.numberOfTrailingZeros(s10 | 65536);
    }

    @c2(markerClass = {q.class, s.class})
    @bk.f
    @v0(version = "1.6")
    public static final long m(long j10, int i10) {
        return p1.j(Long.rotateLeft(j10, i10));
    }

    @c2(markerClass = {q.class, s.class})
    @bk.f
    @v0(version = "1.6")
    public static final byte n(byte b10, int i10) {
        return h1.j(j0.Z0(b10, i10));
    }

    @c2(markerClass = {q.class, s.class})
    @bk.f
    @v0(version = "1.6")
    public static final int o(int i10, int i11) {
        return l1.j(Integer.rotateLeft(i10, i11));
    }

    @c2(markerClass = {q.class, s.class})
    @bk.f
    @v0(version = "1.6")
    public static final short p(short s10, int i10) {
        return v1.j(j0.a1(s10, i10));
    }

    @c2(markerClass = {q.class, s.class})
    @bk.f
    @v0(version = "1.6")
    public static final long q(long j10, int i10) {
        return p1.j(Long.rotateRight(j10, i10));
    }

    @c2(markerClass = {q.class, s.class})
    @bk.f
    @v0(version = "1.6")
    public static final byte r(byte b10, int i10) {
        return h1.j(j0.b1(b10, i10));
    }

    @c2(markerClass = {q.class, s.class})
    @bk.f
    @v0(version = "1.6")
    public static final int s(int i10, int i11) {
        return l1.j(Integer.rotateRight(i10, i11));
    }

    @c2(markerClass = {q.class, s.class})
    @bk.f
    @v0(version = "1.6")
    public static final short t(short s10, int i10) {
        return v1.j(j0.c1(s10, i10));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final byte u(byte b10) {
        return h1.j((byte) Integer.highestOneBit(b10 & 255));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final long v(long j10) {
        return p1.j(Long.highestOneBit(j10));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final int w(int i10) {
        return l1.j(Integer.highestOneBit(i10));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final short x(short s10) {
        return v1.j((short) Integer.highestOneBit(s10 & v1.f38215d));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final byte y(byte b10) {
        return h1.j((byte) Integer.lowestOneBit(b10 & 255));
    }

    @c2(markerClass = {s.class, q.class})
    @bk.f
    @v0(version = "1.5")
    public static final long z(long j10) {
        return p1.j(Long.lowestOneBit(j10));
    }
}
