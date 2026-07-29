package okhttp3;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.d1;
import kotlin.t0;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.w0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\"\n\u0002\b0\u0018\u0000 (2\u00020\u0001:\u00023#Bc\b\u0000\u0012\u0006\u00107\u001a\u00020\b\u0012\u0006\u00109\u001a\u00020\b\u0012\u0006\u0010;\u001a\u00020\b\u0012\u0006\u0010=\u001a\u00020\b\u0012\u0006\u0010?\u001a\u00020\r\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0010\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b\u0012\b\u0010E\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010F\u001a\u00020\b¢\u0006\u0004\b^\u0010_J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\bJ\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u0004\u0018\u00010\bJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001e\u0010\u0007J\u000f\u0010\u001f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0007¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\bH\u0007¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010 J\u000f\u0010$\u001a\u00020\bH\u0007¢\u0006\u0004\b$\u0010 J\u000f\u0010%\u001a\u00020\bH\u0007¢\u0006\u0004\b%\u0010 J\u000f\u0010&\u001a\u00020\rH\u0007¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\rH\u0007¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\bH\u0007¢\u0006\u0004\b)\u0010 J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0007¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0007¢\u0006\u0004\b,\u0010+J\u0011\u0010-\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b-\u0010 J\u0011\u0010.\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b.\u0010 J\u000f\u0010/\u001a\u00020\rH\u0007¢\u0006\u0004\b/\u0010'J\u0015\u00101\u001a\b\u0012\u0004\u0012\u00020\b00H\u0007¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b3\u0010 J\u0011\u00104\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b4\u0010 R\u0017\u00107\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b3\u00105\u001a\u0004\b6\u0010 R\u0017\u00109\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b8\u0010 R\u0017\u0010;\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b)\u00105\u001a\u0004\b:\u0010 R\u0017\u0010=\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b*\u00105\u001a\u0004\b<\u0010 R\u0017\u0010?\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b-\u0010\u0016\u001a\u0004\b>\u0010'R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8\u0007¢\u0006\f\n\u0004\b!\u0010@\u001a\u0004\bA\u0010+R\u001e\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010@R\u0019\u0010E\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\bD\u0010 R\u0014\u0010F\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u00105R\u0017\u0010I\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b,\u0010\u0006\u001a\u0004\bG\u0010HR\u0011\u0010K\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\bJ\u0010 R\u0011\u0010M\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\bL\u0010 R\u0011\u0010O\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\bN\u0010'R\u0011\u0010Q\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\bP\u0010 R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8G¢\u0006\u0006\u001a\u0004\bR\u0010+R\u0013\u0010U\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\bT\u0010 R\u0013\u0010W\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\bV\u0010 R\u0011\u0010Y\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\bX\u0010'R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\b008G¢\u0006\u0006\u001a\u0004\bZ\u00102R\u0013\u0010]\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b\\\u0010 ¨\u0006`"}, d2 = {"Lokhttp3/u;", "", "Ljava/net/URL;", "a0", "()Ljava/net/URL;", "Ljava/net/URI;", "Z", "()Ljava/net/URI;", "", "name", "P", "", i1.a.f31577d5, "", "index", "Q", i1.a.R4, i1.a.X4, "link", i1.a.T4, "Lokhttp3/u$a;", "H", "I", "other", "", "equals", "hashCode", "toString", "Y", SsManifestParser.e.J, "q", "p", "()Ljava/lang/String;", "f", an.aB, "b", "i", "h", com.flydigi.sdk.bluetooth.l.f16298a, "()I", "k", "c", "d", "()Ljava/util/List;", xf.j.f55230b, "e", m0.k.f40564b, "o", "", "n", "()Ljava/util/Set;", "a", "g", "Ljava/lang/String;", "X", "scheme", "b0", "username", "K", "password", "F", xl.e.f55523k, "N", "port", "Ljava/util/List;", "L", "pathSegments", "queryNamesAndValues", "B", "fragment", "url", "G", "()Z", "isHttps", i1.a.W4, "encodedUsername", "w", "encodedPassword", "M", "pathSize", "x", "encodedPath", "y", "encodedPathSegments", an.aD, "encodedQuery", "O", "query", "U", "querySize", "R", "queryParameterNames", "v", "encodedFragment", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public static final b f43948k = new b(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public static final char[] f43949l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.k
    public static final String f43950m = " \"':;<=>@[]^`{}|/\\?#";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public static final String f43951n = " \"':;<=>@[]^`{}|/\\?#";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public static final String f43952o = " \"<>^`{}|/\\?#";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.k
    public static final String f43953p = "[]";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @yt.k
    public static final String f43954q = " \"'<>#";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @yt.k
    public static final String f43955r = " \"'<>#&=";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @yt.k
    public static final String f43956s = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @yt.k
    public static final String f43957t = "\\^`{|}";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @yt.k
    public static final String f43958u = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @yt.k
    public static final String f43959v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @yt.k
    public static final String f43960w = " \"#<>\\^`{|}";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f43961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f43962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final String f43963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final String f43964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f43965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final List<String> f43966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public final List<String> f43967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public final String f43968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public final String f43969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f43970j;

    @kotlin.d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 \u00032\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\bd\u0010eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J0\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0004J\u0016\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004J\u0016\u0010-\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0002J\u000e\u00100\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0004J\u0010\u00102\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0010\u00104\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u00010\u0004J\u0018\u00107\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u0004J\u0018\u0010:\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u0004J\u0018\u0010;\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u0004J\u0018\u0010<\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u0004J\u000e\u0010=\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0004J\u000e\u0010>\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0004J\u0010\u0010@\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010\u0004J\u0010\u0010B\u001a\u00020\u00002\b\u0010A\u001a\u0004\u0018\u00010\u0004J\u000f\u0010C\u001a\u00020\u0000H\u0000¢\u0006\u0004\bC\u0010DJ\u0006\u0010F\u001a\u00020EJ\b\u0010G\u001a\u00020\u0004H\u0016J!\u0010I\u001a\u00020\u00002\b\u0010H\u001a\u0004\u0018\u00010E2\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0004\bI\u0010JR$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010\u001a\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010K\u001a\u0004\bP\u0010M\"\u0004\bQ\u0010OR\"\u0010\u001e\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b:\u0010K\u001a\u0004\bR\u0010M\"\u0004\bS\u0010OR$\u0010 \u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010K\u001a\u0004\bT\u0010M\"\u0004\bU\u0010OR\"\u0010\"\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010>\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR \u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040Z8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010[\u001a\u0004\b\\\u0010]R,\u0010a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010Z8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u0010[\u001a\u0004\b^\u0010]\"\u0004\b_\u0010`R$\u0010A\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010K\u001a\u0004\bb\u0010M\"\u0004\bc\u0010O¨\u0006f"}, d2 = {"Lokhttp3/u$a;", "", "", "i", "", "pathSegments", "", "alreadyEncoded", "f", "canonicalName", "Lkotlin/z1;", "H", "input", "startPos", "limit", "L", "pos", "addTrailingSlash", i1.a.S4, "y", an.aD, "C", "scheme", "M", "username", "Y", "encodedUsername", "n", "password", "B", "encodedPassword", "k", xl.e.f55523k, "x", "port", "D", "pathSegment", "d", "e", "encodedPathSegment", "a", "encodedPathSegments", "b", "index", "U", "P", "K", "encodedPath", com.flydigi.sdk.bluetooth.l.f16298a, "query", "F", "encodedQuery", m0.k.f40564b, "name", "value", "g", "encodedName", "encodedValue", "c", i1.a.T4, "R", "J", "I", "fragment", "o", "encodedFragment", xf.j.f55230b, "G", "()Lokhttp3/u$a;", "Lokhttp3/u;", "h", "toString", xc.d.W, i1.a.W4, "(Lokhttp3/u;Ljava/lang/String;)Lokhttp3/u$a;", "Ljava/lang/String;", "w", "()Ljava/lang/String;", "X", "(Ljava/lang/String;)V", "t", i1.a.R4, "q", "O", "u", i1.a.f31577d5, "v", "()I", i1.a.X4, "(I)V", "", "Ljava/util/List;", SsManifestParser.e.J, "()Ljava/util/List;", an.aB, "Q", "(Ljava/util/List;)V", "encodedQueryNamesAndValues", "p", "N", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @yt.k
        public static final C0498a f43971i = new C0498a(null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @yt.k
        public static final String f43972j = "Invalid URL host";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public String f43973a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.l
        public String f43976d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @yt.k
        public final List<String> f43978f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.l
        public List<String> f43979g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.l
        public String f43980h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public String f43974b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public String f43975c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f43977e = -1;

        /* JADX INFO: renamed from: okhttp3.u$a$a, reason: collision with other inner class name */
        @kotlin.d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lokhttp3/u$a$a;", "", "", "input", "", "pos", "limit", "g", "h", "f", "e", "INVALID_HOST", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0498a {
            public C0498a() {
            }

            public /* synthetic */ C0498a(kotlin.jvm.internal.u uVar) {
                this();
            }

            public final int e(String str, int i10, int i11) {
                try {
                    int i12 = Integer.parseInt(b.f(u.f43948k, str, i10, i11, "", false, false, false, false, null, 248, null));
                    boolean z10 = false;
                    if (1 <= i12 && i12 < 65536) {
                        z10 = true;
                    }
                    if (z10) {
                        return i12;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            public final int f(String str, int i10, int i11) {
                while (i10 < i11) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt == '[') {
                        do {
                            i10++;
                            if (i10 < i11) {
                            }
                        } while (str.charAt(i10) != ']');
                    } else if (cCharAt == ':') {
                        return i10;
                    }
                    i10++;
                }
                return i11;
            }

            public final int g(String str, int i10, int i11) {
                if (i11 - i10 < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i10);
                if ((kotlin.jvm.internal.f0.t(cCharAt, 97) < 0 || kotlin.jvm.internal.f0.t(cCharAt, 122) > 0) && (kotlin.jvm.internal.f0.t(cCharAt, 65) < 0 || kotlin.jvm.internal.f0.t(cCharAt, 90) > 0)) {
                    return -1;
                }
                int i12 = i10 + 1;
                while (i12 < i11) {
                    int i13 = i12 + 1;
                    char cCharAt2 = str.charAt(i12);
                    if (!(((((('a' <= cCharAt2 && cCharAt2 < '{') || ('A' <= cCharAt2 && cCharAt2 < '[')) || ('0' <= cCharAt2 && cCharAt2 < ':')) || cCharAt2 == '+') || cCharAt2 == '-') || cCharAt2 == '.')) {
                        if (cCharAt2 == ':') {
                            return i12;
                        }
                        return -1;
                    }
                    i12 = i13;
                }
                return -1;
            }

            public final int h(String str, int i10, int i11) {
                int i12 = 0;
                while (i10 < i11) {
                    int i13 = i10 + 1;
                    char cCharAt = str.charAt(i10);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i12++;
                    i10 = i13;
                }
                return i12;
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f43978f = arrayList;
            arrayList.add("");
        }

        @yt.k
        public final a A(@yt.l u uVar, @yt.k String str) {
            int iT;
            int i10;
            int i11;
            String str2;
            int i12;
            String str3;
            int i13;
            boolean z10;
            String input = str;
            kotlin.jvm.internal.f0.p(input, "input");
            int iG = rl.f.G(input, 0, 0, 3, null);
            int I = rl.f.I(input, iG, 0, 2, null);
            C0498a c0498a = f43971i;
            int iG2 = c0498a.g(input, iG, I);
            String str4 = "this as java.lang.String…ing(startIndex, endIndex)";
            byte b10 = -1;
            if (iG2 != -1) {
                if (kotlin.text.u.s2(input, "https:", iG, true)) {
                    this.f43973a = "https";
                    iG += 6;
                } else {
                    if (!kotlin.text.u.s2(input, "http:", iG, true)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input.substring(0, iG2);
                        kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb2.append(strSubstring);
                        sb2.append('\'');
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    this.f43973a = "http";
                    iG += 5;
                }
            } else {
                if (uVar == null) {
                    if (str.length() > 6) {
                        input = kotlin.jvm.internal.f0.C(StringsKt___StringsKt.Y8(input, 6), "...");
                    }
                    throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Expected URL scheme 'http' or 'https' but no scheme was found for ", input));
                }
                this.f43973a = uVar.X();
            }
            int iH = c0498a.h(input, iG, I);
            byte b11 = w0.f44229a;
            byte b12 = 35;
            if (iH >= 2 || uVar == null || !kotlin.jvm.internal.f0.g(uVar.X(), this.f43973a)) {
                int i14 = iG + iH;
                boolean z11 = false;
                boolean z12 = false;
                while (true) {
                    iT = rl.f.t(input, "@/\\?#", i14, I);
                    byte bCharAt = iT != I ? input.charAt(iT) : (byte) -1;
                    if (bCharAt == b10 || bCharAt == b12 || bCharAt == 47 || bCharAt == 92 || bCharAt == b11) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z11) {
                            i12 = I;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.f43975c);
                            sb3.append("%40");
                            str3 = str4;
                            i13 = iT;
                            sb3.append(b.f(u.f43948k, str, i14, iT, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.f43975c = sb3.toString();
                        } else {
                            int iS = rl.f.s(input, ':', i14, iT);
                            b bVar = u.f43948k;
                            i12 = I;
                            String str5 = str4;
                            String strF = b.f(bVar, str, i14, iS, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z12) {
                                strF = this.f43974b + "%40" + strF;
                            }
                            this.f43974b = strF;
                            if (iS != iT) {
                                this.f43975c = b.f(bVar, str, iS + 1, iT, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z10 = true;
                            } else {
                                z10 = z11;
                            }
                            z11 = z10;
                            str3 = str5;
                            z12 = true;
                            i13 = iT;
                        }
                        i14 = i13 + 1;
                        str4 = str3;
                        I = i12;
                        b12 = 35;
                        b11 = w0.f44229a;
                        b10 = -1;
                    }
                }
                String str6 = str4;
                i10 = I;
                C0498a c0498a2 = f43971i;
                int iF = c0498a2.f(input, i14, iT);
                int i15 = iF + 1;
                if (i15 < iT) {
                    i11 = i14;
                    this.f43976d = rl.a.e(b.n(u.f43948k, str, i14, iF, false, 4, null));
                    int iE = c0498a2.e(input, i15, iT);
                    this.f43977e = iE;
                    if (!(iE != -1)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid URL port: \"");
                        String strSubstring2 = input.substring(i15, iT);
                        kotlin.jvm.internal.f0.o(strSubstring2, str6);
                        sb4.append(strSubstring2);
                        sb4.append(kotlin.text.y.f38188b);
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                    str2 = str6;
                } else {
                    i11 = i14;
                    str2 = str6;
                    b bVar2 = u.f43948k;
                    this.f43976d = rl.a.e(b.n(bVar2, str, i11, iF, false, 4, null));
                    String str7 = this.f43973a;
                    kotlin.jvm.internal.f0.m(str7);
                    this.f43977e = bVar2.g(str7);
                }
                if (!(this.f43976d != null)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid URL host: \"");
                    String strSubstring3 = input.substring(i11, iF);
                    kotlin.jvm.internal.f0.o(strSubstring3, str2);
                    sb5.append(strSubstring3);
                    sb5.append(kotlin.text.y.f38188b);
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
                iG = iT;
            } else {
                this.f43974b = uVar.A();
                this.f43975c = uVar.w();
                this.f43976d = uVar.F();
                this.f43977e = uVar.N();
                this.f43978f.clear();
                this.f43978f.addAll(uVar.y());
                if (iG == I || input.charAt(iG) == '#') {
                    m(uVar.z());
                }
                i10 = I;
            }
            int i16 = i10;
            int iT2 = rl.f.t(input, "?#", iG, i16);
            L(input, iG, iT2);
            if (iT2 < i16 && input.charAt(iT2) == '?') {
                int iS2 = rl.f.s(input, '#', iT2, i16);
                b bVar3 = u.f43948k;
                this.f43979g = bVar3.p(b.f(bVar3, str, iT2 + 1, iS2, u.f43954q, true, false, true, false, null, 208, null));
                iT2 = iS2;
            }
            if (iT2 < i16 && input.charAt(iT2) == '#') {
                this.f43980h = b.f(u.f43948k, str, iT2 + 1, i16, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        @yt.k
        public final a B(@yt.k String password) {
            kotlin.jvm.internal.f0.p(password, "password");
            O(b.f(u.f43948k, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, mb.e.f41067u1, null));
            return this;
        }

        public final void C() {
            List<String> list = this.f43978f;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.f43978f.isEmpty())) {
                this.f43978f.add("");
            } else {
                List<String> list2 = this.f43978f;
                list2.set(list2.size() - 1, "");
            }
        }

        @yt.k
        public final a D(int i10) {
            boolean z10 = false;
            if (1 <= i10 && i10 < 65536) {
                z10 = true;
            }
            if (!z10) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("unexpected port: ", Integer.valueOf(i10)).toString());
            }
            V(i10);
            return this;
        }

        public final void E(String str, int i10, int i11, boolean z10, boolean z11) {
            String strF = b.f(u.f43948k, str, i10, i11, u.f43952o, z11, false, false, false, null, 240, null);
            if (y(strF)) {
                return;
            }
            if (z(strF)) {
                C();
                return;
            }
            List<String> list = this.f43978f;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.f43978f;
                list2.set(list2.size() - 1, strF);
            } else {
                this.f43978f.add(strF);
            }
            if (z10) {
                this.f43978f.add("");
            }
        }

        @yt.k
        public final a F(@yt.l String str) {
            List<String> listP = null;
            if (str != null) {
                b bVar = u.f43948k;
                String strF = b.f(bVar, str, 0, 0, u.f43954q, false, false, true, false, null, 219, null);
                if (strF != null) {
                    listP = bVar.p(strF);
                }
            }
            Q(listP);
            return this;
        }

        @yt.k
        public final a G() {
            String strU = u();
            T(strU == null ? null : new Regex("[\"<>^`{|}]").q(strU, ""));
            int size = r().size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                r().set(i11, b.f(u.f43948k, r().get(i11), 0, 0, u.f43953p, true, true, false, false, null, 227, null));
            }
            List<String> listS = s();
            if (listS != null) {
                int size2 = listS.size();
                while (i10 < size2) {
                    int i12 = i10 + 1;
                    String str = listS.get(i10);
                    listS.set(i10, str == null ? null : b.f(u.f43948k, str, 0, 0, u.f43957t, true, true, true, false, null, 195, null));
                    i10 = i12;
                }
            }
            String strP = p();
            N(strP != null ? b.f(u.f43948k, strP, 0, 0, u.f43960w, true, true, false, true, null, 163, null) : null);
            return this;
        }

        public final void H(String str) {
            List<String> list = this.f43979g;
            kotlin.jvm.internal.f0.m(list);
            int size = list.size() - 2;
            int iC = bk.n.c(size, 0, -2);
            if (iC > size) {
                return;
            }
            while (true) {
                int i10 = size - 2;
                List<String> list2 = this.f43979g;
                kotlin.jvm.internal.f0.m(list2);
                if (kotlin.jvm.internal.f0.g(str, list2.get(size))) {
                    List<String> list3 = this.f43979g;
                    kotlin.jvm.internal.f0.m(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.f43979g;
                    kotlin.jvm.internal.f0.m(list4);
                    list4.remove(size);
                    List<String> list5 = this.f43979g;
                    kotlin.jvm.internal.f0.m(list5);
                    if (list5.isEmpty()) {
                        this.f43979g = null;
                        return;
                    }
                }
                if (size == iC) {
                    return;
                } else {
                    size = i10;
                }
            }
        }

        @yt.k
        public final a I(@yt.k String encodedName) {
            kotlin.jvm.internal.f0.p(encodedName, "encodedName");
            if (s() == null) {
                return this;
            }
            H(b.f(u.f43948k, encodedName, 0, 0, u.f43955r, true, false, true, false, null, hr.a.f31427a, null));
            return this;
        }

        @yt.k
        public final a J(@yt.k String name) {
            kotlin.jvm.internal.f0.p(name, "name");
            if (s() == null) {
                return this;
            }
            H(b.f(u.f43948k, name, 0, 0, u.f43956s, false, false, true, false, null, 219, null));
            return this;
        }

        @yt.k
        public final a K(int i10) {
            r().remove(i10);
            if (r().isEmpty()) {
                r().add("");
            }
            return this;
        }

        public final void L(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f43978f.clear();
                this.f43978f.add("");
                i10++;
            } else {
                List<String> list = this.f43978f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i12 = i10;
                while (i12 < i11) {
                    i10 = rl.f.t(str, "/\\", i12, i11);
                    boolean z10 = i10 < i11;
                    E(str, i12, i10, z10, true);
                    if (z10) {
                        i12 = i10 + 1;
                    }
                }
                return;
            }
        }

        @yt.k
        public final a M(@yt.k String scheme) {
            kotlin.jvm.internal.f0.p(scheme, "scheme");
            if (kotlin.text.u.L1(scheme, "http", true)) {
                X("http");
            } else {
                if (!kotlin.text.u.L1(scheme, "https", true)) {
                    throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("unexpected scheme: ", scheme));
                }
                X("https");
            }
            return this;
        }

        public final void N(@yt.l String str) {
            this.f43980h = str;
        }

        public final void O(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<set-?>");
            this.f43975c = str;
        }

        @yt.k
        public final a P(int i10, @yt.k String encodedPathSegment) {
            kotlin.jvm.internal.f0.p(encodedPathSegment, "encodedPathSegment");
            String strF = b.f(u.f43948k, encodedPathSegment, 0, 0, u.f43952o, true, false, false, false, null, 243, null);
            r().set(i10, strF);
            if ((y(strF) || z(strF)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("unexpected path segment: ", encodedPathSegment).toString());
        }

        public final void Q(@yt.l List<String> list) {
            this.f43979g = list;
        }

        @yt.k
        public final a R(@yt.k String encodedName, @yt.l String str) {
            kotlin.jvm.internal.f0.p(encodedName, "encodedName");
            I(encodedName);
            c(encodedName, str);
            return this;
        }

        public final void S(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<set-?>");
            this.f43974b = str;
        }

        public final void T(@yt.l String str) {
            this.f43976d = str;
        }

        @yt.k
        public final a U(int i10, @yt.k String pathSegment) {
            kotlin.jvm.internal.f0.p(pathSegment, "pathSegment");
            String strF = b.f(u.f43948k, pathSegment, 0, 0, u.f43952o, false, false, false, false, null, mb.e.f41067u1, null);
            if (!((y(strF) || z(strF)) ? false : true)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("unexpected path segment: ", pathSegment).toString());
            }
            r().set(i10, strF);
            return this;
        }

        public final void V(int i10) {
            this.f43977e = i10;
        }

        @yt.k
        public final a W(@yt.k String name, @yt.l String str) {
            kotlin.jvm.internal.f0.p(name, "name");
            J(name);
            g(name, str);
            return this;
        }

        public final void X(@yt.l String str) {
            this.f43973a = str;
        }

        @yt.k
        public final a Y(@yt.k String username) {
            kotlin.jvm.internal.f0.p(username, "username");
            S(b.f(u.f43948k, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, mb.e.f41067u1, null));
            return this;
        }

        @yt.k
        public final a a(@yt.k String encodedPathSegment) {
            kotlin.jvm.internal.f0.p(encodedPathSegment, "encodedPathSegment");
            E(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        @yt.k
        public final a b(@yt.k String encodedPathSegments) {
            kotlin.jvm.internal.f0.p(encodedPathSegments, "encodedPathSegments");
            return f(encodedPathSegments, true);
        }

        @yt.k
        public final a c(@yt.k String encodedName, @yt.l String str) {
            kotlin.jvm.internal.f0.p(encodedName, "encodedName");
            if (s() == null) {
                Q(new ArrayList());
            }
            List<String> listS = s();
            kotlin.jvm.internal.f0.m(listS);
            b bVar = u.f43948k;
            listS.add(b.f(bVar, encodedName, 0, 0, u.f43955r, true, false, true, false, null, hr.a.f31427a, null));
            List<String> listS2 = s();
            kotlin.jvm.internal.f0.m(listS2);
            listS2.add(str == null ? null : b.f(bVar, str, 0, 0, u.f43955r, true, false, true, false, null, hr.a.f31427a, null));
            return this;
        }

        @yt.k
        public final a d(@yt.k String pathSegment) {
            kotlin.jvm.internal.f0.p(pathSegment, "pathSegment");
            E(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        @yt.k
        public final a e(@yt.k String pathSegments) {
            kotlin.jvm.internal.f0.p(pathSegments, "pathSegments");
            return f(pathSegments, false);
        }

        public final a f(String str, boolean z10) {
            int i10 = 0;
            do {
                int iT = rl.f.t(str, "/\\", i10, str.length());
                E(str, i10, iT, iT < str.length(), z10);
                i10 = iT + 1;
            } while (i10 <= str.length());
            return this;
        }

        @yt.k
        public final a g(@yt.k String name, @yt.l String str) {
            kotlin.jvm.internal.f0.p(name, "name");
            if (s() == null) {
                Q(new ArrayList());
            }
            List<String> listS = s();
            kotlin.jvm.internal.f0.m(listS);
            b bVar = u.f43948k;
            listS.add(b.f(bVar, name, 0, 0, u.f43956s, false, false, true, false, null, 219, null));
            List<String> listS2 = s();
            kotlin.jvm.internal.f0.m(listS2);
            listS2.add(str == null ? null : b.f(bVar, str, 0, 0, u.f43956s, false, false, true, false, null, 219, null));
            return this;
        }

        @yt.k
        public final u h() {
            ArrayList arrayList;
            String str = this.f43973a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = u.f43948k;
            String strN = b.n(bVar, this.f43974b, 0, 0, false, 7, null);
            String strN2 = b.n(bVar, this.f43975c, 0, 0, false, 7, null);
            String str2 = this.f43976d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int i10 = i();
            List<String> list = this.f43978f;
            ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(b.n(u.f43948k, (String) it2.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.f43979g;
            if (list2 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(kotlin.collections.t.Y(list2, 10));
                for (String str3 : list2) {
                    arrayList.add(str3 == null ? null : b.n(u.f43948k, str3, 0, 0, true, 3, null));
                }
            }
            String str4 = this.f43980h;
            return new u(str, strN, strN2, str2, i10, arrayList2, arrayList, str4 == null ? null : b.n(u.f43948k, str4, 0, 0, false, 7, null), toString());
        }

        public final int i() {
            int i10 = this.f43977e;
            if (i10 != -1) {
                return i10;
            }
            b bVar = u.f43948k;
            String str = this.f43973a;
            kotlin.jvm.internal.f0.m(str);
            return bVar.g(str);
        }

        @yt.k
        public final a j(@yt.l String str) {
            N(str == null ? null : b.f(u.f43948k, str, 0, 0, "", true, false, false, true, null, 179, null));
            return this;
        }

        @yt.k
        public final a k(@yt.k String encodedPassword) {
            kotlin.jvm.internal.f0.p(encodedPassword, "encodedPassword");
            O(b.f(u.f43948k, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null));
            return this;
        }

        @yt.k
        public final a l(@yt.k String encodedPath) {
            kotlin.jvm.internal.f0.p(encodedPath, "encodedPath");
            if (!kotlin.text.u.v2(encodedPath, fh.a.f28350w, false, 2, null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("unexpected encodedPath: ", encodedPath).toString());
            }
            L(encodedPath, 0, encodedPath.length());
            return this;
        }

        @yt.k
        public final a m(@yt.l String str) {
            List<String> listP = null;
            if (str != null) {
                b bVar = u.f43948k;
                String strF = b.f(bVar, str, 0, 0, u.f43954q, true, false, true, false, null, hr.a.f31427a, null);
                if (strF != null) {
                    listP = bVar.p(strF);
                }
            }
            Q(listP);
            return this;
        }

        @yt.k
        public final a n(@yt.k String encodedUsername) {
            kotlin.jvm.internal.f0.p(encodedUsername, "encodedUsername");
            S(b.f(u.f43948k, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null));
            return this;
        }

        @yt.k
        public final a o(@yt.l String str) {
            N(str == null ? null : b.f(u.f43948k, str, 0, 0, "", false, false, false, true, null, mb.e.f41031i2, null));
            return this;
        }

        @yt.l
        public final String p() {
            return this.f43980h;
        }

        @yt.k
        public final String q() {
            return this.f43975c;
        }

        @yt.k
        public final List<String> r() {
            return this.f43978f;
        }

        @yt.l
        public final List<String> s() {
            return this.f43979g;
        }

        @yt.k
        public final String t() {
            return this.f43974b;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
        @yt.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                Method dump skipped, instruction units count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.u.a.toString():java.lang.String");
        }

        @yt.l
        public final String u() {
            return this.f43976d;
        }

        public final int v() {
            return this.f43977e;
        }

        @yt.l
        public final String w() {
            return this.f43973a;
        }

        @yt.k
        public final a x(@yt.k String host) {
            kotlin.jvm.internal.f0.p(host, "host");
            String strE = rl.a.e(b.n(u.f43948k, host, 0, 0, false, 7, null));
            if (strE == null) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("unexpected host: ", host));
            }
            T(strE);
            return this;
        }

        public final boolean y(String str) {
            return kotlin.jvm.internal.f0.g(str, j3.b.f36044h) || kotlin.text.u.L1(str, "%2e", true);
        }

        public final boolean z(String str) {
            return kotlin.jvm.internal.f0.g(str, "..") || kotlin.text.u.L1(str, "%2e.", true) || kotlin.text.u.L1(str, ".%2e", true) || kotlin.text.u.L1(str, "%2e%2e", true);
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J%\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00020\u00062\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0000¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e*\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0011*\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0011*\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001c\u0010\u0013J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u0013J\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001e\u0010\u0017J\u0019\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020\u0018H\u0007¢\u0006\u0004\b \u0010\u001aJ1\u0010%\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&Jc\u0010-\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020#2\b\b\u0002\u0010)\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010*\u001a\u00020#2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0004\b-\u0010.J,\u00101\u001a\u00020\n*\u00020/2\u0006\u00100\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002J\u001c\u00102\u001a\u00020#*\u00020\u00022\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002JV\u00104\u001a\u00020\n*\u00020/2\u0006\u00103\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010*\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010+H\u0002R\u0014\u00105\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b<\u00106R\u0014\u0010=\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b=\u00106R\u0014\u0010>\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b>\u00106R\u0014\u0010?\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u00106R\u0014\u0010@\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b@\u00106R\u0014\u0010A\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bA\u00106R\u0014\u0010B\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bB\u00106R\u0014\u0010C\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bC\u00106¨\u0006F"}, d2 = {"Lokhttp3/u$b;", "", "", "scheme", "", "g", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "Lkotlin/z1;", "o", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "q", "", "p", "(Ljava/lang/String;)Ljava/util/List;", "Lokhttp3/u;", "h", "(Ljava/lang/String;)Lokhttp3/u;", com.flydigi.sdk.bluetooth.l.f16298a, "Ljava/net/URL;", xf.j.f55230b, "(Ljava/net/URL;)Lokhttp3/u;", "Ljava/net/URI;", "i", "(Ljava/net/URI;)Lokhttp3/u;", "url", "a", "d", "c", "uri", "b", "pos", "limit", "", "plusIsSpace", m0.k.f40564b, "(Ljava/lang/String;IIZ)Ljava/lang/String;", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "e", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "Lokio/j;", "encoded", an.aB, "k", "input", SsManifestParser.e.J, "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ String f(b bVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12, Object obj) {
            return bVar.e(str, (i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? str.length() : i11, str2, (i12 & 8) != 0 ? false : z10, (i12 & 16) != 0 ? false : z11, (i12 & 32) != 0 ? false : z12, (i12 & 64) != 0 ? false : z13, (i12 & 128) != 0 ? null : charset);
        }

        public static /* synthetic */ String n(b bVar, String str, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = str.length();
            }
            if ((i12 & 4) != 0) {
                z10 = false;
            }
            return bVar.m(str, i10, i11, z10);
        }

        @hk.h(name = "-deprecated_get")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @t0(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        @yt.k
        public final u a(@yt.k String url) {
            kotlin.jvm.internal.f0.p(url, "url");
            return h(url);
        }

        @hk.h(name = "-deprecated_get")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @t0(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @yt.l
        public final u b(@yt.k URI uri) {
            kotlin.jvm.internal.f0.p(uri, "uri");
            return i(uri);
        }

        @hk.h(name = "-deprecated_get")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @t0(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @yt.l
        public final u c(@yt.k URL url) {
            kotlin.jvm.internal.f0.p(url, "url");
            return j(url);
        }

        @hk.h(name = "-deprecated_parse")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @t0(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @yt.l
        public final u d(@yt.k String url) {
            kotlin.jvm.internal.f0.p(url, "url");
            return l(url);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
        @yt.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String e(@yt.k java.lang.String r14, int r15, int r16, @yt.k java.lang.String r17, boolean r18, boolean r19, boolean r20, boolean r21, @yt.l java.nio.charset.Charset r22) {
            /*
                r13 = this;
                r2 = r14
                r4 = r16
                r5 = r17
                java.lang.String r0 = "<this>"
                kotlin.jvm.internal.f0.p(r14, r0)
                java.lang.String r0 = "encodeSet"
                kotlin.jvm.internal.f0.p(r5, r0)
                r3 = r15
            L10:
                if (r3 >= r4) goto L6f
                int r0 = r14.codePointAt(r3)
                r1 = 32
                if (r0 < r1) goto L4c
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 == r1) goto L4c
                r1 = 128(0x80, float:1.8E-43)
                if (r0 < r1) goto L24
                if (r21 == 0) goto L4c
            L24:
                char r1 = (char) r0
                r6 = 0
                r7 = 2
                r8 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.V2(r5, r1, r6, r7, r8)
                if (r1 != 0) goto L4c
                r1 = 37
                if (r0 != r1) goto L3e
                if (r18 == 0) goto L4c
                if (r19 == 0) goto L3e
                r11 = r13
                boolean r1 = r13.k(r14, r3, r4)
                if (r1 == 0) goto L4d
                goto L3f
            L3e:
                r11 = r13
            L3f:
                r1 = 43
                if (r0 != r1) goto L46
                if (r20 == 0) goto L46
                goto L4d
            L46:
                int r0 = java.lang.Character.charCount(r0)
                int r3 = r3 + r0
                goto L10
            L4c:
                r11 = r13
            L4d:
                okio.j r12 = new okio.j
                r12.<init>()
                r0 = r15
                r12.W0(r14, r15, r3)
                r0 = r13
                r1 = r12
                r2 = r14
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r10 = r22
                r0.r(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                java.lang.String r0 = r12.y1()
                return r0
            L6f:
                r11 = r13
                r0 = r15
                java.lang.String r0 = r14.substring(r15, r16)
                java.lang.String r1 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.f0.o(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.u.b.e(java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):java.lang.String");
        }

        @hk.m
        public final int g(@yt.k String scheme) {
            kotlin.jvm.internal.f0.p(scheme, "scheme");
            if (kotlin.jvm.internal.f0.g(scheme, "http")) {
                return 80;
            }
            if (kotlin.jvm.internal.f0.g(scheme, "https")) {
                return rb.a0.f47912q;
            }
            return -1;
        }

        @hk.h(name = "get")
        @hk.m
        @yt.k
        public final u h(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            return new a().A(null, str).h();
        }

        @hk.h(name = "get")
        @hk.m
        @yt.l
        public final u i(@yt.k URI uri) {
            kotlin.jvm.internal.f0.p(uri, "<this>");
            String string = uri.toString();
            kotlin.jvm.internal.f0.o(string, "toString()");
            return l(string);
        }

        @hk.h(name = "get")
        @hk.m
        @yt.l
        public final u j(@yt.k URL url) {
            kotlin.jvm.internal.f0.p(url, "<this>");
            String string = url.toString();
            kotlin.jvm.internal.f0.o(string, "toString()");
            return l(string);
        }

        public final boolean k(String str, int i10, int i11) {
            int i12 = i10 + 2;
            return i12 < i11 && str.charAt(i10) == '%' && rl.f.R(str.charAt(i10 + 1)) != -1 && rl.f.R(str.charAt(i12)) != -1;
        }

        @hk.h(name = "parse")
        @hk.m
        @yt.l
        public final u l(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            try {
                return h(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @yt.k
        public final String m(@yt.k String str, int i10, int i11, boolean z10) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            int i12 = i10;
            while (i12 < i11) {
                int i13 = i12 + 1;
                char cCharAt = str.charAt(i12);
                if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                    okio.j jVar = new okio.j();
                    jVar.W0(str, i10, i12);
                    s(jVar, str, i12, i11, z10);
                    return jVar.y1();
                }
                i12 = i13;
            }
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void o(@yt.k List<String> list, @yt.k StringBuilder out) {
            kotlin.jvm.internal.f0.p(list, "<this>");
            kotlin.jvm.internal.f0.p(out, "out");
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                out.append(zc.f.f58380j);
                out.append(list.get(i10));
            }
        }

        @yt.k
        public final List<String> p(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                int iR3 = StringsKt__StringsKt.r3(str, '&', i10, false, 4, null);
                if (iR3 == -1) {
                    iR3 = str.length();
                }
                int i11 = iR3;
                int iR32 = StringsKt__StringsKt.r3(str, '=', i10, false, 4, null);
                if (iR32 == -1 || iR32 > i11) {
                    String strSubstring = str.substring(i10, i11);
                    kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i10, iR32);
                    kotlin.jvm.internal.f0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iR32 + 1, i11);
                    kotlin.jvm.internal.f0.o(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i10 = i11 + 1;
            }
            return arrayList;
        }

        public final void q(@yt.k List<String> list, @yt.k StringBuilder out) {
            kotlin.jvm.internal.f0.p(list, "<this>");
            kotlin.jvm.internal.f0.p(out, "out");
            qk.k kVarB1 = qk.v.B1(qk.v.W1(0, list.size()), 2);
            int iG = kVarB1.g();
            int iJ = kVarB1.j();
            int iL = kVarB1.l();
            if ((iL <= 0 || iG > iJ) && (iL >= 0 || iJ > iG)) {
                return;
            }
            while (true) {
                int i10 = iG + iL;
                String str = list.get(iG);
                String str2 = list.get(iG + 1);
                if (iG > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (iG == iJ) {
                    return;
                } else {
                    iG = i10;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0090 A[LOOP:1: B:49:0x008a->B:51:0x0090, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void r(okio.j r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lb9
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L28
                r8 = 9
                if (r7 == r8) goto L23
                r8 = 10
                if (r7 == r8) goto L23
                r8 = 12
                if (r7 == r8) goto L23
                r8 = 13
                if (r7 != r8) goto L28
            L23:
                r8 = r14
                r12 = r19
                goto Lb2
            L28:
                r8 = 43
                if (r7 != r8) goto L39
                if (r22 == 0) goto L39
                if (r20 == 0) goto L33
                java.lang.String r8 = "+"
                goto L35
            L33:
                java.lang.String r8 = "%2B"
            L35:
                r15.H0(r8)
                goto L23
            L39:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L69
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L69
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L49
                if (r23 == 0) goto L69
            L49:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt__StringsKt.V2(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L67
                if (r7 != r9) goto L62
                if (r20 == 0) goto L67
                if (r21 == 0) goto L62
                r8 = r14
                boolean r10 = r14.k(r1, r5, r2)
                if (r10 != 0) goto L63
                goto L6c
            L62:
                r8 = r14
            L63:
                r15.H(r7)
                goto Lb2
            L67:
                r8 = r14
                goto L6c
            L69:
                r8 = r14
                r12 = r19
            L6c:
                if (r6 != 0) goto L73
                okio.j r6 = new okio.j
                r6.<init>()
            L73:
                if (r3 == 0) goto L87
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = kotlin.jvm.internal.f0.g(r3, r10)
                if (r10 == 0) goto L7e
                goto L87
            L7e:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.S1(r1, r5, r10, r3)
                goto L8a
            L87:
                r6.H(r7)
            L8a:
                boolean r10 = r6.d0()
                if (r10 != 0) goto Lb2
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = okhttp3.u.t()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = okhttp3.u.t()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L8a
            Lb2:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lb9:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.u.b.r(okio.j, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        public final void s(okio.j jVar, String str, int i10, int i11, boolean z10) {
            int i12;
            while (i10 < i11) {
                int iCodePointAt = str.codePointAt(i10);
                if (iCodePointAt == 37 && (i12 = i10 + 2) < i11) {
                    int iR = rl.f.R(str.charAt(i10 + 1));
                    int iR2 = rl.f.R(str.charAt(i12));
                    if (iR == -1 || iR2 == -1) {
                        jVar.H(iCodePointAt);
                        i10 += Character.charCount(iCodePointAt);
                    } else {
                        jVar.writeByte((iR << 4) + iR2);
                        i10 = Character.charCount(iCodePointAt) + i12;
                    }
                } else if (iCodePointAt == 43 && z10) {
                    jVar.writeByte(32);
                    i10++;
                } else {
                    jVar.H(iCodePointAt);
                    i10 += Character.charCount(iCodePointAt);
                }
            }
        }
    }

    public u(@yt.k String scheme, @yt.k String username, @yt.k String password, @yt.k String host, int i10, @yt.k List<String> pathSegments, @yt.l List<String> list, @yt.l String str, @yt.k String url) {
        kotlin.jvm.internal.f0.p(scheme, "scheme");
        kotlin.jvm.internal.f0.p(username, "username");
        kotlin.jvm.internal.f0.p(password, "password");
        kotlin.jvm.internal.f0.p(host, "host");
        kotlin.jvm.internal.f0.p(pathSegments, "pathSegments");
        kotlin.jvm.internal.f0.p(url, "url");
        this.f43961a = scheme;
        this.f43962b = username;
        this.f43963c = password;
        this.f43964d = host;
        this.f43965e = i10;
        this.f43966f = pathSegments;
        this.f43967g = list;
        this.f43968h = str;
        this.f43969i = url;
        this.f43970j = kotlin.jvm.internal.f0.g(scheme, "https");
    }

    @hk.h(name = "get")
    @hk.m
    @yt.k
    public static final u C(@yt.k String str) {
        return f43948k.h(str);
    }

    @hk.h(name = "get")
    @hk.m
    @yt.l
    public static final u D(@yt.k URI uri) {
        return f43948k.i(uri);
    }

    @hk.h(name = "get")
    @hk.m
    @yt.l
    public static final u E(@yt.k URL url) {
        return f43948k.j(url);
    }

    @hk.h(name = "parse")
    @hk.m
    @yt.l
    public static final u J(@yt.k String str) {
        return f43948k.l(str);
    }

    @hk.m
    public static final int u(@yt.k String str) {
        return f43948k.g(str);
    }

    @hk.h(name = "encodedUsername")
    @yt.k
    public final String A() {
        if (this.f43962b.length() == 0) {
            return "";
        }
        int length = this.f43961a.length() + 3;
        String str = this.f43969i;
        String strSubstring = this.f43969i.substring(length, rl.f.t(str, ":@", length, str.length()));
        kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @hk.h(name = "fragment")
    @yt.l
    public final String B() {
        return this.f43968h;
    }

    @hk.h(name = xl.e.f55523k)
    @yt.k
    public final String F() {
        return this.f43964d;
    }

    public final boolean G() {
        return this.f43970j;
    }

    @yt.k
    public final a H() {
        a aVar = new a();
        aVar.X(this.f43961a);
        aVar.S(A());
        aVar.O(w());
        aVar.T(this.f43964d);
        aVar.V(this.f43965e != f43948k.g(this.f43961a) ? this.f43965e : -1);
        aVar.r().clear();
        aVar.r().addAll(y());
        aVar.m(z());
        aVar.N(v());
        return aVar;
    }

    @yt.l
    public final a I(@yt.k String link) {
        kotlin.jvm.internal.f0.p(link, "link");
        try {
            return new a().A(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @hk.h(name = "password")
    @yt.k
    public final String K() {
        return this.f43963c;
    }

    @hk.h(name = "pathSegments")
    @yt.k
    public final List<String> L() {
        return this.f43966f;
    }

    @hk.h(name = "pathSize")
    public final int M() {
        return this.f43966f.size();
    }

    @hk.h(name = "port")
    public final int N() {
        return this.f43965e;
    }

    @hk.h(name = "query")
    @yt.l
    public final String O() {
        if (this.f43967g == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        f43948k.q(this.f43967g, sb2);
        return sb2.toString();
    }

    @yt.l
    public final String P(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        List<String> list = this.f43967g;
        if (list == null) {
            return null;
        }
        qk.k kVarB1 = qk.v.B1(qk.v.W1(0, list.size()), 2);
        int iG = kVarB1.g();
        int iJ = kVarB1.j();
        int iL = kVarB1.l();
        if ((iL > 0 && iG <= iJ) || (iL < 0 && iJ <= iG)) {
            while (true) {
                int i10 = iG + iL;
                if (kotlin.jvm.internal.f0.g(name, this.f43967g.get(iG))) {
                    return this.f43967g.get(iG + 1);
                }
                if (iG == iJ) {
                    break;
                }
                iG = i10;
            }
        }
        return null;
    }

    @yt.k
    public final String Q(int i10) {
        List<String> list = this.f43967g;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i10 * 2);
        kotlin.jvm.internal.f0.m(str);
        return str;
    }

    @hk.h(name = "queryParameterNames")
    @yt.k
    public final Set<String> R() {
        if (this.f43967g == null) {
            return d1.k();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        qk.k kVarB1 = qk.v.B1(qk.v.W1(0, this.f43967g.size()), 2);
        int iG = kVarB1.g();
        int iJ = kVarB1.j();
        int iL = kVarB1.l();
        if ((iL > 0 && iG <= iJ) || (iL < 0 && iJ <= iG)) {
            while (true) {
                int i10 = iG + iL;
                String str = this.f43967g.get(iG);
                kotlin.jvm.internal.f0.m(str);
                linkedHashSet.add(str);
                if (iG == iJ) {
                    break;
                }
                iG = i10;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        kotlin.jvm.internal.f0.o(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    @yt.l
    public final String S(int i10) {
        List<String> list = this.f43967g;
        if (list != null) {
            return list.get((i10 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @yt.k
    public final List<String> T(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        if (this.f43967g == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList();
        qk.k kVarB1 = qk.v.B1(qk.v.W1(0, this.f43967g.size()), 2);
        int iG = kVarB1.g();
        int iJ = kVarB1.j();
        int iL = kVarB1.l();
        if ((iL > 0 && iG <= iJ) || (iL < 0 && iJ <= iG)) {
            while (true) {
                int i10 = iG + iL;
                if (kotlin.jvm.internal.f0.g(name, this.f43967g.get(iG))) {
                    arrayList.add(this.f43967g.get(iG + 1));
                }
                if (iG == iJ) {
                    break;
                }
                iG = i10;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        kotlin.jvm.internal.f0.o(listUnmodifiableList, "unmodifiableList(result)");
        return listUnmodifiableList;
    }

    @hk.h(name = "querySize")
    public final int U() {
        List<String> list = this.f43967g;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @yt.k
    public final String V() {
        a aVarI = I("/...");
        kotlin.jvm.internal.f0.m(aVarI);
        return aVarI.Y("").B("").h().toString();
    }

    @yt.l
    public final u W(@yt.k String link) {
        kotlin.jvm.internal.f0.p(link, "link");
        a aVarI = I(link);
        if (aVarI == null) {
            return null;
        }
        return aVarI.h();
    }

    @hk.h(name = "scheme")
    @yt.k
    public final String X() {
        return this.f43961a;
    }

    @yt.l
    public final String Y() {
        if (rl.f.k(this.f43964d)) {
            return null;
        }
        return PublicSuffixDatabase.f43869e.c().c(this.f43964d);
    }

    @hk.h(name = "uri")
    @yt.k
    public final URI Z() {
        String string = H().G().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").q(string, ""));
                kotlin.jvm.internal.f0.o(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    @hk.h(name = "-deprecated_encodedFragment")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "encodedFragment", imports = {}))
    @yt.l
    public final String a() {
        return v();
    }

    @hk.h(name = "url")
    @yt.k
    public final URL a0() {
        try {
            return new URL(this.f43969i);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }

    @hk.h(name = "-deprecated_encodedPassword")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "encodedPassword", imports = {}))
    @yt.k
    public final String b() {
        return w();
    }

    @hk.h(name = "username")
    @yt.k
    public final String b0() {
        return this.f43962b;
    }

    @hk.h(name = "-deprecated_encodedPath")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "encodedPath", imports = {}))
    @yt.k
    public final String c() {
        return x();
    }

    @hk.h(name = "-deprecated_encodedPathSegments")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "encodedPathSegments", imports = {}))
    @yt.k
    public final List<String> d() {
        return y();
    }

    @hk.h(name = "-deprecated_encodedQuery")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "encodedQuery", imports = {}))
    @yt.l
    public final String e() {
        return z();
    }

    public boolean equals(@yt.l Object obj) {
        return (obj instanceof u) && kotlin.jvm.internal.f0.g(((u) obj).f43969i, this.f43969i);
    }

    @hk.h(name = "-deprecated_encodedUsername")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "encodedUsername", imports = {}))
    @yt.k
    public final String f() {
        return A();
    }

    @hk.h(name = "-deprecated_fragment")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "fragment", imports = {}))
    @yt.l
    public final String g() {
        return this.f43968h;
    }

    @hk.h(name = "-deprecated_host")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = xl.e.f55523k, imports = {}))
    @yt.k
    public final String h() {
        return this.f43964d;
    }

    public int hashCode() {
        return this.f43969i.hashCode();
    }

    @hk.h(name = "-deprecated_password")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "password", imports = {}))
    @yt.k
    public final String i() {
        return this.f43963c;
    }

    @hk.h(name = "-deprecated_pathSegments")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "pathSegments", imports = {}))
    @yt.k
    public final List<String> j() {
        return this.f43966f;
    }

    @hk.h(name = "-deprecated_pathSize")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "pathSize", imports = {}))
    public final int k() {
        return M();
    }

    @hk.h(name = "-deprecated_port")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "port", imports = {}))
    public final int l() {
        return this.f43965e;
    }

    @hk.h(name = "-deprecated_query")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "query", imports = {}))
    @yt.l
    public final String m() {
        return O();
    }

    @hk.h(name = "-deprecated_queryParameterNames")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "queryParameterNames", imports = {}))
    @yt.k
    public final Set<String> n() {
        return R();
    }

    @hk.h(name = "-deprecated_querySize")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "querySize", imports = {}))
    public final int o() {
        return U();
    }

    @hk.h(name = "-deprecated_scheme")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "scheme", imports = {}))
    @yt.k
    public final String p() {
        return this.f43961a;
    }

    @hk.h(name = "-deprecated_uri")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @t0(expression = "toUri()", imports = {}))
    @yt.k
    public final URI q() {
        return Z();
    }

    @hk.h(name = "-deprecated_url")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @t0(expression = "toUrl()", imports = {}))
    @yt.k
    public final URL r() {
        return a0();
    }

    @hk.h(name = "-deprecated_username")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "username", imports = {}))
    @yt.k
    public final String s() {
        return this.f43962b;
    }

    @yt.k
    public String toString() {
        return this.f43969i;
    }

    @hk.h(name = "encodedFragment")
    @yt.l
    public final String v() {
        if (this.f43968h == null) {
            return null;
        }
        String strSubstring = this.f43969i.substring(StringsKt__StringsKt.r3(this.f43969i, '#', 0, false, 6, null) + 1);
        kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @hk.h(name = "encodedPassword")
    @yt.k
    public final String w() {
        if (this.f43963c.length() == 0) {
            return "";
        }
        String strSubstring = this.f43969i.substring(StringsKt__StringsKt.r3(this.f43969i, ':', this.f43961a.length() + 3, false, 4, null) + 1, StringsKt__StringsKt.r3(this.f43969i, '@', 0, false, 6, null));
        kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @hk.h(name = "encodedPath")
    @yt.k
    public final String x() {
        int iR3 = StringsKt__StringsKt.r3(this.f43969i, zc.f.f58380j, this.f43961a.length() + 3, false, 4, null);
        String str = this.f43969i;
        String strSubstring = this.f43969i.substring(iR3, rl.f.t(str, "?#", iR3, str.length()));
        kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @hk.h(name = "encodedPathSegments")
    @yt.k
    public final List<String> y() {
        int iR3 = StringsKt__StringsKt.r3(this.f43969i, zc.f.f58380j, this.f43961a.length() + 3, false, 4, null);
        String str = this.f43969i;
        int iT = rl.f.t(str, "?#", iR3, str.length());
        ArrayList arrayList = new ArrayList();
        while (iR3 < iT) {
            int i10 = iR3 + 1;
            int iS = rl.f.s(this.f43969i, zc.f.f58380j, i10, iT);
            String strSubstring = this.f43969i.substring(i10, iS);
            kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iR3 = iS;
        }
        return arrayList;
    }

    @hk.h(name = "encodedQuery")
    @yt.l
    public final String z() {
        if (this.f43967g == null) {
            return null;
        }
        int iR3 = StringsKt__StringsKt.r3(this.f43969i, '?', 0, false, 6, null) + 1;
        String str = this.f43969i;
        String strSubstring = this.f43969i.substring(iR3, rl.f.s(str, '#', iR3, str.length()));
        kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
