package cm;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import zl.h;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcm/c;", "", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f10963a = new a(null);

    @d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J!\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcm/c$a;", "", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lcm/c;", "a", "", "Ljava/security/cert/X509Certificate;", "caCerts", "b", "([Ljava/security/cert/X509Certificate;)Lcm/c;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final c a(@k X509TrustManager trustManager) {
            f0.p(trustManager, "trustManager");
            return h.f58636a.g().d(trustManager);
        }

        @k
        public final c b(@k X509Certificate... caCerts) {
            f0.p(caCerts, "caCerts");
            return new cm.a(new b((X509Certificate[]) Arrays.copyOf(caCerts, caCerts.length)));
        }
    }

    @k
    public abstract List<Certificate> a(@k List<? extends Certificate> list, @k String str) throws SSLPeerUnverifiedException;
}
