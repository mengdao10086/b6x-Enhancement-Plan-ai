package kotlin.collections;

import kotlin.m1;
import kotlin.q1;
import kotlin.v1;
import kotlin.w1;

/* JADX INFO: loaded from: classes5.dex */
public final class h1 {
    @kotlin.s
    public static final int a(long[] jArr, int i10, int i11) {
        long jP = q1.p(jArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (Long.compare(q1.p(jArr, i10) ^ Long.MIN_VALUE, jP ^ Long.MIN_VALUE) < 0) {
                i10++;
            }
            while (Long.compare(q1.p(jArr, i11) ^ Long.MIN_VALUE, jP ^ Long.MIN_VALUE) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                long jP2 = q1.p(jArr, i10);
                q1.w(jArr, i10, q1.p(jArr, i11));
                q1.w(jArr, i11, jP2);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @kotlin.s
    public static final int b(byte[] bArr, int i10, int i11) {
        int i12;
        byte bP = kotlin.i1.p(bArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (true) {
                i12 = bP & 255;
                if (kotlin.jvm.internal.f0.t(kotlin.i1.p(bArr, i10) & 255, i12) >= 0) {
                    break;
                }
                i10++;
            }
            while (kotlin.jvm.internal.f0.t(kotlin.i1.p(bArr, i11) & 255, i12) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                byte bP2 = kotlin.i1.p(bArr, i10);
                kotlin.i1.w(bArr, i10, kotlin.i1.p(bArr, i11));
                kotlin.i1.w(bArr, i11, bP2);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @kotlin.s
    public static final int c(short[] sArr, int i10, int i11) {
        int i12;
        short sP = w1.p(sArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (true) {
                int iP = w1.p(sArr, i10) & v1.f38215d;
                i12 = sP & v1.f38215d;
                if (kotlin.jvm.internal.f0.t(iP, i12) >= 0) {
                    break;
                }
                i10++;
            }
            while (kotlin.jvm.internal.f0.t(w1.p(sArr, i11) & v1.f38215d, i12) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                short sP2 = w1.p(sArr, i10);
                w1.w(sArr, i10, w1.p(sArr, i11));
                w1.w(sArr, i11, sP2);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @kotlin.s
    public static final int d(int[] iArr, int i10, int i11) {
        int iP = m1.p(iArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (Integer.compare(m1.p(iArr, i10) ^ Integer.MIN_VALUE, iP ^ Integer.MIN_VALUE) < 0) {
                i10++;
            }
            while (Integer.compare(m1.p(iArr, i11) ^ Integer.MIN_VALUE, iP ^ Integer.MIN_VALUE) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                int iP2 = m1.p(iArr, i10);
                m1.w(iArr, i10, m1.p(iArr, i11));
                m1.w(iArr, i11, iP2);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @kotlin.s
    public static final void e(long[] jArr, int i10, int i11) {
        int iA = a(jArr, i10, i11);
        int i12 = iA - 1;
        if (i10 < i12) {
            e(jArr, i10, i12);
        }
        if (iA < i11) {
            e(jArr, iA, i11);
        }
    }

    @kotlin.s
    public static final void f(byte[] bArr, int i10, int i11) {
        int iB = b(bArr, i10, i11);
        int i12 = iB - 1;
        if (i10 < i12) {
            f(bArr, i10, i12);
        }
        if (iB < i11) {
            f(bArr, iB, i11);
        }
    }

    @kotlin.s
    public static final void g(short[] sArr, int i10, int i11) {
        int iC = c(sArr, i10, i11);
        int i12 = iC - 1;
        if (i10 < i12) {
            g(sArr, i10, i12);
        }
        if (iC < i11) {
            g(sArr, iC, i11);
        }
    }

    @kotlin.s
    public static final void h(int[] iArr, int i10, int i11) {
        int iD = d(iArr, i10, i11);
        int i12 = iD - 1;
        if (i10 < i12) {
            h(iArr, i10, i12);
        }
        if (iD < i11) {
            h(iArr, iD, i11);
        }
    }

    @kotlin.s
    public static final void i(@yt.k long[] array, int i10, int i11) {
        kotlin.jvm.internal.f0.p(array, "array");
        e(array, i10, i11 - 1);
    }

    @kotlin.s
    public static final void j(@yt.k byte[] array, int i10, int i11) {
        kotlin.jvm.internal.f0.p(array, "array");
        f(array, i10, i11 - 1);
    }

    @kotlin.s
    public static final void k(@yt.k short[] array, int i10, int i11) {
        kotlin.jvm.internal.f0.p(array, "array");
        g(array, i10, i11 - 1);
    }

    @kotlin.s
    public static final void l(@yt.k int[] array, int i10, int i11) {
        kotlin.jvm.internal.f0.p(array, "array");
        h(array, i10, i11 - 1);
    }
}
