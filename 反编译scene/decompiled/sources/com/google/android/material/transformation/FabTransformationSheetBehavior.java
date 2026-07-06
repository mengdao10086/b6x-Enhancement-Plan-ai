package com.google.android.material.transformation;

import a.eh;
import a.pv;
import a.rv;
import a.yu;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<View, Integer> f8347a;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean H(View view, View view2, boolean z, boolean z2) {
        b0(view2, z);
        return super.H(view, view2, z, z2);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public FabTransformationBehavior.b Z(Context context, boolean z) {
        int i = z ? yu.mtrl_fab_transformation_sheet_expand_spec : yu.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.b bVar = new FabTransformationBehavior.b();
        bVar.f8344a = pv.c(context, i);
        bVar.f4793a = new rv(17, 0.0f, 0.0f);
        return bVar;
    }

    public final void b0(View view, boolean z) {
        int iIntValue;
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.f8347a = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f8347a.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        iIntValue = 4;
                    } else {
                        Map<View, Integer> map = this.f8347a;
                        if (map != null && map.containsKey(childAt)) {
                            iIntValue = this.f8347a.get(childAt).intValue();
                        }
                    }
                    eh.t0(childAt, iIntValue);
                }
            }
            if (z) {
                return;
            }
            this.f8347a = null;
        }
    }
}
