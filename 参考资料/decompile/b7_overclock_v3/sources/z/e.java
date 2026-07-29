package z;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes2.dex */
public class e extends androidx.constraintlayout.widget.a {
    public static final String B = "Layer";
    public boolean A;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f57610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f57611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f57612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f57613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f57614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f57615o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f57616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f57617q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f57618r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f57619s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f57620t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f57621u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f57622v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View[] f57623w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f57624x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f57625y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f57626z;

    public e(Context context) {
        super(context);
        this.f57610j = Float.NaN;
        this.f57611k = Float.NaN;
        this.f57612l = Float.NaN;
        this.f57614n = 1.0f;
        this.f57615o = 1.0f;
        this.f57616p = Float.NaN;
        this.f57617q = Float.NaN;
        this.f57618r = Float.NaN;
        this.f57619s = Float.NaN;
        this.f57620t = Float.NaN;
        this.f57621u = Float.NaN;
        this.f57622v = true;
        this.f57623w = null;
        this.f57624x = 0.0f;
        this.f57625y = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.a
    public void D(ConstraintLayout container) {
        K();
        this.f57616p = Float.NaN;
        this.f57617q = Float.NaN;
        ConstraintWidget constraintWidgetB = ((ConstraintLayout.b) getLayoutParams()).b();
        constraintWidgetB.c2(0);
        constraintWidgetB.y1(0);
        J();
        layout(((int) this.f57620t) - getPaddingLeft(), ((int) this.f57621u) - getPaddingTop(), ((int) this.f57618r) + getPaddingRight(), ((int) this.f57619s) + getPaddingBottom());
        L();
    }

    @Override // androidx.constraintlayout.widget.a
    public void F(ConstraintLayout container) {
        this.f57613m = container;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f57612l = rotation;
        } else {
            if (Float.isNaN(this.f57612l)) {
                return;
            }
            this.f57612l = rotation;
        }
    }

    public void J() {
        if (this.f57613m == null) {
            return;
        }
        if (this.f57622v || Float.isNaN(this.f57616p) || Float.isNaN(this.f57617q)) {
            if (!Float.isNaN(this.f57610j) && !Float.isNaN(this.f57611k)) {
                this.f57617q = this.f57611k;
                this.f57616p = this.f57610j;
                return;
            }
            View[] viewArrW = w(this.f57613m);
            int left = viewArrW[0].getLeft();
            int top2 = viewArrW[0].getTop();
            int right = viewArrW[0].getRight();
            int bottom = viewArrW[0].getBottom();
            for (int i10 = 0; i10 < this.f4170b; i10++) {
                View view = viewArrW[i10];
                left = Math.min(left, view.getLeft());
                top2 = Math.min(top2, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f57618r = right;
            this.f57619s = bottom;
            this.f57620t = left;
            this.f57621u = top2;
            if (Float.isNaN(this.f57610j)) {
                this.f57616p = (left + right) / 2;
            } else {
                this.f57616p = this.f57610j;
            }
            if (Float.isNaN(this.f57611k)) {
                this.f57617q = (top2 + bottom) / 2;
            } else {
                this.f57617q = this.f57611k;
            }
        }
    }

    public final void K() {
        int i10;
        if (this.f57613m == null || (i10 = this.f4170b) == 0) {
            return;
        }
        View[] viewArr = this.f57623w;
        if (viewArr == null || viewArr.length != i10) {
            this.f57623w = new View[i10];
        }
        for (int i11 = 0; i11 < this.f4170b; i11++) {
            this.f57623w[i11] = this.f57613m.s(this.f4169a[i11]);
        }
    }

    public final void L() {
        if (this.f57613m == null) {
            return;
        }
        if (this.f57623w == null) {
            K();
        }
        J();
        double radians = Float.isNaN(this.f57612l) ? 0.0d : Math.toRadians(this.f57612l);
        float fSin = (float) Math.sin(radians);
        float fCos = (float) Math.cos(radians);
        float f10 = this.f57614n;
        float f11 = f10 * fCos;
        float f12 = this.f57615o;
        float f13 = (-f12) * fSin;
        float f14 = f10 * fSin;
        float f15 = f12 * fCos;
        for (int i10 = 0; i10 < this.f4170b; i10++) {
            View view = this.f57623w[i10];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top2 = (view.getTop() + view.getBottom()) / 2;
            float f16 = left - this.f57616p;
            float f17 = top2 - this.f57617q;
            float f18 = (((f11 * f16) + (f13 * f17)) - f16) + this.f57624x;
            float f19 = (((f16 * f14) + (f15 * f17)) - f17) + this.f57625y;
            view.setTranslationX(f18);
            view.setTranslationY(f19);
            view.setScaleY(this.f57615o);
            view.setScaleX(this.f57614n);
            if (!Float.isNaN(this.f57612l)) {
                view.setRotation(this.f57612l);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.a, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f57613m = (ConstraintLayout) getParent();
        if (this.f57626z || this.A) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i10 = 0; i10 < this.f4170b; i10++) {
                View viewS = this.f57613m.s(this.f4169a[i10]);
                if (viewS != null) {
                    if (this.f57626z) {
                        viewS.setVisibility(visibility);
                    }
                    if (this.A && elevation > 0.0f) {
                        viewS.setTranslationZ(viewS.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.a
    public void r(ConstraintLayout container) {
        q(container);
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        p();
    }

    @Override // android.view.View
    public void setPivotX(float pivotX) {
        this.f57610j = pivotX;
        L();
    }

    @Override // android.view.View
    public void setPivotY(float pivotY) {
        this.f57611k = pivotY;
        L();
    }

    @Override // android.view.View
    public void setRotation(float angle) {
        this.f57612l = angle;
        L();
    }

    @Override // android.view.View
    public void setScaleX(float scaleX) {
        this.f57614n = scaleX;
        L();
    }

    @Override // android.view.View
    public void setScaleY(float scaleY) {
        this.f57615o = scaleY;
        L();
    }

    @Override // android.view.View
    public void setTranslationX(float dx) {
        this.f57624x = dx;
        L();
    }

    @Override // android.view.View
    public void setTranslationY(float dy) {
        this.f57625y = dy;
        L();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        p();
    }

    @Override // androidx.constraintlayout.widget.a
    public void y(AttributeSet attrs) {
        super.y(attrs);
        this.f4173e = false;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f57626z = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.A = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public e(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f57610j = Float.NaN;
        this.f57611k = Float.NaN;
        this.f57612l = Float.NaN;
        this.f57614n = 1.0f;
        this.f57615o = 1.0f;
        this.f57616p = Float.NaN;
        this.f57617q = Float.NaN;
        this.f57618r = Float.NaN;
        this.f57619s = Float.NaN;
        this.f57620t = Float.NaN;
        this.f57621u = Float.NaN;
        this.f57622v = true;
        this.f57623w = null;
        this.f57624x = 0.0f;
        this.f57625y = 0.0f;
    }

    public e(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f57610j = Float.NaN;
        this.f57611k = Float.NaN;
        this.f57612l = Float.NaN;
        this.f57614n = 1.0f;
        this.f57615o = 1.0f;
        this.f57616p = Float.NaN;
        this.f57617q = Float.NaN;
        this.f57618r = Float.NaN;
        this.f57619s = Float.NaN;
        this.f57620t = Float.NaN;
        this.f57621u = Float.NaN;
        this.f57622v = true;
        this.f57623w = null;
        this.f57624x = 0.0f;
        this.f57625y = 0.0f;
    }
}
