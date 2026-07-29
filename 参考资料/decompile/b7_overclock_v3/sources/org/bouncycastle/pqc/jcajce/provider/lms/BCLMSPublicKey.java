package org.bouncycastle.pqc.jcajce.provider.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.crypto.lms.g;
import org.bouncycastle.pqc.crypto.lms.s;
import org.bouncycastle.pqc.crypto.lms.v;
import org.bouncycastle.pqc.jcajce.interfaces.LMSKey;
import org.bouncycastle.util.a;
import ts.c;
import ts.d;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BCLMSPublicKey implements PublicKey, LMSKey {
    private static final long serialVersionUID = -5617456225328969766L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient s f46004a;

    public BCLMSPublicKey(s sVar) {
        this.f46004a = sVar;
    }

    public BCLMSPublicKey(c1 c1Var) throws IOException {
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
        return this.f46004a;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSKey
    public int a0() {
        s sVar = this.f46004a;
        if (sVar instanceof v) {
            return 1;
        }
        return ((g) sVar).e();
    }

    public final void b(c1 c1Var) throws IOException {
        this.f46004a = (s) c.b(c1Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCLMSPublicKey) {
            try {
                return a.g(this.f46004a.getEncoded(), ((BCLMSPublicKey) obj).f46004a.getEncoded());
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return d.a(this.f46004a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        try {
            return a.s0(this.f46004a.getEncoded());
        } catch (IOException unused) {
            return -1;
        }
    }
}
