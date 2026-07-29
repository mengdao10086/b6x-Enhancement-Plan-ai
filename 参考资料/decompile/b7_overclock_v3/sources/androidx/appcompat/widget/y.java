package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import j0.i;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2733n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f2734o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f2735p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f2736q = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final TextView f2737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w0 f2738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w0 f2739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w0 f2740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w0 f2741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w0 f2742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w0 f2743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w0 f2744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final z f2745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2746j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2747k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f2748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2749m;

    public class a extends i.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f2752c;

        public a(int i10, int i11, WeakReference weakReference) {
            this.f2750a = i10;
            this.f2751b = i11;
            this.f2752c = weakReference;
        }

        @Override // j0.i.g
        /* JADX INFO: renamed from: h */
        public void f(int i10) {
        }

        @Override // j0.i.g
        /* JADX INFO: renamed from: i */
        public void g(@g.n0 Typeface typeface) {
            int i10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f2750a) != -1) {
                typeface = g.a(typeface, i10, (this.f2751b & 2) != 0);
            }
            y.this.n(this.f2752c, typeface);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f2754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f2755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f2756c;

        public b(TextView textView, Typeface typeface, int i10) {
            this.f2754a = textView;
            this.f2755b = typeface;
            this.f2756c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2754a.setTypeface(this.f2755b, this.f2756c);
        }
    }

    @g.v0(17)
    public static class c {
        @g.u
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @g.u
        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @g.u
        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    @g.v0(21)
    public static class d {
        @g.u
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @g.v0(24)
    public static class e {
        @g.u
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @g.u
        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    @g.v0(26)
    public static class f {
        @g.u
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @g.u
        public static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        @g.u
        public static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        @g.u
        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    @g.v0(28)
    public static class g {
        @g.u
        public static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    public y(@g.n0 TextView textView) {
        this.f2737a = textView;
        this.f2745i = new z(textView);
    }

    public static w0 d(Context context, i iVar, int i10) {
        ColorStateList colorStateListF = iVar.f(context, i10);
        if (colorStateListF == null) {
            return null;
        }
        w0 w0Var = new w0();
        w0Var.f2729d = true;
        w0Var.f2726a = colorStateListF;
        return w0Var;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void A(int i10, float f10) {
        if (androidx.core.widget.b.O || l()) {
            return;
        }
        B(i10, f10);
    }

    public final void B(int i10, float f10) {
        this.f2745i.w(i10, f10);
    }

    public final void C(Context context, y0 y0Var) {
        String strW;
        this.f2746j = y0Var.o(R.styleable.TextAppearance_android_textStyle, this.f2746j);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int iO = y0Var.o(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f2747k = iO;
            if (iO != -1) {
                this.f2746j = (this.f2746j & 2) | 0;
            }
        }
        int i11 = R.styleable.TextAppearance_android_fontFamily;
        if (!y0Var.C(i11) && !y0Var.C(R.styleable.TextAppearance_fontFamily)) {
            int i12 = R.styleable.TextAppearance_android_typeface;
            if (y0Var.C(i12)) {
                this.f2749m = false;
                int iO2 = y0Var.o(i12, 1);
                if (iO2 == 1) {
                    this.f2748l = Typeface.SANS_SERIF;
                    return;
                } else if (iO2 == 2) {
                    this.f2748l = Typeface.SERIF;
                    return;
                } else {
                    if (iO2 != 3) {
                        return;
                    }
                    this.f2748l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f2748l = null;
        int i13 = R.styleable.TextAppearance_fontFamily;
        if (y0Var.C(i13)) {
            i11 = i13;
        }
        int i14 = this.f2747k;
        int i15 = this.f2746j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceK = y0Var.k(i11, this.f2746j, new a(i14, i15, new WeakReference(this.f2737a)));
                if (typefaceK != null) {
                    if (i10 < 28 || this.f2747k == -1) {
                        this.f2748l = typefaceK;
                    } else {
                        this.f2748l = g.a(Typeface.create(typefaceK, 0), this.f2747k, (this.f2746j & 2) != 0);
                    }
                }
                this.f2749m = this.f2748l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f2748l != null || (strW = y0Var.w(i11)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f2747k == -1) {
            this.f2748l = Typeface.create(strW, this.f2746j);
        } else {
            this.f2748l = g.a(Typeface.create(strW, 0), this.f2747k, (this.f2746j & 2) != 0);
        }
    }

    public final void a(Drawable drawable, w0 w0Var) {
        if (drawable == null || w0Var == null) {
            return;
        }
        i.j(drawable, w0Var, this.f2737a.getDrawableState());
    }

    public void b() {
        if (this.f2738b != null || this.f2739c != null || this.f2740d != null || this.f2741e != null) {
            Drawable[] compoundDrawables = this.f2737a.getCompoundDrawables();
            a(compoundDrawables[0], this.f2738b);
            a(compoundDrawables[1], this.f2739c);
            a(compoundDrawables[2], this.f2740d);
            a(compoundDrawables[3], this.f2741e);
        }
        if (this.f2742f == null && this.f2743g == null) {
            return;
        }
        Drawable[] drawableArrA = c.a(this.f2737a);
        a(drawableArrA[0], this.f2742f);
        a(drawableArrA[2], this.f2743g);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c() {
        this.f2745i.b();
    }

    public int e() {
        return this.f2745i.h();
    }

    public int f() {
        return this.f2745i.i();
    }

    public int g() {
        return this.f2745i.j();
    }

    public int[] h() {
        return this.f2745i.k();
    }

    public int i() {
        return this.f2745i.l();
    }

    @g.p0
    public ColorStateList j() {
        w0 w0Var = this.f2744h;
        if (w0Var != null) {
            return w0Var.f2726a;
        }
        return null;
    }

    @g.p0
    public PorterDuff.Mode k() {
        w0 w0Var = this.f2744h;
        if (w0Var != null) {
            return w0Var.f2727b;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean l() {
        return this.f2745i.q();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a2  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(@g.p0 android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instruction units count: 784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.y.m(android.util.AttributeSet, int):void");
    }

    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f2749m) {
            this.f2748l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (androidx.core.view.u0.O0(textView)) {
                    textView.post(new b(textView, typeface, this.f2746j));
                } else {
                    textView.setTypeface(typeface, this.f2746j);
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (androidx.core.widget.b.O) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i10) {
        String strW;
        ColorStateList colorStateListD;
        ColorStateList colorStateListD2;
        ColorStateList colorStateListD3;
        y0 y0VarE = y0.E(context, i10, R.styleable.TextAppearance);
        int i11 = R.styleable.TextAppearance_textAllCaps;
        if (y0VarE.C(i11)) {
            s(y0VarE.a(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            int i13 = R.styleable.TextAppearance_android_textColor;
            if (y0VarE.C(i13) && (colorStateListD3 = y0VarE.d(i13)) != null) {
                this.f2737a.setTextColor(colorStateListD3);
            }
            int i14 = R.styleable.TextAppearance_android_textColorLink;
            if (y0VarE.C(i14) && (colorStateListD2 = y0VarE.d(i14)) != null) {
                this.f2737a.setLinkTextColor(colorStateListD2);
            }
            int i15 = R.styleable.TextAppearance_android_textColorHint;
            if (y0VarE.C(i15) && (colorStateListD = y0VarE.d(i15)) != null) {
                this.f2737a.setHintTextColor(colorStateListD);
            }
        }
        int i16 = R.styleable.TextAppearance_android_textSize;
        if (y0VarE.C(i16) && y0VarE.g(i16, -1) == 0) {
            this.f2737a.setTextSize(0, 0.0f);
        }
        C(context, y0VarE);
        if (i12 >= 26) {
            int i17 = R.styleable.TextAppearance_fontVariationSettings;
            if (y0VarE.C(i17) && (strW = y0VarE.w(i17)) != null) {
                f.d(this.f2737a, strW);
            }
        }
        y0VarE.I();
        Typeface typeface = this.f2748l;
        if (typeface != null) {
            this.f2737a.setTypeface(typeface, this.f2746j);
        }
    }

    public void r(@g.n0 TextView textView, @g.p0 InputConnection inputConnection, @g.n0 EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        c1.a.j(editorInfo, textView.getText());
    }

    public void s(boolean z10) {
        this.f2737a.setAllCaps(z10);
    }

    public void t(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        this.f2745i.s(i10, i11, i12, i13);
    }

    public void u(@g.n0 int[] iArr, int i10) throws IllegalArgumentException {
        this.f2745i.t(iArr, i10);
    }

    public void v(int i10) {
        this.f2745i.u(i10);
    }

    public void w(@g.p0 ColorStateList colorStateList) {
        if (this.f2744h == null) {
            this.f2744h = new w0();
        }
        w0 w0Var = this.f2744h;
        w0Var.f2726a = colorStateList;
        w0Var.f2729d = colorStateList != null;
        z();
    }

    public void x(@g.p0 PorterDuff.Mode mode) {
        if (this.f2744h == null) {
            this.f2744h = new w0();
        }
        w0 w0Var = this.f2744h;
        w0Var.f2727b = mode;
        w0Var.f2728c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrA = c.a(this.f2737a);
            TextView textView = this.f2737a;
            if (drawable5 == null) {
                drawable5 = drawableArrA[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrA[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrA[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrA[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrA2 = c.a(this.f2737a);
        if (drawableArrA2[0] != null || drawableArrA2[2] != null) {
            TextView textView2 = this.f2737a;
            Drawable drawable7 = drawableArrA2[0];
            if (drawable2 == null) {
                drawable2 = drawableArrA2[1];
            }
            Drawable drawable8 = drawableArrA2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrA2[3];
            }
            c.b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f2737a.getCompoundDrawables();
        TextView textView3 = this.f2737a;
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

    public final void z() {
        w0 w0Var = this.f2744h;
        this.f2738b = w0Var;
        this.f2739c = w0Var;
        this.f2740d = w0Var;
        this.f2741e = w0Var;
        this.f2742f = w0Var;
        this.f2743g = w0Var;
    }
}
