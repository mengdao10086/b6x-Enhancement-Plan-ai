package cm;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¨\u0006\u0016"}, d2 = {"Lcm/a;", "Lcm/c;", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "a", "", "hashCode", "", "other", "", "equals", "Ljava/security/cert/X509Certificate;", "toVerify", "signingCert", "b", "Lcm/e;", "trustRootIndex", "<init>", "(Lcm/e;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final C0110a f10959c = new C0110a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10960d = 9;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final e f10961b;

    /* JADX INFO: renamed from: cm.a$a, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcm/a$a;", "", "", "MAX_SIGNERS", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0110a {
        public C0110a() {
        }

        public /* synthetic */ C0110a(u uVar) {
            this();
        }
    }

    public a(@k e trustRootIndex) {
        f0.p(trustRootIndex, "trustRootIndex");
        this.f10961b = trustRootIndex;
    }

    @Override // cm.c
    @k
    public List<Certificate> a(@k List<? extends Certificate> chain, @k String hostname) throws SSLPeerUnverifiedException {
        f0.p(chain, "chain");
        f0.p(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        f0.o(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        int i10 = 0;
        boolean z10 = false;
        while (i10 < 9) {
            i10++;
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateA = this.f10961b.a(x509Certificate);
            if (x509CertificateA == null) {
                Iterator it2 = arrayDeque.iterator();
                f0.o(it2, "queue.iterator()");
                while (it2.hasNext()) {
                    Object next = it2.next();
                    Objects.requireNonNull(next, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (b(x509Certificate, x509Certificate2)) {
                        it2.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException(f0.C("Failed to find a trusted cert that signed ", x509Certificate));
            }
            if (arrayList.size() > 1 || !f0.g(x509Certificate, x509CertificateA)) {
                arrayList.add(x509CertificateA);
            }
            if (b(x509CertificateA, x509CertificateA)) {
                return arrayList;
            }
            z10 = true;
        }
        throw new SSLPeerUnverifiedException(f0.C("Certificate chain too long: ", arrayList));
    }

    public final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!f0.g(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public boolean equals(@l Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && f0.g(((a) obj).f10961b, this.f10961b);
    }

    public int hashCode() {
        return this.f10961b.hashCode();
    }
}
