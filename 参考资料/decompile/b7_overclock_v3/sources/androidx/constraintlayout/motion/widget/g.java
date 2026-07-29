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
public class g extends f {
    public static final String U = "KeyAttribute";
    public static final String V = "KeyAttributes";
    public static final boolean W = false;
    public static final int X = 1;
    public String D;
    public int E = -1;
    public boolean F = false;
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
    public float R = Float.NaN;
    public float S = Float.NaN;
    public float T = Float.NaN;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3670a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3671b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f3672c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f3673d = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f3674e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f3675f = 8;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f3676g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f3677h = 9;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f3678i = 10;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f3679j = 12;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f3680k = 13;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f3681l = 14;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f3682m = 15;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f3683n = 16;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f3684o = 17;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f3685p = 18;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f3686q = 19;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f3687r = 20;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static SparseIntArray f3688s;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3688s = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            f3688s.append(R.styleable.KeyAttribute_android_elevation, 2);
            f3688s.append(R.styleable.KeyAttribute_android_rotation, 4);
            f3688s.append(R.styleable.KeyAttribute_android_rotationX, 5);
            f3688s.append(R.styleable.KeyAttribute_android_rotationY, 6);
            f3688s.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            f3688s.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            f3688s.append(R.styleable.KeyAttribute_android_scaleX, 7);
            f3688s.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            f3688s.append(R.styleable.KeyAttribute_transitionEasing, 9);
            f3688s.append(R.styleable.KeyAttribute_motionTarget, 10);
            f3688s.append(R.styleable.KeyAttribute_framePosition, 12);
            f3688s.append(R.styleable.KeyAttribute_curveFit, 13);
            f3688s.append(R.styleable.KeyAttribute_android_scaleY, 14);
            f3688s.append(R.styleable.KeyAttribute_android_translationX, 15);
            f3688s.append(R.styleable.KeyAttribute_android_translationY, 16);
            f3688s.append(R.styleable.KeyAttribute_android_translationZ, 17);
            f3688s.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(g c10, TypedArray a10) {
            int indexCount = a10.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = a10.getIndex(i10);
                switch (f3688s.get(index)) {
                    case 1:
                        c10.G = a10.getFloat(index, c10.G);
                        break;
                    case 2:
                        c10.H = a10.getDimension(index, c10.H);
                        break;
                    case 3:
                    case 11:
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("unused attribute 0x");
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(f3688s.get(index));
                        break;
                    case 4:
                        c10.I = a10.getFloat(index, c10.I);
                        break;
                    case 5:
                        c10.J = a10.getFloat(index, c10.J);
                        break;
                    case 6:
                        c10.K = a10.getFloat(index, c10.K);
                        break;
                    case 7:
                        c10.O = a10.getFloat(index, c10.O);
                        break;
                    case 8:
                        c10.N = a10.getFloat(index, c10.N);
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
                        c10.P = a10.getFloat(index, c10.P);
                        break;
                    case 15:
                        c10.Q = a10.getDimension(index, c10.Q);
                        break;
                    case 16:
                        c10.R = a10.getDimension(index, c10.R);
                        break;
                    case 17:
                        c10.S = a10.getDimension(index, c10.S);
                        break;
                    case 18:
                        c10.T = a10.getFloat(index, c10.T);
                        break;
                    case 19:
                        c10.L = a10.getDimension(index, c10.L);
                        break;
                    case 20:
                        c10.M = a10.getDimension(index, c10.M);
                        break;
                }
            }
        }
    }

    public g() {
        this.f3668d = 1;
        this.f3669e = new HashMap<>();
    }

    public int T() {
        return this.E;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    @Override // androidx.constraintlayout.motion.widget.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.HashMap<java.lang.String, a0.d> r7) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.g.a(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new g().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        g gVar = (g) src;
        this.E = gVar.E;
        this.F = gVar.F;
        this.G = gVar.G;
        this.H = gVar.H;
        this.I = gVar.I;
        this.J = gVar.J;
        this.K = gVar.K;
        this.L = gVar.L;
        this.M = gVar.M;
        this.N = gVar.N;
        this.O = gVar.O;
        this.P = gVar.P;
        this.Q = gVar.Q;
        this.R = gVar.R;
        this.S = gVar.S;
        this.T = gVar.T;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
        if (!Float.isNaN(this.G)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.H)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.I)) {
            attributes.add(f.f3647i);
        }
        if (!Float.isNaN(this.J)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.K)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.L)) {
            attributes.add(f.f3650l);
        }
        if (!Float.isNaN(this.M)) {
            attributes.add(f.f3651m);
        }
        if (!Float.isNaN(this.Q)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.R)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.S)) {
            attributes.add("translationZ");
        }
        if (!Float.isNaN(this.N)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.O)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.P)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.T)) {
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
        a.a(this, context.obtainStyledAttributes(attrs, R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void i(HashMap<String, Integer> interpolation) {
        if (this.E == -1) {
            return;
        }
        if (!Float.isNaN(this.G)) {
            interpolation.put("alpha", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.H)) {
            interpolation.put("elevation", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.I)) {
            interpolation.put(f.f3647i, Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.J)) {
            interpolation.put("rotationX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.K)) {
            interpolation.put("rotationY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.L)) {
            interpolation.put(f.f3650l, Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.M)) {
            interpolation.put(f.f3651m, Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.Q)) {
            interpolation.put("translationX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.R)) {
            interpolation.put("translationY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.S)) {
            interpolation.put("translationZ", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.N)) {
            interpolation.put("transitionPathRotate", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.O)) {
            interpolation.put("scaleX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.P)) {
            interpolation.put("scaleY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.T)) {
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
                this.T = m(value);
                break;
            case "transitionEasing":
                this.D = value.toString();
                break;
            case "rotationX":
                this.J = m(value);
                break;
            case "rotationY":
                this.K = m(value);
                break;
            case "translationX":
                this.Q = m(value);
                break;
            case "translationY":
                this.R = m(value);
                break;
            case "translationZ":
                this.S = m(value);
                break;
            case "scaleX":
                this.O = m(value);
                break;
            case "scaleY":
                this.P = m(value);
                break;
            case "transformPivotX":
                this.L = m(value);
                break;
            case "transformPivotY":
                this.M = m(value);
                break;
            case "rotation":
                this.I = m(value);
                break;
            case "elevation":
                this.H = m(value);
                break;
            case "transitionPathRotate":
                this.N = m(value);
                break;
            case "alpha":
                this.G = m(value);
                break;
            case "curveFit":
                this.E = n(value);
                break;
            case "visibility":
                this.F = l(value);
                break;
        }
    }
}
