package y0;

import android.text.TextUtils;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    @yt.k
    public static final String a(@yt.k String str) {
        f0.p(str, "<this>");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        f0.o(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
