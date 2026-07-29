package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class q extends RecyclerView.a0 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final boolean f7177q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f7178r = 25.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f7179s = 10000;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f7180t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f7181u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7182v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final float f7183w = 1.2f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PointF f7186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f7187l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7189n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f7184i = new LinearInterpolator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f7185j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7188m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7190o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7191p = 0;

    public q(Context context) {
        this.f7187l = context.getResources().getDisplayMetrics();
    }

    public int A() {
        PointF pointF = this.f7186k;
        if (pointF != null) {
            float f10 = pointF.x;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public final float B() {
        if (!this.f7188m) {
            this.f7189n = w(this.f7187l);
            this.f7188m = true;
        }
        return this.f7189n;
    }

    public int C() {
        PointF pointF = this.f7186k;
        if (pointF != null) {
            float f10 = pointF.y;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public void D(RecyclerView.a0.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.f(f());
            s();
            return;
        }
        j(pointFA);
        this.f7186k = pointFA;
        this.f7190o = (int) (pointFA.x * 10000.0f);
        this.f7191p = (int) (pointFA.y * 10000.0f);
        aVar.l((int) (this.f7190o * 1.2f), (int) (this.f7191p * 1.2f), (int) (y(10000) * 1.2f), this.f7184i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0
    public void m(int i10, int i11, RecyclerView.b0 b0Var, RecyclerView.a0.a aVar) {
        if (c() == 0) {
            s();
            return;
        }
        this.f7190o = z(this.f7190o, i10);
        int iZ = z(this.f7191p, i11);
        this.f7191p = iZ;
        if (this.f7190o == 0 && iZ == 0) {
            D(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0
    public void n() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0
    public void o() {
        this.f7191p = 0;
        this.f7190o = 0;
        this.f7186k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0
    public void p(View view, RecyclerView.b0 b0Var, RecyclerView.a0.a aVar) {
        int iU = u(view, A());
        int iV = v(view, C());
        int iX = x((int) Math.sqrt((iU * iU) + (iV * iV)));
        if (iX > 0) {
            aVar.l(-iU, -iV, iX, this.f7185j);
        }
    }

    public int t(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == -1) {
            return i12 - i10;
        }
        if (i14 != 0) {
            if (i14 == 1) {
                return i13 - i11;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i15 = i12 - i10;
        if (i15 > 0) {
            return i15;
        }
        int i16 = i13 - i11;
        if (i16 < 0) {
            return i16;
        }
        return 0;
    }

    public int u(View view, int i10) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.v()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return t(oVarE.g0(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, oVarE.j0(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, oVarE.getPaddingLeft(), oVarE.B0() - oVarE.getPaddingRight(), i10);
    }

    public int v(View view, int i10) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.w()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return t(oVarE.k0(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, oVarE.e0(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, oVarE.getPaddingTop(), oVarE.m0() - oVarE.getPaddingBottom(), i10);
    }

    public float w(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int x(int i10) {
        return (int) Math.ceil(((double) y(i10)) / 0.3356d);
    }

    public int y(int i10) {
        return (int) Math.ceil(Math.abs(i10) * B());
    }

    public final int z(int i10, int i11) {
        int i12 = i10 - i11;
        if (i10 * i12 <= 0) {
            return 0;
        }
        return i12;
    }
}
