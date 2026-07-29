package am;

import am.k;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u0014"}, d2 = {"Lam/j;", "Lam/k;", "", "a", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "b", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/z1;", "f", "c", "g", "Lam/j$a;", "socketAdapterFactory", "<init>", "(Lam/j$a;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a f798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public k f799b;

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lam/j$a;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "b", "Lam/k;", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        boolean b(@yt.k SSLSocket sSLSocket);

        @yt.k
        k c(@yt.k SSLSocket sSLSocket);
    }

    public j(@yt.k a socketAdapterFactory) {
        f0.p(socketAdapterFactory, "socketAdapterFactory");
        this.f798a = socketAdapterFactory;
    }

    @Override // am.k
    public boolean a() {
        return true;
    }

    @Override // am.k
    public boolean b(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        return this.f798a.b(sslSocket);
    }

    @Override // am.k
    @yt.l
    public String c(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        k kVarG = g(sslSocket);
        if (kVarG == null) {
            return null;
        }
        return kVarG.c(sslSocket);
    }

    @Override // am.k
    @yt.l
    public X509TrustManager d(@yt.k SSLSocketFactory sSLSocketFactory) {
        return k.a.b(this, sSLSocketFactory);
    }

    @Override // am.k
    public boolean e(@yt.k SSLSocketFactory sSLSocketFactory) {
        return k.a.a(this, sSLSocketFactory);
    }

    @Override // am.k
    public void f(@yt.k SSLSocket sslSocket, @yt.l String str, @yt.k List<? extends Protocol> protocols) {
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
        k kVarG = g(sslSocket);
        if (kVarG == null) {
            return;
        }
        kVarG.f(sslSocket, str, protocols);
    }

    public final synchronized k g(SSLSocket sSLSocket) {
        if (this.f799b == null && this.f798a.b(sSLSocket)) {
            this.f799b = this.f798a.c(sSLSocket);
        }
        return this.f799b;
    }
}
