package org.bouncycastle.pqc.jcajce.provider.sphincs;

import gm.y;
import is.g;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import org.bouncycastle.util.a;
import rs.j;
import ts.c;
import ts.d;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BCSphincs256PublicKey implements PublicKey, SPHINCSKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient y f46017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient j f46018b;

    public BCSphincs256PublicKey(y yVar, j jVar) {
        this.f46017a = yVar;
        this.f46018b = jVar;
    }

    public BCSphincs256PublicKey(c1 c1Var) throws IOException {
        c(c1Var);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        c(c1.A((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public k a() {
        return this.f46018b;
    }

    public y b() {
        return this.f46017a;
    }

    public final void c(c1 c1Var) throws IOException {
        this.f46017a = is.k.x(c1Var.x().A()).y().x();
        this.f46018b = (j) c.b(c1Var);
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey
    public byte[] e0() {
        return this.f46018b.e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCSphincs256PublicKey)) {
            return false;
        }
        BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey) obj;
        return this.f46017a.C(bCSphincs256PublicKey.f46017a) && a.g(this.f46018b.e(), bCSphincs256PublicKey.f46018b.e());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.f46018b.d() != null ? d.a(this.f46018b) : new c1(new b(g.f35791r, new is.k(new b(this.f46017a))), this.f46018b.e())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f46017a.hashCode() + (a.s0(this.f46018b.e()) * 37);
    }
}
