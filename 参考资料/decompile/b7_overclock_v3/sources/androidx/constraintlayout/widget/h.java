package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.i;

/* JADX INFO: loaded from: classes2.dex */
public class h extends View implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4496d;

    public h(Context context) {
        super(context);
        this.f4493a = -1;
        this.f4494b = false;
        this.f4495c = 0;
        this.f4496d = true;
        super.setVisibility(8);
        c(null);
    }

    @Override // androidx.constraintlayout.widget.i.a
    public void a(int key, int newValue, int oldValue) {
        setGuidelineBegin(newValue);
        int id2 = getId();
        if (id2 > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i10 = this.f4495c;
            if (i10 != 0) {
                currentState = i10;
            }
            int i11 = 0;
            if (!this.f4494b) {
                if (!this.f4496d) {
                    b(newValue, id2, motionLayout, currentState);
                    return;
                }
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                while (i11 < constraintSetIds.length) {
                    b(newValue, id2, motionLayout, constraintSetIds[i11]);
                    i11++;
                }
                return;
            }
            if (this.f4496d) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i11 < constraintSetIds2.length) {
                    int i12 = constraintSetIds2[i11];
                    if (i12 != currentState) {
                        b(newValue, id2, motionLayout, i12);
                    }
                    i11++;
                }
            }
            d dVarT0 = motionLayout.t0(currentState);
            dVarT0.d1(id2, newValue);
            motionLayout.s1(currentState, dVarT0, 1000);
        }
    }

    public final void b(int newValue, int id2, MotionLayout motionLayout, int currentState) {
        d dVarH0 = motionLayout.H0(currentState);
        dVarH0.d1(id2, newValue);
        motionLayout.r1(currentState, dVarH0);
    }

    public final void c(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f4493a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4493a);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f4494b = typedArrayObtainStyledAttributes.getBoolean(index, this.f4494b);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f4495c = typedArrayObtainStyledAttributes.getResourceId(index, this.f4495c);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f4496d = typedArrayObtainStyledAttributes.getBoolean(index, this.f4496d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f4493a != -1) {
            ConstraintLayout.getSharedValues().a(this.f4493a, this);
        }
    }

    public boolean d() {
        return this.f4494b;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f4495c;
    }

    public int getAttributeId() {
        return this.f4493a;
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean animate) {
        this.f4494b = animate;
    }

    public void setApplyToConstraintSetId(int id2) {
        this.f4495c = id2;
    }

    public void setAttributeId(int id2) {
        i sharedValues = ConstraintLayout.getSharedValues();
        int i10 = this.f4493a;
        if (i10 != -1) {
            sharedValues.e(i10, this);
        }
        this.f4493a = id2;
        if (id2 != -1) {
            sharedValues.a(id2, this);
        }
    }

    public void setGuidelineBegin(int margin) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f4073a = margin;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int margin) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f4075b = margin;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float ratio) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f4077c = ratio;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
    }

    public h(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4493a = -1;
        this.f4494b = false;
        this.f4495c = 0;
        this.f4496d = true;
        super.setVisibility(8);
        c(attrs);
    }

    public h(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4493a = -1;
        this.f4494b = false;
        this.f4495c = 0;
        this.f4496d = true;
        super.setVisibility(8);
        c(attrs);
    }

    public h(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.f4493a = -1;
        this.f4494b = false;
        this.f4495c = 0;
        this.f4496d = true;
        super.setVisibility(8);
        c(attrs);
    }
}
