package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.DeprecationLevel;
import kotlin.t0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bJ\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0015\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u001b\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\n¨\u0006\u001e"}, d2 = {"Lokhttp3/f0;", "", "Lokhttp3/a;", "a", "()Lokhttp3/a;", "Ljava/net/Proxy;", "b", "()Ljava/net/Proxy;", "Ljava/net/InetSocketAddress;", "c", "()Ljava/net/InetSocketAddress;", "", "f", "other", "equals", "", "hashCode", "", "toString", "Lokhttp3/a;", "d", m7.a.f40701a, "Ljava/net/Proxy;", "e", IOptionConstant.proxy, "Ljava/net/InetSocketAddress;", "g", "socketAddress", "<init>", "(Lokhttp3/a;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a f43615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Proxy f43616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final InetSocketAddress f43617c;

    public f0(@yt.k a address, @yt.k Proxy proxy, @yt.k InetSocketAddress socketAddress) {
        kotlin.jvm.internal.f0.p(address, "address");
        kotlin.jvm.internal.f0.p(proxy, "proxy");
        kotlin.jvm.internal.f0.p(socketAddress, "socketAddress");
        this.f43615a = address;
        this.f43616b = proxy;
        this.f43617c = socketAddress;
    }

    @hk.h(name = "-deprecated_address")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = m7.a.f40701a, imports = {}))
    @yt.k
    public final a a() {
        return this.f43615a;
    }

    @hk.h(name = "-deprecated_proxy")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = IOptionConstant.proxy, imports = {}))
    @yt.k
    public final Proxy b() {
        return this.f43616b;
    }

    @hk.h(name = "-deprecated_socketAddress")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "socketAddress", imports = {}))
    @yt.k
    public final InetSocketAddress c() {
        return this.f43617c;
    }

    @hk.h(name = m7.a.f40701a)
    @yt.k
    public final a d() {
        return this.f43615a;
    }

    @hk.h(name = IOptionConstant.proxy)
    @yt.k
    public final Proxy e() {
        return this.f43616b;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            if (kotlin.jvm.internal.f0.g(f0Var.f43615a, this.f43615a) && kotlin.jvm.internal.f0.g(f0Var.f43616b, this.f43616b) && kotlin.jvm.internal.f0.g(f0Var.f43617c, this.f43617c)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f43615a.v() != null && this.f43616b.type() == Proxy.Type.HTTP;
    }

    @hk.h(name = "socketAddress")
    @yt.k
    public final InetSocketAddress g() {
        return this.f43617c;
    }

    public int hashCode() {
        return ((((527 + this.f43615a.hashCode()) * 31) + this.f43616b.hashCode()) * 31) + this.f43617c.hashCode();
    }

    @yt.k
    public String toString() {
        return "Route{" + this.f43617c + '}';
    }
}
