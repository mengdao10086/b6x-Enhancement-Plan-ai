package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.u0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class l extends ViewGroup implements g2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f7898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f7899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f7900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public Matrix f7902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f7903f;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            u0.n1(l.this);
            l lVar = l.this;
            ViewGroup viewGroup = lVar.f7898a;
            if (viewGroup == null || (view = lVar.f7899b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            u0.n1(l.this.f7898a);
            l lVar2 = l.this;
            lVar2.f7898a = null;
            lVar2.f7899b = null;
            return true;
        }
    }

    public l(View view) {
        super(view.getContext());
        this.f7903f = new a();
        this.f7900c = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    public static l b(View view, ViewGroup viewGroup, Matrix matrix) {
        k kVar;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        k kVarB = k.b(viewGroup);
        l lVarE = e(view);
        int i10 = 0;
        if (lVarE != null && (kVar = (k) lVarE.getParent()) != kVarB) {
            i10 = lVarE.f7901d;
            kVar.removeView(lVarE);
            lVarE = null;
        }
        if (lVarE == null) {
            if (matrix == null) {
                matrix = new Matrix();
                c(view, viewGroup, matrix);
            }
            lVarE = new l(view);
            lVarE.h(matrix);
            if (kVarB == null) {
                kVarB = new k(viewGroup);
            } else {
                kVarB.g();
            }
            d(viewGroup, kVarB);
            d(viewGroup, lVarE);
            kVarB.a(lVarE);
            lVarE.f7901d = i10;
        } else if (matrix != null) {
            lVarE.h(matrix);
        }
        lVarE.f7901d++;
        return lVarE;
    }

    public static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        g2.z.j(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        g2.z.k(viewGroup, matrix);
    }

    public static void d(View view, View view2) {
        g2.z.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    public static l e(View view) {
        return (l) view.getTag(R.id.ghost_view);
    }

    public static void f(View view) {
        l lVarE = e(view);
        if (lVarE != null) {
            int i10 = lVarE.f7901d - 1;
            lVarE.f7901d = i10;
            if (i10 <= 0) {
                ((k) lVarE.getParent()).removeView(lVarE);
            }
        }
    }

    public static void g(@n0 View view, @p0 l lVar) {
        view.setTag(R.id.ghost_view, lVar);
    }

    @Override // g2.e
    public void a(ViewGroup viewGroup, View view) {
        this.f7898a = viewGroup;
        this.f7899b = view;
    }

    public void h(@n0 Matrix matrix) {
        this.f7902e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.f7900c, this);
        this.f7900c.getViewTreeObserver().addOnPreDrawListener(this.f7903f);
        g2.z.i(this.f7900c, 4);
        if (this.f7900c.getParent() != null) {
            ((View) this.f7900c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f7900c.getViewTreeObserver().removeOnPreDrawListener(this.f7903f);
        g2.z.i(this.f7900c, 0);
        g(this.f7900c, null);
        if (this.f7900c.getParent() != null) {
            ((View) this.f7900c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        g2.b.a(canvas, true);
        canvas.setMatrix(this.f7902e);
        g2.z.i(this.f7900c, 0);
        this.f7900c.invalidate();
        g2.z.i(this.f7900c, 4);
        drawChild(canvas, this.f7900c, getDrawingTime());
        g2.b.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View, g2.e
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (e(this.f7900c) == this) {
            g2.z.i(this.f7900c, i10 == 0 ? 4 : 0);
        }
    }
}
