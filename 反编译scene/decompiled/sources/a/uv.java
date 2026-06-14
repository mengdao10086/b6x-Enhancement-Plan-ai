package a;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class uv extends vv<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f7634a;
    public final Rect b;
    public int c;
    public int d;

    public uv() {
        this.f7634a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    public uv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7634a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    public static int N(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    @Override // a.vv
    public void F(CoordinatorLayout coordinatorLayout, View view, int i) {
        int bottom;
        View viewH = H(coordinatorLayout.r(view));
        if (viewH != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f7634a;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, viewH.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + viewH.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            sh lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && eh.v(coordinatorLayout) && !eh.v(view)) {
                rect.left += lastWindowInsets.g();
                rect.right -= lastWindowInsets.h();
            }
            Rect rect2 = this.b;
            bg.a(N(fVar.f8186a), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int I = I(viewH);
            view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            bottom = rect2.top - viewH.getBottom();
        } else {
            super.F(coordinatorLayout, view, i);
            bottom = 0;
        }
        this.c = bottom;
    }

    public abstract View H(List<View> list);

    public final int I(View view) {
        if (this.d == 0) {
            return 0;
        }
        float fJ = J(view);
        int i = this.d;
        return sd.b((int) (fJ * i), 0, i);
    }

    public abstract float J(View view);

    public final int K() {
        return this.d;
    }

    public int L(View view) {
        return view.getMeasuredHeight();
    }

    public final int M() {
        return this.c;
    }

    public final void O(int i) {
        this.d = i;
    }

    public boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewH;
        sh lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewH = H(coordinatorLayout.r(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (eh.v(viewH) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.i() + lastWindowInsets.f();
        }
        int iL = size + L(viewH);
        int measuredHeight = viewH.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            iL -= measuredHeight;
        }
        coordinatorLayout.J(view, i, i2, View.MeasureSpec.makeMeasureSpec(iL, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }
}
