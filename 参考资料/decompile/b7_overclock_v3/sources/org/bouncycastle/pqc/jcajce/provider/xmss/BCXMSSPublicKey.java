package org.bouncycastle.pqc.jcajce.provider.xmss;

import dt.a;
import gm.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.crypto.xmss.f0;
import ts.d;
import us.c;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BCXMSSPublicKey implements PublicKey, c {
    private static final long serialVersionUID = -5617456225328969766L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient f0 f46027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient y f46028b;

    public BCXMSSPublicKey(y yVar, f0 f0Var) {
        this.f46028b = yVar;
        this.f46027a = f0Var;
    }

    public BCXMSSPublicKey(c1 c1Var) throws IOException {
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

    @Override // us.c
    public String a() {
        return a.e(this.f46028b);
    }

    public k b() {
        return this.f46027a;
    }

    public final void c(c1 c1Var) throws IOException {
        f0 f0Var = (f0) ts.c.b(c1Var);
        this.f46027a = f0Var;
        this.f46028b = a.b(f0Var.d());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCXMSSPublicKey) {
            BCXMSSPublicKey bCXMSSPublicKey = (BCXMSSPublicKey) obj;
            try {
                if (this.f46028b.C(bCXMSSPublicKey.f46028b)) {
                    if (org.bouncycastle.util.a.g(this.f46027a.getEncoded(), bCXMSSPublicKey.f46027a.getEncoded())) {
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return d.a(this.f46027a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // us.c
    public int getHeight() {
        return this.f46027a.e().b();
    }

    public int hashCode() {
        try {
            return this.f46028b.hashCode() + (org.bouncycastle.util.a.s0(this.f46027a.getEncoded()) * 37);
        } catch (IOException unused) {
            return this.f46028b.hashCode();
        }
    }
}
