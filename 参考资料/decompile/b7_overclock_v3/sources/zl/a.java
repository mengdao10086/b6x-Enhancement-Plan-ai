package zl;

import am.i;
import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.flydigi.sdk.bluetooth.l;
import com.umeng.analytics.pro.an;
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
@d0(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0017J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¨\u0006\u0018"}, d2 = {"Lzl/a;", "Lzl/h;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", an.aB, "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/z1;", "f", j.f55230b, "", l.f16298a, "trustManager", "Lcm/c;", "d", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public static final C0687a f58606g = new C0687a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f58607h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final List<am.k> f58608f;

    /* JADX INFO: renamed from: zl.a$a, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lzl/a$a;", "", "Lzl/h;", "a", "", "isSupported", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0687a {
        public C0687a() {
        }

        public /* synthetic */ C0687a(u uVar) {
            this();
        }

        @yt.l
        public final h a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return a.f58607h;
        }
    }

    static {
        f58607h = h.f58636a.h() && Build.VERSION.SDK_INT >= 29;
    }

    public a() {
        List listN = CollectionsKt__CollectionsKt.N(am.a.f773a.a(), new am.j(am.f.f782f.d()), new am.j(i.f796a.a()), new am.j(am.g.f790a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (((am.k) obj).a()) {
                arrayList.add(obj);
            }
        }
        this.f58608f = arrayList;
    }

    @Override // zl.h
    @k
    public cm.c d(@k X509TrustManager trustManager) {
        f0.p(trustManager, "trustManager");
        am.b bVarA = am.b.f774d.a(trustManager);
        return bVarA == null ? super.d(trustManager) : bVarA;
    }

    @Override // zl.h
    public void f(@k SSLSocket sslSocket, @yt.l String str, @k List<? extends Protocol> protocols) {
        Object next;
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
        Iterator<T> it2 = this.f58608f.iterator();
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
    @yt.l
    public String j(@k SSLSocket sslSocket) {
        Object next;
        f0.p(sslSocket, "sslSocket");
        Iterator<T> it2 = this.f58608f.iterator();
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
    @SuppressLint({"NewApi"})
    public boolean l(@k String hostname) {
        f0.p(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override // zl.h
    @yt.l
    public X509TrustManager s(@k SSLSocketFactory sslSocketFactory) {
        Object next;
        f0.p(sslSocketFactory, "sslSocketFactory");
        Iterator<T> it2 = this.f58608f.iterator();
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
