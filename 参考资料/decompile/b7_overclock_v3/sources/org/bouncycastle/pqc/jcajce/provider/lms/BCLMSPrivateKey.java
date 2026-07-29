package org.bouncycastle.pqc.jcajce.provider.lms;

import gm.h0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.crypto.k;
import org.bouncycastle.pqc.crypto.lms.f;
import org.bouncycastle.pqc.crypto.lms.s;
import org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey;
import pn.u;
import ts.a;
import ts.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCLMSPrivateKey implements PrivateKey, LMSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient s f46002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient h0 f46003b;

    public BCLMSPrivateKey(s sVar) {
        this.f46002a = sVar;
    }

    public BCLMSPrivateKey(u uVar) throws IOException {
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

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public long S() {
        if (V() == 0) {
            throw new IllegalStateException("key exhausted");
        }
        s sVar = this.f46002a;
        return sVar instanceof org.bouncycastle.pqc.crypto.lms.u ? ((org.bouncycastle.pqc.crypto.lms.u) sVar).j() : ((f) sVar).e();
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public long V() {
        s sVar = this.f46002a;
        return sVar instanceof org.bouncycastle.pqc.crypto.lms.u ? ((org.bouncycastle.pqc.crypto.lms.u) sVar).V() : ((f) sVar).V();
    }

    public k a() {
        return this.f46002a;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSKey
    public int a0() {
        s sVar = this.f46002a;
        if (sVar instanceof org.bouncycastle.pqc.crypto.lms.u) {
            return 1;
        }
        return ((f) sVar).j();
    }

    public final void b(u uVar) throws IOException {
        this.f46003b = uVar.x();
        this.f46002a = (s) a.c(uVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCLMSPrivateKey)) {
            return false;
        }
        try {
            return org.bouncycastle.util.a.g(this.f46002a.getEncoded(), ((BCLMSPrivateKey) obj).f46002a.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to perform equals");
        }
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public LMSPrivateKey g(int i10) {
        s sVar = this.f46002a;
        return sVar instanceof org.bouncycastle.pqc.crypto.lms.u ? new BCLMSPrivateKey(((org.bouncycastle.pqc.crypto.lms.u) sVar).e(i10)) : new BCLMSPrivateKey(((f) sVar).d(i10));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return b.b(this.f46002a, this.f46003b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        try {
            return org.bouncycastle.util.a.s0(this.f46002a.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to calculate hashCode");
        }
    }
}
