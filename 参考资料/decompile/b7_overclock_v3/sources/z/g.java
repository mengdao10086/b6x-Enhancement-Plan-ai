package z;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.h;
import androidx.constraintlayout.core.widgets.i;
import androidx.constraintlayout.widget.k;

/* JADX INFO: loaded from: classes2.dex */
public class g extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f57640m = "MotionPlaceholder";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f57641l;

    public g(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.a
    public void G(androidx.constraintlayout.core.widgets.d container, y.a helper, SparseArray<ConstraintWidget> map) {
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
        J(this.f57641l, widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.constraintlayout.widget.k, androidx.constraintlayout.widget.a
    public void y(AttributeSet attrs) {
        super.y(attrs);
        this.f4172d = new h();
        I();
    }

    public g(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public g(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public g(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
    }
}
