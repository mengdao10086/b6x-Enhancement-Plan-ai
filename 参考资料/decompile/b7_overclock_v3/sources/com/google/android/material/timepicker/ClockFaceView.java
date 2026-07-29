package com.google.android.material.timepicker;

import a1.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import g.c1;
import g.n0;
import g.p0;
import g.x;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
class ClockFaceView extends d implements ClockHandView.d {
    public static final float R7 = 0.001f;
    public static final int S7 = 12;
    public static final String T7 = "";
    public final Rect E7;
    public final RectF F7;
    public final SparseArray<TextView> G7;
    public final androidx.core.view.a H7;
    public final int[] I7;
    public final float[] J7;
    public final ClockHandView K2;
    public final int K7;
    public final int L7;
    public final int M7;
    public final int N7;
    public String[] O7;
    public float P7;
    public final ColorStateList Q7;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.P(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.K2.g()) - ClockFaceView.this.K7);
            return true;
        }
    }

    public class b extends androidx.core.view.a {
        public b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
            if (iIntValue > 0) {
                dVar.Y1((View) ClockFaceView.this.G7.get(iIntValue - 1));
            }
            dVar.e1(d.e.h(0, 1, iIntValue, 1, false, view.isSelected()));
            dVar.c1(true);
            dVar.b(d.a.f110j);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (i10 != 16) {
                return super.j(view, i10, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            float x10 = view.getX() + (view.getWidth() / 2.0f);
            float height = (view.getHeight() / 2.0f) + view.getY();
            ClockFaceView.this.K2.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, x10, height, 0));
            ClockFaceView.this.K2.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, x10, height, 0));
            return true;
        }
    }

    public ClockFaceView(@n0 Context context) {
        this(context, null);
    }

    public static float Y(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    @Override // com.google.android.material.timepicker.d
    public void P(int i10) {
        if (i10 != O()) {
            super.P(i10);
            this.K2.k(O());
        }
    }

    public final void W() {
        RectF rectFD = this.K2.d();
        for (int i10 = 0; i10 < this.G7.size(); i10++) {
            TextView textView = this.G7.get(i10);
            if (textView != null) {
                textView.getDrawingRect(this.E7);
                offsetDescendantRectToMyCoords(textView, this.E7);
                textView.setSelected(rectFD.contains(this.E7.centerX(), this.E7.centerY()));
                textView.getPaint().setShader(X(rectFD, this.E7, textView));
                textView.invalidate();
            }
        }
    }

    @p0
    public final RadialGradient X(RectF rectF, Rect rect, TextView textView) {
        this.F7.set(rect);
        this.F7.offset(textView.getPaddingLeft(), textView.getPaddingTop());
        if (RectF.intersects(rectF, this.F7)) {
            return new RadialGradient(rectF.centerX() - this.F7.left, rectF.centerY() - this.F7.top, rectF.width() * 0.5f, this.I7, this.J7, Shader.TileMode.CLAMP);
        }
        return null;
    }

    public final void Z(@c1 int i10) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.G7.size();
        for (int i11 = 0; i11 < Math.max(this.O7.length, size); i11++) {
            TextView textView = this.G7.get(i11);
            if (i11 >= this.O7.length) {
                removeView(textView);
                this.G7.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.G7.put(i11, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.O7[i11]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i11));
                u0.B1(textView, this.H7);
                textView.setTextColor(this.Q7);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.O7[i11]));
                }
            }
        }
    }

    public void d(String[] strArr, @c1 int i10) {
        this.O7 = strArr;
        Z(i10);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void e(float f10, boolean z10) {
        if (Math.abs(this.P7 - f10) > 0.001f) {
            this.P7 = f10;
            W();
        }
    }

    public void h(@x(from = 0.0d, to = 360.0d) float f10) {
        this.K2.l(f10);
        W();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        a1.d.g2(accessibilityNodeInfo).d1(d.C0006d.f(1, this.O7.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        W();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iY = (int) (this.N7 / Y(this.L7 / displayMetrics.heightPixels, this.M7 / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iY, 1073741824);
        setMeasuredDimension(iY, iY);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public ClockFaceView(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.E7 = new Rect();
        this.F7 = new RectF();
        this.G7 = new SparseArray<>();
        this.J7 = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = ie.c.a(context, typedArrayObtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.Q7 = colorStateListA;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.K2 = clockHandView;
        this.K7 = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.I7 = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = i.a.a(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = ie.c.a(context, typedArrayObtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.H7 = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        d(strArr, 0);
        this.L7 = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.M7 = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.N7 = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
