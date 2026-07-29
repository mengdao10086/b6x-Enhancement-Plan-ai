package okio.internal;

import com.flydigi.sdk.bluetooth.l;
import ik.q;
import kotlin.collections.m;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m0.k;
import okio.ByteString;
import okio.SegmentedByteString;
import okio.a1;
import okio.p0;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000R\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a$\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a]\u0010\u0012\u001a\u00020\u0010*\u00020\u00062K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0080\bø\u0001\u0000\u001aj\u0010\u0015\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012K\u0010\u0011\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0082\b\u001a\u001d\u0010\u0017\u001a\u00020\u0016*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u0018*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0006H\u0080\b\u001a\r\u0010\u001b\u001a\u00020\n*\u00020\u0006H\u0080\b\u001a%\u0010\u001e\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010\"\u001a\u00020!*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010#\u001a\u00020!*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010&\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010(\u001a\u00020!*\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010'H\u0080\b\u001a\r\u0010)\u001a\u00020\u0001*\u00020\u0006H\u0080\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"", "", "value", "fromIndex", "toIndex", "a", "Lokio/SegmentedByteString;", "pos", "n", "Lkotlin/Function3;", "", "Lkotlin/n0;", "name", "data", w.c.R, "byteCount", "Lkotlin/z1;", "action", k.f40564b, "beginIndex", "endIndex", l.f16298a, "Lokio/ByteString;", "i", "", "f", "d", xf.j.f55230b, "Lokio/j;", "buffer", "k", "other", "otherOffset", "", "g", "h", "target", "targetOffset", "b", "", "c", "e", "okio"}, k = 2, mv = {1, 5, 1})
public final class i {
    public static final int a(@yt.k int[] iArr, int i10, int i11, int i12) {
        f0.p(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final void b(@yt.k SegmentedByteString segmentedByteString, int i10, @yt.k byte[] target, int i11, int i12) {
        f0.p(segmentedByteString, "<this>");
        f0.p(target, "target");
        long j10 = i12;
        a1.e(segmentedByteString.x0(), i10, j10);
        a1.e(target.length, i11, j10);
        int i13 = i12 + i10;
        int iN = n(segmentedByteString, i10);
        while (i10 < i13) {
            int i14 = iN == 0 ? 0 : segmentedByteString.R0()[iN - 1];
            int i15 = segmentedByteString.R0()[iN] - i14;
            int i16 = segmentedByteString.R0()[segmentedByteString.S0().length + iN];
            int iMin = Math.min(i13, i15 + i14) - i10;
            int i17 = i16 + (i10 - i14);
            m.W0(segmentedByteString.S0()[iN], target, i11, i17, i17 + iMin);
            i11 += iMin;
            i10 += iMin;
            iN++;
        }
    }

    public static final boolean c(@yt.k SegmentedByteString segmentedByteString, @yt.l Object obj) {
        f0.p(segmentedByteString, "<this>");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.x0() == segmentedByteString.x0() && segmentedByteString.o0(0, byteString, 0, segmentedByteString.x0())) {
                return true;
            }
        }
        return false;
    }

    public static final int d(@yt.k SegmentedByteString segmentedByteString) {
        f0.p(segmentedByteString, "<this>");
        return segmentedByteString.R0()[segmentedByteString.S0().length - 1];
    }

