package am;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u0014"}, d2 = {"Lam/k;", "", "", "a", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "d", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "b", "e", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/z1;", "f", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface k {

    @d0(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static boolean a(@yt.k k kVar, @yt.k SSLSocketFactory sslSocketFactory) {
            f0.p(kVar, "this");
            f0.p(sslSocketFactory, "sslSocketFactory");
            return false;
        }

        @yt.l
        public static X509TrustManager b(@yt.k k kVar, @yt.k SSLSocketFactory sslSocketFactory) {
            f0.p(kVar, "this");
            f0.p(sslSocketFactory, "sslSocketFactory");
            return null;
        }
    }

    boolean a();

    boolean b(@yt.k SSLSocket sSLSocket);

    @yt.l
    String c(@yt.k SSLSocket sSLSocket);

    @yt.l
    X509TrustManager d(@yt.k SSLSocketFactory sSLSocketFactory);

    boolean e(@yt.k SSLSocketFactory sSLSocketFactory);

    void f(@yt.k SSLSocket sSLSocket, @yt.l String str, @yt.k List<? extends Protocol> list);
}
