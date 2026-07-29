package no;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static Set a(X509CertificateHolder[] x509CertificateHolderArr) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 != x509CertificateHolderArr.length; i10++) {
            hashSet.addAll(x509CertificateHolderArr[i10].a());
        }
        return hashSet;
    }
}
