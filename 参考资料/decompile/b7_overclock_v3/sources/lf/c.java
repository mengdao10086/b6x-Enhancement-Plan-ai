package lf;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f39760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f39761b;

    public c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f39760a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f39761b = iArr;
            return;
        }
        int i10 = 1;
        while (i10 < length && iArr[i10] == 0) {
            i10++;
        }
        if (i10 == length) {
            this.f39761b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i10];
        this.f39761b = iArr2;
        System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
    }

    public c a(c cVar) {
        if (!this.f39760a.equals(cVar.f39760a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (f()) {
            return cVar;
        }
        if (cVar.f()) {
            return this;
        }
        int[] iArr = this.f39761b;
        int[] iArr2 = cVar.f39761b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i10 = length; i10 < iArr.length; i10++) {
            iArr3[i10] = this.f39760a.a(iArr2[i10 - length], iArr[i10]);
        }
        return new c(this.f39760a, iArr3);
    }

    public int b(int i10) {
        if (i10 == 0) {
            return c(0);
        }
        if (i10 == 1) {
            int iA = 0;
            for (int i11 : this.f39761b) {
                iA = this.f39760a.a(iA, i11);
            }
            return iA;
        }
        int[] iArr = this.f39761b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i12 = 1; i12 < length; i12++) {
            b bVar = this.f39760a;
            iA2 = bVar.a(bVar.i(i10, iA2), this.f39761b[i12]);
        }
        return iA2;
    }

    public int c(int i10) {
        return this.f39761b[(r0.length - 1) - i10];
    }

    public int[] d() {
        return this.f39761b;
    }

    public int e() {
        return this.f39761b.length - 1;
    }

    public boolean f() {
        return this.f39761b[0] == 0;
    }

    public c g(int i10) {
        if (i10 == 0) {
            return this.f39760a.f();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f39761b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f39760a.i(this.f39761b[i11], i10);
        }
        return new c(this.f39760a, iArr);
    }

    public c h(c cVar) {
        if (!this.f39760a.equals(cVar.f39760a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (f() || cVar.f()) {
            return this.f39760a.f();
        }
        int[] iArr = this.f39761b;
        int length = iArr.length;
        int[] iArr2 = cVar.f39761b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            for (int i12 = 0; i12 < length2; i12++) {
                int i13 = i10 + i12;
                b bVar = this.f39760a;
                iArr3[i13] = bVar.a(iArr3[i13], bVar.i(i11, iArr2[i12]));
            }
        }
        return new c(this.f39760a, iArr3);
    }

    public c i(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f39760a.f();
        }
        int length = this.f39761b.length;
        int[] iArr = new int[i10 + length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f39760a.i(this.f39761b[i12], i11);
        }
        return new c(this.f39760a, iArr);
    }

    public c j() {
        int length = this.f39761b.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = this.f39760a.j(0, this.f39761b[i10]);
        }
        return new c(this.f39760a, iArr);
    }

    public c k(c cVar) {
        if (this.f39760a.equals(cVar.f39760a)) {
            return cVar.f() ? this : a(cVar.j());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(e() * 8);
        for (int iE = e(); iE >= 0; iE--) {
            int iC = c(iE);
            if (iC != 0) {
                if (iC < 0) {
                    sb2.append(" - ");
                    iC = -iC;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (iE == 0 || iC != 1) {
                    sb2.append(iC);
                }
                if (iE != 0) {
                    if (iE == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(iE);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
