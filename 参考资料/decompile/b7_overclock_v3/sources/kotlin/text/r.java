package kotlin.text;

import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.f0;
import kotlin.t0;
import kotlin.v0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public class r extends q {
    @bk.f
    @kotlin.k(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @t0(expression = "append(value = obj)", imports = {}))
    public static final StringBuilder h0(StringBuilder sb2, Object obj) {
        f0.p(sb2, "<this>");
        sb2.append(obj);
        f0.o(sb2, "this.append(obj)");
        return sb2;
    }

    @bk.f
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @t0(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    public static final StringBuilder i0(StringBuilder sb2, char[] str, int i10, int i11) {
        f0.p(sb2, "<this>");
        f0.p(str, "str");
        throw new NotImplementedError(null, 1, null);
    }

    @yt.k
    public static final StringBuilder j0(@yt.k StringBuilder sb2, @yt.k Object... value) {
        f0.p(sb2, "<this>");
        f0.p(value, "value");
        for (Object obj : value) {
            sb2.append(obj);
        }
        return sb2;
    }

    @yt.k
    public static final StringBuilder k0(@yt.k StringBuilder sb2, @yt.k String... value) {
        f0.p(sb2, "<this>");
        f0.p(value, "value");
        for (String str : value) {
            sb2.append(str);
        }
        return sb2;
    }

    @bk.f
    @v0(version = "1.4")
    public static final StringBuilder l0(StringBuilder sb2) {
        f0.p(sb2, "<this>");
        sb2.append('\n');
        f0.o(sb2, "append('\\n')");
        return sb2;
    }

    @bk.f
    @v0(version = "1.4")
    public static final StringBuilder m0(StringBuilder sb2, char c10) {
        f0.p(sb2, "<this>");
        sb2.append(c10);
        f0.o(sb2, "append(value)");
        sb2.append('\n');
        f0.o(sb2, "append('\\n')");
        return sb2;
    }

    @bk.f
    @v0(version = "1.4")
    public static final StringBuilder n0(StringBuilder sb2, CharSequence charSequence) {
        f0.p(sb2, "<this>");
        sb2.append(charSequence);
        f0.o(sb2, "append(value)");
        sb2.append('\n');
        f0.o(sb2, "append('\\n')");
        return sb2;
    }

    @bk.f
    @v0(version = "1.4")
    public static final StringBuilder o0(StringBuilder sb2, Object obj) {
        f0.p(sb2, "<this>");
        sb2.append(obj);
        f0.o(sb2, "append(value)");
        sb2.append('\n');
        f0.o(sb2, "append('\\n')");
        return sb2;
    }

    @bk.f
    @v0(version = "1.4")
    public static final StringBuilder p0(StringBuilder sb2, String str) {
        f0.p(sb2, "<this>");
        sb2.append(str);
        f0.o(sb2, "append(value)");
        sb2.append('\n');
        f0.o(sb2, "append('\\n')");
        return sb2;
    }

    @bk.f
    @v0(version = "1.4")
    public static final StringBuilder q0(StringBuilder sb2, boolean z10) {
        f0.p(sb2, "<this>");
        sb2.append(z10);
        f0.o(sb2, "append(value)");
        sb2.append('\n');
        f0.o(sb2, "append('\\n')");
        return sb2;
    }

    @bk.f
    @v0(version = "1.4")
    public static final StringBuilder r0(StringBuilder sb2, char[] value) {
        f0.p(sb2, "<this>");
        f0.p(value, "value");
        sb2.append(value);
        f0.o(sb2, "append(value)");
        sb2.append('\n');
        f0.o(sb2, "append('\\n')");
        return sb2;
    }

    @bk.f
    @v0(version = "1.1")
    public static final String s0(int i10, ik.l<? super StringBuilder, z1> builderAction) {
        f0.p(builderAction, "builderAction");
        StringBuilder sb2 = new StringBuilder(i10);
        builderAction.i(sb2);
        String string = sb2.toString();
        f0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @bk.f
    public static final String t0(ik.l<? super StringBuilder, z1> builderAction) {
        f0.p(builderAction, "builderAction");
        StringBuilder sb2 = new StringBuilder();
        builderAction.i(sb2);
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
