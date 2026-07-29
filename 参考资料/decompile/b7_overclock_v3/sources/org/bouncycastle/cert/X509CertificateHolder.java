package org.bouncycastle.cert;

import cs.h;
import gm.j;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.util.g;
import p000do.c;
import xn.d;
import zn.b;
import zn.c1;
import zn.e1;
import zn.o;
import zn.y;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class X509CertificateHolder implements g, Serializable {
    private static final long serialVersionUID = 20170722001L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient o f44479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient z f44480b;

    public X509CertificateHolder(o oVar) {
        u(oVar);
    }

    public X509CertificateHolder(byte[] bArr) throws IOException {
        this(x(bArr));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        u(o.z(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public static o x(byte[] bArr) throws IOException {
        try {
            return o.z(c.q(bArr));
        } catch (ClassCastException e10) {
            throw new CertIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new CertIOException("malformed data: " + e11.getMessage(), e11);
        }
    }

    public Set a() {
        return c.m(this.f44480b);
    }

    public y b(gm.y yVar) {
        z zVar = this.f44480b;
        if (zVar != null) {
            return zVar.z(yVar);
        }
        return null;
    }

    public List c() {
        return c.n(this.f44480b);
    }

    public z d() {
        return this.f44480b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509CertificateHolder) {
            return this.f44479a.equals(((X509CertificateHolder) obj).f44479a);
        }
        return false;
    }

    public d f() {
        return d.A(this.f44479a.A());
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f44479a.getEncoded();
    }

    public Set h() {
        return c.o(this.f44480b);
    }

    public int hashCode() {
        return this.f44479a.hashCode();
    }

    public Date i() {
        return this.f44479a.x().x();
    }

    public Date k() {
        return this.f44479a.E().x();
    }

    public BigInteger l() {
        return this.f44479a.B().K();
    }

    public byte[] m() {
        return this.f44479a.C().L();
    }

    public b n() {
        return this.f44479a.D();
    }

    public d o() {
        return d.A(this.f44479a.F());
    }

    public c1 p() {
        return this.f44479a.G();
    }

    public int q() {
        return this.f44479a.J();
    }

    public int r() {
        return this.f44479a.J();
    }

    public boolean t() {
        return this.f44480b != null;
    }

    public final void u(o oVar) {
        this.f44479a = oVar;
        this.f44480b = oVar.H().y();
    }

    public boolean v(h hVar) throws CertException {
        e1 e1VarH = this.f44479a.H();
        if (!c.p(e1VarH.E(), this.f44479a.D())) {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
        try {
            cs.g gVarA = hVar.a(e1VarH.E());
            OutputStream outputStreamB = gVarA.b();
            e1VarH.u(outputStreamB, j.f29713a);
            outputStreamB.close();
            return gVarA.verify(m());
        } catch (Exception e10) {
            throw new CertException("unable to process signature: " + e10.getMessage(), e10);
        }
    }

    public boolean w(Date date) {
        return (date.before(this.f44479a.E().x()) || date.after(this.f44479a.x().x())) ? false : true;
    }

    public o y() {
        return this.f44479a;
    }
}
