package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(19)
public abstract class j extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final h f5543b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f5542a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short f5544c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short f5545d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5546e = 1.0f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public j(@n0 h hVar) {
        androidx.core.util.o.m(hVar, "metadata cannot be null");
        this.f5543b = hVar;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int a() {
        return this.f5545d;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int b() {
        return c().g();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public final h c() {
        return this.f5543b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final float d() {
        return this.f5546e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final int e() {
        return this.f5544c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@n0 Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, @p0 Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f5542a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f5542a;
        this.f5546e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f5543b.f();
        this.f5545d = (short) (this.f5543b.f() * this.f5546e);
        short sK = (short) (this.f5543b.k() * this.f5546e);
        this.f5544c = sK;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f5542a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sK;
    }
}
