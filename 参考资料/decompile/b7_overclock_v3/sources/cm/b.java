package cm;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b\"\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcm/b;", "Lcm/e;", "Ljava/security/cert/X509Certificate;", "cert", "a", "", "other", "", "equals", "", "hashCode", "", "caCerts", "<init>", "([Ljava/security/cert/X509Certificate;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final Map<X500Principal, Set<X509Certificate>> f10962a;

    public b(@k X509Certificate... caCerts) {
        f0.p(caCerts, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = caCerts.length;
        int i10 = 0;
        while (i10 < length) {
            X509Certificate x509Certificate = caCerts[i10];
            i10++;
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            f0.o(subjectX500Principal, "caCert.subjectX500Principal");
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.f10962a = linkedHashMap;
    }

    @Override // cm.e
    @l
    public X509Certificate a(@k X509Certificate cert) {
        boolean z10;
        f0.p(cert, "cert");
        Set<X509Certificate> set = this.f10962a.get(cert.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        Iterator<T> it2 = set.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            try {
                cert.verify(((X509Certificate) next).getPublicKey());
                z10 = true;
            } catch (Exception unused) {
                z10 = false;
            }
            if (z10) {
                obj = next;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    public boolean equals(@l Object obj) {
        return obj == this || ((obj instanceof b) && f0.g(((b) obj).f10962a, this.f10962a));
    }

    public int hashCode() {
        return this.f10962a.hashCode();
    }
}
