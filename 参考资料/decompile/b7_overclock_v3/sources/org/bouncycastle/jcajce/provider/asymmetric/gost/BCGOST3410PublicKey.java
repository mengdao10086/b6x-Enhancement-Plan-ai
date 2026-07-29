package org.bouncycastle.jcajce.provider.asymmetric.gost;

import er.f;
import gm.f2;
import gm.y;
import gr.n;
import gr.p;
import gr.q;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import np.d1;
import org.bouncycastle.jcajce.provider.asymmetric.util.j;
import org.bouncycastle.jcajce.provider.asymmetric.util.l;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import qm.a;
import qm.g;
import rq.c;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCGOST3410PublicKey implements GOST3410PublicKey {
    public static final long serialVersionUID = -6251023343619275990L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient f f45028a;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f45029y;

    public BCGOST3410PublicKey(q qVar) {
        this.f45029y = qVar.d();
        this.f45028a = new n(new p(qVar.b(), qVar.c(), qVar.a()));
    }

    public BCGOST3410PublicKey(BigInteger bigInteger, n nVar) {
        this.f45029y = bigInteger;
        this.f45028a = nVar;
    }

    public BCGOST3410PublicKey(d1 d1Var, n nVar) {
        this.f45029y = d1Var.e();
        this.f45028a = nVar;
    }

    public BCGOST3410PublicKey(GOST3410PublicKey gOST3410PublicKey) {
        this.f45029y = gOST3410PublicKey.getY();
        this.f45028a = gOST3410PublicKey.b();
    }

    public BCGOST3410PublicKey(c1 c1Var) {
        g gVarA = g.A(c1Var.x().A());
        try {
            byte[] bArrJ = ((f2) c1Var.D()).J();
            byte[] bArr = new byte[bArrJ.length];
            for (int i10 = 0; i10 != bArrJ.length; i10++) {
                bArr[i10] = bArrJ[(bArrJ.length - 1) - i10];
            }
            this.f45029y = new BigInteger(1, bArr);
            this.f45028a = n.e(gVarA);
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.f45028a = new n(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
            return;
        }
        this.f45028a = new n(new p((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
        objectInputStream.readObject();
        objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object objA;
        objectOutputStream.defaultWriteObject();
        if (this.f45028a.c() != null) {
            objA = this.f45028a.c();
        } else {
            objectOutputStream.writeObject(null);
            objectOutputStream.writeObject(this.f45028a.a().b());
            objectOutputStream.writeObject(this.f45028a.a().c());
            objA = this.f45028a.a().a();
        }
        objectOutputStream.writeObject(objA);
        objectOutputStream.writeObject(this.f45028a.d());
        objectOutputStream.writeObject(this.f45028a.b());
    }

    @Override // er.e
    public f b() {
        return this.f45028a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCGOST3410PublicKey)) {
            return false;
        }
        BCGOST3410PublicKey bCGOST3410PublicKey = (BCGOST3410PublicKey) obj;
        return this.f45029y.equals(bCGOST3410PublicKey.f45029y) && this.f45028a.equals(bCGOST3410PublicKey.f45028a);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GOST3410";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] byteArray = getY().toByteArray();
        byte[] bArr = new byte[byteArray[0] == 0 ? byteArray.length - 1 : byteArray.length];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = byteArray[(byteArray.length - 1) - i10];
        }
        try {
            f fVar = this.f45028a;
            return l.e(fVar instanceof n ? fVar.b() != null ? new c1(new b(a.f47462l, new g(new y(this.f45028a.c()), new y(this.f45028a.d()), new y(this.f45028a.b()))), new f2(bArr)) : new c1(new b(a.f47462l, new g(new y(this.f45028a.c()), new y(this.f45028a.d()))), new f2(bArr)) : new c1(new b(a.f47462l), new f2(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410PublicKey
    public BigInteger getY() {
        return this.f45029y;
    }

    public int hashCode() {
        return this.f45029y.hashCode() ^ this.f45028a.hashCode();
    }

    public String toString() {
        try {
            return c.c("GOST3410", this.f45029y, ((d1) j.b(this)).d());
        } catch (InvalidKeyException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }
}
