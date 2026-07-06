package a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Animator f1102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f1104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f1105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameLayout f1106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f1107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f1108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextInputLayout f1109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1111a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f1112b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f1113b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f1114b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1115b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f1116c;
    public int d;
    public int e;
    public int f;

    public h20(TextInputLayout textInputLayout) {
        this.f1103a = textInputLayout.getContext();
        this.f1109a = textInputLayout;
        this.f6266a = r0.getResources().getDimensionPixelSize(bv.design_textinput_caption_translate_y);
    }

    public void A(CharSequence charSequence) {
        this.f1114b = charSequence;
        TextView textView = this.f1108a;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void B(boolean z) {
        if (this.f1111a == z) {
            return;
        }
        g();
        if (z) {
            w6 w6Var = new w6(this.f1103a);
            this.f1108a = w6Var;
            w6Var.setId(dv.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.f1108a.setTextAlignment(5);
            }
            Typeface typeface = this.f1105a;
            if (typeface != null) {
                this.f1108a.setTypeface(typeface);
            }
            C(this.e);
            D(this.f1104a);
            A(this.f1114b);
            this.f1108a.setVisibility(4);
            eh.l0(this.f1108a, 1);
            d(this.f1108a, 0);
        } else {
            s();
            y(this.f1108a, 0);
            this.f1108a = null;
            this.f1109a.k0();
            this.f1109a.y0();
        }
        this.f1111a = z;
    }

    public void C(int i) {
        this.e = i;
        TextView textView = this.f1108a;
        if (textView != null) {
            this.f1109a.Y(textView, i);
        }
    }

    public void D(ColorStateList colorStateList) {
        this.f1104a = colorStateList;
        TextView textView = this.f1108a;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void E(int i) {
        this.f = i;
        TextView textView = this.f1113b;
        if (textView != null) {
            oj.q(textView, i);
        }
    }

    public void F(boolean z) {
        if (this.f1115b == z) {
            return;
        }
        g();
        if (z) {
            w6 w6Var = new w6(this.f1103a);
            this.f1113b = w6Var;
            w6Var.setId(dv.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                this.f1113b.setTextAlignment(5);
            }
            Typeface typeface = this.f1105a;
            if (typeface != null) {
                this.f1113b.setTypeface(typeface);
            }
            this.f1113b.setVisibility(4);
            eh.l0(this.f1113b, 1);
            E(this.f);
            G(this.f1112b);
            d(this.f1113b, 1);
        } else {
            t();
            y(this.f1113b, 1);
            this.f1113b = null;
            this.f1109a.k0();
            this.f1109a.y0();
        }
        this.f1115b = z;
    }

    public void G(ColorStateList colorStateList) {
        this.f1112b = colorStateList;
        TextView textView = this.f1113b;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public final void H(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void I(Typeface typeface) {
        if (typeface != this.f1105a) {
            this.f1105a = typeface;
            H(this.f1108a, typeface);
            H(this.f1113b, typeface);
        }
    }

    public final void J(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean K(TextView textView, CharSequence charSequence) {
        return eh.Q(this.f1109a) && this.f1109a.isEnabled() && !(this.d == this.c && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public void L(CharSequence charSequence) {
        g();
        this.f1110a = charSequence;
        this.f1108a.setText(charSequence);
        if (this.c != 1) {
            this.d = 1;
        }
        N(this.c, this.d, K(this.f1108a, charSequence));
    }

    public void M(CharSequence charSequence) {
        g();
        this.f1116c = charSequence;
        this.f1113b.setText(charSequence);
        if (this.c != 2) {
            this.d = 2;
        }
        N(this.c, this.d, K(this.f1113b, charSequence));
    }

    public final void N(int i, int i2, boolean z) {
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f1102a = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.f1115b, this.f1113b, 2, i, i2);
            h(arrayList, this.f1111a, this.f1108a, 1, i, i2);
            lv.a(animatorSet, arrayList);
            animatorSet.addListener(new g20(this, i2, l(i), i, l(i2)));
            animatorSet.start();
        } else {
            z(i, i2);
        }
        this.f1109a.k0();
        this.f1109a.o0(z);
        this.f1109a.y0();
    }

    public void d(TextView textView, int i) {
        if (this.f1107a == null && this.f1106a == null) {
            LinearLayout linearLayout = new LinearLayout(this.f1103a);
            this.f1107a = linearLayout;
            linearLayout.setOrientation(0);
            this.f1109a.addView(this.f1107a, -1, -2);
            this.f1106a = new FrameLayout(this.f1103a);
            this.f1107a.addView(this.f1106a, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f1109a.getEditText() != null) {
                e();
            }
        }
        if (v(i)) {
            this.f1106a.setVisibility(0);
            this.f1106a.addView(textView);
            this.b++;
        } else {
            this.f1107a.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f1107a.setVisibility(0);
        this.f1101a++;
    }

    public void e() {
        if (f()) {
            eh.w0(this.f1107a, eh.D(this.f1109a.getEditText()), 0, eh.C(this.f1109a.getEditText()), 0);
        }
    }

    public final boolean f() {
        return (this.f1107a == null || this.f1109a.getEditText() == null) ? false : true;
    }

    public void g() {
        Animator animator = this.f1102a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void h(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(i(textView, i3 == i));
            if (i3 == i) {
                list.add(j(textView));
            }
        }
    }

    public final ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(kv.f6644a);
        return objectAnimatorOfFloat;
    }

    public final ObjectAnimator j(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f6266a, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(kv.d);
        return objectAnimatorOfFloat;
    }

    public boolean k() {
        return u(this.d);
    }

    public final TextView l(int i) {
        if (i == 1) {
            return this.f1108a;
        }
        if (i != 2) {
            return null;
        }
        return this.f1113b;
    }

    public CharSequence m() {
        return this.f1114b;
    }

    public CharSequence n() {
        return this.f1110a;
    }

    public int o() {
        TextView textView = this.f1108a;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public ColorStateList p() {
        TextView textView = this.f1108a;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence q() {
        return this.f1116c;
    }

    public int r() {
        TextView textView = this.f1113b;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void s() {
        this.f1110a = null;
        g();
        if (this.c == 1) {
            this.d = (!this.f1115b || TextUtils.isEmpty(this.f1116c)) ? 0 : 2;
        }
        N(this.c, this.d, K(this.f1108a, null));
    }

    public void t() {
        g();
        if (this.c == 2) {
            this.d = 0;
        }
        N(this.c, this.d, K(this.f1113b, null));
    }

    public final boolean u(int i) {
        return (i != 1 || this.f1108a == null || TextUtils.isEmpty(this.f1110a)) ? false : true;
    }

    public boolean v(int i) {
        return i == 0 || i == 1;
    }

    public boolean w() {
        return this.f1111a;
    }

    public boolean x() {
        return this.f1115b;
    }

    public void y(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f1107a == null) {
            return;
        }
        if (!v(i) || (frameLayout = this.f1106a) == null) {
            this.f1107a.removeView(textView);
        } else {
            int i2 = this.b - 1;
            this.b = i2;
            J(frameLayout, i2);
            this.f1106a.removeView(textView);
        }
        int i3 = this.f1101a - 1;
        this.f1101a = i3;
        J(this.f1107a, i3);
    }

    public final void z(int i, int i2) {
        TextView textViewL;
        TextView textViewL2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (textViewL2 = l(i2)) != null) {
            textViewL2.setVisibility(0);
            textViewL2.setAlpha(1.0f);
        }
        if (i != 0 && (textViewL = l(i)) != null) {
            textViewL.setVisibility(4);
            if (i == 1) {
                textViewL.setText((CharSequence) null);
            }
        }
        this.c = i2;
    }
}
