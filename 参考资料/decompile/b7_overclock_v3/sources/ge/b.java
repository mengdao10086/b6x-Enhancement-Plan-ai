package ge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.d1;
import g.i1;
import g.n0;
import g.p0;
import g.t0;
import ge.c;
import h2.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<S extends ge.c> extends ProgressBar {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f29244o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f29245p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f29246q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f29247r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f29248s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f29249t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f29250u = R.style.Widget_MaterialComponents_ProgressIndicator;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final float f29251v = 0.2f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f29252w = 255;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f29253x = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f29254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f29258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f29259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f29260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ge.a f29261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f29262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f29263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f29264k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f29265l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b.a f29266m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b.a f29267n;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.l();
        }
    }

    /* JADX INFO: renamed from: ge.b$b, reason: collision with other inner class name */
    public class RunnableC0348b implements Runnable {
        public RunnableC0348b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.k();
            b.this.f29260g = -1L;
        }
    }

    public class c extends b.a {
        public c() {
        }

        @Override // h2.b.a
        public void b(Drawable drawable) {
            b.this.setIndeterminate(false);
            b bVar = b.this;
            bVar.p(bVar.f29255b, b.this.f29256c);
        }
    }

    public class d extends b.a {
        public d() {
        }

        @Override // h2.b.a
        public void b(Drawable drawable) {
            super.b(drawable);
            if (b.this.f29262i) {
                return;
            }
            b bVar = b.this;
            bVar.setVisibility(bVar.f29263j);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface e {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface f {
    }

    public b(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10, @d1 int i11) {
        super(pe.a.c(context, attributeSet, i10, f29250u), attributeSet, i10);
        this.f29260g = -1L;
        this.f29262i = false;
        this.f29263j = 4;
        this.f29264k = new a();
        this.f29265l = new RunnableC0348b();
        this.f29266m = new c();
        this.f29267n = new d();
        Context context2 = getContext();
        this.f29254a = (S) i(context2, attributeSet);
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.f29258e = typedArrayK.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f29259f = Math.min(typedArrayK.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayK.recycle();
        this.f29261h = new ge.a();
        this.f29257d = true;
    }

    @p0
    private j<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().A();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().C();
    }

    @Override // android.widget.ProgressBar
    @p0
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f29254a.f29277f;
    }

    @n0
    public int[] getIndicatorColor() {
        return this.f29254a.f29274c;
    }

    public int getShowAnimationBehavior() {
        return this.f29254a.f29276e;
    }

    @g.l
    public int getTrackColor() {
        return this.f29254a.f29275d;
    }

    @t0
    public int getTrackCornerRadius() {
        return this.f29254a.f29273b;
    }

    @t0
    public int getTrackThickness() {
        return this.f29254a.f29272a;
    }

    public void h(boolean z10) {
        if (this.f29257d) {
            ((i) getCurrentDrawable()).v(s(), false, z10);
        }
    }

    public abstract S i(@n0 Context context, @n0 AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public void j() {
        if (getVisibility() != 0) {
            removeCallbacks(this.f29264k);
            return;
        }
        removeCallbacks(this.f29265l);
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f29260g;
        int i10 = this.f29259f;
        if (jUptimeMillis >= ((long) i10)) {
            this.f29265l.run();
        } else {
            postDelayed(this.f29265l, ((long) i10) - jUptimeMillis);
        }
    }

    public final void k() {
        ((i) getCurrentDrawable()).v(false, false, true);
        if (n()) {
            setVisibility(4);
        }
    }

    public final void l() {
        if (this.f29259f > 0) {
            this.f29260g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    public boolean m() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public final boolean n() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    public final void o() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().z().d(this.f29266m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().c(this.f29267n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().c(this.f29267n);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        if (s()) {
            l();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f29265l);
        removeCallbacks(this.f29264k);
        ((i) getCurrentDrawable()).l();
        r();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@n0 Canvas canvas) {
        int iSave = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        j<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate == null) {
            return;
        }
        setMeasuredDimension(currentDrawingDelegate.e() < 0 ? ProgressBar.getDefaultSize(getSuggestedMinimumWidth(), i10) : currentDrawingDelegate.e() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.d() < 0 ? ProgressBar.getDefaultSize(getSuggestedMinimumHeight(), i11) : currentDrawingDelegate.d() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public void onVisibilityChanged(@n0 View view, int i10) {
        super.onVisibilityChanged(view, i10);
        h(i10 == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        h(false);
    }

    public void p(int i10, boolean z10) {
        if (!isIndeterminate()) {
            super.setProgress(i10);
            if (getProgressDrawable() == null || z10) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.f29255b = i10;
            this.f29256c = z10;
            this.f29262i = true;
            if (!getIndeterminateDrawable().isVisible() || this.f29261h.a(getContext().getContentResolver()) == 0.0f) {
                this.f29266m.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().z().f();
            }
        }
    }

    public void q() {
        if (this.f29258e <= 0) {
            this.f29264k.run();
        } else {
            removeCallbacks(this.f29264k);
            postDelayed(this.f29264k, this.f29258e);
        }
    }

    public final void r() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().b(this.f29267n);
            getIndeterminateDrawable().z().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().b(this.f29267n);
        }
    }

    public boolean s() {
        return u0.O0(this) && getWindowVisibility() == 0 && m();
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAnimatorDurationScaleProvider(@n0 ge.a aVar) {
        this.f29261h = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f29324c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f29324c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i10) {
        this.f29254a.f29277f = i10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z10) {
        if (z10 == isIndeterminate()) {
            return;
        }
        i iVar = (i) getCurrentDrawable();
        if (iVar != null) {
            iVar.l();
        }
        super.setIndeterminate(z10);
        i iVar2 = (i) getCurrentDrawable();
        if (iVar2 != null) {
            iVar2.v(s(), false, false);
        }
        if ((iVar2 instanceof l) && s()) {
            ((l) iVar2).z().g();
        }
        this.f29262i = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@p0 Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof l)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((i) drawable).l();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(@g.l int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{vd.m.b(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f29254a.f29274c = iArr;
        getIndeterminateDrawable().z().c();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i10) {
        if (isIndeterminate()) {
            return;
        }
        p(i10, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@p0 Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof h)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            h hVar = (h) drawable;
            hVar.l();
            super.setProgressDrawable(hVar);
            hVar.H(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i10) {
        this.f29254a.f29276e = i10;
        invalidate();
    }

    public void setTrackColor(@g.l int i10) {
        S s10 = this.f29254a;
        if (s10.f29275d != i10) {
            s10.f29275d = i10;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@t0 int i10) {
        S s10 = this.f29254a;
        if (s10.f29273b != i10) {
            s10.f29273b = Math.min(i10, s10.f29272a / 2);
        }
    }

    public void setTrackThickness(@t0 int i10) {
        S s10 = this.f29254a;
        if (s10.f29272a != i10) {
            s10.f29272a = i10;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i10) {
        if (i10 != 0 && i10 != 4 && i10 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f29263j = i10;
    }

    @Override // android.widget.ProgressBar
    @p0
    public l<S> getIndeterminateDrawable() {
        return (l) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @p0
    public h<S> getProgressDrawable() {
        return (h) super.getProgressDrawable();
    }
}
