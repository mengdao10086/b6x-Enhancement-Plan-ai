package org.bouncycastle.jcajce.provider.asymmetric.edec;

import cr.x;
import gm.h0;
import gm.z;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import np.c;
import np.m2;
import np.p2;
import org.bouncycastle.crypto.util.m;
import org.bouncycastle.jcajce.interfaces.XDHPrivateKey;
import org.bouncycastle.jcajce.interfaces.XDHPublicKey;
import org.bouncycastle.util.p;
import pn.u;
import pq.e;
import tm.a;

/* JADX INFO: loaded from: classes7.dex */
public class BCXDHPrivateKey implements XDHPrivateKey {
    public static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient c f45018a;
    private final byte[] attributes;
    private final boolean hasPublicKey;

    public BCXDHPrivateKey(c cVar) {
        this.hasPublicKey = true;
        this.attributes = null;
        this.f45018a = cVar;
    }

    public BCXDHPrivateKey(u uVar) throws IOException {
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

    @Override // org.bouncycastle.jcajce.interfaces.XDHPrivateKey
    public XDHPublicKey Y() {
        c cVar = this.f45018a;
        return cVar instanceof p2 ? new BCXDHPublicKey(((p2) cVar).e()) : new BCXDHPublicKey(((m2) cVar).e());
    }

    public c a() {
        return this.f45018a;
    }

    public final void b(u uVar) throws IOException {
        byte[] bArrJ = uVar.A().J();
        if (bArrJ.length != 32 && bArrJ.length != 56) {
            bArrJ = z.I(uVar.G()).J();
        }
        this.f45018a = a.f51339c.C(uVar.B().x()) ? new p2(bArrJ) : new m2(bArrJ);
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
        return this.f45018a instanceof p2 ? x.f25874c : x.f25873b;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            h0 h0VarI = h0.I(this.attributes);
            u uVarB = m.b(this.f45018a, h0VarI);
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
        c cVar = this.f45018a;
        return e.c("Private Key", getAlgorithm(), cVar instanceof p2 ? ((p2) cVar).e() : ((m2) cVar).e());
    }
}
