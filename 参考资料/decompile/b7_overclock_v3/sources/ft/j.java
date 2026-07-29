package ft;

/* JADX INFO: loaded from: classes6.dex */
public class j extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f28771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f28772c;

    public j(h hVar, byte[] bArr) {
        this.f28771b = new h(hVar);
        int i10 = 8;
        int i11 = 1;
        while (hVar.d() > i10) {
            i11++;
            i10 += 8;
        }
        if (bArr.length % i11 != 0) {
            throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
        }
        int length = bArr.length / i11;
        this.f28755a = length;
        this.f28772c = new int[length];
        int i12 = 0;
        for (int i13 = 0; i13 < this.f28772c.length; i13++) {
            int i14 = 0;
            while (i14 < i10) {
                int[] iArr = this.f28772c;
                iArr[i13] = ((bArr[i12] & 255) << i14) | iArr[i13];
                i14 += 8;
                i12++;
            }
            if (!hVar.k(this.f28772c[i13])) {
                throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
            }
        }
    }

    public j(h hVar, int[] iArr) {
        this.f28771b = hVar;
        this.f28755a = iArr.length;
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (!hVar.k(iArr[length])) {
                throw new ArithmeticException("Element array is not specified over the given finite field.");
            }
        }
        this.f28772c = t.a(iArr);
    }

    public j(j jVar) {
        this.f28771b = new h(jVar.f28771b);
        this.f28755a = jVar.f28755a;
        this.f28772c = t.a(jVar.f28772c);
    }

    @Override // ft.c0
    public c0 a(c0 c0Var) {
        throw new RuntimeException("not implemented");
    }

    @Override // ft.c0
    public byte[] b() {
        int i10 = 8;
        int i11 = 1;
        while (this.f28771b.d() > i10) {
            i11++;
            i10 += 8;
        }
        byte[] bArr = new byte[this.f28772c.length * i11];
        int i12 = 0;
        for (int i13 = 0; i13 < this.f28772c.length; i13++) {
            int i14 = 0;
            while (i14 < i10) {
                bArr[i12] = (byte) (this.f28772c[i13] >>> i14);
                i14 += 8;
                i12++;
            }
        }
        return bArr;
    }

    @Override // ft.c0
    public boolean d() {
        for (int length = this.f28772c.length - 1; length >= 0; length--) {
            if (this.f28772c[length] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // ft.c0
    public c0 e(x xVar) {
        int[] iArrC = xVar.c();
        int i10 = this.f28755a;
        if (i10 != iArrC.length) {
            throw new ArithmeticException("permutation size and vector size mismatch");
        }
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < iArrC.length; i11++) {
            iArr[i11] = this.f28772c[iArrC[i11]];
        }
        return new j(this.f28771b, iArr);
    }

    @Override // ft.c0
    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f28771b.equals(jVar.f28771b)) {
            return t.b(this.f28772c, jVar.f28772c);
        }
        return false;
    }

    public h f() {
        return this.f28771b;
    }

    public int[] g() {
        return t.a(this.f28772c);
    }

    @Override // ft.c0
    public int hashCode() {
        return (this.f28771b.hashCode() * 31) + org.bouncycastle.util.a.v0(this.f28772c);
    }

    @Override // ft.c0
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < this.f28772c.length; i10++) {
            for (int i11 = 0; i11 < this.f28771b.d(); i11++) {
                stringBuffer.append(((1 << (i11 & 31)) & this.f28772c[i10]) != 0 ? '1' : '0');
            }
            stringBuffer.append(zc.f.f58383m);
        }
        return stringBuffer.toString();
    }
}
