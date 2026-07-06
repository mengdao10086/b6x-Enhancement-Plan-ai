package androidx.appcompat.widget;

import a.i4;
import a.l4;
import a.m7;
import a.n5;
import a.v4;
import a.w4;
import a.z8;
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
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ActionMenuView extends m7 implements i4.b, w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i4.a f8150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4 f4050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public n5 f4051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v4.a f4052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f4053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f4054a;
    public boolean d;
    public boolean e;
    public int j;
    public int k;
    public int l;
    public int m;

    public interface a {
        boolean b();

        boolean c();
    }

    public static class b implements v4.a {
        @Override // a.v4.a
        public void b(i4 i4Var, boolean z) {
        }

        @Override // a.v4.a
        public boolean c(i4 i4Var) {
            return false;
        }
    }

    public static class c extends m7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f8151a;

        @ViewDebug.ExportedProperty
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @ViewDebug.ExportedProperty
        public boolean f4055b;

        @ViewDebug.ExportedProperty
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @ViewDebug.ExportedProperty
        public boolean f4056c;
        public boolean d;

        public c(int i, int i2) {
            super(i, i2);
            this.f8151a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f8151a = cVar.f8151a;
        }
    }

    public class d implements i4.a {
        public d() {
        }

        @Override // a.i4.a
        public void a(i4 i4Var) {
            i4.a aVar = ActionMenuView.this.f8150a;
            if (aVar != null) {
                aVar.a(i4Var);
            }
        }

        @Override // a.i4.a
        public boolean b(i4 i4Var, MenuItem menuItem) {
            e eVar = ActionMenuView.this.f4054a;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.l = (int) (56.0f * f);
        this.m = (int) (f * 4.0f);
        this.f4053a = context;
        this.j = 0;
    }

    public static int L(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.f();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        cVar.f4055b = !cVar.f8151a && z;
        cVar.b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    public void B() {
        n5 n5Var = this.f4051a;
        if (n5Var != null) {
            n5Var.y();
        }
    }

    @Override // a.m7
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((m7.a) cVar).f1901a = 16;
        return cVar;
    }

    @Override // a.m7
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // a.m7
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((m7.a) cVar).f1901a <= 0) {
            ((m7.a) cVar).f1901a = 16;
        }
        return cVar;
    }

    public c F() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f8151a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    public boolean G(int i) {
        boolean zC = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            zC = false | ((a) childAt).c();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? zC : zC | ((a) childAt2).b();
    }

    public boolean H() {
        n5 n5Var = this.f4051a;
        return n5Var != null && n5Var.B();
    }

    public boolean I() {
        n5 n5Var = this.f4051a;
        return n5Var != null && n5Var.D();
    }

    public boolean J() {
        n5 n5Var = this.f4051a;
        return n5Var != null && n5Var.E();
    }

    public boolean K() {
        return this.d;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    public final void M(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        int i7;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.l;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int childCount = getChildCount();
        int iMax = 0;
        int i13 = 0;
        boolean z4 = false;
        int i14 = 0;
        int iMax2 = 0;
        int i15 = 0;
        long j = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            int i16 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i17 = i14 + 1;
                if (z5) {
                    int i18 = this.m;
                    i7 = i17;
                    r14 = 0;
                    childAt.setPadding(i18, 0, i18, 0);
                } else {
                    i7 = i17;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.d = r14;
                cVar.c = r14;
                cVar.b = r14;
                cVar.f4055b = r14;
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = r14;
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = r14;
                cVar.f4056c = z5 && ((ActionMenuItemView) childAt).f();
                int iL = L(childAt, i12, cVar.f8151a ? 1 : i10, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iL);
                if (cVar.f4055b) {
                    i15++;
                }
                if (cVar.f8151a) {
                    z4 = true;
                }
                i10 -= iL;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iL == 1) {
                    j |= (long) (1 << i13);
                    iMax = iMax;
                }
                i14 = i7;
            }
            i13++;
            size2 = i16;
        }
        int i19 = size2;
        boolean z6 = z4 && i14 == 2;
        boolean z7 = false;
        while (i15 > 0 && i10 > 0) {
            int i20 = Integer.MAX_VALUE;
            int i21 = 0;
            int i22 = 0;
            long j2 = 0;
            while (i22 < childCount) {
                boolean z8 = z7;
                c cVar2 = (c) getChildAt(i22).getLayoutParams();
                int i23 = iMax;
                if (cVar2.f4055b) {
                    int i24 = cVar2.b;
                    if (i24 < i20) {
                        j2 = 1 << i22;
                        i20 = i24;
                        i21 = 1;
                    } else if (i24 == i20) {
                        i21++;
                        j2 |= 1 << i22;
                    }
                }
                i22++;
                iMax = i23;
                z7 = z8;
            }
            z = z7;
            i5 = iMax;
            j |= j2;
            if (i21 > i10) {
                i3 = mode;
                i4 = i8;
                break;
            }
            int i25 = i20 + 1;
            int i26 = 0;
            while (i26 < childCount) {
                View childAt2 = getChildAt(i26);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i27 = i8;
                int i28 = mode;
                long j3 = 1 << i26;
                if ((j2 & j3) == 0) {
                    if (cVar3.b == i25) {
                        j |= j3;
                    }
                    z3 = z6;
                } else {
                    if (z6 && cVar3.f4056c && i10 == 1) {
                        int i29 = this.m;
                        z3 = z6;
                        childAt2.setPadding(i29 + i12, 0, i29, 0);
                    } else {
                        z3 = z6;
                    }
                    cVar3.b++;
                    cVar3.d = true;
                    i10--;
                }
                i26++;
                mode = i28;
                i8 = i27;
                z6 = z3;
            }
            iMax = i5;
            z7 = true;
        }
        i3 = mode;
        i4 = i8;
        z = z7;
        i5 = iMax;
        boolean z9 = !z4 && i14 == 1;
        if (i10 <= 0 || j == 0 || (i10 >= i14 - 1 && !z9 && iMax2 <= 1)) {
            i6 = 0;
            z2 = z;
        } else {
            float fBitCount = Long.bitCount(j);
            if (z9) {
                i6 = 0;
            } else {
                i6 = 0;
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f4056c) {
                    fBitCount -= 0.5f;
                }
                int i30 = childCount - 1;
                if ((j & ((long) (1 << i30))) != 0 && !((c) getChildAt(i30).getLayoutParams()).f4056c) {
                    fBitCount -= 0.5f;
                }
            }
            int i31 = fBitCount > 0.0f ? (int) ((i10 * i12) / fBitCount) : i6;
            z2 = z;
            for (int i32 = i6; i32 < childCount; i32++) {
                if ((j & ((long) (1 << i32))) != 0) {
                    View childAt3 = getChildAt(i32);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.c = i31;
                        cVar4.d = true;
                        if (i32 == 0 && !cVar4.f4056c) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = (-i31) / 2;
                        }
                        z2 = true;
                    } else if (cVar4.f8151a) {
                        cVar4.c = i31;
                        cVar4.d = true;
                        ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = (-i31) / 2;
                        z2 = true;
                    } else {
                        if (i32 != 0) {
                            ((ViewGroup.MarginLayoutParams) cVar4).leftMargin = i31 / 2;
                        }
                        if (i32 != childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) cVar4).rightMargin = i31 / 2;
                        }
                    }
                }
            }
        }
        if (z2) {
            for (int i33 = i6; i33 < childCount; i33++) {
                View childAt4 = getChildAt(i33);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.d) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.b * i12) + cVar5.c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i3 != 1073741824 ? i5 : i19);
    }

    public i4 N() {
        return this.f4050a;
    }

    public void O(v4.a aVar, i4.a aVar2) {
        this.f4052a = aVar;
        this.f8150a = aVar2;
    }

    public boolean P() {
        n5 n5Var = this.f4051a;
        return n5Var != null && n5Var.K();
    }

    @Override // a.i4.b
    public boolean c(l4 l4Var) {
        return this.f4050a.L(l4Var, 0);
    }

    @Override // a.m7, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // a.w4
    public void d(i4 i4Var) {
        this.f4050a = i4Var;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f4050a == null) {
            Context context = getContext();
            i4 i4Var = new i4(context);
            this.f4050a = i4Var;
            i4Var.R(new d());
            n5 n5Var = new n5(context);
            this.f4051a = n5Var;
            n5Var.J(true);
            n5 n5Var2 = this.f4051a;
            v4.a bVar = this.f4052a;
            if (bVar == null) {
                bVar = new b();
            }
            n5Var2.g(bVar);
            this.f4050a.c(this.f4051a, this.f4053a);
            this.f4051a.H(this);
        }
        return this.f4050a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f4051a.A();
    }

    public int getPopupTheme() {
        return this.j;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n5 n5Var = this.f4051a;
        if (n5Var != null) {
            n5Var.i(false);
            if (this.f4051a.E()) {
                this.f4051a.B();
                this.f4051a.K();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // a.m7, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.e) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean zB = z8.b(this);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f8151a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin) + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    G(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f8151a) {
                    int i15 = width2 - ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f8151a) {
                int i18 = paddingLeft2 + ((ViewGroup.MarginLayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // a.m7, android.view.View
    public void onMeasure(int i, int i2) {
        i4 i4Var;
        boolean z = this.e;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.e = z2;
        if (z != z2) {
            this.k = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.e && (i4Var = this.f4050a) != null && size != this.k) {
            this.k = size;
            i4Var.K(true);
        }
        int childCount = getChildCount();
        if (this.e && childCount > 0) {
            M(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f4051a.G(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f4054a = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f4051a.I(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.d = z;
    }

    public void setPopupTheme(int i) {
        if (this.j != i) {
            this.j = i;
            if (i == 0) {
                this.f4053a = getContext();
            } else {
                this.f4053a = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(n5 n5Var) {
        this.f4051a = n5Var;
        n5Var.H(this);
    }
}
