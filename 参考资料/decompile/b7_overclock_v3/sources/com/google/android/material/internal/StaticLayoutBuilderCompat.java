package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import g.f0;
import g.n0;
import g.p0;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StaticLayoutBuilderCompat {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f20316o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f20317p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f20318q = 1.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f20319r = "android.text.TextDirectionHeuristic";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f20320s = "android.text.TextDirectionHeuristics";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f20321t = "LTR";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f20322u = "RTL";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f20323v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public static Constructor<StaticLayout> f20324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public static Object f20325x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f20326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f20327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20328c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20330e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20337l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public p f20339n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20329d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Layout.Alignment f20331f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20332g = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f20333h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f20334i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20335j = f20316o;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20336k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public TextUtils.TruncateAt f20338m = null;

    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable th2) {
            super("Error thrown initializing StaticLayout " + th2.getMessage(), th2);
        }
    }

    static {
        f20316o = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f20326a = charSequence;
        this.f20327b = textPaint;
        this.f20328c = i10;
        this.f20330e = charSequence.length();
    }

    @n0
    public static StaticLayoutBuilderCompat c(@n0 CharSequence charSequence, @n0 TextPaint textPaint, @f0(from = 0) int i10) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i10);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.f20326a == null) {
            this.f20326a = "";
        }
        int iMax = Math.max(0, this.f20328c);
        CharSequence charSequenceEllipsize = this.f20326a;
        if (this.f20332g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f20327b, iMax, this.f20338m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f20330e);
        this.f20330e = iMin;
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) androidx.core.util.o.l(f20324w)).newInstance(charSequenceEllipsize, Integer.valueOf(this.f20329d), Integer.valueOf(this.f20330e), this.f20327b, Integer.valueOf(iMax), this.f20331f, androidx.core.util.o.l(f20325x), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f20336k), null, Integer.valueOf(iMax), Integer.valueOf(this.f20332g));
            } catch (Exception e10) {
                throw new StaticLayoutBuilderCompatException(e10);
            }
        }
        if (this.f20337l && this.f20332g == 1) {
            this.f20331f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f20329d, iMin, this.f20327b, iMax);
        builderObtain.setAlignment(this.f20331f);
        builderObtain.setIncludePad(this.f20336k);
        builderObtain.setTextDirection(this.f20337l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f20338m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f20332g);
        float f10 = this.f20333h;
        if (f10 != 0.0f || this.f20334i != 1.0f) {
            builderObtain.setLineSpacing(f10, this.f20334i);
        }
        if (this.f20332g > 1) {
            builderObtain.setHyphenationFrequency(this.f20335j);
        }
        p pVar = this.f20339n;
        if (pVar != null) {
            pVar.a(builderObtain);
        }
        return builderObtain.build();
    }

    public final void b() throws StaticLayoutBuilderCompatException {
        if (f20323v) {
            return;
        }
        try {
            f20325x = this.f20337l && Build.VERSION.SDK_INT >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f20324w = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f20323v = true;
        } catch (Exception e10) {
            throw new StaticLayoutBuilderCompatException(e10);
        }
    }

    @n0
    public StaticLayoutBuilderCompat d(@n0 Layout.Alignment alignment) {
        this.f20331f = alignment;
        return this;
    }

    @n0
    public StaticLayoutBuilderCompat e(@p0 TextUtils.TruncateAt truncateAt) {
        this.f20338m = truncateAt;
        return this;
    }

    @n0
    public StaticLayoutBuilderCompat f(@f0(from = 0) int i10) {
        this.f20330e = i10;
        return this;
    }

    @n0
    public StaticLayoutBuilderCompat g(int i10) {
        this.f20335j = i10;
        return this;
    }

    @n0
    public StaticLayoutBuilderCompat h(boolean z10) {
        this.f20336k = z10;
        return this;
    }

    public StaticLayoutBuilderCompat i(boolean z10) {
        this.f20337l = z10;
        return this;
    }

    @n0
    public StaticLayoutBuilderCompat j(float f10, float f11) {
        this.f20333h = f10;
        this.f20334i = f11;
        return this;
    }

    @n0
    public StaticLayoutBuilderCompat k(@f0(from = 0) int i10) {
        this.f20332g = i10;
        return this;
    }

    @n0
    public StaticLayoutBuilderCompat l(@f0(from = 0) int i10) {
        this.f20329d = i10;
        return this;
    }

    @n0
    public StaticLayoutBuilderCompat m(@p0 p pVar) {
        this.f20339n = pVar;
        return this;
    }
}
