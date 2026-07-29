package p000do;

import cs.f;
import gm.t;
import java.math.BigInteger;
import java.util.Date;
import java.util.Locale;
import org.bouncycastle.cert.X509CertificateHolder;
import xn.d;
import zn.c1;
import zn.j1;
import zn.l1;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l1 f26436a;

    public g(d dVar, BigInteger bigInteger, Date date, Date date2, Locale locale, d dVar2, c1 c1Var) {
        this(dVar, bigInteger, new j1(date, locale), new j1(date2, locale), dVar2, c1Var);
    }

    public g(d dVar, BigInteger bigInteger, Date date, Date date2, d dVar2, c1 c1Var) {
        this(dVar, bigInteger, new j1(date), new j1(date2), dVar2, c1Var);
    }

    public g(d dVar, BigInteger bigInteger, j1 j1Var, j1 j1Var2, d dVar2, c1 c1Var) {
        if (dVar == null) {
            throw new IllegalArgumentException("issuer must not be null");
        }
        if (c1Var == null) {
            throw new IllegalArgumentException("publicKeyInfo must not be null");
        }
        l1 l1Var = new l1();
        this.f26436a = l1Var;
        l1Var.f(new t(bigInteger));
        this.f26436a.d(dVar);
        this.f26436a.i(j1Var);
        this.f26436a.c(j1Var2);
        this.f26436a.j(dVar2);
        this.f26436a.l(c1Var);
    }

    public X509CertificateHolder a(f fVar) {
        this.f26436a.g(fVar.a());
        return c.j(fVar, this.f26436a.a());
    }
}
