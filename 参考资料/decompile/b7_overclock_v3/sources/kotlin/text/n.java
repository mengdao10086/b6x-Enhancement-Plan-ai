package kotlin.text;

import java.io.IOException;
import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public class n {
    @yt.k
    public static final <T extends Appendable> T a(@yt.k T t10, @yt.k CharSequence... value) throws IOException {
        f0.p(t10, "<this>");
        f0.p(value, "value");
        for (CharSequence charSequence : value) {
            t10.append(charSequence);
        }
        return t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void b(@yt.k Appendable appendable, T t10, @yt.l ik.l<? super T, ? extends CharSequence> lVar) {
        f0.p(appendable, "<this>");
        if (lVar != null) {
            appendable.append(lVar.i(t10));
            return;
        }
        if (t10 == 0 ? true : t10 instanceof CharSequence) {
            appendable.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendable.append(((Character) t10).charValue());
        } else {
            appendable.append(String.valueOf(t10));
        }
    }

    @bk.f
    @v0(version = "1.4")
    public static final Appendable c(Appendable appendable) throws IOException {
        f0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append('\n');
        f0.o(appendableAppend, "append('\\n')");
        return appendableAppend;
    }

    @bk.f
    @v0(version = "1.4")
    public static final Appendable d(Appendable appendable, char c10) throws IOException {
        f0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(c10);
        f0.o(appendableAppend, "append(value)");
        Appendable appendableAppend2 = appendableAppend.append('\n');
        f0.o(appendableAppend2, "append('\\n')");
        return appendableAppend2;
    }

    @bk.f
    @v0(version = "1.4")
    public static final Appendable e(Appendable appendable, CharSequence charSequence) throws IOException {
        f0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(charSequence);
        f0.o(appendableAppend, "append(value)");
        Appendable appendableAppend2 = appendableAppend.append('\n');
        f0.o(appendableAppend2, "append('\\n')");
        return appendableAppend2;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.k
    public static final <T extends Appendable> T f(@yt.k T t10, @yt.k CharSequence value, int i10, int i11) {
        f0.p(t10, "<this>");
        f0.p(value, "value");
        T t11 = (T) t10.append(value, i10, i11);
        f0.n(t11, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t11;
    }
}
