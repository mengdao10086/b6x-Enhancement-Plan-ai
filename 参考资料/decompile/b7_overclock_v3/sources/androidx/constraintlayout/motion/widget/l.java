package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class l extends f {
    public static final String V = "KeyTimeCycle";
    public static final String W = "KeyTimeCycle";
    public static final String X = "wavePeriod";
    public static final String Y = "waveOffset";
    public static final String Z = "waveShape";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f3745a0 = 0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f3746b0 = 1;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f3747c0 = 2;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f3748d0 = 3;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f3749e0 = 4;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f3750f0 = 5;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f3751g0 = 6;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f3752h0 = 3;
    public String D;
    public int E = -1;
    public float F = Float.NaN;
    public float G = Float.NaN;
    public float H = Float.NaN;
    public float I = Float.NaN;
    public float J = Float.NaN;
    public float K = Float.NaN;
    public float L = Float.NaN;
    public float M = Float.NaN;
    public float N = Float.NaN;
    public float O = Float.NaN;
    public float P = Float.NaN;
    public float Q = Float.NaN;
    public int R = 0;
    public String S = null;
    public float T = Float.NaN;
    public float U = 0.0f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3753a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3754b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f3755c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f3756d = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f3757e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f3758f = 8;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f3759g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f3760h = 9;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f3761i = 10;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f3762j = 12;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f3763k = 13;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f3764l = 14;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f3765m = 15;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f3766n = 16;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f3767o = 17;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f3768p = 18;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f3769q = 19;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f3770r = 20;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f3771s = 21;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static SparseIntArray f3772t;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3772t = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            f3772t.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            f3772t.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            f3772t.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            f3772t.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            f3772t.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            f3772t.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            f3772t.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            f3772t.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            f3772t.append(R.styleable.KeyTimeCycle_framePosition, 12);
            f3772t.append(R.styleable.KeyTimeCycle_curveFit, 13);
            f3772t.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            f3772t.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            f3772t.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            f3772t.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            f3772t.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            f3772t.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            f3772t.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            f3772t.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(l c10, TypedArray a10) {
            int indexCount = a10.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = a10.getIndex(i10);
                switch (f3772t.get(index)) {
                    case 1:
                        c10.F = a10.getFloat(index, c10.F);
                        break;
                    case 2:
                        c10.G = a10.getDimension(index, c10.G);
                        break;
                    case 3:
                    case 11:
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("unused attribute 0x");
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(f3772t.get(index));
                        break;
                    case 4:
                        c10.H = a10.getFloat(index, c10.H);
                        break;
                    case 5:
                        c10.I = a10.getFloat(index, c10.I);
                        break;
                    case 6:
                        c10.J = a10.getFloat(index, c10.J);
                        break;
                    case 7:
                        c10.L = a10.getFloat(index, c10.L);
                        break;
                    case 8:
                        c10.K = a10.getFloat(index, c10.K);
                        break;
                    case 9:
                        c10.D = a10.getString(index);
                        break;
                    case 10:
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
                    case 12:
                        c10.f3665a = a10.getInt(index, c10.f3665a);
                        break;
                    case 13:
                        c10.E = a10.getInteger(index, c10.E);
                        break;
                    case 14:
                        c10.M = a10.getFloat(index, c10.M);
                        break;
                    case 15:
                        c10.N = a10.getDimension(index, c10.N);
                        break;
                    case 16:
                        c10.O = a10.getDimension(index, c10.O);
                        break;
                    case 17:
                        c10.P = a10.getDimension(index, c10.P);
                        break;
                    case 18:
                        c10.Q = a10.getFloat(index, c10.Q);
                        break;
                    case 19:
                        if (a10.peekValue(index).type == 3) {
                            c10.S = a10.getString(index);
                            c10.R = 7;
                        } else {
                            c10.R = a10.getInt(index, c10.R);
                        }
                        break;
                    case 20:
                        c10.T = a10.getFloat(index, c10.T);
                        break;
                    case 21:
                        if (a10.peekValue(index).type == 5) {
                            c10.U = a10.getDimension(index, c10.U);
                        } else {
                            c10.U = a10.getFloat(index, c10.U);
                        }
                        break;
                }
            }
        }
    }

    public l() {
        this.f3668d = 3;
        this.f3669e = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W(java.util.HashMap<java.lang.String, a0.f> r11) {
        /*
            Method dump skipped, instruction units count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.l.W(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, a0.d> splines) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new l().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        l lVar = (l) src;
        this.D = lVar.D;
        this.E = lVar.E;
        this.R = lVar.R;
        this.T = lVar.T;
        this.U = lVar.U;
        this.Q = lVar.Q;
        this.F = lVar.F;
        this.G = lVar.G;
        this.H = lVar.H;
        this.K = lVar.K;
        this.I = lVar.I;
        this.J = lVar.J;
        this.L = lVar.L;
        this.M = lVar.M;
        this.N = lVar.N;
        this.O = lVar.O;
        this.P = lVar.P;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
        if (!Float.isNaN(this.F)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.G)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.H)) {
            attributes.add(f.f3647i);
        }
        if (!Float.isNaN(this.I)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.J)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.N)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.O)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.P)) {
            attributes.add("translationZ");
        }
        if (!Float.isNaN(this.K)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.L)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.M)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.Q)) {
            attributes.add("progress");
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
        a.a(this, context.obtainStyledAttributes(attrs, R.styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void i(HashMap<String, Integer> interpolation) {
        if (this.E == -1) {
            return;
        }
        if (!Float.isNaN(this.F)) {
            interpolation.put("alpha", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.G)) {
            interpolation.put("elevation", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.H)) {
            interpolation.put(f.f3647i, Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.I)) {
            interpolation.put("rotationX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.J)) {
            interpolation.put("rotationY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.N)) {
            interpolation.put("translationX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.O)) {
            interpolation.put("translationY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.P)) {
            interpolation.put("translationZ", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.K)) {
            interpolation.put("transitionPathRotate", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.L)) {
            interpolation.put("scaleX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.L)) {
            interpolation.put("scaleY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.Q)) {
            interpolation.put("progress", Integer.valueOf(this.E));
        }
        if (this.f3669e.size() > 0) {
            Iterator<String> it2 = this.f3669e.keySet().iterator();
            while (it2.hasNext()) {
                interpolation.put("CUSTOM," + it2.next(), Integer.valueOf(this.E));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void j(String tag, Object value) {
        tag.hashCode();
        switch (tag) {
            case "motionProgress":
                this.Q = m(value);
                break;
            case "transitionEasing":
                this.D = value.toString();
                break;
            case "rotationX":
                this.I = m(value);
                break;
            case "rotationY":
                this.J = m(value);
                break;
            case "translationX":
                this.N = m(value);
                break;
            case "translationY":
                this.O = m(value);
                break;
            case "translationZ":
                this.P = m(value);
                break;
            case "scaleX":
                this.L = m(value);
                break;
            case "scaleY":
                this.M = m(value);
                break;
            case "rotation":
                this.H = m(value);
                break;
            case "elevation":
                this.G = m(value);
                break;
            case "transitionPathRotate":
                this.K = m(value);
                break;
            case "alpha":
                this.F = m(value);
                break;
            case "waveOffset":
                this.U = m(value);
                break;
            case "wavePeriod":
                this.T = m(value);
                break;
            case "curveFit":
                this.E = n(value);
                break;
            case "waveShape":
                if (!(value instanceof Integer)) {
                    this.R = 7;
                    this.S = value.toString();
                    break;
                } else {
                    this.R = n(value);
                    break;
                }
                break;
        }
    }
}
