package sl;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.b;
import okhttp3.b0;
import okhttp3.g;
import okhttp3.o;
import okhttp3.q;
import okhttp3.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u000e\u001a\u00020\r*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\u0012"}, d2 = {"Lsl/a;", "Lokhttp3/b;", "Lokhttp3/f0;", "route", "Lokhttp3/d0;", "response", "Lokhttp3/b0;", "a", "Ljava/net/Proxy;", "Lokhttp3/u;", "url", "Lokhttp3/q;", "dns", "Ljava/net/InetAddress;", "b", "defaultDns", "<init>", "(Lokhttp3/q;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final q f49853d;

    /* JADX INFO: renamed from: sl.a$a, reason: collision with other inner class name */
    @d0(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class C0573a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49854a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            f49854a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(@k q defaultDns) {
        f0.p(defaultDns, "defaultDns");
        this.f49853d = defaultDns;
    }

    @Override // okhttp3.b
    @l
    public b0 a(@l okhttp3.f0 f0Var, @k okhttp3.d0 response) throws IOException {
        okhttp3.a aVarD;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        f0.p(response, "response");
        List<g> listT = response.T();
        b0 b0VarV1 = response.V1();
        u uVarQ = b0VarV1.q();
        boolean z10 = response.W() == 407;
        Proxy proxy = f0Var == null ? null : f0Var.e();
        if (proxy == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (g gVar : listT) {
            if (kotlin.text.u.L1("Basic", gVar.h(), true)) {
                q qVarN = (f0Var == null || (aVarD = f0Var.d()) == null) ? null : aVarD.n();
                if (qVarN == null) {
                    qVarN = this.f49853d;
                }
                if (z10) {
                    SocketAddress socketAddressAddress = proxy.address();
                    Objects.requireNonNull(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    f0.o(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, uVarQ, qVarN), inetSocketAddress.getPort(), uVarQ.X(), gVar.g(), gVar.h(), uVarQ.a0(), Authenticator.RequestorType.PROXY);
                } else {
                    String strF = uVarQ.F();
                    f0.o(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strF, b(proxy, uVarQ, qVarN), uVarQ.N(), uVarQ.X(), gVar.g(), gVar.h(), uVarQ.a0(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z10 ? HttpHeaders.PROXY_AUTHORIZATION : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    f0.o(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    f0.o(password, "auth.password");
                    return b0VarV1.n().n(str, o.b(userName, new String(password), gVar.f())).b();
                }
            }
        }
        return null;
    }

    public final InetAddress b(Proxy proxy, u uVar, q qVar) throws IOException {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : C0573a.f49854a[type.ordinal()]) == 1) {
            return (InetAddress) CollectionsKt___CollectionsKt.w2(qVar.a(uVar.F()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        Objects.requireNonNull(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        f0.o(address, "address() as InetSocketAddress).address");
        return address;
    }

    public /* synthetic */ a(q qVar, int i10, kotlin.jvm.internal.u uVar) {
        this((i10 & 1) != 0 ? q.f43936b : qVar);
    }
}
