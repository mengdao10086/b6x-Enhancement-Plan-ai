package com.google.android.material.navigation;

import a1.d;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import androidx.core.util.n;
import androidx.core.view.u0;
import androidx.transition.u;
import androidx.transition.v;
import g.d1;
import g.n0;
import g.p0;
import g.r;
import g.t0;
import java.util.HashSet;
import le.j;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class c extends ViewGroup implements k {
    public static final int D = 5;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f20583k0 = -1;
    public ColorStateList A;
    public NavigationBarPresenter B;
    public e C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final v f20585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final View.OnClickListener f20586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n.a<com.google.android.material.navigation.a> f20587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final SparseArray<View.OnTouchListener> f20588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public com.google.android.material.navigation.a[] f20590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public ColorStateList f20593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @r
    public int f20594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f20595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public final ColorStateList f20596l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @d1
    public int f20597m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @d1
    public int f20598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f20599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public ColorStateList f20600p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20601q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public final SparseArray<com.google.android.material.badge.a> f20602r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f20603s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20604t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f20605u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f20606v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f20607w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f20608x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public o f20609y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f20610z;
    public static final int[] K0 = {R.attr.state_checked};

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int[] f20584k1 = {-16842910};

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h itemData = ((com.google.android.material.navigation.a) view).getItemData();
            if (c.this.C.P(itemData, c.this.B, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public c(@n0 Context context) {
        super(context);
        this.f20587c = new n.c(5);
        this.f20588d = new SparseArray<>(5);
        this.f20591g = 0;
        this.f20592h = 0;
        this.f20602r = new SparseArray<>(5);
        this.f20603s = -1;
        this.f20604t = -1;
        this.f20610z = false;
        this.f20596l = d(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.f20585a = null;
        } else {
            g2.a aVar = new g2.a();
            this.f20585a = aVar;
            aVar.Z0(0);
            aVar.y0(ee.a.f(getContext(), com.google.android.material.R.attr.motionDurationLong1, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
            aVar.A0(ee.a.g(getContext(), com.google.android.material.R.attr.motionEasingStandard, kd.a.f37167b));
            aVar.M0(new com.google.android.material.internal.r());
        }
        this.f20586b = new a();
        u0.R1(this, 1);
    }

    private com.google.android.material.navigation.a getNewItem() {
        com.google.android.material.navigation.a aVarA = this.f20587c.a();
        return aVarA == null ? g(getContext()) : aVarA;
    }

    private void setBadgeIfNeeded(@n0 com.google.android.material.navigation.a aVar) {
        com.google.android.material.badge.a aVar2;
        int id2 = aVar.getId();
        if (m(id2) && (aVar2 = this.f20602r.get(id2)) != null) {
            aVar.setBadge(aVar2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c() {
        removeAllViews();
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                if (aVar != null) {
                    this.f20587c.b(aVar);
                    aVar.j();
                }
            }
        }
        if (this.C.size() == 0) {
            this.f20591g = 0;
            this.f20592h = 0;
            this.f20590f = null;
            return;
        }
        o();
        this.f20590f = new com.google.android.material.navigation.a[this.C.size()];
        boolean zL = l(this.f20589e, this.C.H().size());
        for (int i10 = 0; i10 < this.C.size(); i10++) {
            this.B.k(true);
            this.C.getItem(i10).setCheckable(true);
            this.B.k(false);
            com.google.android.material.navigation.a newItem = getNewItem();
            this.f20590f[i10] = newItem;
            newItem.setIconTintList(this.f20593i);
            newItem.setIconSize(this.f20594j);
            newItem.setTextColor(this.f20596l);
            newItem.setTextAppearanceInactive(this.f20597m);
            newItem.setTextAppearanceActive(this.f20598n);
            newItem.setTextColor(this.f20595k);
            int i11 = this.f20603s;
            if (i11 != -1) {
                newItem.setItemPaddingTop(i11);
            }
            int i12 = this.f20604t;
            if (i12 != -1) {
                newItem.setItemPaddingBottom(i12);
            }
            newItem.setActiveIndicatorWidth(this.f20606v);
            newItem.setActiveIndicatorHeight(this.f20607w);
            newItem.setActiveIndicatorMarginHorizontal(this.f20608x);
            newItem.setActiveIndicatorDrawable(f());
            newItem.setActiveIndicatorResizeable(this.f20610z);
            newItem.setActiveIndicatorEnabled(this.f20605u);
            Drawable drawable = this.f20599o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f20601q);
            }
            newItem.setItemRippleColor(this.f20600p);
            newItem.setShifting(zL);
            newItem.setLabelVisibilityMode(this.f20589e);
            h hVar = (h) this.C.getItem(i10);
            newItem.h(hVar, 0);
            newItem.setItemPosition(i10);
            int itemId = hVar.getItemId();
            newItem.setOnTouchListener(this.f20588d.get(itemId));
            newItem.setOnClickListener(this.f20586b);
            int i13 = this.f20591g;
            if (i13 != 0 && itemId == i13) {
                this.f20592h = i10;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.C.size() - 1, this.f20592h);
        this.f20592h = iMin;
        this.C.getItem(iMin).setChecked(true);
    }

    @p0
    public ColorStateList d(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = i.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = f20584k1;
        return new ColorStateList(new int[][]{iArr, K0, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    @Override // androidx.appcompat.view.menu.k
    public void e(@n0 e eVar) {
        this.C = eVar;
    }

    @p0
    public final Drawable f() {
        if (this.f20609y == null || this.A == null) {
            return null;
        }
        j jVar = new j(this.f20609y);
        jVar.o0(this.A);
        return jVar;
    }

    @n0
    public abstract com.google.android.material.navigation.a g(@n0 Context context);

    public SparseArray<com.google.android.material.badge.a> getBadgeDrawables() {
        return this.f20602r;
    }

    @p0
    public ColorStateList getIconTintList() {
        return this.f20593i;
    }

    @p0
    public ColorStateList getItemActiveIndicatorColor() {
        return this.A;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f20605u;
    }

    @t0
    public int getItemActiveIndicatorHeight() {
        return this.f20607w;
    }

    @t0
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f20608x;
    }

    @p0
    public o getItemActiveIndicatorShapeAppearance() {
        return this.f20609y;
    }

    @t0
    public int getItemActiveIndicatorWidth() {
        return this.f20606v;
    }

    @p0
    public Drawable getItemBackground() {
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        return (aVarArr == null || aVarArr.length <= 0) ? this.f20599o : aVarArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f20601q;
    }

    @r
    public int getItemIconSize() {
        return this.f20594j;
    }

    @t0
    public int getItemPaddingBottom() {
        return this.f20604t;
    }

    @t0
    public int getItemPaddingTop() {
        return this.f20603s;
    }

    @p0
    public ColorStateList getItemRippleColor() {
        return this.f20600p;
    }

    @d1
    public int getItemTextAppearanceActive() {
        return this.f20598n;
    }

    @d1
    public int getItemTextAppearanceInactive() {
        return this.f20597m;
    }

    @p0
    public ColorStateList getItemTextColor() {
        return this.f20595k;
    }

    public int getLabelVisibilityMode() {
        return this.f20589e;
    }

    @p0
    public e getMenu() {
        return this.C;
    }

    public int getSelectedItemId() {
        return this.f20591g;
    }

    public int getSelectedItemPosition() {
        return this.f20592h;
    }

    @Override // androidx.appcompat.view.menu.k
    public int getWindowAnimations() {
        return 0;
    }

    @p0
    public com.google.android.material.navigation.a h(int i10) {
        t(i10);
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr == null) {
            return null;
        }
        for (com.google.android.material.navigation.a aVar : aVarArr) {
            if (aVar.getId() == i10) {
                return aVar;
            }
        }
        return null;
    }

    @p0
    public com.google.android.material.badge.a i(int i10) {
        return this.f20602r.get(i10);
    }

    public com.google.android.material.badge.a j(int i10) {
        t(i10);
        com.google.android.material.badge.a aVarD = this.f20602r.get(i10);
        if (aVarD == null) {
            aVarD = com.google.android.material.badge.a.d(getContext());
            this.f20602r.put(i10, aVarD);
        }
        com.google.android.material.navigation.a aVarH = h(i10);
        if (aVarH != null) {
            aVarH.setBadge(aVarD);
        }
        return aVarD;
    }

    public boolean k() {
        return this.f20610z;
    }

    public boolean l(int i10, int i11) {
        if (i10 == -1) {
            if (i11 > 3) {
                return true;
            }
        } else if (i10 == 0) {
            return true;
        }
        return false;
    }

    public final boolean m(int i10) {
        return i10 != -1;
    }

    public void n(int i10) {
        t(i10);
        com.google.android.material.badge.a aVar = this.f20602r.get(i10);
        com.google.android.material.navigation.a aVarH = h(i10);
        if (aVarH != null) {
            aVarH.r();
        }
        if (aVar != null) {
            this.f20602r.remove(i10);
        }
    }

    public final void o() {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.C.size(); i10++) {
            hashSet.add(Integer.valueOf(this.C.getItem(i10).getItemId()));
        }
        for (int i11 = 0; i11 < this.f20602r.size(); i11++) {
            int iKeyAt = this.f20602r.keyAt(i11);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.f20602r.delete(iKeyAt);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        d.g2(accessibilityNodeInfo).d1(d.C0006d.f(1, this.C.H().size(), false, 1));
    }

    public void p(SparseArray<com.google.android.material.badge.a> sparseArray) {
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int iKeyAt = sparseArray.keyAt(i10);
            if (this.f20602r.indexOfKey(iKeyAt) < 0) {
                this.f20602r.append(iKeyAt, sparseArray.get(iKeyAt));
            }
        }
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setBadge(this.f20602r.get(aVar.getId()));
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void q(int i10, @p0 View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.f20588d.remove(i10);
        } else {
            this.f20588d.put(i10, onTouchListener);
        }
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                if (aVar.getItemData().getItemId() == i10) {
                    aVar.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void r(int i10) {
        int size = this.C.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.C.getItem(i11);
            if (i10 == item.getItemId()) {
                this.f20591g = i10;
                this.f20592h = i11;
                item.setChecked(true);
                return;
            }
        }
    }

    public void s() {
        v vVar;
        e eVar = this.C;
        if (eVar == null || this.f20590f == null) {
            return;
        }
        int size = eVar.size();
        if (size != this.f20590f.length) {
            c();
            return;
        }
        int i10 = this.f20591g;
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.C.getItem(i11);
            if (item.isChecked()) {
                this.f20591g = item.getItemId();
                this.f20592h = i11;
            }
        }
        if (i10 != this.f20591g && (vVar = this.f20585a) != null) {
            u.b(this, vVar);
        }
        boolean zL = l(this.f20589e, this.C.H().size());
        for (int i12 = 0; i12 < size; i12++) {
            this.B.k(true);
            this.f20590f[i12].setLabelVisibilityMode(this.f20589e);
            this.f20590f[i12].setShifting(zL);
            this.f20590f[i12].h((h) this.C.getItem(i12), 0);
            this.B.k(false);
        }
    }

    public void setIconTintList(@p0 ColorStateList colorStateList) {
        this.f20593i = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@p0 ColorStateList colorStateList) {
        this.A = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorDrawable(f());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f20605u = z10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorEnabled(z10);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@t0 int i10) {
        this.f20607w = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorHeight(i10);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@t0 int i10) {
        this.f20608x = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorMarginHorizontal(i10);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z10) {
        this.f20610z = z10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorResizeable(z10);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@p0 o oVar) {
        this.f20609y = oVar;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorDrawable(f());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@t0 int i10) {
        this.f20606v = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorWidth(i10);
            }
        }
    }

    public void setItemBackground(@p0 Drawable drawable) {
        this.f20599o = drawable;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i10) {
        this.f20601q = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemBackground(i10);
            }
        }
    }

    public void setItemIconSize(@r int i10) {
        this.f20594j = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setIconSize(i10);
            }
        }
    }

    public void setItemPaddingBottom(@t0 int i10) {
        this.f20604t = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemPaddingBottom(i10);
            }
        }
    }

    public void setItemPaddingTop(@t0 int i10) {
        this.f20603s = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemPaddingTop(i10);
            }
        }
    }

    public void setItemRippleColor(@p0 ColorStateList colorStateList) {
        this.f20600p = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(@d1 int i10) {
        this.f20598n = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextAppearanceActive(i10);
                ColorStateList colorStateList = this.f20595k;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@d1 int i10) {
        this.f20597m = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextAppearanceInactive(i10);
                ColorStateList colorStateList = this.f20595k;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@p0 ColorStateList colorStateList) {
        this.f20595k = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f20590f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i10) {
        this.f20589e = i10;
    }

    public void setPresenter(@n0 NavigationBarPresenter navigationBarPresenter) {
        this.B = navigationBarPresenter;
    }

    public final void t(int i10) {
        if (m(i10)) {
            return;
        }
        throw new IllegalArgumentException(i10 + " is not a valid view id");
    }
}
