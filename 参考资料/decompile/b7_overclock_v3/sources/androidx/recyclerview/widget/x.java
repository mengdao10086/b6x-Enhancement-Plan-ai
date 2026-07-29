package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class x extends b0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7236g = 100;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public w f7237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public w f7238f;

    public class a extends q {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.q, androidx.recyclerview.widget.RecyclerView.a0
        public void p(View view, RecyclerView.b0 b0Var, RecyclerView.a0.a aVar) {
            x xVar = x.this;
            int[] iArrC = xVar.c(xVar.f6830a.getLayoutManager(), view);
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

        @Override // androidx.recyclerview.widget.q
        public int y(int i10) {
            return Math.min(100, super.y(i10));
        }
    }

    @Override // androidx.recyclerview.widget.b0
    @p0
    public int[] c(@n0 RecyclerView.o oVar, @n0 View view) {
        int[] iArr = new int[2];
        if (oVar.v()) {
            iArr[0] = m(oVar, view, o(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.w()) {
            iArr[1] = m(oVar, view, q(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.b0
    public q f(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.a0.b) {
            return new a(this.f6830a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.b0
    @p0
    public View h(RecyclerView.o oVar) {
        if (oVar.w()) {
            return n(oVar, q(oVar));
        }
        if (oVar.v()) {
            return n(oVar, o(oVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.b0
    public int i(RecyclerView.o oVar, int i10, int i11) {
        w wVarP;
        int iO0 = oVar.o0();
        if (iO0 == 0 || (wVarP = p(oVar)) == null) {
            return -1;
        }
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        int iY = oVar.Y();
        View view = null;
        View view2 = null;
        for (int i14 = 0; i14 < iY; i14++) {
            View viewX = oVar.X(i14);
            if (viewX != null) {
                int iM = m(oVar, viewX, wVarP);
                if (iM <= 0 && iM > i12) {
                    view2 = viewX;
                    i12 = iM;
                }
                if (iM >= 0 && iM < i13) {
                    view = viewX;
                    i13 = iM;
                }
            }
        }
        boolean zR = r(oVar, i10, i11);
        if (zR && view != null) {
            return oVar.u0(view);
        }
        if (!zR && view2 != null) {
            return oVar.u0(view2);
        }
        if (zR) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iU0 = oVar.u0(view) + (s(oVar) == zR ? -1 : 1);
        if (iU0 < 0 || iU0 >= iO0) {
            return -1;
        }
        return iU0;
    }

    public final int m(@n0 RecyclerView.o oVar, @n0 View view, w wVar) {
        return (wVar.g(view) + (wVar.e(view) / 2)) - (wVar.n() + (wVar.o() / 2));
    }

    @p0
    public final View n(RecyclerView.o oVar, w wVar) {
        int iY = oVar.Y();
        View view = null;
        if (iY == 0) {
            return null;
        }
        int iN = wVar.n() + (wVar.o() / 2);
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < iY; i11++) {
            View viewX = oVar.X(i11);
            int iAbs = Math.abs((wVar.g(viewX) + (wVar.e(viewX) / 2)) - iN);
            if (iAbs < i10) {
                view = viewX;
                i10 = iAbs;
            }
        }
        return view;
    }

    @n0
    public final w o(@n0 RecyclerView.o oVar) {
        w wVar = this.f7238f;
        if (wVar == null || wVar.f7233a != oVar) {
            this.f7238f = w.a(oVar);
        }
        return this.f7238f;
    }

    @p0
    public final w p(RecyclerView.o oVar) {
        if (oVar.w()) {
            return q(oVar);
        }
        if (oVar.v()) {
            return o(oVar);
        }
        return null;
    }

    @n0
    public final w q(@n0 RecyclerView.o oVar) {
        w wVar = this.f7237e;
        if (wVar == null || wVar.f7233a != oVar) {
            this.f7237e = w.c(oVar);
        }
        return this.f7237e;
    }

    public final boolean r(RecyclerView.o oVar, int i10, int i11) {
        return oVar.v() ? i10 > 0 : i11 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean s(RecyclerView.o oVar) {
        PointF pointFA;
        int iO0 = oVar.o0();
        if (!(oVar instanceof RecyclerView.a0.b) || (pointFA = ((RecyclerView.a0.b) oVar).a(iO0 - 1)) == null) {
            return false;
        }
        return pointFA.x < 0.0f || pointFA.y < 0.0f;
    }
}
