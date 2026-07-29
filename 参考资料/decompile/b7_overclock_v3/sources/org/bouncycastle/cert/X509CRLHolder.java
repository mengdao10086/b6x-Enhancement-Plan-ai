package org.bouncycastle.cert;

import cs.h;
import gm.j;
import gm.s;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.bouncycastle.util.g;
import p000do.c;
import xn.d;
import zn.b0;
import zn.c0;
import zn.d1;
import zn.i0;
import zn.j1;
import zn.p;
import zn.y;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class X509CRLHolder implements g, Serializable {
    private static final long serialVersionUID = 20170722001L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient p f44475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient boolean f44476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient z f44477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient c0 f44478d;

    public X509CRLHolder(InputStream inputStream) throws IOException {
        this(r(inputStream));
    }

    public X509CRLHolder(p pVar) {
        o(pVar);
    }

    public X509CRLHolder(byte[] bArr) throws IOException {
        this(r(new ByteArrayInputStream(bArr)));
    }

    public static boolean p(z zVar) {
        y yVarZ;
        return (zVar == null || (yVarZ = zVar.z(y.f59071p)) == null || !i0.B(yVarZ.C()).D()) ? false : true;
    }

    public static p r(InputStream inputStream) throws IOException {
        try {
            gm.c0 c0VarN = new s(inputStream, true).n();
            if (c0VarN != null) {
                return p.y(c0VarN);
            }
            throw new IOException("no content found");
        } catch (ClassCastException e10) {
            throw new CertIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new CertIOException("malformed data: " + e11.getMessage(), e11);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        o(p.y(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public Set a() {
        return c.m(this.f44477c);
    }

    public y b(gm.y yVar) {
        z zVar = this.f44477c;
        if (zVar != null) {
            return zVar.z(yVar);
        }
        return null;
    }

    public List c() {
        return c.n(this.f44477c);
    }

    public z d() {
        return this.f44477c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509CRLHolder) {
            return this.f44475a.equals(((X509CRLHolder) obj).f44475a);
        }
        return false;
    }

    public d f() {
        return d.A(this.f44475a.z());
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f44475a.getEncoded();
    }

    public Date h() {
        j1 j1VarA = this.f44475a.A();
        if (j1VarA != null) {
            return j1VarA.x();
        }
        return null;
    }

    public int hashCode() {
        return this.f44475a.hashCode();
    }

    public Set i() {
        return c.o(this.f44477c);
    }

    public p000do.d k(BigInteger bigInteger) {
        y yVarZ;
        c0 c0VarA = this.f44478d;
        Enumeration enumerationB = this.f44475a.B();
        while (enumerationB.hasMoreElements()) {
            d1.b bVar = (d1.b) enumerationB.nextElement();
            if (bVar.A().N(bigInteger)) {
                return new p000do.d(bVar, this.f44476b, c0VarA);
            }
            if (this.f44476b && bVar.B() && (yVarZ = bVar.x().z(y.f59072q)) != null) {
                c0VarA = c0.A(yVarZ.C());
            }
        }
        return null;
    }

    public Collection l() {
        ArrayList arrayList = new ArrayList(this.f44475a.C().length);
        c0 c0VarA = this.f44478d;
        Enumeration enumerationB = this.f44475a.B();
        while (enumerationB.hasMoreElements()) {
            p000do.d dVar = new p000do.d((d1.b) enumerationB.nextElement(), this.f44476b, c0VarA);
            arrayList.add(dVar);
            c0VarA = dVar.a();
        }
        return arrayList;
    }

    public Date m() {
        return this.f44475a.G().x();
    }

    public boolean n() {
        return this.f44477c != null;
    }

    public final void o(p pVar) {
        this.f44475a = pVar;
        z zVarX = pVar.F().x();
        this.f44477c = zVarX;
        this.f44476b = p(zVarX);
        this.f44478d = new c0(new b0(pVar.z()));
    }

    public boolean q(h hVar) throws CertException {
        d1 d1VarF = this.f44475a.F();
        if (!c.p(d1VarF.E(), this.f44475a.E())) {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
        try {
            cs.g gVarA = hVar.a(d1VarF.E());
            OutputStream outputStreamB = gVarA.b();
            d1VarF.u(outputStreamB, j.f29713a);
            outputStreamB.close();
            return gVarA.verify(this.f44475a.D().L());
        } catch (Exception e10) {
            throw new CertException("unable to process signature: " + e10.getMessage(), e10);
        }
    }

    public p t() {
        return this.f44475a;
    }
}
