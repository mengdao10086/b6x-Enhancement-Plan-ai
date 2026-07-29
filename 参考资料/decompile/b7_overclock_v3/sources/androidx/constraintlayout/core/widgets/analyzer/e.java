package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f3338j = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f3339a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f3342d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3340b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3341c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f3343e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<l> f3344f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b.InterfaceC0036b f3345g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b.a f3346h = new b.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<l> f3347i = new ArrayList<>();

    public e(androidx.constraintlayout.core.widgets.d dVar) {
        this.f3339a = dVar;
        this.f3342d = dVar;
    }

    public final void a(DependencyNode dependencyNode, int i10, int i11, DependencyNode dependencyNode2, ArrayList<l> arrayList, l lVar) {
        WidgetRun widgetRun = dependencyNode.f3292d;
        if (widgetRun.f3303c == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.f3339a;
            if (widgetRun == dVar.f3243e || widgetRun == dVar.f3245f) {
                return;
            }
            if (lVar == null) {
                lVar = new l(widgetRun, i11);
                arrayList.add(lVar);
            }
            widgetRun.f3303c = lVar;
            lVar.a(widgetRun);
            for (d dVar2 : widgetRun.f3308h.f3299k) {
                if (dVar2 instanceof DependencyNode) {
                    a((DependencyNode) dVar2, i10, 0, dependencyNode2, arrayList, lVar);
                }
            }
            for (d dVar3 : widgetRun.f3309i.f3299k) {
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i10, 1, dependencyNode2, arrayList, lVar);
                }
            }
            if (i10 == 1 && (widgetRun instanceof m)) {
                for (d dVar4 : ((m) widgetRun).f3370k.f3299k) {
                    if (dVar4 instanceof DependencyNode) {
                        a((DependencyNode) dVar4, i10, 2, dependencyNode2, arrayList, lVar);
                    }
                }
            }
            for (DependencyNode dependencyNode3 : widgetRun.f3308h.f3300l) {
                if (dependencyNode3 == dependencyNode2) {
                    lVar.f3364b = true;
                }
                a(dependencyNode3, i10, 0, dependencyNode2, arrayList, lVar);
            }
            for (DependencyNode dependencyNode4 : widgetRun.f3309i.f3300l) {
                if (dependencyNode4 == dependencyNode2) {
                    lVar.f3364b = true;
                }
                a(dependencyNode4, i10, 1, dependencyNode2, arrayList, lVar);
            }
            if (i10 == 1 && (widgetRun instanceof m)) {
                Iterator<DependencyNode> it2 = ((m) widgetRun).f3370k.f3300l.iterator();
                while (it2.hasNext()) {
                    a(it2.next(), i10, 2, dependencyNode2, arrayList, lVar);
                }
            }
        }
    }

    public final boolean b(androidx.constraintlayout.core.widgets.d dVar) {
        int iM0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int iD;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        for (ConstraintWidget constraintWidget : dVar.A1) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f3238b0;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[1];
            if (constraintWidget.l0() == 8) {
                constraintWidget.f3235a = true;
            } else {
                if (constraintWidget.B < 1.0f && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f3279w = 2;
                }
                if (constraintWidget.E < 1.0f && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    constraintWidget.f3281x = 2;
                }
                if (constraintWidget.A() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour5 == dimensionBehaviour7 && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.f3279w = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour7 && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        constraintWidget.f3281x = 3;
                    } else if (dimensionBehaviour5 == dimensionBehaviour7 && dimensionBehaviour6 == dimensionBehaviour7) {
                        if (constraintWidget.f3279w == 0) {
                            constraintWidget.f3279w = 3;
                        }
                        if (constraintWidget.f3281x == 0) {
                            constraintWidget.f3281x = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour5 == dimensionBehaviour8 && constraintWidget.f3279w == 1 && (constraintWidget.Q.f3204f == null || constraintWidget.S.f3204f == null)) {
                    dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = dimensionBehaviour5;
                if (dimensionBehaviour6 == dimensionBehaviour8 && constraintWidget.f3281x == 1 && (constraintWidget.R.f3204f == null || constraintWidget.T.f3204f == null)) {
                    dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = dimensionBehaviour6;
                k kVar = constraintWidget.f3243e;
                kVar.f3304d = dimensionBehaviour9;
                int i10 = constraintWidget.f3279w;
                kVar.f3301a = i10;
                m mVar = constraintWidget.f3245f;
                mVar.f3304d = dimensionBehaviour10;
                int i11 = constraintWidget.f3281x;
                mVar.f3301a = i11;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour9 == dimensionBehaviour11 || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour10 == dimensionBehaviour11 || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int iM02 = constraintWidget.m0();
                    if (dimensionBehaviour9 == dimensionBehaviour11) {
                        iM0 = (dVar.m0() - constraintWidget.Q.f3205g) - constraintWidget.S.f3205g;
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        iM0 = iM02;
                        dimensionBehaviour = dimensionBehaviour9;
                    }
                    int iD2 = constraintWidget.D();
                    if (dimensionBehaviour10 == dimensionBehaviour11) {
                        iD = (dVar.D() - constraintWidget.R.f3205g) - constraintWidget.T.f3205g;
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        iD = iD2;
                        dimensionBehaviour2 = dimensionBehaviour10;
                    }
                    r(constraintWidget, dimensionBehaviour, iM0, dimensionBehaviour2, iD);
                    constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                    constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                    constraintWidget.f3235a = true;
                } else {
                    if (dimensionBehaviour9 == dimensionBehaviour8 && (dimensionBehaviour10 == (dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i10 == 3) {
                            if (dimensionBehaviour10 == dimensionBehaviour4) {
                                r(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour4, 0);
                            }
                            int iD3 = constraintWidget.D();
                            int i12 = (int) ((iD3 * constraintWidget.f3246f0) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                            r(constraintWidget, dimensionBehaviour12, i12, dimensionBehaviour12, iD3);
                            constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                            constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                            constraintWidget.f3235a = true;
                        } else if (i10 == 1) {
                            r(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour10, 0);
                            constraintWidget.f3243e.f3305e.f3348m = constraintWidget.m0();
                        } else if (i10 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar.f3238b0;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = dimensionBehaviourArr2[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour13 == dimensionBehaviour14 || dimensionBehaviourArr2[0] == dimensionBehaviour11) {
                                r(constraintWidget, dimensionBehaviour14, (int) ((constraintWidget.B * dVar.m0()) + 0.5f), dimensionBehaviour10, constraintWidget.D());
                                constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                                constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                                constraintWidget.f3235a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = constraintWidget.Y;
                            if (constraintAnchorArr[0].f3204f == null || constraintAnchorArr[1].f3204f == null) {
                                r(constraintWidget, dimensionBehaviour4, 0, dimensionBehaviour10, 0);
                                constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                                constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                                constraintWidget.f3235a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour10 == dimensionBehaviour8 && (dimensionBehaviour9 == (dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i11 == 3) {
                            if (dimensionBehaviour9 == dimensionBehaviour3) {
                                r(constraintWidget, dimensionBehaviour3, 0, dimensionBehaviour3, 0);
                            }
                            int iM03 = constraintWidget.m0();
                            float f10 = constraintWidget.f3246f0;
                            if (constraintWidget.B() == -1) {
                                f10 = 1.0f / f10;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                            r(constraintWidget, dimensionBehaviour15, iM03, dimensionBehaviour15, (int) ((iM03 * f10) + 0.5f));
                            constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                            constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                            constraintWidget.f3235a = true;
                        } else if (i11 == 1) {
                            r(constraintWidget, dimensionBehaviour9, 0, dimensionBehaviour3, 0);
                            constraintWidget.f3245f.f3305e.f3348m = constraintWidget.D();
                        } else if (i11 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = dVar.f3238b0;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = dimensionBehaviourArr3[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour16 == dimensionBehaviour17 || dimensionBehaviourArr3[1] == dimensionBehaviour11) {
                                r(constraintWidget, dimensionBehaviour9, constraintWidget.m0(), dimensionBehaviour17, (int) ((constraintWidget.E * dVar.D()) + 0.5f));
                                constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                                constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                                constraintWidget.f3235a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.Y;
                            if (constraintAnchorArr2[2].f3204f == null || constraintAnchorArr2[3].f3204f == null) {
                                r(constraintWidget, dimensionBehaviour3, 0, dimensionBehaviour10, 0);
                                constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                                constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                                constraintWidget.f3235a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour9 == dimensionBehaviour8 && dimensionBehaviour10 == dimensionBehaviour8) {
                        if (i10 == 1 || i11 == 1) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            r(constraintWidget, dimensionBehaviour18, 0, dimensionBehaviour18, 0);
                            constraintWidget.f3243e.f3305e.f3348m = constraintWidget.m0();
                            constraintWidget.f3245f.f3305e.f3348m = constraintWidget.D();
                        } else if (i11 == 2 && i10 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr4 = dVar.f3238b0;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = dimensionBehaviourArr4[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour19 == dimensionBehaviour20 && dimensionBehaviourArr4[1] == dimensionBehaviour20) {
                                r(constraintWidget, dimensionBehaviour20, (int) ((constraintWidget.B * dVar.m0()) + 0.5f), dimensionBehaviour20, (int) ((constraintWidget.E * dVar.D()) + 0.5f));
                                constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                                constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                                constraintWidget.f3235a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void c() {
        d(this.f3343e);
        this.f3347i.clear();
        l.f3362k = 0;
        k(this.f3339a.f3243e, 0, this.f3347i);
        k(this.f3339a.f3245f, 1, this.f3347i);
        this.f3340b = false;
    }

    public void d(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.f3342d.f3243e.f();
        this.f3342d.f3245f.f();
        arrayList.add(this.f3342d.f3243e);
        arrayList.add(this.f3342d.f3245f);
        HashSet hashSet = null;
        for (ConstraintWidget constraintWidget : this.f3342d.A1) {
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                arrayList.add(new i(constraintWidget));
            } else {
                if (constraintWidget.B0()) {
                    if (constraintWidget.f3239c == null) {
                        constraintWidget.f3239c = new c(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f3239c);
                } else {
                    arrayList.add(constraintWidget.f3243e);
                }
                if (constraintWidget.D0()) {
                    if (constraintWidget.f3241d == null) {
                        constraintWidget.f3241d = new c(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f3241d);
                } else {
                    arrayList.add(constraintWidget.f3245f);
                }
                if (constraintWidget instanceof y.b) {
                    arrayList.add(new j(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        for (WidgetRun widgetRun : arrayList) {
            if (widgetRun.f3302b != this.f3342d) {
                widgetRun.d();
            }
        }
    }

    public final int e(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        int size = this.f3347i.size();
        long jMax = 0;
        for (int i11 = 0; i11 < size; i11++) {
            jMax = Math.max(jMax, this.f3347i.get(i11).b(dVar, i10));
        }
        return (int) jMax;
    }

    public void f(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.f3340b) {
            c();
            boolean z10 = false;
            for (ConstraintWidget constraintWidget : this.f3339a.A1) {
                boolean[] zArr = constraintWidget.f3247g;
                zArr[0] = true;
                zArr[1] = true;
                if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
                    z10 = true;
                }
            }
            if (z10) {
                return;
            }
            for (l lVar : this.f3347i) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                lVar.d(dimensionBehaviour == dimensionBehaviour3, dimensionBehaviour2 == dimensionBehaviour3);
            }
        }
    }

    public boolean g(boolean z10) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = z10 & true;
        if (this.f3340b || this.f3341c) {
            for (ConstraintWidget constraintWidget : this.f3339a.A1) {
                constraintWidget.q();
                constraintWidget.f3235a = false;
                constraintWidget.f3243e.n();
                constraintWidget.f3245f.n();
            }
            this.f3339a.q();
            androidx.constraintlayout.core.widgets.d dVar = this.f3339a;
            dVar.f3235a = false;
            dVar.f3243e.n();
            this.f3339a.f3245f.n();
            this.f3341c = false;
        }
        if (b(this.f3342d)) {
            return false;
        }
        this.f3339a.f2(0);
        this.f3339a.g2(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourZ = this.f3339a.z(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourZ2 = this.f3339a.z(1);
        if (this.f3340b) {
            c();
        }
        int iO0 = this.f3339a.o0();
        int iP0 = this.f3339a.p0();
        this.f3339a.f3243e.f3308h.e(iO0);
        this.f3339a.f3245f.f3308h.e(iP0);
        s();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviourZ == dimensionBehaviour || dimensionBehaviourZ2 == dimensionBehaviour) {
            if (z13) {
                Iterator<WidgetRun> it2 = this.f3343e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().p()) {
                        z13 = false;
                        break;
                    }
                }
            }
            if (z13 && dimensionBehaviourZ == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f3339a.D1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar2 = this.f3339a;
                dVar2.c2(e(dVar2, 0));
                androidx.constraintlayout.core.widgets.d dVar3 = this.f3339a;
                dVar3.f3243e.f3305e.e(dVar3.m0());
            }
            if (z13 && dimensionBehaviourZ2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f3339a.Y1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar4 = this.f3339a;
                dVar4.y1(e(dVar4, 1));
                androidx.constraintlayout.core.widgets.d dVar5 = this.f3339a;
                dVar5.f3245f.f3305e.e(dVar5.D());
            }
        }
        androidx.constraintlayout.core.widgets.d dVar6 = this.f3339a;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = dVar6.f3238b0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int iM0 = dVar6.m0() + iO0;
            this.f3339a.f3243e.f3309i.e(iM0);
            this.f3339a.f3243e.f3305e.e(iM0 - iO0);
            s();
            androidx.constraintlayout.core.widgets.d dVar7 = this.f3339a;
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar7.f3238b0;
            if (dimensionBehaviourArr2[1] == dimensionBehaviour3 || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iD = dVar7.D() + iP0;
                this.f3339a.f3245f.f3309i.e(iD);
                this.f3339a.f3245f.f3305e.e(iD - iP0);
            }
            s();
            z11 = true;
        } else {
            z11 = false;
        }
        for (WidgetRun widgetRun : this.f3343e) {
            if (widgetRun.f3302b != this.f3339a || widgetRun.f3307g) {
                widgetRun.e();
            }
        }
        for (WidgetRun widgetRun2 : this.f3343e) {
            if (z11 || widgetRun2.f3302b != this.f3339a) {
                if (!widgetRun2.f3308h.f3298j || ((!widgetRun2.f3309i.f3298j && !(widgetRun2 instanceof i)) || (!widgetRun2.f3305e.f3298j && !(widgetRun2 instanceof c) && !(widgetRun2 instanceof i)))) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f3339a.D1(dimensionBehaviourZ);
        this.f3339a.Y1(dimensionBehaviourZ2);
        return z12;
    }

    public boolean h(boolean z10) {
        if (this.f3340b) {
            for (ConstraintWidget constraintWidget : this.f3339a.A1) {
                constraintWidget.q();
                constraintWidget.f3235a = false;
                k kVar = constraintWidget.f3243e;
                kVar.f3305e.f3298j = false;
                kVar.f3307g = false;
                kVar.n();
                m mVar = constraintWidget.f3245f;
                mVar.f3305e.f3298j = false;
                mVar.f3307g = false;
                mVar.n();
            }
            this.f3339a.q();
            androidx.constraintlayout.core.widgets.d dVar = this.f3339a;
            dVar.f3235a = false;
            k kVar2 = dVar.f3243e;
            kVar2.f3305e.f3298j = false;
            kVar2.f3307g = false;
            kVar2.n();
            m mVar2 = this.f3339a.f3245f;
            mVar2.f3305e.f3298j = false;
            mVar2.f3307g = false;
            mVar2.n();
            c();
        }
        if (b(this.f3342d)) {
            return false;
        }
        this.f3339a.f2(0);
        this.f3339a.g2(0);
        this.f3339a.f3243e.f3308h.e(0);
        this.f3339a.f3245f.f3308h.e(0);
        return true;
    }

    public boolean i(boolean z10, int i10) {
        boolean z11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z12 = true;
        boolean z13 = z10 & true;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourZ = this.f3339a.z(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourZ2 = this.f3339a.z(1);
        int iO0 = this.f3339a.o0();
        int iP0 = this.f3339a.p0();
        if (z13 && (dimensionBehaviourZ == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviourZ2 == dimensionBehaviour)) {
            Iterator<WidgetRun> it2 = this.f3343e.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WidgetRun next = it2.next();
                if (next.f3306f == i10 && !next.p()) {
                    z13 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z13 && dimensionBehaviourZ == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.f3339a.D1(ConstraintWidget.DimensionBehaviour.FIXED);
                    androidx.constraintlayout.core.widgets.d dVar = this.f3339a;
                    dVar.c2(e(dVar, 0));
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f3339a;
                    dVar2.f3243e.f3305e.e(dVar2.m0());
                }
            } else if (z13 && dimensionBehaviourZ2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f3339a.Y1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar3 = this.f3339a;
                dVar3.y1(e(dVar3, 1));
                androidx.constraintlayout.core.widgets.d dVar4 = this.f3339a;
                dVar4.f3245f.f3305e.e(dVar4.D());
            }
        }
        if (i10 == 0) {
            androidx.constraintlayout.core.widgets.d dVar5 = this.f3339a;
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = dVar5.f3238b0;
            if (dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iM0 = dVar5.m0() + iO0;
                this.f3339a.f3243e.f3309i.e(iM0);
                this.f3339a.f3243e.f3305e.e(iM0 - iO0);
                z11 = true;
            }
            z11 = false;
        } else {
            androidx.constraintlayout.core.widgets.d dVar6 = this.f3339a;
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar6.f3238b0;
            if (dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int iD = dVar6.D() + iP0;
                this.f3339a.f3245f.f3309i.e(iD);
                this.f3339a.f3245f.f3305e.e(iD - iP0);
                z11 = true;
            }
            z11 = false;
        }
        s();
        for (WidgetRun widgetRun : this.f3343e) {
            if (widgetRun.f3306f == i10 && (widgetRun.f3302b != this.f3339a || widgetRun.f3307g)) {
                widgetRun.e();
            }
        }
        for (WidgetRun widgetRun2 : this.f3343e) {
            if (widgetRun2.f3306f == i10 && (z11 || widgetRun2.f3302b != this.f3339a)) {
                if (!widgetRun2.f3308h.f3298j || !widgetRun2.f3309i.f3298j || (!(widgetRun2 instanceof c) && !widgetRun2.f3305e.f3298j)) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f3339a.D1(dimensionBehaviourZ);
        this.f3339a.Y1(dimensionBehaviourZ2);
        return z12;
    }

    public final void j() {
        Iterator<WidgetRun> it2 = this.f3343e.iterator();
        String strM = "digraph {\n";
        while (it2.hasNext()) {
            strM = m(it2.next(), strM);
        }
        String str = strM + "\n}\n";
        System.out.println("content:<<\n" + str + "\n>>");
    }

    public final void k(WidgetRun widgetRun, int i10, ArrayList<l> arrayList) {
        for (d dVar : widgetRun.f3308h.f3299k) {
            if (dVar instanceof DependencyNode) {
                a((DependencyNode) dVar, i10, 0, widgetRun.f3309i, arrayList, null);
            } else if (dVar instanceof WidgetRun) {
                a(((WidgetRun) dVar).f3308h, i10, 0, widgetRun.f3309i, arrayList, null);
            }
        }
        for (d dVar2 : widgetRun.f3309i.f3299k) {
            if (dVar2 instanceof DependencyNode) {
                a((DependencyNode) dVar2, i10, 1, widgetRun.f3308h, arrayList, null);
            } else if (dVar2 instanceof WidgetRun) {
                a(((WidgetRun) dVar2).f3309i, i10, 1, widgetRun.f3308h, arrayList, null);
            }
        }
        if (i10 == 1) {
            for (d dVar3 : ((m) widgetRun).f3370k.f3299k) {
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i10, 2, null, arrayList, null);
                }
            }
        }
    }

    public final String l(c cVar, String str) {
        int i10 = cVar.f3306f;
        StringBuilder sb2 = new StringBuilder("subgraph ");
        sb2.append("cluster_");
        sb2.append(cVar.f3302b.y());
        if (i10 == 0) {
            sb2.append("_h");
        } else {
            sb2.append("_v");
        }
        sb2.append(" {\n");
        String strM = "";
        for (WidgetRun widgetRun : cVar.f3336k) {
            sb2.append(widgetRun.f3302b.y());
            if (i10 == 0) {
                sb2.append("_HORIZONTAL");
            } else {
                sb2.append("_VERTICAL");
            }
            sb2.append(";\n");
            strM = m(widgetRun, strM);
        }
        sb2.append("}\n");
        return str + strM + ((Object) sb2);
    }

    public final String m(WidgetRun widgetRun, String str) {
        boolean z10;
        DependencyNode dependencyNode = widgetRun.f3308h;
        DependencyNode dependencyNode2 = widgetRun.f3309i;
        StringBuilder sb2 = new StringBuilder(str);
        if (!(widgetRun instanceof j) && dependencyNode.f3299k.isEmpty() && (dependencyNode2.f3299k.isEmpty() && dependencyNode.f3300l.isEmpty()) && dependencyNode2.f3300l.isEmpty()) {
            return str;
        }
        sb2.append(t(widgetRun));
        boolean zQ = q(dependencyNode, dependencyNode2);
        String strN = n(dependencyNode2, zQ, n(dependencyNode, zQ, str));
        boolean z11 = widgetRun instanceof m;
        if (z11) {
            strN = n(((m) widgetRun).f3370k, zQ, strN);
        }
        if ((widgetRun instanceof k) || (((z10 = widgetRun instanceof c)) && ((c) widgetRun).f3306f == 0)) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourH = widgetRun.f3302b.H();
            if (dimensionBehaviourH == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourH == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.f3300l.isEmpty() && dependencyNode2.f3300l.isEmpty()) {
                    sb2.append("\n");
                    sb2.append(dependencyNode2.d());
                    sb2.append(" -> ");
                    sb2.append(dependencyNode.d());
                    sb2.append("\n");
                } else if (dependencyNode.f3300l.isEmpty() && !dependencyNode2.f3300l.isEmpty()) {
                    sb2.append("\n");
                    sb2.append(dependencyNode.d());
                    sb2.append(" -> ");
                    sb2.append(dependencyNode2.d());
                    sb2.append("\n");
                }
            } else if (dimensionBehaviourH == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.f3302b.A() > 0.0f) {
                sb2.append("\n");
                sb2.append(widgetRun.f3302b.y());
                sb2.append("_HORIZONTAL -> ");
                sb2.append(widgetRun.f3302b.y());
                sb2.append("_VERTICAL;\n");
            }
        } else if (z11 || (z10 && ((c) widgetRun).f3306f == 1)) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourJ0 = widgetRun.f3302b.j0();
            if (dimensionBehaviourJ0 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourJ0 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (!dependencyNode.f3300l.isEmpty() && dependencyNode2.f3300l.isEmpty()) {
                    sb2.append("\n");
                    sb2.append(dependencyNode2.d());
                    sb2.append(" -> ");
                    sb2.append(dependencyNode.d());
                    sb2.append("\n");
                } else if (dependencyNode.f3300l.isEmpty() && !dependencyNode2.f3300l.isEmpty()) {
                    sb2.append("\n");
                    sb2.append(dependencyNode.d());
                    sb2.append(" -> ");
                    sb2.append(dependencyNode2.d());
                    sb2.append("\n");
                }
            } else if (dimensionBehaviourJ0 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.f3302b.A() > 0.0f) {
                sb2.append("\n");
                sb2.append(widgetRun.f3302b.y());
                sb2.append("_VERTICAL -> ");
                sb2.append(widgetRun.f3302b.y());
                sb2.append("_HORIZONTAL;\n");
            }
        }
        return widgetRun instanceof c ? l((c) widgetRun, strN) : sb2.toString();
    }

    public final String n(DependencyNode dependencyNode, boolean z10, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        for (DependencyNode dependencyNode2 : dependencyNode.f3300l) {
            String str2 = ("\n" + dependencyNode.d()) + " -> " + dependencyNode2.d();
            if (dependencyNode.f3294f > 0 || z10 || (dependencyNode.f3292d instanceof j)) {
                String str3 = str2 + "[";
                if (dependencyNode.f3294f > 0) {
                    str3 = str3 + "label=\"" + dependencyNode.f3294f + "\"";
                    if (z10) {
                        str3 = str3 + ag.c.f654g;
                    }
                }
                if (z10) {
                    str3 = str3 + " style=dashed ";
                }
                if (dependencyNode.f3292d instanceof j) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            sb2.append(str2 + "\n");
        }
        return sb2.toString();
    }

    public void o() {
        this.f3340b = true;
    }

    public void p() {
        this.f3341c = true;
    }

    public final boolean q(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        Iterator<DependencyNode> it2 = dependencyNode.f3300l.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            if (it2.next() != dependencyNode2) {
                i10++;
            }
        }
        Iterator<DependencyNode> it3 = dependencyNode2.f3300l.iterator();
        int i11 = 0;
        while (it3.hasNext()) {
            if (it3.next() != dependencyNode) {
                i11++;
            }
        }
        return i10 > 0 && i11 > 0;
    }

    public final void r(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        b.a aVar = this.f3346h;
        aVar.f3326a = dimensionBehaviour;
        aVar.f3327b = dimensionBehaviour2;
        aVar.f3328c = i10;
        aVar.f3329d = i11;
        this.f3345g.b(constraintWidget, aVar);
        constraintWidget.c2(this.f3346h.f3330e);
        constraintWidget.y1(this.f3346h.f3331f);
        constraintWidget.x1(this.f3346h.f3333h);
        constraintWidget.g1(this.f3346h.f3332g);
    }

    public void s() {
        f fVar;
        for (ConstraintWidget constraintWidget : this.f3339a.A1) {
            if (!constraintWidget.f3235a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f3238b0;
                boolean z10 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i10 = constraintWidget.f3279w;
                int i11 = constraintWidget.f3281x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z11 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i10 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1)) {
                    z10 = true;
                }
                f fVar2 = constraintWidget.f3243e.f3305e;
                boolean z12 = fVar2.f3298j;
                f fVar3 = constraintWidget.f3245f.f3305e;
                boolean z13 = fVar3.f3298j;
                if (z12 && z13) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    r(constraintWidget, dimensionBehaviour4, fVar2.f3295g, dimensionBehaviour4, fVar3.f3295g);
                    constraintWidget.f3235a = true;
                } else if (z12 && z10) {
                    r(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, fVar2.f3295g, dimensionBehaviour3, fVar3.f3295g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f3245f.f3305e.f3348m = constraintWidget.D();
                    } else {
                        constraintWidget.f3245f.f3305e.e(constraintWidget.D());
                        constraintWidget.f3235a = true;
                    }
                } else if (z13 && z11) {
                    r(constraintWidget, dimensionBehaviour3, fVar2.f3295g, ConstraintWidget.DimensionBehaviour.FIXED, fVar3.f3295g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f3243e.f3305e.f3348m = constraintWidget.m0();
                    } else {
                        constraintWidget.f3243e.f3305e.e(constraintWidget.m0());
                        constraintWidget.f3235a = true;
                    }
                }
                if (constraintWidget.f3235a && (fVar = constraintWidget.f3245f.f3371l) != null) {
                    fVar.e(constraintWidget.t());
                }
            }
        }
    }

    public final String t(WidgetRun widgetRun) {
        boolean z10 = widgetRun instanceof m;
        String strY = widgetRun.f3302b.y();
        StringBuilder sb2 = new StringBuilder(strY);
        ConstraintWidget constraintWidget = widgetRun.f3302b;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourH = !z10 ? constraintWidget.H() : constraintWidget.j0();
        l lVar = widgetRun.f3303c;
        if (z10) {
            sb2.append("_VERTICAL");
        } else {
            sb2.append("_HORIZONTAL");
        }
        sb2.append(" [shape=none, label=<");
        sb2.append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
        sb2.append("  <TR>");
        if (z10) {
            sb2.append("    <TD ");
            if (widgetRun.f3308h.f3298j) {
                sb2.append(" BGCOLOR=\"green\"");
            }
            sb2.append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
        } else {
            sb2.append("    <TD ");
            if (widgetRun.f3308h.f3298j) {
                sb2.append(" BGCOLOR=\"green\"");
            }
            sb2.append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
        }
        sb2.append("    <TD BORDER=\"1\" ");
        boolean z11 = widgetRun.f3305e.f3298j;
        if (z11 && !widgetRun.f3302b.f3235a) {
            sb2.append(" BGCOLOR=\"green\" ");
        } else if (z11) {
            sb2.append(" BGCOLOR=\"lightgray\" ");
        } else if (widgetRun.f3302b.f3235a) {
            sb2.append(" BGCOLOR=\"yellow\" ");
        }
        if (dimensionBehaviourH == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            sb2.append("style=\"dashed\"");
        }
        sb2.append(">");
        sb2.append(strY);
        if (lVar != null) {
            sb2.append(" [");
            sb2.append(lVar.f3368f + 1);
            sb2.append(fh.a.f28350w);
            sb2.append(l.f3362k);
            sb2.append("]");
        }
        sb2.append(" </TD>");
        if (z10) {
            sb2.append("    <TD ");
            if (((m) widgetRun).f3370k.f3298j) {
                sb2.append(" BGCOLOR=\"green\"");
            }
            sb2.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
            sb2.append("    <TD ");
            if (widgetRun.f3309i.f3298j) {
                sb2.append(" BGCOLOR=\"green\"");
            }
            sb2.append(" PORT=\"BOTTOM\" BORDER=\"1\">B</TD>");
        } else {
            sb2.append("    <TD ");
            if (widgetRun.f3309i.f3298j) {
                sb2.append(" BGCOLOR=\"green\"");
            }
            sb2.append(" PORT=\"RIGHT\" BORDER=\"1\">R</TD>");
        }
        sb2.append("  </TR></TABLE>");
        sb2.append(">];\n");
        return sb2.toString();
    }

    public void u(b.InterfaceC0036b interfaceC0036b) {
        this.f3345g = interfaceC0036b;
    }
}
