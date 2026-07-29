package kotlin.random;

import bk.m;
import java.io.Serializable;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.v0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
@v0(version = "1.3")
public abstract class Random {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final Default f38003a = new Default(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final Random f38004b = m.f9497a.b();

    public static final class Default extends Random implements Serializable {

        public static final class Serialized implements Serializable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @k
            public static final Serialized f38005a = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.f38003a;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(u uVar) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.f38005a;
        }

        @Override // kotlin.random.Random
        public int b(int i10) {
            return Random.f38004b.b(i10);
        }

        @Override // kotlin.random.Random
        public boolean c() {
            return Random.f38004b.c();
        }

        @Override // kotlin.random.Random
        @k
        public byte[] d(int i10) {
            return Random.f38004b.d(i10);
        }

        @Override // kotlin.random.Random
        @k
        public byte[] f(@k byte[] array) {
            f0.p(array, "array");
            return Random.f38004b.f(array);
        }

        @Override // kotlin.random.Random
        @k
        public byte[] h(@k byte[] array, int i10, int i11) {
            f0.p(array, "array");
            return Random.f38004b.h(array, i10, i11);
        }

        @Override // kotlin.random.Random
        public double k() {
            return Random.f38004b.k();
        }

        @Override // kotlin.random.Random
        public double l(double d10) {
            return Random.f38004b.l(d10);
        }

        @Override // kotlin.random.Random
        public double m(double d10, double d11) {
            return Random.f38004b.m(d10, d11);
        }

        @Override // kotlin.random.Random
        public float n() {
            return Random.f38004b.n();
        }

        @Override // kotlin.random.Random
        public int o() {
            return Random.f38004b.o();
        }

        @Override // kotlin.random.Random
        public int p(int i10) {
            return Random.f38004b.p(i10);
        }

        @Override // kotlin.random.Random
        public int q(int i10, int i11) {
            return Random.f38004b.q(i10, i11);
        }

        @Override // kotlin.random.Random
        public long r() {
            return Random.f38004b.r();
        }

        @Override // kotlin.random.Random
        public long t(long j10) {
            return Random.f38004b.t(j10);
        }

        @Override // kotlin.random.Random
        public long u(long j10, long j11) {
            return Random.f38004b.u(j10, j11);
        }
    }

    public static /* synthetic */ byte[] i(Random random, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return random.h(bArr, i10, i11);
    }

    public abstract int b(int i10);

    public boolean c() {
        return b(1) != 0;
    }

    @k
    public byte[] d(int i10) {
        return f(new byte[i10]);
    }

    @k
    public byte[] f(@k byte[] array) {
        f0.p(array, "array");
        return h(array, 0, array.length);
    }

    @k
    public byte[] h(@k byte[] array, int i10, int i11) {
        f0.p(array, "array");
        if (!(new qk.m(0, array.length).p(i10) && new qk.m(0, array.length).p(i11))) {
            throw new IllegalArgumentException(("fromIndex (" + i10 + ") or toIndex (" + i11 + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (!(i10 <= i11)) {
            throw new IllegalArgumentException(("fromIndex (" + i10 + ") must be not greater than toIndex (" + i11 + ").").toString());
        }
        int i12 = (i11 - i10) / 4;
        for (int i13 = 0; i13 < i12; i13++) {
            int iO = o();
            array[i10] = (byte) iO;
            array[i10 + 1] = (byte) (iO >>> 8);
            array[i10 + 2] = (byte) (iO >>> 16);
            array[i10 + 3] = (byte) (iO >>> 24);
            i10 += 4;
        }
        int i14 = i11 - i10;
        int iB = b(i14 * 8);
        for (int i15 = 0; i15 < i14; i15++) {
            array[i10 + i15] = (byte) (iB >>> (i15 * 8));
        }
        return array;
    }

    public double k() {
        return c.d(b(26), b(27));
    }

    public double l(double d10) {
        return m(0.0d, d10);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double m(double r7, double r9) {
        /*
            r6 = this;
            kotlin.random.d.d(r7, r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L1b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L1b
            r2 = 1
            goto L1c
        L1b:
            r2 = 0
        L1c:
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L2b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L2b
            goto L2c
        L2b:
            r3 = 0
        L2c:
            if (r3 == 0) goto L3e
            double r0 = r6.k()
            r2 = 2
            double r2 = (double) r2
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L45
        L3e:
            double r2 = r6.k()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L45:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L4f
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L4f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.m(double, double):double");
    }

    public float n() {
        return b(24) / 1.6777216E7f;
    }

    public int o() {
        return b(32);
    }

    public int p(int i10) {
        return q(0, i10);
    }

    public int q(int i10, int i11) {
        int iO;
        int i12;
        int iB;
        int iO2;
        boolean z10;
        d.e(i10, i11);
        int i13 = i11 - i10;
        if (i13 > 0 || i13 == Integer.MIN_VALUE) {
            if (((-i13) & i13) == i13) {
                iB = b(d.g(i13));
            } else {
                do {
                    iO = o() >>> 1;
                    i12 = iO % i13;
                } while ((iO - i12) + (i13 - 1) < 0);
                iB = i12;
            }
            return i10 + iB;
        }
        do {
            iO2 = o();
            z10 = false;
            if (i10 <= iO2 && iO2 < i11) {
                z10 = true;
            }
        } while (!z10);
        return iO2;
    }

    public long r() {
        return (((long) o()) << 32) + ((long) o());
    }

    public long t(long j10) {
        return u(0L, j10);
    }

    public long u(long j10, long j11) {
        long jR;
        boolean z10;
        long jR2;
        long j12;
        long jB;
        int iO;
        d.f(j10, j11);
        long j13 = j11 - j10;
        if (j13 <= 0) {
            do {
                jR = r();
                z10 = false;
                if (j10 <= jR && jR < j11) {
                    z10 = true;
                }
            } while (!z10);
            return jR;
        }
        if (((-j13) & j13) == j13) {
            int i10 = (int) j13;
            int i11 = (int) (j13 >>> 32);
            if (i10 != 0) {
                iO = b(d.g(i10));
            } else if (i11 == 1) {
                iO = o();
            } else {
                jB = (((long) b(d.g(i11))) << 32) + (((long) o()) & 4294967295L);
            }
            jB = ((long) iO) & 4294967295L;
        } else {
            do {
                jR2 = r() >>> 1;
                j12 = jR2 % j13;
            } while ((jR2 - j12) + (j13 - 1) < 0);
            jB = j12;
        }
        return j10 + jB;
    }
}
