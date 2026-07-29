package ss;

/* JADX INFO: loaded from: classes6.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f50506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50507b;

    public s(k kVar) {
        this.f50506a = kVar;
        this.f50507b = kVar.f50452c;
    }

    public int[] a(byte[] bArr, int i10, int i11) {
        int[] iArr = new int[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < i11; i16++) {
            if (i12 == 0) {
                i15 = bArr[i13];
                i13++;
                i12 += 8;
            }
            i12 -= this.f50506a.f50453d;
            iArr[i14] = (i15 >>> i12) & (i10 - 1);
            i14++;
        }
        return iArr;
    }

    public byte[] b(byte[] bArr, int i10, int i11, byte[] bArr2, a aVar) {
        if (i11 == 0) {
            return org.bouncycastle.util.a.p(bArr);
        }
        int i12 = i10 + i11;
        if (i12 > this.f50507b - 1) {
            return null;
        }
        byte[] bArrB = b(bArr, i10, i11 - 1, bArr2, aVar);
        aVar.h(i12 - 1);
        return this.f50506a.a(bArr2, aVar, bArrB);
    }

    public byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3, a aVar) {
        k kVar;
        a aVar2 = new a(aVar);
        int[] iArrA = a(bArr2, this.f50507b, this.f50506a.f50455f);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            kVar = this.f50506a;
            if (i10 >= kVar.f50455f) {
                break;
            }
            i11 += (this.f50507b - 1) - iArrA[i10];
            i10++;
        }
        int i12 = kVar.f50456g;
        int i13 = kVar.f50453d;
        int[] iArrF = org.bouncycastle.util.a.F(iArrA, a(org.bouncycastle.util.a.W(org.bouncycastle.util.o.k(i11 << (8 - ((i12 * i13) % 8))), 4 - (((i12 * i13) + 7) / 8), 4), this.f50507b, this.f50506a.f50456g));
        k kVar2 = this.f50506a;
        byte[] bArr4 = new byte[kVar2.f50451b];
        byte[][] bArr5 = new byte[kVar2.f50454e][];
        for (int i14 = 0; i14 < this.f50506a.f50454e; i14++) {
            aVar.g(i14);
            int i15 = this.f50506a.f50451b;
            System.arraycopy(bArr, i14 * i15, bArr4, 0, i15);
            bArr5[i14] = b(bArr4, iArrF[i14], (this.f50507b - 1) - iArrF[i14], bArr3, aVar);
        }
        aVar2.n(1);
        aVar2.i(aVar.a());
        return this.f50506a.f(bArr3, aVar2, org.bouncycastle.util.a.E(bArr5));
    }

    public byte[] d(byte[] bArr, byte[] bArr2, a aVar) {
        a aVar2 = new a(aVar);
        byte[][] bArr3 = new byte[this.f50506a.f50454e][];
        for (int i10 = 0; i10 < this.f50506a.f50454e; i10++) {
            a aVar3 = new a(aVar);
            aVar3.g(i10);
            aVar3.h(0);
            bArr3[i10] = b(this.f50506a.d(bArr, aVar3), 0, this.f50507b - 1, bArr2, aVar3);
        }
        aVar2.n(1);
        aVar2.i(aVar.a());
        return this.f50506a.f(bArr2, aVar2, org.bouncycastle.util.a.E(bArr3));
    }

    public byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3, a aVar) {
        k kVar;
        a aVar2 = new a(aVar);
        int[] iArrA = a(bArr, this.f50507b, this.f50506a.f50455f);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            kVar = this.f50506a;
            if (i10 >= kVar.f50455f) {
                break;
            }
            i11 += (this.f50507b - 1) - iArrA[i10];
            i10++;
        }
        int i12 = kVar.f50453d;
        if (i12 % 8 != 0) {
            i11 <<= 8 - ((kVar.f50456g * i12) % 8);
        }
        int i13 = ((kVar.f50456g * i12) + 7) / 8;
        byte[] bArrK = org.bouncycastle.util.o.k(i11);
        int[] iArrF = org.bouncycastle.util.a.F(iArrA, a(org.bouncycastle.util.a.W(bArrK, i13, bArrK.length), this.f50507b, this.f50506a.f50456g));
        byte[][] bArr4 = new byte[this.f50506a.f50454e][];
        for (int i14 = 0; i14 < this.f50506a.f50454e; i14++) {
            aVar2.g(i14);
            aVar2.h(0);
            bArr4[i14] = b(this.f50506a.d(bArr2, aVar2), 0, iArrF[i14], bArr3, aVar2);
        }
        return org.bouncycastle.util.a.E(bArr4);
    }
}
