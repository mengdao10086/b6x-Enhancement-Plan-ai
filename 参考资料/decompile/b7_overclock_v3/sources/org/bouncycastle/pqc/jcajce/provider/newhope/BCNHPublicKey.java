package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ns.h;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey;
import org.bouncycastle.util.a;
import ts.c;
import ts.d;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BCNHPublicKey implements NHPublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient h f46007a;

    public BCNHPublicKey(h hVar) {
        this.f46007a = hVar;
    }

    public BCNHPublicKey(c1 c1Var) throws IOException {
        b(c1Var);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        b(c1.A((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public k a() {
        return this.f46007a;
    }

    public final void b(c1 c1Var) throws IOException {
        this.f46007a = (h) c.b(c1Var);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCNHPublicKey)) {
            return false;
        }
        return a.g(this.f46007a.d(), ((BCNHPublicKey) obj).f46007a.d());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return d.a(this.f46007a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return a.s0(this.f46007a.d());
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey
    public byte[] n0() {
        return this.f46007a.d();
    }
}
