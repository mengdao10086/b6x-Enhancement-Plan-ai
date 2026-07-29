package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

/* JADX INFO: loaded from: classes2.dex */
public class f extends DependencyNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3348m;

    public f(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof k) {
            this.f3293e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f3293e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
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
}
