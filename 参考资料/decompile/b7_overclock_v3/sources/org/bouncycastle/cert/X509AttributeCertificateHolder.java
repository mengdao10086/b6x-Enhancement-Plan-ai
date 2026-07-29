package org.bouncycastle.cert;

import cs.h;
import gm.f0;
import gm.j;
import gm.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.util.g;
import p000do.a;
import p000do.b;
import p000do.c;
import zn.d;
import zn.e;
import zn.f;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class X509AttributeCertificateHolder implements g, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e[] f44472c = new e[0];
    private static final long serialVersionUID = 20170722001L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient f f44473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient z f44474b;

    public X509AttributeCertificateHolder(f fVar) {
        v(fVar);
    }

    public X509AttributeCertificateHolder(byte[] bArr) throws IOException {
        this(y(bArr));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        v(f.y(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public static f y(byte[] bArr) throws IOException {
        try {
            return f.y(c.q(bArr));
        } catch (ClassCastException e10) {
            throw new CertIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new CertIOException("malformed data: " + e11.getMessage(), e11);
        }
    }

    public e[] a() {
        f0 f0VarY = this.f44473a.x().y();
        e[] eVarArr = new e[f0VarY.size()];
        for (int i10 = 0; i10 != f0VarY.size(); i10++) {
            eVarArr[i10] = e.A(f0VarY.K(i10));
        }
        return eVarArr;
    }

    public e[] b(y yVar) {
        f0 f0VarY = this.f44473a.x().y();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != f0VarY.size(); i10++) {
            e eVarA = e.A(f0VarY.K(i10));
            if (eVarA.x().C(yVar)) {
                arrayList.add(eVarA);
            }
        }
        return arrayList.size() == 0 ? f44472c : (e[]) arrayList.toArray(new e[arrayList.size()]);
    }

    public Set c() {
        return c.m(this.f44474b);
    }

    public zn.y d(y yVar) {
        z zVar = this.f44474b;
        if (zVar != null) {
            return zVar.z(yVar);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509AttributeCertificateHolder) {
            return this.f44473a.equals(((X509AttributeCertificateHolder) obj).f44473a);
        }
        return false;
    }

    public List f() {
        return c.n(this.f44474b);
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f44473a.getEncoded();
    }

    public z h() {
        return this.f44474b;
    }

    public int hashCode() {
        return this.f44473a.hashCode();
    }

    public a i() {
        return new a((f0) this.f44473a.x().A().b());
    }

    public b k() {
        return new b(this.f44473a.x().D());
    }

    public boolean[] l() {
        return c.b(this.f44473a.x().E());
    }

    public Set m() {
        return c.o(this.f44474b);
    }

    public Date n() {
        return c.r(this.f44473a.x().x().y());
    }

    public Date o() {
        return c.r(this.f44473a.x().x().z());
    }

    public BigInteger p() {
        return this.f44473a.x().F().K();
    }

    public byte[] q() {
        return this.f44473a.A().L();
    }

    public zn.b r() {
        return this.f44473a.z();
    }

    public int t() {
        return this.f44473a.x().H().Q() + 1;
    }

    public boolean u() {
        return this.f44474b != null;
    }

    public final void v(f fVar) {
        this.f44473a = fVar;
        this.f44474b = fVar.x().z();
    }

    public boolean w(h hVar) throws CertException {
        zn.g gVarX = this.f44473a.x();
        if (!c.p(gVarX.G(), this.f44473a.z())) {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
        try {
            cs.g gVarA = hVar.a(gVarX.G());
            OutputStream outputStreamB = gVarA.b();
            gVarX.u(outputStreamB, j.f29713a);
            outputStreamB.close();
            return gVarA.verify(q());
        } catch (Exception e10) {
            throw new CertException("unable to process signature: " + e10.getMessage(), e10);
        }
    }

    public boolean x(Date date) {
        d dVarX = this.f44473a.x().x();
        return (date.before(c.r(dVarX.z())) || date.after(c.r(dVarX.y()))) ? false : true;
    }

    public f z() {
        return this.f44473a;
    }
}
