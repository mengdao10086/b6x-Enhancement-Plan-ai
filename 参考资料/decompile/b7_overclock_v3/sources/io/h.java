package io;

import go.n;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.jcajce.util.i;

/* JADX INFO: loaded from: classes5.dex */
public class h implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageDigest f32610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Mac f32611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f32612c = new a(new org.bouncycastle.jcajce.util.c());

    @Override // go.n
    public void a(zn.b bVar, zn.b bVar2) throws CRMFException {
        this.f32610a = this.f32612c.e(bVar.x());
        this.f32611b = this.f32612c.h(bVar2.x());
    }

    @Override // go.n
    public byte[] b(byte[] bArr) {
        return this.f32610a.digest(bArr);
    }

    @Override // go.n
    public byte[] c(byte[] bArr, byte[] bArr2) throws CRMFException {
        try {
            this.f32611b.init(new SecretKeySpec(bArr, this.f32611b.getAlgorithm()));
            return this.f32611b.doFinal(bArr2);
        } catch (GeneralSecurityException e10) {
            throw new CRMFException("failure in setup: " + e10.getMessage(), e10);
        }
    }

    public h d(String str) {
        this.f32612c = new a(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public h e(Provider provider) {
        this.f32612c = new a(new i(provider));
        return this;
    }
}
