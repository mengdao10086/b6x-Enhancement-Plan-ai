package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes2.dex */
public class Guideline extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4165a;

    public Guideline(Context context) {
        super(context);
        this.f4165a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean filter) {
        this.f4165a = filter;
    }

    public void setGuidelineBegin(int margin) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f4165a && bVar.f4073a == margin) {
            return;
        }
        bVar.f4073a = margin;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int margin) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f4165a && bVar.f4075b == margin) {
            return;
        }
        bVar.f4075b = margin;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float ratio) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f4165a && bVar.f4077c == ratio) {
            return;
        }
        bVar.f4077c = ratio;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
    }

    public Guideline(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4165a = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4165a = true;
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.f4165a = true;
        super.setVisibility(8);
    }
}
