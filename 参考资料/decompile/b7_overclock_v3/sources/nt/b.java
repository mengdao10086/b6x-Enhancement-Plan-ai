package nt;

import gm.c0;
import gm.f0;
import gm.k0;
import gm.y;
import gm.z;
import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import org.bouncycastle.util.j;
import xn.d;
import zn.b0;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static c0 a(byte[] bArr) throws IOException {
        return c0.D(((z) c0.D(bArr)).J());
    }

    public static Collection b(byte[] bArr) throws CertificateParsingException {
        Object objB;
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration enumerationL = f0.J(a(bArr)).L();
            while (enumerationL.hasMoreElements()) {
                b0 b0VarZ = b0.z(enumerationL.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(j.g(b0VarZ.q()));
                switch (b0VarZ.q()) {
                    case 0:
                    case 3:
                    case 5:
                        objB = b0VarZ.A().b();
                        break;
                    case 1:
                    case 2:
                    case 6:
                        objB = ((k0) b0VarZ.A()).d();
                        break;
                    case 4:
                        objB = d.A(b0VarZ.A()).toString();
                        break;
                    case 7:
                        arrayList2.add(z.I(b0VarZ.A()).J());
                        continue;
                        arrayList.add(arrayList2);
                        break;
                    case 8:
                        objB = y.N(b0VarZ.A()).L();
                        break;
                    default:
                        throw new IOException("Bad tag number: " + b0VarZ.q());
                }
                arrayList2.add(objB);
                arrayList.add(arrayList2);
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e10) {
            throw new CertificateParsingException(e10.getMessage());
        }
    }

    public static Collection c(X509Certificate x509Certificate) throws CertificateParsingException {
        return b(x509Certificate.getExtensionValue(zn.y.f59062i.L()));
    }

    public static Collection d(X509Certificate x509Certificate) throws CertificateParsingException {
        return b(x509Certificate.getExtensionValue(zn.y.f59061h.L()));
    }
}
