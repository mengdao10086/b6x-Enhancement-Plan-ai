package okhttp3;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.t0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001/B;\b\u0000\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0+¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\u000f\u0010\u000bJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\u001d\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\b8GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\u000bR\u0013\u0010%\u001a\u0004\u0018\u00010\f8G¢\u0006\u0006\u001a\u0004\b$\u0010\u000eR\u0013\u0010'\u001a\u0004\u0018\u00010\f8G¢\u0006\u0006\u001a\u0004\b&\u0010\u000eR\u0018\u0010*\u001a\u00020\u0016*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u00060"}, d2 = {"Lokhttp3/Handshake;", "", "Lokhttp3/TlsVersion;", "f", "()Lokhttp3/TlsVersion;", "Lokhttp3/h;", "a", "()Lokhttp3/h;", "", "Ljava/security/cert/Certificate;", "d", "()Ljava/util/List;", "Ljava/security/Principal;", "e", "()Ljava/security/Principal;", "b", "c", "other", "", "equals", "", "hashCode", "", "toString", "Lokhttp3/TlsVersion;", "o", "tlsVersion", "Lokhttp3/h;", "g", "cipherSuite", "Ljava/util/List;", "k", "localCertificates", "Lkotlin/z;", m0.k.f40564b, "peerCertificates", "n", "peerPrincipal", com.flydigi.sdk.bluetooth.l.f16298a, "localPrincipal", xf.j.f55230b, "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/h;Ljava/util/List;Lik/a;)V", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class Handshake {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final Companion f43420e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final TlsVersion f43421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final h f43422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final List<Certificate> f43423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final kotlin.z f43424d;

    @kotlin.d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J4\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f*\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokhttp3/Handshake$Companion;", "", "Ljavax/net/ssl/SSLSession;", "Lokhttp3/Handshake;", "b", "(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;", "sslSession", "a", "Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/h;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "peerCertificates", "localCertificates", "c", "", "d", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.h(name = "-deprecated_get")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @t0(expression = "sslSession.handshake()", imports = {}))
        @yt.k
        public final Handshake a(@yt.k SSLSession sslSession) throws IOException {
            kotlin.jvm.internal.f0.p(sslSession, "sslSession");
            return b(sslSession);
        }

        @hk.h(name = "get")
        @hk.m
        @yt.k
        public final Handshake b(@yt.k SSLSession sSLSession) throws IOException {
            final List<Certificate> listE;
            kotlin.jvm.internal.f0.p(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (kotlin.jvm.internal.f0.g(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : kotlin.jvm.internal.f0.g(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException(kotlin.jvm.internal.f0.C("cipherSuite == ", cipherSuite));
            }
            h hVarB = h.f43622b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (kotlin.jvm.internal.f0.g(HlsPlaylistParser.M, protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionA = TlsVersion.Companion.a(protocol);
            try {
                listE = d(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listE = CollectionsKt__CollectionsKt.E();
            }
            return new Handshake(tlsVersionA, hVarB, d(sSLSession.getLocalCertificates()), new ik.a<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // ik.a
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final List<Certificate> o() {
                    return listE;
                }
            });
        }

        @hk.m
        @yt.k
        public final Handshake c(@yt.k TlsVersion tlsVersion, @yt.k h cipherSuite, @yt.k List<? extends Certificate> peerCertificates, @yt.k List<? extends Certificate> localCertificates) {
            kotlin.jvm.internal.f0.p(tlsVersion, "tlsVersion");
            kotlin.jvm.internal.f0.p(cipherSuite, "cipherSuite");
            kotlin.jvm.internal.f0.p(peerCertificates, "peerCertificates");
            kotlin.jvm.internal.f0.p(localCertificates, "localCertificates");
            final List listH0 = rl.f.h0(peerCertificates);
            return new Handshake(tlsVersion, cipherSuite, rl.f.h0(localCertificates), new ik.a<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$get$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // ik.a
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final List<Certificate> o() {
                    return listH0;
                }
            });
        }

        public final List<Certificate> d(Certificate[] certificateArr) {
            return certificateArr != null ? rl.f.C(Arrays.copyOf(certificateArr, certificateArr.length)) : CollectionsKt__CollectionsKt.E();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(@yt.k TlsVersion tlsVersion, @yt.k h cipherSuite, @yt.k List<? extends Certificate> localCertificates, @yt.k final ik.a<? extends List<? extends Certificate>> peerCertificatesFn) {
        kotlin.jvm.internal.f0.p(tlsVersion, "tlsVersion");
        kotlin.jvm.internal.f0.p(cipherSuite, "cipherSuite");
        kotlin.jvm.internal.f0.p(localCertificates, "localCertificates");
        kotlin.jvm.internal.f0.p(peerCertificatesFn, "peerCertificatesFn");
        this.f43421a = tlsVersion;
        this.f43422b = cipherSuite;
        this.f43423c = localCertificates;
        this.f43424d = kotlin.b0.a(new ik.a<List<? extends Certificate>>() { // from class: okhttp3.Handshake$peerCertificates$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final List<Certificate> o() {
                try {
                    return peerCertificatesFn.o();
                } catch (SSLPeerUnverifiedException unused) {
                    return CollectionsKt__CollectionsKt.E();
                }
            }
        });
    }

    @hk.h(name = "get")
    @hk.m
    @yt.k
    public static final Handshake h(@yt.k SSLSession sSLSession) throws IOException {
        return f43420e.b(sSLSession);
    }

    @hk.m
    @yt.k
    public static final Handshake i(@yt.k TlsVersion tlsVersion, @yt.k h hVar, @yt.k List<? extends Certificate> list, @yt.k List<? extends Certificate> list2) {
        return f43420e.c(tlsVersion, hVar, list, list2);
    }

    @hk.h(name = "-deprecated_cipherSuite")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "cipherSuite", imports = {}))
    @yt.k
    public final h a() {
        return this.f43422b;
    }

    @hk.h(name = "-deprecated_localCertificates")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "localCertificates", imports = {}))
    @yt.k
    public final List<Certificate> b() {
        return this.f43423c;
    }

    @hk.h(name = "-deprecated_localPrincipal")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "localPrincipal", imports = {}))
    @yt.l
    public final Principal c() {
        return l();
    }

    @hk.h(name = "-deprecated_peerCertificates")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "peerCertificates", imports = {}))
    @yt.k
    public final List<Certificate> d() {
        return m();
    }

    @hk.h(name = "-deprecated_peerPrincipal")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "peerPrincipal", imports = {}))
    @yt.l
    public final Principal e() {
        return n();
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.f43421a == this.f43421a && kotlin.jvm.internal.f0.g(handshake.f43422b, this.f43422b) && kotlin.jvm.internal.f0.g(handshake.m(), m()) && kotlin.jvm.internal.f0.g(handshake.f43423c, this.f43423c)) {
                return true;
            }
        }
        return false;
    }

    @hk.h(name = "-deprecated_tlsVersion")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "tlsVersion", imports = {}))
    @yt.k
    public final TlsVersion f() {
        return this.f43421a;
    }

    @hk.h(name = "cipherSuite")
    @yt.k
    public final h g() {
        return this.f43422b;
    }

    public int hashCode() {
        return ((((((527 + this.f43421a.hashCode()) * 31) + this.f43422b.hashCode()) * 31) + m().hashCode()) * 31) + this.f43423c.hashCode();
    }

    public final String j(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        kotlin.jvm.internal.f0.o(type, "type");
        return type;
    }

    @hk.h(name = "localCertificates")
    @yt.k
    public final List<Certificate> k() {
        return this.f43423c;
    }

    @hk.h(name = "localPrincipal")
    @yt.l
    public final Principal l() {
        Object objB2 = CollectionsKt___CollectionsKt.B2(this.f43423c);
        X509Certificate x509Certificate = objB2 instanceof X509Certificate ? (X509Certificate) objB2 : null;
        if (x509Certificate == null) {
            return null;
        }
        return x509Certificate.getSubjectX500Principal();
    }

    @hk.h(name = "peerCertificates")
    @yt.k
    public final List<Certificate> m() {
        return (List) this.f43424d.getValue();
    }

    @hk.h(name = "peerPrincipal")
    @yt.l
    public final Principal n() {
        Object objB2 = CollectionsKt___CollectionsKt.B2(m());
        X509Certificate x509Certificate = objB2 instanceof X509Certificate ? (X509Certificate) objB2 : null;
        if (x509Certificate == null) {
            return null;
        }
        return x509Certificate.getSubjectX500Principal();
    }

    @hk.h(name = "tlsVersion")
    @yt.k
    public final TlsVersion o() {
        return this.f43421a;
    }

    @yt.k
    public String toString() {
        List<Certificate> listM = m();
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(listM, 10));
        Iterator<T> it2 = listM.iterator();
        while (it2.hasNext()) {
            arrayList.add(j((Certificate) it2.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Handshake{tlsVersion=");
        sb2.append(this.f43421a);
        sb2.append(" cipherSuite=");
        sb2.append(this.f43422b);
        sb2.append(" peerCertificates=");
        sb2.append(string);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.f43423c;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList2.add(j((Certificate) it3.next()));
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
