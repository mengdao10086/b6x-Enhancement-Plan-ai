package rr;

/* JADX INFO: loaded from: classes6.dex */
public abstract class k {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        g.A(iArr, iArr2, iArr3);
        g.z(iArr, 6, iArr2, 6, iArr3, 12);
        int iE = g.e(iArr3, 6, iArr3, 12);
        int iC = iE + g.c(iArr3, 18, iArr3, 12, g.c(iArr3, 0, iArr3, 6, 0) + iE);
        int[] iArrJ = g.j();
        int[] iArrJ2 = g.j();
        boolean z10 = g.n(iArr, 6, iArr, 0, iArrJ, 0) != g.n(iArr2, 6, iArr2, 0, iArrJ2, 0);
        int[] iArrL = g.l();
        g.A(iArrJ, iArrJ2, iArrL);
        o.p(24, iC + (z10 ? o.l(12, iArrL, 0, iArr3, 6) : o.a1(12, iArrL, 0, iArr3, 6)), iArr3, 18);
    }

    public static void b(int[] iArr, int[] iArr2) {
        g.K(iArr, iArr2);
        g.J(iArr, 6, iArr2, 12);
        int iE = g.e(iArr2, 6, iArr2, 12);
        int iC = iE + g.c(iArr2, 18, iArr2, 12, g.c(iArr2, 0, iArr2, 6, 0) + iE);
        int[] iArrJ = g.j();
        g.n(iArr, 6, iArr, 0, iArrJ, 0);
        int[] iArrL = g.l();
        g.K(iArrJ, iArrL);
        o.p(24, iC + o.a1(12, iArrL, 0, iArr2, 6), iArr2, 18);
    }
}
