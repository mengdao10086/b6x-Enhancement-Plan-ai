package org.bouncycastle.cms.jcajce;

import gm.d2;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final cs.f0 f44585g = cs.k.f25889a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f44586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.bouncycastle.cms.jcajce.c f44588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f44589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f44590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AlgorithmParameters f44591f;

    public static class a implements PrivilegedAction {
        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                boolean z10 = true;
                if (Cipher.class.getMethod("updateAAD", byte[].class) == null) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    public class b implements cs.b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SecretKey f44592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f44593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Cipher f44594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public cs.a0 f44595d;

        public b(gm.y yVar, int i10, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws CMSException {
            KeyGenerator keyGeneratorK = n.this.f44588c.k(yVar);
            SecureRandom secureRandomG = org.bouncycastle.crypto.n.g(secureRandom);
            if (i10 < 0) {
                keyGeneratorK.init(secureRandomG);
            } else {
                keyGeneratorK.init(i10, secureRandomG);
            }
            this.f44594c = n.this.f44588c.f(yVar);
            this.f44592a = keyGeneratorK.generateKey();
            algorithmParameters = algorithmParameters == null ? n.this.f44588c.r(yVar, this.f44592a, secureRandomG) : algorithmParameters;
            try {
                this.f44594c.init(1, this.f44592a, algorithmParameters, secureRandomG);
                this.f44593b = n.this.f44588c.s(yVar, algorithmParameters == null ? this.f44594c.getParameters() : algorithmParameters);
            } catch (GeneralSecurityException e10) {
                throw new CMSException("unable to initialize cipher: " + e10.getMessage(), e10);
            }
        }

        @Override // cs.d0
        public zn.b a() {
            return this.f44593b;
        }

        @Override // cs.d0
        public OutputStream b(OutputStream outputStream) {
            this.f44595d = new cs.a0(outputStream, mm.w.y(this.f44593b.A()).x());
            return new lq.b(this.f44595d, this.f44594c);
        }

        @Override // cs.a
        public OutputStream c() {
            if (n.d()) {
                return new l(this.f44594c);
            }
            return null;
        }

        @Override // cs.a
        public byte[] d() {
            return this.f44595d.a();
        }

        @Override // cs.d0
        public cs.q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f44593b, this.f44592a);
        }
    }

    public class c implements cs.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SecretKey f44597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f44598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Cipher f44599c;

        public c(gm.y yVar, int i10, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws CMSException {
            KeyGenerator keyGeneratorK = n.this.f44588c.k(yVar);
            SecureRandom secureRandomG = org.bouncycastle.crypto.n.g(secureRandom);
            if (i10 < 0) {
                keyGeneratorK.init(secureRandomG);
            } else {
                keyGeneratorK.init(i10, secureRandomG);
            }
            this.f44599c = n.this.f44588c.f(yVar);
            this.f44597a = keyGeneratorK.generateKey();
            algorithmParameters = algorithmParameters == null ? n.this.f44588c.r(yVar, this.f44597a, secureRandomG) : algorithmParameters;
            try {
                this.f44599c.init(1, this.f44597a, algorithmParameters, secureRandomG);
                this.f44598b = n.this.f44588c.s(yVar, algorithmParameters == null ? this.f44599c.getParameters() : algorithmParameters);
            } catch (GeneralSecurityException e10) {
                throw new CMSException("unable to initialize cipher: " + e10.getMessage(), e10);
            }
        }

        @Override // cs.d0
        public zn.b a() {
            return this.f44598b;
        }

        @Override // cs.d0
        public OutputStream b(OutputStream outputStream) {
            return new lq.b(outputStream, this.f44599c);
        }

        @Override // cs.d0
        public cs.q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f44598b, this.f44597a);
        }
    }

    public n(gm.y yVar) {
        this(yVar, f44585g.b(yVar));
    }

    public n(gm.y yVar, int i10) {
        int i11;
        this.f44588c = new org.bouncycastle.cms.jcajce.c(new org.bouncycastle.cms.jcajce.b());
        this.f44586a = yVar;
        int iB = f44585g.b(yVar);
        if (yVar.C(pn.s.Z3)) {
            i11 = os.a.f46207a;
            if (i10 != 168 && i10 != iB) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        } else {
            if (!yVar.C(on.b.f44361e)) {
                if (iB > 0 && iB != i10) {
                    throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
                }
                this.f44587b = i10;
                return;
            }
            i11 = 56;
            if (i10 != 56 && i10 != iB) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        }
        this.f44587b = i11;
    }

    public n(zn.b bVar) {
        this(bVar.x(), f44585g.b(bVar.x()));
        this.f44590e = bVar;
    }

    public static boolean d() {
        return ((Boolean) AccessController.doPrivileged(new a())).booleanValue();
    }

    public cs.d0 c() throws CMSException {
        gm.h hVarA;
        if (this.f44591f != null) {
            return this.f44588c.x(this.f44586a) ? new b(this.f44586a, this.f44587b, this.f44591f, this.f44589d) : new c(this.f44586a, this.f44587b, this.f44591f, this.f44589d);
        }
        zn.b bVar = this.f44590e;
        if (bVar != null && (hVarA = bVar.A()) != null && !hVarA.equals(d2.f29657b)) {
            try {
                AlgorithmParameters algorithmParametersC = this.f44588c.c(this.f44590e.x());
                this.f44591f = algorithmParametersC;
                algorithmParametersC.init(hVarA.b().getEncoded());
            } catch (Exception e10) {
                throw new CMSException("unable to process provided algorithmIdentifier: " + e10.toString(), e10);
            }
        }
        return this.f44588c.x(this.f44586a) ? new b(this.f44586a, this.f44587b, this.f44591f, this.f44589d) : new c(this.f44586a, this.f44587b, this.f44591f, this.f44589d);
    }

    public n e(AlgorithmParameters algorithmParameters) {
        this.f44591f = algorithmParameters;
        return this;
    }

    public n f(String str) {
        this.f44588c = new org.bouncycastle.cms.jcajce.c(new m0(str));
        return this;
    }

    public n g(Provider provider) {
        this.f44588c = new org.bouncycastle.cms.jcajce.c(new n0(provider));
        return this;
    }

    public n h(SecureRandom secureRandom) {
        this.f44589d = secureRandom;
        return this;
    }
}
