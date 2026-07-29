package di;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.google.common.collect.LinkedHashMultimap;
import g.x;

/* JADX INFO: loaded from: classes5.dex */
public class a extends m.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f26257j = 1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0296a f26258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f26259b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f26260c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f26261d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f26262e = 300;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f26263f = 400;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f26264g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f26265h = 0.5f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26266i = -1;

    /* JADX INFO: renamed from: di.a$a, reason: collision with other inner class name */
    public interface InterfaceC0296a {
        void b(RecyclerView.e0 e0Var, int i10);

        boolean c(int i10, int i11);

        void f(int i10, int i11);

        boolean j(int i10, int i11);
    }

    public interface b {
        boolean a();

        boolean b();

        View c();

        View d();

        void e(int i10, int i11);

        void f(int i10);

        View g();
    }

    public a(InterfaceC0296a interfaceC0296a) {
        this.f26258a = interfaceC0296a;
    }

    public static void d(b bVar, int i10) {
        if (bVar.c() != null) {
            bVar.c().setVisibility(i10 == 4 ? 0 : 8);
        }
        if (bVar.g() != null) {
            bVar.g().setVisibility(i10 != 8 ? 8 : 0);
        }
    }

    public boolean a() {
        return this.f26260c;
    }

    public void b(long j10) {
        this.f26263f = j10;
    }

    public void c(boolean z10) {
        this.f26260c = z10;
    }

    @Override // androidx.recyclerview.widget.m.f
    public boolean canDropOver(RecyclerView recyclerView, RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.m.f
    public void clearView(RecyclerView recyclerView, RecyclerView.e0 e0Var) {
        e0Var.itemView.setAlpha(1.0f);
        if (e0Var instanceof b) {
            b bVar = (b) e0Var;
            m.f.getDefaultUIUtil().a(bVar.d());
            d(bVar, 0);
            bVar.f(e0Var.getAdapterPosition());
        }
    }

    public void e(boolean z10) {
        this.f26259b = z10;
    }

    public void f(long j10) {
        this.f26262e = j10;
    }

    public void g(boolean z10) {
        this.f26261d = z10;
    }

    @Override // androidx.recyclerview.widget.m.f
    public long getAnimationDuration(RecyclerView recyclerView, int i10, float f10, float f11) {
        return i10 == 8 ? this.f26263f : this.f26262e;
    }

    @Override // androidx.recyclerview.widget.m.f
    public float getMoveThreshold(RecyclerView.e0 e0Var) {
        return this.f26265h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c A[PHI: r2
  0x003c: PHI (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:18:0x002a, B:23:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.recyclerview.widget.m.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getMovementFlags(androidx.recyclerview.widget.RecyclerView r6, androidx.recyclerview.widget.RecyclerView.e0 r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r6.getLayoutManager()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager
            r2 = 12
            r3 = 3
            r4 = 0
            if (r1 != 0) goto L25
            boolean r0 = r0 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r0 == 0) goto L11
            goto L25
        L11:
            int r6 = fi.a.g(r6)
            if (r6 != 0) goto L1d
            int r6 = r5.f26266i
            if (r6 <= 0) goto L28
            r3 = r6
            goto L28
        L1d:
            int r6 = r5.f26266i
            if (r6 <= 0) goto L22
            r2 = r6
        L22:
            r3 = r2
            r2 = 3
            goto L28
        L25:
            r2 = 15
            r3 = 0
        L28:
            boolean r6 = r7 instanceof di.a.b
            if (r6 == 0) goto L3c
            di.a$b r7 = (di.a.b) r7
            boolean r6 = r7.b()
            if (r6 != 0) goto L35
            r2 = 0
        L35:
            boolean r6 = r7.a()
            if (r6 != 0) goto L3c
            goto L3d
        L3c:
            r4 = r3
        L3d:
            int r6 = androidx.recyclerview.widget.m.f.makeMovementFlags(r2, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: di.a.getMovementFlags(androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$e0):int");
    }

    @Override // androidx.recyclerview.widget.m.f
    public float getSwipeThreshold(RecyclerView.e0 e0Var) {
        return this.f26264g;
    }

    public void h(int i10) {
        this.f26266i = i10;
    }

    @Override // androidx.recyclerview.widget.m.f
    public boolean isItemViewSwipeEnabled() {
        return this.f26261d;
    }

    @Override // androidx.recyclerview.widget.m.f
    public boolean isLongPressDragEnabled() {
        return this.f26259b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.m.f
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10) {
        if (i10 != 1 || !(e0Var instanceof b)) {
            super.onChildDraw(canvas, recyclerView, e0Var, f10, f11, i10, z10);
            return;
        }
        b bVar = (b) e0Var;
        View viewD = bVar.d();
        float f12 = f11 != 0.0f ? f11 : f10;
        int i11 = 0;
        if (f12 > 0.0f) {
            i11 = 8;
        } else if (f12 < 0.0f) {
            i11 = 4;
        }
        d(bVar, i11);
        m.f.getDefaultUIUtil().d(canvas, recyclerView, viewD, f10, f11, i10, z10);
    }

    @Override // androidx.recyclerview.widget.m.f
    public boolean onMove(RecyclerView recyclerView, RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        if (!this.f26258a.j(e0Var.getAdapterPosition(), e0Var2.getAdapterPosition())) {
            return false;
        }
        this.f26258a.c(e0Var.getAdapterPosition(), e0Var2.getAdapterPosition());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.m.f
    public void onSelectedChanged(RecyclerView.e0 e0Var, int i10) {
        this.f26258a.b(e0Var, i10);
        if (i10 == 0) {
            super.onSelectedChanged(e0Var, i10);
            return;
        }
        if (e0Var instanceof b) {
            b bVar = (b) e0Var;
            bVar.e(e0Var.getAdapterPosition(), i10);
            if (i10 == 1) {
                m.f.getDefaultUIUtil().b(bVar.d());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.m.f
    public void onSwiped(RecyclerView.e0 e0Var, int i10) {
        if (!(e0Var instanceof b) || ((b) e0Var).d().getTranslationX() == 0.0f) {
            return;
        }
        this.f26258a.f(e0Var.getAdapterPosition(), i10);
    }

    public void setMoveThreshold(float f10) {
        this.f26265h = f10;
    }

    public void setSwipeThreshold(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f26264g = f10;
    }
}
