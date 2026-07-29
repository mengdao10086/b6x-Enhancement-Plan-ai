package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.t0;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b#\u0018\u0000 32\u00020\u0001:\u0002\u0015\u0012BQ\b\u0002\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020\n\u0012\u0006\u0010'\u001a\u00020\n\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\u0006\u00100\u001a\u00020\u0004¢\u0006\u0004\b1\u00102J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0017J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000f\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0015\u0010\rJ\u000f\u0010\u0016\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0010J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u0017\u0010 \u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001f\u0010\rR\u0017\u0010#\u001a\u00020\u00118\u0007¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0013R\u0017\u0010%\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b$\u0010\rR\u0017\u0010'\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b&\u0010\rR\u0017\u0010*\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0010R\u0017\u0010,\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b+\u0010\u0010R\u0017\u0010.\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b-\u0010\u0010R\u0017\u00100\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b/\u0010\u0010¨\u00064"}, d2 = {"Lokhttp3/m;", "", "Lokhttp3/u;", "url", "", SsManifestParser.e.J, "other", "equals", "", "hashCode", "", "toString", "e", "()Ljava/lang/String;", "i", "g", "()Z", "", "b", "()J", "c", "a", "f", "d", "h", "forObsoleteRfc2965", "y", "(Z)Ljava/lang/String;", "Ljava/lang/String;", an.aB, "name", an.aD, "value", "J", "o", "expiresAt", "n", "domain", "v", "path", "Z", "x", "secure", "q", "httpOnly", "w", "persistent", "p", "hostOnly", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", xf.j.f55230b, "okhttp"}, k = 1, mv = {1, 6, 0})
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final b f43901j = new b(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f43902k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f43903l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f43904m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f43905n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f43906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f43907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f43908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final String f43909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final String f43910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f43911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f43912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f43913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f43914i;

    @kotlin.d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018¨\u0006\u001e"}, d2 = {"Lokhttp3/m$a;", "", "", "name", "g", "value", xf.j.f55230b, "", "expiresAt", "d", "domain", "b", "e", "path", "h", "i", "f", "Lokhttp3/m;", "a", "", "hostOnly", "c", "Ljava/lang/String;", "J", "Z", "secure", "httpOnly", "persistent", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public String f43915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public String f43916b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.l
        public String f43918d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f43920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f43921g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f43922h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f43923i;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f43917c = vl.c.f53195a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public String f43919e = fh.a.f28350w;

        @yt.k
        public final m a() {
            String str = this.f43915a;
            Objects.requireNonNull(str, "builder.name == null");
            String str2 = this.f43916b;
            Objects.requireNonNull(str2, "builder.value == null");
            long j10 = this.f43917c;
            String str3 = this.f43918d;
            Objects.requireNonNull(str3, "builder.domain == null");
            return new m(str, str2, j10, str3, this.f43919e, this.f43920f, this.f43921g, this.f43922h, this.f43923i, null);
        }

        @yt.k
        public final a b(@yt.k String domain) {
            kotlin.jvm.internal.f0.p(domain, "domain");
            return c(domain, false);
        }

        public final a c(String str, boolean z10) {
            String strE = rl.a.e(str);
            if (strE == null) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("unexpected domain: ", str));
            }
            this.f43918d = strE;
            this.f43923i = z10;
            return this;
        }

        @yt.k
        public final a d(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > vl.c.f53195a) {
                j10 = 253402300799999L;
            }
            this.f43917c = j10;
            this.f43922h = true;
            return this;
        }

        @yt.k
        public final a e(@yt.k String domain) {
            kotlin.jvm.internal.f0.p(domain, "domain");
            return c(domain, true);
        }

        @yt.k
        public final a f() {
            this.f43921g = true;
            return this;
        }

        @yt.k
        public final a g(@yt.k String name) {
            kotlin.jvm.internal.f0.p(name, "name");
            if (!kotlin.jvm.internal.f0.g(StringsKt__StringsKt.F5(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            this.f43915a = name;
            return this;
        }

        @yt.k
        public final a h(@yt.k String path) {
            kotlin.jvm.internal.f0.p(path, "path");
            if (!kotlin.text.u.v2(path, fh.a.f28350w, false, 2, null)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            this.f43919e = path;
            return this;
        }

        @yt.k
        public final a i() {
            this.f43920f = true;
            return this;
        }

        @yt.k
        public final a j(@yt.k String value) {
            kotlin.jvm.internal.f0.p(value, "value");
            if (!kotlin.jvm.internal.f0.g(StringsKt__StringsKt.F5(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            this.f43916b = value;
            return this;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J)\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0007J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J(\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002R\u001c\u0010\"\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u001c\u0010%\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u001c\u0010&\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010#¨\u0006)"}, d2 = {"Lokhttp3/m$b;", "", "Lokhttp3/u;", "url", "", "setCookie", "Lokhttp3/m;", "e", "", "currentTimeMillis", "f", "(JLokhttp3/u;Ljava/lang/String;)Lokhttp3/m;", "Lokhttp3/t;", IOptionConstant.headers, "", "g", "urlHost", "domain", "", "d", "path", "k", an.aB, "", "pos", "limit", "i", "input", "invert", "c", xf.j.f55230b, "h", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int c(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L0:
                if (r7 >= r8) goto L49
                int r0 = r7 + 1
                char r1 = r6.charAt(r7)
                r2 = 32
                r3 = 1
                r4 = 0
                if (r1 >= r2) goto L12
                r2 = 9
                if (r1 != r2) goto L41
            L12:
                r2 = 127(0x7f, float:1.78E-43)
                if (r1 >= r2) goto L41
                r2 = 57
                if (r1 > r2) goto L20
                r2 = 48
                if (r2 > r1) goto L20
                r2 = 1
                goto L21
            L20:
                r2 = 0
            L21:
                if (r2 != 0) goto L41
                r2 = 122(0x7a, float:1.71E-43)
                if (r1 > r2) goto L2d
                r2 = 97
                if (r2 > r1) goto L2d
                r2 = 1
                goto L2e
            L2d:
                r2 = 0
            L2e:
                if (r2 != 0) goto L41
                r2 = 90
                if (r1 > r2) goto L3a
                r2 = 65
                if (r2 > r1) goto L3a
                r2 = 1
                goto L3b
            L3a:
                r2 = 0
            L3b:
                if (r2 != 0) goto L41
                r2 = 58
                if (r1 != r2) goto L42
            L41:
                r4 = 1
            L42:
                r1 = r9 ^ 1
                if (r4 != r1) goto L47
                return r7
            L47:
                r7 = r0
                goto L0
            L49:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.m.b.c(java.lang.String, int, int, boolean):int");
        }

        public final boolean d(String str, String str2) {
            if (kotlin.jvm.internal.f0.g(str, str2)) {
                return true;
            }
            return kotlin.text.u.K1(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !rl.f.k(str);
        }

        @hk.m
        @yt.l
        public final m e(@yt.k u url, @yt.k String setCookie) {
            kotlin.jvm.internal.f0.p(url, "url");
            kotlin.jvm.internal.f0.p(setCookie, "setCookie");
            return f(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00dc A[PHI: r1
  0x00dc: PHI (r1v23 long) = (r1v8 long), (r1v11 long) binds: [B:45:0x00da, B:56:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
        @yt.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okhttp3.m f(long r26, @yt.k okhttp3.u r28, @yt.k java.lang.String r29) {
            /*
                Method dump skipped, instruction units count: 369
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.m.b.f(long, okhttp3.u, java.lang.String):okhttp3.m");
        }

        @hk.m
        @yt.k
        public final List<m> g(@yt.k u url, @yt.k t headers) {
            kotlin.jvm.internal.f0.p(url, "url");
            kotlin.jvm.internal.f0.p(headers, "headers");
            List<String> listS = headers.s(HttpHeaders.SET_COOKIE);
            int size = listS.size();
            ArrayList arrayList = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                m mVarE = e(url, listS.get(i10));
                if (mVarE != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(mVarE);
                }
                i10 = i11;
            }
            if (arrayList == null) {
                return CollectionsKt__CollectionsKt.E();
            }
            List<m> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            kotlin.jvm.internal.f0.o(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        public final String h(String str) {
            if (!(!kotlin.text.u.K1(str, j3.b.f36044h, false, 2, null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String strE = rl.a.e(StringsKt__StringsKt.d4(str, j3.b.f36044h));
            if (strE != null) {
                return strE;
            }
            throw new IllegalArgumentException();
        }

        public final long i(String str, int i10, int i11) {
            int iC = c(str, i10, i11, false);
            Matcher matcher = m.f43905n.matcher(str);
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int iS3 = -1;
            int i15 = -1;
            int i16 = -1;
            while (iC < i11) {
                int iC2 = c(str, iC + 1, i11, true);
                matcher.region(iC, iC2);
                if (i13 == -1 && matcher.usePattern(m.f43905n).matches()) {
                    String strGroup = matcher.group(1);
                    kotlin.jvm.internal.f0.o(strGroup, "matcher.group(1)");
                    i13 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    kotlin.jvm.internal.f0.o(strGroup2, "matcher.group(2)");
                    i15 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    kotlin.jvm.internal.f0.o(strGroup3, "matcher.group(3)");
                    i16 = Integer.parseInt(strGroup3);
                } else if (i14 == -1 && matcher.usePattern(m.f43904m).matches()) {
                    String strGroup4 = matcher.group(1);
                    kotlin.jvm.internal.f0.o(strGroup4, "matcher.group(1)");
                    i14 = Integer.parseInt(strGroup4);
                } else if (iS3 == -1 && matcher.usePattern(m.f43903l).matches()) {
                    String strGroup5 = matcher.group(1);
                    kotlin.jvm.internal.f0.o(strGroup5, "matcher.group(1)");
                    Locale US = Locale.US;
                    kotlin.jvm.internal.f0.o(US, "US");
                    String lowerCase = strGroup5.toLowerCase(US);
                    kotlin.jvm.internal.f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = m.f43903l.pattern();
                    kotlin.jvm.internal.f0.o(strPattern, "MONTH_PATTERN.pattern()");
                    iS3 = StringsKt__StringsKt.s3(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i12 == -1 && matcher.usePattern(m.f43902k).matches()) {
                    String strGroup6 = matcher.group(1);
                    kotlin.jvm.internal.f0.o(strGroup6, "matcher.group(1)");
                    i12 = Integer.parseInt(strGroup6);
                }
                iC = c(str, iC2 + 1, i11, false);
            }
            if (70 <= i12 && i12 < 100) {
                i12 += 1900;
            }
            if (i12 >= 0 && i12 < 70) {
                i12 += 2000;
            }
            if (!(i12 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iS3 != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i14 && i14 < 32)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i13 >= 0 && i13 < 24)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i15 >= 0 && i15 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i16 >= 0 && i16 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(rl.f.f48801f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i12);
            gregorianCalendar.set(2, iS3 - 1);
            gregorianCalendar.set(5, i14);
            gregorianCalendar.set(11, i13);
            gregorianCalendar.set(12, i15);
            gregorianCalendar.set(13, i16);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        public final long j(String str) {
            try {
                long j10 = Long.parseLong(str);
                if (j10 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j10;
            } catch (NumberFormatException e10) {
                if (new Regex("-?\\d+").n(str)) {
                    return kotlin.text.u.v2(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e10;
            }
        }

        public final boolean k(u uVar, String str) {
            String strX = uVar.x();
            if (kotlin.jvm.internal.f0.g(strX, str)) {
                return true;
            }
            return kotlin.text.u.v2(strX, str, false, 2, null) && (kotlin.text.u.K1(str, fh.a.f28350w, false, 2, null) || strX.charAt(str.length()) == '/');
        }
    }

    public m(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f43906a = str;
        this.f43907b = str2;
        this.f43908c = j10;
        this.f43909d = str3;
        this.f43910e = str4;
        this.f43911f = z10;
        this.f43912g = z11;
        this.f43913h = z12;
        this.f43914i = z13;
    }

    public /* synthetic */ m(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, kotlin.jvm.internal.u uVar) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13);
    }

    @hk.m
    @yt.l
    public static final m t(@yt.k u uVar, @yt.k String str) {
        return f43901j.e(uVar, str);
    }

    @hk.m
    @yt.k
    public static final List<m> u(@yt.k u uVar, @yt.k t tVar) {
        return f43901j.g(uVar, tVar);
    }

    @hk.h(name = "-deprecated_domain")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "domain", imports = {}))
    @yt.k
    public final String a() {
        return this.f43909d;
    }

    @hk.h(name = "-deprecated_expiresAt")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "expiresAt", imports = {}))
    public final long b() {
        return this.f43908c;
    }

    @hk.h(name = "-deprecated_hostOnly")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "hostOnly", imports = {}))
    public final boolean c() {
        return this.f43914i;
    }

    @hk.h(name = "-deprecated_httpOnly")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "httpOnly", imports = {}))
    public final boolean d() {
        return this.f43912g;
    }

    @hk.h(name = "-deprecated_name")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "name", imports = {}))
    @yt.k
    public final String e() {
        return this.f43906a;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (kotlin.jvm.internal.f0.g(mVar.f43906a, this.f43906a) && kotlin.jvm.internal.f0.g(mVar.f43907b, this.f43907b) && mVar.f43908c == this.f43908c && kotlin.jvm.internal.f0.g(mVar.f43909d, this.f43909d) && kotlin.jvm.internal.f0.g(mVar.f43910e, this.f43910e) && mVar.f43911f == this.f43911f && mVar.f43912g == this.f43912g && mVar.f43913h == this.f43913h && mVar.f43914i == this.f43914i) {
                return true;
            }
        }
        return false;
    }

    @hk.h(name = "-deprecated_path")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "path", imports = {}))
    @yt.k
    public final String f() {
        return this.f43910e;
    }

    @hk.h(name = "-deprecated_persistent")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "persistent", imports = {}))
    public final boolean g() {
        return this.f43913h;
    }

    @hk.h(name = "-deprecated_secure")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "secure", imports = {}))
    public final boolean h() {
        return this.f43911f;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.f43906a.hashCode()) * 31) + this.f43907b.hashCode()) * 31) + com.flydigi.data.bean.a.a(this.f43908c)) * 31) + this.f43909d.hashCode()) * 31) + this.f43910e.hashCode()) * 31) + l.a(this.f43911f)) * 31) + l.a(this.f43912g)) * 31) + l.a(this.f43913h)) * 31) + l.a(this.f43914i);
    }

    @hk.h(name = "-deprecated_value")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "value", imports = {}))
    @yt.k
    public final String i() {
        return this.f43907b;
    }

    @hk.h(name = "domain")
    @yt.k
    public final String n() {
        return this.f43909d;
    }

    @hk.h(name = "expiresAt")
    public final long o() {
        return this.f43908c;
    }

    @hk.h(name = "hostOnly")
    public final boolean p() {
        return this.f43914i;
    }

    @hk.h(name = "httpOnly")
    public final boolean q() {
        return this.f43912g;
    }

    public final boolean r(@yt.k u url) {
        kotlin.jvm.internal.f0.p(url, "url");
        if ((this.f43914i ? kotlin.jvm.internal.f0.g(url.F(), this.f43909d) : f43901j.d(url.F(), this.f43909d)) && f43901j.k(url, this.f43910e)) {
            return !this.f43911f || url.G();
        }
        return false;
    }

    @hk.h(name = "name")
    @yt.k
    public final String s() {
        return this.f43906a;
    }

    @yt.k
    public String toString() {
        return y(false);
    }

    @hk.h(name = "path")
    @yt.k
    public final String v() {
        return this.f43910e;
    }

    @hk.h(name = "persistent")
    public final boolean w() {
        return this.f43913h;
    }

    @hk.h(name = "secure")
    public final boolean x() {
        return this.f43911f;
    }

    @yt.k
    public final String y(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(s());
        sb2.append('=');
        sb2.append(z());
        if (w()) {
            if (o() == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(vl.c.b(new Date(o())));
            }
        }
        if (!p()) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(j3.b.f36044h);
            }
            sb2.append(n());
        }
        sb2.append("; path=");
        sb2.append(v());
        if (x()) {
            sb2.append("; secure");
        }
        if (q()) {
            sb2.append("; httponly");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.f0.o(string, "toString()");
        return string;
    }

    @hk.h(name = "value")
    @yt.k
    public final String z() {
        return this.f43907b;
    }
}
