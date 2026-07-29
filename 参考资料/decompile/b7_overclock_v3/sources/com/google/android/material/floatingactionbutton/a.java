package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Iterator;
import le.o;
import le.s;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final long E = 100;
    public static final long F = 100;
    public static final int G = 0;
    public static final int H = 1;
    public static final int I = 2;
    public static final float J = 1.5f;
    public static final float K = 0.0f;
    public static final float L = 0.4f;
    public static final float M = 0.4f;
    public static final float N = 1.0f;
    public static final float O = 1.0f;
    public static final float P = 1.0f;
    public static final float Q = 0.0f;
    public static final float R = 0.0f;

    @p0
    public ViewTreeObserver.OnPreDrawListener C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public o f20230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public le.j f20231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public Drawable f20232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public be.c f20233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public Drawable f20234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20235f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f20237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f20238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f20239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final com.google.android.material.internal.o f20241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public Animator f20242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public kd.h f20243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public kd.h f20244o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f20245p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20247r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f20249t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f20250u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList<j> f20251v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FloatingActionButton f20252w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ke.c f20253x;
    public static final TimeInterpolator D = kd.a.f37168c;
    public static final int S = R.attr.motionDurationLong2;
    public static final int T = R.attr.motionEasingEmphasizedInterpolator;
    public static final int U = R.attr.motionDurationMedium1;
    public static final int V = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] W = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    public static final int[] X = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] Y = {android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] Z = {android.R.attr.state_hovered, android.R.attr.state_enabled};

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int[] f20228a0 = {android.R.attr.state_enabled};

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int[] f20229b0 = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20236g = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f20246q = 1.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f20248s = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f20254y = new Rect();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f20255z = new RectF();
    public final RectF A = new RectF();
    public final Matrix B = new Matrix();

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    public class C0205a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f20257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f20258c;

        public C0205a(boolean z10, k kVar) {
            this.f20257b = z10;
            this.f20258c = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f20256a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f20248s = 0;
            a.this.f20242m = null;
            if (this.f20256a) {
                return;
            }
            FloatingActionButton floatingActionButton = a.this.f20252w;
            boolean z10 = this.f20257b;
            floatingActionButton.a(z10 ? 8 : 4, z10);
            k kVar = this.f20258c;
            if (kVar != null) {
                kVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f20252w.a(0, this.f20257b);
            a.this.f20248s = 1;
            a.this.f20242m = animator;
            this.f20256a = false;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f20261b;

        public b(boolean z10, k kVar) {
            this.f20260a = z10;
            this.f20261b = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f20248s = 0;
            a.this.f20242m = null;
            k kVar = this.f20261b;
            if (kVar != null) {
                kVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f20252w.a(0, this.f20260a);
            a.this.f20248s = 2;
            a.this.f20242m = animator;
        }
    }

    public class c extends kd.g {
        public c() {
        }

        @Override // kd.g, android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a */
        public Matrix evaluate(float f10, @n0 Matrix matrix, @n0 Matrix matrix2) {
            a.this.f20246q = f10;
            return super.evaluate(f10, matrix, matrix2);
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f20264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f20265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f20266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f20267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f20268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f20269f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ float f20270g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Matrix f20271h;

        public d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
            this.f20264a = f10;
            this.f20265b = f11;
            this.f20266c = f12;
            this.f20267d = f13;
            this.f20268e = f14;
            this.f20269f = f15;
            this.f20270g = f16;
            this.f20271h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f20252w.setAlpha(kd.a.b(this.f20264a, this.f20265b, 0.0f, 0.2f, fFloatValue));
            a.this.f20252w.setScaleX(kd.a.a(this.f20266c, this.f20267d, fFloatValue));
            a.this.f20252w.setScaleY(kd.a.a(this.f20268e, this.f20267d, fFloatValue));
            a.this.f20246q = kd.a.a(this.f20269f, this.f20270g, fFloatValue);
            a.this.h(kd.a.a(this.f20269f, this.f20270g, fFloatValue), this.f20271h);
            a.this.f20252w.setImageMatrix(this.f20271h);
        }
    }

    public class e implements TypeEvaluator<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FloatEvaluator f20273a = new FloatEvaluator();

        public e() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f10, Float f11, Float f12) {
            float fFloatValue = this.f20273a.evaluate(f10, (Number) f11, (Number) f12).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    public class f implements ViewTreeObserver.OnPreDrawListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.H();
            return true;
        }
    }

    public class g extends m {
        public g() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        public float a() {
            return 0.0f;
        }
    }

    public class h extends m {
        public h() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        public float a() {
            a aVar = a.this;
            return aVar.f20237h + aVar.f20238i;
        }
    }

    public class i extends m {
        public i() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        public float a() {
            a aVar = a.this;
            return aVar.f20237h + aVar.f20239j;
        }
    }

    public interface j {
        void a();

        void b();
    }

    public interface k {
        void a();

        void b();
    }

    public class l extends m {
        public l() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        public float a() {
            return a.this.f20237h;
        }
    }

    public abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f20281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f20282c;

        public m() {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.j0((int) this.f20282c);
            this.f20280a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            if (!this.f20280a) {
                le.j jVar = a.this.f20231b;
                this.f20281b = jVar == null ? 0.0f : jVar.x();
                this.f20282c = a();
                this.f20280a = true;
            }
            a aVar = a.this;
            float f10 = this.f20281b;
            aVar.j0((int) (f10 + ((this.f20282c - f10) * valueAnimator.getAnimatedFraction())));
        }

        public /* synthetic */ m(a aVar, C0205a c0205a) {
            this();
        }
    }

    public a(FloatingActionButton floatingActionButton, ke.c cVar) {
        this.f20252w = floatingActionButton;
        this.f20253x = cVar;
        com.google.android.material.internal.o oVar = new com.google.android.material.internal.o();
        this.f20241l = oVar;
        oVar.a(W, k(new i()));
        oVar.a(X, k(new h()));
        oVar.a(Y, k(new h()));
        oVar.a(Z, k(new h()));
        oVar.a(f20228a0, k(new l()));
        oVar.a(f20229b0, k(new g()));
        this.f20245p = floatingActionButton.getRotation();
    }

    public void A() {
        this.f20241l.c();
    }

    public void B() {
        le.j jVar = this.f20231b;
        if (jVar != null) {
            le.k.f(this.f20252w, jVar);
        }
        if (N()) {
            this.f20252w.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    public void C() {
    }

    public void D() {
        ViewTreeObserver viewTreeObserver = this.f20252w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    public void E(int[] iArr) {
        this.f20241l.d(iArr);
    }

    public void F(float f10, float f11, float f12) {
        i0();
        j0(f10);
    }

    public void G(@n0 Rect rect) {
        androidx.core.util.o.m(this.f20234e, "Didn't initialize content background");
        if (!c0()) {
            this.f20253x.c(this.f20234e);
        } else {
            this.f20253x.c(new InsetDrawable(this.f20234e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    public void H() {
        float rotation = this.f20252w.getRotation();
        if (this.f20245p != rotation) {
            this.f20245p = rotation;
            g0();
        }
    }

    public void I() {
        ArrayList<j> arrayList = this.f20251v;
        if (arrayList != null) {
            Iterator<j> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
        }
    }

    public void J() {
        ArrayList<j> arrayList = this.f20251v;
        if (arrayList != null) {
            Iterator<j> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
        }
    }

    public void K(@n0 Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f20250u;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void L(@n0 Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f20249t;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void M(@n0 j jVar) {
        ArrayList<j> arrayList = this.f20251v;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(jVar);
    }

    public boolean N() {
        return true;
    }

    public void O(@p0 ColorStateList colorStateList) {
        le.j jVar = this.f20231b;
        if (jVar != null) {
            jVar.setTintList(colorStateList);
        }
        be.c cVar = this.f20233d;
        if (cVar != null) {
            cVar.d(colorStateList);
        }
    }

    public void P(@p0 PorterDuff.Mode mode) {
        le.j jVar = this.f20231b;
        if (jVar != null) {
            jVar.setTintMode(mode);
        }
    }

    public final void Q(float f10) {
        if (this.f20237h != f10) {
            this.f20237h = f10;
            F(f10, this.f20238i, this.f20239j);
        }
    }

    public void R(boolean z10) {
        this.f20235f = z10;
    }

    public final void S(@p0 kd.h hVar) {
        this.f20244o = hVar;
    }

    public final void T(float f10) {
        if (this.f20238i != f10) {
            this.f20238i = f10;
            F(this.f20237h, f10, this.f20239j);
        }
    }

    public final void U(float f10) {
        this.f20246q = f10;
        Matrix matrix = this.B;
        h(f10, matrix);
        this.f20252w.setImageMatrix(matrix);
    }

    public final void V(int i10) {
        if (this.f20247r != i10) {
            this.f20247r = i10;
            h0();
        }
    }

    public void W(int i10) {
        this.f20240k = i10;
    }

    public final void X(float f10) {
        if (this.f20239j != f10) {
            this.f20239j = f10;
            F(this.f20237h, this.f20238i, f10);
        }
    }

    public void Y(@p0 ColorStateList colorStateList) {
        Drawable drawable = this.f20232c;
        if (drawable != null) {
            n0.c.o(drawable, je.b.e(colorStateList));
        }
    }

    public void Z(boolean z10) {
        this.f20236g = z10;
        i0();
    }

    public final void a0(@n0 o oVar) {
        this.f20230a = oVar;
        le.j jVar = this.f20231b;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(oVar);
        }
        Object obj = this.f20232c;
        if (obj instanceof s) {
            ((s) obj).setShapeAppearanceModel(oVar);
        }
        be.c cVar = this.f20233d;
        if (cVar != null) {
            cVar.g(oVar);
        }
    }

    public final void b0(@p0 kd.h hVar) {
        this.f20243n = hVar;
    }

    public boolean c0() {
        return true;
    }

    public final boolean d0() {
        return u0.U0(this.f20252w) && !this.f20252w.isInEditMode();
    }

    public void e(@n0 Animator.AnimatorListener animatorListener) {
        if (this.f20250u == null) {
            this.f20250u = new ArrayList<>();
        }
        this.f20250u.add(animatorListener);
    }

    public final boolean e0() {
        return !this.f20235f || this.f20252w.getSizeDimension() >= this.f20240k;
    }

    public void f(@n0 Animator.AnimatorListener animatorListener) {
        if (this.f20249t == null) {
            this.f20249t = new ArrayList<>();
        }
        this.f20249t.add(animatorListener);
    }

    public void f0(@p0 k kVar, boolean z10) {
        if (z()) {
            return;
        }
        Animator animator = this.f20242m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z11 = this.f20243n == null;
        if (!d0()) {
            this.f20252w.a(0, z10);
            this.f20252w.setAlpha(1.0f);
            this.f20252w.setScaleY(1.0f);
            this.f20252w.setScaleX(1.0f);
            U(1.0f);
            if (kVar != null) {
                kVar.a();
                return;
            }
            return;
        }
        if (this.f20252w.getVisibility() != 0) {
            this.f20252w.setAlpha(0.0f);
            this.f20252w.setScaleY(z11 ? 0.4f : 0.0f);
            this.f20252w.setScaleX(z11 ? 0.4f : 0.0f);
            U(z11 ? 0.4f : 0.0f);
        }
        kd.h hVar = this.f20243n;
        AnimatorSet animatorSetI = hVar != null ? i(hVar, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f, S, T);
        animatorSetI.addListener(new b(z10, kVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f20249t;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                animatorSetI.addListener(it2.next());
            }
        }
        animatorSetI.start();
    }

    public void g(@n0 j jVar) {
        if (this.f20251v == null) {
            this.f20251v = new ArrayList<>();
        }
        this.f20251v.add(jVar);
    }

    public void g0() {
        le.j jVar = this.f20231b;
        if (jVar != null) {
            jVar.w0((int) this.f20245p);
        }
    }

    public final void h(float f10, @n0 Matrix matrix) {
        matrix.reset();
        if (this.f20252w.getDrawable() == null || this.f20247r == 0) {
            return;
        }
        RectF rectF = this.f20255z;
        RectF rectF2 = this.A;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i10 = this.f20247r;
        rectF2.set(0.0f, 0.0f, i10, i10);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i11 = this.f20247r;
        matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
    }

    public final void h0() {
        U(this.f20246q);
    }

    @n0
    public final AnimatorSet i(@n0 kd.h hVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f20252w, (Property<FloatingActionButton, Float>) View.ALPHA, f10);
        hVar.h("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f20252w, (Property<FloatingActionButton, Float>) View.SCALE_X, f11);
        hVar.h("scale").a(objectAnimatorOfFloat2);
        k0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f20252w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f11);
        hVar.h("scale").a(objectAnimatorOfFloat3);
        k0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f12, this.B);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f20252w, new kd.f(), new c(), new Matrix(this.B));
        hVar.h("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        kd.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final void i0() {
        Rect rect = this.f20254y;
        s(rect);
        G(rect);
        this.f20253x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final AnimatorSet j(float f10, float f11, float f12, int i10, int i11) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new d(this.f20252w.getAlpha(), f10, this.f20252w.getScaleX(), f11, this.f20252w.getScaleY(), this.f20246q, f12, new Matrix(this.B)));
        arrayList.add(valueAnimatorOfFloat);
        kd.b.a(animatorSet, arrayList);
        animatorSet.setDuration(ee.a.f(this.f20252w.getContext(), i10, this.f20252w.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(ee.a.g(this.f20252w.getContext(), i11, kd.a.f37167b));
        return animatorSet;
    }

    public void j0(float f10) {
        le.j jVar = this.f20231b;
        if (jVar != null) {
            jVar.n0(f10);
        }
    }

    @n0
    public final ValueAnimator k(@n0 m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void k0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    public le.j l() {
        return new le.j((o) androidx.core.util.o.l(this.f20230a));
    }

    @p0
    public final Drawable m() {
        return this.f20234e;
    }

    public float n() {
        return this.f20237h;
    }

    public boolean o() {
        return this.f20235f;
    }

    @p0
    public final kd.h p() {
        return this.f20244o;
    }

    public float q() {
        return this.f20238i;
    }

    @n0
    public final ViewTreeObserver.OnPreDrawListener r() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    public void s(@n0 Rect rect) {
        int sizeDimension = this.f20235f ? (this.f20240k - this.f20252w.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.f20236g ? n() + this.f20239j : 0.0f));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public float t() {
        return this.f20239j;
    }

    @p0
    public final o u() {
        return this.f20230a;
    }

    @p0
    public final kd.h v() {
        return this.f20243n;
    }

    public void w(@p0 k kVar, boolean z10) {
        if (y()) {
            return;
        }
        Animator animator = this.f20242m;
        if (animator != null) {
            animator.cancel();
        }
        if (!d0()) {
            this.f20252w.a(z10 ? 8 : 4, z10);
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        kd.h hVar = this.f20244o;
        AnimatorSet animatorSetI = hVar != null ? i(hVar, 0.0f, 0.0f, 0.0f) : j(0.0f, 0.4f, 0.4f, U, V);
        animatorSetI.addListener(new C0205a(z10, kVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f20250u;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                animatorSetI.addListener(it2.next());
            }
        }
        animatorSetI.start();
    }

    public void x(ColorStateList colorStateList, @p0 PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        le.j jVarL = l();
        this.f20231b = jVarL;
        jVarL.setTintList(colorStateList);
        if (mode != null) {
            this.f20231b.setTintMode(mode);
        }
        this.f20231b.v0(-12303292);
        this.f20231b.Z(this.f20252w.getContext());
        je.a aVar = new je.a(this.f20231b.getShapeAppearanceModel());
        aVar.setTintList(je.b.e(colorStateList2));
        this.f20232c = aVar;
        this.f20234e = new LayerDrawable(new Drawable[]{(Drawable) androidx.core.util.o.l(this.f20231b), aVar});
    }

    public boolean y() {
        return this.f20252w.getVisibility() == 0 ? this.f20248s == 1 : this.f20248s != 2;
    }

    public boolean z() {
        return this.f20252w.getVisibility() != 0 ? this.f20248s == 2 : this.f20248s != 1;
    }
}
