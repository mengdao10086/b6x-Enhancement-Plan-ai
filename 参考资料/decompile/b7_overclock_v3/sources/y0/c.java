package y0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import g.n0;
import g.p0;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InlinedApi"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f56172a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f56173b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56174c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56175d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56176e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f56177f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f56178g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f56179h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f56180i = 256;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f56181j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f56182k = 63;

    @v0(24)
    public static class a {
        @u
        public static Spanned a(String str, int i10) {
            return Html.fromHtml(str, i10);
        }

        @u
        public static Spanned b(String str, int i10, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i10, imageGetter, tagHandler);
        }

        @u
        public static String c(Spanned spanned, int i10) {
            return Html.toHtml(spanned, i10);
        }
    }

    @n0
    public static Spanned a(@n0 String str, int i10) {
        return Build.VERSION.SDK_INT >= 24 ? a.a(str, i10) : Html.fromHtml(str);
    }

    @n0
    public static Spanned b(@n0 String str, int i10, @p0 Html.ImageGetter imageGetter, @p0 Html.TagHandler tagHandler) {
        return Build.VERSION.SDK_INT >= 24 ? a.b(str, i10, imageGetter, tagHandler) : Html.fromHtml(str, imageGetter, tagHandler);
    }

    @n0
    public static String c(@n0 Spanned spanned, int i10) {
        return Build.VERSION.SDK_INT >= 24 ? a.c(spanned, i10) : Html.toHtml(spanned);
    }
}
