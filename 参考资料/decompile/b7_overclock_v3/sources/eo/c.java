package eo;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.crypto.util.r;
import p000do.j;
import xn.d;

/* JADX INFO: loaded from: classes5.dex */
public class c extends j {
    public c(X509CertificateHolder x509CertificateHolder, BigInteger bigInteger, Date date, Date date2, d dVar, np.c cVar) throws IOException {
        super(x509CertificateHolder.o(), bigInteger, date, date2, dVar, r.a(cVar));
    }

    public c(d dVar, BigInteger bigInteger, Date date, Date date2, d dVar2, np.c cVar) throws IOException {
        super(dVar, bigInteger, date, date2, dVar2, r.a(cVar));
    }
}
