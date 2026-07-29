package ci;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes5.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f10954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView.o f10955b;

    public a(RecyclerView recyclerView) {
        this(recyclerView.getLayoutManager());
        this.f10954a = recyclerView;
    }

    @Override // ci.b
    public int a() {
        RecyclerView.o oVarG = g();
        if (!(oVarG instanceof StaggeredGridLayoutManager)) {
            return ((LinearLayoutManager) oVarG).t2();
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) oVarG;
        int i10 = staggeredGridLayoutManager.A2(null)[0];
        for (int i11 = 1; i11 < e(); i11++) {
            int i12 = staggeredGridLayoutManager.A2(null)[i11];
            if (i12 < i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    @Override // ci.b
    public int b() {
        RecyclerView.o oVarG = g();
        if (!(oVarG instanceof StaggeredGridLayoutManager)) {
            return ((LinearLayoutManager) oVarG).y2();
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) oVarG;
        int i10 = staggeredGridLayoutManager.F2(null)[0];
        for (int i11 = 1; i11 < e(); i11++) {
            int i12 = staggeredGridLayoutManager.F2(null)[i11];
            if (i12 < i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    @Override // ci.b
    public int c() {
        RecyclerView.o oVarG = g();
        if (oVarG instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) oVarG).Q2();
        }
        if (oVarG instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) oVarG).T2();
        }
        return 1;
    }

    @Override // ci.b
    public int d() {
        RecyclerView.o oVarG = g();
        if (!(oVarG instanceof StaggeredGridLayoutManager)) {
            return ((LinearLayoutManager) oVarG).C2();
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) oVarG;
        int i10 = staggeredGridLayoutManager.I2(null)[0];
        for (int i11 = 1; i11 < e(); i11++) {
            int i12 = staggeredGridLayoutManager.I2(null)[i11];
            if (i12 > i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    @Override // ci.b
    public int e() {
        RecyclerView.o oVarG = g();
        if (oVarG instanceof GridLayoutManager) {
            return ((GridLayoutManager) oVarG).H3();
        }
        if (oVarG instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) oVarG).V2();
        }
        return 1;
    }

    @Override // ci.b
    public int f() {
        RecyclerView.o oVarG = g();
        if (!(oVarG instanceof StaggeredGridLayoutManager)) {
            return ((LinearLayoutManager) oVarG).z2();
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) oVarG;
        int i10 = staggeredGridLayoutManager.G2(null)[0];
        for (int i11 = 1; i11 < e(); i11++) {
            int i12 = staggeredGridLayoutManager.G2(null)[i11];
            if (i12 > i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    public final RecyclerView.o g() {
        RecyclerView recyclerView = this.f10954a;
        return recyclerView != null ? recyclerView.getLayoutManager() : this.f10955b;
    }

    public a(RecyclerView.o oVar) {
        this.f10955b = oVar;
    }
}
