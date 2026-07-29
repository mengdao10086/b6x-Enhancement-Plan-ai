package qe;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.internal.q;
import com.google.android.material.internal.t;
import com.google.common.collect.LinkedHashMultimap;
import g.c1;
import g.d1;
import g.f;
import g.n0;
import g.p0;
import g.t0;
import g.x;
import ie.c;
import ie.d;
import le.g;
import le.i;
import le.j;
import le.l;
import vd.m;

/* JADX INFO: loaded from: classes7.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a extends j implements q.b {

    @d1
    public static final int M7 = R.style.Widget_MaterialComponents_Tooltip;

    @f
    public static final int N7 = R.attr.tooltipStyle;

    @n0
    public final View.OnLayoutChangeListener C1;
    public int C2;
    public int E7;
    public int F7;
    public int G7;
    public float H7;
    public float I7;
    public final float J7;

    @n0
    public final Context K0;

    @n0
    public final Rect K1;
    public int K2;
    public float K7;
    public float L7;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @p0
    public CharSequence f47312k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    @p0
    public final Paint.FontMetrics f47313k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    @n0
    public final q f47314v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f47315v2;

    /* JADX INFO: renamed from: qe.a$a, reason: collision with other inner class name */
    public class ViewOnLayoutChangeListenerC0545a implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0545a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            a.this.r1(view);
        }
    }

    public a(@n0 Context context, AttributeSet attributeSet, @f int i10, @d1 int i11) {
        super(context, attributeSet, i10, i11);
        this.f47313k1 = new Paint.FontMetrics();
        q qVar = new q(this);
        this.f47314v1 = qVar;
        this.C1 = new ViewOnLayoutChangeListenerC0545a();
        this.K1 = new Rect();
        this.H7 = 1.0f;
        this.I7 = 1.0f;
        this.J7 = 0.5f;
        this.K7 = 0.5f;
        this.L7 = 1.0f;
        this.K0 = context;
        qVar.e().density = context.getResources().getDisplayMetrics().density;
        qVar.e().setTextAlign(Paint.Align.CENTER);
    }

    @n0
    public static a T0(@n0 Context context) {
        return V0(context, null, N7, M7);
    }

    @n0
    public static a U0(@n0 Context context, @p0 AttributeSet attributeSet) {
        return V0(context, attributeSet, N7, M7);
    }

    @n0
    public static a V0(@n0 Context context, @p0 AttributeSet attributeSet, @f int i10, @d1 int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.g1(attributeSet, i10, i11);
        return aVar;
    }

    public final float Q0() {
        int i10;
        if (((this.K1.right - getBounds().right) - this.G7) - this.E7 < 0) {
            i10 = ((this.K1.right - getBounds().right) - this.G7) - this.E7;
        } else {
            if (((this.K1.left - getBounds().left) - this.G7) + this.E7 <= 0) {
                return 0.0f;
            }
            i10 = ((this.K1.left - getBounds().left) - this.G7) + this.E7;
        }
        return i10;
    }

    public final float R0() {
        this.f47314v1.e().getFontMetrics(this.f47313k1);
        Paint.FontMetrics fontMetrics = this.f47313k1;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public final float S0(@n0 Rect rect) {
        return rect.centerY() - R0();
    }

    public final g W0() {
        float f10 = -Q0();
        float fWidth = ((float) (((double) getBounds().width()) - (((double) this.F7) * Math.sqrt(2.0d)))) / 2.0f;
        return new l(new i(this.F7), Math.min(Math.max(f10, -fWidth), fWidth));
    }

    public void X0(@p0 View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.C1);
    }

    public final void Y0(@n0 Canvas canvas) {
        if (this.f47312k0 == null) {
            return;
        }
        int iS0 = (int) S0(getBounds());
        if (this.f47314v1.d() != null) {
            this.f47314v1.e().drawableState = getState();
            this.f47314v1.k(this.K0);
            this.f47314v1.e().setAlpha((int) (this.L7 * 255.0f));
        }
        CharSequence charSequence = this.f47312k0;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), iS0, this.f47314v1.e());
    }

    public int Z0() {
        return this.E7;
    }

    @Override // com.google.android.material.internal.q.b
    public void a() {
        invalidateSelf();
    }

    public int a1() {
        return this.K2;
    }

    public int b1() {
        return this.C2;
    }

    @p0
    public CharSequence c1() {
        return this.f47312k0;
    }

    @p0
    public d d1() {
        return this.f47314v1.d();
    }

    @Override // le.j, android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        canvas.save();
        float fQ0 = Q0();
        float f10 = (float) (-((((double) this.F7) * Math.sqrt(2.0d)) - ((double) this.F7)));
        canvas.scale(this.H7, this.I7, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.K7));
        canvas.translate(fQ0, f10);
        super.draw(canvas);
        Y0(canvas);
        canvas.restore();
    }

    public int e1() {
        return this.f47315v2;
    }

    public final float f1() {
        CharSequence charSequence = this.f47312k0;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f47314v1.f(charSequence.toString());
    }

    public final void g1(@p0 AttributeSet attributeSet, @f int i10, @d1 int i11) {
        TypedArray typedArrayK = t.k(this.K0, attributeSet, R.styleable.Tooltip, i10, i11, new int[0]);
        this.F7 = this.K0.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().v().t(W0()).m());
        m1(typedArrayK.getText(R.styleable.Tooltip_android_text));
        d dVarG = c.g(this.K0, typedArrayK, R.styleable.Tooltip_android_textAppearance);
        if (dVarG != null) {
            int i12 = R.styleable.Tooltip_android_textColor;
            if (typedArrayK.hasValue(i12)) {
                dVarG.k(c.a(this.K0, typedArrayK, i12));
            }
        }
        n1(dVarG);
        o0(ColorStateList.valueOf(typedArrayK.getColor(R.styleable.Tooltip_backgroundTint, m.m(m0.g.B(m.c(this.K0, android.R.attr.colorBackground, a.class.getCanonicalName()), 229), m0.g.B(m.c(this.K0, R.attr.colorOnBackground, a.class.getCanonicalName()), 153)))));
        F0(ColorStateList.valueOf(m.c(this.K0, R.attr.colorSurface, a.class.getCanonicalName())));
        this.f47315v2 = typedArrayK.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.C2 = typedArrayK.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.K2 = typedArrayK.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.E7 = typedArrayK.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        typedArrayK.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.f47314v1.e().getTextSize(), this.K2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.f47315v2 * 2) + f1(), this.C2);
    }

    public void h1(@t0 int i10) {
        this.E7 = i10;
        invalidateSelf();
    }

    public void i1(@t0 int i10) {
        this.K2 = i10;
        invalidateSelf();
    }

    public void j1(@t0 int i10) {
        this.C2 = i10;
        invalidateSelf();
    }

    public void k1(@p0 View view) {
        if (view == null) {
            return;
        }
        r1(view);
        view.addOnLayoutChangeListener(this.C1);
    }

    public void l1(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.K7 = 1.2f;
        this.H7 = f10;
        this.I7 = f10;
        this.L7 = kd.a.b(0.0f, 1.0f, 0.19f, 1.0f, f10);
        invalidateSelf();
    }

    public void m1(@p0 CharSequence charSequence) {
        if (TextUtils.equals(this.f47312k0, charSequence)) {
            return;
        }
        this.f47312k0 = charSequence;
        this.f47314v1.j(true);
        invalidateSelf();
    }

    public void n1(@p0 d dVar) {
        this.f47314v1.i(dVar, this.K0);
    }

    public void o1(@d1 int i10) {
        n1(new d(this.K0, i10));
    }

    @Override // le.j, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().v().t(W0()).m());
    }

    @Override // le.j, android.graphics.drawable.Drawable, com.google.android.material.internal.q.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p1(@t0 int i10) {
        this.f47315v2 = i10;
        invalidateSelf();
    }

    public void q1(@c1 int i10) {
        m1(this.K0.getResources().getString(i10));
    }

    public final void r1(@n0 View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.G7 = iArr[0];
        view.getWindowVisibleDisplayFrame(this.K1);
    }
}
