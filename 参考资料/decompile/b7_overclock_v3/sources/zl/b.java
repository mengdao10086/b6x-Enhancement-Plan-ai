package zl;

import am.i;
import am.l;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.flydigi.sdk.bluetooth.l;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;
import xf.j;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@rl.c
@d0(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b%\u0010&J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J-\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0011\u0010\u0015\u001a\r\u0012\t\u0012\u00070\u0013¢\u0006\u0002\b\u00140\u0012H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\fH\u0016¨\u0006)"}, d2 = {"Lzl/b;", "Lzl/h;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", m7.a.f40701a, "", "connectTimeout", "Lkotlin/z1;", "g", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", an.aB, "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "Lhk/n;", "protocols", "f", j.f55230b, "closer", "", "k", "message", "stackTrace", "o", "", l.f16298a, "trustManager", "Lcm/c;", "d", "Lcm/e;", "e", "<init>", "()V", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final a f58609h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f58610i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final List<am.k> f58611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final am.h f58612g;

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lzl/b$a;", "", "Lzl/h;", "a", "", "isSupported", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.l
        public final h a() {
            if (b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return b.f58610i;
        }
    }

    /* JADX INFO: renamed from: zl.b$b, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÂ\u0003¨\u0006\u0016"}, d2 = {"Lzl/b$b;", "Lcm/e;", "Ljava/security/cert/X509Certificate;", "cert", "a", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Ljava/lang/reflect/Method;", "findByIssuerAndSignatureMethod", "d", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "c", "<init>", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0688b implements cm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final X509TrustManager f58613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @k
        public final Method f58614b;

        public C0688b(@k X509TrustManager trustManager, @k Method findByIssuerAndSignatureMethod) {
            f0.p(trustManager, "trustManager");
            f0.p(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.f58613a = trustManager;
            this.f58614b = findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ C0688b e(C0688b c0688b, X509TrustManager x509TrustManager, Method method, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                x509TrustManager = c0688b.f58613a;
            }
            if ((i10 & 2) != 0) {
                method = c0688b.f58614b;
            }
            return c0688b.d(x509TrustManager, method);
        }

        @Override // cm.e
        @yt.l
        public X509Certificate a(@k X509Certificate cert) {
            f0.p(cert, "cert");
            try {
                Object objInvoke = this.f58614b.invoke(this.f58613a, cert);
                if (objInvoke != null) {
                    return ((TrustAnchor) objInvoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e10) {
                throw new AssertionError("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public final X509TrustManager b() {
            return this.f58613a;
        }

        public final Method c() {
            return this.f58614b;
        }

        @k
        public final C0688b d(@k X509TrustManager trustManager, @k Method findByIssuerAndSignatureMethod) {
            f0.p(trustManager, "trustManager");
            f0.p(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            return new C0688b(trustManager, findByIssuerAndSignatureMethod);
        }

        public boolean equals(@yt.l Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0688b)) {
                return false;
            }
            C0688b c0688b = (C0688b) obj;
            return f0.g(this.f58613a, c0688b.f58613a) && f0.g(this.f58614b, c0688b.f58614b);
        }

        public int hashCode() {
            return (this.f58613a.hashCode() * 31) + this.f58614b.hashCode();
        }

        @k
        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f58613a + ", findByIssuerAndSignatureMethod=" + this.f58614b + ')';
        }
    }

    static {
        boolean z10 = false;
        if (h.f58636a.h() && Build.VERSION.SDK_INT < 30) {
            z10 = true;
        }
        f58610i = z10;
    }

    public b() {
        List listN = CollectionsKt__CollectionsKt.N(l.a.b(am.l.f800j, null, 1, null), new am.j(am.f.f782f.d()), new am.j(i.f796a.a()), new am.j(am.g.f790a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (((am.k) obj).a()) {
                arrayList.add(obj);
            }
        }
        this.f58611f = arrayList;
        this.f58612g = am.h.f792d.a();
    }

    @Override // zl.h
    @k
    public cm.c d(@k X509TrustManager trustManager) {
        f0.p(trustManager, "trustManager");
        am.b bVarA = am.b.f774d.a(trustManager);
        return bVarA == null ? super.d(trustManager) : bVarA;
    }

    @Override // zl.h
    @k
    public cm.e e(@k X509TrustManager trustManager) {
        f0.p(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            f0.o(method, "method");
            return new C0688b(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.e(trustManager);
        }
    }

    @Override // zl.h
    public void f(@k SSLSocket sslSocket, @yt.l String str, @k List<Protocol> protocols) {
        Object next;
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
        Iterator<T> it2 = this.f58611f.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (((am.k) next).b(sslSocket)) {
                    break;
                }
            }
        }
        am.k kVar = (am.k) next;
        if (kVar == null) {
            return;
        }
        kVar.f(sslSocket, str, protocols);
    }

    @Override // zl.h
    public void g(@k Socket socket, @k InetSocketAddress address, int i10) throws IOException {
        f0.p(socket, "socket");
        f0.p(address, "address");
        try {
            socket.connect(address, i10);
        } catch (ClassCastException e10) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e10;
            }
            throw new IOException("Exception in connect", e10);
        }
    }

    @Override // zl.h
    @yt.l
    public String j(@k SSLSocket sslSocket) {
        Object next;
        f0.p(sslSocket, "sslSocket");
        Iterator<T> it2 = this.f58611f.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (((am.k) next).b(sslSocket)) {
                break;
            }
        }
        am.k kVar = (am.k) next;
        if (kVar == null) {
            return null;
        }
        return kVar.c(sslSocket);
    }

    @Override // zl.h
    @yt.l
    public Object k(@k String closer) {
        f0.p(closer, "closer");
        return this.f58612g.a(closer);
    }

    @Override // zl.h
    public boolean l(@k String hostname) {
        f0.p(hostname, "hostname");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
        }
        if (i10 >= 23) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }
        return true;
    }

    @Override // zl.h
    public void o(@k String message, @yt.l Object obj) {
        f0.p(message, "message");
        if (this.f58612g.b(obj)) {
            return;
        }
        h.n(this, message, 5, null, 4, null);
    }

    @Override // zl.h
    @yt.l
    public X509TrustManager s(@k SSLSocketFactory sslSocketFactory) {
        Object next;
        f0.p(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it2 = this.f58611f.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (((am.k) next).e(sslSocketFactory)) {
                break;
            }
        }
        am.k kVar = (am.k) next;
        if (kVar == null) {
            return null;
        }
        return kVar.d(sslSocketFactory);
    }
}
