package z;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.i;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.d;
import androidx.constraintlayout.widget.k;

/* JADX INFO: loaded from: classes2.dex */
public class d extends k {
    public static final int A = 2;
    public static final int B = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f57595m = "Flow";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f57596n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f57597o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f57598p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f57599q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f57600r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f57601s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f57602t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f57603u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f57604v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f57605w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f57606x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f57607y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f57608z = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.e f57609l;

    public d(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.a
    public void B(ConstraintWidget widget, boolean isRtl) {
        this.f57609l.m2(isRtl);
    }

    @Override // androidx.constraintlayout.widget.k
    public void J(i layout, int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (layout == null) {
            setMeasuredDimension(0, 0);
        } else {
            layout.v2(mode, size, mode2, size2);
            setMeasuredDimension(layout.q2(), layout.p2());
        }
    }

    @Override // androidx.constraintlayout.widget.a, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        J(this.f57609l, widthMeasureSpec, heightMeasureSpec);
    }

    public void setFirstHorizontalBias(float bias) {
        this.f57609l.k3(bias);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int style) {
        this.f57609l.l3(style);
        requestLayout();
    }

    public void setFirstVerticalBias(float bias) {
        this.f57609l.m3(bias);
        requestLayout();
    }

    public void setFirstVerticalStyle(int style) {
        this.f57609l.n3(style);
        requestLayout();
    }

    public void setHorizontalAlign(int align) {
        this.f57609l.o3(align);
        requestLayout();
    }

    public void setHorizontalBias(float bias) {
        this.f57609l.p3(bias);
        requestLayout();
    }

    public void setHorizontalGap(int gap) {
        this.f57609l.q3(gap);
        requestLayout();
    }

    public void setHorizontalStyle(int style) {
        this.f57609l.r3(style);
        requestLayout();
    }

    public void setLastHorizontalBias(float bias) {
        this.f57609l.s3(bias);
        requestLayout();
    }

    public void setLastHorizontalStyle(int style) {
        this.f57609l.t3(style);
        requestLayout();
    }

    public void setLastVerticalBias(float bias) {
        this.f57609l.u3(bias);
        requestLayout();
    }

    public void setLastVerticalStyle(int style) {
        this.f57609l.v3(style);
        requestLayout();
    }

    public void setMaxElementsWrap(int max) {
        this.f57609l.w3(max);
        requestLayout();
    }

    public void setOrientation(int orientation) {
        this.f57609l.x3(orientation);
        requestLayout();
    }

    public void setPadding(int padding) {
        this.f57609l.B2(padding);
        requestLayout();
    }

    public void setPaddingBottom(int paddingBottom) {
        this.f57609l.C2(paddingBottom);
        requestLayout();
    }

    public void setPaddingLeft(int paddingLeft) {
        this.f57609l.E2(paddingLeft);
        requestLayout();
    }

    public void setPaddingRight(int paddingRight) {
        this.f57609l.F2(paddingRight);
        requestLayout();
    }

    public void setPaddingTop(int paddingTop) {
        this.f57609l.H2(paddingTop);
        requestLayout();
    }

    public void setVerticalAlign(int align) {
        this.f57609l.y3(align);
        requestLayout();
    }

    public void setVerticalBias(float bias) {
        this.f57609l.z3(bias);
        requestLayout();
    }

    public void setVerticalGap(int gap) {
        this.f57609l.A3(gap);
        requestLayout();
    }

    public void setVerticalStyle(int style) {
        this.f57609l.B3(style);
        requestLayout();
    }

    public void setWrapMode(int mode) {
        this.f57609l.C3(mode);
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.k, androidx.constraintlayout.widget.a
    public void y(AttributeSet attrs) {
        super.y(attrs);
        this.f57609l = new androidx.constraintlayout.core.widgets.e();
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f57609l.x3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.f57609l.B2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.f57609l.G2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f57609l.D2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f57609l.E2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f57609l.H2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f57609l.F2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f57609l.C2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f57609l.C3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f57609l.r3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f57609l.B3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f57609l.l3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f57609l.t3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f57609l.n3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f57609l.v3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f57609l.p3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f57609l.k3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f57609l.s3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f57609l.m3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f57609l.u3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f57609l.z3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f57609l.o3(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f57609l.y3(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f57609l.q3(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f57609l.A3(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f57609l.w3(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f4172d = this.f57609l;
        I();
    }

    @Override // androidx.constraintlayout.widget.a
    public void z(d.a constraint, y.b child, ConstraintLayout.b layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        super.z(constraint, child, layoutParams, mapIdToWidget);
        if (child instanceof androidx.constraintlayout.core.widgets.e) {
            androidx.constraintlayout.core.widgets.e eVar = (androidx.constraintlayout.core.widgets.e) child;
            int i10 = layoutParams.Z;
            if (i10 != -1) {
                eVar.x3(i10);
            }
        }
    }

    public d(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public d(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
