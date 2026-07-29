package p000do;

import cs.f;
import gm.f0;
import gm.h;
import gm.j;
import gm.o;
import gm.t;
import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509CRLHolder;
import xn.d;
import zn.a0;
import zn.d1;
import zn.j1;
import zn.o1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o1 f26439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f26440b;

    public i(X509CRLHolder x509CRLHolder) {
        o1 o1Var = new o1();
        this.f26439a = o1Var;
        o1Var.l(x509CRLHolder.f());
        this.f26439a.r(new j1(x509CRLHolder.m()));
        Date dateH = x509CRLHolder.h();
        if (dateH != null) {
            this.f26439a.o(new j1(dateH));
        }
        a(x509CRLHolder);
        this.f26440b = new a0();
        z zVarD = x509CRLHolder.d();
        if (zVarD != null) {
            Enumeration enumerationI = zVarD.I();
            while (enumerationI.hasMoreElements()) {
                this.f26440b.c(zVarD.z((y) enumerationI.nextElement()));
            }
        }
    }

    public i(d dVar, Date date) {
        this.f26439a = new o1();
        this.f26440b = new a0();
        this.f26439a.l(dVar);
        this.f26439a.r(new j1(date));
    }

    public i(d dVar, Date date, Locale locale) {
        this.f26439a = new o1();
        this.f26440b = new a0();
        this.f26439a.l(dVar);
        this.f26439a.r(new j1(date, locale));
    }

    public i(d dVar, j1 j1Var) {
        this.f26439a = new o1();
        this.f26440b = new a0();
        this.f26439a.l(dVar);
        this.f26439a.r(j1Var);
    }

    public i a(X509CRLHolder x509CRLHolder) {
        d1 d1VarF = x509CRLHolder.t().F();
        if (d1VarF != null) {
            Enumeration enumerationC = d1VarF.C();
            while (enumerationC.hasMoreElements()) {
                this.f26439a.e(f0.J(((h) enumerationC.nextElement()).b()));
            }
        }
        return this;
    }

    public i b(BigInteger bigInteger, Date date, int i10) {
        this.f26439a.b(new t(bigInteger), new j1(date), i10);
        return this;
    }

    public i c(BigInteger bigInteger, Date date, int i10, Date date2) {
        this.f26439a.c(new t(bigInteger), new j1(date), i10, new o(date2));
        return this;
    }

    public i d(BigInteger bigInteger, Date date, z zVar) {
        this.f26439a.d(new t(bigInteger), new j1(date), zVar);
        return this;
    }

    public i e(y yVar, boolean z10, h hVar) throws CertIOException {
        c.a(this.f26440b, yVar, z10, hVar);
        return this;
    }

    public i f(y yVar, boolean z10, byte[] bArr) throws CertIOException {
        this.f26440b.b(yVar, z10, bArr);
        return this;
    }

    public i g(zn.y yVar) throws CertIOException {
        this.f26440b.c(yVar);
        return this;
    }

    public X509CRLHolder h(f fVar) {
        this.f26439a.p(fVar.a());
        if (!this.f26440b.h()) {
            this.f26439a.j(this.f26440b.e());
        }
        return c.i(fVar, this.f26439a.h());
    }

    public final zn.y i(y yVar) {
        return this.f26440b.e().z(yVar);
    }

    public zn.y j(y yVar) {
        return i(yVar);
    }

    public boolean k(y yVar) {
        return i(yVar) != null;
    }

    public i l(y yVar) {
        this.f26440b = c.d(this.f26440b, yVar);
        return this;
    }

    public i m(y yVar, boolean z10, h hVar) throws CertIOException {
        try {
            this.f26440b = c.e(this.f26440b, new zn.y(yVar, z10, hVar.b().v(j.f29713a)));
            return this;
        } catch (IOException e10) {
            throw new CertIOException("cannot encode extension: " + e10.getMessage(), e10);
        }
    }

    public i n(y yVar, boolean z10, byte[] bArr) throws CertIOException {
        this.f26440b = c.e(this.f26440b, new zn.y(yVar, z10, bArr));
        return this;
    }

    public i o(zn.y yVar) throws CertIOException {
        this.f26440b = c.e(this.f26440b, yVar);
        return this;
    }

    public i p(Date date) {
        return r(new j1(date));
    }

    public i q(Date date, Locale locale) {
        return r(new j1(date, locale));
    }

    public i r(j1 j1Var) {
        this.f26439a.o(j1Var);
        return this;
    }
}
