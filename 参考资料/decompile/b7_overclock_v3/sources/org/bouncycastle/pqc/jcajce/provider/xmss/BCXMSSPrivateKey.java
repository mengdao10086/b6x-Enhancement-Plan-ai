package org.bouncycastle.pqc.jcajce.provider.xmss;

import dt.a;
import gm.h0;
import gm.y;
import is.l;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.crypto.xmss.e0;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey;
import pn.u;
import ts.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCXMSSPrivateKey implements PrivateKey, XMSSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient e0 f46024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient y f46025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient h0 f46026c;

    public BCXMSSPrivateKey(y yVar, e0 e0Var) {
        this.f46025b = yVar;
        this.f46024a = e0Var;
    }

    public BCXMSSPrivateKey(u uVar) throws IOException {
        d(uVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        d(u.z((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey
    public long S() {
        if (V() != 0) {
            return this.f46024a.g();
        }
        throw new IllegalStateException("key exhausted");
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey
    public long V() {
        return this.f46024a.V();
    }

    @Override // us.c
    public String a() {
        return a.e(this.f46025b);
    }

    public k b() {
        return this.f46024a;
    }

    public y c() {
        return this.f46025b;
    }

    public final void d(u uVar) throws IOException {
        this.f46026c = uVar.x();
        this.f46025b = l.y(uVar.B().A()).z().x();
        this.f46024a = (e0) ts.a.c(uVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSPrivateKey)) {
            return false;
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) obj;
        return this.f46025b.C(bCXMSSPrivateKey.f46025b) && org.bouncycastle.util.a.g(this.f46024a.toByteArray(), bCXMSSPrivateKey.f46024a.toByteArray());
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey
    public XMSSPrivateKey g(int i10) {
        return new BCXMSSPrivateKey(this.f46025b, this.f46024a.e(i10));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return b.b(this.f46024a, this.f46026c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // us.c
    public int getHeight() {
        return this.f46024a.i().b();
    }

    public int hashCode() {
        return this.f46025b.hashCode() + (org.bouncycastle.util.a.s0(this.f46024a.toByteArray()) * 37);
    }
}
