package be;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import le.j;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
@v0(21)
public class d extends com.google.android.material.floatingactionbutton.a {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @p0
    public StateListAnimator f9413c0;

    public static class a extends j {
        public a(o oVar) {
            super(oVar);
        }

        @Override // le.j, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public d(FloatingActionButton floatingActionButton, ke.c cVar) {
        super(floatingActionButton, cVar);
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void C() {
        i0();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void E(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.f20252w.isEnabled()) {
                this.f20252w.setElevation(0.0f);
                this.f20252w.setTranslationZ(0.0f);
                return;
            }
            this.f20252w.setElevation(this.f20237h);
            if (this.f20252w.isPressed()) {
                this.f20252w.setTranslationZ(this.f20239j);
            } else if (this.f20252w.isFocused() || this.f20252w.isHovered()) {
                this.f20252w.setTranslationZ(this.f20238i);
            } else {
                this.f20252w.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void F(float f10, float f11, float f12) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f20252w.refreshDrawableState();
        } else if (this.f20252w.getStateListAnimator() == this.f9413c0) {
            StateListAnimator stateListAnimatorM0 = m0(f10, f11, f12);
            this.f9413c0 = stateListAnimatorM0;
            this.f20252w.setStateListAnimator(stateListAnimatorM0);
        }
        if (c0()) {
            i0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public boolean N() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void Y(@p0 ColorStateList colorStateList) {
        Drawable drawable = this.f20232c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(je.b.e(colorStateList));
        } else {
            super.Y(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public boolean c0() {
        return this.f20253x.d() || !e0();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void g0() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    @n0
    public j l() {
        return new a((o) androidx.core.util.o.l(this.f20230a));
    }

    @n0
    public c l0(int i10, ColorStateList colorStateList) {
        Context context = this.f20252w.getContext();
        c cVar = new c((o) androidx.core.util.o.l(this.f20230a));
        cVar.f(h0.d.f(context, R.color.design_fab_stroke_top_outer_color), h0.d.f(context, R.color.design_fab_stroke_top_inner_color), h0.d.f(context, R.color.design_fab_stroke_end_inner_color), h0.d.f(context, R.color.design_fab_stroke_end_outer_color));
        cVar.e(i10);
        cVar.d(colorStateList);
        return cVar;
    }

    @n0
    public final StateListAnimator m0(float f10, float f11, float f12) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.W, n0(f10, f12));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.X, n0(f10, f11));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.Y, n0(f10, f11));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.Z, n0(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f20252w, "elevation", f10).setDuration(0L));
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 22 && i10 <= 24) {
            FloatingActionButton floatingActionButton = this.f20252w;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f20252w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.D);
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.f20228a0, animatorSet);
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.f20229b0, n0(0.0f, 0.0f));
        return stateListAnimator;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float n() {
        return this.f20252w.getElevation();
    }

    @n0
    public final Animator n0(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f20252w, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f20252w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.D);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void s(@n0 Rect rect) {
        if (this.f20253x.d()) {
            super.s(rect);
        } else if (e0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f20240k - this.f20252w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void x(ColorStateList colorStateList, @p0 PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        Drawable layerDrawable;
        j jVarL = l();
        this.f20231b = jVarL;
        jVarL.setTintList(colorStateList);
        if (mode != null) {
            this.f20231b.setTintMode(mode);
        }
        this.f20231b.Z(this.f20252w.getContext());
        if (i10 > 0) {
            this.f20233d = l0(i10, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) androidx.core.util.o.l(this.f20233d), (Drawable) androidx.core.util.o.l(this.f20231b)});
        } else {
            this.f20233d = null;
            layerDrawable = this.f20231b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(je.b.e(colorStateList2), layerDrawable, null);
        this.f20232c = rippleDrawable;
        this.f20234e = rippleDrawable;
    }
}
