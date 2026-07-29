package ft;

/* JADX INFO: loaded from: classes6.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f28750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f28751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y[] f28752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y[] f28753d;

    public a0(h hVar, y yVar) {
        this.f28750a = hVar;
        this.f28751b = yVar;
        b();
        a();
    }

    public static void e(y[] yVarArr, int i10, int i11) {
        y yVar = yVarArr[i10];
        yVarArr[i10] = yVarArr[i11];
        yVarArr[i11] = yVar;
    }

    public final void a() {
        int iM;
        int iN = this.f28751b.n();
        y[] yVarArr = new y[iN];
        int i10 = iN - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            yVarArr[i11] = new y(this.f28752c[i11]);
        }
        this.f28753d = new y[iN];
        while (i10 >= 0) {
            this.f28753d[i10] = new y(this.f28750a, i10);
            i10--;
        }
        for (int i12 = 0; i12 < iN; i12++) {
            if (yVarArr[i12].m(i12) == 0) {
                int i13 = i12 + 1;
                boolean z10 = false;
                while (i13 < iN) {
                    if (yVarArr[i13].m(i12) != 0) {
                        e(yVarArr, i12, i13);
                        e(this.f28753d, i12, i13);
                        i13 = iN;
                        z10 = true;
                    }
                    i13++;
                }
                if (!z10) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int iJ = this.f28750a.j(yVarArr[i12].m(i12));
            yVarArr[i12].E(iJ);
            this.f28753d[i12].E(iJ);
            for (int i14 = 0; i14 < iN; i14++) {
                if (i14 != i12 && (iM = yVarArr[i14].m(i12)) != 0) {
                    y yVarF = yVarArr[i12].F(iM);
                    y yVarF2 = this.f28753d[i12].F(iM);
                    yVarArr[i14].d(yVarF);
                    this.f28753d[i14].d(yVarF2);
                }
            }
        }
    }

    public final void b() {
        int i10;
        int iN = this.f28751b.n();
        this.f28752c = new y[iN];
        int i11 = 0;
        while (true) {
            i10 = iN >> 1;
            if (i11 >= i10) {
                break;
            }
            int i12 = i11 << 1;
            int[] iArr = new int[i12 + 1];
            iArr[i12] = 1;
            this.f28752c[i11] = new y(this.f28750a, iArr);
            i11++;
        }
        while (i10 < iN) {
            int i13 = i10 << 1;
            int[] iArr2 = new int[i13 + 1];
            iArr2[i13] = 1;
            this.f28752c[i10] = new y(this.f28750a, iArr2).t(this.f28751b);
            i10++;
        }
    }

    public y[] c() {
        return this.f28753d;
    }

    public y[] d() {
        return this.f28752c;
    }
}
