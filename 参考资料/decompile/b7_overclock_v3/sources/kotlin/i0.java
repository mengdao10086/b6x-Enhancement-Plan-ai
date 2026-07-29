package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends h0 {
    @bk.f
    @v0(version = "1.2")
    public static final float A0(kotlin.jvm.internal.y yVar, int i10) {
        kotlin.jvm.internal.f0.p(yVar, "<this>");
        return Float.intBitsToFloat(i10);
    }

    @bk.f
    public static final boolean B0(double d10) {
        return (Double.isInfinite(d10) || Double.isNaN(d10)) ? false : true;
    }

    @bk.f
    public static final boolean C0(float f10) {
        return (Float.isInfinite(f10) || Float.isNaN(f10)) ? false : true;
    }

    @bk.f
    public static final boolean D0(double d10) {
        return Double.isInfinite(d10);
    }

    @bk.f
    public static final boolean E0(float f10) {
        return Float.isInfinite(f10);
    }

    @bk.f
    public static final boolean F0(double d10) {
        return Double.isNaN(d10);
    }

    @bk.f
    public static final boolean G0(float f10) {
        return Float.isNaN(f10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.6")
    public static final int H0(int i10, int i11) {
        return Integer.rotateLeft(i10, i11);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.6")
    public static final long I0(long j10, int i10) {
        return Long.rotateLeft(j10, i10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.6")
    public static final int J0(int i10, int i11) {
        return Integer.rotateRight(i10, i11);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.6")
    public static final long K0(long j10, int i10) {
        return Long.rotateRight(j10, i10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final int L0(int i10) {
        return Integer.highestOneBit(i10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final long M0(long j10) {
        return Long.highestOneBit(j10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final int N0(int i10) {
        return Integer.lowestOneBit(i10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final long O0(long j10) {
        return Long.lowestOneBit(j10);
    }

    @bk.f
    @v0(version = "1.2")
    public static final int P0(float f10) {
        return Float.floatToIntBits(f10);
    }

    @bk.f
    @v0(version = "1.2")
    public static final long Q0(double d10) {
        return Double.doubleToLongBits(d10);
    }

    @bk.f
    @v0(version = "1.2")
    public static final int R0(float f10) {
        return Float.floatToRawIntBits(f10);
    }

    @bk.f
    @v0(version = "1.2")
    public static final long S0(double d10) {
        return Double.doubleToRawLongBits(d10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final int t0(int i10) {
        return Integer.numberOfLeadingZeros(i10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final int u0(long j10) {
        return Long.numberOfLeadingZeros(j10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final int v0(int i10) {
        return Integer.bitCount(i10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final int w0(long j10) {
        return Long.bitCount(j10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final int x0(int i10) {
        return Integer.numberOfTrailingZeros(i10);
    }

    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.4")
    public static final int y0(long j10) {
        return Long.numberOfTrailingZeros(j10);
    }

    @bk.f
    @v0(version = "1.2")
    public static final double z0(kotlin.jvm.internal.v vVar, long j10) {
        kotlin.jvm.internal.f0.p(vVar, "<this>");
        return Double.longBitsToDouble(j10);
    }
}
