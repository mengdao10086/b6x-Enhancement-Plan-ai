package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class j extends RecyclerView.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7055d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7056e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7057f = "DividerItem";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f7058g = {R.attr.listDivider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f7059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f7061c = new Rect();

    public j(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f7058g);
        this.f7059a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        m(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        Drawable drawable = this.f7059a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f7060b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        if (recyclerView.getLayoutManager() == null || this.f7059a == null) {
            return;
        }
        if (this.f7060b == 1) {
            j(canvas, recyclerView);
        } else {
            i(canvas, recyclerView);
        }
    }

    public final void i(Canvas canvas, RecyclerView recyclerView) {
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
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            recyclerView.getLayoutManager().f0(childAt, this.f7061c);
            int iRound = this.f7061c.right + Math.round(childAt.getTranslationX());
            this.f7059a.setBounds(iRound - this.f7059a.getIntrinsicWidth(), paddingTop, iRound, height);
            this.f7059a.draw(canvas);
        }
        canvas.restore();
    }

    public final void j(Canvas canvas, RecyclerView recyclerView) {
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
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            recyclerView.v0(childAt, this.f7061c);
            int iRound = this.f7061c.bottom + Math.round(childAt.getTranslationY());
            this.f7059a.setBounds(paddingLeft, iRound - this.f7059a.getIntrinsicHeight(), width, iRound);
            this.f7059a.draw(canvas);
        }
        canvas.restore();
    }

    @p0
    public Drawable k() {
        return this.f7059a;
    }

    public void l(@n0 Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f7059a = drawable;
    }

    public void m(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f7060b = i10;
    }
}
