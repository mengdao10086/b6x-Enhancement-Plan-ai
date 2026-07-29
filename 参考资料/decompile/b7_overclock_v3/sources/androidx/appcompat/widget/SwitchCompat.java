package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.e;
import com.google.common.collect.LinkedHashMultimap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchCompat extends CompoundButton implements f0 {
    public static final int J7 = 250;
    public static final int K7 = 0;
    public static final int L7 = 1;
    public static final int M7 = 2;
    public static final String N7 = "android.widget.Switch";
    public static final int O7 = 1;
    public static final int P7 = 2;
    public static final int Q7 = 3;
    public static final Property<SwitchCompat, Float> R7 = new a(Float.class, "thumbPos");
    public static final int[] S7 = {R.attr.state_checked};
    public int A;
    public int B;
    public int C;
    public final TextPaint C1;
    public Layout C2;
    public int D;
    public ObjectAnimator E7;
    public final y F7;

    @g.n0
    public l G7;

    @g.p0
    public c H7;
    public final Rect I7;
    public int K0;
    public ColorStateList K1;

    @g.p0
    public TransformationMethod K2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f2244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f2245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f2246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f2249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f2250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2254k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f2255k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f2256k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2257l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2258m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2259n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f2260o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f2261p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f2262q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f2263r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2264s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2265t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2266u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f2267v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f2268v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public Layout f2269v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f2270w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public VelocityTracker f2271x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2272y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f2273z;

    public class a extends Property<SwitchCompat, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f2273z);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f10) {
            switchCompat.setThumbPosition(f10.floatValue());
        }
    }

    @g.v0(18)
    public static class b {
        @g.u
        public static void a(ObjectAnimator objectAnimator, boolean z10) {
            objectAnimator.setAutoCancel(z10);
        }
    }

    public static class c extends e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<SwitchCompat> f2274a;

        public c(SwitchCompat switchCompat) {
            this.f2274a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.e.f
        public void a(@g.p0 Throwable th2) {
            SwitchCompat switchCompat = this.f2274a.get();
            if (switchCompat != null) {
                switchCompat.k();
            }
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            SwitchCompat switchCompat = this.f2274a.get();
            if (switchCompat != null) {
                switchCompat.k();
            }
        }
    }

    public SwitchCompat(@g.n0 Context context) {
        this(context, null);
    }

    public static float g(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    @g.n0
    private l getEmojiTextViewHelper() {
        if (this.G7 == null) {
            this.G7 = new l(this);
        }
        return this.G7;
    }

    private boolean getTargetCheckedState() {
        return this.f2273z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((h1.b(this) ? 1.0f - this.f2273z : this.f2273z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f2249f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.I7;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f2244a;
        Rect rectD = drawable2 != null ? d0.d(drawable2) : d0.f2406c;
        return ((((this.A - this.C) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f2262q = charSequence;
        this.f2263r = h(charSequence);
        this.C2 = null;
        if (this.f2264s) {
            q();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f2260o = charSequence;
        this.f2261p = h(charSequence);
        this.f2269v2 = null;
        if (this.f2264s) {
            q();
        }
    }

    public final void a(boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, R7, z10 ? 1.0f : 0.0f);
        this.E7 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        b.a(this.E7, true);
        this.E7.start();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    public final void c() {
        Drawable drawable = this.f2244a;
        if (drawable != null) {
            if (this.f2247d || this.f2248e) {
                Drawable drawableMutate = n0.c.r(drawable).mutate();
                this.f2244a = drawableMutate;
                if (this.f2247d) {
                    n0.c.o(drawableMutate, this.f2245b);
                }
                if (this.f2248e) {
                    n0.c.p(this.f2244a, this.f2246c);
                }
                if (this.f2244a.isStateful()) {
                    this.f2244a.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        Drawable drawable = this.f2249f;
        if (drawable != null) {
            if (this.f2252i || this.f2253j) {
                Drawable drawableMutate = n0.c.r(drawable).mutate();
                this.f2249f = drawableMutate;
                if (this.f2252i) {
                    n0.c.o(drawableMutate, this.f2250g);
                }
                if (this.f2253j) {
                    n0.c.p(this.f2249f, this.f2251h);
                }
                if (this.f2249f.isStateful()) {
                    this.f2249f.setState(getDrawableState());
                }
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        int i11;
        Rect rect = this.I7;
        int i12 = this.D;
        int i13 = this.f2255k0;
        int i14 = this.K0;
        int i15 = this.f2256k1;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f2244a;
        Rect rectD = drawable != null ? d0.d(drawable) : d0.f2406c;
        Drawable drawable2 = this.f2249f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i16 = rect.left;
            thumbOffset += i16;
            if (rectD != null) {
                int i17 = rectD.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = rectD.top;
                int i19 = rect.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = rectD.right;
                int i21 = rect.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = rectD.bottom;
                int i23 = rect.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                }
                this.f2249f.setBounds(i12, i10, i14, i11);
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f2249f.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f2244a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i24 = thumbOffset - rect.left;
            int i25 = thumbOffset + this.C + rect.right;
            this.f2244a.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                n0.c.l(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f2244a;
        if (drawable != null) {
            n0.c.k(drawable, f10, f11);
        }
        Drawable drawable2 = this.f2249f;
        if (drawable2 != null) {
            n0.c.k(drawable2, f10, f11);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2244a;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f2249f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e() {
        ObjectAnimator objectAnimator = this.E7;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public final void f(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!h1.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f2258m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (h1.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f2258m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    @g.p0
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.r.G(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f2264s;
    }

    public boolean getSplitTrack() {
        return this.f2259n;
    }

    public int getSwitchMinWidth() {
        return this.f2257l;
    }

    public int getSwitchPadding() {
        return this.f2258m;
    }

    public CharSequence getTextOff() {
        return this.f2262q;
    }

    public CharSequence getTextOn() {
        return this.f2260o;
    }

    public Drawable getThumbDrawable() {
        return this.f2244a;
    }

    @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public final float getThumbPosition() {
        return this.f2273z;
    }

    public int getThumbTextPadding() {
        return this.f2254k;
    }

    @g.p0
    public ColorStateList getThumbTintList() {
        return this.f2245b;
    }

    @g.p0
    public PorterDuff.Mode getThumbTintMode() {
        return this.f2246c;
    }

    public Drawable getTrackDrawable() {
        return this.f2249f;
    }

    @g.p0
    public ColorStateList getTrackTintList() {
        return this.f2250g;
    }

    @g.p0
    public PorterDuff.Mode getTrackTintMode() {
        return this.f2251h;
    }

    @g.p0
    public final CharSequence h(@g.p0 CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.K2);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    public final boolean i(float f10, float f11) {
        if (this.f2244a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2244a.getPadding(this.I7);
        int i10 = this.f2255k0;
        int i11 = this.f2266u;
        int i12 = i10 - i11;
        int i13 = (this.D + thumbOffset) - i11;
        int i14 = this.C + i13;
        Rect rect = this.I7;
        return f10 > ((float) i13) && f10 < ((float) (((i14 + rect.left) + rect.right) + i11)) && f11 > ((float) i12) && f11 < ((float) (this.f2256k1 + i11));
    }

    public final Layout j(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.C1, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2244a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2249f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.E7;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.E7.end();
        this.E7 = null;
    }

    public void k() {
        setTextOnInternal(this.f2260o);
        setTextOffInternal(this.f2262q);
        requestLayout();
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f2262q;
            if (string == null) {
                string = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
            }
            androidx.core.view.u0.q2(this, string);
        }
    }

    public final void m() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f2260o;
            if (string == null) {
                string = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
            }
            androidx.core.view.u0.q2(this, string);
        }
    }

    public void n(Context context, int i10) {
        y0 y0VarE = y0.E(context, i10, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList colorStateListD = y0VarE.d(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (colorStateListD != null) {
            this.K1 = colorStateListD;
        } else {
            this.K1 = getTextColors();
        }
        int iG = y0VarE.g(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (iG != 0) {
            float f10 = iG;
            if (f10 != this.C1.getTextSize()) {
                this.C1.setTextSize(f10);
                requestLayout();
            }
        }
        p(y0VarE.o(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), y0VarE.o(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (y0VarE.a(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.K2 = new k.a(getContext());
        } else {
            this.K2 = null;
        }
        setTextOnInternal(this.f2260o);
        setTextOffInternal(this.f2262q);
        y0VarE.I();
    }

    public void o(Typeface typeface, int i10) {
        if (i10 <= 0) {
            this.C1.setFakeBoldText(false);
            this.C1.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i11 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i10;
            this.C1.setFakeBoldText((i11 & 1) != 0);
            this.C1.setTextSkewX((i11 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(iArrOnCreateDrawableState, S7);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.I7;
        Drawable drawable = this.f2249f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i10 = this.f2255k0;
        int i11 = this.f2256k1;
        int i12 = i10 + rect.top;
        int i13 = i11 - rect.bottom;
        Drawable drawable2 = this.f2244a;
        if (drawable != null) {
            if (!this.f2259n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = d0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f2269v2 : this.C2;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.K1;
            if (colorStateList != null) {
                this.C1.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.C1.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i12 + i13) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(N7);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(N7);
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f2260o : this.f2262q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            sb2.append(zc.f.f58383m);
            sb2.append(charSequence);
            accessibilityNodeInfo.setText(sb2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iMax;
        int width;
        int paddingLeft;
        int i14;
        int paddingTop;
        int height;
        super.onLayout(z10, i10, i11, i12, i13);
        int iMax2 = 0;
        if (this.f2244a != null) {
            Rect rect = this.I7;
            Drawable drawable = this.f2249f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = d0.d(this.f2244a);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (h1.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i14 = this.B;
            paddingTop = paddingTop2 - (i14 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.B;
                this.D = paddingLeft;
                this.f2255k0 = paddingTop;
                this.f2256k1 = height;
                this.K0 = width;
            }
            paddingTop = getPaddingTop();
            i14 = this.B;
        }
        height = i14 + paddingTop;
        this.D = paddingLeft;
        this.f2255k0 = paddingTop;
        this.f2256k1 = height;
        this.K0 = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f2264s) {
            if (this.f2269v2 == null) {
                this.f2269v2 = j(this.f2261p);
            }
            if (this.C2 == null) {
                this.C2 = j(this.f2263r);
            }
        }
        Rect rect = this.I7;
        Drawable drawable = this.f2244a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f2244a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f2244a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.C = Math.max(this.f2264s ? Math.max(this.f2269v2.getWidth(), this.C2.getWidth()) + (this.f2254k * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f2249f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f2249f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f2244a;
        if (drawable3 != null) {
            Rect rectD = d0.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = this.f2268v1 ? Math.max(this.f2257l, (this.C * 2) + iMax + iMax2) : this.f2257l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.A = iMax3;
        this.B = iMax4;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f2260o : this.f2262q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f2271x
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9f
            r2 = 2
            if (r0 == r1) goto L8b
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8b
            goto Lb9
        L16:
            int r0 = r6.f2265t
            if (r0 == r1) goto L57
            if (r0 == r2) goto L1e
            goto Lb9
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f2267v
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3d
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L39
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3d
        L39:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3d:
            boolean r0 = androidx.appcompat.widget.h1.b(r6)
            if (r0 == 0) goto L44
            float r2 = -r2
        L44:
            float r0 = r6.f2273z
            float r0 = r0 + r2
            float r0 = g(r0, r4, r3)
            float r2 = r6.f2273z
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L56
            r6.f2267v = r7
            r6.setThumbPosition(r0)
        L56:
            return r1
        L57:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f2267v
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f2266u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7d
            float r4 = r6.f2270w
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f2266u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb9
        L7d:
            r6.f2265t = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f2267v = r0
            r6.f2270w = r3
            return r1
        L8b:
            int r0 = r6.f2265t
            if (r0 != r2) goto L96
            r6.r(r7)
            super.onTouchEvent(r7)
            return r1
        L96:
            r0 = 0
            r6.f2265t = r0
            android.view.VelocityTracker r0 = r6.f2271x
            r0.clear()
            goto Lb9
        L9f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb9
            boolean r3 = r6.i(r0, r2)
            if (r3 == 0) goto Lb9
            r6.f2265t = r1
            r6.f2267v = r0
            r6.f2270w = r2
        Lb9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i10, int i11) {
        o(i10 != 1 ? i10 != 2 ? i10 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i11);
    }

    public final void q() {
        if (this.H7 == null && this.G7.b() && androidx.emoji2.text.e.n()) {
            androidx.emoji2.text.e eVarB = androidx.emoji2.text.e.b();
            int iF = eVarB.f();
            if (iF == 3 || iF == 0) {
                c cVar = new c(this);
                this.H7 = cVar;
                eVarB.y(cVar);
            }
        }
    }

    public final void r(MotionEvent motionEvent) {
        this.f2265t = 0;
        boolean targetCheckedState = true;
        boolean z10 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z10) {
            this.f2271x.computeCurrentVelocity(1000);
            float xVelocity = this.f2271x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f2272y) {
                targetCheckedState = getTargetCheckedState();
            } else if (!h1.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        f(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            m();
        } else {
            l();
        }
        if (getWindowToken() != null && androidx.core.view.u0.U0(this)) {
            a(zIsChecked);
        } else {
            e();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@g.p0 ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.r.H(this, callback));
    }

    @Override // androidx.appcompat.widget.f0
    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
        setTextOnInternal(this.f2260o);
        setTextOffInternal(this.f2262q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z10) {
        this.f2268v1 = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@g.n0 InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f2264s != z10) {
            this.f2264s = z10;
            requestLayout();
            if (z10) {
                q();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f2259n = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f2257l = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f2258m = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.C1.getTypeface() == null || this.C1.getTypeface().equals(typeface)) && (this.C1.getTypeface() != null || typeface == null)) {
            return;
        }
        this.C1.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        l();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            m();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2244a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2244a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f10) {
        this.f2273z = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(i.a.b(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f2254k = i10;
        requestLayout();
    }

    public void setThumbTintList(@g.p0 ColorStateList colorStateList) {
        this.f2245b = colorStateList;
        this.f2247d = true;
        c();
    }

    public void setThumbTintMode(@g.p0 PorterDuff.Mode mode) {
        this.f2246c = mode;
        this.f2248e = true;
        c();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2249f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2249f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(i.a.b(getContext(), i10));
    }

    public void setTrackTintList(@g.p0 ColorStateList colorStateList) {
        this.f2250g = colorStateList;
        this.f2252i = true;
        d();
    }

    public void setTrackTintMode(@g.p0 PorterDuff.Mode mode) {
        this.f2251h = mode;
        this.f2253j = true;
        d();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2244a || drawable == this.f2249f;
    }

    public SwitchCompat(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2245b = null;
        this.f2246c = null;
        this.f2247d = false;
        this.f2248e = false;
        this.f2250g = null;
        this.f2251h = null;
        this.f2252i = false;
        this.f2253j = false;
        this.f2271x = VelocityTracker.obtain();
        this.f2268v1 = true;
        this.I7 = new Rect();
        t0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.C1 = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = androidx.appcompat.R.styleable.SwitchCompat;
        y0 y0VarG = y0.G(context, attributeSet, iArr, i10, 0);
        androidx.core.view.u0.z1(this, context, iArr, attributeSet, y0VarG.B(), i10, 0);
        Drawable drawableH = y0VarG.h(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f2244a = drawableH;
        if (drawableH != null) {
            drawableH.setCallback(this);
        }
        Drawable drawableH2 = y0VarG.h(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f2249f = drawableH2;
        if (drawableH2 != null) {
            drawableH2.setCallback(this);
        }
        setTextOnInternal(y0VarG.x(androidx.appcompat.R.styleable.SwitchCompat_android_textOn));
        setTextOffInternal(y0VarG.x(androidx.appcompat.R.styleable.SwitchCompat_android_textOff));
        this.f2264s = y0VarG.a(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.f2254k = y0VarG.g(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f2257l = y0VarG.g(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f2258m = y0VarG.g(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f2259n = y0VarG.a(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListD = y0VarG.d(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateListD != null) {
            this.f2245b = colorStateListD;
            this.f2247d = true;
        }
        PorterDuff.Mode modeE = d0.e(y0VarG.o(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f2246c != modeE) {
            this.f2246c = modeE;
            this.f2248e = true;
        }
        if (this.f2247d || this.f2248e) {
            c();
        }
        ColorStateList colorStateListD2 = y0VarG.d(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateListD2 != null) {
            this.f2250g = colorStateListD2;
            this.f2252i = true;
        }
        PorterDuff.Mode modeE2 = d0.e(y0VarG.o(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f2251h != modeE2) {
            this.f2251h = modeE2;
            this.f2253j = true;
        }
        if (this.f2252i || this.f2253j) {
            d();
        }
        int iU = y0VarG.u(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (iU != 0) {
            n(context, iU);
        }
        y yVar = new y(this);
        this.F7 = yVar;
        yVar.m(attributeSet, i10);
        y0VarG.I();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2266u = viewConfiguration.getScaledTouchSlop();
        this.f2272y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i10);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
