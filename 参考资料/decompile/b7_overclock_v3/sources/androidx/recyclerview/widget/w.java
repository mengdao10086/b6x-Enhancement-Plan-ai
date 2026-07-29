package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7230d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7231e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7232f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f7233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f7235c;

    public static class a extends w {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.w
        public int d(View view) {
            return this.f7233a.j0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f7233a.i0(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f7233a.h0(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int g(View view) {
            return this.f7233a.g0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int h() {
            return this.f7233a.B0();
        }

        @Override // androidx.recyclerview.widget.w
        public int i() {
            return this.f7233a.B0() - this.f7233a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.w
        public int j() {
            return this.f7233a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.w
        public int l() {
            return this.f7233a.C0();
        }

        @Override // androidx.recyclerview.widget.w
        public int m() {
            return this.f7233a.n0();
        }

        @Override // androidx.recyclerview.widget.w
        public int n() {
            return this.f7233a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.w
        public int o() {
            return (this.f7233a.B0() - this.f7233a.getPaddingLeft()) - this.f7233a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.w
        public int q(View view) {
            this.f7233a.A0(view, true, this.f7235c);
            return this.f7235c.right;
        }

        @Override // androidx.recyclerview.widget.w
        public int r(View view) {
            this.f7233a.A0(view, true, this.f7235c);
            return this.f7235c.left;
        }

        @Override // androidx.recyclerview.widget.w
        public void s(View view, int i10) {
            view.offsetLeftAndRight(i10);
        }

        @Override // androidx.recyclerview.widget.w
        public void t(int i10) {
            this.f7233a.V0(i10);
        }
    }

    public static class b extends w {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.w
        public int d(View view) {
            return this.f7233a.e0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f7233a.h0(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f7233a.i0(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int g(View view) {
            return this.f7233a.k0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int h() {
            return this.f7233a.m0();
        }

        @Override // androidx.recyclerview.widget.w
        public int i() {
            return this.f7233a.m0() - this.f7233a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.w
        public int j() {
            return this.f7233a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.w
        public int l() {
            return this.f7233a.n0();
        }

        @Override // androidx.recyclerview.widget.w
        public int m() {
            return this.f7233a.C0();
        }

        @Override // androidx.recyclerview.widget.w
        public int n() {
            return this.f7233a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.w
        public int o() {
            return (this.f7233a.m0() - this.f7233a.getPaddingTop()) - this.f7233a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.w
        public int q(View view) {
            this.f7233a.A0(view, true, this.f7235c);
            return this.f7235c.bottom;
        }

        @Override // androidx.recyclerview.widget.w
        public int r(View view) {
            this.f7233a.A0(view, true, this.f7235c);
            return this.f7235c.top;
        }

        @Override // androidx.recyclerview.widget.w
        public void s(View view, int i10) {
            view.offsetTopAndBottom(i10);
        }

        @Override // androidx.recyclerview.widget.w
        public void t(int i10) {
            this.f7233a.W0(i10);
        }
    }

    public /* synthetic */ w(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static w a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static w b(RecyclerView.o oVar, int i10) {
        if (i10 == 0) {
            return a(oVar);
        }
        if (i10 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static w c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public RecyclerView.o k() {
        return this.f7233a;
    }

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public int p() {
        if (Integer.MIN_VALUE == this.f7234b) {
            return 0;
        }
        return o() - this.f7234b;
    }

    public abstract int q(View view);

    public abstract int r(View view);

    public abstract void s(View view, int i10);

    public abstract void t(int i10);

    public void u() {
        this.f7234b = o();
    }

    public w(RecyclerView.o oVar) {
        this.f7234b = Integer.MIN_VALUE;
        this.f7235c = new Rect();
        this.f7233a = oVar;
    }
}
