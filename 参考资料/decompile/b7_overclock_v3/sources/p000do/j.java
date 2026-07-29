package p000do;

import cs.f;
import gm.h;
import gm.i;
import gm.j2;
import gm.t;
import gm.u1;
import gm.w;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509CertificateHolder;
import xn.d;
import zn.a0;
import zn.b;
import zn.c1;
import zn.e1;
import zn.j1;
import zn.o;
import zn.p1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p1 f26441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f26442b;

    public j(X509CertificateHolder x509CertificateHolder) {
        p1 p1Var = new p1();
        this.f26441a = p1Var;
        p1Var.i(new t(x509CertificateHolder.l()));
        this.f26441a.f(x509CertificateHolder.f());
        this.f26441a.l(new j1(x509CertificateHolder.k()));
        this.f26441a.c(new j1(x509CertificateHolder.i()));
        this.f26441a.m(x509CertificateHolder.o());
        this.f26441a.o(x509CertificateHolder.p());
        this.f26442b = new a0();
        z zVarD = x509CertificateHolder.d();
        Enumeration enumerationI = zVarD.I();
        while (enumerationI.hasMoreElements()) {
            this.f26442b.c(zVarD.z((y) enumerationI.nextElement()));
        }
    }

    public j(d dVar, BigInteger bigInteger, Date date, Date date2, Locale locale, d dVar2, c1 c1Var) {
        this(dVar, bigInteger, new j1(date, locale), new j1(date2, locale), dVar2, c1Var);
    }

    public j(d dVar, BigInteger bigInteger, Date date, Date date2, d dVar2, c1 c1Var) {
        this(dVar, bigInteger, new j1(date), new j1(date2), dVar2, c1Var);
    }

    public j(d dVar, BigInteger bigInteger, j1 j1Var, j1 j1Var2, d dVar2, c1 c1Var) {
        p1 p1Var = new p1();
        this.f26441a = p1Var;
        p1Var.i(new t(bigInteger));
        this.f26441a.f(dVar);
        this.f26441a.l(j1Var);
        this.f26441a.c(j1Var2);
        this.f26441a.m(dVar2);
        this.f26441a.o(c1Var);
        this.f26442b = new a0();
    }

    public static u1 d(boolean[] zArr) {
        byte[] bArr = new byte[(zArr.length + 7) / 8];
        for (int i10 = 0; i10 != zArr.length; i10++) {
            int i11 = i10 / 8;
            bArr[i11] = (byte) (bArr[i11] | (zArr[i10] ? 1 << (7 - (i10 % 8)) : 0));
        }
        int length = zArr.length % 8;
        return length == 0 ? new u1(bArr) : new u1(bArr, 8 - length);
    }

    public static byte[] h(f fVar, w wVar) throws IOException {
        OutputStream outputStreamB = fVar.b();
        wVar.u(outputStreamB, gm.j.f29713a);
        outputStreamB.close();
        return fVar.getSignature();
    }

    public static o i(e1 e1Var, b bVar, byte[] bArr) {
        i iVar = new i();
        iVar.a(e1Var);
        iVar.a(bVar);
        iVar.a(new u1(bArr));
        return o.z(new j2(iVar));
    }

    public j a(y yVar, boolean z10, h hVar) throws CertIOException {
        try {
            this.f26442b.a(yVar, z10, hVar);
            return this;
        } catch (IOException e10) {
            throw new CertIOException("cannot encode extension: " + e10.getMessage(), e10);
        }
    }

    public j b(y yVar, boolean z10, byte[] bArr) throws CertIOException {
        this.f26442b.b(yVar, z10, bArr);
        return this;
    }

    public j c(zn.y yVar) throws CertIOException {
        this.f26442b.c(yVar);
        return this;
    }

    public X509CertificateHolder e(f fVar) {
        this.f26441a.j(fVar.a());
        if (!this.f26442b.h()) {
            this.f26441a.d(this.f26442b.e());
        }
        try {
            e1 e1VarA = this.f26441a.a();
            return new X509CertificateHolder(i(e1VarA, fVar.a(), h(fVar, e1VarA)));
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot produce certificate signature");
        }
    }

    public j f(y yVar, boolean z10, X509CertificateHolder x509CertificateHolder) {
        zn.y yVarZ = x509CertificateHolder.y().H().y().z(yVar);
        if (yVarZ != null) {
            this.f26442b.b(yVar, z10, yVarZ.A().J());
            return this;
        }
        throw new NullPointerException("extension " + yVar + " not present");
    }

    public final zn.y g(y yVar) {
        return this.f26442b.e().z(yVar);
    }

    public zn.y j(y yVar) {
        return g(yVar);
    }

    public boolean k(y yVar) {
        return g(yVar) != null;
    }

    public j l(y yVar) {
        this.f26442b = c.d(this.f26442b, yVar);
        return this;
    }

    public j m(y yVar, boolean z10, h hVar) throws CertIOException {
        try {
            this.f26442b = c.e(this.f26442b, new zn.y(yVar, z10, hVar.b().v(gm.j.f29713a)));
            return this;
        } catch (IOException e10) {
            throw new CertIOException("cannot encode extension: " + e10.getMessage(), e10);
        }
    }

    public j n(y yVar, boolean z10, byte[] bArr) throws CertIOException {
        this.f26442b = c.e(this.f26442b, new zn.y(yVar, z10, bArr));
        return this;
    }

    public j o(zn.y yVar) throws CertIOException {
        this.f26442b = c.e(this.f26442b, yVar);
        return this;
    }

    public j p(boolean[] zArr) {
        this.f26441a.h(d(zArr));
        return this;
    }

    public j q(boolean[] zArr) {
        this.f26441a.p(d(zArr));
        return this;
    }
}
