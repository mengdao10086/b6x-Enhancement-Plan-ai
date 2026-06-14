package a;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class mx extends ix {
    public mx(FloatingActionButton floatingActionButton, yy yyVar) {
        super(floatingActionButton, yyVar);
    }

    @Override // a.ix
    public void B(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (((ix) this).f1430a.isEnabled()) {
                ((ix) this).f1430a.setElevation(((ix) this).f1416a);
                if (((ix) this).f1430a.isPressed()) {
                    floatingActionButton = ((ix) this).f1430a;
                    f = ((ix) this).f1440c;
                } else if (((ix) this).f1430a.isFocused() || ((ix) this).f1430a.isHovered()) {
                    floatingActionButton = ((ix) this).f1430a;
                    f = ((ix) this).f1433b;
                }
                floatingActionButton.setTranslationZ(f);
            }
            ((ix) this).f1430a.setElevation(0.0f);
            floatingActionButton = ((ix) this).f1430a;
            floatingActionButton.setTranslationZ(f);
        }
    }

    @Override // a.ix
    public void C(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            ((ix) this).f1430a.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(ix.f1415a, g0(f, f3));
            stateListAnimator.addState(ix.b, g0(f, f2));
            stateListAnimator.addState(ix.c, g0(f, f2));
            stateListAnimator.addState(ix.d, g0(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(((ix) this).f1430a, "elevation", f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = ((ix) this).f1430a;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(((ix) this).f1430a, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(ix.f6450a);
            stateListAnimator.addState(ix.e, animatorSet);
            stateListAnimator.addState(ix.f, g0(0.0f, 0.0f));
            ((ix) this).f1430a.setStateListAnimator(stateListAnimator);
        }
        if (W()) {
            c0();
        }
    }

    @Override // a.ix
    public boolean H() {
        return false;
    }

    @Override // a.ix
    public void S(ColorStateList colorStateList) {
        Drawable drawable = ((ix) this).f1428a;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(wy.d(colorStateList));
        } else {
            super.S(colorStateList);
        }
    }

    @Override // a.ix
    public boolean W() {
        return ((ix) this).f1423a.c() || !Y();
    }

    @Override // a.ix
    public void a0() {
    }

    public xw f0(int i, ColorStateList colorStateList) {
        Context context = ((ix) this).f1430a.getContext();
        nz nzVar = ((ix) this).f1419a;
        pf.b(nzVar);
        xw xwVar = new xw(nzVar);
        xwVar.e(yb.b(context, av.design_fab_stroke_top_outer_color), yb.b(context, av.design_fab_stroke_top_inner_color), yb.b(context, av.design_fab_stroke_end_inner_color), yb.b(context, av.design_fab_stroke_end_outer_color));
        xwVar.d(i);
        xwVar.c(colorStateList);
        return xwVar;
    }

    @Override // a.ix
    public iz g() {
        nz nzVar = ((ix) this).f1419a;
        pf.b(nzVar);
        return new lx(nzVar);
    }

    public final Animator g0(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(((ix) this).f1430a, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(((ix) this).f1430a, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(ix.f6450a);
        return animatorSet;
    }

    @Override // a.ix
    public float k() {
        return ((ix) this).f1430a.getElevation();
    }

    @Override // a.ix
    public void p(Rect rect) {
        if (((ix) this).f1423a.c()) {
            super.p(rect);
        } else {
            int sizeDimension = !Y() ? (((ix) this).f1417a - ((ix) this).f1430a.getSizeDimension()) / 2 : 0;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // a.ix
    public void u(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        iz izVarG = g();
        ((ix) this).f1418a = izVarG;
        izVarG.setTintList(colorStateList);
        if (mode != null) {
            ((ix) this).f1418a.setTintMode(mode);
        }
        ((ix) this).f1418a.K(((ix) this).f1430a.getContext());
        if (i > 0) {
            ((ix) this).f1421a = f0(i, colorStateList);
            xw xwVar = ((ix) this).f1421a;
            pf.b(xwVar);
            iz izVar = ((ix) this).f1418a;
            pf.b(izVar);
            layerDrawable = new LayerDrawable(new Drawable[]{xwVar, izVar});
        } else {
            ((ix) this).f1421a = null;
            layerDrawable = ((ix) this).f1418a;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(wy.d(colorStateList2), layerDrawable, null);
        ((ix) this).f1428a = rippleDrawable;
        ((ix) this).f1437b = rippleDrawable;
    }

    @Override // a.ix
    public void x() {
    }

    @Override // a.ix
    public void z() {
        c0();
    }
}
