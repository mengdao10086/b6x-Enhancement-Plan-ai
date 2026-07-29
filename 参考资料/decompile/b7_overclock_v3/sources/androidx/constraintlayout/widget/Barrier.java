package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;

/* JADX INFO: loaded from: classes2.dex */
public class Barrier extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4021m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4022n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f4023o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f4024p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f4025q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f4026r = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.a f4029l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.a
    public void B(ConstraintWidget widget, boolean isRtl) {
        K(widget, this.f4027j, isRtl);
    }

    @Deprecated
    public boolean J() {
        return this.f4029l.o2();
    }

    public final void K(ConstraintWidget widget, int type, boolean isRtl) {
        this.f4028k = type;
        if (isRtl) {
            int i10 = this.f4027j;
            if (i10 == 5) {
                this.f4028k = 1;
            } else if (i10 == 6) {
                this.f4028k = 0;
            }
        } else {
            int i11 = this.f4027j;
            if (i11 == 5) {
                this.f4028k = 0;
            } else if (i11 == 6) {
                this.f4028k = 1;
            }
        }
        if (widget instanceof androidx.constraintlayout.core.widgets.a) {
            ((androidx.constraintlayout.core.widgets.a) widget).u2(this.f4028k);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f4029l.o2();
    }

    public int getMargin() {
        return this.f4029l.q2();
    }

    public int getType() {
        return this.f4027j;
    }

    public void setAllowsGoneWidget(boolean supportGone) {
        this.f4029l.t2(supportGone);
    }

    public void setDpMargin(int margin) {
        this.f4029l.v2((int) ((margin * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int margin) {
        this.f4029l.v2(margin);
    }

    public void setType(int type) {
        this.f4027j = type;
    }

    @Override // androidx.constraintlayout.widget.a
    public void y(AttributeSet attrs) {
        super.y(attrs);
        this.f4029l = new androidx.constraintlayout.core.widgets.a();
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f4029l.t2(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f4029l.v2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f4172d = this.f4029l;
        I();
    }

    @Override // androidx.constraintlayout.widget.a
    public void z(d.a constraint, y.b child, ConstraintLayout.b layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        super.z(constraint, child, layoutParams, mapIdToWidget);
        if (child instanceof androidx.constraintlayout.core.widgets.a) {
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) child;
            K(aVar, constraint.f4295e.f4365h0, ((androidx.constraintlayout.core.widgets.d) child.U()).O2());
            aVar.t2(constraint.f4295e.f4381p0);
            aVar.v2(constraint.f4295e.f4367i0);
        }
    }

    public Barrier(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        super.setVisibility(8);
    }
}
