package com.google.android.material.transformation;

import ae.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import g.i;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21161b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21162c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21163d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21164a;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f21165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f21167c;

        public a(View view, int i10, b bVar) {
            this.f21165a = view;
            this.f21166b = i10;
            this.f21167c = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f21165a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f21164a == this.f21166b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b bVar = this.f21167c;
                expandableBehavior.K((View) bVar, this.f21165a, bVar.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f21164a = 0;
    }

    @p0
    public static <T extends ExpandableBehavior> T J(@n0 View view, @n0 Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.g)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.g) layoutParams).f();
        if (cVarF instanceof ExpandableBehavior) {
            return cls.cast(cVarF);
        }
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    }

    public final boolean H(boolean z10) {
        if (!z10) {
            return this.f21164a == 1;
        }
        int i10 = this.f21164a;
        return i10 == 0 || i10 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @p0
    public b I(@n0 CoordinatorLayout coordinatorLayout, @n0 View view) {
        List<View> listQ = coordinatorLayout.q(view);
        int size = listQ.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = listQ.get(i10);
            if (f(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    public abstract boolean K(View view, View view2, boolean z10, boolean z11);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean f(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @i
    public boolean i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!H(bVar.isExpanded())) {
            return false;
        }
        this.f21164a = bVar.isExpanded() ? 1 : 2;
        return K((View) bVar, view, bVar.isExpanded(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @i
    public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, int i10) {
        b bVarI;
        if (u0.U0(view) || (bVarI = I(coordinatorLayout, view)) == null || !H(bVarI.isExpanded())) {
            return false;
        }
        int i11 = bVarI.isExpanded() ? 1 : 2;
        this.f21164a = i11;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, bVarI));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21164a = 0;
    }
}
