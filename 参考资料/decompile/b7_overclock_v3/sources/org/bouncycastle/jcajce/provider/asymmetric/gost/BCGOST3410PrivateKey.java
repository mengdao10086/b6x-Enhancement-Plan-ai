package org.bouncycastle.jcajce.provider.asymmetric.gost;

import er.f;
import er.g;
import gm.f2;
import gm.h;
import gm.j;
import gm.t;
import gm.y;
import gm.z;
import gr.n;
import gr.o;
import gr.p;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.util.Enumeration;
import np.c1;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import pn.u;
import qm.a;
import rq.c;
import zn.b;

/* JADX INFO: loaded from: classes7.dex */
public class BCGOST3410PrivateKey implements GOST3410PrivateKey, g {
    public static final long serialVersionUID = 8581661527592305464L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient f f45025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient g f45026b = new m();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f45027x;

    public BCGOST3410PrivateKey() {
    }

    public BCGOST3410PrivateKey(o oVar) {
        this.f45027x = oVar.d();
        this.f45025a = new n(new p(oVar.b(), oVar.c(), oVar.a()));
    }

    public BCGOST3410PrivateKey(c1 c1Var, n nVar) {
        this.f45027x = c1Var.e();
        this.f45025a = nVar;
        if (nVar == null) {
            throw new IllegalArgumentException("spec is null");
        }
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKey gOST3410PrivateKey) {
        this.f45027x = gOST3410PrivateKey.getX();
        this.f45025a = gOST3410PrivateKey.b();
    }

    public BCGOST3410PrivateKey(u uVar) throws IOException {
        BigInteger bigInteger;
        qm.g gVarA = qm.g.A(uVar.B().A());
        h hVarG = uVar.G();
        if (hVarG instanceof t) {
            bigInteger = t.I(hVarG).J();
        } else {
            byte[] bArrJ = z.I(uVar.G()).J();
            byte[] bArr = new byte[bArrJ.length];
            for (int i10 = 0; i10 != bArrJ.length; i10++) {
                bArr[i10] = bArrJ[(bArrJ.length - 1) - i10];
            }
            bigInteger = new BigInteger(1, bArr);
        }
        this.f45027x = bigInteger;
        this.f45025a = n.e(gVarA);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.f45025a = new n(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        } else {
            this.f45025a = new n(new p((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
            objectInputStream.readObject();
            objectInputStream.readObject();
        }
        this.f45026b = new m();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object objA;
        objectOutputStream.defaultWriteObject();
        if (this.f45025a.c() != null) {
            objA = this.f45025a.c();
        } else {
            objectOutputStream.writeObject(null);
            objectOutputStream.writeObject(this.f45025a.a().b());
            objectOutputStream.writeObject(this.f45025a.a().c());
            objA = this.f45025a.a().a();
        }
        objectOutputStream.writeObject(objA);
        objectOutputStream.writeObject(this.f45025a.d());
        objectOutputStream.writeObject(this.f45025a.b());
    }

    public final boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    @Override // er.e
    public f b() {
        return this.f45025a;
    }

    @Override // er.g
    public h c(y yVar) {
        return this.f45026b.c(yVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PrivateKey)) {
            return false;
        }
        GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) obj;
        return getX().equals(gOST3410PrivateKey.getX()) && b().a().equals(gOST3410PrivateKey.b().a()) && b().d().equals(gOST3410PrivateKey.b().d()) && a(b().b(), gOST3410PrivateKey.b().b());
    }

    @Override // er.g
    public Enumeration f() {
        return this.f45026b.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GOST3410";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] byteArray = getX().toByteArray();
        byte[] bArr = new byte[byteArray[0] == 0 ? byteArray.length - 1 : byteArray.length];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = byteArray[(byteArray.length - 1) - i10];
        }
        try {
            return (this.f45025a instanceof n ? new u(new b(a.f47462l, new qm.g(new y(this.f45025a.c()), new y(this.f45025a.d()))), new f2(bArr)) : new u(new b(a.f47462l), new f2(bArr))).v(j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410PrivateKey
    public BigInteger getX() {
        return this.f45027x;
    }

    @Override // er.g
    public void h(y yVar, h hVar) {
        this.f45026b.h(yVar, hVar);
    }

    public int hashCode() {
        return getX().hashCode() ^ this.f45025a.hashCode();
    }

    public String toString() {
        try {
            return c.b("GOST3410", this.f45027x, ((c1) org.bouncycastle.jcajce.provider.asymmetric.util.j.a(this)).d());
        } catch (InvalidKeyException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }
}
