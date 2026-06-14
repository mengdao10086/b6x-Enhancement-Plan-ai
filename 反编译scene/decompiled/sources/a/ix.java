package a;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f6450a = kv.c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f1415a = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] b = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] c = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] d = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] e = {R.attr.state_enabled};
    public static final int[] f = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f1416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public iz f1418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nz f1419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pv f1420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xw f1421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xx f1422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yy f1423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Animator f1424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f1428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewTreeObserver.OnPreDrawListener f1429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FloatingActionButton f1430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<Animator.AnimatorListener> f1431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1432a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f1433b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1434b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public pv f1435b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f1437b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<Animator.AnimatorListener> f1438b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float f1440c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public pv f1442c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ArrayList<a> f1443c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public float f1444d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public pv f1445d;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1439b = true;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public float f1446e = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f1441c = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f1426a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f1427a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final RectF f1436b = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f1425a = new Matrix();

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a();

        void b();
    }

    public ix(FloatingActionButton floatingActionButton, yy yyVar) {
        this.f1430a = floatingActionButton;
        this.f1423a = yyVar;
        xx xxVar = new xx();
        this.f1422a = xxVar;
        xxVar.a(f1415a, f(new hx(this)));
        this.f1422a.a(b, f(new gx(this)));
        this.f1422a.a(c, f(new gx(this)));
        this.f1422a.a(d, f(new gx(this)));
        this.f1422a.a(e, f(new jx(this)));
        this.f1422a.a(f, f(new fx(this)));
        this.f1444d = this.f1430a.getRotation();
    }

    public void A() {
        ViewTreeObserver viewTreeObserver = this.f1430a.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f1429a;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.f1429a = null;
        }
    }

    public void B(int[] iArr) {
        this.f1422a.d(iArr);
    }

    public void C(float f2, float f3, float f4) {
        c0();
        d0(f2);
    }

    public void D(Rect rect) {
        yy yyVar;
        Drawable insetDrawable;
        pf.c(this.f1437b, "Didn't initialize content background");
        if (W()) {
            insetDrawable = new InsetDrawable(this.f1437b, rect.left, rect.top, rect.right, rect.bottom);
            yyVar = this.f1423a;
        } else {
            yyVar = this.f1423a;
            insetDrawable = this.f1437b;
        }
        yyVar.b(insetDrawable);
    }

    public void E() {
        float rotation = this.f1430a.getRotation();
        if (this.f1444d != rotation) {
            this.f1444d = rotation;
            a0();
        }
    }

    public void F() {
        ArrayList<a> arrayList = this.f1443c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void G() {
        ArrayList<a> arrayList = this.f1443c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public boolean H() {
        return true;
    }

    public void I(ColorStateList colorStateList) {
        iz izVar = this.f1418a;
        if (izVar != null) {
            izVar.setTintList(colorStateList);
        }
        xw xwVar = this.f1421a;
        if (xwVar != null) {
            xwVar.c(colorStateList);
        }
    }

    public void J(PorterDuff.Mode mode) {
        iz izVar = this.f1418a;
        if (izVar != null) {
            izVar.setTintMode(mode);
        }
    }

    public final void K(float f2) {
        if (this.f1416a != f2) {
            this.f1416a = f2;
            C(f2, this.f1433b, this.f1440c);
        }
    }

    public void L(boolean z) {
        this.f1432a = z;
    }

    public final void M(pv pvVar) {
        this.f1445d = pvVar;
    }

    public final void N(float f2) {
        if (this.f1433b != f2) {
            this.f1433b = f2;
            C(this.f1416a, f2, this.f1440c);
        }
    }

    public final void O(float f2) {
        this.f1446e = f2;
        Matrix matrix = this.f1425a;
        d(f2, matrix);
        this.f1430a.setImageMatrix(matrix);
    }

    public final void P(int i) {
        if (this.f1434b != i) {
            this.f1434b = i;
            b0();
        }
    }

    public void Q(int i) {
        this.f1417a = i;
    }

    public final void R(float f2) {
        if (this.f1440c != f2) {
            this.f1440c = f2;
            C(this.f1416a, this.f1433b, f2);
        }
    }

    public void S(ColorStateList colorStateList) {
        Drawable drawable = this.f1428a;
        if (drawable != null) {
            kd.o(drawable, wy.d(colorStateList));
        }
    }

    public void T(boolean z) {
        this.f1439b = z;
        c0();
    }

    public final void U(nz nzVar) {
        this.f1419a = nzVar;
        iz izVar = this.f1418a;
        if (izVar != null) {
            izVar.setShapeAppearanceModel(nzVar);
        }
        Object obj = this.f1428a;
        if (obj instanceof a00) {
            ((a00) obj).setShapeAppearanceModel(nzVar);
        }
        xw xwVar = this.f1421a;
        if (xwVar != null) {
            xwVar.f(nzVar);
        }
    }

    public final void V(pv pvVar) {
        this.f1442c = pvVar;
    }

    public boolean W() {
        return true;
    }

    public final boolean X() {
        return eh.Q(this.f1430a) && !this.f1430a.isInEditMode();
    }

    public final boolean Y() {
        return !this.f1432a || this.f1430a.getSizeDimension() >= this.f1417a;
    }

    public void Z(b bVar, boolean z) {
        if (w()) {
            return;
        }
        Animator animator = this.f1424a;
        if (animator != null) {
            animator.cancel();
        }
        if (!X()) {
            this.f1430a.b(0, z);
            this.f1430a.setAlpha(1.0f);
            this.f1430a.setScaleY(1.0f);
            this.f1430a.setScaleX(1.0f);
            O(1.0f);
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        if (this.f1430a.getVisibility() != 0) {
            this.f1430a.setAlpha(0.0f);
            this.f1430a.setScaleY(0.0f);
            this.f1430a.setScaleX(0.0f);
            O(0.0f);
        }
        pv pvVarJ = this.f1442c;
        if (pvVarJ == null) {
            pvVarJ = j();
        }
        AnimatorSet animatorSetE = e(pvVarJ, 1.0f, 1.0f, 1.0f);
        animatorSetE.addListener(new bx(this, z, bVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f1431a;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetE.addListener(it.next());
            }
        }
        animatorSetE.start();
    }

    public void a0() {
        FloatingActionButton floatingActionButton;
        int i;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f1444d % 90.0f != 0.0f) {
                i = 1;
                if (this.f1430a.getLayerType() != 1) {
                    floatingActionButton = this.f1430a;
                    floatingActionButton.setLayerType(i, null);
                }
            } else if (this.f1430a.getLayerType() != 0) {
                floatingActionButton = this.f1430a;
                i = 0;
                floatingActionButton.setLayerType(i, null);
            }
        }
        iz izVar = this.f1418a;
        if (izVar != null) {
            izVar.Z((int) this.f1444d);
        }
    }

    public final void b0() {
        O(this.f1446e);
    }

    public final void c0() {
        Rect rect = this.f1426a;
        p(rect);
        D(rect);
        this.f1423a.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void d(float f2, Matrix matrix) {
        matrix.reset();
        if (this.f1430a.getDrawable() == null || this.f1434b == 0) {
            return;
        }
        RectF rectF = this.f1427a;
        RectF rectF2 = this.f1436b;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.f1434b;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.f1434b;
        matrix.postScale(f2, f2, i2 / 2.0f, i2 / 2.0f);
    }

    public void d0(float f2) {
        iz izVar = this.f1418a;
        if (izVar != null) {
            izVar.T(f2);
        }
    }

    public final AnimatorSet e(pv pvVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f1430a, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        pvVar.e("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f1430a, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        pvVar.e("scale").a(objectAnimatorOfFloat2);
        e0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f1430a, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        pvVar.e("scale").a(objectAnimatorOfFloat3);
        e0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        d(f4, this.f1425a);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f1430a, new nv(), new cx(this), new Matrix(this.f1425a));
        pvVar.e("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        lv.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final void e0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new dx(this));
    }

    public final ValueAnimator f(kx kxVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f6450a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(kxVar);
        valueAnimator.addUpdateListener(kxVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public iz g() {
        nz nzVar = this.f1419a;
        pf.b(nzVar);
        return new iz(nzVar);
    }

    public final Drawable h() {
        return this.f1437b;
    }

    public final pv i() {
        if (this.f1435b == null) {
            this.f1435b = pv.c(this.f1430a.getContext(), yu.design_fab_hide_motion_spec);
        }
        pv pvVar = this.f1435b;
        pf.b(pvVar);
        return pvVar;
    }

    public final pv j() {
        if (this.f1420a == null) {
            this.f1420a = pv.c(this.f1430a.getContext(), yu.design_fab_show_motion_spec);
        }
        pv pvVar = this.f1420a;
        pf.b(pvVar);
        return pvVar;
    }

    public float k() {
        return this.f1416a;
    }

    public boolean l() {
        return this.f1432a;
    }

    public final pv m() {
        return this.f1445d;
    }

    public float n() {
        return this.f1433b;
    }

    public final ViewTreeObserver.OnPreDrawListener o() {
        if (this.f1429a == null) {
            this.f1429a = new ex(this);
        }
        return this.f1429a;
    }

    public void p(Rect rect) {
        int sizeDimension = this.f1432a ? (this.f1417a - this.f1430a.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.f1439b ? k() + this.f1440c : 0.0f));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public float q() {
        return this.f1440c;
    }

    public final nz r() {
        return this.f1419a;
    }

    public final pv s() {
        return this.f1442c;
    }

    public void t(b bVar, boolean z) {
        if (v()) {
            return;
        }
        Animator animator = this.f1424a;
        if (animator != null) {
            animator.cancel();
        }
        if (!X()) {
            this.f1430a.b(z ? 8 : 4, z);
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        pv pvVarI = this.f1445d;
        if (pvVarI == null) {
            pvVarI = i();
        }
        AnimatorSet animatorSetE = e(pvVarI, 0.0f, 0.0f, 0.0f);
        animatorSetE.addListener(new ax(this, z, bVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f1438b;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetE.addListener(it.next());
            }
        }
        animatorSetE.start();
    }

    public void u(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        iz izVarG = g();
        this.f1418a = izVarG;
        izVarG.setTintList(colorStateList);
        if (mode != null) {
            this.f1418a.setTintMode(mode);
        }
        this.f1418a.Y(-12303292);
        this.f1418a.K(this.f1430a.getContext());
        vy vyVar = new vy(this.f1418a.B());
        vyVar.setTintList(wy.d(colorStateList2));
        this.f1428a = vyVar;
        iz izVar = this.f1418a;
        pf.b(izVar);
        this.f1437b = new LayerDrawable(new Drawable[]{izVar, vyVar});
    }

    public boolean v() {
        return this.f1430a.getVisibility() == 0 ? this.f1441c == 1 : this.f1441c != 2;
    }

    public boolean w() {
        return this.f1430a.getVisibility() != 0 ? this.f1441c == 2 : this.f1441c != 1;
    }

    public void x() {
        this.f1422a.c();
    }

    public void y() {
        iz izVar = this.f1418a;
        if (izVar != null) {
            jz.f(this.f1430a, izVar);
        }
        if (H()) {
            this.f1430a.getViewTreeObserver().addOnPreDrawListener(o());
        }
    }

    public void z() {
    }
}
