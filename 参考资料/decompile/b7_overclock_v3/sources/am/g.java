package am;

import am.j;
import am.k;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\u0011"}, d2 = {"Lam/g;", "Lam/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "b", "a", "", "c", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/z1;", "f", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class g implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final b f790a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final j.a f791b = new a();

    @d0(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"am/g$a", "Lam/j$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "b", "Lam/k;", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a implements j.a {
        @Override // am.j.a
        public boolean b(@yt.k SSLSocket sslSocket) {
            f0.p(sslSocket, "sslSocket");
            return zl.c.f58615g.b() && (sslSocket instanceof BCSSLSocket);
        }

        @Override // am.j.a
        @yt.k
        public k c(@yt.k SSLSocket sslSocket) {
            f0.p(sslSocket, "sslSocket");
            return new g();
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lam/g$b;", "", "Lam/j$a;", "factory", "Lam/j$a;", "a", "()Lam/j$a;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @yt.k
        public final j.a a() {
            return g.f791b;
        }
    }

    @Override // am.k
    public boolean a() {
        return zl.c.f58615g.b();
    }

    @Override // am.k
    public boolean b(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        return sslSocket instanceof BCSSLSocket;
    }

    @Override // am.k
    @yt.l
    public String c(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : f0.g(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
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
        if (b(sslSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            Object[] array = zl.h.f58636a.b(protocols).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}
