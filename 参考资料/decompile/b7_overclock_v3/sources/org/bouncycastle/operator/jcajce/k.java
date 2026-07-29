package org.bouncycastle.operator.jcajce;

import cs.h0;
import cs.q;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes6.dex */
public class k extends h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OperatorHelper f45649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecretKey f45650c;

    public k(zn.b bVar, SecretKey secretKey) {
        super(bVar);
        this.f45649b = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45650c = secretKey;
    }

    @Override // cs.w
    public q b(zn.b bVar, byte[] bArr) throws OperatorException {
        try {
            Cipher cipherK = this.f45649b.k(a().x());
            cipherK.init(4, this.f45650c);
            return new g(bVar, cipherK.unwrap(bArr, this.f45649b.m(bVar.x()), 3));
        } catch (InvalidKeyException e10) {
            throw new OperatorException("key invalid in message.", e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new OperatorException("can't find algorithm.", e11);
        }
    }

    public k c(String str) {
        this.f45649b = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public k d(Provider provider) {
        this.f45649b = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }
}
