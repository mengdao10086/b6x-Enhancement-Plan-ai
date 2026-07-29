package am;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0014"}, d2 = {"Lam/b;", "Lcm/c;", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "a", "", "other", "", "equals", "", "hashCode", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Landroid/net/http/X509TrustManagerExtensions;", "x509TrustManagerExtensions", "<init>", "(Ljavax/net/ssl/X509TrustManager;Landroid/net/http/X509TrustManagerExtensions;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b extends cm.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f774d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final X509TrustManager f775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final X509TrustManagerExtensions f776c;

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lam/b$a;", "", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lam/b;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @rl.c
        @yt.l
        public final b a(@yt.k X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            f0.p(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new b(trustManager, x509TrustManagerExtensions);
            }
            return null;
        }
    }

    public b(@yt.k X509TrustManager trustManager, @yt.k X509TrustManagerExtensions x509TrustManagerExtensions) {
        f0.p(trustManager, "trustManager");
        f0.p(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f775b = trustManager;
        this.f776c = x509TrustManagerExtensions;
    }

    @Override // cm.c
    @rl.c
    @yt.k
    public List<Certificate> a(@yt.k List<? extends Certificate> chain, @yt.k String hostname) throws SSLPeerUnverifiedException {
        f0.p(chain, "chain");
        f0.p(hostname, "hostname");
        Object[] array = chain.toArray(new X509Certificate[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        try {
            List<X509Certificate> listCheckServerTrusted = this.f776c.checkServerTrusted((X509Certificate[]) array, "RSA", hostname);
            f0.o(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e10) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
            sSLPeerUnverifiedException.initCause(e10);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(@yt.l Object obj) {
        return (obj instanceof b) && ((b) obj).f775b == this.f775b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f775b);
    }
}
