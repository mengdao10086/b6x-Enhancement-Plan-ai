package oo;

import java.math.BigInteger;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.m;
import zn.j;
import zn.y;

/* JADX INFO: loaded from: classes5.dex */
public class a implements no.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f44370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44371c;

    public a() {
        this(true);
    }

    public a(boolean z10) {
        this.f44369a = true;
        this.f44370b = null;
        this.f44371c = z10;
    }

    @Override // org.bouncycastle.util.m
    public m d() {
        a aVar = new a();
        aVar.f44371c = this.f44371c;
        aVar.f44369a = this.f44369a;
        aVar.f44370b = this.f44370b;
        return aVar;
    }

    @Override // org.bouncycastle.util.m
    public void i(m mVar) {
        a aVar = (a) mVar;
        this.f44371c = aVar.f44371c;
        this.f44369a = aVar.f44369a;
        this.f44370b = aVar.f44370b;
    }

    @Override // no.c
    public void j(no.d dVar, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        BigInteger bigIntegerA;
        dVar.a(y.f59063j);
        if (!this.f44369a) {
            throw new CertPathValidationException("Basic constraints violated: issuer is not a CA");
        }
        j jVarX = j.x(x509CertificateHolder.d());
        this.f44369a = (jVarX != null && jVarX.B()) || (jVarX == null && !this.f44371c);
        if (this.f44370b != null && !x509CertificateHolder.o().equals(x509CertificateHolder.f())) {
            if (this.f44370b.intValue() < 0) {
                throw new CertPathValidationException("Basic constraints violated: path length exceeded");
            }
            this.f44370b = org.bouncycastle.util.j.g(this.f44370b.intValue() - 1);
        }
        if (jVarX == null || (bigIntegerA = jVarX.A()) == null) {
            return;
        }
        int iL = org.bouncycastle.util.b.l(bigIntegerA);
        Integer num = this.f44370b;
        if (num != null) {
            iL = Math.min(iL, num.intValue());
        }
        this.f44370b = org.bouncycastle.util.j.g(iL);
    }
}
