package xd;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.l;
import g.n;
import g.n0;
import g.p0;
import g.q;
import g.t0;
import h0.d;
import n0.c;

/* JADX INFO: loaded from: classes3.dex */
public class a extends RecyclerView.n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f55164i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f55165j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f55166k = R.style.Widget_MaterialComponents_MaterialDivider;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public Drawable f55167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f55168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public int f55169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f55170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f55171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f55172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f55173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f55174h;

    public a(@n0 Context context, int i10) {
        this(context, null, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(@n0 Rect rect, @n0 View view, @n0 RecyclerView recyclerView, @n0 RecyclerView.b0 b0Var) {
        rect.set(0, 0, 0, 0);
        if (this.f55173g || recyclerView.r0(view) != b0Var.d() - 1) {
            if (this.f55170d == 1) {
                rect.bottom = this.f55167a.getIntrinsicHeight() + this.f55168b;
            } else {
                rect.right = this.f55167a.getIntrinsicWidth() + this.f55168b;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(@n0 Canvas canvas, @n0 RecyclerView recyclerView, @n0 RecyclerView.b0 b0Var) {
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        if (this.f55170d == 1) {
            j(canvas, recyclerView);
        } else {
            i(canvas, recyclerView);
        }
    }

    public final void i(@n0 Canvas canvas, @n0 RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int i10 = paddingTop + this.f55171e;
        int i11 = height - this.f55172f;
        int childCount = recyclerView.getChildCount();
        if (!this.f55173g) {
            childCount--;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.v0(childAt, this.f55174h);
            int iRound = this.f55174h.right + Math.round(childAt.getTranslationX());
            this.f55167a.setBounds((iRound - this.f55167a.getIntrinsicWidth()) - this.f55168b, i10, iRound, i11);
            this.f55167a.draw(canvas);
        }
        canvas.restore();
    }

    public final void j(@n0 Canvas canvas, @n0 RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        boolean z10 = u0.Z(recyclerView) == 1;
        int i10 = paddingLeft + (z10 ? this.f55172f : this.f55171e);
        int i11 = width - (z10 ? this.f55171e : this.f55172f);
        int childCount = recyclerView.getChildCount();
        if (!this.f55173g) {
            childCount--;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.v0(childAt, this.f55174h);
            int iRound = this.f55174h.bottom + Math.round(childAt.getTranslationY());
            this.f55167a.setBounds(i10, (iRound - this.f55167a.getIntrinsicHeight()) - this.f55168b, i11, iRound);
            this.f55167a.draw(canvas);
        }
        canvas.restore();
    }

    @l
    public int k() {
        return this.f55169c;
    }

    @t0
    public int l() {
        return this.f55172f;
    }

    @t0
    public int m() {
        return this.f55171e;
    }

    @t0
    public int n() {
        return this.f55168b;
    }

    public int o() {
        return this.f55170d;
    }

    public boolean p() {
        return this.f55173g;
    }

    public void q(@l int i10) {
        this.f55169c = i10;
        Drawable drawableR = c.r(this.f55167a);
        this.f55167a = drawableR;
        c.n(drawableR, i10);
    }

    public void r(@n0 Context context, @n int i10) {
        q(d.f(context, i10));
    }

    public void s(@t0 int i10) {
        this.f55172f = i10;
    }

    public void t(@n0 Context context, @q int i10) {
        s(context.getResources().getDimensionPixelOffset(i10));
    }

    public void u(@t0 int i10) {
        this.f55171e = i10;
    }

    public void v(@n0 Context context, @q int i10) {
        u(context.getResources().getDimensionPixelOffset(i10));
    }

    public void w(@t0 int i10) {
        this.f55168b = i10;
    }

    public void x(@n0 Context context, @q int i10) {
        w(context.getResources().getDimensionPixelSize(i10));
    }

    public void y(boolean z10) {
        this.f55173g = z10;
    }

    public void z(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f55170d = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i10 + ". It should be either HORIZONTAL or VERTICAL");
    }

    public a(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        this(context, attributeSet, R.attr.materialDividerStyle, i10);
    }

    public a(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        this.f55174h = new Rect();
        TypedArray typedArrayK = t.k(context, attributeSet, R.styleable.MaterialDivider, i10, f55166k, new int[0]);
        this.f55169c = ie.c.a(context, typedArrayK, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.f55168b = typedArrayK.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, context.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f55171e = typedArrayK.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.f55172f = typedArrayK.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        this.f55173g = typedArrayK.getBoolean(R.styleable.MaterialDivider_lastItemDecorated, true);
        typedArrayK.recycle();
        this.f55167a = new ShapeDrawable();
        q(this.f55169c);
        z(i11);
    }
}
