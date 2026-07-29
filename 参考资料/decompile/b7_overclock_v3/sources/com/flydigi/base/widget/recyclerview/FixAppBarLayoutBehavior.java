package com.flydigi.base.widget.recyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class FixAppBarLayoutBehavior extends AppBarLayout.Behavior {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f13608t = "AppBarLayoutBehavior";

    public FixAppBarLayoutBehavior() {
    }

    public final Object J0(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getSuperclass().getSuperclass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, ld.a, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Object objJ0 = J0(this, "offsetAnimator");
            if (objJ0 instanceof ValueAnimator) {
                ((ValueAnimator) objJ0).end();
            }
        }
        return super.l(coordinatorLayout, appBarLayout, motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14) {
        super.t(coordinatorLayout, appBarLayout, view, i10, i11, i12, i13, i14);
        M0(i13, appBarLayout, view, i14);
    }

    public final void M0(int i10, AppBarLayout appBarLayout, View view, int i11) {
        if (i11 == 1) {
            int iH = H();
            if ((i10 >= 0 || iH != 0) && (i10 <= 0 || iH != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            u0.H2(view, 1);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: v0 */
    public void r(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
        super.r(coordinatorLayout, appBarLayout, view, i10, i11, iArr, i12);
        M0(i11, appBarLayout, view, i12);
    }

    public FixAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
