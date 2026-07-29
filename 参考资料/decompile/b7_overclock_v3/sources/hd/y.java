package hd;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31230a = "NalUnitUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31232c = 255;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f31234e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f31235f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f31236g = 39;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f31231b = {0, 0, 0, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[] f31233d = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f31237h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int[] f31238i = new int[10];

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f31241c;

        public a(int i10, int i11, boolean z10) {
            this.f31239a = i10;
            this.f31240b = i11;
            this.f31241c = z10;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f31245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f31246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f31247f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f31248g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f31249h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f31250i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f31251j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f31252k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f31253l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f31254m;

        public b(int i10, int i11, int i12, int i13, int i14, int i15, float f10, boolean z10, boolean z11, int i16, int i17, int i18, boolean z12) {
            this.f31242a = i10;
            this.f31243b = i11;
            this.f31244c = i12;
            this.f31245d = i13;
            this.f31246e = i14;
            this.f31247f = i15;
            this.f31248g = f10;
            this.f31249h = z10;
            this.f31250i = z11;
            this.f31251j = i16;
            this.f31252k = i17;
            this.f31253l = i18;
            this.f31254m = z12;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i10 + 1;
            if (i12 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i13 = byteBuffer.get(i10) & 255;
            if (i11 == 3) {
                if (i13 == 1 && (byteBuffer.get(i12) & 31) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i10 - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i13 == 0) {
                i11++;
            }
            if (i13 != 0) {
                i11 = 0;
            }
            i10 = i12;
        }
    }

    public static int c(byte[] bArr, int i10, int i11, boolean[] zArr) {
        int i12 = i11 - i10;
        hd.a.i(i12 >= 0);
        if (i12 == 0) {
            return i11;
        }
        if (zArr[0]) {
            a(zArr);
            return i10 - 3;
        }
        if (i12 > 1 && zArr[1] && bArr[i10] == 1) {
            a(zArr);
            return i10 - 2;
        }
        if (i12 > 2 && zArr[2] && bArr[i10] == 0 && bArr[i10 + 1] == 1) {
            a(zArr);
            return i10 - 1;
        }
        int i13 = i11 - 1;
        int i14 = i10 + 2;
        while (i14 < i13) {
            if ((bArr[i14] & 254) == 0) {
                int i15 = i14 - 2;
                if (bArr[i15] == 0 && bArr[i14 - 1] == 0 && bArr[i14] == 1) {
                    a(zArr);
                    return i15;
                }
                i14 -= 2;
            }
            i14 += 3;
        }
        zArr[0] = i12 <= 2 ? !(i12 != 2 ? !(zArr[1] && bArr[i13] == 1) : !(zArr[2] && bArr[i11 + (-2)] == 0 && bArr[i13] == 1)) : bArr[i11 + (-3)] == 0 && bArr[i11 + (-2)] == 0 && bArr[i13] == 1;
        zArr[1] = i12 <= 1 ? zArr[2] && bArr[i13] == 0 : bArr[i11 + (-2)] == 0 && bArr[i13] == 0;
        zArr[2] = bArr[i13] == 0;
        return i11;
    }

    public static int d(byte[] bArr, int i10, int i11) {
        while (i10 < i11 - 2) {
            if (bArr[i10] == 0 && bArr[i10 + 1] == 0 && bArr[i10 + 2] == 3) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int e(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i10) {
        return bArr[i10 + 3] & 31;
    }

    public static boolean g(@g.p0 String str, byte b10) {
        if (w.f31190j.equals(str) && (b10 & 31) == 6) {
            return true;
        }
        return w.f31192k.equals(str) && ((b10 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i10, int i11) {
        d0 d0Var = new d0(bArr, i10, i11);
        d0Var.l(8);
        int iH = d0Var.h();
        int iH2 = d0Var.h();
        d0Var.k();
        return new a(iH, iH2, d0Var.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static hd.y.b i(byte[] r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hd.y.i(byte[], int, int):hd.y$b");
    }

    public static void j(d0 d0Var, int i10) {
        int iG = 8;
        int i11 = 8;
        for (int i12 = 0; i12 < i10; i12++) {
            if (iG != 0) {
                iG = ((d0Var.g() + i11) + 256) % 256;
            }
            if (iG != 0) {
                i11 = iG;
            }
        }
    }

    public static int k(byte[] bArr, int i10) {
        int i11;
        synchronized (f31237h) {
            int iD = 0;
            int i12 = 0;
            while (iD < i10) {
                try {
                    iD = d(bArr, iD, i10);
                    if (iD < i10) {
                        int[] iArr = f31238i;
                        if (iArr.length <= i12) {
                            f31238i = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f31238i[i12] = iD;
                        iD += 3;
                        i12++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            i11 = i10 - i12;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < i12; i15++) {
                int i16 = f31238i[i15] - i14;
                System.arraycopy(bArr, i14, bArr, i13, i16);
                int i17 = i13 + i16;
                int i18 = i17 + 1;
                bArr[i17] = 0;
                i13 = i18 + 1;
                bArr[i18] = 0;
                i14 += i16 + 3;
            }
            System.arraycopy(bArr, i14, bArr, i13, i11 - i13);
        }
        return i11;
    }
}
