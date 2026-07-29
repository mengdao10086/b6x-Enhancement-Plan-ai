package ek;

import java.nio.charset.Charset;
import kotlin.jvm.internal.f0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    @bk.f
    @v0(version = "1.8")
    @f
    public static final byte[] a(a aVar, CharSequence source, int i10, int i11) {
        f0.p(aVar, "<this>");
        f0.p(source, "source");
        if (!(source instanceof String)) {
            return aVar.e(source, i10, i11);
        }
        aVar.g(source.length(), i10, i11);
        String strSubstring = ((String) source).substring(i10, i11);
        f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        Charset charset = kotlin.text.d.f38166g;
        f0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strSubstring.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @bk.f
    @v0(version = "1.8")
    @f
    public static final int b(a aVar, byte[] source, byte[] destination, int i10, int i11, int i12) {
        f0.p(aVar, "<this>");
        f0.p(source, "source");
        f0.p(destination, "destination");
        return aVar.v(source, destination, i10, i11, i12);
    }

    @bk.f
    @v0(version = "1.8")
    @f
    public static final byte[] c(a aVar, byte[] source, int i10, int i11) {
        f0.p(aVar, "<this>");
        f0.p(source, "source");
        return aVar.B(source, i10, i11);
    }

    @bk.f
    @v0(version = "1.8")
    @f
    public static final String d(a aVar, byte[] source, int i10, int i11) {
        f0.p(aVar, "<this>");
        f0.p(source, "source");
        return new String(aVar.B(source, i10, i11), kotlin.text.d.f38166g);
    }
}
