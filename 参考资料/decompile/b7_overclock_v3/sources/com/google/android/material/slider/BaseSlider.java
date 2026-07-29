package com.google.android.material.slider;

import a1.d;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.a0;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import g.f0;
import g.i1;
import g.l;
import g.n;
import g.n0;
import g.p0;
import g.q;
import g.r;
import g.v;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import le.j;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {
    public static final String U7 = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    public static final String V7 = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    public static final String W7 = "valueFrom(%s) must be smaller than valueTo(%s)";
    public static final String X7 = "valueTo(%s) must be greater than valueFrom(%s)";
    public static final String Y7 = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    public static final String Z7 = "minSeparation(%s) must be greater or equal to 0";

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final String f20612a8 = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final String f20613b8 = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public static final String f20614c8 = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final int f20615d8 = 200;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final int f20616e8 = 63;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final double f20617f8 = 1.0E-4d;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final int f20619h8 = 1;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final int f20620i8 = 0;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public static final long f20621j8 = 83;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public static final long f20622k8 = 117;
    public int A;
    public int B;
    public float C;
    public ArrayList<Float> C1;
    public float C2;
    public MotionEvent D;
    public boolean E7;
    public int F7;
    public boolean G7;
    public boolean H7;
    public boolean I7;

    @n0
    public ColorStateList J7;
    public boolean K0;
    public int K1;
    public float[] K2;

    @n0
    public ColorStateList K7;

    @n0
    public ColorStateList L7;

    @n0
    public ColorStateList M7;

    @n0
    public ColorStateList N7;

    @n0
    public final j O7;

    @p0
    public Drawable P7;

    @n0
    public List<Drawable> Q7;
    public float R7;
    public int S7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Paint f20623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Paint f20624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Paint f20625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Paint f20626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final Paint f20627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final Paint f20628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final e f20629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f20630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseSlider<S, L, T>.d f20631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final f f20632j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final List<qe.a> f20633k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public com.google.android.material.slider.d f20634k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f20635k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final List<L> f20636l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final List<T> f20637m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f20638n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f20639o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ValueAnimator f20640p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f20641q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20642r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f20643s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20644t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f20645u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f20646v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public float f20647v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f20648v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f20649w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f20650x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f20651y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20652z;
    public static final String T7 = BaseSlider.class.getSimpleName();

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final int f20618g8 = R.style.Widget_MaterialComponents_Slider;

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f20653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f20654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Float> f20655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f20656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f20657e;

        public class a implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(@n0 Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i10) {
                return new SliderState[i10];
            }
        }

        public /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeFloat(this.f20653a);
            parcel.writeFloat(this.f20654b);
            parcel.writeList(this.f20655c);
            parcel.writeFloat(this.f20656d);
            parcel.writeBooleanArray(new boolean[]{this.f20657e});
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        public SliderState(@n0 Parcel parcel) {
            super(parcel);
            this.f20653a = parcel.readFloat();
            this.f20654b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f20655c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f20656d = parcel.readFloat();
            this.f20657e = parcel.createBooleanArray()[0];
        }
    }

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttributeSet f20658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20659b;

        public a(AttributeSet attributeSet, int i10) {
            this.f20658a = attributeSet;
            this.f20659b = i10;
        }

        @Override // com.google.android.material.slider.BaseSlider.f
        public qe.a a() {
            TypedArray typedArrayK = t.k(BaseSlider.this.getContext(), this.f20658a, R.styleable.Slider, this.f20659b, BaseSlider.f20618g8, new int[0]);
            qe.a aVarC0 = BaseSlider.c0(BaseSlider.this.getContext(), typedArrayK);
            typedArrayK.recycle();
            return aVarC0;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it2 = BaseSlider.this.f20633k.iterator();
            while (it2.hasNext()) {
                ((qe.a) it2.next()).l1(fFloatValue);
            }
            u0.n1(BaseSlider.this);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            a0 a0VarH = b0.h(BaseSlider.this);
            Iterator it2 = BaseSlider.this.f20633k.iterator();
            while (it2.hasNext()) {
                a0VarH.b((qe.a) it2.next());
            }
        }
    }

    public static class e extends e1.a {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final BaseSlider<?, ?, ?> f20665t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final Rect f20666u;

        public e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f20666u = new Rect();
            this.f20665t = baseSlider;
        }

        @Override // e1.a
        public int C(float f10, float f11) {
            for (int i10 = 0; i10 < this.f20665t.getValues().size(); i10++) {
                this.f20665t.q0(i10, this.f20666u);
                if (this.f20666u.contains((int) f10, (int) f11)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // e1.a
        public void D(List<Integer> list) {
            for (int i10 = 0; i10 < this.f20665t.getValues().size(); i10++) {
                list.add(Integer.valueOf(i10));
            }
        }

        @Override // e1.a
        public boolean N(int i10, int i11, Bundle bundle) {
            if (!this.f20665t.isEnabled()) {
                return false;
            }
            if (i11 != 4096 && i11 != 8192) {
                if (i11 == 16908349 && bundle != null && bundle.containsKey(a1.d.Z)) {
                    if (this.f20665t.o0(i10, bundle.getFloat(a1.d.Z))) {
                        this.f20665t.r0();
                        this.f20665t.postInvalidate();
                        G(i10);
                        return true;
                    }
                }
                return false;
            }
            float fN = this.f20665t.n(20);
            if (i11 == 8192) {
                fN = -fN;
            }
            if (this.f20665t.O()) {
                fN = -fN;
            }
            if (!this.f20665t.o0(i10, t0.a.d(this.f20665t.getValues().get(i10).floatValue() + fN, this.f20665t.getValueFrom(), this.f20665t.getValueTo()))) {
                return false;
            }
            this.f20665t.r0();
            this.f20665t.postInvalidate();
            G(i10);
            return true;
        }

        @Override // e1.a
        public void R(int i10, a1.d dVar) {
            dVar.b(d.a.M);
            List<Float> values = this.f20665t.getValues();
            float fFloatValue = values.get(i10).floatValue();
            float valueFrom = this.f20665t.getValueFrom();
            float valueTo = this.f20665t.getValueTo();
            if (this.f20665t.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    dVar.a(8192);
                }
                if (fFloatValue < valueTo) {
                    dVar.a(4096);
                }
            }
            dVar.I1(d.f.e(1, valueFrom, valueTo, fFloatValue));
            dVar.b1(SeekBar.class.getName());
            StringBuilder sb2 = new StringBuilder();
            if (this.f20665t.getContentDescription() != null) {
                sb2.append(this.f20665t.getContentDescription());
                sb2.append(ag.c.f654g);
            }
            if (values.size() > 1) {
                sb2.append(a0(i10));
                sb2.append(this.f20665t.F(fFloatValue));
            }
            dVar.f1(sb2.toString());
            this.f20665t.q0(i10, this.f20666u);
            dVar.W0(this.f20666u);
        }

        @n0
        public final String a0(int i10) {
            return i10 == this.f20665t.getValues().size() + (-1) ? this.f20665t.getContext().getString(R.string.material_slider_range_end) : i10 == 0 ? this.f20665t.getContext().getString(R.string.material_slider_range_start) : "";
        }
    }

    public interface f {
        qe.a a();
    }

    public BaseSlider(@n0 Context context) {
        this(context, null);
    }

    public static float G(ValueAnimator valueAnimator, float f10) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f10;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    @n0
    public static qe.a c0(@n0 Context context, @n0 TypedArray typedArray) {
        return qe.a.V0(context, null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    public static int e0(float[] fArr, float f10) {
        return Math.round(f10 * ((fArr.length / 2) - 1));
    }

    private float[] getActiveRange() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.C1.size() == 1) {
            fFloatValue2 = this.f20635k1;
        }
        float fY = Y(fFloatValue2);
        float fY2 = Y(fFloatValue);
        return O() ? new float[]{fY2, fY} : new float[]{fY, fY2};
    }

    private float getValueOfTouchPosition() {
        double dN0 = n0(this.R7);
        if (O()) {
            dN0 = 1.0d - dN0;
        }
        float f10 = this.f20647v1;
        float f11 = this.f20635k1;
        return (float) ((dN0 * ((double) (f10 - f11))) + ((double) f11));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f10 = this.R7;
        if (O()) {
            f10 = 1.0f - f10;
        }
        float f11 = this.f20647v1;
        float f12 = this.f20635k1;
        return (f10 * (f11 - f12)) + f12;
    }

    private void setValuesInternal(@n0 ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.C1.size() == arrayList.size() && this.C1.equals(arrayList)) {
            return;
        }
        this.C1 = arrayList;
        this.I7 = true;
        this.f20648v2 = 0;
        r0();
        s();
        w();
        postInvalidate();
    }

    public final void A(@n0 Canvas canvas, int i10, int i11) {
        for (int i12 = 0; i12 < this.C1.size(); i12++) {
            float fFloatValue = this.C1.get(i12).floatValue();
            Drawable drawable = this.P7;
            if (drawable != null) {
                z(canvas, i10, i11, fFloatValue, drawable);
            } else if (i12 < this.Q7.size()) {
                z(canvas, i10, i11, fFloatValue, this.Q7.get(i12));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.f20651y + (Y(fFloatValue) * i10), i11, this.f20652z, this.f20625c);
                }
                z(canvas, i10, i11, fFloatValue, this.O7);
            }
        }
    }

    public final boolean A0(float f10) {
        return N(f10 - this.f20635k1);
    }

    public final void B() {
        if (this.f20649w == 2) {
            return;
        }
        if (!this.f20638n) {
            this.f20638n = true;
            ValueAnimator valueAnimatorR = r(true);
            this.f20639o = valueAnimatorR;
            this.f20640p = null;
            valueAnimatorR.start();
        }
        Iterator<qe.a> it2 = this.f20633k.iterator();
        for (int i10 = 0; i10 < this.C1.size() && it2.hasNext(); i10++) {
            if (i10 != this.f20648v2) {
                j0(it2.next(), this.C1.get(i10).floatValue());
            }
        }
        if (!it2.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f20633k.size()), Integer.valueOf(this.C1.size())));
        }
        j0(it2.next(), this.C1.get(this.f20648v2).floatValue());
    }

    public final float B0(float f10) {
        return (Y(f10) * this.F7) + this.f20651y;
    }

    public final void C() {
        if (this.f20638n) {
            this.f20638n = false;
            ValueAnimator valueAnimatorR = r(false);
            this.f20640p = valueAnimatorR;
            this.f20639o = null;
            valueAnimatorR.addListener(new c());
            this.f20640p.start();
        }
    }

    public final void C0() {
        float f10 = this.C2;
        if (f10 == 0.0f) {
            return;
        }
        if (((int) f10) != f10) {
            String.format(f20614c8, "stepSize", Float.valueOf(f10));
        }
        float f11 = this.f20635k1;
        if (((int) f11) != f11) {
            String.format(f20614c8, "valueFrom", Float.valueOf(f11));
        }
        float f12 = this.f20647v1;
        if (((int) f12) != f12) {
            String.format(f20614c8, "valueTo", Float.valueOf(f12));
        }
    }

    public final void D(int i10) {
        if (i10 == 1) {
            W(Integer.MAX_VALUE);
            return;
        }
        if (i10 == 2) {
            W(Integer.MIN_VALUE);
        } else if (i10 == 17) {
            X(Integer.MAX_VALUE);
        } else {
            if (i10 != 66) {
                return;
            }
            X(Integer.MIN_VALUE);
        }
    }

    @i1
    public void E(boolean z10) {
        this.G7 = z10;
    }

    public final String F(float f10) {
        if (J()) {
            return this.f20634k0.a(f10);
        }
        return String.format(((float) ((int) f10)) == f10 ? "%.0f" : "%.2f", Float.valueOf(f10));
    }

    public final float H(int i10, float f10) {
        float minSeparation = getMinSeparation();
        if (this.S7 == 0) {
            minSeparation = u(minSeparation);
        }
        if (O()) {
            minSeparation = -minSeparation;
        }
        int i11 = i10 + 1;
        int i12 = i10 - 1;
        return t0.a.d(f10, i12 < 0 ? this.f20635k1 : this.C1.get(i12).floatValue() + minSeparation, i11 >= this.C1.size() ? this.f20647v1 : this.C1.get(i11).floatValue() - minSeparation);
    }

    @l
    public final int I(@n0 ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public boolean J() {
        return this.f20634k0 != null;
    }

    public final Drawable K(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        j(drawableNewDrawable);
        return drawableNewDrawable;
    }

    public final void L() {
        this.f20623a.setStrokeWidth(this.f20650x);
        this.f20624b.setStrokeWidth(this.f20650x);
        this.f20627e.setStrokeWidth(this.f20650x / 2.0f);
        this.f20628f.setStrokeWidth(this.f20650x / 2.0f);
    }

    public final boolean M() {
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    public final boolean N(float f10) {
        double dDoubleValue = new BigDecimal(Float.toString(f10)).divide(new BigDecimal(Float.toString(this.C2)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final boolean O() {
        return u0.Z(this) == 1;
    }

    public boolean P() {
        return this.E7;
    }

    public final void Q(@n0 Resources resources) {
        this.f20645u = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f20642r = dimensionPixelOffset;
        this.f20651y = dimensionPixelOffset;
        this.f20643s = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.f20644t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.B = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    public final void R() {
        if (this.C2 <= 0.0f) {
            return;
        }
        u0();
        int iMin = Math.min((int) (((this.f20647v1 - this.f20635k1) / this.C2) + 1.0f), (this.F7 / (this.f20650x * 2)) + 1);
        float[] fArr = this.K2;
        if (fArr == null || fArr.length != iMin * 2) {
            this.K2 = new float[iMin * 2];
        }
        float f10 = this.F7 / (iMin - 1);
        for (int i10 = 0; i10 < iMin * 2; i10 += 2) {
            float[] fArr2 = this.K2;
            fArr2[i10] = this.f20651y + ((i10 / 2) * f10);
            fArr2[i10 + 1] = o();
        }
    }

    public final void S(@n0 Canvas canvas, int i10, int i11) {
        if (l0()) {
            int iY = (int) (this.f20651y + (Y(this.C1.get(this.f20648v2).floatValue()) * i10));
            if (Build.VERSION.SDK_INT < 28) {
                int i12 = this.A;
                canvas.clipRect(iY - i12, i11 - i12, iY + i12, i12 + i11, Region.Op.UNION);
            }
            canvas.drawCircle(iY, i11, this.A, this.f20626d);
        }
    }

    public final void T(@n0 Canvas canvas) {
        if (!this.E7 || this.C2 <= 0.0f) {
            return;
        }
        float[] activeRange = getActiveRange();
        int iE0 = e0(this.K2, activeRange[0]);
        int iE02 = e0(this.K2, activeRange[1]);
        int i10 = iE0 * 2;
        canvas.drawPoints(this.K2, 0, i10, this.f20627e);
        int i11 = iE02 * 2;
        canvas.drawPoints(this.K2, i10, i11 - i10, this.f20628f);
        float[] fArr = this.K2;
        canvas.drawPoints(fArr, i11, fArr.length - i11, this.f20627e);
    }

    public final boolean U() {
        int iMax = this.f20642r + Math.max(Math.max(this.f20652z - this.f20643s, 0), Math.max((this.f20650x - this.f20644t) / 2, 0));
        if (this.f20651y == iMax) {
            return false;
        }
        this.f20651y = iMax;
        if (!u0.U0(this)) {
            return true;
        }
        s0(getWidth());
        return true;
    }

    public final boolean V() {
        int iMax = Math.max(this.f20645u, Math.max(this.f20650x + getPaddingTop() + getPaddingBottom(), (this.f20652z * 2) + getPaddingTop() + getPaddingBottom()));
        if (iMax == this.f20646v) {
            return false;
        }
        this.f20646v = iMax;
        return true;
    }

    public final boolean W(int i10) {
        int i11 = this.f20648v2;
        int iF = (int) t0.a.f(((long) i11) + ((long) i10), 0L, this.C1.size() - 1);
        this.f20648v2 = iF;
        if (iF == i11) {
            return false;
        }
        if (this.K1 != -1) {
            this.K1 = iF;
        }
        r0();
        postInvalidate();
        return true;
    }

    public final boolean X(int i10) {
        if (O()) {
            i10 = i10 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i10;
        }
        return W(i10);
    }

    public final float Y(float f10) {
        float f11 = this.f20635k1;
        float f12 = (f10 - f11) / (this.f20647v1 - f11);
        return O() ? 1.0f - f12 : f12;
    }

    @p0
    public final Boolean Z(int i10, @n0 KeyEvent keyEvent) {
        if (i10 == 61) {
            return keyEvent.hasNoModifiers() ? Boolean.valueOf(W(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(W(-1)) : Boolean.FALSE;
        }
        if (i10 != 66) {
            if (i10 != 81) {
                if (i10 == 69) {
                    W(-1);
                    return Boolean.TRUE;
                }
                if (i10 != 70) {
                    switch (i10) {
                        case 21:
                            X(-1);
                            break;
                        case 22:
                            X(1);
                            break;
                    }
                    return Boolean.TRUE;
                }
            }
            W(1);
            return Boolean.TRUE;
        }
        this.K1 = this.f20648v2;
        postInvalidate();
        return Boolean.TRUE;
    }

    public final void a0() {
        Iterator<T> it2 = this.f20637m.iterator();
        while (it2.hasNext()) {
            it2.next().a(this);
        }
    }

    public final void b0() {
        Iterator<T> it2 = this.f20637m.iterator();
        while (it2.hasNext()) {
            it2.next().b(this);
        }
    }

    public boolean d0() {
        if (this.K1 != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float fB0 = B0(valueOfTouchPositionAbsolute);
        this.K1 = 0;
        float fAbs = Math.abs(this.C1.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i10 = 1; i10 < this.C1.size(); i10++) {
            float fAbs2 = Math.abs(this.C1.get(i10).floatValue() - valueOfTouchPositionAbsolute);
            float fB02 = B0(this.C1.get(i10).floatValue());
            if (Float.compare(fAbs2, fAbs) > 1) {
                break;
            }
            boolean z10 = !O() ? fB02 - fB0 >= 0.0f : fB02 - fB0 <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.K1 = i10;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fB02 - fB0) < this.f20641q) {
                        this.K1 = -1;
                        return false;
                    }
                    if (z10) {
                        this.K1 = i10;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.K1 != -1;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@n0 MotionEvent motionEvent) {
        return this.f20629g.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@n0 KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f20623a.setColor(I(this.N7));
        this.f20624b.setColor(I(this.M7));
        this.f20627e.setColor(I(this.L7));
        this.f20628f.setColor(I(this.K7));
        for (qe.a aVar : this.f20633k) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.O7.isStateful()) {
            this.O7.setState(getDrawableState());
        }
        this.f20626d.setColor(I(this.J7));
        this.f20626d.setAlpha(63);
    }

    public final void f0(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayK = t.k(context, attributeSet, R.styleable.Slider, i10, f20618g8, new int[0]);
        this.f20635k1 = typedArrayK.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.f20647v1 = typedArrayK.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.f20635k1));
        this.C2 = typedArrayK.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        int i11 = R.styleable.Slider_trackColor;
        boolean zHasValue = typedArrayK.hasValue(i11);
        int i12 = zHasValue ? i11 : R.styleable.Slider_trackColorInactive;
        if (!zHasValue) {
            i11 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateListA = ie.c.a(context, typedArrayK, i12);
        if (colorStateListA == null) {
            colorStateListA = i.a.a(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateListA);
        ColorStateList colorStateListA2 = ie.c.a(context, typedArrayK, i11);
        if (colorStateListA2 == null) {
            colorStateListA2 = i.a.a(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateListA2);
        this.O7.o0(ie.c.a(context, typedArrayK, R.styleable.Slider_thumbColor));
        int i13 = R.styleable.Slider_thumbStrokeColor;
        if (typedArrayK.hasValue(i13)) {
            setThumbStrokeColor(ie.c.a(context, typedArrayK, i13));
        }
        setThumbStrokeWidth(typedArrayK.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListA3 = ie.c.a(context, typedArrayK, R.styleable.Slider_haloColor);
        if (colorStateListA3 == null) {
            colorStateListA3 = i.a.a(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateListA3);
        this.E7 = typedArrayK.getBoolean(R.styleable.Slider_tickVisible, true);
        int i14 = R.styleable.Slider_tickColor;
        boolean zHasValue2 = typedArrayK.hasValue(i14);
        int i15 = zHasValue2 ? i14 : R.styleable.Slider_tickColorInactive;
        if (!zHasValue2) {
            i14 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateListA4 = ie.c.a(context, typedArrayK, i15);
        if (colorStateListA4 == null) {
            colorStateListA4 = i.a.a(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateListA4);
        ColorStateList colorStateListA5 = ie.c.a(context, typedArrayK, i14);
        if (colorStateListA5 == null) {
            colorStateListA5 = i.a.a(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateListA5);
        setThumbRadius(typedArrayK.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayK.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayK.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayK.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setLabelBehavior(typedArrayK.getInt(R.styleable.Slider_labelBehavior, 0));
        if (!typedArrayK.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayK.recycle();
    }

    public void g0(@n0 L l10) {
        this.f20636l.remove(l10);
    }

    @Override // android.view.View
    @n0
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @i1
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f20629g.x();
    }

    public int getActiveThumbIndex() {
        return this.K1;
    }

    public int getFocusedThumbIndex() {
        return this.f20648v2;
    }

    @r
    public int getHaloRadius() {
        return this.A;
    }

    @n0
    public ColorStateList getHaloTintList() {
        return this.J7;
    }

    public int getLabelBehavior() {
        return this.f20649w;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.C2;
    }

    public float getThumbElevation() {
        return this.O7.x();
    }

    @r
    public int getThumbRadius() {
        return this.f20652z;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.O7.N();
    }

    public float getThumbStrokeWidth() {
        return this.O7.Q();
    }

    @n0
    public ColorStateList getThumbTintList() {
        return this.O7.y();
    }

    @n0
    public ColorStateList getTickActiveTintList() {
        return this.K7;
    }

    @n0
    public ColorStateList getTickInactiveTintList() {
        return this.L7;
    }

    @n0
    public ColorStateList getTickTintList() {
        if (this.L7.equals(this.K7)) {
            return this.K7;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @n0
    public ColorStateList getTrackActiveTintList() {
        return this.M7;
    }

    @r
    public int getTrackHeight() {
        return this.f20650x;
    }

    @n0
    public ColorStateList getTrackInactiveTintList() {
        return this.N7;
    }

    @r
    public int getTrackSidePadding() {
        return this.f20651y;
    }

    @n0
    public ColorStateList getTrackTintList() {
        if (this.N7.equals(this.M7)) {
            return this.M7;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @r
    public int getTrackWidth() {
        return this.F7;
    }

    public float getValueFrom() {
        return this.f20635k1;
    }

    public float getValueTo() {
        return this.f20647v1;
    }

    @n0
    public List<Float> getValues() {
        return new ArrayList(this.C1);
    }

    public void h(@n0 L l10) {
        this.f20636l.add(l10);
    }

    public void h0(@n0 T t10) {
        this.f20637m.remove(t10);
    }

    public void i(@n0 T t10) {
        this.f20637m.add(t10);
    }

    public final void i0(int i10) {
        BaseSlider<S, L, T>.d dVar = this.f20631i;
        if (dVar == null) {
            this.f20631i = new d(this, null);
        } else {
            removeCallbacks(dVar);
        }
        this.f20631i.a(i10);
        postDelayed(this.f20631i, 200L);
    }

    public final void j(Drawable drawable) {
        int i10 = this.f20652z * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i10, i10);
        } else {
            float fMax = i10 / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    public final void j0(qe.a aVar, float f10) {
        aVar.m1(F(f10));
        int iY = (this.f20651y + ((int) (Y(f10) * this.F7))) - (aVar.getIntrinsicWidth() / 2);
        int iO = o() - (this.B + this.f20652z);
        aVar.setBounds(iY, iO - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + iY, iO);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.d.c(b0.g(this), this, rect);
        aVar.setBounds(rect);
        b0.h(this).a(aVar);
    }

    public final void k(qe.a aVar) {
        aVar.k1(b0.g(this));
    }

    public final boolean k0() {
        return this.f20649w == 3;
    }

    @p0
    public final Float l(int i10) {
        float fN = this.H7 ? n(20) : m();
        if (i10 == 21) {
            if (!O()) {
                fN = -fN;
            }
            return Float.valueOf(fN);
        }
        if (i10 == 22) {
            if (O()) {
                fN = -fN;
            }
            return Float.valueOf(fN);
        }
        if (i10 == 69) {
            return Float.valueOf(-fN);
        }
        if (i10 == 70 || i10 == 81) {
            return Float.valueOf(fN);
        }
        return null;
    }

    public final boolean l0() {
        return this.G7 || !(getBackground() instanceof RippleDrawable);
    }

    public final float m() {
        float f10 = this.C2;
        if (f10 == 0.0f) {
            return 1.0f;
        }
        return f10;
    }

    public final boolean m0(float f10) {
        return o0(this.K1, f10);
    }

    public final float n(int i10) {
        float fM = m();
        return (this.f20647v1 - this.f20635k1) / fM <= i10 ? fM : Math.round(r1 / r4) * fM;
    }

    public final double n0(float f10) {
        float f11 = this.C2;
        if (f11 <= 0.0f) {
            return f10;
        }
        int i10 = (int) ((this.f20647v1 - this.f20635k1) / f11);
        return ((double) Math.round(f10 * i10)) / ((double) i10);
    }

    public final int o() {
        return (this.f20646v / 2) + ((this.f20649w == 1 || k0()) ? this.f20633k.get(0).getIntrinsicHeight() : 0);
    }

    public final boolean o0(int i10, float f10) {
        this.f20648v2 = i10;
        if (Math.abs(f10 - this.C1.get(i10).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.C1.set(i10, Float.valueOf(H(i10, f10)));
        v(i10);
        return true;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<qe.a> it2 = this.f20633k.iterator();
        while (it2.hasNext()) {
            k(it2.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d dVar = this.f20631i;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.f20638n = false;
        Iterator<qe.a> it2 = this.f20633k.iterator();
        while (it2.hasNext()) {
            t(it2.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@n0 Canvas canvas) {
        if (this.I7) {
            u0();
            R();
        }
        super.onDraw(canvas);
        int iO = o();
        y(canvas, this.F7, iO);
        if (((Float) Collections.max(getValues())).floatValue() > this.f20635k1) {
            x(canvas, this.F7, iO);
        }
        T(canvas);
        if ((this.K0 || isFocused() || k0()) && isEnabled()) {
            S(canvas, this.F7, iO);
            if (this.K1 != -1 || k0()) {
                B();
            } else {
                C();
            }
        } else {
            C();
        }
        A(canvas, this.F7, iO);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, @p0 Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            D(i10);
            this.f20629g.X(this.f20648v2);
        } else {
            this.K1 = -1;
            this.f20629g.o(this.f20648v2);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, @n0 KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.C1.size() == 1) {
            this.K1 = 0;
        }
        if (this.K1 == -1) {
            Boolean boolZ = Z(i10, keyEvent);
            return boolZ != null ? boolZ.booleanValue() : super.onKeyDown(i10, keyEvent);
        }
        this.H7 |= keyEvent.isLongPress();
        Float fL = l(i10);
        if (fL != null) {
            if (m0(this.C1.get(this.K1).floatValue() + fL.floatValue())) {
                r0();
                postInvalidate();
            }
            return true;
        }
        if (i10 != 23) {
            if (i10 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return W(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return W(-1);
                }
                return false;
            }
            if (i10 != 66) {
                return super.onKeyDown(i10, keyEvent);
            }
        }
        this.K1 = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, @n0 KeyEvent keyEvent) {
        this.H7 = false;
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f20646v + ((this.f20649w == 1 || k0()) ? this.f20633k.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.f20635k1 = sliderState.f20653a;
        this.f20647v1 = sliderState.f20654b;
        setValuesInternal(sliderState.f20655c);
        this.C2 = sliderState.f20656d;
        if (sliderState.f20657e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f20653a = this.f20635k1;
        sliderState.f20654b = this.f20647v1;
        sliderState.f20655c = new ArrayList<>(this.C1);
        sliderState.f20656d = this.C2;
        sliderState.f20657e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        s0(i10);
        r0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@n0 MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x10 = motionEvent.getX();
        float f10 = (x10 - this.f20651y) / this.F7;
        this.R7 = f10;
        float fMax = Math.max(0.0f, f10);
        this.R7 = fMax;
        this.R7 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = x10;
            if (!M()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (d0()) {
                    requestFocus();
                    this.K0 = true;
                    p0();
                    r0();
                    invalidate();
                    a0();
                }
            }
        } else if (actionMasked == 1) {
            this.K0 = false;
            MotionEvent motionEvent2 = this.D;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.D.getX() - motionEvent.getX()) <= this.f20641q && Math.abs(this.D.getY() - motionEvent.getY()) <= this.f20641q && d0()) {
                a0();
            }
            if (this.K1 != -1) {
                p0();
                this.K1 = -1;
                b0();
            }
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.K0) {
                if (M() && Math.abs(x10 - this.C) < this.f20641q) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                a0();
            }
            if (d0()) {
                this.K0 = true;
                p0();
                r0();
                invalidate();
            }
        }
        setPressed(this.K0);
        this.D = MotionEvent.obtain(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@n0 View view, int i10) {
        a0 a0VarH;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0 || (a0VarH = b0.h(this)) == null) {
            return;
        }
        Iterator<qe.a> it2 = this.f20633k.iterator();
        while (it2.hasNext()) {
            a0VarH.b(it2.next());
        }
    }

    public void p() {
        this.f20636l.clear();
    }

    public final boolean p0() {
        return m0(getValueOfTouchPosition());
    }

    public void q() {
        this.f20637m.clear();
    }

    public void q0(int i10, Rect rect) {
        int iY = this.f20651y + ((int) (Y(getValues().get(i10).floatValue()) * this.F7));
        int iO = o();
        int i11 = this.f20652z;
        rect.set(iY - i11, iO - i11, iY + i11, iO + i11);
    }

    public final ValueAnimator r(boolean z10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(G(z10 ? this.f20640p : this.f20639o, z10 ? 0.0f : 1.0f), z10 ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z10 ? 83L : 117L);
        valueAnimatorOfFloat.setInterpolator(z10 ? kd.a.f37170e : kd.a.f37168c);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    public final void r0() {
        if (l0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iY = (int) ((Y(this.C1.get(this.f20648v2).floatValue()) * this.F7) + this.f20651y);
            int iO = o();
            int i10 = this.A;
            n0.c.l(background, iY - i10, iO - i10, iY + i10, iO + i10);
        }
    }

    public final void s() {
        if (this.f20633k.size() > this.C1.size()) {
            List<qe.a> listSubList = this.f20633k.subList(this.C1.size(), this.f20633k.size());
            for (qe.a aVar : listSubList) {
                if (u0.O0(this)) {
                    t(aVar);
                }
            }
            listSubList.clear();
        }
        while (this.f20633k.size() < this.C1.size()) {
            qe.a aVarA = this.f20632j.a();
            this.f20633k.add(aVarA);
            if (u0.O0(this)) {
                k(aVarA);
            }
        }
        int i10 = this.f20633k.size() == 1 ? 0 : 1;
        Iterator<qe.a> it2 = this.f20633k.iterator();
        while (it2.hasNext()) {
            it2.next().I0(i10);
        }
    }

    public final void s0(int i10) {
        this.F7 = Math.max(i10 - (this.f20651y * 2), 0);
        R();
    }

    public void setActiveThumbIndex(int i10) {
        this.K1 = i10;
    }

    public void setCustomThumbDrawable(@v int i10) {
        setCustomThumbDrawable(getResources().getDrawable(i10));
    }

    public void setCustomThumbDrawablesForValues(@n0 @v int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            drawableArr[i10] = getResources().getDrawable(iArr[i10]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        setLayerType(z10 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i10) {
        if (i10 < 0 || i10 >= this.C1.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.f20648v2 = i10;
        this.f20629g.X(i10);
        postInvalidate();
    }

    public void setHaloRadius(@f0(from = 0) @r int i10) {
        if (i10 == this.A) {
            return;
        }
        this.A = i10;
        Drawable background = getBackground();
        if (l0() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            yd.a.h((RippleDrawable) background, this.A);
        }
    }

    public void setHaloRadiusResource(@q int i10) {
        setHaloRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setHaloTintList(@n0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.J7)) {
            return;
        }
        this.J7 = colorStateList;
        Drawable background = getBackground();
        if (!l0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f20626d.setColor(I(colorStateList));
        this.f20626d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i10) {
        if (this.f20649w != i10) {
            this.f20649w = i10;
            requestLayout();
        }
    }

    public void setLabelFormatter(@p0 com.google.android.material.slider.d dVar) {
        this.f20634k0 = dVar;
    }

    public void setSeparationUnit(int i10) {
        this.S7 = i10;
        this.I7 = true;
        postInvalidate();
    }

    public void setStepSize(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(String.format(Y7, Float.valueOf(f10), Float.valueOf(this.f20635k1), Float.valueOf(this.f20647v1)));
        }
        if (this.C2 != f10) {
            this.C2 = f10;
            this.I7 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f10) {
        this.O7.n0(f10);
    }

    public void setThumbElevationResource(@q int i10) {
        setThumbElevation(getResources().getDimension(i10));
    }

    public void setThumbRadius(@f0(from = 0) @r int i10) {
        if (i10 == this.f20652z) {
            return;
        }
        this.f20652z = i10;
        this.O7.setShapeAppearanceModel(o.a().q(0, this.f20652z).m());
        j jVar = this.O7;
        int i11 = this.f20652z;
        jVar.setBounds(0, 0, i11 * 2, i11 * 2);
        Drawable drawable = this.P7;
        if (drawable != null) {
            j(drawable);
        }
        Iterator<Drawable> it2 = this.Q7.iterator();
        while (it2.hasNext()) {
            j(it2.next());
        }
        t0();
    }

    public void setThumbRadiusResource(@q int i10) {
        setThumbRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setThumbStrokeColor(@p0 ColorStateList colorStateList) {
        this.O7.F0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@n int i10) {
        if (i10 != 0) {
            setThumbStrokeColor(i.a.a(getContext(), i10));
        }
    }

    public void setThumbStrokeWidth(float f10) {
        this.O7.I0(f10);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@q int i10) {
        if (i10 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i10));
        }
    }

    public void setThumbTintList(@n0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.O7.y())) {
            return;
        }
        this.O7.o0(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@n0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.K7)) {
            return;
        }
        this.K7 = colorStateList;
        this.f20628f.setColor(I(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@n0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.L7)) {
            return;
        }
        this.L7 = colorStateList;
        this.f20627e.setColor(I(colorStateList));
        invalidate();
    }

    public void setTickTintList(@n0 ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z10) {
        if (this.E7 != z10) {
            this.E7 = z10;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@n0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.M7)) {
            return;
        }
        this.M7 = colorStateList;
        this.f20624b.setColor(I(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@f0(from = 0) @r int i10) {
        if (this.f20650x != i10) {
            this.f20650x = i10;
            L();
            t0();
        }
    }

    public void setTrackInactiveTintList(@n0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.N7)) {
            return;
        }
        this.N7 = colorStateList;
        this.f20623a.setColor(I(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@n0 ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f10) {
        this.f20635k1 = f10;
        this.I7 = true;
        postInvalidate();
    }

    public void setValueTo(float f10) {
        this.f20647v1 = f10;
        this.I7 = true;
        postInvalidate();
    }

    public void setValues(@n0 Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public final void t(qe.a aVar) {
        a0 a0VarH = b0.h(this);
        if (a0VarH != null) {
            a0VarH.b(aVar);
            aVar.X0(b0.g(this));
        }
    }

    public final void t0() {
        boolean zV = V();
        boolean zU = U();
        if (zV) {
            requestLayout();
        } else if (zU) {
            postInvalidate();
        }
    }

    public final float u(float f10) {
        if (f10 == 0.0f) {
            return 0.0f;
        }
        float f11 = (f10 - this.f20651y) / this.F7;
        float f12 = this.f20635k1;
        return (f11 * (f12 - this.f20647v1)) + f12;
    }

    public final void u0() {
        if (this.I7) {
            x0();
            y0();
            w0();
            z0();
            v0();
            C0();
            this.I7 = false;
        }
    }

    public final void v(int i10) {
        Iterator<L> it2 = this.f20636l.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, this.C1.get(i10).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f20630h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        i0(i10);
    }

    public final void v0() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException(String.format(Z7, Float.valueOf(minSeparation)));
        }
        float f10 = this.C2;
        if (f10 <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.S7 != 1) {
            throw new IllegalStateException(String.format(f20612a8, Float.valueOf(minSeparation), Float.valueOf(this.C2)));
        }
        if (minSeparation < f10 || !N(minSeparation)) {
            throw new IllegalStateException(String.format(f20613b8, Float.valueOf(minSeparation), Float.valueOf(this.C2), Float.valueOf(this.C2)));
        }
    }

    public final void w() {
        for (L l10 : this.f20636l) {
            Iterator<Float> it2 = this.C1.iterator();
            while (it2.hasNext()) {
                l10.a(this, it2.next().floatValue(), false);
            }
        }
    }

    public final void w0() {
        if (this.C2 > 0.0f && !A0(this.f20647v1)) {
            throw new IllegalStateException(String.format(Y7, Float.valueOf(this.C2), Float.valueOf(this.f20635k1), Float.valueOf(this.f20647v1)));
        }
    }

    public final void x(@n0 Canvas canvas, int i10, int i11) {
        float[] activeRange = getActiveRange();
        int i12 = this.f20651y;
        float f10 = i10;
        float f11 = i11;
        canvas.drawLine(i12 + (activeRange[0] * f10), f11, i12 + (activeRange[1] * f10), f11, this.f20624b);
    }

    public final void x0() {
        if (this.f20635k1 >= this.f20647v1) {
            throw new IllegalStateException(String.format(W7, Float.valueOf(this.f20635k1), Float.valueOf(this.f20647v1)));
        }
    }

    public final void y(@n0 Canvas canvas, int i10, int i11) {
        float[] activeRange = getActiveRange();
        float f10 = i10;
        float f11 = this.f20651y + (activeRange[1] * f10);
        if (f11 < r1 + i10) {
            float f12 = i11;
            canvas.drawLine(f11, f12, r1 + i10, f12, this.f20623a);
        }
        int i12 = this.f20651y;
        float f13 = i12 + (activeRange[0] * f10);
        if (f13 > i12) {
            float f14 = i11;
            canvas.drawLine(i12, f14, f13, f14, this.f20623a);
        }
    }

    public final void y0() {
        if (this.f20647v1 <= this.f20635k1) {
            throw new IllegalStateException(String.format(X7, Float.valueOf(this.f20647v1), Float.valueOf(this.f20635k1)));
        }
    }

    public final void z(@n0 Canvas canvas, int i10, int i11, float f10, @n0 Drawable drawable) {
        canvas.save();
        canvas.translate((this.f20651y + ((int) (Y(f10) * i10))) - (drawable.getBounds().width() / 2.0f), i11 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void z0() {
        for (Float f10 : this.C1) {
            if (f10.floatValue() < this.f20635k1 || f10.floatValue() > this.f20647v1) {
                throw new IllegalStateException(String.format(U7, f10, Float.valueOf(this.f20635k1), Float.valueOf(this.f20647v1)));
            }
            if (this.C2 > 0.0f && !A0(f10.floatValue())) {
                throw new IllegalStateException(String.format(V7, f10, Float.valueOf(this.f20635k1), Float.valueOf(this.C2), Float.valueOf(this.C2)));
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20663a;

        public d() {
            this.f20663a = -1;
        }

        public void a(int i10) {
            this.f20663a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f20629g.Y(this.f20663a, 4);
        }

        public /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public void setCustomThumbDrawable(@n0 Drawable drawable) {
        this.P7 = K(drawable);
        this.Q7.clear();
        postInvalidate();
    }

    public BaseSlider(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(pe.a.c(context, attributeSet, i10, f20618g8), attributeSet, i10);
        this.f20633k = new ArrayList();
        this.f20636l = new ArrayList();
        this.f20637m = new ArrayList();
        this.f20638n = false;
        this.K0 = false;
        this.C1 = new ArrayList<>();
        this.K1 = -1;
        this.f20648v2 = -1;
        this.C2 = 0.0f;
        this.E7 = true;
        this.H7 = false;
        j jVar = new j();
        this.O7 = jVar;
        this.Q7 = Collections.emptyList();
        this.S7 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f20623a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f20624b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.f20625c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f20626d = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f20627e = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f20628f = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        Q(context2.getResources());
        this.f20632j = new a(attributeSet, i10);
        f0(context2, attributeSet, i10);
        setFocusable(true);
        setClickable(true);
        jVar.x0(2);
        this.f20641q = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.f20629g = eVar;
        u0.B1(this, eVar);
        this.f20630h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@n0 List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    public void setCustomThumbDrawablesForValues(@n0 Drawable... drawableArr) {
        this.P7 = null;
        this.Q7 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.Q7.add(K(drawable));
        }
        postInvalidate();
    }
}
