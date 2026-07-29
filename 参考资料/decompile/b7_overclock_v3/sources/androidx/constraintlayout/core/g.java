package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import com.blankj.utilcode.util.i0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class g implements b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f3016n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f3017o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static float f3018p = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3019a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3020b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3021c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f3022d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f3023e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f3024f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f3025g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f3026h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f3027i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3028j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3029k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f3030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f3031m;

    public g(b bVar, c cVar) {
        this.f3030l = bVar;
        this.f3031m = cVar;
        clear();
    }

    public final void a(SolverVariable solverVariable, int i10) {
        int[] iArr;
        int i11 = solverVariable.f2930c % this.f3021c;
        int[] iArr2 = this.f3022d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f3023e;
                if (iArr[i12] == -1) {
                    break;
                } else {
                    i12 = iArr[i12];
                }
            }
            iArr[i12] = i10;
        }
        this.f3023e[i10] = -1;
    }

    public final void b(int i10, SolverVariable solverVariable, float f10) {
        this.f3024f[i10] = solverVariable.f2930c;
        this.f3025g[i10] = f10;
        this.f3026h[i10] = -1;
        this.f3027i[i10] = -1;
        solverVariable.c(this.f3030l);
        solverVariable.f2940m++;
        this.f3028j++;
    }

    public final void c() {
        for (int i10 = 0; i10 < this.f3021c; i10++) {
            if (this.f3022d[i10] != -1) {
                String str = hashCode() + " hash [" + i10 + "] => ";
                int i11 = this.f3022d[i10];
                boolean z10 = false;
                while (!z10) {
                    str = str + i0.f11861z + this.f3024f[i11];
                    int[] iArr = this.f3023e;
                    if (iArr[i11] != -1) {
                        i11 = iArr[i11];
                    } else {
                        z10 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public void clear() {
        int i10 = this.f3028j;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable solverVariableL = l(i11);
            if (solverVariableL != null) {
                solverVariableL.i(this.f3030l);
            }
        }
        for (int i12 = 0; i12 < this.f3020b; i12++) {
            this.f3024f[i12] = -1;
            this.f3023e[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f3021c; i13++) {
            this.f3022d[i13] = -1;
        }
        this.f3028j = 0;
        this.f3029k = -1;
    }

    public final int d() {
        for (int i10 = 0; i10 < this.f3020b; i10++) {
            if (this.f3024f[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int e() {
        return this.f3028j;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void f() {
        int i10 = this.f3028j;
        int i11 = this.f3029k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f3025g;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f3027i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public int g(SolverVariable solverVariable) {
        int[] iArr;
        if (this.f3028j != 0 && solverVariable != null) {
            int i10 = solverVariable.f2930c;
            int i11 = this.f3022d[i10 % this.f3021c];
            if (i11 == -1) {
                return -1;
            }
            if (this.f3024f[i11] == i10) {
                return i11;
            }
            while (true) {
                iArr = this.f3023e;
                if (iArr[i11] == -1 || this.f3024f[iArr[i11]] == i10) {
                    break;
                }
                i11 = iArr[i11];
            }
            if (iArr[i11] != -1 && this.f3024f[iArr[i11]] == i10) {
                return iArr[i11];
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void h() {
        int i10 = this.f3028j;
        System.out.print("{ ");
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable solverVariableL = l(i11);
            if (solverVariableL != null) {
                System.out.print(solverVariableL + " = " + n(i11) + i0.f11861z);
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean i(SolverVariable solverVariable) {
        return g(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float j(b bVar, boolean z10) {
        float fP = p(bVar.f2963a);
        o(bVar.f2963a, z10);
        g gVar = (g) bVar.f2967e;
        int iE = gVar.e();
        int i10 = 0;
        int i11 = 0;
        while (i10 < iE) {
            int[] iArr = gVar.f3024f;
            if (iArr[i11] != -1) {
                m(this.f3031m.f2972d[iArr[i11]], gVar.f3025g[i11] * fP, z10);
                i10++;
            }
            i11++;
        }
        return fP;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void k(SolverVariable solverVariable, float f10) {
        float f11 = f3018p;
        if (f10 > (-f11) && f10 < f11) {
            o(solverVariable, true);
            return;
        }
        if (this.f3028j == 0) {
            b(0, solverVariable, f10);
            a(solverVariable, 0);
            this.f3029k = 0;
            return;
        }
        int iG = g(solverVariable);
        if (iG != -1) {
            this.f3025g[iG] = f10;
            return;
        }
        if (this.f3028j + 1 >= this.f3020b) {
            s();
        }
        int i10 = this.f3028j;
        int i11 = this.f3029k;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int[] iArr = this.f3024f;
            int i14 = iArr[i11];
            int i15 = solverVariable.f2930c;
            if (i14 == i15) {
                this.f3025g[i11] = f10;
                return;
            }
            if (iArr[i11] < i15) {
                i12 = i11;
            }
            i11 = this.f3027i[i11];
            if (i11 == -1) {
                break;
            }
        }
        t(i12, solverVariable, f10);
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable l(int i10) {
        int i11 = this.f3028j;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f3029k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f3031m.f2972d[this.f3024f[i12]];
            }
            i12 = this.f3027i[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void m(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f3018p;
        if (f10 <= (-f11) || f10 >= f11) {
            int iG = g(solverVariable);
            if (iG == -1) {
                k(solverVariable, f10);
                return;
            }
            float[] fArr = this.f3025g;
            fArr[iG] = fArr[iG] + f10;
            float f12 = fArr[iG];
            float f13 = f3018p;
            if (f12 <= (-f13) || fArr[iG] >= f13) {
                return;
            }
            fArr[iG] = 0.0f;
            o(solverVariable, z10);
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float n(int i10) {
        int i11 = this.f3028j;
        int i12 = this.f3029k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f3025g[i12];
            }
            i12 = this.f3027i[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float o(SolverVariable solverVariable, boolean z10) {
        int iG = g(solverVariable);
        if (iG == -1) {
            return 0.0f;
        }
        u(solverVariable);
        float f10 = this.f3025g[iG];
        if (this.f3029k == iG) {
            this.f3029k = this.f3027i[iG];
        }
        this.f3024f[iG] = -1;
        int[] iArr = this.f3026h;
        if (iArr[iG] != -1) {
            int[] iArr2 = this.f3027i;
            iArr2[iArr[iG]] = iArr2[iG];
        }
        int[] iArr3 = this.f3027i;
        if (iArr3[iG] != -1) {
            iArr[iArr3[iG]] = iArr[iG];
        }
        this.f3028j--;
        solverVariable.f2940m--;
        if (z10) {
            solverVariable.i(this.f3030l);
        }
        return f10;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float p(SolverVariable solverVariable) {
        int iG = g(solverVariable);
        if (iG != -1) {
            return this.f3025g[iG];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int q() {
        return 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void r(float f10) {
        int i10 = this.f3028j;
        int i11 = this.f3029k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f3025g;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f3027i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    public final void s() {
        int i10 = this.f3020b * 2;
        this.f3024f = Arrays.copyOf(this.f3024f, i10);
        this.f3025g = Arrays.copyOf(this.f3025g, i10);
        this.f3026h = Arrays.copyOf(this.f3026h, i10);
        this.f3027i = Arrays.copyOf(this.f3027i, i10);
        this.f3023e = Arrays.copyOf(this.f3023e, i10);
        for (int i11 = this.f3020b; i11 < i10; i11++) {
            this.f3024f[i11] = -1;
            this.f3023e[i11] = -1;
        }
        this.f3020b = i10;
    }

    public final void t(int i10, SolverVariable solverVariable, float f10) {
        int iD = d();
        b(iD, solverVariable, f10);
        if (i10 != -1) {
            this.f3026h[iD] = i10;
            int[] iArr = this.f3027i;
            iArr[iD] = iArr[i10];
            iArr[i10] = iD;
        } else {
            this.f3026h[iD] = -1;
            if (this.f3028j > 0) {
                this.f3027i[iD] = this.f3029k;
                this.f3029k = iD;
            } else {
                this.f3027i[iD] = -1;
            }
        }
        int[] iArr2 = this.f3027i;
        if (iArr2[iD] != -1) {
            this.f3026h[iArr2[iD]] = iD;
        }
        a(solverVariable, iD);
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i10 = this.f3028j;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable solverVariableL = l(i11);
            if (solverVariableL != null) {
                String str2 = str + solverVariableL + " = " + n(i11) + i0.f11861z;
                int iG = g(solverVariableL);
                String str3 = str2 + "[p: ";
                String str4 = (this.f3026h[iG] != -1 ? str3 + this.f3031m.f2972d[this.f3024f[this.f3026h[iG]]] : str3 + "none") + ", n: ";
                str = (this.f3027i[iG] != -1 ? str4 + this.f3031m.f2972d[this.f3024f[this.f3027i[iG]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }

    public final void u(SolverVariable solverVariable) {
        int[] iArr;
        int i10 = solverVariable.f2930c;
        int i11 = i10 % this.f3021c;
        int[] iArr2 = this.f3022d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            return;
        }
        if (this.f3024f[i12] == i10) {
            int[] iArr3 = this.f3023e;
            iArr2[i11] = iArr3[i12];
            iArr3[i12] = -1;
            return;
        }
        while (true) {
            iArr = this.f3023e;
            if (iArr[i12] == -1 || this.f3024f[iArr[i12]] == i10) {
                break;
            } else {
                i12 = iArr[i12];
            }
        }
        int i13 = iArr[i12];
        if (i13 == -1 || this.f3024f[i13] != i10) {
            return;
        }
        iArr[i12] = iArr[i13];
        iArr[i13] = -1;
    }
}
