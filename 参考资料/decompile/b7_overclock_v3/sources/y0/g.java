package y0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.RestrictTo;
import androidx.core.os.y;
import androidx.core.util.o;
import g.b0;
import g.f0;
import g.h1;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Spannable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char f56186e = '\n';

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f56187f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b0("sLock")
    @n0
    public static Executor f56188g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Spannable f56189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final a f56190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final int[] f56191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final PrecomputedText f56192d;

    public static class b extends FutureTask<g> {

        public static class a implements Callable<g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public a f56202a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public CharSequence f56203b;

            public a(@n0 a aVar, @n0 CharSequence charSequence) {
                this.f56202a = aVar;
                this.f56203b = charSequence;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g call() throws Exception {
                return g.a(this.f56203b, this.f56202a);
            }
        }

        public b(@n0 a aVar, @n0 CharSequence charSequence) {
            super(new a(aVar, charSequence));
        }
    }

    public g(@n0 CharSequence charSequence, @n0 a aVar, @n0 int[] iArr) {
        this.f56189a = new SpannableString(charSequence);
        this.f56190b = aVar;
        this.f56191c = iArr;
        this.f56192d = null;
    }

    @SuppressLint({"WrongConstant"})
    public static g a(@n0 CharSequence charSequence, @n0 a aVar) {
        PrecomputedText.Params params;
        o.l(charSequence);
        o.l(aVar);
        try {
            y.b("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params = aVar.f56197e) != null) {
                return new g(PrecomputedText.create(charSequence, params), aVar);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i10 = 0;
            while (i10 < length) {
                int iIndexOf = TextUtils.indexOf(charSequence, '\n', i10, length);
                i10 = iIndexOf < 0 ? length : iIndexOf + 1;
                arrayList.add(Integer.valueOf(i10));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                iArr[i11] = ((Integer) arrayList.get(i11)).intValue();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), aVar.e(), Integer.MAX_VALUE).setBreakStrategy(aVar.b()).setHyphenationFrequency(aVar.c()).setTextDirection(aVar.d()).build();
            } else {
                new StaticLayout(charSequence, aVar.e(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return new g(charSequence, aVar, iArr);
        } finally {
            y.d();
        }
    }

    @h1
    public static Future<g> g(@n0 CharSequence charSequence, @n0 a aVar, @p0 Executor executor) {
        b bVar = new b(aVar, charSequence);
        if (executor == null) {
            synchronized (f56187f) {
                if (f56188g == null) {
                    f56188g = Executors.newFixedThreadPool(1);
                }
                executor = f56188g;
            }
        }
        executor.execute(bVar);
        return bVar;
    }

    @f0(from = 0)
    public int b() {
        return Build.VERSION.SDK_INT >= 29 ? this.f56192d.getParagraphCount() : this.f56191c.length;
    }

    @f0(from = 0)
    public int c(@f0(from = 0) int i10) {
        o.g(i10, 0, b(), "paraIndex");
        return Build.VERSION.SDK_INT >= 29 ? this.f56192d.getParagraphEnd(i10) : this.f56191c[i10];
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f56189a.charAt(i10);
    }

    @f0(from = 0)
    public int d(@f0(from = 0) int i10) {
        o.g(i10, 0, b(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f56192d.getParagraphStart(i10);
        }
        if (i10 == 0) {
            return 0;
        }
        return this.f56191c[i10 - 1];
    }

    @n0
    public a e() {
        return this.f56190b;
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(28)
    public PrecomputedText f() {
        Spannable spannable = this.f56189a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f56189a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f56189a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f56189a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f56192d.getSpans(i10, i11, cls) : (T[]) this.f56189a.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f56189a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f56189a.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f56192d.removeSpan(obj);
        } else {
            this.f56189a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f56192d.setSpan(obj, i10, i11, i12);
        } else {
            this.f56189a.setSpan(obj, i10, i11, i12);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f56189a.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    @n0
    public String toString() {
        return this.f56189a.toString();
    }

    @v0(28)
    public g(@n0 PrecomputedText precomputedText, @n0 a aVar) {
        this.f56189a = precomputedText;
        this.f56190b = aVar;
        this.f56191c = null;
        this.f56192d = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final TextPaint f56193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final TextDirectionHeuristic f56194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f56195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f56196d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f56197e;

        /* JADX INFO: renamed from: y0.g$a$a, reason: collision with other inner class name */
        public static class C0662a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @n0
            public final TextPaint f56198a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f56199b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f56200c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f56201d;

            public C0662a(@n0 TextPaint textPaint) {
                this.f56198a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f56200c = 1;
                    this.f56201d = 1;
                } else {
                    this.f56201d = 0;
                    this.f56200c = 0;
                }
                this.f56199b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @n0
            public a a() {
                return new a(this.f56198a, this.f56199b, this.f56200c, this.f56201d);
            }

            @v0(23)
            public C0662a b(int i10) {
                this.f56200c = i10;
                return this;
            }

            @v0(23)
            public C0662a c(int i10) {
                this.f56201d = i10;
                return this;
            }

            @v0(18)
            public C0662a d(@n0 TextDirectionHeuristic textDirectionHeuristic) {
                this.f56199b = textDirectionHeuristic;
                return this;
            }
        }

        public a(@n0 TextPaint textPaint, @n0 TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f56197e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f56197e = null;
            }
            this.f56193a = textPaint;
            this.f56194b = textDirectionHeuristic;
            this.f56195c = i10;
            this.f56196d = i11;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean a(@n0 a aVar) {
            int i10 = Build.VERSION.SDK_INT;
            if ((i10 >= 23 && (this.f56195c != aVar.b() || this.f56196d != aVar.c())) || this.f56193a.getTextSize() != aVar.e().getTextSize() || this.f56193a.getTextScaleX() != aVar.e().getTextScaleX() || this.f56193a.getTextSkewX() != aVar.e().getTextSkewX() || this.f56193a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f56193a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f56193a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i10 >= 24) {
                if (!this.f56193a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f56193a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f56193a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f56193a.getTypeface().equals(aVar.e().getTypeface());
        }

        @v0(23)
        public int b() {
            return this.f56195c;
        }

        @v0(23)
        public int c() {
            return this.f56196d;
        }

        @p0
        @v0(18)
        public TextDirectionHeuristic d() {
            return this.f56194b;
        }

        @n0
        public TextPaint e() {
            return this.f56193a;
        }

        public boolean equals(@p0 Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f56194b == aVar.d();
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 24 ? androidx.core.util.j.b(Float.valueOf(this.f56193a.getTextSize()), Float.valueOf(this.f56193a.getTextScaleX()), Float.valueOf(this.f56193a.getTextSkewX()), Float.valueOf(this.f56193a.getLetterSpacing()), Integer.valueOf(this.f56193a.getFlags()), this.f56193a.getTextLocales(), this.f56193a.getTypeface(), Boolean.valueOf(this.f56193a.isElegantTextHeight()), this.f56194b, Integer.valueOf(this.f56195c), Integer.valueOf(this.f56196d)) : androidx.core.util.j.b(Float.valueOf(this.f56193a.getTextSize()), Float.valueOf(this.f56193a.getTextScaleX()), Float.valueOf(this.f56193a.getTextSkewX()), Float.valueOf(this.f56193a.getLetterSpacing()), Integer.valueOf(this.f56193a.getFlags()), this.f56193a.getTextLocale(), this.f56193a.getTypeface(), Boolean.valueOf(this.f56193a.isElegantTextHeight()), this.f56194b, Integer.valueOf(this.f56195c), Integer.valueOf(this.f56196d));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(zc.a.f58316d);
            sb2.append("textSize=" + this.f56193a.getTextSize());
            sb2.append(", textScaleX=" + this.f56193a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f56193a.getTextSkewX());
            int i10 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f56193a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f56193a.isElegantTextHeight());
            if (i10 >= 24) {
                sb2.append(", textLocale=" + this.f56193a.getTextLocales());
            } else {
                sb2.append(", textLocale=" + this.f56193a.getTextLocale());
            }
            sb2.append(", typeface=" + this.f56193a.getTypeface());
            if (i10 >= 26) {
                sb2.append(", variationSettings=" + this.f56193a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f56194b);
            sb2.append(", breakStrategy=" + this.f56195c);
            sb2.append(", hyphenationFrequency=" + this.f56196d);
            sb2.append(zc.a.f58317e);
            return sb2.toString();
        }

        @v0(28)
        public a(@n0 PrecomputedText.Params params) {
            this.f56193a = params.getTextPaint();
            this.f56194b = params.getTextDirection();
            this.f56195c = params.getBreakStrategy();
            this.f56196d = params.getHyphenationFrequency();
            this.f56197e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
