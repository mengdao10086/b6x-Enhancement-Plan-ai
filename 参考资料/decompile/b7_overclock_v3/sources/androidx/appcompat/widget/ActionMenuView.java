package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.i0;

/* JADX INFO: loaded from: classes2.dex */
public class ActionMenuView extends i0 implements e.b, androidx.appcompat.view.menu.k {
    public static final String E7 = "ActionMenuView";
    public static final int F7 = 56;
    public static final int G7 = 4;
    public androidx.appcompat.view.menu.e B;
    public Context C;
    public boolean C1;
    public int C2;
    public int D;
    public ActionMenuPresenter K0;
    public int K1;
    public e K2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f2089k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public j.a f2090k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public e.a f2091v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f2092v2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface a {
        boolean a();

        boolean d();
    }

    public static class b implements j.a {
        @Override // androidx.appcompat.view.menu.j.a
        public void b(@g.n0 androidx.appcompat.view.menu.e eVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(@g.n0 androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    public static class c extends i0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f2093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f2094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f2095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f2096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f2097e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2098f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f2093a = cVar.f2093a;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f2093a = false;
        }

        public c(int i10, int i11, boolean z10) {
            super(i10, i11);
            this.f2093a = z10;
        }
    }

    public class d implements e.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(@g.n0 androidx.appcompat.view.menu.e eVar, @g.n0 MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.K2;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(@g.n0 androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.f2091v1;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@g.n0 Context context) {
        this(context, null);
    }

    public static int P(View view, int i10, int i11, int i12, int i13) {
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12) - i13, View.MeasureSpec.getMode(i12));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z10 = actionMenuItemView != null && actionMenuItemView.j();
        int i14 = 2;
        if (i11 <= 0 || (z10 && i11 < 2)) {
            i14 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i15 = measuredWidth / i10;
            if (measuredWidth % i10 != 0) {
                i15++;
            }
            if (!z10 || i15 >= 2) {
                i14 = i15;
            }
        }
        cVar.f2096d = !cVar.f2093a && z10;
        cVar.f2094b = i14;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), iMakeMeasureSpec);
        return i14;
    }

    public void F() {
        ActionMenuPresenter actionMenuPresenter = this.K0;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
    }

    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.i0
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public c J() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f2093a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean K(int i10) {
        boolean zA = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            zA = false | ((a) childAt).a();
        }
        return (i10 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).d();
    }

    public boolean L() {
        ActionMenuPresenter actionMenuPresenter = this.K0;
        return actionMenuPresenter != null && actionMenuPresenter.E();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean M() {
        ActionMenuPresenter actionMenuPresenter = this.K0;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean N() {
        ActionMenuPresenter actionMenuPresenter = this.K0;
        return actionMenuPresenter != null && actionMenuPresenter.H();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean O() {
        return this.f2089k0;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    public final void Q(int i10, int i11) {
        int i12;
        int i13;
        boolean z10;
        int i14;
        boolean z11;
        boolean z12;
        int i15;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i16 = size - paddingLeft;
        int i17 = this.f2092v2;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = i17 + (i19 / i18);
        int childCount = getChildCount();
        int iMax = 0;
        int i21 = 0;
        boolean z13 = false;
        int i22 = 0;
        int iMax2 = 0;
        int i23 = 0;
        long j10 = 0;
        while (i21 < childCount) {
            View childAt = getChildAt(i21);
            int i24 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z14 = childAt instanceof ActionMenuItemView;
                int i25 = i22 + 1;
                if (z14) {
                    int i26 = this.C2;
                    i15 = i25;
                    r14 = 0;
                    childAt.setPadding(i26, 0, i26, 0);
                } else {
                    i15 = i25;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f2098f = r14;
                cVar.f2095c = r14;
                cVar.f2094b = r14;
                cVar.f2096d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f2097e = z14 && ((ActionMenuItemView) childAt).j();
                int iP = P(childAt, i20, cVar.f2093a ? 1 : i18, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iP);
                if (cVar.f2096d) {
                    i23++;
                }
                if (cVar.f2093a) {
                    z13 = true;
                }
                i18 -= iP;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iP == 1) {
                    j10 |= (long) (1 << i21);
                    iMax = iMax;
                }
                i22 = i15;
            }
            i21++;
            size2 = i24;
        }
        int i27 = size2;
        boolean z15 = z13 && i22 == 2;
        boolean z16 = false;
        while (i23 > 0 && i18 > 0) {
            int i28 = 0;
            int i29 = 0;
            int i30 = Integer.MAX_VALUE;
            long j11 = 0;
            while (i29 < childCount) {
                boolean z17 = z16;
                c cVar2 = (c) getChildAt(i29).getLayoutParams();
                int i31 = iMax;
                if (cVar2.f2096d) {
                    int i32 = cVar2.f2094b;
                    if (i32 < i30) {
                        j11 = 1 << i29;
                        i30 = i32;
                        i28 = 1;
                    } else if (i32 == i30) {
                        i28++;
                        j11 |= 1 << i29;
                    }
                }
                i29++;
                iMax = i31;
                z16 = z17;
            }
            z10 = z16;
            i14 = iMax;
            j10 |= j11;
            if (i28 > i18) {
                i12 = mode;
                i13 = i16;
                break;
            }
            int i33 = i30 + 1;
            int i34 = 0;
            while (i34 < childCount) {
                View childAt2 = getChildAt(i34);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i35 = i16;
                int i36 = mode;
                long j12 = 1 << i34;
                if ((j11 & j12) == 0) {
                    if (cVar3.f2094b == i33) {
                        j10 |= j12;
                    }
                    z12 = z15;
                } else {
                    if (z15 && cVar3.f2097e && i18 == 1) {
                        int i37 = this.C2;
                        z12 = z15;
                        childAt2.setPadding(i37 + i20, 0, i37, 0);
                    } else {
                        z12 = z15;
                    }
                    cVar3.f2094b++;
                    cVar3.f2098f = true;
                    i18--;
                }
                i34++;
                mode = i36;
                i16 = i35;
                z15 = z12;
            }
            iMax = i14;
            z16 = true;
        }
        i12 = mode;
        i13 = i16;
        z10 = z16;
        i14 = iMax;
        boolean z18 = !z13 && i22 == 1;
        if (i18 <= 0 || j10 == 0 || (i18 >= i22 - 1 && !z18 && iMax2 <= 1)) {
            z11 = z10;
        } else {
            float fBitCount = Long.bitCount(j10);
            if (!z18) {
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f2097e) {
                    fBitCount -= 0.5f;
                }
                int i38 = childCount - 1;
                if ((j10 & ((long) (1 << i38))) != 0 && !((c) getChildAt(i38).getLayoutParams()).f2097e) {
                    fBitCount -= 0.5f;
                }
            }
            int i39 = fBitCount > 0.0f ? (int) ((i18 * i20) / fBitCount) : 0;
            z11 = z10;
            for (int i40 = 0; i40 < childCount; i40++) {
                if ((j10 & ((long) (1 << i40))) != 0) {
                    View childAt3 = getChildAt(i40);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f2095c = i39;
                        cVar4.f2098f = true;
                        if (i40 == 0 && !cVar4.f2097e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i39) / 2;
                        }
                    } else if (cVar4.f2093a) {
                        cVar4.f2095c = i39;
                        cVar4.f2098f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i39) / 2;
                    } else {
                        if (i40 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i39 / 2;
                        }
                        if (i40 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i39 / 2;
                        }
                    }
                    z11 = true;
                }
            }
        }
        if (z11) {
            for (int i41 = 0; i41 < childCount; i41++) {
                View childAt4 = getChildAt(i41);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f2098f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f2094b * i20) + cVar5.f2095c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i13, i12 != 1073741824 ? i14 : i27);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public androidx.appcompat.view.menu.e R() {
        return this.B;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void S(j.a aVar, e.a aVar2) {
        this.f2090k1 = aVar;
        this.f2091v1 = aVar2;
    }

    public boolean T() {
        ActionMenuPresenter actionMenuPresenter = this.K0;
        return actionMenuPresenter != null && actionMenuPresenter.Q();
    }

    @Override // androidx.appcompat.view.menu.e.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean a(androidx.appcompat.view.menu.h hVar) {
        return this.B.O(hVar, 0);
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void e(androidx.appcompat.view.menu.e eVar) {
        this.B = eVar;
    }

    public Menu getMenu() {
        if (this.B == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.B = eVar;
            eVar.X(new d());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.K0 = actionMenuPresenter;
            actionMenuPresenter.O(true);
            ActionMenuPresenter actionMenuPresenter2 = this.K0;
            j.a bVar = this.f2090k1;
            if (bVar == null) {
                bVar = new b();
            }
            actionMenuPresenter2.h(bVar);
            this.B.c(this.K0, this.C);
            this.K0.M(this);
        }
        return this.B;
    }

    @g.p0
    public Drawable getOverflowIcon() {
        getMenu();
        return this.K0.D();
    }

    public int getPopupTheme() {
        return this.D;
    }

    @Override // androidx.appcompat.view.menu.k
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.K0;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.c(false);
            if (this.K0.H()) {
                this.K0.E();
                this.K0.Q();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        F();
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int width;
        int paddingLeft;
        if (!this.C1) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i14 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i12 - i10;
        int paddingRight = (i15 - getPaddingRight()) - getPaddingLeft();
        boolean zB = h1.b(this);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2093a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (K(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    K(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        int iMax = Math.max(0, i22 > 0 ? paddingRight / i22 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f2093a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f2093a) {
                int i27 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft2 = i27 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.i0, android.view.View
    public void onMeasure(int i10, int i11) {
        androidx.appcompat.view.menu.e eVar;
        boolean z10 = this.C1;
        boolean z11 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.C1 = z11;
        if (z10 != z11) {
            this.K1 = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.C1 && (eVar = this.B) != null && size != this.K1) {
            this.K1 = size;
            eVar.N(true);
        }
        int childCount = getChildCount();
        if (this.C1 && childCount > 0) {
            Q(i10, i11);
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            c cVar = (c) getChildAt(i12).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i10, i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z10) {
        this.K0.K(z10);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.K2 = eVar;
    }

    public void setOverflowIcon(@g.p0 Drawable drawable) {
        getMenu();
        this.K0.N(drawable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z10) {
        this.f2089k0 = z10;
    }

    public void setPopupTheme(@g.d1 int i10) {
        if (this.D != i10) {
            this.D = i10;
            if (i10 == 0) {
                this.C = getContext();
            } else {
                this.C = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.K0 = actionMenuPresenter;
        actionMenuPresenter.M(this);
    }

    public ActionMenuView(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f2092v2 = (int) (56.0f * f10);
        this.C2 = (int) (f10 * 4.0f);
        this.C = context;
        this.D = 0;
    }
}
