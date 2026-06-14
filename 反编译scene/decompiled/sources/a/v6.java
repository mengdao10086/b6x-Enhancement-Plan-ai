package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class v6 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a7 f3243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public m8 f3244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f3245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextView f3246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3247a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public m8 f3248b;
    public m8 c;
    public m8 d;
    public m8 e;
    public m8 f;
    public m8 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7661a = 0;
    public int b = -1;

    public v6(TextView textView) {
        this.f3246a = textView;
        this.f3243a = new a7(this.f3246a);
    }

    public static m8 d(Context context, v5 v5Var, int i) {
        ColorStateList colorStateListF = v5Var.f(context, i);
        if (colorStateListF == null) {
            return null;
        }
        m8 m8Var = new m8();
        m8Var.b = true;
        m8Var.f6781a = colorStateListF;
        return m8Var;
    }

    public final void A(int i, float f) {
        this.f3243a.y(i, f);
    }

    public final void B(Context context, o8 o8Var) {
        String strO;
        Typeface typefaceCreate;
        Typeface typeface;
        this.f7661a = o8Var.k(c0.TextAppearance_android_textStyle, this.f7661a);
        if (Build.VERSION.SDK_INT >= 28) {
            int iK = o8Var.k(c0.TextAppearance_android_textFontWeight, -1);
            this.b = iK;
            if (iK != -1) {
                this.f7661a = (this.f7661a & 2) | 0;
            }
        }
        if (!o8Var.s(c0.TextAppearance_android_fontFamily) && !o8Var.s(c0.TextAppearance_fontFamily)) {
            if (o8Var.s(c0.TextAppearance_android_typeface)) {
                this.f3247a = false;
                int iK2 = o8Var.k(c0.TextAppearance_android_typeface, 1);
                if (iK2 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (iK2 == 2) {
                    typeface = Typeface.SERIF;
                } else if (iK2 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.f3245a = typeface;
                return;
            }
            return;
        }
        this.f3245a = null;
        int i = o8Var.s(c0.TextAppearance_fontFamily) ? c0.TextAppearance_fontFamily : c0.TextAppearance_android_fontFamily;
        int i2 = this.b;
        int i3 = this.f7661a;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = o8Var.j(i, this.f7661a, new u6(this, i2, i3, new WeakReference(this.f3246a)));
                if (typefaceJ != null) {
                    if (Build.VERSION.SDK_INT >= 28 && this.b != -1) {
                        typefaceJ = Typeface.create(Typeface.create(typefaceJ, 0), this.b, (this.f7661a & 2) != 0);
                    }
                    this.f3245a = typefaceJ;
                }
                this.f3247a = this.f3245a == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f3245a != null || (strO = o8Var.o(i)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.b == -1) {
            typefaceCreate = Typeface.create(strO, this.f7661a);
        } else {
            typefaceCreate = Typeface.create(Typeface.create(strO, 0), this.b, (this.f7661a & 2) != 0);
        }
        this.f3245a = typefaceCreate;
    }

    public final void a(Drawable drawable, m8 m8Var) {
        if (drawable == null || m8Var == null) {
            return;
        }
        v5.i(drawable, m8Var, this.f3246a.getDrawableState());
    }

    public void b() {
        if (this.f3244a != null || this.f3248b != null || this.c != null || this.d != null) {
            Drawable[] compoundDrawables = this.f3246a.getCompoundDrawables();
            a(compoundDrawables[0], this.f3244a);
            a(compoundDrawables[1], this.f3248b);
            a(compoundDrawables[2], this.c);
            a(compoundDrawables[3], this.d);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.e == null && this.f == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f3246a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.e);
            a(compoundDrawablesRelative[2], this.f);
        }
    }

    public void c() {
        this.f3243a.b();
    }

    public int e() {
        return this.f3243a.j();
    }

    public int f() {
        return this.f3243a.k();
    }

    public int g() {
        return this.f3243a.l();
    }

    public int[] h() {
        return this.f3243a.m();
    }

    public int i() {
        return this.f3243a.n();
    }

    public ColorStateList j() {
        m8 m8Var = this.g;
        if (m8Var != null) {
            return m8Var.f6781a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        m8 m8Var = this.g;
        if (m8Var != null) {
            return m8Var.f1904a;
        }
        return null;
    }

    public boolean l() {
        return this.f3243a.s();
    }

    @SuppressLint({"NewApi"})
    public void m(AttributeSet attributeSet, int i) {
        boolean zA;
        boolean z;
        ColorStateList colorStateListC;
        String strO;
        ColorStateList colorStateListC2;
        String strO2;
        ColorStateList colorStateListC3;
        boolean z2;
        int i2;
        Context context = this.f3246a.getContext();
        v5 v5VarB = v5.b();
        o8 o8VarV = o8.v(context, attributeSet, c0.AppCompatTextHelper, i, 0);
        TextView textView = this.f3246a;
        eh.i0(textView, textView.getContext(), c0.AppCompatTextHelper, attributeSet, o8VarV.r(), i, 0);
        int iN = o8VarV.n(c0.AppCompatTextHelper_android_textAppearance, -1);
        if (o8VarV.s(c0.AppCompatTextHelper_android_drawableLeft)) {
            this.f3244a = d(context, v5VarB, o8VarV.n(c0.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (o8VarV.s(c0.AppCompatTextHelper_android_drawableTop)) {
            this.f3248b = d(context, v5VarB, o8VarV.n(c0.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (o8VarV.s(c0.AppCompatTextHelper_android_drawableRight)) {
            this.c = d(context, v5VarB, o8VarV.n(c0.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (o8VarV.s(c0.AppCompatTextHelper_android_drawableBottom)) {
            this.d = d(context, v5VarB, o8VarV.n(c0.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (o8VarV.s(c0.AppCompatTextHelper_android_drawableStart)) {
                this.e = d(context, v5VarB, o8VarV.n(c0.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (o8VarV.s(c0.AppCompatTextHelper_android_drawableEnd)) {
                this.f = d(context, v5VarB, o8VarV.n(c0.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        o8VarV.w();
        boolean z3 = this.f3246a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iN != -1) {
            o8 o8VarT = o8.t(context, iN, c0.TextAppearance);
            if (z3 || !o8VarT.s(c0.TextAppearance_textAllCaps)) {
                zA = false;
                z = false;
            } else {
                zA = o8VarT.a(c0.TextAppearance_textAllCaps, false);
                z = true;
            }
            B(context, o8VarT);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateListC3 = o8VarT.s(c0.TextAppearance_android_textColor) ? o8VarT.c(c0.TextAppearance_android_textColor) : null;
                colorStateListC = o8VarT.s(c0.TextAppearance_android_textColorHint) ? o8VarT.c(c0.TextAppearance_android_textColorHint) : null;
                colorStateListC2 = o8VarT.s(c0.TextAppearance_android_textColorLink) ? o8VarT.c(c0.TextAppearance_android_textColorLink) : null;
            } else {
                colorStateListC = null;
                colorStateListC2 = null;
                colorStateListC3 = null;
            }
            strO2 = o8VarT.s(c0.TextAppearance_textLocale) ? o8VarT.o(c0.TextAppearance_textLocale) : null;
            strO = (Build.VERSION.SDK_INT < 26 || !o8VarT.s(c0.TextAppearance_fontVariationSettings)) ? null : o8VarT.o(c0.TextAppearance_fontVariationSettings);
            o8VarT.w();
        } else {
            zA = false;
            z = false;
            colorStateListC = null;
            strO = null;
            colorStateListC2 = null;
            strO2 = null;
            colorStateListC3 = null;
        }
        o8 o8VarV2 = o8.v(context, attributeSet, c0.TextAppearance, i, 0);
        if (z3 || !o8VarV2.s(c0.TextAppearance_textAllCaps)) {
            z2 = z;
        } else {
            zA = o8VarV2.a(c0.TextAppearance_textAllCaps, false);
            z2 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (o8VarV2.s(c0.TextAppearance_android_textColor)) {
                colorStateListC3 = o8VarV2.c(c0.TextAppearance_android_textColor);
            }
            if (o8VarV2.s(c0.TextAppearance_android_textColorHint)) {
                colorStateListC = o8VarV2.c(c0.TextAppearance_android_textColorHint);
            }
            if (o8VarV2.s(c0.TextAppearance_android_textColorLink)) {
                colorStateListC2 = o8VarV2.c(c0.TextAppearance_android_textColorLink);
            }
        }
        if (o8VarV2.s(c0.TextAppearance_textLocale)) {
            strO2 = o8VarV2.o(c0.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && o8VarV2.s(c0.TextAppearance_fontVariationSettings)) {
            strO = o8VarV2.o(c0.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && o8VarV2.s(c0.TextAppearance_android_textSize) && o8VarV2.f(c0.TextAppearance_android_textSize, -1) == 0) {
            this.f3246a.setTextSize(0, 0.0f);
        }
        B(context, o8VarV2);
        o8VarV2.w();
        if (colorStateListC3 != null) {
            this.f3246a.setTextColor(colorStateListC3);
        }
        if (colorStateListC != null) {
            this.f3246a.setHintTextColor(colorStateListC);
        }
        if (colorStateListC2 != null) {
            this.f3246a.setLinkTextColor(colorStateListC2);
        }
        if (!z3 && z2) {
            r(zA);
        }
        Typeface typeface = this.f3245a;
        if (typeface != null) {
            if (this.b == -1) {
                this.f3246a.setTypeface(typeface, this.f7661a);
            } else {
                this.f3246a.setTypeface(typeface);
            }
        }
        if (strO != null) {
            this.f3246a.setFontVariationSettings(strO);
        }
        if (strO2 != null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                this.f3246a.setTextLocales(LocaleList.forLanguageTags(strO2));
            } else if (i3 >= 21) {
                this.f3246a.setTextLocale(Locale.forLanguageTag(strO2.substring(0, strO2.indexOf(44))));
            }
        }
        this.f3243a.t(attributeSet, i);
        if (fj.f6112a && this.f3243a.n() != 0) {
            int[] iArrM = this.f3243a.m();
            if (iArrM.length > 0) {
                if (this.f3246a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f3246a.setAutoSizeTextTypeUniformWithConfiguration(this.f3243a.k(), this.f3243a.j(), this.f3243a.l(), 0);
                } else {
                    this.f3246a.setAutoSizeTextTypeUniformWithPresetSizes(iArrM, 0);
                }
            }
        }
        o8 o8VarU = o8.u(context, attributeSet, c0.AppCompatTextView);
        int iN2 = o8VarU.n(c0.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawableC = iN2 != -1 ? v5VarB.c(context, iN2) : null;
        int iN3 = o8VarU.n(c0.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableC2 = iN3 != -1 ? v5VarB.c(context, iN3) : null;
        int iN4 = o8VarU.n(c0.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableC3 = iN4 != -1 ? v5VarB.c(context, iN4) : null;
        int iN5 = o8VarU.n(c0.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableC4 = iN5 != -1 ? v5VarB.c(context, iN5) : null;
        int iN6 = o8VarU.n(c0.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableC5 = iN6 != -1 ? v5VarB.c(context, iN6) : null;
        int iN7 = o8VarU.n(c0.AppCompatTextView_drawableEndCompat, -1);
        x(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? v5VarB.c(context, iN7) : null);
        if (o8VarU.s(c0.AppCompatTextView_drawableTint)) {
            oj.j(this.f3246a, o8VarU.c(c0.AppCompatTextView_drawableTint));
        }
        if (o8VarU.s(c0.AppCompatTextView_drawableTintMode)) {
            i2 = -1;
            oj.k(this.f3246a, e7.d(o8VarU.k(c0.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i2 = -1;
        }
        int iF = o8VarU.f(c0.AppCompatTextView_firstBaselineToTopHeight, i2);
        int iF2 = o8VarU.f(c0.AppCompatTextView_lastBaselineToBottomHeight, i2);
        int iF3 = o8VarU.f(c0.AppCompatTextView_lineHeight, i2);
        o8VarU.w();
        if (iF != i2) {
            oj.m(this.f3246a, iF);
        }
        if (iF2 != i2) {
            oj.n(this.f3246a, iF2);
        }
        if (iF3 != i2) {
            oj.o(this.f3246a, iF3);
        }
    }

    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f3247a) {
            this.f3245a = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f7661a);
            }
        }
    }

    public void o(boolean z, int i, int i2, int i3, int i4) {
        if (fj.f6112a) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i) {
        String strO;
        ColorStateList colorStateListC;
        o8 o8VarT = o8.t(context, i, c0.TextAppearance);
        if (o8VarT.s(c0.TextAppearance_textAllCaps)) {
            r(o8VarT.a(c0.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && o8VarT.s(c0.TextAppearance_android_textColor) && (colorStateListC = o8VarT.c(c0.TextAppearance_android_textColor)) != null) {
            this.f3246a.setTextColor(colorStateListC);
        }
        if (o8VarT.s(c0.TextAppearance_android_textSize) && o8VarT.f(c0.TextAppearance_android_textSize, -1) == 0) {
            this.f3246a.setTextSize(0, 0.0f);
        }
        B(context, o8VarT);
        if (Build.VERSION.SDK_INT >= 26 && o8VarT.s(c0.TextAppearance_fontVariationSettings) && (strO = o8VarT.o(c0.TextAppearance_fontVariationSettings)) != null) {
            this.f3246a.setFontVariationSettings(strO);
        }
        o8VarT.w();
        Typeface typeface = this.f3245a;
        if (typeface != null) {
            this.f3246a.setTypeface(typeface, this.f7661a);
        }
    }

    public void r(boolean z) {
        this.f3246a.setAllCaps(z);
    }

    public void s(int i, int i2, int i3, int i4) {
        this.f3243a.u(i, i2, i3, i4);
    }

    public void t(int[] iArr, int i) {
        this.f3243a.v(iArr, i);
    }

    public void u(int i) {
        this.f3243a.w(i);
    }

    public void v(ColorStateList colorStateList) {
        if (this.g == null) {
            this.g = new m8();
        }
        m8 m8Var = this.g;
        m8Var.f6781a = colorStateList;
        m8Var.b = colorStateList != null;
        y();
    }

    public void w(PorterDuff.Mode mode) {
        if (this.g == null) {
            this.g = new m8();
        }
        m8 m8Var = this.g;
        m8Var.f1904a = mode;
        m8Var.f1905a = mode != null;
        y();
    }

    public final void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f3246a.getCompoundDrawablesRelative();
            TextView textView = this.f3246a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.f3246a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f3246a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f3246a.getCompoundDrawables();
        TextView textView3 = this.f3246a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public final void y() {
        m8 m8Var = this.g;
        this.f3244a = m8Var;
        this.f3248b = m8Var;
        this.c = m8Var;
        this.d = m8Var;
        this.e = m8Var;
        this.f = m8Var;
    }

    public void z(int i, float f) {
        if (fj.f6112a || l()) {
            return;
        }
        A(i, f);
    }
}
