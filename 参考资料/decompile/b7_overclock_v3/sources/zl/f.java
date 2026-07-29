package zl;

import com.umeng.analytics.pro.an;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.t;
import okhttp3.Protocol;
import xf.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0011\u0010\t\u001a\r\u0012\t\u0012\u00070\u0007¢\u0006\u0002\b\b0\u0006H\u0017J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0014"}, d2 = {"Lzl/f;", "Lzl/h;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "Lhk/n;", "protocols", "Lkotlin/z1;", "f", j.f55230b, "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", an.aB, "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public class f extends h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public static final a f58631f = new a(0 == true ? 1 : 0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f58632g;

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lzl/f$a;", "", "Lzl/f;", "a", "", "isAvailable", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @l
        public final f a() {
            if (b()) {
                return new f();
            }
            return null;
        }

        public final boolean b() {
            return f.f58632g;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String property = System.getProperty("java.specification.version");
        Integer numY0 = property != null ? t.Y0(property) : null;
        boolean z10 = true;
        if (numY0 == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
                z10 = false;
            }
        } else if (numY0.intValue() < 9) {
            z10 = false;
        }
        f58632g = z10;
    }

    @Override // zl.h
    @rl.c
    public void f(@k SSLSocket sslSocket, @l String str, @k List<Protocol> protocols) {
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
        SSLParameters sSLParameters = sslSocket.getSSLParameters();
        Object[] array = h.f58636a.b(protocols).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        sSLParameters.setApplicationProtocols((String[]) array);
        sslSocket.setSSLParameters(sSLParameters);
    }

    @Override // zl.h
    @rl.c
    @l
    public String j(@k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        try {
            String applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : f0.g(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // zl.h
    @l
    public X509TrustManager s(@k SSLSocketFactory sslSocketFactory) {
        f0.p(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
