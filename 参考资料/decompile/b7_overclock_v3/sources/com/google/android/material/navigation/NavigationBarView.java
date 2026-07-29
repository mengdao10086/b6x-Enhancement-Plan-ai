package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.y0;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.d0;
import g.d1;
import g.f;
import g.n0;
import g.p0;
import g.q;
import g.r;
import g.t0;
import g.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import l.g;
import le.j;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f20513g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f20514h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f20515i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f20516j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f20517k = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final com.google.android.material.navigation.b f20518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final com.google.android.material.navigation.c f20519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final NavigationBarPresenter f20520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MenuInflater f20521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f20522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f20523f;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public Bundle f20524c;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @p0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void b(@n0 Parcel parcel, ClassLoader classLoader) {
            this.f20524c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f20524c);
        }

        public SavedState(@n0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    public class a implements e.a {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, @n0 MenuItem menuItem) {
            if (NavigationBarView.this.f20523f == null || menuItem.getItemId() != NavigationBarView.this.getSelectedItemId()) {
                return (NavigationBarView.this.f20522e == null || NavigationBarView.this.f20522e.a(menuItem)) ? false : true;
            }
            NavigationBarView.this.f20523f.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface b {
    }

    public interface c {
        void a(@n0 MenuItem menuItem);
    }

    public interface d {
        boolean a(@n0 MenuItem menuItem);
    }

    public NavigationBarView(@n0 Context context, @p0 AttributeSet attributeSet, @f int i10, @d1 int i11) {
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f20520c = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = R.styleable.NavigationBarView;
        int i12 = R.styleable.NavigationBarView_itemTextAppearanceInactive;
        int i13 = R.styleable.NavigationBarView_itemTextAppearanceActive;
        y0 y0VarL = t.l(context2, attributeSet, iArr, i10, i11, i12, i13);
        com.google.android.material.navigation.b bVar = new com.google.android.material.navigation.b(context2, getClass(), getMaxItemCount());
        this.f20518a = bVar;
        com.google.android.material.navigation.c cVarD = d(context2);
        this.f20519b = cVarD;
        navigationBarPresenter.d(cVarD);
        navigationBarPresenter.a(1);
        cVarD.setPresenter(navigationBarPresenter);
        bVar.b(navigationBarPresenter);
        navigationBarPresenter.i(getContext(), bVar);
        int i14 = R.styleable.NavigationBarView_itemIconTint;
        if (y0VarL.C(i14)) {
            cVarD.setIconTintList(y0VarL.d(i14));
        } else {
            cVarD.setIconTintList(cVarD.d(android.R.attr.textColorSecondary));
        }
        setItemIconSize(y0VarL.g(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (y0VarL.C(i12)) {
            setItemTextAppearanceInactive(y0VarL.u(i12, 0));
        }
        if (y0VarL.C(i13)) {
            setItemTextAppearanceActive(y0VarL.u(i13, 0));
        }
        int i15 = R.styleable.NavigationBarView_itemTextColor;
        if (y0VarL.C(i15)) {
            setItemTextColor(y0VarL.d(i15));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            u0.I1(this, c(context2));
        }
        int i16 = R.styleable.NavigationBarView_itemPaddingTop;
        if (y0VarL.C(i16)) {
            setItemPaddingTop(y0VarL.g(i16, 0));
        }
        int i17 = R.styleable.NavigationBarView_itemPaddingBottom;
        if (y0VarL.C(i17)) {
            setItemPaddingBottom(y0VarL.g(i17, 0));
        }
        if (y0VarL.C(R.styleable.NavigationBarView_elevation)) {
            setElevation(y0VarL.g(r12, 0));
        }
        n0.c.o(getBackground().mutate(), ie.c.b(context2, y0VarL, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(y0VarL.p(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int iU = y0VarL.u(R.styleable.NavigationBarView_itemBackground, 0);
        if (iU != 0) {
            cVarD.setItemBackgroundRes(iU);
        } else {
            setItemRippleColor(ie.c.b(context2, y0VarL, R.styleable.NavigationBarView_itemRippleColor));
        }
        int iU2 = y0VarL.u(R.styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (iU2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iU2, R.styleable.NavigationBarActiveIndicator);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_width, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_height, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
            setItemActiveIndicatorColor(ie.c.a(context2, typedArrayObtainStyledAttributes, R.styleable.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(o.b(context2, typedArrayObtainStyledAttributes.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m());
            typedArrayObtainStyledAttributes.recycle();
        }
        int i18 = R.styleable.NavigationBarView_menu;
        if (y0VarL.C(i18)) {
            g(y0VarL.u(i18, 0));
        }
        y0VarL.I();
        addView(cVarD);
        bVar.X(new a());
    }

    private MenuInflater getMenuInflater() {
        if (this.f20521d == null) {
            this.f20521d = new g(getContext());
        }
        return this.f20521d;
    }

    @n0
    public final j c(Context context) {
        j jVar = new j();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            jVar.o0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        jVar.Z(context);
        return jVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public abstract com.google.android.material.navigation.c d(@n0 Context context);

    @p0
    public com.google.android.material.badge.a e(int i10) {
        return this.f20519b.i(i10);
    }

    @n0
    public com.google.android.material.badge.a f(int i10) {
        return this.f20519b.j(i10);
    }

    public void g(int i10) {
        this.f20520c.k(true);
        getMenuInflater().inflate(i10, this.f20518a);
        this.f20520c.k(false);
        this.f20520c.c(true);
    }

    @p0
    public ColorStateList getItemActiveIndicatorColor() {
        return this.f20519b.getItemActiveIndicatorColor();
    }

    @t0
    public int getItemActiveIndicatorHeight() {
        return this.f20519b.getItemActiveIndicatorHeight();
    }

    @t0
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f20519b.getItemActiveIndicatorMarginHorizontal();
    }

    @p0
    public o getItemActiveIndicatorShapeAppearance() {
        return this.f20519b.getItemActiveIndicatorShapeAppearance();
    }

    @t0
    public int getItemActiveIndicatorWidth() {
        return this.f20519b.getItemActiveIndicatorWidth();
    }

    @p0
    public Drawable getItemBackground() {
        return this.f20519b.getItemBackground();
    }

    @v
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f20519b.getItemBackgroundRes();
    }

    @r
    public int getItemIconSize() {
        return this.f20519b.getItemIconSize();
    }

    @p0
    public ColorStateList getItemIconTintList() {
        return this.f20519b.getIconTintList();
    }

    @t0
    public int getItemPaddingBottom() {
        return this.f20519b.getItemPaddingBottom();
    }

    @t0
    public int getItemPaddingTop() {
        return this.f20519b.getItemPaddingTop();
    }

    @p0
    public ColorStateList getItemRippleColor() {
        return this.f20519b.getItemRippleColor();
    }

    @d1
    public int getItemTextAppearanceActive() {
        return this.f20519b.getItemTextAppearanceActive();
    }

    @d1
    public int getItemTextAppearanceInactive() {
        return this.f20519b.getItemTextAppearanceInactive();
    }

    @p0
    public ColorStateList getItemTextColor() {
        return this.f20519b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f20519b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @n0
    public Menu getMenu() {
        return this.f20518a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public k getMenuView() {
        return this.f20519b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public NavigationBarPresenter getPresenter() {
        return this.f20520c;
    }

    @d0
    public int getSelectedItemId() {
        return this.f20519b.getSelectedItemId();
    }

    public boolean h() {
        return this.f20519b.getItemActiveIndicatorEnabled();
    }

    public void i(int i10) {
        this.f20519b.n(i10);
    }

    public void j(int i10, @p0 View.OnTouchListener onTouchListener) {
        this.f20519b.q(i10, onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        le.k.e(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@p0 Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f20518a.U(savedState.f20524c);
    }

    @Override // android.view.View
    @n0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f20524c = bundle;
        this.f20518a.W(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        le.k.d(this, f10);
    }

    public void setItemActiveIndicatorColor(@p0 ColorStateList colorStateList) {
        this.f20519b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f20519b.setItemActiveIndicatorEnabled(z10);
    }

    public void setItemActiveIndicatorHeight(@t0 int i10) {
        this.f20519b.setItemActiveIndicatorHeight(i10);
    }

    public void setItemActiveIndicatorMarginHorizontal(@t0 int i10) {
        this.f20519b.setItemActiveIndicatorMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorShapeAppearance(@p0 o oVar) {
        this.f20519b.setItemActiveIndicatorShapeAppearance(oVar);
    }

    public void setItemActiveIndicatorWidth(@t0 int i10) {
        this.f20519b.setItemActiveIndicatorWidth(i10);
    }

    public void setItemBackground(@p0 Drawable drawable) {
        this.f20519b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@v int i10) {
        this.f20519b.setItemBackgroundRes(i10);
    }

    public void setItemIconSize(@r int i10) {
        this.f20519b.setItemIconSize(i10);
    }

    public void setItemIconSizeRes(@q int i10) {
        setItemIconSize(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconTintList(@p0 ColorStateList colorStateList) {
        this.f20519b.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(@t0 int i10) {
        this.f20519b.setItemPaddingBottom(i10);
    }

    public void setItemPaddingTop(@t0 int i10) {
        this.f20519b.setItemPaddingTop(i10);
    }

    public void setItemRippleColor(@p0 ColorStateList colorStateList) {
        this.f20519b.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(@d1 int i10) {
        this.f20519b.setItemTextAppearanceActive(i10);
    }

    public void setItemTextAppearanceInactive(@d1 int i10) {
        this.f20519b.setItemTextAppearanceInactive(i10);
    }

    public void setItemTextColor(@p0 ColorStateList colorStateList) {
        this.f20519b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.f20519b.getLabelVisibilityMode() != i10) {
            this.f20519b.setLabelVisibilityMode(i10);
            this.f20520c.c(false);
        }
    }

    public void setOnItemReselectedListener(@p0 c cVar) {
        this.f20523f = cVar;
    }

    public void setOnItemSelectedListener(@p0 d dVar) {
        this.f20522e = dVar;
    }

    public void setSelectedItemId(@d0 int i10) {
        MenuItem menuItemFindItem = this.f20518a.findItem(i10);
        if (menuItemFindItem == null || this.f20518a.P(menuItemFindItem, this.f20520c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
