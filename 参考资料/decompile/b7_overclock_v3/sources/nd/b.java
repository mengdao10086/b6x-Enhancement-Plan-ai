package nd;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b extends com.google.android.material.navigation.c {
    public final int C1;
    public boolean C2;
    public final int K1;
    public int[] K2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final int f42070v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final int f42071v2;

    public b(@n0 Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f42070v1 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.C1 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.K1 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.f42071v2 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.K2 = new int[5];
    }

    @Override // com.google.android.material.navigation.c
    @n0
    public com.google.android.material.navigation.a g(@n0 Context context) {
        return new a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int measuredWidth = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                if (u0.Z(this) == 1) {
                    int i17 = i14 - measuredWidth;
                    childAt.layout(i17 - childAt.getMeasuredWidth(), 0, i17, i15);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i15);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        e menu = getMenu();
        int size = View.MeasureSpec.getSize(i10);
        int size2 = menu.H().size();
        int childCount = getChildCount();
        int size3 = View.MeasureSpec.getSize(i11);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        if (l(getLabelVisibilityMode(), size2) && u()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int iMax = this.f42071v2;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.K1, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i12 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.C1 * i12), Math.min(iMax, this.K1));
            int i13 = size - iMin;
            int iMin2 = Math.min(i13 / (i12 == 0 ? 1 : i12), this.f42070v1);
            int i14 = i13 - (i12 * iMin2);
            int i15 = 0;
            while (i15 < childCount) {
                if (getChildAt(i15).getVisibility() != 8) {
                    this.K2[i15] = i15 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i14 > 0) {
                        int[] iArr = this.K2;
                        iArr[i15] = iArr[i15] + 1;
                        i14--;
                    }
                } else {
                    this.K2[i15] = 0;
                }
                i15++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 == 0 ? 1 : size2), this.K1);
            int i16 = size - (size2 * iMin3);
            for (int i17 = 0; i17 < childCount; i17++) {
                if (getChildAt(i17).getVisibility() != 8) {
                    int[] iArr2 = this.K2;
                    iArr2[i17] = iMin3;
                    if (i16 > 0) {
                        iArr2[i17] = iArr2[i17] + 1;
                        i16--;
                    }
                } else {
                    this.K2[i17] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.K2[i18], 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(size3, i11, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        this.C2 = z10;
    }

    public boolean u() {
        return this.C2;
    }
}
