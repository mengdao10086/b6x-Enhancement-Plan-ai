package m0;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorSpace;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float A(long j10) {
        return Color.luminance(j10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float B(long j10) {
        return Color.red(j10);
    }

    public static final int C(@g.l int i10) {
        return (i10 >> 16) & 255;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final boolean D(long j10) {
        return Color.isSrgb(j10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final boolean E(long j10) {
        return Color.isWideGamut(j10);
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final Color F(@yt.k Color color, @yt.k Color c10) {
        kotlin.jvm.internal.f0.p(color, "<this>");
        kotlin.jvm.internal.f0.p(c10, "c");
        Color colorU = g.u(c10, color);
        kotlin.jvm.internal.f0.o(colorU, "compositeColors(c, this)");
        return colorU;
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final Color G(@g.l int i10) {
        Color colorValueOf = Color.valueOf(i10);
        kotlin.jvm.internal.f0.o(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final Color H(long j10) {
        Color colorValueOf = Color.valueOf(j10);
        kotlin.jvm.internal.f0.o(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @g.l
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final int I(long j10) {
        return Color.toArgb(j10);
    }

    @g.l
    public static final int J(@yt.k String str) {
        kotlin.jvm.internal.f0.p(str, "<this>");
        return Color.parseColor(str);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final long K(@g.l int i10) {
        return Color.pack(i10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float a(long j10) {
        return Color.red(j10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float b(@yt.k Color color) {
        kotlin.jvm.internal.f0.p(color, "<this>");
        return color.getComponent(0);
    }

    public static final int c(@g.l int i10) {
        return (i10 >> 24) & 255;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float d(long j10) {
        return Color.green(j10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float e(@yt.k Color color) {
        kotlin.jvm.internal.f0.p(color, "<this>");
        return color.getComponent(1);
    }

    public static final int f(@g.l int i10) {
        return (i10 >> 16) & 255;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float g(long j10) {
        return Color.blue(j10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float h(@yt.k Color color) {
        kotlin.jvm.internal.f0.p(color, "<this>");
        return color.getComponent(2);
    }

    public static final int i(@g.l int i10) {
        return (i10 >> 8) & 255;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float j(long j10) {
        return Color.alpha(j10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float k(@yt.k Color color) {
        kotlin.jvm.internal.f0.p(color, "<this>");
        return color.getComponent(3);
    }

    public static final int l(@g.l int i10) {
        return i10 & 255;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final long m(@g.l int i10, @yt.k ColorSpace.Named colorSpace) {
        kotlin.jvm.internal.f0.p(colorSpace, "colorSpace");
        return Color.convert(i10, ColorSpace.get(colorSpace));
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final long n(@g.l int i10, @yt.k ColorSpace colorSpace) {
        kotlin.jvm.internal.f0.p(colorSpace, "colorSpace");
        return Color.convert(i10, colorSpace);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final long o(long j10, @yt.k ColorSpace.Named colorSpace) {
        kotlin.jvm.internal.f0.p(colorSpace, "colorSpace");
        return Color.convert(j10, ColorSpace.get(colorSpace));
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final long p(long j10, @yt.k ColorSpace colorSpace) {
        kotlin.jvm.internal.f0.p(colorSpace, "colorSpace");
        return Color.convert(j10, colorSpace);
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final Color q(@yt.k Color color, @yt.k ColorSpace.Named colorSpace) {
        kotlin.jvm.internal.f0.p(color, "<this>");
        kotlin.jvm.internal.f0.p(colorSpace, "colorSpace");
        Color colorConvert = color.convert(ColorSpace.get(colorSpace));
        kotlin.jvm.internal.f0.o(colorConvert, "convert(ColorSpace.get(colorSpace))");
        return colorConvert;
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final Color r(@yt.k Color color, @yt.k ColorSpace colorSpace) {
        kotlin.jvm.internal.f0.p(color, "<this>");
        kotlin.jvm.internal.f0.p(colorSpace, "colorSpace");
        Color colorConvert = color.convert(colorSpace);
        kotlin.jvm.internal.f0.o(colorConvert, "convert(colorSpace)");
        return colorConvert;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float s(long j10) {
        return Color.alpha(j10);
    }

    public static final int t(@g.l int i10) {
        return (i10 >> 24) & 255;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float u(long j10) {
        return Color.blue(j10);
    }

    public static final int v(@g.l int i10) {
        return i10 & 255;
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final ColorSpace w(long j10) {
        ColorSpace colorSpace = Color.colorSpace(j10);
        kotlin.jvm.internal.f0.o(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float x(long j10) {
        return Color.green(j10);
    }

    public static final int y(@g.l int i10) {
        return (i10 >> 8) & 255;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final float z(@g.l int i10) {
        return Color.luminance(i10);
    }
}
