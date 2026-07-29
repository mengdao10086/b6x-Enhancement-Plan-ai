package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DependencyNode implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetRun f3292d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3295g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f3289a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3290b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3291c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Type f3293e = Type.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3296h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f3297i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3298j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<d> f3299k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<DependencyNode> f3300l = new ArrayList();

    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f3292d = widgetRun;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        Iterator<DependencyNode> it2 = this.f3300l.iterator();
        while (it2.hasNext()) {
            if (!it2.next().f3298j) {
                return;
            }
        }
        this.f3291c = true;
        d dVar2 = this.f3289a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f3290b) {
            this.f3292d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i10 = 0;
        for (DependencyNode dependencyNode2 : this.f3300l) {
            if (!(dependencyNode2 instanceof f)) {
                i10++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i10 == 1 && dependencyNode.f3298j) {
            f fVar = this.f3297i;
            if (fVar != null) {
                if (!fVar.f3298j) {
                    return;
                } else {
                    this.f3294f = this.f3296h * fVar.f3295g;
                }
            }
            e(dependencyNode.f3295g + this.f3294f);
        }
        d dVar3 = this.f3289a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f3299k.add(dVar);
        if (this.f3298j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f3300l.clear();
        this.f3299k.clear();
        this.f3298j = false;
        this.f3295g = 0;
        this.f3291c = false;
        this.f3290b = false;
    }

    public String d() {
        String str;
        String strY = this.f3292d.f3302b.y();
        Type type = this.f3293e;
        if (type == Type.LEFT || type == Type.RIGHT) {
            str = strY + "_HORIZONTAL";
        } else {
            str = strY + "_VERTICAL";
        }
        return str + ":" + this.f3293e.name();
    }

    public void e(int i10) {
        if (this.f3298j) {
            return;
        }
        this.f3298j = true;
        this.f3295g = i10;
        for (d dVar : this.f3299k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f3292d.f3302b.y());
        sb2.append(":");
        sb2.append(this.f3293e);
        sb2.append(ee.a.f26978c);
        sb2.append(this.f3298j ? Integer.valueOf(this.f3295g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f3300l.size());
        sb2.append(":d=");
        sb2.append(this.f3299k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
