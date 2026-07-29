package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class h extends f {
    public static final String X = "KeyCycle";
    public static final String Y = "KeyCycle";
    public static final String Z = "wavePeriod";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f3689a0 = "waveOffset";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f3690b0 = "wavePhase";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f3691c0 = "waveShape";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f3692d0 = 0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f3693e0 = 1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f3694f0 = 2;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f3695g0 = 3;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f3696h0 = 4;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f3697i0 = 5;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f3698j0 = 6;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f3699k0 = 4;
    public String D = null;
    public int E = 0;
    public int F = -1;
    public String G = null;
    public float H = Float.NaN;
    public float I = 0.0f;
    public float J = 0.0f;
    public float K = Float.NaN;
    public int L = -1;
    public float M = Float.NaN;
    public float N = Float.NaN;
    public float O = Float.NaN;
    public float P = Float.NaN;
    public float Q = Float.NaN;
    public float R = Float.NaN;
    public float S = Float.NaN;
    public float T = Float.NaN;
    public float U = Float.NaN;
    public float V = Float.NaN;
    public float W = Float.NaN;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3700a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3701b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f3702c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f3703d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f3704e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f3705f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f3706g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f3707h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f3708i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f3709j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f3710k = 11;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f3711l = 12;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f3712m = 13;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f3713n = 14;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f3714o = 15;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f3715p = 16;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f3716q = 17;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f3717r = 18;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f3718s = 19;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f3719t = 20;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f3720u = 21;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static SparseIntArray f3721v;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3721v = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            f3721v.append(R.styleable.KeyCycle_framePosition, 2);
            f3721v.append(R.styleable.KeyCycle_transitionEasing, 3);
            f3721v.append(R.styleable.KeyCycle_curveFit, 4);
            f3721v.append(R.styleable.KeyCycle_waveShape, 5);
            f3721v.append(R.styleable.KeyCycle_wavePeriod, 6);
            f3721v.append(R.styleable.KeyCycle_waveOffset, 7);
            f3721v.append(R.styleable.KeyCycle_waveVariesBy, 8);
            f3721v.append(R.styleable.KeyCycle_android_alpha, 9);
            f3721v.append(R.styleable.KeyCycle_android_elevation, 10);
            f3721v.append(R.styleable.KeyCycle_android_rotation, 11);
            f3721v.append(R.styleable.KeyCycle_android_rotationX, 12);
            f3721v.append(R.styleable.KeyCycle_android_rotationY, 13);
            f3721v.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            f3721v.append(R.styleable.KeyCycle_android_scaleX, 15);
            f3721v.append(R.styleable.KeyCycle_android_scaleY, 16);
            f3721v.append(R.styleable.KeyCycle_android_translationX, 17);
            f3721v.append(R.styleable.KeyCycle_android_translationY, 18);
            f3721v.append(R.styleable.KeyCycle_android_translationZ, 19);
            f3721v.append(R.styleable.KeyCycle_motionProgress, 20);
            f3721v.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        public static void b(h c10, TypedArray a10) {
            int indexCount = a10.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = a10.getIndex(i10);
                switch (f3721v.get(index)) {
                    case 1:
                        if (MotionLayout.f3495k9) {
                            int resourceId = a10.getResourceId(index, c10.f3666b);
                            c10.f3666b = resourceId;
                            if (resourceId == -1) {
                                c10.f3667c = a10.getString(index);
                            }
                        } else if (a10.peekValue(index).type == 3) {
                            c10.f3667c = a10.getString(index);
                        } else {
                            c10.f3666b = a10.getResourceId(index, c10.f3666b);
                        }
                        break;
                    case 2:
                        c10.f3665a = a10.getInt(index, c10.f3665a);
                        break;
                    case 3:
                        c10.D = a10.getString(index);
                        break;
                    case 4:
                        c10.E = a10.getInteger(index, c10.E);
                        break;
                    case 5:
                        if (a10.peekValue(index).type == 3) {
                            c10.G = a10.getString(index);
                            c10.F = 7;
                        } else {
                            c10.F = a10.getInt(index, c10.F);
                        }
                        break;
                    case 6:
                        c10.H = a10.getFloat(index, c10.H);
                        break;
                    case 7:
                        if (a10.peekValue(index).type == 5) {
                            c10.I = a10.getDimension(index, c10.I);
                        } else {
                            c10.I = a10.getFloat(index, c10.I);
                        }
                        break;
                    case 8:
                        c10.L = a10.getInt(index, c10.L);
                        break;
                    case 9:
                        c10.M = a10.getFloat(index, c10.M);
                        break;
                    case 10:
                        c10.N = a10.getDimension(index, c10.N);
                        break;
                    case 11:
                        c10.O = a10.getFloat(index, c10.O);
                        break;
                    case 12:
                        c10.Q = a10.getFloat(index, c10.Q);
                        break;
                    case 13:
                        c10.R = a10.getFloat(index, c10.R);
                        break;
                    case 14:
                        c10.P = a10.getFloat(index, c10.P);
                        break;
                    case 15:
                        c10.S = a10.getFloat(index, c10.S);
                        break;
                    case 16:
                        c10.T = a10.getFloat(index, c10.T);
                        break;
                    case 17:
                        c10.U = a10.getDimension(index, c10.U);
                        break;
                    case 18:
                        c10.V = a10.getDimension(index, c10.V);
                        break;
                    case 19:
                        c10.W = a10.getDimension(index, c10.W);
                        break;
                    case 20:
                        c10.K = a10.getFloat(index, c10.K);
                        break;
                    case 21:
                        c10.J = a10.getFloat(index, c10.J) / 360.0f;
                        break;
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("unused attribute 0x");
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(f3721v.get(index));
                        break;
                }
            }
        }
    }

    public h() {
        this.f3668d = 4;
        this.f3669e = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, a0.d> splines) {
        c.n("KeyCycle", "add " + splines.size() + " values", 2);
        for (String str : splines.keySet()) {
            a0.d dVar = splines.get(str);
            if (dVar != null) {
                str.hashCode();
                switch (str) {
                    case "rotationX":
                        dVar.g(this.f3665a, this.Q);
                        break;
                    case "rotationY":
                        dVar.g(this.f3665a, this.R);
                        break;
                    case "translationX":
                        dVar.g(this.f3665a, this.U);
                        break;
                    case "translationY":
                        dVar.g(this.f3665a, this.V);
                        break;
                    case "translationZ":
                        dVar.g(this.f3665a, this.W);
                        break;
                    case "progress":
                        dVar.g(this.f3665a, this.K);
                        break;
                    case "scaleX":
                        dVar.g(this.f3665a, this.S);
                        break;
                    case "scaleY":
                        dVar.g(this.f3665a, this.T);
                        break;
                    case "rotation":
                        dVar.g(this.f3665a, this.O);
                        break;
                    case "elevation":
                        dVar.g(this.f3665a, this.N);
                        break;
                    case "transitionPathRotate":
                        dVar.g(this.f3665a, this.P);
                        break;
                    case "alpha":
                        dVar.g(this.f3665a, this.M);
                        break;
                    case "waveOffset":
                        dVar.g(this.f3665a, this.I);
                        break;
                    case "wavePhase":
                        dVar.g(this.f3665a, this.J);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            break;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("  UNKNOWN  ");
                            sb2.append(str);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public void a0(HashMap<String, a0.c> oscSet) {
        a0.c cVar;
        a0.c cVar2;
        for (String str : oscSet.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.f3669e.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.j() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (cVar = oscSet.get(str)) != null) {
                    cVar.g(this.f3665a, this.F, this.G, this.L, this.H, this.I, this.J, constraintAttribute.k(), constraintAttribute);
                }
            } else {
                float fB0 = b0(str);
                if (!Float.isNaN(fB0) && (cVar2 = oscSet.get(str)) != null) {
                    cVar2.f(this.f3665a, this.F, this.G, this.L, this.H, this.I, this.J, fB0);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new h().c(this);
    }

    public float b0(String key) {
        key.hashCode();
        switch (key) {
            case "rotationX":
                return this.Q;
            case "rotationY":
                return this.R;
            case "translationX":
                return this.U;
            case "translationY":
                return this.V;
            case "translationZ":
                return this.W;
            case "progress":
                return this.K;
            case "scaleX":
                return this.S;
            case "scaleY":
                return this.T;
            case "rotation":
                return this.O;
            case "elevation":
                return this.N;
            case "transitionPathRotate":
                return this.P;
            case "alpha":
                return this.M;
            case "waveOffset":
                return this.I;
            case "wavePhase":
                return this.J;
            default:
                if (key.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  UNKNOWN  ");
                sb2.append(key);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        h hVar = (h) src;
        this.D = hVar.D;
        this.E = hVar.E;
        this.F = hVar.F;
        this.G = hVar.G;
        this.H = hVar.H;
        this.I = hVar.I;
        this.J = hVar.J;
        this.K = hVar.K;
        this.L = hVar.L;
        this.M = hVar.M;
        this.N = hVar.N;
        this.O = hVar.O;
        this.P = hVar.P;
        this.Q = hVar.Q;
        this.R = hVar.R;
        this.S = hVar.S;
        this.T = hVar.T;
        this.U = hVar.U;
        this.V = hVar.V;
        this.W = hVar.W;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
        if (!Float.isNaN(this.M)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.N)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.O)) {
            attributes.add(f.f3647i);
        }
        if (!Float.isNaN(this.Q)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.R)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.S)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.T)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.P)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.U)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.V)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.W)) {
            attributes.add("translationZ");
        }
        if (this.f3669e.size() > 0) {
            Iterator<String> it2 = this.f3669e.keySet().iterator();
            while (it2.hasNext()) {
                attributes.add("CUSTOM," + it2.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void f(Context context, AttributeSet attrs) {
        a.b(this, context.obtainStyledAttributes(attrs, R.styleable.KeyCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void j(String tag, Object value) {
        tag.hashCode();
        switch (tag) {
            case "motionProgress":
                this.K = m(value);
                break;
            case "transitionEasing":
                this.D = value.toString();
                break;
            case "rotationX":
                this.Q = m(value);
                break;
            case "rotationY":
                this.R = m(value);
                break;
            case "translationX":
                this.U = m(value);
                break;
            case "translationY":
                this.V = m(value);
                break;
            case "translationZ":
                this.W = m(value);
                break;
            case "scaleX":
                this.S = m(value);
                break;
            case "scaleY":
                this.T = m(value);
                break;
            case "rotation":
                this.O = m(value);
                break;
            case "elevation":
                this.N = m(value);
                break;
            case "transitionPathRotate":
                this.P = m(value);
                break;
            case "alpha":
                this.M = m(value);
                break;
            case "waveOffset":
                this.I = m(value);
                break;
            case "wavePeriod":
                this.H = m(value);
                break;
            case "curveFit":
                this.E = n(value);
                break;
            case "wavePhase":
                this.J = m(value);
                break;
            case "waveShape":
                if (!(value instanceof Integer)) {
                    this.F = 7;
                    this.G = value.toString();
                    break;
                } else {
                    this.F = n(value);
                    break;
                }
                break;
        }
    }
}
