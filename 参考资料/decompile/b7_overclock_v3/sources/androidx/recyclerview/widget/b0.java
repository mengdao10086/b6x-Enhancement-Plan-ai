package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends RecyclerView.r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f6829d = 100.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f6830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f6831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.t f6832c = new a();

    public class a extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6833a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
            if (i10 == 0 && this.f6833a) {
                this.f6833a = false;
                b0.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            this.f6833a = true;
        }
    }

    public class b extends q {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.q, androidx.recyclerview.widget.RecyclerView.a0
        public void p(View view, RecyclerView.b0 b0Var, RecyclerView.a0.a aVar) {
            b0 b0Var2 = b0.this;
            RecyclerView recyclerView = b0Var2.f6830a;
            if (recyclerView == null) {
                return;
            }
            int[] iArrC = b0Var2.c(recyclerView.getLayoutManager(), view);
            int i10 = iArrC[0];
            int i11 = iArrC[1];
            int iX = x(Math.max(Math.abs(i10), Math.abs(i11)));
            if (iX > 0) {
                aVar.l(i10, i11, iX, this.f7185j);
            }
        }

        @Override // androidx.recyclerview.widget.q
        public float w(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i10, int i11) {
        RecyclerView.o layoutManager = this.f6830a.getLayoutManager();
        if (layoutManager == null || this.f6830a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f6830a.getMinFlingVelocity();
        return (Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && k(layoutManager, i10, i11);
    }

    public void b(@p0 RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f6830a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            g();
        }
        this.f6830a = recyclerView;
        if (recyclerView != null) {
            j();
            this.f6831b = new Scroller(this.f6830a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    @p0
    public abstract int[] c(@n0 RecyclerView.o oVar, @n0 View view);

    public int[] d(int i10, int i11) {
        this.f6831b.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f6831b.getFinalX(), this.f6831b.getFinalY()};
    }

    @p0
    public RecyclerView.a0 e(RecyclerView.o oVar) {
        return f(oVar);
    }

    @p0
    @Deprecated
    public q f(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.a0.b) {
            return new b(this.f6830a.getContext());
        }
        return null;
    }

    public final void g() {
        this.f6830a.u1(this.f6832c);
        this.f6830a.setOnFlingListener(null);
    }

    @p0
    public abstract View h(RecyclerView.o oVar);

    public abstract int i(RecyclerView.o oVar, int i10, int i11);

    public final void j() throws IllegalStateException {
        if (this.f6830a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f6830a.r(this.f6832c);
        this.f6830a.setOnFlingListener(this);
    }

    public final boolean k(@n0 RecyclerView.o oVar, int i10, int i11) {
        RecyclerView.a0 a0VarE;
        int i12;
        if (!(oVar instanceof RecyclerView.a0.b) || (a0VarE = e(oVar)) == null || (i12 = i(oVar, i10, i11)) == -1) {
            return false;
        }
        a0VarE.q(i12);
        oVar.g2(a0VarE);
        return true;
    }

    public void l() {
        RecyclerView.o layoutManager;
        View viewH;
        RecyclerView recyclerView = this.f6830a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewH = h(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewH);
        if (iArrC[0] == 0 && iArrC[1] == 0) {
            return;
        }
        this.f6830a.H1(iArrC[0], iArrC[1]);
    }
}
