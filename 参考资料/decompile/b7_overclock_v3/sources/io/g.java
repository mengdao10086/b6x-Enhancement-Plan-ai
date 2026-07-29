package io;

import cs.d0;
import cs.f0;
import cs.k;
import cs.q;
import gm.y;
import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.jcajce.util.i;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f0 f32601e = k.f25889a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f32602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.a f32604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f32605d;

    public class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SecretKey f32606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f32607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Cipher f32608c;

        public a(y yVar, int i10, SecureRandom secureRandom) throws CRMFException {
            KeyGenerator keyGeneratorG = g.this.f32604c.g(yVar);
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            i10 = i10 < 0 ? g.f32601e.b(yVar) : i10;
            if (i10 < 0) {
                keyGeneratorG.init(secureRandom);
            } else {
                keyGeneratorG.init(i10, secureRandom);
            }
            this.f32608c = g.this.f32604c.c(yVar);
            this.f32606a = keyGeneratorG.generateKey();
            AlgorithmParameters algorithmParametersJ = g.this.f32604c.j(yVar, this.f32606a, secureRandom);
            try {
                this.f32608c.init(1, this.f32606a, algorithmParametersJ, secureRandom);
                this.f32607b = g.this.f32604c.k(yVar, algorithmParametersJ == null ? this.f32608c.getParameters() : algorithmParametersJ);
            } catch (GeneralSecurityException e10) {
                throw new CRMFException("unable to initialize cipher: " + e10.getMessage(), e10);
            }
        }

        @Override // cs.d0
        public zn.b a() {
            return this.f32607b;
        }

        @Override // cs.d0
        public OutputStream b(OutputStream outputStream) {
            return new lq.b(outputStream, this.f32608c);
        }

        @Override // cs.d0
        public q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f32607b, this.f32606a);
        }
    }

    public g(y yVar) {
        this(yVar, -1);
    }

    public g(y yVar, int i10) {
        this.f32604c = new io.a(new org.bouncycastle.jcajce.util.c());
        this.f32602a = yVar;
        this.f32603b = i10;
    }

    public d0 c() throws CRMFException {
        return new a(this.f32602a, this.f32603b, this.f32605d);
    }

    public g d(String str) {
        this.f32604c = new io.a(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public g e(Provider provider) {
        this.f32604c = new io.a(new i(provider));
        return this;
    }

    public g f(SecureRandom secureRandom) {
        this.f32605d = secureRandom;
        return this;
    }
}
