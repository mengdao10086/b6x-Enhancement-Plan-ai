package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u0;
import g.n0;
import g.p0;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class g extends q {
    public static final String R7 = "android:changeTransform:parent";
    public static final String T7 = "android:changeTransform:intermediateParentMatrix";
    public static final String U7 = "android:changeTransform:intermediateMatrix";
    public boolean M7;
    public boolean N7;
    public Matrix O7;
    public static final String P7 = "android:changeTransform:matrix";
    public static final String Q7 = "android:changeTransform:transforms";
    public static final String S7 = "android:changeTransform:parentMatrix";
    public static final String[] V7 = {P7, Q7, S7};
    public static final Property<e, float[]> W7 = new a(float[].class, "nonTranslations");
    public static final Property<e, PointF> X7 = new b(PointF.class, "translations");
    public static final boolean Y7 = true;

    public class a extends Property<e, float[]> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, float[] fArr) {
            eVar.d(fArr);
        }
    }

    public class b extends Property<e, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, PointF pointF) {
            eVar.c(pointF);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Matrix f7852b = new Matrix();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f7853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f7854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f7855e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f7856f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f7857g;

        public c(boolean z10, Matrix matrix, View view, f fVar, e eVar) {
            this.f7853c = z10;
            this.f7854d = matrix;
            this.f7855e = view;
            this.f7856f = fVar;
            this.f7857g = eVar;
        }

        public final void a(Matrix matrix) {
            this.f7852b.set(matrix);
            this.f7855e.setTag(R.id.transition_transform, this.f7852b);
            this.f7856f.a(this.f7855e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7851a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f7851a) {
                if (this.f7853c && g.this.M7) {
                    a(this.f7854d);
                } else {
                    this.f7855e.setTag(R.id.transition_transform, null);
                    this.f7855e.setTag(R.id.parent_matrix, null);
                }
            }
            g2.z.f(this.f7855e, null);
            this.f7856f.a(this.f7855e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(this.f7857g.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            g.N0(this.f7855e);
        }
    }

    public static class d extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f7859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g2.e f7860b;

        public d(View view, g2.e eVar) {
            this.f7859a = view;
            this.f7860b = eVar;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void b(@n0 q qVar) {
            this.f7860b.setVisibility(4);
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void c(@n0 q qVar) {
            qVar.p0(this);
            g2.g.b(this.f7859a);
            this.f7859a.setTag(R.id.transition_transform, null);
            this.f7859a.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void e(@n0 q qVar) {
            this.f7860b.setVisibility(0);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f7861a = new Matrix();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f7862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f7863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7864d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7865e;

        public e(View view, float[] fArr) {
            this.f7862b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f7863c = fArr2;
            this.f7864d = fArr2[2];
            this.f7865e = fArr2[5];
            b();
        }

        public Matrix a() {
            return this.f7861a;
        }

        public final void b() {
            float[] fArr = this.f7863c;
            fArr[2] = this.f7864d;
            fArr[5] = this.f7865e;
            this.f7861a.setValues(fArr);
            g2.z.f(this.f7862b, this.f7861a);
        }

        public void c(PointF pointF) {
            this.f7864d = pointF.x;
            this.f7865e = pointF.y;
            b();
        }

        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f7863c, 0, fArr.length);
            b();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f7866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f7867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f7868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f7869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f7870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f7871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f7872g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f7873h;

        public f(View view) {
            this.f7866a = view.getTranslationX();
            this.f7867b = view.getTranslationY();
            this.f7868c = u0.A0(view);
            this.f7869d = view.getScaleX();
            this.f7870e = view.getScaleY();
            this.f7871f = view.getRotationX();
            this.f7872g = view.getRotationY();
            this.f7873h = view.getRotation();
        }

        public void a(View view) {
            g.R0(view, this.f7866a, this.f7867b, this.f7868c, this.f7869d, this.f7870e, this.f7871f, this.f7872g, this.f7873h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return fVar.f7866a == this.f7866a && fVar.f7867b == this.f7867b && fVar.f7868c == this.f7868c && fVar.f7869d == this.f7869d && fVar.f7870e == this.f7870e && fVar.f7871f == this.f7871f && fVar.f7872g == this.f7872g && fVar.f7873h == this.f7873h;
        }

        public int hashCode() {
            float f10 = this.f7866a;
            int iFloatToIntBits = (f10 != 0.0f ? Float.floatToIntBits(f10) : 0) * 31;
            float f11 = this.f7867b;
            int iFloatToIntBits2 = (iFloatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f7868c;
            int iFloatToIntBits3 = (iFloatToIntBits2 + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0)) * 31;
            float f13 = this.f7869d;
            int iFloatToIntBits4 = (iFloatToIntBits3 + (f13 != 0.0f ? Float.floatToIntBits(f13) : 0)) * 31;
            float f14 = this.f7870e;
            int iFloatToIntBits5 = (iFloatToIntBits4 + (f14 != 0.0f ? Float.floatToIntBits(f14) : 0)) * 31;
            float f15 = this.f7871f;
            int iFloatToIntBits6 = (iFloatToIntBits5 + (f15 != 0.0f ? Float.floatToIntBits(f15) : 0)) * 31;
            float f16 = this.f7872g;
            int iFloatToIntBits7 = (iFloatToIntBits6 + (f16 != 0.0f ? Float.floatToIntBits(f16) : 0)) * 31;
            float f17 = this.f7873h;
            return iFloatToIntBits7 + (f17 != 0.0f ? Float.floatToIntBits(f17) : 0);
        }
    }

    public g() {
        this.M7 = true;
        this.N7 = true;
        this.O7 = new Matrix();
    }

    public static void N0(View view) {
        R0(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void R0(View view, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        u0.w2(view, f12);
        view.setScaleX(f13);
        view.setScaleY(f14);
        view.setRotationX(f15);
        view.setRotationY(f16);
        view.setRotation(f17);
    }

    public final void H0(g2.q qVar) {
        View view = qVar.f28973b;
        if (view.getVisibility() == 8) {
            return;
        }
        qVar.f28972a.put(R7, view.getParent());
        qVar.f28972a.put(Q7, new f(view));
        Matrix matrix = view.getMatrix();
        qVar.f28972a.put(P7, (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.N7) {
            Matrix matrix2 = new Matrix();
            g2.z.j((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            qVar.f28972a.put(S7, matrix2);
            qVar.f28972a.put(U7, view.getTag(R.id.transition_transform));
            qVar.f28972a.put(T7, view.getTag(R.id.parent_matrix));
        }
    }

    public final void I0(ViewGroup viewGroup, g2.q qVar, g2.q qVar2) {
        View view = qVar2.f28973b;
        Matrix matrix = new Matrix((Matrix) qVar2.f28972a.get(S7));
        g2.z.k(viewGroup, matrix);
        g2.e eVarA = g2.g.a(view, viewGroup, matrix);
        if (eVarA == null) {
            return;
        }
        eVarA.a((ViewGroup) qVar.f28972a.get(R7), qVar.f28973b);
        q qVar3 = this;
        while (true) {
            v vVar = qVar3.f7974r;
            if (vVar == null) {
                break;
            } else {
                qVar3 = vVar;
            }
        }
        qVar3.a(new d(view, eVarA));
        if (Y7) {
            View view2 = qVar.f28973b;
            if (view2 != qVar2.f28973b) {
                g2.z.h(view2, 0.0f);
            }
            g2.z.h(view, 1.0f);
        }
    }

    public final ObjectAnimator J0(g2.q qVar, g2.q qVar2, boolean z10) {
        Matrix matrix = (Matrix) qVar.f28972a.get(P7);
        Matrix matrix2 = (Matrix) qVar2.f28972a.get(P7);
        if (matrix == null) {
            matrix = g2.i.f28962a;
        }
        if (matrix2 == null) {
            matrix2 = g2.i.f28962a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        f fVar = (f) qVar2.f28972a.get(Q7);
        View view = qVar2.f28973b;
        N0(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        e eVar = new e(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, PropertyValuesHolder.ofObject(W7, new g2.d(new float[9]), fArr, fArr2), g2.m.a(X7, N().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        c cVar = new c(z10, matrix3, view, fVar, eVar);
        objectAnimatorOfPropertyValuesHolder.addListener(cVar);
        androidx.transition.a.a(objectAnimatorOfPropertyValuesHolder, cVar);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public boolean K0() {
        return this.N7;
    }

    public boolean L0() {
        return this.M7;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean M0(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.f0(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            boolean r0 = r3.f0(r5)
            if (r0 != 0) goto Lf
            goto L1a
        Lf:
            g2.q r4 = r3.K(r4, r1)
            if (r4 == 0) goto L1f
            android.view.View r4 = r4.f28973b
            if (r5 != r4) goto L1d
            goto L1e
        L1a:
            if (r4 != r5) goto L1d
            goto L1e
        L1d:
            r1 = 0
        L1e:
            r2 = r1
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.g.M0(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    public final void O0(g2.q qVar, g2.q qVar2) {
        Matrix matrix = (Matrix) qVar2.f28972a.get(S7);
        qVar2.f28973b.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.O7;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) qVar.f28972a.get(P7);
        if (matrix3 == null) {
            matrix3 = new Matrix();
            qVar.f28972a.put(P7, matrix3);
        }
        matrix3.postConcat((Matrix) qVar.f28972a.get(S7));
        matrix3.postConcat(matrix2);
    }

    public void P0(boolean z10) {
        this.N7 = z10;
    }

    public void Q0(boolean z10) {
        this.M7 = z10;
    }

    @Override // androidx.transition.q
    @n0
    public String[] a0() {
        return V7;
    }

    @Override // androidx.transition.q
    public void j(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    public void m(@n0 g2.q qVar) {
        H0(qVar);
        if (Y7) {
            return;
        }
        ((ViewGroup) qVar.f28973b.getParent()).startViewTransition(qVar.f28973b);
    }

    @Override // androidx.transition.q
    @p0
    public Animator q(@n0 ViewGroup viewGroup, @p0 g2.q qVar, @p0 g2.q qVar2) {
        if (qVar == null || qVar2 == null || !qVar.f28972a.containsKey(R7) || !qVar2.f28972a.containsKey(R7)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) qVar.f28972a.get(R7);
        boolean z10 = this.N7 && !M0(viewGroup2, (ViewGroup) qVar2.f28972a.get(R7));
        Matrix matrix = (Matrix) qVar.f28972a.get(U7);
        if (matrix != null) {
            qVar.f28972a.put(P7, matrix);
        }
        Matrix matrix2 = (Matrix) qVar.f28972a.get(T7);
        if (matrix2 != null) {
            qVar.f28972a.put(S7, matrix2);
        }
        if (z10) {
            O0(qVar, qVar2);
        }
        ObjectAnimator objectAnimatorJ0 = J0(qVar, qVar2, z10);
        if (z10 && objectAnimatorJ0 != null && this.M7) {
            I0(viewGroup, qVar, qVar2);
        } else if (!Y7) {
            viewGroup2.endViewTransition(qVar.f28973b);
        }
        return objectAnimatorJ0;
    }

    @SuppressLint({"RestrictedApi"})
    public g(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M7 = true;
        this.N7 = true;
        this.O7 = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7924g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.M7 = j0.n.e(typedArrayObtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.N7 = j0.n.e(typedArrayObtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
