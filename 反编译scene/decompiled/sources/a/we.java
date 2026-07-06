package a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class we {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextDirectionHeuristic f3428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextPaint f3429a;
    public final int b;

    public we(PrecomputedText.Params params) {
        this.f3429a = params.getTextPaint();
        this.f3428a = params.getTextDirection();
        this.f7779a = params.getBreakStrategy();
        this.b = params.getHyphenationFrequency();
        int i = Build.VERSION.SDK_INT;
    }

    @SuppressLint({"NewApi"})
    public we(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
        }
        this.f3429a = textPaint;
        this.f3428a = textDirectionHeuristic;
        this.f7779a = i;
        this.b = i2;
    }

    public boolean a(we weVar) {
        if ((Build.VERSION.SDK_INT >= 23 && (this.f7779a != weVar.b() || this.b != weVar.c())) || this.f3429a.getTextSize() != weVar.e().getTextSize() || this.f3429a.getTextScaleX() != weVar.e().getTextScaleX() || this.f3429a.getTextSkewX() != weVar.e().getTextSkewX()) {
            return false;
        }
        if ((Build.VERSION.SDK_INT >= 21 && (this.f3429a.getLetterSpacing() != weVar.e().getLetterSpacing() || !TextUtils.equals(this.f3429a.getFontFeatureSettings(), weVar.e().getFontFeatureSettings()))) || this.f3429a.getFlags() != weVar.e().getFlags()) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            if (!this.f3429a.getTextLocales().equals(weVar.e().getTextLocales())) {
                return false;
            }
        } else if (i >= 17 && !this.f3429a.getTextLocale().equals(weVar.e().getTextLocale())) {
            return false;
        }
        return this.f3429a.getTypeface() == null ? weVar.e().getTypeface() == null : this.f3429a.getTypeface().equals(weVar.e().getTypeface());
    }

    public int b() {
        return this.f7779a;
    }

    public int c() {
        return this.b;
    }

    public TextDirectionHeuristic d() {
        return this.f3428a;
    }

    public TextPaint e() {
        return this.f3429a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof we)) {
            return false;
        }
        we weVar = (we) obj;
        if (a(weVar)) {
            return Build.VERSION.SDK_INT < 18 || this.f3428a == weVar.d();
        }
        return false;
    }

    public int hashCode() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return kf.b(Float.valueOf(this.f3429a.getTextSize()), Float.valueOf(this.f3429a.getTextScaleX()), Float.valueOf(this.f3429a.getTextSkewX()), Float.valueOf(this.f3429a.getLetterSpacing()), Integer.valueOf(this.f3429a.getFlags()), this.f3429a.getTextLocales(), this.f3429a.getTypeface(), Boolean.valueOf(this.f3429a.isElegantTextHeight()), this.f3428a, Integer.valueOf(this.f7779a), Integer.valueOf(this.b));
        }
        if (i >= 21) {
            return kf.b(Float.valueOf(this.f3429a.getTextSize()), Float.valueOf(this.f3429a.getTextScaleX()), Float.valueOf(this.f3429a.getTextSkewX()), Float.valueOf(this.f3429a.getLetterSpacing()), Integer.valueOf(this.f3429a.getFlags()), this.f3429a.getTextLocale(), this.f3429a.getTypeface(), Boolean.valueOf(this.f3429a.isElegantTextHeight()), this.f3428a, Integer.valueOf(this.f7779a), Integer.valueOf(this.b));
        }
        if (i < 18 && i < 17) {
            return kf.b(Float.valueOf(this.f3429a.getTextSize()), Float.valueOf(this.f3429a.getTextScaleX()), Float.valueOf(this.f3429a.getTextSkewX()), Integer.valueOf(this.f3429a.getFlags()), this.f3429a.getTypeface(), this.f3428a, Integer.valueOf(this.f7779a), Integer.valueOf(this.b));
        }
        return kf.b(Float.valueOf(this.f3429a.getTextSize()), Float.valueOf(this.f3429a.getTextScaleX()), Float.valueOf(this.f3429a.getTextSkewX()), Integer.valueOf(this.f3429a.getFlags()), this.f3429a.getTextLocale(), this.f3429a.getTypeface(), this.f3428a, Integer.valueOf(this.f7779a), Integer.valueOf(this.b));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.we.toString():java.lang.String");
    }
}
