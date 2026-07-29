package org.bouncycastle.pqc.jcajce.provider.qtesla;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.crypto.k;
import os.f;
import os.g;
import ts.c;
import ts.d;
import us.a;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BCqTESLAPublicKey implements PublicKey, a {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient f f46010a;

    public BCqTESLAPublicKey(f fVar) {
        this.f46010a = fVar;
    }

    public BCqTESLAPublicKey(c1 c1Var) throws IOException {
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
        return this.f46010a;
    }

    public final void b(c1 c1Var) throws IOException {
        this.f46010a = (f) c.b(c1Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCqTESLAPublicKey)) {
            return false;
        }
        BCqTESLAPublicKey bCqTESLAPublicKey = (BCqTESLAPublicKey) obj;
        return this.f46010a.e() == bCqTESLAPublicKey.f46010a.e() && org.bouncycastle.util.a.g(this.f46010a.d(), bCqTESLAPublicKey.f46010a.d());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return g.a(this.f46010a.e());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return d.a(this.f46010a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // us.a
    public et.g getParams() {
        return new et.g(getAlgorithm());
    }

    public int hashCode() {
        return this.f46010a.e() + (org.bouncycastle.util.a.s0(this.f46010a.d()) * 37);
    }
}
