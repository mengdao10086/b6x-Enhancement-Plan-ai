package kotlin.text;

import java.util.regex.Pattern;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public class o extends StringsKt__IndentKt {
    @bk.f
    public static final Regex s(Pattern pattern) {
        f0.p(pattern, "<this>");
        return new Regex(pattern);
    }
}
