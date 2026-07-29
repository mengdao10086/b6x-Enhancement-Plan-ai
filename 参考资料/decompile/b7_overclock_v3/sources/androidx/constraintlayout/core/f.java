package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import com.blankj.utilcode.util.i0;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class f extends androidx.constraintlayout.core.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f3003o = 1.0E-4f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f3004p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3005q = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SolverVariable[] f3007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SolverVariable[] f3008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f3010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f3011n;

    public class a implements Comparator<SolverVariable> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f2930c - solverVariable2.f2930c;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SolverVariable f3013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f3014b;

        public b(f fVar) {
            this.f3014b = fVar;
        }

        public void a(SolverVariable solverVariable) {
            for (int i10 = 0; i10 < 9; i10++) {
                float[] fArr = this.f3013a.f2936i;
                fArr[i10] = fArr[i10] + solverVariable.f2936i[i10];
                if (Math.abs(fArr[i10]) < 1.0E-4f) {
                    this.f3013a.f2936i[i10] = 0.0f;
                }
            }
        }

        public boolean b(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (!this.f3013a.f2928a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = solverVariable.f2936i[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.f3013a.f2936i[i10] = f12;
                    } else {
                        this.f3013a.f2936i[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f3013a.f2936i;
                fArr[i11] = fArr[i11] + (solverVariable.f2936i[i11] * f10);
                if (Math.abs(fArr[i11]) < 1.0E-4f) {
                    this.f3013a.f2936i[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                f.this.J(this.f3013a);
            }
            return false;
        }

        public void c(SolverVariable solverVariable) {
            this.f3013a = solverVariable;
        }

        public final boolean d() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f3013a.f2936i[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean e() {
            for (int i10 = 0; i10 < 9; i10++) {
                if (this.f3013a.f2936i[i10] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean f(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = solverVariable.f2936i[i10];
                float f11 = this.f3013a.f2936i[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void g() {
            Arrays.fill(this.f3013a.f2936i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f3013a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f3013a.f2936i[i10] + i0.f11861z;
                }
            }
            return str + "] " + this.f3013a;
        }
    }

    public f(c cVar) {
        super(cVar);
        this.f3006i = 128;
        this.f3007j = new SolverVariable[128];
        this.f3008k = new SolverVariable[128];
        this.f3009l = 0;
        this.f3010m = new b(this);
        this.f3011n = cVar;
    }

    public final void I(SolverVariable solverVariable) {
        int i10;
        int i11 = this.f3009l + 1;
        SolverVariable[] solverVariableArr = this.f3007j;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f3007j = solverVariableArr2;
            this.f3008k = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f3007j;
        int i12 = this.f3009l;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.f3009l = i13;
        if (i13 > 1 && solverVariableArr3[i13 - 1].f2930c > solverVariable.f2930c) {
            int i14 = 0;
            while (true) {
                i10 = this.f3009l;
                if (i14 >= i10) {
                    break;
                }
                this.f3008k[i14] = this.f3007j[i14];
                i14++;
            }
            Arrays.sort(this.f3008k, 0, i10, new a());
            for (int i15 = 0; i15 < this.f3009l; i15++) {
                this.f3007j[i15] = this.f3008k[i15];
            }
        }
        solverVariable.f2928a = true;
        solverVariable.c(this);
    }

    public final void J(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.f3009l) {
            if (this.f3007j[i10] == solverVariable) {
                while (true) {
                    int i11 = this.f3009l;
                    if (i10 >= i11 - 1) {
                        this.f3009l = i11 - 1;
                        solverVariable.f2928a = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.f3007j;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void c(d dVar, androidx.constraintlayout.core.b bVar, boolean z10) {
        SolverVariable solverVariable = bVar.f2963a;
        if (solverVariable == null) {
            return;
        }
        b.a aVar = bVar.f2967e;
        int iE = aVar.e();
        for (int i10 = 0; i10 < iE; i10++) {
            SolverVariable solverVariableL = aVar.l(i10);
            float fN = aVar.n(i10);
            this.f3010m.c(solverVariableL);
            if (this.f3010m.b(solverVariable, fN)) {
                I(solverVariableL);
            }
            this.f2964b += bVar.f2964b * fN;
        }
        J(solverVariable);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void clear() {
        this.f3009l = 0;
        this.f2964b = 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.constraintlayout.core.SolverVariable e(androidx.constraintlayout.core.d r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = -1
        L3:
            int r2 = r4.f3009l
            if (r0 >= r2) goto L32
            androidx.constraintlayout.core.SolverVariable[] r2 = r4.f3007j
            r2 = r2[r0]
            int r3 = r2.f2930c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            androidx.constraintlayout.core.f$b r3 = r4.f3010m
            r3.c(r2)
            if (r1 != r5) goto L22
            androidx.constraintlayout.core.f$b r2 = r4.f3010m
            boolean r2 = r2.d()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            androidx.constraintlayout.core.f$b r2 = r4.f3010m
            androidx.constraintlayout.core.SolverVariable[] r3 = r4.f3007j
            r3 = r3[r1]
            boolean r2 = r2.f(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r5 = 0
            return r5
        L36:
            androidx.constraintlayout.core.SolverVariable[] r5 = r4.f3007j
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.f.e(androidx.constraintlayout.core.d, boolean[]):androidx.constraintlayout.core.SolverVariable");
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void f(SolverVariable solverVariable) {
        this.f3010m.c(solverVariable);
        this.f3010m.g();
        solverVariable.f2936i[solverVariable.f2932e] = 1.0f;
        I(solverVariable);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.f3009l == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public String toString() {
        String str = " goal -> (" + this.f2964b + ") : ";
        for (int i10 = 0; i10 < this.f3009l; i10++) {
            this.f3010m.c(this.f3007j[i10]);
            str = str + this.f3010m + i0.f11861z;
        }
        return str;
    }
}
