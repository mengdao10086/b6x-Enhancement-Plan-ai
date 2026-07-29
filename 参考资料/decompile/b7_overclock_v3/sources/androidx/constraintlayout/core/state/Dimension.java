package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes2.dex */
public class Dimension {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f3102i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f3103j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f3104k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f3105l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f3106m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f3107n = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f3114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3115h;

    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    public Dimension() {
        this.f3108a = -2;
        this.f3109b = 0;
        this.f3110c = Integer.MAX_VALUE;
        this.f3111d = 1.0f;
        this.f3112e = 0;
        this.f3113f = null;
        this.f3114g = f3103j;
        this.f3115h = false;
    }

    public static Dimension a(int i10) {
        Dimension dimension = new Dimension(f3102i);
        dimension.l(i10);
        return dimension;
    }

    public static Dimension b(Object obj) {
        Dimension dimension = new Dimension(f3102i);
        dimension.m(obj);
        return dimension;
    }

    public static Dimension c() {
        return new Dimension(f3105l);
    }

    public static Dimension d(Object obj, float f10) {
        Dimension dimension = new Dimension(f3106m);
        dimension.s(obj, f10);
        return dimension;
    }

    public static Dimension e(String str) {
        Dimension dimension = new Dimension(f3107n);
        dimension.t(str);
        return dimension;
    }

    public static Dimension f() {
        return new Dimension(f3104k);
    }

    public static Dimension g(int i10) {
        Dimension dimension = new Dimension();
        dimension.v(i10);
        return dimension;
    }

    public static Dimension h(Object obj) {
        Dimension dimension = new Dimension();
        dimension.w(obj);
        return dimension;
    }

    public static Dimension i() {
        return new Dimension(f3103j);
    }

    public void j(State state, ConstraintWidget constraintWidget, int i10) {
        String str = this.f3113f;
        if (str != null) {
            constraintWidget.n1(str);
        }
        int i11 = 2;
        if (i10 == 0) {
            if (this.f3115h) {
                constraintWidget.D1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.f3114g;
                if (obj == f3103j) {
                    i11 = 1;
                } else if (obj != f3106m) {
                    i11 = 0;
                }
                constraintWidget.E1(i11, this.f3109b, this.f3110c, this.f3111d);
                return;
            }
            int i12 = this.f3109b;
            if (i12 > 0) {
                constraintWidget.P1(i12);
            }
            int i13 = this.f3110c;
            if (i13 < Integer.MAX_VALUE) {
                constraintWidget.M1(i13);
            }
            Object obj2 = this.f3114g;
            if (obj2 == f3103j) {
                constraintWidget.D1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                return;
            }
            if (obj2 == f3105l) {
                constraintWidget.D1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    constraintWidget.D1(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.c2(this.f3112e);
                    return;
                }
                return;
            }
        }
        if (this.f3115h) {
            constraintWidget.Y1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.f3114g;
            if (obj3 == f3103j) {
                i11 = 1;
            } else if (obj3 != f3106m) {
                i11 = 0;
            }
            constraintWidget.Z1(i11, this.f3109b, this.f3110c, this.f3111d);
            return;
        }
        int i14 = this.f3109b;
        if (i14 > 0) {
            constraintWidget.O1(i14);
        }
        int i15 = this.f3110c;
        if (i15 < Integer.MAX_VALUE) {
            constraintWidget.L1(i15);
        }
        Object obj4 = this.f3114g;
        if (obj4 == f3103j) {
            constraintWidget.Y1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        }
        if (obj4 == f3105l) {
            constraintWidget.Y1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        } else if (obj4 == null) {
            constraintWidget.Y1(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.y1(this.f3112e);
        }
    }

    public boolean k(int i10) {
        return this.f3114g == null && this.f3112e == i10;
    }

    public Dimension l(int i10) {
        this.f3114g = null;
        this.f3112e = i10;
        return this;
    }

    public Dimension m(Object obj) {
        this.f3114g = obj;
        if (obj instanceof Integer) {
            this.f3112e = ((Integer) obj).intValue();
            this.f3114g = null;
        }
        return this;
    }

    public int n() {
        return this.f3112e;
    }

    public Dimension o(int i10) {
        if (this.f3110c >= 0) {
            this.f3110c = i10;
        }
        return this;
    }

    public Dimension p(Object obj) {
        Object obj2 = f3103j;
        if (obj == obj2 && this.f3115h) {
            this.f3114g = obj2;
            this.f3110c = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension q(int i10) {
        if (i10 >= 0) {
            this.f3109b = i10;
        }
        return this;
    }

    public Dimension r(Object obj) {
        if (obj == f3103j) {
            this.f3109b = -2;
        }
        return this;
    }

    public Dimension s(Object obj, float f10) {
        this.f3111d = f10;
        return this;
    }

    public Dimension t(String str) {
        this.f3113f = str;
        return this;
    }

    public void u(int i10) {
        this.f3115h = false;
        this.f3114g = null;
        this.f3112e = i10;
    }

    public Dimension v(int i10) {
        this.f3115h = true;
        if (i10 >= 0) {
            this.f3110c = i10;
        }
        return this;
    }

    public Dimension w(Object obj) {
        this.f3114g = obj;
        this.f3115h = true;
        return this;
    }

    public Dimension(Object obj) {
        this.f3108a = -2;
        this.f3109b = 0;
        this.f3110c = Integer.MAX_VALUE;
        this.f3111d = 1.0f;
        this.f3112e = 0;
        this.f3113f = null;
        this.f3115h = false;
        this.f3114g = obj;
    }
}
