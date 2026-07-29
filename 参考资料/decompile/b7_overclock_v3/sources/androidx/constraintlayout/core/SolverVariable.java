package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    public static final int A = 7;
    public static final int B = 8;
    public static int C = 1;
    public static int D = 1;
    public static int K0 = 1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static int f2916k0 = 1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static int f2917k1 = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final boolean f2918r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f2919s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f2920t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f2921u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f2922v = 2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f2923v1 = 9;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f2924w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f2925x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f2926y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f2927z = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f2935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f2936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Type f2937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b[] f2938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashSet<b> f2944q;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2945a;

        static {
            int[] iArr = new int[Type.values().length];
            f2945a = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2945a[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2945a[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2945a[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2945a[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public SolverVariable(String str, Type type) {
        this.f2930c = -1;
        this.f2931d = -1;
        this.f2932e = 0;
        this.f2934g = false;
        this.f2935h = new float[9];
        this.f2936i = new float[9];
        this.f2938k = new b[16];
        this.f2939l = 0;
        this.f2940m = 0;
        this.f2941n = false;
        this.f2942o = -1;
        this.f2943p = 0.0f;
        this.f2944q = null;
        this.f2929b = str;
        this.f2937j = type;
    }

    public static String g(Type type, String str) {
        if (str != null) {
            return str + D;
        }
        int i10 = a.f2945a[type.ordinal()];
        if (i10 == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("U");
            int i11 = f2916k0 + 1;
            f2916k0 = i11;
            sb2.append(i11);
            return sb2.toString();
        }
        if (i10 == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("C");
            int i12 = K0 + 1;
            K0 = i12;
            sb3.append(i12);
            return sb3.toString();
        }
        if (i10 == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(i1.a.R4);
            int i13 = C + 1;
            C = i13;
            sb4.append(i13);
            return sb4.toString();
        }
        if (i10 == 4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("e");
            int i14 = D + 1;
            D = i14;
            sb5.append(i14);
            return sb5.toString();
        }
        if (i10 != 5) {
            throw new AssertionError(type.name());
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(i1.a.X4);
        int i15 = f2917k1 + 1;
        f2917k1 = i15;
        sb6.append(i15);
        return sb6.toString();
    }

    public static void h() {
        D++;
    }

    public final void c(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f2939l;
            if (i10 >= i11) {
                b[] bVarArr = this.f2938k;
                if (i11 >= bVarArr.length) {
                    this.f2938k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f2938k;
                int i12 = this.f2939l;
                bVarArr2[i12] = bVar;
                this.f2939l = i12 + 1;
                return;
            }
            if (this.f2938k[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    public void d() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.f2935h[i10] = 0.0f;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(SolverVariable solverVariable) {
        return this.f2930c - solverVariable.f2930c;
    }

    public String f() {
        return this.f2929b;
    }

    public final void i(b bVar) {
        int i10 = this.f2939l;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f2938k[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f2938k;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f2939l--;
                return;
            }
            i11++;
        }
    }

    public void j() {
        this.f2929b = null;
        this.f2937j = Type.UNKNOWN;
        this.f2932e = 0;
        this.f2930c = -1;
        this.f2931d = -1;
        this.f2933f = 0.0f;
        this.f2934g = false;
        this.f2941n = false;
        this.f2942o = -1;
        this.f2943p = 0.0f;
        int i10 = this.f2939l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f2938k[i11] = null;
        }
        this.f2939l = 0;
        this.f2940m = 0;
        this.f2928a = false;
        Arrays.fill(this.f2936i, 0.0f);
    }

    public void k(d dVar, float f10) {
        this.f2933f = f10;
        this.f2934g = true;
        this.f2941n = false;
        this.f2942o = -1;
        this.f2943p = 0.0f;
        int i10 = this.f2939l;
        this.f2931d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f2938k[i11].a(dVar, this, false);
        }
        this.f2939l = 0;
    }

    public void l(String str) {
        this.f2929b = str;
    }

    public void m(d dVar, SolverVariable solverVariable, float f10) {
        this.f2941n = true;
        this.f2942o = solverVariable.f2930c;
        this.f2943p = f10;
        int i10 = this.f2939l;
        this.f2931d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f2938k[i11].G(dVar, this, false);
        }
        this.f2939l = 0;
        dVar.z();
    }

    public void n(Type type, String str) {
        this.f2937j = type;
    }

    public String o() {
        String str = this + "[";
        boolean z10 = false;
        boolean z11 = true;
        for (int i10 = 0; i10 < this.f2935h.length; i10++) {
            String str2 = str + this.f2935h[i10];
            float[] fArr = this.f2935h;
            if (fArr[i10] > 0.0f) {
                z10 = false;
            } else if (fArr[i10] < 0.0f) {
                z10 = true;
            }
            if (fArr[i10] != 0.0f) {
                z11 = false;
            }
            str = i10 < fArr.length - 1 ? str2 + ", " : str2 + "] ";
        }
        if (z10) {
            str = str + " (-)";
        }
        if (!z11) {
            return str;
        }
        return str + " (*)";
    }

    public final void p(d dVar, b bVar) {
        int i10 = this.f2939l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f2938k[i11].c(dVar, bVar, false);
        }
        this.f2939l = 0;
    }

    public String toString() {
        if (this.f2929b != null) {
            return "" + this.f2929b;
        }
        return "" + this.f2930c;
    }

    public SolverVariable(Type type, String str) {
        this.f2930c = -1;
        this.f2931d = -1;
        this.f2932e = 0;
        this.f2934g = false;
        this.f2935h = new float[9];
        this.f2936i = new float[9];
        this.f2938k = new b[16];
        this.f2939l = 0;
        this.f2940m = 0;
        this.f2941n = false;
        this.f2942o = -1;
        this.f2943p = 0.0f;
        this.f2944q = null;
        this.f2937j = type;
    }
}