    public static final int e(@yt.k SegmentedByteString segmentedByteString) {
        f0.p(segmentedByteString, "<this>");
        int iX = segmentedByteString.x();
        if (iX != 0) {
            return iX;
        }
        int length = segmentedByteString.S0().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i10 < length) {
            int i13 = segmentedByteString.R0()[length + i10];
            int i14 = segmentedByteString.R0()[i10];
            byte[] bArr = segmentedByteString.S0()[i10];
            int i15 = (i14 - i11) + i13;
            while (i13 < i15) {
                i12 = (i12 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i11 = i14;
        }
        segmentedByteString.r0(i12);
        return i12;
    }

    public static final byte f(@yt.k SegmentedByteString segmentedByteString, int i10) {
        f0.p(segmentedByteString, "<this>");
        a1.e(segmentedByteString.R0()[segmentedByteString.S0().length - 1], i10, 1L);
        int iN = n(segmentedByteString, i10);
        return segmentedByteString.S0()[iN][(i10 - (iN == 0 ? 0 : segmentedByteString.R0()[iN - 1])) + segmentedByteString.R0()[segmentedByteString.S0().length + iN]];
    }

    public static final boolean g(@yt.k SegmentedByteString segmentedByteString, int i10, @yt.k ByteString other, int i11, int i12) {
        f0.p(segmentedByteString, "<this>");
        f0.p(other, "other");
        if (i10 < 0 || i10 > segmentedByteString.x0() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iN = n(segmentedByteString, i10);
        while (i10 < i13) {
            int i14 = iN == 0 ? 0 : segmentedByteString.R0()[iN - 1];
            int i15 = segmentedByteString.R0()[iN] - i14;
            int i16 = segmentedByteString.R0()[segmentedByteString.S0().length + iN];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!other.p0(i11, segmentedByteString.S0()[iN], i16 + (i10 - i14), iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iN++;
        }
        return true;
    }

    public static final boolean h(@yt.k SegmentedByteString segmentedByteString, int i10, @yt.k byte[] other, int i11, int i12) {
        f0.p(segmentedByteString, "<this>");
        f0.p(other, "other");
        if (i10 < 0 || i10 > segmentedByteString.x0() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iN = n(segmentedByteString, i10);
        while (i10 < i13) {
            int i14 = iN == 0 ? 0 : segmentedByteString.R0()[iN - 1];
            int i15 = segmentedByteString.R0()[iN] - i14;
            int i16 = segmentedByteString.R0()[segmentedByteString.S0().length + iN];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!a1.d(segmentedByteString.S0()[iN], i16 + (i10 - i14), other, i11, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iN++;
        }
        return true;
    }

    @yt.k
    public static final ByteString i(@yt.k SegmentedByteString segmentedByteString, int i10, int i11) {
        f0.p(segmentedByteString, "<this>");
        int iL = a1.l(segmentedByteString, i11);
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
        }
        if (!(iL <= segmentedByteString.x0())) {
            throw new IllegalArgumentException(("endIndex=" + iL + " > length(" + segmentedByteString.x0() + ')').toString());
        }
        int i12 = iL - i10;
        if (!(i12 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + iL + " < beginIndex=" + i10).toString());
        }
        if (i10 == 0 && iL == segmentedByteString.x0()) {
            return segmentedByteString;
        }
        if (i10 == iL) {
            return ByteString.f44030d;
        }
        int iN = n(segmentedByteString, i10);
        int iN2 = n(segmentedByteString, iL - 1);
        byte[][] bArr = (byte[][]) m.M1(segmentedByteString.S0(), iN, iN2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iN <= iN2) {
            int i13 = iN;
            int i14 = 0;
            while (true) {
                int i15 = i13 + 1;
                iArr[i14] = Math.min(segmentedByteString.R0()[i13] - i10, i12);
                int i16 = i14 + 1;
                iArr[i14 + bArr.length] = segmentedByteString.R0()[segmentedByteString.S0().length + i13];
                if (i13 == iN2) {
                    break;
                }
                i13 = i15;
                i14 = i16;
            }
        }
        int i17 = iN != 0 ? segmentedByteString.R0()[iN - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i10 - i17);
        return new SegmentedByteString(bArr, iArr);
    }

    @yt.k
    public static final byte[] j(@yt.k SegmentedByteString segmentedByteString) {
        f0.p(segmentedByteString, "<this>");
        byte[] bArr = new byte[segmentedByteString.x0()];
        int length = segmentedByteString.S0().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = segmentedByteString.R0()[length + i10];
            int i14 = segmentedByteString.R0()[i10];
            int i15 = i14 - i11;
            m.W0(segmentedByteString.S0()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public static final void k(@yt.k SegmentedByteString segmentedByteString, @yt.k okio.j buffer, int i10, int i11) {
        f0.p(segmentedByteString, "<this>");
        f0.p(buffer, "buffer");
        int i12 = i10 + i11;
        int iN = n(segmentedByteString, i10);
        while (i10 < i12) {
            int i13 = iN == 0 ? 0 : segmentedByteString.R0()[iN - 1];
            int i14 = segmentedByteString.R0()[iN] - i13;
            int i15 = segmentedByteString.R0()[segmentedByteString.S0().length + iN];
            int iMin = Math.min(i12, i14 + i13) - i10;
            int i16 = i15 + (i10 - i13);
            p0 p0Var = new p0(segmentedByteString.S0()[iN], i16, i16 + iMin, true, false);
            p0 p0Var2 = buffer.f44116a;
            if (p0Var2 == null) {
                p0Var.f44180g = p0Var;
                p0Var.f44179f = p0Var;
                buffer.f44116a = p0Var;
            } else {
                f0.m(p0Var2);
                p0 p0Var3 = p0Var2.f44180g;
                f0.m(p0Var3);
                p0Var3.c(p0Var);
            }
            i10 += iMin;
            iN++;
        }
        buffer.i2(buffer.m2() + ((long) i11));
    }

    public static final void l(SegmentedByteString segmentedByteString, int i10, int i11, q<? super byte[], ? super Integer, ? super Integer, z1> qVar) {
        int iN = n(segmentedByteString, i10);
        while (i10 < i11) {
            int i12 = iN == 0 ? 0 : segmentedByteString.R0()[iN - 1];
            int i13 = segmentedByteString.R0()[iN] - i12;
            int i14 = segmentedByteString.R0()[segmentedByteString.S0().length + iN];
            int iMin = Math.min(i11, i13 + i12) - i10;
            qVar.A(segmentedByteString.S0()[iN], Integer.valueOf(i14 + (i10 - i12)), Integer.valueOf(iMin));
            i10 += iMin;
            iN++;
        }
    }

    public static final void m(@yt.k SegmentedByteString segmentedByteString, @yt.k q<? super byte[], ? super Integer, ? super Integer, z1> action) {
        f0.p(segmentedByteString, "<this>");
        f0.p(action, "action");
        int length = segmentedByteString.S0().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = segmentedByteString.R0()[length + i10];
            int i13 = segmentedByteString.R0()[i10];
            action.A(segmentedByteString.S0()[i10], Integer.valueOf(i12), Integer.valueOf(i13 - i11));
            i10++;
            i11 = i13;
        }
    }

    public static final int n(@yt.k SegmentedByteString segmentedByteString, int i10) {
        f0.p(segmentedByteString, "<this>");
        int iA = a(segmentedByteString.R0(), i10 + 1, 0, segmentedByteString.S0().length);
        return iA >= 0 ? iA : ~iA;
    }
}
