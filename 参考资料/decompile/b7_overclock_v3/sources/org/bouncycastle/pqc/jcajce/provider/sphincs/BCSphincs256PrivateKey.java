package org.bouncycastle.pqc.jcajce.provider.sphincs;

import gm.f2;
import gm.h0;
import gm.y;
import is.g;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import pn.u;
import rs.i;
import ts.a;
import ts.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCSphincs256PrivateKey implements PrivateKey, SPHINCSKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient y f46014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient i f46015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient h0 f46016c;

    public BCSphincs256PrivateKey(y yVar, i iVar) {
        this.f46014a = yVar;
        this.f46015b = iVar;
    }

    public BCSphincs256PrivateKey(u uVar) throws IOException {
        c(uVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        c(u.z((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public k a() {
        return this.f46015b;
    }

    public y b() {
        return this.f46014a;
    }

    public final void c(u uVar) throws IOException {
        this.f46016c = uVar.x();
        this.f46014a = is.k.x(uVar.B().A()).y().x();
        this.f46015b = (i) a.c(uVar);
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey
    public byte[] e0() {
        return this.f46015b.e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCSphincs256PrivateKey)) {
            return false;
        }
        BCSphincs256PrivateKey bCSphincs256PrivateKey = (BCSphincs256PrivateKey) obj;
        return this.f46014a.C(bCSphincs256PrivateKey.f46014a) && org.bouncycastle.util.a.g(this.f46015b.e(), bCSphincs256PrivateKey.f46015b.e());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.f46015b.d() != null ? b.b(this.f46015b, this.f46016c) : new u(new zn.b(g.f35791r, new is.k(new zn.b(this.f46014a))), new f2(this.f46015b.e()), this.f46016c)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f46014a.hashCode() + (org.bouncycastle.util.a.s0(this.f46015b.e()) * 37);
    }
}
