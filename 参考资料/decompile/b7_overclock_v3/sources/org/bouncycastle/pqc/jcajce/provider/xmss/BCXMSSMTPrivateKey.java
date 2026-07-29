package org.bouncycastle.pqc.jcajce.provider.xmss;

import dt.a;
import gm.h0;
import gm.y;
import is.m;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.crypto.xmss.x;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey;
import pn.u;
import ts.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCXMSSMTPrivateKey implements PrivateKey, XMSSMTPrivateKey {
    private static final long serialVersionUID = 7682140473044521395L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient y f46019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient x f46020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient h0 f46021c;

    public BCXMSSMTPrivateKey(y yVar, x xVar) {
        this.f46019a = yVar;
        this.f46020b = xVar;
    }

    public BCXMSSMTPrivateKey(u uVar) throws IOException {
        f(uVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        f(u.z((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey
    public long S() {
        if (V() != 0) {
            return this.f46020b.g();
        }
        throw new IllegalStateException("key exhausted");
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey
    public long V() {
        return this.f46020b.V();
    }

    @Override // us.d
    public String a() {
        return a.e(this.f46019a);
    }

    @Override // us.d
    public int b() {
        return this.f46020b.i().b();
    }

    public k c() {
        return this.f46020b;
    }

    public y d() {
        return this.f46019a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSMTPrivateKey)) {
            return false;
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) obj;
        return this.f46019a.C(bCXMSSMTPrivateKey.f46019a) && org.bouncycastle.util.a.g(this.f46020b.toByteArray(), bCXMSSMTPrivateKey.f46020b.toByteArray());
    }

    public final void f(u uVar) throws IOException {
        this.f46021c = uVar.x();
        this.f46019a = m.y(uVar.B().A()).A().x();
        this.f46020b = (x) ts.a.c(uVar);
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey
    public XMSSMTPrivateKey g(int i10) {
        return new BCXMSSMTPrivateKey(this.f46019a, this.f46020b.e(i10));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return b.b(this.f46020b, this.f46021c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // us.d
    public int getHeight() {
        return this.f46020b.i().a();
    }

    public int hashCode() {
        return this.f46019a.hashCode() + (org.bouncycastle.util.a.s0(this.f46020b.toByteArray()) * 37);
    }
}
