package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import com.blankj.utilcode.util.i0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f2946l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f2947m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f2948n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static float f2949o = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f2952c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2950a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2953d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SolverVariable f2954e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f2955f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f2956g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f2957h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2958i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2959j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2960k = false;

    public a(b bVar, c cVar) {
        this.f2951b = bVar;
        this.f2952c = cVar;
    }

    public int a() {
        return this.f2958i;
    }

    public final int b(int i10) {
        return this.f2955f[i10];
    }

    public final int c(int i10) {
        return this.f2956g[i10];
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void clear() {
        int i10 = this.f2958i;
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            SolverVariable solverVariable = this.f2952c.f2972d[this.f2955f[i10]];
            if (solverVariable != null) {
                solverVariable.i(this.f2951b);
            }
            i10 = this.f2956g[i10];
        }
        this.f2958i = -1;
        this.f2959j = -1;
        this.f2960k = false;
        this.f2950a = 0;
    }

    public SolverVariable d() {
        SolverVariable solverVariable = this.f2954e;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i10 = this.f2958i;
        SolverVariable solverVariable2 = null;
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            if (this.f2957h[i10] < 0.0f) {
                SolverVariable solverVariable3 = this.f2952c.f2972d[this.f2955f[i10]];
                if (solverVariable2 == null || solverVariable2.f2932e < solverVariable3.f2932e) {
                    solverVariable2 = solverVariable3;
                }
            }
            i10 = this.f2956g[i10];
        }
        return solverVariable2;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int e() {
        return this.f2950a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void f() {
        int i10 = this.f2958i;
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            float[] fArr = this.f2957h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f2956g[i10];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public int g(SolverVariable solverVariable) {
        int i10 = this.f2958i;
        if (i10 == -1) {
            return -1;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            if (this.f2955f[i10] == solverVariable.f2930c) {
                return i10;
            }
            i10 = this.f2956g[i10];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void h() {
        int i10 = this.f2950a;
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
        int i10 = this.f2958i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            if (this.f2955f[i10] == solverVariable.f2930c) {
                return true;
            }
            i10 = this.f2956g[i10];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float j(b bVar, boolean z10) {
        float fP = p(bVar.f2963a);
        o(bVar.f2963a, z10);
        b.a aVar = bVar.f2967e;
        int iE = aVar.e();
        for (int i10 = 0; i10 < iE; i10++) {
            SolverVariable solverVariableL = aVar.l(i10);
            m(solverVariableL, aVar.p(solverVariableL) * fP, z10);
        }
        return fP;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void k(SolverVariable solverVariable, float f10) {
        if (f10 == 0.0f) {
            o(solverVariable, true);
            return;
        }
        int i10 = this.f2958i;
        if (i10 == -1) {
            this.f2958i = 0;
            this.f2957h[0] = f10;
            this.f2955f[0] = solverVariable.f2930c;
            this.f2956g[0] = -1;
            solverVariable.f2940m++;
            solverVariable.c(this.f2951b);
            this.f2950a++;
            if (this.f2960k) {
                return;
            }
            int i11 = this.f2959j + 1;
            this.f2959j = i11;
            int[] iArr = this.f2955f;
            if (i11 >= iArr.length) {
                this.f2960k = true;
                this.f2959j = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f2950a; i13++) {
            int[] iArr2 = this.f2955f;
            int i14 = iArr2[i10];
            int i15 = solverVariable.f2930c;
            if (i14 == i15) {
                this.f2957h[i10] = f10;
                return;
            }
            if (iArr2[i10] < i15) {
                i12 = i10;
            }
            i10 = this.f2956g[i10];
        }
        int length = this.f2959j;
        int i16 = length + 1;
        if (this.f2960k) {
            int[] iArr3 = this.f2955f;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i16;
        }
        int[] iArr4 = this.f2955f;
        if (length >= iArr4.length && this.f2950a < iArr4.length) {
            int i17 = 0;
            while (true) {
                int[] iArr5 = this.f2955f;
                if (i17 >= iArr5.length) {
                    break;
                }
                if (iArr5[i17] == -1) {
                    length = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr6 = this.f2955f;
        if (length >= iArr6.length) {
            length = iArr6.length;
            int i18 = this.f2953d * 2;
            this.f2953d = i18;
            this.f2960k = false;
            this.f2959j = length - 1;
            this.f2957h = Arrays.copyOf(this.f2957h, i18);
            this.f2955f = Arrays.copyOf(this.f2955f, this.f2953d);
            this.f2956g = Arrays.copyOf(this.f2956g, this.f2953d);
        }
        this.f2955f[length] = solverVariable.f2930c;
        this.f2957h[length] = f10;
        if (i12 != -1) {
            int[] iArr7 = this.f2956g;
            iArr7[length] = iArr7[i12];
            iArr7[i12] = length;
        } else {
            this.f2956g[length] = this.f2958i;
            this.f2958i = length;
        }
        solverVariable.f2940m++;
        solverVariable.c(this.f2951b);
        int i19 = this.f2950a + 1;
        this.f2950a = i19;
        if (!this.f2960k) {
            this.f2959j++;
        }
        int[] iArr8 = this.f2955f;
        if (i19 >= iArr8.length) {
            this.f2960k = true;
        }
        if (this.f2959j >= iArr8.length) {
            this.f2960k = true;
            this.f2959j = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable l(int i10) {
        int i11 = this.f2958i;
        for (int i12 = 0; i11 != -1 && i12 < this.f2950a; i12++) {
            if (i12 == i10) {
                return this.f2952c.f2972d[this.f2955f[i11]];
            }
            i11 = this.f2956g[i11];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void m(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f2949o;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.f2958i;
            if (i10 == -1) {
                this.f2958i = 0;
                this.f2957h[0] = f10;
                this.f2955f[0] = solverVariable.f2930c;
                this.f2956g[0] = -1;
                solverVariable.f2940m++;
                solverVariable.c(this.f2951b);
                this.f2950a++;
                if (this.f2960k) {
                    return;
                }
                int i11 = this.f2959j + 1;
                this.f2959j = i11;
                int[] iArr = this.f2955f;
                if (i11 >= iArr.length) {
                    this.f2960k = true;
                    this.f2959j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f2950a; i13++) {
                int[] iArr2 = this.f2955f;
                int i14 = iArr2[i10];
                int i15 = solverVariable.f2930c;
                if (i14 == i15) {
                    float[] fArr = this.f2957h;
                    float f12 = fArr[i10] + f10;
                    float f13 = f2949o;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.f2958i) {
                            this.f2958i = this.f2956g[i10];
                        } else {
                            int[] iArr3 = this.f2956g;
                            iArr3[i12] = iArr3[i10];
                        }
                        if (z10) {
                            solverVariable.i(this.f2951b);
                        }
                        if (this.f2960k) {
                            this.f2959j = i10;
                        }
                        solverVariable.f2940m--;
                        this.f2950a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i10] < i15) {
                    i12 = i10;
                }
                i10 = this.f2956g[i10];
            }
            int length = this.f2959j;
            int i16 = length + 1;
            if (this.f2960k) {
                int[] iArr4 = this.f2955f;
                if (iArr4[length] != -1) {
                    length = iArr4.length;
                }
            } else {
                length = i16;
            }
            int[] iArr5 = this.f2955f;
            if (length >= iArr5.length && this.f2950a < iArr5.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr6 = this.f2955f;
                    if (i17 >= iArr6.length) {
                        break;
                    }
                    if (iArr6[i17] == -1) {
                        length = i17;
                        break;
                    }
                    i17++;
                }
            }
            int[] iArr7 = this.f2955f;
            if (length >= iArr7.length) {
                length = iArr7.length;
                int i18 = this.f2953d * 2;
                this.f2953d = i18;
                this.f2960k = false;
                this.f2959j = length - 1;
                this.f2957h = Arrays.copyOf(this.f2957h, i18);
                this.f2955f = Arrays.copyOf(this.f2955f, this.f2953d);
                this.f2956g = Arrays.copyOf(this.f2956g, this.f2953d);
            }
            this.f2955f[length] = solverVariable.f2930c;
            this.f2957h[length] = f10;
            if (i12 != -1) {
                int[] iArr8 = this.f2956g;
                iArr8[length] = iArr8[i12];
                iArr8[i12] = length;
            } else {
                this.f2956g[length] = this.f2958i;
                this.f2958i = length;
            }
            solverVariable.f2940m++;
            solverVariable.c(this.f2951b);
            this.f2950a++;
            if (!this.f2960k) {
                this.f2959j++;
            }
            int i19 = this.f2959j;
            int[] iArr9 = this.f2955f;
            if (i19 >= iArr9.length) {
                this.f2960k = true;
                this.f2959j = iArr9.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float n(int i10) {
        int i11 = this.f2958i;
        for (int i12 = 0; i11 != -1 && i12 < this.f2950a; i12++) {
            if (i12 == i10) {
                return this.f2957h[i11];
            }
            i11 = this.f2956g[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float o(SolverVariable solverVariable, boolean z10) {
        if (this.f2954e == solverVariable) {
            this.f2954e = null;
        }
        int i10 = this.f2958i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f2950a) {
            if (this.f2955f[i10] == solverVariable.f2930c) {
                if (i10 == this.f2958i) {
                    this.f2958i = this.f2956g[i10];
                } else {
                    int[] iArr = this.f2956g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    solverVariable.i(this.f2951b);
                }
                solverVariable.f2940m--;
                this.f2950a--;
                this.f2955f[i10] = -1;
                if (this.f2960k) {
                    this.f2959j = i10;
                }
                return this.f2957h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f2956g[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float p(SolverVariable solverVariable) {
        int i10 = this.f2958i;
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            if (this.f2955f[i10] == solverVariable.f2930c) {
                return this.f2957h[i10];
            }
            i10 = this.f2956g[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int q() {
        return (this.f2955f.length * 4 * 3) + 0 + 36;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void r(float f10) {
        int i10 = this.f2958i;
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            float[] fArr = this.f2957h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f2956g[i10];
        }
    }

    public final float s(int i10) {
        return this.f2957h[i10];
    }

    public boolean t() {
        int i10 = this.f2958i;
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            if (this.f2957h[i10] > 0.0f) {
                return true;
            }
            i10 = this.f2956g[i10];
        }
        return false;
    }

    public String toString() {
        int i10 = this.f2958i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f2950a; i11++) {
            str = ((str + " -> ") + this.f2957h[i10] + " : ") + this.f2952c.f2972d[this.f2955f[i10]];
            i10 = this.f2956g[i10];
        }
        return str;
    }
}
