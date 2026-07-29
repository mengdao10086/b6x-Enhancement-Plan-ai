package af;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f642e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f644g = "GB2312";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f638a = Charset.defaultCharset();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f643f = "SJIS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f639b = Charset.forName(f643f);

    static {
        Charset charsetForName;
        try {
            charsetForName = Charset.forName(f644g);
        } catch (UnsupportedCharsetException unused) {
            charsetForName = null;
        }
        f640c = charsetForName;
        Charset charsetForName2 = Charset.forName("EUC_JP");
        f641d = charsetForName2;
        Charset charset = f639b;
        Charset charset2 = f638a;
        f642e = charset.equals(charset2) || charsetForName2.equals(charset2);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074 A[PHI: r10
  0x0074: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:45:0x007f, B:54:0x0098, B:39:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.nio.charset.Charset a(byte[] r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: af.o.a(byte[], java.util.Map):java.nio.charset.Charset");
    }

    public static String b(byte[] bArr, Map<DecodeHintType, ?> map) {
        Charset charsetA = a(bArr, map);
        return charsetA.equals(f639b) ? f643f : charsetA.equals(StandardCharsets.UTF_8) ? "UTF8" : charsetA.equals(StandardCharsets.ISO_8859_1) ? "ISO8859_1" : charsetA.name();
    }
}
