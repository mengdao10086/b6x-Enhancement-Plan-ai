package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ConstraintAnchor {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f3197j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f3198k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f3202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f3203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f3204f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SolverVariable f3207i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<ConstraintAnchor> f3199a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3205g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3206h = Integer.MIN_VALUE;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3208a;

        static {
            int[] iArr = new int[Type.values().length];
            f3208a = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3208a[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3208a[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3208a[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3208a[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3208a[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3208a[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3208a[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3208a[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f3202d = constraintWidget;
        this.f3203e = type;
    }

    public void A(int i10) {
        this.f3200b = i10;
        this.f3201c = true;
    }

    public void B(int i10) {
        if (p()) {
            this.f3206h = i10;
        }
    }

    public void C(int i10) {
        if (p()) {
            this.f3205g = i10;
        }
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i10) {
        return b(constraintAnchor, i10, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i10, int i11, boolean z10) {
        if (constraintAnchor == null) {
            x();
            return true;
        }
        if (!z10 && !v(constraintAnchor)) {
            return false;
        }
        this.f3204f = constraintAnchor;
        if (constraintAnchor.f3199a == null) {
            constraintAnchor.f3199a = new HashSet<>();
        }
        HashSet<ConstraintAnchor> hashSet = this.f3204f.f3199a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f3205g = i10;
        this.f3206h = i11;
        return true;
    }

    public void c(ConstraintAnchor constraintAnchor, HashMap<ConstraintWidget, ConstraintWidget> map) {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor2 = this.f3204f;
        if (constraintAnchor2 != null && (hashSet = constraintAnchor2.f3199a) != null) {
            hashSet.remove(this);
        }
        ConstraintAnchor constraintAnchor3 = constraintAnchor.f3204f;
        if (constraintAnchor3 != null) {
            this.f3204f = map.get(constraintAnchor.f3204f.f3202d).r(constraintAnchor3.l());
        } else {
            this.f3204f = null;
        }
        ConstraintAnchor constraintAnchor4 = this.f3204f;
        if (constraintAnchor4 != null) {
            if (constraintAnchor4.f3199a == null) {
                constraintAnchor4.f3199a = new HashSet<>();
            }
            this.f3204f.f3199a.add(this);
        }
        this.f3205g = constraintAnchor.f3205g;
        this.f3206h = constraintAnchor.f3206h;
    }

    public void d(int i10, ArrayList<n> arrayList, n nVar) {
        HashSet<ConstraintAnchor> hashSet = this.f3199a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.core.widgets.analyzer.h.a(it2.next().f3202d, i10, arrayList, nVar);
            }
        }
    }

    public HashSet<ConstraintAnchor> e() {
        return this.f3199a;
    }

    public int f() {
        if (this.f3201c) {
            return this.f3200b;
        }
        return 0;
    }

    public int g() {
        ConstraintAnchor constraintAnchor;
        if (this.f3202d.l0() == 8) {
            return 0;
        }
        return (this.f3206h == Integer.MIN_VALUE || (constraintAnchor = this.f3204f) == null || constraintAnchor.f3202d.l0() != 8) ? this.f3205g : this.f3206h;
    }

    public final ConstraintAnchor h() {
        switch (a.f3208a[this.f3203e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f3202d.S;
            case 3:
                return this.f3202d.Q;
            case 4:
                return this.f3202d.T;
            case 5:
                return this.f3202d.R;
            default:
                throw new AssertionError(this.f3203e.name());
        }
    }

    public ConstraintWidget i() {
        return this.f3202d;
    }

    public SolverVariable j() {
        return this.f3207i;
    }

    public ConstraintAnchor k() {
        return this.f3204f;
    }

    public Type l() {
        return this.f3203e;
    }

    public boolean m() {
        HashSet<ConstraintAnchor> hashSet = this.f3199a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (it2.next().h().p()) {
                return true;
            }
        }
        return false;
    }

    public boolean n() {
        HashSet<ConstraintAnchor> hashSet = this.f3199a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean o() {
        return this.f3201c;
    }

    public boolean p() {
        return this.f3204f != null;
    }

    public boolean q(ConstraintWidget constraintWidget) {
        if (s(constraintWidget, new HashSet<>())) {
            return false;
        }
        ConstraintWidget constraintWidgetU = i().U();
        return constraintWidgetU == constraintWidget || constraintWidget.U() == constraintWidgetU;
    }

    public boolean r(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return q(constraintWidget);
    }

    public final boolean s(ConstraintWidget constraintWidget, HashSet<ConstraintWidget> hashSet) {
        if (hashSet.contains(constraintWidget)) {
            return false;
        }
        hashSet.add(constraintWidget);
        if (constraintWidget == i()) {
            return true;
        }
        ArrayList<ConstraintAnchor> arrayListS = constraintWidget.s();
        int size = arrayListS.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintAnchor constraintAnchor = arrayListS.get(i10);
            if (constraintAnchor.u(this) && constraintAnchor.p() && s(constraintAnchor.k().i(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    public boolean t() {
        switch (a.f3208a[this.f3203e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                throw new AssertionError(this.f3203e.name());
        }
    }

    public String toString() {
        return this.f3202d.y() + ":" + this.f3203e.toString();
    }

    public boolean u(ConstraintAnchor constraintAnchor) {
        Type typeL = constraintAnchor.l();
        Type type = this.f3203e;
        if (typeL == type) {
            return true;
        }
        switch (a.f3208a[type.ordinal()]) {
            case 1:
                return typeL != Type.BASELINE;
            case 2:
            case 3:
            case 7:
                return typeL == Type.LEFT || typeL == Type.RIGHT || typeL == Type.CENTER_X;
            case 4:
            case 5:
            case 6:
            case 8:
                return typeL == Type.TOP || typeL == Type.BOTTOM || typeL == Type.CENTER_Y || typeL == Type.BASELINE;
            case 9:
                return false;
            default:
                throw new AssertionError(this.f3203e.name());
        }
    }

    public boolean v(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type typeL = constraintAnchor.l();
        Type type = this.f3203e;
        if (typeL == type) {
            return type != Type.BASELINE || (constraintAnchor.i().q0() && i().q0());
        }
        switch (a.f3208a[type.ordinal()]) {
            case 1:
                return (typeL == Type.BASELINE || typeL == Type.CENTER_X || typeL == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z10 = typeL == Type.LEFT || typeL == Type.RIGHT;
                if (constraintAnchor.i() instanceof f) {
                    return z10 || typeL == Type.CENTER_X;
                }
                return z10;
            case 4:
            case 5:
                boolean z11 = typeL == Type.TOP || typeL == Type.BOTTOM;
                if (constraintAnchor.i() instanceof f) {
                    return z11 || typeL == Type.CENTER_Y;
                }
                return z11;
            case 6:
                return (typeL == Type.LEFT || typeL == Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f3203e.name());
        }
    }

    public boolean w() {
        switch (a.f3208a[this.f3203e.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 7:
                return false;
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
                return true;
            default:
                throw new AssertionError(this.f3203e.name());
        }
    }

    public void x() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f3204f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f3199a) != null) {
            hashSet.remove(this);
            if (this.f3204f.f3199a.size() == 0) {
                this.f3204f.f3199a = null;
            }
        }
        this.f3199a = null;
        this.f3204f = null;
        this.f3205g = 0;
        this.f3206h = Integer.MIN_VALUE;
        this.f3201c = false;
        this.f3200b = 0;
    }

    public void y() {
        this.f3201c = false;
        this.f3200b = 0;
    }

    public void z(androidx.constraintlayout.core.c cVar) {
        SolverVariable solverVariable = this.f3207i;
        if (solverVariable == null) {
            this.f3207i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.j();
        }
    }
}
