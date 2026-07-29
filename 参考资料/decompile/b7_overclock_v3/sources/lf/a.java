package lf;

import com.google.zxing.ChecksumException;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f39753a = b.f39754f;

    public int a(int[] iArr, int i10, int[] iArr2) throws ChecksumException {
        c cVar = new c(this.f39753a, iArr);
        int[] iArr3 = new int[i10];
        boolean z10 = false;
        for (int i11 = i10; i11 > 0; i11--) {
            int iB = cVar.b(this.f39753a.c(i11));
            iArr3[i10 - i11] = iB;
            if (iB != 0) {
                z10 = true;
            }
        }
        if (!z10) {
            return 0;
        }
        c cVarD = this.f39753a.d();
        if (iArr2 != null) {
            for (int i12 : iArr2) {
                int iC = this.f39753a.c((iArr.length - 1) - i12);
                b bVar = this.f39753a;
                cVarD = cVarD.h(new c(bVar, new int[]{bVar.j(0, iC), 1}));
            }
        }
        c[] cVarArrD = d(this.f39753a.b(i10, 1), new c(this.f39753a, iArr3), i10);
        c cVar2 = cVarArrD[0];
        c cVar3 = cVarArrD[1];
        int[] iArrB = b(cVar2);
        int[] iArrC = c(cVar3, cVar2, iArrB);
        for (int i13 = 0; i13 < iArrB.length; i13++) {
            int length = (iArr.length - 1) - this.f39753a.h(iArrB[i13]);
            if (length < 0) {
                throw ChecksumException.b();
            }
            iArr[length] = this.f39753a.j(iArr[length], iArrC[i13]);
        }
        return iArrB.length;
    }

    public final int[] b(c cVar) throws ChecksumException {
        int iE = cVar.e();
        int[] iArr = new int[iE];
        int i10 = 0;
        for (int i11 = 1; i11 < this.f39753a.e() && i10 < iE; i11++) {
            if (cVar.b(i11) == 0) {
                iArr[i10] = this.f39753a.g(i11);
                i10++;
            }
        }
        if (i10 == iE) {
            return iArr;
        }
        throw ChecksumException.b();
    }

    public final int[] c(c cVar, c cVar2, int[] iArr) {
        int iE = cVar2.e();
        if (iE < 1) {
            return new int[0];
        }
        int[] iArr2 = new int[iE];
        for (int i10 = 1; i10 <= iE; i10++) {
            iArr2[iE - i10] = this.f39753a.i(i10, cVar2.c(i10));
        }
        c cVar3 = new c(this.f39753a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            int iG = this.f39753a.g(iArr[i11]);
            iArr3[i11] = this.f39753a.i(this.f39753a.j(0, cVar.b(iG)), this.f39753a.g(cVar3.b(iG)));
        }
        return iArr3;
    }

    public final c[] d(c cVar, c cVar2, int i10) throws ChecksumException {
        if (cVar.e() < cVar2.e()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c cVarF = this.f39753a.f();
        c cVarD = this.f39753a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = cVarD;
            c cVar5 = cVarF;
            cVarF = cVar4;
            if (cVar.e() < i10 / 2) {
                int iC = cVarF.c(0);
                if (iC == 0) {
                    throw ChecksumException.b();
                }
                int iG = this.f39753a.g(iC);
                return new c[]{cVarF.g(iG), cVar.g(iG)};
            }
            if (cVar.f()) {
                throw ChecksumException.b();
            }
            c cVarF2 = this.f39753a.f();
            int iG2 = this.f39753a.g(cVar.c(cVar.e()));
            while (cVar2.e() >= cVar.e() && !cVar2.f()) {
                int iE = cVar2.e() - cVar.e();
                int i11 = this.f39753a.i(cVar2.c(cVar2.e()), iG2);
                cVarF2 = cVarF2.a(this.f39753a.b(iE, i11));
                cVar2 = cVar2.k(cVar.i(iE, i11));
            }
            cVarD = cVarF2.h(cVarF).k(cVar5).j();
        }
    }
}
