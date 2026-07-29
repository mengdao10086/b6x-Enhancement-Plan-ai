package org.bouncycastle.jcajce.provider.asymmetric.edec;

import cr.h;
import gm.h0;
import gm.z;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import np.c;
import np.o0;
import np.r0;
import org.bouncycastle.crypto.util.m;
import org.bouncycastle.jcajce.interfaces.EdDSAPrivateKey;
import org.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import org.bouncycastle.util.p;
import pn.u;
import pq.e;
import tm.a;

/* JADX INFO: loaded from: classes7.dex */
public class BCEdDSAPrivateKey implements EdDSAPrivateKey {
    public static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient c f45016a;
    private final byte[] attributes;
    private final boolean hasPublicKey;

    public BCEdDSAPrivateKey(c cVar) {
        this.hasPublicKey = true;
        this.attributes = null;
        this.f45016a = cVar;
    }

    public BCEdDSAPrivateKey(u uVar) throws IOException {
        this.hasPublicKey = uVar.F();
        this.attributes = uVar.x() != null ? uVar.x().getEncoded() : null;
        b(uVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        b(u.z((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    @Override // org.bouncycastle.jcajce.interfaces.EdDSAPrivateKey
    public EdDSAPublicKey Y() {
        c cVar = this.f45016a;
        return cVar instanceof r0 ? new BCEdDSAPublicKey(((r0) cVar).e()) : new BCEdDSAPublicKey(((o0) cVar).e());
    }

    public c a() {
        return this.f45016a;
    }

    public final void b(u uVar) throws IOException {
        byte[] bArrJ = z.I(uVar.G()).J();
        this.f45016a = a.f51341e.C(uVar.B().x()) ? new r0(bArrJ) : new o0(bArrJ);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PrivateKey) {
            return org.bouncycastle.util.a.g(((PrivateKey) obj).getEncoded(), getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.f45016a instanceof r0 ? h.f25816c : h.f25815b;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            h0 h0VarI = h0.I(this.attributes);
            u uVarB = m.b(this.f45016a, h0VarI);
            return (!this.hasPublicKey || p.d("org.bouncycastle.pkcs8.v1_info_only")) ? new u(uVarB.B(), uVarB.G(), h0VarI).getEncoded() : uVarB.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return org.bouncycastle.util.a.s0(getEncoded());
    }

    public String toString() {
        c cVar = this.f45016a;
        return e.c("Private Key", getAlgorithm(), cVar instanceof r0 ? ((r0) cVar).e() : ((o0) cVar).e());
    }
}
