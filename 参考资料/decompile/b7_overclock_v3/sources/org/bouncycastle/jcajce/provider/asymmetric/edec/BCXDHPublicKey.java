package org.bouncycastle.jcajce.provider.asymmetric.edec;

import cr.x;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import np.c;
import np.n2;
import np.q2;
import org.bouncycastle.jcajce.interfaces.XDHPublicKey;
import pq.b;
import pq.e;
import tm.a;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCXDHPublicKey implements XDHPublicKey {
    public static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient c f45019a;

    public BCXDHPublicKey(c cVar) {
        this.f45019a = cVar;
    }

    public BCXDHPublicKey(c1 c1Var) {
        b(c1Var);
    }

    public BCXDHPublicKey(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException {
        c n2Var;
        int length = bArr.length;
        if (!e.b(bArr, bArr2)) {
            throw new InvalidKeySpecException("raw key data not recognised");
        }
        if (bArr2.length - length == 56) {
            n2Var = new q2(bArr2, length);
        } else {
            if (bArr2.length - length != 32) {
                throw new InvalidKeySpecException("raw key data not recognised");
            }
            n2Var = new n2(bArr2, length);
        }
        this.f45019a = n2Var;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        b(c1.A((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public c a() {
        return this.f45019a;
    }

    public final void b(c1 c1Var) {
        byte[] bArrL = c1Var.C().L();
        this.f45019a = a.f51339c.C(c1Var.x().x()) ? new q2(bArrL) : new n2(bArrL);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PublicKey) {
            return org.bouncycastle.util.a.g(((PublicKey) obj).getEncoded(), getEncoded());
        }
        return false;
    }

    @Override // org.bouncycastle.jcajce.interfaces.XDHPublicKey
    public BigInteger g0() {
        byte[] bArrZ0 = z0();
        org.bouncycastle.util.a.N0(bArrZ0);
        return new BigInteger(1, bArrZ0);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.f45019a instanceof q2 ? x.f25874c : x.f25873b;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.f45019a instanceof q2) {
            byte[] bArr = b.f46987d;
            byte[] bArr2 = new byte[bArr.length + 56];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            ((q2) this.f45019a).d(bArr2, bArr.length);
            return bArr2;
        }
        byte[] bArr3 = b.f46988e;
        byte[] bArr4 = new byte[bArr3.length + 32];
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        ((n2) this.f45019a).d(bArr4, bArr3.length);
        return bArr4;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return org.bouncycastle.util.a.s0(getEncoded());
    }

    public String toString() {
        return e.c("Public Key", getAlgorithm(), this.f45019a);
    }

    @Override // org.bouncycastle.jcajce.interfaces.XDHPublicKey
    public byte[] z0() {
        c cVar = this.f45019a;
        return cVar instanceof q2 ? ((q2) cVar).getEncoded() : ((n2) cVar).getEncoded();
    }
}
