package am;

import am.k;
import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes5.dex */
@rl.c
@SuppressLint({"NewApi"})
@d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0017¨\u0006\u0011"}, d2 = {"Lam/a;", "Lam/k;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "b", "a", "", "c", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/z1;", "f", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final C0015a f773a = new C0015a(null);

    /* JADX INFO: renamed from: am.a$a, reason: collision with other inner class name */
    @rl.c
    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lam/a$a;", "", "Lam/k;", "a", "", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0015a {
        public C0015a() {
        }

        public /* synthetic */ C0015a(u uVar) {
            this();
        }

        @yt.l
        public final k a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return zl.h.f58636a.h() && Build.VERSION.SDK_INT >= 29;
        }
    }

    @Override // am.k
    public boolean a() {
        return f773a.b();
    }

    @Override // am.k
    public boolean b(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sslSocket);
    }

    @Override // am.k
    @yt.l
    @SuppressLint({"NewApi"})
    public String c(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        String applicationProtocol = sslSocket.getApplicationProtocol();
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
    @SuppressLint({"NewApi"})
    public void f(@yt.k SSLSocket sslSocket, @yt.l String str, @yt.k List<? extends Protocol> protocols) throws IOException {
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sslSocket, true);
            SSLParameters sSLParameters = sslSocket.getSSLParameters();
            Object[] array = zl.h.f58636a.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            sSLParameters.setApplicationProtocols((String[]) array);
            sslSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }
}
