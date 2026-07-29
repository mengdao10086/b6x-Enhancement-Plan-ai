package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class State {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3116f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3117g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3118h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3119i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Integer f3120j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<Object, c> f3121a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<Object, androidx.constraintlayout.core.state.a> f3122b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, ArrayList<String>> f3123c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintReference f3124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3125e;

    public enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3126a;

        static {
            int[] iArr = new int[Helper.values().length];
            f3126a = iArr;
            try {
                iArr[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3126a[Helper.VERTICAL_CHAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3126a[Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3126a[Helper.ALIGN_VERTICALLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3126a[Helper.BARRIER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.f3124d = constraintReference;
        this.f3125e = 0;
        this.f3121a.put(f3120j, constraintReference);
    }

    public x.f A(Object obj) {
        return k(obj, 1);
    }

    public State B(Dimension dimension) {
        return x(dimension);
    }

    public void a(androidx.constraintlayout.core.widgets.d dVar) {
        androidx.constraintlayout.core.state.a aVar;
        y.b bVarM0;
        y.b bVarM02;
        dVar.p2();
        this.f3124d.V().j(this, dVar, 0);
        this.f3124d.D().j(this, dVar, 1);
        for (Object obj : this.f3122b.keySet()) {
            y.b bVarM03 = this.f3122b.get(obj).M0();
            if (bVarM03 != null) {
                c cVarE = this.f3121a.get(obj);
                if (cVarE == null) {
                    cVarE = e(obj);
                }
                cVarE.b(bVarM03);
            }
        }
        for (Object obj2 : this.f3121a.keySet()) {
            c cVar = this.f3121a.get(obj2);
            if (cVar != this.f3124d && (cVar.d() instanceof androidx.constraintlayout.core.state.a) && (bVarM02 = ((androidx.constraintlayout.core.state.a) cVar.d()).M0()) != null) {
                c cVarE2 = this.f3121a.get(obj2);
                if (cVarE2 == null) {
                    cVarE2 = e(obj2);
                }
                cVarE2.b(bVarM02);
            }
        }
        Iterator<Object> it2 = this.f3121a.keySet().iterator();
        while (it2.hasNext()) {
            c cVar2 = this.f3121a.get(it2.next());
            if (cVar2 != this.f3124d) {
                ConstraintWidget constraintWidgetA = cVar2.a();
                constraintWidgetA.j1(cVar2.getKey().toString());
                constraintWidgetA.S1(null);
                if (cVar2.d() instanceof x.f) {
                    cVar2.apply();
                }
                dVar.b(constraintWidgetA);
            } else {
                cVar2.b(dVar);
            }
        }
        Iterator<Object> it3 = this.f3122b.keySet().iterator();
        while (it3.hasNext()) {
            androidx.constraintlayout.core.state.a aVar2 = this.f3122b.get(it3.next());
            if (aVar2.M0() != null) {
                Iterator<Object> it4 = aVar2.f3129l0.iterator();
                while (it4.hasNext()) {
                    aVar2.M0().b(this.f3121a.get(it4.next()).a());
                }
                aVar2.apply();
            } else {
                aVar2.apply();
            }
        }
        Iterator<Object> it5 = this.f3121a.keySet().iterator();
        while (it5.hasNext()) {
            c cVar3 = this.f3121a.get(it5.next());
            if (cVar3 != this.f3124d && (cVar3.d() instanceof androidx.constraintlayout.core.state.a) && (bVarM0 = (aVar = (androidx.constraintlayout.core.state.a) cVar3.d()).M0()) != null) {
                for (Object obj3 : aVar.f3129l0) {
                    c cVar4 = this.f3121a.get(obj3);
                    if (cVar4 != null) {
                        bVarM0.b(cVar4.a());
                    } else if (obj3 instanceof c) {
                        bVarM0.b(((c) obj3).a());
                    } else {
                        System.out.println("couldn't find reference for " + obj3);
                    }
                }
                cVar3.apply();
            }
        }
        for (Object obj4 : this.f3121a.keySet()) {
            c cVar5 = this.f3121a.get(obj4);
            cVar5.apply();
            ConstraintWidget constraintWidgetA2 = cVar5.a();
            if (constraintWidgetA2 != null && obj4 != null) {
                constraintWidgetA2.f3263o = obj4.toString();
            }
        }
    }

    public x.c b(Object obj, Direction direction) {
        ConstraintReference constraintReferenceE = e(obj);
        if (constraintReferenceE.d() == null || !(constraintReferenceE.d() instanceof x.c)) {
            x.c cVar = new x.c(this);
            cVar.P0(direction);
            constraintReferenceE.p0(cVar);
        }
        return (x.c) constraintReferenceE.d();
    }

    public x.a c(Object... objArr) {
        x.a aVar = (x.a) m(null, Helper.ALIGN_HORIZONTALLY);
        aVar.L0(objArr);
        return aVar;
    }

    public x.b d(Object... objArr) {
        x.b bVar = (x.b) m(null, Helper.ALIGN_VERTICALLY);
        bVar.L0(objArr);
        return bVar;
    }

    public ConstraintReference e(Object obj) {
        c cVarG = this.f3121a.get(obj);
        if (cVarG == null) {
            cVarG = g(obj);
            this.f3121a.put(obj, cVarG);
            cVarG.c(obj);
        }
        if (cVarG instanceof ConstraintReference) {
            return (ConstraintReference) cVarG;
        }
        return null;
    }

    public int f(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference g(Object obj) {
        return new ConstraintReference(this);
    }

    public final String h() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("__HELPER_KEY_");
        int i10 = this.f3125e;
        this.f3125e = i10 + 1;
        sb2.append(i10);
        sb2.append("__");
        return sb2.toString();
    }

    public void i() {
        for (Object obj : this.f3121a.keySet()) {
            ConstraintReference constraintReferenceE = e(obj);
            if (constraintReferenceE instanceof ConstraintReference) {
                constraintReferenceE.w0(obj);
            }
        }
    }

    public ArrayList<String> j(String str) {
        if (this.f3123c.containsKey(str)) {
            return this.f3123c.get(str);
        }
        return null;
    }

    public x.f k(Object obj, int i10) {
        ConstraintReference constraintReferenceE = e(obj);
        if (constraintReferenceE.d() == null || !(constraintReferenceE.d() instanceof x.f)) {
            x.f fVar = new x.f(this);
            fVar.h(i10);
            fVar.c(obj);
            constraintReferenceE.p0(fVar);
        }
        return (x.f) constraintReferenceE.d();
    }

    public State l(Dimension dimension) {
        return v(dimension);
    }

    public androidx.constraintlayout.core.state.a m(Object obj, Helper helper) {
        androidx.constraintlayout.core.state.a gVar;
        if (obj == null) {
            obj = h();
        }
        androidx.constraintlayout.core.state.a aVar = this.f3122b.get(obj);
        if (aVar == null) {
            int i10 = a.f3126a[helper.ordinal()];
            if (i10 == 1) {
                gVar = new x.g(this);
            } else if (i10 == 2) {
                gVar = new x.h(this);
            } else if (i10 == 3) {
                gVar = new x.a(this);
            } else if (i10 == 4) {
                gVar = new x.b(this);
            } else if (i10 != 5) {
                aVar = new androidx.constraintlayout.core.state.a(this, helper);
                aVar.c(obj);
                this.f3122b.put(obj, aVar);
            } else {
                gVar = new x.c(this);
            }
            aVar = gVar;
            aVar.c(obj);
            this.f3122b.put(obj, aVar);
        }
        return aVar;
    }

    public x.g n() {
        return (x.g) m(null, Helper.HORIZONTAL_CHAIN);
    }

    public x.g o(Object... objArr) {
        x.g gVar = (x.g) m(null, Helper.HORIZONTAL_CHAIN);
        gVar.L0(objArr);
        return gVar;
    }

    public x.f p(Object obj) {
        return k(obj, 0);
    }

    public void q(Object obj, Object obj2) {
        ConstraintReference constraintReferenceE = e(obj);
        if (constraintReferenceE instanceof ConstraintReference) {
            constraintReferenceE.w0(obj2);
        }
    }

    public c r(Object obj) {
        return this.f3121a.get(obj);
    }

    public void s() {
        this.f3122b.clear();
        this.f3123c.clear();
    }

    public boolean t(int i10) {
        return this.f3124d.D().k(i10);
    }

    public boolean u(int i10) {
        return this.f3124d.V().k(i10);
    }

    public State v(Dimension dimension) {
        this.f3124d.q0(dimension);
        return this;
    }

    public void w(String str, String str2) {
        ArrayList<String> arrayList;
        ConstraintReference constraintReferenceE = e(str);
        if (constraintReferenceE instanceof ConstraintReference) {
            constraintReferenceE.t0(str2);
            if (this.f3123c.containsKey(str2)) {
                arrayList = this.f3123c.get(str2);
            } else {
                arrayList = new ArrayList<>();
                this.f3123c.put(str2, arrayList);
            }
            arrayList.add(str);
        }
    }

    public State x(Dimension dimension) {
        this.f3124d.x0(dimension);
        return this;
    }

    public x.h y() {
        return (x.h) m(null, Helper.VERTICAL_CHAIN);
    }

    public x.h z(Object... objArr) {
        x.h hVar = (x.h) m(null, Helper.VERTICAL_CHAIN);
        hVar.L0(objArr);
        return hVar;
    }
}
