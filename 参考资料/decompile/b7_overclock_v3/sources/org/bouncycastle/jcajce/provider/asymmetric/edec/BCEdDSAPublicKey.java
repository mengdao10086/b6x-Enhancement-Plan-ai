package org.bouncycastle.jcajce.provider.asymmetric.edec;

import cr.h;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import np.c;
import np.p0;
import np.s0;
import org.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import pq.b;
import pq.e;
import tm.a;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCEdDSAPublicKey implements EdDSAPublicKey {
    public static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient c f45017a;

    public BCEdDSAPublicKey(c cVar) {
        this.f45017a = cVar;
    }

    public BCEdDSAPublicKey(c1 c1Var) {
        b(c1Var);
    }

    public BCEdDSAPublicKey(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException {
        c p0Var;
        int length = bArr.length;
        if (!e.b(bArr, bArr2)) {
            throw new InvalidKeySpecException("raw key data not recognised");
        }
        if (bArr2.length - length == 57) {
            p0Var = new s0(bArr2, length);
        } else {
            if (bArr2.length - length != 32) {
                throw new InvalidKeySpecException("raw key data not recognised");
            }
            p0Var = new p0(bArr2, length);
        }
        this.f45017a = p0Var;
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
        return this.f45017a;
    }

    public final void b(c1 c1Var) {
        byte[] bArrL = c1Var.C().L();
        this.f45017a = a.f51341e.C(c1Var.x().x()) ? new s0(bArrL) : new p0(bArrL);
    }

    @Override // org.bouncycastle.jcajce.interfaces.EdDSAPublicKey
    public byte[] c0() {
        c cVar = this.f45017a;
        return cVar instanceof s0 ? ((s0) cVar).getEncoded() : ((p0) cVar).getEncoded();
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

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.f45017a instanceof s0 ? h.f25816c : h.f25815b;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.f45017a instanceof s0) {
            byte[] bArr = b.f46989f;
            byte[] bArr2 = new byte[bArr.length + 57];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            ((s0) this.f45017a).d(bArr2, bArr.length);
            return bArr2;
        }
        byte[] bArr3 = b.f46990g;
        byte[] bArr4 = new byte[bArr3.length + 32];
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        ((p0) this.f45017a).d(bArr4, bArr3.length);
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
        return e.c("Public Key", getAlgorithm(), this.f45017a);
    }
}
