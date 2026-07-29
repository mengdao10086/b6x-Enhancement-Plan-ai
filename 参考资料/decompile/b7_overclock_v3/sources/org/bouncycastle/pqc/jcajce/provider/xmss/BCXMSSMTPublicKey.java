package org.bouncycastle.pqc.jcajce.provider.xmss;

import dt.a;
import gm.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.crypto.k;
import ts.c;
import us.d;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BCXMSSMTPublicKey implements PublicKey, d {
    private static final long serialVersionUID = 3230324130542413475L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient y f46022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient org.bouncycastle.pqc.crypto.xmss.y f46023b;

    public BCXMSSMTPublicKey(y yVar, org.bouncycastle.pqc.crypto.xmss.y yVar2) {
        this.f46022a = yVar;
        this.f46023b = yVar2;
    }

    public BCXMSSMTPublicKey(c1 c1Var) throws IOException {
        d(c1Var);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        d(c1.A((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    @Override // us.d
    public String a() {
        return a.e(this.f46022a);
    }

    @Override // us.d
    public int b() {
        return this.f46023b.e().b();
    }

    public k c() {
        return this.f46023b;
    }

    public final void d(c1 c1Var) throws IOException {
        org.bouncycastle.pqc.crypto.xmss.y yVar = (org.bouncycastle.pqc.crypto.xmss.y) c.b(c1Var);
        this.f46023b = yVar;
        this.f46022a = a.b(yVar.d());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSMTPublicKey)) {
            return false;
        }
        BCXMSSMTPublicKey bCXMSSMTPublicKey = (BCXMSSMTPublicKey) obj;
        return this.f46022a.C(bCXMSSMTPublicKey.f46022a) && org.bouncycastle.util.a.g(this.f46023b.toByteArray(), bCXMSSMTPublicKey.f46023b.toByteArray());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return ts.d.a(this.f46023b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // us.d
    public int getHeight() {
        return this.f46023b.e().a();
    }

    public int hashCode() {
        return this.f46022a.hashCode() + (org.bouncycastle.util.a.s0(this.f46023b.toByteArray()) * 37);
    }
}
