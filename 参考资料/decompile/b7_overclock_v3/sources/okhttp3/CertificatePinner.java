package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.w0;
import kotlin.t0;
import kotlin.text.StringsKt__StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0003\b\u000f\fB#\b\u0000\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u001c\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b$\u0010%J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J+\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\tH\u0000¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u001c8\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lokhttp3/CertificatePinner;", "", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "Lkotlin/z1;", "a", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "c", "(Ljava/lang/String;Lik/a;)V", "", "b", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "Lokhttp3/CertificatePinner$c;", "d", "Lcm/c;", "certificateChainCleaner", xf.j.f55230b, "(Lcm/c;)Lokhttp3/CertificatePinner;", "other", "", "equals", "", "hashCode", "", "Ljava/util/Set;", "f", "()Ljava/util/Set;", "pins", "Lcm/c;", "e", "()Lcm/c;", "<init>", "(Ljava/util/Set;Lcm/c;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class CertificatePinner {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final b f43412c = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final CertificatePinner f43413d = new a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Set<c> f43414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final cm.c f43415b;

    @kotlin.d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001a\u00020\bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/CertificatePinner$a;", "", "", "pattern", "", "pins", "a", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$a;", "Lokhttp3/CertificatePinner;", "b", "", "Lokhttp3/CertificatePinner$c;", "Ljava/util/List;", "c", "()Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final List<c> f43416a = new ArrayList();

        @yt.k
        public final a a(@yt.k String pattern, @yt.k String... pins) {
            kotlin.jvm.internal.f0.p(pattern, "pattern");
            kotlin.jvm.internal.f0.p(pins, "pins");
            int length = pins.length;
            int i10 = 0;
            while (i10 < length) {
                String str = pins[i10];
                i10++;
                c().add(new c(pattern, str));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @yt.k
        public final CertificatePinner b() {
            return new CertificatePinner(CollectionsKt___CollectionsKt.V5(this.f43416a), null, 2, 0 == true ? 1 : 0);
        }

        @yt.k
        public final List<c> c() {
            return this.f43416a;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lokhttp3/CertificatePinner$b;", "", "Ljava/security/cert/X509Certificate;", "Lokio/ByteString;", "b", "c", "Ljava/security/cert/Certificate;", "certificate", "", "a", "Lokhttp3/CertificatePinner;", "DEFAULT", "Lokhttp3/CertificatePinner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final String a(@yt.k Certificate certificate) {
            kotlin.jvm.internal.f0.p(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return kotlin.jvm.internal.f0.C("sha256/", c((X509Certificate) certificate).h());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        @hk.m
        @yt.k
        public final ByteString b(@yt.k X509Certificate x509Certificate) {
            kotlin.jvm.internal.f0.p(x509Certificate, "<this>");
            ByteString.a aVar = ByteString.f44029c;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            kotlin.jvm.internal.f0.o(encoded, "publicKey.encoded");
            return ByteString.a.p(aVar, encoded, 0, 0, 3, null).u0();
        }

        @hk.m
        @yt.k
        public final ByteString c(@yt.k X509Certificate x509Certificate) {
            kotlin.jvm.internal.f0.p(x509Certificate, "<this>");
            ByteString.a aVar = ByteString.f44029c;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            kotlin.jvm.internal.f0.o(encoded, "publicKey.encoded");
            return ByteString.a.p(aVar, encoded, 0, 0, 3, null).v0();
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017¨\u0006\u001c"}, d2 = {"Lokhttp3/CertificatePinner$c;", "", "", "hostname", "", "e", "Ljava/security/cert/X509Certificate;", "certificate", "d", "toString", "other", "equals", "", "hashCode", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "pattern", "b", "hashAlgorithm", "Lokio/ByteString;", "Lokio/ByteString;", "()Lokio/ByteString;", "hash", "pin", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final String f43417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final String f43418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final ByteString f43419c;

        public c(@yt.k String pattern, @yt.k String pin) {
            kotlin.jvm.internal.f0.p(pattern, "pattern");
            kotlin.jvm.internal.f0.p(pin, "pin");
            if (!((kotlin.text.u.v2(pattern, "*.", false, 2, null) && StringsKt__StringsKt.s3(pattern, "*", 1, false, 4, null) == -1) || (kotlin.text.u.v2(pattern, "**.", false, 2, null) && StringsKt__StringsKt.s3(pattern, "*", 2, false, 4, null) == -1) || StringsKt__StringsKt.s3(pattern, "*", 0, false, 6, null) == -1)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Unexpected pattern: ", pattern).toString());
            }
            String strE = rl.a.e(pattern);
            if (strE == null) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Invalid pattern: ", pattern));
            }
            this.f43417a = strE;
            if (kotlin.text.u.v2(pin, "sha1/", false, 2, null)) {
                this.f43418b = "sha1";
                ByteString.a aVar = ByteString.f44029c;
                String strSubstring = pin.substring(5);
                kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                ByteString byteStringH = aVar.h(strSubstring);
                if (byteStringH == null) {
                    throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Invalid pin hash: ", pin));
                }
                this.f43419c = byteStringH;
                return;
            }
            if (!kotlin.text.u.v2(pin, "sha256/", false, 2, null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("pins must start with 'sha256/' or 'sha1/': ", pin));
            }
            this.f43418b = "sha256";
            ByteString.a aVar2 = ByteString.f44029c;
            String strSubstring2 = pin.substring(7);
            kotlin.jvm.internal.f0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
            ByteString byteStringH2 = aVar2.h(strSubstring2);
            if (byteStringH2 == null) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Invalid pin hash: ", pin));
            }
            this.f43419c = byteStringH2;
        }

        @yt.k
        public final ByteString a() {
            return this.f43419c;
        }

        @yt.k
        public final String b() {
            return this.f43418b;
        }

        @yt.k
        public final String c() {
            return this.f43417a;
        }

        public final boolean d(@yt.k X509Certificate certificate) {
            kotlin.jvm.internal.f0.p(certificate, "certificate");
            String str = this.f43418b;
            if (kotlin.jvm.internal.f0.g(str, "sha256")) {
                return kotlin.jvm.internal.f0.g(this.f43419c, CertificatePinner.f43412c.c(certificate));
            }
            if (kotlin.jvm.internal.f0.g(str, "sha1")) {
                return kotlin.jvm.internal.f0.g(this.f43419c, CertificatePinner.f43412c.b(certificate));
            }
            return false;
        }

        public final boolean e(@yt.k String hostname) {
            kotlin.jvm.internal.f0.p(hostname, "hostname");
            if (kotlin.text.u.v2(this.f43417a, "**.", false, 2, null)) {
                int length = this.f43417a.length() - 3;
                int length2 = hostname.length() - length;
                if (!kotlin.text.u.e2(hostname, hostname.length() - length, this.f43417a, 3, length, (16 & 16) != 0 ? false : false)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!kotlin.text.u.v2(this.f43417a, "*.", false, 2, null)) {
                    return kotlin.jvm.internal.f0.g(hostname, this.f43417a);
                }
                int length3 = this.f43417a.length() - 1;
                int length4 = hostname.length() - length3;
                if (!kotlin.text.u.e2(hostname, hostname.length() - length3, this.f43417a, 1, length3, (16 & 16) != 0 ? false : false) || StringsKt__StringsKt.F3(hostname, '.', length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(@yt.l Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.f0.g(this.f43417a, cVar.f43417a) && kotlin.jvm.internal.f0.g(this.f43418b, cVar.f43418b) && kotlin.jvm.internal.f0.g(this.f43419c, cVar.f43419c);
        }

        public int hashCode() {
            return (((this.f43417a.hashCode() * 31) + this.f43418b.hashCode()) * 31) + this.f43419c.hashCode();
        }

        @yt.k
        public String toString() {
            return this.f43418b + zc.f.f58380j + this.f43419c.h();
        }
    }

    public CertificatePinner(@yt.k Set<c> pins, @yt.l cm.c cVar) {
        kotlin.jvm.internal.f0.p(pins, "pins");
        this.f43414a = pins;
        this.f43415b = cVar;
    }

    @hk.m
    @yt.k
    public static final String g(@yt.k Certificate certificate) {
        return f43412c.a(certificate);
    }

    @hk.m
    @yt.k
    public static final ByteString h(@yt.k X509Certificate x509Certificate) {
        return f43412c.b(x509Certificate);
    }

    @hk.m
    @yt.k
    public static final ByteString i(@yt.k X509Certificate x509Certificate) {
        return f43412c.c(x509Certificate);
    }

    public final void a(@yt.k final String hostname, @yt.k final List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        kotlin.jvm.internal.f0.p(hostname, "hostname");
        kotlin.jvm.internal.f0.p(peerCertificates, "peerCertificates");
        c(hostname, new ik.a<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final List<X509Certificate> o() {
                cm.c cVarE = this.this$0.e();
                List<Certificate> listA = cVarE == null ? null : cVarE.a(peerCertificates, hostname);
                if (listA == null) {
                    listA = peerCertificates;
                }
                ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(listA, 10));
                Iterator<T> it2 = listA.iterator();
                while (it2.hasNext()) {
                    arrayList.add((X509Certificate) ((Certificate) it2.next()));
                }
                return arrayList;
            }
        });
    }

    @kotlin.k(message = "replaced with {@link #check(String, List)}.", replaceWith = @t0(expression = "check(hostname, peerCertificates.toList())", imports = {}))
    public final void b(@yt.k String hostname, @yt.k Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        kotlin.jvm.internal.f0.p(hostname, "hostname");
        kotlin.jvm.internal.f0.p(peerCertificates, "peerCertificates");
        a(hostname, ArraysKt___ArraysKt.iz(peerCertificates));
    }

    public final void c(@yt.k String hostname, @yt.k ik.a<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        kotlin.jvm.internal.f0.p(hostname, "hostname");
        kotlin.jvm.internal.f0.p(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<c> listD = d(hostname);
        if (listD.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listO = cleanedPeerCertificatesFn.o();
        for (X509Certificate x509Certificate : listO) {
            ByteString byteStringC = null;
            ByteString byteStringB = null;
            for (c cVar : listD) {
                String strB = cVar.b();
                if (kotlin.jvm.internal.f0.g(strB, "sha256")) {
                    if (byteStringC == null) {
                        byteStringC = f43412c.c(x509Certificate);
                    }
                    if (kotlin.jvm.internal.f0.g(cVar.a(), byteStringC)) {
                        return;
                    }
                } else {
                    if (!kotlin.jvm.internal.f0.g(strB, "sha1")) {
                        throw new AssertionError(kotlin.jvm.internal.f0.C("unsupported hashAlgorithm: ", cVar.b()));
                    }
                    if (byteStringB == null) {
                        byteStringB = f43412c.b(x509Certificate);
                    }
                    if (kotlin.jvm.internal.f0.g(cVar.a(), byteStringB)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listO) {
            sb2.append("\n    ");
            sb2.append(f43412c.a(x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(hostname);
        sb2.append(":");
        for (c cVar2 : listD) {
            sb2.append("\n    ");
            sb2.append(cVar2);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.f0.o(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    @yt.k
    public final List<c> d(@yt.k String hostname) {
        kotlin.jvm.internal.f0.p(hostname, "hostname");
        Set<c> set = this.f43414a;
        List<c> listE = CollectionsKt__CollectionsKt.E();
        for (Object obj : set) {
            if (((c) obj).e(hostname)) {
                if (listE.isEmpty()) {
                    listE = new ArrayList<>();
                }
                w0.g(listE).add(obj);
            }
        }
        return listE;
    }

    @yt.l
    public final cm.c e() {
        return this.f43415b;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (kotlin.jvm.internal.f0.g(certificatePinner.f43414a, this.f43414a) && kotlin.jvm.internal.f0.g(certificatePinner.f43415b, this.f43415b)) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public final Set<c> f() {
        return this.f43414a;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.f43414a.hashCode()) * 41;
        cm.c cVar = this.f43415b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    @yt.k
    public final CertificatePinner j(@yt.k cm.c certificateChainCleaner) {
        kotlin.jvm.internal.f0.p(certificateChainCleaner, "certificateChainCleaner");
        return kotlin.jvm.internal.f0.g(this.f43415b, certificateChainCleaner) ? this : new CertificatePinner(this.f43414a, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, cm.c cVar, int i10, kotlin.jvm.internal.u uVar) {
        this(set, (i10 & 2) != 0 ? null : cVar);
    }
}
