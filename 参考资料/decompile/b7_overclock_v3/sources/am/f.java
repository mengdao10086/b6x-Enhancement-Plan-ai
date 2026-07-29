package am;

import am.j;
import am.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.u;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0013"}, d2 = {"Lam/f;", "Lam/k;", "", "a", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "b", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/z1;", "f", "c", "Ljava/lang/Class;", "sslSocketClass", "<init>", "(Ljava/lang/Class;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public class f implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final a f782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final j.a f783g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Class<? super SSLSocket> f784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Method f785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f788e;

    @d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0006H\u0002R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lam/f$a;", "", "", "packageName", "Lam/j$a;", "c", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "actualSSLSocketClass", "Lam/f;", "b", "playProviderFactory", "Lam/j$a;", "d", "()Lam/j$a;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: am.f$a$a, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"am/f$a$a", "Lam/j$a;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "b", "Lam/k;", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0016a implements j.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f789a;

            public C0016a(String str) {
                this.f789a = str;
            }

            @Override // am.j.a
            public boolean b(@yt.k SSLSocket sslSocket) {
                f0.p(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                f0.o(name, "sslSocket.javaClass.name");
                return u.v2(name, f0.C(this.f789a, j3.b.f36044h), false, 2, null);
            }

            @Override // am.j.a
            @yt.k
            public k c(@yt.k SSLSocket sslSocket) {
                f0.p(sslSocket, "sslSocket");
                return f.f782f.b(sslSocket.getClass());
            }
        }

        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final f b(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> superclass = cls;
            while (superclass != null && !f0.g(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError(f0.C("No OpenSSLSocketImpl superclass of socket of type ", cls));
                }
            }
            f0.m(superclass);
            return new f(superclass);
        }

        @yt.k
        public final j.a c(@yt.k String packageName) {
            f0.p(packageName, "packageName");
            return new C0016a(packageName);
        }

        @yt.k
        public final j.a d() {
            return f.f783g;
        }
    }

    static {
        a aVar = new a(null);
        f782f = aVar;
        f783g = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public f(@yt.k Class<? super SSLSocket> sslSocketClass) throws NoSuchMethodException {
        f0.p(sslSocketClass, "sslSocketClass");
        this.f784a = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        f0.o(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f785b = declaredMethod;
        this.f786c = sslSocketClass.getMethod("setHostname", String.class);
        this.f787d = sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f788e = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // am.k
    public boolean a() {
        return zl.b.f58609h.b();
    }

    @Override // am.k
    public boolean b(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        return this.f784a.isInstance(sslSocket);
    }

    @Override // am.k
    @yt.l
    public String c(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        if (!b(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f787d.invoke(sslSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            return new String(bArr, kotlin.text.d.f38161b);
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if ((cause instanceof NullPointerException) && f0.g(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e11);
        }
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
            try {
                this.f785b.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f786c.invoke(sslSocket, str);
                }
                this.f788e.invoke(sslSocket, zl.h.f58636a.c(protocols));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
