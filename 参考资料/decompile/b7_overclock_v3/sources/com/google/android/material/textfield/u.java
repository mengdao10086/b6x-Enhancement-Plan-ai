package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.d1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f20999v = 217;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f21000w = 167;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f21001x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f21002y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f21003z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextInputLayout f21005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f21006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f21008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public Animator f21009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f21010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public CharSequence f21013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f21014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public TextView f21015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public CharSequence f21016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f21017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public ColorStateList f21018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f21019p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21020q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public TextView f21021r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f21022s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public ColorStateList f21023t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Typeface f21024u;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f21026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f21027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f21028d;

        public a(int i10, TextView textView, int i11, TextView textView2) {
            this.f21025a = i10;
            this.f21026b = textView;
            this.f21027c = i11;
            this.f21028d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u.this.f21011h = this.f21025a;
            u.this.f21009f = null;
            TextView textView = this.f21026b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f21027c == 1 && u.this.f21015l != null) {
                    u.this.f21015l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f21028d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f21028d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f21028d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public class b extends View.AccessibilityDelegate {
        public b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = u.this.f21005b.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public u(@n0 TextInputLayout textInputLayout) {
        this.f21004a = textInputLayout.getContext();
        this.f21005b = textInputLayout;
        this.f21010g = r0.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public void A() {
        h();
        int i10 = this.f21011h;
        if (i10 == 2) {
            this.f21012i = 0;
        }
        V(i10, this.f21012i, S(this.f21021r, ""));
    }

    public final boolean B(int i10) {
        return (i10 != 1 || this.f21015l == null || TextUtils.isEmpty(this.f21013j)) ? false : true;
    }

    public final boolean C(int i10) {
        return (i10 != 2 || this.f21021r == null || TextUtils.isEmpty(this.f21019p)) ? false : true;
    }

    public boolean D(int i10) {
        return i10 == 0 || i10 == 1;
    }

    public boolean E() {
        return this.f21014k;
    }

    public boolean F() {
        return this.f21020q;
    }

    public void G(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f21006c == null) {
            return;
        }
        if (!D(i10) || (frameLayout = this.f21008e) == null) {
            this.f21006c.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i11 = this.f21007d - 1;
        this.f21007d = i11;
        R(this.f21006c, i11);
    }

    public final void H(int i10, int i11) {
        TextView textViewN;
        TextView textViewN2;
        if (i10 == i11) {
            return;
        }
        if (i11 != 0 && (textViewN2 = n(i11)) != null) {
            textViewN2.setVisibility(0);
            textViewN2.setAlpha(1.0f);
        }
        if (i10 != 0 && (textViewN = n(i10)) != null) {
            textViewN.setVisibility(4);
            if (i10 == 1) {
                textViewN.setText((CharSequence) null);
            }
        }
        this.f21011h = i11;
    }

    public void I(@p0 CharSequence charSequence) {
        this.f21016m = charSequence;
        TextView textView = this.f21015l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void J(boolean z10) {
        if (this.f21014k == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f21004a);
            this.f21015l = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            this.f21015l.setTextAlignment(5);
            Typeface typeface = this.f21024u;
            if (typeface != null) {
                this.f21015l.setTypeface(typeface);
            }
            K(this.f21017n);
            L(this.f21018o);
            I(this.f21016m);
            this.f21015l.setVisibility(4);
            u0.D1(this.f21015l, 1);
            e(this.f21015l, 0);
        } else {
            z();
            G(this.f21015l, 0);
            this.f21015l = null;
            this.f21005b.G0();
            this.f21005b.Q0();
        }
        this.f21014k = z10;
    }

    public void K(@d1 int i10) {
        this.f21017n = i10;
        TextView textView = this.f21015l;
        if (textView != null) {
            this.f21005b.u0(textView, i10);
        }
    }

    public void L(@p0 ColorStateList colorStateList) {
        this.f21018o = colorStateList;
        TextView textView = this.f21015l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void M(@d1 int i10) {
        this.f21022s = i10;
        TextView textView = this.f21021r;
        if (textView != null) {
            androidx.core.widget.r.E(textView, i10);
        }
    }

    public void N(boolean z10) {
        if (this.f21020q == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f21004a);
            this.f21021r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            this.f21021r.setTextAlignment(5);
            Typeface typeface = this.f21024u;
            if (typeface != null) {
                this.f21021r.setTypeface(typeface);
            }
            this.f21021r.setVisibility(4);
            u0.D1(this.f21021r, 1);
            M(this.f21022s);
            O(this.f21023t);
            e(this.f21021r, 1);
            this.f21021r.setAccessibilityDelegate(new b());
        } else {
            A();
            G(this.f21021r, 1);
            this.f21021r = null;
            this.f21005b.G0();
            this.f21005b.Q0();
        }
        this.f21020q = z10;
    }

    public void O(@p0 ColorStateList colorStateList) {
        this.f21023t = colorStateList;
        TextView textView = this.f21021r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public final void P(@p0 TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void Q(Typeface typeface) {
        if (typeface != this.f21024u) {
            this.f21024u = typeface;
            P(this.f21015l, typeface);
            P(this.f21021r, typeface);
        }
    }

    public final void R(@n0 ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean S(@p0 TextView textView, @n0 CharSequence charSequence) {
        return u0.U0(this.f21005b) && this.f21005b.isEnabled() && !(this.f21012i == this.f21011h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public void T(CharSequence charSequence) {
        h();
        this.f21013j = charSequence;
        this.f21015l.setText(charSequence);
        int i10 = this.f21011h;
        if (i10 != 1) {
            this.f21012i = 1;
        }
        V(i10, this.f21012i, S(this.f21015l, charSequence));
    }

    public void U(CharSequence charSequence) {
        h();
        this.f21019p = charSequence;
        this.f21021r.setText(charSequence);
        int i10 = this.f21011h;
        if (i10 != 2) {
            this.f21012i = 2;
        }
        V(i10, this.f21012i, S(this.f21021r, charSequence));
    }

    public final void V(int i10, int i11, boolean z10) {
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f21009f = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f21020q, this.f21021r, 2, i10, i11);
            i(arrayList, this.f21014k, this.f21015l, 1, i10, i11);
            kd.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i11, n(i10), i10, n(i11)));
            animatorSet.start();
        } else {
            H(i10, i11);
        }
        this.f21005b.G0();
        this.f21005b.K0(z10);
        this.f21005b.Q0();
    }

    public void e(TextView textView, int i10) {
        if (this.f21006c == null && this.f21008e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f21004a);
            this.f21006c = linearLayout;
            linearLayout.setOrientation(0);
            this.f21005b.addView(this.f21006c, -1, -2);
            this.f21008e = new FrameLayout(this.f21004a);
            this.f21006c.addView(this.f21008e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f21005b.getEditText() != null) {
                f();
            }
        }
        if (D(i10)) {
            this.f21008e.setVisibility(0);
            this.f21008e.addView(textView);
        } else {
            this.f21006c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f21006c.setVisibility(0);
        this.f21007d++;
    }

    public void f() {
        if (g()) {
            EditText editText = this.f21005b.getEditText();
            boolean zI = ie.c.i(this.f21004a);
            LinearLayout linearLayout = this.f21006c;
            int i10 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            u0.d2(linearLayout, w(zI, i10, u0.k0(editText)), w(zI, R.dimen.material_helper_text_font_1_3_padding_top, this.f21004a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), w(zI, i10, u0.j0(editText)), 0);
        }
    }

    public final boolean g() {
        return (this.f21006c == null || this.f21005b.getEditText() == null) ? false : true;
    }

    public void h() {
        Animator animator = this.f21009f;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void i(@n0 List<Animator> list, boolean z10, @p0 TextView textView, int i10, int i11, int i12) {
        if (textView == null || !z10) {
            return;
        }
        if (i10 == i12 || i10 == i11) {
            list.add(j(textView, i12 == i10));
            if (i12 == i10) {
                list.add(k(textView));
            }
        }
    }

    public final ObjectAnimator j(TextView textView, boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z10 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(kd.a.f37166a);
        return objectAnimatorOfFloat;
    }

    public final ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f21010g, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(kd.a.f37169d);
        return objectAnimatorOfFloat;
    }

    public boolean l() {
        return B(this.f21011h);
    }

    public boolean m() {
        return B(this.f21012i);
    }

    @p0
    public final TextView n(int i10) {
        if (i10 == 1) {
            return this.f21015l;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f21021r;
    }

    @p0
    public CharSequence o() {
        return this.f21016m;
    }

    @p0
    public CharSequence p() {
        return this.f21013j;
    }

    @g.l
    public int q() {
        TextView textView = this.f21015l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @p0
    public ColorStateList r() {
        TextView textView = this.f21015l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence s() {
        return this.f21019p;
    }

    @p0
    public View t() {
        return this.f21021r;
    }

    @p0
    public ColorStateList u() {
        TextView textView = this.f21021r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    @g.l
    public int v() {
        TextView textView = this.f21021r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int w(boolean z10, @g.q int i10, int i11) {
        return z10 ? this.f21004a.getResources().getDimensionPixelSize(i10) : i11;
    }

    public boolean x() {
        return C(this.f21011h);
    }

    public boolean y() {
        return C(this.f21012i);
    }

    public void z() {
        this.f21013j = null;
        h();
        if (this.f21011h == 1) {
            if (!this.f21020q || TextUtils.isEmpty(this.f21019p)) {
                this.f21012i = 0;
            } else {
                this.f21012i = 2;
            }
        }
        V(this.f21011h, this.f21012i, S(this.f21015l, ""));
    }
}
