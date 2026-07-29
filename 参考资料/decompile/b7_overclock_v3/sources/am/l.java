package am;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB3\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\b\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0010"}, d2 = {"Lam/l;", "Lam/f;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "", "e", "Ljavax/net/ssl/X509TrustManager;", "d", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketClass", "sslSocketFactoryClass", "paramClass", "<init>", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class l extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final a f800j = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final Class<? super SSLSocketFactory> f801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public final Class<?> f802i;

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lam/l$a;", "", "", "packageName", "Lam/k;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ k b(a aVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        @yt.l
        public final k a(@yt.k String packageName) {
            f0.p(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(f0.C(packageName, ".OpenSSLSocketImpl"));
                Class<?> cls2 = Class.forName(f0.C(packageName, ".OpenSSLSocketFactoryImpl"));
                Class<?> paramsClass = Class.forName(f0.C(packageName, ".SSLParametersImpl"));
                f0.o(paramsClass, "paramsClass");
                return new l(cls, cls2, paramsClass);
            } catch (Exception e10) {
                zl.h.f58636a.g().m("unable to load android socket classes", 5, e10);
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@yt.k Class<? super SSLSocket> sslSocketClass, @yt.k Class<? super SSLSocketFactory> sslSocketFactoryClass, @yt.k Class<?> paramClass) {
        super(sslSocketClass);
        f0.p(sslSocketClass, "sslSocketClass");
        f0.p(sslSocketFactoryClass, "sslSocketFactoryClass");
        f0.p(paramClass, "paramClass");
        this.f801h = sslSocketFactoryClass;
        this.f802i = paramClass;
    }

    @Override // am.f, am.k
    @yt.l
    public X509TrustManager d(@yt.k SSLSocketFactory sslSocketFactory) throws IllegalAccessException {
        f0.p(sslSocketFactory, "sslSocketFactory");
        Object objU = rl.f.U(sslSocketFactory, this.f802i, "sslParameters");
        f0.m(objU);
        X509TrustManager x509TrustManager = (X509TrustManager) rl.f.U(objU, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager == null ? (X509TrustManager) rl.f.U(objU, X509TrustManager.class, "trustManager") : x509TrustManager;
    }

    @Override // am.f, am.k
    public boolean e(@yt.k SSLSocketFactory sslSocketFactory) {
        f0.p(sslSocketFactory, "sslSocketFactory");
        return this.f801h.isInstance(sslSocketFactory);
    }
}
