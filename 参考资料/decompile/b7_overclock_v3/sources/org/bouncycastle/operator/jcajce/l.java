package org.bouncycastle.operator.jcajce;

import cs.i0;
import cs.q;
import gm.d2;
import gm.t;
import gm.y;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.OperatorException;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class l extends i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OperatorHelper f45651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f45652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecretKey f45653d;

    public l(SecretKey secretKey) {
        super(d(secretKey));
        this.f45651b = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45653d = secretKey;
    }

    public static zn.b c(String str, int i10) {
        y yVar;
        y yVar2;
        if (str.startsWith("DES") || str.startsWith("TripleDES")) {
            return new zn.b(s.f46835p6, d2.f29657b);
        }
        if (str.startsWith("RC2")) {
            return new zn.b(new y("1.2.840.113549.1.9.16.3.7"), new t(58L));
        }
        if (str.startsWith(m5.b.f40641c)) {
            if (i10 == 128) {
                yVar2 = kn.d.B;
            } else if (i10 == 192) {
                yVar2 = kn.d.J;
            } else {
                if (i10 != 256) {
                    throw new IllegalArgumentException("illegal keysize in AES");
                }
                yVar2 = kn.d.R;
            }
            return new zn.b(yVar2);
        }
        if (str.startsWith("SEED")) {
            return new zn.b(gn.a.f29841d);
        }
        if (!str.startsWith("Camellia")) {
            throw new IllegalArgumentException("unknown algorithm");
        }
        if (i10 == 128) {
            yVar = mn.a.f41446d;
        } else if (i10 == 192) {
            yVar = mn.a.f41447e;
        } else {
            if (i10 != 256) {
                throw new IllegalArgumentException("illegal keysize in Camellia");
            }
            yVar = mn.a.f41448f;
        }
        return new zn.b(yVar);
    }

    public static zn.b d(SecretKey secretKey) {
        return c(secretKey.getAlgorithm(), secretKey.getEncoded().length * 8);
    }

    @Override // cs.x
    public byte[] b(q qVar) throws OperatorException {
        Key keyA = m.a(qVar);
        Cipher cipherK = this.f45651b.k(a().x());
        try {
            cipherK.init(3, this.f45653d, this.f45652c);
            return cipherK.wrap(keyA);
        } catch (GeneralSecurityException e10) {
            throw new OperatorException("cannot wrap key: " + e10.getMessage(), e10);
        }
    }

    public l e(String str) {
        this.f45651b = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public l f(Provider provider) {
        this.f45651b = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }

    public l g(SecureRandom secureRandom) {
        this.f45652c = secureRandom;
        return this;
    }
}
