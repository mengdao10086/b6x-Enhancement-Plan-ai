package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ConstraintReference implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3066a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f3067a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final State f3068b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f3069b0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public Dimension f3073d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Dimension f3075e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public Object f3077f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ConstraintWidget f3079g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public HashMap<String, Integer> f3081h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public HashMap<String, Float> f3083i0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3070c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x.e f3072d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3074e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3076f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3078g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3080h = -1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3082i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3084j = 0.5f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3085k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3086l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3087m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3088n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3089o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3090p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3091q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3092r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3093s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3094t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3095u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3096v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3097w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3098x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f3099y = Float.NaN;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3100z = Float.NaN;
    public float A = Float.NaN;
    public float B = Float.NaN;
    public float C = Float.NaN;
    public float D = Float.NaN;
    public float E = Float.NaN;
    public float F = Float.NaN;
    public float G = Float.NaN;
    public float H = Float.NaN;
    public float I = Float.NaN;
    public int J = 0;
    public Object K = null;
    public Object L = null;
    public Object M = null;
    public Object N = null;
    public Object O = null;
    public Object P = null;
    public Object Q = null;
    public Object R = null;
    public Object S = null;
    public Object T = null;
    public Object U = null;
    public Object V = null;
    public Object W = null;
    public Object X = null;
    public Object Y = null;
    public Object Z = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public State.Constraint f3071c0 = null;

    public static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.mErrors = arrayList;
        }

        public ArrayList<String> a() {
            return this.mErrors;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3101a;

        static {
            int[] iArr = new int[State.Constraint.values().length];
            f3101a = iArr;
            try {
                iArr[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3101a[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3101a[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3101a[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3101a[State.Constraint.START_TO_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3101a[State.Constraint.START_TO_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3101a[State.Constraint.END_TO_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3101a[State.Constraint.END_TO_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3101a[State.Constraint.TOP_TO_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3101a[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3101a[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3101a[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3101a[State.Constraint.BASELINE_TO_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3101a[State.Constraint.BASELINE_TO_TOP.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3101a[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3101a[State.Constraint.CIRCULAR_CONSTRAINT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3101a[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f3101a[State.Constraint.CENTER_VERTICALLY.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public interface b {
        ConstraintReference a(State state);
    }

    public ConstraintReference(State state) {
        Object obj = Dimension.f3103j;
        this.f3073d0 = Dimension.b(obj);
        this.f3075e0 = Dimension.b(obj);
        this.f3081h0 = new HashMap<>();
        this.f3083i0 = new HashMap<>();
        this.f3068b = state;
    }

    public ConstraintReference A(Object obj) {
        this.f3071c0 = State.Constraint.END_TO_START;
        this.Q = obj;
        return this;
    }

    public ConstraintReference A0(Object obj) {
        this.f3071c0 = State.Constraint.START_TO_START;
        this.O = obj;
        return this;
    }

    public final Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof ConstraintReference) ? this.f3068b.r(obj) : obj;
    }

    public ConstraintReference B0() {
        if (this.S != null) {
            this.f3071c0 = State.Constraint.TOP_TO_TOP;
        } else {
            this.f3071c0 = State.Constraint.TOP_TO_BOTTOM;
        }
        return this;
    }

    public float C() {
        return this.G;
    }

    public ConstraintReference C0(Object obj) {
        this.f3071c0 = State.Constraint.TOP_TO_BOTTOM;
        this.T = obj;
        return this;
    }

    public Dimension D() {
        return this.f3075e0;
    }

    public ConstraintReference D0(Object obj) {
        this.f3071c0 = State.Constraint.TOP_TO_TOP;
        this.S = obj;
        return this;
    }

    public int E() {
        return this.f3074e;
    }

    public ConstraintReference E0(float f10) {
        this.D = f10;
        return this;
    }

    public float F() {
        return this.f3078g;
    }

    public ConstraintReference F0(float f10) {
        this.E = f10;
        return this;
    }

    public float G() {
        return this.f3099y;
    }

    public ConstraintReference G0(float f10) {
        this.F = f10;
        return this;
    }

    public float H() {
        return this.f3100z;
    }

    public void H0() throws IncorrectConstraintException {
        ArrayList arrayList = new ArrayList();
        if (this.K != null && this.L != null) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (this.M != null && this.N != null) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (this.O != null && this.P != null) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (this.Q != null && this.R != null) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if ((this.K != null || this.L != null || this.M != null || this.N != null) && (this.O != null || this.P != null || this.Q != null || this.R != null)) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new IncorrectConstraintException(arrayList);
        }
    }

    public float I() {
        return this.A;
    }

    public ConstraintReference I0(float f10) {
        this.f3084j = f10;
        return this;
    }

    public float J() {
        return this.B;
    }

    public ConstraintReference J0(int i10) {
        this.J = i10;
        return this;
    }

    public float K() {
        return this.C;
    }

    public ConstraintReference K0(Dimension dimension) {
        return x0(dimension);
    }

    public float L() {
        return this.H;
    }

    public float M() {
        return this.I;
    }

    public String N() {
        return this.f3070c;
    }

    public final ConstraintWidget O(Object obj) {
        if (obj instanceof c) {
            return ((c) obj).a();
        }
        return null;
    }

    public float P() {
        return this.D;
    }

    public float Q() {
        return this.E;
    }

    public float R() {
        return this.F;
    }

    public int S(int i10) {
        return this.f3076f;
    }

    public float T() {
        return this.f3080h;
    }

    public Object U() {
        return this.f3077f0;
    }

    public Dimension V() {
        return this.f3073d0;
    }

    public ConstraintReference W(Dimension dimension) {
        return q0(dimension);
    }

    public ConstraintReference X(float f10) {
        this.f3082i = f10;
        return this;
    }

    public ConstraintReference Y() {
        if (this.K != null) {
            this.f3071c0 = State.Constraint.LEFT_TO_LEFT;
        } else {
            this.f3071c0 = State.Constraint.LEFT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference Z(Object obj) {
        this.f3071c0 = State.Constraint.LEFT_TO_LEFT;
        this.K = obj;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.c
    public ConstraintWidget a() {
        if (this.f3079g0 == null) {
            ConstraintWidget constraintWidgetW = w();
            this.f3079g0 = constraintWidgetW;
            constraintWidgetW.h1(this.f3077f0);
        }
        return this.f3079g0;
    }

    public ConstraintReference a0(Object obj) {
        this.f3071c0 = State.Constraint.LEFT_TO_RIGHT;
        this.L = obj;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.c
    public void apply() {
        if (this.f3079g0 == null) {
            return;
        }
        x.e eVar = this.f3072d;
        if (eVar != null) {
            eVar.apply();
        }
        this.f3073d0.j(this.f3068b, this.f3079g0, 0);
        this.f3075e0.j(this.f3068b, this.f3079g0, 1);
        x();
        h(this.f3079g0, this.K, State.Constraint.LEFT_TO_LEFT);
        h(this.f3079g0, this.L, State.Constraint.LEFT_TO_RIGHT);
        h(this.f3079g0, this.M, State.Constraint.RIGHT_TO_LEFT);
        h(this.f3079g0, this.N, State.Constraint.RIGHT_TO_RIGHT);
        h(this.f3079g0, this.O, State.Constraint.START_TO_START);
        h(this.f3079g0, this.P, State.Constraint.START_TO_END);
        h(this.f3079g0, this.Q, State.Constraint.END_TO_START);
        h(this.f3079g0, this.R, State.Constraint.END_TO_END);
        h(this.f3079g0, this.S, State.Constraint.TOP_TO_TOP);
        h(this.f3079g0, this.T, State.Constraint.TOP_TO_BOTTOM);
        h(this.f3079g0, this.U, State.Constraint.BOTTOM_TO_TOP);
        h(this.f3079g0, this.V, State.Constraint.BOTTOM_TO_BOTTOM);
        h(this.f3079g0, this.W, State.Constraint.BASELINE_TO_BASELINE);
        h(this.f3079g0, this.X, State.Constraint.BASELINE_TO_TOP);
        h(this.f3079g0, this.Y, State.Constraint.BASELINE_TO_BOTTOM);
        h(this.f3079g0, this.Z, State.Constraint.CIRCULAR_CONSTRAINT);
        int i10 = this.f3074e;
        if (i10 != 0) {
            this.f3079g0.B1(i10);
        }
        int i11 = this.f3076f;
        if (i11 != 0) {
            this.f3079g0.W1(i11);
        }
        float f10 = this.f3078g;
        if (f10 != -1.0f) {
            this.f3079g0.F1(f10);
        }
        float f11 = this.f3080h;
        if (f11 != -1.0f) {
            this.f3079g0.a2(f11);
        }
        this.f3079g0.A1(this.f3082i);
        this.f3079g0.V1(this.f3084j);
        ConstraintWidget constraintWidget = this.f3079g0;
        o oVar = constraintWidget.f3261n;
        oVar.f3182f = this.f3099y;
        oVar.f3183g = this.f3100z;
        oVar.f3184h = this.A;
        oVar.f3185i = this.B;
        oVar.f3186j = this.C;
        oVar.f3187k = this.D;
        oVar.f3188l = this.E;
        oVar.f3189m = this.F;
        oVar.f3190n = this.H;
        oVar.f3191o = this.I;
        oVar.f3192p = this.G;
        int i12 = this.J;
        oVar.f3194r = i12;
        constraintWidget.b2(i12);
        HashMap<String, Integer> map = this.f3081h0;
        if (map != null) {
            for (String str : map.keySet()) {
                this.f3079g0.f3261n.w(str, 902, this.f3081h0.get(str).intValue());
            }
        }
        HashMap<String, Float> map2 = this.f3083i0;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                this.f3079g0.f3261n.v(str2, 901, this.f3083i0.get(str2).floatValue());
            }
        }
    }

    @Override // androidx.constraintlayout.core.state.c
    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return;
        }
        this.f3079g0 = constraintWidget;
        constraintWidget.h1(this.f3077f0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ConstraintReference b0(int i10) {
        State.Constraint constraint = this.f3071c0;
        if (constraint != null) {
            switch (a.f3101a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.f3085k = i10;
                    break;
                case 3:
                case 4:
                    this.f3086l = i10;
                    break;
                case 5:
                case 6:
                    this.f3087m = i10;
                    break;
                case 7:
                case 8:
                    this.f3088n = i10;
                    break;
                case 9:
                case 10:
                    this.f3089o = i10;
                    break;
                case 11:
                case 12:
                    this.f3090p = i10;
                    break;
                case 13:
                case 14:
                case 15:
                    this.f3097w = i10;
                    break;
                case 16:
                    this.f3069b0 = i10;
                    break;
            }
        } else {
            this.f3085k = i10;
            this.f3086l = i10;
            this.f3087m = i10;
            this.f3088n = i10;
            this.f3089o = i10;
            this.f3090p = i10;
        }
        return this;
    }

    @Override // androidx.constraintlayout.core.state.c
    public void c(Object obj) {
        this.f3066a = obj;
    }

    public ConstraintReference c0(Object obj) {
        return b0(this.f3068b.f(obj));
    }

    @Override // androidx.constraintlayout.core.state.c
    public x.e d() {
        return this.f3072d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ConstraintReference d0(int i10) {
        State.Constraint constraint = this.f3071c0;
        if (constraint != null) {
            switch (a.f3101a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.f3091q = i10;
                    break;
                case 3:
                case 4:
                    this.f3092r = i10;
                    break;
                case 5:
                case 6:
                    this.f3093s = i10;
                    break;
                case 7:
                case 8:
                    this.f3094t = i10;
                    break;
                case 9:
                case 10:
                    this.f3095u = i10;
                    break;
                case 11:
                case 12:
                    this.f3096v = i10;
                    break;
                case 13:
                case 14:
                case 15:
                    this.f3098x = i10;
                    break;
            }
        } else {
            this.f3091q = i10;
            this.f3092r = i10;
            this.f3093s = i10;
            this.f3094t = i10;
            this.f3095u = i10;
            this.f3096v = i10;
        }
        return this;
    }

    public void e(String str, int i10) {
        this.f3081h0.put(str, Integer.valueOf(i10));
    }

    public ConstraintReference e0(Object obj) {
        return d0(this.f3068b.f(obj));
    }

    public void f(String str, float f10) {
        if (this.f3083i0 == null) {
            this.f3083i0 = new HashMap<>();
        }
        this.f3083i0.put(str, Float.valueOf(f10));
    }

    public ConstraintReference f0(float f10) {
        this.f3099y = f10;
        return this;
    }

    public ConstraintReference g(float f10) {
        this.G = f10;
        return this;
    }

    public ConstraintReference g0(float f10) {
        this.f3100z = f10;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.c
    public Object getKey() {
        return this.f3066a;
    }

    public final void h(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget constraintWidgetO = O(obj);
        if (constraintWidgetO == null) {
        }
        int[] iArr = a.f3101a;
        int i10 = iArr[constraint.ordinal()];
        switch (iArr[constraint.ordinal()]) {
            case 1:
                ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                constraintWidget.r(type).b(constraintWidgetO.r(type), this.f3085k, this.f3091q, false);
                break;
            case 2:
                constraintWidget.r(ConstraintAnchor.Type.LEFT).b(constraintWidgetO.r(ConstraintAnchor.Type.RIGHT), this.f3085k, this.f3091q, false);
                break;
            case 3:
                constraintWidget.r(ConstraintAnchor.Type.RIGHT).b(constraintWidgetO.r(ConstraintAnchor.Type.LEFT), this.f3086l, this.f3092r, false);
                break;
            case 4:
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.r(type2).b(constraintWidgetO.r(type2), this.f3086l, this.f3092r, false);
                break;
            case 5:
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.LEFT;
                constraintWidget.r(type3).b(constraintWidgetO.r(type3), this.f3087m, this.f3093s, false);
                break;
            case 6:
                constraintWidget.r(ConstraintAnchor.Type.LEFT).b(constraintWidgetO.r(ConstraintAnchor.Type.RIGHT), this.f3087m, this.f3093s, false);
                break;
            case 7:
                constraintWidget.r(ConstraintAnchor.Type.RIGHT).b(constraintWidgetO.r(ConstraintAnchor.Type.LEFT), this.f3088n, this.f3094t, false);
                break;
            case 8:
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.r(type4).b(constraintWidgetO.r(type4), this.f3088n, this.f3094t, false);
                break;
            case 9:
                ConstraintAnchor.Type type5 = ConstraintAnchor.Type.TOP;
                constraintWidget.r(type5).b(constraintWidgetO.r(type5), this.f3089o, this.f3095u, false);
                break;
            case 10:
                constraintWidget.r(ConstraintAnchor.Type.TOP).b(constraintWidgetO.r(ConstraintAnchor.Type.BOTTOM), this.f3089o, this.f3095u, false);
                break;
            case 11:
                constraintWidget.r(ConstraintAnchor.Type.BOTTOM).b(constraintWidgetO.r(ConstraintAnchor.Type.TOP), this.f3090p, this.f3096v, false);
                break;
            case 12:
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.BOTTOM;
                constraintWidget.r(type6).b(constraintWidgetO.r(type6), this.f3090p, this.f3096v, false);
                break;
            case 13:
                constraintWidget.v0(ConstraintAnchor.Type.BASELINE, constraintWidgetO, ConstraintAnchor.Type.BOTTOM, this.f3097w, this.f3098x);
                break;
            case 14:
                constraintWidget.v0(ConstraintAnchor.Type.BASELINE, constraintWidgetO, ConstraintAnchor.Type.TOP, this.f3097w, this.f3098x);
                break;
            case 15:
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BASELINE;
                constraintWidget.v0(type7, constraintWidgetO, type7, this.f3097w, this.f3098x);
                break;
            case 16:
                constraintWidget.m(constraintWidgetO, this.f3067a0, (int) this.f3069b0);
                break;
        }
    }

    public ConstraintReference h0() {
        if (this.M != null) {
            this.f3071c0 = State.Constraint.RIGHT_TO_LEFT;
        } else {
            this.f3071c0 = State.Constraint.RIGHT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference i() {
        this.f3071c0 = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference i0(Object obj) {
        this.f3071c0 = State.Constraint.RIGHT_TO_LEFT;
        this.M = obj;
        return this;
    }

    public ConstraintReference j(Object obj) {
        this.f3071c0 = State.Constraint.BASELINE_TO_BASELINE;
        this.W = obj;
        return this;
    }

    public ConstraintReference j0(Object obj) {
        this.f3071c0 = State.Constraint.RIGHT_TO_RIGHT;
        this.N = obj;
        return this;
    }

    public ConstraintReference k(Object obj) {
        this.f3071c0 = State.Constraint.BASELINE_TO_BOTTOM;
        this.Y = obj;
        return this;
    }

    public ConstraintReference k0(float f10) {
        this.A = f10;
        return this;
    }

    public ConstraintReference l(Object obj) {
        this.f3071c0 = State.Constraint.BASELINE_TO_TOP;
        this.X = obj;
        return this;
    }

    public ConstraintReference l0(float f10) {
        this.B = f10;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.constraintlayout.core.state.ConstraintReference m(float r3) {
        /*
            r2 = this;
            androidx.constraintlayout.core.state.State$Constraint r0 = r2.f3071c0
            if (r0 != 0) goto L5
            return r2
        L5:
            int[] r1 = androidx.constraintlayout.core.state.ConstraintReference.a.f3101a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 17
            if (r0 == r1) goto L1c
            r1 = 18
            if (r0 == r1) goto L19
            switch(r0) {
                case 1: goto L1c;
                case 2: goto L1c;
                case 3: goto L1c;
                case 4: goto L1c;
                case 5: goto L1c;
                case 6: goto L1c;
                case 7: goto L1c;
                case 8: goto L1c;
                case 9: goto L19;
                case 10: goto L19;
                case 11: goto L19;
                case 12: goto L19;
                default: goto L18;
            }
        L18:
            goto L1e
        L19:
            r2.f3084j = r3
            goto L1e
        L1c:
            r2.f3082i = r3
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintReference.m(float):androidx.constraintlayout.core.state.ConstraintReference");
    }

    public ConstraintReference m0(float f10) {
        this.C = f10;
        return this;
    }

    public ConstraintReference n() {
        if (this.U != null) {
            this.f3071c0 = State.Constraint.BOTTOM_TO_TOP;
        } else {
            this.f3071c0 = State.Constraint.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference n0(float f10) {
        this.H = f10;
        return this;
    }

    public ConstraintReference o(Object obj) {
        this.f3071c0 = State.Constraint.BOTTOM_TO_BOTTOM;
        this.V = obj;
        return this;
    }

    public ConstraintReference o0(float f10) {
        this.I = f10;
        return this;
    }

    public ConstraintReference p(Object obj) {
        this.f3071c0 = State.Constraint.BOTTOM_TO_TOP;
        this.U = obj;
        return this;
    }

    public void p0(x.e eVar) {
        this.f3072d = eVar;
        if (eVar != null) {
            b(eVar.a());
        }
    }

    public ConstraintReference q(Object obj) {
        Object objB = B(obj);
        this.O = objB;
        this.R = objB;
        this.f3071c0 = State.Constraint.CENTER_HORIZONTALLY;
        this.f3082i = 0.5f;
        return this;
    }

    public ConstraintReference q0(Dimension dimension) {
        this.f3075e0 = dimension;
        return this;
    }

    public ConstraintReference r(Object obj) {
        Object objB = B(obj);
        this.S = objB;
        this.V = objB;
        this.f3071c0 = State.Constraint.CENTER_VERTICALLY;
        this.f3084j = 0.5f;
        return this;
    }

    public void r0(int i10) {
        this.f3074e = i10;
    }

    public ConstraintReference s(Object obj, float f10, float f11) {
        this.Z = B(obj);
        this.f3067a0 = f10;
        this.f3069b0 = f11;
        this.f3071c0 = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    public void s0(float f10) {
        this.f3078g = f10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ConstraintReference t() {
        State.Constraint constraint = this.f3071c0;
        if (constraint != null) {
            switch (a.f3101a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.K = null;
                    this.L = null;
                    this.f3085k = 0;
                    this.f3091q = 0;
                    break;
                case 3:
                case 4:
                    this.M = null;
                    this.N = null;
                    this.f3086l = 0;
                    this.f3092r = 0;
                    break;
                case 5:
                case 6:
                    this.O = null;
                    this.P = null;
                    this.f3087m = 0;
                    this.f3093s = 0;
                    break;
                case 7:
                case 8:
                    this.Q = null;
                    this.R = null;
                    this.f3088n = 0;
                    this.f3094t = 0;
                    break;
                case 9:
                case 10:
                    this.S = null;
                    this.T = null;
                    this.f3089o = 0;
                    this.f3095u = 0;
                    break;
                case 11:
                case 12:
                    this.U = null;
                    this.V = null;
                    this.f3090p = 0;
                    this.f3096v = 0;
                    break;
                case 15:
                    this.W = null;
                    break;
                case 16:
                    this.Z = null;
                    break;
            }
        } else {
            this.K = null;
            this.L = null;
            this.f3085k = 0;
            this.M = null;
            this.N = null;
            this.f3086l = 0;
            this.O = null;
            this.P = null;
            this.f3087m = 0;
            this.Q = null;
            this.R = null;
            this.f3088n = 0;
            this.S = null;
            this.T = null;
            this.f3089o = 0;
            this.U = null;
            this.V = null;
            this.f3090p = 0;
            this.W = null;
            this.Z = null;
            this.f3082i = 0.5f;
            this.f3084j = 0.5f;
            this.f3091q = 0;
            this.f3092r = 0;
            this.f3093s = 0;
            this.f3094t = 0;
            this.f3095u = 0;
            this.f3096v = 0;
        }
        return this;
    }

    public void t0(String str) {
        this.f3070c = str;
    }

    public ConstraintReference u() {
        y0().t();
        y().t();
        Y().t();
        h0().t();
        return this;
    }

    public void u0(int i10) {
        this.f3076f = i10;
    }

    public ConstraintReference v() {
        B0().t();
        i().t();
        n().t();
        return this;
    }

    public void v0(float f10) {
        this.f3080h = f10;
    }

    public ConstraintWidget w() {
        return new ConstraintWidget(V().n(), D().n());
    }

    public void w0(Object obj) {
        this.f3077f0 = obj;
        ConstraintWidget constraintWidget = this.f3079g0;
        if (constraintWidget != null) {
            constraintWidget.h1(obj);
        }
    }

    public final void x() {
        this.K = B(this.K);
        this.L = B(this.L);
        this.M = B(this.M);
        this.N = B(this.N);
        this.O = B(this.O);
        this.P = B(this.P);
        this.Q = B(this.Q);
        this.R = B(this.R);
        this.S = B(this.S);
        this.T = B(this.T);
        this.U = B(this.U);
        this.V = B(this.V);
        this.W = B(this.W);
        this.X = B(this.X);
        this.Y = B(this.Y);
    }

    public ConstraintReference x0(Dimension dimension) {
        this.f3073d0 = dimension;
        return this;
    }

    public ConstraintReference y() {
        if (this.Q != null) {
            this.f3071c0 = State.Constraint.END_TO_START;
        } else {
            this.f3071c0 = State.Constraint.END_TO_END;
        }
        return this;
    }

    public ConstraintReference y0() {
        if (this.O != null) {
            this.f3071c0 = State.Constraint.START_TO_START;
        } else {
            this.f3071c0 = State.Constraint.START_TO_END;
        }
        return this;
    }

    public ConstraintReference z(Object obj) {
        this.f3071c0 = State.Constraint.END_TO_END;
        this.R = obj;
        return this;
    }

    public ConstraintReference z0(Object obj) {
        this.f3071c0 = State.Constraint.START_TO_END;
        this.P = obj;
        return this;
    }
}
