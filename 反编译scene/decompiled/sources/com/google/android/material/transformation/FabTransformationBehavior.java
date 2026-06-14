package com.google.android.material.transformation;

import a.dv;
import a.eh;
import a.kv;
import a.lv;
import a.mv;
import a.pv;
import a.qv;
import a.rv;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f4789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f4790a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final RectF f4791b;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8343a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f4792a;
        public final /* synthetic */ View b;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f4792a = z;
            this.f8343a = view;
            this.b = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f4792a) {
                return;
            }
            this.f8343a.setVisibility(4);
            this.b.setAlpha(1.0f);
            this.b.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f4792a) {
                this.f8343a.setVisibility(0);
                this.b.setAlpha(0.0f);
                this.b.setVisibility(4);
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public pv f8344a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public rv f4793a;
    }

    public FabTransformationBehavior() {
        this.f4788a = new Rect();
        this.f4789a = new RectF();
        this.f4791b = new RectF();
        this.f4790a = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4788a = new Rect();
        this.f4789a = new RectF();
        this.f4791b = new RectF();
        this.f4790a = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet J(View view, View view2, boolean z, boolean z2) {
        b bVarZ = Z(view2.getContext(), z);
        if (z) {
            this.f8342a = view.getTranslationX();
            this.b = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            V(view, view2, z, z2, bVarZ, arrayList, arrayList2);
        }
        RectF rectF = this.f4789a;
        Y(view, view2, z, z2, bVarZ, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        U(view, view2, z, bVarZ, arrayList);
        X(view, view2, z, z2, bVarZ, arrayList, arrayList2);
        W(view, view2, z, z2, bVarZ, fWidth, fHeight, arrayList, arrayList2);
        T(view, view2, z, z2, bVarZ, arrayList, arrayList2);
        S(view, view2, z, z2, bVarZ, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        lv.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    public final ViewGroup K(View view) {
        View viewFindViewById = view.findViewById(dv.mtrl_child_content_container);
        return viewFindViewById != null ? a0(viewFindViewById) : a0(view);
    }

    public final void L(View view, b bVar, qv qvVar, qv qvVar2, float f, float f2, float f3, float f4, RectF rectF) {
        float fQ = Q(bVar, qvVar, f, f3);
        float fQ2 = Q(bVar, qvVar2, f2, f4);
        Rect rect = this.f4788a;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f4789a;
        rectF2.set(rect);
        RectF rectF3 = this.f4791b;
        R(view, rectF3);
        rectF3.offset(fQ, fQ2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final void M(View view, RectF rectF) {
        R(view, rectF);
        rectF.offset(this.f8342a, this.b);
    }

    public final Pair<qv, qv> N(float f, float f2, boolean z, b bVar) {
        qv qvVarE;
        pv pvVar;
        String str;
        if (f == 0.0f || f2 == 0.0f) {
            qvVarE = bVar.f8344a.e("translationXLinear");
            pvVar = bVar.f8344a;
            str = "translationYLinear";
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            qvVarE = bVar.f8344a.e("translationXCurveDownwards");
            pvVar = bVar.f8344a;
            str = "translationYCurveDownwards";
        } else {
            qvVarE = bVar.f8344a.e("translationXCurveUpwards");
            pvVar = bVar.f8344a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(qvVarE, pvVar.e(str));
    }

    public final float O(View view, View view2, rv rvVar) {
        float fCenterX;
        float fCenterX2;
        float f;
        RectF rectF = this.f4789a;
        RectF rectF2 = this.f4791b;
        M(view, rectF);
        R(view2, rectF2);
        int i = rvVar.f2790a & 7;
        if (i == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i != 5) {
                f = 0.0f;
                return f + rvVar.f7333a;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f = fCenterX - fCenterX2;
        return f + rvVar.f7333a;
    }

    public final float P(View view, View view2, rv rvVar) {
        float fCenterY;
        float fCenterY2;
        float f;
        RectF rectF = this.f4789a;
        RectF rectF2 = this.f4791b;
        M(view, rectF);
        R(view2, rectF2);
        int i = rvVar.f2790a & 112;
        if (i == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i != 80) {
                f = 0.0f;
                return f + rvVar.b;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f = fCenterY - fCenterY2;
        return f + rvVar.b;
    }

    public final float Q(b bVar, qv qvVar, float f, float f2) {
        long jC = qvVar.c();
        long jD = qvVar.d();
        qv qvVarE = bVar.f8344a.e("expansion");
        return kv.a(f, f2, qvVar.e().getInterpolation((((qvVarE.c() + qvVarE.d()) + 17) - jC) / jD));
    }

    public final void R(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f4790a);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void S(View view, View view2, boolean z, boolean z2, b bVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupK;
        ObjectAnimator objectAnimatorOfFloat;
        if ((view2 instanceof ViewGroup) && (viewGroupK = K(view2)) != null) {
            if (z) {
                if (!z2) {
                    mv.f6845a.set(viewGroupK, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, mv.f6845a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, mv.f6845a, 0.0f);
            }
            bVar.f8344a.e("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    public final void T(View view, View view2, boolean z, boolean z2, b bVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
    }

    public final void U(View view, View view2, boolean z, b bVar, List<Animator> list) {
        float fO = O(view, view2, bVar.f4793a);
        float fP = P(view, view2, bVar.f4793a);
        Pair<qv, qv> pairN = N(fO, fP, z, bVar);
        qv qvVar = (qv) pairN.first;
        qv qvVar2 = (qv) pairN.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            fO = this.f8342a;
        }
        fArr[0] = fO;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            fP = this.b;
        }
        fArr2[0] = fP;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        qvVar.a(objectAnimatorOfFloat);
        qvVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @TargetApi(21)
    public final void V(View view, View view2, boolean z, boolean z2, b bVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fT = eh.t(view2) - eh.t(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-fT);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fT);
        }
        bVar.f8344a.e("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    public final void W(View view, View view2, boolean z, boolean z2, b bVar, float f, float f2, List<Animator> list, List<Animator.AnimatorListener> list2) {
    }

    public final void X(View view, View view2, boolean z, boolean z2, b bVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
    }

    public final void Y(View view, View view2, boolean z, boolean z2, b bVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fO = O(view, view2, bVar.f4793a);
        float fP = P(view, view2, bVar.f4793a);
        Pair<qv, qv> pairN = N(fO, fP, z, bVar);
        qv qvVar = (qv) pairN.first;
        qv qvVar2 = (qv) pairN.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fO);
                view2.setTranslationY(-fP);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            L(view2, bVar, qvVar, qvVar2, -fO, -fP, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fO);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fP);
        }
        qvVar.a(objectAnimatorOfFloat);
        qvVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    public abstract b Z(Context context, boolean z);

    public final ViewGroup a0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f == 0) {
            fVar.f = 80;
        }
    }
}
