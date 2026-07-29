package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final d f38160a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final Charset f38161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final Charset f38162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final Charset f38163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final Charset f38164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final Charset f38165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final Charset f38166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public static volatile Charset f38167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.l
    public static volatile Charset f38168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public static volatile Charset f38169j;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        f0.o(charsetForName, "forName(\"UTF-8\")");
        f38161b = charsetForName;
        Charset charsetForName2 = Charset.forName(ya.g.f56719p);
        f0.o(charsetForName2, "forName(\"UTF-16\")");
        f38162c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        f0.o(charsetForName3, "forName(\"UTF-16BE\")");
        f38163d = charsetForName3;
        Charset charsetForName4 = Charset.forName(ya.g.f56723q);
        f0.o(charsetForName4, "forName(\"UTF-16LE\")");
        f38164e = charsetForName4;
        Charset charsetForName5 = Charset.forName(ya.g.f56707m);
        f0.o(charsetForName5, "forName(\"US-ASCII\")");
        f38165f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        f0.o(charsetForName6, "forName(\"ISO-8859-1\")");
        f38166g = charsetForName6;
    }

    @hk.h(name = "UTF32")
    @yt.k
    public final Charset a() {
        Charset charset = f38167h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32");
        f0.o(charsetForName, "forName(\"UTF-32\")");
        f38167h = charsetForName;
        return charsetForName;
    }

    @hk.h(name = "UTF32_BE")
    @yt.k
    public final Charset b() {
        Charset charset = f38169j;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        f0.o(charsetForName, "forName(\"UTF-32BE\")");
        f38169j = charsetForName;
        return charsetForName;
    }

    @hk.h(name = "UTF32_LE")
    @yt.k
    public final Charset c() {
        Charset charset = f38168i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        f0.o(charsetForName, "forName(\"UTF-32LE\")");
        f38168i = charsetForName;
        return charsetForName;
    }
}
