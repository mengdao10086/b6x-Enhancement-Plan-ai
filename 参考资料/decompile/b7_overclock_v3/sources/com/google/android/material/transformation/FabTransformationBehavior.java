package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;
import kd.h;
import kd.i;
import kd.j;
import sd.g;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f21171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f21172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f21173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f21174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f21175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f21176k;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f21178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f21179c;

        public a(boolean z10, View view, View view2) {
            this.f21177a = z10;
            this.f21178b = view;
            this.f21179c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f21177a) {
                return;
            }
            this.f21178b.setVisibility(4);
            this.f21179c.setAlpha(1.0f);
            this.f21179c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f21177a) {
                this.f21178b.setVisibility(0);
                this.f21179c.setAlpha(0.0f);
                this.f21179c.setVisibility(4);
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f21181a;

        public b(View view) {
            this.f21181a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f21181a.invalidate();
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f21183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f21184b;

        public c(g gVar, Drawable drawable) {
            this.f21183a = gVar;
            this.f21184b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f21183a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f21183a.setCircularRevealOverlayDrawable(this.f21184b);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f21186a;

        public d(g gVar) {
            this.f21186a = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.e revealInfo = this.f21186a.getRevealInfo();
            revealInfo.f49689c = Float.MAX_VALUE;
            this.f21186a.setRevealInfo(revealInfo);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public h f21188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f21189b;
    }

    public FabTransformationBehavior() {
        this.f21171f = new Rect();
        this.f21172g = new RectF();
        this.f21173h = new RectF();
        this.f21174i = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @n0
    public AnimatorSet M(@n0 View view, @n0 View view2, boolean z10, boolean z11) {
        e eVarH0 = h0(view2.getContext(), z10);
        if (z10) {
            this.f21175j = view.getTranslationX();
            this.f21176k = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        a0(view, view2, z10, z11, eVarH0, arrayList, arrayList2);
        RectF rectF = this.f21172g;
        f0(view, view2, z10, z11, eVarH0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        Z(view, view2, z10, eVarH0, arrayList);
        c0(view, view2, z10, z11, eVarH0, arrayList, arrayList2);
        b0(view, view2, z10, z11, eVarH0, fWidth, fHeight, arrayList, arrayList2);
        Y(view, view2, z10, z11, eVarH0, arrayList, arrayList2);
        X(view, view2, z10, z11, eVarH0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        kd.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener(arrayList2.get(i10));
        }
        return animatorSet;
    }

    @p0
    public final ViewGroup N(@n0 View view) {
        View viewFindViewById = view.findViewById(R.id.mtrl_child_content_container);
        return viewFindViewById != null ? i0(viewFindViewById) : ((view instanceof re.b) || (view instanceof re.a)) ? i0(((ViewGroup) view).getChildAt(0)) : i0(view);
    }

    public final void O(@n0 View view, @n0 e eVar, @n0 i iVar, @n0 i iVar2, float f10, float f11, float f12, float f13, @n0 RectF rectF) {
        float fV = V(eVar, iVar, f10, f12);
        float fV2 = V(eVar, iVar2, f11, f13);
        Rect rect = this.f21171f;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f21172g;
        rectF2.set(rect);
        RectF rectF3 = this.f21173h;
        W(view, rectF3);
        rectF3.offset(fV, fV2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final void P(@n0 View view, @n0 RectF rectF) {
        W(view, rectF);
        rectF.offset(this.f21175j, this.f21176k);
    }

    @n0
    public final Pair<i, i> Q(float f10, float f11, boolean z10, @n0 e eVar) {
        i iVarH;
        i iVarH2;
        if (f10 == 0.0f || f11 == 0.0f) {
            iVarH = eVar.f21188a.h("translationXLinear");
            iVarH2 = eVar.f21188a.h("translationYLinear");
        } else if ((!z10 || f11 >= 0.0f) && (z10 || f11 <= 0.0f)) {
            iVarH = eVar.f21188a.h("translationXCurveDownwards");
            iVarH2 = eVar.f21188a.h("translationYCurveDownwards");
        } else {
            iVarH = eVar.f21188a.h("translationXCurveUpwards");
            iVarH2 = eVar.f21188a.h("translationYCurveUpwards");
        }
        return new Pair<>(iVarH, iVarH2);
    }

    public final float R(@n0 View view, @n0 View view2, @n0 j jVar) {
        RectF rectF = this.f21172g;
        RectF rectF2 = this.f21173h;
        P(view, rectF);
        W(view2, rectF2);
        rectF2.offset(-T(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    public final float S(@n0 View view, @n0 View view2, @n0 j jVar) {
        RectF rectF = this.f21172g;
        RectF rectF2 = this.f21173h;
        P(view, rectF);
        W(view2, rectF2);
        rectF2.offset(0.0f, -U(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    public final float T(@n0 View view, @n0 View view2, @n0 j jVar) {
        float fCenterX;
        float fCenterX2;
        float f10;
        RectF rectF = this.f21172g;
        RectF rectF2 = this.f21173h;
        P(view, rectF);
        W(view2, rectF2);
        int i10 = jVar.f37187a & 7;
        if (i10 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i10 == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i10 != 5) {
                f10 = 0.0f;
                return f10 + jVar.f37188b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f10 = fCenterX - fCenterX2;
        return f10 + jVar.f37188b;
    }

    public final float U(@n0 View view, @n0 View view2, @n0 j jVar) {
        float fCenterY;
        float fCenterY2;
        float f10;
        RectF rectF = this.f21172g;
        RectF rectF2 = this.f21173h;
        P(view, rectF);
        W(view2, rectF2);
        int i10 = jVar.f37187a & 112;
        if (i10 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i10 == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i10 != 80) {
                f10 = 0.0f;
                return f10 + jVar.f37189c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f10 = fCenterY - fCenterY2;
        return f10 + jVar.f37189c;
    }

    public final float V(@n0 e eVar, @n0 i iVar, float f10, float f11) {
        long jC = iVar.c();
        long jD = iVar.d();
        i iVarH = eVar.f21188a.h("expansion");
        return kd.a.a(f10, f11, iVar.e().getInterpolation((((iVarH.c() + iVarH.d()) + 17) - jC) / jD));
    }

    public final void W(@n0 View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f21174i);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void X(View view, View view2, boolean z10, boolean z11, @n0 e eVar, @n0 List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupN;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof g) && sd.d.f49669o == 0) || (viewGroupN = N(view2)) == null) {
                return;
            }
            if (z10) {
                if (!z11) {
                    kd.d.f37172a.set(viewGroupN, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupN, kd.d.f37172a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupN, kd.d.f37172a, 0.0f);
            }
            eVar.f21188a.h("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(@n0 View view, View view2, boolean z10, boolean z11, @n0 e eVar, @n0 List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof g) {
            g gVar = (g) view2;
            int iG0 = g0(view);
            int i10 = 16777215 & iG0;
            if (z10) {
                if (!z11) {
                    gVar.setCircularRevealScrimColor(iG0);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(gVar, g.d.f49685a, i10);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(gVar, g.d.f49685a, iG0);
            }
            objectAnimatorOfInt.setEvaluator(kd.c.b());
            eVar.f21188a.h("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    public final void Z(@n0 View view, @n0 View view2, boolean z10, @n0 e eVar, @n0 List<Animator> list) {
        float fT = T(view, view2, eVar.f21189b);
        float fU = U(view, view2, eVar.f21189b);
        Pair<i, i> pairQ = Q(fT, fU, z10, eVar);
        i iVar = (i) pairQ.first;
        i iVar2 = (i) pairQ.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z10) {
            fT = this.f21175j;
        }
        fArr[0] = fT;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z10) {
            fU = this.f21176k;
        }
        fArr2[0] = fU;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @TargetApi(21)
    public final void a0(View view, @n0 View view2, boolean z10, boolean z11, @n0 e eVar, @n0 List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fR = u0.R(view2) - u0.R(view);
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-fR);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fR);
        }
        eVar.f21188a.h("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0(@n0 View view, View view2, boolean z10, boolean z11, @n0 e eVar, float f10, float f11, @n0 List<Animator> list, @n0 List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof g) {
            g gVar = (g) view2;
            float fR = R(view, view2, eVar.f21189b);
            float fS = S(view, view2, eVar.f21189b);
            ((FloatingActionButton) view).i(this.f21171f);
            float fWidth = this.f21171f.width() / 2.0f;
            i iVarH = eVar.f21188a.h("expansion");
            if (z10) {
                if (!z11) {
                    gVar.setRevealInfo(new g.e(fR, fS, fWidth));
                }
                if (z11) {
                    fWidth = gVar.getRevealInfo().f49689c;
                }
                animatorA = sd.a.a(gVar, fR, fS, de.a.b(fR, fS, 0.0f, 0.0f, f10, f11));
                animatorA.addListener(new d(gVar));
                e0(view2, iVarH.c(), (int) fR, (int) fS, fWidth, list);
            } else {
                float f12 = gVar.getRevealInfo().f49689c;
                Animator animatorA2 = sd.a.a(gVar, fR, fS, fWidth);
                int i10 = (int) fR;
                int i11 = (int) fS;
                e0(view2, iVarH.c(), i10, i11, f12, list);
                d0(view2, iVarH.c(), iVarH.d(), eVar.f21188a.i(), i10, i11, fWidth, list);
                animatorA = animatorA2;
            }
            iVarH.a(animatorA);
            list.add(animatorA);
            list2.add(sd.a.c(gVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c0(View view, View view2, boolean z10, boolean z11, @n0 e eVar, @n0 List<Animator> list, @n0 List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof g) && (view instanceof ImageView)) {
            g gVar = (g) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z10) {
                if (!z11) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, kd.e.f37173b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, kd.e.f37173b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.f21188a.h("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(gVar, drawable));
        }
    }

    public final void d0(View view, long j10, long j11, long j12, int i10, int i11, float f10, @n0 List<Animator> list) {
        long j13 = j10 + j11;
        if (j13 < j12) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            animatorCreateCircularReveal.setStartDelay(j13);
            animatorCreateCircularReveal.setDuration(j12 - j13);
            list.add(animatorCreateCircularReveal);
        }
    }

    public final void e0(View view, long j10, int i10, int i11, float f10, @n0 List<Animator> list) {
        if (j10 > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j10);
            list.add(animatorCreateCircularReveal);
        }
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @g.i
    public boolean f(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    public final void f0(@n0 View view, @n0 View view2, boolean z10, boolean z11, @n0 e eVar, @n0 List<Animator> list, List<Animator.AnimatorListener> list2, @n0 RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fT = T(view, view2, eVar.f21189b);
        float fU = U(view, view2, eVar.f21189b);
        Pair<i, i> pairQ = Q(fT, fU, z10, eVar);
        i iVar = (i) pairQ.first;
        i iVar2 = (i) pairQ.second;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-fT);
                view2.setTranslationY(-fU);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            O(view2, eVar, iVar, iVar2, -fT, -fU, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fT);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fU);
        }
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    public final int g0(@n0 View view) {
        ColorStateList colorStateListN = u0.N(view);
        if (colorStateListN != null) {
            return colorStateListN.getColorForState(view.getDrawableState(), colorStateListN.getDefaultColor());
        }
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @g.i
    public void h(@n0 CoordinatorLayout.g gVar) {
        if (gVar.f4560h == 0) {
            gVar.f4560h = 80;
        }
    }

    public abstract e h0(Context context, boolean z10);

    @p0
    public final ViewGroup i0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21171f = new Rect();
        this.f21172g = new RectF();
        this.f21173h = new RectF();
        this.f21174i = new int[2];
    }
}
