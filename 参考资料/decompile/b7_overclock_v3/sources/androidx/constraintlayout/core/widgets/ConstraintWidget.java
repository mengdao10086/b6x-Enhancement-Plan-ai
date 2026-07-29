package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.o;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.k;
import androidx.constraintlayout.core.widgets.analyzer.m;
import com.blankj.utilcode.util.i0;
import com.bumptech.glide.load.engine.GlideException;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ConstraintWidget {
    public static final boolean U0 = false;
    public static final int V0 = 1;
    public static final int W0 = 2;
    public static final boolean X0 = false;
    public static final int Y0 = 0;
    public static final int Z0 = 1;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final int f3209a1 = 2;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final int f3210b1 = 3;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final int f3211c1 = 4;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final int f3212d1 = -1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final int f3213e1 = 0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final int f3214f1 = 1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final int f3215g1 = 2;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final int f3216h1 = 0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final int f3217i1 = 4;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final int f3218j1 = 8;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f3219k1 = 0;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final int f3220l1 = 1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final int f3221m1 = 2;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final int f3222n1 = 0;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final int f3223o1 = 1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final int f3224p1 = 2;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final int f3225q1 = 3;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final int f3226r1 = -2;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final int f3227s1 = 0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final int f3228t1 = 1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final int f3229u1 = 2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f3230v1 = 3;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final int f3231w1 = 4;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final int f3232x1 = 0;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final int f3233y1 = 1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static float f3234z1 = 0.5f;
    public int A;
    public int A0;
    public float B;
    public int B0;
    public int C;
    public boolean C0;
    public int D;
    public boolean D0;
    public float E;
    public boolean E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public boolean G0;
    public int H;
    public boolean H0;
    public float I;
    public boolean I0;
    public int[] J;
    public int J0;
    public float K;
    public int K0;
    public boolean L;
    public boolean L0;
    public boolean M;
    public boolean M0;
    public boolean N;
    public float[] N0;
    public int O;
    public ConstraintWidget[] O0;
    public int P;
    public ConstraintWidget[] P0;
    public ConstraintAnchor Q;
    public ConstraintWidget Q0;
    public ConstraintAnchor R;
    public ConstraintWidget R0;
    public ConstraintAnchor S;
    public int S0;
    public ConstraintAnchor T;
    public int T0;
    public ConstraintAnchor U;
    public ConstraintAnchor V;
    public ConstraintAnchor W;
    public ConstraintAnchor X;
    public ConstraintAnchor[] Y;
    public ArrayList<ConstraintAnchor> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3235a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean[] f3236a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WidgetRun[] f3237b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public DimensionBehaviour[] f3238b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f3239c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ConstraintWidget f3240c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f3241d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f3242d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f3243e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f3244e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f3245f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f3246f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f3247g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f3248g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3249h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f3250h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3251i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f3252i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3253j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f3254j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3255k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f3256k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3257l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f3258l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3259m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f3260m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f3261n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f3262n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f3263o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f3264o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3265p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f3266p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3267q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f3268q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3269r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f3270r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3271s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Object f3272s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3273t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f3274t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3275u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f3276u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3277v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f3278v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3279w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f3280w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3281x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f3282x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f3283y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f3284y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3285z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f3286z0;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3288b;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f3288b = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3288b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3288b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3288b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f3287a = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3287a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3287a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3287a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3287a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3287a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3287a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3287a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3287a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public ConstraintWidget() {
        this.f3235a = false;
        this.f3237b = new WidgetRun[2];
        this.f3243e = null;
        this.f3245f = null;
        this.f3247g = new boolean[]{true, true};
        this.f3249h = false;
        this.f3251i = true;
        this.f3253j = false;
        this.f3255k = true;
        this.f3257l = -1;
        this.f3259m = -1;
        this.f3261n = new o(this);
        this.f3265p = false;
        this.f3267q = false;
        this.f3269r = false;
        this.f3271s = false;
        this.f3273t = -1;
        this.f3275u = -1;
        this.f3277v = 0;
        this.f3279w = 0;
        this.f3281x = 0;
        this.f3283y = new int[2];
        this.f3285z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList<>();
        this.f3236a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f3238b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f3240c0 = null;
        this.f3242d0 = 0;
        this.f3244e0 = 0;
        this.f3246f0 = 0.0f;
        this.f3248g0 = -1;
        this.f3250h0 = 0;
        this.f3252i0 = 0;
        this.f3254j0 = 0;
        this.f3256k0 = 0;
        this.f3258l0 = 0;
        this.f3260m0 = 0;
        this.f3262n0 = 0;
        float f10 = f3234z1;
        this.f3268q0 = f10;
        this.f3270r0 = f10;
        this.f3274t0 = 0;
        this.f3276u0 = 0;
        this.f3278v0 = false;
        this.f3280w0 = null;
        this.f3282x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    public float A() {
        return this.f3246f0;
    }

    public boolean A0(int i10) {
        return this.f3236a0[i10];
    }

    public void A1(float f10) {
        this.f3268q0 = f10;
    }

    public int B() {
        return this.f3248g0;
    }

    public boolean B0() {
        ConstraintAnchor constraintAnchor = this.Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f3204f;
        if (constraintAnchor2 != null && constraintAnchor2.f3204f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f3204f;
        return constraintAnchor4 != null && constraintAnchor4.f3204f == constraintAnchor3;
    }

    public void B1(int i10) {
        this.J0 = i10;
    }

    public boolean C() {
        return this.L;
    }

    public boolean C0() {
        return this.M;
    }

    public void C1(int i10, int i11) {
        this.f3250h0 = i10;
        int i12 = i11 - i10;
        this.f3242d0 = i12;
        int i13 = this.f3264o0;
        if (i12 < i13) {
            this.f3242d0 = i13;
        }
    }

    public int D() {
        if (this.f3276u0 == 8) {
            return 0;
        }
        return this.f3244e0;
    }

    public boolean D0() {
        ConstraintAnchor constraintAnchor = this.R;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f3204f;
        if (constraintAnchor2 != null && constraintAnchor2.f3204f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.T;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f3204f;
        return constraintAnchor4 != null && constraintAnchor4.f3204f == constraintAnchor3;
    }

    public void D1(DimensionBehaviour dimensionBehaviour) {
        this.f3238b0[0] = dimensionBehaviour;
    }

    public float E() {
        return this.f3268q0;
    }

    public boolean E0() {
        return this.N;
    }

    public void E1(int i10, int i11, int i12, float f10) {
        this.f3279w = i10;
        this.f3285z = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.A = i12;
        this.B = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f3279w = 2;
    }

    public ConstraintWidget F() {
        if (!B0()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor constraintAnchorR = constraintWidget.r(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor constraintAnchorK = constraintAnchorR == null ? null : constraintAnchorR.k();
            ConstraintWidget constraintWidgetI = constraintAnchorK == null ? null : constraintAnchorK.i();
            if (constraintWidgetI == U()) {
                return constraintWidget;
            }
            ConstraintAnchor constraintAnchorK2 = constraintWidgetI == null ? null : constraintWidgetI.r(ConstraintAnchor.Type.RIGHT).k();
            if (constraintAnchorK2 == null || constraintAnchorK2.i() == constraintWidget) {
                constraintWidget = constraintWidgetI;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public boolean F0() {
        return this.f3251i && this.f3276u0 != 8;
    }

    public void F1(float f10) {
        this.N0[0] = f10;
    }

    public int G() {
        return this.J0;
    }

    public boolean G0() {
        return this.f3265p || (this.Q.o() && this.S.o());
    }

    public void G1(int i10, boolean z10) {
        this.f3236a0[i10] = z10;
    }

    public DimensionBehaviour H() {
        return this.f3238b0[0];
    }

    public boolean H0() {
        return this.f3267q || (this.R.o() && this.T.o());
    }

    public void H1(boolean z10) {
        this.M = z10;
    }

    public int I() {
        ConstraintAnchor constraintAnchor = this.Q;
        int i10 = constraintAnchor != null ? 0 + constraintAnchor.f3205g : 0;
        ConstraintAnchor constraintAnchor2 = this.S;
        return constraintAnchor2 != null ? i10 + constraintAnchor2.f3205g : i10;
    }

    public boolean I0() {
        return this.f3240c0 == null;
    }

    public void I1(boolean z10) {
        this.N = z10;
    }

    public int J() {
        return this.O;
    }

    public boolean J0() {
        return this.f3281x == 0 && this.f3246f0 == 0.0f && this.C == 0 && this.D == 0 && this.f3238b0[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void J1(int i10, int i11) {
        this.O = i10;
        this.P = i11;
        N1(false);
    }

    public int K() {
        return this.P;
    }

    public boolean K0() {
        return this.f3279w == 0 && this.f3246f0 == 0.0f && this.f3285z == 0 && this.A == 0 && this.f3238b0[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void K1(int i10, int i11) {
        if (i11 == 0) {
            c2(i10);
        } else if (i11 == 1) {
            y1(i10);
        }
    }

    public int L() {
        return o0();
    }

    public boolean L0() {
        return this.f3271s;
    }

    public void L1(int i10) {
        this.J[1] = i10;
    }

    public int M(int i10) {
        if (i10 == 0) {
            return m0();
        }
        if (i10 == 1) {
            return D();
        }
        return 0;
    }

    public boolean M0() {
        return this.F;
    }

    public void M1(int i10) {
        this.J[0] = i10;
    }

    public int N() {
        return this.J[1];
    }

    public void N0() {
        this.f3269r = true;
    }

    public void N1(boolean z10) {
        this.f3251i = z10;
    }

    public int O() {
        return this.J[0];
    }

    public void O0() {
        this.f3271s = true;
    }

    public void O1(int i10) {
        if (i10 < 0) {
            this.f3266p0 = 0;
        } else {
            this.f3266p0 = i10;
        }
    }

    public int P() {
        return this.f3266p0;
    }

    public boolean P0(int i10) {
        char c10 = i10 == 0 ? (char) 1 : (char) 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.f3238b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i10];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c10];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3;
    }

    public void P1(int i10) {
        if (i10 < 0) {
            this.f3264o0 = 0;
        } else {
            this.f3264o0 = i10;
        }
    }

    public int Q() {
        return this.f3264o0;
    }

    public boolean Q0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.f3238b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void Q1(int i10, int i11) {
        this.f3258l0 = i10;
        this.f3260m0 = i11;
    }

    public ConstraintWidget R(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.T).f3204f) != null && constraintAnchor2.f3204f == constraintAnchor) {
                return constraintAnchor2.f3202d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f3204f;
        if (constraintAnchor4 == null || constraintAnchor4.f3204f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f3202d;
    }

    public void R0() {
        this.Q.x();
        this.R.x();
        this.S.x();
        this.T.x();
        this.U.x();
        this.V.x();
        this.W.x();
        this.X.x();
        this.f3240c0 = null;
        this.K = 0.0f;
        this.f3242d0 = 0;
        this.f3244e0 = 0;
        this.f3246f0 = 0.0f;
        this.f3248g0 = -1;
        this.f3250h0 = 0;
        this.f3252i0 = 0;
        this.f3258l0 = 0;
        this.f3260m0 = 0;
        this.f3262n0 = 0;
        this.f3264o0 = 0;
        this.f3266p0 = 0;
        float f10 = f3234z1;
        this.f3268q0 = f10;
        this.f3270r0 = f10;
        DimensionBehaviour[] dimensionBehaviourArr = this.f3238b0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f3272s0 = null;
        this.f3274t0 = 0;
        this.f3276u0 = 0;
        this.f3282x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f3273t = -1;
        this.f3275u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f3279w = 0;
        this.f3281x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.f3285z = 0;
        this.C = 0;
        this.f3249h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.f3247g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.f3236a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f3251i = true;
        int[] iArr2 = this.f3283y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f3257l = -1;
        this.f3259m = -1;
    }

    public void R1(int i10, int i11) {
        this.f3250h0 = i10;
        this.f3252i0 = i11;
    }

    public int S() {
        int iMax;
        int i10 = this.f3244e0;
        if (this.f3238b0[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i10;
        }
        if (this.f3281x == 1) {
            iMax = Math.max(this.C, i10);
        } else {
            iMax = this.C;
            if (iMax > 0) {
                this.f3244e0 = iMax;
            } else {
                iMax = 0;
            }
        }
        int i11 = this.D;
        return (i11 <= 0 || i11 >= iMax) ? iMax : i11;
    }

    public void S0() {
        U0();
        V1(f3234z1);
        A1(f3234z1);
    }

    public void S1(ConstraintWidget constraintWidget) {
        this.f3240c0 = constraintWidget;
    }

    public int T() {
        int iMax;
        int i10 = this.f3242d0;
        if (this.f3238b0[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i10;
        }
        if (this.f3279w == 1) {
            iMax = Math.max(this.f3285z, i10);
        } else {
            iMax = this.f3285z;
            if (iMax > 0) {
                this.f3242d0 = iMax;
            } else {
                iMax = 0;
            }
        }
        int i11 = this.A;
        return (i11 <= 0 || i11 >= iMax) ? iMax : i11;
    }

    public void T0(ConstraintAnchor constraintAnchor) {
        if (U() != null && (U() instanceof d) && ((d) U()).K2()) {
            return;
        }
        ConstraintAnchor constraintAnchorR = r(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchorR2 = r(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor constraintAnchorR3 = r(ConstraintAnchor.Type.TOP);
        ConstraintAnchor constraintAnchorR4 = r(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor constraintAnchorR5 = r(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor constraintAnchorR6 = r(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor constraintAnchorR7 = r(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == constraintAnchorR5) {
            if (constraintAnchorR.p() && constraintAnchorR2.p() && constraintAnchorR.k() == constraintAnchorR2.k()) {
                constraintAnchorR.x();
                constraintAnchorR2.x();
            }
            if (constraintAnchorR3.p() && constraintAnchorR4.p() && constraintAnchorR3.k() == constraintAnchorR4.k()) {
                constraintAnchorR3.x();
                constraintAnchorR4.x();
            }
            this.f3268q0 = 0.5f;
            this.f3270r0 = 0.5f;
        } else if (constraintAnchor == constraintAnchorR6) {
            if (constraintAnchorR.p() && constraintAnchorR2.p() && constraintAnchorR.k().i() == constraintAnchorR2.k().i()) {
                constraintAnchorR.x();
                constraintAnchorR2.x();
            }
            this.f3268q0 = 0.5f;
        } else if (constraintAnchor == constraintAnchorR7) {
            if (constraintAnchorR3.p() && constraintAnchorR4.p() && constraintAnchorR3.k().i() == constraintAnchorR4.k().i()) {
                constraintAnchorR3.x();
                constraintAnchorR4.x();
            }
            this.f3270r0 = 0.5f;
        } else if (constraintAnchor == constraintAnchorR || constraintAnchor == constraintAnchorR2) {
            if (constraintAnchorR.p() && constraintAnchorR.k() == constraintAnchorR2.k()) {
                constraintAnchorR5.x();
            }
        } else if ((constraintAnchor == constraintAnchorR3 || constraintAnchor == constraintAnchorR4) && constraintAnchorR3.p() && constraintAnchorR3.k() == constraintAnchorR4.k()) {
            constraintAnchorR5.x();
        }
        constraintAnchor.x();
    }

    public void T1(int i10, int i11) {
        if (i11 == 0) {
            this.f3254j0 = i10;
        } else if (i11 == 1) {
            this.f3256k0 = i10;
        }
    }

    public ConstraintWidget U() {
        return this.f3240c0;
    }

    public void U0() {
        ConstraintWidget constraintWidgetU = U();
        if (constraintWidgetU != null && (constraintWidgetU instanceof d) && ((d) U()).K2()) {
            return;
        }
        int size = this.Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Z.get(i10).x();
        }
    }

    public void U1(String str) {
        this.f3282x0 = str;
    }

    public ConstraintWidget V(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.R).f3204f) != null && constraintAnchor2.f3204f == constraintAnchor) {
                return constraintAnchor2.f3202d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f3204f;
        if (constraintAnchor4 == null || constraintAnchor4.f3204f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f3202d;
    }

    public void V0() {
        this.f3265p = false;
        this.f3267q = false;
        this.f3269r = false;
        this.f3271s = false;
        int size = this.Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.Z.get(i10).y();
        }
    }

    public void V1(float f10) {
        this.f3270r0 = f10;
    }

    public int W(int i10) {
        if (i10 == 0) {
            return this.f3254j0;
        }
        if (i10 == 1) {
            return this.f3256k0;
        }
        return 0;
    }

    public void W0(androidx.constraintlayout.core.c cVar) {
        this.Q.z(cVar);
        this.R.z(cVar);
        this.S.z(cVar);
        this.T.z(cVar);
        this.U.z(cVar);
        this.X.z(cVar);
        this.V.z(cVar);
        this.W.z(cVar);
    }

    public void W1(int i10) {
        this.K0 = i10;
    }

    public int X() {
        return o0() + this.f3242d0;
    }

    public void X0() {
        this.f3269r = false;
        this.f3271s = false;
    }

    public void X1(int i10, int i11) {
        this.f3252i0 = i10;
        int i12 = i11 - i10;
        this.f3244e0 = i12;
        int i13 = this.f3266p0;
        if (i12 < i13) {
            this.f3244e0 = i13;
        }
    }

    public int Y() {
        return this.f3250h0 + this.f3258l0;
    }

    public StringBuilder Y0(StringBuilder sb2) {
        sb2.append("{\n");
        Z0(sb2, xc.d.f55080k0, this.Q);
        Z0(sb2, "top", this.R);
        Z0(sb2, xc.d.f55082m0, this.S);
        Z0(sb2, "bottom", this.T);
        Z0(sb2, "baseline", this.U);
        Z0(sb2, "centerX", this.V);
        Z0(sb2, "centerY", this.W);
        c1(sb2, this.X, this.K);
        e1(sb2, SocializeProtocolConstants.WIDTH, this.f3242d0, this.f3264o0, this.J[0], this.f3257l, this.f3285z, this.f3279w, this.B, this.N0[0]);
        e1(sb2, SocializeProtocolConstants.HEIGHT, this.f3244e0, this.f3266p0, this.J[1], this.f3259m, this.C, this.f3281x, this.E, this.N0[1]);
        d1(sb2, "dimensionRatio", this.f3246f0, this.f3248g0);
        a1(sb2, "horizontalBias", this.f3268q0, f3234z1);
        a1(sb2, "verticalBias", this.f3270r0, f3234z1);
        sb2.append("}\n");
        return sb2;
    }

    public void Y1(DimensionBehaviour dimensionBehaviour) {
        this.f3238b0[1] = dimensionBehaviour;
    }

    public int Z() {
        return this.f3252i0 + this.f3260m0;
    }

    public final void Z0(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f3204f == null) {
            return;
        }
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.f3204f);
        sb2.append("',");
        sb2.append(constraintAnchor.f3205g);
        sb2.append(ag.c.f654g);
        sb2.append(constraintAnchor.f3206h);
        sb2.append(ag.c.f654g);
        sb2.append(" ] ,\n");
    }

    public void Z1(int i10, int i11, int i12, float f10) {
        this.f3281x = i10;
        this.C = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.D = i12;
        this.E = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f3281x = 2;
    }

    public WidgetRun a0(int i10) {
        if (i10 == 0) {
            return this.f3243e;
        }
        if (i10 == 1) {
            return this.f3245f;
        }
        return null;
    }

    public final void a1(StringBuilder sb2, String str, float f10, float f11) {
        if (f10 == f11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f10);
        sb2.append(",\n");
    }

    public void a2(float f10) {
        this.N0[1] = f10;
    }

    public void b0(StringBuilder sb2) {
        sb2.append(GlideException.a.f12263d + this.f3263o + ":{\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.f3242d0);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.f3244e0);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.f3250h0);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.f3252i0);
        sb2.append("\n");
        d0(sb2, xc.d.f55080k0, this.Q);
        d0(sb2, "top", this.R);
        d0(sb2, xc.d.f55082m0, this.S);
        d0(sb2, "bottom", this.T);
        d0(sb2, "baseline", this.U);
        d0(sb2, "centerX", this.V);
        d0(sb2, "centerY", this.W);
        c0(sb2, "    width", this.f3242d0, this.f3264o0, this.J[0], this.f3257l, this.f3285z, this.f3279w, this.B, this.N0[0]);
        c0(sb2, "    height", this.f3244e0, this.f3266p0, this.J[1], this.f3259m, this.C, this.f3281x, this.E, this.N0[1]);
        d1(sb2, "    dimensionRatio", this.f3246f0, this.f3248g0);
        a1(sb2, "    horizontalBias", this.f3268q0, f3234z1);
        a1(sb2, "    verticalBias", this.f3270r0, f3234z1);
        b1(sb2, "    horizontalChainStyle", this.J0, 0);
        b1(sb2, "    verticalChainStyle", this.K0, 0);
        sb2.append("  }");
    }

    public final void b1(StringBuilder sb2, String str, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i10);
        sb2.append(",\n");
    }

    public void b2(int i10) {
        this.f3276u0 = i10;
    }

    public final void c0(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, float f11) {
        sb2.append(str);
        sb2.append(" :  {\n");
        b1(sb2, "      size", i10, 0);
        b1(sb2, "      min", i11, 0);
        b1(sb2, "      max", i12, Integer.MAX_VALUE);
        b1(sb2, "      matchMin", i14, 0);
        b1(sb2, "      matchDef", i15, 0);
        a1(sb2, "      matchPercent", f10, 1.0f);
        sb2.append("    },\n");
    }

    public final void c1(StringBuilder sb2, ConstraintAnchor constraintAnchor, float f10) {
        if (constraintAnchor.f3204f == null) {
            return;
        }
        sb2.append("circle : [ '");
        sb2.append(constraintAnchor.f3204f);
        sb2.append("',");
        sb2.append(constraintAnchor.f3205g);
        sb2.append(ag.c.f654g);
        sb2.append(f10);
        sb2.append(ag.c.f654g);
        sb2.append(" ] ,\n");
    }

    public void c2(int i10) {
        this.f3242d0 = i10;
        int i11 = this.f3264o0;
        if (i10 < i11) {
            this.f3242d0 = i11;
        }
    }

    public final void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    public final void d0(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f3204f == null) {
            return;
        }
        sb2.append(wn.a.f54751a);
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.f3204f);
        sb2.append("'");
        if (constraintAnchor.f3206h != Integer.MIN_VALUE || constraintAnchor.f3205g != 0) {
            sb2.append(ag.c.f654g);
            sb2.append(constraintAnchor.f3205g);
            if (constraintAnchor.f3206h != Integer.MIN_VALUE) {
                sb2.append(ag.c.f654g);
                sb2.append(constraintAnchor.f3206h);
                sb2.append(ag.c.f654g);
            }
        }
        sb2.append(" ] ,\n");
    }

    public final void d1(StringBuilder sb2, String str, float f10, int i10) {
        if (f10 == 0.0f) {
            return;
        }
        sb2.append(str);
        sb2.append(" :  [");
        sb2.append(f10);
        sb2.append(ag.c.f654g);
        sb2.append(i10);
        sb2.append("");
        sb2.append("],\n");
    }

    public void d2(boolean z10) {
        this.F = z10;
    }

    public void e(d dVar, androidx.constraintlayout.core.d dVar2, HashSet<ConstraintWidget> hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            g.a(dVar, dVar2, this);
            hashSet.remove(this);
            g(dVar2, dVar.S2(64));
        }
        if (i10 == 0) {
            HashSet<ConstraintAnchor> hashSetE = this.Q.e();
            if (hashSetE != null) {
                Iterator<ConstraintAnchor> it2 = hashSetE.iterator();
                while (it2.hasNext()) {
                    it2.next().f3202d.e(dVar, dVar2, hashSet, i10, true);
                }
            }
            HashSet<ConstraintAnchor> hashSetE2 = this.S.e();
            if (hashSetE2 != null) {
                Iterator<ConstraintAnchor> it3 = hashSetE2.iterator();
                while (it3.hasNext()) {
                    it3.next().f3202d.e(dVar, dVar2, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> hashSetE3 = this.R.e();
        if (hashSetE3 != null) {
            Iterator<ConstraintAnchor> it4 = hashSetE3.iterator();
            while (it4.hasNext()) {
                it4.next().f3202d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> hashSetE4 = this.T.e();
        if (hashSetE4 != null) {
            Iterator<ConstraintAnchor> it5 = hashSetE4.iterator();
            while (it5.hasNext()) {
                it5.next().f3202d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> hashSetE5 = this.U.e();
        if (hashSetE5 != null) {
            Iterator<ConstraintAnchor> it6 = hashSetE5.iterator();
            while (it6.hasNext()) {
                it6.next().f3202d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
    }

    public int e0() {
        return p0();
    }

    public final void e1(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, float f11) {
        sb2.append(str);
        sb2.append(" :  {\n");
        b1(sb2, "size", i10, Integer.MIN_VALUE);
        b1(sb2, "min", i11, 0);
        b1(sb2, "max", i12, Integer.MAX_VALUE);
        b1(sb2, "matchMin", i14, 0);
        b1(sb2, "matchDef", i15, 0);
        b1(sb2, "matchPercent", i15, 1);
        sb2.append("},\n");
    }

    public void e2(int i10) {
        if (i10 < 0 || i10 > 3) {
            return;
        }
        this.f3277v = i10;
    }

    public boolean f() {
        return (this instanceof i) || (this instanceof f);
    }

    public String f0() {
        return this.f3282x0;
    }

    public void f1(boolean z10) {
        this.f3278v0 = z10;
    }

    public void f2(int i10) {
        this.f3250h0 = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x05f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(androidx.constraintlayout.core.d r54, boolean r55) {
        /*
            Method dump skipped, instruction units count: 1567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.d, boolean):void");
    }

    public float g0() {
        return this.f3270r0;
    }

    public void g1(int i10) {
        this.f3262n0 = i10;
        this.L = i10 > 0;
    }

    public void g2(int i10) {
        this.f3252i0 = i10;
    }

    public boolean h() {
        return this.f3276u0 != 8;
    }

    public ConstraintWidget h0() {
        if (!D0()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor constraintAnchorR = constraintWidget.r(ConstraintAnchor.Type.TOP);
            ConstraintAnchor constraintAnchorK = constraintAnchorR == null ? null : constraintAnchorR.k();
            ConstraintWidget constraintWidgetI = constraintAnchorK == null ? null : constraintAnchorK.i();
            if (constraintWidgetI == U()) {
                return constraintWidget;
            }
            ConstraintAnchor constraintAnchorK2 = constraintWidgetI == null ? null : constraintWidgetI.r(ConstraintAnchor.Type.BOTTOM).k();
            if (constraintAnchorK2 == null || constraintAnchorK2.i() == constraintWidget) {
                constraintWidget = constraintWidgetI;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public void h1(Object obj) {
        this.f3272s0 = obj;
    }

    public void h2(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.H == -1) {
            if (z12 && !z13) {
                this.H = 0;
            } else if (!z12 && z13) {
                this.H = 1;
                if (this.f3248g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.p() || !this.T.p())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.p() || !this.S.p())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.p() || !this.T.p() || !this.Q.p() || !this.S.p())) {
            if (this.R.p() && this.T.p()) {
                this.H = 0;
            } else if (this.Q.p() && this.S.p()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i10 = this.f3285z;
            if (i10 > 0 && this.C == 0) {
                this.H = 0;
            } else {
                if (i10 != 0 || this.C <= 0) {
                    return;
                }
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x04a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0508 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:384:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(androidx.constraintlayout.core.d r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            Method dump skipped, instruction units count: 1352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.d, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public int i0() {
        return this.K0;
    }

    public void i1(int i10) {
        if (i10 >= 0) {
            this.f3274t0 = i10;
        } else {
            this.f3274t0 = 0;
        }
    }

    public void i2(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean zM = z10 & this.f3243e.m();
        boolean zM2 = z11 & this.f3245f.m();
        k kVar = this.f3243e;
        int i12 = kVar.f3308h.f3295g;
        m mVar = this.f3245f;
        int i13 = mVar.f3308h.f3295g;
        int i14 = kVar.f3309i.f3295g;
        int i15 = mVar.f3309i.f3295g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (zM) {
            this.f3250h0 = i12;
        }
        if (zM2) {
            this.f3252i0 = i13;
        }
        if (this.f3276u0 == 8) {
            this.f3242d0 = 0;
            this.f3244e0 = 0;
            return;
        }
        if (zM) {
            if (this.f3238b0[0] == DimensionBehaviour.FIXED && i17 < (i11 = this.f3242d0)) {
                i17 = i11;
            }
            this.f3242d0 = i17;
            int i19 = this.f3264o0;
            if (i17 < i19) {
                this.f3242d0 = i19;
            }
        }
        if (zM2) {
            if (this.f3238b0[1] == DimensionBehaviour.FIXED && i18 < (i10 = this.f3244e0)) {
                i18 = i10;
            }
            this.f3244e0 = i18;
            int i20 = this.f3266p0;
            if (i18 < i20) {
                this.f3244e0 = i20;
            }
        }
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        k(type, constraintWidget, type2, 0);
    }

    public DimensionBehaviour j0() {
        return this.f3238b0[1];
    }

    public void j1(String str) {
        this.f3280w0 = str;
    }

    public void j2(androidx.constraintlayout.core.d dVar, boolean z10) {
        m mVar;
        k kVar;
        int iO = dVar.O(this.Q);
        int iO2 = dVar.O(this.R);
        int iO3 = dVar.O(this.S);
        int iO4 = dVar.O(this.T);
        if (z10 && (kVar = this.f3243e) != null) {
            DependencyNode dependencyNode = kVar.f3308h;
            if (dependencyNode.f3298j) {
                DependencyNode dependencyNode2 = kVar.f3309i;
                if (dependencyNode2.f3298j) {
                    iO = dependencyNode.f3295g;
                    iO3 = dependencyNode2.f3295g;
                }
            }
        }
        if (z10 && (mVar = this.f3245f) != null) {
            DependencyNode dependencyNode3 = mVar.f3308h;
            if (dependencyNode3.f3298j) {
                DependencyNode dependencyNode4 = mVar.f3309i;
                if (dependencyNode4.f3298j) {
                    iO2 = dependencyNode3.f3295g;
                    iO4 = dependencyNode4.f3295g;
                }
            }
        }
        int i10 = iO4 - iO2;
        if (iO3 - iO < 0 || i10 < 0 || iO == Integer.MIN_VALUE || iO == Integer.MAX_VALUE || iO2 == Integer.MIN_VALUE || iO2 == Integer.MAX_VALUE || iO3 == Integer.MIN_VALUE || iO3 == Integer.MAX_VALUE || iO4 == Integer.MIN_VALUE || iO4 == Integer.MAX_VALUE) {
            iO4 = 0;
            iO = 0;
            iO2 = 0;
            iO3 = 0;
        }
        v1(iO, iO2, iO3, iO4);
    }

    public void k(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z10;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 != type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                if (type2 == type6 || type2 == ConstraintAnchor.Type.RIGHT) {
                    k(type6, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    r(type5).a(constraintWidget.r(type2), 0);
                    return;
                }
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
                if (type2 == type7 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    k(type7, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    r(type5).a(constraintWidget.r(type2), 0);
                    return;
                }
                return;
            }
            ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor constraintAnchorR = r(type8);
            ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor constraintAnchorR2 = r(type9);
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor constraintAnchorR3 = r(type10);
            ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor constraintAnchorR4 = r(type11);
            boolean z11 = true;
            if ((constraintAnchorR == null || !constraintAnchorR.p()) && (constraintAnchorR2 == null || !constraintAnchorR2.p())) {
                k(type8, constraintWidget, type8, 0);
                k(type9, constraintWidget, type9, 0);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((constraintAnchorR3 == null || !constraintAnchorR3.p()) && (constraintAnchorR4 == null || !constraintAnchorR4.p())) {
                k(type10, constraintWidget, type10, 0);
                k(type11, constraintWidget, type11, 0);
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                r(type5).a(constraintWidget.r(type5), 0);
                return;
            }
            if (z10) {
                ConstraintAnchor.Type type12 = ConstraintAnchor.Type.CENTER_X;
                r(type12).a(constraintWidget.r(type12), 0);
                return;
            } else {
                if (z11) {
                    ConstraintAnchor.Type type13 = ConstraintAnchor.Type.CENTER_Y;
                    r(type13).a(constraintWidget.r(type13), 0);
                    return;
                }
                return;
            }
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor constraintAnchorR5 = r(type4);
            ConstraintAnchor constraintAnchorR6 = constraintWidget.r(type2);
            ConstraintAnchor constraintAnchorR7 = r(ConstraintAnchor.Type.RIGHT);
            constraintAnchorR5.a(constraintAnchorR6, 0);
            constraintAnchorR7.a(constraintAnchorR6, 0);
            r(type14).a(constraintAnchorR6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor constraintAnchorR8 = constraintWidget.r(type2);
            r(type3).a(constraintAnchorR8, 0);
            r(ConstraintAnchor.Type.BOTTOM).a(constraintAnchorR8, 0);
            r(type15).a(constraintAnchorR8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            r(type16).a(constraintWidget.r(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            r(type17).a(constraintWidget.r(type17), 0);
            r(type14).a(constraintWidget.r(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            r(type18).a(constraintWidget.r(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            r(type19).a(constraintWidget.r(type19), 0);
            r(type15).a(constraintWidget.r(type2), 0);
            return;
        }
        ConstraintAnchor constraintAnchorR9 = r(type);
        ConstraintAnchor constraintAnchorR10 = constraintWidget.r(type2);
        if (constraintAnchorR9.v(constraintAnchorR10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor constraintAnchorR11 = r(ConstraintAnchor.Type.TOP);
                ConstraintAnchor constraintAnchorR12 = r(ConstraintAnchor.Type.BOTTOM);
                if (constraintAnchorR11 != null) {
                    constraintAnchorR11.x();
                }
                if (constraintAnchorR12 != null) {
                    constraintAnchorR12.x();
                }
            } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                ConstraintAnchor constraintAnchorR13 = r(type20);
                if (constraintAnchorR13 != null) {
                    constraintAnchorR13.x();
                }
                ConstraintAnchor constraintAnchorR14 = r(type5);
                if (constraintAnchorR14.k() != constraintAnchorR10) {
                    constraintAnchorR14.x();
                }
                ConstraintAnchor constraintAnchorH = r(type).h();
                ConstraintAnchor constraintAnchorR15 = r(type15);
                if (constraintAnchorR15.p()) {
                    constraintAnchorH.x();
                    constraintAnchorR15.x();
                }
            } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor constraintAnchorR16 = r(type5);
                if (constraintAnchorR16.k() != constraintAnchorR10) {
                    constraintAnchorR16.x();
                }
                ConstraintAnchor constraintAnchorH2 = r(type).h();
                ConstraintAnchor constraintAnchorR17 = r(type14);
                if (constraintAnchorR17.p()) {
                    constraintAnchorH2.x();
                    constraintAnchorR17.x();
                }
            }
            constraintAnchorR9.a(constraintAnchorR10, i10);
        }
    }

    public int k0() {
        int i10 = this.Q != null ? 0 + this.R.f3205g : 0;
        return this.S != null ? i10 + this.T.f3205g : i10;
    }

    public void k1(androidx.constraintlayout.core.d dVar, String str) {
        this.f3280w0 = str;
        SolverVariable solverVariableU = dVar.u(this.Q);
        SolverVariable solverVariableU2 = dVar.u(this.R);
        SolverVariable solverVariableU3 = dVar.u(this.S);
        SolverVariable solverVariableU4 = dVar.u(this.T);
        solverVariableU.l(str + ".left");
        solverVariableU2.l(str + ".top");
        solverVariableU3.l(str + ".right");
        solverVariableU4.l(str + ".bottom");
        dVar.u(this.U).l(str + ".baseline");
    }

    public void l(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        if (constraintAnchor.i() == this) {
            k(constraintAnchor.l(), constraintAnchor2.i(), constraintAnchor2.l(), i10);
        }
    }

    public int l0() {
        return this.f3276u0;
    }

    public void l1(int i10, int i11) {
        this.f3242d0 = i10;
        int i12 = this.f3264o0;
        if (i10 < i12) {
            this.f3242d0 = i12;
        }
        this.f3244e0 = i11;
        int i13 = this.f3266p0;
        if (i11 < i13) {
            this.f3244e0 = i13;
        }
    }

    public void m(ConstraintWidget constraintWidget, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        v0(type, constraintWidget, type, i10, 0);
        this.K = f10;
    }

    public int m0() {
        if (this.f3276u0 == 8) {
            return 0;
        }
        return this.f3242d0;
    }

    public void m1(float f10, int i10) {
        this.f3246f0 = f10;
        this.f3248g0 = i10;
    }

    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.f3273t = constraintWidget.f3273t;
        this.f3275u = constraintWidget.f3275u;
        this.f3279w = constraintWidget.f3279w;
        this.f3281x = constraintWidget.f3281x;
        int[] iArr = this.f3283y;
        int[] iArr2 = constraintWidget.f3283y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f3285z = constraintWidget.f3285z;
        this.A = constraintWidget.A;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        this.I = constraintWidget.I;
        int[] iArr3 = constraintWidget.J;
        this.J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = constraintWidget.K;
        this.L = constraintWidget.L;
        this.M = constraintWidget.M;
        this.Q.x();
        this.R.x();
        this.S.x();
        this.T.x();
        this.U.x();
        this.V.x();
        this.W.x();
        this.X.x();
        this.f3238b0 = (DimensionBehaviour[]) Arrays.copyOf(this.f3238b0, 2);
        this.f3240c0 = this.f3240c0 == null ? null : map.get(constraintWidget.f3240c0);
        this.f3242d0 = constraintWidget.f3242d0;
        this.f3244e0 = constraintWidget.f3244e0;
        this.f3246f0 = constraintWidget.f3246f0;
        this.f3248g0 = constraintWidget.f3248g0;
        this.f3250h0 = constraintWidget.f3250h0;
        this.f3252i0 = constraintWidget.f3252i0;
        this.f3254j0 = constraintWidget.f3254j0;
        this.f3256k0 = constraintWidget.f3256k0;
        this.f3258l0 = constraintWidget.f3258l0;
        this.f3260m0 = constraintWidget.f3260m0;
        this.f3262n0 = constraintWidget.f3262n0;
        this.f3264o0 = constraintWidget.f3264o0;
        this.f3266p0 = constraintWidget.f3266p0;
        this.f3268q0 = constraintWidget.f3268q0;
        this.f3270r0 = constraintWidget.f3270r0;
        this.f3272s0 = constraintWidget.f3272s0;
        this.f3274t0 = constraintWidget.f3274t0;
        this.f3276u0 = constraintWidget.f3276u0;
        this.f3278v0 = constraintWidget.f3278v0;
        this.f3280w0 = constraintWidget.f3280w0;
        this.f3282x0 = constraintWidget.f3282x0;
        this.f3284y0 = constraintWidget.f3284y0;
        this.f3286z0 = constraintWidget.f3286z0;
        this.A0 = constraintWidget.A0;
        this.B0 = constraintWidget.B0;
        this.C0 = constraintWidget.C0;
        this.D0 = constraintWidget.D0;
        this.E0 = constraintWidget.E0;
        this.F0 = constraintWidget.F0;
        this.G0 = constraintWidget.G0;
        this.H0 = constraintWidget.H0;
        this.J0 = constraintWidget.J0;
        this.K0 = constraintWidget.K0;
        this.L0 = constraintWidget.L0;
        this.M0 = constraintWidget.M0;
        float[] fArr = this.N0;
        float[] fArr2 = constraintWidget.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.O0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.O0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.P0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.P0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.Q0;
        this.Q0 = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.R0;
        this.R0 = constraintWidget3 != null ? map.get(constraintWidget3) : null;
    }

    public int n0() {
        return this.f3277v;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0084 A[PHI: r0
  0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:45:0x0084, B:35:0x007d, B:23:0x004f, B:25:0x0055, B:27:0x0061, B:29:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n1(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L8e
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L8e
        Lb:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L37
            int r6 = r2 + (-1)
            if (r3 >= r6) goto L37
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2c
            r1 = 0
            goto L35
        L2c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L35
            r1 = 1
        L35:
            int r4 = r3 + 1
        L37:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L75
            int r2 = r2 - r5
            if (r3 >= r2) goto L75
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L84
            int r3 = r9.length()
            if (r3 <= 0) goto L84
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: java.lang.NumberFormatException -> L84
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L84
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L84
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L84
            if (r1 != r5) goto L6f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L6f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L75:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L84
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L84
            goto L85
        L84:
            r9 = 0
        L85:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L8d
            r8.f3246f0 = r9
            r8.f3248g0 = r1
        L8d:
            return
        L8e:
            r8.f3246f0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.n1(java.lang.String):void");
    }

    public void o(androidx.constraintlayout.core.d dVar) {
        dVar.u(this.Q);
        dVar.u(this.R);
        dVar.u(this.S);
        dVar.u(this.T);
        if (this.f3262n0 > 0) {
            dVar.u(this.U);
        }
    }

    public int o0() {
        ConstraintWidget constraintWidget = this.f3240c0;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f3250h0 : ((d) constraintWidget).I1 + this.f3250h0;
    }

    public void o1(int i10) {
        if (this.L) {
            int i11 = i10 - this.f3262n0;
            int i12 = this.f3244e0 + i11;
            this.f3252i0 = i11;
            this.R.A(i11);
            this.T.A(i12);
            this.U.A(i10);
            this.f3267q = true;
        }
    }

    public void p() {
        this.f3251i = true;
    }

    public int p0() {
        ConstraintWidget constraintWidget = this.f3240c0;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f3252i0 : ((d) constraintWidget).J1 + this.f3252i0;
    }

    public void p1(int i10, int i11, int i12, int i13, int i14, int i15) {
        v1(i10, i11, i12, i13);
        g1(i14);
        if (i15 == 0) {
            this.f3265p = true;
            this.f3267q = false;
        } else if (i15 == 1) {
            this.f3265p = false;
            this.f3267q = true;
        } else if (i15 == 2) {
            this.f3265p = true;
            this.f3267q = true;
        } else {
            this.f3265p = false;
            this.f3267q = false;
        }
    }

    public void q() {
        if (this.f3243e == null) {
            this.f3243e = new k(this);
        }
        if (this.f3245f == null) {
            this.f3245f = new m(this);
        }
    }

    public boolean q0() {
        return this.L;
    }

    public void q1(int i10, int i11) {
        if (this.f3265p) {
            return;
        }
        this.Q.A(i10);
        this.S.A(i11);
        this.f3250h0 = i10;
        this.f3242d0 = i11 - i10;
        this.f3265p = true;
    }

    public ConstraintAnchor r(ConstraintAnchor.Type type) {
        switch (a.f3287a[type.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean r0(int i10) {
        if (i10 == 0) {
            return (this.Q.f3204f != null ? 1 : 0) + (this.S.f3204f != null ? 1 : 0) < 2;
        }
        return ((this.R.f3204f != null ? 1 : 0) + (this.T.f3204f != null ? 1 : 0)) + (this.U.f3204f != null ? 1 : 0) < 2;
    }

    public void r1(int i10) {
        this.Q.A(i10);
        this.f3250h0 = i10;
    }

    public ArrayList<ConstraintAnchor> s() {
        return this.Z;
    }

    public boolean s0() {
        int size = this.Z.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.Z.get(i10).n()) {
                return true;
            }
        }
        return false;
    }

    public void s1(int i10) {
        this.R.A(i10);
        this.f3252i0 = i10;
    }

    public int t() {
        return this.f3262n0;
    }

    public boolean t0() {
        return (this.f3257l == -1 && this.f3259m == -1) ? false : true;
    }

    public void t1(int i10, int i11) {
        if (this.f3267q) {
            return;
        }
        this.R.A(i10);
        this.T.A(i11);
        this.f3252i0 = i10;
        this.f3244e0 = i11 - i10;
        if (this.L) {
            this.U.A(i10 + this.f3262n0);
        }
        this.f3267q = true;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f3282x0 != null) {
            str = "type: " + this.f3282x0 + i0.f11861z;
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f3280w0 != null) {
            str2 = "id: " + this.f3280w0 + i0.f11861z;
        }
        sb2.append(str2);
        sb2.append(ee.a.f26978c);
        sb2.append(this.f3250h0);
        sb2.append(", ");
        sb2.append(this.f3252i0);
        sb2.append(") - (");
        sb2.append(this.f3242d0);
        sb2.append(" x ");
        sb2.append(this.f3244e0);
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    public float u(int i10) {
        if (i10 == 0) {
            return this.f3268q0;
        }
        if (i10 == 1) {
            return this.f3270r0;
        }
        return -1.0f;
    }

    public boolean u0(int i10, int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.Q.f3204f;
            return constraintAnchor3 != null && constraintAnchor3.o() && (constraintAnchor2 = this.S.f3204f) != null && constraintAnchor2.o() && (this.S.f3204f.f() - this.S.g()) - (this.Q.f3204f.f() + this.Q.g()) >= i11;
        }
        ConstraintAnchor constraintAnchor4 = this.R.f3204f;
        return constraintAnchor4 != null && constraintAnchor4.o() && (constraintAnchor = this.T.f3204f) != null && constraintAnchor.o() && (this.T.f3204f.f() - this.T.g()) - (this.R.f3204f.f() + this.R.g()) >= i11;
        return false;
    }

    public void u1(int i10, int i11, int i12) {
        if (i12 == 0) {
            C1(i10, i11);
        } else if (i12 == 1) {
            X1(i10, i11);
        }
    }

    public int v() {
        return p0() + this.f3244e0;
    }

    public void v0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        r(type).b(constraintWidget.r(type2), i10, i11, true);
    }

    public void v1(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f3250h0 = i10;
        this.f3252i0 = i11;
        if (this.f3276u0 == 8) {
            this.f3242d0 = 0;
            this.f3244e0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.f3238b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i16 < (i15 = this.f3242d0)) {
            i16 = i15;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i17 < (i14 = this.f3244e0)) {
            i17 = i14;
        }
        this.f3242d0 = i16;
        this.f3244e0 = i17;
        int i18 = this.f3266p0;
        if (i17 < i18) {
            this.f3244e0 = i18;
        }
        int i19 = this.f3264o0;
        if (i16 < i19) {
            this.f3242d0 = i19;
        }
        int i20 = this.A;
        if (i20 > 0 && dimensionBehaviourArr[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f3242d0 = Math.min(this.f3242d0, i20);
        }
        int i21 = this.D;
        if (i21 > 0 && this.f3238b0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f3244e0 = Math.min(this.f3244e0, i21);
        }
        int i22 = this.f3242d0;
        if (i16 != i22) {
            this.f3257l = i22;
        }
        int i23 = this.f3244e0;
        if (i17 != i23) {
            this.f3259m = i23;
        }
    }

    public Object w() {
        return this.f3272s0;
    }

    public boolean w0() {
        return this.f3278v0;
    }

    public void w1(ConstraintAnchor.Type type, int i10) {
        int i11 = a.f3287a[type.ordinal()];
        if (i11 == 1) {
            this.Q.f3206h = i10;
            return;
        }
        if (i11 == 2) {
            this.R.f3206h = i10;
            return;
        }
        if (i11 == 3) {
            this.S.f3206h = i10;
        } else if (i11 == 4) {
            this.T.f3206h = i10;
        } else {
            if (i11 != 5) {
                return;
            }
            this.U.f3206h = i10;
        }
    }

    public int x() {
        return this.f3274t0;
    }

    public final boolean x0(int i10) {
        int i11 = i10 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.Y;
        if (constraintAnchorArr[i11].f3204f != null && constraintAnchorArr[i11].f3204f.f3204f != constraintAnchorArr[i11]) {
            int i12 = i11 + 1;
            if (constraintAnchorArr[i12].f3204f != null && constraintAnchorArr[i12].f3204f.f3204f == constraintAnchorArr[i12]) {
                return true;
            }
        }
        return false;
    }

    public void x1(boolean z10) {
        this.L = z10;
    }

    public String y() {
        return this.f3280w0;
    }

    public boolean y0() {
        return this.G;
    }

    public void y1(int i10) {
        this.f3244e0 = i10;
        int i11 = this.f3266p0;
        if (i10 < i11) {
            this.f3244e0 = i11;
        }
    }

    public DimensionBehaviour z(int i10) {
        if (i10 == 0) {
            return H();
        }
        if (i10 == 1) {
            return j0();
        }
        return null;
    }

    public boolean z0() {
        return this.f3269r;
    }

    public void z1(boolean z10) {
        this.G = z10;
    }

    public ConstraintWidget(String str) {
        this.f3235a = false;
        this.f3237b = new WidgetRun[2];
        this.f3243e = null;
        this.f3245f = null;
        this.f3247g = new boolean[]{true, true};
        this.f3249h = false;
        this.f3251i = true;
        this.f3253j = false;
        this.f3255k = true;
        this.f3257l = -1;
        this.f3259m = -1;
        this.f3261n = new o(this);
        this.f3265p = false;
        this.f3267q = false;
        this.f3269r = false;
        this.f3271s = false;
        this.f3273t = -1;
        this.f3275u = -1;
        this.f3277v = 0;
        this.f3279w = 0;
        this.f3281x = 0;
        this.f3283y = new int[2];
        this.f3285z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList<>();
        this.f3236a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f3238b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f3240c0 = null;
        this.f3242d0 = 0;
        this.f3244e0 = 0;
        this.f3246f0 = 0.0f;
        this.f3248g0 = -1;
        this.f3250h0 = 0;
        this.f3252i0 = 0;
        this.f3254j0 = 0;
        this.f3256k0 = 0;
        this.f3258l0 = 0;
        this.f3260m0 = 0;
        this.f3262n0 = 0;
        float f10 = f3234z1;
        this.f3268q0 = f10;
        this.f3270r0 = f10;
        this.f3274t0 = 0;
        this.f3276u0 = 0;
        this.f3278v0 = false;
        this.f3280w0 = null;
        this.f3282x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
        j1(str);
    }

    public ConstraintWidget(int i10, int i11, int i12, int i13) {
        this.f3235a = false;
        this.f3237b = new WidgetRun[2];
        this.f3243e = null;
        this.f3245f = null;
        this.f3247g = new boolean[]{true, true};
        this.f3249h = false;
        this.f3251i = true;
        this.f3253j = false;
        this.f3255k = true;
        this.f3257l = -1;
        this.f3259m = -1;
        this.f3261n = new o(this);
        this.f3265p = false;
        this.f3267q = false;
        this.f3269r = false;
        this.f3271s = false;
        this.f3273t = -1;
        this.f3275u = -1;
        this.f3277v = 0;
        this.f3279w = 0;
        this.f3281x = 0;
        this.f3283y = new int[2];
        this.f3285z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList<>();
        this.f3236a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f3238b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f3240c0 = null;
        this.f3246f0 = 0.0f;
        this.f3248g0 = -1;
        this.f3254j0 = 0;
        this.f3256k0 = 0;
        this.f3258l0 = 0;
        this.f3260m0 = 0;
        this.f3262n0 = 0;
        float f10 = f3234z1;
        this.f3268q0 = f10;
        this.f3270r0 = f10;
        this.f3274t0 = 0;
        this.f3276u0 = 0;
        this.f3278v0 = false;
        this.f3280w0 = null;
        this.f3282x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        this.f3250h0 = i10;
        this.f3252i0 = i11;
        this.f3242d0 = i12;
        this.f3244e0 = i13;
        d();
    }

    public ConstraintWidget(String str, int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13);
        j1(str);
    }

    public ConstraintWidget(int i10, int i11) {
        this(0, 0, i10, i11);
    }

    public ConstraintWidget(String str, int i10, int i11) {
        this(i10, i11);
        j1(str);
    }
}
