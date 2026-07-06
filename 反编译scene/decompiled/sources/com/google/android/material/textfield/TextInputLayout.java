package com.google.android.material.textfield;

import a.ak;
import a.av;
import a.bv;
import a.dv;
import a.dy;
import a.e20;
import a.e7;
import a.eg;
import a.eh;
import a.f20;
import a.fv;
import a.gy;
import a.h20;
import a.hv;
import a.iv;
import a.iw;
import a.iz;
import a.jv;
import a.k20;
import a.kd;
import a.kv;
import a.ni;
import a.ny;
import a.nz;
import a.o8;
import a.oj;
import a.p20;
import a.q10;
import a.q20;
import a.qx;
import a.r10;
import a.r2;
import a.r20;
import a.rf;
import a.rx;
import a.s10;
import a.te;
import a.v5;
import a.w6;
import a.yb;
import a.zu;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int x = iv.Widget_Design_TextInputLayout;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h20 f4725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public iz f4726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nz f4727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qx f4728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f4729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f4730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f4731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f4733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f4734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<f20> f4736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnLongClickListener f4737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EditText f4738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FrameLayout f4739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinearLayout f4740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f4741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CheckableImageButton f4742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f4743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedHashSet<f> f4744a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public iz f4745b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f4746b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public PorterDuff.Mode f4747b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f4748b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f4749b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View.OnLongClickListener f4750b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final FrameLayout f4751b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final LinearLayout f4752b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f4753b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final CheckableImageButton f4754b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f4755b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final LinkedHashSet<g> f4756b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4757b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ColorStateList f4758c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Drawable f4759c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public View.OnLongClickListener f4760c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final TextView f4761c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final CheckableImageButton f4762c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f4763c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4764c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ColorStateList f4765d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final TextView f4766d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public CharSequence f4767d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4768d;
    public final int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public ColorStateList f4769e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public CharSequence f4770e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4771e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public ColorStateList f4772f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4773f;
    public final int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public ColorStateList f4774g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4775g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public ColorStateList f4776h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4777h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public ColorStateList f4778i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4779i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f4780j;
    public int k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f4781k;
    public int l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public boolean f4782l;
    public int m;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public boolean f4783m;
    public int n;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public boolean f4784n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.o0(!r0.f4784n);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f4757b) {
                textInputLayout.g0(editable.length());
            }
            if (TextInputLayout.this.f4768d) {
                TextInputLayout.this.s0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f4754b.performClick();
            TextInputLayout.this.f4754b.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f4738a.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f4728a.V(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends rf {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextInputLayout f8336a;

        public e(TextInputLayout textInputLayout) {
            this.f8336a = textInputLayout;
        }

        @Override // a.rf
        public void g(View view, ni niVar) {
            super.g(view, niVar);
            EditText editText = this.f8336a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f8336a.getHint();
            CharSequence helperText = this.f8336a.getHelperText();
            CharSequence error = this.f8336a.getError();
            int counterMaxLength = this.f8336a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f8336a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(helperText);
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z2 ? hint.toString() : "";
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(((z4 || z3) && !TextUtils.isEmpty(string)) ? ", " : "");
            String string2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string2);
            if (z4) {
                helperText = error;
            } else if (!z3) {
                helperText = "";
            }
            sb2.append((Object) helperText);
            String string3 = sb2.toString();
            if (z) {
                niVar.A0(text);
            } else if (!TextUtils.isEmpty(string3)) {
                niVar.A0(string3);
            }
            if (!TextUtils.isEmpty(string3)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    niVar.l0(string3);
                } else {
                    if (z) {
                        string3 = ((Object) text) + ", " + string3;
                    }
                    niVar.A0(string3);
                }
                niVar.w0(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            niVar.n0(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                niVar.h0(error);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    public static class h extends ak {
        public static final Parcelable.Creator<h> CREATOR = new q20();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f8337a;
        public boolean b;

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8337a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.b = parcel.readInt() == 1;
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f8337a) + "}";
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f8337a, parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        int colorForState;
        super(r20.c(context, attributeSet, i, x), attributeSet, i);
        this.f4725a = new h20(this);
        this.f4732a = new Rect();
        this.f4748b = new Rect();
        this.f4733a = new RectF();
        this.f4744a = new LinkedHashSet<>();
        this.n = 0;
        this.f4736a = new SparseArray<>();
        this.f4756b = new LinkedHashSet<>();
        this.f4728a = new qx(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f4739a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.f4739a);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f4740a = linearLayout;
        linearLayout.setOrientation(0);
        this.f4740a.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        this.f4739a.addView(this.f4740a);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f4752b = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f4752b.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        this.f4739a.addView(this.f4752b);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f4751b = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.f4728a.a0(kv.f6644a);
        this.f4728a.X(kv.f6644a);
        this.f4728a.L(8388659);
        o8 o8VarI = dy.i(context2, attributeSet, jv.TextInputLayout, i, x, jv.TextInputLayout_counterTextAppearance, jv.TextInputLayout_counterOverflowTextAppearance, jv.TextInputLayout_errorTextAppearance, jv.TextInputLayout_helperTextTextAppearance, jv.TextInputLayout_hintTextAppearance);
        this.f4771e = o8VarI.a(jv.TextInputLayout_hintEnabled, true);
        setHint(o8VarI.p(jv.TextInputLayout_android_hint));
        this.f4782l = o8VarI.a(jv.TextInputLayout_hintAnimationEnabled, true);
        this.f4727a = nz.c(context2, attributeSet, i, x).m();
        this.e = context2.getResources().getDimensionPixelOffset(bv.mtrl_textinput_box_label_cutout_padding);
        this.g = o8VarI.e(jv.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.i = o8VarI.f(jv.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(bv.mtrl_textinput_box_stroke_width_default));
        this.j = o8VarI.f(jv.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(bv.mtrl_textinput_box_stroke_width_focused));
        this.h = this.i;
        float fD = o8VarI.d(jv.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fD2 = o8VarI.d(jv.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fD3 = o8VarI.d(jv.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fD4 = o8VarI.d(jv.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        nz.a aVarT = this.f4727a.t();
        if (fD >= 0.0f) {
            aVarT.z(fD);
        }
        if (fD2 >= 0.0f) {
            aVarT.D(fD2);
        }
        if (fD3 >= 0.0f) {
            aVarT.v(fD3);
        }
        if (fD4 >= 0.0f) {
            aVarT.r(fD4);
        }
        this.f4727a = aVarT.m();
        ColorStateList colorStateListB = ny.b(context2, o8VarI, jv.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.s = defaultColor;
            this.l = defaultColor;
            if (colorStateListB.isStateful()) {
                this.t = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.u = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                colorForState = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.u = this.s;
                ColorStateList colorStateListC = r2.c(context2, av.mtrl_filled_background_color);
                this.t = colorStateListC.getColorForState(new int[]{-16842910}, -1);
                colorForState = colorStateListC.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
            this.v = colorForState;
        } else {
            this.l = 0;
            this.s = 0;
            this.t = 0;
            this.u = 0;
            this.v = 0;
        }
        if (o8VarI.s(jv.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListC2 = o8VarI.c(jv.TextInputLayout_android_textColorHint);
            this.f4776h = colorStateListC2;
            this.f4774g = colorStateListC2;
        }
        ColorStateList colorStateListB2 = ny.b(context2, o8VarI, jv.TextInputLayout_boxStrokeColor);
        this.r = o8VarI.b(jv.TextInputLayout_boxStrokeColor, 0);
        this.p = yb.b(context2, av.mtrl_textinput_default_box_stroke_color);
        this.w = yb.b(context2, av.mtrl_textinput_disabled_color);
        this.q = yb.b(context2, av.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        if (o8VarI.s(jv.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(ny.b(context2, o8VarI, jv.TextInputLayout_boxStrokeErrorColor));
        }
        if (o8VarI.n(jv.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(o8VarI.n(jv.TextInputLayout_hintTextAppearance, 0));
        }
        int iN = o8VarI.n(jv.TextInputLayout_errorTextAppearance, 0);
        CharSequence charSequenceP = o8VarI.p(jv.TextInputLayout_errorContentDescription);
        boolean zA = o8VarI.a(jv.TextInputLayout_errorEnabled, false);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(fv.design_text_input_end_icon, (ViewGroup) this.f4752b, false);
        this.f4762c = checkableImageButton;
        checkableImageButton.setVisibility(8);
        if (o8VarI.s(jv.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(o8VarI.g(jv.TextInputLayout_errorIconDrawable));
        }
        if (o8VarI.s(jv.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(ny.b(context2, o8VarI, jv.TextInputLayout_errorIconTint));
        }
        if (o8VarI.s(jv.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(gy.e(o8VarI.k(jv.TextInputLayout_errorIconTintMode, -1), null));
        }
        this.f4762c.setContentDescription(getResources().getText(hv.error_icon_content_description));
        eh.t0(this.f4762c, 2);
        this.f4762c.setClickable(false);
        this.f4762c.setPressable(false);
        this.f4762c.setFocusable(false);
        int iN2 = o8VarI.n(jv.TextInputLayout_helperTextTextAppearance, 0);
        boolean zA2 = o8VarI.a(jv.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceP2 = o8VarI.p(jv.TextInputLayout_helperText);
        int iN3 = o8VarI.n(jv.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence charSequenceP3 = o8VarI.p(jv.TextInputLayout_placeholderText);
        int iN4 = o8VarI.n(jv.TextInputLayout_prefixTextAppearance, 0);
        CharSequence charSequenceP4 = o8VarI.p(jv.TextInputLayout_prefixText);
        int iN5 = o8VarI.n(jv.TextInputLayout_suffixTextAppearance, 0);
        CharSequence charSequenceP5 = o8VarI.p(jv.TextInputLayout_suffixText);
        boolean zA3 = o8VarI.a(jv.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(o8VarI.k(jv.TextInputLayout_counterMaxLength, -1));
        this.c = o8VarI.n(jv.TextInputLayout_counterTextAppearance, 0);
        this.b = o8VarI.n(jv.TextInputLayout_counterOverflowTextAppearance, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(fv.design_text_input_start_icon, (ViewGroup) this.f4740a, false);
        this.f4742a = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (o8VarI.s(jv.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(o8VarI.g(jv.TextInputLayout_startIconDrawable));
            if (o8VarI.s(jv.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(o8VarI.p(jv.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(o8VarI.a(jv.TextInputLayout_startIconCheckable, true));
        }
        if (o8VarI.s(jv.TextInputLayout_startIconTint)) {
            setStartIconTintList(ny.b(context2, o8VarI, jv.TextInputLayout_startIconTint));
        }
        if (o8VarI.s(jv.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(gy.e(o8VarI.k(jv.TextInputLayout_startIconTintMode, -1), null));
        }
        setBoxBackgroundMode(o8VarI.k(jv.TextInputLayout_boxBackgroundMode, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(fv.design_text_input_end_icon, (ViewGroup) this.f4751b, false);
        this.f4754b = checkableImageButton3;
        this.f4751b.addView(checkableImageButton3);
        this.f4754b.setVisibility(8);
        this.f4736a.append(-1, new r10(this));
        this.f4736a.append(0, new k20(this));
        this.f4736a.append(1, new p20(this));
        this.f4736a.append(2, new q10(this));
        this.f4736a.append(3, new e20(this));
        if (o8VarI.s(jv.TextInputLayout_endIconMode)) {
            setEndIconMode(o8VarI.k(jv.TextInputLayout_endIconMode, 0));
            if (o8VarI.s(jv.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(o8VarI.g(jv.TextInputLayout_endIconDrawable));
            }
            if (o8VarI.s(jv.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(o8VarI.p(jv.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(o8VarI.a(jv.TextInputLayout_endIconCheckable, true));
        } else if (o8VarI.s(jv.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(o8VarI.a(jv.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(o8VarI.g(jv.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(o8VarI.p(jv.TextInputLayout_passwordToggleContentDescription));
            if (o8VarI.s(jv.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(ny.b(context2, o8VarI, jv.TextInputLayout_passwordToggleTint));
            }
            if (o8VarI.s(jv.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(gy.e(o8VarI.k(jv.TextInputLayout_passwordToggleTintMode, -1), null));
            }
        }
        if (!o8VarI.s(jv.TextInputLayout_passwordToggleEnabled)) {
            if (o8VarI.s(jv.TextInputLayout_endIconTint)) {
                setEndIconTintList(ny.b(context2, o8VarI, jv.TextInputLayout_endIconTint));
            }
            if (o8VarI.s(jv.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(gy.e(o8VarI.k(jv.TextInputLayout_endIconTintMode, -1), null));
            }
        }
        w6 w6Var = new w6(context2);
        this.f4761c = w6Var;
        w6Var.setId(dv.textinput_prefix_text);
        this.f4761c.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        eh.l0(this.f4761c, 1);
        this.f4740a.addView(this.f4742a);
        this.f4740a.addView(this.f4761c);
        w6 w6Var2 = new w6(context2);
        this.f4766d = w6Var2;
        w6Var2.setId(dv.textinput_suffix_text);
        this.f4766d.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        eh.l0(this.f4766d, 1);
        this.f4752b.addView(this.f4766d);
        this.f4752b.addView(this.f4762c);
        this.f4752b.addView(this.f4751b);
        setHelperTextEnabled(zA2);
        setHelperText(charSequenceP2);
        setHelperTextTextAppearance(iN2);
        setErrorEnabled(zA);
        setErrorTextAppearance(iN);
        setErrorContentDescription(charSequenceP);
        setCounterTextAppearance(this.c);
        setCounterOverflowTextAppearance(this.b);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        setPrefixText(charSequenceP4);
        setPrefixTextAppearance(iN4);
        setSuffixText(charSequenceP5);
        setSuffixTextAppearance(iN5);
        if (o8VarI.s(jv.TextInputLayout_errorTextColor)) {
            setErrorTextColor(o8VarI.c(jv.TextInputLayout_errorTextColor));
        }
        if (o8VarI.s(jv.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(o8VarI.c(jv.TextInputLayout_helperTextTextColor));
        }
        if (o8VarI.s(jv.TextInputLayout_hintTextColor)) {
            setHintTextColor(o8VarI.c(jv.TextInputLayout_hintTextColor));
        }
        if (o8VarI.s(jv.TextInputLayout_counterTextColor)) {
            setCounterTextColor(o8VarI.c(jv.TextInputLayout_counterTextColor));
        }
        if (o8VarI.s(jv.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(o8VarI.c(jv.TextInputLayout_counterOverflowTextColor));
        }
        if (o8VarI.s(jv.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(o8VarI.c(jv.TextInputLayout_placeholderTextColor));
        }
        if (o8VarI.s(jv.TextInputLayout_prefixTextColor)) {
            setPrefixTextColor(o8VarI.c(jv.TextInputLayout_prefixTextColor));
        }
        if (o8VarI.s(jv.TextInputLayout_suffixTextColor)) {
            setSuffixTextColor(o8VarI.c(jv.TextInputLayout_suffixTextColor));
        }
        setCounterEnabled(zA3);
        setEnabled(o8VarI.a(jv.TextInputLayout_android_enabled, true));
        o8VarI.w();
        eh.t0(this, 2);
    }

    public static void S(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                S((ViewGroup) childAt, z);
            }
        }
    }

    public static void V(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zL = eh.L(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = zL || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zL);
        checkableImageButton.setPressable(zL);
        checkableImageButton.setLongClickable(z);
        eh.t0(checkableImageButton, z2 ? 1 : 2);
    }

    public static void W(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        V(checkableImageButton, onLongClickListener);
    }

    public static void X(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        V(checkableImageButton, onLongClickListener);
    }

    private f20 getEndIconDelegate() {
        f20 f20Var = this.f4736a.get(this.n);
        return f20Var != null ? f20Var : this.f4736a.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f4762c.getVisibility() == 0) {
            return this.f4762c;
        }
        if (H() && J()) {
            return this.f4754b;
        }
        return null;
    }

    public static void h0(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? hv.character_counter_overflowed_content_description : hv.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private void setEditText(EditText editText) {
        if (this.f4738a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.n != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f4738a = editText;
        Q();
        setTextInputAccessibilityDelegate(new e(this));
        this.f4728a.b0(this.f4738a.getTypeface());
        this.f4728a.T(this.f4738a.getTextSize());
        int gravity = this.f4738a.getGravity();
        this.f4728a.L((gravity & (-113)) | 48);
        this.f4728a.S(gravity);
        this.f4738a.addTextChangedListener(new a());
        if (this.f4774g == null) {
            this.f4774g = this.f4738a.getHintTextColors();
        }
        if (this.f4771e) {
            if (TextUtils.isEmpty(this.f4770e)) {
                CharSequence hint = this.f4738a.getHint();
                this.f4743a = hint;
                setHint(hint);
                this.f4738a.setHint((CharSequence) null);
            }
            this.f4773f = true;
        }
        if (this.f4741a != null) {
            g0(this.f4738a.getText().length());
        }
        k0();
        this.f4725a.e();
        this.f4740a.bringToFront();
        this.f4752b.bringToFront();
        this.f4751b.bringToFront();
        this.f4762c.bringToFront();
        A();
        t0();
        w0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        p0(false, true);
    }

    private void setErrorIconVisible(boolean z) {
        this.f4762c.setVisibility(z ? 0 : 8);
        this.f4751b.setVisibility(z ? 8 : 0);
        w0();
        if (H()) {
            return;
        }
        j0();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f4770e)) {
            return;
        }
        this.f4770e = charSequence;
        this.f4728a.Z(charSequence);
        if (this.f4781k) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.f4768d == z) {
            return;
        }
        if (z) {
            w6 w6Var = new w6(getContext());
            this.f4753b = w6Var;
            w6Var.setId(dv.textinput_placeholder);
            eh.l0(this.f4753b, 1);
            setPlaceholderTextAppearance(this.d);
            setPlaceholderTextColor(this.f4730a);
            g();
        } else {
            T();
            this.f4753b = null;
        }
        this.f4768d = z;
    }

    public final void A() {
        Iterator<f> it = this.f4744a.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final void B(int i) {
        Iterator<g> it = this.f4756b.iterator();
        while (it.hasNext()) {
            it.next().a(this, i);
        }
    }

    public final void C(Canvas canvas) {
        iz izVar = this.f4745b;
        if (izVar != null) {
            Rect bounds = izVar.getBounds();
            bounds.top = bounds.bottom - this.h;
            this.f4745b.draw(canvas);
        }
    }

    public final void D(Canvas canvas) {
        if (this.f4771e) {
            this.f4728a.j(canvas);
        }
    }

    public final void E(boolean z) {
        ValueAnimator valueAnimator = this.f4729a;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f4729a.cancel();
        }
        if (z && this.f4782l) {
            h(0.0f);
        } else {
            this.f4728a.V(0.0f);
        }
        if (z() && ((s10) this.f4726a).h0()) {
            x();
        }
        this.f4781k = true;
        I();
        u0();
        x0();
    }

    public final int F(int i, boolean z) {
        int compoundPaddingLeft = i + this.f4738a.getCompoundPaddingLeft();
        return (this.f4763c == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.f4761c.getMeasuredWidth()) + this.f4761c.getPaddingLeft();
    }

    public final int G(int i, boolean z) {
        int compoundPaddingRight = i - this.f4738a.getCompoundPaddingRight();
        return (this.f4763c == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.f4761c.getMeasuredWidth() - this.f4761c.getPaddingRight());
    }

    public final boolean H() {
        return this.n != 0;
    }

    public final void I() {
        TextView textView = this.f4753b;
        if (textView == null || !this.f4768d) {
            return;
        }
        textView.setText((CharSequence) null);
        this.f4753b.setVisibility(4);
    }

    public boolean J() {
        return this.f4751b.getVisibility() == 0 && this.f4754b.getVisibility() == 0;
    }

    public final boolean K() {
        return this.f4762c.getVisibility() == 0;
    }

    public boolean L() {
        return this.f4725a.x();
    }

    public final boolean M() {
        return this.f4781k;
    }

    public boolean N() {
        return this.f4773f;
    }

    public final boolean O() {
        return this.f == 1 && (Build.VERSION.SDK_INT < 16 || this.f4738a.getMinLines() <= 1);
    }

    public boolean P() {
        return this.f4742a.getVisibility() == 0;
    }

    public final void Q() {
        o();
        U();
        y0();
        if (this.f != 0) {
            n0();
        }
    }

    public final void R() {
        if (z()) {
            RectF rectF = this.f4733a;
            this.f4728a.m(rectF, this.f4738a.getWidth(), this.f4738a.getGravity());
            k(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            ((s10) this.f4726a).n0(rectF);
        }
    }

    public final void T() {
        TextView textView = this.f4753b;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void U() {
        if (b0()) {
            eh.m0(this.f4738a, this.f4726a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Y(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            a.oj.q(r3, r4)     // Catch: java.lang.Exception -> L1a
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1a
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1a
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1a
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1a
        L18:
            r4 = 0
            r0 = r4
        L1a:
            if (r0 == 0) goto L2e
            int r4 = a.iv.TextAppearance_AppCompat_Caption
            a.oj.q(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = a.av.design_error
            int r4 = a.yb.b(r4, r0)
            r3.setTextColor(r4)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.Y(android.widget.TextView, int):void");
    }

    public final boolean Z() {
        return (this.f4762c.getVisibility() == 0 || ((H() && J()) || this.f4767d != null)) && this.f4752b.getMeasuredWidth() > 0;
    }

    public final boolean a0() {
        return !(getStartIconDrawable() == null && this.f4763c == null) && this.f4740a.getMeasuredWidth() > 0;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f4739a.addView(view, layoutParams2);
        this.f4739a.setLayoutParams(layoutParams);
        n0();
        setEditText((EditText) view);
    }

    public final boolean b0() {
        EditText editText = this.f4738a;
        return (editText == null || this.f4726a == null || editText.getBackground() != null || this.f == 0) ? false : true;
    }

    public final void c0() {
        TextView textView = this.f4753b;
        if (textView == null || !this.f4768d) {
            return;
        }
        textView.setText(this.f4755b);
        this.f4753b.setVisibility(0);
        this.f4753b.bringToFront();
    }

    public final void d0(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            l();
            return;
        }
        Drawable drawableMutate = kd.r(getEndIconDrawable()).mutate();
        kd.n(drawableMutate, this.f4725a.o());
        this.f4754b.setImageDrawable(drawableMutate);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText;
        if (this.f4743a == null || (editText = this.f4738a) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.f4773f;
        this.f4773f = false;
        CharSequence hint = editText.getHint();
        this.f4738a.setHint(this.f4743a);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.f4738a.setHint(hint);
            this.f4773f = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f4784n = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f4784n = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        D(canvas);
        C(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f4783m) {
            return;
        }
        this.f4783m = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        qx qxVar = this.f4728a;
        boolean zY = qxVar != null ? qxVar.Y(drawableState) | false : false;
        if (this.f4738a != null) {
            o0(eh.Q(this) && isEnabled());
        }
        k0();
        y0();
        if (zY) {
            invalidate();
        }
        this.f4783m = false;
    }

    public void e(f fVar) {
        this.f4744a.add(fVar);
        if (this.f4738a != null) {
            fVar.a(this);
        }
    }

    public final void e0(Rect rect) {
        iz izVar = this.f4745b;
        if (izVar != null) {
            int i = rect.bottom;
            izVar.setBounds(rect.left, i - this.j, rect.right, i);
        }
    }

    public void f(g gVar) {
        this.f4756b.add(gVar);
    }

    public final void f0() {
        if (this.f4741a != null) {
            EditText editText = this.f4738a;
            g0(editText == null ? 0 : editText.getText().length());
        }
    }

    public final void g() {
        TextView textView = this.f4753b;
        if (textView != null) {
            this.f4739a.addView(textView);
            this.f4753b.setVisibility(0);
        }
    }

    public void g0(int i) {
        boolean z = this.f4764c;
        int i2 = this.f8331a;
        if (i2 == -1) {
            this.f4741a.setText(String.valueOf(i));
            this.f4741a.setContentDescription(null);
            this.f4764c = false;
        } else {
            this.f4764c = i > i2;
            h0(getContext(), this.f4741a, i, this.f8331a, this.f4764c);
            if (z != this.f4764c) {
                i0();
            }
            this.f4741a.setText(te.c().j(getContext().getString(hv.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.f8331a))));
        }
        if (this.f4738a == null || z == this.f4764c) {
            return;
        }
        o0(false);
        y0();
        k0();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f4738a;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    public iz getBoxBackground() {
        int i = this.f;
        if (i == 1 || i == 2) {
            return this.f4726a;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.l;
    }

    public int getBoxBackgroundMode() {
        return this.f;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.f4726a.s();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.f4726a.t();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.f4726a.E();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.f4726a.D();
    }

    public int getBoxStrokeColor() {
        return this.r;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f4778i;
    }

    public int getBoxStrokeWidth() {
        return this.i;
    }

    public int getBoxStrokeWidthFocused() {
        return this.j;
    }

    public int getCounterMaxLength() {
        return this.f8331a;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f4757b && this.f4764c && (textView = this.f4741a) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f4746b;
    }

    public ColorStateList getCounterTextColor() {
        return this.f4746b;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f4774g;
    }

    public EditText getEditText() {
        return this.f4738a;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f4754b.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f4754b.getDrawable();
    }

    public int getEndIconMode() {
        return this.n;
    }

    public CheckableImageButton getEndIconView() {
        return this.f4754b;
    }

    public CharSequence getError() {
        if (this.f4725a.w()) {
            return this.f4725a.n();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f4725a.m();
    }

    public int getErrorCurrentTextColors() {
        return this.f4725a.o();
    }

    public Drawable getErrorIconDrawable() {
        return this.f4762c.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.f4725a.o();
    }

    public CharSequence getHelperText() {
        if (this.f4725a.x()) {
            return this.f4725a.q();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f4725a.r();
    }

    public CharSequence getHint() {
        if (this.f4771e) {
            return this.f4770e;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f4728a.o();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.f4728a.r();
    }

    public ColorStateList getHintTextColor() {
        return this.f4776h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f4754b.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f4754b.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f4768d) {
            return this.f4755b;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.d;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f4730a;
    }

    public CharSequence getPrefixText() {
        return this.f4763c;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f4761c.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f4761c;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f4742a.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f4742a.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.f4767d;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f4766d.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f4766d;
    }

    public Typeface getTypeface() {
        return this.f4734a;
    }

    public void h(float f2) {
        if (this.f4728a.v() == f2) {
            return;
        }
        if (this.f4729a == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f4729a = valueAnimator;
            valueAnimator.setInterpolator(kv.b);
            this.f4729a.setDuration(167L);
            this.f4729a.addUpdateListener(new d());
        }
        this.f4729a.setFloatValues(this.f4728a.v(), f2);
        this.f4729a.start();
    }

    public final void i() {
        iz izVar = this.f4726a;
        if (izVar == null) {
            return;
        }
        izVar.setShapeAppearanceModel(this.f4727a);
        if (v()) {
            this.f4726a.a0(this.h, this.k);
        }
        int iP = p();
        this.l = iP;
        this.f4726a.U(ColorStateList.valueOf(iP));
        if (this.n == 3) {
            this.f4738a.getBackground().invalidateSelf();
        }
        j();
        invalidate();
    }

    public final void i0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f4741a;
        if (textView != null) {
            Y(textView, this.f4764c ? this.b : this.c);
            if (!this.f4764c && (colorStateList2 = this.f4746b) != null) {
                this.f4741a.setTextColor(colorStateList2);
            }
            if (!this.f4764c || (colorStateList = this.f4758c) == null) {
                return;
            }
            this.f4741a.setTextColor(colorStateList);
        }
    }

    public final void j() {
        if (this.f4745b == null) {
            return;
        }
        if (w()) {
            this.f4745b.U(ColorStateList.valueOf(this.k));
        }
        invalidate();
    }

    public final boolean j0() {
        boolean z;
        if (this.f4738a == null) {
            return false;
        }
        boolean z2 = true;
        if (a0()) {
            int measuredWidth = this.f4740a.getMeasuredWidth() - this.f4738a.getPaddingLeft();
            if (this.f4735a == null || this.m != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f4735a = colorDrawable;
                this.m = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrA = oj.a(this.f4738a);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.f4735a;
            if (drawable != drawable2) {
                oj.l(this.f4738a, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.f4735a != null) {
                Drawable[] drawableArrA2 = oj.a(this.f4738a);
                oj.l(this.f4738a, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
                this.f4735a = null;
                z = true;
            }
            z = false;
        }
        if (Z()) {
            int measuredWidth2 = this.f4766d.getMeasuredWidth() - this.f4738a.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + eg.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] drawableArrA3 = oj.a(this.f4738a);
            Drawable drawable3 = this.f4749b;
            if (drawable3 == null || this.o == measuredWidth2) {
                if (this.f4749b == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f4749b = colorDrawable2;
                    this.o = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrA3[2];
                Drawable drawable5 = this.f4749b;
                if (drawable4 != drawable5) {
                    this.f4759c = drawableArrA3[2];
                    oj.l(this.f4738a, drawableArrA3[0], drawableArrA3[1], drawable5, drawableArrA3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.o = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                oj.l(this.f4738a, drawableArrA3[0], drawableArrA3[1], this.f4749b, drawableArrA3[3]);
            }
        } else {
            if (this.f4749b == null) {
                return z;
            }
            Drawable[] drawableArrA4 = oj.a(this.f4738a);
            if (drawableArrA4[2] == this.f4749b) {
                oj.l(this.f4738a, drawableArrA4[0], drawableArrA4[1], this.f4759c, drawableArrA4[3]);
            } else {
                z2 = z;
            }
            this.f4749b = null;
        }
        return z2;
    }

    public final void k(RectF rectF) {
        float f2 = rectF.left;
        int i = this.e;
        rectF.left = f2 - i;
        rectF.top -= i;
        rectF.right += i;
        rectF.bottom += i;
    }

    public void k0() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f4738a;
        if (editText == null || this.f != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (e7.a(background)) {
            background = background.mutate();
        }
        if (this.f4725a.k()) {
            currentTextColor = this.f4725a.o();
        } else {
            if (!this.f4764c || (textView = this.f4741a) == null) {
                kd.c(background);
                this.f4738a.refreshDrawableState();
                return;
            }
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(v5.e(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    public final void l() {
        m(this.f4754b, this.f4779i, this.f4769e, this.f4780j, this.f4747b);
    }

    public final boolean l0() {
        int iMax;
        if (this.f4738a == null || this.f4738a.getMeasuredHeight() >= (iMax = Math.max(this.f4752b.getMeasuredHeight(), this.f4740a.getMeasuredHeight()))) {
            return false;
        }
        this.f4738a.setMinimumHeight(iMax);
        return true;
    }

    public final void m(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = kd.r(drawable).mutate();
            if (z) {
                kd.o(drawable, colorStateList);
            }
            if (z2) {
                kd.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public final void m0(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        Drawable drawableMutate = kd.r(drawable).mutate();
        kd.o(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public final void n() {
        m(this.f4742a, this.f4775g, this.f4765d, this.f4777h, this.f4731a);
    }

    public final void n0() {
        if (this.f != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4739a.getLayoutParams();
            int iU = u();
            if (iU != layoutParams.topMargin) {
                layoutParams.topMargin = iU;
                this.f4739a.requestLayout();
            }
        }
    }

    public final void o() {
        int i = this.f;
        if (i == 0) {
            this.f4726a = null;
        } else if (i == 1) {
            this.f4726a = new iz(this.f4727a);
            this.f4745b = new iz();
            return;
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.f + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.f4726a = (!this.f4771e || (this.f4726a instanceof s10)) ? new iz(this.f4727a) : new s10(this.f4727a);
        }
        this.f4745b = null;
    }

    public void o0(boolean z) {
        p0(z, false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.f4738a;
        if (editText != null) {
            Rect rect = this.f4732a;
            rx.a(this, editText, rect);
            e0(rect);
            if (this.f4771e) {
                this.f4728a.T(this.f4738a.getTextSize());
                int gravity = this.f4738a.getGravity();
                this.f4728a.L((gravity & (-113)) | 48);
                this.f4728a.S(gravity);
                this.f4728a.H(q(rect));
                this.f4728a.P(t(rect));
                this.f4728a.E();
                if (!z() || this.f4781k) {
                    return;
                }
                R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean zL0 = l0();
        boolean zJ0 = j0();
        if (zL0 || zJ0) {
            this.f4738a.post(new c());
        }
        q0();
        t0();
        w0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.q());
        setError(hVar.f8337a);
        if (hVar.b) {
            this.f4754b.post(new b());
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f4725a.k()) {
            hVar.f8337a = getError();
        }
        hVar.b = H() && this.f4754b.isChecked();
        return hVar;
    }

    public final int p() {
        return this.f == 1 ? iw.e(iw.d(this, zu.colorSurface, 0), this.l) : this.l;
    }

    public final void p0(boolean z, boolean z2) {
        ColorStateList textColors;
        qx qxVar;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f4738a;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f4738a;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean zK = this.f4725a.k();
        ColorStateList colorStateList = this.f4774g;
        if (colorStateList != null) {
            this.f4728a.K(colorStateList);
            this.f4728a.R(this.f4774g);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList2 = this.f4774g;
            int colorForState = colorStateList2 != null ? colorStateList2.getColorForState(new int[]{-16842910}, this.w) : this.w;
            this.f4728a.K(ColorStateList.valueOf(colorForState));
            this.f4728a.R(ColorStateList.valueOf(colorForState));
        } else if (zK) {
            this.f4728a.K(this.f4725a.p());
        } else {
            if (this.f4764c && (textView = this.f4741a) != null) {
                qxVar = this.f4728a;
                textColors = textView.getTextColors();
            } else if (z4 && (textColors = this.f4776h) != null) {
                qxVar = this.f4728a;
            }
            qxVar.K(textColors);
        }
        if (z3 || (isEnabled() && (z4 || zK))) {
            if (z2 || this.f4781k) {
                y(z);
                return;
            }
            return;
        }
        if (z2 || !this.f4781k) {
            E(z);
        }
    }

    public final Rect q(Rect rect) {
        int paddingTop;
        int iG;
        if (this.f4738a == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f4748b;
        boolean z = eh.y(this) == 1;
        rect2.bottom = rect.bottom;
        int i = this.f;
        if (i == 1) {
            rect2.left = F(rect.left, z);
            paddingTop = rect.top + this.g;
        } else {
            if (i == 2) {
                rect2.left = rect.left + this.f4738a.getPaddingLeft();
                rect2.top = rect.top - u();
                iG = rect.right - this.f4738a.getPaddingRight();
                rect2.right = iG;
                return rect2;
            }
            rect2.left = F(rect.left, z);
            paddingTop = getPaddingTop();
        }
        rect2.top = paddingTop;
        iG = G(rect.right, z);
        rect2.right = iG;
        return rect2;
    }

    public final void q0() {
        EditText editText;
        if (this.f4753b == null || (editText = this.f4738a) == null) {
            return;
        }
        this.f4753b.setGravity(editText.getGravity());
        this.f4753b.setPadding(this.f4738a.getCompoundPaddingLeft(), this.f4738a.getCompoundPaddingTop(), this.f4738a.getCompoundPaddingRight(), this.f4738a.getCompoundPaddingBottom());
    }

    public final int r(Rect rect, Rect rect2, float f2) {
        return O() ? (int) (rect2.top + f2) : rect.bottom - this.f4738a.getCompoundPaddingBottom();
    }

    public final void r0() {
        EditText editText = this.f4738a;
        s0(editText == null ? 0 : editText.getText().length());
    }

    public final int s(Rect rect, float f2) {
        return O() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.f4738a.getCompoundPaddingTop();
    }

    public final void s0(int i) {
        if (i != 0 || this.f4781k) {
            I();
        } else {
            c0();
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.l != i) {
            this.l = i;
            this.s = i;
            this.u = i;
            this.v = i;
            i();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(yb.b(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.s = defaultColor;
        this.l = defaultColor;
        this.t = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.u = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.v = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        i();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f) {
            return;
        }
        this.f = i;
        if (this.f4738a != null) {
            Q();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.r != i) {
            this.r = i;
            y0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (!colorStateList.isStateful()) {
            if (this.r != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            y0();
        } else {
            this.p = colorStateList.getDefaultColor();
            this.w = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.q = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        }
        this.r = defaultColor;
        y0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f4778i != colorStateList) {
            this.f4778i = colorStateList;
            y0();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.i = i;
        y0();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.j = i;
        y0();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f4757b != z) {
            if (z) {
                w6 w6Var = new w6(getContext());
                this.f4741a = w6Var;
                w6Var.setId(dv.textinput_counter);
                Typeface typeface = this.f4734a;
                if (typeface != null) {
                    this.f4741a.setTypeface(typeface);
                }
                this.f4741a.setMaxLines(1);
                this.f4725a.d(this.f4741a, 2);
                eg.d((ViewGroup.MarginLayoutParams) this.f4741a.getLayoutParams(), getResources().getDimensionPixelOffset(bv.mtrl_textinput_counter_margin_start));
                i0();
                f0();
            } else {
                this.f4725a.y(this.f4741a, 2);
                this.f4741a = null;
            }
            this.f4757b = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f8331a != i) {
            if (i <= 0) {
                i = -1;
            }
            this.f8331a = i;
            if (this.f4757b) {
                f0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.b != i) {
            this.b = i;
            i0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f4758c != colorStateList) {
            this.f4758c = colorStateList;
            i0();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.c != i) {
            this.c = i;
            i0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f4746b != colorStateList) {
            this.f4746b = colorStateList;
            i0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f4774g = colorStateList;
        this.f4776h = colorStateList;
        if (this.f4738a != null) {
            o0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        S(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.f4754b.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.f4754b.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f4754b.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? r2.d(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f4754b.setImageDrawable(drawable);
    }

    public void setEndIconMode(int i) {
        int i2 = this.n;
        this.n = i;
        B(i2);
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().b(this.f)) {
            getEndIconDelegate().a();
            l();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f + " is not supported by the end icon mode " + i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        W(this.f4754b, onClickListener, this.f4750b);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f4750b = onLongClickListener;
        X(this.f4754b, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f4769e != colorStateList) {
            this.f4769e = colorStateList;
            this.f4779i = true;
            l();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f4747b != mode) {
            this.f4747b = mode;
            this.f4780j = true;
            l();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (J() != z) {
            this.f4754b.setVisibility(z ? 0 : 8);
            w0();
            j0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f4725a.w()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f4725a.s();
        } else {
            this.f4725a.L(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f4725a.A(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.f4725a.B(z);
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? r2.d(getContext(), i) : null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f4762c.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f4725a.w());
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        W(this.f4762c, onClickListener, this.f4760c);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f4760c = onLongClickListener;
        X(this.f4762c, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f4772f = colorStateList;
        Drawable drawable = this.f4762c.getDrawable();
        if (drawable != null) {
            drawable = kd.r(drawable).mutate();
            kd.o(drawable, colorStateList);
        }
        if (this.f4762c.getDrawable() != drawable) {
            this.f4762c.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4762c.getDrawable();
        if (drawable != null) {
            drawable = kd.r(drawable).mutate();
            kd.p(drawable, mode);
        }
        if (this.f4762c.getDrawable() != drawable) {
            this.f4762c.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        this.f4725a.C(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f4725a.D(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (L()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!L()) {
                setHelperTextEnabled(true);
            }
            this.f4725a.M(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f4725a.G(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f4725a.F(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.f4725a.E(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f4771e) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f4782l = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f4771e) {
            this.f4771e = z;
            if (z) {
                CharSequence hint = this.f4738a.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f4770e)) {
                        setHint(hint);
                    }
                    this.f4738a.setHint((CharSequence) null);
                }
                this.f4773f = true;
            } else {
                this.f4773f = false;
                if (!TextUtils.isEmpty(this.f4770e) && TextUtils.isEmpty(this.f4738a.getHint())) {
                    this.f4738a.setHint(this.f4770e);
                }
                setHintInternal(null);
            }
            if (this.f4738a != null) {
                n0();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f4728a.I(i);
        this.f4776h = this.f4728a.n();
        if (this.f4738a != null) {
            o0(false);
            n0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f4776h != colorStateList) {
            if (this.f4774g == null) {
                this.f4728a.K(colorStateList);
            }
            this.f4776h = colorStateList;
            if (this.f4738a != null) {
                o0(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f4754b.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? r2.d(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f4754b.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.n != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f4769e = colorStateList;
        this.f4779i = true;
        l();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f4747b = mode;
        this.f4780j = true;
        l();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f4768d && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f4768d) {
                setPlaceholderTextEnabled(true);
            }
            this.f4755b = charSequence;
        }
        r0();
    }

    public void setPlaceholderTextAppearance(int i) {
        this.d = i;
        TextView textView = this.f4753b;
        if (textView != null) {
            oj.q(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f4730a != colorStateList) {
            this.f4730a = colorStateList;
            TextView textView = this.f4753b;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f4763c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f4761c.setText(charSequence);
        u0();
    }

    public void setPrefixTextAppearance(int i) {
        oj.q(this.f4761c, i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f4761c.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.f4742a.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.f4742a.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? r2.d(getContext(), i) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f4742a.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            n();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        W(this.f4742a, onClickListener, this.f4737a);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f4737a = onLongClickListener;
        X(this.f4742a, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.f4765d != colorStateList) {
            this.f4765d = colorStateList;
            this.f4775g = true;
            n();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.f4731a != mode) {
            this.f4731a = mode;
            this.f4777h = true;
            n();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (P() != z) {
            this.f4742a.setVisibility(z ? 0 : 8);
            t0();
            j0();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f4767d = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f4766d.setText(charSequence);
        x0();
    }

    public void setSuffixTextAppearance(int i) {
        oj.q(this.f4766d, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f4766d.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f4738a;
        if (editText != null) {
            eh.k0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f4734a) {
            this.f4734a = typeface;
            this.f4728a.b0(typeface);
            this.f4725a.I(typeface);
            TextView textView = this.f4741a;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public final Rect t(Rect rect) {
        if (this.f4738a == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f4748b;
        float fU = this.f4728a.u();
        rect2.left = rect.left + this.f4738a.getCompoundPaddingLeft();
        rect2.top = s(rect, fU);
        rect2.right = rect.right - this.f4738a.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, fU);
        return rect2;
    }

    public final void t0() {
        if (this.f4738a == null) {
            return;
        }
        eh.w0(this.f4761c, P() ? 0 : eh.D(this.f4738a), this.f4738a.getCompoundPaddingTop(), 0, this.f4738a.getCompoundPaddingBottom());
    }

    public final int u() {
        float fO;
        if (!this.f4771e) {
            return 0;
        }
        int i = this.f;
        if (i == 0 || i == 1) {
            fO = this.f4728a.o();
        } else {
            if (i != 2) {
                return 0;
            }
            fO = this.f4728a.o() / 2.0f;
        }
        return (int) fO;
    }

    public final void u0() {
        this.f4761c.setVisibility((this.f4763c == null || M()) ? 8 : 0);
        j0();
    }

    public final boolean v() {
        return this.f == 2 && w();
    }

    public final void v0(boolean z, boolean z2) {
        int defaultColor = this.f4778i.getDefaultColor();
        int colorForState = this.f4778i.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f4778i.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.k = colorForState2;
        } else if (z2) {
            this.k = colorForState;
        } else {
            this.k = defaultColor;
        }
    }

    public final boolean w() {
        return this.h > -1 && this.k != 0;
    }

    public final void w0() {
        if (this.f4738a == null) {
            return;
        }
        eh.w0(this.f4766d, 0, this.f4738a.getPaddingTop(), (J() || K()) ? 0 : eh.C(this.f4738a), this.f4738a.getPaddingBottom());
    }

    public final void x() {
        if (z()) {
            ((s10) this.f4726a).k0();
        }
    }

    public final void x0() {
        int visibility = this.f4766d.getVisibility();
        boolean z = (this.f4767d == null || M()) ? false : true;
        this.f4766d.setVisibility(z ? 0 : 8);
        if (visibility != this.f4766d.getVisibility()) {
            getEndIconDelegate().c(z);
        }
        j0();
    }

    public final void y(boolean z) {
        ValueAnimator valueAnimator = this.f4729a;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f4729a.cancel();
        }
        if (z && this.f4782l) {
            h(1.0f);
        } else {
            this.f4728a.V(1.0f);
        }
        this.f4781k = false;
        if (z()) {
            R();
        }
        r0();
        u0();
        x0();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y0() {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.y0():void");
    }

    public final boolean z() {
        return this.f4771e && !TextUtils.isEmpty(this.f4770e) && (this.f4726a instanceof s10);
    }
}
