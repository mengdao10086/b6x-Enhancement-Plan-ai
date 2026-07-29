package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.transformation.FabTransformationBehavior;
import g.i;
import g.n0;
import g.p0;
import java.util.HashMap;
import java.util.Map;
import kd.h;
import kd.j;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public Map<View, Integer> f21199l;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @i
    public boolean K(@n0 View view, @n0 View view2, boolean z10, boolean z11) {
        j0(view2, z10);
        return super.K(view, view2, z10, z11);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @n0
    public FabTransformationBehavior.e h0(Context context, boolean z10) {
        int i10 = z10 ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f21188a = h.d(context, i10);
        eVar.f21189b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    public final void j0(@n0 View view, boolean z10) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                this.f21199l = new HashMap(childCount);
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                boolean z11 = (childAt.getLayoutParams() instanceof CoordinatorLayout.g) && (((CoordinatorLayout.g) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z11) {
                    if (z10) {
                        this.f21199l.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        u0.R1(childAt, 4);
                    } else {
                        Map<View, Integer> map = this.f21199l;
                        if (map != null && map.containsKey(childAt)) {
                            u0.R1(childAt, this.f21199l.get(childAt).intValue());
                        }
                    }
                }
            }
            if (z10) {
                return;
            }
            this.f21199l = null;
        }
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
