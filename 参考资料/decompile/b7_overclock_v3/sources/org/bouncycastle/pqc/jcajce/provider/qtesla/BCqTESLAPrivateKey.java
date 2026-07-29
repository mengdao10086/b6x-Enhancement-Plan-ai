package org.bouncycastle.pqc.jcajce.provider.qtesla;

import gm.h0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.crypto.k;
import os.e;
import os.g;
import pn.u;
import ts.b;
import us.a;

/* JADX INFO: loaded from: classes6.dex */
public class BCqTESLAPrivateKey implements PrivateKey, a {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient e f46008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient h0 f46009b;

    public BCqTESLAPrivateKey(e eVar) {
        this.f46008a = eVar;
    }

    public BCqTESLAPrivateKey(u uVar) throws IOException {
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

    public k a() {
        return this.f46008a;
    }

    public final void b(u uVar) throws IOException {
        this.f46009b = uVar.x();
        this.f46008a = (e) ts.a.c(uVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCqTESLAPrivateKey)) {
            return false;
        }
        BCqTESLAPrivateKey bCqTESLAPrivateKey = (BCqTESLAPrivateKey) obj;
        return this.f46008a.e() == bCqTESLAPrivateKey.f46008a.e() && org.bouncycastle.util.a.g(this.f46008a.d(), bCqTESLAPrivateKey.f46008a.d());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return g.a(this.f46008a.e());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return b.b(this.f46008a, this.f46009b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // us.a
    public et.g getParams() {
        return new et.g(getAlgorithm());
    }

    public int hashCode() {
        return this.f46008a.e() + (org.bouncycastle.util.a.s0(this.f46008a.d()) * 37);
    }
}
