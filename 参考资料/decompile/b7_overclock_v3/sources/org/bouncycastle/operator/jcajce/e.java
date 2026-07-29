package org.bouncycastle.operator.jcajce;

import cs.q;
import gm.y;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.ProviderException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes6.dex */
public class e extends cs.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OperatorHelper f45621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f45622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PrivateKey f45623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f45624e;

    public e(zn.b bVar, PrivateKey privateKey) {
        super(bVar);
        this.f45621b = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45622c = new HashMap();
        this.f45623d = privateKey;
    }

    @Override // cs.w
    public q b(zn.b bVar, byte[] bArr) throws OperatorException {
        byte[] encoded;
        try {
            Cipher cipherD = this.f45621b.d(a().x(), this.f45622c);
            AlgorithmParameters algorithmParametersC = this.f45621b.c(a());
            Key secretKeySpec = null;
            try {
                if (algorithmParametersC != null) {
                    cipherD.init(4, this.f45623d, algorithmParametersC);
                } else {
                    cipherD.init(4, this.f45623d);
                }
                Key keyUnwrap = cipherD.unwrap(bArr, this.f45621b.m(bVar.x()), 3);
                if (!this.f45624e || ((encoded = keyUnwrap.getEncoded()) != null && encoded.length != 0)) {
                    secretKeySpec = keyUnwrap;
                }
            } catch (IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException | Exception unused) {
            }
            if (secretKeySpec == null) {
                cipherD.init(2, this.f45623d);
                secretKeySpec = new SecretKeySpec(cipherD.doFinal(bArr), bVar.x().L());
            }
            return new g(bVar, secretKeySpec);
        } catch (InvalidKeyException e10) {
            throw new OperatorException("key invalid: " + e10.getMessage(), e10);
        } catch (BadPaddingException e11) {
            throw new OperatorException("bad padding: " + e11.getMessage(), e11);
        } catch (IllegalBlockSizeException e12) {
            throw new OperatorException("illegal blocksize: " + e12.getMessage(), e12);
        }
    }

    public e c(y yVar, String str) {
        this.f45622c.put(yVar, str);
        return this;
    }

    public e d(boolean z10) {
        this.f45624e = z10;
        return this;
    }

    public e e(String str) {
        this.f45621b = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public e f(Provider provider) {
        this.f45621b = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }
}
