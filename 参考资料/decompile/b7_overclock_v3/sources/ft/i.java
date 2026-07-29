package ft;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes6.dex */
public class i extends w {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f28769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[][] f28770i;

    public i(h hVar, byte[] bArr) {
        this.f28769h = hVar;
        int i10 = 8;
        int i11 = 1;
        while (hVar.d() > i10) {
            i11++;
            i10 += 8;
        }
        if (bArr.length < 5) {
            throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
        }
        int i12 = ((((bArr[3] & 255) << 24) ^ ((bArr[2] & 255) << 16)) ^ ((bArr[1] & 255) << 8)) ^ (bArr[0] & 255);
        this.f28819a = i12;
        int i13 = i11 * i12;
        if (i12 > 0) {
            int i14 = 4;
            if ((bArr.length - 4) % i13 == 0) {
                int length = (bArr.length - 4) / i13;
                this.f28820b = length;
                this.f28770i = (int[][]) Array.newInstance((Class<?>) int.class, i12, length);
                for (int i15 = 0; i15 < this.f28819a; i15++) {
                    for (int i16 = 0; i16 < this.f28820b; i16++) {
                        int i17 = 0;
                        while (i17 < i10) {
                            int[] iArr = this.f28770i[i15];
                            iArr[i16] = iArr[i16] ^ ((bArr[i14] & 255) << i17);
                            i17 += 8;
                            i14++;
                        }
                        if (!this.f28769h.k(this.f28770i[i15][i16])) {
                            throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
                        }
                    }
                }
                return;
            }
        }
        throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
    }

    public i(h hVar, int[][] iArr) {
        this.f28769h = hVar;
        this.f28770i = iArr;
        this.f28819a = iArr.length;
        this.f28820b = iArr[0].length;
    }

    public i(i iVar) {
        int i10 = iVar.f28819a;
        this.f28819a = i10;
        this.f28820b = iVar.f28820b;
        this.f28769h = iVar.f28769h;
        this.f28770i = new int[i10][];
        for (int i11 = 0; i11 < this.f28819a; i11++) {
            this.f28770i[i11] = t.a(iVar.f28770i[i11]);
        }
    }

    public static void m(int[][] iArr, int i10, int i11) {
        int[] iArr2 = iArr[i10];
        iArr[i10] = iArr[i11];
        iArr[i11] = iArr2;
    }

    @Override // ft.w
    public w a() {
        int i10;
        int i11 = this.f28819a;
        if (i11 != this.f28820b) {
            throw new ArithmeticException("Matrix is not invertible.");
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i11, i11);
        for (int i12 = this.f28819a - 1; i12 >= 0; i12--) {
            iArr[i12] = t.a(this.f28770i[i12]);
        }
        int i13 = this.f28819a;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, i13, i13);
        for (int i14 = this.f28819a - 1; i14 >= 0; i14--) {
            iArr2[i14][i14] = 1;
        }
        for (int i15 = 0; i15 < this.f28819a; i15++) {
            if (iArr[i15][i15] == 0) {
                int i16 = i15 + 1;
                boolean z10 = false;
                while (i16 < this.f28819a) {
                    if (iArr[i16][i15] != 0) {
                        m(iArr, i15, i16);
                        m(iArr2, i15, i16);
                        i16 = this.f28819a;
                        z10 = true;
                    }
                    i16++;
                }
                if (!z10) {
                    throw new ArithmeticException("Matrix is not invertible.");
                }
            }
            int iJ = this.f28769h.j(iArr[i15][i15]);
            l(iArr[i15], iJ);
            l(iArr2[i15], iJ);
            for (int i17 = 0; i17 < this.f28819a; i17++) {
                if (i17 != i15 && (i10 = iArr[i17][i15]) != 0) {
                    int[] iArrK = k(iArr[i15], i10);
                    int[] iArrK2 = k(iArr2[i15], i10);
                    j(iArrK, iArr[i17]);
                    j(iArrK2, iArr2[i17]);
                }
            }
        }
        return new i(this.f28769h, iArr2);
    }

    @Override // ft.w
    public byte[] b() {
        int i10 = 8;
        int i11 = 1;
        while (this.f28769h.d() > i10) {
            i11++;
            i10 += 8;
        }
        int i12 = this.f28819a;
        int i13 = this.f28820b * i12 * i11;
        int i14 = 4;
        byte[] bArr = new byte[i13 + 4];
        bArr[0] = (byte) (i12 & 255);
        bArr[1] = (byte) ((i12 >>> 8) & 255);
        bArr[2] = (byte) ((i12 >>> 16) & 255);
        bArr[3] = (byte) ((i12 >>> 24) & 255);
        for (int i15 = 0; i15 < this.f28819a; i15++) {
            for (int i16 = 0; i16 < this.f28820b; i16++) {
                int i17 = 0;
                while (i17 < i10) {
                    bArr[i14] = (byte) (this.f28770i[i15][i16] >>> i17);
                    i17 += 8;
                    i14++;
                }
            }
        }
        return bArr;
    }

    @Override // ft.w
    public boolean e() {
        for (int i10 = 0; i10 < this.f28819a; i10++) {
            for (int i11 = 0; i11 < this.f28820b; i11++) {
                if (this.f28770i[i10][i11] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i)) {
            i iVar = (i) obj;
            if (this.f28769h.equals(iVar.f28769h)) {
                int i10 = iVar.f28819a;
                int i11 = this.f28820b;
                if (i10 == i11 && iVar.f28820b == i11) {
                    for (int i12 = 0; i12 < this.f28819a; i12++) {
                        for (int i13 = 0; i13 < this.f28820b; i13++) {
                            if (this.f28770i[i12][i13] != iVar.f28770i[i12][i13]) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // ft.w
    public c0 f(c0 c0Var) {
        throw new RuntimeException("Not implemented.");
    }

    @Override // ft.w
    public w g(w wVar) {
        throw new RuntimeException("Not implemented.");
    }

    @Override // ft.w
    public w h(x xVar) {
        throw new RuntimeException("Not implemented.");
    }

    public int hashCode() {
        int iHashCode = (((this.f28769h.hashCode() * 31) + this.f28819a) * 31) + this.f28820b;
        for (int i10 = 0; i10 < this.f28819a; i10++) {
            for (int i11 = 0; i11 < this.f28820b; i11++) {
                iHashCode = (iHashCode * 31) + this.f28770i[i10][i11];
            }
        }
        return iHashCode;
    }

    @Override // ft.w
    public c0 i(c0 c0Var) {
        throw new RuntimeException("Not implemented.");
    }

    public final void j(int[] iArr, int[] iArr2) {
        for (int length = iArr2.length - 1; length >= 0; length--) {
            iArr2[length] = this.f28769h.a(iArr[length], iArr2[length]);
        }
    }

    public final int[] k(int[] iArr, int i10) {
        int[] iArr2 = new int[iArr.length];
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr2[length] = this.f28769h.l(iArr[length], i10);
        }
        return iArr2;
    }

    public final void l(int[] iArr, int i10) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr[length] = this.f28769h.l(iArr[length], i10);
        }
    }

    @Override // ft.w
    public String toString() {
        String str = this.f28819a + " x " + this.f28820b + " Matrix over " + this.f28769h.toString() + ": \n";
        for (int i10 = 0; i10 < this.f28819a; i10++) {
            for (int i11 = 0; i11 < this.f28820b; i11++) {
                str = str + this.f28769h.b(this.f28770i[i10][i11]) + " : ";
            }
            str = str + "\n";
        }
        return str;
    }
}
