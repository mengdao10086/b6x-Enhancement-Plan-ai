package oo;

import gm.t;
import java.math.BigInteger;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.m;
import zn.r0;
import zn.y;

/* JADX INFO: loaded from: classes5.dex */
public class c implements no.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44377c;

    public c(int i10) {
        this(i10, false, false, false);
    }

    public c(int i10, boolean z10, boolean z11, boolean z12) {
        if (z10) {
            this.f44375a = 0;
        } else {
            this.f44375a = i10 + 1;
        }
        if (z11) {
            this.f44377c = 0;
        } else {
            this.f44377c = i10 + 1;
        }
        if (z12) {
            this.f44376b = 0;
        } else {
            this.f44376b = i10 + 1;
        }
    }

    public final int a(int i10) {
        if (i10 != 0) {
            return i10 - 1;
        }
        return 0;
    }

    @Override // org.bouncycastle.util.m
    public m d() {
        return new c(0);
    }

    @Override // org.bouncycastle.util.m
    public void i(m mVar) {
    }

    @Override // no.c
    public void j(no.d dVar, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        int iQ;
        dVar.a(y.f59079w);
        gm.y yVar = y.f59082z;
        dVar.a(yVar);
        if (dVar.c() || g.a(x509CertificateHolder)) {
            return;
        }
        this.f44375a = a(this.f44375a);
        this.f44376b = a(this.f44376b);
        this.f44377c = a(this.f44377c);
        r0 r0VarX = r0.x(x509CertificateHolder.d());
        if (r0VarX != null) {
            BigInteger bigIntegerA = r0VarX.A();
            if (bigIntegerA != null && bigIntegerA.intValue() < this.f44375a) {
                this.f44375a = bigIntegerA.intValue();
            }
            BigInteger bigIntegerY = r0VarX.y();
            if (bigIntegerY != null && bigIntegerY.intValue() < this.f44376b) {
                this.f44376b = bigIntegerY.intValue();
            }
        }
        y yVarB = x509CertificateHolder.b(yVar);
        if (yVarB == null || (iQ = t.I(yVarB.C()).Q()) >= this.f44377c) {
            return;
        }
        this.f44377c = iQ;
    }
}
