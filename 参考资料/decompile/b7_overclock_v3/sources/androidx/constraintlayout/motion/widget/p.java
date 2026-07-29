package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class p extends androidx.constraintlayout.widget.a implements q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View[] f3873m;

    public p(Context context) {
        super(context);
        this.f3870j = false;
        this.f3871k = false;
    }

    public void J(View view, float progress) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.l
    public void a(MotionLayout motionLayout, int startId, int endId, float progress) {
    }

    @Override // androidx.constraintlayout.motion.widget.q
    public void b(MotionLayout motionLayout) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.l
    public void c(MotionLayout motionLayout, int startId, int endId) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.l
    public void d(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
    }

    @Override // androidx.constraintlayout.motion.widget.q
    public boolean e() {
        return this.f3870j;
    }

    @Override // androidx.constraintlayout.motion.widget.q
    public boolean f() {
        return this.f3871k;
    }

    @Override // androidx.constraintlayout.motion.widget.q
    public void g(MotionLayout motionLayout, HashMap<View, o> controllerMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public float getProgress() {
        return this.f3872l;
    }

    @Override // androidx.constraintlayout.motion.widget.q
    public void h(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.motion.widget.q
    public void i(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.motion.widget.q
    public boolean j() {
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.l
    public void k(MotionLayout motionLayout, int currentId) {
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void setProgress(float progress) {
        this.f3872l = progress;
        int i10 = 0;
        if (this.f4170b > 0) {
            this.f3873m = w((ConstraintLayout) getParent());
            while (i10 < this.f4170b) {
                J(this.f3873m[i10], progress);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof p)) {
                J(childAt, progress);
            }
            i10++;
        }
    }

    @Override // androidx.constraintlayout.widget.a
    public void y(AttributeSet attrs) {
        super.y(attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.f3870j = typedArrayObtainStyledAttributes.getBoolean(index, this.f3870j);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.f3871k = typedArrayObtainStyledAttributes.getBoolean(index, this.f3871k);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public p(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3870j = false;
        this.f3871k = false;
        y(attrs);
    }

    public p(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3870j = false;
        this.f3871k = false;
        y(attrs);
    }
}
