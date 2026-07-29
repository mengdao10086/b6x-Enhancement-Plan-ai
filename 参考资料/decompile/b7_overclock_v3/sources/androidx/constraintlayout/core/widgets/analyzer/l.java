package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3359h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3360i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3361j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f3362k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WidgetRun f3365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetRun f3366d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3369g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3363a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3364b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f3367e = new ArrayList<>();

    public l(WidgetRun widgetRun, int i10) {
        this.f3365c = null;
        this.f3366d = null;
        int i11 = f3362k;
        this.f3368f = i11;
        f3362k = i11 + 1;
        this.f3365c = widgetRun;
        this.f3366d = widgetRun;
        this.f3369g = i10;
    }

    public void a(WidgetRun widgetRun) {
        this.f3367e.add(widgetRun);
        this.f3366d = widgetRun;
    }

    public long b(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        long j10;
        int i11;
        WidgetRun widgetRun = this.f3365c;
        if (widgetRun instanceof c) {
            if (((c) widgetRun).f3306f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(widgetRun instanceof k)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof m)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i10 == 0 ? dVar.f3243e : dVar.f3245f).f3308h;
        DependencyNode dependencyNode2 = (i10 == 0 ? dVar.f3243e : dVar.f3245f).f3309i;
        boolean zContains = widgetRun.f3308h.f3300l.contains(dependencyNode);
        boolean zContains2 = this.f3365c.f3309i.f3300l.contains(dependencyNode2);
        long j11 = this.f3365c.j();
        if (zContains && zContains2) {
            long jF = f(this.f3365c.f3308h, 0L);
            long jE = e(this.f3365c.f3309i, 0L);
            long j12 = jF - j11;
            WidgetRun widgetRun2 = this.f3365c;
            int i12 = widgetRun2.f3309i.f3294f;
            if (j12 >= (-i12)) {
                j12 += (long) i12;
            }
            int i13 = widgetRun2.f3308h.f3294f;
            long j13 = ((-jE) - j11) - ((long) i13);
            if (j13 >= i13) {
                j13 -= (long) i13;
            }
            float fU = widgetRun2.f3302b.u(i10);
            float f10 = fU > 0.0f ? (long) ((j13 / fU) + (j12 / (1.0f - fU))) : 0L;
            long j14 = ((long) ((f10 * fU) + 0.5f)) + j11 + ((long) ((f10 * (1.0f - fU)) + 0.5f));
            WidgetRun widgetRun3 = this.f3365c;
            j10 = ((long) widgetRun3.f3308h.f3294f) + j14;
            i11 = widgetRun3.f3309i.f3294f;
        } else {
            if (zContains) {
                return Math.max(f(this.f3365c.f3308h, r13.f3294f), ((long) this.f3365c.f3308h.f3294f) + j11);
            }
            if (zContains2) {
                return Math.max(-e(this.f3365c.f3309i, r13.f3294f), ((long) (-this.f3365c.f3309i.f3294f)) + j11);
            }
            WidgetRun widgetRun4 = this.f3365c;
            j10 = ((long) widgetRun4.f3308h.f3294f) + widgetRun4.j();
            i11 = this.f3365c.f3309i.f3294f;
        }
        return j10 - ((long) i11);
    }

    public final boolean c(WidgetRun widgetRun, int i10) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.f3302b.f3247g[i10]) {
            return false;
        }
        for (d dVar : widgetRun.f3308h.f3299k) {
            if ((dVar instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dVar).f3292d) != widgetRun && dependencyNode2 == widgetRun3.f3308h) {
                if (widgetRun instanceof c) {
                    Iterator<WidgetRun> it2 = ((c) widgetRun).f3336k.iterator();
                    while (it2.hasNext()) {
                        c(it2.next(), i10);
                    }
                } else if (!(widgetRun instanceof j)) {
                    widgetRun.f3302b.f3247g[i10] = false;
                }
                c(dependencyNode2.f3292d, i10);
            }
        }
        for (d dVar2 : widgetRun.f3309i.f3299k) {
            if ((dVar2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dVar2).f3292d) != widgetRun && dependencyNode == widgetRun2.f3308h) {
                if (widgetRun instanceof c) {
                    Iterator<WidgetRun> it3 = ((c) widgetRun).f3336k.iterator();
                    while (it3.hasNext()) {
                        c(it3.next(), i10);
                    }
                } else if (!(widgetRun instanceof j)) {
                    widgetRun.f3302b.f3247g[i10] = false;
                }
                c(dependencyNode.f3292d, i10);
            }
        }
        return false;
    }

    public void d(boolean z10, boolean z11) {
        if (z10) {
            WidgetRun widgetRun = this.f3365c;
            if (widgetRun instanceof k) {
                c(widgetRun, 0);
            }
        }
        if (z11) {
            WidgetRun widgetRun2 = this.f3365c;
            if (widgetRun2 instanceof m) {
                c(widgetRun2, 1);
            }
        }
    }

    public final long e(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f3292d;
        if (widgetRun instanceof j) {
            return j10;
        }
        int size = dependencyNode.f3299k.size();
        long jMin = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = dependencyNode.f3299k.get(i10);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f3292d != widgetRun) {
                    jMin = Math.min(jMin, e(dependencyNode2, ((long) dependencyNode2.f3294f) + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.f3309i) {
            return jMin;
        }
        long j11 = j10 - widgetRun.j();
        return Math.min(Math.min(jMin, e(widgetRun.f3308h, j11)), j11 - ((long) widgetRun.f3308h.f3294f));
    }

    public final long f(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f3292d;
        if (widgetRun instanceof j) {
            return j10;
        }
        int size = dependencyNode.f3299k.size();
        long jMax = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = dependencyNode.f3299k.get(i10);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f3292d != widgetRun) {
                    jMax = Math.max(jMax, f(dependencyNode2, ((long) dependencyNode2.f3294f) + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.f3308h) {
            return jMax;
        }
        long j11 = j10 + widgetRun.j();
        return Math.max(Math.max(jMax, f(widgetRun.f3309i, j11)), j11 - ((long) widgetRun.f3309i.f3294f));
    }
}
