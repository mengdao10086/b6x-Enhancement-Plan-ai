package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes2.dex */
public class e extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4480b = "Constraints";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f4481a;

    public e(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attrs) {
        return new a(getContext(), attrs);
    }

    public final void c(AttributeSet attrs) {
    }

    public d getConstraintSet() {
        if (this.f4481a == null) {
            this.f4481a = new d();
        }
        this.f4481a.J(this);
        return this.f4481a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l10, int t10, int r10, int b10) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p10) {
        return new ConstraintLayout.b(p10);
    }

    public e(Context context, AttributeSet attrs) {
        super(context, attrs);
        c(attrs);
        super.setVisibility(8);
    }

    public e(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        c(attrs);
        super.setVisibility(8);
    }

    public static class a extends ConstraintLayout.b {
        public float V0;
        public boolean W0;
        public float X0;
        public float Y0;
        public float Z0;

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        public float f4482a1;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        public float f4483b1;

        /* JADX INFO: renamed from: c1, reason: collision with root package name */
        public float f4484c1;

        /* JADX INFO: renamed from: d1, reason: collision with root package name */
        public float f4485d1;

        /* JADX INFO: renamed from: e1, reason: collision with root package name */
        public float f4486e1;

        /* JADX INFO: renamed from: f1, reason: collision with root package name */
        public float f4487f1;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        public float f4488g1;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public float f4489h1;

        public a(int width, int height) {
            super(width, height);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.f4482a1 = 0.0f;
            this.f4483b1 = 1.0f;
            this.f4484c1 = 1.0f;
            this.f4485d1 = 0.0f;
            this.f4486e1 = 0.0f;
            this.f4487f1 = 0.0f;
            this.f4488g1 = 0.0f;
            this.f4489h1 = 0.0f;
        }

        public a(a source) {
            super((ConstraintLayout.b) source);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.f4482a1 = 0.0f;
            this.f4483b1 = 1.0f;
            this.f4484c1 = 1.0f;
            this.f4485d1 = 0.0f;
            this.f4486e1 = 0.0f;
            this.f4487f1 = 0.0f;
            this.f4488g1 = 0.0f;
            this.f4489h1 = 0.0f;
        }

        public a(Context c10, AttributeSet attrs) {
            super(c10, attrs);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.f4482a1 = 0.0f;
            this.f4483b1 = 1.0f;
            this.f4484c1 = 1.0f;
            this.f4485d1 = 0.0f;
            this.f4486e1 = 0.0f;
            this.f4487f1 = 0.0f;
            this.f4488g1 = 0.0f;
            this.f4489h1 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = c10.obtainStyledAttributes(attrs, R.styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.V0 = typedArrayObtainStyledAttributes.getFloat(index, this.V0);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.X0 = typedArrayObtainStyledAttributes.getFloat(index, this.X0);
                    this.W0 = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.Z0 = typedArrayObtainStyledAttributes.getFloat(index, this.Z0);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.f4482a1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4482a1);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.Y0 = typedArrayObtainStyledAttributes.getFloat(index, this.Y0);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.f4483b1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4483b1);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.f4484c1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4484c1);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.f4485d1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4485d1);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.f4486e1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4486e1);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.f4487f1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4487f1);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.f4488g1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4488g1);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.f4489h1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4489h1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
