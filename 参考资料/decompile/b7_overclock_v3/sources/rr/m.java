package rr;

/* JADX INFO: loaded from: classes6.dex */
public abstract class m {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        i.C(iArr, iArr2, iArr3);
        i.B(iArr, 8, iArr2, 8, iArr3, 16);
        int iG = i.g(iArr3, 8, iArr3, 16);
        int iE = iG + i.e(iArr3, 24, iArr3, 16, i.e(iArr3, 0, iArr3, 8, 0) + iG);
        int[] iArrL = i.l();
        int[] iArrL2 = i.l();
        boolean z10 = i.p(iArr, 8, iArr, 0, iArrL, 0) != i.p(iArr2, 8, iArr2, 0, iArrL2, 0);
        int[] iArrN = i.n();
        i.C(iArrL, iArrL2, iArrN);
        o.p(32, iE + (z10 ? o.l(16, iArrN, 0, iArr3, 8) : o.a1(16, iArrN, 0, iArr3, 8)), iArr3, 24);
    }

    public static void b(int[] iArr, int[] iArr2) {
        i.O(iArr, iArr2);
        i.N(iArr, 8, iArr2, 16);
        int iG = i.g(iArr2, 8, iArr2, 16);
        int iE = iG + i.e(iArr2, 24, iArr2, 16, i.e(iArr2, 0, iArr2, 8, 0) + iG);
        int[] iArrL = i.l();
        i.p(iArr, 8, iArr, 0, iArrL, 0);
        int[] iArrN = i.n();
        i.O(iArrL, iArrN);
        o.p(32, iE + o.a1(16, iArrN, 0, iArr2, 8), iArr2, 24);
    }
}
