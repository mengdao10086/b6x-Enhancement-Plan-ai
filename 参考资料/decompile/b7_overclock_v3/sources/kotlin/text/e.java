package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "CharsetsKt")
public final class e {
    @bk.f
    public static final Charset a(String charsetName) {
        f0.p(charsetName, "charsetName");
        Charset charsetForName = Charset.forName(charsetName);
        f0.o(charsetForName, "forName(charsetName)");
        return charsetForName;
    }
}
