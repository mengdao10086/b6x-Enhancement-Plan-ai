package kotlin.text;

import java.util.Set;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public class p extends o {
    @bk.f
    public static final Regex t(String str) {
        f0.p(str, "<this>");
        return new Regex(str);
    }

    @bk.f
    public static final Regex u(String str, Set<? extends RegexOption> options) {
        f0.p(str, "<this>");
        f0.p(options, "options");
        return new Regex(str, options);
    }

    @bk.f
    public static final Regex v(String str, RegexOption option) {
        f0.p(str, "<this>");
        f0.p(option, "option");
        return new Regex(str, option);
    }
}
