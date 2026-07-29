package ft;

import java.security.SecureRandom;
import java.util.Vector;

/* JADX INFO: loaded from: classes6.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecureRandom f28775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f28777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Vector f28778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Vector f28779e;

    public l(SecureRandom secureRandom) {
        this.f28775a = secureRandom;
    }

    public abstract void a(l lVar);

    public abstract void b();

    public final k c(k kVar, l lVar) throws RuntimeException {
        if (lVar == this || this.f28777c.equals(lVar.f28777c)) {
            return (k) kVar.clone();
        }
        if (this.f28776b != lVar.f28776b) {
            throw new RuntimeException("GF2nField.convert: B1 has a different degree and thus cannot be coverted to!");
        }
        int iIndexOf = this.f28778d.indexOf(lVar);
        if (iIndexOf == -1) {
            a(lVar);
            iIndexOf = this.f28778d.indexOf(lVar);
        }
        f[] fVarArr = (f[]) this.f28779e.elementAt(iIndexOf);
        k kVar2 = (k) kVar.clone();
        if (kVar2 instanceof m) {
            ((m) kVar2).H();
        }
        f fVar = new f(this.f28776b, kVar2.j());
        fVar.i(this.f28776b);
        f fVar2 = new f(this.f28776b);
        for (int i10 = 0; i10 < this.f28776b; i10++) {
            if (fVar.a0(fVarArr[i10])) {
                fVar2.I((this.f28776b - 1) - i10);
            }
        }
        if (lVar instanceof q) {
            return new p((q) lVar, fVar2);
        }
        if (!(lVar instanceof n)) {
            throw new RuntimeException("GF2nField.convert: B1 must be an instance of GF2nPolynomialField or GF2nONBField!");
        }
        m mVar = new m((n) lVar, fVar2.W());
        mVar.H();
        return mVar;
    }

    public final int d() {
        return this.f28776b;
    }

    public final f e() {
        if (this.f28777c == null) {
            b();
        }
        return new f(this.f28777c);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.f28776b != this.f28776b || !this.f28777c.equals(lVar.f28777c)) {
            return false;
        }
        if (!(this instanceof q) || (lVar instanceof q)) {
            return !(this instanceof n) || (lVar instanceof n);
        }
        return false;
    }

    public abstract k f(f fVar);

    public final f[] g(f[] fVarArr) {
        f[] fVarArr2 = new f[fVarArr.length];
        f[] fVarArr3 = new f[fVarArr.length];
        int i10 = 0;
        for (int i11 = 0; i11 < this.f28776b; i11++) {
            fVarArr2[i11] = new f(fVarArr[i11]);
            fVarArr3[i11] = new f(this.f28776b);
            fVarArr3[i11].I((this.f28776b - 1) - i11);
        }
        while (true) {
            int i12 = this.f28776b;
            if (i10 >= i12 - 1) {
                for (int i13 = i12 - 1; i13 > 0; i13--) {
                    for (int i14 = i13 - 1; i14 >= 0; i14--) {
                        if (fVarArr2[i14].U((this.f28776b - 1) - i13)) {
                            fVarArr2[i14].b(fVarArr2[i13]);
                            fVarArr3[i14].b(fVarArr3[i13]);
                        }
                    }
                }
                return fVarArr3;
            }
            int i15 = i10;
            while (true) {
                int i16 = this.f28776b;
                if (i15 >= i16 || fVarArr2[i15].U((i16 - 1) - i10)) {
                    break;
                }
                i15++;
            }
            if (i15 >= this.f28776b) {
                throw new RuntimeException("GF2nField.invertMatrix: Matrix cannot be inverted!");
            }
            if (i10 != i15) {
                f fVar = fVarArr2[i10];
                fVarArr2[i10] = fVarArr2[i15];
                fVarArr2[i15] = fVar;
                f fVar2 = fVarArr3[i10];
                fVarArr3[i10] = fVarArr3[i15];
                fVarArr3[i15] = fVar2;
            }
            int i17 = i10 + 1;
            int i18 = i17;
            while (true) {
                int i19 = this.f28776b;
                if (i18 < i19) {
                    if (fVarArr2[i18].U((i19 - 1) - i10)) {
                        fVarArr2[i18].b(fVarArr2[i10]);
                        fVarArr3[i18].b(fVarArr3[i10]);
                    }
                    i18++;
                }
            }
            i10 = i17;
        }
    }

    public int hashCode() {
        return this.f28776b + this.f28777c.hashCode();
    }
}
