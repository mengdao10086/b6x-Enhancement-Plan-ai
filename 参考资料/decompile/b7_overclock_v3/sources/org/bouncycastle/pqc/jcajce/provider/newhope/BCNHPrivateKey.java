package org.bouncycastle.pqc.jcajce.provider.newhope;

import gm.h0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ns.g;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.jcajce.interfaces.NHPrivateKey;
import pn.u;
import ts.a;
import ts.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCNHPrivateKey implements NHPrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g f46005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient h0 f46006b;

    public BCNHPrivateKey(g gVar) {
        this.f46005a = gVar;
    }

    public BCNHPrivateKey(u uVar) throws IOException {
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

    @Override // org.bouncycastle.pqc.jcajce.interfaces.NHPrivateKey
    public short[] I0() {
        return this.f46005a.d();
    }

    public k a() {
        return this.f46005a;
    }

    public final void b(u uVar) throws IOException {
        this.f46006b = uVar.x();
        this.f46005a = (g) a.c(uVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BCNHPrivateKey) {
            return org.bouncycastle.util.a.l(this.f46005a.d(), ((BCNHPrivateKey) obj).f46005a.d());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return b.b(this.f46005a, this.f46006b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return org.bouncycastle.util.a.A0(this.f46005a.d());
    }
}
