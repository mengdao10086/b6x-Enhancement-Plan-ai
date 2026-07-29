package xp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.bouncycastle.est.ESTException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class g implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Logger f55743b = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f55744a;

    public g(Set<String> set) {
        this.f55744a = set;
    }

    public static boolean b(String str, String str2, Set<String> set) throws IOException {
        if (!str2.contains("*")) {
            return str.equalsIgnoreCase(str2);
        }
        int iIndexOf = str2.indexOf(42);
        if (iIndexOf != str2.lastIndexOf("*") || str2.contains("..") || str2.charAt(str2.length() - 1) == '*') {
            return false;
        }
        int iIndexOf2 = str2.indexOf(46, iIndexOf);
        if (set != null && set.contains(Strings.k(str2.substring(iIndexOf2)))) {
            throw new IOException("Wildcard `" + str2 + "` matches known public suffix.");
        }
        String strK = Strings.k(str2.substring(iIndexOf + 1));
        String strK2 = Strings.k(str);
        if (strK2.equals(strK) || strK.length() > strK2.length()) {
            return false;
        }
        if (iIndexOf > 0) {
            return strK2.startsWith(str2.substring(0, iIndexOf)) && strK2.endsWith(strK) && strK2.substring(iIndexOf, strK2.length() - strK.length()).indexOf(46) < 0;
        }
        if (strK2.substring(0, strK2.length() - strK.length()).indexOf(46) > 0) {
            return false;
        }
        return strK2.endsWith(strK);
    }

    @Override // xp.i
    public boolean a(String str, SSLSession sSLSession) throws IOException {
        try {
            return c(str, (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(sSLSession.getPeerCertificates()[0].getEncoded())));
        } catch (Exception e10) {
            if (e10 instanceof ESTException) {
                throw ((ESTException) e10);
            }
            throw new ESTException(e10.getMessage(), e10);
        }
    }

    public boolean c(String str, X509Certificate x509Certificate) throws IOException {
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                if (x509Certificate.getSubjectX500Principal() == null) {
                    return false;
                }
                xn.c[] cVarArrC = xn.d.A(x509Certificate.getSubjectX500Principal().getEncoded()).C();
                for (int length = cVarArrC.length - 1; length >= 0; length--) {
                    xn.a[] aVarArrB = cVarArrC[length].B();
                    for (int i10 = 0; i10 != aVarArrB.length; i10++) {
                        xn.a aVar = aVarArrB[i10];
                        if (aVar.y().C(yn.c.f57394g)) {
                            return b(str, aVar.z().toString(), this.f55744a);
                        }
                    }
                }
                return false;
            }
            for (List<?> list : subjectAlternativeNames) {
                int iIntValue = ((Number) list.get(0)).intValue();
                if (iIntValue == 2) {
                    if (b(str, list.get(1).toString(), this.f55744a)) {
                        return true;
                    }
                } else if (iIntValue == 7) {
                    if (InetAddress.getByName(str).equals(InetAddress.getByName(list.get(1).toString()))) {
                        return true;
                    }
                } else if (f55743b.isLoggable(Level.INFO)) {
                    String strJ = list.get(1) instanceof byte[] ? jt.h.j((byte[]) list.get(1)) : list.get(1).toString();
                    f55743b.log(Level.INFO, "ignoring type " + iIntValue + " value = " + strJ);
                }
            }
            return false;
        } catch (Exception e10) {
            throw new ESTException(e10.getMessage(), e10);
        }
    }
}
