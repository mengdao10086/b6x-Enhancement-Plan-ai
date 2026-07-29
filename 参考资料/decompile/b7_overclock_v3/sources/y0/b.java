package y0;

import android.text.TextUtils;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final boolean a(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int b(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
