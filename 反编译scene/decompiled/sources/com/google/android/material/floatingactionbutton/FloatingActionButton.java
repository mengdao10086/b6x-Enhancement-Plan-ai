package com.google.android.material.floatingactionbutton;

import a.a00;
import a.bv;
import a.d10;
import a.dy;
import a.eh;
import a.gy;
import a.iv;
import a.ix;
import a.iy;
import a.jv;
import a.kd;
import a.mx;
import a.ny;
import a.nz;
import a.pf;
import a.pv;
import a.qg;
import a.r20;
import a.rj;
import a.rx;
import a.tw;
import a.uw;
import a.v5;
import a.yy;
import a.z5;
import a.zu;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class FloatingActionButton extends iy implements qg, rj, tw, a00, CoordinatorLayout.b {
    public static final int g = iv.Widget_Design_FloatingActionButton;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ix f8307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final uw f4634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z5 f4635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f4636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f4637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4638a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f4639b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public PorterDuff.Mode f4640b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f4641b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4642b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ColorStateList f4643c;
    public int d;
    public int e;
    public int f;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f8308a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public b f4644a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4645a;

        public BaseBehavior() {
            this.f4645a = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jv.FloatingActionButton_Behavior_Layout);
            this.f4645a = typedArrayObtainStyledAttributes.getBoolean(jv.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public static boolean F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f4638a;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final void G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f4638a;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i = 0;
            int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i = -rect.top;
            }
            if (i != 0) {
                eh.W(floatingActionButton, i);
            }
            if (i2 != 0) {
                eh.V(floatingActionButton, i2);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!F(view)) {
                return false;
            }
            L(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> listR = coordinatorLayout.r(floatingActionButton);
            int size = listR.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = listR.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.I(floatingActionButton, i);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        public final boolean J(View view, FloatingActionButton floatingActionButton) {
            return this.f4645a && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f8308a == null) {
                this.f8308a = new Rect();
            }
            Rect rect = this.f8308a;
            rx.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.i(this.f4644a, false);
                return true;
            }
            floatingActionButton.m(this.f4644a, false);
            return true;
        }

        public final boolean L(View view, FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.i(this.f4644a, false);
                return true;
            }
            floatingActionButton.m(this.f4644a, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f == 0) {
                fVar.f = 80;
            }
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class a implements ix.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f8309a;

        public a(b bVar) {
            this.f8309a = bVar;
        }

        @Override // a.ix.b
        public void a() {
            this.f8309a.a(FloatingActionButton.this);
        }

        @Override // a.ix.b
        public void b() {
            this.f8309a.b(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public abstract void a(FloatingActionButton floatingActionButton);

        public abstract void b(FloatingActionButton floatingActionButton);
    }

    public class c implements yy {
        public c() {
        }

        @Override // a.yy
        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.f4638a.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.e, i2 + FloatingActionButton.this.e, i3 + FloatingActionButton.this.e, i4 + FloatingActionButton.this.e);
        }

        @Override // a.yy
        public void b(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // a.yy
        public boolean c() {
            return FloatingActionButton.this.f4642b;
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(r20.c(context, attributeSet, i, g), attributeSet, i);
        this.f4638a = new Rect();
        this.f4641b = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayH = dy.h(context2, attributeSet, jv.FloatingActionButton, i, g, new int[0]);
        this.f4636a = ny.a(context2, typedArrayH, jv.FloatingActionButton_backgroundTint);
        this.f4637a = gy.e(typedArrayH.getInt(jv.FloatingActionButton_backgroundTintMode, -1), null);
        this.f4643c = ny.a(context2, typedArrayH, jv.FloatingActionButton_rippleColor);
        this.c = typedArrayH.getInt(jv.FloatingActionButton_fabSize, -1);
        this.d = typedArrayH.getDimensionPixelSize(jv.FloatingActionButton_fabCustomSize, 0);
        this.b = typedArrayH.getDimensionPixelSize(jv.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayH.getDimension(jv.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayH.getDimension(jv.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayH.getDimension(jv.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f4642b = typedArrayH.getBoolean(jv.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(bv.mtrl_fab_min_touch_target);
        this.f = typedArrayH.getDimensionPixelSize(jv.FloatingActionButton_maxImageSize, 0);
        pv pvVarB = pv.b(context2, typedArrayH, jv.FloatingActionButton_showMotionSpec);
        pv pvVarB2 = pv.b(context2, typedArrayH, jv.FloatingActionButton_hideMotionSpec);
        nz nzVarM = nz.e(context2, attributeSet, i, g, nz.e).m();
        boolean z = typedArrayH.getBoolean(jv.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayH.getBoolean(jv.FloatingActionButton_android_enabled, true));
        typedArrayH.recycle();
        z5 z5Var = new z5(this);
        this.f4635a = z5Var;
        z5Var.f(attributeSet, i);
        this.f4634a = new uw(this);
        getImpl().U(nzVarM);
        getImpl().u(this.f4636a, this.f4637a, this.f4643c, this.b);
        getImpl().Q(dimensionPixelSize);
        getImpl().K(dimension);
        getImpl().N(dimension2);
        getImpl().R(dimension3);
        getImpl().P(this.f);
        getImpl().V(pvVarB);
        getImpl().M(pvVarB2);
        getImpl().L(z);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private ix getImpl() {
        if (this.f8307a == null) {
            this.f8307a = e();
        }
        return this.f8307a;
    }

    public static int l(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @Override // a.tw
    public boolean a() {
        return this.f4634a.c();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().B(getDrawableState());
    }

    public final ix e() {
        return Build.VERSION.SDK_INT >= 21 ? new mx(this, new c()) : new ix(this, new c());
    }

    @Deprecated
    public boolean f(Rect rect) {
        if (!eh.Q(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        j(rect);
        return true;
    }

    public void g(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        j(rect);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f4636a;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f4637a;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().k();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().n();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().q();
    }

    public Drawable getContentBackground() {
        return getImpl().h();
    }

    public int getCustomSize() {
        return this.d;
    }

    public int getExpandedComponentIdHint() {
        return this.f4634a.b();
    }

    public pv getHideMotionSpec() {
        return getImpl().m();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f4643c;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f4643c;
    }

    public nz getShapeAppearanceModel() {
        nz nzVarR = getImpl().r();
        pf.b(nzVarR);
        return nzVarR;
    }

    public pv getShowMotionSpec() {
        return getImpl().s();
    }

    public int getSize() {
        return this.c;
    }

    public int getSizeDimension() {
        return h(this.c);
    }

    @Override // a.qg
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // a.rj
    public ColorStateList getSupportImageTintList() {
        return this.f4639b;
    }

    @Override // a.rj
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f4640b;
    }

    public boolean getUseCompatPadding() {
        return this.f4642b;
    }

    public final int h(int i) {
        int i2 = this.d;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            return resources.getDimensionPixelSize(i != 1 ? bv.design_fab_size_normal : bv.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? h(1) : h(0);
    }

    public void i(b bVar, boolean z) {
        getImpl().t(n(bVar), z);
    }

    public final void j(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.f4638a;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().x();
    }

    public final void k() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f4639b;
        if (colorStateList == null) {
            kd.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f4640b;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(v5.e(colorForState, mode));
    }

    public void m(b bVar, boolean z) {
        getImpl().Z(n(bVar), z);
    }

    public final ix.b n(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().y();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().A();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.e = (sizeDimension - this.f) / 2;
        getImpl().c0();
        int iMin = Math.min(l(sizeDimension, i), l(sizeDimension, i2));
        Rect rect = this.f4638a;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d10)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d10 d10Var = (d10) parcelable;
        super.onRestoreInstanceState(d10Var.q());
        uw uwVar = this.f4634a;
        Bundle bundle = d10Var.f5847a.get("expandableWidgetHelper");
        pf.b(bundle);
        uwVar.d(bundle);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        d10 d10Var = new d10(parcelableOnSaveInstanceState);
        d10Var.f5847a.put("expandableWidgetHelper", this.f4634a.e());
        return d10Var;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && f(this.f4641b) && !this.f4641b.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f4636a != colorStateList) {
            this.f4636a = colorStateList;
            getImpl().I(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f4637a != mode) {
            this.f4637a = mode;
            getImpl().J(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().K(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().N(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().R(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.d) {
            this.d = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().d0(f);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().l()) {
            getImpl().L(z);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.f4634a.f(i);
    }

    public void setHideMotionSpec(pv pvVar) {
        getImpl().M(pvVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(pv.c(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().b0();
            if (this.f4639b != null) {
                k();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f4635a.g(i);
        k();
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f4643c != colorStateList) {
            this.f4643c = colorStateList;
            getImpl().S(this.f4643c);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().F();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().F();
    }

    public void setShadowPaddingEnabled(boolean z) {
        getImpl().T(z);
    }

    @Override // a.a00
    public void setShapeAppearanceModel(nz nzVar) {
        getImpl().U(nzVar);
    }

    public void setShowMotionSpec(pv pvVar) {
        getImpl().V(pvVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(pv.c(getContext(), i));
    }

    public void setSize(int i) {
        this.d = 0;
        if (i != this.c) {
            this.c = i;
            requestLayout();
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // a.rj
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f4639b != colorStateList) {
            this.f4639b = colorStateList;
            k();
        }
    }

    @Override // a.rj
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f4640b != mode) {
            this.f4640b = mode;
            k();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().G();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().G();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().G();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f4642b != z) {
            this.f4642b = z;
            getImpl().z();
        }
    }

    @Override // a.iy, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
