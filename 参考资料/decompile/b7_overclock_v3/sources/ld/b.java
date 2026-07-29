package ld;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.j1;
import androidx.core.view.m;
import androidx.core.view.u0;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends d<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f39580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f39581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f39582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39583g;

    public b() {
        this.f39580d = new Rect();
        this.f39581e = new Rect();
        this.f39582f = 0;
    }

    public static int V(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    @Override // ld.d
    public void K(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, int i10) {
        View viewP = P(coordinatorLayout.q(view));
        if (viewP == null) {
            super.K(coordinatorLayout, view, i10);
            this.f39582f = 0;
            return;
        }
        CoordinatorLayout.g gVar = (CoordinatorLayout.g) view.getLayoutParams();
        Rect rect = this.f39580d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) gVar).leftMargin, viewP.getBottom() + ((ViewGroup.MarginLayoutParams) gVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin, ((coordinatorLayout.getHeight() + viewP.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin);
        j1 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && u0.U(coordinatorLayout) && !u0.U(view)) {
            rect.left += lastWindowInsets.p();
            rect.right -= lastWindowInsets.q();
        }
        Rect rect2 = this.f39581e;
        m.b(V(gVar.f4555c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
        int iQ = Q(viewP);
        view.layout(rect2.left, rect2.top - iQ, rect2.right, rect2.bottom - iQ);
        this.f39582f = rect2.top - viewP.getBottom();
    }

    @p0
    public abstract View P(List<View> list);

    public final int Q(View view) {
        if (this.f39583g == 0) {
            return 0;
        }
        float fR = R(view);
        int i10 = this.f39583g;
        return t0.a.e((int) (fR * i10), 0, i10);
    }

    public float R(View view) {
        return 1.0f;
    }

    public final int S() {
        return this.f39583g;
    }

    public int T(@n0 View view) {
        return view.getMeasuredHeight();
    }

    public final int U() {
        return this.f39582f;
    }

    public final void W(int i10) {
        this.f39583g = i10;
    }

    public boolean X() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, int i10, int i11, int i12, int i13) {
        View viewP;
        j1 lastWindowInsets;
        int i14 = view.getLayoutParams().height;
        if ((i14 != -1 && i14 != -2) || (viewP = P(coordinatorLayout.q(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (u0.U(viewP) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.r() + lastWindowInsets.o();
        }
        int iT = size + T(viewP);
        int measuredHeight = viewP.getMeasuredHeight();
        if (X()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iT -= measuredHeight;
        }
        coordinatorLayout.O(view, i10, i11, View.MeasureSpec.makeMeasureSpec(iT, i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
        return true;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39580d = new Rect();
        this.f39581e = new Rect();
        this.f39582f = 0;
    }
}
