package org.bouncycastle.operator.jcajce;

import cr.m;
import cs.q;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import mm.q0;
import mm.x;
import org.bouncycastle.crypto.util.e;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes6.dex */
public class i extends cs.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OperatorHelper f45637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f45638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PrivateKey f45639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f45640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f45641f;

    public i(zn.b bVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        super(bVar);
        this.f45637b = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45638c = new HashMap();
        this.f45639d = privateKey;
        this.f45640e = org.bouncycastle.util.a.p(bArr);
        this.f45641f = org.bouncycastle.util.a.p(bArr2);
    }

    @Override // cs.w
    public q b(zn.b bVar, byte[] bArr) throws OperatorException {
        x xVarY = x.y(a().A());
        Cipher cipherD = this.f45637b.d(a().x(), this.f45638c);
        String strP = this.f45637b.p(xVarY.x().x());
        q0 q0VarX = q0.x(xVarY.z().A());
        try {
            cipherD.init(4, this.f45639d, new m.b(strP, q0VarX.z().intValue() * 8, new e.b(xVarY.x(), this.f45640e, this.f45641f).a().a()).b(q0VarX.y()).a());
            return new g(bVar, cipherD.unwrap(bArr, this.f45637b.m(bVar.x()), 3));
        } catch (Exception e10) {
            throw new OperatorException("Unable to unwrap contents key: " + e10.getMessage(), e10);
        }
    }

    public i c(String str) {
        this.f45637b = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public i d(Provider provider) {
        this.f45637b = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }
}
