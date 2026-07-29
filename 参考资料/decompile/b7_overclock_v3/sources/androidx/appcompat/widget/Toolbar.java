package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Toolbar extends ViewGroup implements androidx.core.view.t {
    public static final String I7 = "Toolbar";
    public ColorStateList A;
    public boolean B;
    public boolean C;
    public f C1;
    public ActionMenuPresenter C2;
    public final ArrayList<View> D;
    public j.a E7;
    public e.a F7;
    public boolean G7;
    public final Runnable H7;
    public final int[] K0;
    public final ActionMenuView.e K1;
    public d K2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f2275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f2276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f2277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageButton f2278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f2279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f2280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f2281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageButton f2282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f2283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f2284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2285k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final ArrayList<View> f2286k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final androidx.core.view.w f2287k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2289m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2290n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2291o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2292p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2293q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2294r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2295s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public p0 f2296t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2297u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2298v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public ArrayList<MenuItem> f2299v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public a1 f2300v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2301w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f2302x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f2303y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f2304z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2306d;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2305c);
            parcel.writeInt(this.f2306d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2305c = parcel.readInt();
            this.f2306d = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f2287k1.j(menuItem)) {
                return true;
            }
            f fVar = Toolbar.this.C1;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.U();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    public class d implements androidx.appcompat.view.menu.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f2310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.h f2311b;

        public d() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void b(androidx.appcompat.view.menu.e eVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.j
        public void c(boolean z10) {
            if (this.f2311b != null) {
                androidx.appcompat.view.menu.e eVar = this.f2310a;
                boolean z11 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        }
                        if (this.f2310a.getItem(i10) == this.f2311b) {
                            z11 = true;
                            break;
                        }
                        i10++;
                    }
                }
                if (z11) {
                    return;
                }
                f(this.f2310a, this.f2311b);
            }
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean e() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean f(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.h hVar) {
            KeyEvent.Callback callback = Toolbar.this.f2283i;
            if (callback instanceof l.c) {
                ((l.c) callback).d();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f2283i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f2282h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f2283i = null;
            toolbar3.a();
            this.f2311b = null;
            Toolbar.this.requestLayout();
            hVar.t(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean g(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.h hVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f2282h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f2282h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f2282h);
            }
            Toolbar.this.f2283i = hVar.getActionView();
            this.f2311b = hVar;
            ViewParent parent2 = Toolbar.this.f2283i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f2283i);
                }
                e eVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                eVarGenerateDefaultLayoutParams.f1604a = 8388611 | (toolbar4.f2290n & 112);
                eVarGenerateDefaultLayoutParams.f2316b = 2;
                toolbar4.f2283i.setLayoutParams(eVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f2283i);
            }
            Toolbar.this.K();
            Toolbar.this.requestLayout();
            hVar.t(true);
            KeyEvent.Callback callback = Toolbar.this.f2283i;
            if (callback instanceof l.c) {
                ((l.c) callback).b();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.j
        public void h(j.a aVar) {
        }

        @Override // androidx.appcompat.view.menu.j
        public void i(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.h hVar;
            androidx.appcompat.view.menu.e eVar2 = this.f2310a;
            if (eVar2 != null && (hVar = this.f2311b) != null) {
                eVar2.g(hVar);
            }
            this.f2310a = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public void j(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean l(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public androidx.appcompat.view.menu.k m(ViewGroup viewGroup) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.j
        public Parcelable n() {
            return null;
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(@g.n0 Context context) {
        this(context, null);
    }

    private void J() {
        removeCallbacks(this.H7);
        post(this.H7);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new l.g(getContext());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean A() {
        ActionMenuView actionMenuView = this.f2275a;
        return actionMenuView != null && actionMenuView.M();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f2275a;
        return actionMenuView != null && actionMenuView.N();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean C() {
        Layout layout;
        TextView textView = this.f2276b;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i10 = 0; i10 < lineCount; i10++) {
            if (layout.getEllipsisCount(i10) > 0) {
                return true;
            }
        }
        return false;
    }

    public final int D(View view, int i10, int[] iArr, int i11) {
        e eVar = (e) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int iR = r(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iR, iMax + measuredWidth, view.getMeasuredHeight() + iR);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    public final int E(View view, int i10, int[] iArr, int i11) {
        e eVar = (e) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int iR = r(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iR, iMax, view.getMeasuredHeight() + iR);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    @Override // androidx.core.view.t
    @g.k0
    public void F(@g.n0 androidx.core.view.a0 a0Var) {
        this.f2287k1.l(a0Var);
    }

    public final int G(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + iMax + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void H(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void I() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f2287k1.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f2299v1 = currentMenuItems2;
        this.f2287k1.k(menu);
    }

    public void K() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f2316b != 2 && childAt != this.f2275a) {
                removeViewAt(childCount);
                this.f2286k0.add(childAt);
            }
        }
    }

    public void L(int i10, int i11) {
        h();
        this.f2296t.e(i10, i11);
    }

    public void M(int i10, int i11) {
        h();
        this.f2296t.g(i10, i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void N(androidx.appcompat.view.menu.e eVar, ActionMenuPresenter actionMenuPresenter) {
        if (eVar == null && this.f2275a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e eVarR = this.f2275a.R();
        if (eVarR == eVar) {
            return;
        }
        if (eVarR != null) {
            eVarR.S(this.C2);
            eVarR.S(this.K2);
        }
        if (this.K2 == null) {
            this.K2 = new d();
        }
        actionMenuPresenter.K(true);
        if (eVar != null) {
            eVar.c(actionMenuPresenter, this.f2284j);
            eVar.c(this.K2, this.f2284j);
        } else {
            actionMenuPresenter.i(this.f2284j, null);
            this.K2.i(this.f2284j, null);
            actionMenuPresenter.c(true);
            this.K2.c(true);
        }
        this.f2275a.setPopupTheme(this.f2285k);
        this.f2275a.setPresenter(actionMenuPresenter);
        this.C2 = actionMenuPresenter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void O(j.a aVar, e.a aVar2) {
        this.E7 = aVar;
        this.F7 = aVar2;
        ActionMenuView actionMenuView = this.f2275a;
        if (actionMenuView != null) {
            actionMenuView.S(aVar, aVar2);
        }
    }

    public void P(Context context, @g.d1 int i10) {
        this.f2289m = i10;
        TextView textView = this.f2277c;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public void Q(int i10, int i11, int i12, int i13) {
        this.f2292p = i10;
        this.f2294r = i11;
        this.f2293q = i12;
        this.f2295s = i13;
        requestLayout();
    }

    public void R(Context context, @g.d1 int i10) {
        this.f2288l = i10;
        TextView textView = this.f2276b;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public final boolean S() {
        if (!this.G7) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (T(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean T(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean U() {
        ActionMenuView actionMenuView = this.f2275a;
        return actionMenuView != null && actionMenuView.T();
    }

    public void a() {
        for (int size = this.f2286k0.size() - 1; size >= 0; size--) {
            addView(this.f2286k0.get(size));
        }
        this.f2286k0.clear();
    }

    public final void b(List<View> list, int i10) {
        boolean z10 = androidx.core.view.u0.Z(this) == 1;
        int childCount = getChildCount();
        int iD = androidx.core.view.m.d(i10, androidx.core.view.u0.Z(this));
        list.clear();
        if (!z10) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f2316b == 0 && T(childAt) && q(eVar.f1604a) == iD) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f2316b == 0 && T(childAt2) && q(eVar2.f1604a) == iD) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e eVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        eVarGenerateDefaultLayoutParams.f2316b = 1;
        if (!z10 || this.f2283i == null) {
            addView(view, eVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f2286k0.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f2275a) != null && actionMenuView.O();
    }

    public void e() {
        d dVar = this.K2;
        androidx.appcompat.view.menu.h hVar = dVar == null ? null : dVar.f2311b;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f2275a;
        if (actionMenuView != null) {
            actionMenuView.F();
        }
    }

    @Override // androidx.core.view.t
    @g.k0
    @SuppressLint({"LambdaLast"})
    public void f2(@g.n0 androidx.core.view.a0 a0Var, @g.n0 androidx.lifecycle.y yVar, @g.n0 Lifecycle.State state) {
        this.f2287k1.e(a0Var, yVar, state);
    }

    public void g() {
        if (this.f2282h == null) {
            n nVar = new n(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f2282h = nVar;
            nVar.setImageDrawable(this.f2280f);
            this.f2282h.setContentDescription(this.f2281g);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f1604a = 8388611 | (this.f2290n & 112);
            eVarGenerateDefaultLayoutParams.f2316b = 2;
            this.f2282h.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f2282h.setOnClickListener(new c());
        }
    }

    @g.p0
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f2282h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @g.p0
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f2282h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        p0 p0Var = this.f2296t;
        if (p0Var != null) {
            return p0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.f2298v;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        p0 p0Var = this.f2296t;
        if (p0Var != null) {
            return p0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        p0 p0Var = this.f2296t;
        if (p0Var != null) {
            return p0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        p0 p0Var = this.f2296t;
        if (p0Var != null) {
            return p0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.f2297u;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarR;
        ActionMenuView actionMenuView = this.f2275a;
        return actionMenuView != null && (eVarR = actionMenuView.R()) != null && eVarR.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.f2298v, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return androidx.core.view.u0.Z(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return androidx.core.view.u0.Z(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f2297u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f2279e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f2279e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f2275a.getMenu();
    }

    @g.p0
    @RestrictTo({RestrictTo.Scope.TESTS})
    public View getNavButtonView() {
        return this.f2278d;
    }

    @g.p0
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f2278d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @g.p0
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f2278d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.C2;
    }

    @g.p0
    public Drawable getOverflowIcon() {
        j();
        return this.f2275a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f2284j;
    }

    @g.d1
    public int getPopupTheme() {
        return this.f2285k;
    }

    public CharSequence getSubtitle() {
        return this.f2303y;
    }

    @g.p0
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getSubtitleTextView() {
        return this.f2277c;
    }

    public CharSequence getTitle() {
        return this.f2302x;
    }

    public int getTitleMarginBottom() {
        return this.f2295s;
    }

    public int getTitleMarginEnd() {
        return this.f2293q;
    }

    public int getTitleMarginStart() {
        return this.f2292p;
    }

    public int getTitleMarginTop() {
        return this.f2294r;
    }

    @g.p0
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getTitleTextView() {
        return this.f2276b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public c0 getWrapper() {
        if (this.f2300v2 == null) {
            this.f2300v2 = new a1(this, true);
        }
        return this.f2300v2;
    }

    public final void h() {
        if (this.f2296t == null) {
            this.f2296t = new p0();
        }
    }

    public final void i() {
        if (this.f2279e == null) {
            this.f2279e = new AppCompatImageView(getContext());
        }
    }

    public final void j() {
        k();
        if (this.f2275a.R() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f2275a.getMenu();
            if (this.K2 == null) {
                this.K2 = new d();
            }
            this.f2275a.setExpandedActionViewsExclusive(true);
            eVar.c(this.K2, this.f2284j);
        }
    }

    public final void k() {
        if (this.f2275a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f2275a = actionMenuView;
            actionMenuView.setPopupTheme(this.f2285k);
            this.f2275a.setOnMenuItemClickListener(this.K1);
            this.f2275a.S(this.E7, this.F7);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f1604a = 8388613 | (this.f2290n & 112);
            this.f2275a.setLayoutParams(eVarGenerateDefaultLayoutParams);
            c(this.f2275a, false);
        }
    }

    public final void l() {
        if (this.f2278d == null) {
            this.f2278d = new n(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f1604a = 8388611 | (this.f2290n & 112);
            this.f2278d.setLayoutParams(eVarGenerateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // androidx.core.view.t
    @g.k0
    public void n2(@g.n0 androidx.core.view.a0 a0Var) {
        this.f2287k1.c(a0Var);
    }

    @Override // androidx.core.view.t
    @g.k0
    public void o(@g.n0 androidx.core.view.a0 a0Var, @g.n0 androidx.lifecycle.y yVar) {
        this.f2287k1.d(a0Var, yVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.H7);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x029f A[LOOP:0: B:104:0x029d->B:105:0x029f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c1 A[LOOP:1: B:107:0x02bf->B:108:0x02c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fa A[LOOP:2: B:116:0x02f8->B:117:0x02fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.K0;
        boolean zB = h1.b(this);
        int i12 = !zB ? 1 : 0;
        if (T(this.f2278d)) {
            H(this.f2278d, i10, 0, i11, 0, this.f2291o);
            measuredWidth = this.f2278d.getMeasuredWidth() + t(this.f2278d);
            iMax = Math.max(0, this.f2278d.getMeasuredHeight() + u(this.f2278d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2278d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (T(this.f2282h)) {
            H(this.f2282h, i10, 0, i11, 0, this.f2291o);
            measuredWidth = this.f2282h.getMeasuredWidth() + t(this.f2282h);
            iMax = Math.max(iMax, this.f2282h.getMeasuredHeight() + u(this.f2282h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2282h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (T(this.f2275a)) {
            H(this.f2275a, i10, iMax3, i11, 0, this.f2291o);
            measuredWidth2 = this.f2275a.getMeasuredWidth() + t(this.f2275a);
            iMax = Math.max(iMax, this.f2275a.getMeasuredHeight() + u(this.f2275a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2275a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i12] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (T(this.f2283i)) {
            iMax4 += G(this.f2283i, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f2283i.getMeasuredHeight() + u(this.f2283i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2283i.getMeasuredState());
        }
        if (T(this.f2279e)) {
            iMax4 += G(this.f2279e, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f2279e.getMeasuredHeight() + u(this.f2279e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2279e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((e) childAt.getLayoutParams()).f2316b == 0 && T(childAt)) {
                iMax4 += G(childAt, i10, iMax4, i11, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + u(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i14 = this.f2294r + this.f2295s;
        int i15 = this.f2292p + this.f2293q;
        if (T(this.f2276b)) {
            G(this.f2276b, i10, iMax4 + i15, i11, i14, iArr);
            int measuredWidth3 = this.f2276b.getMeasuredWidth() + t(this.f2276b);
            measuredHeight = this.f2276b.getMeasuredHeight() + u(this.f2276b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2276b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (T(this.f2277c)) {
            iMax2 = Math.max(iMax2, G(this.f2277c, i10, iMax4 + i15, i11, measuredHeight + i14, iArr));
            measuredHeight += this.f2277c.getMeasuredHeight() + u(this.f2277c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f2277c.getMeasuredState());
        }
        int iMax5 = Math.max(iMax, measuredHeight);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, (-16777216) & iCombineMeasuredStates2), S() ? 0 : View.resolveSizeAndState(Math.max(iMax5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f2275a;
        androidx.appcompat.view.menu.e eVarR = actionMenuView != null ? actionMenuView.R() : null;
        int i10 = savedState.f2305c;
        if (i10 != 0 && this.K2 != null && eVarR != null && (menuItemFindItem = eVarR.findItem(i10)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f2306d) {
            J();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        h();
        this.f2296t.f(i10 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.h hVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.K2;
        if (dVar != null && (hVar = dVar.f2311b) != null) {
            savedState.f2305c = hVar.getItemId();
        }
        savedState.f2306d = B();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.b ? new e((a.b) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public final int q(int i10) {
        int iZ = androidx.core.view.u0.Z(this);
        int iD = androidx.core.view.m.d(i10, iZ) & 7;
        return (iD == 1 || iD == 3 || iD == 5) ? iD : iZ == 1 ? 5 : 3;
    }

    public final int r(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int iS = s(eVar.f1604a);
        if (iS == 48) {
            return getPaddingTop() - i11;
        }
        if (iS == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i12) {
            iMax = i12;
        } else {
            int i13 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i14 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i13 < i14) {
                iMax = Math.max(0, iMax - (i14 - i13));
            }
        }
        return paddingTop + iMax;
    }

    public final int s(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.f2301w & 112;
    }

    public void setCollapseContentDescription(@g.c1 int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(@g.v int i10) {
        setCollapseIcon(i.a.b(getContext(), i10));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z10) {
        this.G7 = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f2298v) {
            this.f2298v = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f2297u) {
            this.f2297u = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(@g.v int i10) {
        setLogo(i.a.b(getContext(), i10));
    }

    public void setLogoDescription(@g.c1 int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(@g.c1 int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(@g.v int i10) {
        setNavigationIcon(i.a.b(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f2278d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.C1 = fVar;
    }

    public void setOverflowIcon(@g.p0 Drawable drawable) {
        j();
        this.f2275a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@g.d1 int i10) {
        if (this.f2285k != i10) {
            this.f2285k = i10;
            if (i10 == 0) {
                this.f2284j = getContext();
            } else {
                this.f2284j = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(@g.c1 int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(@g.l int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(@g.c1 int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.f2295s = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f2293q = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f2292p = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f2294r = i10;
        requestLayout();
    }

    public void setTitleTextColor(@g.l int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public final int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.view.r.c(marginLayoutParams) + androidx.core.view.r.b(marginLayoutParams);
    }

    public final int u(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final int v(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int measuredWidth = 0;
        while (i12 < size) {
            View view = list.get(i12);
            e eVar = (e) view.getLayoutParams();
            int i13 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i10;
            int i14 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i11;
            int iMax = Math.max(0, i13);
            int iMax2 = Math.max(0, i14);
            int iMax3 = Math.max(0, -i13);
            int iMax4 = Math.max(0, -i14);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i12++;
            i11 = iMax4;
            i10 = iMax3;
        }
        return measuredWidth;
    }

    @Override // androidx.core.view.t
    @g.k0
    public void v2() {
        Iterator<MenuItem> it2 = this.f2299v1.iterator();
        while (it2.hasNext()) {
            getMenu().removeItem(it2.next().getItemId());
        }
        I();
    }

    public boolean w() {
        d dVar = this.K2;
        return (dVar == null || dVar.f2311b == null) ? false : true;
    }

    public boolean x() {
        ActionMenuView actionMenuView = this.f2275a;
        return actionMenuView != null && actionMenuView.L();
    }

    public void y(@g.l0 int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public final boolean z(View view) {
        return view.getParent() == this || this.f2286k0.contains(view);
    }

    public static class e extends a.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f2313c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f2314d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f2315e = 2;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2316b;

        public e(@g.n0 Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2316b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i10, int i11) {
            super(i10, i11);
            this.f2316b = 0;
            this.f1604a = 8388627;
        }

        public e(int i10, int i11, int i12) {
            super(i10, i11);
            this.f2316b = 0;
            this.f1604a = i12;
        }

        public e(int i10) {
            this(-2, -1, i10);
        }

        public e(e eVar) {
            super((a.b) eVar);
            this.f2316b = 0;
            this.f2316b = eVar.f2316b;
        }

        public e(a.b bVar) {
            super(bVar);
            this.f2316b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2316b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2316b = 0;
        }
    }

    public Toolbar(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public void setCollapseContentDescription(@g.p0 CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f2282h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@g.p0 Drawable drawable) {
        if (drawable != null) {
            g();
            this.f2282h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f2282h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f2280f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f2279e)) {
                c(this.f2279e, true);
            }
        } else {
            ImageView imageView = this.f2279e;
            if (imageView != null && z(imageView)) {
                removeView(this.f2279e);
                this.f2286k0.remove(this.f2279e);
            }
        }
        ImageView imageView2 = this.f2279e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f2279e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@g.p0 CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f2278d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            b1.a(this.f2278d, charSequence);
        }
    }

    public void setNavigationIcon(@g.p0 Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f2278d)) {
                c(this.f2278d, true);
            }
        } else {
            ImageButton imageButton = this.f2278d;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f2278d);
                this.f2286k0.remove(this.f2278d);
            }
        }
        ImageButton imageButton2 = this.f2278d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2277c;
            if (textView != null && z(textView)) {
                removeView(this.f2277c);
                this.f2286k0.remove(this.f2277c);
            }
        } else {
            if (this.f2277c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2277c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2277c.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f2289m;
                if (i10 != 0) {
                    this.f2277c.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f2277c.setTextColor(colorStateList);
                }
            }
            if (!z(this.f2277c)) {
                c(this.f2277c, true);
            }
        }
        TextView textView2 = this.f2277c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2303y = charSequence;
    }

    public void setSubtitleTextColor(@g.n0 ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f2277c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2276b;
            if (textView != null && z(textView)) {
                removeView(this.f2276b);
                this.f2286k0.remove(this.f2276b);
            }
        } else {
            if (this.f2276b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2276b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2276b.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f2288l;
                if (i10 != 0) {
                    this.f2276b.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.f2304z;
                if (colorStateList != null) {
                    this.f2276b.setTextColor(colorStateList);
                }
            }
            if (!z(this.f2276b)) {
                c(this.f2276b, true);
            }
        }
        TextView textView2 = this.f2276b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2302x = charSequence;
    }

    public void setTitleTextColor(@g.n0 ColorStateList colorStateList) {
        this.f2304z = colorStateList;
        TextView textView = this.f2276b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public Toolbar(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2301w = 8388627;
        this.D = new ArrayList<>();
        this.f2286k0 = new ArrayList<>();
        this.K0 = new int[2];
        this.f2287k1 = new androidx.core.view.w(new Runnable() { // from class: androidx.appcompat.widget.z0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2781a.v2();
            }
        });
        this.f2299v1 = new ArrayList<>();
        this.K1 = new a();
        this.H7 = new b();
        Context context2 = getContext();
        int[] iArr = R.styleable.Toolbar;
        y0 y0VarG = y0.G(context2, attributeSet, iArr, i10, 0);
        androidx.core.view.u0.z1(this, context, iArr, attributeSet, y0VarG.B(), i10, 0);
        this.f2288l = y0VarG.u(R.styleable.Toolbar_titleTextAppearance, 0);
        this.f2289m = y0VarG.u(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f2301w = y0VarG.p(R.styleable.Toolbar_android_gravity, this.f2301w);
        this.f2290n = y0VarG.p(R.styleable.Toolbar_buttonGravity, 48);
        int iF = y0VarG.f(R.styleable.Toolbar_titleMargin, 0);
        int i11 = R.styleable.Toolbar_titleMargins;
        iF = y0VarG.C(i11) ? y0VarG.f(i11, iF) : iF;
        this.f2295s = iF;
        this.f2294r = iF;
        this.f2293q = iF;
        this.f2292p = iF;
        int iF2 = y0VarG.f(R.styleable.Toolbar_titleMarginStart, -1);
        if (iF2 >= 0) {
            this.f2292p = iF2;
        }
        int iF3 = y0VarG.f(R.styleable.Toolbar_titleMarginEnd, -1);
        if (iF3 >= 0) {
            this.f2293q = iF3;
        }
        int iF4 = y0VarG.f(R.styleable.Toolbar_titleMarginTop, -1);
        if (iF4 >= 0) {
            this.f2294r = iF4;
        }
        int iF5 = y0VarG.f(R.styleable.Toolbar_titleMarginBottom, -1);
        if (iF5 >= 0) {
            this.f2295s = iF5;
        }
        this.f2291o = y0VarG.g(R.styleable.Toolbar_maxButtonHeight, -1);
        int iF6 = y0VarG.f(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iF7 = y0VarG.f(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iG = y0VarG.g(R.styleable.Toolbar_contentInsetLeft, 0);
        int iG2 = y0VarG.g(R.styleable.Toolbar_contentInsetRight, 0);
        h();
        this.f2296t.e(iG, iG2);
        if (iF6 != Integer.MIN_VALUE || iF7 != Integer.MIN_VALUE) {
            this.f2296t.g(iF6, iF7);
        }
        this.f2297u = y0VarG.f(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f2298v = y0VarG.f(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f2280f = y0VarG.h(R.styleable.Toolbar_collapseIcon);
        this.f2281g = y0VarG.x(R.styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceX = y0VarG.x(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceX)) {
            setTitle(charSequenceX);
        }
        CharSequence charSequenceX2 = y0VarG.x(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceX2)) {
            setSubtitle(charSequenceX2);
        }
        this.f2284j = getContext();
        setPopupTheme(y0VarG.u(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawableH = y0VarG.h(R.styleable.Toolbar_navigationIcon);
        if (drawableH != null) {
            setNavigationIcon(drawableH);
        }
        CharSequence charSequenceX3 = y0VarG.x(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceX3)) {
            setNavigationContentDescription(charSequenceX3);
        }
        Drawable drawableH2 = y0VarG.h(R.styleable.Toolbar_logo);
        if (drawableH2 != null) {
            setLogo(drawableH2);
        }
        CharSequence charSequenceX4 = y0VarG.x(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceX4)) {
            setLogoDescription(charSequenceX4);
        }
        int i12 = R.styleable.Toolbar_titleTextColor;
        if (y0VarG.C(i12)) {
            setTitleTextColor(y0VarG.d(i12));
        }
        int i13 = R.styleable.Toolbar_subtitleTextColor;
        if (y0VarG.C(i13)) {
            setSubtitleTextColor(y0VarG.d(i13));
        }
        int i14 = R.styleable.Toolbar_menu;
        if (y0VarG.C(i14)) {
            y(y0VarG.u(i14, 0));
        }
        y0VarG.I();
    }
}
