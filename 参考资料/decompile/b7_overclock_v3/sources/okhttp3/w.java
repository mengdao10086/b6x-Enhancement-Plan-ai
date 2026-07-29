package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.DeprecationLevel;
import kotlin.t0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\nB/\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000f\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\tJ\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0017\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\tR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lokhttp3/w;", "", "Ljava/nio/charset/Charset;", "defaultValue", "f", "", "name", "i", "b", "()Ljava/lang/String;", "a", "toString", "other", "", "equals", "", "hashCode", "Ljava/lang/String;", "mediaType", com.flydigi.sdk.bluetooth.l.f16298a, "type", "c", "k", "subtype", "", "d", "[Ljava/lang/String;", "parameterNamesAndValues", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "e", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final String f43985f = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final String f43986g = "\"([^\"]*)\"";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f43989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f43990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final String f43991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final String[] f43992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f43984e = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f43987h = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f43988i = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0005R\u001c\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\r¨\u0006\u0014"}, d2 = {"Lokhttp3/w$a;", "", "", "Lokhttp3/w;", "c", "(Ljava/lang/String;)Lokhttp3/w;", "d", "mediaType", "a", "b", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PARAMETER", "Ljava/util/regex/Pattern;", "QUOTED", "Ljava/lang/String;", "TOKEN", "TYPE_SUBTYPE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.h(name = "-deprecated_get")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @t0(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        @yt.k
        public final w a(@yt.k String mediaType) {
            kotlin.jvm.internal.f0.p(mediaType, "mediaType");
            return c(mediaType);
        }

        @hk.h(name = "-deprecated_parse")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @t0(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        @yt.l
        public final w b(@yt.k String mediaType) {
            kotlin.jvm.internal.f0.p(mediaType, "mediaType");
            return d(mediaType);
        }

        @hk.h(name = "get")
        @hk.m
        @yt.k
        public final w c(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            Matcher matcher = w.f43987h.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + kotlin.text.y.f38188b).toString());
            }
            String strGroup = matcher.group(1);
            kotlin.jvm.internal.f0.o(strGroup, "typeSubtype.group(1)");
            Locale US = Locale.US;
            kotlin.jvm.internal.f0.o(US, "US");
            String lowerCase = strGroup.toLowerCase(US);
            kotlin.jvm.internal.f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            kotlin.jvm.internal.f0.o(strGroup2, "typeSubtype.group(2)");
            kotlin.jvm.internal.f0.o(US, "US");
            String lowerCase2 = strGroup2.toLowerCase(US);
            kotlin.jvm.internal.f0.o(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = w.f43988i.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                    sb2.append(strSubstring);
                    sb2.append("\" for: \"");
                    sb2.append(str);
                    sb2.append(kotlin.text.y.f38188b);
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (kotlin.text.u.v2(strGroup4, "'", false, 2, null) && kotlin.text.u.K1(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        kotlin.jvm.internal.f0.o(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new w(str, lowerCase, lowerCase2, (String[]) array, null);
        }

        @hk.h(name = "parse")
        @hk.m
        @yt.l
        public final w d(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            try {
                return c(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public w(String str, String str2, String str3, String[] strArr) {
        this.f43989a = str;
        this.f43990b = str2;
        this.f43991c = str3;
        this.f43992d = strArr;
    }

    public /* synthetic */ w(String str, String str2, String str3, String[] strArr, kotlin.jvm.internal.u uVar) {
        this(str, str2, str3, strArr);
    }

    public static /* synthetic */ Charset g(w wVar, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = null;
        }
        return wVar.f(charset);
    }

    @hk.h(name = "get")
    @hk.m
    @yt.k
    public static final w h(@yt.k String str) {
        return f43984e.c(str);
    }

    @hk.h(name = "parse")
    @hk.m
    @yt.l
    public static final w j(@yt.k String str) {
        return f43984e.d(str);
    }

    @hk.h(name = "-deprecated_subtype")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "subtype", imports = {}))
    @yt.k
    public final String a() {
        return this.f43991c;
    }

    @hk.h(name = "-deprecated_type")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "type", imports = {}))
    @yt.k
    public final String b() {
        return this.f43990b;
    }

    @hk.i
    @yt.l
    public final Charset e() {
        return g(this, null, 1, null);
    }

    public boolean equals(@yt.l Object obj) {
        return (obj instanceof w) && kotlin.jvm.internal.f0.g(((w) obj).f43989a, this.f43989a);
    }

    @hk.i
    @yt.l
    public final Charset f(@yt.l Charset charset) {
        String strI = i("charset");
        if (strI == null) {
            return charset;
        }
        try {
            return Charset.forName(strI);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public int hashCode() {
        return this.f43989a.hashCode();
    }

    @yt.l
    public final String i(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        int i10 = 0;
        int iC = bk.n.c(0, this.f43992d.length - 1, 2);
        if (iC < 0) {
            return null;
        }
        while (true) {
            int i11 = i10 + 2;
            if (kotlin.text.u.L1(this.f43992d[i10], name, true)) {
                return this.f43992d[i10 + 1];
            }
            if (i10 == iC) {
                return null;
            }
            i10 = i11;
        }
    }

    @hk.h(name = "subtype")
    @yt.k
    public final String k() {
        return this.f43991c;
    }

    @hk.h(name = "type")
    @yt.k
    public final String l() {
        return this.f43990b;
    }

    @yt.k
    public String toString() {
        return this.f43989a;
    }
}
