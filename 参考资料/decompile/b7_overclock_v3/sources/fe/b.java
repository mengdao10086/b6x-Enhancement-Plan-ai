package fe;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import g.n0;
import g.t0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b extends com.google.android.material.navigation.c {
    public final FrameLayout.LayoutParams C1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    @t0
    public int f28131v1;

    public b(@n0 Context context) {
        super(context);
        this.f28131v1 = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.C1 = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    @Override // com.google.android.material.navigation.c
    @n0
    public com.google.android.material.navigation.a g(@n0 Context context) {
        return new a(context);
    }

    @t0
    public int getItemMinimumHeight() {
        return this.f28131v1;
    }

    public int getMenuGravity() {
        return this.C1.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                childAt.layout(0, i15, i14, measuredHeight);
                i15 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        int size2 = getMenu().H().size();
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i10), i10, 0), View.resolveSizeAndState((size2 <= 1 || !l(getLabelVisibilityMode(), size2)) ? x(i10, size, size2, null) : y(i10, size, size2), i11, 0));
    }

    public void setItemMinimumHeight(@t0 int i10) {
        if (this.f28131v1 != i10) {
            this.f28131v1 = i10;
            requestLayout();
        }
    }

    public void setMenuGravity(int i10) {
        FrameLayout.LayoutParams layoutParams = this.C1;
        if (layoutParams.gravity != i10) {
            layoutParams.gravity = i10;
            setLayoutParams(layoutParams);
        }
    }

    public boolean u() {
        return (this.C1.gravity & 112) == 48;
    }

    public final int v(int i10, int i11, int i12) {
        int iMax = i11 / Math.max(1, i12);
        int size = this.f28131v1;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i10);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    public final int w(View view, int i10, int i11) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i10, i11);
        return view.getMeasuredHeight();
    }

    public final int x(int i10, int i11, int i12, View view) {
        v(i10, i11, i12);
        int iV = view == null ? v(i10, i11, i12) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int iW = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt != view) {
                iW += w(childAt, i10, iV);
            }
        }
        return iW;
    }

    public final int y(int i10, int i11, int i12) {
        int iW;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iW = w(childAt, i10, v(i10, i11, i12));
            i11 -= iW;
            i12--;
        } else {
            iW = 0;
        }
        return iW + x(i10, i11, i12, childAt);
    }
}
