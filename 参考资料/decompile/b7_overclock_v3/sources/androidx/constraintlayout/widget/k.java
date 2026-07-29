package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4521k;

    public k(Context context) {
        super(context);
    }

    public void J(androidx.constraintlayout.core.widgets.i layout, int widthMeasureSpec, int heightMeasureSpec) {
    }

    @Override // androidx.constraintlayout.widget.a, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4520j || this.f4521k) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i10 = 0; i10 < this.f4170b; i10++) {
                    View viewS = constraintLayout.s(this.f4169a[i10]);
                    if (viewS != null) {
                        if (this.f4520j) {
                            viewS.setVisibility(visibility);
                        }
                        if (this.f4521k && elevation > 0.0f) {
                            viewS.setTranslationZ(viewS.getTranslationZ() + elevation);
                        }
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
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        p();
    }

    @Override // androidx.constraintlayout.widget.a
    public void y(AttributeSet attrs) {
        super.y(attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f4520j = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f4521k = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public k(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public k(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
