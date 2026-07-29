package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class r extends b0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f7192g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public w f7193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public w f7194f;

    @Override // androidx.recyclerview.widget.b0
    public int[] c(@n0 RecyclerView.o oVar, @n0 View view) {
        int[] iArr = new int[2];
        if (oVar.v()) {
            iArr[0] = n(oVar, view, q(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.w()) {
            iArr[1] = n(oVar, view, r(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.b0
    public View h(RecyclerView.o oVar) {
        if (oVar.w()) {
            return p(oVar, r(oVar));
        }
        if (oVar.v()) {
            return p(oVar, q(oVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.b0
    public int i(RecyclerView.o oVar, int i10, int i11) {
        int iO0;
        View viewH;
        int iU0;
        int i12;
        PointF pointFA;
        int iO;
        int iO2;
        if (!(oVar instanceof RecyclerView.a0.b) || (iO0 = oVar.o0()) == 0 || (viewH = h(oVar)) == null || (iU0 = oVar.u0(viewH)) == -1 || (pointFA = ((RecyclerView.a0.b) oVar).a(iO0 - 1)) == null) {
            return -1;
        }
        if (oVar.v()) {
            iO = o(oVar, q(oVar), i10, 0);
            if (pointFA.x < 0.0f) {
                iO = -iO;
            }
        } else {
            iO = 0;
        }
        if (oVar.w()) {
            iO2 = o(oVar, r(oVar), 0, i11);
            if (pointFA.y < 0.0f) {
                iO2 = -iO2;
            }
        } else {
            iO2 = 0;
        }
        if (oVar.w()) {
            iO = iO2;
        }
        if (iO == 0) {
            return -1;
        }
        int i13 = iU0 + iO;
        int i14 = i13 >= 0 ? i13 : 0;
        return i14 >= iO0 ? i12 : i14;
    }

    public final float m(RecyclerView.o oVar, w wVar) {
        int iY = oVar.Y();
        if (iY == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < iY; i12++) {
            View viewX = oVar.X(i12);
            int iU0 = oVar.u0(viewX);
            if (iU0 != -1) {
                if (iU0 < i10) {
                    view = viewX;
                    i10 = iU0;
                }
                if (iU0 > i11) {
                    view2 = viewX;
                    i11 = iU0;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(wVar.d(view), wVar.d(view2)) - Math.min(wVar.g(view), wVar.g(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i11 - i10) + 1);
    }

    public final int n(@n0 RecyclerView.o oVar, @n0 View view, w wVar) {
        return (wVar.g(view) + (wVar.e(view) / 2)) - (wVar.n() + (wVar.o() / 2));
    }

    public final int o(RecyclerView.o oVar, w wVar, int i10, int i11) {
        int[] iArrD = d(i10, i11);
        float fM = m(oVar, wVar);
        if (fM <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArrD[0]) > Math.abs(iArrD[1]) ? iArrD[0] : iArrD[1]) / fM);
    }

    @p0
    public final View p(RecyclerView.o oVar, w wVar) {
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
    public final w q(@n0 RecyclerView.o oVar) {
        w wVar = this.f7194f;
        if (wVar == null || wVar.f7233a != oVar) {
            this.f7194f = w.a(oVar);
        }
        return this.f7194f;
    }

    @n0
    public final w r(@n0 RecyclerView.o oVar) {
        w wVar = this.f7193e;
        if (wVar == null || wVar.f7233a != oVar) {
            this.f7193e = w.c(oVar);
        }
        return this.f7193e;
    }
}
