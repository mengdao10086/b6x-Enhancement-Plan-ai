package ft;

import java.lang.reflect.Array;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public final class s {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f28801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f28802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public x f28803c;

        public a(e eVar, e eVar2, x xVar) {
            this.f28801a = eVar;
            this.f28802b = eVar2;
            this.f28803c = xVar;
        }

        public e a() {
            return this.f28801a;
        }

        public x b() {
            return this.f28803c;
        }

        public e c() {
            return this.f28802b;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f28804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f28805b;

        public b(e eVar, int[] iArr) {
            this.f28804a = eVar;
            this.f28805b = iArr;
        }

        public e a() {
            return this.f28804a;
        }

        public int[] b() {
            return this.f28805b;
        }
    }

    public static a a(e eVar, SecureRandom secureRandom) {
        x xVar;
        e eVar2;
        e eVarV;
        boolean z10;
        int iC = eVar.c();
        e eVar3 = null;
        do {
            xVar = new x(iC, secureRandom);
            eVar2 = (e) eVar.h(xVar);
            eVarV = eVar2.v();
            z10 = true;
            try {
                eVar3 = (e) eVarV.a();
            } catch (ArithmeticException unused) {
                z10 = false;
            }
        } while (!z10);
        return new a(eVarV, ((e) eVar3.g(eVar2)).x(), xVar);
    }

    public static e b(h hVar, y yVar) {
        int iD = hVar.d();
        int i10 = 1 << iD;
        int iN = yVar.n();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, iN, i10);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, iN, i10);
        for (int i11 = 0; i11 < i10; i11++) {
            iArr2[0][i11] = hVar.j(yVar.j(i11));
        }
        for (int i12 = 1; i12 < iN; i12++) {
            for (int i13 = 0; i13 < i10; i13++) {
                iArr2[i12][i13] = hVar.l(iArr2[i12 - 1][i13], i13);
            }
        }
        for (int i14 = 0; i14 < iN; i14++) {
            for (int i15 = 0; i15 < i10; i15++) {
                for (int i16 = 0; i16 <= i14; i16++) {
                    iArr[i14][i15] = hVar.a(iArr[i14][i15], hVar.l(iArr2[i16][i15], yVar.m((iN + i16) - i14)));
                }
            }
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) int.class, iN * iD, (i10 + 31) >>> 5);
        for (int i17 = 0; i17 < i10; i17++) {
            int i18 = i17 >>> 5;
            int i19 = 1 << (i17 & 31);
            for (int i20 = 0; i20 < iN; i20++) {
                int i21 = iArr[i20][i17];
                for (int i22 = 0; i22 < iD; i22++) {
                    if (((i21 >>> i22) & 1) != 0) {
                        int[] iArr4 = iArr3[(((i20 + 1) * iD) - i22) - 1];
                        iArr4[i18] = iArr4[i18] ^ i19;
                    }
                }
            }
        }
        return new e(i10, iArr3);
    }

    public static g c(g gVar, h hVar, y yVar, y[] yVarArr) {
        int iD = 1 << hVar.d();
        g gVar2 = new g(iD);
        if (!gVar.d()) {
            y[] yVarArrA = new y(gVar.n(hVar)).x(yVar).c(1).D(yVarArr).A(yVar);
            y yVarA = yVarArrA[0].J(yVarArrA[0]).a(yVarArrA[1].J(yVarArrA[1]).H(1));
            y yVarF = yVarA.F(hVar.j(yVarA.p()));
            for (int i10 = 0; i10 < iD; i10++) {
                if (yVarF.j(i10) == 0) {
                    gVar2.m(i10);
                }
            }
        }
        return gVar2;
    }
}
