package y0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import g.v0;
import java.util.Locale;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class f {
    @v0(17)
    public static final int a(@yt.k Locale locale) {
        f0.p(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
