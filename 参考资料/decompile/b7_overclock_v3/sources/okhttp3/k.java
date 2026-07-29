package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.t0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\f\u0018\u0000 *2\u00020\u0001:\u0002\u0004\tB9\b\u0000\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001f\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001f¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0002R\u0017\u0010\u001c\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0017\u0010\u001e\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001d\u0010\nR\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010 R\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b$\u0010\u0005R\u0019\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b&\u0010\u0005¨\u0006+"}, d2 = {"Lokhttp3/k;", "", "", "Lokhttp3/h;", "a", "()Ljava/util/List;", "Lokhttp3/TlsVersion;", "c", "", "b", "()Z", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "Lkotlin/z1;", "f", "(Ljavax/net/ssl/SSLSocket;Z)V", "socket", "h", "other", "equals", "", "hashCode", "", "toString", xf.j.f55230b, "Z", "i", "isTls", "k", "supportsTlsExtensions", "", "[Ljava/lang/String;", "cipherSuitesAsString", "d", "tlsVersionsAsString", "g", "cipherSuites", com.flydigi.sdk.bluetooth.l.f16298a, "tlsVersions", "<init>", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "e", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final b f43880e = new b(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final h[] f43881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final h[] f43882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final k f43883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final k f43884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final k f43885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final k f43886k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f43887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f43888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final String[] f43889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final String[] f43890d;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lokhttp3/k$b;", "", "", "Lokhttp3/h;", "APPROVED_CIPHER_SUITES", "[Lokhttp3/h;", "Lokhttp3/k;", "CLEARTEXT", "Lokhttp3/k;", "COMPATIBLE_TLS", "MODERN_TLS", "RESTRICTED_CIPHER_SUITES", "RESTRICTED_TLS", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    static {
        h hVar = h.f43663o1;
        h hVar2 = h.f43666p1;
        h hVar3 = h.f43669q1;
        h hVar4 = h.f43621a1;
        h hVar5 = h.f43633e1;
        h hVar6 = h.f43624b1;
        h hVar7 = h.f43636f1;
        h hVar8 = h.f43654l1;
        h hVar9 = h.f43651k1;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9};
        f43881f = hVarArr;
        h[] hVarArr2 = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, h.L0, h.M0, h.f43647j0, h.f43650k0, h.H, h.L, h.f43652l};
        f43882g = hVarArr2;
        a aVarE = new a(true).e((h[]) Arrays.copyOf(hVarArr, hVarArr.length));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f43883h = aVarE.p(tlsVersion, tlsVersion2).n(true).c();
        f43884i = new a(true).e((h[]) Arrays.copyOf(hVarArr2, hVarArr2.length)).p(tlsVersion, tlsVersion2).n(true).c();
        f43885j = new a(true).e((h[]) Arrays.copyOf(hVarArr2, hVarArr2.length)).p(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).n(true).c();
        f43886k = new a(false).c();
    }

    public k(boolean z10, boolean z11, @yt.l String[] strArr, @yt.l String[] strArr2) {
        this.f43887a = z10;
        this.f43888b = z11;
        this.f43889c = strArr;
        this.f43890d = strArr2;
    }

    @hk.h(name = "-deprecated_cipherSuites")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "cipherSuites", imports = {}))
    @yt.l
    public final List<h> a() {
        return g();
    }

    @hk.h(name = "-deprecated_supportsTlsExtensions")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "supportsTlsExtensions", imports = {}))
    public final boolean b() {
        return this.f43888b;
    }

    @hk.h(name = "-deprecated_tlsVersions")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "tlsVersions", imports = {}))
    @yt.l
    public final List<TlsVersion> c() {
        return l();
    }

    public boolean equals(@yt.l Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z10 = this.f43887a;
        k kVar = (k) obj;
        if (z10 != kVar.f43887a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f43889c, kVar.f43889c) && Arrays.equals(this.f43890d, kVar.f43890d) && this.f43888b == kVar.f43888b);
    }

    public final void f(@yt.k SSLSocket sslSocket, boolean z10) {
        kotlin.jvm.internal.f0.p(sslSocket, "sslSocket");
        k kVarJ = j(sslSocket, z10);
        if (kVarJ.l() != null) {
            sslSocket.setEnabledProtocols(kVarJ.f43890d);
        }
        if (kVarJ.g() != null) {
            sslSocket.setEnabledCipherSuites(kVarJ.f43889c);
        }
    }

    @hk.h(name = "cipherSuites")
    @yt.l
    public final List<h> g() {
        String[] strArr = this.f43889c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(h.f43622b.b(str));
        }
        return CollectionsKt___CollectionsKt.Q5(arrayList);
    }

    public final boolean h(@yt.k SSLSocket socket) {
        kotlin.jvm.internal.f0.p(socket, "socket");
        if (!this.f43887a) {
            return false;
        }
        String[] strArr = this.f43890d;
        if (strArr != null && !rl.f.z(strArr, socket.getEnabledProtocols(), uj.g.q())) {
            return false;
        }
        String[] strArr2 = this.f43889c;
        return strArr2 == null || rl.f.z(strArr2, socket.getEnabledCipherSuites(), h.f43622b.c());
    }

    public int hashCode() {
        if (!this.f43887a) {
            return 17;
        }
        String[] strArr = this.f43889c;
        int iHashCode = (527 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String[] strArr2 = this.f43890d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f43888b ? 1 : 0);
    }

    @hk.h(name = "isTls")
    public final boolean i() {
        return this.f43887a;
    }

    public final k j(SSLSocket sSLSocket, boolean z10) {
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        if (this.f43889c != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            kotlin.jvm.internal.f0.o(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = rl.f.L(enabledCipherSuites, this.f43889c, h.f43622b.c());
        } else {
            cipherSuitesIntersection = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f43890d != null) {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            kotlin.jvm.internal.f0.o(enabledProtocols, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = rl.f.L(enabledProtocols, this.f43890d, uj.g.q());
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        kotlin.jvm.internal.f0.o(supportedCipherSuites, "supportedCipherSuites");
        int iD = rl.f.D(supportedCipherSuites, "TLS_FALLBACK_SCSV", h.f43622b.c());
        if (z10 && iD != -1) {
            kotlin.jvm.internal.f0.o(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iD];
            kotlin.jvm.internal.f0.o(str, "supportedCipherSuites[indexOfFallbackScsv]");
            cipherSuitesIntersection = rl.f.r(cipherSuitesIntersection, str);
        }
        a aVar = new a(this);
        kotlin.jvm.internal.f0.o(cipherSuitesIntersection, "cipherSuitesIntersection");
        a aVarD = aVar.d((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        kotlin.jvm.internal.f0.o(tlsVersionsIntersection, "tlsVersionsIntersection");
        return aVarD.o((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length)).c();
    }

    @hk.h(name = "supportsTlsExtensions")
    public final boolean k() {
        return this.f43888b;
    }

    @hk.h(name = "tlsVersions")
    @yt.l
    public final List<TlsVersion> l() {
        String[] strArr = this.f43890d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(TlsVersion.Companion.a(str));
        }
        return CollectionsKt___CollectionsKt.Q5(arrayList);
    }

    @yt.k
    public String toString() {
        if (!this.f43887a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + ((Object) Objects.toString(g(), "[all enabled]")) + ", tlsVersions=" + ((Object) Objects.toString(l(), "[all enabled]")) + ", supportsTlsExtensions=" + this.f43888b + ')';
    }

    @kotlin.d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b%\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0014¢\u0006\u0004\b%\u0010'J\u0006\u0010\u0002\u001a\u00020\u0000J!\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0003\"\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0000J!\u0010\u000e\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0003\"\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0003\"\u00020\b¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0006\u0010\u0015\u001a\u00020\u0014R\"\u0010\u001b\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001a¨\u0006("}, d2 = {"Lokhttp3/k$a;", "", "a", "", "Lokhttp3/h;", "cipherSuites", "e", "([Lokhttp3/h;)Lokhttp3/k$a;", "", "d", "([Ljava/lang/String;)Lokhttp3/k$a;", "b", "Lokhttp3/TlsVersion;", "tlsVersions", "p", "([Lokhttp3/TlsVersion;)Lokhttp3/k$a;", "o", "", "supportsTlsExtensions", "n", "Lokhttp3/k;", "c", "Z", "h", "()Z", com.flydigi.sdk.bluetooth.l.f16298a, "(Z)V", "tls", "[Ljava/lang/String;", "f", "()[Ljava/lang/String;", xf.j.f55230b, "([Ljava/lang/String;)V", "i", m0.k.f40564b, "g", "k", "<init>", "connectionSpec", "(Lokhttp3/k;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f43891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public String[] f43892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public String[] f43893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f43894d;

        public a(boolean z10) {
            this.f43891a = z10;
        }

        @yt.k
        public final a a() {
            if (!h()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            j(null);
            return this;
        }

        @yt.k
        public final a b() {
            if (!h()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            m(null);
            return this;
        }

        @yt.k
        public final k c() {
            return new k(this.f43891a, this.f43894d, this.f43892b, this.f43893c);
        }

        @yt.k
        public final a d(@yt.k String... cipherSuites) {
            kotlin.jvm.internal.f0.p(cipherSuites, "cipherSuites");
            if (!h()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(cipherSuites.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            j((String[]) cipherSuites.clone());
            return this;
        }

        @yt.k
        public final a e(@yt.k h... cipherSuites) {
            kotlin.jvm.internal.f0.p(cipherSuites, "cipherSuites");
            if (!h()) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (h hVar : cipherSuites) {
                arrayList.add(hVar.e());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            return d((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @yt.l
        public final String[] f() {
            return this.f43892b;
        }

        public final boolean g() {
            return this.f43894d;
        }

        public final boolean h() {
            return this.f43891a;
        }

        @yt.l
        public final String[] i() {
            return this.f43893c;
        }

        public final void j(@yt.l String[] strArr) {
            this.f43892b = strArr;
        }

        public final void k(boolean z10) {
            this.f43894d = z10;
        }

        public final void l(boolean z10) {
            this.f43891a = z10;
        }

        public final void m(@yt.l String[] strArr) {
            this.f43893c = strArr;
        }

        @kotlin.k(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        @yt.k
        public final a n(boolean z10) {
            if (!h()) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            k(z10);
            return this;
        }

        @yt.k
        public final a o(@yt.k String... tlsVersions) {
            kotlin.jvm.internal.f0.p(tlsVersions, "tlsVersions");
            if (!h()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(tlsVersions.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            m((String[]) tlsVersions.clone());
            return this;
        }

        @yt.k
        public final a p(@yt.k TlsVersion... tlsVersions) {
            kotlin.jvm.internal.f0.p(tlsVersions, "tlsVersions");
            if (!h()) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(tlsVersions.length);
            for (TlsVersion tlsVersion : tlsVersions) {
                arrayList.add(tlsVersion.javaName());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            return o((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public a(@yt.k k connectionSpec) {
            kotlin.jvm.internal.f0.p(connectionSpec, "connectionSpec");
            this.f43891a = connectionSpec.i();
            this.f43892b = connectionSpec.f43889c;
            this.f43893c = connectionSpec.f43890d;
            this.f43894d = connectionSpec.k();
        }
    }
}
