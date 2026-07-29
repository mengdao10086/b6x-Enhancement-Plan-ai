package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean A = false;
    public static int B = 1000;
    public static s.b C = null;
    public static long D = 0;
    public static long E = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final boolean f2973r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f2974s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f2975t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f2976u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f2977v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f2978w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f2979x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f2980y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f2981z = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f2985d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.constraintlayout.core.b[] f2988g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f2995n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f2998q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2982a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2983b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, SolverVariable> f2984c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2986e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2987f = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2989h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2990i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean[] f2991j = new boolean[32];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2992k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2993l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2994m = 32;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SolverVariable[] f2996o = new SolverVariable[B];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2997p = 0;

    public interface a {
        void a(d dVar, SolverVariable solverVariable, boolean z10);

        void b(d dVar);

        void c(d dVar, androidx.constraintlayout.core.b bVar, boolean z10);

        void clear();

        void d(a aVar);

        SolverVariable e(d dVar, boolean[] zArr);

        void f(SolverVariable solverVariable);

        SolverVariable getKey();

        boolean isEmpty();
    }

    public class b extends androidx.constraintlayout.core.b {
        public b(c cVar) {
            this.f2967e = new g(this, cVar);
        }
    }

    public d() {
        this.f2988g = null;
        this.f2988g = new androidx.constraintlayout.core.b[32];
        W();
        c cVar = new c();
        this.f2995n = cVar;
        this.f2985d = new f(cVar);
        if (A) {
            this.f2998q = new b(cVar);
        } else {
            this.f2998q = new androidx.constraintlayout.core.b(cVar);
        }
    }

    public static s.b L() {
        return C;
    }

    public static androidx.constraintlayout.core.b w(d dVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        return dVar.v().m(solverVariable, solverVariable2, f10);
    }

    public final void A() {
        B();
        String str = "";
        for (int i10 = 0; i10 < this.f2993l; i10++) {
            str = (str + this.f2988g[i10]) + "\n";
        }
        System.out.println(str + this.f2985d + "\n");
    }

    public final void B() {
        System.out.println("Display Rows (" + this.f2993l + "x" + this.f2992k + ")\n");
    }

    public void C() {
        int iE = 0;
        for (int i10 = 0; i10 < this.f2986e; i10++) {
            androidx.constraintlayout.core.b[] bVarArr = this.f2988g;
            if (bVarArr[i10] != null) {
                iE += bVarArr[i10].E();
            }
        }
        int iE2 = 0;
        for (int i11 = 0; i11 < this.f2993l; i11++) {
            androidx.constraintlayout.core.b[] bVarArr2 = this.f2988g;
            if (bVarArr2[i11] != null) {
                iE2 += bVarArr2[i11].E();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Linear System -> Table size: ");
        sb2.append(this.f2986e);
        sb2.append(" (");
        int i12 = this.f2986e;
        sb2.append(H(i12 * i12));
        sb2.append(") -- row sizes: ");
        sb2.append(H(iE));
        sb2.append(", actual size: ");
        sb2.append(H(iE2));
        sb2.append(" rows: ");
        sb2.append(this.f2993l);
        sb2.append(fh.a.f28350w);
        sb2.append(this.f2994m);
        sb2.append(" cols: ");
        sb2.append(this.f2992k);
        sb2.append(fh.a.f28350w);
        sb2.append(this.f2987f);
        sb2.append(i0.f11861z);
        sb2.append(0);
        sb2.append(" occupied cells, ");
        sb2.append(H(0));
        printStream.println(sb2.toString());
    }

    public void D() {
        B();
        String str = "";
        for (int i10 = 0; i10 < this.f2993l; i10++) {
            if (this.f2988g[i10].f2963a.f2937j == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.f2988g[i10].F()) + "\n";
            }
        }
        System.out.println(str + this.f2985d + "\n");
    }

    public final int E(a aVar) throws Exception {
        boolean z10;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f2993l) {
                z10 = false;
                break;
            }
            androidx.constraintlayout.core.b[] bVarArr = this.f2988g;
            if (bVarArr[i10].f2963a.f2937j != SolverVariable.Type.UNRESTRICTED && bVarArr[i10].f2964b < 0.0f) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return 0;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            s.b bVar = C;
            if (bVar != null) {
                bVar.f49260o++;
            }
            i11++;
            float f10 = Float.MAX_VALUE;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            for (int i15 = 0; i15 < this.f2993l; i15++) {
                androidx.constraintlayout.core.b bVar2 = this.f2988g[i15];
                if (bVar2.f2963a.f2937j != SolverVariable.Type.UNRESTRICTED && !bVar2.f2968f && bVar2.f2964b < 0.0f) {
                    int i16 = 9;
                    if (f2981z) {
                        int iE = bVar2.f2967e.e();
                        int i17 = 0;
                        while (i17 < iE) {
                            SolverVariable solverVariableL = bVar2.f2967e.l(i17);
                            float fP = bVar2.f2967e.p(solverVariableL);
                            if (fP > 0.0f) {
                                int i18 = 0;
                                while (i18 < i16) {
                                    float f11 = solverVariableL.f2935h[i18] / fP;
                                    if ((f11 < f10 && i18 == i14) || i18 > i14) {
                                        i13 = solverVariableL.f2930c;
                                        i14 = i18;
                                        i12 = i15;
                                        f10 = f11;
                                    }
                                    i18++;
                                    i16 = 9;
                                }
                            }
                            i17++;
                            i16 = 9;
                        }
                    } else {
                        for (int i19 = 1; i19 < this.f2992k; i19++) {
                            SolverVariable solverVariable = this.f2995n.f2972d[i19];
                            float fP2 = bVar2.f2967e.p(solverVariable);
                            if (fP2 > 0.0f) {
                                for (int i20 = 0; i20 < 9; i20++) {
                                    float f12 = solverVariable.f2935h[i20] / fP2;
                                    if ((f12 < f10 && i20 == i14) || i20 > i14) {
                                        i13 = i19;
                                        i14 = i20;
                                        i12 = i15;
                                        f10 = f12;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i12 != -1) {
                androidx.constraintlayout.core.b bVar3 = this.f2988g[i12];
                bVar3.f2963a.f2931d = -1;
                s.b bVar4 = C;
                if (bVar4 != null) {
                    bVar4.f49259n++;
                }
                bVar3.C(this.f2995n.f2972d[i13]);
                SolverVariable solverVariable2 = bVar3.f2963a;
                solverVariable2.f2931d = i12;
                solverVariable2.p(this, bVar3);
            } else {
                z11 = true;
            }
            if (i11 > this.f2992k / 2) {
                z11 = true;
            }
        }
        return i11;
    }

    public void F(s.b bVar) {
        C = bVar;
    }

    public c G() {
        return this.f2995n;
    }

    public final String H(int i10) {
        int i11 = i10 * 4;
        int i12 = i11 / 1024;
        int i13 = i12 / 1024;
        if (i13 > 0) {
            return "" + i13 + " Mb";
        }
        if (i12 > 0) {
            return "" + i12 + " Kb";
        }
        return "" + i11 + " bytes";
    }

    public final String I(int i10) {
        return i10 == 1 ? "LOW" : i10 == 2 ? "MEDIUM" : i10 == 3 ? "HIGH" : i10 == 4 ? "HIGHEST" : i10 == 5 ? "EQUALITY" : i10 == 8 ? "FIXED" : i10 == 6 ? "BARRIER" : HlsPlaylistParser.M;
    }

    public a J() {
        return this.f2985d;
    }

    public int K() {
        int iE = 0;
        for (int i10 = 0; i10 < this.f2993l; i10++) {
            androidx.constraintlayout.core.b[] bVarArr = this.f2988g;
            if (bVarArr[i10] != null) {
                iE += bVarArr[i10].E();
            }
        }
        return iE;
    }

    public int M() {
        return this.f2993l;
    }

    public int N() {
        return this.f2983b;
    }

    public int O(Object obj) {
        SolverVariable solverVariableJ = ((ConstraintAnchor) obj).j();
        if (solverVariableJ != null) {
            return (int) (solverVariableJ.f2933f + 0.5f);
        }
        return 0;
    }

    public androidx.constraintlayout.core.b P(int i10) {
        return this.f2988g[i10];
    }

    public float Q(String str) {
        SolverVariable solverVariableR = R(str, SolverVariable.Type.UNRESTRICTED);
        if (solverVariableR == null) {
            return 0.0f;
        }
        return solverVariableR.f2933f;
    }

    public SolverVariable R(String str, SolverVariable.Type type) {
        if (this.f2984c == null) {
            this.f2984c = new HashMap<>();
        }
        SolverVariable solverVariable = this.f2984c.get(str);
        return solverVariable == null ? y(str, type) : solverVariable;
    }

    public final void S() {
        int i10 = this.f2986e * 2;
        this.f2986e = i10;
        this.f2988g = (androidx.constraintlayout.core.b[]) Arrays.copyOf(this.f2988g, i10);
        c cVar = this.f2995n;
        cVar.f2972d = (SolverVariable[]) Arrays.copyOf(cVar.f2972d, this.f2986e);
        int i11 = this.f2986e;
        this.f2991j = new boolean[i11];
        this.f2987f = i11;
        this.f2994m = i11;
        s.b bVar = C;
        if (bVar != null) {
            bVar.f49253h++;
            bVar.f49265t = Math.max(bVar.f49265t, i11);
            s.b bVar2 = C;
            bVar2.J = bVar2.f49265t;
        }
    }

    public void T() throws Exception {
        s.b bVar = C;
        if (bVar != null) {
            bVar.f49254i++;
        }
        if (this.f2985d.isEmpty()) {
            r();
            return;
        }
        if (!this.f2989h && !this.f2990i) {
            U(this.f2985d);
            return;
        }
        s.b bVar2 = C;
        if (bVar2 != null) {
            bVar2.f49267v++;
        }
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f2993l) {
                z10 = true;
                break;
            } else if (!this.f2988g[i10].f2968f) {
                break;
            } else {
                i10++;
            }
        }
        if (!z10) {
            U(this.f2985d);
            return;
        }
        s.b bVar3 = C;
        if (bVar3 != null) {
            bVar3.f49266u++;
        }
        r();
    }

    public void U(a aVar) throws Exception {
        s.b bVar = C;
        if (bVar != null) {
            bVar.f49271z++;
            bVar.A = Math.max(bVar.A, this.f2992k);
            s.b bVar2 = C;
            bVar2.B = Math.max(bVar2.B, this.f2993l);
        }
        E(aVar);
        V(aVar, false);
        r();
    }

    public final int V(a aVar, boolean z10) {
        s.b bVar = C;
        if (bVar != null) {
            bVar.f49257l++;
        }
        for (int i10 = 0; i10 < this.f2992k; i10++) {
            this.f2991j[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            s.b bVar2 = C;
            if (bVar2 != null) {
                bVar2.f49258m++;
            }
            i11++;
            if (i11 >= this.f2992k * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f2991j[aVar.getKey().f2930c] = true;
            }
            SolverVariable solverVariableE = aVar.e(this, this.f2991j);
            if (solverVariableE != null) {
                boolean[] zArr = this.f2991j;
                int i12 = solverVariableE.f2930c;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (solverVariableE != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f2993l; i14++) {
                    androidx.constraintlayout.core.b bVar3 = this.f2988g[i14];
                    if (bVar3.f2963a.f2937j != SolverVariable.Type.UNRESTRICTED && !bVar3.f2968f && bVar3.y(solverVariableE)) {
                        float fP = bVar3.f2967e.p(solverVariableE);
                        if (fP < 0.0f) {
                            float f11 = (-bVar3.f2964b) / fP;
                            if (f11 < f10) {
                                i13 = i14;
                                f10 = f11;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    androidx.constraintlayout.core.b bVar4 = this.f2988g[i13];
                    bVar4.f2963a.f2931d = -1;
                    s.b bVar5 = C;
                    if (bVar5 != null) {
                        bVar5.f49259n++;
                    }
                    bVar4.C(solverVariableE);
                    SolverVariable solverVariable = bVar4.f2963a;
                    solverVariable.f2931d = i13;
                    solverVariable.p(this, bVar4);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    public final void W() {
        int i10 = 0;
        if (A) {
            while (i10 < this.f2993l) {
                androidx.constraintlayout.core.b bVar = this.f2988g[i10];
                if (bVar != null) {
                    this.f2995n.f2969a.b(bVar);
                }
                this.f2988g[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f2993l) {
            androidx.constraintlayout.core.b bVar2 = this.f2988g[i10];
            if (bVar2 != null) {
                this.f2995n.f2970b.b(bVar2);
            }
            this.f2988g[i10] = null;
            i10++;
        }
    }

    public void X(androidx.constraintlayout.core.b bVar) {
        SolverVariable solverVariable;
        int i10;
        if (!bVar.f2968f || (solverVariable = bVar.f2963a) == null) {
            return;
        }
        int i11 = solverVariable.f2931d;
        if (i11 != -1) {
            while (true) {
                i10 = this.f2993l;
                if (i11 >= i10 - 1) {
                    break;
                }
                androidx.constraintlayout.core.b[] bVarArr = this.f2988g;
                int i12 = i11 + 1;
                SolverVariable solverVariable2 = bVarArr[i12].f2963a;
                if (solverVariable2.f2931d == i12) {
                    solverVariable2.f2931d = i11;
                }
                bVarArr[i11] = bVarArr[i12];
                i11 = i12;
            }
            this.f2993l = i10 - 1;
        }
        SolverVariable solverVariable3 = bVar.f2963a;
        if (!solverVariable3.f2934g) {
            solverVariable3.k(this, bVar.f2964b);
        }
        if (A) {
            this.f2995n.f2969a.b(bVar);
        } else {
            this.f2995n.f2970b.b(bVar);
        }
    }

    public void Y() {
        c cVar;
        int i10 = 0;
        while (true) {
            cVar = this.f2995n;
            SolverVariable[] solverVariableArr = cVar.f2972d;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.j();
            }
            i10++;
        }
        cVar.f2971c.c(this.f2996o, this.f2997p);
        this.f2997p = 0;
        Arrays.fill(this.f2995n.f2972d, (Object) null);
        HashMap<String, SolverVariable> map = this.f2984c;
        if (map != null) {
            map.clear();
        }
        this.f2983b = 0;
        this.f2985d.clear();
        this.f2992k = 1;
        for (int i11 = 0; i11 < this.f2993l; i11++) {
            androidx.constraintlayout.core.b[] bVarArr = this.f2988g;
            if (bVarArr[i11] != null) {
                bVarArr[i11].f2965c = false;
            }
        }
        W();
        this.f2993l = 0;
        if (A) {
            this.f2998q = new b(this.f2995n);
        } else {
            this.f2998q = new androidx.constraintlayout.core.b(this.f2995n);
        }
    }

    public final SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariableA = this.f2995n.f2971c.a();
        if (solverVariableA == null) {
            solverVariableA = new SolverVariable(type, str);
            solverVariableA.n(type, str);
        } else {
            solverVariableA.j();
            solverVariableA.n(type, str);
        }
        int i10 = this.f2997p;
        int i11 = B;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            B = i12;
            this.f2996o = (SolverVariable[]) Arrays.copyOf(this.f2996o, i12);
        }
        SolverVariable[] solverVariableArr = this.f2996o;
        int i13 = this.f2997p;
        this.f2997p = i13 + 1;
        solverVariableArr[i13] = solverVariableA;
        return solverVariableA;
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableU = u(constraintWidget.r(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableU2 = u(constraintWidget.r(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableU3 = u(constraintWidget.r(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableU4 = u(constraintWidget.r(type4));
        SolverVariable solverVariableU5 = u(constraintWidget2.r(type));
        SolverVariable solverVariableU6 = u(constraintWidget2.r(type2));
        SolverVariable solverVariableU7 = u(constraintWidget2.r(type3));
        SolverVariable solverVariableU8 = u(constraintWidget2.r(type4));
        androidx.constraintlayout.core.b bVarV = v();
        double d10 = f10;
        double d11 = i10;
        bVarV.v(solverVariableU2, solverVariableU4, solverVariableU6, solverVariableU8, (float) (Math.sin(d10) * d11));
        d(bVarV);
        androidx.constraintlayout.core.b bVarV2 = v();
        bVarV2.v(solverVariableU, solverVariableU3, solverVariableU5, solverVariableU7, (float) (Math.cos(d10) * d11));
        d(bVarV2);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        androidx.constraintlayout.core.b bVarV = v();
        bVarV.k(solverVariable, solverVariable2, i10, f10, solverVariable3, solverVariable4, i11);
        if (i12 != 8) {
            bVarV.g(this, i12);
        }
        d(bVarV);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(androidx.constraintlayout.core.b r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L3
            return
        L3:
            s.b r0 = androidx.constraintlayout.core.d.C
            r1 = 1
            if (r0 == 0) goto L17
            long r3 = r0.f49255j
            long r3 = r3 + r1
            r0.f49255j = r3
            boolean r3 = r8.f2968f
            if (r3 == 0) goto L17
            long r3 = r0.f49256k
            long r3 = r3 + r1
            r0.f49256k = r3
        L17:
            int r0 = r7.f2993l
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.f2994m
            if (r0 >= r4) goto L26
            int r0 = r7.f2992k
            int r0 = r0 + r3
            int r4 = r7.f2987f
            if (r0 < r4) goto L29
        L26:
            r7.S()
        L29:
            r0 = 0
            boolean r4 = r8.f2968f
            if (r4 != 0) goto La1
            r8.b(r7)
            boolean r4 = r8.isEmpty()
            if (r4 == 0) goto L38
            return
        L38:
            r8.w()
            boolean r4 = r8.i(r7)
            if (r4 == 0) goto L98
            androidx.constraintlayout.core.SolverVariable r4 = r7.t()
            r8.f2963a = r4
            int r5 = r7.f2993l
            r7.m(r8)
            int r6 = r7.f2993l
            int r5 = r5 + r3
            if (r6 != r5) goto L98
            androidx.constraintlayout.core.d$a r0 = r7.f2998q
            r0.d(r8)
            androidx.constraintlayout.core.d$a r0 = r7.f2998q
            r7.V(r0, r3)
            int r0 = r4.f2931d
            r5 = -1
            if (r0 != r5) goto L99
            androidx.constraintlayout.core.SolverVariable r0 = r8.f2963a
            if (r0 != r4) goto L76
            androidx.constraintlayout.core.SolverVariable r0 = r8.A(r4)
            if (r0 == 0) goto L76
            s.b r4 = androidx.constraintlayout.core.d.C
            if (r4 == 0) goto L73
            long r5 = r4.f49259n
            long r5 = r5 + r1
            r4.f49259n = r5
        L73:
            r8.C(r0)
        L76:
            boolean r0 = r8.f2968f
            if (r0 != 0) goto L7f
            androidx.constraintlayout.core.SolverVariable r0 = r8.f2963a
            r0.p(r7, r8)
        L7f:
            boolean r0 = androidx.constraintlayout.core.d.A
            if (r0 == 0) goto L8b
            androidx.constraintlayout.core.c r0 = r7.f2995n
            androidx.constraintlayout.core.e$a<androidx.constraintlayout.core.b> r0 = r0.f2969a
            r0.b(r8)
            goto L92
        L8b:
            androidx.constraintlayout.core.c r0 = r7.f2995n
            androidx.constraintlayout.core.e$a<androidx.constraintlayout.core.b> r0 = r0.f2970b
            r0.b(r8)
        L92:
            int r0 = r7.f2993l
            int r0 = r0 - r3
            r7.f2993l = r0
            goto L99
        L98:
            r3 = 0
        L99:
            boolean r0 = r8.x()
            if (r0 != 0) goto La0
            return
        La0:
            r0 = r3
        La1:
            if (r0 != 0) goto La6
            r7.m(r8)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.d.d(androidx.constraintlayout.core.b):void");
    }

    public androidx.constraintlayout.core.b e(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        if (f2978w && i11 == 8 && solverVariable2.f2934g && solverVariable.f2931d == -1) {
            solverVariable.k(this, solverVariable2.f2933f + i10);
            return null;
        }
        androidx.constraintlayout.core.b bVarV = v();
        bVarV.r(solverVariable, solverVariable2, i10);
        if (i11 != 8) {
            bVarV.g(this, i11);
        }
        d(bVarV);
        return bVarV;
    }

    public void f(SolverVariable solverVariable, int i10) {
        if (f2978w && solverVariable.f2931d == -1) {
            float f10 = i10;
            solverVariable.k(this, f10);
            for (int i11 = 0; i11 < this.f2983b + 1; i11++) {
                SolverVariable solverVariable2 = this.f2995n.f2972d[i11];
                if (solverVariable2 != null && solverVariable2.f2941n && solverVariable2.f2942o == solverVariable.f2930c) {
                    solverVariable2.k(this, solverVariable2.f2943p + f10);
                }
            }
            return;
        }
        int i12 = solverVariable.f2931d;
        if (i12 == -1) {
            androidx.constraintlayout.core.b bVarV = v();
            bVarV.l(solverVariable, i10);
            d(bVarV);
            return;
        }
        androidx.constraintlayout.core.b bVar = this.f2988g[i12];
        if (bVar.f2968f) {
            bVar.f2964b = i10;
            return;
        }
        if (bVar.f2967e.e() == 0) {
            bVar.f2968f = true;
            bVar.f2964b = i10;
        } else {
            androidx.constraintlayout.core.b bVarV2 = v();
            bVarV2.q(solverVariable, i10);
            d(bVarV2);
        }
    }

    public final void g(androidx.constraintlayout.core.b bVar) {
        bVar.g(this, 0);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        androidx.constraintlayout.core.b bVarV = v();
        SolverVariable solverVariableX = x();
        solverVariableX.f2932e = 0;
        bVarV.t(solverVariable, solverVariable2, solverVariableX, i10);
        d(bVarV);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        androidx.constraintlayout.core.b bVarV = v();
        SolverVariable solverVariableX = x();
        solverVariableX.f2932e = 0;
        bVarV.t(solverVariable, solverVariable2, solverVariableX, i10);
        if (i11 != 8) {
            o(bVarV, (int) (bVarV.f2967e.p(solverVariableX) * (-1.0f)), i11);
        }
        d(bVarV);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        androidx.constraintlayout.core.b bVarV = v();
        SolverVariable solverVariableX = x();
        solverVariableX.f2932e = 0;
        bVarV.u(solverVariable, solverVariable2, solverVariableX, i10);
        d(bVarV);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        androidx.constraintlayout.core.b bVarV = v();
        SolverVariable solverVariableX = x();
        solverVariableX.f2932e = 0;
        bVarV.u(solverVariable, solverVariable2, solverVariableX, i10);
        if (i11 != 8) {
            o(bVarV, (int) (bVarV.f2967e.p(solverVariableX) * (-1.0f)), i11);
        }
        d(bVarV);
    }

    public void l(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10, int i10) {
        androidx.constraintlayout.core.b bVarV = v();
        bVarV.n(solverVariable, solverVariable2, solverVariable3, solverVariable4, f10);
        if (i10 != 8) {
            bVarV.g(this, i10);
        }
        d(bVarV);
    }

    public final void m(androidx.constraintlayout.core.b bVar) {
        int i10;
        if (f2979x && bVar.f2968f) {
            bVar.f2963a.k(this, bVar.f2964b);
        } else {
            androidx.constraintlayout.core.b[] bVarArr = this.f2988g;
            int i11 = this.f2993l;
            bVarArr[i11] = bVar;
            SolverVariable solverVariable = bVar.f2963a;
            solverVariable.f2931d = i11;
            this.f2993l = i11 + 1;
            solverVariable.p(this, bVar);
        }
        if (f2979x && this.f2982a) {
            int i12 = 0;
            while (i12 < this.f2993l) {
                if (this.f2988g[i12] == null) {
                    System.out.println("WTF");
                }
                androidx.constraintlayout.core.b[] bVarArr2 = this.f2988g;
                if (bVarArr2[i12] != null && bVarArr2[i12].f2968f) {
                    androidx.constraintlayout.core.b bVar2 = bVarArr2[i12];
                    bVar2.f2963a.k(this, bVar2.f2964b);
                    if (A) {
                        this.f2995n.f2969a.b(bVar2);
                    } else {
                        this.f2995n.f2970b.b(bVar2);
                    }
                    this.f2988g[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f2993l;
                        if (i13 >= i10) {
                            break;
                        }
                        androidx.constraintlayout.core.b[] bVarArr3 = this.f2988g;
                        int i15 = i13 - 1;
                        bVarArr3[i15] = bVarArr3[i13];
                        if (bVarArr3[i15].f2963a.f2931d == i13) {
                            bVarArr3[i15].f2963a.f2931d = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f2988g[i14] = null;
                    }
                    this.f2993l = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f2982a = false;
        }
    }

    public final void n(androidx.constraintlayout.core.b bVar, int i10) {
        o(bVar, i10, 0);
    }

    public void o(androidx.constraintlayout.core.b bVar, int i10, int i11) {
        bVar.h(s(i11, null), i10);
    }

    public void p(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        if (solverVariable.f2931d != -1 || i10 != 0) {
            e(solverVariable, solverVariable2, i10, 8);
            return;
        }
        if (solverVariable2.f2941n) {
            solverVariable2 = this.f2995n.f2972d[solverVariable2.f2942o];
        }
        if (solverVariable.f2941n) {
            SolverVariable solverVariable3 = this.f2995n.f2972d[solverVariable.f2942o];
        } else {
            solverVariable.m(this, solverVariable2, 0.0f);
        }
    }

    public final void q() {
        int i10;
        int i11 = 0;
        while (i11 < this.f2993l) {
            androidx.constraintlayout.core.b bVar = this.f2988g[i11];
            if (bVar.f2967e.e() == 0) {
                bVar.f2968f = true;
            }
            if (bVar.f2968f) {
                SolverVariable solverVariable = bVar.f2963a;
                solverVariable.f2933f = bVar.f2964b;
                solverVariable.i(bVar);
                int i12 = i11;
                while (true) {
                    i10 = this.f2993l;
                    if (i12 >= i10 - 1) {
                        break;
                    }
                    androidx.constraintlayout.core.b[] bVarArr = this.f2988g;
                    int i13 = i12 + 1;
                    bVarArr[i12] = bVarArr[i13];
                    i12 = i13;
                }
                this.f2988g[i10 - 1] = null;
                this.f2993l = i10 - 1;
                i11--;
                if (A) {
                    this.f2995n.f2969a.b(bVar);
                } else {
                    this.f2995n.f2970b.b(bVar);
                }
            }
            i11++;
        }
    }

    public final void r() {
        for (int i10 = 0; i10 < this.f2993l; i10++) {
            androidx.constraintlayout.core.b bVar = this.f2988g[i10];
            bVar.f2963a.f2933f = bVar.f2964b;
        }
    }

    public SolverVariable s(int i10, String str) {
        s.b bVar = C;
        if (bVar != null) {
            bVar.f49262q++;
        }
        if (this.f2992k + 1 >= this.f2987f) {
            S();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.ERROR, str);
        int i11 = this.f2983b + 1;
        this.f2983b = i11;
        this.f2992k++;
        solverVariableA.f2930c = i11;
        solverVariableA.f2932e = i10;
        this.f2995n.f2972d[i11] = solverVariableA;
        this.f2985d.f(solverVariableA);
        return solverVariableA;
    }

    public SolverVariable t() {
        s.b bVar = C;
        if (bVar != null) {
            bVar.f49264s++;
        }
        if (this.f2992k + 1 >= this.f2987f) {
            S();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f2983b + 1;
        this.f2983b = i10;
        this.f2992k++;
        solverVariableA.f2930c = i10;
        this.f2995n.f2972d[i10] = solverVariableA;
        return solverVariableA;
    }

    public SolverVariable u(Object obj) {
        SolverVariable solverVariableJ = null;
        if (obj == null) {
            return null;
        }
        if (this.f2992k + 1 >= this.f2987f) {
            S();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariableJ = constraintAnchor.j();
            if (solverVariableJ == null) {
                constraintAnchor.z(this.f2995n);
                solverVariableJ = constraintAnchor.j();
            }
            int i10 = solverVariableJ.f2930c;
            if (i10 == -1 || i10 > this.f2983b || this.f2995n.f2972d[i10] == null) {
                if (i10 != -1) {
                    solverVariableJ.j();
                }
                int i11 = this.f2983b + 1;
                this.f2983b = i11;
                this.f2992k++;
                solverVariableJ.f2930c = i11;
                solverVariableJ.f2937j = SolverVariable.Type.UNRESTRICTED;
                this.f2995n.f2972d[i11] = solverVariableJ;
            }
        }
        return solverVariableJ;
    }

    public androidx.constraintlayout.core.b v() {
        androidx.constraintlayout.core.b bVarA;
        if (A) {
            bVarA = this.f2995n.f2969a.a();
            if (bVarA == null) {
                bVarA = new b(this.f2995n);
                E++;
            } else {
                bVarA.D();
            }
        } else {
            bVarA = this.f2995n.f2970b.a();
            if (bVarA == null) {
                bVarA = new androidx.constraintlayout.core.b(this.f2995n);
                D++;
            } else {
                bVarA.D();
            }
        }
        SolverVariable.h();
        return bVarA;
    }

    public SolverVariable x() {
        s.b bVar = C;
        if (bVar != null) {
            bVar.f49263r++;
        }
        if (this.f2992k + 1 >= this.f2987f) {
            S();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f2983b + 1;
        this.f2983b = i10;
        this.f2992k++;
        solverVariableA.f2930c = i10;
        this.f2995n.f2972d[i10] = solverVariableA;
        return solverVariableA;
    }

    public final SolverVariable y(String str, SolverVariable.Type type) {
        s.b bVar = C;
        if (bVar != null) {
            bVar.f49261p++;
        }
        if (this.f2992k + 1 >= this.f2987f) {
            S();
        }
        SolverVariable solverVariableA = a(type, null);
        solverVariableA.l(str);
        int i10 = this.f2983b + 1;
        this.f2983b = i10;
        this.f2992k++;
        solverVariableA.f2930c = i10;
        if (this.f2984c == null) {
            this.f2984c = new HashMap<>();
        }
        this.f2984c.put(str, solverVariableA);
        this.f2995n.f2972d[this.f2983b] = solverVariableA;
        return solverVariableA;
    }

    public void z() {
        B();
        String str = " num vars " + this.f2983b + "\n";
        for (int i10 = 0; i10 < this.f2983b + 1; i10++) {
            SolverVariable solverVariable = this.f2995n.f2972d[i10];
            if (solverVariable != null && solverVariable.f2934g) {
                str = str + " $[" + i10 + "] => " + solverVariable + " = " + solverVariable.f2933f + "\n";
            }
        }
        String str2 = str + "\n";
        for (int i11 = 0; i11 < this.f2983b + 1; i11++) {
            SolverVariable[] solverVariableArr = this.f2995n.f2972d;
            SolverVariable solverVariable2 = solverVariableArr[i11];
            if (solverVariable2 != null && solverVariable2.f2941n) {
                str2 = str2 + " ~[" + i11 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.f2942o] + " + " + solverVariable2.f2943p + "\n";
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i12 = 0; i12 < this.f2993l; i12++) {
            str3 = (str3 + this.f2988g[i12].F()) + "\n #  ";
        }
        if (this.f2985d != null) {
            str3 = str3 + "Goal: " + this.f2985d + "\n";
        }
        System.out.println(str3);
    }
}
