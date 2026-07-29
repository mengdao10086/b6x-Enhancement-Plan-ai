package p000do;

import cs.f;
import gm.j;
import gm.l2;
import gm.o;
import gm.t;
import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import zn.a0;
import zn.c;
import zn.e;
import zn.m1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m1 f26437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f26438b;

    public h(a aVar, b bVar, BigInteger bigInteger, Date date, Date date2) {
        this.f26437a = new m1();
        this.f26438b = new a0();
        this.f26437a.g(aVar.f26429a);
        this.f26437a.h(c.y(bVar.f26430a));
        this.f26437a.j(new t(bigInteger));
        this.f26437a.l(new o(date));
        this.f26437a.d(new o(date2));
    }

    public h(a aVar, b bVar, BigInteger bigInteger, Date date, Date date2, Locale locale) {
        this.f26437a = new m1();
        this.f26438b = new a0();
        this.f26437a.g(aVar.f26429a);
        this.f26437a.h(c.y(bVar.f26430a));
        this.f26437a.j(new t(bigInteger));
        this.f26437a.l(new o(date, locale));
        this.f26437a.d(new o(date2, locale));
    }

    public h(X509AttributeCertificateHolder x509AttributeCertificateHolder) {
        m1 m1Var = new m1();
        this.f26437a = m1Var;
        m1Var.j(new t(x509AttributeCertificateHolder.p()));
        this.f26437a.h(c.y(x509AttributeCertificateHolder.k().f26430a));
        this.f26437a.l(new o(x509AttributeCertificateHolder.o()));
        this.f26437a.d(new o(x509AttributeCertificateHolder.n()));
        this.f26437a.g(x509AttributeCertificateHolder.i().f26429a);
        boolean[] zArrL = x509AttributeCertificateHolder.l();
        if (zArrL != null) {
            this.f26437a.i(c.c(zArrL));
        }
        e[] eVarArrA = x509AttributeCertificateHolder.a();
        for (int i10 = 0; i10 != eVarArrA.length; i10++) {
            this.f26437a.b(eVarArrA[i10]);
        }
        this.f26438b = new a0();
        z zVarH = x509AttributeCertificateHolder.h();
        Enumeration enumerationI = zVarH.I();
        while (enumerationI.hasMoreElements()) {
            this.f26438b.c(zVarH.z((y) enumerationI.nextElement()));
        }
    }

    public h a(y yVar, gm.h hVar) {
        this.f26437a.b(new e(yVar, new l2(hVar)));
        return this;
    }

    public h b(y yVar, gm.h[] hVarArr) {
        this.f26437a.b(new e(yVar, new l2(hVarArr)));
        return this;
    }

    public h c(y yVar, boolean z10, gm.h hVar) throws CertIOException {
        c.a(this.f26438b, yVar, z10, hVar);
        return this;
    }

    public h d(y yVar, boolean z10, byte[] bArr) throws CertIOException {
        this.f26438b.b(yVar, z10, bArr);
        return this;
    }

    public h e(zn.y yVar) throws CertIOException {
        this.f26438b.c(yVar);
        return this;
    }

    public X509AttributeCertificateHolder f(f fVar) {
        this.f26437a.k(fVar.a());
        if (!this.f26438b.h()) {
            this.f26437a.e(this.f26438b.e());
        }
        return c.h(fVar, this.f26437a.c());
    }

    public final zn.y g(y yVar) {
        return this.f26438b.e().z(yVar);
    }

    public zn.y h(y yVar) {
        return g(yVar);
    }

    public boolean i(y yVar) {
        return g(yVar) != null;
    }

    public h j(y yVar) {
        this.f26438b = c.d(this.f26438b, yVar);
        return this;
    }

    public h k(y yVar, boolean z10, gm.h hVar) throws CertIOException {
        try {
            this.f26438b = c.e(this.f26438b, new zn.y(yVar, z10, hVar.b().v(j.f29713a)));
            return this;
        } catch (IOException e10) {
            throw new CertIOException("cannot encode extension: " + e10.getMessage(), e10);
        }
    }

    public h l(y yVar, boolean z10, byte[] bArr) throws CertIOException {
        this.f26438b = c.e(this.f26438b, new zn.y(yVar, z10, bArr));
        return this;
    }

    public h m(zn.y yVar) throws CertIOException {
        this.f26438b = c.e(this.f26438b, yVar);
        return this;
    }

    public void n(boolean[] zArr) {
        this.f26437a.i(c.c(zArr));
    }
}
