package y0;

import android.text.Html;
import android.text.Spanned;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @yt.k
    public static final Spanned a(@yt.k String str, int i10, @yt.l Html.ImageGetter imageGetter, @yt.l Html.TagHandler tagHandler) {
        f0.p(str, "<this>");
        Spanned spannedB = c.b(str, i10, imageGetter, tagHandler);
        f0.o(spannedB, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedB;
    }

    public static /* synthetic */ Spanned b(String str, int i10, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            imageGetter = null;
        }
        if ((i11 & 4) != 0) {
            tagHandler = null;
        }
        f0.p(str, "<this>");
        Spanned spannedB = c.b(str, i10, imageGetter, tagHandler);
        f0.o(spannedB, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedB;
    }

    @yt.k
    public static final String c(@yt.k Spanned spanned, int i10) {
        f0.p(spanned, "<this>");
        String strC = c.c(spanned, i10);
        f0.o(strC, "toHtml(this, option)");
        return strC;
    }

    public static /* synthetic */ String d(Spanned spanned, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        f0.p(spanned, "<this>");
        String strC = c.c(spanned, i10);
        f0.o(strC, "toHtml(this, option)");
        return strC;
    }
}
