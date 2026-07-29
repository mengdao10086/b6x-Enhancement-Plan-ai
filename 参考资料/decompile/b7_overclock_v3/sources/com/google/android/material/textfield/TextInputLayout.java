package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.y0;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.b0;
import g.c1;
import g.d1;
import g.i1;
import g.n0;
import g.p0;
import g.t0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout {
    public static final int A8 = 2;
    public static final int B8 = 3;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public static final int f20866n8 = 167;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public static final long f20867o8 = 87;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public static final long f20868p8 = 67;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public static final int f20869q8 = -1;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public static final int f20870r8 = -1;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final String f20872t8 = "TextInputLayout";

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final int f20873u8 = 0;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final int f20874v8 = 1;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static final int f20875w8 = 2;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public static final int f20876x8 = -1;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final int f20877y8 = 0;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public static final int f20878z8 = 1;
    public boolean A;
    public CharSequence B;
    public boolean C;

    @p0
    public le.j C1;
    public final int C2;

    @p0
    public le.j D;
    public int E7;
    public int F7;
    public int G7;
    public int H7;

    @g.l
    public int I7;

    @g.l
    public int J7;
    public StateListDrawable K0;

    @n0
    public le.o K1;
    public int K2;
    public final Rect K7;
    public final Rect L7;
    public final RectF M7;
    public Typeface N7;

    @p0
    public Drawable O7;
    public int P7;
    public final LinkedHashSet<i> Q7;

    @p0
    public Drawable R7;
    public int S7;
    public Drawable T7;
    public ColorStateList U7;
    public ColorStateList V7;

    @g.l
    public int W7;

    @g.l
    public int X7;

    @g.l
    public int Y7;
    public ColorStateList Z7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f20879a;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    @g.l
    public int f20880a8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final z f20881b;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    @g.l
    public int f20882b8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final r f20883c;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    @g.l
    public int f20884c8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EditText f20885d;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    @g.l
    public int f20886d8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f20887e;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    @g.l
    public int f20888e8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20889f;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public boolean f20890f8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20891g;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public final com.google.android.material.internal.b f20892g8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20893h;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public boolean f20894h8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20895i;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public boolean f20896i8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f20897j;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public ValueAnimator f20898j8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20899k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public le.j f20900k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f20901k1;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public boolean f20902k8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20903l;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public boolean f20904l8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f20905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public h f20906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public TextView f20907o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20908p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20909q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f20910r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f20911s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f20912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public ColorStateList f20913u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f20914v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    @p0
    public le.j f20915v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f20916v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public androidx.transition.i f20917w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public androidx.transition.i f20918x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public ColorStateList f20919y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @p0
    public ColorStateList f20920z;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public static final int f20865m8 = R.style.Widget_Design_TextInputLayout;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final int[][] f20871s8 = {new int[]{android.R.attr.state_pressed}, new int[0]};

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public CharSequence f20921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f20922d;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @p0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @n0
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f20921c) + zc.a.f58317e;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f20921c, parcel, i10);
            parcel.writeInt(this.f20922d ? 1 : 0);
        }

        public SavedState(@n0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f20921c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f20922d = parcel.readInt() == 1;
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@n0 Editable editable) {
            TextInputLayout.this.K0(!r0.f20904l8);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f20899k) {
                textInputLayout.C0(editable);
            }
            if (TextInputLayout.this.f20911s) {
                TextInputLayout.this.O0(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f20883c.i();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f20885d.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            TextInputLayout.this.f20892g8.z0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextInputLayout f20927d;

        public e(@n0 TextInputLayout textInputLayout) {
            this.f20927d = textInputLayout;
        }

        @Override // androidx.core.view.a
        public void g(@n0 View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            EditText editText = this.f20927d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f20927d.getHint();
            CharSequence error = this.f20927d.getError();
            CharSequence placeholderText = this.f20927d.getPlaceholderText();
            int counterMaxLength = this.f20927d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f20927d.getCounterOverflowDescription();
            boolean z10 = !TextUtils.isEmpty(text);
            boolean z11 = !TextUtils.isEmpty(hint);
            boolean z12 = !this.f20927d.Y();
            boolean z13 = !TextUtils.isEmpty(error);
            boolean z14 = z13 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z11 ? hint.toString() : "";
            this.f20927d.f20881b.w(dVar);
            if (z10) {
                dVar.S1(text);
            } else if (!TextUtils.isEmpty(string)) {
                dVar.S1(string);
                if (z12 && placeholderText != null) {
                    dVar.S1(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                dVar.S1(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    dVar.q1(string);
                } else {
                    if (z10) {
                        string = ((Object) text) + ", " + string;
                    }
                    dVar.S1(string);
                }
                dVar.O1(!z10);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            dVar.z1(counterMaxLength);
            if (z14) {
                if (!z13) {
                    error = counterOverflowDescription;
                }
                dVar.m1(error);
            }
            View viewT = this.f20927d.f20897j.t();
            if (viewT != null) {
                dVar.t1(viewT);
            }
            this.f20927d.f20883c.o().o(view, dVar);
        }

        @Override // androidx.core.view.a
        public void h(@n0 View view, @n0 AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            this.f20927d.f20883c.o().p(view, accessibilityEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    public interface h {
        int a(@p0 Editable editable);
    }

    public interface i {
        void a(@n0 TextInputLayout textInputLayout);
    }

    public interface j {
        void a(@n0 TextInputLayout textInputLayout, int i10);
    }

    public TextInputLayout(@n0 Context context) {
        this(context, null);
    }

    public static void D0(@n0 Context context, @n0 TextView textView, int i10, int i11, boolean z10) {
        textView.setContentDescription(context.getString(z10 ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    public static Drawable K(le.j jVar, int i10, int i11, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{vd.m.n(i11, i10, 0.1f), i10}), jVar, jVar);
    }

    public static Drawable N(Context context, le.j jVar, int i10, int[][] iArr) {
        int iC = vd.m.c(context, R.attr.colorSurface, f20872t8);
        le.j jVar2 = new le.j(jVar.getShapeAppearanceModel());
        int iN = vd.m.n(i10, iC, 0.1f);
        jVar2.o0(new ColorStateList(iArr, new int[]{iN, 0}));
        jVar2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iN, iC});
        le.j jVar3 = new le.j(jVar.getShapeAppearanceModel());
        jVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, jVar2, jVar3), jVar});
    }

    public static /* synthetic */ int e0(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    @p0
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f20885d;
        if (!(editText instanceof AutoCompleteTextView) || q.a(editText)) {
            return this.D;
        }
        int iD = vd.m.d(this.f20885d, R.attr.colorControlHighlight);
        int i10 = this.K2;
        if (i10 == 2) {
            return N(getContext(), this.D, iD, f20871s8);
        }
        if (i10 == 1) {
            return K(this.D, this.J7, iD, f20871s8);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.K0 == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.K0 = stateListDrawable;
            stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.K0.addState(new int[0], J(false));
        }
        return this.K0;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f20900k0 == null) {
            this.f20900k0 = J(true);
        }
        return this.f20900k0;
    }

    public static void j0(@n0 ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                j0((ViewGroup) childAt, z10);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f20885d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3) {
            boolean z10 = editText instanceof TextInputEditText;
        }
        this.f20885d = editText;
        int i10 = this.f20889f;
        if (i10 != -1) {
            setMinEms(i10);
        } else {
            setMinWidth(this.f20893h);
        }
        int i11 = this.f20891g;
        if (i11 != -1) {
            setMaxEms(i11);
        } else {
            setMaxWidth(this.f20895i);
        }
        this.f20901k1 = false;
        f0();
        setTextInputAccessibilityDelegate(new e(this));
        this.f20892g8.O0(this.f20885d.getTypeface());
        this.f20892g8.w0(this.f20885d.getTextSize());
        this.f20892g8.r0(this.f20885d.getLetterSpacing());
        int gravity = this.f20885d.getGravity();
        this.f20892g8.k0((gravity & (-113)) | 48);
        this.f20892g8.v0(gravity);
        this.f20885d.addTextChangedListener(new a());
        if (this.U7 == null) {
            this.U7 = this.f20885d.getHintTextColors();
        }
        if (this.A) {
            if (TextUtils.isEmpty(this.B)) {
                CharSequence hint = this.f20885d.getHint();
                this.f20887e = hint;
                setHint(hint);
                this.f20885d.setHint((CharSequence) null);
            }
            this.C = true;
        }
        if (this.f20907o != null) {
            C0(this.f20885d.getText());
        }
        G0();
        this.f20897j.f();
        this.f20881b.bringToFront();
        this.f20883c.bringToFront();
        F();
        this.f20883c.z0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        L0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.B)) {
            return;
        }
        this.B = charSequence;
        this.f20892g8.L0(charSequence);
        if (this.f20890f8) {
            return;
        }
        g0();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f20911s == z10) {
            return;
        }
        if (z10) {
            j();
        } else {
            q0();
            this.f20912t = null;
        }
        this.f20911s = z10;
    }

    public final void A() {
        if (D()) {
            ((com.google.android.material.textfield.h) this.D).Q0();
        }
    }

    public final void A0(@n0 Rect rect) {
        le.j jVar = this.f20915v1;
        if (jVar != null) {
            int i10 = rect.bottom;
            jVar.setBounds(rect.left, i10 - this.G7, rect.right, i10);
        }
        le.j jVar2 = this.C1;
        if (jVar2 != null) {
            int i11 = rect.bottom;
            jVar2.setBounds(rect.left, i11 - this.H7, rect.right, i11);
        }
    }

    public final void B(boolean z10) {
        ValueAnimator valueAnimator = this.f20898j8;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f20898j8.cancel();
        }
        if (z10 && this.f20896i8) {
            l(1.0f);
        } else {
            this.f20892g8.z0(1.0f);
        }
        this.f20890f8 = false;
        if (D()) {
            g0();
        }
        N0();
        this.f20881b.j(false);
        this.f20883c.I(false);
    }

    public final void B0() {
        if (this.f20907o != null) {
            EditText editText = this.f20885d;
            C0(editText == null ? null : editText.getText());
        }
    }

    public final androidx.transition.i C() {
        androidx.transition.i iVar = new androidx.transition.i();
        iVar.y0(87L);
        iVar.A0(kd.a.f37166a);
        return iVar;
    }

    public void C0(@p0 Editable editable) {
        int iA = this.f20906n.a(editable);
        boolean z10 = this.f20905m;
        int i10 = this.f20903l;
        if (i10 == -1) {
            this.f20907o.setText(String.valueOf(iA));
            this.f20907o.setContentDescription(null);
            this.f20905m = false;
        } else {
            this.f20905m = iA > i10;
            D0(getContext(), this.f20907o, iA, this.f20903l, this.f20905m);
            if (z10 != this.f20905m) {
                E0();
            }
            this.f20907o.setText(y0.a.c().q(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(iA), Integer.valueOf(this.f20903l))));
        }
        if (this.f20885d == null || z10 == this.f20905m) {
            return;
        }
        K0(false);
        Q0();
        G0();
    }

    public final boolean D() {
        return this.A && !TextUtils.isEmpty(this.B) && (this.D instanceof com.google.android.material.textfield.h);
    }

    @i1
    public boolean E() {
        return D() && ((com.google.android.material.textfield.h) this.D).P0();
    }

    public final void E0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f20907o;
        if (textView != null) {
            u0(textView, this.f20905m ? this.f20908p : this.f20909q);
            if (!this.f20905m && (colorStateList2 = this.f20919y) != null) {
                this.f20907o.setTextColor(colorStateList2);
            }
            if (!this.f20905m || (colorStateList = this.f20920z) == null) {
                return;
            }
            this.f20907o.setTextColor(colorStateList);
        }
    }

    public final void F() {
        Iterator<i> it2 = this.Q7.iterator();
        while (it2.hasNext()) {
            it2.next().a(this);
        }
    }

    public boolean F0() {
        boolean z10;
        if (this.f20885d == null) {
            return false;
        }
        boolean z11 = true;
        if (x0()) {
            int measuredWidth = this.f20881b.getMeasuredWidth() - this.f20885d.getPaddingLeft();
            if (this.O7 == null || this.P7 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.O7 = colorDrawable;
                this.P7 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrH = androidx.core.widget.r.h(this.f20885d);
            Drawable drawable = drawableArrH[0];
            Drawable drawable2 = this.O7;
            if (drawable != drawable2) {
                androidx.core.widget.r.w(this.f20885d, drawable2, drawableArrH[1], drawableArrH[2], drawableArrH[3]);
                z10 = true;
            }
            z10 = false;
        } else {
            if (this.O7 != null) {
                Drawable[] drawableArrH2 = androidx.core.widget.r.h(this.f20885d);
                androidx.core.widget.r.w(this.f20885d, null, drawableArrH2[1], drawableArrH2[2], drawableArrH2[3]);
                this.O7 = null;
                z10 = true;
            }
            z10 = false;
        }
        if (w0()) {
            int measuredWidth2 = this.f20883c.y().getMeasuredWidth() - this.f20885d.getPaddingRight();
            CheckableImageButton checkableImageButtonM = this.f20883c.m();
            if (checkableImageButtonM != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonM.getMeasuredWidth() + androidx.core.view.r.c((ViewGroup.MarginLayoutParams) checkableImageButtonM.getLayoutParams());
            }
            Drawable[] drawableArrH3 = androidx.core.widget.r.h(this.f20885d);
            Drawable drawable3 = this.R7;
            if (drawable3 == null || this.S7 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.R7 = colorDrawable2;
                    this.S7 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrH3[2];
                Drawable drawable5 = this.R7;
                if (drawable4 != drawable5) {
                    this.T7 = drawableArrH3[2];
                    androidx.core.widget.r.w(this.f20885d, drawableArrH3[0], drawableArrH3[1], drawable5, drawableArrH3[3]);
                } else {
                    z11 = z10;
                }
            } else {
                this.S7 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.r.w(this.f20885d, drawableArrH3[0], drawableArrH3[1], this.R7, drawableArrH3[3]);
            }
        } else {
            if (this.R7 == null) {
                return z10;
            }
            Drawable[] drawableArrH4 = androidx.core.widget.r.h(this.f20885d);
            if (drawableArrH4[2] == this.R7) {
                androidx.core.widget.r.w(this.f20885d, drawableArrH4[0], drawableArrH4[1], this.T7, drawableArrH4[3]);
            } else {
                z11 = z10;
            }
            this.R7 = null;
        }
        return z11;
    }

    public final void G(Canvas canvas) {
        le.j jVar;
        if (this.C1 == null || (jVar = this.f20915v1) == null) {
            return;
        }
        jVar.draw(canvas);
        if (this.f20885d.isFocused()) {
            Rect bounds = this.C1.getBounds();
            Rect bounds2 = this.f20915v1.getBounds();
            float fG = this.f20892g8.G();
            int iCenterX = bounds2.centerX();
            bounds.left = kd.a.c(iCenterX, bounds2.left, fG);
            bounds.right = kd.a.c(iCenterX, bounds2.right, fG);
            this.C1.draw(canvas);
        }
    }

    public void G0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f20885d;
        if (editText == null || this.K2 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (d0.a(background)) {
            background = background.mutate();
        }
        if (v0()) {
            background.setColorFilter(androidx.appcompat.widget.i.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f20905m && (textView = this.f20907o) != null) {
            background.setColorFilter(androidx.appcompat.widget.i.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            n0.c.c(background);
            this.f20885d.refreshDrawableState();
        }
    }

    public final void H(@n0 Canvas canvas) {
        if (this.A) {
            this.f20892g8.l(canvas);
        }
    }

    public void H0() {
        EditText editText = this.f20885d;
        if (editText == null || this.D == null) {
            return;
        }
        if ((this.f20901k1 || editText.getBackground() == null) && this.K2 != 0) {
            u0.I1(this.f20885d, getEditTextBoxBackground());
            this.f20901k1 = true;
        }
    }

    public final void I(boolean z10) {
        ValueAnimator valueAnimator = this.f20898j8;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f20898j8.cancel();
        }
        if (z10 && this.f20896i8) {
            l(0.0f);
        } else {
            this.f20892g8.z0(0.0f);
        }
        if (D() && ((com.google.android.material.textfield.h) this.D).P0()) {
            A();
        }
        this.f20890f8 = true;
        O();
        this.f20881b.j(true);
        this.f20883c.I(true);
    }

    public final boolean I0() {
        int iMax;
        if (this.f20885d == null || this.f20885d.getMeasuredHeight() >= (iMax = Math.max(this.f20883c.getMeasuredHeight(), this.f20881b.getMeasuredHeight()))) {
            return false;
        }
        this.f20885d.setMinimumHeight(iMax);
        return true;
    }

    public final le.j J(boolean z10) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float f10 = z10 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f20885d;
        float popupElevation = editText instanceof v ? ((v) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        le.o oVarM = le.o.a().K(f10).P(f10).x(dimensionPixelOffset).C(dimensionPixelOffset).m();
        le.j jVarN = le.j.n(getContext(), popupElevation);
        jVarN.setShapeAppearanceModel(oVarM);
        jVarN.q0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return jVarN;
    }

    public final void J0() {
        if (this.K2 != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20879a.getLayoutParams();
            int iV = v();
            if (iV != layoutParams.topMargin) {
                layoutParams.topMargin = iV;
                this.f20879a.requestLayout();
            }
        }
    }

    public void K0(boolean z10) {
        L0(z10, false);
    }

    public final int L(int i10, boolean z10) {
        int compoundPaddingLeft = i10 + this.f20885d.getCompoundPaddingLeft();
        return (getPrefixText() == null || z10) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    public final void L0(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f20885d;
        boolean z12 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f20885d;
        boolean z13 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.U7;
        if (colorStateList2 != null) {
            this.f20892g8.j0(colorStateList2);
            this.f20892g8.u0(this.U7);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.U7;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f20888e8) : this.f20888e8;
            this.f20892g8.j0(ColorStateList.valueOf(colorForState));
            this.f20892g8.u0(ColorStateList.valueOf(colorForState));
        } else if (v0()) {
            this.f20892g8.j0(this.f20897j.r());
        } else if (this.f20905m && (textView = this.f20907o) != null) {
            this.f20892g8.j0(textView.getTextColors());
        } else if (z13 && (colorStateList = this.V7) != null) {
            this.f20892g8.j0(colorStateList);
        }
        if (z12 || !this.f20894h8 || (isEnabled() && z13)) {
            if (z11 || this.f20890f8) {
                B(z10);
                return;
            }
            return;
        }
        if (z11 || !this.f20890f8) {
            I(z10);
        }
    }

    public final int M(int i10, boolean z10) {
        int compoundPaddingRight = i10 - this.f20885d.getCompoundPaddingRight();
        return (getPrefixText() == null || !z10) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    public final void M0() {
        EditText editText;
        if (this.f20912t == null || (editText = this.f20885d) == null) {
            return;
        }
        this.f20912t.setGravity(editText.getGravity());
        this.f20912t.setPadding(this.f20885d.getCompoundPaddingLeft(), this.f20885d.getCompoundPaddingTop(), this.f20885d.getCompoundPaddingRight(), this.f20885d.getCompoundPaddingBottom());
    }

    public final void N0() {
        EditText editText = this.f20885d;
        O0(editText == null ? null : editText.getText());
    }

    public final void O() {
        TextView textView = this.f20912t;
        if (textView == null || !this.f20911s) {
            return;
        }
        textView.setText((CharSequence) null);
        androidx.transition.u.b(this.f20879a, this.f20918x);
        this.f20912t.setVisibility(4);
    }

    public final void O0(@p0 Editable editable) {
        if (this.f20906n.a(editable) != 0 || this.f20890f8) {
            O();
        } else {
            y0();
        }
    }

    public boolean P() {
        return this.f20899k;
    }

    public final void P0(boolean z10, boolean z11) {
        int defaultColor = this.Z7.getDefaultColor();
        int colorForState = this.Z7.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.Z7.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.I7 = colorForState2;
        } else if (z11) {
            this.I7 = colorForState;
        } else {
            this.I7 = defaultColor;
        }
    }

    public boolean Q() {
        return this.f20883c.D();
    }

    public void Q0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.D == null || this.K2 == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.f20885d) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f20885d) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.I7 = this.f20888e8;
        } else if (v0()) {
            if (this.Z7 != null) {
                P0(z11, z10);
            } else {
                this.I7 = getErrorCurrentTextColors();
            }
        } else if (!this.f20905m || (textView = this.f20907o) == null) {
            if (z11) {
                this.I7 = this.Y7;
            } else if (z10) {
                this.I7 = this.X7;
            } else {
                this.I7 = this.W7;
            }
        } else if (this.Z7 != null) {
            P0(z11, z10);
        } else {
            this.I7 = textView.getCurrentTextColor();
        }
        this.f20883c.J();
        n0();
        if (this.K2 == 2) {
            int i10 = this.F7;
            if (z11 && isEnabled()) {
                this.F7 = this.H7;
            } else {
                this.F7 = this.G7;
            }
            if (this.F7 != i10) {
                i0();
            }
        }
        if (this.K2 == 1) {
            if (!isEnabled()) {
                this.J7 = this.f20882b8;
            } else if (z10 && !z11) {
                this.J7 = this.f20886d8;
            } else if (z11) {
                this.J7 = this.f20884c8;
            } else {
                this.J7 = this.f20880a8;
            }
        }
        m();
    }

    public boolean R() {
        return this.f20883c.F();
    }

    public boolean S() {
        return this.f20897j.E();
    }

    public boolean T() {
        return this.f20894h8;
    }

    @i1
    public final boolean U() {
        return this.f20897j.x();
    }

    public boolean V() {
        return this.f20897j.F();
    }

    public boolean W() {
        return this.f20896i8;
    }

    public boolean X() {
        return this.A;
    }

    public final boolean Y() {
        return this.f20890f8;
    }

    @Deprecated
    public boolean Z() {
        return this.f20883c.H();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean a0() {
        return this.C;
    }

    @Override // android.view.ViewGroup
    public void addView(@n0 View view, int i10, @n0 ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f20879a.addView(view, layoutParams2);
        this.f20879a.setLayoutParams(layoutParams);
        J0();
        setEditText((EditText) view);
    }

    public final boolean b0() {
        return this.K2 == 1 && this.f20885d.getMinLines() <= 1;
    }

    public boolean c0() {
        return this.f20881b.h();
    }

    public boolean d0() {
        return this.f20881b.i();
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@n0 ViewStructure viewStructure, int i10) {
        EditText editText = this.f20885d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f20887e != null) {
            boolean z10 = this.C;
            this.C = false;
            CharSequence hint = editText.getHint();
            this.f20885d.setHint(this.f20887e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
                return;
            } finally {
                this.f20885d.setHint(hint);
                this.C = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i10);
        onProvideAutofillVirtualStructure(viewStructure, i10);
        viewStructure.setChildCount(this.f20879a.getChildCount());
        for (int i11 = 0; i11 < this.f20879a.getChildCount(); i11++) {
            View childAt = this.f20879a.getChildAt(i11);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i11);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i10);
            if (childAt == this.f20885d) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@n0 SparseArray<Parcelable> sparseArray) {
        this.f20904l8 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f20904l8 = false;
    }

    @Override // android.view.View
    public void draw(@n0 Canvas canvas) {
        super.draw(canvas);
        H(canvas);
        G(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f20902k8) {
            return;
        }
        this.f20902k8 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.b bVar = this.f20892g8;
        boolean zJ0 = bVar != null ? bVar.J0(drawableState) | false : false;
        if (this.f20885d != null) {
            K0(u0.U0(this) && isEnabled());
        }
        G0();
        Q0();
        if (zJ0) {
            invalidate();
        }
        this.f20902k8 = false;
    }

    public final void f0() {
        p();
        H0();
        Q0();
        z0();
        k();
        if (this.K2 != 0) {
            J0();
        }
        t0();
    }

    public final void g0() {
        if (D()) {
            RectF rectF = this.M7;
            this.f20892g8.o(rectF, this.f20885d.getWidth(), this.f20885d.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            o(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.F7);
            ((com.google.android.material.textfield.h) this.D).S0(rectF);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f20885d;
        return editText != null ? editText.getBaseline() + getPaddingTop() + v() : super.getBaseline();
    }

    @n0
    public le.j getBoxBackground() {
        int i10 = this.K2;
        if (i10 == 1 || i10 == 2) {
            return this.D;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.J7;
    }

    public int getBoxBackgroundMode() {
        return this.K2;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.E7;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return b0.l(this) ? this.K1.j().a(this.M7) : this.K1.l().a(this.M7);
    }

    public float getBoxCornerRadiusBottomStart() {
        return b0.l(this) ? this.K1.l().a(this.M7) : this.K1.j().a(this.M7);
    }

    public float getBoxCornerRadiusTopEnd() {
        return b0.l(this) ? this.K1.r().a(this.M7) : this.K1.t().a(this.M7);
    }

    public float getBoxCornerRadiusTopStart() {
        return b0.l(this) ? this.K1.t().a(this.M7) : this.K1.r().a(this.M7);
    }

    public int getBoxStrokeColor() {
        return this.Y7;
    }

    @p0
    public ColorStateList getBoxStrokeErrorColor() {
        return this.Z7;
    }

    public int getBoxStrokeWidth() {
        return this.G7;
    }

    public int getBoxStrokeWidthFocused() {
        return this.H7;
    }

    public int getCounterMaxLength() {
        return this.f20903l;
    }

    @p0
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f20899k && this.f20905m && (textView = this.f20907o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @p0
    public ColorStateList getCounterOverflowTextColor() {
        return this.f20919y;
    }

    @p0
    public ColorStateList getCounterTextColor() {
        return this.f20919y;
    }

    @p0
    public ColorStateList getDefaultHintTextColor() {
        return this.U7;
    }

    @p0
    public EditText getEditText() {
        return this.f20885d;
    }

    @p0
    public CharSequence getEndIconContentDescription() {
        return this.f20883c.n();
    }

    @p0
    public Drawable getEndIconDrawable() {
        return this.f20883c.p();
    }

    public int getEndIconMode() {
        return this.f20883c.q();
    }

    @n0
    public CheckableImageButton getEndIconView() {
        return this.f20883c.r();
    }

    @p0
    public CharSequence getError() {
        if (this.f20897j.E()) {
            return this.f20897j.p();
        }
        return null;
    }

    @p0
    public CharSequence getErrorContentDescription() {
        return this.f20897j.o();
    }

    @g.l
    public int getErrorCurrentTextColors() {
        return this.f20897j.q();
    }

    @p0
    public Drawable getErrorIconDrawable() {
        return this.f20883c.s();
    }

    @p0
    public CharSequence getHelperText() {
        if (this.f20897j.F()) {
            return this.f20897j.s();
        }
        return null;
    }

    @g.l
    public int getHelperTextCurrentTextColor() {
        return this.f20897j.v();
    }

    @p0
    public CharSequence getHint() {
        if (this.A) {
            return this.B;
        }
        return null;
    }

    @i1
    public final float getHintCollapsedTextHeight() {
        return this.f20892g8.r();
    }

    @i1
    public final int getHintCurrentCollapsedTextColor() {
        return this.f20892g8.w();
    }

    @p0
    public ColorStateList getHintTextColor() {
        return this.V7;
    }

    @n0
    public h getLengthCounter() {
        return this.f20906n;
    }

    public int getMaxEms() {
        return this.f20891g;
    }

    @t0
    public int getMaxWidth() {
        return this.f20895i;
    }

    public int getMinEms() {
        return this.f20889f;
    }

    @t0
    public int getMinWidth() {
        return this.f20893h;
    }

    @p0
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f20883c.u();
    }

    @p0
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f20883c.v();
    }

    @p0
    public CharSequence getPlaceholderText() {
        if (this.f20911s) {
            return this.f20910r;
        }
        return null;
    }

    @d1
    public int getPlaceholderTextAppearance() {
        return this.f20914v;
    }

    @p0
    public ColorStateList getPlaceholderTextColor() {
        return this.f20913u;
    }

    @p0
    public CharSequence getPrefixText() {
        return this.f20881b.a();
    }

    @p0
    public ColorStateList getPrefixTextColor() {
        return this.f20881b.b();
    }

    @n0
    public TextView getPrefixTextView() {
        return this.f20881b.c();
    }

    @p0
    public CharSequence getStartIconContentDescription() {
        return this.f20881b.d();
    }

    @p0
    public Drawable getStartIconDrawable() {
        return this.f20881b.e();
    }

    @p0
    public CharSequence getSuffixText() {
        return this.f20883c.w();
    }

    @p0
    public ColorStateList getSuffixTextColor() {
        return this.f20883c.x();
    }

    @n0
    public TextView getSuffixTextView() {
        return this.f20883c.y();
    }

    @p0
    public Typeface getTypeface() {
        return this.N7;
    }

    public void h(@n0 i iVar) {
        this.Q7.add(iVar);
        if (this.f20885d != null) {
            iVar.a(this);
        }
    }

    @Deprecated
    public void h0(boolean z10) {
        this.f20883c.w0(z10);
    }

    public void i(@n0 j jVar) {
        this.f20883c.g(jVar);
    }

    public final void i0() {
        if (!D() || this.f20890f8) {
            return;
        }
        A();
        g0();
    }

    public final void j() {
        TextView textView = this.f20912t;
        if (textView != null) {
            this.f20879a.addView(textView);
            this.f20912t.setVisibility(0);
        }
    }

    public final void k() {
        if (this.f20885d == null || this.K2 != 1) {
            return;
        }
        if (ie.c.j(getContext())) {
            EditText editText = this.f20885d;
            u0.d2(editText, u0.k0(editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), u0.j0(this.f20885d), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (ie.c.i(getContext())) {
            EditText editText2 = this.f20885d;
            u0.d2(editText2, u0.k0(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), u0.j0(this.f20885d), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    public void k0() {
        this.f20883c.K();
    }

    @i1
    public void l(float f10) {
        if (this.f20892g8.G() == f10) {
            return;
        }
        if (this.f20898j8 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f20898j8 = valueAnimator;
            valueAnimator.setInterpolator(kd.a.f37167b);
            this.f20898j8.setDuration(167L);
            this.f20898j8.addUpdateListener(new d());
        }
        this.f20898j8.setFloatValues(this.f20892g8.G(), f10);
        this.f20898j8.start();
    }

    public final void m() {
        le.j jVar = this.D;
        if (jVar == null) {
            return;
        }
        le.o shapeAppearanceModel = jVar.getShapeAppearanceModel();
        le.o oVar = this.K1;
        if (shapeAppearanceModel != oVar) {
            this.D.setShapeAppearanceModel(oVar);
        }
        if (w()) {
            this.D.D0(this.F7, this.I7);
        }
        int iQ = q();
        this.J7 = iQ;
        this.D.o0(ColorStateList.valueOf(iQ));
        n();
        H0();
    }

    public void m0() {
        this.f20883c.L();
    }

    public final void n() {
        if (this.f20915v1 == null || this.C1 == null) {
            return;
        }
        if (x()) {
            this.f20915v1.o0(this.f20885d.isFocused() ? ColorStateList.valueOf(this.W7) : ColorStateList.valueOf(this.I7));
            this.C1.o0(ColorStateList.valueOf(this.I7));
        }
        invalidate();
    }

    public void n0() {
        this.f20881b.k();
    }

    public final void o(@n0 RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.C2;
        rectF.left = f10 - i10;
        rectF.right += i10;
    }

    public void o0(@n0 i iVar) {
        this.Q7.remove(iVar);
    }

    @Override // android.view.View
    public void onConfigurationChanged(@n0 Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f20892g8.a0(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f20885d;
        if (editText != null) {
            Rect rect = this.K7;
            com.google.android.material.internal.d.a(this, editText, rect);
            A0(rect);
            if (this.A) {
                this.f20892g8.w0(this.f20885d.getTextSize());
                int gravity = this.f20885d.getGravity();
                this.f20892g8.k0((gravity & (-113)) | 48);
                this.f20892g8.v0(gravity);
                this.f20892g8.g0(r(rect));
                this.f20892g8.q0(u(rect));
                this.f20892g8.c0();
                if (!D() || this.f20890f8) {
                    return;
                }
                g0();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        boolean zI0 = I0();
        boolean zF0 = F0();
        if (zI0 || zF0) {
            this.f20885d.post(new c());
        }
        M0();
        this.f20883c.z0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@p0 Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f20921c);
        if (savedState.f20922d) {
            post(new b());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = false;
        boolean z11 = i10 == 1;
        boolean z12 = this.f20916v2;
        if (z11 != z12) {
            if (z11 && !z12) {
                z10 = true;
            }
            float fA = this.K1.r().a(this.M7);
            float fA2 = this.K1.t().a(this.M7);
            float fA3 = this.K1.j().a(this.M7);
            float fA4 = this.K1.l().a(this.M7);
            float f10 = z10 ? fA : fA2;
            if (z10) {
                fA = fA2;
            }
            float f11 = z10 ? fA3 : fA4;
            if (z10) {
                fA3 = fA4;
            }
            r0(f10, fA, f11, fA3);
        }
    }

    @Override // android.view.View
    @p0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (v0()) {
            savedState.f20921c = getError();
        }
        savedState.f20922d = this.f20883c.E();
        return savedState;
    }

    public final void p() {
        int i10 = this.K2;
        if (i10 == 0) {
            this.D = null;
            this.f20915v1 = null;
            this.C1 = null;
            return;
        }
        if (i10 == 1) {
            this.D = new le.j(this.K1);
            this.f20915v1 = new le.j();
            this.C1 = new le.j();
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException(this.K2 + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.A || (this.D instanceof com.google.android.material.textfield.h)) {
                this.D = new le.j(this.K1);
            } else {
                this.D = new com.google.android.material.textfield.h(this.K1);
            }
            this.f20915v1 = null;
            this.C1 = null;
        }
    }

    public void p0(@n0 j jVar) {
        this.f20883c.N(jVar);
    }

    public final int q() {
        return this.K2 == 1 ? vd.m.m(vd.m.e(this, R.attr.colorSurface, 0), this.J7) : this.J7;
    }

    public final void q0() {
        TextView textView = this.f20912t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @n0
    public final Rect r(@n0 Rect rect) {
        if (this.f20885d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.L7;
        boolean zL = b0.l(this);
        rect2.bottom = rect.bottom;
        int i10 = this.K2;
        if (i10 == 1) {
            rect2.left = L(rect.left, zL);
            rect2.top = rect.top + this.E7;
            rect2.right = M(rect.right, zL);
            return rect2;
        }
        if (i10 != 2) {
            rect2.left = L(rect.left, zL);
            rect2.top = getPaddingTop();
            rect2.right = M(rect.right, zL);
            return rect2;
        }
        rect2.left = rect.left + this.f20885d.getPaddingLeft();
        rect2.top = rect.top - v();
        rect2.right = rect.right - this.f20885d.getPaddingRight();
        return rect2;
    }

    public void r0(float f10, float f11, float f12, float f13) {
        boolean zL = b0.l(this);
        this.f20916v2 = zL;
        float f14 = zL ? f11 : f10;
        if (!zL) {
            f10 = f11;
        }
        float f15 = zL ? f13 : f12;
        if (!zL) {
            f12 = f13;
        }
        le.j jVar = this.D;
        if (jVar != null && jVar.S() == f14 && this.D.T() == f10 && this.D.t() == f15 && this.D.u() == f12) {
            return;
        }
        this.K1 = this.K1.v().K(f14).P(f10).x(f15).C(f12).m();
        m();
    }

    public final int s(@n0 Rect rect, @n0 Rect rect2, float f10) {
        return b0() ? (int) (rect2.top + f10) : rect.bottom - this.f20885d.getCompoundPaddingBottom();
    }

    public void s0(@g.q int i10, @g.q int i11, @g.q int i12, @g.q int i13) {
        r0(getContext().getResources().getDimension(i10), getContext().getResources().getDimension(i11), getContext().getResources().getDimension(i13), getContext().getResources().getDimension(i12));
    }

    public void setBoxBackgroundColor(@g.l int i10) {
        if (this.J7 != i10) {
            this.J7 = i10;
            this.f20880a8 = i10;
            this.f20884c8 = i10;
            this.f20886d8 = i10;
            m();
        }
    }

    public void setBoxBackgroundColorResource(@g.n int i10) {
        setBoxBackgroundColor(h0.d.f(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(@n0 ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f20880a8 = defaultColor;
        this.J7 = defaultColor;
        this.f20882b8 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f20884c8 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.f20886d8 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        m();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.K2) {
            return;
        }
        this.K2 = i10;
        if (this.f20885d != null) {
            f0();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.E7 = i10;
    }

    public void setBoxStrokeColor(@g.l int i10) {
        if (this.Y7 != i10) {
            this.Y7 = i10;
            Q0();
        }
    }

    public void setBoxStrokeColorStateList(@n0 ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.W7 = colorStateList.getDefaultColor();
            this.f20888e8 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.X7 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.Y7 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.Y7 != colorStateList.getDefaultColor()) {
            this.Y7 = colorStateList.getDefaultColor();
        }
        Q0();
    }

    public void setBoxStrokeErrorColor(@p0 ColorStateList colorStateList) {
        if (this.Z7 != colorStateList) {
            this.Z7 = colorStateList;
            Q0();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.G7 = i10;
        Q0();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.H7 = i10;
        Q0();
    }

    public void setBoxStrokeWidthFocusedResource(@g.q int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(@g.q int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f20899k != z10) {
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f20907o = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.N7;
                if (typeface != null) {
                    this.f20907o.setTypeface(typeface);
                }
                this.f20907o.setMaxLines(1);
                this.f20897j.e(this.f20907o, 2);
                androidx.core.view.r.h((ViewGroup.MarginLayoutParams) this.f20907o.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                E0();
                B0();
            } else {
                this.f20897j.G(this.f20907o, 2);
                this.f20907o = null;
            }
            this.f20899k = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f20903l != i10) {
            if (i10 > 0) {
                this.f20903l = i10;
            } else {
                this.f20903l = -1;
            }
            if (this.f20899k) {
                B0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f20908p != i10) {
            this.f20908p = i10;
            E0();
        }
    }

    public void setCounterOverflowTextColor(@p0 ColorStateList colorStateList) {
        if (this.f20920z != colorStateList) {
            this.f20920z = colorStateList;
            E0();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f20909q != i10) {
            this.f20909q = i10;
            E0();
        }
    }

    public void setCounterTextColor(@p0 ColorStateList colorStateList) {
        if (this.f20919y != colorStateList) {
            this.f20919y = colorStateList;
            E0();
        }
    }

    public void setDefaultHintTextColor(@p0 ColorStateList colorStateList) {
        this.U7 = colorStateList;
        this.V7 = colorStateList;
        if (this.f20885d != null) {
            K0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        j0(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f20883c.P(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f20883c.Q(z10);
    }

    public void setEndIconContentDescription(@c1 int i10) {
        this.f20883c.R(i10);
    }

    public void setEndIconDrawable(@g.v int i10) {
        this.f20883c.T(i10);
    }

    public void setEndIconMode(int i10) {
        this.f20883c.V(i10);
    }

    public void setEndIconOnClickListener(@p0 View.OnClickListener onClickListener) {
        this.f20883c.W(onClickListener);
    }

    public void setEndIconOnLongClickListener(@p0 View.OnLongClickListener onLongClickListener) {
        this.f20883c.X(onLongClickListener);
    }

    public void setEndIconTintList(@p0 ColorStateList colorStateList) {
        this.f20883c.Y(colorStateList);
    }

    public void setEndIconTintMode(@p0 PorterDuff.Mode mode) {
        this.f20883c.Z(mode);
    }

    public void setEndIconVisible(boolean z10) {
        this.f20883c.a0(z10);
    }

    public void setError(@p0 CharSequence charSequence) {
        if (!this.f20897j.E()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f20897j.z();
        } else {
            this.f20897j.T(charSequence);
        }
    }

    public void setErrorContentDescription(@p0 CharSequence charSequence) {
        this.f20897j.I(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f20897j.J(z10);
    }

    public void setErrorIconDrawable(@g.v int i10) {
        this.f20883c.b0(i10);
    }

    public void setErrorIconOnClickListener(@p0 View.OnClickListener onClickListener) {
        this.f20883c.d0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(@p0 View.OnLongClickListener onLongClickListener) {
        this.f20883c.e0(onLongClickListener);
    }

    public void setErrorIconTintList(@p0 ColorStateList colorStateList) {
        this.f20883c.f0(colorStateList);
    }

    public void setErrorIconTintMode(@p0 PorterDuff.Mode mode) {
        this.f20883c.g0(mode);
    }

    public void setErrorTextAppearance(@d1 int i10) {
        this.f20897j.K(i10);
    }

    public void setErrorTextColor(@p0 ColorStateList colorStateList) {
        this.f20897j.L(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.f20894h8 != z10) {
            this.f20894h8 = z10;
            K0(false);
        }
    }

    public void setHelperText(@p0 CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (V()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!V()) {
                setHelperTextEnabled(true);
            }
            this.f20897j.U(charSequence);
        }
    }

    public void setHelperTextColor(@p0 ColorStateList colorStateList) {
        this.f20897j.O(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f20897j.N(z10);
    }

    public void setHelperTextTextAppearance(@d1 int i10) {
        this.f20897j.M(i10);
    }

    public void setHint(@p0 CharSequence charSequence) {
        if (this.A) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f20896i8 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.A) {
            this.A = z10;
            if (z10) {
                CharSequence hint = this.f20885d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.B)) {
                        setHint(hint);
                    }
                    this.f20885d.setHint((CharSequence) null);
                }
                this.C = true;
            } else {
                this.C = false;
                if (!TextUtils.isEmpty(this.B) && TextUtils.isEmpty(this.f20885d.getHint())) {
                    this.f20885d.setHint(this.B);
                }
                setHintInternal(null);
            }
            if (this.f20885d != null) {
                J0();
            }
        }
    }

    public void setHintTextAppearance(@d1 int i10) {
        this.f20892g8.h0(i10);
        this.V7 = this.f20892g8.p();
        if (this.f20885d != null) {
            K0(false);
            J0();
        }
    }

    public void setHintTextColor(@p0 ColorStateList colorStateList) {
        if (this.V7 != colorStateList) {
            if (this.U7 == null) {
                this.f20892g8.j0(colorStateList);
            }
            this.V7 = colorStateList;
            if (this.f20885d != null) {
                K0(false);
            }
        }
    }

    public void setLengthCounter(@n0 h hVar) {
        this.f20906n = hVar;
    }

    public void setMaxEms(int i10) {
        this.f20891g = i10;
        EditText editText = this.f20885d;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxEms(i10);
    }

    public void setMaxWidth(@t0 int i10) {
        this.f20895i = i10;
        EditText editText = this.f20885d;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxWidth(i10);
    }

    public void setMaxWidthResource(@g.q int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f20889f = i10;
        EditText editText = this.f20885d;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinEms(i10);
    }

    public void setMinWidth(@t0 int i10) {
        this.f20893h = i10;
        EditText editText = this.f20885d;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinWidth(i10);
    }

    public void setMinWidthResource(@g.q int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@c1 int i10) {
        this.f20883c.i0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@g.v int i10) {
        this.f20883c.k0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        this.f20883c.n0(z10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@p0 ColorStateList colorStateList) {
        this.f20883c.o0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@p0 PorterDuff.Mode mode) {
        this.f20883c.p0(mode);
    }

    public void setPlaceholderText(@p0 CharSequence charSequence) {
        if (this.f20912t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f20912t = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            u0.R1(this.f20912t, 2);
            androidx.transition.i iVarC = C();
            this.f20917w = iVarC;
            iVarC.E0(67L);
            this.f20918x = C();
            setPlaceholderTextAppearance(this.f20914v);
            setPlaceholderTextColor(this.f20913u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f20911s) {
                setPlaceholderTextEnabled(true);
            }
            this.f20910r = charSequence;
        }
        N0();
    }

    public void setPlaceholderTextAppearance(@d1 int i10) {
        this.f20914v = i10;
        TextView textView = this.f20912t;
        if (textView != null) {
            androidx.core.widget.r.E(textView, i10);
        }
    }

    public void setPlaceholderTextColor(@p0 ColorStateList colorStateList) {
        if (this.f20913u != colorStateList) {
            this.f20913u = colorStateList;
            TextView textView = this.f20912t;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@p0 CharSequence charSequence) {
        this.f20881b.l(charSequence);
    }

    public void setPrefixTextAppearance(@d1 int i10) {
        this.f20881b.m(i10);
    }

    public void setPrefixTextColor(@n0 ColorStateList colorStateList) {
        this.f20881b.n(colorStateList);
    }

    public void setStartIconCheckable(boolean z10) {
        this.f20881b.o(z10);
    }

    public void setStartIconContentDescription(@c1 int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(@g.v int i10) {
        setStartIconDrawable(i10 != 0 ? i.a.b(getContext(), i10) : null);
    }

    public void setStartIconOnClickListener(@p0 View.OnClickListener onClickListener) {
        this.f20881b.r(onClickListener);
    }

    public void setStartIconOnLongClickListener(@p0 View.OnLongClickListener onLongClickListener) {
        this.f20881b.s(onLongClickListener);
    }

    public void setStartIconTintList(@p0 ColorStateList colorStateList) {
        this.f20881b.t(colorStateList);
    }

    public void setStartIconTintMode(@p0 PorterDuff.Mode mode) {
        this.f20881b.u(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.f20881b.v(z10);
    }

    public void setSuffixText(@p0 CharSequence charSequence) {
        this.f20883c.q0(charSequence);
    }

    public void setSuffixTextAppearance(@d1 int i10) {
        this.f20883c.r0(i10);
    }

    public void setSuffixTextColor(@n0 ColorStateList colorStateList) {
        this.f20883c.s0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@p0 e eVar) {
        EditText editText = this.f20885d;
        if (editText != null) {
            u0.B1(editText, eVar);
        }
    }

    public void setTypeface(@p0 Typeface typeface) {
        if (typeface != this.N7) {
            this.N7 = typeface;
            this.f20892g8.O0(typeface);
            this.f20897j.Q(typeface);
            TextView textView = this.f20907o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public final int t(@n0 Rect rect, float f10) {
        return b0() ? (int) (rect.centerY() - (f10 / 2.0f)) : rect.top + this.f20885d.getCompoundPaddingTop();
    }

    public final void t0() {
        EditText editText = this.f20885d;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i10 = this.K2;
                if (i10 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i10 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    @n0
    public final Rect u(@n0 Rect rect) {
        if (this.f20885d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.L7;
        float fD = this.f20892g8.D();
        rect2.left = rect.left + this.f20885d.getCompoundPaddingLeft();
        rect2.top = t(rect, fD);
        rect2.right = rect.right - this.f20885d.getCompoundPaddingRight();
        rect2.bottom = s(rect, rect2, fD);
        return rect2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u0(@g.n0 android.widget.TextView r3, @g.d1 int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.r.E(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R.style.TextAppearance_AppCompat_Caption
            androidx.core.widget.r.E(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R.color.design_error
            int r4 = h0.d.f(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.u0(android.widget.TextView, int):void");
    }

    public final int v() {
        float fR;
        if (!this.A) {
            return 0;
        }
        int i10 = this.K2;
        if (i10 == 0) {
            fR = this.f20892g8.r();
        } else {
            if (i10 != 2) {
                return 0;
            }
            fR = this.f20892g8.r() / 2.0f;
        }
        return (int) fR;
    }

    public boolean v0() {
        return this.f20897j.m();
    }

    public final boolean w() {
        return this.K2 == 2 && x();
    }

    public final boolean w0() {
        return (this.f20883c.G() || ((this.f20883c.z() && R()) || this.f20883c.w() != null)) && this.f20883c.getMeasuredWidth() > 0;
    }

    public final boolean x() {
        return this.F7 > -1 && this.I7 != 0;
    }

    public final boolean x0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f20881b.getMeasuredWidth() > 0;
    }

    public void y() {
        this.Q7.clear();
    }

    public final void y0() {
        if (this.f20912t == null || !this.f20911s || TextUtils.isEmpty(this.f20910r)) {
            return;
        }
        this.f20912t.setText(this.f20910r);
        androidx.transition.u.b(this.f20879a, this.f20917w);
        this.f20912t.setVisibility(0);
        this.f20912t.bringToFront();
        announceForAccessibility(this.f20910r);
    }

    public void z() {
        this.f20883c.j();
    }

    public final void z0() {
        if (this.K2 == 1) {
            if (ie.c.j(getContext())) {
                this.E7 = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (ie.c.i(getContext())) {
                this.E7 = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    public TextInputLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setEndIconContentDescription(@p0 CharSequence charSequence) {
        this.f20883c.S(charSequence);
    }

    public void setEndIconDrawable(@p0 Drawable drawable) {
        this.f20883c.U(drawable);
    }

    public void setErrorIconDrawable(@p0 Drawable drawable) {
        this.f20883c.c0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@p0 CharSequence charSequence) {
        this.f20883c.j0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@p0 Drawable drawable) {
        this.f20883c.m0(drawable);
    }

    public void setStartIconContentDescription(@p0 CharSequence charSequence) {
        this.f20881b.p(charSequence);
    }

    public void setStartIconDrawable(@p0 Drawable drawable) {
        this.f20881b.q(drawable);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v66 */
    public TextInputLayout(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        ?? r32;
        int i11 = f20865m8;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20889f = -1;
        this.f20891g = -1;
        this.f20893h = -1;
        this.f20895i = -1;
        this.f20897j = new u(this);
        this.f20906n = new h() { // from class: com.google.android.material.textfield.a0
            @Override // com.google.android.material.textfield.TextInputLayout.h
            public final int a(Editable editable) {
                return TextInputLayout.e0(editable);
            }
        };
        this.K7 = new Rect();
        this.L7 = new Rect();
        this.M7 = new RectF();
        this.Q7 = new LinkedHashSet<>();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f20892g8 = bVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f20879a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = kd.a.f37166a;
        bVar.M0(timeInterpolator);
        bVar.H0(timeInterpolator);
        bVar.k0(8388659);
        int[] iArr = R.styleable.TextInputLayout;
        int i12 = R.styleable.TextInputLayout_counterTextAppearance;
        int i13 = R.styleable.TextInputLayout_counterOverflowTextAppearance;
        int i14 = R.styleable.TextInputLayout_errorTextAppearance;
        int i15 = R.styleable.TextInputLayout_helperTextTextAppearance;
        int i16 = R.styleable.TextInputLayout_hintTextAppearance;
        y0 y0VarL = com.google.android.material.internal.t.l(context2, attributeSet, iArr, i10, i11, i12, i13, i14, i15, i16);
        z zVar = new z(this, y0VarL);
        this.f20881b = zVar;
        this.A = y0VarL.a(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(y0VarL.x(R.styleable.TextInputLayout_android_hint));
        this.f20896i8 = y0VarL.a(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.f20894h8 = y0VarL.a(R.styleable.TextInputLayout_expandedHintEnabled, true);
        int i17 = R.styleable.TextInputLayout_android_minEms;
        if (y0VarL.C(i17)) {
            setMinEms(y0VarL.o(i17, -1));
        } else {
            int i18 = R.styleable.TextInputLayout_android_minWidth;
            if (y0VarL.C(i18)) {
                setMinWidth(y0VarL.g(i18, -1));
            }
        }
        int i19 = R.styleable.TextInputLayout_android_maxEms;
        if (y0VarL.C(i19)) {
            setMaxEms(y0VarL.o(i19, -1));
        } else {
            int i20 = R.styleable.TextInputLayout_android_maxWidth;
            if (y0VarL.C(i20)) {
                setMaxWidth(y0VarL.g(i20, -1));
            }
        }
        this.K1 = le.o.e(context2, attributeSet, i10, i11).m();
        this.C2 = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.E7 = y0VarL.f(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.G7 = y0VarL.g(R.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.H7 = y0VarL.g(R.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.F7 = this.G7;
        float fE = y0VarL.e(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fE2 = y0VarL.e(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fE3 = y0VarL.e(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fE4 = y0VarL.e(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        o.b bVarV = this.K1.v();
        if (fE >= 0.0f) {
            bVarV.K(fE);
        }
        if (fE2 >= 0.0f) {
            bVarV.P(fE2);
        }
        if (fE3 >= 0.0f) {
            bVarV.C(fE3);
        }
        if (fE4 >= 0.0f) {
            bVarV.x(fE4);
        }
        this.K1 = bVarV.m();
        ColorStateList colorStateListB = ie.c.b(context2, y0VarL, R.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f20880a8 = defaultColor;
            this.J7 = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f20882b8 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f20884c8 = colorStateListB.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.f20886d8 = colorStateListB.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.f20884c8 = this.f20880a8;
                ColorStateList colorStateListA = i.a.a(context2, R.color.mtrl_filled_background_color);
                this.f20882b8 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.f20886d8 = colorStateListA.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.J7 = 0;
            this.f20880a8 = 0;
            this.f20882b8 = 0;
            this.f20884c8 = 0;
            this.f20886d8 = 0;
        }
        int i21 = R.styleable.TextInputLayout_android_textColorHint;
        if (y0VarL.C(i21)) {
            ColorStateList colorStateListD = y0VarL.d(i21);
            this.V7 = colorStateListD;
            this.U7 = colorStateListD;
        }
        int i22 = R.styleable.TextInputLayout_boxStrokeColor;
        ColorStateList colorStateListB2 = ie.c.b(context2, y0VarL, i22);
        this.Y7 = y0VarL.c(i22, 0);
        this.W7 = h0.d.f(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.f20888e8 = h0.d.f(context2, R.color.mtrl_textinput_disabled_color);
        this.X7 = h0.d.f(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i23 = R.styleable.TextInputLayout_boxStrokeErrorColor;
        if (y0VarL.C(i23)) {
            setBoxStrokeErrorColor(ie.c.b(context2, y0VarL, i23));
        }
        if (y0VarL.u(i16, -1) != -1) {
            r32 = 0;
            setHintTextAppearance(y0VarL.u(i16, 0));
        } else {
            r32 = 0;
        }
        int iU = y0VarL.u(i14, r32);
        CharSequence charSequenceX = y0VarL.x(R.styleable.TextInputLayout_errorContentDescription);
        boolean zA = y0VarL.a(R.styleable.TextInputLayout_errorEnabled, r32);
        int iU2 = y0VarL.u(i15, r32);
        boolean zA2 = y0VarL.a(R.styleable.TextInputLayout_helperTextEnabled, r32);
        CharSequence charSequenceX2 = y0VarL.x(R.styleable.TextInputLayout_helperText);
        int iU3 = y0VarL.u(R.styleable.TextInputLayout_placeholderTextAppearance, r32);
        CharSequence charSequenceX3 = y0VarL.x(R.styleable.TextInputLayout_placeholderText);
        boolean zA3 = y0VarL.a(R.styleable.TextInputLayout_counterEnabled, r32);
        setCounterMaxLength(y0VarL.o(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.f20909q = y0VarL.u(i12, 0);
        this.f20908p = y0VarL.u(i13, 0);
        setBoxBackgroundMode(y0VarL.o(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(charSequenceX);
        setCounterOverflowTextAppearance(this.f20908p);
        setHelperTextTextAppearance(iU2);
        setErrorTextAppearance(iU);
        setCounterTextAppearance(this.f20909q);
        setPlaceholderText(charSequenceX3);
        setPlaceholderTextAppearance(iU3);
        int i24 = R.styleable.TextInputLayout_errorTextColor;
        if (y0VarL.C(i24)) {
            setErrorTextColor(y0VarL.d(i24));
        }
        int i25 = R.styleable.TextInputLayout_helperTextTextColor;
        if (y0VarL.C(i25)) {
            setHelperTextColor(y0VarL.d(i25));
        }
        int i26 = R.styleable.TextInputLayout_hintTextColor;
        if (y0VarL.C(i26)) {
            setHintTextColor(y0VarL.d(i26));
        }
        int i27 = R.styleable.TextInputLayout_counterTextColor;
        if (y0VarL.C(i27)) {
            setCounterTextColor(y0VarL.d(i27));
        }
        int i28 = R.styleable.TextInputLayout_counterOverflowTextColor;
        if (y0VarL.C(i28)) {
            setCounterOverflowTextColor(y0VarL.d(i28));
        }
        int i29 = R.styleable.TextInputLayout_placeholderTextColor;
        if (y0VarL.C(i29)) {
            setPlaceholderTextColor(y0VarL.d(i29));
        }
        r rVar = new r(this, y0VarL);
        this.f20883c = rVar;
        boolean zA4 = y0VarL.a(R.styleable.TextInputLayout_android_enabled, true);
        y0VarL.I();
        u0.R1(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            u0.S1(this, 1);
        }
        frameLayout.addView(zVar);
        frameLayout.addView(rVar);
        addView(frameLayout);
        setEnabled(zA4);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceX2);
    }

    public void setHint(@c1 int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }
}
